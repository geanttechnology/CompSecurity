// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

// Referenced classes of package android.support.v7:
//            ya, ye

public final class xu
{
    public static class a extends IOException
    {

        a(int i, int j)
        {
            super((new StringBuilder()).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(j).append(").").toString());
        }
    }


    private final ByteBuffer a;

    private xu(ByteBuffer bytebuffer)
    {
        a = bytebuffer;
    }

    private xu(byte abyte0[], int i, int j)
    {
        this(ByteBuffer.wrap(abyte0, i, j));
    }

    private static int a(CharSequence charsequence)
    {
_L2:
        int j;
        int k = i;
        if (j < l)
        {
            k = charsequence.charAt(j);
            if (k < 2048)
            {
                j++;
                i = (127 - k >>> 31) + i;
                continue; /* Loop/switch isn't completed */
            }
            k = i + a(charsequence, j);
        }
        if (k < l)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("UTF-8 length does not fit in int: ").append((long)k + 0x100000000L).toString());
        } else
        {
            return k;
        }
        int l = charsequence.length();
        int i;
        for (i = 0; i < l && charsequence.charAt(i) < '\200'; i++) { }
        j = i;
        i = l;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static int a(CharSequence charsequence, int i)
    {
        int i1 = charsequence.length();
        int j = 0;
        while (i < i1) 
        {
            char c1 = charsequence.charAt(i);
            int k;
            if (c1 < '\u0800')
            {
                j += 127 - c1 >>> 31;
                k = i;
            } else
            {
                int l = j + 2;
                k = i;
                j = l;
                if ('\uD800' <= c1)
                {
                    k = i;
                    j = l;
                    if (c1 <= '\uDFFF')
                    {
                        if (Character.codePointAt(charsequence, i) < 0x10000)
                        {
                            throw new IllegalArgumentException((new StringBuilder()).append("Unpaired surrogate at index ").append(i).toString());
                        }
                        k = i + 1;
                        j = l;
                    }
                }
            }
            i = k + 1;
        }
        return j;
    }

    private static int a(CharSequence charsequence, byte abyte0[], int i, int j)
    {
        int l1;
        int i2;
        l1 = charsequence.length();
        boolean flag = false;
        i2 = i + j;
        j = ((flag) ? 1 : 0);
        do
        {
            if (j >= l1 || j + i >= i2)
            {
                break;
            }
            char c3 = charsequence.charAt(j);
            if (c3 >= '\200')
            {
                break;
            }
            abyte0[i + j] = (byte)c3;
            j++;
        } while (true);
        if (j == l1)
        {
            return i + l1;
        }
        i += j;
_L2:
        char c1;
        if (j >= l1)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        c1 = charsequence.charAt(j);
        if (c1 >= '\200' || i >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = i + 1;
        abyte0[i] = (byte)c1;
        i = k;
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (c1 < '\u0800' && i <= i2 - 2)
        {
            int l = i + 1;
            abyte0[i] = (byte)(c1 >>> 6 | 0x3c0);
            i = l + 1;
            abyte0[l] = (byte)(c1 & 0x3f | 0x80);
        } else
        if ((c1 < '\uD800' || '\uDFFF' < c1) && i <= i2 - 3)
        {
            int i1 = i + 1;
            abyte0[i] = (byte)(c1 >>> 12 | 0x1e0);
            int j2 = i1 + 1;
            abyte0[i1] = (byte)(c1 >>> 6 & 0x3f | 0x80);
            i = j2 + 1;
            abyte0[j2] = (byte)(c1 & 0x3f | 0x80);
        } else
        {
label0:
            {
                char c2;
label1:
                {
                    if (i > i2 - 4)
                    {
                        break label0;
                    }
                    int j1 = j;
                    if (j + 1 != charsequence.length())
                    {
                        j++;
                        c2 = charsequence.charAt(j);
                        if (Character.isSurrogatePair(c1, c2))
                        {
                            break label1;
                        }
                        j1 = j;
                    }
                    throw new IllegalArgumentException((new StringBuilder()).append("Unpaired surrogate at index ").append(j1 - 1).toString());
                }
                int k1 = Character.toCodePoint(c1, c2);
                int k2 = i + 1;
                abyte0[i] = (byte)(k1 >>> 18 | 0xf0);
                i = k2 + 1;
                abyte0[k2] = (byte)(k1 >>> 12 & 0x3f | 0x80);
                k2 = i + 1;
                abyte0[i] = (byte)(k1 >>> 6 & 0x3f | 0x80);
                i = k2 + 1;
                abyte0[k2] = (byte)(k1 & 0x3f | 0x80);
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Failed writing ").append(c1).append(" at index ").append(i).toString());
        return i;
    }

    public static xu a(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public static xu a(byte abyte0[], int i, int j)
    {
        return new xu(abyte0, i, j);
    }

    private static void a(CharSequence charsequence, ByteBuffer bytebuffer)
    {
        if (bytebuffer.isReadOnly())
        {
            throw new ReadOnlyBufferException();
        }
        if (bytebuffer.hasArray())
        {
            try
            {
                bytebuffer.position(a(charsequence, bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer.remaining()) - bytebuffer.arrayOffset());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                bytebuffer = new BufferOverflowException();
            }
            bytebuffer.initCause(charsequence);
            throw bytebuffer;
        } else
        {
            b(charsequence, bytebuffer);
            return;
        }
    }

    public static int b(float f1)
    {
        return 4;
    }

    public static int b(int i)
    {
        if (i >= 0)
        {
            return f(i);
        } else
        {
            return 10;
        }
    }

    public static int b(int i, float f1)
    {
        return d(i) + b(f1);
    }

    public static int b(int i, int j)
    {
        return d(i) + b(j);
    }

    public static int b(int i, long l)
    {
        return d(i) + b(l);
    }

    public static int b(int i, ya ya1)
    {
        return d(i) * 2 + c(ya1);
    }

    public static int b(int i, String s)
    {
        return d(i) + b(s);
    }

    public static int b(int i, boolean flag)
    {
        return d(i) + b(flag);
    }

    public static int b(long l)
    {
        return d(l);
    }

    public static int b(String s)
    {
        int i = a(s);
        return i + f(i);
    }

    public static int b(boolean flag)
    {
        return 1;
    }

    private static void b(CharSequence charsequence, ByteBuffer bytebuffer)
    {
        int i;
        int l;
        l = charsequence.length();
        i = 0;
_L2:
        char c1;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        c1 = charsequence.charAt(i);
        if (c1 >= '\200')
        {
            break; /* Loop/switch isn't completed */
        }
        bytebuffer.put((byte)c1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (c1 < '\u0800')
        {
            bytebuffer.put((byte)(c1 >>> 6 | 0x3c0));
            bytebuffer.put((byte)(c1 & 0x3f | 0x80));
        } else
        if (c1 < '\uD800' || '\uDFFF' < c1)
        {
            bytebuffer.put((byte)(c1 >>> 12 | 0x1e0));
            bytebuffer.put((byte)(c1 >>> 6 & 0x3f | 0x80));
            bytebuffer.put((byte)(c1 & 0x3f | 0x80));
        } else
        {
            char c2;
label0:
            {
                int j = i;
                if (i + 1 != charsequence.length())
                {
                    i++;
                    c2 = charsequence.charAt(i);
                    if (Character.isSurrogatePair(c1, c2))
                    {
                        break label0;
                    }
                    j = i;
                }
                throw new IllegalArgumentException((new StringBuilder()).append("Unpaired surrogate at index ").append(j - 1).toString());
            }
            int k = Character.toCodePoint(c1, c2);
            bytebuffer.put((byte)(k >>> 18 | 0xf0));
            bytebuffer.put((byte)(k >>> 12 & 0x3f | 0x80));
            bytebuffer.put((byte)(k >>> 6 & 0x3f | 0x80));
            bytebuffer.put((byte)(k & 0x3f | 0x80));
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static int c(int i, ya ya1)
    {
        return d(i) + d(ya1);
    }

    public static int c(ya ya1)
    {
        return ya1.h();
    }

    public static int d(int i)
    {
        return f(ye.a(i, 0));
    }

    public static int d(long l)
    {
        if ((-128L & l) == 0L)
        {
            return 1;
        }
        if ((-16384L & l) == 0L)
        {
            return 2;
        }
        if ((0xffffffffffe00000L & l) == 0L)
        {
            return 3;
        }
        if ((0xfffffffff0000000L & l) == 0L)
        {
            return 4;
        }
        if ((0xfffffff800000000L & l) == 0L)
        {
            return 5;
        }
        if ((0xfffffc0000000000L & l) == 0L)
        {
            return 6;
        }
        if ((0xfffe000000000000L & l) == 0L)
        {
            return 7;
        }
        if ((0xff00000000000000L & l) == 0L)
        {
            return 8;
        }
        return (0x8000000000000000L & l) != 0L ? 10 : 9;
    }

    public static int d(ya ya1)
    {
        int i = ya1.h();
        return i + f(i);
    }

    public static int f(int i)
    {
        if ((i & 0xffffff80) == 0)
        {
            return 1;
        }
        if ((i & 0xffffc000) == 0)
        {
            return 2;
        }
        if ((0xffe00000 & i) == 0)
        {
            return 3;
        }
        return (0xf0000000 & i) != 0 ? 5 : 4;
    }

    public int a()
    {
        return a.remaining();
    }

    public void a(byte byte0)
        throws IOException
    {
        if (!a.hasRemaining())
        {
            throw new a(a.position(), a.limit());
        } else
        {
            a.put(byte0);
            return;
        }
    }

    public void a(float f1)
        throws IOException
    {
        g(Float.floatToIntBits(f1));
    }

    public void a(int i)
        throws IOException
    {
        if (i >= 0)
        {
            e(i);
            return;
        } else
        {
            c(i);
            return;
        }
    }

    public void a(int i, float f1)
        throws IOException
    {
        c(i, 5);
        a(f1);
    }

    public void a(int i, int j)
        throws IOException
    {
        c(i, 0);
        a(j);
    }

    public void a(int i, long l)
        throws IOException
    {
        c(i, 0);
        a(l);
    }

    public void a(int i, ya ya1)
        throws IOException
    {
        c(i, 2);
        b(ya1);
    }

    public void a(int i, String s)
        throws IOException
    {
        c(i, 2);
        a(s);
    }

    public void a(int i, boolean flag)
        throws IOException
    {
        c(i, 0);
        a(flag);
    }

    public void a(long l)
        throws IOException
    {
        c(l);
    }

    public void a(ya ya1)
        throws IOException
    {
        ya1.a(this);
    }

    public void a(String s)
        throws IOException
    {
        try
        {
            int i = f(s.length());
            if (i == f(s.length() * 3))
            {
                int j = a.position();
                a.position(j + i);
                a(((CharSequence) (s)), a);
                int k = a.position();
                a.position(j);
                e(k - j - i);
                a.position(k);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new a(a.position(), a.limit());
        }
        e(a(((CharSequence) (s))));
        a(((CharSequence) (s)), a);
        return;
    }

    public void a(boolean flag)
        throws IOException
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        c(i);
    }

    public void b(ya ya1)
        throws IOException
    {
        e(ya1.g());
        ya1.a(this);
    }

    public void b(byte abyte0[])
        throws IOException
    {
        b(abyte0, 0, abyte0.length);
    }

    public void b(byte abyte0[], int i, int j)
        throws IOException
    {
        if (a.remaining() >= j)
        {
            a.put(abyte0, i, j);
            return;
        } else
        {
            throw new a(a.position(), a.limit());
        }
    }

    public void c(int i)
        throws IOException
    {
        a((byte)i);
    }

    public void c(int i, int j)
        throws IOException
    {
        e(ye.a(i, j));
    }

    public void c(long l)
        throws IOException
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                c((int)l);
                return;
            }
            c((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public void e(int i)
        throws IOException
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                c(i);
                return;
            }
            c(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public void g(int i)
        throws IOException
    {
        c(i & 0xff);
        c(i >> 8 & 0xff);
        c(i >> 16 & 0xff);
        c(i >> 24 & 0xff);
    }
}
