// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.AdContainer;
import com.millennialmedia.internal.MMActivity;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import com.millennialmedia.internal.utils.Utils;
import com.millennialmedia.internal.utils.ViewUtils;
import com.millennialmedia.internal.video.VASTParser;
import com.millennialmedia.internal.video.VASTVideoView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            AdController

public class VASTVideoController extends AdController
{
    public static interface VASTVideoControllerListener
    {

        public abstract void attachFailed();

        public abstract void attachSucceeded();

        public abstract void initFailed();

        public abstract void initSucceeded();

        public abstract void onClick();
    }


    private static final int MAX_WRAPPERS = 3;
    private static final String TAG = com/millennialmedia/internal/adcontrollers/VASTVideoController.getSimpleName();
    private com.millennialmedia.internal.video.VASTParser.InLineAd inLineAd;
    private VASTVideoControllerListener listener;
    private VASTVideoView vastVideoView;
    private List wrapperAds;

    public VASTVideoController()
    {
    }

    public VASTVideoController(final Context context, final String adContent, final VASTVideoControllerListener listener)
    {
        this.listener = listener;
        wrapperAds = new ArrayList();
        if (!EnvironmentUtils.isExternalStorageWritable())
        {
            MMLog.w(TAG, "External storage is not writeable.  Unable to load VAST video interstitial.");
            listener.initFailed();
            return;
        } else
        {
            ThreadUtils.runOnWorkerThread(new Runnable() {

                final VASTVideoController this$0;
                final String val$adContent;
                final Context val$context;
                final VASTVideoControllerListener val$listener;

                public void run()
                {
                    try
                    {
                        loadAd(adContent);
                        if (inLineAd == null)
                        {
                            MMLog.e(VASTVideoController.TAG, "VAST content did not produce a valid InLineAd instance.");
                            fireErrorUrls();
                            listener.initFailed();
                            return;
                        }
                    }
                    catch (XmlPullParserException xmlpullparserexception)
                    {
                        MMLog.e(VASTVideoController.TAG, "VAST XML Parsing error.", xmlpullparserexception);
                        fireErrorUrls();
                        listener.initFailed();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        MMLog.e(VASTVideoController.TAG, "VAST XML I/O error.", ioexception);
                        fireErrorUrls();
                        listener.initFailed();
                        return;
                    }
                    if (inLineAd.impressions.isEmpty())
                    {
                        MMLog.e(VASTVideoController.TAG, "InLineAd must contain at least one Impression URL.");
                        fireErrorUrls();
                        listener.initFailed();
                        return;
                    }
label0:
                    {
                        if (wrapperAds == null)
                        {
                            break label0;
                        }
                        Iterator iterator = wrapperAds.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                        } while (!((com.millennialmedia.internal.video.VASTParser.WrapperAd)iterator.next()).impressions.isEmpty());
                        MMLog.e(VASTVideoController.TAG, "WrapperAd must contain at least one Impression URL.");
                        fireErrorUrls();
                        listener.initFailed();
                        return;
                    }
                    ThreadUtils.runOnUiThread(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            vastVideoView = new VASTVideoView(new MutableContextWrapper(context), inLineAd, wrapperAds, new com.millennialmedia.internal.video.VASTVideoView.VASTVideoViewListener() {

                                final _cls1 this$2;

                                public void onClicked()
                                {
                                    listener.onClick();
                                }

                                public void onFailed()
                                {
                                    fireErrorUrls();
                                    listener.initFailed();
                                }

                                public void onLoaded()
                                {
                                    listener.initSucceeded();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                }

            
            {
                this$0 = VASTVideoController.this;
                adContent = s;
                listener = vastvideocontrollerlistener;
                context = context1;
                super();
            }
            });
            return;
        }
    }

    private void fireErrorUrls()
    {
        ThreadUtils.runOnWorkerThread(new Runnable() {

            final VASTVideoController this$0;

            public void run()
            {
                if (inLineAd != null && !Utils.isEmpty(inLineAd.error))
                {
                    HttpUtils.getContentFromGetRequest(inLineAd.error);
                }
                if (wrapperAds != null)
                {
                    Iterator iterator = wrapperAds.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.millennialmedia.internal.video.VASTParser.WrapperAd wrapperad = (com.millennialmedia.internal.video.VASTParser.WrapperAd)iterator.next();
                        if (!Utils.isEmpty(wrapperad.error))
                        {
                            HttpUtils.getContentFromGetRequest(wrapperad.error);
                        }
                    } while (true);
                }
            }

            
            {
                this$0 = VASTVideoController.this;
                super();
            }
        });
    }

    private void loadAd(String s)
        throws XmlPullParserException, IOException
    {
        s = VASTParser.parse(s);
        if (s == null)
        {
            fireErrorUrls();
            listener.initFailed();
        } else
        {
            if (s instanceof com.millennialmedia.internal.video.VASTParser.InLineAd)
            {
                inLineAd = (com.millennialmedia.internal.video.VASTParser.InLineAd)s;
                return;
            }
            if (s instanceof com.millennialmedia.internal.video.VASTParser.WrapperAd)
            {
                s = (com.millennialmedia.internal.video.VASTParser.WrapperAd)s;
                wrapperAds.add(s);
                if (wrapperAds.size() <= 3 && ((com.millennialmedia.internal.video.VASTParser.WrapperAd) (s)).adTagURI != null && !((com.millennialmedia.internal.video.VASTParser.WrapperAd) (s)).adTagURI.isEmpty())
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(TAG, (new StringBuilder()).append("Requesting VAST tag URI = ").append(((com.millennialmedia.internal.video.VASTParser.WrapperAd) (s)).adTagURI).toString());
                    }
                    com.millennialmedia.internal.utils.HttpUtils.Response response = HttpUtils.getContentFromGetRequest(((com.millennialmedia.internal.video.VASTParser.WrapperAd) (s)).adTagURI);
                    if (response.code == 200)
                    {
                        loadAd(response.content);
                        return;
                    } else
                    {
                        MMLog.e(TAG, (new StringBuilder()).append("Received HTTP status code = ").append(response.code).append(" when processing ad tag URI = ").append(((com.millennialmedia.internal.video.VASTParser.WrapperAd) (s)).adTagURI).toString());
                        return;
                    }
                } else
                {
                    MMLog.e(TAG, "VAST wrapper did not contain a valid ad tag URI or MAX VAST Redirects exceeded.");
                    return;
                }
            }
        }
    }

