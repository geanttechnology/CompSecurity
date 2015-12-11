// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;

// Referenced classes of package com.google.common.io:
//            CharSource, ByteSource, CharSink, ByteSink

public abstract class BaseEncoding
{
    private static final class Alphabet extends CharMatcher
    {

        final int bitsPerChar;
        final int bytesPerChunk;
        private final char chars[];
        final int charsPerChunk;
        private final byte decodabet[];
        final int mask;
        private final String name;
        private final boolean validPadding[];

        private boolean hasLowerCase()
        {
            boolean flag1 = false;
            char ac[] = chars;
            int j = ac.length;
            int i = 0;
            do
            {
label0:
                {
                    boolean flag = flag1;
                    if (i < j)
                    {
                        if (!Ascii.isLowerCase(ac[i]))
                        {
                            break label0;
                        }
                        flag = true;
                    }
                    return flag;
                }
                i++;
            } while (true);
        }

        private boolean hasUpperCase()
        {
            boolean flag1 = false;
            char ac[] = chars;
            int j = ac.length;
            int i = 0;
            do
            {
label0:
                {
                    boolean flag = flag1;
                    if (i < j)
                    {
                        if (!Ascii.isUpperCase(ac[i]))
                        {
                            break label0;
                        }
                        flag = true;
                    }
                    return flag;
                }
                i++;
            } while (true);
        }

        int decode(char c)
            throws DecodingException
        {
            if (c > '\177' || decodabet[c] == -1)
            {
                Object obj;
                if (CharMatcher.INVISIBLE.matches(c))
                {
                    obj = String.valueOf(Integer.toHexString(c));
                    if (((String) (obj)).length() != 0)
                    {
                        obj = "0x".concat(((String) (obj)));
                    } else
                    {
                        obj = new String("0x");
                    }
                } else
                {
                    obj = Character.valueOf(c);
                }
                obj = String.valueOf(obj);
                throw new DecodingException((new StringBuilder(String.valueOf(obj).length() + 24)).append("Unrecognized character: ").append(((String) (obj))).toString());
            } else
            {
                return decodabet[c];
            }
        }

        char encode(int i)
        {
            return chars[i];
        }

        boolean isValidPaddingStartPosition(int i)
        {
            return validPadding[i % charsPerChunk];
        }

        Alphabet lowerCase()
        {
            if (!hasUpperCase())
            {
                return this;
            }
            char ac[];
            boolean flag;
            if (!hasLowerCase())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "Cannot call lowerCase() on a mixed-case alphabet");
            ac = new char[chars.length];
            for (int i = 0; i < chars.length; i++)
            {
                ac[i] = Ascii.toLowerCase(chars[i]);
            }

            return new Alphabet(String.valueOf(name).concat(".lowerCase()"), ac);
        }

        public boolean matches(char c)
        {
            return CharMatcher.ASCII.matches(c) && decodabet[c] != -1;
        }

        public String toString()
        {
            return name;
        }

        Alphabet upperCase()
        {
            if (!hasLowerCase())
            {
                return this;
            }
            char ac[];
            boolean flag;
            if (!hasUpperCase())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkState(flag, "Cannot call upperCase() on a mixed-case alphabet");
            ac = new char[chars.length];
            for (int i = 0; i < chars.length; i++)
            {
                ac[i] = Ascii.toUpperCase(chars[i]);
            }

            return new Alphabet(String.valueOf(name).concat(".upperCase()"), ac);
        }


