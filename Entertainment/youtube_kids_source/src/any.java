// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class any
    implements Runnable
{

    private android.media.MediaCodec.CryptoException a;
    private anw b;

    any(anw anw1, android.media.MediaCodec.CryptoException cryptoexception)
    {
        b = anw1;
        a = cryptoexception;
        super();
    }

    public final void run()
    {
        b.c.a(a);
    }
}
