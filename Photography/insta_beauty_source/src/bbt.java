// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.compose.InstaMagType;

class bbt
{

    static final int a[];

    static 
    {
        a = new int[InstaMagType.values().length];
        try
        {
            a[InstaMagType.RECT_LIB_SIZE_TYPE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[InstaMagType.SQ_LIB_SIZE_TYPE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[InstaMagType.LANDSCAPE_LIB_SIZE_TYPE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[InstaMagType.LINK_LIB_SIZE_TYPE.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
