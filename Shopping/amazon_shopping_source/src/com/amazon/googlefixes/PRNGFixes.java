// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.googlefixes;

import android.os.Build;
import android.os.Process;
import android.util.Log;
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
import java.security.Provider;
import java.security.SecureRandomSpi;

public final class PRNGFixes
{
    public static class LinuxPRNGSecureRandom extends SecureRandomSpi
    {

        private static final Object S_LOCK = new Object();
        private static final File URANDOM_FILE = new File("/dev/urandom");
        private static DataInputStream sUrandomIn;
        private static OutputStream sUrandomOut;
        private boolean mSeeded;

        private DataInputStream getUrandomInputStream()
        {
            Object obj = S_LOCK;
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
            throws IOException
        {
            OutputStream outputstream;
            synchronized (S_LOCK)
            {
                if (sUrandomOut == null)
                {
                    sUrandomOut = new FileOutputStream(URANDOM_FILE);
                }
                outputstream = sUrandomOut;
            }
            return outputstream;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
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
            synchronized (S_LOCK)
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
            synchronized (S_LOCK)
            {
                outputstream = getUrandomOutputStream();
            }
            outputstream.write(abyte0);
            outputstream.flush();
            mSeeded = true;
            return;
            abyte0;
            obj;
            JVM INSTR monitorexit ;
            try
            {
                throw abyte0;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[]) { }
            finally
            {
                mSeeded = true;
            }
            Log.w(com/amazon/googlefixes/PRNGFixes.getSimpleName(), (new StringBuilder()).append("Failed to mix seed into ").append(URANDOM_FILE).toString());
            mSeeded = true;
            return;
        }


        public LinuxPRNGSecureRandom()
        {
        }
    }

    public static class LinuxPRNGSecureRandomProvider extends Provider
    {

        public LinuxPRNGSecureRandomProvider()
        {
            super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
            put("SecureRandom.SHA1PRNG", com/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandom.getName());
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }


    private static final byte BUILD_FINGERPRINT_AND_DEVICE_SERIAL[] = getBuildFingerprintAndDeviceSerial();

    private PRNGFixes()
    {
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


}
