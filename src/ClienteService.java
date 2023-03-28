@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteDTO obtenerCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        // Calcular edad
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(cliente.getFechaNacimiento(), fechaActual).getYears();

        // Crear DTO con la información requerida
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(cliente.getNombre());
        clienteDTO.setApellido(cliente.getApellido());
        clienteDTO.setEdad(edad);

        return clienteDTO;
    }

}
