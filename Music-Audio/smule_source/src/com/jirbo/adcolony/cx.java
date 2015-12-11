// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.jirbo.adcolony:
//            ak, q

class cx
{

    public static String a = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  x          xxxxxxx                          xxxx x                          xxxxx";
    public static String b = "0123456789ABCDEF";
    public static String c = "0123456789abcdef";

    public static String a(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int j = s.length();
        int i = 0;
        while (i < j) 
        {
            char c1 = s.charAt(i);
            if (c1 < '\200' && a.charAt(c1) == ' ')
            {
                stringbuilder.append(c1);
            } else
            {
                stringbuilder.append('%');
                int k = c1 >> 4 & 0xf;
                int l = c1 & 0xf;
                if (k < 10)
                {
                    stringbuilder.append((char)(k + 48));
                } else
                {
                    stringbuilder.append((char)((k + 65) - 10));
                }
                if (l < 10)
                {
                    stringbuilder.append((char)(l + 48));
                } else
                {
                    stringbuilder.append((char)((l + 65) - 10));
                }
            }
            i++;
        }
        return stringbuilder.toString();
    }

    static boolean a()
    {
        boolean flag2 = false;
        boolean flag;
        if (ak.v)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (ak.x != null)
            {
                NetworkInfo networkinfo = ((ConnectivityManager)q.d().getSystemService("connectivity")).getActiveNetworkInfo();
                flag = flag2;
                if (networkinfo != null)
                {
                    boolean flag1;
                    if (networkinfo.getType() == 1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    static boolean b()
    {
        if (!ak.v && ak.x != null)
        {
            NetworkInfo networkinfo = ((ConnectivityManager)q.d().getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkinfo != null)
            {
                int i = networkinfo.getType();
                boolean flag;
                if (i == 0 || i >= 2)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    static boolean c()
    {
        return a() || b();
    }

}
