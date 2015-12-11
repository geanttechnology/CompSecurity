// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identifier
    implements Comparable
{

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("^[0-9]+$");
    private static final Pattern HEX_PATTERN = Pattern.compile("^0x[0-9A-Fa-f]*$");
    private static final Pattern UUID_PATTERN = Pattern.compile("^[0-9A-Fa-f]{8}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{4}-?[0-9A-Fa-f]{12}$");
    private static final char hexArray[] = "0123456789abcdef".toCharArray();
    private static final BigInteger maxInteger = BigInteger.valueOf(65535L);
    private final byte mValue[];

    public Identifier(Identifier identifier)
    {
        if (identifier == null)
        {
            throw new NullPointerException("identifier == null");
        } else
        {
            mValue = identifier.mValue;
            return;
        }
    }

    protected Identifier(byte abyte0[])
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("identifier == null");
        } else
        {
            mValue = abyte0;
            return;
        }
    }

    public static Identifier fromBytes(byte abyte0[], int i, int j, boolean flag)
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("bytes == null");
        }
        if (i < 0 || i > abyte0.length)
        {
            throw new ArrayIndexOutOfBoundsException("start < 0 || start > bytes.length");
        }
        if (j > abyte0.length)
        {
            throw new ArrayIndexOutOfBoundsException("end > bytes.length");
        }
        if (i > j)
        {
            throw new IllegalArgumentException("start > end");
        }
        abyte0 = Arrays.copyOfRange(abyte0, i, j);
        if (flag)
        {
            reverseArray(abyte0);
        }
        return new Identifier(abyte0);
    }

    public static Identifier fromInt(int i)
    {
        if (i < 0 || i > 65535)
        {
            throw new IllegalArgumentException("value must be between 0 and 65535");
        } else
        {
            return new Identifier(new byte[] {
                (byte)(i >> 8), (byte)i
            });
        }
    }

    public static Identifier parse(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("stringValue == null");
        }
        if (HEX_PATTERN.matcher(s).matches())
        {
            return parseHex(s.substring(2));
        }
        if (UUID_PATTERN.matcher(s).matches())
        {
            return parseHex(s.replace("-", ""));
        }
        if (DECIMAL_PATTERN.matcher(s).matches())
        {
            BigInteger biginteger = new BigInteger(s);
            if (biginteger.compareTo(BigInteger.ZERO) < 0 || biginteger.compareTo(maxInteger) > 0)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Decimal formatted integers must be between 0 and 65535. Value: ").append(s).toString());
            } else
            {
                return fromInt(biginteger.intValue());
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unable to parse identifier: ").append(s).toString());
        }
    }

    private static Identifier parseHex(String s)
    {
        byte abyte0[];
        if (s.length() % 2 == 0)
        {
            s = s.toLowerCase();
        } else
        {
            s = (new StringBuilder()).append("0").append(s.toLowerCase()).toString();
        }
        abyte0 = new byte[s.length() / 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
        }

        return new Identifier(abyte0);
    }

    private static void reverseArray(byte abyte0[])
    {
        for (int i = 0; i < abyte0.length / 2; i++)
        {
            byte byte0 = abyte0[i];
            abyte0[i] = abyte0[abyte0.length - i - 1];
            abyte0[abyte0.length - i - 1] = byte0;
        }

    }

    private static String toHexString(byte abyte0[], int i, int j)
    {
        char ac[] = new char[j * 2];
        for (int k = 0; k < j; k++)
        {
            int l = abyte0[i + k] & 0xff;
            ac[k * 2] = hexArray[l >>> 4];
            ac[k * 2 + 1] = hexArray[l & 0xf];
        }

        return new String(ac);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((Identifier)obj);
    }

    public int compareTo(Identifier identifier)
    {
        if (mValue.length == identifier.mValue.length) goto _L2; else goto _L1
_L1:
        if (mValue.length >= identifier.mValue.length) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        return 1;
_L2:
        int i = 0;
        do
        {
            if (i >= mValue.length)
            {
                break;
            }
            if (mValue[i] != identifier.mValue[i])
            {
                if (mValue[i] >= identifier.mValue[i])
                {
                    return 1;
                }
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        return 0;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof Identifier))
        {
            return false;
        } else
        {
            obj = (Identifier)obj;
            return Arrays.equals(mValue, ((Identifier) (obj)).mValue);
        }
    }

    public int getByteCount()
    {
        return mValue.length;
    }

    public int hashCode()
    {
        return Arrays.hashCode(mValue);
    }

    public byte[] toByteArrayOfSpecifiedEndianness(boolean flag)
    {
        byte abyte0[] = Arrays.copyOf(mValue, mValue.length);
        if (!flag)
        {
            reverseArray(abyte0);
        }
        return abyte0;
    }

    public String toHexString()
    {
        return toHexString(mValue, 0, mValue.length);
    }

    public int toInt()
    {
        if (mValue.length > 2)
        {
            throw new UnsupportedOperationException("Only supported for Identifiers with max byte length of 2");
        }
        int j = 0;
        for (int i = 0; i < mValue.length; i++)
        {
            j |= (mValue[i] & 0xff) << (mValue.length - i - 1) * 8;
        }

        return j;
    }

    public String toString()
    {
        if (mValue.length == 2)
        {
            return Integer.toString(toInt());
        }
        if (mValue.length == 16)
        {
            return toUuidString();
        } else
        {
            return (new StringBuilder()).append("0x").append(toHexString()).toString();
        }
    }

    public String toUuidString()
    {
        if (mValue.length != 16)
        {
            throw new UnsupportedOperationException("Only available for values with length of 16 bytes");
        } else
        {
            return (new StringBuilder()).append(toHexString(mValue, 0, 4)).append("-").append(toHexString(mValue, 4, 2)).append("-").append(toHexString(mValue, 6, 2)).append("-").append(toHexString(mValue, 8, 2)).append("-").append(toHexString(mValue, 10, 6)).toString();
        }
    }

}
