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
//            c

public class PhotoGalleryUserInteractionRecord
    implements Parcelable
{

    private List a;
    private int b;
    private int c;
    private long d;
    private long e;

    private PhotoGalleryUserInteractionRecord()
    {
        new c(this);
        a = new ArrayList();
        e = System.currentTimeMillis();
    }

    PhotoGalleryUserInteractionRecord(byte byte0)
    {
        this();
    }

    static int a(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord, int i)
    {
        photogalleryuserinteractionrecord.b = i;
        return i;
    }

    static long a(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord, long l)
    {
        photogalleryuserinteractionrecord.d = l;
        return l;
    }

    public static PhotoGalleryUserInteractionRecord a(Bundle bundle)
    {
        if (bundle.containsKey("PhotoGalleryUserInteractionRecord"))
        {
            return (PhotoGalleryUserInteractionRecord)bundle.getParcelable("PhotoGalleryUserInteractionRecord");
        } else
        {
            return new PhotoGalleryUserInteractionRecord();
        }
    }

    static List a(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord, List list)
    {
        photogalleryuserinteractionrecord.a = list;
        return list;
    }

    static int b(PhotoGalleryUserInteractionRecord photogalleryuserinteractionrecord, int i)
    {
        photogalleryuserinteractionrecord.c = i;
        return i;
    }

    public final void a()
    {
        long l = e;
        e = System.currentTimeMillis();
        if (e < l)
        {
            e = 1L + l;
        }
        long l1 = d;
        d = (e - l) + l1;
    }

    public final void a(int i)
    {
        if (!a.contains(Integer.valueOf(i)))
        {
            a.add(Integer.valueOf(i));
        }
    }

    public final void b()
    {
        e = System.currentTimeMillis();
    }

    public final void b(int i)
    {
        b = i;
    }

    public final void c()
    {
        c = c + 1;
    }

    public final JSONObject d()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("images_viewed", a.size());
            jsonobject.put("image_total", b);
            jsonobject.put("swipe_total", c);
            jsonobject.put("event_duration", d);
        }
        catch (JSONException jsonexception)
        {
            g.a(this, jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeValue(a);
        parcel.writeValue(Integer.valueOf(b));
        parcel.writeValue(Integer.valueOf(c));
        parcel.writeValue(Long.valueOf(d));
    }
}
