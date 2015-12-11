// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import shared_presage.com.google.android.exoplayer.upstream.Loader;
import shared_presage.com.google.android.exoplayer.upstream.UriDataSource;
import shared_presage.com.google.android.exoplayer.upstream.UriLoadable;

// Referenced classes of package shared_presage.com.google.android.exoplayer.util:
//            c, a, b

public class ManifestFetcher
    implements shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface EventListener
    {

        public abstract void onManifestError(IOException ioexception);

        public abstract void onManifestRefreshStarted();

        public abstract void onManifestRefreshed();
    }

    public static interface ManifestCallback
    {

        public abstract void onSingleManifest(Object obj);

        public abstract void onSingleManifestError(IOException ioexception);
    }

    public static interface RedirectingManifest
    {

        public abstract String getNextManifestUri();
    }

    private final class a
        implements shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
    {

        final ManifestFetcher a;
        private final UriLoadable b;
        private final Looper c;
        private final ManifestCallback d;
        private final Loader e = new Loader("manifestLoader:single");
        private long f;

        public final void a()
        {
            f = SystemClock.elapsedRealtime();
            e.startLoading(c, b, this);
        }

        public final void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
        {
            loadable = new IOException("Load cancelled", new CancellationException());
            d.onSingleManifestError(loadable);
            e.release();
            return;
            loadable;
            e.release();
            throw loadable;
        }

        public final void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
        {
            loadable = ((shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable) (b.getResult()));
            a.onSingleFetchCompleted(loadable, f);
            d.onSingleManifest(loadable);
            e.release();
            return;
            loadable;
            e.release();
            throw loadable;
        }

        public final void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
        {
            d.onSingleManifestError(ioexception);
            e.release();
            return;
            loadable;
            e.release();
            throw loadable;
        }

        public a(UriLoadable uriloadable, Looper looper, ManifestCallback manifestcallback)
        {
            a = ManifestFetcher.this;
            super();
            b = uriloadable;
            c = looper;
            d = manifestcallback;
        }
    }


    private long currentLoadStartTimestamp;
    private UriLoadable currentLoadable;
    private int enabledCount;
    private final Handler eventHandler;
    private final EventListener eventListener;
    private IOException loadException;
    private int loadExceptionCount;
    private long loadExceptionTimestamp;
    private Loader loader;
    private volatile Object manifest;
    private volatile long manifestLoadCompleteTimestamp;
    private volatile long manifestLoadStartTimestamp;
    volatile String manifestUri;
    private final shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser parser;
    private final UriDataSource uriDataSource;

    public ManifestFetcher(String s, UriDataSource uridatasource, shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser parser1)
    {
        this(s, uridatasource, parser1, null, null);
    }

    public ManifestFetcher(String s, UriDataSource uridatasource, shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser parser1, Handler handler, EventListener eventlistener)
    {
        parser = parser1;
        manifestUri = s;
        uriDataSource = uridatasource;
        eventHandler = handler;
        eventListener = eventlistener;
    }

    private long getRetryDelayMillis(long l)
    {
        return Math.min((l - 1L) * 1000L, 5000L);
    }

    private void notifyManifestError(IOException ioexception)
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new c(this, ioexception));
        }
    }

    private void notifyManifestRefreshStarted()
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new shared_presage.com.google.android.exoplayer.util.a(this));
        }
    }

    private void notifyManifestRefreshed()
    {
        if (eventHandler != null && eventListener != null)
        {
            eventHandler.post(new b(this));
        }
    }

    public void disable()
    {
        int i = enabledCount - 1;
        enabledCount = i;
        if (i == 0 && loader != null)
        {
            loader.release();
            loader = null;
        }
    }

    public void enable()
    {
        int i = enabledCount;
        enabledCount = i + 1;
        if (i == 0)
        {
            loadExceptionCount = 0;
            loadException = null;
        }
    }

    public Object getManifest()
    {
        return manifest;
    }

    public long getManifestLoadCompleteTimestamp()
    {
        return manifestLoadCompleteTimestamp;
    }

    public long getManifestLoadStartTimestamp()
    {
        return manifestLoadStartTimestamp;
    }

    public void maybeThrowError()
    {
        if (loadException == null || loadExceptionCount <= 1)
        {
            return;
        } else
        {
            throw loadException;
        }
    }

    public void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
    }

    public void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        if (currentLoadable != loadable)
        {
            return;
        }
        manifest = currentLoadable.getResult();
        manifestLoadStartTimestamp = currentLoadStartTimestamp;
        manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
        loadExceptionCount = 0;
        loadException = null;
        if (manifest instanceof RedirectingManifest)
        {
            loadable = ((RedirectingManifest)manifest).getNextManifestUri();
            if (!TextUtils.isEmpty(loadable))
            {
                manifestUri = loadable;
            }
        }
        notifyManifestRefreshed();
    }

    public void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        if (currentLoadable != loadable)
        {
            return;
        } else
        {
            loadExceptionCount = loadExceptionCount + 1;
            loadExceptionTimestamp = SystemClock.elapsedRealtime();
            loadException = new IOException(ioexception);
            notifyManifestError(loadException);
            return;
        }
    }

    void onSingleFetchCompleted(Object obj, long l)
    {
        manifest = obj;
        manifestLoadStartTimestamp = l;
        manifestLoadCompleteTimestamp = SystemClock.elapsedRealtime();
    }

    public void requestRefresh()
    {
        if (loadException == null || SystemClock.elapsedRealtime() >= loadExceptionTimestamp + getRetryDelayMillis(loadExceptionCount))
        {
            if (loader == null)
            {
                loader = new Loader("manifestLoader");
            }
            if (!loader.isLoading())
            {
                currentLoadable = new UriLoadable(manifestUri, uriDataSource, parser);
                currentLoadStartTimestamp = SystemClock.elapsedRealtime();
                loader.startLoading(currentLoadable, this);
                notifyManifestRefreshStarted();
                return;
            }
        }
    }

    public void singleLoad(Looper looper, ManifestCallback manifestcallback)
    {
        (new a(new UriLoadable(manifestUri, uriDataSource, parser), looper, manifestcallback)).a();
    }

    public void updateManifestUri(String s)
    {
        manifestUri = s;
    }

}
