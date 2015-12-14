// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.lensflare;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import com.picsart.shop.a;
import com.picsart.studio.editor.item.LensFlareItem;
import com.socialin.android.d;
import com.socialin.android.photo.svg.Svg;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.lensflare:
//            b, d

public class LensFlareFactory
{

    private static String a = com/socialin/android/photo/lensflare/LensFlareFactory.getSimpleName();
    private static final int b[] = {
        28, 31, 17, 29, 32, 33, 57, 56, 34, 52, 
        55, 30, 58, 59, 60, 37, 23, 36, 45, 41, 
        44, 48, 51, 50, 46, 47, 53, 40, 42, 21, 
        24, 35, 49, 54, 39, 43, 27, 25, 38, 22, 
        26, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
        10, 11, 12, 13, 14, 15, 16
    };

    public LensFlareFactory()
    {
    }

    public static int a()
    {
        return 57;
    }

    public static LensFlareItem a(Context context, int i, float f, float f1)
    {
        return new LensFlareItem((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(context.getString(0x7f0808fb)).append("/").append(context.getString(0x7f0808dc)).append("/lensflare/source/").append(a(i)).toString(), f, f1);
    }

    public static String a(int i)
    {
        return (new StringBuilder("flare_")).append(b[i]).toString();
    }

    public static void a(LensFlareItem lensflareitem, String s, Context context)
    {
        JSONObject jsonobject;
        ArrayList arraylist;
        int j;
        jsonobject = new JSONObject(FileUtils.a(com.picsart.shop.a.a(context).a(s, "info.json")));
        j = jsonobject.optJSONArray("components").length();
        arraylist = new ArrayList(j);
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject1 = jsonobject.optJSONArray("components").optJSONObject(i);
        float f;
        float f1;
        Object obj;
        String s1;
        byte byte0;
        boolean flag;
        boolean flag1;
        if (jsonobject1.optString("type").equals("raster"))
        {
            obj = ".jpg";
        } else
        {
            obj = ".svg";
        }
        obj = com.picsart.shop.a.a(context).a(s, (new StringBuilder()).append(i + 1).append(((String) (obj))).toString());
        s1 = jsonobject1.optString("type");
        f = (float)jsonobject1.optDouble("dist", 0.0D);
        f1 = (float)jsonobject1.optDouble("pdist", 0.0D);
        flag = jsonobject1.optBoolean("rotatable", false);
        flag1 = jsonobject1.optBoolean("autoScale", false);
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 431
    //                   -938121859: 286
    //                   -820387517: 302;
           goto _L3 _L4 _L5
_L9:
        throw new IllegalArgumentException((new StringBuilder("The supplied JSONObject doesn't have a valid format: '")).append(s1).append("' is not a valid component type.").toString());
        obj;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(((Exception) (obj)).getMessage()).toString()
        });
_L7:
        i++;
          goto _L6
_L4:
        if (s1.equals("raster"))
        {
            byte0 = 0;
        }
          goto _L3
_L5:
        if (s1.equals("vector"))
        {
            byte0 = 1;
        }
          goto _L3
_L10:
        obj = new b(f, f1, flag, flag1, BitmapFactory.decodeStream(((java.io.InputStream) (obj))));
_L8:
        arraylist.add(obj);
          goto _L7
_L11:
        obj = new com.socialin.android.photo.lensflare.d(f, f1, flag, flag1, new Svg(((java.io.InputStream) (obj))));
          goto _L8
_L2:
        try
        {
            lensflareitem.a(arraylist, (float)jsonobject.optDouble("intrinsicSrcToDst", 0.0D));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (LensFlareItem lensflareitem)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(lensflareitem.getMessage()).toString()
            });
        }
        return;
          goto _L7
_L3:
        byte0;
        JVM INSTR tableswitch 0 1: default 456
    //                   0 318
    //                   1 352;
           goto _L9 _L10 _L11
    }

}
