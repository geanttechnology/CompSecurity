// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import com.gotv.crackle.data.GenreList;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.util.Log;

// Referenced classes of package com.gotv.crackle:
//            LoadingActivity, Application

class this._cls1
    implements android.content.ickListener
{

    final tActivity this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        finish();
        dialoginterface = new Intent("android.intent.action.MAIN");
        dialoginterface.addCategory("android.intent.category.HOME");
        startActivity(dialoginterface);
    }

    l.tag()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/gotv/crackle/LoadingActivity$2

/* anonymous class */
    class LoadingActivity._cls2
        implements Runnable
    {

        final LoadingActivity this$0;
        final String val$tag;

        public void run()
        {
            if (LoadingActivity.access$000(LoadingActivity.this) || !tag.equalsIgnoreCase("GetAllowedLocations") && !tag.equalsIgnoreCase("GetLocation")) goto _L2; else goto _L1
_L1:
            Log.d("LOADING", "LOADING 3");
            if (!Application.getInstance().getLocalization().allRequestsComplete()) goto _L4; else goto _L3
_L3:
            Log.d("LOADING", "LOADING 4");
            if (!Application.getInstance().getLocalization().isCurrentCountryCodeValid()) goto _L6; else goto _L5
_L5:
            Log.d("LOADING", "LOADING 5");
            LoadingActivity.access$002(LoadingActivity.this, true);
            Application.getInstance();
            if (Application.isLeanBack() || Application.isNookTablet() || Application.isKindle()) goto _L8; else goto _L7
_L7:
            LoadingActivity.access$200(LoadingActivity.this);
_L4:
            return;
_L8:
            LoadingActivity.access$100(LoadingActivity.this);
            return;
_L6:
            Log.d("LOADING", "LOADING 6");
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoadingActivity.this);
            builder.setMessage(getResources().getString(0x7f0b00b3));
            builder.setPositiveButton(getResources().getString(0x7f0b00b5), new LoadingActivity._cls2._cls1());
            builder.create().show();
            return;
_L2:
            if (LoadingActivity.access$300(LoadingActivity.this) != null && LoadingActivity.access$400(LoadingActivity.this) != null && LoadingActivity.access$500(LoadingActivity.this) != null)
            {
                Log.d("LOADING", "LOADING 8");
                if (LoadingActivity.access$300(LoadingActivity.this).getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE && LoadingActivity.access$400(LoadingActivity.this).getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE && LoadingActivity.access$500(LoadingActivity.this).getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
                {
                    Log.d("LOADING", "LOADING 9");
                    if (Application.isLeanBack())
                    {
                        finish();
                        Application.getInstance().startHomeActivity(LoadingActivity.this);
                        return;
                    } else
                    {
                        getAd();
                        return;
                    }
                }
            }
            if (true) goto _L4; else goto _L9
_L9:
        }

            
            {
                this$0 = final_loadingactivity;
                tag = String.this;
                super();
            }
    }

}
