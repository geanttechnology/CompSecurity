// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fo;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.cast:
//            b

public class CastDevice
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    final int a;
    String b;
    String c;
    String d;
    String e;
    String f;
    int g;
    List h;
    private Inet4Address i;

    private CastDevice()
    {
        this(1, null, null, null, null, null, -1, ((List) (new ArrayList())));
    }

    CastDevice(int j, String s, String s1, String s2, String s3, String s4, int k, 
            List list)
    {
        a = j;
        b = s;
        c = s1;
        if (c != null)
        {
            try
            {
                s = InetAddress.getByName(c);
                if (s instanceof Inet4Address)
                {
                    i = (Inet4Address)s;
                }
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                i = null;
            }
        }
        d = s2;
        e = s3;
        f = s4;
        g = k;
        h = list;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof CastDevice))
        {
            return false;
        }
        obj = (CastDevice)obj;
        if (b != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CastDevice) (obj)).b == null) goto _L1; else goto _L3
_L3:
        return false;
        if (fo.a(b, ((CastDevice) (obj)).b) && fo.a(i, ((CastDevice) (obj)).i) && fo.a(e, ((CastDevice) (obj)).e) && fo.a(d, ((CastDevice) (obj)).d) && fo.a(f, ((CastDevice) (obj)).f) && g == ((CastDevice) (obj)).g && fo.a(h, ((CastDevice) (obj)).h)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        if (b == null)
        {
            return 0;
        } else
        {
            return b.hashCode();
        }
    }

    public String toString()
    {
        return String.format("\"%s\" (%s)", new Object[] {
            d, b
        });
    }

    public void writeToParcel(Parcel parcel, int j)
    {
        com.google.android.gms.cast.b.a(this, parcel);
    }

}
