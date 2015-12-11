// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake
{

    private final String cipherSuite;
    private final List localCertificates;
    private final List peerCertificates;

    private Handshake(String s, List list, List list1)
    {
        cipherSuite = s;
        peerCertificates = list;
        localCertificates = list1;
    }

    public static Handshake get(SSLSession sslsession)
    {
        String s = sslsession.getCipherSuite();
        if (s == null)
        {
            throw new IllegalStateException("cipherSuite == null");
        }
        List list;
        try
        {
            list = sslsession.getPeerCertificates();
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            list = null;
        }
        if (list != null)
        {
            list = Util.immutableList(list);
        } else
        {
            list = Collections.emptyList();
        }
        sslsession = sslsession.getLocalCertificates();
        if (sslsession != null)
        {
            sslsession = Util.immutableList(sslsession);
        } else
        {
            sslsession = Collections.emptyList();
        }
        return new Handshake(s, list, sslsession);
    }

    public String cipherSuite()
    {
        return cipherSuite;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Handshake)
        {
            if (cipherSuite.equals(((Handshake) (obj = (Handshake)obj)).cipherSuite) && peerCertificates.equals(((Handshake) (obj)).peerCertificates) && localCertificates.equals(((Handshake) (obj)).localCertificates))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return ((cipherSuite.hashCode() + 527) * 31 + peerCertificates.hashCode()) * 31 + localCertificates.hashCode();
    }

    public List peerCertificates()
    {
        return peerCertificates;
    }
}
