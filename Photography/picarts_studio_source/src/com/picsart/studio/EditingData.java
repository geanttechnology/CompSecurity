// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.socialin.android.util.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import myobfuscated.f.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditingData
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public double m;
    public double n;
    private Bundle o;
    private Bundle p;

    private EditingData(Location location)
    {
        m = -1D;
        n = -1D;
        a = UUID.randomUUID().toString();
        o = new Bundle();
        p = new Bundle();
        if (location != null)
        {
            m = location.getLongitude();
            n = location.getLatitude();
        }
    }

    private EditingData(Parcel parcel)
    {
        m = -1D;
        n = -1D;
        a = parcel.readString();
        b = parcel.readString();
        c = parcel.readInt();
        d = parcel.readInt();
        k = parcel.readInt();
        l = parcel.readInt();
        e = parcel.readInt();
        f = parcel.readInt();
        g = parcel.readInt();
        h = parcel.readInt();
        i = parcel.readInt();
        o = parcel.readBundle();
        j = parcel.readInt();
        p = parcel.readBundle();
        m = parcel.readDouble();
        n = parcel.readDouble();
    }

    EditingData(Parcel parcel, byte byte0)
    {
        this(parcel);
    }

    private EditingData(JSONObject jsonobject)
    {
        m = -1D;
        n = -1D;
        o = new Bundle();
        p = new Bundle();
        a = jsonobject.optString("uid", UUID.randomUUID().toString());
        b = jsonobject.optString("origin");
        if ((TextUtils.isEmpty(b) || "unknown".equals(b)) && jsonobject.has("from"))
        {
            b = jsonobject.optString("from");
        }
        c = jsonobject.optInt("total_effects_time");
        d = jsonobject.optInt("total_effects_actions");
        k = jsonobject.optInt("effects_applied");
        l = jsonobject.optInt("effects_tried");
        e = jsonobject.optInt("total_draw_time");
        f = jsonobject.optInt("total_draw_actions");
        g = jsonobject.optInt("layers_used");
        h = jsonobject.optInt("brushes_used");
        e = jsonobject.optInt("total_draw_time");
        i = jsonobject.optInt("total_editor_time");
        JSONObject jsonobject1 = jsonobject.optJSONObject("total_editor_actions");
        if (jsonobject1 != null)
        {
            String s;
            for (Iterator iterator = jsonobject1.keys(); iterator.hasNext(); o.putInt(s, jsonobject1.optInt(s)))
            {
                s = (String)iterator.next();
            }

        }
        j = jsonobject.optInt("photos_added");
        jsonobject1 = jsonobject.optJSONObject("tools_used");
        if (jsonobject1 != null)
        {
            String s1;
            for (Iterator iterator1 = jsonobject1.keys(); iterator1.hasNext(); p.putInt(s1, jsonobject1.optInt(s1)))
            {
                s1 = (String)iterator1.next();
            }

        }
        m = jsonobject.optDouble("longitude");
        n = jsonobject.optDouble("latitude");
    }

    public static EditingData a(Location location)
    {
        return a(location, "unknown");
    }

    public static EditingData a(Location location, String s)
    {
        location = new EditingData(location);
        location.b = s;
        return location;
    }

    public static EditingData a(String s)
    {
        s = myobfuscated.f.m.c(s);
        if (TextUtils.isEmpty(s))
        {
            return new EditingData(((Location) (null)));
        }
        try
        {
            s = new EditingData(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return new EditingData(((Location) (null)));
        }
        return s;
    }

    public static EditingData a(String s, String s1)
    {
        s = myobfuscated.f.m.c(s);
        if (TextUtils.isEmpty(s))
        {
            return a(((Location) (null)), s1);
        }
        try
        {
            s = new JSONObject(s);
            if (!s.has("origin"))
            {
                s.put("origin", s1);
            }
            s = new EditingData(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return a(((Location) (null)), s1);
        }
        return s;
    }

    public static EditingData b(String s)
    {
        s = FileUtils.d(new File(s));
        if (TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_42;
        }
        s = new EditingData(new JSONObject(s));
        return s;
        s;
        s.printStackTrace();
        return new EditingData(((Location) (null)));
    }

    private JSONObject d()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            if (o != null)
            {
                String s;
                for (Iterator iterator = o.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, o.getInt(s)))
                {
                    s = (String)iterator.next();
                }

            }
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
        }
        return jsonobject;
    }

    private JSONObject e()
    {
        JSONObject jsonobject = new JSONObject();
        Iterator iterator;
        if (p == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        iterator = p.keySet().iterator();
_L2:
        String s;
        int i1;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_78;
            }
            s = (String)iterator.next();
            i1 = p.getInt(s);
        } while (i1 <= 0);
        jsonobject.put(s, i1);
        if (true) goto _L2; else goto _L1
_L1:
        JSONException jsonexception;
        jsonexception;
        jsonexception.printStackTrace();
        return jsonobject;
    }

    public final JSONArray a()
    {
        JSONArray jsonarray = new JSONArray();
        if (o != null)
        {
            for (Iterator iterator = o.keySet().iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                try
                {
                    jsonarray.put((new StringBuilder()).append(s).append(":").append(o.getInt(s)).toString());
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }

        }
        return jsonarray;
    }

    public final JSONArray b()
    {
        JSONArray jsonarray = new JSONArray();
        if (p == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = p.keySet().iterator();
_L3:
        String s;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)iterator.next();
        int i1 = p.getInt(s);
        if (i1 > 0)
        {
            try
            {
                jsonarray.put((new StringBuilder()).append(s).append(":").append(i1).toString());
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        return jsonarray;
    }

    public final JSONObject c()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("uid", a);
            jsonobject.put("origin", b);
            jsonobject.put("total_effects_time", c);
            jsonobject.put("total_effects_actions", d);
            jsonobject.put("effects_applied", k);
            jsonobject.put("effects_tried", l);
            jsonobject.put("total_draw_time", e);
            jsonobject.put("total_draw_actions", f);
            jsonobject.put("layers_used", g);
            jsonobject.put("brushes_used", h);
            jsonobject.put("total_draw_time", e);
            jsonobject.put("total_editor_time", i);
            jsonobject.put("total_editor_actions", d());
            jsonobject.put("photos_added", j);
            jsonobject.put("tools_used", e());
            jsonobject.put("longitude", m);
            jsonobject.put("latitude", n);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            return jsonobject;
        }
        return jsonobject;
    }

    public final void c(String s)
    {
        p.putInt(s, p.getInt(s) + 1);
    }

    public final void d(String s)
    {
        o.putInt(s, o.getInt(s) + 1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i1)
    {
        parcel.writeString(a);
        parcel.writeString(b);
        parcel.writeInt(c);
        parcel.writeInt(d);
        parcel.writeInt(k);
        parcel.writeInt(l);
        parcel.writeInt(e);
        parcel.writeInt(f);
        parcel.writeInt(g);
        parcel.writeInt(h);
        parcel.writeInt(i);
        parcel.writeBundle(o);
        parcel.writeInt(j);
        parcel.writeBundle(p);
        parcel.writeDouble(m);
        parcel.writeDouble(n);
    }


    /* member class not found */
    class _cls1 {}

}
