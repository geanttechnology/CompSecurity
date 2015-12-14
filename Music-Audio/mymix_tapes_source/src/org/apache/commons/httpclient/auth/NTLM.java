// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.util.EncodingUtil;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            AuthenticationException

final class NTLM
{

    public static final String DEFAULT_CHARSET = "ASCII";
    private String credentialCharset;
    private int currentPosition;
    private byte currentResponse[];

    NTLM()
    {
        currentPosition = 0;
        credentialCharset = "ASCII";
    }

    private void addByte(byte byte0)
    {
        currentResponse[currentPosition] = byte0;
        currentPosition = currentPosition + 1;
    }

    private void addBytes(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length; i++)
        {
            currentResponse[currentPosition] = abyte0[i];
            currentPosition = currentPosition + 1;
        }

    }

    private void calcResp(byte abyte0[], byte abyte1[], byte abyte2[])
        throws AuthenticationException
    {
        byte abyte5[] = new byte[7];
        byte abyte4[] = new byte[7];
        byte abyte3[] = new byte[7];
        for (int i = 0; i < 7; i++)
        {
            abyte5[i] = abyte0[i];
        }

        for (int j = 0; j < 7; j++)
        {
            abyte4[j] = abyte0[j + 7];
        }

        for (int k = 0; k < 7; k++)
        {
            abyte3[k] = abyte0[k + 14];
        }

        abyte0 = encrypt(abyte5, abyte1);
        abyte4 = encrypt(abyte4, abyte1);
        abyte1 = encrypt(abyte3, abyte1);
        for (int l = 0; l < 8; l++)
        {
            abyte2[l] = abyte0[l];
        }

        for (int i1 = 0; i1 < 8; i1++)
        {
            abyte2[i1 + 8] = abyte4[i1];
        }

        for (int j1 = 0; j1 < 8; j1++)
        {
            abyte2[j1 + 16] = abyte1[j1];
        }

    }

    private byte[] convertShort(int i)
    {
        String s;
        for (s = Integer.toString(i, 16); s.length() < 4; s = "0" + s) { }
        String s1 = s.substring(2, 4);
        s = s.substring(0, 2);
        return (new byte[] {
            (byte)Integer.parseInt(s1, 16), (byte)Integer.parseInt(s, 16)
        });
    }

    private byte[] encrypt(byte abyte0[], byte abyte1[])
        throws AuthenticationException
    {
        abyte0 = getCipher(abyte0);
        try
        {
            abyte0 = abyte0.doFinal(abyte1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AuthenticationException("Invalid block size for DES encryption.", abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AuthenticationException("Data not padded correctly for DES encryption.", abyte0);
        }
        return abyte0;
    }

    private Cipher getCipher(byte abyte0[])
        throws AuthenticationException
    {
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("DES/ECB/NoPadding");
            cipher.init(1, new SecretKeySpec(setupKey(abyte0), "DES"));
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AuthenticationException("DES encryption is not available.", abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AuthenticationException("Invalid key for DES encryption.", abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AuthenticationException("NoPadding option for DES is not available.", abyte0);
        }
        return cipher;
    }

    private String getResponse()
    {
        byte abyte0[];
        if (currentResponse.length > currentPosition)
        {
            abyte0 = new byte[currentPosition];
            for (int i = 0; i < currentPosition; i++)
            {
                abyte0[i] = currentResponse[i];
            }

        } else
        {
            abyte0 = currentResponse;
        }
        return EncodingUtil.getAsciiString(Base64.encodeBase64(abyte0));
    }

    private byte[] hashPassword(String s, byte abyte0[])
        throws AuthenticationException
    {
        byte abyte2[] = EncodingUtil.getBytes(s.toUpperCase(), credentialCharset);
        byte abyte1[] = new byte[7];
        s = new byte[7];
        int i = abyte2.length;
        int i1 = i;
        if (i > 7)
        {
            i1 = 7;
        }
        i = 0;
        int j1;
        do
        {
            j1 = i;
            if (i >= i1)
            {
                break;
            }
            abyte1[i] = abyte2[i];
            i++;
        } while (true);
        for (; j1 < 7; j1++)
        {
            abyte1[j1] = 0;
        }

        i = abyte2.length;
        i1 = i;
        if (i > 14)
        {
            i1 = 14;
        }
        i = 7;
        do
        {
            j1 = i;
            if (i >= i1)
            {
                break;
            }
            s[i - 7] = abyte2[i];
            i++;
        } while (true);
        for (; j1 < 14; j1++)
        {
            s[j1 - 7] = 0;
        }

        abyte2 = new byte[8];
        byte[] _tmp = abyte2;
        abyte2[0] = 75;
        abyte2[1] = 71;
        abyte2[2] = 83;
        abyte2[3] = 33;
        abyte2[4] = 64;
        abyte2[5] = 35;
        abyte2[6] = 36;
        abyte2[7] = 37;
        abyte1 = encrypt(abyte1, abyte2);
        abyte2 = encrypt(s, abyte2);
        s = new byte[21];
        for (int j = 0; j < abyte1.length; j++)
        {
            s[j] = abyte1[j];
        }

        for (int k = 0; k < abyte2.length; k++)
        {
            s[k + 8] = abyte2[k];
        }

        for (int l = 0; l < 5; l++)
        {
            s[l + 16] = 0;
        }

        abyte1 = new byte[24];
        calcResp(s, abyte0, abyte1);
        return abyte1;
    }

    private void prepareResponse(int i)
    {
        currentResponse = new byte[i];
        currentPosition = 0;
    }

    private byte[] setupKey(byte abyte0[])
    {
        byte abyte1[] = new byte[8];
        abyte1[0] = (byte)(abyte0[0] >> 1 & 0xff);
        abyte1[1] = (byte)(((abyte0[0] & 1) << 6 | (abyte0[1] & 0xff) >> 2 & 0xff) & 0xff);
        abyte1[2] = (byte)(((abyte0[1] & 3) << 5 | (abyte0[2] & 0xff) >> 3 & 0xff) & 0xff);
        abyte1[3] = (byte)(((abyte0[2] & 7) << 4 | (abyte0[3] & 0xff) >> 4 & 0xff) & 0xff);
        abyte1[4] = (byte)(((abyte0[3] & 0xf) << 3 | (abyte0[4] & 0xff) >> 5 & 0xff) & 0xff);
        abyte1[5] = (byte)(((abyte0[4] & 0x1f) << 2 | (abyte0[5] & 0xff) >> 6 & 0xff) & 0xff);
        abyte1[6] = (byte)(((abyte0[5] & 0x3f) << 1 | (abyte0[6] & 0xff) >> 7 & 0xff) & 0xff);
        abyte1[7] = (byte)(abyte0[6] & 0x7f);
        for (int i = 0; i < abyte1.length; i++)
        {
            abyte1[i] = (byte)(abyte1[i] << 1);
        }

        return abyte1;
    }

    public String getCredentialCharset()
    {
        return credentialCharset;
    }

    public final String getResponseFor(String s, String s1, String s2, String s3, String s4)
        throws AuthenticationException
    {
        if (s == null || s.trim().equals(""))
        {
            return getType1Message(s3, s4);
        } else
        {
            return getType3Message(s1, s2, s3, s4, parseType2Message(s));
        }
    }

    public String getType1Message(String s, String s1)
    {
        s = s.toUpperCase();
        s1 = s1.toUpperCase();
        s = EncodingUtil.getBytes(s, "ASCII");
        s1 = EncodingUtil.getBytes(s1, "ASCII");
        prepareResponse(s.length + 32 + s1.length);
        addBytes(EncodingUtil.getBytes("NTLMSSP", "ASCII"));
        addByte((byte)0);
        addByte((byte)1);
        addByte((byte)0);
        addByte((byte)0);
        addByte((byte)0);
        addByte((byte)6);
        addByte((byte)82);
        addByte((byte)0);
        addByte((byte)0);
        byte abyte0[] = convertShort(s1.length);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        abyte0 = convertShort(s.length + 32);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        addByte((byte)0);
        addByte((byte)0);
        abyte0 = convertShort(s.length);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        abyte0 = convertShort(32);
        addByte(abyte0[0]);
        addByte(abyte0[1]);
        addByte((byte)0);
        addByte((byte)0);
        addBytes(s);
        addBytes(s1);
        return getResponse();
    }

    public String getType3Message(String s, String s1, String s2, String s3, byte abyte0[])
        throws AuthenticationException
    {
        s3 = s3.toUpperCase();
        s2 = s2.toUpperCase();
        s = s.toUpperCase();
        s3 = EncodingUtil.getBytes(s3, "ASCII");
        s2 = EncodingUtil.getBytes(s2, "ASCII");
        s = EncodingUtil.getBytes(s, credentialCharset);
        int i = s3.length;
        int l = s2.length;
        int i1 = s.length;
        int k = i + 88 + i1 + l;
        prepareResponse(k);
        addBytes(EncodingUtil.getBytes("NTLMSSP", "ASCII"));
        addByte((byte)0);
        addByte((byte)3);
        addByte((byte)0);
        addByte((byte)0);
        addByte((byte)0);
        addBytes(convertShort(24));
        addBytes(convertShort(24));
        addBytes(convertShort(k - 24));
        addByte((byte)0);
        addByte((byte)0);
        addBytes(convertShort(0));
        addBytes(convertShort(0));
        addBytes(convertShort(k));
        addByte((byte)0);
        addByte((byte)0);
        addBytes(convertShort(i));
        addBytes(convertShort(i));
        addBytes(convertShort(64));
        addByte((byte)0);
        addByte((byte)0);
        addBytes(convertShort(i1));
        addBytes(convertShort(i1));
        addBytes(convertShort(i + 64));
        addByte((byte)0);
        addByte((byte)0);
        addBytes(convertShort(l));
        addBytes(convertShort(l));
        addBytes(convertShort(i + 64 + i1));
        for (int j = 0; j < 6; j++)
        {
            addByte((byte)0);
        }

        addBytes(convertShort(k));
        addByte((byte)0);
        addByte((byte)0);
        addByte((byte)6);
        addByte((byte)82);
        addByte((byte)0);
        addByte((byte)0);
        addBytes(s3);
        addBytes(s);
        addBytes(s2);
        addBytes(hashPassword(s1, abyte0));
        return getResponse();
    }

    public byte[] parseType2Message(String s)
    {
        s = Base64.decodeBase64(EncodingUtil.getBytes(s, "ASCII"));
        byte abyte0[] = new byte[8];
        for (int i = 0; i < 8; i++)
        {
            abyte0[i] = s[i + 24];
        }

        return abyte0;
    }

    public void setCredentialCharset(String s)
    {
        credentialCharset = s;
    }
}
