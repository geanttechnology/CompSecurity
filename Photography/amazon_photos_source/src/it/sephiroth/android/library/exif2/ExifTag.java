// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

// Referenced classes of package it.sephiroth.android.library.exif2:
//            Rational

public class ExifTag
{

    private static final long LONG_MAX = 0x7fffffffL;
    private static final long LONG_MIN = 0xffffffff80000000L;
    static final int SIZE_UNDEFINED = 0;
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("yyyy:MM:dd kk:mm:ss");
    public static final short TYPE_ASCII = 2;
    public static final short TYPE_LONG = 9;
    public static final short TYPE_RATIONAL = 10;
    private static final int TYPE_TO_SIZE_MAP[];
    public static final short TYPE_UNDEFINED = 7;
    public static final short TYPE_UNSIGNED_BYTE = 1;
    public static final short TYPE_UNSIGNED_LONG = 4;
    public static final short TYPE_UNSIGNED_RATIONAL = 5;
    public static final short TYPE_UNSIGNED_SHORT = 3;
    private static final long UNSIGNED_LONG_MAX = 0xffffffffL;
    private static final int UNSIGNED_SHORT_MAX = 65535;
    private static Charset US_ASCII = Charset.forName("US-ASCII");
    private int mComponentCountActual;
    private final short mDataType;
    private boolean mHasDefinedDefaultComponentCount;
    private int mIfd;
    private int mOffset;
    private final short mTagId;
    private Object mValue;

    ExifTag(short word0, short word1, int i, int j, boolean flag)
    {
        mTagId = word0;
        mDataType = word1;
        mComponentCountActual = i;
        mHasDefinedDefaultComponentCount = flag;
        mIfd = j;
        mValue = null;
    }

    private boolean checkBadComponentCount(int i)
    {
        return mHasDefinedDefaultComponentCount && mComponentCountActual != i;
    }

