// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.model.res.EResType;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;

public class td extends fr
{

    public td(Context context)
    {
        super(context);
    }

    protected Bitmap a(Object obj)
    {
        Object obj1;
        if (!(obj instanceof TDFSceneInfo))
        {
            break MISSING_BLOCK_LABEL_146;
        }
        obj1 = (TDFSceneInfo)obj;
        if (((TDFSceneInfo) (obj1)).getResType() == EResType.NETWORK)
        {
            int i = ((TDFSceneInfo) (obj1)).icon.lastIndexOf("/");
            String s1 = ((TDFSceneInfo) (obj1)).icon.substring(i + 1);
            if (((TDFSceneInfo) (obj1)).folderName != null && ((TDFSceneInfo) (obj1)).folderName.length() > 0)
            {
                s1 = FileManager.getInstance().getPipFileCache().a();
                obj1 = (new StringBuilder()).append(s1).append("/").append(((TDFSceneInfo) (obj1)).folderName).append("/").append(((TDFSceneInfo) (obj1)).icon).toString();
                return FileManager.getInstance().getBitmapByFilePath(((String) (obj1)));
            } else
            {
                return FileManager.getInstance().getOnlineBitmapRes(EOnlineResType.PIP_SCENE, s1);
            }
        }
        obj1 = ((TDFSceneInfo) (obj1)).getIconBitmap();
        return ((Bitmap) (obj1));
        Exception exception;
        exception;
        exception.printStackTrace();
        Crashlytics.logException(exception);
        if (obj instanceof TResInfo)
        {
            TResInfo tresinfo = (TResInfo)obj;
            Log.v("OnlineWork:info.icon", tresinfo.icon);
            int j = tresinfo.icon.lastIndexOf("/");
            String s = tresinfo.icon.substring(j + 1);
            obj = EOnlineResType.PIP_SCENE;
            if (tresinfo instanceof TDFSceneInfo)
            {
                obj = EOnlineResType.PIP_SCENE;
            }
            return FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj)), s);
        } else
        {
            return null;
        }
    }

    protected String b(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            return ((TResInfo)obj).getIcon();
        } else
        {
            return String.valueOf(obj);
        }
    }
}
