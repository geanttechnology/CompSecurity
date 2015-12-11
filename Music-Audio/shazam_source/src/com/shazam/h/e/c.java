// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h.e;

import com.shazam.android.analytics.TaggedBeacon;
import com.shazam.android.analytics.TaggingStatus;
import com.shazam.android.ay.b.d;
import com.shazam.h.e.a.b;
import com.shazam.i.f.a;
import java.io.IOException;

// Referenced classes of package com.shazam.h.e:
//            b, d, a

public final class c
    implements com.shazam.h.e.b
{

    private final com.shazam.e.a a;
    private final com.shazam.e.a b;
    private final d c;
    private final int d;
    private final TaggingStatus e;

    public c(d d1, int i, TaggingStatus taggingstatus)
    {
        this(com.shazam.i.f.a.b(), com.shazam.i.f.a.a(), d1, i, taggingstatus);
    }

    private c(com.shazam.e.a a1, com.shazam.e.a a2, d d1, int i, TaggingStatus taggingstatus)
    {
        a = a1;
        b = a2;
        c = d1;
        d = i;
        e = taggingstatus;
    }

    private void a(String s, long l, b b1)
    {
        (new com.shazam.h.e.d(s, (String)b.a(String.valueOf(l)))).a(b1);
    }

    public final void a(b b1)
    {
        long l;
        try
        {
            c.a(d, d);
            l = c.c();
            byte abyte0[] = c.b();
            Object obj = e.getTaggedBeacon();
            ((TaggedBeacon) (obj)).endRecordingTime();
            ((TaggedBeacon) (obj)).setSampleLength(l);
            obj = new a.a();
            obj.a = "sample";
            obj.b = "janet.sig";
            obj.c = (byte[])a.a(abyte0);
            (new com.shazam.h.e.a(((a.a) (obj)), (byte)0)).a(b1);
            a("sampleBytes", abyte0.length, b1);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            Thread.currentThread().interrupt();
            throw new IOException(b1);
        }
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        a("sampleLength", l, b1);
    }
}
