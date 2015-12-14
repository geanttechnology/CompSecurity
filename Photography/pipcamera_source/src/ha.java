// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotoproedit.activity.font.FontOnlineInfo;
import com.wantu.model.res.TResInfo;

public class ha extends fp
{

    protected Bitmap a(Object obj)
    {
        Object obj1 = null;
        if (obj instanceof FontOnlineInfo)
        {
            FontOnlineInfo fontonlineinfo = (FontOnlineInfo)obj;
            if (hs.a().a(fontonlineinfo.resId))
            {
                try
                {
                    obj = fontonlineinfo.getIconImage();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    Crashlytics.logException(((Throwable) (obj)));
                    obj = obj1;
                }
                if (obj != null)
                {
                    return ((Bitmap) (obj));
                }
            }
            return super.a(String.valueOf(fontonlineinfo.icon));
        } else
        {
            return super.a(obj);
        }
    }

    protected String b(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            obj = (TResInfo)obj;
            if (((TResInfo) (obj)).icon != null)
            {
                return ((TResInfo) (obj)).getIcon();
            } else
            {
                return "";
            }
        } else
        {
            return "";
        }
    }
}
