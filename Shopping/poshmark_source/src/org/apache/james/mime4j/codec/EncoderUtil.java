// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.codec;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.Locale;
import org.apache.james.mime4j.util.CharsetUtil;

// Referenced classes of package org.apache.james.mime4j.codec:
//            Base64OutputStream

public class EncoderUtil
{
    public static final class Encoding extends Enum
    {

        private static final Encoding $VALUES[];
        public static final Encoding B;
        public static final Encoding Q;

        public static Encoding valueOf(String s)
        {
            return (Encoding)Enum.valueOf(org/apache/james/mime4j/codec/EncoderUtil$Encoding, s);
        }

        public static Encoding[] values()
        {
            return (Encoding[])$VALUES.clone();
        }

        static 
        {
            B = new Encoding("B", 0);
            Q = new Encoding("Q", 1);
            $VALUES = (new Encoding[] {
                B, Q
            });
        }

        private Encoding(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Usage extends Enum
    {

        private static final Usage $VALUES[];
        public static final Usage TEXT_TOKEN;
        public static final Usage WORD_ENTITY;

        public static Usage valueOf(String s)
        {
            return (Usage)Enum.valueOf(org/apache/james/mime4j/codec/EncoderUtil$Usage, s);
        }

        public static Usage[] values()
        {
            return (Usage[])$VALUES.clone();
        }

        static 
        {
            TEXT_TOKEN = new Usage("TEXT_TOKEN", 0);
            WORD_ENTITY = new Usage("WORD_ENTITY", 1);
            $VALUES = (new Usage[] {
                TEXT_TOKEN, WORD_ENTITY
            });
        }

        private Usage(String s, int i)
        {
            super(s, i);
        }
    }


    private static final BitSet ATEXT_CHARS = initChars("()<>@.,;:\\\"[]");
    private static final char BASE64_PAD = 61;
    private static final byte BASE64_TABLE[];
    private static final int ENCODED_WORD_MAX_LENGTH = 75;
    private static final String ENC_WORD_PREFIX = "=?";
    private static final String ENC_WORD_SUFFIX = "?=";
    private static final int MAX_USED_CHARACTERS = 50;
    private static final BitSet Q_REGULAR_CHARS = initChars("=_?");
    private static final BitSet Q_RESTRICTED_CHARS = initChars("=_?\"#$%&'(),.:;<>@[\\]^`{|}~");
    private static final BitSet TOKEN_CHARS = initChars("()<>@,;:\\\"/[]?=");

    private EncoderUtil()
    {
    }

    private static int bEncodedLength(byte abyte0[])
    {
        return ((abyte0.length + 2) / 3) * 4;
    }

    private static Charset determineCharset(String s)
    {
        boolean flag = true;
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            if (c > '\377')
            {
                return CharsetUtil.UTF_8;
            }
            if (c > '\177')
            {
                flag = false;
            }
        }

        if (flag)
        {
            return CharsetUtil.US_ASCII;
        } else
        {
            return CharsetUtil.ISO_8859_1;
        }
    }

    private static Encoding determineEncoding(byte abyte0[], Usage usage)
    {
        if (abyte0.length == 0)
        {
            return Encoding.Q;
        }
        int j;
        if (usage == Usage.TEXT_TOKEN)
        {
            usage = Q_REGULAR_CHARS;
        } else
        {
            usage = Q_RESTRICTED_CHARS;
        }
        j = 0;
        for (int i = 0; i < abyte0.length;)
        {
            int l = abyte0[i] & 0xff;
            int k = j;
            if (l != 32)
            {
                k = j;
                if (!usage.get(l))
                {
                    k = j + 1;
                }
            }
            i++;
            j = k;
        }

        if ((j * 100) / abyte0.length > 30)
        {
            return Encoding.B;
        } else
        {
            return Encoding.Q;
        }
    }

    private static byte[] encode(String s, Charset charset)
    {
        s = charset.encode(s);
        charset = new byte[s.limit()];
        s.get(charset);
        return charset;
    }

    public static String encodeAddressDisplayName(String s)
    {
        if (isAtomPhrase(s))
        {
            return s;
        }
        if (hasToBeEncoded(s, 0))
        {
            return encodeEncodedWord(s, Usage.WORD_ENTITY);
        } else
        {
            return quote(s);
        }
    }

