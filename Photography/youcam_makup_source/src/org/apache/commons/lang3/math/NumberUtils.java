// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.math;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.lang3.StringUtils;

public class NumberUtils
{

    public static final Byte BYTE_MINUS_ONE = Byte.valueOf((byte)-1);
    public static final Byte BYTE_ONE = Byte.valueOf((byte)1);
    public static final Byte BYTE_ZERO = Byte.valueOf((byte)0);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1D);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0D);
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0D);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1F);
    public static final Float FLOAT_ONE = Float.valueOf(1.0F);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0F);
    public static final Integer INTEGER_MINUS_ONE = Integer.valueOf(-1);
    public static final Integer INTEGER_ONE = Integer.valueOf(1);
    public static final Integer INTEGER_ZERO = Integer.valueOf(0);
    public static final Long LONG_MINUS_ONE = Long.valueOf(-1L);
    public static final Long LONG_ONE = Long.valueOf(1L);
    public static final Long LONG_ZERO = Long.valueOf(0L);
    public static final Short SHORT_MINUS_ONE = Short.valueOf((short)-1);
    public static final Short SHORT_ONE = Short.valueOf((short)1);
    public static final Short SHORT_ZERO = Short.valueOf((short)0);

    public NumberUtils()
    {
    }

    public static BigDecimal createBigDecimal(String s)
    {
        if (s == null)
        {
            return null;
        }
        if (StringUtils.isBlank(s))
        {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (s.trim().startsWith("--"))
        {
            throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid number.").toString());
        } else
        {
            return new BigDecimal(s);
        }
    }

    public static BigInteger createBigInteger(String s)
    {
        boolean flag = true;
        int i = 0;
        if (s == null)
        {
            return null;
        }
        int j;
        if (s.startsWith("-"))
        {
            i = 1;
        } else
        {
            flag = false;
        }
        if (s.startsWith("0x", i) || s.startsWith("0x", i))
        {
            j = i + 2;
            i = 16;
        } else
        if (s.startsWith("#", i))
        {
            j = i + 1;
            i = 16;
        } else
        if (s.startsWith("0", i) && s.length() > i + 1)
        {
            j = i + 1;
            i = 8;
        } else
        {
            j = i;
            i = 10;
        }
        s = new BigInteger(s.substring(j), i);
        if (flag)
        {
            return s.negate();
        } else
        {
            return s;
        }
    }

    public static Double createDouble(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Double.valueOf(s);
        }
    }

    public static Float createFloat(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Float.valueOf(s);
        }
    }

    public static Integer createInteger(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Integer.decode(s);
        }
    }

    public static Long createLong(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return Long.decode(s);
        }
    }

    public static Number createNumber(String s)
    {
        Object obj;
        String s4;
        Object obj2;
        int j;
        int k;
        s4 = null;
        obj2 = null;
        obj = null;
        k = 0;
        j = 0;
        if (s != null) goto _L2; else goto _L1
_L1:
        return ((Number) (obj));
_L17:
        if (i > 0)
        {
            k = i;
            char c1;
            do
            {
                c1 = j;
                if (i >= s.length())
                {
                    break;
                }
                j = s.charAt(i);
                c1 = j;
                if (j != '0')
                {
                    break;
                }
                k++;
                i++;
            } while (true);
            i = s.length() - k;
            if (i > 16 || i == 16 && c1 > '7')
            {
                return createBigInteger(s);
            }
            if (i > 8 || i == 8 && c1 > '7')
            {
                return createLong(s);
            } else
            {
                return createInteger(s);
            }
        }
        char c = s.charAt(s.length() - 1);
        i = s.indexOf('.');
        j = s.indexOf('e') + s.indexOf('E') + 1;
        if (i > -1)
        {
            if (j > -1)
            {
                if (j < i || j > s.length())
                {
                    throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid number.").toString());
                }
                obj = s.substring(i + 1, j);
            } else
            {
                obj = s.substring(i + 1);
            }
            obj1 = s.substring(0, i);
            i = ((String) (obj)).length();
        } else
        {
            if (j > -1)
            {
                if (j > s.length())
                {
                    throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid number.").toString());
                }
                obj = s.substring(0, j);
            } else
            {
                obj = s;
            }
            s2 = null;
            obj1 = obj;
            i = 0;
            obj = s2;
        }
        if (Character.isDigit(c) || c == '.') goto _L4; else goto _L3
_L3:
        s2 = s4;
        if (j > -1)
        {
            s2 = s4;
            if (j < s.length() - 1)
            {
                s2 = s.substring(j + 1, s.length() - 1);
            }
        }
        s4 = s.substring(0, s.length() - 1);
        if (isAllZeros(((String) (obj1))) && isAllZeros(s2))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        c;
        JVM INSTR lookupswitch 6: default 520
    //                   68: 763
    //                   70: 723
    //                   76: 640
    //                   100: 763
    //                   102: 723
    //                   108: 640;
           goto _L5 _L6 _L7 _L8 _L6 _L7 _L8
_L6:
        break; /* Loop/switch isn't completed */
_L5:
        throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid number.").toString());
_L8:
        if (obj == null && s2 == null && (s4.charAt(0) == '-' && isDigits(s4.substring(1)) || isDigits(s4)))
        {
            try
            {
                s = createLong(s4);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return createBigInteger(s4);
            }
            return s;
        } else
        {
            throw new NumberFormatException((new StringBuilder()).append(s).append(" is not a valid number.").toString());
        }
_L7:
        obj1 = createFloat(s4);
        if (((Float) (obj1)).isInfinite())
        {
            break; /* Loop/switch isn't completed */
        }
        f = ((Float) (obj1)).floatValue();
        obj = obj1;
        if (f != 0.0F) goto _L1; else goto _L9
_L9:
        obj = obj1;
        if (i != 0) goto _L1; else goto _L10
_L10:
        obj1 = createDouble(s4);
        if (((Double) (obj1)).isInfinite())
        {
            break; /* Loop/switch isn't completed */
        }
        f = ((Double) (obj1)).floatValue();
        obj = obj1;
        if ((double)f != 0.0D) goto _L1; else goto _L11
_L11:
        obj = obj1;
        if (i != 0) goto _L1; else goto _L12
_L12:
        obj = createBigDecimal(s4);
        return ((Number) (obj));
_L4:
        String s3 = obj2;
        if (j > -1)
        {
            s3 = obj2;
            if (j < s.length() - 1)
            {
                s3 = s.substring(j + 1, s.length());
            }
        }
        if (obj == null && s3 == null)
        {
            try
            {
                obj = createInteger(s);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                try
                {
                    obj = createLong(s);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    return createBigInteger(s);
                }
                return ((Number) (obj));
            }
            return ((Number) (obj));
        }
        j = k;
        if (isAllZeros(((String) (obj1))))
        {
            j = k;
            if (isAllZeros(s3))
            {
                j = 1;
            }
        }
        if (i > 7)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = createFloat(s);
        if (((Float) (obj1)).isInfinite())
        {
            break; /* Loop/switch isn't completed */
        }
        f = ((Float) (obj1)).floatValue();
        obj = obj1;
        if (f != 0.0F) goto _L1; else goto _L13
_L13:
        obj = obj1;
        if (j != 0) goto _L1; else goto _L14
_L14:
        if (i > 16)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = createDouble(s);
        if (((Double) (obj1)).isInfinite())
        {
            break; /* Loop/switch isn't completed */
        }
        d = ((Double) (obj1)).doubleValue();
        obj = obj1;
        if (d != 0.0D) goto _L1; else goto _L15
_L15:
        obj = obj1;
        if (j != 0) goto _L1; else goto _L16
_L16:
        return createBigDecimal(s);
        numberformatexception;
          goto _L5
        numberformatexception;
          goto _L16
        numberformatexception;
          goto _L14
        numberformatexception;
          goto _L12
        numberformatexception;
          goto _L10
_L2:
        if (StringUtils.isBlank(s))
        {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        obj = new String[6];
        obj[0] = "0x";
        obj[1] = "0X";
        obj[2] = "-0x";
        obj[3] = "-0X";
        obj[4] = "#";
        obj[5] = "-#";
        int l = obj.length;
        double d;
        float f;
        NumberFormatException numberformatexception;
        Object obj1;
        String s2;
        int i;
        for (i = 0; i < l; i++)
        {
            String s1 = obj[i];
            if (s.startsWith(s1))
            {
                i = s1.length() + 0;
                break MISSING_BLOCK_LABEL_122;
            }
        }

        i = 0;
          goto _L17
    }

    private static boolean isAllZeros(String s)
    {
        if (s != null)
        {
            for (int i = s.length() - 1; i >= 0; i--)
            {
                if (s.charAt(i) != '0')
                {
                    return false;
                }
            }

            if (s.length() <= 0)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isDigits(String s)
    {
        if (!StringUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= s.length())
                {
                    break label1;
                }
                if (!Character.isDigit(s.charAt(i)))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static boolean isNumber(String s)
    {
        boolean flag5;
        boolean flag6;
        flag6 = true;
        flag5 = true;
        if (!StringUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        boolean flag;
        int j;
        boolean flag1;
        boolean flag2;
        int k;
        boolean flag4;
        s = s.toCharArray();
        j = s.length;
        int i;
        if (s[0] == '-')
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (j > i + 1 && s[i] == '0')
        {
            if (s[i + 1] == 'x' || s[i + 1] == 'X')
            {
                i += 2;
                if (i == j)
                {
                    continue; /* Loop/switch isn't completed */
                }
                for (; i < s.length; i++)
                {
                    if ((s[i] < '0' || s[i] > '9') && (s[i] < 'a' || s[i] > 'f') && (s[i] < 'A' || s[i] > 'F'))
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }

                return true;
            }
            if (Character.isDigit(s[i + 1]))
            {
                for (i++; i < s.length; i++)
                {
                    if (s[i] < '0' || s[i] > '7')
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                }

                return true;
            }
        }
        k = j - 1;
        boolean flag3 = false;
        flag1 = false;
        flag2 = false;
        flag4 = false;
        j = i;
        flag = flag3;
_L3:
        if (j >= k && (j >= k + 1 || !flag || flag4))
        {
            break MISSING_BLOCK_LABEL_347;
        }
        if (s[j] >= '0' && s[j] <= '9')
        {
            flag4 = true;
            flag = false;
        } else
        if (s[j] == '.')
        {
            if (flag1 || flag2)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag1 = true;
        } else
        {
            if (s[j] != 'e' && s[j] != 'E')
            {
                continue; /* Loop/switch isn't completed */
            }
            if (flag2 || !flag4)
            {
                continue; /* Loop/switch isn't completed */
            }
            flag = true;
            flag2 = true;
        }
_L5:
        j++;
          goto _L3
        if (s[j] != '+' && s[j] != '-' || !flag) goto _L1; else goto _L4
_L4:
        flag4 = false;
        flag = false;
          goto _L5
        if (j < s.length)
        {
            if (s[j] >= '0' && s[j] <= '9')
            {
                return true;
            }
            if (s[j] != 'e' && s[j] != 'E')
            {
                if (s[j] == '.')
                {
                    if (!flag1 && !flag2)
                    {
                        return flag4;
                    }
                } else
                {
                    if (!flag && (s[j] == 'd' || s[j] == 'D' || s[j] == 'f' || s[j] == 'F'))
                    {
                        return flag4;
                    }
                    if (s[j] == 'l' || s[j] == 'L')
                    {
                        if (flag4 && !flag2 && !flag1)
                        {
                            flag4 = flag5;
                        } else
                        {
                            flag4 = false;
                        }
                        return flag4;
                    }
                }
            }
        } else
        {
            if (!flag && flag4)
            {
                flag4 = flag6;
            } else
            {
                flag4 = false;
            }
            return flag4;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public static byte max(byte byte0, byte byte1, byte byte2)
    {
        if (byte1 <= byte0)
        {
            byte1 = byte0;
        }
        if (byte2 > byte1)
        {
            return byte2;
        } else
        {
            return byte1;
        }
    }

    public static byte max(byte abyte0[])
    {
        validateArray(abyte0);
        byte byte0 = abyte0[0];
        for (int i = 1; i < abyte0.length;)
        {
            byte byte1 = byte0;
            if (abyte0[i] > byte0)
            {
                byte1 = abyte0[i];
            }
            i++;
            byte0 = byte1;
        }

        return byte0;
    }

    public static double max(double d, double d1, double d2)
    {
        return Math.max(Math.max(d, d1), d2);
    }

    public static double max(double ad[])
    {
        validateArray(ad);
        double d = ad[0];
        int i = 1;
        do
        {
label0:
            {
                double d1 = d;
                if (i < ad.length)
                {
                    if (!Double.isNaN(ad[i]))
                    {
                        break label0;
                    }
                    d1 = (0.0D / 0.0D);
                }
                return d1;
            }
            double d2 = d;
            if (ad[i] > d)
            {
                d2 = ad[i];
            }
            i++;
            d = d2;
        } while (true);
    }

    public static float max(float f, float f1, float f2)
    {
        return Math.max(Math.max(f, f1), f2);
    }

    public static float max(float af[])
    {
        validateArray(af);
        float f = af[0];
        int i = 1;
        do
        {
label0:
            {
                float f1 = f;
                if (i < af.length)
                {
                    if (!Float.isNaN(af[i]))
                    {
                        break label0;
                    }
                    f1 = (0.0F / 0.0F);
                }
                return f1;
            }
            float f2 = f;
            if (af[i] > f)
            {
                f2 = af[i];
            }
            i++;
            f = f2;
        } while (true);
    }

    public static int max(int i, int j, int k)
    {
        if (j <= i)
        {
            j = i;
        }
        if (k > j)
        {
            return k;
        } else
        {
            return j;
        }
    }

    public static int max(int ai[])
    {
        validateArray(ai);
        int j = ai[0];
        for (int i = 1; i < ai.length;)
        {
            int k = j;
            if (ai[i] > j)
            {
                k = ai[i];
            }
            i++;
            j = k;
        }

        return j;
    }

    public static long max(long l, long l1, long l2)
    {
        if (l1 <= l)
        {
            l1 = l;
        }
        if (l2 > l1)
        {
            return l2;
        } else
        {
            return l1;
        }
    }

    public static long max(long al[])
    {
        validateArray(al);
        long l = al[0];
        for (int i = 1; i < al.length;)
        {
            long l1 = l;
            if (al[i] > l)
            {
                l1 = al[i];
            }
            i++;
            l = l1;
        }

        return l;
    }

    public static short max(short word0, short word1, short word2)
    {
        if (word1 <= word0)
        {
            word1 = word0;
        }
        if (word2 > word1)
        {
            return word2;
        } else
        {
            return word1;
        }
    }

    public static short max(short aword0[])
    {
        validateArray(aword0);
        short word0 = aword0[0];
        for (int i = 1; i < aword0.length;)
        {
            short word1 = word0;
            if (aword0[i] > word0)
            {
                word1 = aword0[i];
            }
            i++;
            word0 = word1;
        }

        return word0;
    }

    public static byte min(byte byte0, byte byte1, byte byte2)
    {
        if (byte1 >= byte0)
        {
            byte1 = byte0;
        }
        if (byte2 < byte1)
        {
            return byte2;
        } else
        {
            return byte1;
        }
    }

    public static byte min(byte abyte0[])
    {
        validateArray(abyte0);
        byte byte0 = abyte0[0];
        for (int i = 1; i < abyte0.length;)
        {
            byte byte1 = byte0;
            if (abyte0[i] < byte0)
            {
                byte1 = abyte0[i];
            }
            i++;
            byte0 = byte1;
        }

        return byte0;
    }

    public static double min(double d, double d1, double d2)
    {
        return Math.min(Math.min(d, d1), d2);
    }

    public static double min(double ad[])
    {
        validateArray(ad);
        double d = ad[0];
        int i = 1;
        do
        {
label0:
            {
                double d1 = d;
                if (i < ad.length)
                {
                    if (!Double.isNaN(ad[i]))
                    {
                        break label0;
                    }
                    d1 = (0.0D / 0.0D);
                }
                return d1;
            }
            double d2 = d;
            if (ad[i] < d)
            {
                d2 = ad[i];
            }
            i++;
            d = d2;
        } while (true);
    }

    public static float min(float f, float f1, float f2)
    {
        return Math.min(Math.min(f, f1), f2);
    }

    public static float min(float af[])
    {
        validateArray(af);
        float f = af[0];
        int i = 1;
        do
        {
label0:
            {
                float f1 = f;
                if (i < af.length)
                {
                    if (!Float.isNaN(af[i]))
                    {
                        break label0;
                    }
                    f1 = (0.0F / 0.0F);
                }
                return f1;
            }
            float f2 = f;
            if (af[i] < f)
            {
                f2 = af[i];
            }
            i++;
            f = f2;
        } while (true);
    }

    public static int min(int i, int j, int k)
    {
        if (j >= i)
        {
            j = i;
        }
        if (k < j)
        {
            return k;
        } else
        {
            return j;
        }
    }

    public static int min(int ai[])
    {
        validateArray(ai);
        int j = ai[0];
        for (int i = 1; i < ai.length;)
        {
            int k = j;
            if (ai[i] < j)
            {
                k = ai[i];
            }
            i++;
            j = k;
        }

        return j;
    }

    public static long min(long l, long l1, long l2)
    {
        if (l1 >= l)
        {
            l1 = l;
        }
        if (l2 < l1)
        {
            return l2;
        } else
        {
            return l1;
        }
    }

    public static long min(long al[])
    {
        validateArray(al);
        long l = al[0];
        for (int i = 1; i < al.length;)
        {
            long l1 = l;
            if (al[i] < l)
            {
                l1 = al[i];
            }
            i++;
            l = l1;
        }

        return l;
    }

    public static short min(short word0, short word1, short word2)
    {
        if (word1 >= word0)
        {
            word1 = word0;
        }
        if (word2 < word1)
        {
            return word2;
        } else
        {
            return word1;
        }
    }

    public static short min(short aword0[])
    {
        validateArray(aword0);
        short word0 = aword0[0];
        for (int i = 1; i < aword0.length;)
        {
            short word1 = word0;
            if (aword0[i] < word0)
            {
                word1 = aword0[i];
            }
            i++;
            word0 = word1;
        }

        return word0;
    }

    public static byte toByte(String s)
    {
        return toByte(s, (byte)0);
    }

    public static byte toByte(String s, byte byte0)
    {
        if (s == null)
        {
            return byte0;
        }
        byte byte1;
        try
        {
            byte1 = Byte.parseByte(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return byte0;
        }
        return byte1;
    }

    public static double toDouble(String s)
    {
        return toDouble(s, 0.0D);
    }

    public static double toDouble(String s, double d)
    {
        if (s == null)
        {
            return d;
        }
        double d1;
        try
        {
            d1 = Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return d;
        }
        return d1;
    }

    public static float toFloat(String s)
    {
        return toFloat(s, 0.0F);
    }

    public static float toFloat(String s, float f)
    {
        if (s == null)
        {
            return f;
        }
        float f1;
        try
        {
            f1 = Float.parseFloat(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return f;
        }
        return f1;
    }

    public static int toInt(String s)
    {
        return toInt(s, 0);
    }

    public static int toInt(String s, int i)
    {
        if (s == null)
        {
            return i;
        }
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
    }

    public static long toLong(String s)
    {
        return toLong(s, 0L);
    }

    public static long toLong(String s, long l)
    {
        if (s == null)
        {
            return l;
        }
        long l1;
        try
        {
            l1 = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return l;
        }
        return l1;
    }

    public static short toShort(String s)
    {
        return toShort(s, (short)0);
    }

    public static short toShort(String s, short word0)
    {
        if (s == null)
        {
            return word0;
        }
        short word1;
        try
        {
            word1 = Short.parseShort(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return word0;
        }
        return word1;
    }

    private static void validateArray(Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (Array.getLength(obj) == 0)
        {
            throw new IllegalArgumentException("Array cannot be empty.");
        } else
        {
            return;
        }
    }

}
