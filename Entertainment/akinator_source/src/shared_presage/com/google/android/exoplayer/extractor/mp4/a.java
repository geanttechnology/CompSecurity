// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.extractor.mp4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import shared_presage.com.google.android.exoplayer.util.ParsableByteArray;
import shared_presage.com.google.android.exoplayer.util.Util;

abstract class shared_presage.com.google.android.exoplayer.extractor.mp4.a
{
    static final class a extends shared_presage.com.google.android.exoplayer.extractor.mp4.a
    {

        public final long ah;
        public final List ai = new ArrayList();
        public final List aj = new ArrayList();

        public final void a(a a1)
        {
            aj.add(a1);
        }

        public final void a(b b1)
        {
            ai.add(b1);
        }

        public final b d(int i1)
        {
            int k1 = ai.size();
            for (int j1 = 0; j1 < k1; j1++)
            {
                b b1 = (b)ai.get(j1);
                if (b1.ag == i1)
                {
                    return b1;
                }
            }

            return null;
        }

        public final a e(int i1)
        {
            int k1 = aj.size();
            for (int j1 = 0; j1 < k1; j1++)
            {
                a a1 = (a)aj.get(j1);
                if (a1.ag == i1)
                {
                    return a1;
                }
            }

            return null;
        }

        public final String toString()
        {
            return (new StringBuilder()).append(c(ag)).append(" leaves: ").append(Arrays.toString(ai.toArray(new b[0]))).append(" containers: ").append(Arrays.toString(aj.toArray(new a[0]))).toString();
        }

        public a(int i1, long l1)
        {
            super(i1);
            ah = l1;
        }
    }

    static final class b extends shared_presage.com.google.android.exoplayer.extractor.mp4.a
    {

        public final ParsableByteArray ah;

        public b(int i1, ParsableByteArray parsablebytearray)
        {
            super(i1);
            ah = parsablebytearray;
        }
    }


    public static final int A = Util.getIntegerCodeForString("esds");
    public static final int B = Util.getIntegerCodeForString("moof");
    public static final int C = Util.getIntegerCodeForString("traf");
    public static final int D = Util.getIntegerCodeForString("mvex");
    public static final int E = Util.getIntegerCodeForString("tkhd");
    public static final int F = Util.getIntegerCodeForString("mdhd");
    public static final int G = Util.getIntegerCodeForString("hdlr");
    public static final int H = Util.getIntegerCodeForString("stsd");
    public static final int I = Util.getIntegerCodeForString("pssh");
    public static final int J = Util.getIntegerCodeForString("sinf");
    public static final int K = Util.getIntegerCodeForString("schm");
    public static final int L = Util.getIntegerCodeForString("schi");
    public static final int M = Util.getIntegerCodeForString("tenc");
    public static final int N = Util.getIntegerCodeForString("encv");
    public static final int O = Util.getIntegerCodeForString("enca");
    public static final int P = Util.getIntegerCodeForString("frma");
    public static final int Q = Util.getIntegerCodeForString("saiz");
    public static final int R = Util.getIntegerCodeForString("uuid");
    public static final int S = Util.getIntegerCodeForString("senc");
    public static final int T = Util.getIntegerCodeForString("pasp");
    public static final int U = Util.getIntegerCodeForString("TTML");
    public static final int V = Util.getIntegerCodeForString("vmhd");
    public static final int W = Util.getIntegerCodeForString("smhd");
    public static final int X = Util.getIntegerCodeForString("mp4v");
    public static final int Y = Util.getIntegerCodeForString("stts");
    public static final int Z = Util.getIntegerCodeForString("stss");
    public static final int a = Util.getIntegerCodeForString("ftyp");
    public static final int aa = Util.getIntegerCodeForString("ctts");
    public static final int ab = Util.getIntegerCodeForString("stsc");
    public static final int ac = Util.getIntegerCodeForString("stsz");
    public static final int ad = Util.getIntegerCodeForString("stco");
    public static final int ae = Util.getIntegerCodeForString("co64");
    public static final int af = Util.getIntegerCodeForString("tx3g");
    public static final int b = Util.getIntegerCodeForString("avc1");
    public static final int c = Util.getIntegerCodeForString("avc3");
    public static final int d = Util.getIntegerCodeForString("hvc1");
    public static final int e = Util.getIntegerCodeForString("hev1");
    public static final int f = Util.getIntegerCodeForString("s263");
    public static final int g = Util.getIntegerCodeForString("d263");
    public static final int h = Util.getIntegerCodeForString("mdat");
    public static final int i = Util.getIntegerCodeForString("mp4a");
    public static final int j = Util.getIntegerCodeForString("ac-3");
    public static final int k = Util.getIntegerCodeForString("dac3");
    public static final int l = Util.getIntegerCodeForString("ec-3");
    public static final int m = Util.getIntegerCodeForString("dec3");
    public static final int n = Util.getIntegerCodeForString("tfdt");
    public static final int o = Util.getIntegerCodeForString("tfhd");
    public static final int p = Util.getIntegerCodeForString("trex");
    public static final int q = Util.getIntegerCodeForString("trun");
    public static final int r = Util.getIntegerCodeForString("sidx");
    public static final int s = Util.getIntegerCodeForString("moov");
    public static final int t = Util.getIntegerCodeForString("mvhd");
    public static final int u = Util.getIntegerCodeForString("trak");
    public static final int v = Util.getIntegerCodeForString("mdia");
    public static final int w = Util.getIntegerCodeForString("minf");
    public static final int x = Util.getIntegerCodeForString("stbl");
    public static final int y = Util.getIntegerCodeForString("avcC");
    public static final int z = Util.getIntegerCodeForString("hvcC");
    public final int ag;

    public shared_presage.com.google.android.exoplayer.extractor.mp4.a(int i1)
    {
        ag = i1;
    }

    public static int a(int i1)
    {
        return i1 >> 24 & 0xff;
    }

    public static int b(int i1)
    {
        return 0xffffff & i1;
    }

    public static String c(int i1)
    {
        return (new StringBuilder()).append((char)(i1 >> 24)).append((char)(i1 >> 16 & 0xff)).append((char)(i1 >> 8 & 0xff)).append((char)(i1 & 0xff)).toString();
    }

    public String toString()
    {
        return c(ag);
    }

}
