// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class rq
{

    public static final int a[];

    static 
    {
        a = new int[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.values().length];
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_FB.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_INSTAGRAM.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_QQZONE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_SINA.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_TWITTER.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_WECHAT.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.fotoable.beautyui.gpuimage.sample.activity.CustomShareUtil.EnumRecentShare.SHARE_MOMENT.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
