// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzsb

public final class zzsa
    implements Cloneable
{

    private static final zzsb zzbin = new zzsb();
    private int mSize;
    private boolean zzbio;
    private int zzbip[];
    private zzsb zzbiq[];

    zzsa()
    {
        this(10);
    }

    zzsa(int i)
    {
        zzbio = false;
        i = idealIntArraySize(i);
        zzbip = new int[i];
        zzbiq = new zzsb[i];
        mSize = 0;
    }

    private void gc()
    {
        int l = mSize;
        int ai[] = zzbip;
        zzsb azzsb[] = zzbiq;
        int i = 0;
        int j;
        int k;
        for (j = 0; i < l; j = k)
        {
            zzsb zzsb1 = azzsb[i];
            k = j;
            if (zzsb1 != zzbin)
            {
                if (i != j)
                {
                    ai[j] = ai[i];
                    azzsb[j] = zzsb1;
                    azzsb[i] = null;
                }
                k = j + 1;
            }
            i++;
        }

        zzbio = false;
        mSize = j;
    }

    private int idealByteArraySize(int i)
    {
        int j = 4;
        do
        {
label0:
            {
                int k = i;
                if (j < 32)
                {
                    if (i > (1 << j) - 12)
                    {
                        break label0;
                    }
                    k = (1 << j) - 12;
                }
                return k;
            }
            j++;
        } while (true);
    }

    private int idealIntArraySize(int i)
    {
        return idealByteArraySize(i << 2) / 4;
    }

    private boolean zza(int ai[], int ai1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (ai[j] != ai1[j])
            {
                return false;
            }
        }

        return true;
    }

    private boolean zza(zzsb azzsb[], zzsb azzsb1[], int i)
    {
        for (int j = 0; j < i; j++)
        {
            if (!azzsb[j].equals(azzsb1[j]))
            {
                return false;
            }
        }

        return true;
    }

    private int zzlT(int i)
    {
        int k;
label0:
        {
            k = mSize;
            int j = 0;
            for (k--; j <= k;)
            {
                int l = j + k >>> 1;
                int i1 = zzbip[l];
                if (i1 < i)
                {
                    j = l + 1;
                } else
                {
                    k = l;
                    if (i1 <= i)
                    {
                        break label0;
                    }
                    k = l - 1;
                }
            }

            k = ~j;
        }
        return k;
    }

    public final Object clone()
    {
        return zzFH();
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof zzsa))
            {
                return false;
            }
            obj = (zzsa)obj;
            if (size() != ((zzsa) (obj)).size())
            {
                return false;
            }
            if (!zza(zzbip, ((zzsa) (obj)).zzbip, mSize) || !zza(zzbiq, ((zzsa) (obj)).zzbiq, mSize))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        if (zzbio)
        {
            gc();
        }
        int j = 17;
        for (int i = 0; i < mSize; i++)
        {
            j = (j * 31 + zzbip[i]) * 31 + zzbiq[i].hashCode();
        }

        return j;
    }

    public final boolean isEmpty()
    {
        return size() == 0;
    }

    final int size()
    {
        if (zzbio)
        {
            gc();
        }
        return mSize;
    }

    public final zzsa zzFH()
    {
        int i = 0;
        int j = size();
        zzsa zzsa1 = new zzsa(j);
        System.arraycopy(zzbip, 0, zzsa1.zzbip, 0, j);
        for (; i < j; i++)
        {
            if (zzbiq[i] != null)
            {
                zzsa1.zzbiq[i] = zzbiq[i].zzFI();
            }
        }

        zzsa1.mSize = j;
        return zzsa1;
    }

    final void zza(int i, zzsb zzsb1)
    {
        int j = zzlT(i);
        if (j >= 0)
        {
            zzbiq[j] = zzsb1;
            return;
        }
        int k = ~j;
        if (k < mSize && zzbiq[k] == zzbin)
        {
            zzbip[k] = i;
            zzbiq[k] = zzsb1;
            return;
        }
        j = k;
        if (zzbio)
        {
            j = k;
            if (mSize >= zzbip.length)
            {
                gc();
                j = ~zzlT(i);
            }
        }
        if (mSize >= zzbip.length)
        {
            int l = idealIntArraySize(mSize + 1);
            int ai[] = new int[l];
            zzsb azzsb[] = new zzsb[l];
            System.arraycopy(zzbip, 0, ai, 0, zzbip.length);
            System.arraycopy(zzbiq, 0, azzsb, 0, zzbiq.length);
            zzbip = ai;
            zzbiq = azzsb;
        }
        if (mSize - j != 0)
        {
            System.arraycopy(zzbip, j, zzbip, j + 1, mSize - j);
            System.arraycopy(zzbiq, j, zzbiq, j + 1, mSize - j);
        }
        zzbip[j] = i;
        zzbiq[j] = zzsb1;
        mSize = mSize + 1;
    }

    final zzsb zzlR(int i)
    {
        i = zzlT(i);
        if (i < 0 || zzbiq[i] == zzbin)
        {
            return null;
        } else
        {
            return zzbiq[i];
        }
    }

    final zzsb zzlS(int i)
    {
        if (zzbio)
        {
            gc();
        }
        return zzbiq[i];
    }

}
