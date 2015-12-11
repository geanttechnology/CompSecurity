// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wearable;

import ady;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import auq;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.google.android.gms.wearable:
//            Asset

public class PutDataRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new auq();
    private static final Random b = new SecureRandom();
    public final int a;
    private final Uri c;
    private final Bundle d;
    private byte e[];

    private PutDataRequest(int i, Uri uri)
    {
        this(i, uri, new Bundle(), null);
    }

    public PutDataRequest(int i, Uri uri, Bundle bundle, byte abyte0[])
    {
        a = i;
        c = uri;
        d = bundle;
        d.setClassLoader(com/google/android/gms/wearable/internal/DataItemAssetParcelable.getClassLoader());
        e = abyte0;
    }

    public static PutDataRequest a(Uri uri)
    {
        return new PutDataRequest(1, uri);
    }

    public static PutDataRequest a(String s)
    {
        return a(b(s));
    }

    private static Uri b(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("An empty path was supplied.");
        }
        if (!s.startsWith("/"))
        {
            throw new IllegalArgumentException("A path must start with a single / .");
        }
        if (s.startsWith("//"))
        {
            throw new IllegalArgumentException("A path must start with a single / .");
        } else
        {
            return (new android.net.Uri.Builder()).scheme("wear").path(s).build();
        }
    }

    public Uri a()
    {
        return c;
    }

    public PutDataRequest a(String s, Asset asset)
    {
        ady.a(s);
        ady.a(asset);
        d.putParcelable(s, asset);
        return this;
    }

    public PutDataRequest a(byte abyte0[])
    {
        e = abyte0;
        return this;
    }

    public String a(boolean flag)
    {
        StringBuilder stringbuilder = new StringBuilder("PutDataRequest[");
        StringBuilder stringbuilder1 = (new StringBuilder()).append("dataSz=");
        Object obj;
        if (e == null)
        {
            obj = "null";
        } else
        {
            obj = Integer.valueOf(e.length);
        }
        stringbuilder.append(stringbuilder1.append(obj).toString());
        stringbuilder.append((new StringBuilder()).append(", numAssets=").append(d.size()).toString());
        stringbuilder.append((new StringBuilder()).append(", uri=").append(c).toString());
        if (!flag)
        {
            stringbuilder.append("]");
            return stringbuilder.toString();
        }
        stringbuilder.append("]\n  assets: ");
        String s;
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); stringbuilder.append((new StringBuilder()).append("\n    ").append(s).append(": ").append(d.getParcelable(s)).toString()))
        {
            s = (String)iterator.next();
        }

        stringbuilder.append("\n  ]");
        return stringbuilder.toString();
    }

    public byte[] b()
    {
        return e;
    }

    public Map c()
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = d.keySet().iterator(); iterator.hasNext(); hashmap.put(s, (Asset)d.getParcelable(s)))
        {
            s = (String)iterator.next();
        }

        return Collections.unmodifiableMap(hashmap);
    }

    public Bundle d()
    {
        return d;
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return a(Log.isLoggable("DataMap", 3));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        auq.a(this, parcel, i);
    }

}
