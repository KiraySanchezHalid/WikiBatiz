import java.util.Scanner;

public class WikiBatiz {

    static boolean activo = true;
    static boolean reinicio = false;

    public static void main(String[] args) {
        do {
            ImprimirNombre();
            SeleccionTipoUsuario();
            Separacion();
            if (reinicio) {
                System.out.println("Regresando al menu inicial...");
                reinicio = false;
            } else {
                System.out.println("Deseas volver al menu inicial?");
                System.out.println("1.Si 2.No");
                String[] a = {"1. Si", "2. No"};
                Separacion();
                int RepetirConsulta = NumRango(a, 1, 2);
                if (RepetirConsulta == 2) {
                    activo = false;
                    System.out.println("Gracias por usar WikiBatiz");
                    Separacion();
                }
            }
        } while (activo);
    }

    public static void SeleccionTipoUsuario() {
        String[] usuarios = {"1. Administrador", "2. Usuario"};
        MostrarOpciones("Escoge tu tipo de usuario", usuarios);
        int usuarioSeleccionado = NumRango(usuarios, 1, usuarios.length);
        Separacion();
        System.out.println("Has seleccionado " + usuarios[usuarioSeleccionado - 1]);
        Separacion();
        switch (usuarioSeleccionado) {
            case 1:
                PanelAdministrador();
                break;
            case 2:
                usuarioActivo = true;
                ProcesoUsuario();
                break;
            default:
                System.out.println("Ha ocurrido un error, volviendo al menu inicial");
                reinicio = true;
                break;
        }
    }
    static boolean VienedeUnMenu = false;
    static boolean usuarioActivo = false;
    static String[] opcionesMenuUsuario = {
        "1. Actividades Deportivas y Cuturales",
        "2. Tramites",
        "3. Alumnos",
        "4. Eventos",
        "5. Tutorias"};

    public static void ProcesoUsuario() {
        do {
            MostrarOpciones("Selecciona tu consulta", opcionesMenuUsuario);
            int GotoMenu = NumRango(opcionesMenuUsuario, 1, opcionesMenuUsuario.length);
            switch (GotoMenu) {
                case 1:
                    MenuActividadesDeportivasCulturales();
                    break;
                case 2:
                    MenuTramites();
                    break;
                case 3:
                    MenuAlumnos();
                    break;
                case 4:
                    MenuEventos();
                    break;
                case 5:
                    MenuTutorias();
                    break;
                default:
                    System.out.println("Ha ocurrido un error inesperado");
                    VienedeUnMenu = true;
                    break;
            }
            Separacion();
            if (VienedeUnMenu) {
                System.out.println("Regresando al menu de consulta...");
                VienedeUnMenu = false;
            } else {
                System.out.println("Deseas realizar otra consulta?");
                System.out.println("1.Si 2.No");
                String[] a = {"1. Si", "2. No"};
                Separacion();
                int RepetirConsulta = NumRango(a, 1, 2);
                if (RepetirConsulta == 2) {
                    usuarioActivo = false;
                }
            }
        } while (usuarioActivo);
    }

    public static int menu(String[] opciones) {
        MostrarOpciones("Selecciona una opcion", opciones);
        int eleccion = NumRango(opciones, 1, opciones.length);
        if (eleccion >= opciones.length) {
            VienedeUnMenu = true;
        } else {
            return eleccion;
        }
        return 0;
    }

