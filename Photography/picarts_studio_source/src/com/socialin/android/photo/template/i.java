// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.content.Context;
import android.content.res.AssetManager;
import com.picsart.shop.a;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.template:
//            Template, TemplateImage

public class i
{

    private static final String a = com/socialin/android/photo/template/i.getSimpleName();

    public i()
    {
    }

    public static ArrayList a(Context context, String s)
    {
        JSONObject jsonobject;
        ArrayList arraylist;
        ArrayList arraylist1;
        int j;
        arraylist = new ArrayList();
        jsonobject = null;
        JSONArray jsonarray;
        JSONObject jsonobject1;
        TemplateImage templateimage;
        int k;
        try
        {
            context = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            context = jsonobject;
        }
        context = FileUtils.a(context);
        context = (new JSONObject(context)).getJSONArray("collageFrames");
        j = 0;
_L3:
        if (j >= context.length())
        {
            break MISSING_BLOCK_LABEL_339;
        }
        s = new Template();
        jsonobject = (JSONObject)context.getJSONObject(j).get("frame");
        arraylist1 = new ArrayList();
        jsonarray = jsonobject.getJSONArray("images");
        k = 0;
_L2:
        if (k >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject1 = (JSONObject)jsonarray.getJSONObject(k).get("image");
        templateimage = new TemplateImage();
        templateimage.c = jsonobject1.getDouble("angle");
        templateimage.a = (float)jsonobject1.getDouble("posX");
        templateimage.b = (float)jsonobject1.getDouble("posY");
        templateimage.d = (float)jsonobject1.getDouble("width");
        templateimage.e = (float)jsonobject1.getDouble("height");
        arraylist1.add(templateimage);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        s.h = jsonobject.getString("url");
        s.i = jsonobject.getString("iconUrl");
        s.f = arraylist1;
        s.j = context.getJSONObject(j).optString("name");
        arraylist.add(s);
        j++;
          goto _L3
        context;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
        return arraylist;
    }

    public static ArrayList a(JSONArray jsonarray)
    {
        ArrayList arraylist;
        int j;
        arraylist = new ArrayList();
        j = 0;
_L3:
        Template template;
        JSONObject jsonobject;
        ArrayList arraylist1;
        Object obj;
        if (j >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_339;
        }
        template = new Template();
        jsonobject = (JSONObject)jsonarray.getJSONObject(j).get("frame");
        arraylist1 = new ArrayList();
        obj = jsonobject.getJSONArray("images");
        int k = 0;
_L2:
        if (k >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = (JSONObject)((JSONArray) (obj)).getJSONObject(k).get("image");
        TemplateImage templateimage = new TemplateImage();
        templateimage.c = jsonobject1.getDouble("angle");
        templateimage.a = (float)jsonobject1.getDouble("posX");
        templateimage.b = (float)jsonobject1.getDouble("posY");
        templateimage.d = (float)jsonobject1.getDouble("width");
        templateimage.e = (float)jsonobject1.getDouble("height");
        arraylist1.add(templateimage);
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = jsonarray.getJSONObject(j).optBoolean("fromShop");
        obj = jsonarray.getJSONObject(j).optString("packageDir");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_237;
        }
        if (!com.picsart.shop.a.a().a(((String) (obj))) && !(new File(((String) (obj)))).exists())
        {
            break MISSING_BLOCK_LABEL_296;
        }
        template.o = flag;
        template.p = ((String) (obj));
        template.h = jsonobject.getString("url");
        template.i = jsonobject.getString("iconUrl");
        template.f = arraylist1;
        template.j = jsonarray.getJSONObject(j).optString("name");
        arraylist.add(template);
        j++;
          goto _L3
        jsonarray;
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(jsonarray.getMessage()).toString()
        });
        return arraylist;
    }

}
