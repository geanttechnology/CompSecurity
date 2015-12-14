// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import apq;
import aso;
import bei;
import bjh;
import bji;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.photoselector.activity.CommonActionBarView;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;
import com.instamag.activity.compose.MagComposeActivity;
import com.instamag.activity.library.model.TResTypeManager;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import java.util.ArrayList;
import java.util.List;
import yp;

public class InstaRandomPhotoSelectorActivity extends PhotoSelectorActivity
{

    private bei d;
    private String e;

    public InstaRandomPhotoSelectorActivity()
    {
        d = null;
        e = "InstaRandomPhotoSelectorActivity";
    }

    private TPhotoComposeInfo c(int i)
    {
        List list;
        Object obj;
label0:
        {
            obj = null;
            TPhotoMagComposeManager tphotomagcomposemanager = apq.c().d();
            List list1 = tphotomagcomposemanager.getInfosByImageCountTypeId(i, TResTypeManager.KRES_MINIMAL);
            if (list1 != null)
            {
                list = list1;
                if (list1 == null)
                {
                    break label0;
                }
                list = list1;
                if (list1.size() != 0)
                {
                    break label0;
                }
            }
            list = tphotomagcomposemanager.getInfosByImageCountAndCollageType(i);
        }
        TPhotoComposeInfo tphotocomposeinfo = obj;
        if (list != null)
        {
            tphotocomposeinfo = obj;
            if (list.size() > 0)
            {
                tphotocomposeinfo = (TPhotoComposeInfo)list.get((int)(Math.random() * (double)list.size()));
            }
        }
        return tphotocomposeinfo;
    }

    public void a(Object obj)
    {
        obj = (Integer)obj;
        if (((Integer) (obj)).intValue() < a.size())
        {
            a.remove(((Integer) (obj)).intValue());
            obj = getResources().getString(0x7f060205);
            c((new StringBuilder()).append(((String) (obj))).append("(").append(Integer.toString(h().size())).append(")").toString());
            return;
        } else
        {
            Log.v("photo selected ", "delete failed");
            return;
        }
    }

    public void a(String s, aso aso)
    {
        super.a(s, aso);
        s = getResources().getString(0x7f060205);
        c((new StringBuilder()).append(s).append("(").append(Integer.toString(h().size())).append(")").toString());
    }

    public void d()
    {
        super.d();
        int i = a.size();
        if (i < i())
        {
            Toast.makeText(this, getResources().getString(0x7f0601ac).replace("N", String.valueOf(1)), 0).show();
        } else
        {
            if (i > j())
            {
                Toast.makeText(this, getResources().getString(0x7f0601ac).replace("N", String.valueOf(9)), 0).show();
                return;
            }
            TPhotoComposeInfo tphotocomposeinfo = c(i);
            if (tphotocomposeinfo != null)
            {
                ArrayList arraylist = h();
                Intent intent = new Intent(this, com/instamag/activity/compose/MagComposeActivity);
                ArrayList arraylist1 = new ArrayList(arraylist.size());
                for (int j = 0; j < arraylist.size(); j++)
                {
                    arraylist1.add(((Uri)arraylist.get(j)).toString());
                }

                intent.putExtra("use_for_flurry_mag", 20);
                intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist1);
                intent.putExtra("SelectedComposeInfoResId", tphotocomposeinfo.resId);
                startActivity(intent);
                return;
            }
        }
    }

    public void nextBtnClicked(View view)
    {
        super.nextBtnClicked(view);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.e("oncreate", "oncreate");
        bundle = (Button)findViewById(0x7f0d010a);
        if (bundle != null)
        {
            bundle.setVisibility(0);
        }
        Object obj = (CommonActionBarView)findViewById(0x7f0d00b3);
        if (obj != null)
        {
            ((CommonActionBarView) (obj)).setVisibility(4);
        }
        obj = (RelativeLayout)findViewById(0x7f0d0109);
        bundle.setBackgroundResource(0x7f020199);
        ((RelativeLayout) (obj)).setBackgroundColor(getResources().getColor(0x7f0c0086));
        obj = getResources().getString(0x7f060205);
        c((new StringBuilder()).append(((String) (obj))).append("(").append(Integer.toString(h().size())).append(")").toString());
        b(9);
        a(1);
        d(((String) (obj)));
        obj = (LinearLayout)findViewById(0x7f0d010d);
        bundle.getViewTreeObserver().addOnGlobalLayoutListener(new bjh(this, bundle));
        bundle = (Button)findViewById(0x7f0d010f).findViewById(0x7f0d010b);
        bundle.getViewTreeObserver().addOnGlobalLayoutListener(new bji(this, bundle));
    }

    protected void onResume()
    {
        super.onResume();
        Log.v(e, (new StringBuilder()).append(e).append(" onResume").toString());
        if (!yp.m(this))
        {
            RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0d00b0);
            relativelayout.setVisibility(0);
            FotoAdFactory.createAdBanner(this, relativelayout);
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }

    public void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }
}
