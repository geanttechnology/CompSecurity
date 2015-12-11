// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.tracker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.b.a.a.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.offerup.android.tracker:
//            b

public class ItemDetailUserInteractionRecord
    implements Parcelable
{

    private int a;
    private List b;
    private int c;

    private ItemDetailUserInteractionRecord()
    {
        new b(this);
        b = new ArrayList();
    }

    ItemDetailUserInteractionRecord(byte byte0)
    {
        this();
    }

    static int a(ItemDetailUserInteractionRecord itemdetailuserinteractionrecord, int i)
    {
        itemdetailuserinteractionrecord.a = i;
        return i;
    }

    public static ItemDetailUserInteractionRecord a(Bundle bundle)
    {
        if (bundle.containsKey("ItemDetailUserInteractionRecord"))
        {
            return (ItemDetailUserInteractionRecord)bundle.getParcelable("ItemDetailUserInteractionRecord");
        } else
        {
            return new ItemDetailUserInteractionRecord();
        }
    }

    static List a(ItemDetailUserInteractionRecord itemdetailuserinteractionrecord, List list)
    {
        itemdetailuserinteractionrecord.b = list;
        return list;
    }

    static int b(ItemDetailUserInteractionRecord itemdetailuserinteractionrecord, int i)
    {
        itemdetailuserinteractionrecord.c = i;
        return i;
    }

    public final void a()
    {
        a = a + 1;
    }

    public final void a(int i)
    {
        if (!b.contains(Integer.valueOf(i)))
        {
            b.add(Integer.valueOf(i));
        }
    }

    public final JSONObject b()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("carousel_swipe_total", a);
            jsonobject.put("carousel_images_viewed", b.size());
            jsonobject.put("carousel_image_total", c);
        }
        catch (JSONException jsonexception)
        {
            g.a(this, jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final void b(int i)
    {
        c = i;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeValue(Integer.valueOf(a));
        parcel.writeValue(b);
        parcel.writeValue(Integer.valueOf(c));
    }
}
