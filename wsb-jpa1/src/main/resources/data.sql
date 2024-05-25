INSERT INTO address (city, address_line1, address_line2, postal_code) VALUES
('Warsaw', 'Street A', 'Apartment 1', '00-001'),
('Krakow', 'Street B', 'Apartment 2', '30-002'),
('Gdansk', 'Street C', 'Apartment 3', '80-003');

INSERT INTO doctor (first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
('John', 'Doe', '123456789', 'john.doe@example.com', 'DOC001', 'SURGEON', 1),
('Jane', 'Smith', '987654321', 'jane.smith@example.com', 'DOC002', 'GP', 2),
('Jim', 'Beam', '555666777', 'jim.beam@example.com', 'DOC003', 'OCULIST', 3);


INSERT INTO patient (first_name, last_name, telephone_number, email, patient_number, date_of_birth, age, address_id) VALUES
('Alice', 'Johnson', '111222333', 'alice.johnson@example.com', 'PAT001', '1980-01-15', 44, 1),
('Bob', 'Williams', '444555666', 'bob.williams@example.com', 'PAT002', '1990-02-20', 34, 2),
('Charlie', 'Brown', '777888999', 'charlie.brown@example.com', 'PAT003', '2000-03-25', 24, 3);

INSERT INTO visit (description, time, doctor_id, patient_id) VALUES
('Initial consultation', '2024-05-20 09:00:00', 1, 1),
('Follow-up visit', '2024-05-21 10:00:00', 2, 2),
('Routine check-up', '2024-05-22 11:00:00', 3, 3),
('Emergency visit', '2024-05-23 12:00:00', 1, 2);

INSERT INTO medical_treatment (description, type, visit_id) VALUES
('test1', 'USG', 1),
('test2', 'EKG', 2),
('test3', 'USG', 3),
('test4', 'RTG', 4);
