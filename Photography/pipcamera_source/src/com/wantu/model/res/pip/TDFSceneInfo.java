// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.model.res.pip;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResProcessType;
import com.wantu.model.res.EResType;
import com.wantu.model.res.FilterType;
import com.wantu.model.res.TResInfo;
import com.wantu.piprender.ESceneMode;
import java.io.IOException;
import java.io.InputStream;
import pb;
import tm;

public class TDFSceneInfo extends TResInfo
{

    public String alphaTexturePath;
    public FilterType filterType;
    public String framePath;
    public Rect frameRect;
    public ESceneMode mode;
    public Point sceneSize;

    public TDFSceneInfo()
    {
    }

    public static TDFSceneInfo sceneByInfo(int i, String s, String s1, EResType erestype, EResProcessType eresprocesstype, String s2, Point point, Rect rect, 
            String s3, ESceneMode escenemode)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.resId = i;
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setResType(erestype);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setResProcessType(eresprocesstype);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.mode = escenemode;
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, ESceneMode escenemode, EResType erestype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setMode(escenemode);
        tdfsceneinfo.setResType(erestype);
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, String s2, Point point, Rect rect, String s3, FilterType filtertype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.setFilterType(filtertype);
        return tdfsceneinfo;
    }

    public static TDFSceneInfo sceneByInfo(String s, String s1, String s2, Point point, Rect rect, String s3, ESceneMode escenemode, FilterType filtertype)
    {
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s);
        tdfsceneinfo.setIcon(s1);
        tdfsceneinfo.setFramePath(s2);
        tdfsceneinfo.setSceneSize(point);
        tdfsceneinfo.setFrameRect(rect);
        tdfsceneinfo.setAlphaTexturePath(s3);
        tdfsceneinfo.setMode(escenemode);
        tdfsceneinfo.setFilterType(filtertype);
        return tdfsceneinfo;
    }

    public String getAlphaTexturePath()
    {
        return alphaTexturePath;
    }

    public FilterType getFilterType()
    {
        return filterType;
    }

    public String getFramePath()
    {
        return framePath;
    }

    public Rect getFrameRect()
    {
        return frameRect;
    }

    public Bitmap getGPUPipMaskBitmap(Context context)
    {
        context = null;
        if (getResType() != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        if (alphaTexturePath == null) goto _L4; else goto _L3
_L3:
        int i = alphaTexturePath.lastIndexOf("/");
        context = alphaTexturePath.substring(i + 1);
        Log.v("alphaTexture fileName", context);
        if (folderName == null || folderName.length() <= 0) goto _L6; else goto _L5
_L5:
        String s = FileManager.getInstance().getPipFileCache().a();
        context = (new StringBuilder()).append(s).append("/").append(folderName).append("/").append(context).toString();
        context = FileManager.getInstance().getBitmapByFilePath(context);
          goto _L7
_L6:
        context = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, context);
          goto _L7
        context;
        context.printStackTrace();
        Crashlytics.logException(context);
_L8:
        context = null;
        break; /* Loop/switch isn't completed */
_L2:
        if (alphaTexturePath != null)
        {
            return pb.b(PIPCameraApplication.a, alphaTexturePath);
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (context == null) goto _L8; else goto _L4
_L4:
        return context;
    }

    public ESceneMode getMode()
    {
        if (mode == null)
        {
            return ESceneMode.SCENE_MODE1;
        } else
        {
            return mode;
        }
    }

    public Bitmap getPipCoverBitmap(Context context)
    {
        if (getResType() == EResType.NETWORK)
        {
            if (framePath == null)
            {
                return null;
            }
            int i = framePath.lastIndexOf("/");
            context = framePath.substring(i + 1);
            if (folderName != null && folderName.length() > 0)
            {
                String s = FileManager.getInstance().getPipFileCache().a();
                context = (new StringBuilder()).append(s).append("/").append(folderName).append("/").append(context).toString();
                return FileManager.getInstance().getBitmapByFilePath(context);
            }
            try
            {
                context = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return null;
            }
            return context;
        } else
        {
            return pb.b(PIPCameraApplication.a, framePath);
        }
    }

    public Bitmap getPipMaskBitmap(Context context)
    {
        Object obj1;
        String s;
        Object obj2;
        Object obj3;
        obj3 = null;
        s = null;
        obj2 = null;
        obj1 = null;
        if (getResType() != EResType.NETWORK) goto _L2; else goto _L1
_L1:
        if (alphaTexturePath == null) goto _L4; else goto _L3
_L3:
        Object obj;
        int i = alphaTexturePath.lastIndexOf("/");
        obj = alphaTexturePath.substring(i + 1);
        Log.v("alphaTexture fileName", ((String) (obj)));
        context = ((Context) (obj1));
        if (folderName == null) goto _L6; else goto _L5
_L5:
        context = ((Context) (obj1));
        if (folderName.length() <= 0) goto _L6; else goto _L7
_L7:
        context = ((Context) (obj1));
        try
        {
            s = FileManager.getInstance().getPipFileCache().a();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return context;
        }
        context = ((Context) (obj1));
        obj = (new StringBuilder()).append(s).append("/").append(folderName).append("/").append(((String) (obj))).toString();
        context = ((Context) (obj1));
        obj = FileManager.getInstance().getBitmapByFilePath(((String) (obj)));
_L8:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj1));
        obj1 = ((Bitmap) (obj)).extractAlpha();
        context = ((Context) (obj1));
        ((Bitmap) (obj)).recycle();
        return ((Bitmap) (obj1));
