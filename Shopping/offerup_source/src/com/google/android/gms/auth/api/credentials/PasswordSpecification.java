// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.google.android.gms.auth.api.credentials:
//            zze

public final class PasswordSpecification
    implements SafeParcelable
{

    public static final zze CREATOR = new zze();
    public static final PasswordSpecification zzSt = (new zza()).zzg(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzf("abcdefghijkmnopqrstxyz", 1).zzf("ABCDEFGHJKLMNPQRSTXY", 1).zzf("3456789", 1).zzlK();
    public static final PasswordSpecification zzSu = (new zza()).zzg(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzf("abcdefghijklmnopqrstuvwxyz", 1).zzf("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzf("1234567890", 1).zzlK();
    final int mVersionCode;
    private final int zzSA[] = zzlJ();
    final String zzSv;
    final List zzSw;
    final List zzSx;
    final int zzSy;
    final int zzSz;
    private final Random zzts = new SecureRandom();

    PasswordSpecification(int i, String s, List list, List list1, int j, int k)
    {
        mVersionCode = i;
        zzSv = s;
        zzSw = Collections.unmodifiableList(list);
        zzSx = Collections.unmodifiableList(list1);
        zzSy = j;
        zzSz = k;
    }

    private int zza(char c)
    {
        return c - 32;
    }

    private static String zzb(Collection collection)
    {
        char ac[] = new char[collection.size()];
        collection = collection.iterator();
        for (int i = 0; collection.hasNext(); i++)
        {
            ac[i] = ((Character)collection.next()).charValue();
        }

        return new String(ac);
    }

    private static boolean zzb(int i, int j, int k)
    {
        return i < j || i > k;
    }

    static String zzc(Collection collection)
    {
        return zzb(collection);
    }

    static boolean zzc(int i, int j, int k)
    {
        return zzb(i, j, k);
    }

    private int[] zzlJ()
    {
        int ai[] = new int[95];
        Arrays.fill(ai, -1);
        Iterator iterator = zzSw.iterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            char ac[] = ((String)iterator.next()).toCharArray();
            int k = ac.length;
            for (int j = 0; j < k; j++)
            {
                ai[zza(ac[j])] = i;
            }

        }

        return ai;
    }

    public final int describeContents()
    {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i);
    }


    private class zza
    {

        private final TreeSet zzSB = new TreeSet();
        private final List zzSw = new ArrayList();
        private final List zzSx = new ArrayList();
        private int zzSy;
        private int zzSz;

        private void zzlL()
        {
            Iterator iterator = zzSx.iterator();
            int i;
            for (i = 0; iterator.hasNext(); i = ((Integer)iterator.next()).intValue() + i) { }
            if (i > zzSz)
            {
                throw new zzb("required character count cannot be greater than the max password size");
            } else
            {
                return;
            }
        }

        private void zzlM()
        {
            boolean aflag[] = new boolean[95];
            for (Iterator iterator = zzSw.iterator(); iterator.hasNext();)
            {
                char ac[] = ((String)iterator.next()).toCharArray();
                int j = ac.length;
                int i = 0;
                while (i < j) 
                {
                    char c = ac[i];
                    if (aflag[c - 32])
                    {
                        throw new zzb((new StringBuilder("character ")).append(c).append(" occurs in more than one required character set").toString());
                    }
                    aflag[c - 32] = true;
                    i++;
                }
            }

        }

        private TreeSet zzr(String s, String s1)
        {
            if (TextUtils.isEmpty(s))
            {
                throw new zzb((new StringBuilder()).append(s1).append(" cannot be null or empty").toString());
            }
            TreeSet treeset = new TreeSet();
            s = s.toCharArray();
            int j = s.length;
            for (int i = 0; i < j; i++)
            {
                char c = s[i];
                if (PasswordSpecification.zzc(c, 32, 126))
                {
                    throw new zzb((new StringBuilder()).append(s1).append(" must only contain ASCII printable characters").toString());
                }
                treeset.add(Character.valueOf(c));
            }

            return treeset;
        }

        public zza zzbD(String s)
        {
            zzSB.addAll(zzr(s, "allowedChars"));
            return this;
        }

        public zza zzf(String s, int i)
        {
            if (i <= 0)
            {
                throw new zzb("count must be at least 1");
            } else
            {
                s = zzr(s, "requiredChars");
                zzSw.add(PasswordSpecification.zzc(s));
                zzSx.add(Integer.valueOf(i));
                return this;
            }
        }

        public zza zzg(int i, int j)
        {
            if (i <= 0)
            {
                throw new zzb("minimumSize must be at least 1");
            }
            if (i > j)
            {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            } else
            {
                zzSy = i;
                zzSz = j;
                return this;
            }
        }

        public PasswordSpecification zzlK()
        {
            if (zzSB.isEmpty())
            {
                throw new zzb("no allowed characters specified");
            } else
            {
                zzlL();
                zzlM();
                return new PasswordSpecification(1, PasswordSpecification.zzc(zzSB), zzSw, zzSx, zzSy, zzSz);
            }
        }

        public zza()
        {
            zzSy = 12;
            zzSz = 16;
        }

        private class zzb extends Error
        {

            public zzb(String s)
            {
                super(s);
            }
        }

    }

}
