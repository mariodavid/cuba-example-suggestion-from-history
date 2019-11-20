## CUBA example - Suggestion from History

This is a CUBA example that shows how to "reuse" already entered values.

Example:

* Entity: Person
  * Attribute: Role (String)
  
  
The Role Lookup Field in the UI displays all distinct values that have been previously entered by former Persons.

![Using Role suggestion Field](/img/suggestion-from-history.gif)

### How it works

```java
public class PersonEdit extends StandardEditor<Person> {


    @Inject
    protected LookupField<String> roleField;

    @Inject
    protected DataManager dataManager;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        roleField.setOptionsList( // <1>
                allPreviousEnteredRoles()
        );
        
        roleField.setNewOptionHandler(
                newEnteredRole -> getEditedEntity().setRole(newEnteredRole) // <2>
        ); 
    }

    private List<String> allPreviousEnteredRoles() { // <3>
        List<Person> personList = dataManager.load(Person.class)
                .list();

        return personList.stream()
                .map(Person::getRole)
                .distinct()
                .collect(Collectors.toList());
    }


}
```

1. the option list will be set manually
2. new option handler enables the ability to enter values that are not in the options list
3. all Persons are loaded, the role attribute is fetched into a distinct list of Values

