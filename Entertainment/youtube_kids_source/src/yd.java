// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class yd
    implements android.media.RemoteControlClient.OnGetPlaybackPositionListener
{

    private yc a;

    yd(yc yc1)
    {
        a = yc1;
        super();
    }

    public final long onGetPlaybackPosition()
    {
        if (a.b != null)
        {
            return a.b.p();
        } else
        {
            return 0L;
        }
    }
}
