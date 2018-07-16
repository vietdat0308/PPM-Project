alter table user add constraint FK_roleid foreign key(roleid) references role(roleid)

alter table patient add constraint FK_treatmentid foreign key(treatmentid) references treatment(treatmentid)

alter table treatment add constraint FK_doctorid foreign key(doctorid) references user(userid)

alter table treatment add constraint FK_patientid foreign key(patientid) references user(userid)