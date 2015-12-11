// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzru;
import com.google.android.gms.internal.zzsd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzu extends zzc
{

    private final String TAG = "SafeDataBufferRef";

    public zzu(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    protected String zzF(String s, String s1)
    {
        String s2 = s1;
        if (zzce(s))
        {
            s2 = s1;
            if (!zzcg(s))
            {
                s2 = getString(s);
            }
        }
        return s2;
    }

    protected SafeParcelable zza(String s, android.os.Parcelable.Creator creator)
    {
        s = zzc(s, null);
        if (s == null)
        {
            return null;
        } else
        {
            return com.google.android.gms.common.internal.safeparcel.zzc.zza(s, creator);
        }
    }

    protected List zza(String s, android.os.Parcelable.Creator creator, List list)
    {
        s = zzc(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        zzru zzru1;
        return list;
_L2:
        byte abyte0[][];
        int j;
        if ((zzru1 = zzru.zzz(s)).zzbhW == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = new ArrayList(zzru1.zzbhW.length);
        abyte0 = zzru1.zzbhW;
        j = abyte0.length;
        int i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(abyte0[i], creator));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        return s;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected List zza(String s, List list)
    {
        s = zzc(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        return list;
_L2:
        ArrayList arraylist;
        if (((zzru) (s = zzru.zzz(s))).zzbhV == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = new ArrayList(((zzru) (s)).zzbhV.length);
        int i = 0;
_L4:
        if (i >= ((zzru) (s)).zzbhV.length)
        {
            break; /* Loop/switch isn't completed */
        }
        arraylist.add(Integer.valueOf(((zzru) (s)).zzbhV[i]));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        return arraylist;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected float zzb(String s, float f)
    {
        float f1 = f;
        if (zzce(s))
        {
            f1 = f;
            if (!zzcg(s))
            {
                f1 = getFloat(s);
            }
        }
        return f1;
    }

    protected List zzb(String s, List list)
    {
        s = zzc(s, null);
        if (s != null) goto _L2; else goto _L1
_L1:
        return list;
_L2:
        if (((zzru) (s = zzru.zzz(s))).zzbhU == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = Arrays.asList(((zzru) (s)).zzbhU);
        return s;
        s;
        if (Log.isLoggable("SafeDataBufferRef", 6))
        {
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", s);
            return list;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected byte[] zzc(String s, byte abyte0[])
    {
        byte abyte1[] = abyte0;
        if (zzce(s))
        {
            abyte1 = abyte0;
            if (!zzcg(s))
            {
                abyte1 = getByteArray(s);
            }
        }
        return abyte1;
    }

    protected boolean zzh(String s, boolean flag)
    {
        boolean flag1 = flag;
        if (zzce(s))
        {
            flag1 = flag;
            if (!zzcg(s))
            {
                flag1 = getBoolean(s);
            }
        }
        return flag1;
    }

    protected int zzz(String s, int i)
    {
        int j = i;
        if (zzce(s))
        {
            j = i;
            if (!zzcg(s))
            {
                j = getInteger(s);
            }
        }
        return j;
    }
}
