// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import d.k;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class CertificatePinner
{

    public static final CertificatePinner DEFAULT = (new Builder()).build();
    private final Map hostnameToPins;

    private CertificatePinner(Builder builder)
    {
        hostnameToPins = Util.immutableMap(builder.hostnameToPins);
    }

    CertificatePinner(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public static String pin(Certificate certificate)
    {
        if (!(certificate instanceof X509Certificate))
        {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        } else
        {
            return (new StringBuilder("sha1/")).append(sha1((X509Certificate)certificate).b()).toString();
        }
    }

    private static k sha1(X509Certificate x509certificate)
    {
        return Util.sha1(k.a(x509certificate.getPublicKey().getEncoded()));
    }

    public final void check(String s, List list)
    {
        List list1;
        boolean flag;
        flag = false;
        list1 = (List)hostnameToPins.get(s);
        if (list1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1 = list.size();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= i1)
                {
                    break label1;
                }
                if (list1.contains(sha1((X509Certificate)list.get(i))))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        StringBuilder stringbuilder = (new StringBuilder("Certificate pinning failure!")).append("\n  Peer certificate chain:");
        int j1 = list.size();
        for (int j = 0; j < j1; j++)
        {
            X509Certificate x509certificate = (X509Certificate)list.get(j);
            stringbuilder.append("\n    ").append(pin(x509certificate)).append(": ").append(x509certificate.getSubjectDN().getName());
        }

        stringbuilder.append("\n  Pinned certificates for ").append(s).append(":");
        j1 = list1.size();
        for (int l = ((flag) ? 1 : 0); l < j1; l++)
        {
            s = (k)list1.get(l);
            stringbuilder.append("\n    sha1/").append(s.b());
        }

        throw new SSLPeerUnverifiedException(stringbuilder.toString());
    }

    public final transient void check(String s, Certificate acertificate[])
    {
        check(s, Arrays.asList(acertificate));
    }


    private class Builder
    {

        private final Map hostnameToPins = new LinkedHashMap();

        public final transient Builder add(String s, String as[])
        {
            if (s == null)
            {
                throw new IllegalArgumentException("hostname == null");
            }
            ArrayList arraylist = new ArrayList();
            s = (List)hostnameToPins.put(s, Collections.unmodifiableList(arraylist));
            if (s != null)
            {
                arraylist.addAll(s);
            }
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                s = as[i];
                if (!s.startsWith("sha1/"))
                {
                    throw new IllegalArgumentException((new StringBuilder("pins must start with 'sha1/': ")).append(s).toString());
                }
                k k1 = k.b(s.substring(5));
                if (k1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("pins must be base64: ")).append(s).toString());
                }
                arraylist.add(k1);
            }

            return this;
        }

        public final CertificatePinner build()
        {
            return new CertificatePinner(this, null);
        }


        public Builder()
        {
        }
    }

}
