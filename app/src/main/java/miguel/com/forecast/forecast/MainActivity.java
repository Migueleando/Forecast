package miguel.com.forecast.forecast;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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

    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> adapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);


            String[] weekForecast = {"Hoy - Soleado - 19-30", "Mañana - Soleado - 18-35", "Martes - Nublado - 19-29",
                    "Miercoles - Lluvia de meteoritos - 21-30", "Jueves - soleado - 19-30", "Viernes - soleado - 19-30", "Sábado - soleado - 19-30"};

            adapter = new ArrayAdapter<>(getActivity(),
                    R.layout.list_item_forecast, R.id.list_item_forecast_textview, weekForecast);

            ListView listView = (ListView) rootView.findViewById(R.id.ListViewForecast);

            listView.setAdapter(adapter);


            return rootView;

        }
    }
}
