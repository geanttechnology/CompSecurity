// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.j.a.d.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            af, w

public class c
{

    public static Bitmap a(Drawable drawable)
    {
        boolean flag = true;
        if (drawable instanceof BitmapDrawable)
        {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        if (drawable.getBounds().isEmpty()) goto _L2; else goto _L1
_L1:
        int i = drawable.getBounds().width();
_L6:
        if (drawable.getBounds().isEmpty()) goto _L4; else goto _L3
_L3:
        int j = drawable.getBounds().height();
          goto _L5
_L7:
        Bitmap bitmap;
        int k;
        try
        {
            bitmap = Bitmap.createBitmap(k, i, android.graphics.Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        // Misplaced declaration of an exception variable
        catch (Drawable drawable)
        {
            return null;
        }
        return bitmap;
_L2:
        i = drawable.getIntrinsicWidth();
          goto _L6
_L4:
        j = drawable.getIntrinsicHeight();
          goto _L5
_L9:
        i = j;
          goto _L7
_L5:
        k = i;
        if (i <= 0)
        {
            k = 1;
        }
        if (j > 0) goto _L9; else goto _L8
_L8:
        i = ((flag) ? 1 : 0);
          goto _L7
    }

    public static File a(Object obj)
    {
        JSONArray jsonarray;
        af af2;
        jsonarray = (JSONArray)obj;
        af2 = af.valueOf(a());
        String s;
        Object obj1;
        int i;
        obj1 = null;
        s = "";
        obj = "";
        i = 0;
_L8:
        if (i >= jsonarray.length()) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject;
        JSONArray jsonarray1;
        jsonobject = e.e().k().k().optJSONObject(((JSONObject)jsonarray.get(i)).optString("image_id"));
        jsonarray1 = jsonobject.optJSONArray("deviceTags");
        int j = 0;
_L9:
        if (j >= jsonarray1.length()) goto _L4; else goto _L3
_L3:
        af af1 = af.valueOf(jsonarray1.optString(j));
        if (!af1.equals(af2)) goto _L6; else goto _L5
_L5:
        obj = jsonobject.optString("filename");
_L4:
        if (((String) (obj)).equals("")) goto _L7; else goto _L2
_L2:
        obj1 = obj;
        break MISSING_BLOCK_LABEL_125;
_L6:
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        s = jsonobject.optString("filename");
        obj1 = af1;
        break MISSING_BLOCK_LABEL_230;
        if (af1.ordinal() <= ((af) (obj1)).ordinal())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        s = jsonobject.optString("filename");
        obj1 = af1;
        break MISSING_BLOCK_LABEL_230;
_L7:
        i++;
          goto _L8
        if (((String) (obj)).equals(""))
        {
            obj1 = s;
        }
        try
        {
            return new File(e.e().o().getFilesDir(), ((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b("error retriving file: ", ((Exception) (obj)));
        }
        return new File("sofuh28yr2jkjdkjadal");
        j++;
          goto _L9
    }

    public static String a()
    {
        String s = "";
        float f = e.e().o().getResources().getDisplayMetrics().density;
        if ((double)f >= 0.75D)
        {
            s = "ldpi";
        } else
        {
            if (f == 1.0F)
            {
                return "mdpi";
            }
            if (f > 1.0F && (double)f < 1.5D)
            {
                return "tvdpi";
            }
            if ((double)f == 1.5D)
            {
                return "hdpi";
            }
            if (f == 2.0F)
            {
                return "xhdpi";
            }
            if (f == 3F)
            {
                return "xxhdpi";
            }
            if (f == 4F)
            {
                return "xxxhdpi";
            }
        }
        return s;
    }

    public static void a(String s, String s1, Context context)
    {
        Object obj = null;
        s1 = new File(context.getFilesDir(), s1);
        if (s1.exists() || s1.isDirectory()) goto _L2; else goto _L1
_L1:
        s = (new URL(s)).openStream();
        context = new FileOutputStream(s1);
        s1 = new byte[2048];
_L5:
        int i = s.read(s1);
        if (i == -1) goto _L4; else goto _L3
_L3:
        context.write(s1, 0, i);
          goto _L5
_L8:
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                w.b("something terrible has occurred in our silly nested io catch", s);
                return;
            }
        }
        if (s == null) goto _L2; else goto _L6
_L6:
        s.close();
_L2:
        return;
_L4:
        try
        {
            s.close();
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1 = s;
            s = context;
        }
        continue; /* Loop/switch isn't completed */
        s;
        s = null;
        s1 = obj;
        continue; /* Loop/switch isn't completed */
        s1;
        context = null;
        s1 = s;
        s = context;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Drawable b()
    {
        Object obj;
        obj = e.e().o().getPackageManager();
        obj = e.e().o().getApplicationInfo().loadIcon(((android.content.pm.PackageManager) (obj)));
        if (obj != null)
        {
            return ((Drawable) (obj));
        }
        break MISSING_BLOCK_LABEL_37;
        Exception exception;
        exception;
        w.c("problem getting app icon");
        return null;
    }

    public static byte[] c()
    {
        Object obj = null;
        byte abyte0[];
        Object obj1;
        ByteArrayOutputStream bytearrayoutputstream;
        try
        {
            obj1 = b();
        }
        catch (Exception exception)
        {
            return null;
        }
        abyte0 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj1 = a(((Drawable) (obj1)));
        bytearrayoutputstream = new ByteArrayOutputStream();
        abyte0 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        ((Bitmap) (obj1)).compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
        abyte0 = bytearrayoutputstream.toByteArray();
        return abyte0;
    }
}
