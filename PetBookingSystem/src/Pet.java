public class Pet {
    private final String name;
    private final String species;
    private final String breed;
    private final String colour;
    private boolean vaccineStatus;
    private Client owner;
    private CareProfile care;
    private EmergVet vet;
    public Pet(String name, String species, String breed, String colour, Client owner){
        this.name=name;
        this.species=species;
        this.breed=breed;
        this.colour=colour;
        this.owner=owner;
    }
    public void setCare(String[] meds,String medInstr,String feedingInstr){
        CareProfile care = new CareProfile(meds,medInstr,feedingInstr);

    }
    public void sefVet(EmergVet vet){
        this.vet=vet;
    }
    public EmergVet getVet(){
        return this.vet;
    }



}
