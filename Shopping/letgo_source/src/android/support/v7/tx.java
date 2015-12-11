// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            vn

public class tx
{

    private long a;
    private long b;
    private Object c;

    public tx(long l)
    {
        b = 0x8000000000000000L;
        c = new Object();
        a = l;
    }

    public boolean a()
    {
        long l;
label0:
        {
            synchronized (c)
            {
                l = zzp.zzbB().b();
                if (b + a <= l)
                {
                    break label0;
                }
            }
            return false;
        }
        b = l;
        obj;
        JVM INSTR monitorexit ;
        return true;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
