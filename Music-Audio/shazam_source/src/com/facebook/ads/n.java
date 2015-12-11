// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.graphics.Color;
import android.graphics.Typeface;
import com.facebook.ads.a.f.b;
import com.facebook.ads.a.f.c;
import org.json.JSONObject;

public final class n
{

    private Typeface a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;

    public n()
    {
        a = Typeface.DEFAULT;
        b = -1;
        c = 0xff000000;
        d = 0xff4e5665;
        e = 0;
        f = 0xff4278e7;
        g = 0xff4278e7;
        h = true;
    }

    public n(JSONObject jsonobject)
    {
        int k;
        k = 0;
        super();
        a = Typeface.DEFAULT;
        b = -1;
        c = 0xff000000;
        d = 0xff4e5665;
        e = 0;
        f = 0xff4278e7;
        g = 0xff4278e7;
        h = true;
        int i;
        int j;
        int l;
        int i1;
        if (jsonobject.getBoolean("background_transparent"))
        {
            i = 0;
        } else
        {
            try
            {
                i = Color.parseColor(jsonobject.getString("background_color"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(jsonobject, "Error retrieving native ui configuration data"));
                return;
            }
        }
        l = Color.parseColor(jsonobject.getString("title_text_color"));
        i1 = Color.parseColor(jsonobject.getString("description_text_color"));
        if (!jsonobject.getBoolean("button_transparent")) goto _L2; else goto _L1
_L1:
        j = 0;
_L3:
        if (!jsonobject.getBoolean("button_border_transparent"))
        {
            break MISSING_BLOCK_LABEL_194;
        }
_L4:
        int j1 = Color.parseColor(jsonobject.getString("button_text_color"));
        jsonobject = Typeface.create(jsonobject.getString("android_typeface"), 0);
        b = i;
        c = l;
        d = i1;
        e = j;
        g = k;
        f = j1;
        a = jsonobject;
        return;
_L2:
        j = Color.parseColor(jsonobject.getString("button_color"));
          goto _L3
        k = Color.parseColor(jsonobject.getString("button_border_color"));
          goto _L4
    }
}
