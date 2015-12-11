// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.text.TextUtils;
import android.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger

public class StagingStream extends OutputStream
{

    private final FileOutputStream fos;
    private final OutputStream middleStream;
    private final String publicKey;
    private final long publicKeySerial;
    private Map userMetadata;
    private final OutputStream wrappedStream;

    public StagingStream(File file, String s, long l)
        throws IOException
    {
        publicKey = s;
        publicKeySerial = l;
        Logger.v((new StringBuilder()).append("fileToWrite is ").append(file).toString());
        fos = new FileOutputStream(file);
        if (TextUtils.isEmpty(s))
        {
            middleStream = fos;
            Logger.v("middleStream is fos");
        } else
        {
            try
            {
                middleStream = createCryptoStream(fos);
                Logger.v("middleStream is cryptostream");
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                throw new IOException("Initialization failure, no such algorithm", file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                throw new IOException("Initialization failure, bad key", file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                throw new IOException("Initialization failure, no such padding", file);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                throw new IOException("Initialization failure, invalid algorithm parameter", file);
            }
        }
        wrappedStream = new GZIPOutputStream(middleStream);
    }

    public void close()
        throws IOException
    {
        wrappedStream.close();
    }

    protected OutputStream createCryptoStream(OutputStream outputstream)
        throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, InvalidAlgorithmParameterException
    {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte abyte0[] = new byte[32];
        byte abyte1[] = new byte[16];
        SecureRandom securerandom = new SecureRandom();
        securerandom.nextBytes(abyte0);
        securerandom.nextBytes(abyte1);
        cipher.init(1, new SecretKeySpec(abyte0, "AES"), new IvParameterSpec(abyte1));
        outputstream = new CipherOutputStream(outputstream, cipher);
        setupUserMetadata(abyte0, abyte1);
        return outputstream;
    }

    protected byte[] encrypt(byte abyte0[])
    {
        try
        {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            byte abyte1[] = Base64.decode(publicKey, 0);
            cipher.init(1, KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(abyte1)));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return null;
        }
        return abyte0;
    }

    public Map getUserMetadata()
    {
        return userMetadata;
    }

    protected void setupUserMetadata(byte abyte0[], byte abyte1[])
    {
        userMetadata = new HashMap();
        if (publicKeySerial > -1L)
        {
            userMetadata.put("publicKeySerial", String.valueOf(publicKeySerial));
        }
        abyte0 = encrypt(abyte0);
        if (abyte0 != null)
        {
            userMetadata.put("encryptedAesKey", Base64.encodeToString(abyte0, 2));
            userMetadata.put("aesIV", Base64.encodeToString(abyte1, 2));
        }
    }

    public void write(int i)
        throws IOException
    {
        Logger.v("stagingStream write(byte)");
        wrappedStream.write(i);
    }

    public void write(byte abyte0[])
        throws IOException
    {
        Logger.v((new StringBuilder()).append("stagingStream write(byte[").append(abyte0.length).append("])").toString());
        wrappedStream.write(abyte0);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        Logger.v((new StringBuilder()).append("stagingStream write(byte[").append(abyte0.length).append("], ").append(i).append(", ").append(j).append(")").toString());
        wrappedStream.write(abyte0, i, j);
    }
}
