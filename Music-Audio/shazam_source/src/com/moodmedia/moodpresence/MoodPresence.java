// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import android.content.Context;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.moodmedia.moodpresence:
//            h, i, a, MoodPresenceHandler, 
//            MoodPresenceResult, g

public final class MoodPresence extends Enum
    implements h
{

    public static final MoodPresence INSTANCE;
    private static final MoodPresence k[];
    private a a;
    private String b;
    private Integer c;
    private ArrayList d;
    private Boolean e;
    private i f;
    private int g;
    private ByteBuffer h;
    private ShortBuffer i;
    private short j[];

    private MoodPresence(String s, int l)
    {
        super(s, l);
        c = Integer.valueOf(44100);
        g = 3;
    }

    private void a()
    {
        if (!isInitialized())
        {
            throw new IllegalStateException("MoodPresence instance was not properly initialized");
        } else
        {
            return;
        }
    }

    public static MoodPresence valueOf(String s)
    {
        return (MoodPresence)Enum.valueOf(com/moodmedia/moodpresence/MoodPresence, s);
    }

    public static MoodPresence[] values()
    {
        return (MoodPresence[])k.clone();
    }

    public final void addSamples(byte abyte0[], int l, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (h == null)
        {
            h = ByteBuffer.allocate(getBufferLength().intValue() * 2);
            h.order(ByteOrder.LITTLE_ENDIAN);
            i = h.asShortBuffer();
            h.position(0);
            i.position(0);
            j = new short[getBufferLength().intValue()];
        }
          goto _L1
_L3:
        int j1;
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        int k1;
        k1 = Math.min(h.remaining(), j1);
        h.put(abyte0, (i1 - j1) + l, k1);
        if (!h.hasRemaining())
        {
            h.position(0);
            i.position(0);
            i.get(j, 0, j.length);
            addSamples(j);
        }
        j1 -= k1;
        continue; /* Loop/switch isn't completed */
        return;
        abyte0;
        throw abyte0;
_L1:
        j1 = i1;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public final void addSamples(short aword0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (!isPrepared())
        {
            throw new IllegalStateException("MoodPresence instance has not been prepared");
        }
        break MISSING_BLOCK_LABEL_24;
        aword0;
        this;
        JVM INSTR monitorexit ;
        throw aword0;
        f.a(aword0);
        this;
        JVM INSTR monitorexit ;
    }

    public final String getApiHost()
    {
        return a.b();
    }

    public final String getApiPath()
    {
        return a.c();
    }

    public final String getApiScheme()
    {
        return a.a();
    }

    public final Integer getBufferLength()
    {
        if (!isPrepared())
        {
            throw new IllegalStateException("MoodPresence instance has not been prepared");
        } else
        {
            return f.a();
        }
    }

    public final int getMinHits()
    {
        return g;
    }

    public final int getSampleRate()
    {
        return c.intValue();
    }

    public final String getSdkKey()
    {
        return b;
    }

    public final String getVersion()
    {
        return "1.2.1";
    }

    public final void handleDetection(g g1)
    {
        a();
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            MoodPresenceHandler moodpresencehandler = (MoodPresenceHandler)iterator.next();
            try
            {
                moodpresencehandler.handlePresence(new MoodPresenceResult(g1));
            }
            catch (Exception exception) { }
        }

    }

    public final void init(String s)
    {
        this;
        JVM INSTR monitorenter ;
        init(s, Boolean.valueOf(false));
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public final void init(String s, Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        if (isInitialized())
        {
            throw new IllegalStateException("MoodPresence instance was already initialized");
        }
        break MISSING_BLOCK_LABEL_24;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        b = s;
        e = boolean1;
        d = new ArrayList();
        a = new a(b);
        this;
        JVM INSTR monitorexit ;
    }

    public final boolean isInitialized()
    {
        while (b == null || e == null) 
        {
            return false;
        }
        return true;
    }

    public final boolean isListening()
    {
        while (!isInitialized() || f == null || f.b() != i.a.c) 
        {
            return false;
        }
        return true;
    }

    public final boolean isPrepared()
    {
        while (!isInitialized() || f == null || f.b() != i.a.b) 
        {
            return false;
        }
        return true;
    }

    public final void prepare(int l)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        if (isPrepared())
        {
            throw new IllegalStateException("MoodPresence instance is already prepared");
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        c = Integer.valueOf(l);
        f = new i(this, e, c);
        f.c();
        this;
        JVM INSTR monitorexit ;
    }

    public final void reset()
    {
        this;
        JVM INSTR monitorenter ;
        a();
        if (!isPrepared())
        {
            throw new IllegalStateException("MoodPresence instance has not been prepared");
        }
        break MISSING_BLOCK_LABEL_28;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        f.f();
        this;
        JVM INSTR monitorexit ;
    }

    public final void setMinHits(int l)
    {
        this;
        JVM INSTR monitorenter ;
        if (l > 0 && l <= 4)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw new IllegalArgumentException("minHits must be between 1 and 4, inclusive");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        g = l;
        if (f != null)
        {
            f.a(l);
        }
        this;
        JVM INSTR monitorexit ;
    }

    public final void startListening(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        if (f == null)
        {
            f = new i(this, e, c);
        }
        f.g();
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public final void stopListening()
    {
        this;
        JVM INSTR monitorenter ;
        a();
        f.h();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void subscribe(MoodPresenceHandler moodpresencehandler)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        a();
        flag = d.contains(moodpresencehandler);
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.add(moodpresencehandler);
        if (true) goto _L1; else goto _L3
_L3:
        moodpresencehandler;
        throw moodpresencehandler;
    }

    public final void unsubscribe(MoodPresenceHandler moodpresencehandler)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        d.remove(moodpresencehandler);
        this;
        JVM INSTR monitorexit ;
        return;
        moodpresencehandler;
        throw moodpresencehandler;
    }

    static 
    {
        INSTANCE = new MoodPresence("INSTANCE", 0);
        k = (new MoodPresence[] {
            INSTANCE
        });
    }
}
