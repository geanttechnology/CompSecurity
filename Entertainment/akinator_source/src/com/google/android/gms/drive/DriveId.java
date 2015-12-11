// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;

// Referenced classes of package com.google.android.gms.drive:
//            zze, DriveFile, DriveFolder, DriveResource

public class DriveId
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    public static final int RESOURCE_TYPE_FILE = 0;
    public static final int RESOURCE_TYPE_FOLDER = 1;
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    final int mVersionCode;
    final String zzaiM;
    final long zzaiN;
    final int zzaiO;
    private volatile String zzaiP;
    final long zzaiv;
    private volatile String zzaix;

    DriveId(int i, String s, long l, long l1, int j)
    {
label0:
        {
            boolean flag1 = false;
            super();
            zzaix = null;
            zzaiP = null;
            mVersionCode = i;
            zzaiM = s;
            boolean flag;
            if (!"".equals(s))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zzaa(flag);
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
        zzx.zzaa(flag);
        zzaiN = l;
        zzaiv = l1;
        zzaiO = j;
    }

    public DriveId(String s, long l, long l1, int i)
    {
        this(1, s, l, l1, i);
    }

    public static DriveId decodeFromString(String s)
    {
        zzx.zzb(s.startsWith("DriveId:"), (new StringBuilder()).append("Invalid DriveId: ").append(s).toString());
        return zzk(Base64.decode(s.substring("DriveId:".length()), 10));
    }

    public static DriveId zzcB(String s)
    {
        zzx.zzw(s);
        return new DriveId(s, -1L, -1L, -1);
    }

    static DriveId zzk(byte abyte0[])
    {
        zzat zzat1;
        try
        {
            zzat1 = zzat.zzl(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException();
        }
        if ("".equals(zzat1.zzalQ))
        {
            abyte0 = null;
        } else
        {
            abyte0 = zzat1.zzalQ;
        }
        return new DriveId(zzat1.versionCode, abyte0, zzat1.zzalR, zzat1.zzalO, zzat1.zzalS);
    }

    private byte[] zzqR()
    {
        zzau zzau1 = new zzau();
        zzau1.zzalR = zzaiN;
        zzau1.zzalO = zzaiv;
        return zzse.zzf(zzau1);
    }

    public DriveFile asDriveFile()
    {
        if (zzaiO == 1)
        {
            throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
        } else
        {
            return new zzw(this);
        }
    }

    public DriveFolder asDriveFolder()
    {
        if (zzaiO == 0)
        {
            throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
        } else
        {
            return new zzy(this);
        }
    }

    public DriveResource asDriveResource()
    {
        if (zzaiO == 1)
        {
            return asDriveFolder();
        }
        if (zzaiO == 0)
        {
            return asDriveFile();
        } else
        {
            return new zzab(this);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public final String encodeToString()
    {
        if (zzaix == null)
        {
            String s = Base64.encodeToString(zzqL(), 10);
            zzaix = (new StringBuilder()).append("DriveId:").append(s).toString();
        }
        return zzaix;
    }

    public boolean equals(Object obj)
    {
        boolean flag = true;
        if (obj instanceof DriveId)
        {
            obj = (DriveId)obj;
            if (((DriveId) (obj)).zzaiv != zzaiv)
            {
                zzz.zzy("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
                return false;
            }
            if (((DriveId) (obj)).zzaiN == -1L && zzaiN == -1L)
            {
                return ((DriveId) (obj)).zzaiM.equals(zzaiM);
            }
            if (zzaiM == null || ((DriveId) (obj)).zzaiM == null)
            {
                if (((DriveId) (obj)).zzaiN != zzaiN)
                {
                    flag = false;
                }
                return flag;
            }
            if (((DriveId) (obj)).zzaiN == zzaiN)
            {
                if (((DriveId) (obj)).zzaiM.equals(zzaiM))
                {
                    return true;
                } else
                {
                    zzz.zzy("DriveId", "Unexpected unequal resourceId for same DriveId object.");
                    return false;
                }
            }
        }
        return false;
    }

    public String getResourceId()
    {
        return zzaiM;
    }

    public int getResourceType()
    {
        return zzaiO;
    }

    public int hashCode()
    {
        if (zzaiN == -1L)
        {
            return zzaiM.hashCode();
        } else
        {
            return (new StringBuilder()).append(String.valueOf(zzaiv)).append(String.valueOf(zzaiN)).toString().hashCode();
        }
    }

    public final String toInvariantString()
    {
        if (zzaiP == null)
        {
            zzaiP = Base64.encodeToString(zzqR(), 10);
        }
        return zzaiP;
    }

    public String toString()
    {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }

    final byte[] zzqL()
    {
        zzat zzat1 = new zzat();
        zzat1.versionCode = mVersionCode;
        String s;
        if (zzaiM == null)
        {
            s = "";
        } else
        {
            s = zzaiM;
        }
        zzat1.zzalQ = s;
        zzat1.zzalR = zzaiN;
        zzat1.zzalO = zzaiv;
        zzat1.zzalS = zzaiO;
        return zzse.zzf(zzat1);
    }

}
