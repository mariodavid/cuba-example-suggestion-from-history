package com.rtcab.cesfh.web.screens.person;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cesfh.entity.Person;

@UiController("cesfh_Person.browse")
@UiDescriptor("person-browse.xml")
@LookupComponent("personsTable")
@LoadDataBeforeShow
public class PersonBrowse extends StandardLookup<Person> {
}