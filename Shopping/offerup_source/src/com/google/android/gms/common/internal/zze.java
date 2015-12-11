// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import java.util.Arrays;

// Referenced classes of package com.google.android.gms.common.internal:
//            zzx

public abstract class zze
{

    public static final zze zzaeL = zza("\t\n\013\f\r \205\u1680\u2028\u2029\u205F\u3000\240\u180E\u202F").zza(zza('\u2000', '\u200A'));
    public static final zze zzaeM = zza("\t\n\013\f\r \205\u1680\u2028\u2029\u205F\u3000").zza(zza('\u2000', '\u2006')).zza(zza('\u2008', '\u200A'));
    public static final zze zzaeN = zza('\0', '\177');
    public static final zze zzaeO;
    public static final zze zzaeP = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzc('\u1680')).zza(zzc('\u180E')).zza(zza('\u2000', '\u2006')).zza(zza('\u2008', '\u200B')).zza(zza('\u2028', '\u2029')).zza(zzc('\u205F')).zza(zzc('\u3000'));
    public static final zze zzaeQ = new _cls1();
    public static final zze zzaeR = new _cls5();
    public static final zze zzaeS = new _cls6();
    public static final zze zzaeT = new _cls7();
    public static final zze zzaeU = new _cls8();
    public static final zze zzaeV = zza('\0', '\037').zza(zza('\177', '\237'));
    public static final zze zzaeW = zza('\0', ' ').zza(zza('\177', '\240')).zza(zzc('\255')).zza(zza('\u0600', '\u0603')).zza(zza("\u06DD\u070F\u1680\u17B4\u17B5\u180E")).zza(zza('\u2000', '\u200F')).zza(zza('\u2028', '\u202F')).zza(zza('\u205F', '\u2064')).zza(zza('\u206A', '\u206F')).zza(zzc('\u3000')).zza(zza('\uD800', '\uF8FF')).zza(zza("\uFEFF\uFFF9\uFFFA\uFFFB"));
    public static final zze zzaeX = zza('\0', '\u04F9').zza(zzc('\u05BE')).zza(zza('\u05D0', '\u05EA')).zza(zzc('\u05F3')).zza(zzc('\u05F4')).zza(zza('\u0600', '\u06FF')).zza(zza('\u0750', '\u077F')).zza(zza('\u0E00', '\u0E7F')).zza(zza('\u1E00', '\u20AF')).zza(zza('\u2100', '\u213A')).zza(zza('\uFB50', '\uFDFF')).zza(zza('\uFE70', '\uFEFF')).zza(zza('\uFF61', '\uFFDC'));
    public static final zze zzaeY = new _cls9();
    public static final zze zzaeZ = new _cls10();

    public zze()
    {
    }

    public static zze zza(char c, char c1)
    {
        boolean flag;
        if (c1 >= c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        return new _cls4(c, c1);
    }

    public static zze zza(CharSequence charsequence)
    {
        switch (charsequence.length())
        {
        default:
            charsequence = charsequence.toString().toCharArray();
            Arrays.sort(charsequence);
            return new _cls3(charsequence);

        case 0: // '\0'
            return zzaeZ;

        case 1: // '\001'
            return zzc(charsequence.charAt(0));

        case 2: // '\002'
            return new _cls2(charsequence.charAt(0), charsequence.charAt(1));
        }
    }

    public static zze zzc(char c)
    {
        return new _cls11(c);
    }

    public zze zza(zze zze1)
    {
        return new zza(Arrays.asList(new zze[] {
            this, (zze)zzx.zzw(zze1)
        }));
    }

    public boolean zzb(CharSequence charsequence)
    {
        for (int i = charsequence.length() - 1; i >= 0; i--)
        {
            if (!zzd(charsequence.charAt(i)))
            {
                return false;
            }
        }

        return true;
    }

    public abstract boolean zzd(char c);

    static 
    {
        zze zze1 = zza('0', '9');
        char ac[] = "\u0660\u06F0\u07C0\u0966\u09E6\u0A66\u0AE6\u0B66\u0BE6\u0C66\u0CE6\u0D66\u0E50\u0ED0\u0F20\u1040\u1090\u17E0\u1810\u1946\u19D0\u1B50\u1BB0\u1C40\u1C50\uA620\uA8D0\uA900\uAA50\uFF10".toCharArray();
        int j = ac.length;
        for (int i = 0; i < j; i++)
        {
            char c = ac[i];
            zze1 = zze1.zza(zza(c, (char)(c + 9)));
        }

        zzaeO = zze1;
    }

    private class _cls4 extends zze
    {

        final char zzafd;
        final char zzafe;

        public final boolean zzd(char c)
        {
            return zzafd <= c && c <= zzafe;
        }

        _cls4(char c, char c1)
        {
            zzafd = c;
            zzafe = c1;
            super();
        }
    }


    private class _cls3 extends zze
    {

        final char zzafc[];

        public final boolean zzd(char c)
        {
            return Arrays.binarySearch(zzafc, c) >= 0;
        }

        _cls3(char ac[])
        {
            zzafc = ac;
            super();
        }
    }


    private class _cls2 extends zze
    {

        final char zzafa;
        final char zzafb;

        public final boolean zzd(char c)
        {
            return c == zzafa || c == zzafb;
        }

        _cls2(char c, char c1)
        {
            zzafa = c;
            zzafb = c1;
            super();
        }
    }


    private class _cls11 extends zze
    {

        final char zzaff;

        public final zze zza(zze zze1)
        {
            if (zze1.zzd(zzaff))
            {
                return zze1;
            } else
            {
                return zza(zze1);
            }
        }

        public final boolean zzd(char c)
        {
            return c == zzaff;
        }

        _cls11(char c)
        {
            zzaff = c;
            super();
        }
    }


    private class zza extends zze
    {

        List zzafg;

        public zze zza(zze zze1)
        {
            ArrayList arraylist = new ArrayList(zzafg);
            arraylist.add(zzx.zzw(zze1));
            return new zza(arraylist);
        }

        public boolean zzd(char c)
        {
            for (Iterator iterator = zzafg.iterator(); iterator.hasNext();)
            {
                if (((zze)iterator.next()).zzd(c))
                {
                    return true;
                }
            }

            return false;
        }

        zza(List list)
        {
            zzafg = list;
        }
    }


    private class _cls1 extends zze
    {

        public final boolean zzd(char c)
        {
            return Character.isDigit(c);
        }

        _cls1()
        {
        }
    }


    private class _cls5 extends zze
    {

        public final boolean zzd(char c)
        {
            return Character.isLetter(c);
        }

        _cls5()
        {
        }
    }


    private class _cls6 extends zze
    {

        public final boolean zzd(char c)
        {
            return Character.isLetterOrDigit(c);
        }

        _cls6()
        {
        }
    }


    private class _cls7 extends zze
    {

        public final boolean zzd(char c)
        {
            return Character.isUpperCase(c);
        }

        _cls7()
        {
        }
    }


    private class _cls8 extends zze
    {

        public final boolean zzd(char c)
        {
            return Character.isLowerCase(c);
        }

        _cls8()
        {
        }
    }


    private class _cls9 extends zze
    {

        public final zze zza(zze zze1)
        {
            zzx.zzw(zze1);
            return this;
        }

        public final boolean zzb(CharSequence charsequence)
        {
            zzx.zzw(charsequence);
            return true;
        }

        public final boolean zzd(char c)
        {
            return true;
        }

        _cls9()
        {
        }
    }


    private class _cls10 extends zze
    {

        public final zze zza(zze zze1)
        {
            return (zze)zzx.zzw(zze1);
        }

        public final boolean zzb(CharSequence charsequence)
        {
            return charsequence.length() == 0;
        }

        public final boolean zzd(char c)
        {
            return false;
        }

        _cls10()
        {
        }
    }

}
