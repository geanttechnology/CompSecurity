// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;


// Referenced classes of package cn.jpush.android.util:
//            JRecorder, x

final class t
    implements Runnable
{

    t()
    {
    }

    public final void run()
    {
        JRecorder.a(false);
        x.c();
        JRecorder.a(JRecorder.a());
    }
}
