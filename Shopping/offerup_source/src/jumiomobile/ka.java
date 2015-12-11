// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.jumio.clientlib.impl.livenessAndTM.FrameProcessingCallbackTemplateMatcher;
import com.jumio.clientlib.impl.livenessAndTM.FrameQueue;
import com.jumio.clientlib.impl.livenessAndTM.LibImage;
import com.jumio.clientlib.impl.livenessAndTM.TemplateInfo;
import com.jumio.netverify.sdk.extraction.templatematcher.TemplateInfoWrapper;

// Referenced classes of package jumiomobile:
//            ab

public class ka extends FrameProcessingCallbackTemplateMatcher
{

    private Handler a;
    private long b;
    private long c;
    private boolean d;

    public ka(Handler handler)
    {
        b = 0L;
        c = 0L;
        d = false;
        a = handler;
    }

    public void a()
    {
        d = false;
    }

    public void finalResult(FrameQueue framequeue, TemplateInfo templateinfo)
    {
        long l = 0L;
        if (!d)
        {
            d = true;
            Bundle bundle;
            TemplateInfoWrapper templateinfowrapper;
            byte abyte0[];
            if (b == 0L)
            {
                b = System.currentTimeMillis();
            } else
            {
                l = System.currentTimeMillis() - b;
                b = System.currentTimeMillis();
            }
            bundle = new Bundle();
            templateinfowrapper = new TemplateInfoWrapper(templateinfo);
            templateinfowrapper.a(l);
            bundle.putParcelable("templateInfo", templateinfowrapper);
            templateinfo = framequeue.getFrameByID(templateinfo.getFrameIndex());
            abyte0 = new byte[(int)((float)(templateinfo.getWidth() * templateinfo.getHeight()) * 1.5F)];
            templateinfo.getFrameBuffer(abyte0);
            framequeue.clear();
            bundle.putByteArray("finalResultFrame", abyte0);
            framequeue = new Message();
            framequeue.what = 103;
            framequeue.setData(bundle);
            a.sendMessage(framequeue);
        }
    }

    public void intermediateResult(FrameQueue framequeue, TemplateInfo templateinfo)
    {
        if (!d)
        {
            Bundle bundle;
            TemplateInfoWrapper templateinfowrapper;
            long l;
            if (c == 0L)
            {
                c = System.currentTimeMillis();
                l = 0L;
            } else
            {
                l = System.currentTimeMillis() - c;
                c = System.currentTimeMillis();
            }
            templateinfowrapper = new TemplateInfoWrapper(templateinfo);
            templateinfowrapper.a(l);
            bundle = new Bundle();
            bundle.putParcelable("templateInfo", templateinfowrapper);
            if (framequeue.size() > 0L)
            {
                framequeue = framequeue.getFrameByID(templateinfo.getFrameIndex());
                if (framequeue != null)
                {
                    templateinfo = new byte[(int)((float)(framequeue.getWidth() * framequeue.getHeight()) * 1.5F)];
                    framequeue.getFrameBuffer(templateinfo);
                    bundle.putByteArray("finalResultFrame", templateinfo);
                } else
                {
                    ab.e("TemplateMatcher", "IntermediateResult: no frame received from queue!!");
                }
            } else
            {
                ab.e("TemplateMatcher", "IntermediateResult: FrameQueue empty!!");
            }
            framequeue = new Message();
            framequeue.what = 102;
            framequeue.setData(bundle);
            a.sendMessage(framequeue);
        }
    }

    public void noResult(FrameQueue framequeue)
    {
        d = false;
        a.sendEmptyMessage(101);
    }
}
