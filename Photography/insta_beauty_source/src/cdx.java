// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.util.Log;
import android.view.Surface;
import com.crashlytics.android.Crashlytics;

public class cdx extends cdu
{

    protected static int k[] = {
        0x7f000789
    };
    private final int l;
    private final int m;
    private ceb n;
    private Surface o;

    public cdx(cdw cdw, cdv cdv1, int i, int j)
    {
        super(cdw, cdv1);
        l = i;
        m = j;
        n = ceb.a("MediaVideoEncoder");
    }

    protected static final int a(MediaCodecInfo mediacodecinfo, String s)
    {
        boolean flag = false;
        android.media.MediaCodecInfo.CodecCapabilities codeccapabilities;
        Thread.currentThread().setPriority(10);
        codeccapabilities = mediacodecinfo.getCapabilitiesForType(s);
        int i;
        Thread.currentThread().setPriority(5);
        i = 0;
_L2:
        int j = ((flag) ? 1 : 0);
        if (i < codeccapabilities.colorFormats.length)
        {
            j = codeccapabilities.colorFormats[i];
            if (!a(j))
            {
                break MISSING_BLOCK_LABEL_110;
            }
        }
        if (j == 0)
        {
            Log.e("MediaVideoEncoder", (new StringBuilder()).append("couldn't find a good color format for ").append(mediacodecinfo.getName()).append(" / ").append(s).toString());
        }
        return j;
        mediacodecinfo;
        Thread.currentThread().setPriority(5);
        throw mediacodecinfo;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static final MediaCodecInfo a(String s)
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
                    if (as[j].equalsIgnoreCase(s) && a(mediacodecinfo, s) > 0)
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

    private static final boolean a(int i)
    {
        boolean flag1 = false;
        int j;
        int i1;
        if (k != null)
        {
            j = k.length;
        } else
        {
            j = 0;
        }
        i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j)
                {
                    if (k[i1] != i)
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private int e()
    {
        int i = (int)(5F * (float)l * (float)m);
        Log.e("MediaVideoEncoder", String.format("bitrate=%5.2f[Mbps]", new Object[] {
            Float.valueOf((float)i / 1024F / 1024F)
        }));
        return i;
    }

    public void a(EGLContext eglcontext, int i)
    {
        n.a(eglcontext, i, o, l, m, true);
    }

    protected boolean a()
    {
        g = -1;
        e = false;
        f = false;
        if (a("video/avc") == null)
        {
            Log.e("MediaVideoEncoder", "Unable to find an appropriate codec for video/avc");
        } else
        {
            MediaFormat mediaformat = MediaFormat.createVideoFormat("video/avc", l, m);
            mediaformat.setInteger("color-format", 0x7f000789);
            mediaformat.setInteger("bitrate", e());
            mediaformat.setInteger("frame-rate", 20);
            mediaformat.setInteger("i-frame-interval", 10);
            h = MediaCodec.createEncoderByType("video/avc");
            if (h != null)
            {
                try
                {
                    h.configure(mediaformat, null, null, 1);
                    o = h.createInputSurface();
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
                        Log.e("MediaVideoEncoder", "prepare:", exception1);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(cec cec, jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumPreviewRatio enumpreviewratio)
    {
        boolean flag = super.f();
        if (flag)
        {
            n.a(cec, enumpreviewratio, j());
        }
        return flag;
    }

    public void b()
    {
        Log.e("startRecording", "MediaVideoEncoder, startRecording");
        super.b();
    }

    protected void c()
    {
        if (o != null)
        {
            o.release();
            o = null;
        }
        if (n != null)
        {
            n.a();
            n = null;
        }
        super.c();
    }

    public void d()
    {
        n.a = false;
        super.d();
    }

    public boolean f()
    {
        boolean flag = super.f();
        if (flag)
        {
            n.a(null, null, j());
        }
        return flag;
    }

    protected void h()
    {
        h.signalEndOfInputStream();
        e = true;
    }

}
