// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.AdMetadata;
import com.millennialmedia.internal.MMWebView;
import com.millennialmedia.internal.SizableStateManager;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.ViewUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            AdController

public class WebController extends AdController
{
    public static interface WebControllerListener
    {

        public abstract void attachFailed();

        public abstract void attachSucceeded();

        public abstract void initFailed();

        public abstract void initSucceeded();

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onCollapsed();

        public abstract void onExpanded();

        public abstract void onResize(int i, int j);

        public abstract void onResized(int i, int j, boolean flag);
    }


    private static final String TAG = com/millennialmedia/internal/adcontrollers/WebController.getSimpleName();
    private static final String searchTags[] = {
        "<SCRIPT", "<IMG", "<HTML", "<BODY", "<HEAD", "<A", "<DIV", "<SPAN", "<P", "<H1", 
        "<H2", "<H3", "<H4", "<H5", "<H6"
    };
    private volatile MMWebView mmWebView;
    private volatile SizableStateManager sizableStateManager;
    private WebControllerListener webControllerListener;

    public WebController()
    {
    }

    public WebController(final Context context, final boolean isInterstitial, final String adContent, final AdMetadata adMetadata, final WebControllerListener webControllerListener)
    {
        this.webControllerListener = webControllerListener;
        ThreadUtils.runOnUiThread(new Runnable() {

            final WebController this$0;
            final String val$adContent;
            final AdMetadata val$adMetadata;
            final Context val$context;
            final boolean val$isInterstitial;
            final WebControllerListener val$webControllerListener;

            public void run()
            {
                mmWebView = createWebView(context, isInterstitial, false, adMetadata, webControllerListener);
                mmWebView.setContent(adContent);
            }

            
            {
                this$0 = WebController.this;
                context = context1;
                isInterstitial = flag;
                adMetadata = admetadata;
                webControllerListener = webcontrollerlistener;
                adContent = s;
                super();
            }
        });
    }

    public void attach(final RelativeLayout containerLayout, final android.widget.RelativeLayout.LayoutParams layoutParams)
    {
        if (containerLayout == null)
        {
            webControllerListener.attachFailed();
            return;
        }
        if (!(containerLayout.getContext() instanceof Activity))
        {
            webControllerListener.attachFailed();
            return;
        } else
        {
            containerLayout.setOnClickListener(new android.view.View.OnClickListener() {

                final WebController this$0;

                public void onClick(View view)
                {
                    webControllerListener.onClicked();
                }

            
            {
                this$0 = WebController.this;
                super();
            }
            });
            ThreadUtils.runOnUiThread(new Runnable() {

                final WebController this$0;
                final RelativeLayout val$containerLayout;
                final android.widget.RelativeLayout.LayoutParams val$layoutParams;

                public void run()
                {
                    if (mmWebView == null)
                    {
                        MMLog.e(WebController.TAG, "MMWebView instance is null, unable to attach");
                        webControllerListener.attachFailed();
                        return;
                    } else
                    {
                        ViewUtils.attachView(containerLayout, mmWebView, layoutParams);
                        webControllerListener.attachSucceeded();
                        return;
                    }
                }

            
            {
                this$0 = WebController.this;
                containerLayout = relativelayout;
                layoutParams = layoutparams;
                super();
            }
            });
            return;
        }
    }

