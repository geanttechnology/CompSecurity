// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            dp, dy, du, dr, 
//            dx

public class dv extends dp
{
    private class a
        implements Runnable
    {

        final dv yy;

        public void run()
        {
            boolean flag;
            flag = false;
            dv.a(yy, false);
            long l = SystemClock.elapsedRealtime();
            dv.a(yy).d(l, 3);
            dv.b(yy).d(l, 3);
            dv.c(yy).d(l, 3);
            dv.d(yy).d(l, 3);
            dv.e(yy).d(l, 3);
            dv.f(yy).d(l, 3);
            dv.g(yy).d(l, 3);
            dv.h(yy).d(l, 3);
            Object obj = dy.yD;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            if (dv.a(yy).dl() || dv.e(yy).dl() || dv.f(yy).dl() || dv.g(yy).dl() || dv.h(yy).dl())
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            dv.b(yy, flag);
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private a()
        {
            yy = dv.this;
            super();
        }

    }


    private static final long yi;
    private static final long yj;
    private static final long yk;
    private static final long yl;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private long ym;
    private MediaStatus yn;
    private final dy yo;
    private final dy yp;
    private final dy yq;
    private final dy yr;
    private final dy ys;
    private final dy yt;
    private final dy yu;
    private final dy yv;
    private final Runnable yw = new a();
    private boolean yx;

    public dv()
    {
        super("urn:x-cast:com.google.cast.media", "MediaControlChannel");
        yo = new dy(yj);
        yp = new dy(yi);
        yq = new dy(yi);
        yr = new dy(yi);
        ys = new dy(yk);
        yt = new dy(yi);
        yu = new dy(yi);
        yv = new dy(yi);
        dj();
    }

    static dy a(dv dv1)
    {
        return dv1.yo;
    }

    private void a(long l, JSONObject jsonobject)
        throws JSONException
    {
        int i;
        int j;
label0:
        {
            j = 1;
            boolean flag1 = yo.m(l);
            boolean flag;
            if (ys.dl() && !ys.m(l))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (yt.dl())
            {
                flag = j;
                if (!yt.m(l))
                {
                    break label0;
                }
            }
            if (yu.dl() && !yu.m(l))
            {
                flag = j;
            } else
            {
                flag = false;
            }
        }
        if (i != 0)
        {
            i = 2;
        } else
        {
            i = 0;
        }
        j = i;
        if (flag)
        {
            j = i | 1;
        }
        if (flag1 || yn == null)
        {
            yn = new MediaStatus(jsonobject);
            ym = SystemClock.elapsedRealtime();
            i = 7;
        } else
        {
            i = yn.a(jsonobject, j);
        }
        if ((i & 1) != 0)
        {
            ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0)
        {
            ym = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0)
        {
            onMetadataUpdated();
        }
        yo.c(l, 0);
        yp.c(l, 0);
        yq.c(l, 0);
        yr.c(l, 0);
        ys.c(l, 0);
        yt.c(l, 0);
        yu.c(l, 0);
        yv.c(l, 0);
    }

    static boolean a(dv dv1, boolean flag)
    {
        dv1.yx = flag;
        return flag;
    }

    static dy b(dv dv1)
    {
        return dv1.yp;
    }

    static void b(dv dv1, boolean flag)
    {
        dv1.u(flag);
    }

    static dy c(dv dv1)
    {
        return dv1.yq;
    }

    static dy d(dv dv1)
    {
        return dv1.yr;
    }

    private void dj()
    {
        u(false);
        ym = 0L;
        yn = null;
        yo.clear();
        ys.clear();
        yt.clear();
    }

    static dy e(dv dv1)
    {
        return dv1.ys;
    }

    static dy f(dv dv1)
    {
        return dv1.yt;
    }

    static dy g(dv dv1)
    {
        return dv1.yu;
    }

    static dy h(dv dv1)
    {
        return dv1.yv;
    }

    private void u(boolean flag)
    {
label0:
        {
            if (yx != flag)
            {
                yx = flag;
                if (!flag)
                {
                    break label0;
                }
                mHandler.postDelayed(yw, yl);
            }
            return;
        }
        mHandler.removeCallbacks(yw);
    }

    public final void P(String s)
    {
        xB.b("message received: %s", new Object[] {
            s
        });
        Object obj;
        String s1;
        long l;
        obj = JSONObjectInstrumentation.init(s);
        s1 = ((JSONObject) (obj)).getString("type");
        l = ((JSONObject) (obj)).optLong("requestId", -1L);
        if (!s1.equals("MEDIA_STATUS"))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        obj = ((JSONObject) (obj)).getJSONArray("status");
        if (((JSONArray) (obj)).length() > 0)
        {
            a(l, ((JSONArray) (obj)).getJSONObject(0));
            return;
        }
        try
        {
            yn = null;
            onStatusUpdated();
            onMetadataUpdated();
            yv.c(l, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            xB.d("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
        }
        return;
        if (s1.equals("INVALID_PLAYER_STATE"))
        {
            xB.d("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            yo.b(l, 1, ((JSONObject) (obj)));
            yp.b(l, 1, ((JSONObject) (obj)));
            yq.b(l, 1, ((JSONObject) (obj)));
            yr.b(l, 1, ((JSONObject) (obj)));
            ys.b(l, 1, ((JSONObject) (obj)));
            yt.b(l, 1, ((JSONObject) (obj)));
            yu.b(l, 1, ((JSONObject) (obj)));
            yv.b(l, 1, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            yo.b(l, 1, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            yo.b(l, 2, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("INVALID_REQUEST"))
        {
            xB.d("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            yo.b(l, 1, ((JSONObject) (obj)));
            yp.b(l, 1, ((JSONObject) (obj)));
            yq.b(l, 1, ((JSONObject) (obj)));
            yr.b(l, 1, ((JSONObject) (obj)));
            ys.b(l, 1, ((JSONObject) (obj)));
            yt.b(l, 1, ((JSONObject) (obj)));
            yu.b(l, 1, ((JSONObject) (obj)));
            yv.b(l, 1, ((JSONObject) (obj)));
        }
        return;
    }

    public long a(dx dx)
        throws IOException
    {
        JSONObject jsonobject = new JSONObject();
        long l = cW();
        yv.a(l, dx);
        u(true);
        try
        {
            jsonobject.put("requestId", l);
            jsonobject.put("type", "GET_STATUS");
            if (yn != null)
            {
                jsonobject.put("mediaSessionId", yn.cU());
            }
        }
        // Misplaced declaration of an exception variable
        catch (dx dx) { }
        if (!(jsonobject instanceof JSONObject))
        {
            dx = jsonobject.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        a(((String) (dx)), l, null);
        return l;
    }

    public long a(dx dx, double d1, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d1).toString());
        }
        jsonobject1 = new JSONObject();
        l = cW();
        yt.a(l, dx);
        u(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", cU());
        dx = new JSONObject();
        dx.put("level", d1);
        jsonobject1.put("volume", dx);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(((String) (dx)), l, null);
        return l;
    }

    public long a(dx dx, long l, int i, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = cW();
        ys.a(l1, dx);
        u(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", cU());
        jsonobject1.put("currentTime", dr.l(l));
        if (i != 1) goto _L2; else goto _L1
_L1:
        jsonobject1.put("resumeState", "PLAYBACK_START");
_L4:
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(((String) (dx)), l1, null);
        return l1;
_L2:
        if (i != 2) goto _L4; else goto _L3
_L3:
        jsonobject1.put("resumeState", "PLAYBACK_PAUSE");
          goto _L4
    }

    public long a(dx dx, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = cW();
        yo.a(l1, dx);
        u(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "LOAD");
        jsonobject1.put("media", mediainfo.cT());
        jsonobject1.put("autoplay", flag);
        jsonobject1.put("currentTime", dr.l(l));
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(((String) (dx)), l1, null);
        return l1;
    }

    public long a(dx dx, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = cW();
        yp.a(l, dx);
        u(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", cU());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(((String) (dx)), l, null);
        return l;
    }

    public long a(dx dx, boolean flag, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = cW();
        yu.a(l, dx);
        u(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", cU());
        dx = new JSONObject();
        dx.put("muted", flag);
        jsonobject1.put("volume", dx);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(((String) (dx)), l, null);
        return l;
    }

    public void a(long l, int i)
    {
        yo.c(l, i);
        yp.c(l, i);
        yq.c(l, i);
        yr.c(l, i);
        ys.c(l, i);
        yt.c(l, i);
        yu.c(l, i);
        yv.c(l, i);
    }

    public long b(dx dx, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = cW();
        yr.a(l, dx);
        u(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "STOP");
        jsonobject1.put("mediaSessionId", cU());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(dx, l, null);
        return l;
    }

    public long c(dx dx, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = cW();
        yq.a(l, dx);
        u(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", cU());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dx dx) { }
        }
        if (!(jsonobject1 instanceof JSONObject))
        {
            dx = jsonobject1.toString();
        } else
        {
            dx = JSONObjectInstrumentation.toString((JSONObject)jsonobject1);
        }
        a(dx, l, null);
        return l;
    }

    public long cU()
        throws IllegalStateException
    {
        if (yn == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return yn.cU();
        }
    }

    public void cX()
    {
        dj();
    }

    public long getApproximateStreamPosition()
    {
        long l;
        long l1;
        MediaInfo mediainfo;
        for (mediainfo = getMediaInfo(); mediainfo == null || ym == 0L;)
        {
            return 0L;
        }

        double d1 = yn.getPlaybackRate();
        long l2 = yn.getStreamPosition();
        int i = yn.getPlayerState();
        if (d1 == 0.0D || i != 2)
        {
            return l2;
        }
        l = SystemClock.elapsedRealtime() - ym;
        if (l < 0L)
        {
            l = 0L;
        }
        if (l == 0L)
        {
            return l2;
        }
        l1 = mediainfo.getStreamDuration();
        l = l2 + (long)((double)l * d1);
        if (l <= l1) goto _L2; else goto _L1
_L1:
        l = l1;
_L4:
        return l;
_L2:
        if (l < 0L)
        {
            l = 0L;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public MediaInfo getMediaInfo()
    {
        if (yn == null)
        {
            return null;
        } else
        {
            return yn.getMediaInfo();
        }
    }

    public MediaStatus getMediaStatus()
    {
        return yn;
    }

    public long getStreamDuration()
    {
        MediaInfo mediainfo = getMediaInfo();
        if (mediainfo != null)
        {
            return mediainfo.getStreamDuration();
        } else
        {
            return 0L;
        }
    }

    protected void onMetadataUpdated()
    {
    }

    protected void onStatusUpdated()
    {
    }

    static 
    {
        yi = TimeUnit.HOURS.toMillis(24L);
        yj = TimeUnit.HOURS.toMillis(24L);
        yk = TimeUnit.HOURS.toMillis(24L);
        yl = TimeUnit.SECONDS.toMillis(1L);
    }
}
