// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;

// Referenced classes of package com.google.android.gms.drive:
//            zzd

public class DriveId
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzagC;
    final long zzagD;
    final int zzagE;
    private volatile String zzagF;
    final long zzagn;
    private volatile String zzagp;

    DriveId(int i, String s, long l, long l1, int j)
    {
label0:
        {
            boolean flag1 = false;
            super();
            zzagp = null;
            zzagF = null;
            mVersionCode = i;
            zzagC = s;
            boolean flag;
            if (!"".equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzZ(flag);
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
        zzx.zzZ(flag);
        zzagD = l;
        zzagn = l1;
        zzagE = j;
    }

    public DriveId(String s, long l, long l1, int i)
    {
        if (s != null && s.startsWith("generated-android-"))
        {
            s = null;
        }
        this(1, s, l, l1, i);
    }

    public static DriveId decodeFromString(String s)
    {
        zzx.zzb(s.startsWith("DriveId:"), (new StringBuilder()).append("Invalid DriveId: ").append(s).toString());
        return zzk(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcC(String s)
    {
        zzx.zzv(s);
        return new DriveId(s, -1L, -1L, -1);
    }

    static DriveId zzk(byte abyte0[])
    {
        zzas zzas1;
        try
        {
            zzas1 = zzas.zzl(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException();
        }
        if ("".equals(zzas1.zzajB))
        {
            abyte0 = null;
        } else
        {
            abyte0 = zzas1.zzajB;
        }
        return new DriveId(zzas1.versionCode, abyte0, zzas1.zzajC, zzas1.zzajz, zzas1.zzajD);
    }

    private byte[] zzqk()
    {
        zzat zzat1 = new zzat();
        zzat1.zzajC = zzagD;
        zzat1.zzajz = zzagn;
        return zzrx.zzf(zzat1);
    }

    public int describeContents()
    {
        return 0;
    }

    public final String encodeToString()
    {
        if (zzagp == null)
        {
            String s = Base64.encodeToString(zzqe(), 10);
            zzagp = (new StringBuilder()).append("DriveId:").append(s).toString();
        }
        return zzagp;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj instanceof DriveId)
        {
            obj = (DriveId)obj;
            if (((DriveId) (obj)).zzagn != zzagn)
            {
                zzy.zzw("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if (((DriveId) (obj)).zzagD == -1L && zzagD == -1L)
            {
                return ((DriveId) (obj)).zzagC.equals(zzagC);
            }
            if (zzagC == null || ((DriveId) (obj)).zzagC == null)
            {
                if (((DriveId) (obj)).zzagD != zzagD)
                {
                    flag = false;
                }
                return flag;
            }
            if (((DriveId) (obj)).zzagD == zzagD)
            {
                if (((DriveId) (obj)).zzagC.equals(zzagC))
                {
                    return true;
                } else
                {
                    zzy.zzw("DriveId", "Unexpected unequal resourceId for same DriveId object.");
                    return false;
                }
            }
        }
        return false;
    }

    public String getResourceId()
    {
        return zzagC;
    }

    public int getResourceType()
    {
        return zzagE;
    }

    public int hashCode()
    {
        if (zzagD == -1L)
        {
            return zzagC.hashCode();
        } else
        {
            return (new StringBuilder()).append(String.valueOf(zzagn)).append(String.valueOf(zzagD)).toString().hashCode();
        }
    }

    public final String toInvariantString()
    {
        if (zzagF == null)
        {
            zzagF = Base64.encodeToString(zzqk(), 10);
        }
        return zzagF;
    }

    public String toString()
    {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    final byte[] zzqe()
    {
        zzas zzas1 = new zzas();
        zzas1.versionCode = mVersionCode;
        String s;
        if (zzagC == null)
        {
            s = "";
        } else
        {
            s = zzagC;
        }
        zzas1.zzajB = s;
        zzas1.zzajC = zzagD;
        zzas1.zzajz = zzagn;
        zzas1.zzajD = zzagE;
        return zzrx.zzf(zzas1);
    }

}
