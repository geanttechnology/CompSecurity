// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.Arrays;

public final class zzw
{

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    public static zza zzv(Object obj)
    {
        return new zza(obj, null);
    }

    private class zza
    {

        private final Object zzJm;
        private final List zzago;

        public final String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(100)).append(zzJm.getClass().getSimpleName()).append('{');
            int j = zzago.size();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append((String)zzago.get(i));
                if (i < j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            return stringbuilder.append('}').toString();
        }

        public final zza zzg(String s, Object obj)
        {
            zzago.add((new StringBuilder()).append((String)zzx.zzw(s)).append("=").append(String.valueOf(obj)).toString());
            return this;
        }

        private zza(Object obj)
        {
            zzJm = zzx.zzw(obj);
            zzago = new ArrayList();
        }

        zza(Object obj, _cls1 _pcls1)
        {
            this(obj);
        }
    }

}
