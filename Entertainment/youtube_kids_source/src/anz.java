// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class anz extends Exception
{

    public final String a;

    public anz(aon aon, Throwable throwable, int i)
    {
        aon = String.valueOf(aon);
        super((new StringBuilder(String.valueOf(aon).length() + 36)).append("Decoder init failed: [").append(i).append("], ").append(aon).toString(), throwable);
        a = null;
        if (i < 0)
        {
            aon = "neg_";
        } else
        {
            aon = "";
        }
        i = Math.abs(i);
        (new StringBuilder(String.valueOf(aon).length() + 64)).append("com.google.android.exoplayer.MediaCodecTrackRenderer_").append(aon).append(i);
    }

    public anz(aon aon, Throwable throwable, String s)
    {
        aon = String.valueOf(aon);
        super((new StringBuilder(String.valueOf(s).length() + 23 + String.valueOf(aon).length())).append("Decoder init failed: ").append(s).append(", ").append(aon).toString(), throwable);
        a = s;
        if (atp.a >= 21 && (throwable instanceof android.media.MediaCodec.CodecException))
        {
            ((android.media.MediaCodec.CodecException)throwable).getDiagnosticInfo();
        }
    }
}
