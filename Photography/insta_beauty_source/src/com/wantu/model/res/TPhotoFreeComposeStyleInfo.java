// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.util.Log;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// Referenced classes of package com.wantu.model.res:
//            TResInfo, EResType

public class TPhotoFreeComposeStyleInfo extends TResInfo
{

    public int backgroundBorderColor;
    public float backgroundBorderWidth;
    public int backgroundColor;
    public String backgroundImageURL;
    public int borderColor;
    public float borderWidth;
    public List decoratorArray;
    public List dependencesRes;
    public String forgroundFrameurl;
    public Boolean isAvailable;
    public Boolean isHideShadow;
    public Boolean isNeedSign;
    public Boolean isTiledBgImage;
    public RectF margin;
    public int photoBackgroundColor;
    public String photoFrameImageURL;
    public float roundRadius;
    public int uid;
    public int version;

    public TPhotoFreeComposeStyleInfo()
    {
    }

    public Bitmap getBitmapByPath(String s)
    {
        Bitmap bitmap;
        if (resType == EResType.NETWORK)
        {
            s = s.substring(s.lastIndexOf("/") + 1);
            EOnlineResType eonlinerestype = EOnlineResType.FREE_COLLAGE_STYLE;
            return FileManager.getInstance().getOnlineBitmapRes(eonlinerestype, s);
        }
        AssetManager assetmanager = InstaBeautyApplication.a().getApplicationContext().getAssets();
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
            break MISSING_BLOCK_LABEL_67;
        }
        s.close();
        s.close();
        return bitmap;
        s;
        s.printStackTrace();
        return bitmap;
    }

    public Bitmap getImageBitmap()
    {
        Bitmap bitmap = null;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inPurgeable = true;
        Object obj = bitmap;
        if (resType == EResType.ASSET)
        {
            obj = bitmap;
            if (backgroundImageURL != null)
            {
                obj = BitmapFactory.decodeStream(InstaBeautyApplication.a().getApplicationContext().getAssets().open(backgroundImageURL), null, options);
            }
        }
        bitmap = ((Bitmap) (obj));
        if (resType == EResType.RES)
        {
            bitmap = ((Bitmap) (obj));
            if (backgroundImageURL != null)
            {
                obj = InstaBeautyApplication.a().getApplicationContext();
                int i = Integer.parseInt(backgroundImageURL);
                bitmap = BitmapFactory.decodeResource(((Context) (obj)).getResources(), i, options);
            }
        }
        obj = bitmap;
        if (resType == EResType.NETWORK)
        {
            obj = bitmap;
            if (backgroundImageURL != null)
            {
                int j = backgroundImageURL.lastIndexOf("/");
                obj = backgroundImageURL.substring(j + 1);
                Log.v("PIpStyle NetWork frameFileName:", ((String) (obj)));
                obj = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.FREE_COLLAGE_STYLE, ((String) (obj)));
            }
        }
        return ((Bitmap) (obj));
    }
}
