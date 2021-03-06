import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVCcontroller {

	private MainPanel mPanel;
	private NewPatientForm npForm; 
	private PatientAssignmentForm patientAssignmentForm;
	private EditPatientForm editPatient;
	private EditEmployeeForm editEmployee;
	private PaymentProcessingForm paymentProcessingForm;

	MVCcontroller(MainPanel mp, NewPatientForm npf, PatientAssignmentForm paf, EditPatientForm epf,
			EditEmployeeForm eef, PaymentProcessingForm ppf) {

		editEmployee = eef;
		editPatient = epf;
		patientAssignmentForm = paf;
		paymentProcessingForm = ppf;
		mPanel  = mp;
		npForm = npf;
		mPanel.addSaveButtonListener(new addSaveButtonListener());
		mPanel.addRecordButtonListener(new addRecordButtonListener());
		mPanel.addUpdatePatientButtonListener(new addUpdatePatientButtonListener());
		mPanel.addUpdateEmployeeButtonListener(new addUpdateEmployeeButtonListener());
		mPanel.addProcessPaymentButtonListener(new addProcessPaymentButtonListener());

	}

	class addSaveButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (npForm.generatePatientID())
				mPanel.loadPatient(); //
		}		
	}

	class addRecordButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (patientAssignmentForm.addToRecord()) {
				mPanel.loadLastPatientHistory();
				mPanel.errorMessage("New record saved!");
			}
			else
				mPanel.errorMessage("Unable to add to record!");
		}		
	}

	class addUpdatePatientButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			editPatient.updatePatientInfo();
			mPanel.loadPatient();
			mPanel.updatePatientInfoIsPressed();
		}
	}

	class addUpdateEmployeeButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			editEmployee.updateEmployeeInfo();
			mPanel.loadEmployee();
			mPanel.updateEmployeeInfoIsPressed();
		}
	}

	class addProcessPaymentButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			editEmployee.updateEmployeeInfo();
//			mPanel.loadEmployee();
//			mPanel.updateEmployeeInfoIsPressed();
		}
	}
}