    public boolean canHandleContent(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        new JSONObject(s);
        return false;
        JSONException jsonexception;
        jsonexception;
        s = s.toUpperCase();
        String as[] = searchTags;
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            if (s.contains(as[i]))
            {
                return true;
            }
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    MMWebView createWebView(final Context context, final boolean isInterstitial, final boolean isTwoPart, final AdMetadata adMetadata, final WebControllerListener webControllerListener)
    {
        boolean flag;
        if (adMetadata != null && adMetadata.isTransparent() && isInterstitial)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new MMWebView(context, isInterstitial, flag, new com.millennialmedia.internal.MMWebView.MMWebViewListener() {

            final WebController this$0;
            final AdMetadata val$adMetadata;
            final Context val$context;
            final boolean val$isInterstitial;
            final boolean val$isTwoPart;
            final WebControllerListener val$webControllerListener;

            public void close()
            {
                if (sizableStateManager != null)
                {
                    sizableStateManager.close();
                }
                mmWebView.setBackgroundColor(-1);
            }

            public boolean expand(com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams)
            {
                SizableStateManager sizablestatemanager = getSizableStateManager();
                boolean flag1 = false;
                MMWebView mmwebview;
                if (TextUtils.isEmpty(expandparams.url))
                {
                    if (!isInterstitial)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    mmwebview = mmWebView;
                } else
                {
                    mmwebview = createWebView(context, false, true, adMetadata, webControllerListener);
                    mmwebview.setTwoPartExpand();
                    mmwebview.setVisibility(4);
                    loadTwoPartContentAsync(mmwebview, expandparams);
                }
                if (adMetadata != null && adMetadata.isTransparent())
                {
                    mmwebview.setBackgroundColor(0);
                    expandparams.transparent = true;
                }
                return sizablestatemanager.expand(mmwebview, expandparams, flag1);
            }

            public void onAdLeftApplication()
            {
                webControllerListener.onAdLeftApplication();
            }

            public void onClicked()
            {
                webControllerListener.onClicked();
            }

            public void onFailed()
            {
                if (!isTwoPart)
                {
                    webControllerListener.initFailed();
                }
            }

            public void onLoaded()
            {
                if (!isTwoPart)
                {
                    webControllerListener.initSucceeded();
                }
            }

            public void onReady()
            {
            }

            public boolean resize(com.millennialmedia.internal.SizableStateManager.ResizeParams resizeparams)
            {
                return getSizableStateManager().resize(mmWebView, resizeparams);
            }

            public void setOrientation(int i)
            {
                if (sizableStateManager != null)
                {
                    sizableStateManager.setOrientation(i);
                }
            }

            public void showCloseIndicator(boolean flag1)
            {
                if (sizableStateManager != null)
                {
                    sizableStateManager.showCloseIndicator(flag1);
                }
            }

            
            {
                this$0 = WebController.this;
                isTwoPart = flag;
                webControllerListener = webcontrollerlistener;
                isInterstitial = flag1;
                context = context1;
                adMetadata = admetadata;
                super();
            }
        });
    }

    SizableStateManager getSizableStateManager()
    {
        if (sizableStateManager == null)
        {
            sizableStateManager = new SizableStateManager(new com.millennialmedia.internal.SizableStateManager.SizableListener() {

                final WebController this$0;

                public void onCollapsed()
                {
                    mmWebView.setStateCollapsed();
                    webControllerListener.onCollapsed();
                    sizableStateManager = null;
                }

                public void onCollapsing()
                {
                    mmWebView.setStateResizing();
                }

                public void onExpandFailed()
                {
                    webControllerListener.attachFailed();
                }

                public void onExpanded()
                {
                    mmWebView.setStateExpanded();
                    webControllerListener.onExpanded();
                }

                public void onExpanding()
                {
                    mmWebView.setStateResizing();
                }

                public void onResized(int i, int j)
                {
                    mmWebView.setStateResized();
                    webControllerListener.onResized(i, j, false);
                }

                public void onResizing(int i, int j)
                {
                    mmWebView.setStateResizing();
                    webControllerListener.onResize(i, j);
                }

                public void onUnresized(int i, int j)
                {
                    mmWebView.setStateUnresized();
                    webControllerListener.onResized(i, j, true);
                    sizableStateManager = null;
                }

                public void onUnresizing(int i, int j)
                {
                    mmWebView.setStateResizing();
                }

            
            {
                this$0 = WebController.this;
                super();
            }
            });
        }
        return sizableStateManager;
    }

    void loadTwoPartContentAsync(MMWebView mmwebview, final com.millennialmedia.internal.SizableStateManager.ExpandParams expandParams)
    {
        WeakReference weakreference = new WeakReference(sizableStateManager);
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final WebController this$0;
            final com.millennialmedia.internal.SizableStateManager.ExpandParams val$expandParams;
            final WeakReference val$sizableStateManagerRef;
            final WeakReference val$twoPartWebViewRef;

            public void run()
            {
                sizableStateManager.showLoadingSpinner(expandParams);
                ThreadUtils.runOnUiThread(HttpUtils.getContentFromGetRequest(expandParams.url). new Runnable() {

                    final _cls7 this$1;
                    final com.millennialmedia.internal.utils.HttpUtils.Response val$response;

                    public void run()
                    {
                        MMWebView mmwebview = (MMWebView)twoPartWebViewRef.get();
                        if (mmwebview != null) goto _L2; else goto _L1
_L1:
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(WebController.TAG, "Expanded web view is no longer valid");
                        }
_L4:
                        return;
_L2:
                        SizableStateManager sizablestatemanager;
                        sizablestatemanager = (SizableStateManager)sizableStateManagerRef.get();
                        if (sizablestatemanager != null)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(WebController.TAG, "Sizing container is no longer valid");
                            return;
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                        if (!sizablestatemanager.isExpanded())
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(WebController.TAG, "Sizing container has been collapsed");
                                return;
                            }
                        } else
                        {
                            sizablestatemanager.hideLoadingSpinner(expandParams);
                            if (response != null && response.code == 200 && response.content != null)
                            {
                                mmwebview.setContent(response.content);
                            } else
                            {
                                MMLog.e(WebController.TAG, "Unable to retrieve expanded content");
                                sizablestatemanager.showCloseIndicator(true);
                            }
                            mmwebview.setVisibility(0);
                            return;
                        }
                        if (true) goto _L4; else goto _L5
_L5:
                    }

            
            {
                this$1 = final__pcls7;
                response = com.millennialmedia.internal.utils.HttpUtils.Response.this;
                super();
            }
                });
            }

            
            {
                this$0 = WebController.this;
                expandParams = expandparams;
                twoPartWebViewRef = weakreference;
                sizableStateManagerRef = weakreference1;
                super();
            }
        });
    }

    public void showExpanded(final com.millennialmedia.internal.MMActivity.MMActivityConfig activityConfig)
    {
        ThreadUtils.runOnUiThread(new Runnable() {

            final WebController this$0;
            final com.millennialmedia.internal.MMActivity.MMActivityConfig val$activityConfig;

            public void run()
            {
                SizableStateManager sizablestatemanager = getSizableStateManager();
                com.millennialmedia.internal.SizableStateManager.ExpandParams expandparams = new com.millennialmedia.internal.SizableStateManager.ExpandParams();
                expandparams.width = -1;
                expandparams.height = -1;
                expandparams.showCloseIndicator = true;
                expandparams.orientation = -1;
                if (!sizablestatemanager.expand(mmWebView, expandparams, activityConfig))
                {
                    webControllerListener.attachFailed();
                }
            }

            
            {
                this$0 = WebController.this;
                activityConfig = mmactivityconfig;
                super();
            }
        });
    }




/*
    static MMWebView access$002(WebController webcontroller, MMWebView mmwebview)
    {
        webcontroller.mmWebView = mmwebview;
        return mmwebview;
    }

*/





/*
    static SizableStateManager access$302(WebController webcontroller, SizableStateManager sizablestatemanager)
    {
        webcontroller.sizableStateManager = sizablestatemanager;
        return sizablestatemanager;
    }

*/
}
