// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer;

import shared_presage.com.google.android.exoplayer.util.Util;

// Referenced classes of package shared_presage.com.google.android.exoplayer:
//            MediaCodecTrackRenderer, MediaFormat

public static class diagnosticInfo extends Exception
{

    private static final int CUSTOM_ERROR_CODE_BASE = -50000;
    private static final int DECODER_QUERY_ERROR = -49998;
    private static final int NO_SUITABLE_DECODER_ERROR = -49999;
    public final String decoderName;
    public final String diagnosticInfo;

    private static String buildCustomDiagnosticInfo(int i)
    {
        String s;
        if (i < 0)
        {
            s = "neg_";
        } else
        {
            s = "";
        }
        return (new StringBuilder("shared_presage.com.google.android.exoplayer.MediaCodecTrackRenderer_")).append(s).append(Math.abs(i)).toString();
    }

    private static String getDiagnosticInfoV21(Throwable throwable)
    {
        if (throwable instanceof android.media.ecoderInitializationException)
        {
            return ((android.media.ecoderInitializationException)throwable).ecoderInitializationException();
        } else
        {
            return null;
        }
    }

    public (MediaFormat mediaformat, Throwable throwable, int i)
    {
        super((new StringBuilder("Decoder init failed: [")).append(i).append("], ").append(mediaformat).toString(), throwable);
        decoderName = null;
        diagnosticInfo = buildCustomDiagnosticInfo(i);
    }

    public buildCustomDiagnosticInfo(MediaFormat mediaformat, Throwable throwable, String s)
    {
        super((new StringBuilder("Decoder init failed: ")).append(s).append(", ").append(mediaformat).toString(), throwable);
        decoderName = s;
        if (Util.SDK_INT >= 21)
        {
            mediaformat = getDiagnosticInfoV21(throwable);
        } else
        {
            mediaformat = null;
        }
        diagnosticInfo = mediaformat;
    }
}
