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

    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls11 {}


    /* member class not found */
    class zza {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls9 {}


    /* member class not found */
    class _cls10 {}

}
