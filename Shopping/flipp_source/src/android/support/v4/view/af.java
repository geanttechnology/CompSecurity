// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;


// Referenced classes of package android.support.v4.view:
//            ah, ag, ai

public final class af
{

    static final ai a;

    public static void a(Object obj)
    {
        a.a(obj);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            a = new ah((byte)0);
        } else
        {
            a = new ag((byte)0);
        }
    }
}
