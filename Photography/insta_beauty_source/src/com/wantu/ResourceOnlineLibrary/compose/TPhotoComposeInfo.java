// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.compose;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import bgd;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.activity.link.model.TMetaInfo;
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
    public int typeId;
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
        Bitmap bitmap;
        if (resType == EResType.NETWORK)
        {
            s = s.substring(s.lastIndexOf("/") + 1);
            Object obj = EOnlineResType.MAG_MASK_INFO;
            if (folderName != null && folderName.length() > 0)
            {
                obj = FileManager.getInstance().getInstaMagFileCache().a();
                s = (new StringBuilder()).append(((String) (obj))).append("/").append(folderName).append("/").append(s).toString();
                return FileManager.getInstance().getBitmapByFilePath(s);
            } else
            {
                return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj)), s);
            }
        }
        AssetManager assetmanager = InstaBeautyApplication.a().b().getAssets();
        bitmap = null;
        try
        {
            s = assetmanager.open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = bitmap;
        }
        bitmap = BitmapFactory.decodeStream(s);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        s.close();
        s.close();
        return bitmap;
        s;
        s.printStackTrace();
        return bitmap;
    }

    public String getDeleteTag()
    {
        return String.format(",%d,", new Object[] {
            Integer.valueOf(resId)
        });
    }

    public Bitmap getIconBitmap()
    {
        if (resType != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        int i = icon.lastIndexOf("/");
        obj = icon.substring(i + 1);
        obj1 = EOnlineResType.MAG_MASK_INFO;
        if (folderName == null || folderName.length() <= 0) goto _L4; else goto _L3
_L3:
        Object obj2;
        obj1 = FileManager.getInstance().getInstaMagFileCache().a();
        obj = (new StringBuilder()).append(((String) (obj1))).append("/").append(folderName).append("/").append(((String) (obj))).toString();
        obj2 = FileManager.getInstance().getBitmapByFilePath(((String) (obj)));
_L6:
        return ((Bitmap) (obj2));
_L4:
        return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj1)), ((String) (obj)));
_L2:
        obj = InstaBeautyApplication.a().b().getAssets();
        try
        {
            obj1 = ((AssetManager) (obj)).open(icon);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj1 = null;
        }
        obj = BitmapFactory.decodeStream(((InputStream) (obj1)));
        obj2 = obj;
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        ((InputStream) (obj1)).close();
        return ((Bitmap) (obj));
        obj1;
_L8:
        ((IOException) (obj1)).printStackTrace();
        return ((Bitmap) (obj));
        obj;
        return null;
        obj1;
        return ((Bitmap) (obj));
        obj1;
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean hasSharedInfo()
    {
        while (shareStyleID == null || shareStyleID.equalsIgnoreCase("") || shareStyleID.equalsIgnoreCase("0")) 
        {
            return false;
        }
        return InstaBeautyApplication.a.getSharedPreferences("shareStyleID", 0).getBoolean((new StringBuilder()).append("hasSharedID_").append(shareStyleID).toString(), false);
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

    public InstaMagType magType()
    {
        InstaMagType instamagtype1 = InstaMagType.RECT_LIB_SIZE_TYPE;
        InstaMagType instamagtype;
        if (width == 320F && height == 480F)
        {
            instamagtype = InstaMagType.RECT_LIB_SIZE_TYPE;
        } else
        {
            if (width == 320F && height == 320F)
            {
                return InstaMagType.SQ_LIB_SIZE_TYPE;
            }
            if (width == 320F && height == 214F)
            {
                return InstaMagType.LANDSCAPE_LIB_SIZE_TYPE;
            }
            instamagtype = instamagtype1;
            if (width == 320F)
            {
                instamagtype = instamagtype1;
                if (height == 960F)
                {
                    return InstaMagType.LINK_LIB_SIZE_TYPE;
                }
            }
        }
        return instamagtype;
    }

    public void setInfoHasShared()
    {
        Object obj = InstaBeautyApplication.a.getSharedPreferences("shareStyleID", 0);
        String s = (new StringBuilder()).append("hasSharedID_").append(shareStyleID).toString();
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean(s, true);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }

}
