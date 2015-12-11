// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

// Referenced classes of package cz.msebera.android.httpclient.conn.ssl:
//            AbstractVerifier

public class BrowserCompatHostnameVerifier extends AbstractVerifier
{

    public BrowserCompatHostnameVerifier()
    {
    }

    public final String toString()
    {
        return "BROWSER_COMPATIBLE";
    }

    boolean validCountryWildcard(String s)
    {
        return true;
    }

    public final void verify(String s, String as[], String as1[])
        throws SSLException
    {
        verify(s, as, as1, false);
    }
}