    private boolean checkOverflowForRational(Rational arational[])
    {
        int j = arational.length;
        for (int i = 0; i < j; i++)
        {
            Rational rational = arational[i];
            if (rational.getNumerator() < 0xffffffff80000000L || rational.getDenominator() < 0xffffffff80000000L || rational.getNumerator() > 0x7fffffffL || rational.getDenominator() > 0x7fffffffL)
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkOverflowForUnsignedLong(int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            if (ai[i] < 0)
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkOverflowForUnsignedLong(long al[])
    {
        int j = al.length;
        for (int i = 0; i < j; i++)
        {
            long l = al[i];
            if (l < 0L || l > 0xffffffffL)
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkOverflowForUnsignedRational(Rational arational[])
    {
        int j = arational.length;
        for (int i = 0; i < j; i++)
        {
            Rational rational = arational[i];
            if (rational.getNumerator() < 0L || rational.getDenominator() < 0L || rational.getNumerator() > 0xffffffffL || rational.getDenominator() > 0xffffffffL)
            {
                return true;
            }
        }

        return false;
    }

    private boolean checkOverflowForUnsignedShort(int ai[])
    {
        int j = ai.length;
        for (int i = 0; i < j; i++)
        {
            int k = ai[i];
            if (k > 65535 || k < 0)
            {
                return true;
            }
        }

        return false;
    }

    private static String convertTypeToString(short word0)
    {
        switch (word0)
        {
        case 6: // '\006'
        case 8: // '\b'
        default:
            return "";

        case 1: // '\001'
            return "UNSIGNED_BYTE";

        case 2: // '\002'
            return "ASCII";

        case 3: // '\003'
            return "UNSIGNED_SHORT";

        case 4: // '\004'
            return "UNSIGNED_LONG";

        case 5: // '\005'
            return "UNSIGNED_RATIONAL";

        case 7: // '\007'
            return "UNDEFINED";

        case 9: // '\t'
            return "LONG";

        case 10: // '\n'
            return "RATIONAL";
        }
    }

    public static int getElementSize(short word0)
    {
        return TYPE_TO_SIZE_MAP[word0];
    }

    public static boolean isValidIfd(int i)
    {
        return i == 0 || i == 1 || i == 2 || i == 3 || i == 4;
    }

    public static boolean isValidType(short word0)
    {
        return word0 == 1 || word0 == 2 || word0 == 3 || word0 == 4 || word0 == 5 || word0 == 7 || word0 == 9 || word0 == 10;
    }

    public boolean equals(Object obj)
    {
_L2:
        return false;
        if (obj == null || !(obj instanceof ExifTag)) goto _L2; else goto _L1
_L1:
        obj = (ExifTag)obj;
        if (((ExifTag) (obj)).mTagId != mTagId || ((ExifTag) (obj)).mComponentCountActual != mComponentCountActual || ((ExifTag) (obj)).mDataType != mDataType)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (mValue == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((ExifTag) (obj)).mValue == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(mValue instanceof long[]))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((ExifTag) (obj)).mValue instanceof long[])
        {
            return Arrays.equals((long[])(long[])mValue, (long[])(long[])((ExifTag) (obj)).mValue);
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (!(mValue instanceof Rational[]))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((ExifTag) (obj)).mValue instanceof Rational[])
        {
            return Arrays.equals((Rational[])(Rational[])mValue, (Rational[])(Rational[])((ExifTag) (obj)).mValue);
        }
        if (true) goto _L2; else goto _L4
_L4:
        if (mValue instanceof byte[])
        {
            if (((ExifTag) (obj)).mValue instanceof byte[])
            {
                return Arrays.equals((byte[])(byte[])mValue, (byte[])(byte[])((ExifTag) (obj)).mValue);
            }
        } else
        {
            return mValue.equals(((ExifTag) (obj)).mValue);
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (((ExifTag) (obj)).mValue != null) goto _L2; else goto _L6
_L6:
        return true;
    }

    public long forceGetValueAsLong(long l)
    {
        long al[] = getValueAsLongs();
        long l1;
        if (al != null && al.length >= 1)
        {
            l1 = al[0];
        } else
        {
            Object aobj[] = getValueAsBytes();
            if (aobj != null && aobj.length >= 1)
            {
                return (long)aobj[0];
            }
            aobj = getValueAsRationals();
            l1 = l;
            if (aobj != null)
            {
                l1 = l;
                if (aobj.length >= 1)
                {
                    l1 = l;
                    if (aobj[0].getDenominator() != 0L)
                    {
                        return (long)aobj[0].toDouble();
                    }
                }
            }
        }
        return l1;
    }

    public String forceGetValueAsString()
    {
        if (mValue == null)
        {
            return "";
        }
        if (mValue instanceof byte[])
        {
            if (mDataType == 2)
            {
                return new String((byte[])(byte[])mValue, US_ASCII);
            } else
            {
                return Arrays.toString((byte[])(byte[])mValue);
            }
        }
        if (mValue instanceof long[])
        {
            if (((long[])(long[])mValue).length == 1)
            {
                return String.valueOf(((long[])(long[])mValue)[0]);
            } else
            {
                return Arrays.toString((long[])(long[])mValue);
            }
        }
        if (mValue instanceof Object[])
        {
            if (((Object[])(Object[])mValue).length == 1)
            {
                Object obj = ((Object[])(Object[])mValue)[0];
                if (obj == null)
                {
                    return "";
                } else
                {
                    return obj.toString();
                }
            } else
            {
                return Arrays.toString((Object[])(Object[])mValue);
            }
        } else
        {
            return mValue.toString();
        }
    }

    protected void forceSetComponentCount(int i)
    {
        mComponentCountActual = i;
    }

    protected void getBytes(byte abyte0[])
    {
        getBytes(abyte0, 0, abyte0.length);
    }

    protected void getBytes(byte abyte0[], int i, int j)
    {
        if (mDataType != 7 && mDataType != 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get BYTE value from ").append(convertTypeToString(mDataType)).toString());
        }
        Object obj = mValue;
        int k = j;
        if (j > mComponentCountActual)
        {
            k = mComponentCountActual;
        }
        System.arraycopy(obj, 0, abyte0, i, k);
    }

    public int getComponentCount()
    {
        return mComponentCountActual;
    }

    public int getDataSize()
    {
        return getComponentCount() * getElementSize(getDataType());
    }

    public short getDataType()
    {
        return mDataType;
    }

    public int getIfd()
    {
        return mIfd;
    }

    protected int getOffset()
    {
        return mOffset;
    }

    protected Rational getRational(int i)
    {
        if (mDataType != 10 && mDataType != 5)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get RATIONAL value from ").append(convertTypeToString(mDataType)).toString());
        } else
        {
            return ((Rational[])(Rational[])mValue)[i];
        }
    }

    protected String getString()
    {
        if (mDataType != 2)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get ASCII value from ").append(convertTypeToString(mDataType)).toString());
        } else
        {
            return new String((byte[])(byte[])mValue, US_ASCII);
        }
    }

    protected byte[] getStringByte()
    {
        return (byte[])(byte[])mValue;
    }

    public short getTagId()
    {
        return mTagId;
    }

    public Object getValue()
    {
        return mValue;
    }

    public byte getValueAsByte(byte byte0)
    {
        byte abyte0[] = getValueAsBytes();
        if (abyte0 == null || abyte0.length < 1)
        {
            return byte0;
        } else
        {
            return abyte0[0];
        }
    }

    public byte[] getValueAsBytes()
    {
        if (mValue instanceof byte[])
        {
            return (byte[])(byte[])mValue;
        } else
        {
            return null;
        }
    }

    public int getValueAsInt(int i)
    {
        int ai[] = getValueAsInts();
        if (ai == null || ai.length < 1)
        {
            return i;
        } else
        {
            return ai[0];
        }
    }

    public int[] getValueAsInts()
    {
        int ai[];
        ai = null;
        break MISSING_BLOCK_LABEL_2;
_L2:
        do
        {
            return ai;
        } while (mValue == null || !(mValue instanceof long[]));
        long al[] = (long[])(long[])mValue;
        int ai1[] = new int[al.length];
        int i = 0;
        do
        {
            ai = ai1;
            if (i >= al.length)
            {
                continue;
            }
            ai1[i] = (int)al[i];
            i++;
        } while (true);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public long getValueAsLong(long l)
    {
        long al[] = getValueAsLongs();
        if (al == null || al.length < 1)
        {
            return l;
        } else
        {
            return al[0];
        }
    }

    public long[] getValueAsLongs()
    {
        if (mValue instanceof long[])
        {
            return (long[])(long[])mValue;
        } else
        {
            return null;
        }
    }

    public Rational getValueAsRational(long l)
    {
        return getValueAsRational(new Rational(l, 1L));
    }

    public Rational getValueAsRational(Rational rational)
    {
        Rational arational[] = getValueAsRationals();
        if (arational == null || arational.length < 1)
        {
            return rational;
        } else
        {
            return arational[0];
        }
    }

    public Rational[] getValueAsRationals()
    {
        if (mValue instanceof Rational[])
        {
            return (Rational[])(Rational[])mValue;
        } else
        {
            return null;
        }
    }

    public String getValueAsString()
    {
        if (mValue != null)
        {
            if (mValue instanceof String)
            {
                return (String)mValue;
            }
            if (mValue instanceof byte[])
            {
                return new String((byte[])(byte[])mValue, US_ASCII);
            }
        }
        return null;
    }

    public String getValueAsString(String s)
    {
        String s1 = getValueAsString();
        if (s1 == null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    protected long getValueAt(int i)
    {
        if (mValue instanceof long[])
        {
            return ((long[])(long[])mValue)[i];
        }
        if (mValue instanceof byte[])
        {
            return (long)((byte[])(byte[])mValue)[i];
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot get integer value from ").append(convertTypeToString(mDataType)).toString());
        }
    }

    protected boolean hasDefinedCount()
    {
        return mHasDefinedDefaultComponentCount;
    }

    public boolean hasValue()
    {
        return mValue != null;
    }

    protected void setHasDefinedCount(boolean flag)
    {
        mHasDefinedDefaultComponentCount = flag;
    }

    protected void setIfd(int i)
    {
        mIfd = i;
    }

    protected void setOffset(int i)
    {
        mOffset = i;
    }

    public boolean setTimeValue(long l)
    {
        boolean flag;
        synchronized (TIME_FORMAT)
        {
            flag = setValue(TIME_FORMAT.format(new Date(l)));
        }
        return flag;
        exception;
        simpledateformat;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean setValue(byte byte0)
    {
        return setValue(new byte[] {
            byte0
        });
    }

    public boolean setValue(int i)
    {
        return setValue(new int[] {
            i
        });
    }

    public boolean setValue(long l)
    {
        return setValue(new long[] {
            l
        });
    }

    public boolean setValue(Rational rational)
    {
        return setValue(new Rational[] {
            rational
        });
    }

    public boolean setValue(Object obj)
    {
        if (obj != null)
        {
            if (obj instanceof Short)
            {
                return setValue(((Short)obj).shortValue() & 0xffff);
            }
            if (obj instanceof String)
            {
                return setValue((String)obj);
            }
            if (obj instanceof int[])
            {
                return setValue((int[])(int[])obj);
            }
            if (obj instanceof long[])
            {
                return setValue((long[])(long[])obj);
            }
            if (obj instanceof Rational)
            {
                return setValue((Rational)obj);
            }
            if (obj instanceof Rational[])
            {
                return setValue((Rational[])(Rational[])obj);
            }
            if (obj instanceof byte[])
            {
                return setValue((byte[])(byte[])obj);
            }
            if (obj instanceof Integer)
            {
                return setValue(((Integer)obj).intValue());
            }
            if (obj instanceof Long)
            {
                return setValue(((Long)obj).longValue());
            }
            if (obj instanceof Byte)
            {
                return setValue(((Byte)obj).byteValue());
            }
            if (obj instanceof Short[])
            {
                obj = (Short[])(Short[])obj;
                int ai[] = new int[obj.length];
                int i = 0;
                while (i < obj.length) 
                {
                    int i1;
                    if (obj[i] == null)
                    {
                        i1 = 0;
                    } else
                    {
                        i1 = obj[i].shortValue() & 0xffff;
                    }
                    ai[i] = i1;
                    i++;
                }
                return setValue(ai);
            }
            if (obj instanceof Integer[])
            {
                obj = (Integer[])(Integer[])obj;
                int ai1[] = new int[obj.length];
                int j = 0;
                while (j < obj.length) 
                {
                    int j1;
                    if (obj[j] == null)
                    {
                        j1 = 0;
                    } else
                    {
                        j1 = obj[j].intValue();
                    }
                    ai1[j] = j1;
                    j++;
                }
                return setValue(ai1);
            }
            if (obj instanceof Long[])
            {
                obj = (Long[])(Long[])obj;
                long al[] = new long[obj.length];
                int k = 0;
                while (k < obj.length) 
                {
                    long l1;
                    if (obj[k] == null)
                    {
                        l1 = 0L;
                    } else
                    {
                        l1 = obj[k].longValue();
                    }
                    al[k] = l1;
                    k++;
                }
                return setValue(al);
            }
            if (obj instanceof Byte[])
            {
                obj = (Byte[])(Byte[])obj;
                byte abyte0[] = new byte[obj.length];
                int l = 0;
                while (l < obj.length) 
                {
                    byte byte0;
                    if (obj[l] == null)
                    {
                        byte0 = 0;
                    } else
                    {
                        byte0 = obj[l].byteValue();
                    }
                    abyte0[l] = byte0;
                    l++;
                }
                return setValue(abyte0);
            }
        }
        return false;
    }

    public boolean setValue(String s)
    {
        if (mDataType == 2 || mDataType == 7) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        String s1;
        s = s.getBytes(US_ASCII);
        s1 = s;
        if (s.length <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        int i;
        if (s[s.length - 1] != 0 && mDataType != 7)
        {
            s = Arrays.copyOf(s, s.length + 1);
        }
_L4:
        i = s.length;
        if (!checkBadComponentCount(i))
        {
            mComponentCountActual = i;
            mValue = s;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        s = s1;
        if (mDataType == 2)
        {
            s = s1;
            if (mComponentCountActual == 1)
            {
                s = new byte[1];
                s[0] = 0;
            }
        }
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public boolean setValue(byte abyte0[])
    {
        return setValue(abyte0, 0, abyte0.length);
    }

    public boolean setValue(byte abyte0[], int i, int j)
    {
        while (checkBadComponentCount(j) || mDataType != 1 && mDataType != 7) 
        {
            return false;
        }
        mValue = new byte[j];
        System.arraycopy(abyte0, i, mValue, 0, j);
        mComponentCountActual = j;
        return true;
    }

    public boolean setValue(int ai[])
    {
        while (checkBadComponentCount(ai.length) || mDataType != 3 && mDataType != 9 && mDataType != 4 || mDataType == 3 && checkOverflowForUnsignedShort(ai) || mDataType == 4 && checkOverflowForUnsignedLong(ai)) 
        {
            return false;
        }
        long al[] = new long[ai.length];
        for (int i = 0; i < ai.length; i++)
        {
            al[i] = ai[i];
        }

        mValue = al;
        mComponentCountActual = ai.length;
        return true;
    }

    public boolean setValue(long al[])
    {
        while (checkBadComponentCount(al.length) || mDataType != 4 || checkOverflowForUnsignedLong(al)) 
        {
            return false;
        }
        mValue = al;
        mComponentCountActual = al.length;
        return true;
    }

    public boolean setValue(Rational arational[])
    {
        while (checkBadComponentCount(arational.length) || mDataType != 5 && mDataType != 10 || mDataType == 5 && checkOverflowForUnsignedRational(arational) || mDataType == 10 && checkOverflowForRational(arational)) 
        {
            return false;
        }
        mValue = arational;
        mComponentCountActual = arational.length;
        return true;
    }

    public String toString()
    {
        return (new StringBuilder()).append(String.format("tag id: %04X\n", new Object[] {
            Short.valueOf(mTagId)
        })).append("ifd id: ").append(mIfd).append("\ntype: ").append(convertTypeToString(mDataType)).append("\ncount: ").append(mComponentCountActual).append("\noffset: ").append(mOffset).append("\nvalue: ").append(forceGetValueAsString()).append("\n").toString();
    }

    static 
    {
        TYPE_TO_SIZE_MAP = new int[11];
        TYPE_TO_SIZE_MAP[1] = 1;
        TYPE_TO_SIZE_MAP[2] = 1;
        TYPE_TO_SIZE_MAP[3] = 2;
        TYPE_TO_SIZE_MAP[4] = 4;
        TYPE_TO_SIZE_MAP[5] = 8;
        TYPE_TO_SIZE_MAP[7] = 1;
        TYPE_TO_SIZE_MAP[9] = 4;
        TYPE_TO_SIZE_MAP[10] = 8;
    }
}
