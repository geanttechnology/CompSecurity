// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
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
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import junit.framework.Assert;

// Referenced classes of package com.ebay.nautilus.kernel:
//            CountryCode, NautilusKernel

public final class EbayIdentity
{
    private static final class DeviceId
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
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, "DeviceId.generate()");
            }
            abyte0 = EbayIdentity.deviceId;
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
            if (EbayIdentity.deviceId == null)
            {
                load(context);
            }
            if (EbayIdentity.deviceId == null)
            {
                break MISSING_BLOCK_LABEL_39;
            }
            context = Base64.encodeToString(encrypt(EbayIdentity.deviceId), 2);
            return context;
            context;
            EbayIdentity.log.logAsError("Couldn't share the ID!", context);
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
            if (!EbayIdentity.log.isLoggable)
            {
                break MISSING_BLOCK_LABEL_48;
            }
            stringbuilder = (new StringBuilder()).append("DeviceId.load() - device id ");
            Object obj;
            if (EbayIdentity.deviceId == null)
            {
                obj = "not set";
            } else
            {
                obj = "already set";
            }
            EbayIdentity.log(context, stringbuilder.append(((String) (obj))).toString());
            obj = EbayIdentity.deviceId;
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
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, "Device ID is old. Get a new one.");
            }
            ((File) (obj)).delete();
              goto _L1
            context;
            EbayIdentity.log.logAsError((new StringBuilder()).append("Device ID initialization failed. App does not have privileges to access the file: ").append(((File) (obj)).getAbsolutePath()).toString());
              goto _L1
            context;
            throw context;
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("loaded: ").append(toHexString(abyte0)).toString());
            }
            byte abyte1[] = new byte[abyte0.length - 1];
            System.arraycopy(abyte0, 1, abyte1, 0, abyte1.length);
            EbayIdentity.deviceId = decrypt(abyte1);
            if (EbayIdentity.deviceId != null) goto _L6; else goto _L5
_L5:
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log.log("Device ID is invalid. Get a new one.");
            }
            ((File) (obj)).delete();
              goto _L1
            context;
            EbayIdentity.log.logAsError("Invalid file data", context);
            ((File) (obj)).delete();
              goto _L1
_L6:
            if (!EbayIdentity.log.isLoggable) goto _L1; else goto _L7
_L7:
            EbayIdentity.log(context, (new StringBuilder()).append("loaded device id: ").append(toHexString(EbayIdentity.deviceId)).toString());
              goto _L1
            context;
            EbayIdentity.log.logAsError("Device ID initialization failed. Could not read/write installation file");
              goto _L1
_L4:
            if (!EbayIdentity.log.isLoggable) goto _L1; else goto _L8
_L8:
            EbayIdentity.log(context, (new StringBuilder()).append("No file ").append(((File) (obj)).getAbsolutePath()).toString());
              goto _L1
        }

        private static byte[] readInstallationFile(Context context, File file)
            throws IOException
        {
            if (EbayIdentity.log.isLoggable)
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
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("DeviceId.save() - ").append(toHexString(abyte0)).toString());
            }
            load(context);
            abyte1 = EbayIdentity.deviceId;
            if (abyte1 == null) goto _L2; else goto _L1
_L1:
            com/ebay/nautilus/kernel/EbayIdentity$DeviceId;
            JVM INSTR monitorexit ;
            return;
