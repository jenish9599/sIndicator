package moduals;

import java.util.List;

/**
 * Created by jenishpatel on 18/03/17.
 */

public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
