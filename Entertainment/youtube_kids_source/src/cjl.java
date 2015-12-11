// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cjl
    implements anv
{

    cjl(cjh cjh)
    {
    }

    public final void a(android.media.MediaCodec.CryptoException cryptoexception)
    {
        bmo.a("Audio CryptoError with ExoPlayer.", cryptoexception);
    }

    public final void a(anz anz)
    {
        bmo.a("Error with ExoPlayer audio decoder initialization.", anz);
    }

    public final void a(aoz aoz)
    {
        bmo.a("Error with ExoPlayer audio track initialization.", aoz);
    }

    public final void a(apa apa)
    {
        bmo.a("Error with ExoPlayer audio track write.", apa);
    }
}
