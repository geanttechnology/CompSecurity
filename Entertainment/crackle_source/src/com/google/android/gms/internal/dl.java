// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            df, do, dk, dh, 
//            dn

public class dl extends df
{
    private class a
        implements Runnable
    {

        final dl mr;

        public void run()
        {
            boolean flag;
            flag = false;
            dl.a(mr, false);
            long l = SystemClock.elapsedRealtime();
            dl.a(mr).d(l, 3);
            dl.b(mr).d(l, 3);
            dl.c(mr).d(l, 3);
            dl.d(mr).d(l, 3);
            dl.e(mr).d(l, 3);
            Object obj = do.mw;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            if (dl.a(mr).bf() || dl.b(mr).bf() || dl.c(mr).bf() || dl.d(mr).bf() || dl.e(mr).bf())
            {
                flag = true;
            }
            obj;
            JVM INSTR monitorexit ;
            dl.b(mr, flag);
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        private a()
        {
            mr = dl.this;
            super();
        }

    }


    private static final long me;
    private static final long mf;
    private static final long mg;
    private static final long mh;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private long mi;
    private MediaStatus mj;
    private final do mk;
    private final do ml;
    private final do mm;
    private final do mn;
    private final do mo;
    private final Runnable mp = new a();
    private boolean mq;

    public dl()
    {
        super("urn:x-cast:com.google.cast.media", "MediaControlChannel");
        mk = new do(mf);
        ml = new do(mg);
        mm = new do(me);
        mn = new do(me);
        mo = new do(me);
        bd();
    }

    static do a(dl dl1)
    {
        return dl1.mk;
    }

    private void a(long l, JSONObject jsonobject)
        throws JSONException
    {
        int i;
        int j;
label0:
        {
            j = 1;
            boolean flag1 = mk.i(l);
            boolean flag;
            if (ml.bf() && !ml.i(l))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (mm.bf())
            {
                flag = j;
                if (!mm.i(l))
                {
                    break label0;
                }
            }
            if (mn.bf() && !mn.i(l))
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
        if (flag1 || mj == null)
        {
            mj = new MediaStatus(jsonobject);
            mi = SystemClock.elapsedRealtime();
            i = 7;
        } else
        {
            i = mj.a(jsonobject, j);
        }
        if ((i & 1) != 0)
        {
            mi = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0)
        {
            mi = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0)
        {
            onMetadataUpdated();
        }
        mk.c(l, 0);
        ml.c(l, 0);
        mm.c(l, 0);
        mn.c(l, 0);
        mo.c(l, 0);
    }

    static boolean a(dl dl1, boolean flag)
    {
        dl1.mq = flag;
        return flag;
    }

    static do b(dl dl1)
    {
        return dl1.ml;
    }

    static void b(dl dl1, boolean flag)
    {
        dl1.o(flag);
    }

    private void bd()
    {
        o(false);
        mi = 0L;
        mj = null;
        mk.clear();
        ml.clear();
        mm.clear();
    }

    static do c(dl dl1)
    {
        return dl1.mm;
    }

    static do d(dl dl1)
    {
        return dl1.mn;
    }

    static do e(dl dl1)
    {
        return dl1.mo;
    }

    private void o(boolean flag)
    {
label0:
        {
            if (mq != flag)
            {
                mq = flag;
                if (!flag)
                {
                    break label0;
                }
                mHandler.postDelayed(mp, mh);
            }
            return;
        }
        mHandler.removeCallbacks(mp);
    }

    public final void B(String s)
    {
        lx.b("message received: %s", new Object[] {
            s
        });
        Object obj;
        String s1;
        long l;
        obj = new JSONObject(s);
        s1 = ((JSONObject) (obj)).getString("type");
        l = ((JSONObject) (obj)).optLong("requestId", -1L);
        if (!s1.equals("MEDIA_STATUS"))
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj = ((JSONObject) (obj)).getJSONArray("status");
        if (((JSONArray) (obj)).length() > 0)
        {
            a(l, ((JSONArray) (obj)).getJSONObject(0));
            return;
        }
        try
        {
            mj = null;
            onStatusUpdated();
            onMetadataUpdated();
            mo.c(l, 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            lx.d("Message is malformed (%s); ignoring: %s", new Object[] {
                ((JSONException) (obj)).getMessage(), s
            });
        }
        return;
        if (s1.equals("INVALID_PLAYER_STATE"))
        {
            lx.d("received unexpected error: Invalid Player State.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            mk.b(l, 1, ((JSONObject) (obj)));
            ml.b(l, 1, ((JSONObject) (obj)));
            mm.b(l, 1, ((JSONObject) (obj)));
            mn.b(l, 1, ((JSONObject) (obj)));
            mo.b(l, 1, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("LOAD_FAILED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            mk.b(l, 1, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("LOAD_CANCELLED"))
        {
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            mk.b(l, 2, ((JSONObject) (obj)));
            return;
        }
        if (s1.equals("INVALID_REQUEST"))
        {
            lx.d("received unexpected error: Invalid Request.", new Object[0]);
            obj = ((JSONObject) (obj)).optJSONObject("customData");
            mk.b(l, 1, ((JSONObject) (obj)));
            ml.b(l, 1, ((JSONObject) (obj)));
            mm.b(l, 1, ((JSONObject) (obj)));
            mn.b(l, 1, ((JSONObject) (obj)));
            mo.b(l, 1, ((JSONObject) (obj)));
        }
        return;
    }

    public long a(dn dn)
        throws IOException
    {
        JSONObject jsonobject = new JSONObject();
        long l = aS();
        mo.a(l, dn);
        o(true);
        try
        {
            jsonobject.put("requestId", l);
            jsonobject.put("type", "GET_STATUS");
            if (mj != null)
            {
                jsonobject.put("mediaSessionId", mj.aQ());
            }
        }
        // Misplaced declaration of an exception variable
        catch (dn dn) { }
        a(jsonobject.toString(), l, null);
        return l;
    }

    public long a(dn dn, double d1, JSONObject jsonobject)
        throws IOException, IllegalStateException, IllegalArgumentException
    {
        JSONObject jsonobject1;
        long l;
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Volume cannot be ").append(d1).toString());
        }
        jsonobject1 = new JSONObject();
        l = aS();
        mm.a(l, dn);
        o(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", aQ());
        dn = new JSONObject();
        dn.put("level", d1);
        jsonobject1.put("volume", dn);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dn dn) { }
        }
        a(jsonobject1.toString(), l, null);
        return l;
    }

    public long a(dn dn, long l, int i, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = aS();
        ml.a(l1, dn);
        o(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "SEEK");
        jsonobject1.put("mediaSessionId", aQ());
        jsonobject1.put("currentTime", dh.h(l));
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
            catch (dn dn) { }
        }
        a(jsonobject1.toString(), l1, null);
        return l1;
_L2:
        if (i != 2) goto _L4; else goto _L3
_L3:
        jsonobject1.put("resumeState", "PLAYBACK_PAUSE");
          goto _L4
    }

    public long a(dn dn, MediaInfo mediainfo, boolean flag, long l, JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l1;
        jsonobject1 = new JSONObject();
        l1 = aS();
        mk.a(l1, dn);
        o(true);
        jsonobject1.put("requestId", l1);
        jsonobject1.put("type", "LOAD");
        jsonobject1.put("media", mediainfo.aP());
        jsonobject1.put("autoplay", flag);
        jsonobject1.put("currentTime", dh.h(l));
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dn dn) { }
        }
        a(jsonobject1.toString(), l1, null);
        return l1;
    }

    public long a(dn dn, boolean flag, JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = aS();
        mn.a(l, dn);
        o(true);
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "SET_VOLUME");
        jsonobject1.put("mediaSessionId", aQ());
        dn = new JSONObject();
        dn.put("muted", flag);
        jsonobject1.put("volume", dn);
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (dn dn) { }
        }
        a(jsonobject1.toString(), l, null);
        return l;
    }

