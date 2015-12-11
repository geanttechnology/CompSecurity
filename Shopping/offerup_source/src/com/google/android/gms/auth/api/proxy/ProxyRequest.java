// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.auth.api.proxy:
//            zzb

public class ProxyRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    public static final int HTTP_METHOD_DELETE = 3;
    public static final int HTTP_METHOD_GET = 0;
    public static final int HTTP_METHOD_HEAD = 4;
    public static final int HTTP_METHOD_OPTIONS = 5;
    public static final int HTTP_METHOD_PATCH = 7;
    public static final int HTTP_METHOD_POST = 1;
    public static final int HTTP_METHOD_PUT = 2;
    public static final int HTTP_METHOD_TRACE = 6;
    public static final int LAST_CODE = 7;
    public static final int VERSION_CODE = 2;
    public final byte body[];
    public final int httpMethod;
    public final long timeoutMillis;
    public final String url;
    final int versionCode;
    Bundle zzSK;

    ProxyRequest(int i, String s, int j, long l, byte abyte0[], Bundle bundle)
    {
        versionCode = i;
        url = s;
        httpMethod = j;
        timeoutMillis = l;
        body = abyte0;
        zzSK = bundle;
    }

    public int describeContents()
    {
        return 0;
    }

    public Map getHeaderMap()
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap(zzSK.size());
        String s;
        for (Iterator iterator = zzSK.keySet().iterator(); iterator.hasNext(); linkedhashmap.put(s, zzSK.getString(s)))
        {
            s = (String)iterator.next();
        }

        return Collections.unmodifiableMap(linkedhashmap);
    }

    public String toString()
    {
        return (new StringBuilder("ProxyRequest[ url: ")).append(url).append(", method: ").append(httpMethod).append(" ]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

}
