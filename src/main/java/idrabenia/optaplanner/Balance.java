package idrabenia.optaplanner;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;

@PlanningSolution
public class Balance implements Solution <HardSoftScore> {
    private List<Machine> machines = new ArrayList<Machine>();
    private List<Process> processes = new ArrayList<Process>();
    private HardSoftScore score;

    @ValueRangeProvider(id = "machines")
    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @PlanningEntityCollectionProperty
    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }

    public Balance processes(Process... processes) {
        this.processes = new ArrayList<Process>(asList(processes));
        return this;
    }

    public Balance machines(Machine... machines) {
        this.machines = new ArrayList<Machine>(asList(machines));
        return this;
    }

    @Override
    public HardSoftScore getScore() {
        return score;
    }

    @Override
    public void setScore(HardSoftScore hardSoftScore) {
        this.score = hardSoftScore;
    }

    @Override
    public Collection<?> getProblemFacts() {
        return asList(processes);
    }
}