        Alphabet(String s, char ac[])
        {
            name = (String)Preconditions.checkNotNull(s);
            chars = (char[])Preconditions.checkNotNull(ac);
            int i;
            try
            {
                bitsPerChar = IntMath.log2(ac.length, RoundingMode.UNNECESSARY);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                int j = ac.length;
                throw new IllegalArgumentException((new StringBuilder(35)).append("Illegal alphabet length ").append(j).toString(), s);
            }
            i = Math.min(8, Integer.lowestOneBit(bitsPerChar));
            charsPerChunk = 8 / i;
            bytesPerChunk = bitsPerChar / i;
            mask = ac.length - 1;
            s = new byte[128];
            Arrays.fill(s, (byte)-1);
            i = 0;
            while (i < ac.length) 
            {
                char c = ac[i];
                Preconditions.checkArgument(CharMatcher.ASCII.matches(c), "Non-ASCII character: %s", new Object[] {
                    Character.valueOf(c)
                });
                boolean flag;
                if (s[c] == -1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                Preconditions.checkArgument(flag, "Duplicate character: %s", new Object[] {
                    Character.valueOf(c)
                });
                s[c] = (byte)i;
                i++;
            }
            decodabet = s;
            s = new boolean[charsPerChunk];
            for (int k = 0; k < bytesPerChunk; k++)
            {
                s[IntMath.divide(k * 8, bitsPerChar, RoundingMode.CEILING)] = 1;
            }

            validPadding = s;
        }
    }

    static final class Base16Encoding extends StandardBaseEncoding
    {

        final char encoding[];

