package Control;

/**
 * Created by ribohe94 on 28/07/16.
 */
public interface State {
    public State next(Input in);
}
