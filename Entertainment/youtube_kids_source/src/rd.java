// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class rd
    implements android.media.RemoteControlClient.OnGetPlaybackPositionListener
{

    private rc a;

    rd(rc rc1)
    {
        a = rc1;
        super();
    }

    public final long onGetPlaybackPosition()
    {
        return rc.a(a);
    }
}
