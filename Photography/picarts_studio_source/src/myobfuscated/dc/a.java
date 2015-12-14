// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.dc;


public final class a
{

    public static a b;
    public boolean a;

    public a()
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
}
