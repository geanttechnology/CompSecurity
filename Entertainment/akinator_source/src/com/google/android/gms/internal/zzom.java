// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzmw

public class zzom
{

    private static final ThreadLocal zzark = new ThreadLocal();

    public static String zzB(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return s;
        } else
        {
            byte abyte0[] = new byte[s.length() + s1.length()];
            System.arraycopy(s.getBytes(), 0, abyte0, 0, s.length());
            System.arraycopy(s1.getBytes(), 0, abyte0, s.length(), s1.length());
            return Integer.toHexString(zzmw.zza(abyte0, 0, abyte0.length, 0));
        }
    }

    public static String zzcU(String s)
    {
        if (zzsK())
        {
            return s;
        } else
        {
            return zzB(s, (String)zzark.get());
        }
    }

    public static boolean zzsK()
    {
        String s = (String)zzark.get();
        return s == null || s.startsWith("com.google");
    }

}
