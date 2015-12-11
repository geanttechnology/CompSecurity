// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.util.Base64;

// Referenced classes of package com.google.tagmanager:
//            Base64

class Base64Encoder
{

    public static final int DEFAULT = 0;
    public static final int NO_PADDING = 1;
    public static final int URL_SAFE = 2;

    Base64Encoder()
    {
    }

    public static byte[] decode(String s, int i)
    {
        int j = 1;
        if (getSdkVersion() >= 8)
        {
            j = 2;
            if ((i & 1) != 0)
            {
                j = 2 | 1;
            }
            int k = j;
            if ((i & 2) != 0)
            {
                k = j | 8;
            }
            return Base64.decode(s, k);
        }
        if ((i & 1) != 0);
        if ((i & 2) != 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            return Base64.decodeWebSafe(s);
        } else
        {
            return Base64.decode(s);
        }
    }

    public static String encodeToString(byte abyte0[], int i)
    {
        int j = 1;
        if (getSdkVersion() >= 8)
        {
            j = 2;
            if ((i & 1) != 0)
            {
                j = 2 | 1;
            }
            int k = j;
            if ((i & 2) != 0)
            {
                k = j | 8;
            }
            return Base64.encodeToString(abyte0, k);
        }
        boolean flag;
        if ((i & 1) == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 2) != 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            return Base64.encodeWebSafe(abyte0, flag);
        } else
        {
            return Base64.encode(abyte0, flag);
        }
    }

    static int getSdkVersion()
    {
        return android.os.Build.VERSION.SDK_INT;
    }
}
