// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;


// Referenced classes of package com.wantu.model.res:
//            TResInfo, EResType, EResProcessType

public class TBackgroundInfo extends TResInfo
{

    public TBackgroundInfo()
    {
    }

    public static TBackgroundInfo ItemByInfo(String s, String s1, EResType erestype, EResProcessType eresprocesstype)
    {
        TBackgroundInfo tbackgroundinfo = new TBackgroundInfo();
        tbackgroundinfo.setName(s);
        tbackgroundinfo.setIcon(s1);
        tbackgroundinfo.setResType(erestype);
        tbackgroundinfo.setResProcessType(eresprocesstype);
        return tbackgroundinfo;
    }
}
