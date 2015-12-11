// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

// Referenced classes of package com.wishabi.flipp.app:
//            dl

public class e extends dl
{

    private String a;
    private WebView c;

    public e()
    {
    }

    public static Bundle a(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("SAVE_STATE_BARCODE_URL_KEY", s);
        return bundle;
    }

    public static e a(Bundle bundle)
    {
        e e1 = new e();
        e1.setArguments(bundle);
        return e1;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = getArguments();
        }
        if (bundle1 != null)
        {
            a = bundle1.getString("SAVE_STATE_BARCODE_URL_KEY");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        bundle = getActivity();
        if (bundle == null)
        {
            return null;
        }
        layoutinflater = layoutinflater.inflate(0x7f030005, viewgroup, false);
        if (layoutinflater == null)
        {
            return null;
        }
        viewgroup = (new StringBuilder("<html><img src=\"")).append(a).append("\" style=\"position:absolute; margin:auto; left:0; top:0; right:0; bottom:0; max-width: 100%; max-height: 100%;\"></html>").toString();
        c = (WebView)layoutinflater.findViewById(0x7f0b002d);
        c.loadData(viewgroup, "text/html", null);
        c.getSettings().setBuiltInZoomControls(true);
        c.getSettings().setDisplayZoomControls(false);
        c.setHorizontalScrollBarEnabled(false);
        c.setVerticalScrollBarEnabled(false);
        c.setOverScrollMode(2);
        b(bundle.getString(0x7f0e006b));
        if (getResources().getConfiguration().orientation == 2)
        {
            bundle.setRequestedOrientation(6);
        } else
        {
            bundle.setRequestedOrientation(7);
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            activity.setRequestedOrientation(4);
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            android.view.WindowManager.LayoutParams layoutparams = activity.getWindow().getAttributes();
            layoutparams.screenBrightness = -1F;
            activity.getWindow().setAttributes(layoutparams);
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        Activity activity = getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            android.view.WindowManager.LayoutParams layoutparams = activity.getWindow().getAttributes();
            layoutparams.screenBrightness = 1.0F;
            activity.getWindow().setAttributes(layoutparams);
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("SAVE_STATE_BARCODE_URL_KEY", a);
    }
}
