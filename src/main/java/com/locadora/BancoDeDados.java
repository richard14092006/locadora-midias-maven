package com.locadora;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.util.List;

public class BancoDeDados {
    private static Nitrite db;
    private static ObjectRepository<Cliente> clientesRepo;
    private static ObjectRepository<Midia> midiasRepo;
    private static ObjectRepository<Locacao> locacoesRepo;

    public static void iniciar() {
        if (db != null) return;
        db = Nitrite.builder()
                .filePath("locadora.db")
                .openOrCreate("admin", "1234");

        clientesRepo = db.getRepository(Cliente.class);
        midiasRepo = db.getRepository(Midia.class);
        locacoesRepo = db.getRepository(Locacao.class);
    }

    public static void fechar() {
        if (db != null && !db.isClosed()) db.close();
    }

    public static void salvarCliente(Cliente c) { clientesRepo.update(c, true); }
    public static void salvarMidia(Midia m) { midiasRepo.update(m, true); }
    public static void salvarLocacao(Locacao l) { locacoesRepo.update(l, true); }

    public static List<Cliente> listarClientes() { return clientesRepo.find().toList(); }
    public static List<Midia> listarMidias() { return midiasRepo.find().toList(); }
    public static List<Locacao> listarLocacoes() { return locacoesRepo.find().toList(); }
}
