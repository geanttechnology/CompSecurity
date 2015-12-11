// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dl;
import com.google.android.gms.internal.dm;
import com.google.android.gms.internal.dn;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            MediaInfo, MediaStatus, CastDevice, Cast

public class RemoteMediaPlayer
    implements Cast.MessageReceivedCallback
{
    public static interface MediaChannelResult
        extends Result
    {
    }

    public static interface OnMetadataUpdatedListener
    {

        public abstract void onMetadataUpdated();
    }

    public static interface OnStatusUpdatedListener
    {

        public abstract void onStatusUpdated();
    }

    private class a
        implements dm
    {

        final RemoteMediaPlayer lh;
        private GoogleApiClient lr;
        private long ls;

        public void a(String s, String s1, long l, String s2)
            throws IOException
        {
            if (lr == null)
            {
                throw new IOException("No GoogleApiClient available");
            } else
            {
                Cast.CastApi.sendMessage(lr, s, s1).setResultCallback(new a(this, l));
                return;
            }
        }

        public long aR()
        {
            long l = ls + 1L;
            ls = l;
            return l;
        }

        public void b(GoogleApiClient googleapiclient)
        {
            lr = googleapiclient;
        }

        public a()
        {
            lh = RemoteMediaPlayer.this;
            super();
            ls = 0L;
        }
    }

    private final class a.a
        implements ResultCallback
    {

        private final long lt;
        final a lu;

        public void j(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.e(lu.lh).a(lt, status.getStatusCode());
            }
        }

        public void onResult(Result result)
        {
            j((Status)result);
        }

        a.a(a a1, long l)
        {
            lu = a1;
            super();
            lt = l;
        }
    }

    private static abstract class b extends Cast.a
    {

        dn lv;

        public Result e(Status status)
        {
            return k(status);
        }

        public MediaChannelResult k(Status status)
        {
            return new MediaChannelResult(this, status) {

                final Status jP;
                final b lw;

                public Status getStatus()
                {
                    return jP;
                }

            
            {
                lw = b1;
                jP = status;
                super();
            }
            };
        }

        b()
        {
            lv = new _cls1(this);
        }
    }

    private static final class c
        implements MediaChannelResult
    {

        private final Status jY;
        private final JSONObject kM;

        public Status getStatus()
        {
            return jY;
        }

        c(Status status, JSONObject jsonobject)
        {
            jY = status;
            kM = jsonobject;
        }
    }


    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2;
    public static final int STATUS_FAILED = 1;
    public static final int STATUS_REPLACED = 4;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 3;
    private final Object fx = new Object();
    private final dl ld = new dl() {

        final RemoteMediaPlayer lh;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.b(lh);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.a(lh);
        }

            
            {
                lh = RemoteMediaPlayer.this;
                super();
            }
    };
    private final a le = new a();
    private OnMetadataUpdatedListener lf;
    private OnStatusUpdatedListener lg;

    public RemoteMediaPlayer()
    {
        ld.a(le);
    }

    static void a(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onStatusUpdated();
    }

    static void b(RemoteMediaPlayer remotemediaplayer)
    {
        remotemediaplayer.onMetadataUpdated();
    }

    static Object c(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.fx;
    }

    static a d(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.le;
    }

    static dl e(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.ld;
    }

    private void onMetadataUpdated()
    {
        if (lf != null)
        {
            lf.onMetadataUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (lg != null)
        {
            lg.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (fx)
        {
            l = ld.getApproximateStreamPosition();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaInfo getMediaInfo()
    {
        MediaInfo mediainfo;
        synchronized (fx)
        {
            mediainfo = ld.getMediaInfo();
        }
        return mediainfo;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MediaStatus getMediaStatus()
    {
        MediaStatus mediastatus;
        synchronized (fx)
        {
            mediastatus = ld.getMediaStatus();
        }
        return mediastatus;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getNamespace()
    {
        return ld.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (fx)
        {
            l = ld.getStreamDuration();
        }
        return l;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo)
    {
        return load(googleapiclient, mediainfo, true, 0L, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag)
    {
        return load(googleapiclient, mediainfo, flag, 0L, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l)
    {
        return load(googleapiclient, mediainfo, flag, l, null);
    }

    public PendingResult load(GoogleApiClient googleapiclient, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, mediainfo, flag, l, jsonobject) {

            final RemoteMediaPlayer lh;
            final GoogleApiClient li;
            final MediaInfo lj;
            final boolean lk;
            final long ll;
            final JSONObject lm;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dg)a1);
            }

            protected void a(dg dg1)
            {
                dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
                dg1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(lh).b(li);
                RemoteMediaPlayer.e(lh).a(lv, lj, lk, ll, lm);
                RemoteMediaPlayer.d(lh).b(null);
_L1:
                dg1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (k(new Status(1)))));
                RemoteMediaPlayer.d(lh).b(null);
                  goto _L1
                obj;
                dg1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(lh).b(null);
                throw obj;
            }

            
            {
                lh = RemoteMediaPlayer.this;
                li = googleapiclient;
                lj = mediainfo;
                lk = flag;
                ll = l;
                lm = jsonobject;
                super();
            }
        });
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        ld.B(s1);
    }

    public void pause(GoogleApiClient googleapiclient)
        throws IOException
    {
        pause(googleapiclient, null);
    }

    public void pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
        throws IOException
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        le.b(googleapiclient);
        ld.c(jsonobject);
        le.b(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        googleapiclient;
        le.b(null);
        throw googleapiclient;
        googleapiclient;
        obj;
        JVM INSTR monitorexit ;
        throw googleapiclient;
    }

    public void play(GoogleApiClient googleapiclient)
        throws IOException, IllegalStateException
    {
        play(googleapiclient, null);
    }

    public void play(GoogleApiClient googleapiclient, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        le.b(googleapiclient);
        ld.e(jsonobject);
        le.b(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        googleapiclient;
        le.b(null);
        throw googleapiclient;
        googleapiclient;
        obj;
        JVM INSTR monitorexit ;
        throw googleapiclient;
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new b(googleapiclient) {

            final RemoteMediaPlayer lh;
            final GoogleApiClient li;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dg)a1);
            }

            protected void a(dg dg1)
            {
                dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
                dg1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(lh).b(li);
                RemoteMediaPlayer.e(lh).a(lv);
                RemoteMediaPlayer.d(lh).b(null);
_L1:
                dg1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (k(new Status(1)))));
                RemoteMediaPlayer.d(lh).b(null);
                  goto _L1
                obj;
                dg1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(lh).b(null);
                throw obj;
            }

            
            {
                lh = RemoteMediaPlayer.this;
                li = googleapiclient;
                super();
            }
        });
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l)
    {
        return seek(googleapiclient, l, 0, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i)
    {
        return seek(googleapiclient, l, i, null);
    }

    public PendingResult seek(GoogleApiClient googleapiclient, long l, int i, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, l, i, jsonobject) {

            final RemoteMediaPlayer lh;
            final GoogleApiClient li;
            final JSONObject lm;
            final long ln;
            final int lo;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dg)a1);
            }

            protected void a(dg dg1)
            {
                dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
                dg1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(lh).b(li);
                RemoteMediaPlayer.e(lh).a(lv, ln, lo, lm);
                RemoteMediaPlayer.d(lh).b(null);
_L1:
                dg1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (k(new Status(1)))));
                RemoteMediaPlayer.d(lh).b(null);
                  goto _L1
                obj;
                dg1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(lh).b(null);
                throw obj;
            }

            
            {
                lh = RemoteMediaPlayer.this;
                li = googleapiclient;
                ln = l;
                lo = i;
                lm = jsonobject;
                super();
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        lf = onmetadataupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        lg = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, flag, jsonobject) {

            final RemoteMediaPlayer lh;
            final GoogleApiClient li;
            final JSONObject lm;
            final boolean lq;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
            {
                a((dg)a1);
            }

            protected void a(dg dg1)
            {
                dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
                dg1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(lh).b(li);
                RemoteMediaPlayer.e(lh).a(lv, lq, lm);
                RemoteMediaPlayer.d(lh).b(null);
_L1:
                dg1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (k(new Status(1)))));
                RemoteMediaPlayer.d(lh).b(null);
                  goto _L1
                obj;
                dg1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                a(((Result) (k(new Status(1)))));
                RemoteMediaPlayer.d(lh).b(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.d(lh).b(null);
                throw obj;
            }

            
            {
                lh = RemoteMediaPlayer.this;
                li = googleapiclient;
                lq = flag;
                lm = jsonobject;
                super();
            }
        });
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d1)
        throws IllegalArgumentException
    {
        return setStreamVolume(googleapiclient, d1, null);
    }

    public PendingResult setStreamVolume(GoogleApiClient googleapiclient, double d1, JSONObject jsonobject)
        throws IllegalArgumentException
    {
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d1).toString());
        } else
        {
            return googleapiclient.b(new b(googleapiclient, d1, jsonobject) {

                final RemoteMediaPlayer lh;
                final GoogleApiClient li;
                final JSONObject lm;
                final double lp;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                {
                    a((dg)a1);
                }

                protected void a(dg dg1)
                {
                    dg1 = ((dg) (RemoteMediaPlayer.c(lh)));
                    dg1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.d(lh).b(li);
                    RemoteMediaPlayer.e(lh).a(lv, lp, lm);
                    RemoteMediaPlayer.d(lh).b(null);
_L1:
                    dg1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    a(((Result) (k(new Status(1)))));
                    RemoteMediaPlayer.d(lh).b(null);
                      goto _L1
                    obj;
                    dg1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    a(((Result) (k(new Status(1)))));
                    RemoteMediaPlayer.d(lh).b(null);
                      goto _L1
                    obj;
                    a(((Result) (k(new Status(1)))));
                    RemoteMediaPlayer.d(lh).b(null);
                      goto _L1
                    obj;
                    RemoteMediaPlayer.d(lh).b(null);
                    throw obj;
                }

            
            {
                lh = RemoteMediaPlayer.this;
                li = googleapiclient;
                lp = d1;
                lm = jsonobject;
                super();
            }
            });
        }
    }

    public void stop(GoogleApiClient googleapiclient)
        throws IOException
    {
        stop(googleapiclient, null);
    }

    public void stop(GoogleApiClient googleapiclient, JSONObject jsonobject)
        throws IOException
    {
        Object obj = fx;
        obj;
        JVM INSTR monitorenter ;
        le.b(googleapiclient);
        ld.d(jsonobject);
        le.b(null);
        obj;
        JVM INSTR monitorexit ;
        return;
        googleapiclient;
        le.b(null);
        throw googleapiclient;
        googleapiclient;
        obj;
        JVM INSTR monitorexit ;
        throw googleapiclient;
    }

    // Unreferenced inner class com/google/android/gms/cast/RemoteMediaPlayer$b$1

/* anonymous class */
    class b._cls1
        implements dn
    {

        final b lw;

        public void a(long l, int i, JSONObject jsonobject)
        {
            lw.a(new c(new Status(i), jsonobject));
        }

        public void g(long l)
        {
            lw.a(lw.k(new Status(4)));
        }

            
            {
                lw = b1;
                super();
            }
    }

}
