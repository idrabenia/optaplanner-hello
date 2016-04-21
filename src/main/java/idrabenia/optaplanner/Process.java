package idrabenia.optaplanner;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Process {
    private int requiredDiskSpace;

    private Machine machine;

    public Process(int requiredDiskSpace) {
        this.requiredDiskSpace = requiredDiskSpace;
    }

    public Process() {
    }

    @PlanningVariable(valueRangeProviderRefs = "machines")
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public int getRequiredDiskSpace() {
        return requiredDiskSpace;
    }

    public void setRequiredDiskSpace(int requiredDiskSpace) {
        this.requiredDiskSpace = requiredDiskSpace;
    }
}
