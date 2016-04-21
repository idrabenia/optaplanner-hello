package idrabenia.optaplanner;

import org.optaplanner.core.api.score.Score;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;


public class ScoreCalculator implements EasyScoreCalculator<Balance> {

    @Override
    public Score calculateScore(Balance balance) {
        Integer hardScore = 0;
        Integer softScore = 0;

        for (Machine curMachine : balance.getMachines()) {
            Integer usedMachineSpace = 0;
            Boolean used = false;

            for (Process curProcess : balance.getProcesses()) {
                if (curProcess.getMachine() != null && curProcess.getMachine().equals(curMachine)) {
                    usedMachineSpace += curProcess.getRequiredDiskSpace();
                    used = true;
                }
            }

            if (curMachine.getDiskSpace() - usedMachineSpace < 0) {
                hardScore += curMachine.getDiskSpace() - usedMachineSpace;
            }

            if (used) {
                softScore -= curMachine.getDiskSpace();
            }
        }

        return HardSoftScore.valueOf(hardScore, softScore);
    }

}
