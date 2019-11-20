package com.rtcab.cesfh.web.screens.person;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cesfh.entity.Person;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@UiController("cesfh_Person.edit")
@UiDescriptor("person-edit.xml")
@EditedEntityContainer("personDc")
@LoadDataBeforeShow
public class PersonEdit extends StandardEditor<Person> {


    @Inject
    protected LookupField<String> roleField;

    @Inject
    protected DataManager dataManager;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        roleField.setOptionsList(allPreviousEnteredRoles());
        roleField.setNewOptionHandler(newEnteredRole -> getEditedEntity().setRole(newEnteredRole));
    }

    private List<String> allPreviousEnteredRoles() {
        List<Person> personList = dataManager.load(Person.class)
                .list();

        return personList.stream()
                .map(Person::getRole)
                .distinct()
                .collect(Collectors.toList());
    }


}