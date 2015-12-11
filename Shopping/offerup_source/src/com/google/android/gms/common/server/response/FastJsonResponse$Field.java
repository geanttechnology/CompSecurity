// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.server.response:
//            zza, SafeParcelResponse, FieldMappingDictionary

public class zzahd
    implements SafeParcelable
{

    public static final zza CREATOR = new zza();
    private final int mVersionCode;
    protected final int zzagU;
    protected final boolean zzagV;
    protected final int zzagW;
    protected final boolean zzagX;
    protected final String zzagY;
    protected final int zzagZ;
    protected final Class zzaha;
    protected final String zzahb;
    private FieldMappingDictionary zzahc;
    private zzahb zzahd;

    public static zzahd zza(String s, int i, zzahd zzahd1, boolean flag)
    {
        return new <init>(zzahd1.pB(), flag, zzahd1.pC(), false, s, i, null, zzahd1);
    }

    public static pC zza(String s, int i, Class class1)
    {
        return new <init>(11, false, 11, false, s, i, class1, null);
    }

    public static <init> zzb(String s, int i, Class class1)
    {
        return new <init>(11, true, 11, true, s, i, class1, null);
    }

    static <init> zzc(<init> <init>1)
    {
        return <init>1.zzahd;
    }

    public static zzahd zzj(String s, int i)
    {
        return new <init>(0, false, 0, false, s, i, null, null);
    }

    public static <init> zzk(String s, int i)
    {
        return new <init>(4, false, 4, false, s, i, null, null);
    }

    public static <init> zzl(String s, int i)
    {
        return new <init>(6, false, 6, false, s, i, null, null);
    }

    public static <init> zzm(String s, int i)
    {
        return new <init>(7, false, 7, false, s, i, null, null);
    }

    public static <init> zzn(String s, int i)
    {
        return new <init>(7, true, 7, true, s, i, null, null);
    }

    public Object convertBack(Object obj)
    {
        return zzahd.nvertBack(obj);
    }

    public int describeContents()
    {
        return 0;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Field\n");
        stringbuilder.append("            versionCode=").append(mVersionCode).append('\n');
        stringbuilder.append("                 typeIn=").append(zzagU).append('\n');
        stringbuilder.append("            typeInArray=").append(zzagV).append('\n');
        stringbuilder.append("                typeOut=").append(zzagW).append('\n');
        stringbuilder.append("           typeOutArray=").append(zzagX).append('\n');
        stringbuilder.append("        outputFieldName=").append(zzagY).append('\n');
        stringbuilder.append("      safeParcelFieldId=").append(zzagZ).append('\n');
        stringbuilder.append("       concreteTypeName=").append(zzpM()).append('\n');
        if (zzpL() != null)
        {
            stringbuilder.append("     concreteType.class=").append(zzpL().getCanonicalName()).append('\n');
        }
        StringBuilder stringbuilder1 = stringbuilder.append("          converterName=");
        String s;
        if (zzahd == null)
        {
            s = "null";
        } else
        {
            s = zzahd.getClass().getCanonicalName();
        }
        stringbuilder1.append(s).append('\n');
        return stringbuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
    }

    public void zza(FieldMappingDictionary fieldmappingdictionary)
    {
        zzahc = fieldmappingdictionary;
    }

    public int zzpB()
    {
        return zzagU;
    }

    public int zzpC()
    {
        return zzagW;
    }

    public zzagW zzpG()
    {
        return new <init>(mVersionCode, zzagU, zzagV, zzagW, zzagX, zzagY, zzagZ, zzahb, zzpO());
    }

    public boolean zzpH()
    {
        return zzagV;
    }

    public boolean zzpI()
    {
        return zzagX;
    }

    public String zzpJ()
    {
        return zzagY;
    }

    public int zzpK()
    {
        return zzagZ;
    }

    public Class zzpL()
    {
        return zzaha;
    }

    String zzpM()
    {
        if (zzahb == null)
        {
            return null;
        } else
        {
            return zzahb;
        }
    }

    public boolean zzpN()
    {
        return zzahd != null;
    }

    ConverterWrapper zzpO()
    {
        if (zzahd == null)
        {
            return null;
        } else
        {
            return ConverterWrapper.zza(zzahd);
        }
    }

    public Map zzpP()
    {
        zzx.zzw(zzahb);
        zzx.zzw(zzahc);
        return zzahc.zzcw(zzahb);
    }


    (int i, int j, boolean flag, int k, boolean flag1, String s, int l, 
            String s1, ConverterWrapper converterwrapper)
    {
        mVersionCode = i;
        zzagU = j;
        zzagV = flag;
        zzagW = k;
        zzagX = flag1;
        zzagY = s;
        zzagZ = l;
        if (s1 == null)
        {
            zzaha = null;
            zzahb = null;
        } else
        {
            zzaha = com/google/android/gms/common/server/response/SafeParcelResponse;
            zzahb = s1;
        }
        if (converterwrapper == null)
        {
            zzahd = null;
            return;
        } else
        {
            zzahd = converterwrapper.zzpz();
            return;
        }
    }

    protected zzahd(int i, boolean flag, int j, boolean flag1, String s, int k, Class class1, 
            zzahd zzahd1)
    {
        mVersionCode = 1;
        zzagU = i;
        zzagV = flag;
        zzagW = j;
        zzagX = flag1;
        zzagY = s;
        zzagZ = k;
        zzaha = class1;
        if (class1 == null)
        {
            zzahb = null;
        } else
        {
            zzahb = class1.getCanonicalName();
        }
        zzahd = zzahd1;
    }
}
