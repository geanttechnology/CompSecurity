// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.Arrays;

public final class zzt
{

    public static boolean equal(Object obj, Object obj1)
    {
        return obj == obj1 || obj != null && obj.equals(obj1);
    }

    public static transient int hashCode(Object aobj[])
    {
        return Arrays.hashCode(aobj);
    }

    public static zza zzt(Object obj)
    {
        return new zza(obj, null);
    }

    private class zza
    {

        private final Object zzGE;
        private final List zzabb;

        public String toString()
        {
            StringBuilder stringbuilder = (new StringBuilder(100)).append(zzGE.getClass().getSimpleName()).append('{');
            int j = zzabb.size();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append((String)zzabb.get(i));
                if (i < j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

            return stringbuilder.append('}').toString();
        }

        public zza zzg(String s, Object obj)
        {
            zzabb.add((new StringBuilder()).append((String)zzu.zzu(s)).append("=").append(String.valueOf(obj)).toString());
            return this;
        }

        private zza(Object obj)
        {
            zzGE = zzu.zzu(obj);
            zzabb = new ArrayList();
        }

        zza(Object obj, _cls1 _pcls1)
        {
            this(obj);
        }
    }

}
