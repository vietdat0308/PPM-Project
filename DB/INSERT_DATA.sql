INSERT INTO role (name) values('doctor'),
('nurse'),('admin')	

INSERT INTO medicine (name, description) values
					('thuoc1', 'chuabenh1'),
					('thuoc2', 'chuabenh2'),('thuoc3', 'chuabenh3') 

INSERT INTO patient  (fullname, address, sex,dateofbirth,placeofbirth,treatmentid,allergic) values
					('Phuc123', 'lequangdinh', 'Nam', '1993/2/1', 'TPHCM',null,''),
					('Phuc1', 'lequangdinh1', 'Nu', '1995/12/16', 'TPHCM',null,''),
					('Phuc2', 'lequangdinh2', 'Nam', '1990/3/19', 'TPHCM',null,''), 
                    ('Phuc3', 'lequangdinh3', 'Nu', '1995/5/19', 'TPHCM',null,''),
					('Phuc4', 'lequangdinh4', 'Nam', '1997/6/16', 'TPHCM',null,''),
                    ('Phuc5', 'lequangdinh5', 'Nu', '1998/2/20', 'TPHCM',null,''),
					('Phuc6', 'lequangdinh6', 'Nam', '1993/2/13', 'TPHCM',null,''),
                    ('Phuc7', 'lequangdinh7', 'Nam', '1992/2/12', 'TPHCM',null,'')
                    
INSERT INTO treatment (historyofdiseases, prescription,medicineused,medicaltestresult,patientid,doctorid,medicineid) values
					('Benhdaumua', 'qua lau', 'Thuoc tay', 'Sap die',3,1,1)  

INSERT INTO user  (fullname, address, sex,dateofbirth,placeofbirth,roleid,username,password) values
					('Phuc123', 'lequangdinh', 'Nam', '1993/2/1', 'TPHCM',1,'doctor1','doctor1')