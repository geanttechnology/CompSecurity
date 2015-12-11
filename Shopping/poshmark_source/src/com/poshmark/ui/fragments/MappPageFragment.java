// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gson.reflect.TypeToken;
import com.poshmark.application.PMApplication;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.ExternalAppUtils;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.UIThreadTask;
import com.poshmark.webcommands.WebCommand;
import com.poshmark.webcommands.WebCommandsManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class MappPageFragment extends PMFragment
{
    public class JSInterface
    {

        Context mContext;
        final MappPageFragment this$0;

        public void executeCommand(String s)
        {
            commandsManager.launchWebCommand(s);
            s = new UIThreadTask((PMActivity)getActivity());
            s.setCallback(new com.poshmark.utils.UIThreadTask.Callback() {

                final JSInterface this$1;

                public void runOnUIThread(Object obj)
                {
                    webView.loadUrl("javascript:gp_command.queue.ready=true;");
                }

            
            {
                this$1 = JSInterface.this;
                super();
            }
            });
            s.execute(null);
        }

        JSInterface(Context context)
        {
            this$0 = MappPageFragment.this;
            super();
            mContext = context;
        }
    }


    public static final String bundleLearnMoreURL = "/mapp/bundles_help";
    public static final String externalLibrariesURL = "/mapp/external_libraries";
    public static final String feePolicyURL = "/mapp/fee_policy";
    public static final String findPeopleContactsURL = "/mapp/find_people/contacts";
    public static final String nwtPolicyURL = "/mapp/nwt_policy";
    public static final String privacyPolicyURL = "/mapp/privacy_policy";
    public static final String termsAndConditionsURL = "/mapp/terms_and_conditions";
    List actionbarButtonCommands;
    String authority;
    boolean bShowRefreshButton;
    WebCommandsManager commandsManager;
    String lastPathSegment;
    boolean pageLoadComplete;
    String pageName;
    String path;
    boolean pendingCommandResult;
    int savedRequestCode;
    int savedResultCode;
    Intent savedResultData;
    String title;
    String url;
    WebView webView;

    public MappPageFragment()
    {
        webView = null;
        url = null;
        bShowRefreshButton = false;
        title = null;
        pageLoadComplete = false;
        actionbarButtonCommands = new ArrayList();
        pendingCommandResult = false;
    }

    private void setupWebClient()
    {
        webView.setWebViewClient(new WebViewClient() {

            final MappPageFragment this$0;

            public void onPageFinished(WebView webview, String s)
            {
                loadComplete(webview);
            }

            public void onReceivedError(WebView webview, int i, String s, String s1)
            {
                if (i != 302);
            }

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                sslerrorhandler.proceed();
            }

            public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
            {
                return null;
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                if (s == null)
                {
                    return false;
                }
                if (s.startsWith("market://"))
                {
                    webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                    return true;
                }
                if (s.startsWith("mailto:"))
                {
                    ExternalAppUtils.showEmailClientForURL(getActivity(), s);
                    return true;
                } else
                {
                    webview.addJavascriptInterface(new JSInterface(getActivity()), "AndroidInterface");
                    return false;
                }
            }

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {

            final MappPageFragment this$0;

            public boolean onConsoleMessage(ConsoleMessage consolemessage)
            {
                Log.d("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
                return true;
            }

            public void onReceivedTitle(WebView webview, String s)
            {
                super.onReceivedTitle(webview, s);
                if (s != null && s.length() > 0 && title == null)
                {
                    title = s;
                    if (getUserVisibleHint())
                    {
                        setTitle(title);
                    }
                }
            }

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSInterface(getActivity()), "AndroidInterface");
    }

    public void addActionBarButtonCommand(WebCommand webcommand)
    {
        actionbarButtonCommands.add(webcommand);
    }

    public void fireJSCallback(String s)
    {
        webView.loadUrl((new StringBuilder()).append("javascript:").append(Uri.decode(s)).toString());
    }

    public String getLastPathSegment()
    {
        return lastPathSegment;
    }

    public String getPageName()
    {
        return pageName;
    }

    public String getURL()
    {
        return url;
    }

    public String getUrlAuthority()
    {
        return authority;
    }

    public String getUrlPath()
    {
        return path;
    }

    public boolean handleBack()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
            webView.clearHistory();
            return true;
        } else
        {
            return false;
        }
    }

    public void launchWebView(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("URL", s);
        bundle.putString("ANALYTICS_PAGE_NAME", s1);
        ((PMActivity)getActivity()).replaceFragment(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
    }

    protected void loadComplete(WebView webview)
    {
        pageLoadComplete = true;
        hideProgressDialog();
        if (pendingCommandResult)
        {
            pendingCommandResult = false;
            commandsManager.handleCommandResult(savedRequestCode, savedResultCode, savedResultData);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        Log.d("PM Callback", "OnActivityCreated");
        CookieManager cookiemanager;
        if (bundle == null)
        {
            actionbarButtonCommands = new ArrayList();
        } else
        {
            title = bundle.getString("MAPP_PAGE_TITLE");
        }
        cookiemanager = CookieManager.getInstance();
        webView = (WebView)getView().findViewById(0x7f0c0318);
        setupWebClient();
        if (!cookiemanager.hasCookies())
        {
            Log.d("PMLogging", "No Cookies");
            PMApplication.getApplicationObject().setCookieInJar();
        }
        if (bundle != null)
        {
            webView.restoreState(bundle);
            return;
        } else
        {
            webView.loadUrl(url);
            showProgressDialogWithMessage(getString(0x7f060190));
            return;
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (pageLoadComplete)
        {
            commandsManager.handleCommandResult(i, j, intent);
            return;
        } else
        {
            savedRequestCode = i;
            savedResultCode = j;
            savedResultData = intent;
            pendingCommandResult = true;
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.d("PM Callback", "onCreate");
        url = getArguments().getString("URL");
        bShowRefreshButton = getArguments().getBoolean("SHOW_REFRESH", false);
        title = getArguments().getString("TITLE");
        Uri uri = Uri.parse(url);
        authority = uri.getEncodedAuthority();
        path = uri.getEncodedPath();
        lastPathSegment = uri.getLastPathSegment();
        pageName = uri.getQueryParameter("pageName");
        commandsManager = new WebCommandsManager((PMActivity)getActivity(), this);
        if (bundle != null)
        {
            boolean flag = bundle.getBoolean("VISIBILITY_HINT");
            setUserVisibleHint(flag);
            if (!flag)
            {
                bundle = getActivity().getSupportFragmentManager().beginTransaction();
                bundle.hide(this);
                bundle.commit();
            } else
            {
                Object obj = bundle.getString("LIST_OF_PENDING_COMMANDS");
                if (obj != null)
                {
                    obj = (HashMap)StringUtils.fromJson(((String) (obj)), new TypeToken() {

                        final MappPageFragment this$0;

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
                    });
                    commandsManager.setPendingCommandsMap(((Map) (obj)));
                    commandsManager.reAttachHandlersToPendingCommands();
                }
                bundle = bundle.getString("LIST_OF_BUTTON_COMMANDS");
                if (bundle != null)
                {
                    Log.d("Mapp actions", bundle);
                    actionbarButtonCommands = (List)StringUtils.fromJson(bundle, new TypeToken() {

                        final MappPageFragment this$0;

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
                    });
                    return;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        Log.d("PM Callback", "onCreateView");
        return layoutinflater.inflate(0x7f0300d2, viewgroup, false);
    }

    public void onDestroy()
    {
        hideProgressDialog();
        super.onDestroy();
    }

    public void onHiddenChanged(boolean flag)
    {
        if (title != null && !flag)
        {
            setupActionBar();
            setTitle(title);
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (actionbarButtonCommands != null)
        {
            Object obj = (new TypeToken() {

                final MappPageFragment this$0;

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
            }).getType();
            obj = StringUtils.toJson(actionbarButtonCommands, ((java.lang.reflect.Type) (obj)));
            bundle.putString("LIST_OF_BUTTON_COMMANDS", ((String) (obj)));
            actionbarButtonCommands = (List)StringUtils.fromJson(((String) (obj)), new TypeToken() {

                final MappPageFragment this$0;

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
            });
        }
        Map map = commandsManager.getPendingCommands();
        if (map != null && !map.isEmpty())
        {
            java.lang.reflect.Type type = (new TypeToken() {

                final MappPageFragment this$0;

            
            {
                this$0 = MappPageFragment.this;
                super();
            }
            }).getType();
            bundle.putString("LIST_OF_PENDING_COMMANDS", StringUtils.toJson(commandsManager.getPendingCommands(), type));
        }
        if (title != null)
        {
            java.util.UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, title);
            bundle.putParcelable("MAPP_PAGE_TITLE", new ParcelUuid(uuid));
            bundle.putString("MAPP_PAGE_TITLE", title);
        }
        bundle.putBoolean("VISIBILITY_HINT", getUserVisibleHint());
        webView.saveState(bundle);
    }

    public void reload()
    {
        showProgressDialogWithMessage(getString(0x7f060190));
        webView.reload();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = getArguments().getString("ANALYTICS_PAGE_NAME", "mapp_screen");
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (title != null)
        {
            setTitle(title);
        } else
        {
            setTitle("");
        }
        if (!actionbarButtonCommands.isEmpty())
        {
            for (int i = 0; i < actionbarButtonCommands.size(); i++)
            {
                WebCommand webcommand = (WebCommand)actionbarButtonCommands.get(i);
                actionbarButtonCommands.remove(i);
                commandsManager.fireCommand(webcommand);
            }

        }
    }
}
