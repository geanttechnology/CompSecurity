// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.google.zxing.Result;
import java.util.Vector;

public final class lw extends Handler
{

    private final CaptureQRCodeActivity a;
    private final ma b;
    private lx c;

    public lw(CaptureQRCodeActivity captureqrcodeactivity, Vector vector, String s)
    {
        a = captureqrcodeactivity;
        b = new ma(captureqrcodeactivity, vector, s, new mg(captureqrcodeactivity.a()));
        b.start();
        c = lx.b;
        mj.a().e();
        b();
    }

    private void b()
    {
        if (c == lx.b)
        {
            c = lx.a;
            mj.a().a(b.a(), 0x7f0c0001);
            mj.a().b(this, 0x7f0c0000);
            a.c();
        }
    }

    public void a()
    {
        c = lx.c;
        mj.a().f();
        Message.obtain(b.a(), 0x7f0c0005).sendToTarget();
        try
        {
            b.join();
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        removeMessages(0x7f0c0003);
        removeMessages(0x7f0c0002);
    }

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 2131492864 2131492870: default 48
    //                   2131492864 49
    //                   2131492865 48
    //                   2131492866 135
    //                   2131492867 74
    //                   2131492868 158
    //                   2131492869 48
    //                   2131492870 69;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L1 _L6
_L1:
        return;
_L2:
        if (c == lx.a)
        {
            mj.a().b(this, 0x7f0c0000);
            return;
        }
          goto _L1
_L6:
        b();
        return;
_L4:
        Object obj = message.getData();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (Bitmap)((Bundle) (obj)).getParcelable("barcode_bitmap");
        }
        a.a((Result)message.obj, ((Bitmap) (obj)));
        try
        {
            Thread.sleep(2000L);
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            message.printStackTrace();
        }
        c = lx.b;
        return;
_L3:
        c = lx.a;
        mj.a().a(b.a(), 0x7f0c0001);
        return;
_L5:
        message = new Intent("android.intent.action.VIEW", Uri.parse((String)message.obj));
        message.addFlags(0x80000);
        a.startActivity(message);
        return;
    }
}
