// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bestbuy.android.activities.bbyscan.CaptureQRCodeActivity;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.common.HybridBinarizer;
import java.util.Hashtable;

final class lz extends Handler
{

    private final CaptureQRCodeActivity a;
    private final MultiFormatReader b = new MultiFormatReader();
    private me c;

    lz(CaptureQRCodeActivity captureqrcodeactivity, Hashtable hashtable)
    {
        b.setHints(hashtable);
        a = captureqrcodeactivity;
    }

    private void a(byte abyte0[], int i, int j)
    {
        Object obj;
        Object obj1;
        me me1;
        obj = null;
        me1 = mj.a().a(abyte0, i, j);
        c = me1;
        obj1 = new BinaryBitmap(new HybridBinarizer(me1));
        obj1 = b.decodeWithState(((BinaryBitmap) (obj1)));
        obj = obj1;
        b.reset();
_L1:
        ReaderException readerexception;
        if (obj != null)
        {
            abyte0 = Message.obtain(a.b(), 0x7f0c0003, obj);
            obj = new Bundle();
            ((Bundle) (obj)).putParcelable("barcode_bitmap", me1.a());
            abyte0.setData(((Bundle) (obj)));
            abyte0.sendToTarget();
            return;
        } else
        {
            b(abyte0, i, j);
            Message.obtain(a.b(), 0x7f0c0002).sendToTarget();
            return;
        }
        readerexception;
        b.reset();
          goto _L1
        abyte0;
        b.reset();
        throw abyte0;
    }

    private void b(byte abyte0[], int i, int j)
    {
        Bundle bundle;
        bundle = null;
        byte abyte1[] = new byte[abyte0.length];
        for (int k = 0; k < j; k++)
        {
            for (int l = 0; l < i; l++)
            {
                abyte1[(l * j + j) - k - 1] = abyte0[k * i + l];
            }

        }

        abyte0 = new BinaryBitmap(new HybridBinarizer(mj.a().b(abyte1, i, j)));
        abyte0 = b.decodeWithState(abyte0);
        b.reset();
_L1:
        if (abyte0 != null)
        {
            abyte0 = Message.obtain(a.b(), 0x7f0c0003, abyte0);
            bundle = new Bundle();
            bundle.putParcelable("barcode_bitmap", c.a());
            abyte0.setData(bundle);
            abyte0.sendToTarget();
            return;
        } else
        {
            Message.obtain(a.b(), 0x7f0c0002).sendToTarget();
            return;
        }
        abyte0;
        b.reset();
        abyte0 = bundle;
          goto _L1
        abyte0;
        b.reset();
        throw abyte0;
    }

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 2131492865: 
            a((byte[])(byte[])message.obj, message.arg1, message.arg2);
            return;

        case 2131492869: 
            Looper.myLooper().quit();
            break;
        }
    }
}
