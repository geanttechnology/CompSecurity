// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class a extends com.cyberlink.youcammakeup.a
{

    public a()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        bundle.findViewById(0x7f0c0070).setOnClickListener(new android.view.View.OnClickListener() {

            final a a;

            public void onClick(View view)
            {
                a.dismiss();
            }

            
            {
                a = a.this;
                super();
            }
        });
        bundle = (WebView)bundle.findViewById(0x7f0c0073);
        bundle.setHorizontalScrollBarEnabled(false);
        bundle.loadUrl("file:///android_asset/license/Licenses.html");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030000, null);
    }
}
