// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.q;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.iy;
import com.google.android.gms.internal.iz;

// Referenced classes of package com.google.android.gms.drive:
//            c

public class DriveId
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new c();
    final int kg;
    final String qO;
    final long qP;
    final long qQ;
    private volatile String qR;

    DriveId(int i, String s, long l, long l1)
    {
label0:
        {
            boolean flag1 = false;
            super();
            qR = null;
            kg = i;
            qO = s;
            boolean flag;
            if (!"".equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            eg.r(flag);
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
        eg.r(flag);
        qP = l;
        qQ = l1;
    }

    public DriveId(String s, long l, long l1)
    {
        this(1, s, l, l1);
    }

    public static DriveId ab(String s)
    {
        eg.f(s);
        return new DriveId(s, -1L, -1L);
    }

    static DriveId d(byte abyte0[])
    {
        q q1;
        try
        {
            q1 = q.e(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException();
        }
        if ("".equals(q1.rt))
        {
            abyte0 = null;
        } else
        {
            abyte0 = q1.rt;
        }
        return new DriveId(q1.versionCode, abyte0, q1.ru, q1.rv);
    }

    public static DriveId decodeFromString(String s)
    {
        eg.b(s.startsWith("DriveId:"), (new StringBuilder()).append("Invalid DriveId: ").append(s).toString());
        return d(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    final byte[] cL()
    {
        q q1 = new q();
        q1.versionCode = kg;
        String s;
        if (qO == null)
        {
            s = "";
        } else
        {
            s = qO;
        }
        q1.rt = s;
        q1.ru = qP;
        q1.rv = qQ;
        return iz.a(q1);
    }

    public int describeContents()
    {
        return 0;
    }

    public final String encodeToString()
    {
        if (qR == null)
        {
            String s = Base64.encodeToString(cL(), 10);
            qR = (new StringBuilder()).append("DriveId:").append(s).toString();
        }
        return qR;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof DriveId)
        {
            obj = (DriveId)obj;
            if (((DriveId) (obj)).qQ != qQ)
            {
                Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if (((DriveId) (obj)).qP == -1L && qP == -1L)
            {
                return ((DriveId) (obj)).qO.equals(qO);
            }
            if (((DriveId) (obj)).qP == qP)
            {
                return true;
            }
        }
        return false;
    }

    public String getResourceId()
    {
        return qO;
    }

    public int hashCode()
    {
        if (qP == -1L)
        {
            return qO.hashCode();
        } else
        {
            return (new StringBuilder()).append(String.valueOf(qQ)).append(String.valueOf(qP)).toString().hashCode();
        }
    }

    public String toString()
    {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        c.a(this, parcel, i);
    }

}
