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
    private final int zzaqO;
    private float zzaqS;
    private boolean zzare;
    private String zzarf;
    private Map zzarg;
    private int zzarh[];
    private float zzari[];

    public Value(int i)
    {
        this(3, i, false, 0.0F, null, null, null, null);
    }

    Value(int i, int j, boolean flag, float f, String s, Bundle bundle, int ai[], 
            float af[])
    {
        mVersionCode = i;
        zzaqO = j;
        zzare = flag;
        zzaqS = f;
        zzarf = s;
        zzarg = zzs(bundle);
        zzarh = ai;
        zzari = af;
    }

    private boolean zza(Value value)
    {
        if (zzaqO != value.zzaqO || zzare != value.zzare) goto _L2; else goto _L1
_L1:
        zzaqO;
        JVM INSTR tableswitch 1 6: default 64
    //                   1 78
    //                   2 91
    //                   3 105
    //                   4 117
    //                   5 131
    //                   6 143;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        if (zzaqS != value.zzaqS) goto _L11; else goto _L10
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
        return zzrH().equals(value.zzrH());
_L8:
        return zzsE().equals(value.zzsE());
_L9:
        return zzsF().equals(value.zzsF());
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
        if (zzaqO == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float format");
        return zzaqS;
    }

    public int asInt()
    {
        boolean flag = true;
        if (zzaqO != 1)
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in int format");
        return Float.floatToRawIntBits(zzaqS);
    }

    public String asString()
    {
        boolean flag;
        if (zzaqO == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in string format");
        return zzarf;
    }

    public void clearKey(String s)
    {
        boolean flag;
        if (zzaqO == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        if (zzarg != null)
        {
            zzarg.remove(s);
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
        return zzaqO;
    }

    public Float getKeyValue(String s)
    {
        boolean flag;
        if (zzaqO == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float map format");
        if (zzarg != null && zzarg.containsKey(s))
        {
            return Float.valueOf(((MapValue)zzarg.get(s)).asFloat());
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
            Float.valueOf(zzaqS), zzarf, zzarg, zzarh, zzari
        });
    }

    public boolean isSet()
    {
        return zzare;
    }

    public void setActivity(String s)
    {
        setInt(FitnessActivities.zzcO(s));
    }

    public void setFloat(float f)
    {
        boolean flag;
        if (zzaqO == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        zzare = true;
        zzaqS = f;
    }

    public void setInt(int i)
    {
        boolean flag;
        if (zzaqO == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        zzare = true;
        zzaqS = Float.intBitsToFloat(i);
    }

    public void setKeyValue(String s, float f)
    {
        boolean flag;
        if (zzaqO == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        zzare = true;
        if (zzarg == null)
        {
            zzarg = new HashMap();
        }
        zzarg.put(s, MapValue.zzc(f));
    }

    public void setString(String s)
    {
        boolean flag;
        if (zzaqO == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        zzare = true;
        zzarf = s;
    }

    public String toString()
    {
        if (!zzare)
        {
            return "unset";
        }
        switch (zzaqO)
        {
        default:
            return "unknown";

        case 1: // '\001'
            return Integer.toString(asInt());

        case 2: // '\002'
            return Float.toString(asFloat());

        case 3: // '\003'
            return zzarf;

        case 4: // '\004'
            return (new TreeMap(zzarg)).toString();

        case 5: // '\005'
            return zzsE().toString();

        case 6: // '\006'
            return zzsF().toString();
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzt.zza(this, parcel, i);
    }

    public Map zzrH()
    {
        boolean flag;
        if (zzaqO == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float map format");
        if (zzarg == null)
        {
            return Collections.emptyMap();
        } else
        {
            return zzarg;
        }
    }

    public int[] zzsE()
    {
        boolean flag;
        if (zzaqO == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in int list format");
        return zzarh;
    }

    public float[] zzsF()
    {
        boolean flag;
        if (zzaqO == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Value is not in float list format");
        return zzari;
    }

    String zzsG()
    {
        return zzarf;
    }

    Bundle zzsH()
    {
        if (zzarg == null)
        {
            return null;
        }
        Bundle bundle = new Bundle(zzarg.size());
        java.util.Map.Entry entry;
        for (Iterator iterator = zzarg.entrySet().iterator(); iterator.hasNext(); bundle.putParcelable((String)entry.getKey(), (Parcelable)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return bundle;
    }

    int[] zzsI()
    {
        return zzarh;
    }

    float[] zzsJ()
    {
        return zzari;
    }

    float zzsy()
    {
        return zzaqS;
    }

}