    static String[] opcionesDeportivas = {
        "1. Consultar horarios",
        "2. Inscripciones",
        "3. Profesores titulares",
        "4. Regresar al menu inicial"};
    static String[] mensajeDeportivas = {
         //horarios
            " \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557 \n" +
                    " \u2551   Horarios      de    Actividades     Deportivas      y      Culturales     \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Actividades \u2551 Lunes     \u2551 Martes     \u2551 Mi\u00E9rcoles  \u2551 Jueves     \u2551 Viernes    \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Atletismo   \u255110:00-13:00\u255109:00-13:00 \u25519:00-13:00  \u25519:00-13:00  \u25519:00-13:00  \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Basquetbol  \u255112:00-16:00\u255112:00-16:00 \u255112:00-16:00 \u255112:00-16:00 \u255112:00-16:00 \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Volibol     \u255112:00-16:00\u255112:00-16:00 \u255112:00-16:00 \u255112:00-16:00 \u255112:00-15:00 \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Futbol      \u255112:00-15:00\u255112:00-15:00 \u255112:00-15:00 \u255112:00-15:00 \u255112:00-15:00 \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Tae Kwon Do \u2551           \u255111:00-13:00 \u2551            \u255111:00-13:00 \u2551            \u2551 \n" +
                    " \u2551             \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551             \u2551           \u255115:00-17:00 \u2551            \u255115:00-17:00 \u2551            \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Futbol      \u255110:00-12:00\u255110:00-12:00 \u255110:00-12:00 \u255110:00-12:00 \u255110:00-12:00 \u2551 \n" +
                    " \u2551 Americano   \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551             \u255115:00-17:00\u255115:00-17:00 \u255115:00-17:00 \u255115:00-17:00 \u255115:00-17:00 \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Tocho       \u255111:00-13:00\u255111:00-13:00 \u255111:00-13:00 \u255111:00-13:00 \u255110:00-13:00 \u2551 \n" +
                    " \u2551 Bandera     \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551             \u255115:00-17:00\u255115:00-17:00 \u2551 15:00-17:00\u255115:00-17:00 \u255115:00-17:00 \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Artes       \u255112:00-17:00\u255112:00-17:00 \u255112:00-17:00 \u255112:00-17:00 \u255112:00-16:00 \u2551 \n" +
                    " \u2551 Visuales    \u2551 1er piso  \u2551 1er piso   \u2551 1er piso   \u2551 1er piso   \u2551 1er piso   \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Musica      \u255109:00-17:00\u255113:00-16:00 \u255114:00-17:00 \u255111:00-16:00 \u2551            \u2551 \n" +
                    " \u2551 Foklorica   \u2551 Auditorio \u2551 Auditorio  \u2551 Auditorio  \u2551 Auditorio  \u2551            \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Danza       \u2551           \u255112:00-15:00 \u2551            \u2551            \u255112:00-15:00 \u2551 \n" +
                    " \u2551 Folklorica  \u2551           \u2551 Auditorio  \u2551            \u2551            \u2551 Auditorio  \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Piano       \u2551           \u2551            \u2551 12:00-18:00\u2551            \u2551            \u2551 \n" +
                    " \u2551             \u2551           \u2551            \u2551Camerino del\u2551            \u2551            \u2551 \n" +
                    " \u2551             \u2551           \u2551            \u2551 auditorio  \u2551            \u2551            \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Creacion    \u2551           \u2551            \u2551 19:00-21:00\u2551            \u2551            \u2551 \n" +
                    " \u2551 Literaria   \u2551           \u2551            \u2551 Virtual    \u2551            \u2551            \u2551 \n" +
                    " \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256C\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563 \n" +
                    " \u2551 Teatro      \u2551           \u2551            \u2551            \u2551 11:00-17:00\u2551            \u2551 \n" +
                    " \u2551             \u2551           \u2551            \u2551            \u2551 Auditorio  \u2551            \u2551 \n" +
                    " \u255A\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D \n"
            ,
         //inscripciones a actividades
        "Realiza tus inscripciones en https://forms.gle./xbSYFKxs5oMV5eCG9",
         //Profesores titulares
        "[Actividades Deportivas] \n" +
            " Atletismo: Profa. Alma Yadira Quintanar Camacho \n " +
            " Basquetbol : Prof.Miguel Angel Ramirez Calnacasco & prof. Carlos del Valle Garcia \n" +
            " Volibol: Prof. Miguel Angel Ramirez Calnasco \n" +
            " Futbol: Prof.Alfonso Morales Martinez \n" +
            " Tae Kwon Do: Arturo Wong \n " +
            " GFutbol Americano Varonil : HEAD COACH Rodrigo Galindo Nava \n" +
            " Tocho Bandera: HEAD COACH Juan Antonio Rivas Garcia \n" +
        "[Actividades Culturales] \n" +
                " Artes Visuales : Prof. Guadalupe de la Rosa Castelan \n " +
                " Musica Folklorica: Prof. Julio de la Cruz Rodriguez \n" +
                " Danza Folklorica: Prof. Emmanuel Flores Don Juan \n" +
                " Piano: Prof.Eduardo Gomez Alarcon \n" +
                " Creacion Literaria Profa. Rosa Maria Getino \n" +
                " Teatro: Prof. Alexis Badillo Ortiz \n"
            ,
        "Espera..."
    };
    static String[] opcionesTutorias = {
        "1. Consultar horarios",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeTutorias = {
        "1. mensaje 1",
        "2. mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesEventos = {
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeEventos = {
        "1.mensaje 1",
        "2.mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesAlumnos = {
        "1. opcion 1",
        "2. opcion 2",
        "3. opcion 3",
        "4. Regresar al menu inicial"
    };
    static String[] mensajeAlumnos = {
        "1. mensaje 1",
        "2. mensaje 2",
        "3. mensaje 3",
        "Espera..."
    };
    static String[] opcionesTramites = {
        "1. Solicitud de Dictamen",
        "2. Cambios de carrera o plantel",
        "3. Inscripci\u00F3n/ Reinscripci\u00F3n",
        "4. Proceso de Saberes Previos",
        "5. Trayectoria, constancias y boletas",
        "6. Bajas temporales y definitivas",
        "7. Certificados y documentacion de egreso",
        "8. Regresar al menu inicial "
    };
    static String[] mensajeTramites = {
        //1Dictamen
        "El periodo de recepci\u00F3n de solicitudes se lleva  \n" +
                "a cabo al final del proceso de inscripci\u00F3n de cada \n" +
                "semestre. \n" +
                "Los alumnos que hayan incumplido con lo esta- \n" +
                "blecido en el Reglamento General de Estudios y \n" +
                "deseen regularizar su situaci\u00F3n escolar, deben \n" +
                "solicitar Dictamen: \n" +
                "Cuando el alumno a\u00FAn puede terminar sus estu- \n" +
                "dios de nivel medio superior en los t\u00E9rminos del \n" +
                "Art. 49 del Reglamento General de Estudios \n" +
                "(4 años y medio). \n" +
                "Cuando el alumno el alumno rebasa el t\u00E9rmino \n" +
                "establecido por el Art. 49 del Reglamento General de \n" +
                "Estudios para el t\u00E9rmino de sus estudios (m\u00E1s de 4 a\u00F1os \n" +
                "y medio). \n" +
                "Para solicitarlo, deben enviar un mensaje de correo electr\u00F3nico \n" +
                "a gestion.escolar.cecyt9@gmail.com indicando nombre completo,\n" +
                " n\u00FAmero de boleta y situaci\u00F3n escolar \n"
        ,
        //2CambiodePlantelCarrera
        "La convocatoria se publica al final de cada semestre en la siguiente p\u00E1gina web: \n" +
                "www.dae.ipn.mx/cambiosua/ \n"
        ,
        //3InscripcionReinscripcion
                "Las fechas y los procedimientos se publican en la p\u00E1gina del \n" +
                        "CECyT y se difunden a trav\u00E9s de los medios oficiales del plantel. \n" +
                        "La reinscripci\u00F3n NUNCA es autom\u00E1tica y es obligaci\u00F3n del \n" +
                "alumno estar atento a los comunicados que se publican en la \n" +
                "página del plantel y de realizar los trámites correspondientes en \n" +
                "tiempo y forma. \n" +
                "De igual forma, el alumno debe informar de manera INMEDIATA \n" +
                        "cualquier problema que tenga con su registro de inscripci\u00F3n. \n" +
                        "Toda la informaci\u00F3n que el alumno proporciona al plantel est\u00E1 \n" +
                        "protegida por el aviso de privacidad de la instituci\u00F3n y la\n" +
                        " veracidad de los datos es responsabilidad \u00FAnica del alumno. \n" +
                        "Estos datos son utilizados para la difusi\u00F3n de informaci\u00F3n \n" +
                        "oficial, para el tr\u00E1mite de becas y otros est\u00EDmulos, de documentos \n" +
                "de egreso y para ponerse en contacto con sus padres y/o \n" +
                "tutores en casos de emergencia \n"
        ,
        //4SaberesPrevios
                "El proceso se lleva a cabo al inicio de cada semestre. Las fechas y \n" +
                        " procedimientos se publican en la p\u00E1gina del CECyT.\n",
        //5Trayectoria
                "El departamento de Gesti\u00F3n Escolar expide, a solicitud del alumno, \n" +
                        "boletas y constancias para diversor tr\u00E1mites. Para solicitarlas, se debe \n" +
                "hacer el registro en las ligas abajo indicadas: \n" +
                "Boletas de calificaciones \n" +
                "https://forms.gle/bm3cfuW85rcozhid6 \n" +
                "Constancias de Estudio \n" +
                "https://forms.gle/P8b2S7SndaYynn5ZA \n",
        //6Bajas
        "BAJA TEMPORAL \n" +
                "Se solicita en los primeros 30 d\u00EDas posteriores a la inscripci\u00F3n \n" +
                " y puede ser por 6  meses o por 1 a\u00F1o Para solicitarla, se debe \n" +
                "escribir un correo electr\u00F3nico al departamento solicitando la liga de\n " +
                "registro. \n" +
                "BAJA DEFINITIVA \n" +
                "Para solicitarla, primero se debe hacer el registro en la siguiente liga: \n " +
                "https://forms.gle/phqbsmwKobLqEt8i7 \n" +
                "Despu\u00E9s se debe solicitar el tr\u00E1mite de una boleta global de calificaciones \n" +
                "(3 firmas) en la siguiente liga: \n" +
                "https://forms.gle/bm3cfuW85rcozhid6\n",
        //7Egreso
                "CERTIFICACIÓN INTEGRAL \n" +
                        "Se lleva a cabo \u00FAnicamente en el periodo intersemestral del mes de \n" +
                        "julio y sirve para agilizar el proceso de certificaci\u00F3n del alumno.\n " +
                        "El procedimiento se publica en la p\u00E1gina del plantel.\n" +
                        "ENTREGA DE DOCUMENTACI\u00D3N DE EGRESO \n" +
                "Se lleva a cabo al final de cada semestre para los alumnos que han concluido \n" +
                        "satisfactoriamente sus estudios. El procedimiento se publica en la p\u00E1gina \n" +
                "del plantel \n",
        "Espera..."
    };

    public static void MenuActividadesDeportivasCulturales() {
        int mostrar = menu(opcionesDeportivas);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeDeportivas[mostrar - 1]);
                break;
        }
    }

