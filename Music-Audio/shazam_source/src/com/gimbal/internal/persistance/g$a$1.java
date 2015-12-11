// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.persistance;


// Referenced classes of package com.gimbal.internal.persistance:
//            g, e

final class c
    implements Runnable
{

    private e a;
    private String b;
    private Object c;
    private a d;

    public final void run()
    {
        try
        {
            a.a(b, c);
            return;
        }
        catch (Exception exception)
        {
            a.getClass();
            exception.getMessage();
            return;
        }
    }

    ( , e e1, String s, Object obj)
    {
        d = ;
        a = e1;
        b = s;
        c = obj;
        super();
    }
}
