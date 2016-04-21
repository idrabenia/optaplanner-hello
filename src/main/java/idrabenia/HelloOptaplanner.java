package idrabenia;

import idrabenia.optaplanner.*;
import idrabenia.optaplanner.Process;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class HelloOptaplanner {

    public static void main(String[] args) {
        // Build the Solver
        SolverFactory<Balance> solverFactory = SolverFactory.createFromXmlResource(
                "idrabenia/optaplanner/helloSolverConfig.xml");
        Solver<Balance> solver = solverFactory.buildSolver();

        // Load a problem with 400 computers and 1200 processes
        Balance unsolvedCloudBalance =
            new Balance()
                .processes(new Process(10), new Process(20), new Process(15), new Process(23))
                .machines(new Machine(35), new Machine(15), new Machine(25), new Machine(45));

        // Solve the problem
        Balance solvedCloudBalance = solver.solve(unsolvedCloudBalance);

        // Display the result
        System.out.println("\nSolved cloudBalance with 400 computers and 1200 processes:\n"
                + toDisplayString(solvedCloudBalance));
    }


    public static String toDisplayString(Balance cloudBalance) {
        StringBuilder displayString = new StringBuilder();
        for (Process process : cloudBalance.getProcesses()) {
            Machine computer = process.getMachine();
            displayString.append("  ").append(process.getRequiredDiskSpace()).append(" -> ")
                    .append(computer == null ? null : computer.getDiskSpace()).append("\n");
        }
        return displayString.toString();
    }

}
