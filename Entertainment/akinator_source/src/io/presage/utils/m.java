// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.TypedValue;
import io.presage.Presage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Formatter;

public final class m
{

    public static int a(int i)
    {
        Context context = Presage.getInstance().getContext();
        return (int)TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static Bitmap a(String s, int i, int j)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setDoInput(true);
        s.connect();
        obj = BitmapFactory.decodeStream(s.getInputStream());
        if (i <= 0 || j <= 0)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj1 = Bitmap.createScaledBitmap(((Bitmap) (obj)), i, i, false);
        obj = obj1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s.disconnect();
        obj1 = obj;
_L2:
        return ((Bitmap) (obj1));
        IOException ioexception;
        ioexception;
        s = null;
_L5:
        obj1 = obj;
        ioexception.printStackTrace();
        obj1 = s;
        if (obj == null) goto _L2; else goto _L1
_L1:
        ((HttpURLConnection) (obj)).disconnect();
        return s;
        obj;
        s = ((String) (obj1));
_L4:
        if (s != null)
        {
            s.disconnect();
        }
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
        ioexception;
        Object obj2 = null;
        obj = s;
        s = obj2;
          goto _L5
        ioexception;
        Object obj3 = obj;
        obj = s;
        s = ((String) (obj3));
          goto _L5
        return ((Bitmap) (obj));
    }

    public static String a(Object obj)
    {
        if (obj instanceof String)
        {
            return (String)obj;
        }
        if (obj instanceof Double)
        {
            return Integer.toString(((Double)obj).intValue());
        } else
        {
            return "";
        }
    }

    public static String a(String s, String s1)
    {
        Formatter formatter = new Formatter();
        formatter.format(s, new Object[] {
            s1.replace("_", "-"), s1
        });
        s = formatter.toString();
        formatter.close();
        return s;
    }

    public static byte[] a(String s)
    {
        Object obj = null;
        Bitmap bitmap = a(s, 0, 0);
        s = obj;
        if (bitmap != null)
        {
            s = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, s);
            s = s.toByteArray();
        }
        return s;
    }
}