_L2:
            File file;
            EbayIdentity.deviceId = abyte0;
            file = getFile(context);
            byte abyte2[];
            abyte0 = encrypt(abyte0);
            abyte2 = new byte[abyte0.length + 1];
            abyte2[0] = 1;
            System.arraycopy(abyte0, 0, abyte2, 1, abyte0.length);
            writeInstallationFile(context, file, abyte2);
              goto _L1
            context;
            EbayIdentity.log.logAsError("Failed to write generated device ID", context);
              goto _L1
            context;
            throw context;
            context;
            EbayIdentity.log.logAsError("Failed to write generated device ID", context);
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
            if (EbayIdentity.log.isLoggable)
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

        private DeviceId()
        {
        }
    }

    private static final class DeviceIdGenerateReceiver extends BroadcastReceiver
    {

        private final CountDownLatch done = new CountDownLatch(1);
        private final Looper looper;
        private final Handler scheduler;

        final boolean getId(Context context)
        {
            context.sendOrderedBroadcast((new Intent("com.ebay.nautilus.domain.ACTION_GET_DEVICE_ID")).putExtra("version", (byte)1), null, this, scheduler, 0, null, null);
            boolean flag;
            try
            {
                flag = done.await(30L, TimeUnit.SECONDS);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return false;
            }
            return flag;
        }

        public void onReceive(Context context, Intent intent)
        {
            String s = getResultData();
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("DeviceIdGenerateReceiver:onReceive(").append(s).append(')').toString());
            }
            Object obj = null;
            intent = obj;
            if (s != null)
            {
                try
                {
                    intent = DeviceId.decrypt(Base64.decode(s, 0));
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    EbayIdentity.log.logAsError((new StringBuilder()).append("Received an invalid response: ").append(s).toString());
                    intent = obj;
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    EbayIdentity.log.logAsError((new StringBuilder()).append("Received an invalid response: ").append(s).toString(), intent);
                    intent = obj;
                }
            }
            if (intent != null)
            {
                DeviceId.save(context, intent);
            } else
            {
                DeviceId.generate(context);
            }
            done.countDown();
            looper.quit();
        }

        public DeviceIdGenerateReceiver()
        {
            HandlerThread handlerthread = new HandlerThread(com/ebay/nautilus/kernel/EbayIdentity$DeviceIdGenerateReceiver.getSimpleName());
            handlerthread.start();
            looper = handlerthread.getLooper();
            scheduler = new Handler(looper);
        }
    }

    public static class DeviceIdReceiver extends BroadcastReceiver
    {

        public void onReceive(Context context, Intent intent)
        {
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, "DeviceIdReceiver:onReceive()");
            }
            if ("com.ebay.nautilus.domain.ACTION_GET_DEVICE_ID".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("Unknown action: ").append(intent.getAction()).toString());
            }
_L4:
            return;
