// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.camera.masks;

import com.socialin.android.apiv3.SocialinV3;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{

    public static final String a;
    private static HashMap i = new Mask._cls1();
    private static HashMap j = new Mask._cls2();
    private static HashMap k = new Mask._cls3();
    public int b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;

    public a(JSONObject jsonobject)
    {
        b = 0;
        c = 0;
        d = "";
        h = -1;
        try
        {
            d = jsonobject.getString("name");
            e = jsonobject.getString("icon");
            c = ((Integer)i.get(jsonobject.getString("resType"))).intValue();
            f = jsonobject.getString("url");
            b = ((Integer)j.get(jsonobject.getString("orientation"))).intValue();
            g = jsonobject.getString("extention");
            h = ((Integer)k.get(jsonobject.getString("blendMode"))).intValue();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }

    static 
    {
        a = (new StringBuilder()).append(SocialinV3.RESOURCE_URL).append("masks_ver2/").toString();
    }

    // Unreferenced inner class com/socialin/camera/masks/Mask$1

/* anonymous class */
    final class Mask._cls1 extends HashMap
    {

            
            {
                put("type_res", Integer.valueOf(0));
                put("type_downloadable", Integer.valueOf(1));
            }
    }


    // Unreferenced inner class com/socialin/camera/masks/Mask$2

/* anonymous class */
    final class Mask._cls2 extends HashMap
    {

            
            {
                put("horizontal_vertical", Integer.valueOf(0));
                put("horizontal", Integer.valueOf(1));
                put("vertical", Integer.valueOf(2));
            }
    }


    // Unreferenced inner class com/socialin/camera/masks/Mask$3

/* anonymous class */
    final class Mask._cls3 extends HashMap
    {

            
            {
                put("normal", Integer.valueOf(-1));
                put("screen", Integer.valueOf(0));
                put("overlay", Integer.valueOf(2));
                put("multiply", Integer.valueOf(1));
            }
    }

}
