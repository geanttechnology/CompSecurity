// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.wantu.model.res.TResInfo;

public class bgy extends zs
{

    public bgy(Context context, int i)
    {
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        if (obj instanceof TResInfo)
        {
            obj = ((TResInfo)obj).previewUrl;
            Log.v("OnlineWork:info.previewUrl", (new StringBuilder()).append("OnlineWork:info.previewUrl").append(((String) (obj))).toString());
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
            return ((TResInfo)obj).previewUrl;
        } else
        {
            return String.valueOf(obj);
        }
    }
}
