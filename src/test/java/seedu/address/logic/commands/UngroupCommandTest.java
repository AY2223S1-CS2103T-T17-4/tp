package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for UngroupPatientCommand.
 */
public class UngroupCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_originalPatientList_showsSameList() {
        assertCommandSuccess(
                new UngroupCommand("patients"), model, UngroupCommand.MESSAGE_SUCCESS_PATIENTS, expectedModel);
    }

    @Test
    public void execute_unsortedPatientListAfterSorted_showsSameList() {
        expectedModel.updatePersonComparator(Model.COMPARATOR_UNGROUP_PATIENTS);
        assertCommandSuccess(
                new UngroupCommand("patients"), model, UngroupCommand.MESSAGE_SUCCESS_PATIENTS, expectedModel);
    }
}
