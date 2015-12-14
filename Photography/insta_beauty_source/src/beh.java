// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import com.wantu.model.res.TResInfo;

public class beh extends zs
{

    public beh(Context context, int i)
    {
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        Object obj1 = null;
        if (obj instanceof TResInfo)
        {
            TResInfo tresinfo = (TResInfo)obj;
            try
            {
                obj = tresinfo.getIconBitmap();
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
            } else
            {
                return super.a(String.valueOf(tresinfo.icon));
            }
        } else
        {
            return super.a(String.valueOf(obj));
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
