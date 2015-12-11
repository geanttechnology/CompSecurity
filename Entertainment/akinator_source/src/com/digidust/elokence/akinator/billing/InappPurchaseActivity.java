// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.billing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.elokence.limuleapi.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.digidust.elokence.akinator.billing:
//            InappManagerImpl

public class InappPurchaseActivity extends Activity
{

    static InappManagerImpl caller = null;
    static PendingIntent toLaunch = null;

    public InappPurchaseActivity()
    {
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        boolean flag1 = false;
        if (i != 1001) goto _L2; else goto _L1
_L1:
        Object obj;
        intent.getIntExtra("RESPONSE_CODE", 0);
        obj = intent.getStringExtra("INAPP_PURCHASE_DATA");
        intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (j != -1) goto _L4; else goto _L3
_L3:
        obj = new JSONObject(((String) (obj)));
        intent = ((JSONObject) (obj)).getString("productId");
        obj = ((JSONObject) (obj)).getString("purchaseToken");
        caller.inappActivityCallback(this, intent, ((String) (obj)));
        if (AkConfigFactory.sharedInstance().isPaid() || AkConfigFactory.sharedInstance().isFreemium() && AkGameFactory.sharedInstance().isUnlocked()) goto _L6; else goto _L5
_L5:
        boolean flag = flag1;
        if (!AkConfigFactory.sharedInstance().isFreemium()) goto _L8; else goto _L7
_L7:
        flag = flag1;
        if (AkGameFactory.sharedInstance().getPopularityState()) goto _L8; else goto _L6
_L8:
        try
        {
            SessionFactory.sharedInstance().setPrio(flag);
            SessionFactory.sharedInstance().setPartnerId(AkConfigFactory.sharedInstance().getPartnerId(AkConfigFactory.sharedInstance().isTablet()));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.e("Akinator", "Failed to parse purchase data.");
            intent.printStackTrace();
        }
_L4:
        finish();
_L2:
        return;
_L6:
        flag = true;
        if (true) goto _L8; else goto _L9
_L9:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030026);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0e0003, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f0d02d5)
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (toLaunch == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        startIntentSenderForResult(toLaunch.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        return;
        android.content.IntentSender.SendIntentException sendintentexception;
        sendintentexception;
        sendintentexception.printStackTrace();
        return;
    }

}
