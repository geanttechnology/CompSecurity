// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.frame.TFilterFrameManager;
import com.wantu.imagelib.filter.TLightingFilterManager;

public class bgs
{

    public static bgv a(EOnlineResType eonlinerestype)
    {
        switch (bgt.a[eonlinerestype.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new TLightingFilterManager();

        case 2: // '\002'
            return new TFilterFrameManager();

        case 3: // '\003'
            return apq.c().d();
        }
    }
}
