// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.ResourceOnlineLibrary.FileManager;
import com.wantu.imagelib.filter.TImageFilterInfo;
import com.wantu.model.res.TFrameItemInfo;
import com.wantu.model.res.TPhotoFreeComposeStyleInfo;
import com.wantu.model.res.TResInfo;
import com.wantu.model.res.pip.TDFSceneInfo;

public class bfu extends zu
{

    public bfu(Context context)
    {
        super(context);
    }

    protected Bitmap a(Object obj)
    {
        Object obj1 = null;
        if (!(obj instanceof TResInfo)) goto _L2; else goto _L1
_L1:
        TResInfo tresinfo;
        tresinfo = (TResInfo)obj;
        Log.v("OnlineWork:info.icon", tresinfo.icon);
        int i = tresinfo.icon.lastIndexOf("/");
        obj1 = tresinfo.icon.substring(i + 1);
        obj = EOnlineResType.PIP_SCENE;
        if (!(tresinfo instanceof TDFSceneInfo)) goto _L4; else goto _L3
_L3:
        obj = EOnlineResType.PIP_SCENE;
_L6:
        obj1 = FileManager.getInstance().getOnlineBitmapRes(((EOnlineResType) (obj)), ((String) (obj1)));
_L2:
        return ((Bitmap) (obj1));
_L4:
        if (tresinfo instanceof TFrameItemInfo)
        {
            obj = EOnlineResType.FILTER_FRAME;
        } else
        if (tresinfo instanceof TImageFilterInfo)
        {
            obj = EOnlineResType.LIGHT_FILTER;
        } else
        if (tresinfo instanceof TPhotoFreeComposeStyleInfo)
        {
            obj = EOnlineResType.FREE_COLLAGE_STYLE;
        }
        if (true) goto _L6; else goto _L5
_L5:
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
