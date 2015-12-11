// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzry, zzsa, zzrx, zzrw, 
//            zzse

public final class zzFT extends zzry
{

    public String version;
    public int zzbiJ;
    public String zzbiK;

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzFT))
            {
                return false;
            }
            obj = (zzFT)obj;
            if (zzbiJ != ((zzbiJ) (obj)).zzbiJ)
            {
                return false;
            }
            if (zzbiK == null)
            {
                if (((zzbiK) (obj)).zzbiK != null)
                {
                    return false;
                }
            } else
            if (!zzbiK.equals(((zzbiK) (obj)).zzbiK))
            {
                return false;
            }
            if (version == null)
            {
                if (((version) (obj)).version != null)
                {
                    return false;
                }
            } else
            if (!version.equals(((version) (obj)).version))
            {
                return false;
            }
            if (zzbik == null || zzbik.isEmpty())
            {
                if (((pty) (obj)).zzbik != null && !((zzbik) (obj)).zzbik.isEmpty())
                {
                    return false;
                }
            } else
            {
                return zzbik.equals(((ls) (obj)).zzbik);
            }
        }
        return true;
    }

    public final int hashCode()
    {
        boolean flag = false;
        int l = getClass().getName().hashCode();
        int i1 = zzbiJ;
        int i;
        int j;
        int k;
        if (zzbiK == null)
        {
            i = 0;
        } else
        {
            i = zzbiK.hashCode();
        }
        if (version == null)
        {
            j = 0;
        } else
        {
            j = version.hashCode();
        }
        k = ((flag) ? 1 : 0);
        if (zzbik != null)
        {
            if (zzbik.isEmpty())
            {
                k = ((flag) ? 1 : 0);
            } else
            {
                k = zzbik.hashCode();
            }
        }
        return (j + (i + ((l + 527) * 31 + i1) * 31) * 31) * 31 + k;
    }

    protected final int zzB()
    {
        int j = super.zzB();
        int i = j;
        if (zzbiJ != 0)
        {
            i = j + zzrx.zzA(1, zzbiJ);
        }
        j = i;
        if (!zzbiK.equals(""))
        {
            j = i + zzrx.zzn(2, zzbiK);
        }
        i = j;
        if (!version.equals(""))
        {
            i = j + zzrx.zzn(3, version);
        }
        return i;
    }

    public final version zzFT()
    {
        zzbiJ = 0;
        zzbiK = "";
        version = "";
        zzbik = null;
        zzbiv = -1;
        return this;
    }

    public final zzbiv zzH(zzrw zzrw1)
    {
_L6:
        int i = zzrw1.zzFo();
        i;
        JVM INSTR lookupswitch 4: default 48
    //                   0: 57
    //                   8: 59
    //                   18: 199
    //                   26: 210;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (zza(zzrw1, i)) goto _L6; else goto _L2
_L2:
        return this;
_L3:
        int j = zzrw1.zzFr();
        switch (j)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
            zzbiJ = j;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        zzbiK = zzrw1.readString();
        continue; /* Loop/switch isn't completed */
_L5:
        version = zzrw1.readString();
        if (true) goto _L6; else goto _L7
_L7:
    }

    public final void zza(zzrx zzrx1)
    {
        if (zzbiJ != 0)
        {
            zzrx1.zzy(1, zzbiJ);
        }
        if (!zzbiK.equals(""))
        {
            zzrx1.zzb(2, zzbiK);
        }
        if (!version.equals(""))
        {
            zzrx1.zzb(3, version);
        }
        super.zza(zzrx1);
    }

    public final zzse zzb(zzrw zzrw1)
    {
        return zzH(zzrw1);
    }

    public ()
    {
        zzFT();
    }
}
