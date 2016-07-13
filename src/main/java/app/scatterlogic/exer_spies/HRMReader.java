package app.scatterlogic.exer_spies;

public interface HRMReader {
    int bpm();

    boolean Connect();
    boolean Disconnect();
    boolean isConnected();
}
