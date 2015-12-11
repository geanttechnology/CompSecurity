// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.util;


// Referenced classes of package cn.jpush.android.util:
//            JRecorder

final class s
    implements Runnable
{

    final int a;
    final JRecorder b;

    s(JRecorder jrecorder, int i)
    {
        b = jrecorder;
        a = i;
        super();
    }

    public final void run()
    {
        JRecorder.a(b, a);
    }
}
