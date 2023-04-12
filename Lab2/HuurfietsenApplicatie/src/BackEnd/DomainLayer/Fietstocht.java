package BackEnd.DomainLayer;

import java.time.LocalDateTime;

public interface Fietstocht {
    public int tid();

    public LocalDateTime tijd();

    public void voegLocatieToe(LocalDateTime t, int x, int y);
}
