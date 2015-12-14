// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.photoselector;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.photoselector.activity.PhotoSelectorActivity;
import com.instamag.activity.compose.MagComposeActivity;
import java.util.ArrayList;

public class InstaPhotoSelectorActivity extends PhotoSelectorActivity
{

    public static InstaPhotoSelectorActivity d = null;
    private int e;
    private int f;

    public InstaPhotoSelectorActivity()
    {
        e = 0;
        f = 1;
    }

    public void d()
    {
        super.d();
        if (a.size() < i())
        {
            Toast.makeText(this, getResources().getString(0x7f0601ac).replace("N", String.valueOf(f)), 0).show();
            return;
        }
        ArrayList arraylist = h();
        Intent intent = new Intent(this, com/instamag/activity/compose/MagComposeActivity);
        ArrayList arraylist1 = new ArrayList(f);
        for (int i = 0; i < arraylist.size(); i++)
        {
            arraylist1.add(((Uri)arraylist.get(i)).toString());
        }

        intent.putExtra("use_for_flurry_mag", 20);
        intent.putStringArrayListExtra("SelectedImageUriStrings", arraylist1);
        intent.putExtra("SelectedComposeInfoResId", e);
        startActivity(intent);
    }

    public void nextBtnClicked(View view)
    {
        super.nextBtnClicked(view);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Button button = (Button)findViewById(0x7f0d010a);
        RelativeLayout relativelayout = (RelativeLayout)findViewById(0x7f0d0109);
        button.setBackgroundResource(0x7f020046);
        relativelayout.setBackgroundResource(0x7f0202d5);
        d = this;
        f = 0;
        if (bundle == null) goto _L2; else goto _L1
_L1:
        e = bundle.getInt("SelectedComposeInfoResId");
        f = bundle.getInt("SelectedComposeInfoImageCount");
_L4:
        String s = getResources().getString(0x7f0601ac).replace("N", String.valueOf(f));
        bundle = s;
        if (f == 1)
        {
            bundle = s.replace("photos", "photo");
        }
        c(bundle);
        b(f);
        a(f);
        s = getResources().getString(0x7f0601ac).replace("N", String.valueOf(f));
        bundle = s;
        if (f == 1)
        {
            bundle = s.replace("photos", "photo");
        }
        d(bundle);
        return;
_L2:
        bundle = getIntent();
        if (bundle != null)
        {
            e = bundle.getIntExtra("SelectedComposeInfoResId", 18);
            f = bundle.getIntExtra("SelectedComposeInfoImageCount", 4);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("SelectedComposeInfoResId", e);
        bundle.putInt("SelectedComposeInfoImageCount", f);
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
