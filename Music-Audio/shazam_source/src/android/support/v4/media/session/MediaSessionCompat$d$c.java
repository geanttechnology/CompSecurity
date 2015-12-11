// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.media.session;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.KeyEvent;

// Referenced classes of package android.support.v4.media.session:
//            MediaSessionCompat

private final class a extends Handler
{

    final a a;

    public final void a(int i, Object obj)
    {
        obtainMessage(i, obj).sendToTarget();
    }

    public final void a(int i, Object obj, Bundle bundle)
    {
        obj = obtainMessage(i, obj);
        ((Message) (obj)).setData(bundle);
        ((Message) (obj)).sendToTarget();
    }

    public final void handleMessage(Message message)
    {
        if (a.a != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
            break;

        case 2: // '\002'
            Object obj = message.obj;
            message.getData();
            return;

        case 3: // '\003'
            Object obj1 = message.obj;
            message.getData();
            return;

        case 4: // '\004'
            ((Long)message.obj).longValue();
            return;

        case 11: // '\013'
            ((Long)message.obj).longValue();
            return;

        case 12: // '\f'
            message = ((Message) (message.obj));
            return;

        case 13: // '\r'
            Object obj2 = message.obj;
            message.getData();
            return;

        case 14: // '\016'
            message = (KeyEvent)message.obj;
            (new Intent("android.intent.action.MEDIA_BUTTON")).putExtra("android.intent.extra.KEY_EVENT", message);
            return;

        case 15: // '\017'
            message = ((Message) (message.obj));
            return;

        case 16: // '\020'
            a(a, ((Integer)message.obj).intValue(), 0);
            return;

        case 17: // '\021'
            a(a, ((Integer)message.obj).intValue(), 0);
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public ( , Looper looper)
    {
        a = ;
        super(looper);
    }
}
