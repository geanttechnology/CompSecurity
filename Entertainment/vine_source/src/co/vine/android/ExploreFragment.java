// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import co.vine.android.client.VineAPI;
import co.vine.android.provider.SettingsManager;
import co.vine.android.util.BuildUtil;
import co.vine.android.util.Util;
import co.vine.android.widget.OnTabChangedListener;
import co.vine.android.widget.ScrollDeltaScrollView;
import com.edisonwang.android.slog.SLog;
import com.twitter.android.widget.TopScrollable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, HomeTabActivity, ExploreChannelsActivity, ExploreVideoListActivity, 
//            SearchActivity

public class ExploreFragment extends BaseControllerFragment
    implements OnTabChangedListener, TopScrollable, co.vine.android.widget.ScrollDeltaScrollView.ScrollDeltaListener
{
    class VineVideoListWebViewClient extends WebViewClient
    {

        final ExploreFragment this$0;

        public void onPageFinished(WebView webview, String s)
        {
            mEmpty.setVisibility(8);
            webview.scrollTo(0, 0);
        }

        public void onReceivedError(WebView webview, int i, String s, String s1)
        {
            SLog.dWithTag("ExploreFragment", (new StringBuilder()).append("WebViewClient errorCode=").append(i).toString());
            webview.setVisibility(8);
            if (mProgressContainer != null)
            {
                mProgressContainer.setVisibility(8);
            }
            if (mEmpty != null)
            {
                mEmpty.setVisibility(0);
            }
            if (mSadface != null)
            {
                mSadfaceContainer.setVisibility(0);
            }
            if (mEmptyText != null)
            {
                mEmptyText.setVisibility(0);
            }
            if (i == -2)
            {
                webview = getString(0x7f0e00d2);
            } else
            {
                webview = getString(0x7f0e00d1);
            }
            mEmptyText.setText(webview);
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            webview = Uri.parse(s);
            if (webview.getScheme().equals("vine"))
            {
                s = new Intent();
                s.setData(webview);
                if ("channels".equals(webview.getHost()))
                {
                    s.setClass(getActivity(), co/vine/android/ExploreChannelsActivity);
                } else
                {
                    s.setClass(getActivity(), co/vine/android/ExploreVideoListActivity);
                }
                startActivity(s);
                return true;
            } else
            {
                return false;
            }
        }

        VineVideoListWebViewClient()
        {
            this$0 = ExploreFragment.this;
            super();
        }
    }


    public static final String ARG_TAKE_FOCUS = "take_focus";
    private static final boolean LOGGABLE = Log.isLoggable("ExploreFragment", 3);
    private static final String PARAM_EDITION = "ed";
    private static final String PARAM_MODEL = "model";
    private static final String PARAM_OS = "os";
    private static final String PARAM_VERSION = "v";
    private static final String PREF_LAST_REFRESH_TIME = "last_explore";
    private static final long REFRESH_INTERVAL = 0xdbba0L;
    private static final String TAG = "ExploreFragment";
    private static final String VALUE_OS = "android";
    private static final String VALUE_UNDEFINED = "undefined";
    private BroadcastReceiver mConnectivityReceiver;
    private View mEmpty;
    private TextView mEmptyText;
    private String mExploreUrl;
    private SharedPreferences mPrefs;
    private RelativeLayout mProgressContainer;
    private ImageView mSadface;
    private View mSadfaceContainer;
    private WebView mWebView;

    public ExploreFragment()
    {
        mConnectivityReceiver = new BroadcastReceiver() {

            final ExploreFragment this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (context != null && context.isConnected())
                {
                    reloadWebView();
                }
            }

            
            {
                this$0 = ExploreFragment.this;
                super();
            }
        };
    }

    private String getExploreUrl()
    {
        String s;
        String s1;
        ArrayList arraylist;
        try
        {
            s = Util.getVersionName(getActivity());
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception = "undefined";
        }
        s1 = String.format(Locale.US, "%s_%s", new Object[] {
            Build.MANUFACTURER, Build.MODEL
        });
        arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("model", s1.replaceAll("\\s+", "-")));
        arraylist.add(new BasicNameValuePair("v", s));
        arraylist.add(new BasicNameValuePair("os", "android"));
        arraylist.add(new BasicNameValuePair("ed", SettingsManager.getEdition(getActivity())));
        return (new StringBuilder()).append(mExploreUrl).append("?").append(URLEncodedUtils.format(arraylist, "UTF-8")).toString();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        mExploreUrl = VineAPI.getInstance(getActivity()).getExploreUrl();
        if (getArguments().getBoolean("take_focus", false))
        {
            ((HomeTabActivity)getActivity()).showPage(2, this);
            if (BuildUtil.isLogsOn())
            {
                Log.d("ExploreFragment", "Explore tab took focus.");
            }
        }
        reloadWebView();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030039, viewgroup, false);
        mEmpty = layoutinflater.findViewById(0x7f0a00e2);
        mEmptyText = (TextView)layoutinflater.findViewById(0x7f0a007f);
        mProgressContainer = (RelativeLayout)layoutinflater.findViewById(0x7f0a00c5);
        mSadfaceContainer = layoutinflater.findViewById(0x7f0a007e);
        mSadface = (ImageView)layoutinflater.findViewById(0x7f0a00e3);
        mWebView = (WebView)layoutinflater.findViewById(0x7f0a00e1);
        layoutinflater.findViewById(0x7f0a00e4).setOnClickListener(new android.view.View.OnClickListener() {

            final ExploreFragment this$0;

            public void onClick(View view)
            {
                startActivity(new Intent(getActivity(), co/vine/android/SearchActivity));
            }

            
            {
                this$0 = ExploreFragment.this;
                super();
            }
        });
        ((ScrollDeltaScrollView)layoutinflater.findViewById(0x7f0a00e0)).setScrollDeltaListener(this);
        mPrefs = Util.getDefaultSharedPrefs(getActivity());
        return layoutinflater;
    }

    public void onDestroy()
    {
        ViewGroup viewgroup = (ViewGroup)mWebView.getParent();
        viewgroup.removeViewAt(viewgroup.indexOfChild(mWebView));
        mWebView.destroy();
        super.onDestroy();
    }

    public void onMoveAway(int i)
    {
    }

    public void onMoveTo(int i)
    {
        long l = mPrefs.getLong("last_explore", 0L);
        android.content.SharedPreferences.Editor editor = mPrefs.edit();
        long l1 = System.currentTimeMillis();
        if (editor != null)
        {
            if (l > 0L && 0xdbba0L + l < l1)
            {
                reloadWebView();
                editor.putLong("last_explore", l1).commit();
            } else
            if (l <= 0L)
            {
                editor.putLong("last_explore", l1).commit();
                return;
            }
        }
    }

    public void onPause()
    {
        super.onPause();
        getActivity().unregisterReceiver(mConnectivityReceiver);
    }

    public void onResume()
    {
        super.onResume();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentfilter.addAction("abort_all_requests");
        getActivity().registerReceiver(mConnectivityReceiver, intentfilter, "co.vine.android.BROADCAST", null);
    }

    public void onScroll(int i)
    {
        ((HomeTabActivity)getActivity()).onScroll(i);
    }

    public void reloadWebView()
    {
        WebView webview = mWebView;
        if (webview != null)
        {
            webview.setVisibility(0);
            mSadfaceContainer.setVisibility(8);
            webview.setWebViewClient(new VineVideoListWebViewClient());
            webview.setHorizontalScrollBarEnabled(false);
            Object obj = webview.getSettings();
            Object obj1;
            try
            {
                ((WebSettings) (obj)).setJavaScriptEnabled(true);
            }
            catch (Exception exception) { }
            ((WebSettings) (obj)).setCacheMode(2);
            obj = new HashMap(1);
            obj1 = Util.getLocale();
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                ((Map) (obj)).put("Accept-Language", obj1);
            }
            obj1 = VineAPI.getInstance(getActivity());
            ((Map) (obj)).put("X-Vine-Client", ((VineAPI) (obj1)).getVineClientHeader());
            if (!BuildUtil.isProduction())
            {
                ((Map) (obj)).put("X-Vine-Auth", ((VineAPI) (obj1)).getAuthHeaderSecret());
            }
            obj1 = getExploreUrl();
            if (BuildUtil.isLogsOn())
            {
                Log.d("ExploreFragment", (new StringBuilder()).append("Accessing explore url: ").append(((String) (obj1))).toString());
            }
            webview.loadUrl(((String) (obj1)), ((Map) (obj)));
        }
    }

    public boolean scrollTop()
    {
        boolean flag = false;
        if (mWebView != null)
        {
            mWebView.scrollTo(0, 0);
            flag = true;
        }
        return flag;
    }






}
