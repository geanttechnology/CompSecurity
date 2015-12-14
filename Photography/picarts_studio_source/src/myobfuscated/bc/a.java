// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.bc;


public final class a
{

    private static a b;
    public boolean a;

    private a()
    {
        a = false;
        if (Integer.parseInt(android.os.Build.VERSION.SDK) >= 5)
        {
            a = true;
            return;
        } else
        {
            a = false;
            return;
        }
    }

    public static a a()
    {
        if (b == null)
        {
            b = new a();
        }
        return b;
    }
}
