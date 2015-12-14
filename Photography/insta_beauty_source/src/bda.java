// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.wantu.model.res.TResInfo;

public class bda extends zs
{

    public bda(Context context, int i)
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
        }
        if (obj instanceof bdf)
        {
            String s = ((bdf)obj).a;
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
        if (obj instanceof bdf)
        {
            obj = (bdf)obj;
            if (((bdf) (obj)).a != null)
            {
                return ((bdf) (obj)).a;
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
