// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public class zzig
{

    private final String zzIO[];
    private final double zzIP[];
    private final double zzIQ[];
    private final int zzIR[];
    private int zzIS;

    private zzig(zzb zzb1)
    {
        int i = zzb.zza(zzb1).size();
        zzIO = (String[])zzb.zzb(zzb1).toArray(new String[i]);
        zzIP = zzg(zzb.zza(zzb1));
        zzIQ = zzg(zzb.zzc(zzb1));
        zzIR = new int[i];
        zzIS = 0;
    }


    private double[] zzg(List list)
    {
        double ad[] = new double[list.size()];
        for (int i = 0; i < ad.length; i++)
        {
            ad[i] = ((Double)list.get(i)).doubleValue();
        }

        return ad;
    }

    public List getBuckets()
    {
        ArrayList arraylist = new ArrayList(zzIO.length);
        for (int i = 0; i < zzIO.length; i++)
        {
            arraylist.add(new zza(zzIO[i], zzIQ[i], zzIP[i], (double)zzIR[i] / (double)zzIS, zzIR[i]));
        }

        return arraylist;
    }

    public void zza(double d)
    {
        zzIS = zzIS + 1;
        int i = 0;
        do
        {
            if (i >= zzIQ.length)
            {
                break;
            }
            if (zzIQ[i] <= d && d < zzIP[i])
            {
                int ai[] = zzIR;
                ai[i] = ai[i] + 1;
            }
            if (d < zzIQ[i])
            {
                break;
            }
            i++;
        } while (true);
    }

    private class zzb
    {

        private final List zzIW = new ArrayList();
        private final List zzIX = new ArrayList();
        private final List zzIY = new ArrayList();

        static List zza(zzb zzb1)
        {
            return zzb1.zzIX;
        }

        static List zzb(zzb zzb1)
        {
            return zzb1.zzIW;
        }

        static List zzc(zzb zzb1)
        {
            return zzb1.zzIY;
        }

        public zzb zza(String s, double d, double d1)
        {
            int i = 0;
            do
            {
                if (i >= zzIW.size())
                {
                    break;
                }
                double d2 = ((Double)zzIY.get(i)).doubleValue();
                double d3 = ((Double)zzIX.get(i)).doubleValue();
                if (d < d2 || d2 == d && d1 < d3)
                {
                    break;
                }
                i++;
            } while (true);
            zzIW.add(i, s);
            zzIY.add(i, Double.valueOf(d));
            zzIX.add(i, Double.valueOf(d1));
            return this;
        }

        public zzig zzgK()
        {
            return new zzig(this);
        }

        public zzb()
        {
        }
    }


    private class zza
    {

        public final int count;
        public final String name;
        public final double zzIT;
        public final double zzIU;
        public final double zzIV;

        public boolean equals(Object obj)
        {
            if (obj instanceof zza)
            {
                if (zzw.equal(name, ((zza) (obj = (zza)obj)).name) && zzIT == ((zza) (obj)).zzIT && zzIU == ((zza) (obj)).zzIU && count == ((zza) (obj)).count && Double.compare(zzIV, ((zza) (obj)).zzIV) == 0)
                {
                    return true;
                }
            }
            return false;
        }

        public int hashCode()
        {
            return zzw.hashCode(new Object[] {
                name, Double.valueOf(zzIT), Double.valueOf(zzIU), Double.valueOf(zzIV), Integer.valueOf(count)
            });
        }

        public String toString()
        {
            return zzw.zzv(this).zzg("name", name).zzg("minBound", Double.valueOf(zzIU)).zzg("maxBound", Double.valueOf(zzIT)).zzg("percent", Double.valueOf(zzIV)).zzg("count", Integer.valueOf(count)).toString();
        }

        public zza(String s, double d, double d1, double d2, 
                int i)
        {
            name = s;
            zzIU = d;
            zzIT = d1;
            zzIV = d2;
            count = i;
        }
    }

}
