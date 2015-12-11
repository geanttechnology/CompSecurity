// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;


// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            DefaultLoadControl

final class a
    implements Runnable
{

    final boolean a;
    final DefaultLoadControl b;

    a(DefaultLoadControl defaultloadcontrol, boolean flag)
    {
        b = defaultloadcontrol;
        a = flag;
        super();
    }

    public final void run()
    {
        DefaultLoadControl.access$000(b).onLoadingChanged(a);
    }
}