        int decodeTo(byte abyte0[], CharSequence charsequence)
            throws DecodingException
        {
            Preconditions.checkNotNull(abyte0);
            if (charsequence.length() % 2 == 1)
            {
                int i = charsequence.length();
                throw new DecodingException((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
            }
            int j = 0;
            for (int k = 0; k < charsequence.length();)
            {
                abyte0[j] = (byte)(alphabet.decode(charsequence.charAt(k)) << 4 | alphabet.decode(charsequence.charAt(k + 1)));
                k += 2;
                j++;
            }

            return j;
        }

        void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
            throws IOException
        {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
            for (int k = 0; k < j; k++)
            {
                int l = abyte0[i + k] & 0xff;
                appendable.append(encoding[l]);
                appendable.append(encoding[l | 0x100]);
            }

        }

        BaseEncoding newInstance(Alphabet alphabet, Character character)
        {
            return new Base16Encoding(alphabet);
        }

        private Base16Encoding(Alphabet alphabet)
        {
            super(alphabet, null);
            encoding = new char[512];
            boolean flag;
            if (alphabet.chars.length == 16)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            for (int i = 0; i < 256; i++)
            {
                encoding[i] = alphabet.encode(i >>> 4);
                encoding[i | 0x100] = alphabet.encode(i & 0xf);
            }

        }

        Base16Encoding(String s, String s1)
        {
            this(new Alphabet(s, s1.toCharArray()));
        }
    }

    static final class Base64Encoding extends StandardBaseEncoding
    {

        int decodeTo(byte abyte0[], CharSequence charsequence)
            throws DecodingException
        {
            Preconditions.checkNotNull(abyte0);
            charsequence = padding().trimTrailingFrom(charsequence);
            if (!this.alphabet.isValidPaddingStartPosition(charsequence.length()))
            {
                int i = charsequence.length();
                throw new DecodingException((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
            }
            int j = 0;
            int k = 0;
            do
            {
                if (k >= charsequence.length())
                {
                    break;
                }
                Alphabet alphabet = this.alphabet;
                int j1 = k + 1;
                k = alphabet.decode(charsequence.charAt(k));
                alphabet = this.alphabet;
                int l = j1 + 1;
                int l1 = k << 18 | alphabet.decode(charsequence.charAt(j1)) << 12;
                j1 = j + 1;
                abyte0[j] = (byte)(l1 >>> 16);
                j = j1;
                k = l;
                if (l < charsequence.length())
                {
                    Alphabet alphabet1 = this.alphabet;
                    k = l + 1;
                    l1 |= alphabet1.decode(charsequence.charAt(l)) << 6;
                    j = j1 + 1;
                    abyte0[j1] = (byte)(l1 >>> 8 & 0xff);
                    if (k < charsequence.length())
                    {
                        Alphabet alphabet2 = this.alphabet;
                        int i1 = k + 1;
                        k = alphabet2.decode(charsequence.charAt(k));
                        int k1 = j + 1;
                        abyte0[j] = (byte)((l1 | k) & 0xff);
                        k = i1;
                        j = k1;
                    }
                }
            } while (true);
            return j;
        }

        void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
            throws IOException
        {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
            int k = j;
            int l;
            for (l = i; k >= 3; l++)
            {
                int i1 = l + 1;
                byte byte0 = abyte0[l];
                l = i1 + 1;
                i1 = (byte0 & 0xff) << 16 | (abyte0[i1] & 0xff) << 8 | abyte0[l] & 0xff;
                appendable.append(alphabet.encode(i1 >>> 18));
                appendable.append(alphabet.encode(i1 >>> 12 & 0x3f));
                appendable.append(alphabet.encode(i1 >>> 6 & 0x3f));
                appendable.append(alphabet.encode(i1 & 0x3f));
                k -= 3;
            }

            if (l < i + j)
            {
                encodeChunkTo(appendable, abyte0, l, (i + j) - l);
            }
        }

        BaseEncoding newInstance(Alphabet alphabet, Character character)
        {
            return new Base64Encoding(alphabet, character);
        }

        private Base64Encoding(Alphabet alphabet, Character character)
        {
            super(alphabet, character);
            boolean flag;
            if (alphabet.chars.length == 64)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
        }

        Base64Encoding(String s, String s1, Character character)
        {
            this(new Alphabet(s, s1.toCharArray()), character);
        }
    }

    public static final class DecodingException extends IOException
    {

        DecodingException(String s)
        {
            super(s);
        }

        DecodingException(Throwable throwable)
        {
            super(throwable);
        }
    }

    static final class SeparatedBaseEncoding extends BaseEncoding
    {

        private final int afterEveryChars;
        private final BaseEncoding _flddelegate;
        private final String separator;
        private final CharMatcher separatorChars;

        int decodeTo(byte abyte0[], CharSequence charsequence)
            throws DecodingException
        {
            return _flddelegate.decodeTo(abyte0, separatorChars.removeFrom(charsequence));
        }

        public InputStream decodingStream(Reader reader)
        {
            return _flddelegate.decodingStream(ignoringReader(reader, separatorChars));
        }

        void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
            throws IOException
        {
            _flddelegate.encodeTo(separatingAppendable(appendable, separator, afterEveryChars), abyte0, i, j);
        }

        public OutputStream encodingStream(Writer writer)
        {
            return _flddelegate.encodingStream(separatingWriter(writer, separator, afterEveryChars));
        }

        public BaseEncoding lowerCase()
        {
            return _flddelegate.lowerCase().withSeparator(separator, afterEveryChars);
        }

        int maxDecodedSize(int i)
        {
            return _flddelegate.maxDecodedSize(i);
        }

        int maxEncodedSize(int i)
        {
            i = _flddelegate.maxEncodedSize(i);
            return separator.length() * IntMath.divide(Math.max(0, i - 1), afterEveryChars, RoundingMode.FLOOR) + i;
        }

        public BaseEncoding omitPadding()
        {
            return _flddelegate.omitPadding().withSeparator(separator, afterEveryChars);
        }

        CharMatcher padding()
        {
            return _flddelegate.padding();
        }

        public String toString()
        {
            String s = String.valueOf(_flddelegate.toString());
            String s1 = separator;
            int i = afterEveryChars;
            return (new StringBuilder(String.valueOf(s).length() + 31 + String.valueOf(s1).length())).append(s).append(".withSeparator(\"").append(s1).append("\", ").append(i).append(")").toString();
        }

        public BaseEncoding upperCase()
        {
            return _flddelegate.upperCase().withSeparator(separator, afterEveryChars);
        }

        public BaseEncoding withPadChar(char c)
        {
            return _flddelegate.withPadChar(c).withSeparator(separator, afterEveryChars);
        }

        public BaseEncoding withSeparator(String s, int i)
        {
            throw new UnsupportedOperationException("Already have a separator");
        }

        SeparatedBaseEncoding(BaseEncoding baseencoding, String s, int i)
        {
            _flddelegate = (BaseEncoding)Preconditions.checkNotNull(baseencoding);
            separator = (String)Preconditions.checkNotNull(s);
            afterEveryChars = i;
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Cannot add a separator after every %s chars", new Object[] {
                Integer.valueOf(i)
            });
            separatorChars = CharMatcher.anyOf(s).precomputed();
        }
    }

    static class StandardBaseEncoding extends BaseEncoding
    {

        final Alphabet alphabet;
        private transient BaseEncoding lowerCase;
        final Character paddingChar;
        private transient BaseEncoding upperCase;

        int decodeTo(byte abyte0[], CharSequence charsequence)
            throws DecodingException
        {
            Preconditions.checkNotNull(abyte0);
            charsequence = padding().trimTrailingFrom(charsequence);
            if (!alphabet.isValidPaddingStartPosition(charsequence.length()))
            {
                int i = charsequence.length();
                throw new DecodingException((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
            }
            int j = 0;
            for (int k = 0; k < charsequence.length(); k += alphabet.charsPerChunk)
            {
                long l2 = 0L;
                int l = 0;
                for (int i1 = 0; i1 < alphabet.charsPerChunk;)
                {
                    long l3 = l2 << alphabet.bitsPerChar;
                    int k1 = l;
                    l2 = l3;
                    if (k + i1 < charsequence.length())
                    {
                        l2 = l3 | (long)alphabet.decode(charsequence.charAt(k + l));
                        k1 = l + 1;
                    }
                    i1++;
                    l = k1;
                }

                int l1 = alphabet.bytesPerChunk;
                int i2 = alphabet.bitsPerChar;
                for (int j1 = (alphabet.bytesPerChunk - 1) * 8; j1 >= l1 * 8 - i2 * l;)
                {
                    abyte0[j] = (byte)(int)(l2 >>> j1 & 255L);
                    j1 -= 8;
                    j++;
                }

            }

            return j;
        }

        public InputStream decodingStream(Reader reader)
        {
            Preconditions.checkNotNull(reader);
            return reader. new InputStream() {

                int bitBuffer;
                int bitBufferLength;
                boolean hitPadding;
                final CharMatcher paddingMatcher;
                int readChars;
                final StandardBaseEncoding this$0;
                final Reader val$reader;

                public void close()
                    throws IOException
                {
                    reader.close();
                }

                public int read()
                    throws IOException
                {
                    byte byte0 = -1;
                    int i;
label0:
                    do
                    {
                        char c;
                        do
                        {
                            i = reader.read();
                            if (i == -1)
                            {
                                i = byte0;
                                if (!hitPadding)
                                {
                                    i = byte0;
                                    if (!alphabet.isValidPaddingStartPosition(readChars))
                                    {
                                        i = readChars;
                                        throw new DecodingException((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
                                    }
                                }
                                break label0;
                            }
                            readChars = readChars + 1;
                            c = (char)i;
                            if (!paddingMatcher.matches(c))
                            {
                                break;
                            }
                            if (!hitPadding && (readChars == 1 || !alphabet.isValidPaddingStartPosition(readChars - 1)))
                            {
                                i = readChars;
                                throw new DecodingException((new StringBuilder(41)).append("Padding cannot start at index ").append(i).toString());
                            }
                            hitPadding = true;
                        } while (true);
                        if (hitPadding)
                        {
                            i = readChars;
                            throw new DecodingException((new StringBuilder(61)).append("Expected padding character but found '").append(c).append("' at index ").append(i).toString());
                        }
                        bitBuffer = bitBuffer << alphabet.bitsPerChar;
                        bitBuffer = bitBuffer | alphabet.decode(c);
                        bitBufferLength = bitBufferLength + alphabet.bitsPerChar;
                        if (bitBufferLength < 8)
                        {
                            continue;
                        }
                        bitBufferLength = bitBufferLength - 8;
                        i = bitBuffer >> bitBufferLength & 0xff;
                        break;
                    } while (true);
                    return i;
                }

            
            {
                this$0 = final_standardbaseencoding;
                reader = Reader.this;
                super();
                bitBuffer = 0;
                bitBufferLength = 0;
                readChars = 0;
                hitPadding = false;
                paddingMatcher = padding();
            }
            };
        }

        void encodeChunkTo(Appendable appendable, byte abyte0[], int i, int j)
            throws IOException
        {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
            long l1;
            boolean flag;
            if (j <= alphabet.bytesPerChunk)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            l1 = 0L;
            for (int k = 0; k < j; k++)
            {
                l1 = (l1 | (long)(abyte0[i + k] & 0xff)) << 8;
            }

            int l = alphabet.bitsPerChar;
            for (i = 0; i < j * 8; i += alphabet.bitsPerChar)
            {
                int i1 = (int)(l1 >>> (j + 1) * 8 - l - i);
                int j1 = alphabet.mask;
                appendable.append(alphabet.encode(i1 & j1));
            }

            if (paddingChar != null)
            {
                for (; i < alphabet.bytesPerChunk * 8; i += alphabet.bitsPerChar)
                {
                    appendable.append(paddingChar.charValue());
                }

            }
        }

        void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
            throws IOException
        {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
            for (int k = 0; k < j; k += alphabet.bytesPerChunk)
            {
                encodeChunkTo(appendable, abyte0, i + k, Math.min(alphabet.bytesPerChunk, j - k));
            }

        }

        public OutputStream encodingStream(Writer writer)
        {
            Preconditions.checkNotNull(writer);
            return writer. new OutputStream() {

                int bitBuffer;
                int bitBufferLength;
                final StandardBaseEncoding this$0;
                final Writer val$out;
                int writtenChars;

                public void close()
                    throws IOException
                {
                    if (bitBufferLength > 0)
                    {
                        int i = bitBuffer;
                        int j = alphabet.bitsPerChar;
                        int k = bitBufferLength;
                        int l = alphabet.mask;
                        out.write(alphabet.encode(i << j - k & l));
                        writtenChars = writtenChars + 1;
                        if (paddingChar != null)
                        {
                            for (; writtenChars % alphabet.charsPerChunk != 0; writtenChars = writtenChars + 1)
                            {
                                out.write(paddingChar.charValue());
                            }

                        }
                    }
                    out.close();
                }

                public void flush()
                    throws IOException
                {
                    out.flush();
                }

                public void write(int i)
                    throws IOException
                {
                    bitBuffer = bitBuffer << 8;
                    bitBuffer = bitBuffer | i & 0xff;
                    for (bitBufferLength = bitBufferLength + 8; bitBufferLength >= alphabet.bitsPerChar; bitBufferLength = bitBufferLength - alphabet.bitsPerChar)
                    {
                        i = bitBuffer;
                        int j = bitBufferLength;
                        int k = alphabet.bitsPerChar;
                        int l = alphabet.mask;
                        out.write(alphabet.encode(i >> j - k & l));
                        writtenChars = writtenChars + 1;
                    }

                }

            
            {
                this$0 = final_standardbaseencoding;
                out = Writer.this;
                super();
                bitBuffer = 0;
                bitBufferLength = 0;
                writtenChars = 0;
            }
            };
        }

        public BaseEncoding lowerCase()
        {
            BaseEncoding baseencoding = lowerCase;
            Object obj = baseencoding;
            if (baseencoding == null)
            {
                obj = alphabet.lowerCase();
                if (obj == alphabet)
                {
                    obj = this;
                } else
                {
                    obj = newInstance(((Alphabet) (obj)), paddingChar);
                }
                lowerCase = ((BaseEncoding) (obj));
            }
            return ((BaseEncoding) (obj));
        }

        int maxDecodedSize(int i)
        {
            return (int)(((long)alphabet.bitsPerChar * (long)i + 7L) / 8L);
        }

        int maxEncodedSize(int i)
        {
            return alphabet.charsPerChunk * IntMath.divide(i, alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        BaseEncoding newInstance(Alphabet alphabet1, Character character)
        {
            return new StandardBaseEncoding(alphabet1, character);
        }

        public BaseEncoding omitPadding()
        {
            if (paddingChar == null)
            {
                return this;
            } else
            {
                return newInstance(alphabet, null);
            }
        }

        CharMatcher padding()
        {
            if (paddingChar == null)
            {
                return CharMatcher.NONE;
            } else
            {
                return CharMatcher.is(paddingChar.charValue());
            }
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder("BaseEncoding.");
            stringbuilder.append(alphabet.toString());
            if (8 % alphabet.bitsPerChar != 0)
            {
                if (paddingChar == null)
                {
                    stringbuilder.append(".omitPadding()");
                } else
                {
                    stringbuilder.append(".withPadChar(").append(paddingChar).append(')');
                }
            }
            return stringbuilder.toString();
        }

        public BaseEncoding upperCase()
        {
            BaseEncoding baseencoding = upperCase;
            Object obj = baseencoding;
            if (baseencoding == null)
            {
                obj = alphabet.upperCase();
                if (obj == alphabet)
                {
                    obj = this;
                } else
                {
                    obj = newInstance(((Alphabet) (obj)), paddingChar);
                }
                upperCase = ((BaseEncoding) (obj));
            }
            return ((BaseEncoding) (obj));
        }

        public BaseEncoding withPadChar(char c)
        {
            if (8 % alphabet.bitsPerChar == 0 || paddingChar != null && paddingChar.charValue() == c)
            {
                return this;
            } else
            {
                return newInstance(alphabet, Character.valueOf(c));
            }
        }

        public BaseEncoding withSeparator(String s, int i)
        {
            Preconditions.checkArgument(padding().or(alphabet).matchesNoneOf(s), "Separator (%s) cannot contain alphabet or padding characters", new Object[] {
                s
            });
            return new SeparatedBaseEncoding(this, s, i);
        }

        StandardBaseEncoding(Alphabet alphabet1, Character character)
        {
            alphabet = (Alphabet)Preconditions.checkNotNull(alphabet1);
            boolean flag;
            if (character == null || !alphabet1.matches(character.charValue()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "Padding character %s was already in alphabet", new Object[] {
                character
            });
            paddingChar = character;
        }

        StandardBaseEncoding(String s, String s1, Character character)
        {
            this(new Alphabet(s, s1.toCharArray()), character);
        }
    }


    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", Character.valueOf('='));
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", Character.valueOf('='));
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", Character.valueOf('='));
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", Character.valueOf('='));

    BaseEncoding()
    {
    }

    public static BaseEncoding base16()
    {
        return BASE16;
    }

    public static BaseEncoding base32()
    {
        return BASE32;
    }

    public static BaseEncoding base32Hex()
    {
        return BASE32_HEX;
    }

    public static BaseEncoding base64()
    {
        return BASE64;
    }

    public static BaseEncoding base64Url()
    {
        return BASE64_URL;
    }

    private static byte[] extract(byte abyte0[], int i)
    {
        if (i == abyte0.length)
        {
            return abyte0;
        } else
        {
            byte abyte1[] = new byte[i];
            System.arraycopy(abyte0, 0, abyte1, 0, i);
            return abyte1;
        }
    }

    static Reader ignoringReader(Reader reader, CharMatcher charmatcher)
    {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(charmatcher);
        return new Reader(reader, charmatcher) {

            final Reader val$delegate;
            final CharMatcher val$toIgnore;

            public void close()
                throws IOException
            {
                delegate.close();
            }

            public int read()
                throws IOException
            {
                int i;
                do
                {
                    i = delegate.read();
                } while (i != -1 && toIgnore.matches((char)i));
                return i;
            }

            public int read(char ac[], int i, int j)
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            
            {
                delegate = reader;
                toIgnore = charmatcher;
                super();
            }
        };
    }

    static Appendable separatingAppendable(Appendable appendable, String s, int i)
    {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(s);
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
        return new Appendable(i, appendable, s) {

            int charsUntilSeparator;
            final int val$afterEveryChars;
            final Appendable val$delegate;
            final String val$separator;

            public Appendable append(char c)
                throws IOException
            {
                if (charsUntilSeparator == 0)
                {
                    delegate.append(separator);
                    charsUntilSeparator = afterEveryChars;
                }
                delegate.append(c);
                charsUntilSeparator = charsUntilSeparator - 1;
                return this;
            }

            public Appendable append(CharSequence charsequence)
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            public Appendable append(CharSequence charsequence, int j, int k)
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            
            {
                afterEveryChars = i;
                delegate = appendable;
                separator = s;
                super();
                charsUntilSeparator = afterEveryChars;
            }
        };
    }

    static Writer separatingWriter(Writer writer, String s, int i)
    {
        return new Writer(separatingAppendable(writer, s, i), writer) {

            final Writer val$delegate;
            final Appendable val$seperatingAppendable;

            public void close()
                throws IOException
            {
                delegate.close();
            }

            public void flush()
                throws IOException
            {
                delegate.flush();
            }

            public void write(int j)
                throws IOException
            {
                seperatingAppendable.append((char)j);
            }

            public void write(char ac[], int j, int k)
                throws IOException
            {
                throw new UnsupportedOperationException();
            }

            
            {
                seperatingAppendable = appendable;
                delegate = writer;
                super();
            }
        };
    }

    public final byte[] decode(CharSequence charsequence)
    {
        try
        {
            charsequence = decodeChecked(charsequence);
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            throw new IllegalArgumentException(charsequence);
        }
        return charsequence;
    }

    final byte[] decodeChecked(CharSequence charsequence)
        throws DecodingException
    {
        charsequence = padding().trimTrailingFrom(charsequence);
        byte abyte0[] = new byte[maxDecodedSize(charsequence.length())];
        return extract(abyte0, decodeTo(abyte0, charsequence));
    }

    abstract int decodeTo(byte abyte0[], CharSequence charsequence)
        throws DecodingException;

    public final ByteSource decodingSource(final CharSource encodedSource)
    {
        Preconditions.checkNotNull(encodedSource);
        return new ByteSource() {

            final BaseEncoding this$0;
            final CharSource val$encodedSource;

            public InputStream openStream()
                throws IOException
            {
                return decodingStream(encodedSource.openStream());
            }

            
            {
                this$0 = BaseEncoding.this;
                encodedSource = charsource;
                super();
            }
        };
    }

    public abstract InputStream decodingStream(Reader reader);

    public String encode(byte abyte0[])
    {
        return encode(abyte0, 0, abyte0.length);
    }

    public final String encode(byte abyte0[], int i, int j)
    {
        Preconditions.checkPositionIndexes(i, i + j, abyte0.length);
        StringBuilder stringbuilder = new StringBuilder(maxEncodedSize(j));
        try
        {
            encodeTo(stringbuilder, abyte0, i, j);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new AssertionError(abyte0);
        }
        return stringbuilder.toString();
    }

    abstract void encodeTo(Appendable appendable, byte abyte0[], int i, int j)
        throws IOException;

    public final ByteSink encodingSink(final CharSink encodedSink)
    {
        Preconditions.checkNotNull(encodedSink);
        return new ByteSink() {

            final BaseEncoding this$0;
            final CharSink val$encodedSink;

            public OutputStream openStream()
                throws IOException
            {
                return encodingStream(encodedSink.openStream());
            }

            
            {
                this$0 = BaseEncoding.this;
                encodedSink = charsink;
                super();
            }
        };
    }

    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i);

    abstract int maxEncodedSize(int i);

    public abstract BaseEncoding omitPadding();

    abstract CharMatcher padding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String s, int i);

}
