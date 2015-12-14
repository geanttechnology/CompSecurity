// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bny
{

    public static final int a[];

    static 
    {
        a = new int[com.wantu.service.gif.play.GifView.GifImageType.values().length];
        try
        {
            a[com.wantu.service.gif.play.GifView.GifImageType.WAIT_FINISH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.wantu.service.gif.play.GifView.GifImageType.COVER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