    public void attach(MMActivity mmactivity)
    {
        mmactivity = mmactivity.getRootView();
        if (mmactivity == null)
        {
            listener.attachFailed();
            return;
        }
        final AdContainer adContainer = mmactivity.getContext();
        if (!(adContainer instanceof Activity))
        {
            listener.attachFailed();
            return;
        } else
        {
            adContainer = new AdContainer((Activity)adContainer, null);
            adContainer.setOnClickListener(new android.view.View.OnClickListener() {

                final VASTVideoController this$0;

                public void onClick(View view)
                {
                    listener.onClick();
                }

            
            {
                this$0 = VASTVideoController.this;
                super();
            }
            });
            ThreadUtils.runOnUiThread(new Runnable() {

                final VASTVideoController this$0;
                final AdContainer val$adContainer;

                public void run()
                {
                    if (vastVideoView == null)
                    {
                        MMLog.e(VASTVideoController.TAG, "VASTVideoView instance is null, unable to attach");
                        listener.attachFailed();
                        return;
                    } else
                    {
                        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
                        vastVideoView.setLayoutParams(layoutparams);
                        ViewUtils.attachView(adContainer, vastVideoView);
                        vastVideoView.updateLayout();
                        listener.attachSucceeded();
                        return;
                    }
                }

            
            {
                this$0 = VASTVideoController.this;
                adContainer = adcontainer;
                super();
            }
            });
            ViewUtils.attachView(mmactivity, adContainer);
            return;
        }
    }

    public boolean canHandleContent(String s)
    {
        if (!Utils.isEmpty(s))
        {
            s = s.toUpperCase();
            int i = s.indexOf("<VAST");
            int j = s.indexOf("<AD");
            int k = s.indexOf("</VAST>");
            if (i >= 0 && i < j && j < k)
            {
                return true;
            }
        }
        return false;
    }

    public boolean onBackPressed()
    {
        if (vastVideoView != null)
        {
            return vastVideoView.canSkip();
        } else
        {
            return true;
        }
    }

    public void shutdown()
    {
        if (vastVideoView != null)
        {
            vastVideoView.shutdown();
        }
    }









/*
    static VASTVideoView access$502(VASTVideoController vastvideocontroller, VASTVideoView vastvideoview)
    {
        vastvideocontroller.vastVideoView = vastvideoview;
        return vastvideoview;
    }

*/

}
