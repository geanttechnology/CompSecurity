// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.mobile.mash.MASHWebChromeClient;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.now.mash.NavManager;
import com.amazon.now.mash.interception.UrlIntercepter;
import java.util.Arrays;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.web:
//            NowWebView, WebViewSubscriber, NowWebViewClient

public class NowWebFragment extends Fragment
{
    protected static class FragmentWebViewClient extends NowWebViewClient
    {

        private final NowWebFragment mWebFragment;

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            if (mWebFragment.getSubscriber() != null)
            {
                mWebFragment.getSubscriber().onPageFinished();
            }
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            if (mWebFragment.getSubscriber() != null)
            {
                mWebFragment.getSubscriber().onPageStarted();
            }
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            super.onReceivedError(webview, i, s, s1);
            if (mWebFragment.getSubscriber() != null)
            {
                mWebFragment.getSubscriber().onPageError();
            }
        }

        public FragmentWebViewClient(NowWebFragment nowwebfragment, CordovaInterface cordovainterface, MASHWebView mashwebview, MASHNavDelegate mashnavdelegate, MASHUrlIntercepter mashurlintercepter)
        {
            super(cordovainterface, mashwebview, mashnavdelegate, mashurlintercepter);
            mWebFragment = nowwebfragment;
        }
    }

    public static interface OnWebViewReadyListener
    {

        public abstract void onWebViewReady(NowWebView nowwebview);
    }


    private NowWebView mCurrentWebView;
    private boolean mIsFirstOnResume;
    private String mMethod;
    private NowWebView mNextWebView;
    private OnWebViewReadyListener mOnWebViewReadyListener;
    private byte mPostParameters[];
    private boolean mShouldDestroyWebView;
    private WebViewSubscriber mSubscriber;
    private String mUrl;

    public NowWebFragment()
    {
        mShouldDestroyWebView = true;
        mIsFirstOnResume = true;
    }

    public static NowWebFragment add(FragmentManager fragmentmanager, int i)
    {
        if (fragmentmanager.findFragmentById(i) != null)
        {
            return (NowWebFragment)fragmentmanager.findFragmentById(i);
        } else
        {
            NowWebFragment nowwebfragment = new NowWebFragment();
            fragmentmanager.beginTransaction().add(i, nowwebfragment).commit();
            return nowwebfragment;
        }
    }

    private void destroyCurrentWebView()
    {
        mCurrentWebView.setWebChromeClient(new WebChromeClient());
        mCurrentWebView.setWebViewClient(new WebViewClient());
        mCurrentWebView.destroy();
        mCurrentWebView = null;
    }

    public void attach()
    {
        getFragmentManager().beginTransaction().attach(this).commit();
    }

    public void detach()
    {
        getFragmentManager().beginTransaction().detach(this).commitAllowingStateLoss();
    }

    public OnWebViewReadyListener getOnWebViewReadyListener()
    {
        return mOnWebViewReadyListener;
    }

    public boolean getShouldDestroyWebView()
    {
        return mShouldDestroyWebView;
    }

    public WebViewSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public NowWebView getWebView()
    {
        return mCurrentWebView;
    }

    public void loadUrl(String s)
    {
        loadUrl(s, "GET", null);
    }

    public void loadUrl(String s, String s1, byte abyte0[])
    {
        if (mCurrentWebView == null)
        {
            mUrl = s;
            mMethod = s1;
            if (abyte0 != null)
            {
                mPostParameters = Arrays.copyOf(abyte0, abyte0.length);
                return;
            } else
            {
                mPostParameters = null;
                return;
            }
        }
        if (s1.equalsIgnoreCase("POST"))
        {
            mCurrentWebView.postUrl(s, abyte0);
            return;
        } else
        {
            mCurrentWebView.loadUrl(s);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        onWebViewReady();
        if (mOnWebViewReadyListener != null)
        {
            mOnWebViewReadyListener.onWebViewReady(mCurrentWebView);
        }
        if (mUrl != null && mMethod != null)
        {
            loadUrl(mUrl, mMethod, mPostParameters);
            mUrl = null;
            mMethod = null;
            mPostParameters = null;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mNextWebView != null)
        {
            if (mCurrentWebView != null && mShouldDestroyWebView)
            {
                destroyCurrentWebView();
            }
            mCurrentWebView = mNextWebView;
            mNextWebView = null;
        }
        if (mCurrentWebView == null)
        {
            mCurrentWebView = new NowWebView(getActivity());
        }
        if (bundle != null)
        {
            mCurrentWebView.restoreState(bundle);
        }
        return mCurrentWebView;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mCurrentWebView != null && mShouldDestroyWebView)
        {
            destroyCurrentWebView();
        }
        mOnWebViewReadyListener = null;
    }

    public void onPause()
    {
        super.onPause();
        mCurrentWebView.onPause();
        if (!getActivity().isFinishing())
        {
            loadUrl("javascript:if (window.P) { P.when('houdini-pause').execute(function(o) { o.pause(); }) }");
        }
    }

    public void onResume()
    {
        super.onResume();
        mCurrentWebView.onResume();
        if (mIsFirstOnResume)
        {
            mIsFirstOnResume = false;
            return;
        } else
        {
            loadUrl("javascript:if (window.P) { P.when('houdini-pause').execute(function(o) { o.resume(); }) }");
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mCurrentWebView.saveState(bundle);
    }

    protected void onWebViewReady()
    {
        mCurrentWebView.setWebViewClient(new FragmentWebViewClient(this, (CordovaInterface)getActivity(), mCurrentWebView, NavManager.getInstance(), new UrlIntercepter()));
        mCurrentWebView.setWebChromeClient(new MASHWebChromeClient((CordovaInterface)getActivity(), mCurrentWebView));
    }

    public void resetWebView()
    {
        if (mCurrentWebView != null)
        {
            destroyCurrentWebView();
        }
        mCurrentWebView = new NowWebView(getActivity());
    }

    public void setOnWebViewReadyListener(OnWebViewReadyListener onwebviewreadylistener)
    {
        mOnWebViewReadyListener = onwebviewreadylistener;
    }

    public void setShouldDestroyWebView(boolean flag)
    {
        mShouldDestroyWebView = flag;
    }

    public void setSubscriber(WebViewSubscriber webviewsubscriber)
    {
        mSubscriber = webviewsubscriber;
    }

    public void setWebView(NowWebView nowwebview)
    {
        mNextWebView = nowwebview;
    }
}
