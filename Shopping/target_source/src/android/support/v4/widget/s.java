// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;


public class s
{
    public static abstract class a
    {

        final Object a = s.a().a(this);

        public boolean a(String s1)
        {
            return false;
        }

        public boolean b(String s1)
        {
            return false;
        }

        public a()
        {
        }
    }


    private static final d a;

    static d a()
    {
        return a;
    }

    static 
    {
    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

    /* block-local class not found */
    class e {}

        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new c();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new b();
        } else
        {
            a = new e();
        }
    }

    // Unreferenced inner class android/support/v4/widget/s$d
    /* block-local class not found */
    class d {}

}
