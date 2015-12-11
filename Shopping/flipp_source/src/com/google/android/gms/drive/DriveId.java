// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.h;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.kd;
import com.google.android.gms.internal.kf;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.drive:
//            b

public class DriveId
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new b();
    final int a;
    final String b;
    final long c;
    final long d;
    private volatile String e;

    DriveId(int i, String s, long l, long l1)
    {
label0:
        {
            boolean flag1 = false;
            super();
            e = null;
            a = i;
            b = s;
            boolean flag;
            if (!"".equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ha.b(flag);
            if (s == null)
            {
                flag = flag1;
                if (l == -1L)
                {
                    break label0;
                }
            }
            flag = true;
        }
        ha.b(flag);
        c = l;
        d = l1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof DriveId)
        {
            obj = (DriveId)obj;
            if (((DriveId) (obj)).d != d)
            {
                Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if (((DriveId) (obj)).c == -1L && c == -1L)
            {
                return ((DriveId) (obj)).b.equals(b);
            }
            if (((DriveId) (obj)).c == c)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        if (c == -1L)
        {
            return b.hashCode();
        } else
        {
            return (new StringBuilder()).append(String.valueOf(d)).append(String.valueOf(c)).toString().hashCode();
        }
    }

    public String toString()
    {
        if (e == null)
        {
            h h1 = new h();
            h1.b = a;
            Object obj;
            int i;
            if (b == null)
            {
                obj = "";
            } else
            {
                obj = b;
            }
            h1.c = ((String) (obj));
            h1.d = c;
            h1.e = d;
            obj = new byte[h1.a()];
            i = obj.length;
            try
            {
                kd kd1 = kd.a(((byte []) (obj)), i);
                h1.a(kd1);
                if (kd1.a() != 0)
                {
                    throw new IllegalStateException("Did not write as much data as expected.");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ((Throwable) (obj)));
            }
            obj = Base64.encodeToString(((byte []) (obj)), 10);
            e = (new StringBuilder("DriveId:")).append(((String) (obj))).toString();
        }
        return e;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.drive.b.a(this, parcel);
    }

}
