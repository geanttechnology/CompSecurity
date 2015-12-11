// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.modules;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.k;
import android.support.v4.app.m;
import android.view.MenuItem;
import android.view.View;
import com.google.android.a.a.c;
import com.shazam.android.activities.a.a;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.fragment.e;
import com.shazam.android.fragment.musicdetails.modules.YoutubeVideoFragment;

public class VideoActivity extends AutoToolbarBaseAppCompatActivity
    implements e
{

    private View a;
    private View b;

    public VideoActivity()
    {
    }

    public static Intent a(Context context, String s, Uri uri)
    {
        context = new Intent(context, com/shazam/android/activities/modules/VideoActivity);
        context.putExtra("extraUrl", s);
        com.shazam.android.activities.a.a.a(context, uri);
        return context;
    }

    public void onBackPressed()
    {
label0:
        {
            Object obj = getSupportFragmentManager().a("tag_video_fragment");
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = (YoutubeVideoFragment)obj;
            }
            if (obj != null)
            {
                boolean flag;
                if (((YoutubeVideoFragment) (obj)).getArguments().getBoolean("arg_fullscreen", false))
                {
                    ((YoutubeVideoFragment) (obj)).a.b();
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    break label0;
                }
            }
            super.onBackPressed();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030033);
        a = findViewById(0x7f110120);
        b = findViewById(0x7f11011e);
        Object obj = getIntent().getStringExtra("extraUrl");
        b.setVisibility(8);
        a.setVisibility(8);
        bundle = getSupportFragmentManager();
        if (bundle.a("tag_video_fragment") == null)
        {
            obj = YoutubeVideoFragment.a(com.shazam.android.activities.a.a.a(getIntent()), ((String) (obj)));
            bundle.a().b(0x7f11011d, ((android.support.v4.app.Fragment) (obj)), "tag_video_fragment").b();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 16908332: 
            onBackPressed();
            break;
        }
        return true;
    }

    public final void t_()
    {
        k k1 = getSupportFragmentManager();
        android.support.v4.app.Fragment fragment = k1.a("tag_retry_fragment");
        if (fragment != null)
        {
            k1.a().a(fragment).a();
        }
        a.setVisibility(0);
        b.setVisibility(0);
    }
}
