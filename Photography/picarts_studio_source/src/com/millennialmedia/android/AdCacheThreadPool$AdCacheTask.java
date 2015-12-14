// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            CachedAd, HandShake, AdCache

class d
    implements Comparable, Runnable
{

    private WeakReference a;
    private String b;
    private CachedAd c;
    private WeakReference d;

    public int compareTo(d d1)
    {
        return c.downloadPriority - d1.c.downloadPriority;
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof compareTo))
        {
            return false;
        } else
        {
            obj = (compareTo)obj;
            return c.equals(((c) (obj)).c);
        }
    }

    public void run()
    {
        String s;
        Context context;
        c c1;
        String s1;
        boolean flag;
        if (d != null)
        {
            c1 = (d)d.get();
        } else
        {
            c1 = null;
        }
        if (c1 != null)
        {
            c1.wnloadStart(c);
        }
        HandShake.a((Context)a.get()).c(b);
        flag = c.download((Context)a.get());
        HandShake.a((Context)a.get()).d(b);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        s = AdCache.d((Context)a.get(), b);
        if (s == null || !c.getId().equals(s)) goto _L2; else goto _L1
_L1:
        c.delete((Context)a.get());
        context = (Context)a.get();
        s = b;
_L4:
        s1 = null;
_L5:
        AdCache.b(context, s, s1);
_L6:
        if (c1 != null)
        {
            c1.wnloadCompleted(c, flag);
        }
        return;
_L2:
        context = (Context)a.get();
        s = b;
        if (c.downloadAllOrNothing) goto _L4; else goto _L3
_L3:
        s1 = c.getId();
          goto _L5
        AdCache.b((Context)a.get(), b, null);
          goto _L6
    }

    (Context context, String s, CachedAd cachedad,  )
    {
        a = new WeakReference(context.getApplicationContext());
        b = s;
        c = cachedad;
        if ( != null)
        {
            d = new WeakReference();
        }
    }
}
