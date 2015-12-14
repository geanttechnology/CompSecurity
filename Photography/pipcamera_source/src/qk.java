// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.wantu.model.res.TResInfo;

public class qk extends fp
{

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
        }
        if (obj instanceof qt)
        {
            String s = ((qt)obj).d;
            if (s != null && s.length() > 0)
            {
                Log.v("MagImageWorker", (new StringBuilder()).append("MagImageWorker url:").append(s).toString());
                return super.a(String.valueOf(s));
            }
        }
        return super.a(String.valueOf(obj));
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
        }
        if (obj instanceof qt)
        {
            obj = (qt)obj;
            if (((qt) (obj)).d != null)
            {
                return ((qt) (obj)).d;
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