    public static void MenuTramites() {
        int mostrar = menu(opcionesTramites);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeTramites[mostrar - 1]);
                break;
        }
    }

    public static void MenuAlumnos() {
        int mostrar = menu(opcionesAlumnos);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeAlumnos[mostrar - 1]);
                break;
        }
    }

    public static void MenuEventos() {
        int mostrar = menu(opcionesEventos);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeEventos[mostrar - 1]);
                break;
        }
    }

    public static void MenuTutorias() {
        int mostrar = menu(opcionesTutorias);
        switch (mostrar) {
            case 0:
                System.out.println("error");
                break;
            default:
                System.out.println(mensajeTutorias[mostrar - 1]);
                break;
        }
    }



    public static void PanelAdministrador() {
        int contrasenaIngresada = 0;
        int contrasenaEsperada = -2310;
        System.out.println("Ingresa la contraseña");
        for (int i = 0; i < 3; i++) {
            Separacion();
            contrasenaIngresada = LeerNum();
            if (contrasenaIngresada == contrasenaEsperada) {
                i = 3;
            } else {
                Separacion();
                if (i != 2){
                    System.out.println("Contrase\u00F1a incorrecta - Intenta ingresarla de nuevo");
                }
            }
        }
        if (contrasenaIngresada != contrasenaEsperada) {
            System.out.println("Demasiados intentos");
            Separacion();
            reinicio = true;
        } else {
            System.out.println("Ahora eres admin");
        }
    }

    public static void MostrarOpciones(String mensaje, String[] opciones) {
        Separacion();
        System.out.println(mensaje);
        Separacion();
        for (int q = 0; q < opciones.length; q++) {
            System.out.println(opciones[q]);
        }
        Separacion();
    }

    public static int NumRango(String[] opciones, int minimo, int maximo) {
        int numIngresado = LeerNum();
        boolean bandera = (numIngresado < minimo) || (numIngresado > maximo);
        while (bandera) {
            Separacion();
            System.out.println("Ingresa un valor valido segun el menu");
            Separacion();
            for (int i = 0; i < opciones.length; i++) {
                System.out.println(opciones[i]);
            }
            Separacion();
            numIngresado = LeerNum();
            if (numIngresado >= minimo && numIngresado <= maximo) {
                bandera = false;
            }
        }
        Separacion();
        return numIngresado;
    }

    public static int LeerNum() {
        Scanner leer = new Scanner(System.in);
        int num = leer.nextInt();
        return num;
    }

    public static void Separacion() {
        for (int i = 0; i < 150; i++) {
            System.out.print("_");
        }
        System.out.println('\n');
    }

    public static void ImprimirNombre() {
        System.out.println(" ____________________________________________________________________________________________________________ ");
        System.out.println("|                                                                                                            |");
        System.out.println("|      :::       ::: ::::::::::: :::    ::: ::::::::::: :::::::::      ::: ::::::::::: ::::::::::: ::::: :::: |");
        System.out.println("|     :+:       :+:     :+:     :+:   :+:      :+:     :+:    :+:   :+: :+:   :+:         :+:          :+:   |");
        System.out.println("|    +:+       +:+     +:+     +:+  +:+       +:+     +:+    +:+  +:+   +:+  +:+         +:+         +:+     |");
        System.out.println("|   +#+  +:+  +#+     +#+     +#++:++        +#+     +#++:++#+  +#++:++#++: +#+         +#+        +#+       |");
        System.out.println("|  +#+ +#+#+ +#+     +#+     +#+  +#+       +#+     +#+    +#+ +#+     +#+ +#+         +#+       +#+         |");
        System.out.println("|  #+#+# #+#+#      #+#     #+#   #+#      #+#     #+#    #+# #+#     #+# #+#         #+#      #+#           |");
        System.out.println("|  ###   ###   ########### ###    ### ########### #########  ###     ### ###     ########### #########       |");
        System.out.println("|                                                                                                            |");
        System.out.println("|____________________________________________________________________________________________________________|");
        System.out.println('\n');
    }
}
