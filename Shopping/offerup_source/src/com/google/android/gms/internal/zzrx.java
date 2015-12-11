// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

// Referenced classes of package com.google.android.gms.internal:
//            zzse, zzsh

public final class zzrx
{

    private final ByteBuffer zzbij;

    private zzrx(ByteBuffer bytebuffer)
    {
        zzbij = bytebuffer;
        zzbij.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzrx(byte abyte0[], int i, int j)
    {
        this(ByteBuffer.wrap(abyte0, i, j));
    }

    public static int zzA(int i, int j)
    {
        return zzlM(i) + zzlJ(j);
    }

    public static int zzB(int i, int j)
    {
        return zzlM(i) + zzlK(j);
    }

    public static zzrx zzC(byte abyte0[])
    {
        return zzb(abyte0, 0, abyte0.length);
    }

    public static int zzE(byte abyte0[])
    {
        return zzlO(abyte0.length) + abyte0.length;
    }

    private static int zza(CharSequence charsequence, int i)
    {
        int i1 = charsequence.length();
        int j = 0;
        while (i < i1) 
        {
            char c = charsequence.charAt(i);
            int k;
            if (c < '\u0800')
            {
                j += 127 - c >>> 31;
                k = i;
            } else
            {
                int l = j + 2;
                j = l;
                k = i;
                if ('\uD800' <= c)
                {
                    j = l;
                    k = i;
                    if (c <= '\uDFFF')
                    {
                        if (Character.codePointAt(charsequence, i) < 0x10000)
                        {
                            throw new IllegalArgumentException((new StringBuilder("Unpaired surrogate at index ")).append(i).toString());
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

    private static int zza(CharSequence charsequence, byte abyte0[], int i, int j)
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
            char c2 = charsequence.charAt(j);
            if (c2 >= '\200')
            {
                break;
            }
            abyte0[i + j] = (byte)c2;
            j++;
        } while (true);
        if (j == l1)
        {
            return i + l1;
        }
        i += j;
_L2:
        char c;
        if (j >= l1)
        {
            break MISSING_BLOCK_LABEL_540;
        }
        c = charsequence.charAt(j);
        if (c >= '\200' || i >= i2)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = i + 1;
        abyte0[i] = (byte)c;
        i = k;
_L3:
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        if (c < '\u0800' && i <= i2 - 2)
        {
            int l = i + 1;
            abyte0[i] = (byte)(c >>> 6 | 0x3c0);
            i = l + 1;
            abyte0[l] = (byte)(c & 0x3f | 0x80);
        } else
        if ((c < '\uD800' || '\uDFFF' < c) && i <= i2 - 3)
        {
            int i1 = i + 1;
            abyte0[i] = (byte)(c >>> 12 | 0x1e0);
            int j2 = i1 + 1;
            abyte0[i1] = (byte)(c >>> 6 & 0x3f | 0x80);
            i = j2 + 1;
            abyte0[j2] = (byte)(c & 0x3f | 0x80);
        } else
        {
label0:
            {
                char c1;
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
                        c1 = charsequence.charAt(j);
                        if (Character.isSurrogatePair(c, c1))
                        {
                            break label1;
                        }
                        j1 = j;
                    }
                    throw new IllegalArgumentException((new StringBuilder("Unpaired surrogate at index ")).append(j1 - 1).toString());
                }
                int k1 = Character.toCodePoint(c, c1);
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
        if ('\uD800' <= c && c <= '\uDFFF' && (j + 1 == charsequence.length() || !Character.isSurrogatePair(c, charsequence.charAt(j + 1))))
        {
            throw new IllegalArgumentException((new StringBuilder("Unpaired surrogate at index ")).append(j).toString());
        } else
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder("Failed writing ")).append(c).append(" at index ").append(i).toString());
        }
        return i;
    }

    private static void zza(CharSequence charsequence, ByteBuffer bytebuffer)
    {
        if (bytebuffer.isReadOnly())
        {
            throw new ReadOnlyBufferException();
        }
        if (bytebuffer.hasArray())
        {
            try
            {
                bytebuffer.position(zza(charsequence, bytebuffer.array(), bytebuffer.arrayOffset() + bytebuffer.position(), bytebuffer.remaining()) - bytebuffer.arrayOffset());
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
            zzb(charsequence, bytebuffer);
            return;
        }
    }

    public static int zzaa(long l)
    {
        return zzad(l);
    }

    public static int zzab(long l)
    {
        return zzad(zzaf(l));
    }

    public static int zzad(long l)
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

    public static long zzaf(long l)
    {
        return l << 1 ^ l >> 63;
    }

    public static int zzav(boolean flag)
    {
        return 1;
    }

    public static int zzb(int i, double d)
    {
        return zzlM(i) + zzk(d);
    }

    public static int zzb(int i, zzse zzse1)
    {
        return (zzlM(i) << 1) + zzd(zzse1);
    }

    public static int zzb(int i, byte abyte0[])
    {
        return zzlM(i) + zzE(abyte0);
    }

    public static zzrx zzb(byte abyte0[], int i, int j)
    {
        return new zzrx(abyte0, i, j);
    }

    private static void zzb(CharSequence charsequence, ByteBuffer bytebuffer)
    {
        int i;
        int l;
        l = charsequence.length();
        i = 0;
_L2:
        char c;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        c = charsequence.charAt(i);
        if (c >= '\200')
        {
            break; /* Loop/switch isn't completed */
        }
        bytebuffer.put((byte)c);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (c < '\u0800')
        {
            bytebuffer.put((byte)(c >>> 6 | 0x3c0));
            bytebuffer.put((byte)(c & 0x3f | 0x80));
        } else
        if (c < '\uD800' || '\uDFFF' < c)
        {
            bytebuffer.put((byte)(c >>> 12 | 0x1e0));
            bytebuffer.put((byte)(c >>> 6 & 0x3f | 0x80));
            bytebuffer.put((byte)(c & 0x3f | 0x80));
        } else
        {
            char c1;
label0:
            {
                int j = i;
                if (i + 1 != charsequence.length())
                {
                    i++;
                    c1 = charsequence.charAt(i);
                    if (Character.isSurrogatePair(c, c1))
                    {
                        break label0;
                    }
                    j = i;
                }
                throw new IllegalArgumentException((new StringBuilder("Unpaired surrogate at index ")).append(j - 1).toString());
            }
            int k = Character.toCodePoint(c, c1);
            bytebuffer.put((byte)(k >>> 18 | 0xf0));
            bytebuffer.put((byte)(k >>> 12 & 0x3f | 0x80));
            bytebuffer.put((byte)(k >>> 6 & 0x3f | 0x80));
            bytebuffer.put((byte)(k & 0x3f | 0x80));
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static int zzc(int i, float f)
    {
        return zzlM(i) + zzj(f);
    }

    public static int zzc(int i, zzse zzse1)
    {
        return zzlM(i) + zze(zzse1);
    }

    public static int zzc(int i, boolean flag)
    {
        return zzlM(i) + zzav(flag);
    }

    private static int zzc(CharSequence charsequence)
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
            k = i + zza(charsequence, j);
        }
        if (k < l)
        {
            throw new IllegalArgumentException((new StringBuilder("UTF-8 length does not fit in int: ")).append((long)k + 0x100000000L).toString());
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

    public static int zzd(int i, long l)
    {
        return zzlM(i) + zzaa(l);
    }

    public static int zzd(zzse zzse1)
    {
        return zzse1.zzFR();
    }

    public static int zze(int i, long l)
    {
        return zzlM(i) + zzab(l);
    }

    public static int zze(zzse zzse1)
    {
        int i = zzse1.zzFR();
        return i + zzlO(i);
    }

    public static int zzfA(String s)
    {
        int i = zzc(s);
        return i + zzlO(i);
    }

    public static int zzj(float f)
    {
        return 4;
    }

    public static int zzk(double d)
    {
        return 8;
    }

    public static int zzlJ(int i)
    {
        if (i >= 0)
        {
            return zzlO(i);
        } else
        {
            return 10;
        }
    }

    public static int zzlK(int i)
    {
        return zzlO(zzlQ(i));
    }

    public static int zzlM(int i)
    {
        return zzlO(zzsh.zzD(i, 0));
    }

    public static int zzlO(int i)
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

    public static int zzlQ(int i)
    {
        return i << 1 ^ i >> 31;
    }

    public static int zzn(int i, String s)
    {
        return zzlM(i) + zzfA(s);
    }

    public final void zzC(int i, int j)
    {
        zzlN(zzsh.zzD(i, j));
    }

    public final void zzD(byte abyte0[])
    {
        zzlN(abyte0.length);
        zzF(abyte0);
    }

    public final void zzF(byte abyte0[])
    {
        zzc(abyte0, 0, abyte0.length);
    }

    public final int zzFD()
    {
        return zzbij.remaining();
    }

    public final void zzFE()
    {
        if (zzFD() != 0)
        {
            throw new IllegalStateException("Did not write as much data as expected.");
        } else
        {
            return;
        }
    }

    public final void zzY(long l)
    {
        zzac(l);
    }

    public final void zzZ(long l)
    {
        zzac(zzaf(l));
    }

    public final void zza(int i, double d)
    {
        zzC(i, 1);
        zzj(d);
    }

    public final void zza(int i, zzse zzse1)
    {
        zzC(i, 2);
        zzc(zzse1);
    }

    public final void zza(int i, byte abyte0[])
    {
        zzC(i, 2);
        zzD(abyte0);
    }

    public final void zzac(long l)
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                zzlL((int)l);
                return;
            }
            zzlL((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public final void zzae(long l)
    {
        if (zzbij.remaining() < 8)
        {
            throw new zza(zzbij.position(), zzbij.limit());
        } else
        {
            zzbij.putLong(l);
            return;
        }
    }

    public final void zzau(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        zzlL(i);
    }

    public final void zzb(byte byte0)
    {
        if (!zzbij.hasRemaining())
        {
            throw new zza(zzbij.position(), zzbij.limit());
        } else
        {
            zzbij.put(byte0);
            return;
        }
    }

    public final void zzb(int i, float f)
    {
        zzC(i, 5);
        zzi(f);
    }

    public final void zzb(int i, long l)
    {
        zzC(i, 0);
        zzY(l);
    }

    public final void zzb(int i, String s)
    {
        zzC(i, 2);
        zzfz(s);
    }

    public final void zzb(int i, boolean flag)
    {
        zzC(i, 0);
        zzau(flag);
    }

    public final void zzb(zzse zzse1)
    {
        zzse1.zza(this);
    }

    public final void zzc(int i, long l)
    {
        zzC(i, 0);
        zzZ(l);
    }

    public final void zzc(zzse zzse1)
    {
        zzlN(zzse1.zzFQ());
        zzse1.zza(this);
    }

    public final void zzc(byte abyte0[], int i, int j)
    {
        if (zzbij.remaining() >= j)
        {
            zzbij.put(abyte0, i, j);
            return;
        } else
        {
            throw new zza(zzbij.position(), zzbij.limit());
        }
    }

    public final void zzfz(String s)
    {
        zza zza1;
        int i;
        int j;
        i = zzlO(s.length());
        if (i != zzlO(s.length() * 3))
        {
            break MISSING_BLOCK_LABEL_152;
        }
        j = zzbij.position();
        if (zzbij.remaining() < i)
        {
            throw new zza(i + j, zzbij.limit());
        }
        try
        {
            zzbij.position(j + i);
            zza(s, zzbij);
            int k = zzbij.position();
            zzbij.position(j);
            zzlN(k - j - i);
            zzbij.position(k);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            zza1 = new zza(zzbij.position(), zzbij.limit());
            zza1.initCause(s);
            throw zza1;
        }
        zzlN(zzc(s));
        zza(s, zzbij);
        return;
    }

    public final void zzi(float f)
    {
        zzlP(Float.floatToIntBits(f));
    }

    public final void zzj(double d)
    {
        zzae(Double.doubleToLongBits(d));
    }

    public final void zzlH(int i)
    {
        if (i >= 0)
        {
            zzlN(i);
            return;
        } else
        {
            zzac(i);
            return;
        }
    }

    public final void zzlI(int i)
    {
        zzlN(zzlQ(i));
    }

    public final void zzlL(int i)
    {
        zzb((byte)i);
    }

    public final void zzlN(int i)
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                zzlL(i);
                return;
            }
            zzlL(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public final void zzlP(int i)
    {
        if (zzbij.remaining() < 4)
        {
            throw new zza(zzbij.position(), zzbij.limit());
        } else
        {
            zzbij.putInt(i);
            return;
        }
    }

    public final void zzy(int i, int j)
    {
        zzC(i, 0);
        zzlH(j);
    }

    public final void zzz(int i, int j)
    {
        zzC(i, 0);
        zzlI(j);
    }

    private class zza extends IOException
    {

        zza(int i, int j)
        {
            super((new StringBuilder("CodedOutputStream was writing to a flat byte array and ran out of space (pos ")).append(i).append(" limit ").append(j).append(").").toString());
        }
    }

}
