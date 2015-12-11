// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ep;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.common.images:
//            b

public final class WebImage
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    private final Uri AR;
    private final int v;
    private final int w;
    private final int wj;

    WebImage(int i, Uri uri, int j, int k)
    {
        wj = i;
        AR = uri;
        w = j;
        v = k;
    }

    public WebImage(Uri uri)
        throws IllegalArgumentException
    {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int j)
        throws IllegalArgumentException
    {
        this(1, uri, i, j);
        if (uri == null)
        {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i < 0 || j < 0)
        {
            throw new IllegalArgumentException("width and height must not be negative");
        } else
        {
            return;
        }
    }

    public WebImage(JSONObject jsonobject)
        throws IllegalArgumentException
    {
        this(c(jsonobject), jsonobject.optInt("width", 0), jsonobject.optInt("height", 0));
    }

    private static Uri c(JSONObject jsonobject)
    {
        Uri uri = null;
        if (jsonobject.has("url"))
        {
            try
            {
                uri = Uri.parse(jsonobject.getString("url"));
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return null;
            }
        }
        return uri;
    }

    public JSONObject cT()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("url", AR.toString());
            jsonobject.put("width", w);
            jsonobject.put("height", v);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof WebImage))
            {
                return false;
            }
            obj = (WebImage)obj;
            if (!ep.equal(AR, ((WebImage) (obj)).AR) || w != ((WebImage) (obj)).w || v != ((WebImage) (obj)).v)
            {
                return false;
            }
        }
        return true;
    }

    public int getHeight()
    {
        return v;
    }

    public Uri getUrl()
    {
        return AR;
    }

    int getVersionCode()
    {
        return wj;
    }

    public int getWidth()
    {
        return w;
    }

    public int hashCode()
    {
        return ep.hashCode(new Object[] {
            AR, Integer.valueOf(w), Integer.valueOf(v)
        });
    }

    public String toString()
    {
        return String.format("Image %dx%d %s", new Object[] {
            Integer.valueOf(w), Integer.valueOf(v), AR.toString()
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        b.a(this, parcel, i);
    }

}