    public static String encodeAddressLocalPart(String s)
    {
        if (isDotAtomText(s))
        {
            return s;
        } else
        {
            return quote(s);
        }
    }

    private static String encodeB(String s, String s1, int i, Charset charset, byte abyte0[])
    {
        int j = bEncodedLength(abyte0);
        if (s.length() + j + "?=".length() <= 75 - i)
        {
            return (new StringBuilder()).append(s).append(encodeB(abyte0)).append("?=").toString();
        } else
        {
            abyte0 = s1.substring(0, s1.length() / 2);
            abyte0 = encodeB(s, ((String) (abyte0)), i, charset, encode(abyte0, charset));
            s1 = s1.substring(s1.length() / 2);
            s = encodeB(s, s1, 0, charset, encode(s1, charset));
            return (new StringBuilder()).append(abyte0).append(" ").append(s).toString();
        }
    }

    public static String encodeB(byte abyte0[])
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        stringbuilder = new StringBuilder();
        i = 0;
        for (j = abyte0.length; i < j - 2; i += 3)
        {
            int k = (abyte0[i] & 0xff) << 16 | (abyte0[i + 1] & 0xff) << 8 | abyte0[i + 2] & 0xff;
            stringbuilder.append((char)BASE64_TABLE[k >> 18 & 0x3f]);
            stringbuilder.append((char)BASE64_TABLE[k >> 12 & 0x3f]);
            stringbuilder.append((char)BASE64_TABLE[k >> 6 & 0x3f]);
            stringbuilder.append((char)BASE64_TABLE[k & 0x3f]);
        }

        if (i != j - 2) goto _L2; else goto _L1
_L1:
        i = (abyte0[i] & 0xff) << 16 | (abyte0[i + 1] & 0xff) << 8;
        stringbuilder.append((char)BASE64_TABLE[i >> 18 & 0x3f]);
        stringbuilder.append((char)BASE64_TABLE[i >> 12 & 0x3f]);
        stringbuilder.append((char)BASE64_TABLE[i >> 6 & 0x3f]);
        stringbuilder.append('=');
_L4:
        return stringbuilder.toString();
_L2:
        if (i == j - 1)
        {
            i = (abyte0[i] & 0xff) << 16;
            stringbuilder.append((char)BASE64_TABLE[i >> 18 & 0x3f]);
            stringbuilder.append((char)BASE64_TABLE[i >> 12 & 0x3f]);
            stringbuilder.append('=');
            stringbuilder.append('=');
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String encodeEncodedWord(String s, Usage usage)
    {
        return encodeEncodedWord(s, usage, 0, null, null);
    }

    public static String encodeEncodedWord(String s, Usage usage, int i)
    {
        return encodeEncodedWord(s, usage, i, null, null);
    }

    public static String encodeEncodedWord(String s, Usage usage, int i, Charset charset, Encoding encoding)
    {
        if (s == null)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > 50)
        {
            throw new IllegalArgumentException();
        }
        Charset charset1 = charset;
        if (charset == null)
        {
            charset1 = determineCharset(s);
        }
        byte abyte0[] = encode(s, charset1);
        charset = encoding;
        if (encoding == null)
        {
            charset = determineEncoding(abyte0, usage);
        }
        if (charset == Encoding.B)
        {
            return encodeB((new StringBuilder()).append("=?").append(charset1.name()).append("?B?").toString(), s, i, charset1, abyte0);
        } else
        {
            return encodeQ((new StringBuilder()).append("=?").append(charset1.name()).append("?Q?").toString(), s, usage, i, charset1, abyte0);
        }
    }

    public static String encodeHeaderParameter(String s, String s1)
    {
        s = s.toLowerCase(Locale.US);
        if (isToken(s1))
        {
            return (new StringBuilder()).append(s).append("=").append(s1).toString();
        } else
        {
            return (new StringBuilder()).append(s).append("=").append(quote(s1)).toString();
        }
    }

    public static String encodeIfNecessary(String s, Usage usage, int i)
    {
        String s1 = s;
        if (hasToBeEncoded(s, i))
        {
            s1 = encodeEncodedWord(s, usage, i);
        }
        return s1;
    }

