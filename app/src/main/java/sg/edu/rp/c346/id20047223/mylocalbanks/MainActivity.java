package sg.edu.rp.c346.id20047223.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String wordclicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textviewDBS);
        tvOCBC = findViewById(R.id.textviewOCBC);
        tvUOB = findViewById(R.id.textviewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvDBS){
            wordclicked = "DBS";
        } else if (v == tvOCBC){
            wordclicked = "OCBC";
        } else if(v == tvUOB){
            wordclicked = "UOB";
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.language_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.English){
            tvDBS.setText("@string/bank1");
            tvOCBC.setText("@string/bank2");
            tvUOB.setText("@string/bank3");
        } else if(id == R.id.Chinese){
            tvDBS.setText("@string/cbank1");
            tvOCBC.setText("@string/cbank2");
            tvUOB.setText("@string/cbank3");
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (wordclicked.equalsIgnoreCase("DBS")){
            if(item.getItemId() == 0){
                Intent intentDBS = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:@string/ubank1"));
                startActivity(intentDBS);

                return true;
            } else if(item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:@string/pbank2"));
                startActivity(intentCall);

                return true;
            } else if(item.getItemId() == 2){
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
            }
        } else if (wordclicked.equalsIgnoreCase("OCBC")){
            if(item.getItemId() == 0){
                Intent intentOCBC = new Intent(Intent.ACTION_VIEW, Uri.parse("@string/ubank2"));
                startActivity(intentOCBC);
            } else if(item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("@string/pbank2"));
                startActivity(intentCall);
            } else if(item.getItemId() == 2){

                tvDBS.setTextColor(Color.parseColor("#FF0000"));
            }
        } else if(wordclicked.equalsIgnoreCase("UOB")){
            if(item.getItemId() == 0){
                Intent intentUOB = new Intent(Intent.ACTION_VIEW, Uri.parse("@string/ubank3"));
                startActivity(intentUOB);
            } else if (item.getItemId() == 1){
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:@string/pbank3"));
                startActivity(intentCall);
            } else if(item.getItemId() == 2){
                tvDBS.setTextColor(Color.parseColor("#FF0000"));
            }
        }
        return super.onContextItemSelected(item);
    }
}