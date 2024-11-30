public class Administrador extends Pessoa {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Administrador [email=" + email + ", Nome=" + getNome() + ", Id=" + getId() + "]";
    }

}
