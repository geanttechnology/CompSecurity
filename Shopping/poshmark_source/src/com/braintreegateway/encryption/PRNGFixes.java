// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreegateway.encryption;

import android.os.Build;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;

public final class PRNGFixes
{
    public static class LinuxPRNGSecureRandom extends SecureRandomSpi
    {

        private static final File URANDOM_FILE = new File("/dev/urandom");
        private static final Object sLock = new Object();
        private static DataInputStream sUrandomIn;
        private static OutputStream sUrandomOut;
        private boolean mSeeded;

        private DataInputStream getUrandomInputStream()
        {
            Object obj = sLock;
            obj;
            JVM INSTR monitorenter ;
            DataInputStream datainputstream = sUrandomIn;
            if (datainputstream != null)
            {
                break MISSING_BLOCK_LABEL_34;
            }
            sUrandomIn = new DataInputStream(new FileInputStream(URANDOM_FILE));
            datainputstream = sUrandomIn;
            obj;
            JVM INSTR monitorexit ;
            return datainputstream;
            Object obj1;
            obj1;
            throw new SecurityException((new StringBuilder()).append("Failed to open ").append(URANDOM_FILE).append(" for reading").toString(), ((Throwable) (obj1)));
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        private OutputStream getUrandomOutputStream()
        {
            Object obj = sLock;
            obj;
            JVM INSTR monitorenter ;
            OutputStream outputstream = sUrandomOut;
            if (outputstream != null)
            {
                break MISSING_BLOCK_LABEL_27;
            }
            sUrandomOut = new FileOutputStream(URANDOM_FILE);
            outputstream = sUrandomOut;
            obj;
            JVM INSTR monitorexit ;
            return outputstream;
            Object obj1;
            obj1;
            throw new SecurityException((new StringBuilder()).append("Failed to open ").append(URANDOM_FILE).append(" for writing").toString(), ((Throwable) (obj1)));
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
        }

        protected byte[] engineGenerateSeed(int i)
        {
            byte abyte0[] = new byte[i];
            engineNextBytes(abyte0);
            return abyte0;
        }

        protected void engineNextBytes(byte abyte0[])
        {
            if (!mSeeded)
            {
                engineSetSeed(PRNGFixes.generateSeed());
            }
            DataInputStream datainputstream;
            synchronized (sLock)
            {
                datainputstream = getUrandomInputStream();
            }
            datainputstream;
            JVM INSTR monitorenter ;
            datainputstream.readFully(abyte0);
            datainputstream;
            JVM INSTR monitorexit ;
            return;
            abyte0;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw abyte0;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new SecurityException((new StringBuilder()).append("Failed to read from ").append(URANDOM_FILE).toString(), abyte0);
            }
            abyte0;
            datainputstream;
            JVM INSTR monitorexit ;
            throw abyte0;
        }

        protected void engineSetSeed(byte abyte0[])
        {
            OutputStream outputstream;
            synchronized (sLock)
            {
                outputstream = getUrandomOutputStream();
            }
            try
            {
                outputstream.write(abyte0);
                outputstream.flush();
                mSeeded = true;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                throw new SecurityException((new StringBuilder()).append("Failed to mix seed into ").append(URANDOM_FILE).toString(), abyte0);
            }
            abyte0;
            obj;
            JVM INSTR monitorexit ;
            throw abyte0;
        }


        public LinuxPRNGSecureRandom()
        {
        }
    }

    private static class LinuxPRNGSecureRandomProvider extends Provider
    {

        public LinuxPRNGSecureRandomProvider()
        {
            super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", com/braintreegateway/encryption/PRNGFixes$LinuxPRNGSecureRandom.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }


    private static final byte BUILD_FINGERPRINT_AND_DEVICE_SERIAL[] = getBuildFingerprintAndDeviceSerial();
    private static final int VERSION_CODE_JELLY_BEAN = 16;
    private static final int VERSION_CODE_JELLY_BEAN_MR2 = 18;

    private PRNGFixes()
    {
    }

    public static void apply()
    {
        applyOpenSSLFix();
        installLinuxPRNGSecureRandom();
    }

    private static void applyOpenSSLFix()
        throws SecurityException
    {
        if (android.os.Build.VERSION.SDK_INT >= 16 && android.os.Build.VERSION.SDK_INT <= 18) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        try
        {
            Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[] {
                [B
            }).invoke(null, new Object[] {
                generateSeed()
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

    private static byte[] generateSeed()
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
            dataoutputstream.write(BUILD_FINGERPRINT_AND_DEVICE_SERIAL);
            dataoutputstream.close();
            abyte0 = bytearrayoutputstream.toByteArray();
        }
        catch (IOException ioexception)
        {
            throw new SecurityException("Failed to generate seed", ioexception);
        }
        return abyte0;
    }

    private static byte[] getBuildFingerprintAndDeviceSerial()
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = Build.FINGERPRINT;
        if (s != null)
        {
            stringbuilder.append(s);
        }
        s = getDeviceSerialNumber();
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

    private static String getDeviceSerialNumber()
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

    private static void installLinuxPRNGSecureRandom()
        throws SecurityException
    {
        if (android.os.Build.VERSION.SDK_INT <= 18)
        {
            Provider aprovider[] = Security.getProviders("SecureRandom.SHA1PRNG");
            if (aprovider == null || aprovider.length < 1 || !com/braintreegateway/encryption/PRNGFixes$LinuxPRNGSecureRandomProvider.equals(aprovider[0].getClass()))
            {
                Security.insertProviderAt(new LinuxPRNGSecureRandomProvider(), 1);
            }
            SecureRandom securerandom = new SecureRandom();
            if (!com/braintreegateway/encryption/PRNGFixes$LinuxPRNGSecureRandomProvider.equals(securerandom.getProvider().getClass()))
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
            if (!com/braintreegateway/encryption/PRNGFixes$LinuxPRNGSecureRandomProvider.equals(securerandom.getProvider().getClass()))
            {
                throw new SecurityException((new StringBuilder()).append("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: ").append(securerandom.getProvider().getClass()).toString());
            }
        }
    }


}
