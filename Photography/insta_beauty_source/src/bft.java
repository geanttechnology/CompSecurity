// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;

public class bft
{

    public static final int a[];

    static 
    {
        a = new int[EOnlineResType.values().length];
        try
        {
            a[EOnlineResType.LIGHT_FILTER.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[EOnlineResType.PIP_SCENE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[EOnlineResType.FILTER_FRAME.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[EOnlineResType.FREE_COLLAGE_STYLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[EOnlineResType.MAG_MASK_INFO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[EOnlineResType.FREE_RECT_COLLAGE_STYLE.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[EOnlineResType.TIEZHI.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[EOnlineResType.TEXT.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[EOnlineResType.PIP_SCENE2.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[EOnlineResType.BORDER.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[EOnlineResType.ZIMU.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[EOnlineResType.TAG.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
