// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class iv extends Handler
{

    private final ArrayList a = new ArrayList();
    private iu b;

    iv(iu iu1)
    {
        b = iu1;
        super();
    }

    public final void a(int i, Object obj)
    {
        obtainMessage(i, obj).sendToTarget();
    }

    public final void handleMessage(Message message)
    {
        int j;
        j = message.what;
        message = ((Message) (message.obj));
        j;
        JVM INSTR tableswitch 257 262: default 52
    //                   257 117
    //                   258 134
    //                   259 151
    //                   260 52
    //                   261 52
    //                   262 168;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L5
_L1:
        int i = b.b.size();
_L6:
        i--;
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        Object obj = (ir)((WeakReference)b.b.get(i)).get();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        b.b.remove(i);
          goto _L6
_L2:
        b.g.a((iz)message);
          goto _L1
_L3:
        b.g.b((iz)message);
          goto _L1
_L4:
        b.g.c((iz)message);
          goto _L1
_L5:
        b.g.d((iz)message);
          goto _L1
        a.addAll(((ir) (obj)).c);
          goto _L6
        int k = a.size();
        i = 0;
_L13:
        if (i >= k) goto _L8; else goto _L7
_L7:
        ir ir1;
        is is1;
        obj = (it)a.get(i);
        ir1 = ((it) (obj)).a;
        is1 = ((it) (obj)).b;
        0xff00 & j;
        JVM INSTR lookupswitch 2: default 418
    //                   256: 276
    //                   512: 483;
           goto _L9 _L10 _L11
_L10:
        iz iz1 = (iz)message;
        boolean flag;
        if ((((it) (obj)).d & 2) == 0 && !iz1.a(((it) (obj)).c))
        {
            flag = false;
        } else
        {
            flag = true;
        }
          goto _L12
_L15:
        is1.a(ir1, iz1);
          goto _L9
        message;
        a.clear();
        throw message;
_L16:
        is1.b(ir1, iz1);
          goto _L9
_L17:
        is1.a(ir1);
          goto _L9
_L18:
        is1.c(iz1);
          goto _L9
_L19:
        is1.a(iz1);
          goto _L9
_L20:
        is1.b(iz1);
          goto _L9
_L21:
        is1.b(ir1);
          goto _L9
_L22:
        is1.c(ir1);
          goto _L9
_L23:
        is1.d(ir1);
          goto _L9
_L8:
        a.clear();
        return;
_L9:
        i++;
          goto _L13
_L12:
        if (!flag) goto _L9; else goto _L14
_L14:
        j;
        JVM INSTR tableswitch 257 263: default 480
    //                   257 306
    //                   258 333
    //                   259 344
    //                   260 353
    //                   261 418
    //                   262 363
    //                   263 373;
           goto _L9 _L15 _L16 _L17 _L18 _L9 _L19 _L20
_L11:
        j;
        JVM INSTR tableswitch 513 515: default 512
    //                   513 383
    //                   514 392
    //                   515 401;
           goto _L9 _L21 _L22 _L23
    }
}