    private static String encodeQ(String s, String s1, Usage usage, int i, Charset charset, byte abyte0[])
    {
        int j = qEncodedLength(abyte0, usage);
        if (s.length() + j + "?=".length() <= 75 - i)
        {
            return (new StringBuilder()).append(s).append(encodeQ(abyte0, usage)).append("?=").toString();
        } else
        {
            abyte0 = s1.substring(0, s1.length() / 2);
            abyte0 = encodeQ(s, ((String) (abyte0)), usage, i, charset, encode(abyte0, charset));
            s1 = s1.substring(s1.length() / 2);
            s = encodeQ(s, s1, usage, 0, charset, encode(s1, charset));
            return (new StringBuilder()).append(abyte0).append(" ").append(s).toString();
        }
    }

    public static String encodeQ(byte abyte0[], Usage usage)
    {
        StringBuilder stringbuilder;
        int i;
        int j;
        if (usage == Usage.TEXT_TOKEN)
        {
            usage = Q_REGULAR_CHARS;
        } else
        {
            usage = Q_RESTRICTED_CHARS;
        }
        stringbuilder = new StringBuilder();
        j = abyte0.length;
        i = 0;
        while (i < j) 
        {
            int k = abyte0[i] & 0xff;
            if (k == 32)
            {
                stringbuilder.append('_');
            } else
            if (!usage.get(k))
            {
                stringbuilder.append('=');
                stringbuilder.append(hexDigit(k >>> 4));
                stringbuilder.append(hexDigit(k & 0xf));
            } else
            {
                stringbuilder.append((char)k);
            }
            i++;
        }
        return stringbuilder.toString();
    }

    public static boolean hasToBeEncoded(String s, int i)
    {
        int j;
        if (s == null)
        {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i > 50)
        {
            throw new IllegalArgumentException();
        }
        j = 0;
_L2:
        char c;
        if (j >= s.length())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        c = s.charAt(j);
        if (c != '\t' && c != ' ')
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L4:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        for (i++; i > 77 || c < ' ';)
        {
            return true;
        }

        if (c < '\177') goto _L4; else goto _L3
_L3:
        return true;
        return false;
    }

    private static char hexDigit(int i)
    {
        if (i < 10)
        {
            return (char)(i + 48);
        } else
        {
            return (char)((i - 10) + 65);
        }
    }

    private static BitSet initChars(String s)
    {
        BitSet bitset = new BitSet(128);
        for (char c = '!'; c < 127; c++)
        {
            if (s.indexOf(c) == -1)
            {
                bitset.set(c);
            }
        }

        return bitset;
    }

    private static boolean isAtomPhrase(String s)
    {
        int i;
        int j;
        boolean flag;
        flag = false;
        j = s.length();
        i = 0;
_L2:
        char c;
        boolean flag1;
        flag1 = flag;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        c = s.charAt(i);
        if (!ATEXT_CHARS.get(c))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (CharsetUtil.isWhitespace(c)) goto _L4; else goto _L3
_L3:
        flag1 = false;
        return flag1;
    }

    private static boolean isDotAtomText(String s)
    {
        char c;
        int j;
        c = '.';
        j = s.length();
        if (j != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
_L6:
        char c1;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        c1 = s.charAt(i);
        if (c1 != '.') goto _L4; else goto _L3
_L3:
        if (c == 46 || i == j - 1) goto _L1; else goto _L5
_L5:
        c = c1;
        i++;
          goto _L6
_L4:
        if (ATEXT_CHARS.get(c1)) goto _L5; else goto _L7
_L7:
        return false;
        return true;
    }

    public static boolean isToken(String s)
    {
        int j = s.length();
        if (j != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                char c = s.charAt(i);
                if (!TOKEN_CHARS.get(c))
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

    private static int qEncodedLength(byte abyte0[], Usage usage)
    {
        int i;
        int j;
        if (usage == Usage.TEXT_TOKEN)
        {
            usage = Q_REGULAR_CHARS;
        } else
        {
            usage = Q_RESTRICTED_CHARS;
        }
        i = 0;
        j = 0;
        while (j < abyte0.length) 
        {
            int k = abyte0[j] & 0xff;
            if (k == 32)
            {
                i++;
            } else
            if (!usage.get(k))
            {
                i += 3;
            } else
            {
                i++;
            }
            j++;
        }
        return i;
    }

    private static String quote(String s)
    {
        s = s.replaceAll("[\\\\\"]", "\\\\$0");
        return (new StringBuilder()).append("\"").append(s).append("\"").toString();
    }

    static 
    {
        BASE64_TABLE = Base64OutputStream.BASE64_TABLE;
    }
}
