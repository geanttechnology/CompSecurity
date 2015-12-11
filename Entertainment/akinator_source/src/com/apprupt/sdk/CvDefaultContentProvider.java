// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvAppInfo, CvContentOptions, CvPreloaderResponse, 
//            CvContentResponse, CvFeaturesList, CvSDK, CvUrl, 
//            URLRequest, CvUnderscore, CvAudience

class CvDefaultContentProvider
    implements CvContentManager.ContentProvider
{
    private class Loader extends LoaderBase
    {

        private JSONObject data;
        private CvContentManager.ContentListener listener;
        final CvDefaultContentProvider this$0;

        private void callListener(CvContentResponse cvcontentresponse, CvContentManager.ContentListener contentlistener)
        {
            boolean flag = true;
            this;
            JVM INSTR monitorenter ;
            Logger.log log1 = CvDefaultContentProvider.log;
            if (contentlistener == null)
            {
                flag = false;
            }
            log1.e(new Object[] {
                "Calling listener with response", Boolean.valueOf(flag)
            });
            if (contentlistener == null)
            {
                break MISSING_BLOCK_LABEL_47;
            }
            contentlistener.onContentLoaded(cvcontentresponse);
            cancel();
            this;
            JVM INSTR monitorexit ;
            return;
            cvcontentresponse;
            throw cvcontentresponse;
        }

        String getUri()
        {
            int ai[] = new int[3];
            int[] _tmp = ai;
            ai[0] = 0;
            ai[1] = 0;
            ai[2] = 0;
            String s;
            if (options.adColony)
            {
                int i = ai[2];
                String s1;
                Object obj;
                String s2;
                String s3;
                String s4;
                byte byte0;
                long l;
                if (options.interstitial)
                {
                    byte0 = 16;
                } else
                {
                    byte0 = 32;
                }
                ai[2] = byte0 | i;
            }
            s1 = options.adSpaceId;
            obj = context;
            obj = CvFeaturesList.urlHex(ai, new int[] {
                0, 0, 0
            }, ((Context) (obj)));
            s2 = CvSDK.getPiKey();
            s3 = options.categories;
            s4 = options.keywords;
            l = Calendar.getInstance().getTimeInMillis();
            if (options.interstitial)
            {
                s = "&interstitial=1";
            } else
            {
                s = "";
            }
            return CvUrl.build(String.format("/cv/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s", new Object[] {
                s1, "6", obj, s2, s3, s4, Long.valueOf(l), s
            }));
        }

        void onCanceled()
        {
            this;
            JVM INSTR monitorenter ;
            listener = null;
            data = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        void onComplete()
        {
            CvContentResponse cvcontentresponse = new CvContentResponse(data);
            CvContentManager.ContentListener contentlistener = listener;
        /* block-local class not found */
        class _cls2 {}

            handler.post(new _cls2(cvcontentresponse, contentlistener));
        }

        void onError(String s, Exception exception, int i)
        {
            s = new CvContentResponse(s, exception, i);
            exception = listener;
        /* block-local class not found */
        class _cls1 {}

            handler.post(new _cls1(s, exception));
        }

        boolean parseContent(String s)
            throws Exception
        {
            if (s == null || s.length() == 0 || s.toLowerCase().equals("null") || s.equals("[]"))
            {
                error("Server returned empty response, possibly piKey should be refreshed.", null, 0);
                return false;
            }
            s = new JSONObject(s);
            if (s.has("size") && s.getString("size").length() > 0 && s.has("html") && s.getString("html").length() > 0)
            {
                data = s;
                return true;
            } else
            {
                error("Server returned not parsable response.", null, -2);
                return false;
            }
        }


        Loader(Context context, CvContentOptions cvcontentoptions, CvContentManager.ContentListener contentlistener)
        {
            this$0 = CvDefaultContentProvider.this;
            super(context, cvcontentoptions);
            data = null;
            listener = contentlistener;
        }
    }

    private abstract class LoaderBase
        implements CvContentManager.ContentLoader
    {

        protected boolean canceled;
        protected final Context context;
        protected final Handler handler = new Handler();
        protected final CvContentOptions options;
        final CvDefaultContentProvider this$0;

        public void cancel()
        {
            this;
            JVM INSTR monitorenter ;
            canceled = true;
            onCanceled();
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        void error(String s, Exception exception, int i)
        {
            CvDefaultContentProvider.log.e(exception, new Object[] {
                "Error while loading content:", s
            });
            onError(s, exception, i);
            cancel();
        }

        abstract String getUri();

        void handleResponse(URLRequest.URLResponse urlresponse)
        {
            CvDefaultContentProvider.log.i(new Object[] {
                "URLResponse:", Boolean.valueOf(urlresponse.isError), Integer.valueOf(urlresponse.code), urlresponse.data
            });
            if (!urlresponse.isError) goto _L2; else goto _L1
_L1:
            CvDefaultContentProvider.log.e(new Object[] {
                "URLResponse with error", Integer.valueOf(urlresponse.code), urlresponse.message
            });
            error(urlresponse.message, urlresponse.error, urlresponse.code);
_L4:
            return;
_L2:
            if (!parseContent(urlresponse.data)) goto _L4; else goto _L3
_L3:
            CvDefaultContentProvider.log.i(new Object[] {
                "URLResponse content parsed"
            });
            onComplete();
            return;
            Exception exception;
            exception;
            CvDefaultContentProvider.log.e(new Object[] {
                "URLResponse data is not parsable", urlresponse.data
            });
            error("Cannot parse content", exception, -2);
            return;
        }

        void load(String s)
        {
            CvDefaultContentProvider.log.i(new Object[] {
                "Building request /", options.adSpaceId
            });
            URLRequest urlrequest = URLRequest.post(getUri()).addPostParam("_", CvUnderscore.create().extend(CvAudience.getInstance().getJSON()).toString());
            String s1 = s;
            if (s == null)
            {
                s1 = "";
            }
        /* block-local class not found */
        class _cls2 {}

            urlrequest.addPostParam("pyld", s1).addPostParam("sdkVersion", "android_4.0.4").setListener(new _cls2()).send();
        }

        abstract void onCanceled();

        abstract void onComplete();

        abstract void onError(String s, Exception exception, int i);

        abstract boolean parseContent(String s)
            throws Exception;

        CvContentManager.ContentLoader run()
        {
        /* block-local class not found */
        class _cls1 {}

            (new Handler(Looper.getMainLooper())).post(new _cls1());
            return this;
        }

        LoaderBase(Context context1, CvContentOptions cvcontentoptions)
        {
            this$0 = CvDefaultContentProvider.this;
            super();
            canceled = false;
            options = cvcontentoptions;
            context = context1;
        }
    }

    private class TestLoader extends LoaderBase
    {

        private boolean hasAds;
        private CvContentManager.PreloaderListener listener;
        final CvDefaultContentProvider this$0;

        private void callListener(CvPreloaderResponse cvpreloaderresponse, CvContentManager.PreloaderListener preloaderlistener)
        {
            this;
            JVM INSTR monitorenter ;
            if (preloaderlistener == null)
            {
                break MISSING_BLOCK_LABEL_13;
            }
            preloaderlistener.onPreloaderFinish(cvpreloaderresponse);
            cancel();
            this;
            JVM INSTR monitorexit ;
            return;
            cvpreloaderresponse;
            throw cvpreloaderresponse;
        }

        String getUri()
        {
            String s1 = options.adSpaceId;
            String s2 = CvFeaturesList.urlHex(context);
            String s3 = CvSDK.getPiKey();
            String s4 = options.categories;
            String s5 = options.keywords;
            long l = Calendar.getInstance().getTimeInMillis();
            String s;
            if (options.interstitial)
            {
                s = "&interstitial=1";
            } else
            {
                s = "";
            }
            return CvUrl.build(String.format("/AdsAvailable/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s", new Object[] {
                s1, "6", s2, s3, s4, s5, Long.valueOf(l), s
            }));
        }

        void onCanceled()
        {
            this;
            JVM INSTR monitorenter ;
            listener = null;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        void onComplete()
        {
        /* block-local class not found */
        class _cls2 {}

            CvPreloaderResponse cvpreloaderresponse;
            CvContentManager.PreloaderListener preloaderlistener;
            if (hasAds)
            {
                cvpreloaderresponse = new CvPreloaderResponse();
            } else
            {
                cvpreloaderresponse = new CvPreloaderResponse("Ad space is empty", 0);
            }
            preloaderlistener = listener;
            handler.post(new _cls2(cvpreloaderresponse, preloaderlistener));
        }

        void onError(String s, Exception exception, int i)
        {
            s = new CvPreloaderResponse(s, i);
            exception = listener;
        /* block-local class not found */
        class _cls1 {}

            handler.post(new _cls1(s, exception));
        }

        boolean parseContent(String s)
            throws Exception
        {
            boolean flag;
            if (s != null && s.trim().equals("1"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hasAds = flag;
            return true;
        }


        TestLoader(Context context, CvContentOptions cvcontentoptions, CvContentManager.PreloaderListener preloaderlistener)
        {
            this$0 = CvDefaultContentProvider.this;
            super(context, cvcontentoptions);
            listener = null;
            hasAds = false;
            listener = preloaderlistener;
        }
    }


    private static final String ADS_CHECK_REQUEST_URI_PATH_FORMAT = "/AdsAvailable/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s";
    private static final String AD_REQUEST_URI_PATH_FORMAT = "/cv/a/%s/sdk/%s/fm/%s/piKey/%s/c/%s/k/%s/v/1/?nc=%d%s";
    private static final Logger.log log = Logger.get("CONTENT_PROVIDER_DEFAULT");
    private final HashMap cache = new HashMap();

    CvDefaultContentProvider()
    {
    }

    private ArrayList adSpaceCache(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!cache.containsKey(s))
        {
            cache.put(s, new ArrayList());
        }
        s = (ArrayList)cache.get(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public void checkAdsAvailable(Context context, CvContentOptions cvcontentoptions, CvContentManager.PreloaderListener preloaderlistener)
    {
        this;
        JVM INSTR monitorenter ;
        CvAppInfo.initialize(context);
        if (adSpaceCache(cvcontentoptions.adSpaceId).size() <= 0) goto _L2; else goto _L1
_L1:
        log.i(new Object[] {
            "Returning content from cache for", cvcontentoptions.adSpaceId
        });
        if (preloaderlistener == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        preloaderlistener.onPreloaderFinish(new CvPreloaderResponse());
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        log.i(new Object[] {
            "Loading content for", cvcontentoptions.adSpaceId
        });
        (new TestLoader(context, cvcontentoptions, preloaderlistener)).run();
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public boolean hasContent(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = adSpaceCache(s).size();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        throw s;
    }

    public CvContentManager.ContentLoader loadAd(Context context, CvContentOptions cvcontentoptions, CvContentManager.ContentListener contentlistener)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        CvAppInfo.initialize(context);
        context = new Loader(context, cvcontentoptions, contentlistener);
        arraylist = adSpaceCache(cvcontentoptions.adSpaceId);
        if (arraylist.size() <= 0) goto _L2; else goto _L1
_L1:
        log.i(new Object[] {
            "Ad already cached, returning content for", cvcontentoptions.adSpaceId
        });
        if (contentlistener == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        contentlistener.onContentLoaded(new CvContentResponse((JSONObject)arraylist.remove(0)));
        context.cancel();
_L4:
        this;
        JVM INSTR monitorexit ;
        return context;
_L2:
        log.i(new Object[] {
            "starting loader for", cvcontentoptions.adSpaceId
        });
        context.run();
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public void prefetchAd(Context context, final CvContentOptions options, final CvContentManager.PreloaderListener listener)
    {
        CvAppInfo.initialize(context);
        this;
        JVM INSTR monitorenter ;
        log.i(new Object[] {
            "Content already cached, skipping preload action", options.adSpaceId
        });
        if (adSpaceCache(options.adSpaceId).size() <= 0)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (listener == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        listener.onPreloaderFinish(new CvPreloaderResponse());
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        log.i(new Object[] {
            "Prefetching content for", options.adSpaceId
        });
        (new Loader(context, options, new CvContentManager.ContentListener() {

            final CvDefaultContentProvider this$0;
            final CvContentManager.PreloaderListener val$listener;
            final CvContentOptions val$options;

            public void onContentLoaded(CvContentResponse cvcontentresponse)
            {
                if (cvcontentresponse.isError)
                {
                    CvDefaultContentProvider.log.e(cvcontentresponse.error, new Object[] {
                        "Error while loading content for", options.adSpaceId, ":", cvcontentresponse.message
                    });
                    if (listener != null)
                    {
                        listener.onPreloaderFinish(new CvPreloaderResponse(cvcontentresponse.message, cvcontentresponse.code));
                    }
                    return;
                }
                synchronized (CvDefaultContentProvider.this)
                {
                    ArrayList arraylist = adSpaceCache(options.adSpaceId);
                    CvDefaultContentProvider.log.i(new Object[] {
                        "Got content for", options.adSpaceId
                    });
                    CvDefaultContentProvider.log.v(new Object[] {
                        "Content", cvcontentresponse.content
                    });
                    arraylist.add(cvcontentresponse.content);
                    if (listener != null)
                    {
                        listener.onPreloaderFinish(new CvPreloaderResponse());
                    }
                }
                return;
                cvcontentresponse;
                cvdefaultcontentprovider;
                JVM INSTR monitorexit ;
                throw cvcontentresponse;
            }

            
            {
                this$0 = CvDefaultContentProvider.this;
                options = cvcontentoptions;
                listener = preloaderlistener;
                super();
            }
        })).run();
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
    }



}
