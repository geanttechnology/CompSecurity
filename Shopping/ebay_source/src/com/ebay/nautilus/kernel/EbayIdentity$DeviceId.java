// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.Context;
import android.util.Base64;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import junit.framework.Assert;

// Referenced classes of package com.ebay.nautilus.kernel:
//            EbayIdentity

private static final class n
{

    public static final byte VERSION = 1;

    private static void append(long l, int i, byte abyte0[], int j)
    {
        int k = i - 1;
        i = j;
        j = k;
        while (j >= 0) 
        {
            byte byte0 = (byte)(int)(l >> j * 4 & 15L);
            int i1 = i / 2;
            if (i % 2 == 0)
            {
                abyte0[i1] = (byte)(byte0 << 4);
            } else
            {
                abyte0[i1] = (byte)(abyte0[i1] | byte0);
            }
            j--;
            i++;
        }
    }

    static byte[] decrypt(byte abyte0[])
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        byte abyte3[] = encryptDecrypt(false, abyte0);
        if (abyte3.length != 48)
        {
            abyte0 = null;
        } else
        {
            abyte0 = new byte[16];
            System.arraycopy(abyte3, 0, abyte0, 0, abyte0.length);
            byte abyte1[] = getHmac(abyte0);
            Assert.assertEquals(abyte1.length, 20);
            byte abyte2[] = new byte[20];
            System.arraycopy(abyte3, abyte3.length - abyte2.length, abyte2, 0, abyte2.length);
            if (!Arrays.equals(abyte1, abyte2))
            {
                return null;
            }
        }
        return abyte0;
    }

    private static byte[] encrypt(byte abyte0[])
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        if (abyte0.length != 16)
        {
            throw new IllegalArgumentException("id");
        } else
        {
            byte abyte1[] = getHmac(abyte0);
            Assert.assertEquals(abyte1.length, 20);
            byte abyte2[] = new byte[48];
            System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, abyte2.length - abyte1.length, abyte1.length);
            return encryptDecrypt(true, abyte2);
        }
    }

    private static byte[] encryptDecrypt(boolean flag, byte abyte0[])
        throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
    {
        SecretKeySpec secretkeyspec = new SecretKeySpec(new byte[] {
            64, -87, 45, 37, -102, 68, -66, -79, -38, -18, 
            68, -114, 31, -25, 90, 16, 122, -74, 88, 32, 
            42, 112, 54, -23, 17, -79, 2, -117, 26, -19, 
            -39, 80
        }, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        cipher.init(i, secretkeyspec, new IvParameterSpec(new byte[16]));
        return cipher.doFinal(abyte0, 0, abyte0.length);
    }

    public static void generate(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorenter ;
        byte abyte0[];
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, "DeviceId.generate()");
        }
        abyte0 = EbayIdentity.access$000();
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorexit ;
        return;
_L2:
        save(context, generateEbayGuid());
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public static byte[] generateEbayGuid()
    {
        SecureRandom securerandom = new SecureRandom();
        long l = System.currentTimeMillis();
        byte abyte1[] = new byte[9];
        securerandom.nextBytes(abyte1);
        long l1 = toLong(abyte1, 0, 6);
        long l2 = toLong(abyte1, 6, 3);
        byte abyte0[] = new byte[16];
        append(l & 0xffffffffL, 8, abyte0, 0);
        append(l >> 32 & 4095L, 3, abyte0, 8);
        append(l1, 12, abyte0, 11);
        append(0L, 1, abyte0, 23);
        append(1L, 2, abyte0, 24);
        append(l2, 6, abyte0, 26);
        return abyte0;
    }

    public static String getEncryptedIdForBroadcast(Context context)
    {
        if (EbayIdentity.access$000() == null)
        {
            load(context);
        }
        if (EbayIdentity.access$000() == null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        context = Base64.encodeToString(encrypt(EbayIdentity.access$000()), 2);
        return context;
        context;
        EbayIdentity.access$100().or("Couldn't share the ID!", context);
        return null;
    }

    private static File getFile(Context context)
    {
        return new File(context.getFilesDir(), "installId");
    }

    private static byte[] getHmac(byte abyte0[])
    {
        try
        {
            Mac mac = Mac.getInstance("HmacSHA1");
            String s = mac.getAlgorithm();
            mac.init(new SecretKeySpec(new byte[] {
                -121, 87, -57, -124, 40, 126, 27, 48, 98, 63, 
                18, -80, -126, -43, -104, -101, 31, 119, -10, -19, 
                109, 31, 108, -3, -63, 67, 37, 117, 77, -81, 
                -105, -14
            }, s));
            abyte0 = mac.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Couldn't create HMAC!", abyte0);
        }
        return abyte0;
    }

    public static void load(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorenter ;
        StringBuilder stringbuilder;
        if (!EbayIdentity.access$100().le)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        stringbuilder = (new StringBuilder()).append("DeviceId.load() - device id ");
        Object obj;
        if (EbayIdentity.access$000() == null)
        {
            obj = "not set";
        } else
        {
            obj = "already set";
        }
        EbayIdentity.log(context, stringbuilder.append(((String) (obj))).toString());
        obj = EbayIdentity.access$000();
        if (obj == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = getFile(context);
        if (!((File) (obj)).exists()) goto _L4; else goto _L3
_L3:
        byte abyte0[] = readInstallationFile(context, ((File) (obj)));
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (abyte0.length == 49 && abyte0[0] == 1)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, "Device ID is old. Get a new one.");
        }
        ((File) (obj)).delete();
          goto _L1
        context;
        EbayIdentity.access$100().or((new StringBuilder()).append("Device ID initialization failed. App does not have privileges to access the file: ").append(((File) (obj)).getAbsolutePath()).toString());
          goto _L1
        context;
        throw context;
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, (new StringBuilder()).append("loaded: ").append(toHexString(abyte0)).toString());
        }
        byte abyte1[] = new byte[abyte0.length - 1];
        System.arraycopy(abyte0, 1, abyte1, 0, abyte1.length);
        EbayIdentity.access$002(decrypt(abyte1));
        if (EbayIdentity.access$000() != null) goto _L6; else goto _L5
