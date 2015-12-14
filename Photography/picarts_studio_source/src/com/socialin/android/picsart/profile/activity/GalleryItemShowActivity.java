// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.fragment.aa;
import myobfuscated.f.m;

public class GalleryItemShowActivity extends BaseActivity
{

    private static String a = (new StringBuilder()).append(com/socialin/android/picsart/profile/activity/GalleryItemShowActivity.getSimpleName()).append(" - ").toString();
    private aa b;

    public GalleryItemShowActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (b != null)
        {
            b.onActivityResult(i, j, intent);
        }
    }

    public void onBackPressed()
    {
        try
        {
            if (b != null)
            {
                b.c();
            }
            finishActivity(4549);
        }
        catch (Exception exception)
        {
            d.a(a, exception);
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        supportRequestWindowFeature(9);
        m.b(this);
        setContentView(0x7f030126);
        bundle = getFragmentManager();
        FragmentTransaction fragmenttransaction = bundle.beginTransaction();
        b = (aa)bundle.findFragmentByTag("gallery_item_show_fragment_tag_activity");
        if (b == null)
        {
            b = new aa();
            fragmenttransaction.add(0x7f1002a3, b, "gallery_item_show_fragment_tag_activity");
        } else
        {
            fragmenttransaction.show(b);
        }
        fragmenttransaction.commit();
    }

}
