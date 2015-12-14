// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzt, MapValue

public final class Value
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzt();
    private final int mVersionCode;
    private boolean zzaoG;
    private String zzaoH;
    private Map zzaoI;
    private int zzaoJ[];
    private float zzaoK[];
    private final int zzaoq;
    private float zzaou;

    public Value(int i)
    {
        this(3, i, false, 0.0F, null, null, null, null);
    }

    Value(int i, int j, boolean flag, float f, String s, Bundle bundle, int ai[], 
            float af[])
    {
        mVersionCode = i;
        zzaoq = j;
        zzaoG = flag;
        zzaou = f;
        zzaoH = s;
        zzaoI = zzs(bundle);
        zzaoJ = ai;
        zzaoK = af;
    }

    private boolean zza(Value value)
    {
        if (zzaoq != value.zzaoq || zzaoG != value.zzaoG) goto _L2; else goto _L1
_L1:
        zzaoq;
        JVM INSTR tableswitch 1 6: default 64
    //                   1 78
    //                   2 91
    //                   3 105
    //                   4 117
    //                   5 131
    //                   6 143;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        if (zzaou != value.zzaou) goto _L11; else goto _L10
_L10:
        return true;
_L4:
        if (asInt() == value.asInt()) goto _L10; else goto _L12
_L12:
        return false;
_L5:
        if (asFloat() == value.asFloat()) goto _L10; else goto _L13
_L13:
        return false;
_L6:
        return asString().equals(value.asString());
_L7:
        return zzqX().equals(value.zzqX());
_L8:
        return zzrS().equals(value.zzrS());
_L9:
        return zzrT().equals(value.zzrT());
_L11:
        return false;
_L2:
        return false;
    }

    private static Map zzs(Bundle bundle)
    {
        if (bundle == null)
        {
            return null;
        }
        bundle.setClassLoader(com/google/android/gms/fitness/data/MapValue.getClassLoader());
        ArrayMap arraymap = new ArrayMap(bundle.size());
        String s;
        for (Iterator iterator = bundle.keySet().iterator(); iterator.hasNext(); arraymap.put(s, bundle.getParcelable(s)))
        {
            s = (String)iterator.next();
        }

        return arraymap;
    }

    public String asActivity()
    {
        return FitnessActivities.getName(asInt());
    }

    public float asFloat()
    {
        boolean flag;
        if (zzaoq == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float format");
        return zzaou;
    }

    public int asInt()
    {
        boolean flag = true;
        if (zzaoq != 1)
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in int format");
        return Float.floatToRawIntBits(zzaou);
    }

    public String asString()
    {
        boolean flag;
        if (zzaoq == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in string format");
        return zzaoH;
    }

    public void clearKey(String s)
    {
        boolean flag;
        if (zzaoq == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (zzaoI != null)
        {
            zzaoI.remove(s);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof Value) && zza((Value)obj);
    }

    public int getFormat()
    {
        return zzaoq;
    }

    public Float getKeyValue(String s)
    {
        boolean flag;
        if (zzaoq == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float map format");
        if (zzaoI != null && zzaoI.containsKey(s))
        {
            return Float.valueOf(((MapValue)zzaoI.get(s)).asFloat());
        } else
        {
            return null;
        }
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Float.valueOf(zzaou), zzaoH, zzaoI, zzaoJ, zzaoK
        });
    }

    public boolean isSet()
    {
        return zzaoG;
    }

    public void setActivity(String s)
    {
        setInt(FitnessActivities.zzcP(s));
    }

    public void setFloat(float f)
    {
        boolean flag;
        if (zzaoq == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        zzaoG = true;
        zzaou = f;
    }

    public void setInt(int i)
    {
        boolean flag;
        if (zzaoq == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        zzaoG = true;
        zzaou = Float.intBitsToFloat(i);
    }

    public void setKeyValue(String s, float f)
    {
        boolean flag;
        if (zzaoq == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        zzaoG = true;
        if (zzaoI == null)
        {
            zzaoI = new HashMap();
        }
        zzaoI.put(s, MapValue.zzc(f));
    }

    public void setString(String s)
    {
        boolean flag;
        if (zzaoq == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        zzaoG = true;
        zzaoH = s;
    }

    public String toString()
    {
        if (!zzaoG)
        {
            return "unset";
        }
        switch (zzaoq)
        {
        default:
            return "unknown";

        case 1: // '\001'
            return Integer.toString(asInt());

        case 2: // '\002'
            return Float.toString(asFloat());

        case 3: // '\003'
            return zzaoH;

        case 4: // '\004'
            return (new TreeMap(zzaoI)).toString();

        case 5: // '\005'
            return zzrS().toString();

        case 6: // '\006'
            return zzrT().toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzt.zza(this, parcel, i);
    }

    public Map zzqX()
    {
        boolean flag;
        if (zzaoq == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float map format");
        if (zzaoI == null)
        {
            return Collections.emptyMap();
        } else
        {
            return zzaoI;
        }
    }

    float zzrM()
    {
        return zzaou;
    }

    public int[] zzrS()
    {
        boolean flag;
        if (zzaoq == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in int list format");
        return zzaoJ;
    }

    public float[] zzrT()
    {
        boolean flag;
        if (zzaoq == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float list format");
        return zzaoK;
    }

    String zzrU()
    {
        return zzaoH;
    }

    Bundle zzrV()
    {
        if (zzaoI == null)
        {
            return null;
        }
        Bundle bundle = new Bundle(zzaoI.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = zzaoI.entrySet().iterator(); iterator.hasNext(); bundle.putParcelable((String)entry.getKey(), (Parcelable)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return bundle;
    }

    int[] zzrW()
    {
        return zzaoJ;
    }

    float[] zzrX()
    {
        return zzaoK;
    }

}