_L5:
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.access$100().le("Device ID is invalid. Get a new one.");
        }
        ((File) (obj)).delete();
          goto _L1
        context;
        EbayIdentity.access$100().or("Invalid file data", context);
        ((File) (obj)).delete();
          goto _L1
_L6:
        if (!EbayIdentity.access$100().le) goto _L1; else goto _L7
_L7:
        EbayIdentity.log(context, (new StringBuilder()).append("loaded device id: ").append(toHexString(EbayIdentity.access$000())).toString());
          goto _L1
        context;
        EbayIdentity.access$100().or("Device ID initialization failed. Could not read/write installation file");
          goto _L1
_L4:
        if (!EbayIdentity.access$100().le) goto _L1; else goto _L8
_L8:
        EbayIdentity.log(context, (new StringBuilder()).append("No file ").append(((File) (obj)).getAbsolutePath()).toString());
          goto _L1
    }

    private static byte[] readInstallationFile(Context context, File file)
        throws IOException
    {
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, "Reading installation file");
        }
        context = null;
        file = new RandomAccessFile(file, "r");
        context = new byte[(int)file.length()];
        file.readFully(context);
        StreamUtil.closeQuietly(file);
        return context;
        file;
_L2:
        StreamUtil.closeQuietly(context);
        throw file;
        Exception exception;
        exception;
        context = file;
        file = exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void save(Context context, byte abyte0[])
    {
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorenter ;
        byte abyte1[];
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, (new StringBuilder()).append("DeviceId.save() - ").append(toHexString(abyte0)).toString());
        }
        load(context);
        abyte1 = EbayIdentity.access$000();
        if (abyte1 == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
        JVM INSTR monitorexit ;
        return;
_L2:
        File file;
        EbayIdentity.access$002(abyte0);
        file = getFile(context);
        byte abyte2[];
        abyte0 = encrypt(abyte0);
        abyte2 = new byte[abyte0.length + 1];
        abyte2[0] = 1;
        System.arraycopy(abyte0, 0, abyte2, 1, abyte0.length);
        writeInstallationFile(context, file, abyte2);
          goto _L1
        context;
        EbayIdentity.access$100().or("Failed to write generated device ID", context);
          goto _L1
        context;
        throw context;
        context;
        EbayIdentity.access$100().or("Failed to write generated device ID", context);
          goto _L1
    }

    private static String toHexString(byte abyte0[])
    {
        int j = abyte0.length;
        StringBuilder stringbuilder = new StringBuilder(j * 2);
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append("0123456789abcdef".charAt(abyte0[i] >> 4 & 0xf));
            stringbuilder.append("0123456789abcdef".charAt(abyte0[i] & 0xf));
        }

        return stringbuilder.toString();
    }

    private static long toLong(byte abyte0[], int i, int j)
    {
        long l;
        boolean flag;
        if (i + j <= abyte0.length)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        l = 0L;
        for (int k = i; k < i + j; k++)
        {
            l = l << 8 | (long)abyte0[k] & 255L;
        }

        return l;
    }

    private static void writeInstallationFile(Context context, File file, byte abyte0[])
        throws IOException
    {
        if (EbayIdentity.access$100().le)
        {
            EbayIdentity.log(context, "Writing installation file");
        }
        context = null;
        file = new FileOutputStream(file);
        file.write(abyte0);
        StreamUtil.closeQuietly(file);
        return;
        file;
_L2:
        StreamUtil.closeQuietly(context);
        throw file;
        abyte0;
        context = file;
        file = abyte0;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private n()
    {
    }
}