    public void a(long l, int i)
    {
        mk.c(l, i);
        ml.c(l, i);
        mm.c(l, i);
        mn.c(l, i);
        mo.c(l, i);
    }

    public long aQ()
        throws IllegalStateException
    {
        if (mj == null)
        {
            throw new IllegalStateException("No current media session");
        } else
        {
            return mj.aQ();
        }
    }

    public void aT()
    {
        bd();
    }

    public void c(JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = aS();
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PAUSE");
        jsonobject1.put("mediaSessionId", aQ());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        a(jsonobject1.toString(), l, null);
        return;
    }

    public void d(JSONObject jsonobject)
        throws IOException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = aS();
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "STOP");
        jsonobject1.put("mediaSessionId", aQ());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        a(jsonobject1.toString(), l, null);
        return;
    }

    public void e(JSONObject jsonobject)
        throws IOException, IllegalStateException
    {
        JSONObject jsonobject1;
        long l;
        jsonobject1 = new JSONObject();
        l = aS();
        jsonobject1.put("requestId", l);
        jsonobject1.put("type", "PLAY");
        jsonobject1.put("mediaSessionId", aQ());
        if (jsonobject != null)
        {
            try
            {
                jsonobject1.put("customData", jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject) { }
        }
        a(jsonobject1.toString(), l, null);
        return;
    }

    public long getApproximateStreamPosition()
    {
        long l;
        long l1;
        MediaInfo mediainfo;
        for (mediainfo = getMediaInfo(); mediainfo == null || mi == 0L;)
        {
            return 0L;
        }

        double d1 = mj.getPlaybackRate();
        long l2 = mj.getStreamPosition();
        int i = mj.getPlayerState();
        if (d1 == 0.0D || i != 2)
        {
            return l2;
        }
        l = SystemClock.elapsedRealtime() - mi;
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
        if (mj == null)
        {
            return null;
        } else
        {
            return mj.getMediaInfo();
        }
    }

    public MediaStatus getMediaStatus()
    {
        return mj;
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
        me = TimeUnit.SECONDS.toMillis(3L);
        mf = TimeUnit.HOURS.toMillis(24L);
        mg = TimeUnit.SECONDS.toMillis(5L);
        mh = TimeUnit.SECONDS.toMillis(1L);
    }
}
