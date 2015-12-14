// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;


// Referenced classes of package com.wantu.ResourceOnlineLibrary:
//            FileManager, EOnlineResType

class 
{

    static final int a[];

    static 
    {
        a = new int[EOnlineResType.values().length];
        try
        {
            a[EOnlineResType.PIP_SCENE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[EOnlineResType.MAG_MASK_INFO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[EOnlineResType.TIEZHI.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[EOnlineResType.PIP_SCENE2.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
