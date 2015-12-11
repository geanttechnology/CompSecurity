// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.common.images:
//            zzb

public final class WebImage
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final Uri zzaeg;
    private final int zznQ;
    private final int zznR;

    WebImage(int i, Uri uri, int j, int k)
    {
        mVersionCode = i;
        zzaeg = uri;
        zznQ = j;
        zznR = k;
    }

    public WebImage(Uri uri)
    {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i, int j)
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
    {
        this(zzi(jsonobject), jsonobject.optInt("width", 0), jsonobject.optInt("height", 0));
    }

    private static Uri zzi(JSONObject jsonobject)
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

    public final int describeContents()
    {
        return 0;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || !(obj instanceof WebImage))
            {
                return false;
            }
            obj = (WebImage)obj;
            if (!zzw.equal(zzaeg, ((WebImage) (obj)).zzaeg) || zznQ != ((WebImage) (obj)).zznQ || zznR != ((WebImage) (obj)).zznR)
            {
                return false;
            }
        }
        return true;
    }

    public final int getHeight()
    {
        return zznR;
    }

    public final Uri getUrl()
    {
        return zzaeg;
    }

    final int getVersionCode()
    {
        return mVersionCode;
    }

    public final int getWidth()
    {
        return zznQ;
    }

    public final int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzaeg, Integer.valueOf(zznQ), Integer.valueOf(zznR)
        });
    }

    public final JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("url", zzaeg.toString());
            jsonobject.put("width", zznQ);
            jsonobject.put("height", zznR);
        }
        catch (JSONException jsonexception)
        {
            return jsonobject;
        }
        return jsonobject;
    }

    public final String toString()
    {
        return String.format("Image %dx%d %s", new Object[] {
            Integer.valueOf(zznQ), Integer.valueOf(zznR), zzaeg.toString()
        });
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
