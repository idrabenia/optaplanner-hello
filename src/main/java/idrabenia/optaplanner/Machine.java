package idrabenia.optaplanner;

public class Machine {
    private Integer diskSpace;

    public Machine(Integer diskSpace) {
        this.diskSpace = diskSpace;
    }

    public Machine() {
    }

    public Integer getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(Integer diskSpace) {
        this.diskSpace = diskSpace;
    }
}
