// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Dialog;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ebay.mobile.activities.BaseDialogFragment;

public class DescriptionPreviewDialogFragment extends BaseDialogFragment
{

    protected static final String EXTRA_DESCRIPTION = "description";
    private WebView webview;

    public DescriptionPreviewDialogFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getDialog().setTitle(getResources().getString(0x7f07053c));
        webview = (WebView)getView().findViewById(0x7f100316);
        bundle = webview.getSettings();
        bundle.setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        bundle.setTextSize(android.webkit.WebSettings.TextSize.NORMAL);
        bundle.setLoadsImagesAutomatically(true);
        bundle.setJavaScriptEnabled(true);
        bundle.setJavaScriptCanOpenWindowsAutomatically(false);
        bundle.setSupportZoom(true);
        bundle.setBuiltInZoomControls(true);
        bundle.setDisplayZoomControls(false);
        webview.setFocusable(true);
        bundle = getArguments().getString("description");
        if (TextUtils.isEmpty(bundle))
        {
            webview.loadData("", "text/html", "utf-8");
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("<html><body>");
            stringbuilder.append(Uri.decode(bundle));
            stringbuilder.append("</body></html>");
            webview.loadDataWithBaseURL(null, stringbuilder.toString(), "text/html", "utf-8", null);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0301fd, null);
    }
}
