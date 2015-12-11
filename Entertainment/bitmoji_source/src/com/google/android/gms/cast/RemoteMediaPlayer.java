// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.dv;
import com.google.android.gms.internal.dw;
import com.google.android.gms.internal.dx;
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
        implements dw
    {

        final RemoteMediaPlayer xk;
        private GoogleApiClient xu;
        private long xv;

        public void a(String s, String s1, long l, String s2)
            throws IOException
        {
            if (xu == null)
            {
                throw new IOException("No GoogleApiClient available");
            } else
            {
                Cast.CastApi.sendMessage(xu, s, s1).setResultCallback(new a(this, l));
                return;
            }
        }

        public void b(GoogleApiClient googleapiclient)
        {
            xu = googleapiclient;
        }

        public long cV()
        {
            long l = xv + 1L;
            xv = l;
            return l;
        }

        public a()
        {
            xk = RemoteMediaPlayer.this;
            super();
            xv = 0L;
        }
    }

    private final class a.a
        implements ResultCallback
    {

        private final long xw;
        final a xx;

        public void i(Status status)
        {
            if (!status.isSuccess())
            {
                RemoteMediaPlayer.e(xx.xk).a(xw, status.getStatusCode());
            }
        }

        public void onResult(Result result)
        {
            i((Status)result);
        }

        a.a(a a1, long l)
        {
            xx = a1;
            super();
            xw = l;
        }
    }

    private static abstract class b extends Cast.a
    {

        dx xy;

        public Result d(Status status)
        {
            return j(status);
        }

        public MediaChannelResult j(Status status)
        {
            return new MediaChannelResult(this, status) {

                final Status vb;
                final b xz;

                public Status getStatus()
                {
                    return vb;
                }

            
            {
                xz = b1;
                vb = status;
                super();
            }
            };
        }

        b()
        {
            xy = new _cls1(this);
        }
    }

    private static final class c
        implements MediaChannelResult
    {

        private final Status vl;
        private final JSONObject wP;

        public Status getStatus()
        {
            return vl;
        }

        c(Status status, JSONObject jsonobject)
        {
            vl = status;
            wP = jsonobject;
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
    private final Object mg = new Object();
    private final dv xg = new dv() {

        final RemoteMediaPlayer xk;

        protected void onMetadataUpdated()
        {
            RemoteMediaPlayer.b(xk);
        }

        protected void onStatusUpdated()
        {
            RemoteMediaPlayer.a(xk);
        }

            
            {
                xk = RemoteMediaPlayer.this;
                super();
            }
    };
    private final a xh = new a();
    private OnMetadataUpdatedListener xi;
    private OnStatusUpdatedListener xj;

    public RemoteMediaPlayer()
    {
        xg.a(xh);
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
        return remotemediaplayer.mg;
    }

    static a d(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.xh;
    }

    static dv e(RemoteMediaPlayer remotemediaplayer)
    {
        return remotemediaplayer.xg;
    }

    private void onMetadataUpdated()
    {
        if (xi != null)
        {
            xi.onMetadataUpdated();
        }
    }

    private void onStatusUpdated()
    {
        if (xj != null)
        {
            xj.onStatusUpdated();
        }
    }

    public long getApproximateStreamPosition()
    {
        long l;
        synchronized (mg)
        {
            l = xg.getApproximateStreamPosition();
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
        synchronized (mg)
        {
            mediainfo = xg.getMediaInfo();
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
        synchronized (mg)
        {
            mediastatus = xg.getMediaStatus();
        }
        return mediastatus;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String getNamespace()
    {
        return xg.getNamespace();
    }

    public long getStreamDuration()
    {
        long l;
        synchronized (mg)
        {
            l = xg.getStreamDuration();
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

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final MediaInfo xm;
            final boolean xn;
            final long xo;
            final JSONObject xp;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).a(xy, xm, xn, xo, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xm = mediainfo;
                xn = flag;
                xo = l;
                xp = jsonobject;
                super();
            }
        });
    }

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        xg.P(s1);
    }

    public PendingResult pause(GoogleApiClient googleapiclient)
    {
        return pause(googleapiclient, null);
    }

    public PendingResult pause(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, jsonobject) {

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final JSONObject xp;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).a(xy, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xp = jsonobject;
                super();
            }
        });
    }

    public PendingResult play(GoogleApiClient googleapiclient)
    {
        return play(googleapiclient, null);
    }

    public PendingResult play(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, jsonobject) {

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final JSONObject xp;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).c(xy, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xp = jsonobject;
                super();
            }
        });
    }

    public PendingResult requestStatus(GoogleApiClient googleapiclient)
    {
        return googleapiclient.b(new b(googleapiclient) {

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).a(xy);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
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

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final JSONObject xp;
            final long xq;
            final int xr;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).a(xy, xq, xr, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xq = l;
                xr = i;
                xp = jsonobject;
                super();
            }
        });
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener onmetadataupdatedlistener)
    {
        xi = onmetadataupdatedlistener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener onstatusupdatedlistener)
    {
        xj = onstatusupdatedlistener;
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag)
    {
        return setStreamMute(googleapiclient, flag, null);
    }

    public PendingResult setStreamMute(GoogleApiClient googleapiclient, boolean flag, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, flag, jsonobject) {

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final JSONObject xp;
            final boolean xt;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).a(xy, xt, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xt = flag;
                xp = jsonobject;
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

                final RemoteMediaPlayer xk;
                final GoogleApiClient xl;
                final JSONObject xp;
                final double xs;

                protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                    throws RemoteException
                {
                    a((dq)a1);
                }

                protected void a(dq dq1)
                {
                    dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                    dq1;
                    JVM INSTR monitorenter ;
                    RemoteMediaPlayer.d(xk).b(xl);
                    RemoteMediaPlayer.e(xk).a(xy, xs, xp);
                    RemoteMediaPlayer.d(xk).b(null);
_L1:
                    dq1;
                    JVM INSTR monitorexit ;
                    return;
                    Object obj;
                    obj;
                    a(((Result) (j(new Status(1)))));
                    RemoteMediaPlayer.d(xk).b(null);
                      goto _L1
                    obj;
                    dq1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    a(((Result) (j(new Status(1)))));
                    RemoteMediaPlayer.d(xk).b(null);
                      goto _L1
                    obj;
                    a(((Result) (j(new Status(1)))));
                    RemoteMediaPlayer.d(xk).b(null);
                      goto _L1
                    obj;
                    RemoteMediaPlayer.d(xk).b(null);
                    throw obj;
                }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xs = d1;
                xp = jsonobject;
                super();
            }
            });
        }
    }

    public PendingResult stop(GoogleApiClient googleapiclient)
    {
        return stop(googleapiclient, null);
    }

    public PendingResult stop(GoogleApiClient googleapiclient, JSONObject jsonobject)
    {
        return googleapiclient.b(new b(googleapiclient, jsonobject) {

            final RemoteMediaPlayer xk;
            final GoogleApiClient xl;
            final JSONObject xp;

            protected volatile void a(com.google.android.gms.common.api.Api.a a1)
                throws RemoteException
            {
                a((dq)a1);
            }

            protected void a(dq dq1)
            {
                dq1 = ((dq) (RemoteMediaPlayer.c(xk)));
                dq1;
                JVM INSTR monitorenter ;
                RemoteMediaPlayer.d(xk).b(xl);
                RemoteMediaPlayer.e(xk).b(xy, xp);
                RemoteMediaPlayer.d(xk).b(null);
_L1:
                dq1;
                JVM INSTR monitorexit ;
                return;
                Object obj;
                obj;
                a(((Result) (j(new Status(1)))));
                RemoteMediaPlayer.d(xk).b(null);
                  goto _L1
                obj;
                dq1;
                JVM INSTR monitorexit ;
                throw obj;
                obj;
                RemoteMediaPlayer.d(xk).b(null);
                throw obj;
            }

            
            {
                xk = RemoteMediaPlayer.this;
                xl = googleapiclient;
                xp = jsonobject;
                super();
            }
        });
    }

    // Unreferenced inner class com/google/android/gms/cast/RemoteMediaPlayer$b$1

/* anonymous class */
    class b._cls1
        implements dx
    {

        final b xz;

        public void a(long l, int i, JSONObject jsonobject)
        {
            xz.a(new c(new Status(i), jsonobject));
        }

        public void k(long l)
        {
            xz.a(xz.j(new Status(4)));
        }

            
            {
                xz = b1;
                super();
            }
    }

}
