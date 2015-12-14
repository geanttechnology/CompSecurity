// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import asx;
import bjk;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.wantu.activity.photoselector:
//            MultiPhotoSelectorFragment

public class MultiPhotoSelectorActivity extends FragmentActivity
{

    private ProgressDialog a;

    public MultiPhotoSelectorActivity()
    {
    }

    public void a()
    {
        showDialog(1);
    }

    public void b()
    {
        a = null;
        removeDialog(1);
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void nextBtnClicked(View view)
    {
        view = (MultiPhotoSelectorFragment)getSupportFragmentManager().findFragmentByTag("gridphotos");
        if (view == null)
        {
            return;
        }
        Object obj = view.a();
        if (((ArrayList) (obj)).size() < 2)
        {
            Toast.makeText(this, getResources().getString(0x7f060132), 0).show();
            return;
        }
        view = new ArrayList();
        for (int i = 0; i < ((ArrayList) (obj)).size(); i++)
        {
            view.add(Integer.valueOf((int)((asx)((ArrayList) (obj)).get(i)).b()));
        }

        obj = new bjk(this, null);
        obj.a = view;
        ((bjk) (obj)).execute(new Void[0]);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(0x7f03002f);
        bundle = getSupportFragmentManager().beginTransaction();
        bundle.add(0x7f0d0108, MultiPhotoSelectorFragment.a("gridphotos"), "gridphotos");
        bundle.commit();
    }

    protected Dialog onCreateDialog(int i)
    {
        ProgressDialog progressdialog;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(getResources().getString(0x7f0601c6));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        a = progressdialog;
        return progressdialog;
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }
}
