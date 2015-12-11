// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.util.Args;
import java.security.cert.X509Certificate;
import java.util.Arrays;

public final class PrivateKeyDetails
{

    private final X509Certificate certChain[];
    private final String type;

    public PrivateKeyDetails(String s, X509Certificate ax509certificate[])
    {
        type = (String)Args.notNull(s, "Private key type");
        certChain = ax509certificate;
    }

    public X509Certificate[] getCertChain()
    {
        return certChain;
    }

    public String getType()
    {
        return type;
    }

    public String toString()
    {
        return (new StringBuilder()).append(type).append(':').append(Arrays.toString(certChain)).toString();
    }
}
