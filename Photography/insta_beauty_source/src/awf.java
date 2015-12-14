// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.fotoable.sketch.info.TTieZhiInfo;
import com.wantu.model.res.TResInfo;

public class awf extends zs
{

    public awf(Context context, int i)
    {
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        Object obj1 = null;
        if (obj instanceof TTieZhiInfo)
        {
            TTieZhiInfo ttiezhiinfo = (TTieZhiInfo)obj;
            if (awg.a().b(ttiezhiinfo.resId) && !ttiezhiinfo.isGroupEnable)
            {
                try
                {
                    obj = ttiezhiinfo.getIconImage();
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
            return super.a(String.valueOf(ttiezhiinfo.icon));
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
