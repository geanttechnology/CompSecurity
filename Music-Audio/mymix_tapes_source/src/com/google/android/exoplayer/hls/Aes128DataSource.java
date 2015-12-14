// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSourceInputStream;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class Aes128DataSource
    implements DataSource
{

    private CipherInputStream cipherInputStream;
    private final byte encryptionIv[];
    private final byte encryptionKey[];
    private final DataSource upstream;

    public Aes128DataSource(DataSource datasource, byte abyte0[], byte abyte1[])
    {
        upstream = datasource;
        encryptionKey = abyte0;
        encryptionIv = abyte1;
    }

    public void close()
        throws IOException
    {
        cipherInputStream = null;
        upstream.close();
    }

    public long open(DataSpec dataspec)
        throws IOException
    {
        Cipher cipher;
        SecretKeySpec secretkeyspec;
        IvParameterSpec ivparameterspec;
        try
        {
            cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        secretkeyspec = new SecretKeySpec(encryptionKey, "AES");
        ivparameterspec = new IvParameterSpec(encryptionIv);
        try
        {
            cipher.init(2, secretkeyspec, ivparameterspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        // Misplaced declaration of an exception variable
        catch (DataSpec dataspec)
        {
            throw new RuntimeException(dataspec);
        }
        cipherInputStream = new CipherInputStream(new DataSourceInputStream(upstream, dataspec), cipher);
        return -1L;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        boolean flag;
        if (cipherInputStream != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assertions.checkState(flag);
        j = cipherInputStream.read(abyte0, i, j);
        i = j;
        if (j < 0)
        {
            i = -1;
        }
        return i;
    }
}
