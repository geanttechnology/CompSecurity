// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import android.graphics.Bitmap;
import bgd;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;

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

    public Bitmap getBitmap()
    {
        String s1;
        int i = imgUrl.lastIndexOf("/");
        s1 = imgUrl.substring(i + 1);
        if (folderName == null || folderName.length() <= 0) goto _L2; else goto _L1
_L1:
        String s = FileManager.getInstance().getInstaMagFileCache().a();
        _cls1..SwitchMap.com.wantu.ResourceOnlineLibrary.EOnlineResType[resType.ordinal()];
        JVM INSTR tableswitch 1 1: default 150
    //                   1 120;
           goto _L3 _L4
_L3:
        s = (new StringBuilder()).append(s).append("/").append(folderName).append("/").append(s1).toString();
        return FileManager.getInstance().getBitmapByFilePath(s);
_L4:
        s = FileManager.getInstance().getInstaMagFileCache().a();
        if (true) goto _L3; else goto _L2
_L2:
        Bitmap bitmap;
        try
        {
            bitmap = FileManager.getInstance().getOnlineBitmapRes(resType, s1);
        }
        catch (Exception exception)
        {
            return null;
        }
        return bitmap;
    }

    public EOnlineResType getEOnlineResType()
    {
        return resType;
    }

    public long getExpiredTime()
    {
        return expiredTime;
    }

    public String getFolderName()
    {
        return folderName;
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

    private class _cls1
    {

        static final int $SwitchMap$com$wantu$ResourceOnlineLibrary$EOnlineResType[];

        static 
        {
            $SwitchMap$com$wantu$ResourceOnlineLibrary$EOnlineResType = new int[EOnlineResType.values().length];
            try
            {
                $SwitchMap$com$wantu$ResourceOnlineLibrary$EOnlineResType[EOnlineResType.MAG_MASK_INFO.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror) { }
        }
    }

}
