// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nielsen.app.sdk;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class AppCryptoManager
{
    public static class AppBase16
    {

        private static final String a = "0123456789ABCDEF";

        private static void a(StringBuffer stringbuffer, byte byte0)
        {
            stringbuffer.append("0123456789ABCDEF".charAt(byte0 >> 4 & 0xf)).append("0123456789ABCDEF".charAt(byte0 & 0xf));
        }

        public static byte[] decodeBytes(String s)
        {
            int j = s.length() / 2;
            byte abyte0[] = new byte[j];
            for (int i = 0; i < j; i++)
            {
                abyte0[i] = Integer.valueOf(s.substring(i * 2, i * 2 + 1), 16).byteValue();
            }

            return abyte0;
        }

        public static String decodeString(String s)
        {
            return new String(decodeBytes(s));
        }

        public static String encode(String s)
        {
            return encode(s.getBytes());
        }

        public static String encode(byte abyte0[])
        {
            if (abyte0 == null)
            {
                return "";
            }
            StringBuffer stringbuffer = new StringBuffer(abyte0.length * 2);
            for (int i = 0; i < abyte0.length; i++)
            {
                a(stringbuffer, abyte0[i]);
            }

            return stringbuffer.toString();
        }

        public AppBase16()
        {
        }
    }

    public static class AppPasswordManager
    {

        private static final String a = "HmacSHA1";
        private static byte b[];
        private static Mac c;
        private static int d;
        private static byte e[] = new byte[20];
        private static int f = 0;
        private static int g = 0;
        private static int h = 1;

        public static void Setup(String s, byte abyte0[])
            throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
        {
            Setup(s, abyte0, 1000);
        }

        public static void Setup(String s, byte abyte0[], int i)
            throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
        {
            Setup(s.getBytes("UTF8"), abyte0, i);
        }

        public static void Setup(byte abyte0[], byte abyte1[], int i)
            throws NoSuchAlgorithmException, InvalidKeyException
        {
            if (abyte1 == null || abyte1.length < 8)
            {
                throw new InvalidKeyException("Salt must be 8 bytes or more");
            }
            if (abyte0 == null)
            {
                throw new InvalidKeyException("Password cannot be null");
            } else
            {
                b = abyte1;
                d = i;
                c = Mac.getInstance("HmacSHA1");
                c.init(new SecretKeySpec(abyte0, "HmacSHA1"));
                return;
            }
        }

        private static byte[] a()
        {
            c.update(b, 0, b.length);
            byte abyte1[] = c.doFinal(a(h));
            c.reset();
            int i = 2;
            byte abyte0[] = abyte1;
            for (; i <= d; i++)
            {
                abyte0 = c.doFinal(abyte0);
                for (int j = 0; j < 20; j++)
                {
                    abyte1[j] = (byte)(abyte1[j] ^ abyte0[j]);
                }

            }

            if (h >= 0x7fffffff)
            {
                h = 0;
                return abyte1;
            } else
            {
                h++;
                return abyte1;
            }
        }

        private static byte[] a(int i)
        {
            return (new byte[] {
                (byte)(i >>> 24), (byte)(i >>> 16), (byte)(i >>> 8), (byte)i
            });
        }

        public static byte[] getBytes(int i)
        {
label0:
            {
                byte abyte0[] = new byte[i];
                int j = g - f;
                int k;
                if (j > 0)
                {
                    if (j > i)
                    {
                        System.arraycopy(e, f, abyte0, 0, i);
                        f += i;
                    } else
                    {
                        System.arraycopy(e, f, abyte0, 0, j);
                        f = 0;
                        g = 0;
                    }
                    j += 0;
                } else
                {
                    j = 0;
                }
                do
                {
                    if (j >= i)
                    {
                        break label0;
                    }
                    k = i - j;
                    e = a();
                    if (k <= 20)
                    {
                        break;
                    }
                    System.arraycopy(e, 0, abyte0, j, 20);
                    j += 20;
                } while (true);
                System.arraycopy(e, 0, abyte0, j, k);
                f = k;
                g = 20;
            }
            return abyte0;
        }


        public AppPasswordManager()
        {
        }
    }


    public static final int ENCODING_SCHEME_Base16Text = 1;
    public static final int ENCODING_SCHEME_Base64Text = 0;
    private static final String a = "F1D3A567894BC2E0";
    private final String b = "AES/CBC/PKCS5Padding";
    private final String c = "AES";
    private Cipher d;
    private SecretKey e;
    private IvParameterSpec f;

    AppCryptoManager()
    {
        d = null;
        e = null;
        f = null;
    }

    private void a()
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        if (d != null && e != null && f != null)
        {
            return;
        } else
        {
            e = new SecretKeySpec(new byte[] {
                -91, 48, -17, -86, 80, 82, 118, -105, -121, 43, 
                23, -17, -17, -12, -85, -11, 56, -126, -114, -96, 
                -36, -122, 67, -71, 65, 64, 112, -69, 85, -40, 
                24, 112
            }, "AES");
            f = new IvParameterSpec("F1D3A567894BC2E0".getBytes("UTF-8"));
            d = Cipher.getInstance("AES/CBC/PKCS5Padding");
            return;
        }
    }

    private byte[] a(byte abyte0[])
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        a();
        d.init(1, e, f);
        return d.doFinal(abyte0);
    }

    private byte[] b(byte abyte0[])
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        a();
        d.init(2, e, f);
        return d.doFinal(abyte0);
    }

    public String decrypt(String s, int i)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        i;
        JVM INSTR tableswitch 0 1: default 24
    //                   0 32
    //                   1 41;
           goto _L1 _L2 _L3
_L1:
        s = null;
_L5:
        if (s == null)
        {
            return null;
        }
        break; /* Loop/switch isn't completed */
_L2:
        s = Base64.decode(s, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        s = AppBase16.decodeString(s).getBytes("UTF-8");
        if (true) goto _L5; else goto _L4
_L4:
        s = b(s);
        if (s == null)
        {
            throw new Exception("Could not get decrypted text from plain text");
        } else
        {
            return new String(s);
        }
    }

    public String encrypt(String s, int i)
        throws NoSuchAlgorithmException, NoSuchPaddingException, Exception
    {
        s = a(s.getBytes());
        if (s == null)
        {
            throw new Exception("Could not get encrypted text from plain text");
        }
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return Base64.encodeToString(s, 0);

        case 1: // '\001'
            return AppBase16.encode(s);
        }
    }
}
