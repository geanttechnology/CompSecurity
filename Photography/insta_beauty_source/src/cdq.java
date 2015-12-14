// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Log;
import com.crashlytics.android.Crashlytics;

public class cdq extends cdu
{

    private static final int m[] = {
        1, 0, 5, 7, 6
    };
    private cds k;
    private cdt l;

    public cdq(cdw cdw, cdv cdv1, cdt cdt)
    {
        super(cdw, cdv1);
        k = null;
        l = cdt;
    }

    private static final MediaCodecInfo a(String s)
    {
        int i1 = MediaCodecList.getCodecCount();
        int i = 0;
        while (i < i1) 
        {
            MediaCodecInfo mediacodecinfo = MediaCodecList.getCodecInfoAt(i);
            if (mediacodecinfo.isEncoder())
            {
                String as[] = mediacodecinfo.getSupportedTypes();
                int j = 0;
                while (j < as.length) 
                {
                    if (as[j].equalsIgnoreCase(s) && true)
                    {
                        return mediacodecinfo;
                    }
                    j++;
                }
            }
            i++;
        }
        return null;
    }

    static cdt a(cdq cdq1)
    {
        return cdq1.l;
    }

    static int[] e()
    {
        return m;
    }

    protected boolean a()
    {
        g = -1;
        e = false;
        f = false;
        if (a("audio/mp4a-latm") == null)
        {
            Log.e("MediaAudioEncoder", "Unable to find an appropriate codec for audio/mp4a-latm");
        } else
        {
            MediaFormat mediaformat = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
            mediaformat.setInteger("aac-profile", 2);
            mediaformat.setInteger("channel-mask", 16);
            mediaformat.setInteger("bitrate", 64000);
            mediaformat.setInteger("channel-count", 1);
            h = MediaCodec.createEncoderByType("audio/mp4a-latm");
            if (h != null)
            {
                try
                {
                    h.configure(mediaformat, null, null, 1);
                }
                catch (Exception exception)
                {
                    Crashlytics.logException(exception);
                }
                h.start();
                if (j != null)
                {
                    try
                    {
                        j.a(this);
                    }
                    catch (Exception exception1)
                    {
                        Log.e("MediaAudioEncoder", "prepare:", exception1);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    protected void b()
    {
        Log.e("startRecording", "MeidaAudioEncoder startRecording");
        super.b();
        if (k == null)
        {
            k = new cds(this, null);
            k.start();
            k.a = true;
        }
    }

    protected void c()
    {
        k = null;
        super.c();
    }

    public void d()
    {
        k.a = false;
        super.d();
    }

}
