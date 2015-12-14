// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.photoselector.activity.CommonActionBarView;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;
import com.pipcamera.application.PIPCameraApplication;
import ew;
import java.util.ArrayList;
import nl;
import pb;

// Referenced classes of package com.instamag.activity.lib:
//            MagComposeActivity

public class InstaPhotoSelectorActivity extends PhotoSelectorActivity
{

    private int d;
    private int e;
    private RelativeLayout f;
    private final String g = "InstaPhotoSelectorActivity";

    public InstaPhotoSelectorActivity()
    {
        d = 0;
        e = 1;
    }

    public void a(Object obj)
    {
        obj = (Integer)obj;
        if (((Integer) (obj)).intValue() < a.size())
        {
            a.remove(((Integer) (obj)).intValue());
            String s = getResources().getString(0x7f06018b).replace("N", String.valueOf(e));
            obj = s;
            if (e == 1)
            {
                obj = s.replace("photos", "photo");
            }
            c((new StringBuilder()).append(((String) (obj))).append("(").append(Integer.toString(h().size())).append(")").toString());
            return;
        } else
        {
            Log.v("photo selected ", "delete failed");
            return;
        }
    }

    public void a(String s, nl nl)
    {
        super.a(s, nl);
        nl = getResources().getString(0x7f06018b).replace("N", String.valueOf(e));
        s = nl;
        if (e == 1)
        {
            s = nl.replace("photos", "photo");
        }
        c((new StringBuilder()).append(s).append("(").append(Integer.toString(h().size())).append(")").toString());
    }

    public void d()
    {
        super.d();
        int i = a.size();
        if (i < i())
        {
            Toast.makeText(this, getResources().getString(0x7f06018b).replace("N", String.valueOf(e)), 0).show();
        } else
        {
            if (i > j())
            {
                Toast.makeText(this, getResources().getString(0x7f06018a).replace("N", String.valueOf(e)), 0).show();
                return;
            }
            ArrayList arraylist = h();
            Intent intent = new Intent(this, com/instamag/activity/lib/MagComposeActivity);
            ArrayList arraylist1 = new ArrayList(e);
            for (int j = 0; j < arraylist.size(); j++)
            {
                arraylist1.add(((Uri)arraylist.get(j)).toString());
            }

            intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist1);
            intent.putExtra("SelectedComposeInfoResId", d);
            startActivity(intent);
            if (PIPCameraApplication.b)
            {
                finish();
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
        Log.e("instaPSA", "instaPSA");
        Button button = (Button)findViewById(0x7f0c007f);
        if (button != null)
        {
            button.setVisibility(0);
        }
        CommonActionBarView commonactionbarview = (CommonActionBarView)findViewById(0x7f0c0081);
        if (commonactionbarview != null)
        {
            commonactionbarview.setActionBarTitle("");
            commonactionbarview.setVisibility(4);
        }
        ((RelativeLayout)findViewById(0x7f0c007e)).setBackgroundColor(getResources().getColor(0x7f0b0080));
        button.setBackgroundResource(0x7f020046);
        f = (RelativeLayout)findViewById(0x7f0c0055);
        button.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(button) {

            final Button a;
            final InstaPhotoSelectorActivity b;

            public void onGlobalLayout()
            {
                a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (a != null)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                    if (layoutparams != null)
                    {
                        layoutparams.height = pb.a(PIPCameraApplication.a, 47F);
                        layoutparams.width = pb.a(PIPCameraApplication.a, 59F);
                        a.setLayoutParams(layoutparams);
                    }
                }
            }

            
            {
                b = InstaPhotoSelectorActivity.this;
                a = button;
                super();
            }
        });
        button = (Button)findViewById(0x7f0c0083).findViewById(0x7f0c0080);
        button.setBackgroundResource(0x7f02022d);
        button.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(button) {

            final Button a;
            final InstaPhotoSelectorActivity b;

            public void onGlobalLayout()
            {
                a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (a != null)
                {
                    android.view.ViewGroup.LayoutParams layoutparams = a.getLayoutParams();
                    if (layoutparams != null)
                    {
                        layoutparams.height = pb.a(PIPCameraApplication.a, 44F);
                        layoutparams.width = pb.a(PIPCameraApplication.a, 60F);
                        a.setLayoutParams(layoutparams);
                    }
                }
            }

            
            {
                b = InstaPhotoSelectorActivity.this;
                a = button;
                super();
            }
        });
        e = 0;
        if (bundle == null) goto _L2; else goto _L1
_L1:
        d = bundle.getInt("SelectedComposeInfoResId");
        e = bundle.getInt("SelectedComposeInfoImageCount");
_L4:
        String s = getResources().getString(0x7f06018b).replace("N", String.valueOf(e));
        bundle = s;
        if (e == 1)
        {
            bundle = s.replace("photos", "photo");
        }
        c((new StringBuilder()).append(bundle).append("(").append(Integer.toString(h().size())).append(")").toString());
        b(e);
        a(e);
        s = getResources().getString(0x7f06018a).replace("N", String.valueOf(e));
        bundle = s;
        if (e == 1)
        {
            bundle = s.replace("photos", "photo");
        }
        d(bundle);
        return;
_L2:
        bundle = getIntent();
        if (bundle != null)
        {
            d = bundle.getIntExtra("SelectedComposeInfoResId", 18);
            e = bundle.getIntExtra("SelectedComposeInfoImageCount", 4);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onResume()
    {
        super.onResume();
        Log.v("InstaPhotoSelectorActivity", "onResume");
        if (!ew.n(this))
        {
            f.setVisibility(0);
            FotoAdFactory.createAdBanner(this, f);
            return;
        } else
        {
            f.setVisibility(8);
            return;
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SelectedComposeInfoResId", d);
        bundle.putInt("SelectedComposeInfoImageCount", e);
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, PIPCameraApplication.h);
    }

    public void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }
}
