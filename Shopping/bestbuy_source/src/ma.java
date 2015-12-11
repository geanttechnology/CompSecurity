// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

final class ma extends Thread
{

    private final CaptureQRCodeActivity a;
    private final Hashtable b;
    private Handler c;
    private final CountDownLatch d;

    ma(CaptureQRCodeActivity captureqrcodeactivity, Vector vector, String s, ResultPointCallback resultpointcallback)
    {
label0:
        {
            super();
            a = captureqrcodeactivity;
            d = new CountDownLatch(1);
            b = new Hashtable(3);
            if (vector != null)
            {
                captureqrcodeactivity = vector;
                if (!vector.isEmpty())
                {
                    break label0;
                }
            }
            captureqrcodeactivity = new Vector();
            captureqrcodeactivity.addAll(ly.b);
            captureqrcodeactivity.addAll(ly.c);
            captureqrcodeactivity.addAll(ly.d);
        }
        b.put(DecodeHintType.POSSIBLE_FORMATS, captureqrcodeactivity);
        if (s != null)
        {
            b.put(DecodeHintType.CHARACTER_SET, s);
        }
        b.put(DecodeHintType.NEED_RESULT_POINT_CALLBACK, resultpointcallback);
    }

    Handler a()
    {
        try
        {
            d.await();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        return c;
    }

    public void run()
    {
        Looper.prepare();
        c = new lz(a, b);
        d.countDown();
        Looper.loop();
    }
}
