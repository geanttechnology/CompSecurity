// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.pipcamera.application.PIPCameraApplication;

// Referenced classes of package com.wantu.model.res:
//            TResInfo, EResType, EResProcessType

public class TFrameItemInfo extends TResInfo
{

    public int bgColor;
    public String imageURL;
    public boolean isTiledImage;

    public TFrameItemInfo()
    {
        isTiledImage = false;
    }

    public static TFrameItemInfo ItemByInfo(String s, String s1, EResType erestype, EResProcessType eresprocesstype, int i)
    {
        TFrameItemInfo tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.setName(s);
        tframeiteminfo.setIcon(s1);
        tframeiteminfo.setResType(erestype);
        tframeiteminfo.setResProcessType(eresprocesstype);
        tframeiteminfo.bgColor = i;
        return tframeiteminfo;
    }

    public static TFrameItemInfo ItemByInfo(String s, String s1, EResType erestype, EResProcessType eresprocesstype, String s2)
    {
        TFrameItemInfo tframeiteminfo = new TFrameItemInfo();
        tframeiteminfo.setName(s);
        tframeiteminfo.setIcon(s1);
        tframeiteminfo.setResType(erestype);
        tframeiteminfo.setResProcessType(eresprocesstype);
        tframeiteminfo.setImageURL(s2);
        return tframeiteminfo;
    }

    public int getBgColor()
    {
        return bgColor;
    }

    public Bitmap getImageBitmap()
    {
        Object obj = null;
        Bitmap bitmap = null;
        if (imageURL != null)
        {
            bitmap = obj;
            if (resType == EResType.ASSET)
            {
                bitmap = BitmapFactory.decodeStream(PIPCameraApplication.b().getApplicationContext().getAssets().open(imageURL));
            }
            if (resType == EResType.RES)
            {
                Context context = PIPCameraApplication.b().getApplicationContext();
                int i = Integer.parseInt(icon);
                return BitmapFactory.decodeResource(context.getResources(), i);
            }
        }
        return bitmap;
    }

    public String getImageURL()
    {
        return imageURL;
    }

    public void setBgColor(int i)
    {
        bgColor = i;
    }

    public void setImageURL(String s)
    {
        imageURL = s;
    }
}
