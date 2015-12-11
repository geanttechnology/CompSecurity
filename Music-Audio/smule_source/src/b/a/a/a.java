// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;


// Referenced classes of package b.a.a:
//            b

public class a
{

    public static int a()
    {
        if (android.os.Build.VERSION.RELEASE.startsWith("1.5"))
        {
            return 3;
        } else
        {
            return b.a();
        }
    }
}
