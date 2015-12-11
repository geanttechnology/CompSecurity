// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import java.util.HashMap;

// Referenced classes of package com.apprupt.sdk:
//            CvViewHelper, AFP2, CvContentOptions, CvDefaultContentProvider, 
//            CvContentResponse, CvPreloaderResponse

public class CvContentManager
{
    public static interface ContentListener
    {

        public abstract void onContentLoaded(CvContentResponse cvcontentresponse);
    }

    public static interface ContentLoader
    {

        public abstract void cancel();
    }

    public static interface ContentProvider
    {

        public abstract void checkAdsAvailable(Context context, CvContentOptions cvcontentoptions, PreloaderListener preloaderlistener);

        public abstract boolean hasContent(String s);

        public abstract ContentLoader loadAd(Context context, CvContentOptions cvcontentoptions, ContentListener contentlistener);

        public abstract void prefetchAd(Context context, CvContentOptions cvcontentoptions, PreloaderListener preloaderlistener);
    }

    public static interface PreloaderListener
    {

        public abstract void onPreloaderFinish(CvPreloaderResponse cvpreloaderresponse);
    }


    private ContentProvider defaultProvider;
    private HashMap providers;

    CvContentManager()
    {
        providers = new HashMap();
        resetDefaultProvider();
    }

    private ContentProvider providerForAdSpace(int i)
    {
        return providerForAdSpace(String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    private ContentProvider providerForAdSpace(String s)
    {
        if (providers.containsKey(s))
        {
            return (ContentProvider)providers.get(s);
        } else
        {
            return defaultProvider;
        }
    }

    void checkAdsAvailable(Context context, CvContentOptions cvcontentoptions, final PreloaderListener listener)
    {
        CvViewHelper.runOnUIThread(new Runnable() {

            final CvContentManager this$0;
            final PreloaderListener val$listener;

            public void run()
            {
                listener.onPreloaderFinish(new CvPreloaderResponse());
            }

            
            {
                this$0 = CvContentManager.this;
                listener = preloaderlistener;
                super();
            }
        });
    }

    public ContentProvider getDefaultProvider()
    {
        return defaultProvider;
    }

    boolean hasContent(int i)
    {
        return hasContent(String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    boolean hasContent(String s)
    {
        return providerForAdSpace(s).hasContent(s);
    }

    ContentLoader loadAd(Context context, CvContentOptions cvcontentoptions, ContentListener contentlistener)
    {
        AFP2.start(context);
        return providerForAdSpace(cvcontentoptions.adSpaceId).loadAd(context, cvcontentoptions, contentlistener);
    }

    public void removeProvider(int i)
    {
        removeProvider(String.format("%d", new Object[] {
            Integer.valueOf(i)
        }));
    }

    public void removeProvider(String s)
    {
        setProvider(s, null);
    }

    public void resetDefaultProvider()
    {
        setDefaultProvider(null);
    }

    public void setDefaultProvider(ContentProvider contentprovider)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = contentprovider;
        if (contentprovider != null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        obj = new CvDefaultContentProvider();
        defaultProvider = ((ContentProvider) (obj));
        this;
        JVM INSTR monitorexit ;
        return;
        contentprovider;
        throw contentprovider;
    }

    public void setProvider(int i, ContentProvider contentprovider)
    {
        this;
        JVM INSTR monitorenter ;
        setProvider(String.format("%d", new Object[] {
            Integer.valueOf(i)
        }), contentprovider);
        this;
        JVM INSTR monitorexit ;
        return;
        contentprovider;
        throw contentprovider;
    }

    public void setProvider(String s, ContentProvider contentprovider)
    {
        this;
        JVM INSTR monitorenter ;
        if (contentprovider != null) goto _L2; else goto _L1
_L1:
        if (providers.containsKey(s))
        {
            providers.remove(s);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        providers.put(s, contentprovider);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }
}