_L2:
            if (1 == intent.getByteExtra("version", (byte)0))
            {
                break; /* Loop/switch isn't completed */
            }
            if (EbayIdentity.log.isLoggable)
            {
                EbayIdentity.log(context, (new StringBuilder()).append("Expecting version: 1 but got version: ").append(intent.getByteExtra("version", (byte)0)).toString());
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            intent = DeviceId.getEncryptedIdForBroadcast(context);
            if (intent != null)
            {
                if (EbayIdentity.log.isLoggable)
                {
                    EbayIdentity.log(context, (new StringBuilder()).append("device ID set: ").append(intent).append(" aborting").toString());
                }
                setResultData(intent);
                abortBroadcast();
                return;
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public DeviceIdReceiver()
        {
        }
    }

    public static final class Fingerprint4pp
    {

        private static final int OFFSET_DEVICE_COUNTRY = 5;
        private static final int OFFSET_DEVICE_LANGUAGE = 10;
        private static final int OFFSET_DEVICE_OPERATING_SYSTEM = 4;
        private static final int OFFSET_DEVICE_TYPE = 3;
        private static final int OFFSET_HMAC = 31;
        private static final int OFFSET_KEYSET = 1;
        private static final int OFFSET_MOBILE_NETWORK_CODE = 7;
        private static final int OFFSET_PADDING = 28;
        private static final int OFFSET_UNIQUE_IDENTIFIER = 12;
        private static final int OFFSET_VERSION = 0;
        private final byte data[];
        private State state;

        private void encryptDecrypt(boolean flag)
        {
            SecretKeySpec secretkeyspec = new SecretKeySpec(getCryptKey(), "AES");
            Cipher cipher;
            int i;
            try
            {
                cipher = Cipher.getInstance("AES/CBC/NoPadding");
            }
            catch (Exception exception)
            {
                throw new RuntimeException("Couldn't encrypt/decrypt data!", exception);
            }
            if (flag)
            {
                i = 1;
            } else
            {
                i = 2;
            }
            cipher.init(i, secretkeyspec, new IvParameterSpec(new byte[16]));
            i = data.length - 3;
            System.arraycopy(cipher.doFinal(data, 3, i), 0, data, 3, i);
            return;
        }

        private void ensureEncrypted()
        {
            if (state == State.Encrypted)
            {
                return;
            } else
            {
                ensureHmac();
                encryptDecrypt(true);
                state = State.Encrypted;
                return;
            }
        }

        private void ensureHmac()
        {
            if (state != State.Unencrypted)
            {
                break MISSING_BLOCK_LABEL_90;
            }
            Assert.assertEquals(data[28] | data[29] | data[30], 0);
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(getHmacKey(), mac.getAlgorithm()));
            mac.update(data, 0, 31);
            mac.doFinal(data, 31);
            state = State.HmacCalculated;
            return;
            Exception exception;
            exception;
            throw new RuntimeException("Couldn't create HMAC!", exception);
        }

        private void ensureUnencrypted()
        {
            if (state != State.Encrypted)
            {
                return;
            }
            if (!isSupportedVersion())
            {
                throw new RuntimeException((new StringBuilder()).append("Unknown version: ").append(getVersion()).toString());
            } else
            {
                encryptDecrypt(false);
                state = State.HmacCalculated;
                return;
            }
        }

        private byte[] getCryptKey()
        {
            switch (getKeyset())
            {
            default:
                throw new RuntimeException((new StringBuilder()).append("Unknown keyset: ").append(getKeyset()).toString());

            case 1: // '\001'
            case 2: // '\002'
                return (new byte[] {
                    64, -87, 45, 37, -102, 68, -66, -79, -38, -18, 
                    68, -114, 31, -25, 90, 16, 122, -74, 88, 32, 
                    42, 112, 54, -23, 17, -79, 2, -117, 26, -19, 
                    -39, 80
                });

            case 3: // '\003'
                return (new byte[] {
                    -10, 34, -49, 3, 69, 49, -70, -48, 4, 49, 
                    -75, 70, 46, 13, 17, -123, 0, -91, 70, 10, 
                    -121, -90, -37, 78, 73, -45, -119, -20, -17, -83, 
                    -20, -104
                });

            case 4: // '\004'
                return (new byte[] {
                    43, -50, -93, 17, -57, -113, -57, -69, 72, 30, 
                    108, -30, -41, 0, 50, -36, 42, -66, -83, -106, 
                    117, 75, -75, 6, -63, 41, 8, 20, -29, -96, 
                    101, -85
                });

            case 5: // '\005'
                return (new byte[] {
                    -62, 112, 7, -80, 114, -36, 113, 106, 60, -62, 
                    9, 37, -125, -54, 56, -118, -52, -67, 85, 90, 
                    55, -102, -124, -59, 74, 68, 77, 43, -105, 9, 
                    -84, 49
                });

            case 6: // '\006'
                return (new byte[] {
                    53, 54, -110, -73, -12, -92, -102, -40, 16, 95, 
                    -96, -125, -125, 96, -70, 76, -109, -1, 6, -38, 
                    -91, -38, -82, -25, 82, 107, 32, -78, -79, 35, 
                    15, 52
                });

            case 7: // '\007'
                return (new byte[] {
                    -45, -23, -94, 114, -55, 81, 56, -118, 126, -54, 
                    14, -90, 69, -55, 117, -97, 71, 3, -107, -17, 
                    -8, 97, 3, 18, -127, 8, 117, 5, -110, 22, 
                    59, 13
                });
            }
        }

        private byte[] getHmacKey()
        {
            switch (getKeyset())
            {
            default:
                throw new RuntimeException((new StringBuilder()).append("Unknown keyset: ").append(getKeyset()).toString());

            case 1: // '\001'
            case 2: // '\002'
                return (new byte[] {
                    -121, 87, -57, -124, 40, 126, 27, 48, 98, 63, 
                    18, -80, -126, -43, -104, -101, 31, 119, -10, -19, 
                    109, 31, 108, -3, -63, 67, 37, 117, 77, -81, 
                    -105, -14
                });

            case 3: // '\003'
                return (new byte[] {
                    41, 33, -109, 105, 94, -27, 21, 73, -85, -99, 
                    -127, -37, 23, 36, 113, -71, 53, 21, -70, 13, 
                    -16, -109, 111, 97, 108, 116, 30, -103, -83, -109, 
                    -24, 97
                });

            case 4: // '\004'
                return (new byte[] {
                    -32, -44, 75, 40, -9, -109, 43, 79, 60, -100, 
                    88, 114, -51, -79, 27, 58, 52, -24, 31, -118, 
                    -117, -37, -39, 68, -48, 81, 77, -112, 96, -7, 
                    -86, 101
                });

            case 5: // '\005'
                return (new byte[] {
                    -97, -72, 18, -58, 35, -12, -119, 48, -36, -105, 
                    -66, -44, -104, 103, 105, -38, 39, 125, -77, -91, 
                    -71, -38, -62, -36, 123, -24, -29, -105, -77, 115, 
                    -91, 52
                });

            case 6: // '\006'
                return (new byte[] {
                    -18, -80, 73, 127, 17, 105, 58, -43, -28, -43, 
                    -20, 6, -92, 38, -41, 122, -31, -14, 7, -112, 
                    26, -17, 87, 26, 44, -107, -128, -18, 10, 57, 
                    -61, -70
                });

            case 7: // '\007'
                return (new byte[] {
                    -87, -97, -9, -83, -79, -1, 102, 82, -87, 95, 
                    119, -114, -22, 69, 36, -36, -25, 108, -76, -10, 
                    -26, -42, 104, 36, -97, -33, -93, -5, 73, 82, 
                    1, -116
                });
            }
        }

        private static String toHexString(byte byte0)
        {
            return Integer.toHexString(byte0 & 0xff);
        }

        public String getDeviceCountry()
        {
            ensureUnencrypted();
            if (data[5] == 0 || data[6] == 0)
            {
                return null;
            } else
            {
                return new String(data, 5, 2);
            }
        }

        public String getDeviceLanguage()
        {
            ensureUnencrypted();
            if (data[10] == 0 || data[11] == 0)
            {
                return null;
            } else
            {
                return new String(data, 10, 2);
            }
        }

        public DeviceOs getDeviceOperatingSystem()
        {
            ensureUnencrypted();
            return DeviceOs.values()[data[4]];
        }

        public DeviceType getDeviceType()
        {
            ensureUnencrypted();
            return DeviceType.values()[data[3]];
        }

        public String getEncryptedString()
        {
            ensureEncrypted();
            return Base64.encodeToString(data, 2);
        }

        public short getKeyset()
        {
            short word0 = (short)((short)data[1] << 8);
            return (short)(data[2] & 0xff | word0);
        }

        public String getMobileNetworkCode()
        {
            ensureUnencrypted();
            int j = 0;
            for (int i = 0; i < 3 && data[i + 7] != 0; i++)
            {
                j++;
            }

            if (j == 0)
            {
                return null;
            } else
            {
                return new String(data, 7, j);
            }
        }

        public byte[] getUniqueIdentifier()
        {
            ensureUnencrypted();
            byte abyte0[] = new byte[16];
            System.arraycopy(data, 12, abyte0, 0, 16);
            return abyte0;
        }

        public byte getVersion()
        {
            return data[0];
        }

        public boolean isSupportedVersion()
        {
            return getVersion() == 1;
        }

        public void setDeviceCountry(String s)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            if (s != null && s.length() == 2)
            {
                s = s.getBytes();
            } else
            {
                s = null;
            }
            if (s == null || s.length != 2)
            {
                s = data;
                data[6] = 0;
                s[5] = 0;
                return;
            } else
            {
                data[5] = s[0];
                data[6] = s[1];
                return;
            }
        }

        public void setDeviceLanguage(String s)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            if (s != null && s.length() == 2)
            {
                s = s.getBytes();
            } else
            {
                s = null;
            }
            if (s == null || s.length != 2)
            {
                s = data;
                data[11] = 0;
                s[10] = 0;
                return;
            } else
            {
                data[10] = s[0];
                data[11] = s[1];
                return;
            }
        }

        public void setDeviceOperatingSystem(DeviceOs deviceos)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            data[4] = (byte)deviceos.ordinal();
        }

        public void setDeviceType(DeviceType devicetype)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            data[3] = (byte)devicetype.ordinal();
        }

        public void setKeyset(short word0)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            data[1] = (byte)(word0 >> 8 & 0xff);
            data[2] = (byte)(word0 & 0xff);
        }

        public void setMobileNetworkCode(String s)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            if (!TextUtils.isEmpty(s))
            {
                s = s.getBytes();
            } else
            {
                s = null;
            }
            if (s == null || s.length > 3)
            {
                s = data;
                byte abyte0[] = data;
                data[9] = 0;
                abyte0[8] = 0;
                s[7] = 0;
            } else
            {
                for (int i = 0; i < s.length; i++)
                {
                    data[i + 7] = s[i];
                }

                int j = s.length;
                while (j < 3) 
                {
                    data[j + 7] = 0;
                    j++;
                }
            }
        }

        public void setUniqueIdentifier(byte abyte0[])
        {
            byte abyte1[];
label0:
            {
                ensureUnencrypted();
                state = State.Unencrypted;
                if (abyte0 != null)
                {
                    abyte1 = abyte0;
                    if (abyte0.length == 16)
                    {
                        break label0;
                    }
                }
                abyte1 = new byte[16];
            }
            System.arraycopy(abyte1, 0, data, 12, 16);
        }

        public void setVersion(byte byte0)
        {
            ensureUnencrypted();
            state = State.Unencrypted;
            data[0] = byte0;
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(state);
            if (state != State.Encrypted)
            {
                stringbuilder.append("\nversion = 0x").append(Integer.toHexString(getVersion())).append(",\nkeyset = 0x").append(Integer.toHexString(getKeyset())).append(",\ndeviceType = 0x").append(Integer.toHexString(getDeviceType().ordinal())).append(" (").append(getDeviceType()).append(')').append(",\ndeviceOperatingSystem = 0x").append(Integer.toHexString(getDeviceOperatingSystem().ordinal())).append(" (").append(getDeviceOperatingSystem()).append(')').append(",\ndeviceCountry = {0x").append(toHexString(data[5])).append(", 0x").append(toHexString(data[6])).append('}');
                String s = getDeviceCountry();
                if (s != null)
                {
                    stringbuilder.append(" (").append(s).append(')');
                }
                stringbuilder.append(",\nmobileNetworkCode = {0x").append(toHexString(data[7])).append(", 0x").append(toHexString(data[8])).append(", 0x").append(toHexString(data[9])).append('}');
                s = getMobileNetworkCode();
                if (s != null)
                {
                    stringbuilder.append(" (").append(s).append(')');
                }
                stringbuilder.append(",\ndeviceLanguage = {0x").append(toHexString(data[10])).append(", 0x").append(toHexString(data[11])).append('}');
                s = getDeviceLanguage();
                if (s != null)
                {
                    stringbuilder.append(" (").append(s).append(')');
                }
                stringbuilder.append(",\nuniqueIdentifier = {0x").append(toHexString(data[12]));
                for (int i = 1; i < 16; i++)
                {
                    stringbuilder.append(", 0x").append(toHexString(data[i + 12]));
                }

                stringbuilder.append("},\npadding = {0x").append(toHexString(data[28])).append(", 0x").append(toHexString(data[29])).append(", 0x").append(toHexString(data[30])).append('}').append(",\nhmac = {0x").append(toHexString(data[31]));
                for (int j = 1; j < 20; j++)
                {
                    stringbuilder.append(", 0x").append(toHexString(data[j + 31]));
                }

                stringbuilder.append('}');
            }
            int k = 0;
            while (k < data.length) 
            {
                String s1;
                if (k % 8 == 0)
                {
                    StringBuilder stringbuilder1 = stringbuilder.append('\n');
                    int l;
                    if (k < 16)
                    {
                        s1 = "0x000";
                    } else
                    {
                        s1 = "0x00";
                    }
                    stringbuilder1.append(s1).append(Integer.toHexString(k)).append(':');
                }
                l = data[k] & 0xff;
                if (l < 16)
                {
                    s1 = " 0x0";
                } else
                {
                    s1 = " 0x";
                }
                stringbuilder.append(s1).append(Integer.toHexString(l));
                k++;
            }
            return stringbuilder.toString();
        }

        public boolean verifyHmac()
        {
            boolean flag = false;
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$nautilus$kernel$EbayIdentity$Fingerprint4pp$State[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$kernel$EbayIdentity$Fingerprint4pp$State = new int[Fingerprint4pp.State.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$kernel$EbayIdentity$Fingerprint4pp$State[Fingerprint4pp.State.Unencrypted.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$kernel$EbayIdentity$Fingerprint4pp$State[Fingerprint4pp.State.Encrypted.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.ebay.nautilus.kernel.EbayIdentity.Fingerprint4pp.State[state.ordinal()];
            JVM INSTR tableswitch 1 2: default 36
        //                       1 75
        //                       2 77;
               goto _L1 _L2 _L3
_L1:
            Fingerprint4pp fingerprint4pp = new Fingerprint4pp();
            System.arraycopy(data, 0, fingerprint4pp.data, 0, 31);
            fingerprint4pp.ensureHmac();
            flag = Arrays.equals(data, fingerprint4pp.data);
_L2:
            return flag;
_L3:
            ensureUnencrypted();
            if (true) goto _L1; else goto _L4
_L4:
        }

        public Fingerprint4pp()
        {
            data = new byte[51];
            state = State.Unencrypted;
        }

        public Fingerprint4pp(String s)
            throws IllegalArgumentException
        {
            data = new byte[51];
            state = State.Unencrypted;
            s = Base64.decode(s, 0);
            if (s == null || s.length != data.length)
            {
                throw new IllegalArgumentException("The string is not in the proper format.");
            } else
            {
                System.arraycopy(s, 0, data, 0, s.length);
                state = State.Encrypted;
                return;
            }
        }
    }

    public static final class Fingerprint4pp.DeviceOs extends Enum
    {

        private static final Fingerprint4pp.DeviceOs $VALUES[];
        public static final Fingerprint4pp.DeviceOs Android;
        public static final Fingerprint4pp.DeviceOs Blackberry;
        public static final Fingerprint4pp.DeviceOs Ios;
        public static final Fingerprint4pp.DeviceOs Unknown;
        public static final Fingerprint4pp.DeviceOs WindowsMobile;

        public static Fingerprint4pp.DeviceOs valueOf(String s)
        {
            return (Fingerprint4pp.DeviceOs)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceOs, s);
        }

        public static Fingerprint4pp.DeviceOs[] values()
        {
            return (Fingerprint4pp.DeviceOs[])$VALUES.clone();
        }

        static 
        {
            Unknown = new Fingerprint4pp.DeviceOs("Unknown", 0);
            Ios = new Fingerprint4pp.DeviceOs("Ios", 1);
            Android = new Fingerprint4pp.DeviceOs("Android", 2);
            Blackberry = new Fingerprint4pp.DeviceOs("Blackberry", 3);
            WindowsMobile = new Fingerprint4pp.DeviceOs("WindowsMobile", 4);
            $VALUES = (new Fingerprint4pp.DeviceOs[] {
                Unknown, Ios, Android, Blackberry, WindowsMobile
            });
        }

        private Fingerprint4pp.DeviceOs(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Fingerprint4pp.DeviceType extends Enum
    {

        private static final Fingerprint4pp.DeviceType $VALUES[];
        public static final Fingerprint4pp.DeviceType Computer;
        public static final Fingerprint4pp.DeviceType Mid;
        public static final Fingerprint4pp.DeviceType Phone;
        public static final Fingerprint4pp.DeviceType Tablet;
        public static final Fingerprint4pp.DeviceType Unknown;

        public static Fingerprint4pp.DeviceType valueOf(String s)
        {
            return (Fingerprint4pp.DeviceType)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$DeviceType, s);
        }

        public static Fingerprint4pp.DeviceType[] values()
        {
            return (Fingerprint4pp.DeviceType[])$VALUES.clone();
        }

        static 
        {
            Unknown = new Fingerprint4pp.DeviceType("Unknown", 0);
            Phone = new Fingerprint4pp.DeviceType("Phone", 1);
            Mid = new Fingerprint4pp.DeviceType("Mid", 2);
            Tablet = new Fingerprint4pp.DeviceType("Tablet", 3);
            Computer = new Fingerprint4pp.DeviceType("Computer", 4);
            $VALUES = (new Fingerprint4pp.DeviceType[] {
                Unknown, Phone, Mid, Tablet, Computer
            });
        }

        private Fingerprint4pp.DeviceType(String s, int i)
        {
            super(s, i);
        }
    }

    private static final class Fingerprint4pp.State extends Enum
    {

        private static final Fingerprint4pp.State $VALUES[];
        public static final Fingerprint4pp.State Encrypted;
        public static final Fingerprint4pp.State HmacCalculated;
        public static final Fingerprint4pp.State Unencrypted;

        public static Fingerprint4pp.State valueOf(String s)
        {
            return (Fingerprint4pp.State)Enum.valueOf(com/ebay/nautilus/kernel/EbayIdentity$Fingerprint4pp$State, s);
        }

        public static Fingerprint4pp.State[] values()
        {
            return (Fingerprint4pp.State[])$VALUES.clone();
        }

        static 
        {
            Unencrypted = new Fingerprint4pp.State("Unencrypted", 0);
            HmacCalculated = new Fingerprint4pp.State("HmacCalculated", 1);
            Encrypted = new Fingerprint4pp.State("Encrypted", 2);
            $VALUES = (new Fingerprint4pp.State[] {
                Unencrypted, HmacCalculated, Encrypted
            });
        }

        private Fingerprint4pp.State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String ACTION_GET_DEVICE_ID = "com.ebay.nautilus.domain.ACTION_GET_DEVICE_ID";
    private static volatile String device3ppFingerprint = null;
    private static volatile String device4ppFingerprint = null;
    private static volatile byte deviceId[] = null;
    private static volatile String deviceIdString = null;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(com/ebay/nautilus/kernel/EbayIdentity.getSimpleName(), 3, "Log device ID creation");

    public EbayIdentity()
    {
    }

    private static String asHexString(byte abyte0[])
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

    private static void generate3ppFingerprint(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorenter ;
        Object obj = device3ppFingerprint;
        if (obj == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj = new StringBuilder(43);
        ((StringBuilder) (obj)).append(getDeviceIdString(context));
        ((StringBuilder) (obj)).insert(8, '-');
        ((StringBuilder) (obj)).insert(13, '-');
        ((StringBuilder) (obj)).insert(18, '-');
        ((StringBuilder) (obj)).insert(23, '-');
        ((StringBuilder) (obj)).append(',');
        context = CountryCode.getCountryCallingCode(context);
        if (context != null)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append('0');
_L4:
        ((StringBuilder) (obj)).append(",0");
        device3ppFingerprint = ((StringBuilder) (obj)).toString();
        if (true) goto _L1; else goto _L3
        context;
        throw context;
_L3:
        ((StringBuilder) (obj)).append(context);
          goto _L4
    }

    private static void generate4ppFingerprint(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorenter ;
        String s = device4ppFingerprint;
        if (s == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        byte abyte0[];
        obj = (TelephonyManager)context.getSystemService("phone");
        abyte0 = getDeviceId(context);
        s = ((TelephonyManager) (obj)).getNetworkOperator();
        if (TextUtils.isEmpty(s) || s.length() < 4)
        {
            break MISSING_BLOCK_LABEL_188;
        }
          goto _L3
_L6:
        ((TelephonyManager) (obj)).getPhoneType();
        JVM INSTR tableswitch 1 2: default 193
    //                   1 181
    //                   2 181;
           goto _L4 _L5 _L5
_L4:
        obj = Fingerprint4pp.DeviceType.Unknown;
_L7:
        Fingerprint4pp fingerprint4pp;
        fingerprint4pp = new Fingerprint4pp();
        fingerprint4pp.setVersion((byte)1);
        fingerprint4pp.setKeyset((short)4);
        fingerprint4pp.setDeviceType(((Fingerprint4pp.DeviceType) (obj)));
        fingerprint4pp.setDeviceOperatingSystem(Fingerprint4pp.DeviceOs.Android);
        fingerprint4pp.setDeviceCountry(CountryCode.getCountry(context));
        fingerprint4pp.setMobileNetworkCode(s);
        fingerprint4pp.setDeviceLanguage(Locale.getDefault().getLanguage());
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        fingerprint4pp.setUniqueIdentifier(abyte0);
        device4ppFingerprint = fingerprint4pp.getEncryptedString();
          goto _L1
        context;
        throw context;
_L3:
        s = s.substring(3);
          goto _L6
_L5:
        obj = Fingerprint4pp.DeviceType.Phone;
          goto _L7
        s = null;
          goto _L6
    }

    private static void generateDeviceId(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorenter ;
        byte abyte0[] = deviceId;
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorexit ;
        return;
_L2:
        DeviceId.load(context);
        if (deviceId == null && !(new DeviceIdGenerateReceiver()).getId(context))
        {
            DeviceId.generate(context);
        }
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    private static void generateDeviceIdString(Context context)
    {
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorenter ;
        String s = deviceIdString;
        if (s == null) goto _L2; else goto _L1
_L1:
        com/ebay/nautilus/kernel/EbayIdentity;
        JVM INSTR monitorexit ;
        return;
_L2:
        context = getDeviceId(context);
        if (context == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        deviceIdString = asHexString(context);
        if (true) goto _L1; else goto _L3
_L3:
        context;
        throw context;
    }

    public static byte[] generateEbayGuid()
    {
        return DeviceId.generateEbayGuid();
    }

    public static String generateEbayGuidString()
    {
        return asHexString(generateEbayGuid());
    }

    public static String generateRequestCorrelationId()
    {
        SecureRandom securerandom = new SecureRandom();
        byte abyte0[] = new byte[9];
        securerandom.nextBytes(abyte0);
        return Base64.encodeToString(abyte0, 2);
    }

    public static String get3ppFingerprint(Context context)
    {
        NautilusKernel.verifyNotMain();
        if (device3ppFingerprint == null)
        {
            generate3ppFingerprint(context);
        }
        return device3ppFingerprint;
    }

    public static String get3ppFingerprintIfAlreadyInitialized()
    {
        return device3ppFingerprint;
    }

    public static String get4ppFingerprint(Context context)
    {
        NautilusKernel.verifyNotMain();
        if (device4ppFingerprint == null)
        {
            generate4ppFingerprint(context);
        }
        return device4ppFingerprint;
    }

    public static String get4ppFingerprintIfAlreadyInitialized()
    {
        return device4ppFingerprint;
    }

    public static byte[] getDeviceId(Context context)
    {
        NautilusKernel.verifyNotMain();
        if (deviceId == null)
        {
            generateDeviceId(context);
        }
        return deviceId;
    }

    public static String getDeviceIdString(Context context)
    {
        NautilusKernel.verifyNotMain();
        if (deviceIdString == null)
        {
            generateDeviceIdString(context);
        }
        return deviceIdString;
    }

    public static String getDeviceIdStringIfAlreadyInitialized()
    {
        return deviceIdString;
    }

    static void log(Context context, String s)
    {
        log.log((new StringBuilder()).append(context.getPackageName()).append(' ').append(s).toString());
    }




/*
    static byte[] access$002(byte abyte0[])
    {
        deviceId = abyte0;
        return abyte0;
    }

*/

}