_L6:
        context = ((Context) (obj1));
        obj = FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, ((String) (obj)));
        if (true) goto _L8; else goto _L4
_L2:
        if (alphaTexturePath == null) goto _L4; else goto _L9
_L9:
        context = context.getAssets();
        exception = s;
        obj1 = obj2;
        if (alphaTexturePath == null) goto _L11; else goto _L10
_L10:
        exception = s;
        obj1 = obj2;
        Log.v("alphaTexturePath", (new StringBuilder()).append("alphaTexturePath:").append(getAlphaTexturePath()).toString());
_L16:
        exception = s;
        obj1 = obj2;
        InputStream inputstream = context.open(getAlphaTexturePath());
        exception = s;
        obj1 = obj2;
        Bitmap bitmap = BitmapFactory.decodeStream(inputstream);
        context = obj3;
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        exception = s;
        obj1 = obj2;
        context = bitmap.extractAlpha();
        bitmap.recycle();
        exception = context;
        obj1 = context;
        inputstream.close();
        return context;
        context;
_L14:
        context.printStackTrace();
        Crashlytics.logException(context);
        return exception;
_L11:
        exception = s;
        obj1 = obj2;
        Log.v("alphaTexturePath", "alphaTexturePath is null");
        continue; /* Loop/switch isn't completed */
        context;
_L13:
        context.printStackTrace();
        Crashlytics.logException(context);
        return ((Bitmap) (obj1));
        exception;
        obj1 = context;
        context = exception;
        if (true) goto _L13; else goto _L12
_L12:
        IOException ioexception;
        ioexception;
        exception = context;
        context = ioexception;
        if (true) goto _L14; else goto _L4
_L4:
        return null;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public Point getSceneSize()
    {
        return sceneSize;
    }

    public boolean isShouldFirst()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (bRetainFirst)
        {
            flag = flag1;
            if (getExpireTime() > 0L)
            {
                flag = flag1;
                if (getExpireTime() >= System.currentTimeMillis())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void setAlphaTexturePath(String s)
    {
        alphaTexturePath = s;
    }

    public void setFilterType(FilterType filtertype)
    {
        filterType = filtertype;
    }

    public void setFramePath(String s)
    {
        framePath = s;
    }

    public void setFrameRect(Rect rect)
    {
        frameRect = rect;
    }

    public void setMode(ESceneMode escenemode)
    {
        mode = escenemode;
    }

    public void setSceneSize(Point point)
    {
        sceneSize = point;
    }
}
