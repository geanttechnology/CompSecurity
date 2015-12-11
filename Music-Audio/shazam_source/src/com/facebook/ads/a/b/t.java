// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.ads.j;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.facebook.ads.a.b:
//            g, u, h

public final class t extends g
{

    public com.facebook.ads.m.a b;
    public boolean c;
    public boolean d;
    public boolean e;
    public View f;
    public List g;
    private final u h;

    public t(Context context, h h1, u u1)
    {
        super(context, h1);
        h = u1;
    }

    private String a(View view)
    {
        try
        {
            view = b(view).toString();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return "Json exception";
        }
        return view;
    }

    private JSONObject b(View view)
    {
        boolean flag = true;
        int i = 0;
        JSONObject jsonobject = new JSONObject();
        jsonobject.putOpt("id", Integer.valueOf(view.getId()));
        jsonobject.putOpt("class", view.getClass());
        jsonobject.putOpt("origin", String.format("{x:%d, y:%d}", new Object[] {
            Integer.valueOf(view.getTop()), Integer.valueOf(view.getLeft())
        }));
        jsonobject.putOpt("size", String.format("{h:%d, w:%d}", new Object[] {
            Integer.valueOf(view.getHeight()), Integer.valueOf(view.getWidth())
        }));
        Object obj;
        if (g == null || !g.contains(view))
        {
            flag = false;
        }
        jsonobject.putOpt("clickable", Boolean.valueOf(flag));
        obj = "unknown";
        if (view instanceof TextView)
        {
            obj = "text";
        } else
        if (view instanceof Button)
        {
            obj = "button";
        } else
        if (view instanceof ImageView)
        {
            obj = "image";
        } else
        if (view instanceof j)
        {
            obj = "mediaview";
        } else
        if (view instanceof ViewGroup)
        {
            obj = "viewgroup";
        }
        jsonobject.putOpt("type", obj);
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            obj = new JSONArray();
            for (; i < view.getChildCount(); i++)
            {
                ((JSONArray) (obj)).put(b(view.getChildAt(i)));
            }

            jsonobject.putOpt("list", obj);
        }
        return jsonobject;
    }

    private String c(View view)
    {
        if (view.getWidth() <= 0 || view.getHeight() <= 0)
        {
            return "";
        }
        try
        {
            Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
            bitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(bitmap));
            view = new ByteArrayOutputStream();
            bitmap.compress(android.graphics.Bitmap.CompressFormat.JPEG, h.f(), view);
            view = Base64.encodeToString(view.toByteArray(), 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            return "";
        }
        return view;
    }

    protected final void b()
    {
        if (h == null)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        if (a != null)
        {
            hashmap.put("mil", Boolean.valueOf(a.a()));
            hashmap.put("eil", Boolean.valueOf(false));
            hashmap.put("eil_source", null);
        }
        if (b != null)
        {
            hashmap.put("nti", String.valueOf(b.a()));
        }
        if (c)
        {
            hashmap.put("nhs", String.valueOf(c));
        }
        if (d)
        {
            hashmap.put("nmv", String.valueOf(d));
        }
        if (e)
        {
            hashmap.put("nmvap", String.valueOf(e));
        }
        if (f != null && h.d())
        {
            hashmap.put("view", a(f));
        }
        if (f != null && h.e())
        {
            hashmap.put("snapshot", c(f));
        }
        h.a(hashmap);
    }
}
