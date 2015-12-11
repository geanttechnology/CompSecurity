// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

static class <init> extends BaseEncoding
{

    final  alphabet;
    private transient BaseEncoding lowerCase;
    final Character paddingChar;
    private transient BaseEncoding upperCase;

    int decodeTo(byte abyte0[], CharSequence charsequence)
        throws <init>
    {
        Preconditions.checkNotNull(abyte0);
        charsequence = padding().trimTrailingFrom(charsequence);
        if (!alphabet.ngStartPosition(charsequence.length()))
        {
            int i = charsequence.length();
            throw new it>((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
        }
        int j = 0;
        for (int k = 0; k < charsequence.length(); k += alphabet.k)
        {
            long l2 = 0L;
            int l = 0;
            for (int i1 = 0; i1 < alphabet.k;)
            {
                long l3 = l2 << alphabet.alphabet;
                int k1 = l;
                l2 = l3;
                if (k + i1 < charsequence.length())
                {
                    l2 = l3 | (long)alphabet.alphabet(charsequence.charAt(k + l));
                    k1 = l + 1;
                }
                i1++;
                l = k1;
            }

            int l1 = alphabet.k;
            int i2 = alphabet.alphabet;
            for (int j1 = (alphabet.k - 1) * 8; j1 >= l1 * 8 - i2 * l;)
            {
                abyte0[j] = (byte)(int)(l2 >>> j1 & 255L);
                j1 -= 8;
                j++;
            }

        }

        return j;
    }

    public InputStream decodingStream(final Reader reader)
    {
        Preconditions.checkNotNull(reader);
        return new InputStream() {

            int bitBuffer;
            int bitBufferLength;
            boolean hitPadding;
            final CharMatcher paddingMatcher;
            int readChars;
            final BaseEncoding.StandardBaseEncoding this$0;
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
                                    throw new BaseEncoding.DecodingException((new StringBuilder(32)).append("Invalid input length ").append(i).toString());
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
                            throw new BaseEncoding.DecodingException((new StringBuilder(41)).append("Padding cannot start at index ").append(i).toString());
                        }
                        hitPadding = true;
                    } while (true);
                    if (hitPadding)
                    {
                        i = readChars;
                        throw new BaseEncoding.DecodingException((new StringBuilder(61)).append("Expected padding character but found '").append(c).append("' at index ").append(i).toString());
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
                this$0 = BaseEncoding.StandardBaseEncoding.this;
                reader = reader1;
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
        if (j <= alphabet.k)
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

        int l = alphabet.alphabet;
        for (i = 0; i < j * 8; i += alphabet.alphabet)
        {
            int i1 = (int)(l1 >>> (j + 1) * 8 - l - i);
            int j1 = alphabet.alphabet;
            appendable.append(alphabet.alphabet(i1 & j1));
        }

        if (paddingChar != null)
        {
            for (; i < alphabet.k * 8; i += alphabet.alphabet)
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
        for (int k = 0; k < j; k += alphabet.k)
        {
            encodeChunkTo(appendable, abyte0, i + k, Math.min(alphabet.k, j - k));
        }

    }

    public OutputStream encodingStream(final Writer out)
    {
        Preconditions.checkNotNull(out);
        return new OutputStream() {

            int bitBuffer;
            int bitBufferLength;
            final BaseEncoding.StandardBaseEncoding this$0;
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
                this$0 = BaseEncoding.StandardBaseEncoding.this;
                out = writer;
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
            obj = alphabet.alphabet();
            if (obj == alphabet)
            {
                obj = this;
            } else
            {
                obj = newInstance(((newInstance) (obj)), paddingChar);
            }
            lowerCase = ((BaseEncoding) (obj));
        }
        return ((BaseEncoding) (obj));
    }

    int maxDecodedSize(int i)
    {
        return (int)(((long)alphabet.alphabet * (long)i + 7L) / 8L);
    }

    int maxEncodedSize(int i)
    {
        return alphabet.k * IntMath.divide(i, alphabet.k, RoundingMode.CEILING);
    }

    BaseEncoding newInstance(k k, Character character)
    {
        return new <init>(k, character);
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
        stringbuilder.append(alphabet.alphabet());
        if (8 % alphabet.alphabet != 0)
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
            obj = alphabet.alphabet();
            if (obj == alphabet)
            {
                obj = this;
            } else
            {
                obj = newInstance(((newInstance) (obj)), paddingChar);
            }
            upperCase = ((BaseEncoding) (obj));
        }
        return ((BaseEncoding) (obj));
    }

    public BaseEncoding withPadChar(char c)
    {
        if (8 % alphabet.alphabet == 0 || paddingChar != null && paddingChar.charValue() == c)
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
        return new (this, s, i);
    }

    padding(padding padding1, Character character)
    {
        alphabet = (alphabet)Preconditions.checkNotNull(padding1);
        boolean flag;
        if (character == null || !padding1.alphabet(character.charValue()))
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

    paddingChar(String s, String s1, Character character)
    {
        this(new <init>(s, s1.toCharArray()), character);
    }
}
