// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw, n, ad

public class ae
{

    private String a;
    private long b;
    private String c;
    private String d;
    private int e;
    private List f;
    private File g;

    public ae(JSONObject jsonobject)
        throws Exception
    {
        int i = 0;
        super();
        b = 0L;
        e = 0;
        f = new ArrayList();
        a = jsonobject.getString("coupon-image");
        d = jsonobject.getString("coupon-id");
        if (jsonobject.has("coupon-skip-seconds"))
        {
            e = jsonobject.getInt("coupon-skip-seconds") * 1000;
        }
        if (jsonobject.has("coupon-code"))
        {
            c = jsonobject.getString("coupon-code");
        }
        for (jsonobject = jsonobject.getJSONArray("events"); i < jsonobject.length(); i++)
        {
            f.add(new aw(jsonobject.getJSONObject(i)));
        }

        n.c(f);
    }

    public int a()
    {
        return e;
    }

    public aw a(aw.b b1)
    {
        for (Iterator iterator = f.iterator(); iterator.hasNext();)
        {
            aw aw1 = (aw)iterator.next();
            if (aw1.a() == b1)
            {
                return aw1;
            }
        }

        return null;
    }

    public String a(Context context)
    {
        try
        {
            String s = g.getAbsolutePath();
            context = android.provider.MediaStore.Images.Media.insertImage(context.getContentResolver(), s, "Coupon", "Coupon");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            ad.a(context);
            return null;
        }
        return context;
    }

    public boolean a(File file)
    {
        try
        {
            g = file;
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            ad.a(file);
            return false;
        }
        return true;
    }

    public File b()
    {
        return g;
    }

    public String c()
    {
        return a;
    }

    public long d()
    {
        return b;
    }

    public void e()
    {
    }
}
