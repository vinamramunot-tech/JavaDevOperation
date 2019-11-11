import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class mainPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameSearch, idSearch, ssnSearch;
	private JButton searchButton, logoutButton;

	private JPanel profilePanel, profileInputPanel, bottomPanel, profileSection;
	private JLabel userLabel, SSNLabel, genderLabel, DOBLabel, patientIDLabel, firstNameLabel, midNameLabel,
	lastNameLabel, primaryDoctorLabel;
	private JLabel streetLabel, cityStateLabel, phoneNumberLabel, aptLabel;

	private db_control dbc = new db_control();
	private JLabel lblPhone;
	private JButton homeButton;
	private JPanel searchPanel;
	private JPanel centerPanel;
	private JButton addNewButton;

	newPatientForm npf = new newPatientForm();
	lastPatientHistory lph = new lastPatientHistory();
	patientAssignmentForm paf = new patientAssignmentForm();

	MVCcontroller mvc = new MVCcontroller(this, npf, paf);

	DefaultListModel<String> model;
	private JPanel optionProfilePanel;
	private JLabel updateStatusLabel;
	private JButton checkinButton;
	private JButton editPatientProfile;
	private JButton patientHistoryButton;
	private JButton viewBillButton;

	public mainPanel() {
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 5));
		searchPanel = new JPanel();
		add(searchPanel, BorderLayout.NORTH);
		searchPanel.setLayout(new GridLayout(0, 1, 0, 3));

		JPanel inputPanel = new JPanel();
		searchPanel.add(inputPanel);
		inputPanel.setLayout(new GridLayout(2, 7, 5, 5));

		JPanel blank0 = new JPanel();
		inputPanel.add(blank0);

		JLabel lblname = new JLabel("Enter Name");
		lblname.setHorizontalAlignment(SwingConstants.CENTER);
		lblname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		inputPanel.add(lblname);

		JLabel lblssn = new JLabel("Enter 4 digit SSN:");
		lblssn.setHorizontalAlignment(SwingConstants.CENTER);
		lblssn.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		inputPanel.add(lblssn);

		JLabel lblid = new JLabel("Enter ID");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		inputPanel.add(lblid);

		JPanel blank1 = new JPanel();
		inputPanel.add(blank1);

		JPanel blank2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) blank2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		inputPanel.add(blank2);

		userLabel = new JLabel("Login as: " + userProfile.getUser());
		userLabel.setForeground(Color.BLUE);
		userLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		blank2.add(userLabel);

		JPanel blank3 = new JPanel();
		inputPanel.add(blank3);

		nameSearch = new JTextField();
		nameSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ssnSearch.setBackground(Color.white);
				idSearch.setBackground(Color.white);
				nameSearch.setBackground(Color.white);
			}
		});
		nameSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						searchPatient();
					} catch (InterruptedException e1) {
						
						return;
					}
				}
			}
		});
		nameSearch.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		nameSearch.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(nameSearch);
		nameSearch.setColumns(10);

		idSearch = new JTextField();
		idSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ssnSearch.setBackground(Color.white);
				idSearch.setBackground(Color.white);
				nameSearch.setBackground(Color.white);
			}
		});
		idSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						searchPatient();
					} catch (InterruptedException e1) {
						//
						return;
					}
				}
			}
		});

		ssnSearch = new JTextField();
		ssnSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				ssnSearch.setBackground(Color.white);
				idSearch.setBackground(Color.white);
				nameSearch.setBackground(Color.white);
			}
		});
		ssnSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						searchPatient();
					} catch (InterruptedException e1) {
					
						return;
					}
				}
			}
		});
		ssnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		ssnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(ssnSearch);
		ssnSearch.setColumns(10);
		inputPanel.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { nameSearch, idSearch, ssnSearch, searchButton, logoutButton }));
		idSearch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		idSearch.setHorizontalAlignment(SwingConstants.LEFT);
		inputPanel.add(idSearch);
		idSearch.setColumns(10);

		searchButton = new JButton("Search");
		searchButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchPatient();
				} catch (InterruptedException e1) {
			
					return;
				}
			}
		});
		searchButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						searchPatient();
					} catch (InterruptedException e1) {
						return;
					}
				}
			}
		});
		searchButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		inputPanel.add(searchButton);

		JPanel blank4 = new JPanel();
		inputPanel.add(blank4);

		model = new DefaultListModel<String>();

		bottomPanel = new JPanel();
		FlowLayout fl_bottomPanel = (FlowLayout) bottomPanel.getLayout();
		fl_bottomPanel.setHgap(50);
		fl_bottomPanel.setAlignment(FlowLayout.RIGHT);
		add(bottomPanel, BorderLayout.SOUTH);

		logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		logoutButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.exit(0);
				}
			}
		});
		
		homeButton = new JButton("Home");
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToHome();
			}
		});
		homeButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					backToHome();
				}
			}
		});
				
		updateStatusLabel = new JLabel("-");
		updateStatusLabel.setForeground(Color.GREEN);
		updateStatusLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		bottomPanel.add(updateStatusLabel);
		homeButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bottomPanel.add(homeButton);
		logoutButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bottomPanel.add(logoutButton);

		centerPanel = new JPanel();
		centerPanel.setBackground(Color.LIGHT_GRAY);
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new BorderLayout(5, 5));

		profilePanel = new JPanel();
		profilePanel.setBackground(Color.LIGHT_GRAY);
		centerPanel.add(profilePanel, BorderLayout.NORTH);
		profilePanel.setLayout(new GridLayout(0, 2, 5, 5));

		profileSection = new JPanel();
		profileSection.setBackground(Color.WHITE);
		profileSection.setPreferredSize(new Dimension(400, 225));
		profileSection.setMinimumSize(new Dimension(400, 225));
		profileSection.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		profilePanel.add(profileSection);
		profileSection.setLayout(null);

		JLabel lblNewLabel = new JLabel("Patient ID: ");
		lblNewLabel.setBounds(11, 0, 89, 38);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(lblNewLabel);

		patientIDLabel = new JLabel("-");
		patientIDLabel.setBounds(101, 0, 127, 38);
		patientIDLabel.setHorizontalAlignment(SwingConstants.LEFT);
		patientIDLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(patientIDLabel);

		JLabel lblDOB = new JLabel("DOB: ");
		lblDOB.setBounds(11, 62, 64, 38);
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(lblDOB);

		DOBLabel = new JLabel("-");
		DOBLabel.setBounds(79, 62, 105, 38);
		DOBLabel.setHorizontalAlignment(SwingConstants.LEFT);
		DOBLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(DOBLabel);

		JLabel lblGender = new JLabel("Gender: ");
		lblGender.setBounds(186, 62, 59, 38);
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(lblGender);

		genderLabel = new JLabel("-");
		genderLabel.setBounds(245, 62, 64, 38);
		genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		genderLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(genderLabel);

		JLabel lblSSN = new JLabel("SSN: ");
		lblSSN.setBounds(342, 99, 42, 38);
		lblSSN.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(lblSSN);

		SSNLabel = new JLabel("    -   -       ");
		SSNLabel.setBounds(388, 99, 127, 38);
		SSNLabel.setHorizontalAlignment(SwingConstants.LEFT);
		SSNLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(SSNLabel);

		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(11, 143, 76, 38);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(lblAddress);

		streetLabel = new JLabel("---  ----- ------");
		streetLabel.setBounds(89, 143, 201, 38);
		streetLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(streetLabel);

		Label lblPrimaryDoctor = new Label("Primary Doctor:");
		lblPrimaryDoctor.setBounds(341, 143, 139, 38);
		lblPrimaryDoctor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		profileSection.add(lblPrimaryDoctor);

		primaryDoctorLabel = new JLabel("------------");
		primaryDoctorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		primaryDoctorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		primaryDoctorLabel.setBounds(335, 173, 145, 38);
		primaryDoctorLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(primaryDoctorLabel);

		cityStateLabel = new JLabel("---- ----- ---- -----");
		cityStateLabel.setBounds(89, 173, 234, 38);
		cityStateLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		profileSection.add(cityStateLabel);

		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(11, 24, 59, 38);
		profileSection.add(lblName);

		firstNameLabel = new JLabel("-");
		firstNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		firstNameLabel.setBounds(79, 24, 89, 38);
		profileSection.add(firstNameLabel);

		midNameLabel = new JLabel("-");
		midNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		midNameLabel.setBounds(176, 25, 89, 38);
		profileSection.add(midNameLabel);

		lastNameLabel = new JLabel("-");
		lastNameLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lastNameLabel.setBounds(273, 25, 117, 38);
		profileSection.add(lastNameLabel);

		aptLabel = new JLabel("Apt# ");
		aptLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		aptLabel.setBounds(11, 173, 76, 38);
		profileSection.add(aptLabel);

		lblPhone = new JLabel("Phone#");
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPhone.setBounds(11, 99, 64, 38);
		profileSection.add(lblPhone);

		phoneNumberLabel = new JLabel("(   )-   -    ");
		phoneNumberLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneNumberLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		phoneNumberLabel.setBounds(79, 99, 127, 38);
		profileSection.add(phoneNumberLabel);

		optionProfilePanel = new JPanel();
		profilePanel.add(optionProfilePanel);
		optionProfilePanel.setLayout(null);
		
		patientHistoryButton = new JButton("View History");
		patientHistoryButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		patientHistoryButton.setBounds(10, 67, 155, 37);
		optionProfilePanel.add(patientHistoryButton);
		
		editPatientProfile = new JButton("Edit Profile");
		editPatientProfile.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		editPatientProfile.setBounds(10, 15, 155, 37);
		optionProfilePanel.add(editPatientProfile);
		
		viewBillButton = new JButton("View Bill");
		viewBillButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		viewBillButton.setBounds(10, 119, 155, 37);
		optionProfilePanel.add(viewBillButton);
		
		checkinButton = new JButton("Check-in");
		checkinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadPatientAssignmentForm();
			}
		});
		checkinButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		checkinButton.setBounds(10, 171, 155, 37);
		optionProfilePanel.add(checkinButton);

		profileInputPanel = new JPanel();
		profileInputPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		centerPanel.add(profileInputPanel, BorderLayout.CENTER);

		addNewButton = new JButton("Add New Patient");
		addNewButton.setBackground(Color.WHITE);
		addNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressAddNewPatient();
			}
		});
		profileInputPanel.setLayout(new BorderLayout(0, 0));
		addNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		profileInputPanel.add(addNewButton);

	}// end panel

	JTextField getNameSearchField() {
		return nameSearch;
	}
	
	
	void addSaveButtonListener(ActionListener savePress) {
		npf.getSaveButton().addActionListener(savePress);
	}// end add action listener

	void addRecordButtonListener(ActionListener recordButtonPress) {
		paf.getAddRecordButton().addActionListener(recordButtonPress);
	}// end add action listener
	


	void pressAddNewPatient() {
		profileInputPanel.removeAll();
		profileInputPanel.add(npf);
		npf.setVisible(true);
		profileInputPanel.repaint();
		profileInputPanel.validate();

	}

	void searchPatient() throws InterruptedException {
		if (idSearch.getText().isEmpty()) {
			if (ssnSearch.getText().isEmpty() && nameSearch.getText().isEmpty()) {
				nameSearch.setBackground(Color.YELLOW);
				idSearch.setBackground(Color.YELLOW);
				ssnSearch.setBackground(Color.YELLOW);
				return;
			} else if ((!ssnSearch.getText().isEmpty() && nameSearch.getText().isEmpty())
					|| (ssnSearch.getText().isEmpty() && !nameSearch.getText().isEmpty())) {
				nameSearch.setBackground(Color.YELLOW);
				ssnSearch.setBackground(Color.YELLOW);
				return;
			}

		}
		// else do following
		dbc.getProfile(idSearch.getText(), nameSearch.getText(), ssnSearch.getText());

		if (patientProfile.found) {
			nameSearch.setText("");
			idSearch.setText("");
			ssnSearch.setText("");

			loadPatient();
		} else {

			patientIDLabel.setForeground(Color.RED);
			patientIDLabel.setText("Search Not Found!");
			firstNameLabel.setText("");
			midNameLabel.setText("");
			lastNameLabel.setText("");
			DOBLabel.setText("");
			genderLabel.setText("");
			primaryDoctorLabel.setText("");
		}

	}// end search

	void loadPatient() {

		// patient info
		patientIDLabel.setForeground(Color.BLACK);
		patientIDLabel.setText(patientProfile.patientID);
		firstNameLabel.setText(patientProfile.firstName);
		midNameLabel.setText(patientProfile.midName);
		lastNameLabel.setText(patientProfile.lastName);
		DOBLabel.setText(patientProfile.dateOfBirth);
		genderLabel.setText(patientProfile.gender);
		primaryDoctorLabel.setText(patientProfile.PrimaryDoctor);
		phoneNumberLabel.setText(patientProfile.phoneNumber);
		SSNLabel.setText("XXX-XX-" + patientProfile.ssnSerial);

		// address
		String address = patientProfile.streetNum + " " + patientProfile.streetName;
		String cityStateZip = patientProfile.cityName + ", " + patientProfile.stateName + " " + patientProfile.zipcode;
		streetLabel.setText(address);
		aptLabel.setText("Apt#" + patientProfile.aptNum);
		cityStateLabel.setText(cityStateZip);

		if (patientProfile.active == 0) {
			loadLastPatientHistory();

		} else {
			loadPatientAssignmentForm();
		}

	}

	void loadLastPatientHistory() {
		profileInputPanel.removeAll();
		profileInputPanel.add(lph);
		lph.setVisible(true);
		profileInputPanel.repaint();
		profileInputPanel.validate();
	}

	void loadPatientAssignmentForm() {
		profileInputPanel.removeAll();
		profileInputPanel.add(paf);
		paf.setVisible(true);
		profileInputPanel.repaint();
		profileInputPanel.validate();
	}

	void backToHome() {
		if (npf.isFormClear() == false) {
			if (JOptionPane.showConfirmDialog(null, "Form hasn't save, are you sure you want to leave?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				nameSearch.setText("");
				idSearch.setText("");
				ssnSearch.setText("");

				patientIDLabel.setText("_");
				firstNameLabel.setText("_");
				midNameLabel.setText("_");
				lastNameLabel.setText("_");
				SSNLabel.setText("   -  -    ");
				phoneNumberLabel.setText("(   ) -    ");
				streetLabel.setText("_____" + " _____ __");
				aptLabel.setText("");
				cityStateLabel.setText("________" + ", __" + " _____");
				primaryDoctorLabel.setText("________");
				DOBLabel.setText("_");
				genderLabel.setText("_");

				profileInputPanel.removeAll();
				profileInputPanel.add(addNewButton);
				profileInputPanel.repaint();
				profileInputPanel.validate();

				npf.clearForm();
			}
			return;
		}
		nameSearch.setText("");
		idSearch.setText("");
		ssnSearch.setText("");

		patientIDLabel.setText("_");
		firstNameLabel.setText("_");
		midNameLabel.setText("_");
		lastNameLabel.setText("_");
		SSNLabel.setText("   -  -    ");
		phoneNumberLabel.setText("(   ) -    ");
		streetLabel.setText("_____" + " _____ __");
		aptLabel.setText("");
		cityStateLabel.setText("________" + ", __" + " _____");
		primaryDoctorLabel.setText("________");
		DOBLabel.setText("_");
		genderLabel.setText("_");

		profileInputPanel.removeAll();
		profileInputPanel.add(addNewButton);
		profileInputPanel.repaint();
		profileInputPanel.validate();

	}
}
