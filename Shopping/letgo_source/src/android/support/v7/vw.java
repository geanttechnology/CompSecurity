// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            xs

public class vw
{
    public static interface a
    {

        public abstract void a(xs xs);
    }

    public static interface b
    {

        public abstract void a(Object obj);
    }


    public final Object a;
    public final mo.a b;
    public final xs c;
    public boolean d;

    private vw(xs xs)
    {
        d = false;
        a = null;
        b = null;
        c = xs;
    }

    private vw(Object obj, mo.a a1)
    {
        d = false;
        a = obj;
        b = a1;
        c = null;
    }

    public static vw a(xs xs)
    {
        return new vw(xs);
    }

    public static vw a(Object obj, mo.a a1)
    {
        return new vw(obj, a1);
    }

    public boolean a()
    {
        return c == null;
    }
}
