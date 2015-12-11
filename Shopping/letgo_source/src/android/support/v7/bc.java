// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v7:
//            bn, bd

public class bc
{
    static class a extends c
    {

        a()
        {
        }
    }

    static class b extends a
    {

        public int a(AccessibilityEvent accessibilityevent)
        {
            return bd.a(accessibilityevent);
        }

        public void a(AccessibilityEvent accessibilityevent, int i)
        {
            bd.a(accessibilityevent, i);
        }

        b()
        {
        }
    }

    static class c
        implements d
    {

        public int a(AccessibilityEvent accessibilityevent)
        {
            return 0;
        }

        public void a(AccessibilityEvent accessibilityevent, int i)
        {
        }

        c()
        {
        }
    }

    static interface d
    {

        public abstract int a(AccessibilityEvent accessibilityevent);

        public abstract void a(AccessibilityEvent accessibilityevent, int i);
    }


    private static final d a;

    public static bn a(AccessibilityEvent accessibilityevent)
    {
        return new bn(accessibilityevent);
    }

    public static void a(AccessibilityEvent accessibilityevent, int i)
    {
        a.a(accessibilityevent, i);
    }

    public static int b(AccessibilityEvent accessibilityevent)
    {
        return a.a(accessibilityevent);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new b();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new a();
        } else
        {
            a = new c();
        }
    }
}
