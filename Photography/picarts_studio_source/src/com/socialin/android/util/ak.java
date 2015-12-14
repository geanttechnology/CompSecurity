// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import com.socialin.android.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.util:
//            FileUtils

public class ak
{

    public static final String a = com/socialin/android/util/ak.getSimpleName();
    private static final Map c;
    private static final Map d = new HashMap();
    public JSONArray b;
    private Context e;

    private ak(Context context, String s)
    {
        e = context;
        Object obj = null;
        try
        {
            context = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
            context = obj;
        }
        context = FileUtils.a(context);
        try
        {
            b = new JSONArray(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            com.socialin.android.d.b(a, new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
            });
        }
    }

    public static ak a(Context context)
    {
        return a(context, "default");
    }

    public static ak a(Context context, String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "default";
        }
        s = (String)c.get(s1);
        if (s == null)
        {
            throw new IllegalArgumentException();
        }
        if (!d.containsKey(s1))
        {
            context = new ak(context, s);
            d.put(s1, context);
        }
        return (ak)d.get(s1);
    }

    public final String a(int i)
    {
        JSONObject jsonobject = b.optJSONObject(i);
        return (new StringBuilder()).append(jsonobject.optString("name")).append(".").append(jsonobject.optString("extension", "png")).toString();
    }

    public final String b(int i)
    {
        String s = (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/").append(e.getString(0x7f0808fb)).append("/").append(e.getString(0x7f0808dc)).append("/sticker/").toString();
        return (new StringBuilder()).append(s).append(a(i)).toString();
    }

    public final int c(int i)
    {
        String s = b.optJSONObject(i).optString("blendingMode");
        if (s.equals("add"))
        {
            return 5;
        }
        if (s.equals("darken"))
        {
            return 3;
        }
        if (s.equals("lighten"))
        {
            return 4;
        }
        if (s.equals("multiply"))
        {
            return 1;
        }
        if (!s.equals("normal"))
        {
            if (s.equals("overlay"))
            {
                return 2;
            }
            if (s.equals("screen"))
            {
                return 0;
            }
        }
        return -1;
    }

    static 
    {
        HashMap hashmap = new HashMap();
        c = hashmap;
        hashmap.put("default", "stickers/default.json");
        c.put("drawing", "stickers/drawing.json");
    }
}
