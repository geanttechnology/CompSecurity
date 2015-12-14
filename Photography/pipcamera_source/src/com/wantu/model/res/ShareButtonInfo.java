// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import com.wantu.ResourceOnlineLibrary.EOnlineResType;

public class ShareButtonInfo
{

    public String adUrl;
    public long expiredTime;
    private String folderName;
    public String imgUrl;
    private EOnlineResType resType;

    public ShareButtonInfo()
    {
    }

    public String getAdUrl()
    {
        return adUrl;
    }

    public long getExpiredTime()
    {
        return expiredTime;
    }

    public String getImageUrl()
    {
        return imgUrl;
    }

    public void setAdUrl(String s)
    {
        adUrl = s;
    }

    public void setEOnlineResType(EOnlineResType eonlinerestype)
    {
        resType = eonlinerestype;
    }

    public void setExpiredTime(long l)
    {
        expiredTime = l;
    }

    public void setFolderName(String s)
    {
        folderName = s;
    }

    public void setimgUrl(String s)
    {
        imgUrl = s;
    }
}
