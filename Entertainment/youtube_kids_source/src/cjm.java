// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cjm
    implements aol
{

    private cjh a;

    cjm(cjh cjh1)
    {
        a = cjh1;
        super();
    }

    public final void a()
    {
        if (cjh.i(a) != null)
        {
            cjh.i(a).a(0);
        }
    }

    public final void a(int i)
    {
        cjh.c(a).e(i);
    }

    public final void a(int i, int j)
    {
        cjh.a(a, i);
        cjh.b(a, j);
        if (cjh.i(a) != null && cjh.i(a).j())
        {
            cjh.i(a).a(cjh.g(a), cjh.h(a));
        }
    }

    public final void a(android.media.MediaCodec.CryptoException cryptoexception)
    {
        bmo.a("Video CryptoError with ExoPlayer.", cryptoexception);
    }

    public final void a(anz anz)
    {
        bmo.a("Error with ExoPlayer video decoder initialization.", anz);
    }
}
