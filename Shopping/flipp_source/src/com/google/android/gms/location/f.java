// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.location:
//            n

public class f
    implements SafeParcelable
{

    public static final n CREATOR = new n();
    final int a;
    final PendingIntent b;
    final String c;

    public f(int i, PendingIntent pendingintent, String s)
    {
        a = i;
        b = pendingintent;
        c = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (f)obj;
        if (b == null)
        {
            if (((f) (obj)).b != null)
            {
                return false;
            }
        } else
        if (!b.equals(((f) (obj)).b))
        {
            return false;
        }
        if (c != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((f) (obj)).c == null) goto _L1; else goto _L3
_L3:
        return false;
        if (c.equals(((f) (obj)).c)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (b == null)
        {
            i = 0;
        } else
        {
            i = b.hashCode();
        }
        if (c != null)
        {
            j = c.hashCode();
        }
        return (i + 31) * 31 + j;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        n.a(this, parcel, i);
    }

}
