// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.az;

import org.json.JSONException;
import org.json.JSONObject;

public final class d
{

    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public int i;

    public d(JSONObject jsonobject, String s)
    {
        try
        {
            c = jsonobject.getString("item");
            a = jsonobject.getString("item");
            d = jsonobject.getString("icon");
            h = jsonobject.getInt("thumb_width");
            i = jsonobject.getInt("thumb_height");
            f = jsonobject.getInt("width");
            g = jsonobject.getInt("height");
            if (c != null)
            {
                b = (new StringBuilder()).append(s).append(c).toString();
            }
            if (d != null)
            {
                e = (new StringBuilder()).append(s).append(d).toString();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
        }
    }
}
