// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.fragment.m;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.activity.AdBaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.util.c;

public class FreeCropActivity extends AdBaseActivity
{

    public static Bitmap a;
    private static Bitmap b;

    public FreeCropActivity()
    {
    }

    public static Intent a(Context context, Bitmap bitmap, EditingData editingdata)
    {
        context = new Intent(context, com/socialin/android/photo/freecrop/FreeCropActivity);
        if (editingdata != null)
        {
            context.putExtra("editing_data", editingdata);
        }
        b = bitmap;
        return context;
    }

    protected ViewGroup getAdLayout()
    {
        return (RelativeLayout)findViewById(0x7f100128);
    }

    public void onBackPressed()
    {
        m m1 = (m)getFragmentManager().findFragmentByTag("FreeCropFragment");
        if (m1 != null)
        {
            AnalyticUtils.getInstance(m1.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolFreeCropCloseEvent(m1.c.a, "back", (int)m1.a.d()));
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030024);
        Log.e("ex1", "FreeCrop Activity onCreate");
        Object obj = getFragmentManager();
        if (((FragmentManager) (obj)).findFragmentByTag("FreeCropFragment") == null)
        {
            bundle = new m();
            if (b != null)
            {
                bundle.b = c.b(b, android.graphics.Bitmap.Config.ARGB_8888);
                bundle.a(((m) (bundle)).b, null);
            }
            Intent intent = getIntent();
            if (intent.hasExtra("editing_data"))
            {
                bundle.c = (EditingData)intent.getParcelableExtra("editing_data");
            }
            bundle.setRetainInstance(true);
            obj = ((FragmentManager) (obj)).beginTransaction();
            ((FragmentTransaction) (obj)).replace(0x7f100145, bundle, "FreeCropFragment");
            ((FragmentTransaction) (obj)).commit();
            b = null;
        }
        initAd();
    }
}
