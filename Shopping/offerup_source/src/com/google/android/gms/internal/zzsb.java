// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzrx, zzrz, zzsg, zzse

class zzsb
    implements Cloneable
{

    private zzrz zzbir;
    private Object zzbis;
    private List zzbit;

    zzsb()
    {
        zzbit = new ArrayList();
    }

    private byte[] toByteArray()
    {
        byte abyte0[] = new byte[zzB()];
        zza(zzrx.zzC(abyte0));
        return abyte0;
    }

    public Object clone()
    {
        return zzFI();
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (obj instanceof zzsb)
            {
                obj = (zzsb)obj;
                if (zzbis != null && ((zzsb) (obj)).zzbis != null)
                {
                    flag = flag2;
                    if (zzbir == ((zzsb) (obj)).zzbir)
                    {
                        if (!zzbir.zzbil.isArray())
                        {
                            return zzbis.equals(((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof byte[])
                        {
                            return Arrays.equals((byte[])zzbis, (byte[])((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof int[])
                        {
                            return Arrays.equals((int[])zzbis, (int[])((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof long[])
                        {
                            return Arrays.equals((long[])zzbis, (long[])((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof float[])
                        {
                            return Arrays.equals((float[])zzbis, (float[])((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof double[])
                        {
                            return Arrays.equals((double[])zzbis, (double[])((zzsb) (obj)).zzbis);
                        }
                        if (zzbis instanceof boolean[])
                        {
                            return Arrays.equals((boolean[])zzbis, (boolean[])((zzsb) (obj)).zzbis);
                        } else
                        {
                            return Arrays.deepEquals((Object[])zzbis, (Object[])((zzsb) (obj)).zzbis);
                        }
                    }
                } else
                {
                    if (zzbit != null && ((zzsb) (obj)).zzbit != null)
                    {
                        return zzbit.equals(((zzsb) (obj)).zzbit);
                    }
                    boolean flag1;
                    try
                    {
                        flag1 = Arrays.equals(toByteArray(), ((zzsb) (obj)).toByteArray());
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new IllegalStateException(((Throwable) (obj)));
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    public int hashCode()
    {
        int i;
        try
        {
            i = Arrays.hashCode(toByteArray());
        }
        catch (IOException ioexception)
        {
            throw new IllegalStateException(ioexception);
        }
        return i + 527;
    }

    int zzB()
    {
        if (zzbis == null) goto _L2; else goto _L1
_L1:
        int j = zzbir.zzX(zzbis);
_L4:
        return j;
_L2:
        Iterator iterator = zzbit.iterator();
        int i = 0;
        do
        {
            j = i;
            if (!iterator.hasNext())
            {
                continue;
            }
            i = ((zzsg)iterator.next()).zzB() + i;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final zzsb zzFI()
    {
        Object obj;
        int i;
        i = 0;
        obj = new zzsb();
        obj.zzbir = zzbir;
        if (zzbit != null) goto _L2; else goto _L1
_L1:
        obj.zzbit = null;
_L7:
        if (zzbis == null) goto _L4; else goto _L3
_L3:
        if (!(zzbis instanceof zzse)) goto _L6; else goto _L5
_L5:
        obj.zzbis = ((zzse)zzbis).zzFG();
        return ((zzsb) (obj));
_L2:
        try
        {
            ((zzsb) (obj)).zzbit.addAll(zzbit);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new AssertionError(obj);
        }
          goto _L7
_L6:
        if (!(zzbis instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj.zzbis = ((byte[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof byte[][])) goto _L9; else goto _L8
_L8:
        Object obj1;
        Object obj2;
        obj1 = (byte[][])zzbis;
        obj2 = new byte[obj1.length][];
        obj.zzbis = obj2;
        i = 0;
_L10:
        if (i >= obj1.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2[i] = (byte[])obj1[i].clone();
        i++;
        if (true) goto _L10; else goto _L4
_L9:
        if (!(zzbis instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_205;
        }
        obj.zzbis = ((boolean[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_231;
        }
        obj.zzbis = ((int[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_257;
        }
        obj.zzbis = ((long[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_283;
        }
        obj.zzbis = ((float[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_309;
        }
        obj.zzbis = ((double[])zzbis).clone();
        return ((zzsb) (obj));
        if (!(zzbis instanceof zzse[])) goto _L4; else goto _L11
_L11:
        obj1 = (zzse[])zzbis;
        obj2 = new zzse[obj1.length];
        obj.zzbis = obj2;
_L13:
        if (i >= obj1.length) goto _L4; else goto _L12
_L12:
        obj2[i] = obj1[i].zzFG();
        i++;
          goto _L13
_L4:
        return ((zzsb) (obj));
    }

    void zza(zzrx zzrx1)
    {
        if (zzbis != null)
        {
            zzbir.zza(zzbis, zzrx1);
        } else
        {
            Iterator iterator = zzbit.iterator();
            while (iterator.hasNext()) 
            {
                ((zzsg)iterator.next()).zza(zzrx1);
            }
        }
    }

    void zza(zzsg zzsg1)
    {
        zzbit.add(zzsg1);
    }

    Object zzb(zzrz zzrz1)
    {
        if (zzbis != null)
        {
            if (zzbir != zzrz1)
            {
                throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
            }
        } else
        {
            zzbir = zzrz1;
            zzbis = zzrz1.zzE(zzbit);
            zzbit = null;
        }
        return zzbis;
    }
}
