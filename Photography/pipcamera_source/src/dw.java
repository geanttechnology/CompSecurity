// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class dw
{

    public static String a(Context context, Uri uri)
    {
        Object obj = null;
        if (uri != null)
        {
            String s = uri.getScheme();
            if (s == null)
            {
                return uri.getPath();
            }
            if ("file".equals(s))
            {
                return uri.getPath();
            }
            if ("content".equals(s))
            {
                uri = context.getContentResolver().query(uri, new String[] {
                    "_data"
                }, null, null, null);
                if (uri != null)
                {
                    context = obj;
                    if (uri.moveToFirst())
                    {
                        int i = uri.getColumnIndex("_data");
                        context = obj;
                        if (i > -1)
                        {
                            context = uri.getString(i);
                        }
                    }
                    uri.close();
                    return context;
                }
            }
        }
        return null;
    }
}
