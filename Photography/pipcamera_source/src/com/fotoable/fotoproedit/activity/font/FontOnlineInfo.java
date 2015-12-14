// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.model.res.TResInfo;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextLabelInfo

public class FontOnlineInfo extends TResInfo
{

    public boolean hasBg;
    public boolean isLocalOnlineRes;
    public ArrayList labelArray;
    public int viewH;
    public int viewW;

    public FontOnlineInfo()
    {
        isLocalOnlineRes = false;
        hasBg = false;
        labelArray = new ArrayList();
    }

    private Bitmap getImage(String s)
    {
        if (isLocalOnlineRes)
        {
            return BitmapFactory.decodeFile(s).copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        try
        {
            s = PIPCameraApplication.a.getAssets().open(s);
            Bitmap bitmap = BitmapFactory.decodeStream(s);
            s.close();
            s = bitmap.copy(android.graphics.Bitmap.Config.ARGB_8888, true);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            return null;
        }
        return s;
    }

    public Bitmap getBgImage()
    {
label0:
        {
            if (labelArray == null)
            {
                break label0;
            }
            Iterator iterator = labelArray.iterator();
            FontTextLabelInfo fonttextlabelinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                fonttextlabelinfo = (FontTextLabelInfo)iterator.next();
            } while (fonttextlabelinfo.u != FontTextLabelInfo.TEXTBGVIEWTYPE.IMAGEBG);
            return getImage(fonttextlabelinfo.t);
        }
        return null;
    }

    public Bitmap getIconImage()
    {
        return getImage(icon);
    }

    public Rect getTextRect()
    {
label0:
        {
            if (labelArray == null)
            {
                break label0;
            }
            Iterator iterator = labelArray.iterator();
            FontTextLabelInfo fonttextlabelinfo;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                fonttextlabelinfo = (FontTextLabelInfo)iterator.next();
            } while (fonttextlabelinfo.u != FontTextLabelInfo.TEXTBGVIEWTYPE.LABEL);
            return fonttextlabelinfo.s;
        }
        return new Rect();
    }
}
