// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.wantu.model.res.TResInfo;

public class tl extends fp
{

    public tl(Context context, int i)
    {
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            obj = ((TResInfo)obj).icon;
            Log.v("OnlineWork:info.icon", ((String) (obj)));
            return super.a(String.valueOf(obj));
        } else
        {
            return super.a(String.valueOf(obj));
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
