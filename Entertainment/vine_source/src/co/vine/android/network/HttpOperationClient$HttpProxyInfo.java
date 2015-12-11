// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.network;

import org.apache.http.HttpHost;

// Referenced classes of package co.vine.android.network:
//            HttpOperationClient

private static class enabled
{

    public final boolean enabled;
    public final HttpHost httpHost;

    public (boolean flag, String s, String s1)
    {
        s = s.trim();
        if (s.length() == 0)
        {
            flag = false;
        }
        int i;
        try
        {
            i = Integer.parseInt(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            i = -1;
            flag = false;
        }
        httpHost = new HttpHost(s, i, "http");
        enabled = flag;
    }
}
