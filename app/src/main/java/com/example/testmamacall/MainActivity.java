package com.example.testmamacall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private String packageName = "kr.co.knowledgepoint.MaMaCall";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button testBtn = (Button) findViewById(R.id.testBtn);

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
//                getPackageList();
                String url = "myapp://app";
                Intent intent = new Intent(Intent.ACTION_MAIN, Uri.parse(url));
                intent.putExtra("userId", "spoonId");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });
    }

    public void getPackageList() {
//        boolean isExist = false;
        Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent == null) {
            Log.i("없음", "없음");
            Intent goWebSite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://st-facecall.milkt.co.kr/store"));
            startActivity(goWebSite);
        } else {
            Log.v("있음", "있음");
            String userId = "tspoonId";
            String callStatus = "start";
            String name = "홍길동";
            intent.putExtra("userId", userId);
            intent.putExtra("callStatus", callStatus);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }



//        PackageManager pkgMgr = getPackageManager();
//        List<ResolveInfo> mApps;
//        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
//        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        mApps = pkgMgr.queryIntentActivities(mainIntent, 0);
//
//        try {
//            for (int i = 0; i < mApps.size(); i++) {
//                if(mApps.get(i).activityInfo.packageName.startsWith(packageName)){
//                    Log.i("$$$$$$", "$$$$$$");
//                    isExist = true;
//                    Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
//                    String userId = "tspoonId";
//                    String callStatus = "start";
//                    String name = "홍길동";
//                    intent.putExtra("userId", userId);
//                    intent.putExtra("callStatus", callStatus);
//                    intent.putExtra("name", name);
//                    startActivity(intent);
//                    break;
//                } else {
//                    Log.i("#############", "#######");
//                    Intent goWebSite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://st-facecall.milkt.co.kr/store"));
//                    startActivity(goWebSite);
//                }
//            }
//        }
//        catch (Exception e) {
//            isExist = false;
//        }
//        return isExist;
//    }
}