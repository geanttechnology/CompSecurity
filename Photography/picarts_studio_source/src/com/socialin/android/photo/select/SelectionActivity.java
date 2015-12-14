// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.fragment.SelectionFragment;
import com.picsart.studio.utils.TimeCalculator;
import com.socialin.android.activity.BaseActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;

public class SelectionActivity extends BaseActivity
{

    public static Bitmap a;
    private static Bitmap b;

    public SelectionActivity()
    {
    }

    public static Intent a(Context context, Bitmap bitmap, EditingData editingdata)
    {
        context = new Intent(context, com/socialin/android/photo/select/SelectionActivity);
        if (editingdata != null)
        {
            context.putExtra("editing_data", editingdata);
        }
        b = bitmap;
        return context;
    }

    public void onBackPressed()
    {
        SelectionFragment selectionfragment = (SelectionFragment)getFragmentManager().findFragmentByTag("SelectionMainFragment");
        if (selectionfragment != null)
        {
            AnalyticUtils.getInstance(selectionfragment.getActivity()).track(new com.socialin.android.apiv3.events.EventsFactory.ToolSelectionCloseEvent(selectionfragment.d.a, "back", (int)selectionfragment.f.d()));
        }
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030027);
        Object obj = getFragmentManager();
        if (((FragmentManager) (obj)).findFragmentByTag("SelectionMainFragment") == null)
        {
            bundle = new SelectionFragment();
            if (b != null)
            {
                Bitmap bitmap = b;
                bundle.e = bitmap;
                if (((SelectionFragment) (bundle)).c)
                {
                    bundle.b(bitmap);
                }
            }
            Intent intent = getIntent();
            if (intent.hasExtra("editing_data"))
            {
                bundle.d = (EditingData)intent.getParcelableExtra("editing_data");
            }
            bundle.setRetainInstance(true);
            obj = ((FragmentManager) (obj)).beginTransaction();
            ((FragmentTransaction) (obj)).replace(0x7f100184, bundle, "SelectionMainFragment");
            ((FragmentTransaction) (obj)).commit();
            b = null;
        }
    }
}
