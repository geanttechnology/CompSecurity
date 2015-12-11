// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.app.Activity;
import android.content.res.Resources;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.app.f;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.ProgressBar;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.util.al;
import com.target.ui.view.ObservableScrollWebView;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.fragment.webview:
//            a, b

public abstract class TargetBaseWebViewFragment extends BaseNavigationFragment
    implements com.target.ui.fragment.webview.a
{
    private class a
        implements com.target.ui.view.common.c
    {

        final TargetBaseWebViewFragment this$0;

        public void A_()
        {
            while (TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this) == null || k()) 
            {
                return;
            }
            u();
        }

        private a()
        {
            this$0 = TargetBaseWebViewFragment.this;
            super();
        }

    }

    class b extends WebChromeClient
    {

        final TargetBaseWebViewFragment this$0;

        public void onProgressChanged(WebView webview, int i1)
        {
            if (i1 < 100)
            {
                TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).progressBar.setProgress(i1);
            }
        }

        b()
        {
            this$0 = TargetBaseWebViewFragment.this;
            super();
        }
    }

    protected class c extends com.target.ui.fragment.webview.b
    {

        private boolean mIsError;
        final TargetBaseWebViewFragment this$0;

        private void a(int i1)
        {
            mIsError = true;
            if (i1 == -2)
            {
                d.c(TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this)).a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            } else
            {
                d.c(TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this)).a("", getString(0x7f0902f9), true);
            }
            s();
        }

        public void a()
        {
            mIsError = false;
        }

        public void onPageFinished(WebView webview, String s1)
        {
            if (j())
            {
                TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).progressBar.setProgress(100);
            }
            if (!mIsError)
            {
                TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this, webview);
                l();
            } else
            {
                s();
            }
            super.onPageFinished(webview, s1);
        }

        public void onReceivedError(WebView webview, int i1, String s1, String s2)
        {
            super.onReceivedError(webview, i1, s1, s2);
            a(i1);
        }

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            a(sslerror.getPrimaryError());
        }

        public c()
        {
            this$0 = TargetBaseWebViewFragment.this;
            super();
            mIsError = false;
        }
    }

    private class d
    {

        private TargetErrorView errorContainer;
        protected ProgressBar progressBar;
        private View progressContainer;
        final TargetBaseWebViewFragment this$0;
        protected ObservableScrollWebView webView;
        private View webViewContainer;

        static View a(d d1)
        {
            return d1.webViewContainer;
        }

        static View b(d d1)
        {
            return d1.progressContainer;
        }

        static TargetErrorView c(d d1)
        {
            return d1.errorContainer;
        }

        public d(View view)
        {
            this$0 = TargetBaseWebViewFragment.this;
            super();
            progressContainer = view.findViewById(TargetBaseWebViewFragment.this.c());
            webViewContainer = view.findViewById(TargetBaseWebViewFragment.this.b());
            errorContainer = (TargetErrorView)view.findViewById(d());
            progressBar = (ProgressBar)view.findViewById(f());
            webView = (ObservableScrollWebView)view.findViewById(e());
        }
    }


    public static final int CACHE_DEFAULT = -1;
    public static final int CACHE_DISABLE = 2;
    private static final String KEY_WEB_SAVED_STATE = "KEY_WEB_SAVED_STATE";
    private static final int MAX_PROGRESS = 100;
    private static final String SCROLLING_PADDING_CORRECTION_FORMAT = "javascript:document.body.style.paddingTop=\"%spx\"; void 0";
    public static final String TAG = com/target/ui/fragment/webview/TargetBaseWebViewFragment.getSimpleName();
    private Bundle mSavedWebViewState;
    private com.target.ui.e.f mScrollingTabCoordinator;
    private d mViews;
    private c mWebViewClient;

    public TargetBaseWebViewFragment()
    {
    }

    static com.target.ui.e.f a(TargetBaseWebViewFragment targetbasewebviewfragment)
    {
        return targetbasewebviewfragment.mScrollingTabCoordinator;
    }

    private void a(WebView webview)
    {
        if (mScrollingTabCoordinator != null)
        {
            float f1 = getActivity().getResources().getDisplayMetrics().density;
            webview.loadUrl(String.format("javascript:document.body.style.paddingTop=\"%spx\"; void 0", new Object[] {
                Integer.valueOf(Math.round((float)mScrollingTabCoordinator.e() / f1))
            }));
        }
    }

    static void a(TargetBaseWebViewFragment targetbasewebviewfragment, WebView webview)
    {
        targetbasewebviewfragment.a(webview);
    }

    static d b(TargetBaseWebViewFragment targetbasewebviewfragment)
    {
        return targetbasewebviewfragment.mViews;
    }

    private void n()
    {
        mViews.webView.onPause();
    }

    private Bundle o()
    {
        Bundle bundle = v();
        mViews.webView.setWebChromeClient(null);
        mViews.webView.setWebViewClient(null);
        mViews.webView.clearCache(true);
        WebViewDatabase.getInstance(getActivity()).clearFormData();
        mViews.webView.destroy();
        mViews.webView = null;
        return bundle;
    }

    private Bundle v()
    {
        Bundle bundle = new Bundle();
        mViews.webView.saveState(bundle);
        return bundle;
    }

    private void w()
    {
        Object obj = getView();
        if (obj == null)
        {
            throw new IllegalStateException("Content view not yet created");
        }
        mViews = new d(((View) (obj)));
        mWebViewClient = g();
        obj = new b();
        mViews.webView.setWebViewClient(mWebViewClient);
        mViews.webView.setWebChromeClient(((WebChromeClient) (obj)));
        mViews.webView.setBackgroundColor(0);
        mViews.webView.setLayerType(1, null);
        obj = mViews.webView.getSettings();
        ((WebSettings) (obj)).setSaveFormData(false);
        ((WebSettings) (obj)).setSavePassword(false);
        ((WebSettings) (obj)).setJavaScriptEnabled(true);
        ((WebSettings) (obj)).setCacheMode(h());
        if (i())
        {
            mViews.webView.setOnKeyListener(new android.view.View.OnKeyListener() {

                final TargetBaseWebViewFragment this$0;

                public boolean onKey(View view, int i1, KeyEvent keyevent)
                {
                    if (i1 == 4 && keyevent.getAction() == 1 && TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).webView.canGoBack())
                    {
                        TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).webView.goBack();
                        return true;
                    } else
                    {
                        return false;
                    }
                }

            
            {
                this$0 = TargetBaseWebViewFragment.this;
                super();
            }
            });
        }
        x();
    }

    private void x()
    {
        d.c(mViews).setClickListener(new a());
    }

    private void y()
    {
        d.c(mViews).setClickListener(null);
    }

    private void z()
    {
        if (j())
        {
            t();
        }
    }

    public void a(com.target.ui.view.common.b.a a1, boolean flag)
    {
        d.c(mViews).a(a1, flag);
        s();
    }

    public void c(int i1)
    {
        d(getString(i1));
    }

    public void d(String s1)
    {
        d.c(mViews).a("", s1, false);
        s();
    }

    protected final void e(String s1)
    {
        if (mViews == null)
        {
            throw new IllegalStateException("web views are not yet created");
        } else
        {
            z();
            mWebViewClient.a();
            mViews.webView.loadUrl(s1);
            return;
        }
    }

    protected c g()
    {
        return new c();
    }

    protected int h()
    {
        return -1;
    }

    protected boolean i()
    {
        return false;
    }

    protected boolean j()
    {
        return true;
    }

    protected boolean k()
    {
        return false;
    }

    public void l()
    {
        al.a(new View[] {
            d.b(mViews), d.c(mViews)
        });
        al.b(new View[] {
            d.a(mViews), mViews.webView
        });
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        activity = getParentFragment();
        if (activity instanceof com.target.ui.e.f)
        {
            mScrollingTabCoordinator = (com.target.ui.e.f)activity;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle != null)
        {
            mSavedWebViewState = bundle.getBundle("KEY_WEB_SAVED_STATE");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(a(), null);
    }

    public void onDestroy()
    {
        mSavedWebViewState = null;
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (mViews.webView != null)
        {
            ((ViewGroup)d.a(mViews)).removeView(mViews.webView);
            mSavedWebViewState = o();
        }
        y();
        mViews = null;
        super.onDestroyView();
    }

    public void onDetach()
    {
        super.onDetach();
        mScrollingTabCoordinator = null;
    }

    public void onPause()
    {
        super.onPause();
        n();
    }

    public void onResume()
    {
        r();
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mViews != null && mViews.webView != null)
        {
            mSavedWebViewState = v();
        }
        bundle.putBundle("KEY_WEB_SAVED_STATE", mSavedWebViewState);
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        w();
        if (mSavedWebViewState != null)
        {
            mViews.webView.restoreState(mSavedWebViewState);
        }
        mViews.webView.setOnScrollListener(new com.target.ui.view.ObservableScrollWebView.a() {

            final TargetBaseWebViewFragment this$0;

            public void a()
            {
                if (TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this) == null)
                {
                    return;
                } else
                {
                    TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this).f();
                    return;
                }
            }

            public void a(int i1, int j1)
            {
                if (TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this) == null)
                {
                    return;
                } else
                {
                    TargetBaseWebViewFragment.a(TargetBaseWebViewFragment.this).b(j1);
                    return;
                }
            }

            
            {
                this$0 = TargetBaseWebViewFragment.this;
                super();
            }
        });
    }

    public void p()
    {
        if (mViews.webView != null)
        {
            mViews.webView.requestFocus();
        }
    }

    public boolean q()
    {
        return mSavedWebViewState != null;
    }

    protected void r()
    {
        p();
        mViews.webView.onResume();
    }

    public void s()
    {
        al.a(new View[] {
            d.b(mViews), d.a(mViews)
        });
        al.b(new View[] {
            d.c(mViews)
        });
    }

    public void t()
    {
        al.a(new View[] {
            d.c(mViews), d.a(mViews)
        });
        al.b(new View[] {
            d.b(mViews), mViews.progressBar
        });
    }

    protected final void u()
    {
        mWebViewClient.a();
        mViews.webView.reload();
    }

}
