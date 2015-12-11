// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.os.Build;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

final class n
{

    private static final byte a[] = g();

    public static void a()
    {
        c();
        d();
    }

    static byte[] b()
    {
        return e();
    }

    private static void c()
    {
        if (android.os.d.VERSION.SDK_INT >= 16 && android.os.d.VERSION.SDK_INT <= 18) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        try
        {
            Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] {
                [B
            }).invoke(null, new Object[] {
                e()
            });
            i = ((Integer)Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[] {
                java/lang/String, Long.TYPE
            }).invoke(null, new Object[] {
                "/dev/urandom", Integer.valueOf(1024)
            })).intValue();
        }
        catch (Exception exception)
        {
            throw new SecurityException("Failed to seed OpenSSL PRNG", exception);
        }
        if (i == 1024) goto _L1; else goto _L3
_L3:
        throw new IOException((new StringBuilder()).append("Unexpected number of bytes read from Linux PRNG: ").append(i).toString());
    }

    private static void d()
    {
        if (android.os.d.VERSION.SDK_INT <= 18)
        {
            Provider aprovider[] = Security.getProviders("SecureRandom.SHA1PRNG");
            class b extends Provider
            {

            public b()
            {
                super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
                put("SecureRandom.SHA1PRNG", com/exacttarget/etpushsdk/util/a$b$a.getName());
                put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
            }
            }

            if (aprovider == null || aprovider.length < 1 || !com/exacttarget/etpushsdk/util/a$b$b.equals(aprovider[0].getClass()))
            {
                Security.insertProviderAt(new b(), 1);
            }
            SecureRandom securerandom = new SecureRandom();
            if (!com/exacttarget/etpushsdk/util/a$b$b.equals(securerandom.getProvider().getClass()))
            {
                throw new SecurityException((new StringBuilder()).append("new SecureRandom() backed by wrong Provider: ").append(securerandom.getProvider().getClass()).toString());
            }
            try
            {
                securerandom = SecureRandom.getInstance("SHA1PRNG");
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                throw new SecurityException("SHA1PRNG not available", nosuchalgorithmexception);
            }
            if (!com/exacttarget/etpushsdk/util/a$b$b.equals(securerandom.getProvider().getClass()))
            {
                throw new SecurityException((new StringBuilder()).append("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: ").append(securerandom.getProvider().getClass()).toString());
            }
        }
    }

    private static byte[] e()
    {
        byte abyte0[];
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            dataoutputstream.writeLong(System.currentTimeMillis());
            dataoutputstream.writeLong(System.nanoTime());
            dataoutputstream.writeInt(Process.myPid());
            dataoutputstream.writeInt(Process.myUid());
            dataoutputstream.write(a);
            dataoutputstream.close();
            abyte0 = bytearrayoutputstream.toByteArray();
        }
        catch (IOException ioexception)
        {
            throw new SecurityException("Failed to generate seed", ioexception);
        }
        return abyte0;
    }

    private static String f()
    {
        String s;
        try
        {
            s = (String)android/os/Build.getField("SERIAL").get(null);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    private static byte[] g()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = Build.FINGERPRINT;
        if (s != null)
        {
            stringbuilder.append(s);
        }
        s = f();
        if (s != null)
        {
            stringbuilder.append(s);
        }
        byte abyte0[];
        try
        {
            abyte0 = stringbuilder.toString().getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
        return abyte0;
    }


    private n()
    {
    }
}
