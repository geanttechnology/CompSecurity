// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;


// Referenced classes of package com.google.ads.util:
//            i, b

public final class e extends e
{

    final i d;
    private boolean e;

    public Object a()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = a;
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        b.d((new StringBuilder()).append("State changed - ").append(d.toString()).append(".").append(b).append(": '").append(obj).append("' <-- '").append(a).append("'.").toString());
        a = obj;
        e = true;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(super.toString());
        String s;
        if (e)
        {
            s = " (*)";
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    public (i j, String s)
    {
        d = j;
        super(j, s, null);
        e = false;
        e = false;
    }

    public e(i j, String s, Object obj)
    {
        d = j;
        super(j, s, obj, null);
        e = false;
        e = false;
    }
}
