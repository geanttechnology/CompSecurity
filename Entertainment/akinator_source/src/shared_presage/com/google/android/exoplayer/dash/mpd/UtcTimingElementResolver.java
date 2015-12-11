// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.dash.mpd;

import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.CancellationException;
import shared_presage.com.google.android.exoplayer.ParserException;
import shared_presage.com.google.android.exoplayer.upstream.Loader;
import shared_presage.com.google.android.exoplayer.upstream.UriDataSource;
import shared_presage.com.google.android.exoplayer.upstream.UriLoadable;
import shared_presage.com.google.android.exoplayer.util.Assertions;
import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer.dash.mpd:
//            UtcTimingElement

public final class UtcTimingElementResolver
    implements shared_presage.com.google.android.exoplayer.upstream.Loader.Callback
{
    public static interface UtcTimingCallback
    {

        public abstract void onTimestampError(UtcTimingElement utctimingelement, IOException ioexception);

        public abstract void onTimestampResolved(UtcTimingElement utctimingelement, long l);
    }

    private static final class a
        implements shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser
    {

        private static Long a(InputStream inputstream)
        {
            inputstream = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
            long l;
            try
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
                l = simpledateformat.parse(inputstream).getTime();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new ParserException(inputstream);
            }
            return Long.valueOf(l);
        }

        public final Object parse(String s, InputStream inputstream)
        {
            return a(inputstream);
        }

        private a()
        {
        }

        a(byte byte0)
        {
            this();
        }
    }

    private static final class b
        implements shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser
    {

        private static Long a(InputStream inputstream)
        {
            inputstream = (new BufferedReader(new InputStreamReader(inputstream))).readLine();
            long l;
            try
            {
                l = Util.parseXsDateTime(inputstream);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new ParserException(inputstream);
            }
            return Long.valueOf(l);
        }

        public final Object parse(String s, InputStream inputstream)
        {
            return a(inputstream);
        }

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }


    private final UtcTimingCallback callback;
    private UriLoadable singleUseLoadable;
    private Loader singleUseLoader;
    private final UtcTimingElement timingElement;
    private final long timingElementElapsedRealtime;
    private final UriDataSource uriDataSource;

    private UtcTimingElementResolver(UriDataSource uridatasource, UtcTimingElement utctimingelement, long l, UtcTimingCallback utctimingcallback)
    {
        uriDataSource = uridatasource;
        timingElement = (UtcTimingElement)Assertions.checkNotNull(utctimingelement);
        timingElementElapsedRealtime = l;
        callback = (UtcTimingCallback)Assertions.checkNotNull(utctimingcallback);
    }

    private void releaseLoader()
    {
        singleUseLoader.release();
    }

    private void resolve()
    {
        String s = timingElement.schemeIdUri;
        if (Util.areEqual(s, "urn:mpeg:dash:utc:direct:2012"))
        {
            resolveDirect();
            return;
        }
        if (Util.areEqual(s, "urn:mpeg:dash:utc:http-iso:2014"))
        {
            resolveHttp(new a((byte)0));
            return;
        }
        if (Util.areEqual(s, "urn:mpeg:dash:utc:http-xsdate:2012") || Util.areEqual(s, "urn:mpeg:dash:utc:http-xsdate:2014"))
        {
            resolveHttp(new b((byte)0));
            return;
        } else
        {
            callback.onTimestampError(timingElement, new IOException("Unsupported utc timing scheme"));
            return;
        }
    }

    private void resolveDirect()
    {
        try
        {
            long l = Util.parseXsDateTime(timingElement.value);
            long l1 = timingElementElapsedRealtime;
            callback.onTimestampResolved(timingElement, l - l1);
            return;
        }
        catch (ParseException parseexception)
        {
            callback.onTimestampError(timingElement, new ParserException(parseexception));
        }
    }

    private void resolveHttp(shared_presage.com.google.android.exoplayer.upstream.UriLoadable.Parser parser)
    {
        singleUseLoader = new Loader("utctiming");
        singleUseLoadable = new UriLoadable(timingElement.value, uriDataSource, parser);
        singleUseLoader.startLoading(singleUseLoadable, this);
    }

    public static void resolveTimingElement(UriDataSource uridatasource, UtcTimingElement utctimingelement, long l, UtcTimingCallback utctimingcallback)
    {
        (new UtcTimingElementResolver(uridatasource, utctimingelement, l, utctimingcallback)).resolve();
    }

    public final void onLoadCanceled(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        onLoadError(loadable, new IOException("Load cancelled", new CancellationException()));
    }

    public final void onLoadCompleted(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable)
    {
        singleUseLoader.release();
        long l = ((Long)singleUseLoadable.getResult()).longValue();
        long l1 = SystemClock.elapsedRealtime();
        callback.onTimestampResolved(timingElement, l - l1);
    }

    public final void onLoadError(shared_presage.com.google.android.exoplayer.upstream.Loader.Loadable loadable, IOException ioexception)
    {
        singleUseLoader.release();
        callback.onTimestampError(timingElement, ioexception);
    }
}
