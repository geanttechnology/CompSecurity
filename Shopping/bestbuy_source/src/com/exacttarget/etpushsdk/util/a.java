// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.exacttarget.etpushsdk.util:
//            d, n, m

public class a
{

    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static String b = null;
    private static SharedPreferences c = null;
    private static c d = null;

    private static SharedPreferences a(Context context)
    {
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = context.getSharedPreferences("ETPush", 0);
        }
        context = c;
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private static a a(String s, c c1)
    {
        return a(s, c1, "UTF-8");
    }

    private static a a(String s, c c1, String s1)
    {
        return a(s.getBytes(s1), c1);
    }

    private static a a(byte abyte0[], c c1)
    {
        byte abyte1[] = b();
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, c1.a(), new IvParameterSpec(abyte1));
        abyte1 = cipher.getIV();
        abyte0 = cipher.doFinal(abyte0);
        return new a(abyte0, abyte1, a(a.a(abyte1, abyte0), c1.b()));
    }

    private static c a(String s, String s1)
    {
        return a(s, Base64.decode(s1, 2));
    }

    private static c a(String s, byte abyte0[])
    {
        c();
        s = new PBEKeySpec(s.toCharArray(), abyte0, 10000, 384);
        abyte0 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(s).getEncoded();
        s = Arrays.copyOfRange(abyte0, 0, 16);
        abyte0 = Arrays.copyOfRange(abyte0, 16, 48);
        return new c(new SecretKeySpec(s, "AES"), new SecretKeySpec(abyte0, "HmacSHA256"));
    }

    public static String a(Context context, String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (!TextUtils.isEmpty(com.exacttarget.etpushsdk.util.d.e()))
            {
                return a(s, b(context)).toString();
            }
        }
        return s1;
    }

    private static String a(SharedPreferences sharedpreferences)
    {
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        b = sharedpreferences.getString("install_date_enc", null);
        if (b == null)
        {
            b = a(a());
            sharedpreferences.edit().putString("install_date_enc", b).apply();
        }
        sharedpreferences = n.b((new StringBuilder()).append(com.exacttarget.etpushsdk.util.d.b()).append("29200FA5-DF79-4C3F-BC0F-E2FF3CE6199A").toString());
        int i;
        try
        {
            i = NumberFormat.getInstance().parse(sharedpreferences).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (SharedPreferences sharedpreferences)
        {
            i = 200;
        }
        b = n.b(b.substring(Integer.valueOf(String.valueOf(i).substring(0, 1)).intValue()));
        sharedpreferences = b;
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorexit ;
        return sharedpreferences;
        sharedpreferences;
        throw sharedpreferences;
    }

    private static String a(a a1, c c1)
    {
        return a(a1, c1, "UTF-8");
    }

    private static String a(a a1, c c1, String s)
    {
        return new String(b(a1, c1), s);
    }

    private static String a(byte abyte0[])
    {
        return Base64.encodeToString(abyte0, 2);
    }

    public static void a(Context context, String s, String s1)
    {
        SharedPreferences sharedpreferences = a(context);
        try
        {
            context = a(context, s1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            m.c("~!ua", context.getMessage(), context);
            context = s1;
        }
        sharedpreferences.edit().putString(s, context).commit();
    }

    public static boolean a(byte abyte0[], byte abyte1[])
    {
        if (abyte0.length == abyte1.length)
        {
            int i = 0;
            int j = 0;
            for (; i < abyte0.length; i++)
            {
                j |= abyte0[i] ^ abyte1[i];
            }

            if (j == 0)
            {
                return true;
            }
        }
        return false;
    }

    private static byte[] a()
    {
        return a(128);
    }

    private static byte[] a(int i)
    {
        c();
        SecureRandom securerandom = SecureRandom.getInstance("SHA1PRNG");
        byte abyte0[] = new byte[i];
        securerandom.nextBytes(abyte0);
        return abyte0;
    }

    private static byte[] a(byte abyte0[], SecretKey secretkey)
    {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(secretkey);
        return mac.doFinal(abyte0);
    }

    private static c b(Context context)
    {
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = a(com.exacttarget.etpushsdk.util.d.e(), a(a(context)));
        }
        context = d;
        com/exacttarget/etpushsdk/util/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String b(Context context, String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (!TextUtils.isEmpty(com.exacttarget.etpushsdk.util.d.e()))
            {
                return a(new a(s), b(context));
            }
        }
        return s1;
    }

    public static String b(Context context, String s, String s1)
    {
        Object obj;
        Object obj1;
        obj = null;
        obj1 = a(context);
        obj1 = ((SharedPreferences) (obj1)).getString(s, null);
        s = obj;
        if (obj1 != null)
        {
            try
            {
                s = b(context, ((String) (obj1)));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                m.c("~!ua", context.getMessage(), context);
                s = obj;
            }
        }
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    private static byte[] b()
    {
        return a(16);
    }

    private static byte[] b(a a1, c c1)
    {
        if (a(a(a.a(a1.b(), a1.a()), c1.b()), a1.c()))
        {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, c1.a(), new IvParameterSpec(a1.b()));
            return cipher.doFinal(a1.a());
        } else
        {
            throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
        }
    }

    private static void c()
    {
        if (a.get())
        {
            break MISSING_BLOCK_LABEL_44;
        }
        com/exacttarget/etpushsdk/util/a$b;
        JVM INSTR monitorenter ;
        if (!a.get())
        {
            b.a();
            a.set(true);
        }
        com/exacttarget/etpushsdk/util/a$b;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/exacttarget/etpushsdk/util/a$b;
        JVM INSTR monitorexit ;
        throw exception;
    }


    private class c
    {

        private SecretKey a;
        private SecretKey b;

        public SecretKey a()
        {
            return a;
        }

        public void a(SecretKey secretkey)
        {
            a = secretkey;
        }

        public SecretKey b()
        {
            return b;
        }

        public void b(SecretKey secretkey)
        {
            b = secretkey;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (c)obj;
                if (!b.equals(((c) (obj)).b))
                {
                    return false;
                }
                if (!a.equals(((c) (obj)).a))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return (a.hashCode() + 31) * 31 + b.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append(Base64.encodeToString(a().getEncoded(), 2)).append(":").append(Base64.encodeToString(b().getEncoded(), 2)).toString();
        }

        public c(SecretKey secretkey, SecretKey secretkey1)
        {
            a(secretkey);
            b(secretkey1);
        }
    }


    private class a
    {

        private final byte a[];
        private final byte b[];
        private final byte c[];

        public static byte[] a(byte abyte0[], byte abyte1[])
        {
            byte abyte2[] = new byte[abyte0.length + abyte1.length];
            System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
            System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
            return abyte2;
        }

        public byte[] a()
        {
            return a;
        }

        public byte[] b()
        {
            return b;
        }

        public byte[] c()
        {
            return c;
        }

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null)
                {
                    return false;
                }
                if (getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (a)obj;
                if (!Arrays.equals(a, ((a) (obj)).a))
                {
                    return false;
                }
                if (!Arrays.equals(b, ((a) (obj)).b))
                {
                    return false;
                }
                if (!Arrays.equals(c, ((a) (obj)).c))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return ((Arrays.hashCode(a) + 31) * 31 + Arrays.hashCode(b)) * 31 + Arrays.hashCode(c);
        }

        public String toString()
        {
            String s = Base64.encodeToString(b, 2);
            String s1 = Base64.encodeToString(a, 2);
            String s2 = Base64.encodeToString(c, 2);
            return String.format((new StringBuilder()).append(s).append(":").append(s2).append(":").append(s1).toString(), new Object[0]);
        }

        public a(String s)
        {
            s = s.split(":");
            if (s.length != 3)
            {
                throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
            } else
            {
                b = Base64.decode(s[0], 2);
                c = Base64.decode(s[1], 2);
                a = Base64.decode(s[2], 2);
                return;
            }
        }

        public a(byte abyte0[], byte abyte1[], byte abyte2[])
        {
            a = Arrays.copyOf(abyte0, abyte0.length);
            b = Arrays.copyOf(abyte1, abyte1.length);
            c = Arrays.copyOf(abyte2, abyte2.length);
        }
    }


    private class b
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
            if (android.os.Build.VERSION.SDK_INT <= 18)
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


        private b()
        {
        }
    }

}
