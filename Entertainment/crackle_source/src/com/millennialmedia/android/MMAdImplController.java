// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.millennialmedia.android:
//            MMAdImpl, MMWebView, MMLayout, HandShake, 
//            MMException, AdCache, CachedAd, MMSDK, 
//            InterstitialAd, HttpGetRequest, VideoAd, HttpMMHeaders

class MMAdImplController
    implements AdCache.AdCacheTaskListener
{
    private class RequestAdRunnable
        implements Runnable
    {

        String adUrl;
        HttpMMHeaders mmHeaders;
        final MMAdImplController this$0;

        private boolean isAdUrlBuildable()
        {
            Object obj;
            adUrl = null;
            obj = null;
            if (adImplRef != null)
            {
                obj = (MMAdImpl)adImplRef.get();
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_228;
            }
            try
            {
                Object obj1 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                ((MMAdImpl) (obj)).insertUrlAdMetaValues(((Map) (obj1)));
                MMSDK.insertUrlCommonValues(((MMAdImpl) (obj)).getContext(), ((Map) (obj1)));
                ((Map) (obj1)).put("ua", ((MMAdImpl) (obj)).controller.getUserAgent());
                obj = new StringBuilder(HandShake.getAdUrl());
                MMSDK.Log.d(((Map) (obj1)).entrySet().toString());
                java.util.Map.Entry entry;
                for (obj1 = ((Map) (obj1)).entrySet().iterator(); ((Iterator) (obj1)).hasNext(); ((StringBuilder) (obj)).append(String.format("%s=%s&", new Object[] {
        entry.getKey(), URLEncoder.encode((String)entry.getValue(), "UTF-8")
    })))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
                }

            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return failWithErrorMessage(new MMException(((Exception) (obj))));
            }
            ((StringBuilder) (obj)).delete(((StringBuilder) (obj)).length() - 1, ((StringBuilder) (obj)).length());
            adUrl = ((StringBuilder) (obj)).toString();
            MMSDK.Log.d("Calling for an advertisement: %s", new Object[] {
                adUrl
            });
            break MISSING_BLOCK_LABEL_242;
            failWithInfoMessage(new MMException(25));
            return true;
        }

        private boolean isHandledHtmlResponse(HttpEntity httpentity)
        {
            MMAdImpl mmadimpl = null;
            InterstitialAd interstitialad;
            try
            {
                if (adImplRef != null)
                {
                    mmadimpl = (MMAdImpl)adImplRef.get();
                }
            }
            // Misplaced declaration of an exception variable
            catch (HttpEntity httpentity)
            {
                return failWithErrorMessage(new MMException((new StringBuilder()).append("Exception raised in HTTP stream: ").append(httpentity.getMessage()).toString(), httpentity));
            }
            if (mmadimpl == null)
            {
                break MISSING_BLOCK_LABEL_217;
            }
            if (!mmadimpl.isBanner())
            {
                interstitialad = new InterstitialAd();
                interstitialad.content = HttpGetRequest.convertStreamToString(httpentity.getContent());
                interstitialad.setId(mmadimpl.adType);
                interstitialad.adUrl = adUrl;
                interstitialad.mmHeaders = mmHeaders;
                if (MMSDK.logLevel >= 5)
                {
                    MMSDK.Log.v("Received interstitial ad with url %s.", new Object[] {
                        interstitialad.adUrl
                    });
                    MMSDK.Log.v(interstitialad.content);
                }
                AdCache.save(mmadimpl.getContext(), interstitialad);
                AdCache.setNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName(), interstitialad.getId());
                MMSDK.Event.fetchStartedCaching(mmadimpl);
                MMSDK.Event.requestCompleted(mmadimpl);
                break MISSING_BLOCK_LABEL_217;
            }
            if (mmadimpl.controller != null)
            {
                mmadimpl.controller.setWebViewContent(HttpGetRequest.convertStreamToString(httpentity.getContent()), adUrl);
            }
            MMSDK.Event.requestCompleted(mmadimpl);
            return true;
        }

        private boolean isHandledJsonResponse(HttpEntity httpentity)
        {
            MMAdImpl mmadimpl = null;
            if (adImplRef != null)
            {
                mmadimpl = (MMAdImpl)adImplRef.get();
            }
            if (mmadimpl != null)
            {
                if (mmadimpl.isBanner())
                {
                    return failWithErrorMessage(new MMException("Millennial ad return unsupported format.", 15));
                }
                try
                {
                    httpentity = (VideoAd)CachedAd.parseJSON(HttpGetRequest.convertStreamToString(httpentity.getContent()));
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    httpentity.printStackTrace();
                    return failWithInfoMessage(new MMException("Millennial ad return failed. Invalid response data.", httpentity));
                }
                // Misplaced declaration of an exception variable
                catch (HttpEntity httpentity)
                {
                    httpentity.printStackTrace();
                    return failWithInfoMessage(new MMException((new StringBuilder()).append("Millennial ad return failed. ").append(httpentity.getMessage()).toString(), httpentity));
                }
                if (httpentity != null && httpentity.isValid())
                {
                    MMSDK.Log.i((new StringBuilder()).append("Cached video ad JSON received: ").append(httpentity.getId()).toString());
                    if (httpentity.isExpired())
                    {
                        MMSDK.Log.i("New ad has expiration date in the past. Not downloading ad content.");
                        httpentity.delete(mmadimpl.getContext());
                        MMSDK.Event.requestFailed(mmadimpl, new MMException(15));
                    } else
                    if (AdCache.loadNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName()) != null)
                    {
                        MMSDK.Log.i("Previously fetched ad exists in the playback queue. Not downloading ad content.");
                        httpentity.delete(mmadimpl.getContext());
                        MMSDK.Event.requestFailed(mmadimpl, new MMException(17));
                    } else
                    {
                        AdCache.save(mmadimpl.getContext(), httpentity);
                        if (!httpentity.isOnDisk(mmadimpl.getContext()))
                        {
                            MMSDK.Event.logEvent(((VideoAd) (httpentity)).cacheMissURL);
                            MMSDK.Log.d("Downloading ad...");
                            MMSDK.Event.fetchStartedCaching(mmadimpl);
                            httpentity.downloadPriority = 3;
                            AdCache.startDownloadTask(mmadimpl.getContext(), mmadimpl.getCachedName(), httpentity, mmadimpl.controller);
                        } else
                        {
                            MMSDK.Log.d("Cached ad is valid. Moving it to the front of the queue.");
                            AdCache.setNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName(), httpentity.getId());
                            MMSDK.Event.fetchStartedCaching(mmadimpl);
                            MMSDK.Event.requestCompleted(mmadimpl);
                        }
                    }
                }
            }
            return true;
        }

        private boolean isHandledResponse(HttpResponse httpresponse)
        {
            HttpEntity httpentity = httpresponse.getEntity();
            if (httpentity == null)
            {
                failWithInfoMessage(new MMException("Null HTTP entity", 14));
                return false;
            }
            if (httpentity.getContentLength() == 0L)
            {
                failWithInfoMessage(new MMException("Millennial ad return failed. Zero content length returned.", 14));
                return false;
            }
            saveMacId(httpresponse);
            Header header = httpentity.getContentType();
            if (header != null && header.getValue() != null)
            {
                if (header.getValue().toLowerCase().startsWith("application/json"))
                {
                    isHandledJsonResponse(httpentity);
                } else
                if (header.getValue().toLowerCase().startsWith("text/html"))
                {
                    Header header1 = httpresponse.getFirstHeader("X-MM-Video");
                    mmHeaders = new HttpMMHeaders(httpresponse.getAllHeaders());
                    if (header1 != null && header1.getValue().equalsIgnoreCase("true"))
                    {
                        httpresponse = null;
                        if (adImplRef != null)
                        {
                            httpresponse = (MMAdImpl)adImplRef.get();
                        }
                        if (httpresponse != null)
                        {
                            Context context = httpresponse.getContext();
                            HandShake.sharedHandShake(context).updateLastVideoViewedTime(context, ((MMAdImpl) (httpresponse)).adType);
                        }
                    }
                    isHandledHtmlResponse(httpentity);
                } else
                {
                    failWithInfoMessage(new MMException("Millennial ad return failed. Invalid (JSON/HTML expected) mime type returned.", 15));
                    return false;
                }
                return true;
            } else
            {
                failWithInfoMessage(new MMException("Millennial ad return failed. HTTP Header value null.", 15));
                return false;
            }
        }

        private void saveMacId(HttpResponse httpresponse)
        {
            httpresponse = httpresponse.getHeaders("Set-Cookie");
            int j = httpresponse.length;
            for (int i = 0; i < j; i++)
            {
                String s = httpresponse[i].getValue();
                int k = s.indexOf("MAC-ID=");
                if (k < 0)
                {
                    continue;
                }
                int l = s.indexOf(';', k);
                if (l > k)
                {
                    MMSDK.macId = s.substring(k + 7, l);
                }
            }

        }

        boolean fail(MMException mmexception)
        {
            MMAdImpl mmadimpl = null;
            if (adImplRef != null)
            {
                mmadimpl = (MMAdImpl)adImplRef.get();
            }
            MMSDK.Event.requestFailed(mmadimpl, mmexception);
            return false;
        }

        boolean failWithErrorMessage(MMException mmexception)
        {
            MMSDK.Log.e(mmexception.getMessage());
            return fail(mmexception);
        }

        boolean failWithInfoMessage(MMException mmexception)
        {
            MMSDK.Log.i(mmexception.getMessage());
            return fail(mmexception);
        }

        public void run()
        {
            Object obj;
            if (adImplRef == null)
            {
                break MISSING_BLOCK_LABEL_193;
            }
            obj = (MMAdImpl)adImplRef.get();
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_167;
            }
            boolean flag;
            if (!MMSDK.isConnected(((MMAdImpl) (obj)).getContext()))
            {
                break MISSING_BLOCK_LABEL_167;
            }
            flag = isAdUrlBuildable();
            if (!flag)
            {
                requestAdRunnable = null;
                return;
            }
            obj = (new HttpGetRequest()).get(adUrl);
            if (obj != null)
            {
                break MISSING_BLOCK_LABEL_148;
            }
            failWithErrorMessage(new MMException("HTTP response is null.", 14));
            requestAdRunnable = null;
            return;
            obj;
            failWithErrorMessage(new MMException((new StringBuilder()).append("Ad request HTTP error. ").append(((Exception) (obj)).getMessage()).toString(), 14));
            requestAdRunnable = null;
            return;
            flag = isHandledResponse(((HttpResponse) (obj)));
            if (!flag)
            {
                requestAdRunnable = null;
                return;
            }
            break MISSING_BLOCK_LABEL_193;
            failWithInfoMessage(new MMException("No network available, can't call for ads.", 11));
            requestAdRunnable = null;
            return;
            requestAdRunnable = null;
            return;
            Object obj1;
            obj1;
            failWithInfoMessage(new MMException("Request not filled, can't call for ads.", 14));
            requestAdRunnable = null;
            return;
            obj1;
            requestAdRunnable = null;
            throw obj1;
        }

        private RequestAdRunnable()
        {
            this$0 = MMAdImplController.this;
            super();
        }

    }


    static final long NO_ID_RETURNED = -4L;
    private static final Map saveableControllers = new ConcurrentHashMap();
    private static final Map weakUnsaveableAdRef = new ConcurrentHashMap();
    volatile WeakReference adImplRef;
    volatile long linkedAdImplId;
    RequestAdRunnable requestAdRunnable;
    volatile MMWebView webView;

    private MMAdImplController(MMAdImpl mmadimpl)
    {
        MMSDK.Log.d("**************** creating new controller.");
        adImplRef = new WeakReference(mmadimpl);
        if (mmadimpl.linkForExpansionId != 0L)
        {
            linkForExpansion(mmadimpl);
            webView = getWebViewFromExistingAdImpl(mmadimpl);
            return;
        }
        if (mmadimpl.isBanner())
        {
            webView = new MMWebView(mmadimpl.getContext().getApplicationContext(), mmadimpl.internalId);
            webView.requiresPreAdSizeFix = true;
            return;
        } else
        {
            webView = new MMWebView(mmadimpl.getContext(), mmadimpl.internalId);
            return;
        }
    }

    static void assignAdViewController(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        if (mmadimpl.controller == null) goto _L2; else goto _L1
_L1:
        if (saveableControllers.containsValue(mmadimpl.controller)) goto _L4; else goto _L3
_L3:
        if (!mmadimpl.isLifecycleObservable()) goto _L6; else goto _L5
_L5:
        saveableControllers.put(Long.valueOf(mmadimpl.internalId), mmadimpl.controller);
        if (weakUnsaveableAdRef.containsKey(Long.valueOf(mmadimpl.internalId)))
        {
            weakUnsaveableAdRef.remove(Long.valueOf(mmadimpl.internalId));
        }
_L4:
        MMSDK.Log.d((new StringBuilder()).append(mmadimpl).append(" - Has a controller").toString());
_L8:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L6:
        if (weakUnsaveableAdRef.containsKey(Long.valueOf(mmadimpl.internalId))) goto _L4; else goto _L7
_L7:
        weakUnsaveableAdRef.put(Long.valueOf(mmadimpl.internalId), new WeakReference(mmadimpl.controller));
          goto _L4
        mmadimpl;
        throw mmadimpl;
_L2:
        MMAdImplController mmadimplcontroller;
        MMSDK.Log.d((new StringBuilder()).append("*****************************************assignAdViewController for ").append(mmadimpl).toString());
        mmadimplcontroller = (MMAdImplController)saveableControllers.get(Long.valueOf(mmadimpl.internalId));
        Object obj;
        obj = mmadimplcontroller;
        if (mmadimplcontroller != null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = (WeakReference)weakUnsaveableAdRef.get(Long.valueOf(mmadimpl.internalId));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_244;
        }
        mmadimplcontroller = (MMAdImplController)((WeakReference) (obj)).get();
        obj = mmadimplcontroller;
        if (mmadimplcontroller != null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj = new MMAdImplController(mmadimpl);
        if (!mmadimpl.isLifecycleObservable())
        {
            break MISSING_BLOCK_LABEL_314;
        }
        saveableControllers.put(Long.valueOf(mmadimpl.internalId), obj);
_L9:
        mmadimpl.controller = ((MMAdImplController) (obj));
        obj.adImplRef = new WeakReference(mmadimpl);
        if (((MMAdImplController) (obj)).webView != null)
        {
            setupWebView(mmadimpl);
        }
          goto _L8
        weakUnsaveableAdRef.put(Long.valueOf(mmadimpl.internalId), new WeakReference(obj));
          goto _L9
    }

    static void attachWebViewFromOverlay(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImpl mmadimpl1;
        MMSDK.Log.d((new StringBuilder()).append("attachWebViewFromOverlay with ").append(mmadimpl).toString());
        mmadimpl1 = getAdImplWithId(mmadimpl.linkForExpansionId);
        if (mmadimpl1 == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (mmadimpl1.controller != null)
        {
            if (mmadimpl1.controller.webView == null)
            {
                mmadimpl1.controller.webView = mmadimpl.controller.webView;
                mmadimpl.removeView(mmadimpl.controller.webView);
                mmadimpl.controller.webView = null;
            }
            mmadimpl1.controller.webView.setMraidDefault();
            mmadimpl1.controller.webView.setWebViewClient(mmadimpl1.getMMWebViewClient());
        }
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
        mmadimpl;
        throw mmadimpl;
    }

    static void clearControllers()
    {
        if (saveableControllers != null)
        {
            saveableControllers.clear();
        }
        if (weakUnsaveableAdRef != null)
        {
            weakUnsaveableAdRef.clear();
        }
    }

    static String controllersToString()
    {
        return (new StringBuilder()).append(weakUnsaveableAdRef.toString()).append(" SAVED:").append(saveableControllers.toString()).toString();
    }

    static void destroyOtherInlineVideo(Context context)
    {
        context = saveableControllers.entrySet().iterator();
        do
        {
            if (!context.hasNext())
            {
                break;
            }
            Object obj = (MMAdImplController)((java.util.Map.Entry)context.next()).getValue();
            if (obj != null)
            {
                obj = (MMAdImpl)((MMAdImplController) (obj)).adImplRef.get();
                if (obj != null)
                {
                    obj = ((MMAdImpl) (obj)).getCallingAd();
                    if (obj != null && (obj instanceof MMLayout))
                    {
                        ((MMLayout)obj).removeVideo();
                    }
                }
            }
        } while (true);
    }

    static MMAdImpl getAdImplWithId(long l)
    {
        MMAdImpl mmadimpl = null;
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        if (l != -4L) goto _L2; else goto _L1
_L1:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return mmadimpl;
_L2:
        MMAdImplController mmadimplcontroller1 = (MMAdImplController)saveableControllers.get(Long.valueOf(l));
        MMAdImplController mmadimplcontroller;
        mmadimplcontroller = mmadimplcontroller1;
        if (mmadimplcontroller1 != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        WeakReference weakreference = (WeakReference)weakUnsaveableAdRef.get(Long.valueOf(l));
        mmadimplcontroller = mmadimplcontroller1;
        if (weakreference == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mmadimplcontroller = (MMAdImplController)weakreference.get();
        if (mmadimplcontroller == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        mmadimpl = (MMAdImpl)mmadimplcontroller.adImplRef.get();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static MMWebView getWebViewFromExistingAdImpl(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMSDK.Log.i((new StringBuilder()).append("getWebViewFromExistingLayout(").append(mmadimpl.internalId).append(" taking from ").append(mmadimpl.linkForExpansionId).append(")").toString());
        Object obj = null;
        MMAdImpl mmadimpl1 = getAdImplWithId(mmadimpl.linkForExpansionId);
        mmadimpl = obj;
        if (mmadimpl1 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        mmadimpl = obj;
        if (mmadimpl1.controller != null)
        {
            mmadimpl = mmadimpl1.controller.webView;
            mmadimpl1.controller.webView = null;
        }
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return mmadimpl;
        mmadimpl;
        throw mmadimpl;
    }

    private boolean isDownloadingCachedAd(MMAdImpl mmadimpl)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        Context context = mmadimpl.getContext();
        if (!HandShake.sharedHandShake(context).isAdTypeDownloading(mmadimpl.adType)) goto _L2; else goto _L1
_L1:
        MMSDK.Log.i("There is a download in progress. Defering call for new ad");
        MMSDK.Event.requestFailed(mmadimpl, new MMException(12));
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        CachedAd cachedad;
        MMSDK.Log.d("No download in progress.");
        cachedad = AdCache.loadIncompleteDownload(context, mmadimpl.getCachedName());
        if (cachedad == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        MMSDK.Log.i("Last ad wasn't fully downloaded. Download again.");
        MMSDK.Event.fetchStartedCaching(mmadimpl);
        AdCache.startDownloadTask(context, mmadimpl.getCachedName(), cachedad, this);
        continue; /* Loop/switch isn't completed */
        mmadimpl;
        throw mmadimpl;
        MMSDK.Log.i("No incomplete downloads.");
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void removeAdViewController(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImplController mmadimplcontroller = mmadimpl.controller;
        if (mmadimplcontroller != null) goto _L2; else goto _L1
_L1:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!mmadimpl.isLifecycleObservable())
        {
            break; /* Loop/switch isn't completed */
        }
        saveableControllers.put(Long.valueOf(mmadimpl.internalId), mmadimpl.controller);
        if (weakUnsaveableAdRef.get(Long.valueOf(mmadimpl.internalId)) != null)
        {
            weakUnsaveableAdRef.remove(Long.valueOf(mmadimpl.internalId));
        }
_L4:
        MMSDK.Log.d((new StringBuilder()).append("****************RemoveAdviewcontroller - ").append(mmadimpl).toString());
        if (mmadimpl.isFinishing)
        {
            saveableControllers.remove(Long.valueOf(mmadimpl.internalId));
            weakUnsaveableAdRef.remove(Long.valueOf(mmadimpl.internalId));
        }
        MMAdImplController mmadimplcontroller1 = mmadimpl.controller;
        mmadimpl.controller = null;
        MMSDK.Log.d((new StringBuilder()).append("****************RemoveAdviewcontroller - controllers ").append(controllersToString()).toString());
        if (mmadimplcontroller1.webView != null)
        {
            MMSDK.Log.d((new StringBuilder()).append("****************RemoveAdviewcontroller - controller!=null, expanding=").append(mmadimplcontroller1.webView.isExpanding).toString());
            mmadimpl.removeView(mmadimplcontroller1.webView);
            mmadimplcontroller1.webView.isExpanding = false;
            if (mmadimpl.isFinishing && mmadimpl.linkForExpansionId == 0L)
            {
                mmadimplcontroller1.webView = null;
            }
        }
        if (true) goto _L1; else goto _L3
        mmadimpl;
        throw mmadimpl;
_L3:
        weakUnsaveableAdRef.put(Long.valueOf(mmadimpl.internalId), new WeakReference(mmadimpl.controller));
          goto _L4
    }

    private void requestAdInternal(MMAdImpl mmadimpl)
    {
        if (mmadimpl.apid != null) goto _L2; else goto _L1
_L1:
        MMException mmexception = new MMException("MMAdView found with a null apid. New ad requests on this MMAdView are disabled until an apid has been assigned.", 1);
        MMSDK.Log.e(mmexception);
        MMSDK.Event.requestFailed(mmadimpl, mmexception);
_L4:
        return;
_L2:
        if (!mmadimpl.isBanner() && isDownloadingCachedAd(mmadimpl)) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
        if (requestAdRunnable == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        MMSDK.Log.i(MMException.getErrorCodeMessage(12));
        MMSDK.Event.requestFailed(mmadimpl, new MMException(12));
        this;
        JVM INSTR monitorexit ;
        return;
        mmadimpl;
        this;
        JVM INSTR monitorexit ;
        throw mmadimpl;
        requestAdRunnable = new RequestAdRunnable();
        Utils.ThreadUtils.execute(requestAdRunnable);
        this;
        JVM INSTR monitorexit ;
    }

    private static void setupWebView(MMAdImpl mmadimpl)
    {
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorenter ;
        MMAdImplController mmadimplcontroller;
        mmadimplcontroller = mmadimpl.controller;
        mmadimplcontroller.webView.setWebViewClient(mmadimpl.getMMWebViewClient());
        if (mmadimplcontroller.webView.isCurrentParent(mmadimpl.internalId)) goto _L2; else goto _L1
_L1:
        if (!mmadimpl.isBanner()) goto _L4; else goto _L3
_L3:
        android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        android.widget.RelativeLayout.LayoutParams layoutparams = layoutparams1;
        if (!mmadimplcontroller.webView.isMraidResized())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        mmadimplcontroller.webView.unresizeToDefault(mmadimpl);
        layoutparams = layoutparams1;
_L6:
        mmadimplcontroller.webView.removeFromParent();
        mmadimpl.addView(mmadimplcontroller.webView, layoutparams);
_L2:
        com/millennialmedia/android/MMAdImplController;
        JVM INSTR monitorexit ;
        return;
_L4:
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        if (true) goto _L6; else goto _L5
_L5:
        mmadimpl;
        throw mmadimpl;
    }

    int checkReason(MMAdImpl mmadimpl, CachedAd cachedad)
    {
        if (cachedad.isExpired())
        {
            MMSDK.Log.d("%s is expired.", new Object[] {
                cachedad.getId()
            });
            return 21;
        }
        if (!cachedad.isOnDisk(mmadimpl.getContext()))
        {
            MMSDK.Log.d("%s is not on disk.", new Object[] {
                cachedad.getId()
            });
            return 22;
        }
        if (!HandShake.sharedHandShake(mmadimpl.getContext()).canDisplayCachedAd(mmadimpl.adType, cachedad.deferredViewStart))
        {
            MMSDK.Log.d("%s cannot be shown at this time.", new Object[] {
                cachedad.getId()
            });
            return 24;
        } else
        {
            return 100;
        }
    }

    int display(MMAdImpl mmadimpl)
    {
        CachedAd cachedad = AdCache.loadNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName());
        if (cachedad != null)
        {
            if (cachedad.canShow(mmadimpl.getContext(), mmadimpl, true))
            {
                MMSDK.Event.displayStarted(mmadimpl);
                AdCache.setNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName(), null);
                cachedad.show(mmadimpl.getContext(), mmadimpl.internalId);
                HandShake.sharedHandShake(mmadimpl.getContext()).updateLastVideoViewedTime(mmadimpl.getContext(), mmadimpl.adType);
                return 0;
            } else
            {
                return checkReason(mmadimpl, cachedad);
            }
        } else
        {
            return 20;
        }
    }

    public void downloadCompleted(CachedAd cachedad, boolean flag)
    {
        MMAdImpl mmadimpl = (MMAdImpl)adImplRef.get();
        if (mmadimpl == null)
        {
            MMSDK.Log.e(MMException.getErrorCodeMessage(25));
            return;
        }
        if (flag)
        {
            AdCache.setNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName(), cachedad.getId());
        }
        if (flag)
        {
            MMSDK.Event.requestCompleted(mmadimpl);
            return;
        } else
        {
            MMSDK.Event.requestFailed(mmadimpl, new MMException(15));
            return;
        }
    }

    public void downloadStart(CachedAd cachedad)
    {
    }

    String getUserAgent()
    {
        if (webView != null)
        {
            return webView.getUserAgent();
        } else
        {
            return Build.MODEL;
        }
    }

    int isAdAvailable(MMAdImpl mmadimpl)
    {
        CachedAd cachedad = AdCache.loadNextCachedAd(mmadimpl.getContext(), mmadimpl.getCachedName());
        if (cachedad != null)
        {
            if (cachedad.canShow(mmadimpl.getContext(), mmadimpl, true))
            {
                return 0;
            } else
            {
                return checkReason(mmadimpl, cachedad);
            }
        } else
        {
            MMSDK.Log.i("No next ad.");
            return 20;
        }
    }

    void linkForExpansion(MMAdImpl mmadimpl)
    {
        MMAdImpl mmadimpl1 = getAdImplWithId(mmadimpl.linkForExpansionId);
        if (mmadimpl1 != null)
        {
            linkedAdImplId = mmadimpl.linkForExpansionId;
            mmadimpl1.controller.linkedAdImplId = mmadimpl.internalId;
            mmadimpl1.linkForExpansionId = mmadimpl.internalId;
        }
    }

    void loadUrl(String s)
    {
        if (!TextUtils.isEmpty(s) && webView != null)
        {
            webView.loadUrl(s);
        }
    }

    void loadWebContent(String s, String s1)
    {
        MMAdImpl mmadimpl = (MMAdImpl)adImplRef.get();
        if (mmadimpl != null && webView != null)
        {
            webView.setWebViewContent(s, s1, mmadimpl);
        }
    }

    void pauseWebViewVideo()
    {
        if (webView != null)
        {
            webView.onPauseWebViewVideo();
        }
    }

    void requestAd()
    {
        MMAdImpl mmadimpl = (MMAdImpl)adImplRef.get();
        if (mmadimpl == null)
        {
            MMSDK.Log.e(MMException.getErrorCodeMessage(25));
            MMSDK.Event.requestFailed(mmadimpl, new MMException(25));
            return;
        }
        if (!mmadimpl.isRefreshable())
        {
            MMSDK.Event.requestFailed(mmadimpl, new MMException(16));
            return;
        }
        if (!MMSDK.isUiThread())
        {
            MMSDK.Log.e(MMException.getErrorCodeMessage(3));
            MMSDK.Event.requestFailed(mmadimpl, new MMException(3));
            return;
        }
        if (HandShake.sharedHandShake(mmadimpl.getContext()).kill)
        {
            MMSDK.Log.i("The server is no longer allowing ads.");
            MMSDK.Event.requestFailed(mmadimpl, new MMException(16));
            return;
        }
        try
        {
            MMSDK.Log.d("adLayout - requestAd");
            requestAdInternal(mmadimpl);
            return;
        }
        catch (Exception exception)
        {
            MMSDK.Log.e("There was an exception with the ad request. %s", new Object[] {
                exception.getMessage()
            });
            exception.printStackTrace();
            return;
        }
    }

    void resumeWebViewVideo()
    {
        if (webView != null)
        {
            webView.onResumeWebViewVideo();
        }
    }

    void setWebViewContent(String s, String s1)
    {
        webView.setWebViewContent(s, s1, (MMAdImpl)adImplRef.get());
    }

    public String toString()
    {
        MMAdImpl mmadimpl = (MMAdImpl)adImplRef.get();
        StringBuilder stringbuilder = new StringBuilder();
        if (mmadimpl != null)
        {
            stringbuilder.append((new StringBuilder()).append(mmadimpl).append("-LinkInC=").append(linkedAdImplId).toString());
        }
        return (new StringBuilder()).append(stringbuilder.toString()).append(" w/").append(webView).toString();
    }

    void unresizeToDefault()
    {
        if (webView != null)
        {
            webView.unresizeToDefault((MMAdImpl)adImplRef.get());
        }
    }

}
