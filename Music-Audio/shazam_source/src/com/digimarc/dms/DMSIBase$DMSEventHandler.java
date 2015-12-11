// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import android.os.Handler;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.digimarc.dms:
//            DMSIBase, DMSIListener, DMSMessage

protected static class  extends Handler
{

    public void handleMessage(Message message)
    {
        Iterator iterator = DMSIBase.mListenerList.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            DMSIListener dmsilistener = (DMSIListener)iterator.next();
            if (dmsilistener == null)
            {
                continue;
            }
            switch (message.what)
            {
            case 1: // '\001'
                dmsilistener.onStatus(((DMSMessage)message.obj).getStatus());
                break;

            case 101: // 'e'
                dmsilistener.onImageWatermarkDetected((DMSMessage)message.obj);
                break;

            case 100: // 'd'
                dmsilistener.onAudioWatermarkDetected((DMSMessage)message.obj);
                break;

            case 102: // 'f'
                dmsilistener.onImageBarcodeDetected((DMSMessage)message.obj);
                break;

            case 103: // 'g'
                dmsilistener.onImageQRCodeDetected((DMSMessage)message.obj);
                break;

            case 500: 
            case 501: 
            case 502: 
            case 503: 
            case 504: 
            case 505: 
            case 600: 
                dmsilistener.onError(message.what);
                break;
            }
        } while (true);
    }

    protected ()
    {
    }
}
