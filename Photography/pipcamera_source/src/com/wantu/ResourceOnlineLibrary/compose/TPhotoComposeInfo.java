// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import com.crashlytics.android.Crashlytics;
import com.instamag.activity.link.model.TMetaInfo;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.wantu.ResourceOnlineLibrary.compose:
//            InstaMagType

public class TPhotoComposeInfo extends TResInfo
{

    public static float scale = 1.0F;
    public String backgoundImagePath;
    public int backgroundColor;
    public List decorateInfoArray;
    public int foregroundColor;
    public String foregroundImagePath;
    public float height;
    public int imageCount;
    public boolean isHFlip;
    public boolean isLinkInfo;
    public boolean isOnline;
    public boolean isUpdate;
    public boolean isVFlip;
    public List metaArray;
    public TMetaInfo metaInfo;
    public List photoMaskInfoArray;
    public int rid;
    public float width;

    public TPhotoComposeInfo()
    {
        isLinkInfo = false;
        rid = 0;
        width = 320F;
        height = 480F;
        isHFlip = false;
        isVFlip = false;
    }

    public static InstaMagType getInstaMagType(TPhotoComposeInfo tphotocomposeinfo)
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            if (tphotocomposeinfo.width == 320F && tphotocomposeinfo.height == 214F)
            {
                return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (tphotocomposeinfo.width == 320F)
            {
                instamagtype = instamagtype1;
                if (tphotocomposeinfo.height == 960F)
                {
                    return InstaMagType.LINK_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public static RectF getScaledRect(RectF rectf)
    {
        return new RectF(rectf.left * scale, rectf.top * scale, rectf.right * scale, rectf.bottom * scale);
    }

    public static float getScaledValue(float f)
    {
        return scale * f;
    }

    public Bitmap getBitmapByPath(String s)
    {
        Object obj = null;
        if (resType == EResType.NETWORK)
        {
            s = s.substring(s.lastIndexOf("/") + 1);
            obj = EOnlineResType.MAG_MASK_INFO;
            return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj)), s);
        }
        Object obj1 = PIPCameraApplication.a.getAssets();
        try
        {
            s = ((AssetManager) (obj1)).open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            s = null;
        }
        obj1 = BitmapFactory.decodeStream(s);
        obj = obj1;
_L2:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s.close();
        s.close();
        return ((Bitmap) (obj));
        s;
        s.printStackTrace();
        return ((Bitmap) (obj));
        Object obj2;
        obj2;
        Crashlytics.logException(((Throwable) (obj2)));
        continue; /* Loop/switch isn't completed */
        obj2;
        Crashlytics.logException(((Throwable) (obj2)));
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Bitmap getIconBitmap()
    {
        if (resType != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        Object obj2;
        int i = icon.lastIndexOf("/");
        String s = icon.substring(i + 1);
        EOnlineResType eonlinerestype = EOnlineResType.MAG_MASK_INFO;
        obj2 = FileManager.getInstance().getOnlineBitmapRes(eonlinerestype, s);
_L4:
        return ((Bitmap) (obj2));
_L2:
        Object obj;
        Object obj1;
        obj = PIPCameraApplication.a.getAssets();
        try
        {
            obj1 = ((AssetManager) (obj)).open(icon);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            obj1 = null;
        }
        obj = BitmapFactory.decodeStream(((InputStream) (obj1)));
        obj2 = obj;
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        ((InputStream) (obj1)).close();
        return ((Bitmap) (obj));
        obj1;
_L8:
        ((IOException) (obj1)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj1)));
        return ((Bitmap) (obj));
        obj1;
        obj = null;
_L6:
        Crashlytics.logException(((Throwable) (obj1)));
        return ((Bitmap) (obj));
        obj1;
        if (true) goto _L6; else goto _L5
_L5:
        obj1;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean isShouldFirst()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (bRetainFirst)
        {
            flag = flag1;
            if (expiredTime > 0L)
            {
                flag = flag1;
                if (expiredTime * 1000L >= System.currentTimeMillis())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

}
