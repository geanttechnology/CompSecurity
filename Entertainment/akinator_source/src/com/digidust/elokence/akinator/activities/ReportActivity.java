// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.digidust.elokence.akinator.adapters.AkReportAdapter;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity

public class ReportActivity extends AkActivity
{

    private AkReportAdapter adapter;
    private android.view.View.OnClickListener mRetourClickListener;
    private ImageView retourButton;
    private TextView textReport;
    private ListView uiReportList;

    public ReportActivity()
    {
        mRetourClickListener = new android.view.View.OnClickListener() {

            final ReportActivity this$0;

            public void onClick(View view)
            {
                onBack();
            }

            
            {
                this$0 = ReportActivity.this;
                super();
            }
        };
    }

    private void onBack()
    {
        super.onBackPressed();
        startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
        overridePendingTransition(0x7f04001a, 0x7f04001b);
        finish();
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 2 && j == 0)
        {
            goToHome();
        }
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (mIsRebooting)
        {
            return;
        } else
        {
            setContentView(0x7f030032);
            retourButton = (ImageView)findViewById(0x7f0d0133);
            uiReportList = (ListView)findViewById(0x7f0d01a5);
            textReport = (TextView)findViewById(0x7f0d01a4);
            adapter = new AkReportAdapter(this, SessionFactory.sharedInstance().getSession().getCurrentReport());
            uiReportList.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            uiReportList.setDivider(null);
            uiReportList.setDividerHeight(0);
            textReport.setText(TraductionFactory.sharedInstance().getTraductionFromToken("RAPPORT_DE_PARTIE"));
            textReport.setTypeface(tf);
            addTextView(textReport);
            setBackgroundImage(0x7f0d0085, (Bitmap)AkSceneryFactory.sharedInstance().getBackgroundSet(AkConfigFactory.sharedInstance().getBackground()).background3.get(0), true);
            retourButton.setOnClickListener(mRetourClickListener);
            return;
        }
    }

    public void onDestroy()
    {
        if (!mIsRebooting)
        {
            adapter.clear();
        }
        super.onDestroy();
    }

}
