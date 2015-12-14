// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import android.content.Context;
import android.content.res.AssetManager;
import com.socialin.android.util.FileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.camera.masks:
//            a, c

public final class d
{

    public static final HashMap b = new MaskManager._cls1();
    public ArrayList a;
    private Context c;

    public d(Context context, String s)
    {
        a = new ArrayList();
        c = context;
        a(s);
    }

    private void a(String s)
    {
        ArrayList arraylist;
        String s1;
        String s2;
        int i;
        arraylist = null;
        Object obj;
        int j;
        try
        {
            s = c.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = arraylist;
        }
        s = FileUtils.a(s);
        s = (new JSONObject(s)).getJSONArray("categories");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_210;
        }
        i = 0;
_L3:
        if (i >= s.length())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        arraylist = new ArrayList();
        obj = (JSONObject)s.getJSONObject(i).get("category");
        s1 = ((JSONObject) (obj)).getString("name");
        s2 = ((JSONObject) (obj)).getString("folder");
        obj = ((JSONObject) (obj)).getJSONArray("items");
        j = 0;
_L2:
        if (j >= ((JSONArray) (obj)).length())
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(new a((JSONObject)((JSONArray) (obj)).getJSONObject(j).get("mask")));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        c c1 = new c();
        c1.a = s1;
        c1.b = s2;
        c1.c = arraylist;
        a.add(c1);
        i++;
          goto _L3
        s;
        s.printStackTrace();
    }


    // Unreferenced inner class com/socialin/camera/masks/MaskManager$1

/* anonymous class */
    final class MaskManager._cls1 extends HashMap
    {

            
            {
                put("Lights", Integer.valueOf(0x7f0803e3));
                put("Bokeh", Integer.valueOf(0x7f0803e1));
                put("Border", Integer.valueOf(0x7f0803e2));
                put("Texture", Integer.valueOf(0x7f0803e4));
                put("Artistic", Integer.valueOf(0x7f0803e0));
            }
    }

}
