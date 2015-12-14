// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class ayd
{

    public static final int a[];

    static 
    {
        a = new int[com.fotoable.tgifview.TGifView.GifImageType.values().length];
        try
        {
            a[com.fotoable.tgifview.TGifView.GifImageType.WAIT_FINISH.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.tgifview.TGifView.GifImageType.COVER.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.tgifview.TGifView.GifImageType.SYNC_DECODER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
