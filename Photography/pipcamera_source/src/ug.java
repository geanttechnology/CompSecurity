// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

public class ug extends fp
{

    public ug(Context context, int i)
    {
        super(context, i);
    }

    protected Bitmap a(Object obj)
    {
        if (obj instanceof uj)
        {
            obj = ((uj)obj).c;
            Log.v("OnlineWork:info.icon", ((String) (obj)));
            return super.a(String.valueOf(obj));
        } else
        {
            return super.a(String.valueOf(obj));
        }
    }

    protected String b(Object obj)
    {
        if (obj instanceof uj)
        {
            return ((uj)obj).c;
        } else
        {
            return String.valueOf(obj);
        }
    }
}
