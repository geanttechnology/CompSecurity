// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            ax, aw

public class av
{

    public static final av a = new av();
    private static final String b = com/paypal/android/sdk/av.getSimpleName();
    private byte c[];

    private av()
    {
        c = null;
        c = null;
    }

    public av(String s)
    {
        c = null;
        int j;
        c = new byte[(s.length() + 1) / 2];
        j = s.length();
        int i;
        i = 0;
        j--;
          goto _L1
_L5:
        int k;
        c[i] = (byte)Integer.parseInt(s.substring(k, j + 1), 16);
        j -= 2;
        i++;
          goto _L1
        s;
        ax.a();
        c = null;
_L3:
        return;
_L1:
        if (j < 0) goto _L3; else goto _L2
_L2:
        int l = j - 1;
        k = l;
        if (l < 0)
        {
            k = 0;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final boolean a(aw aw1)
    {
        int i = aw1.a() / 8;
        if (c != null)
        {
            if (i >= c.length)
            {
                return false;
            }
            i = c[i];
            byte byte0 = (byte)(1 << aw1.a() % 8);
            if ((i & byte0) != byte0)
            {
                return false;
            }
        }
        return true;
    }

}
