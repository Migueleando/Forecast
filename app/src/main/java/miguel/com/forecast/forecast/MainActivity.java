package miguel.com.forecast.forecast;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.action_bar_container, new PlaceholderFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
            String[] weekForecast = {"Hoy - Soleado - 19-30", "Mañana - Soleado - 18-35", "Martes - Nublado - 19-29",
                    "Miercoles - Lluvia de meteoritos - 21-30", "Jueves - soleado - 19-30", "Viernes - soleado - 19-30", "Sábado - soleado - 19-30"};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);
            ListView listView = (ListView) findViewById(R.id.ListViewForecast);
            listView.setAdapter(adapter);
            return listView;
        }
    }
}
