// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Formatter;
import java.util.Locale;

class BasicIdGenerator
{

    private long count;
    private final String hostname;
    private final SecureRandom rnd;

    public BasicIdGenerator()
    {
        String s;
        try
        {
            s = InetAddress.getLocalHost().getHostName();
        }
        catch (UnknownHostException unknownhostexception)
        {
            unknownhostexception = "localhost";
        }
        hostname = s;
        try
        {
            rnd = SecureRandom.getInstance("SHA1PRNG");
            return;
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new Error(nosuchalgorithmexception);
        }
    }

    public String generate()
    {
        StringBuilder stringbuilder = new StringBuilder();
        generate(stringbuilder);
        return stringbuilder.toString();
    }

    public void generate(StringBuilder stringbuilder)
    {
        this;
        JVM INSTR monitorenter ;
        count = count + 1L;
        int i = rnd.nextInt();
        stringbuilder.append(System.currentTimeMillis());
        stringbuilder.append('.');
        Formatter formatter = new Formatter(stringbuilder, Locale.US);
        formatter.format("%1$016x-%2$08x", new Object[] {
            Long.valueOf(count), Integer.valueOf(i)
        });
        formatter.close();
        stringbuilder.append('.');
        stringbuilder.append(hostname);
        this;
        JVM INSTR monitorexit ;
        return;
        stringbuilder;
        throw stringbuilder;
    }
}
