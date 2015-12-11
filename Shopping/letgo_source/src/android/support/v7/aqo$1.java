// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.List;

// Referenced classes of package android.support.v7:
//            aqo

static final class  extends 
{

    protected void a(int i, String s, String s1, Throwable throwable)
    {
        throw new AssertionError("Missing override for log method.");
    }

    public transient void a(String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((<init>)list.get(i)).a(s, aobj);
        }

    }

    public transient void a(Throwable throwable, String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((a)list.get(i)).a(throwable, s, aobj);
        }

    }

    public transient void b(String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((a)list.get(i)).b(s, aobj);
        }

    }

    public transient void b(Throwable throwable, String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((b)list.get(i)).b(throwable, s, aobj);
        }

    }

    public transient void c(String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((b)list.get(i)).c(s, aobj);
        }

    }

    public transient void d(String s, Object aobj[])
    {
        List list = aqo.a();
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            ((c)list.get(i)).d(s, aobj);
        }

    }

    ()
    {
    }
}
