// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebView, AmazonWebKitFactories, AmazonWebKitFactory

public class AmazonWebViewFragment extends Fragment
{

    private boolean mIsWebViewAvailable;
    private AmazonWebView mWebView;

    public AmazonWebViewFragment()
    {
    }

    public AmazonWebView getWebView()
    {
        if (mIsWebViewAvailable)
        {
            return mWebView;
        } else
        {
            return null;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mWebView != null)
        {
            mWebView.destroy();
        }
        mWebView = AmazonWebKitFactories.getDefaultFactory().createWebView(getActivity(), 0, null, false);
        mIsWebViewAvailable = true;
        return mWebView;
    }

    public void onDestroy()
    {
        if (mWebView != null)
        {
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        mIsWebViewAvailable = false;
        super.onDestroyView();
    }

    public void onPause()
    {
        super.onPause();
        mWebView.onPause();
    }

    public void onResume()
    {
        mWebView.onResume();
        super.onResume();
    }
}
