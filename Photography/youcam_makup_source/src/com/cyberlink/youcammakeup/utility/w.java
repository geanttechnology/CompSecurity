// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.opengl.GLES20;
import android.util.Log;
import com.cyberlink.uma.internal.a;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            v

final class w
    implements Runnable
{

    int a[];
    String b;

    w()
    {
        a = new int[1];
        Thread thread = new Thread(this);
        thread.start();
        try
        {
            thread.join();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            com.cyberlink.uma.internal.a.b(interruptedexception);
        }
    }

    public void run()
    {
        v v2 = new v();
        v v1 = v2;
        GLES20.glGetIntegerv(3379, a, 0);
        v1 = v2;
        b = GLES20.glGetString(7938);
        if (v2 != null)
        {
            v2.a();
        }
_L2:
        return;
        Throwable throwable;
        throwable;
        v2 = null;
_L5:
        v1 = v2;
        Log.w("GLInfo", "", throwable);
        if (v2 == null) goto _L2; else goto _L1
_L1:
        v2.a();
        return;
        Exception exception;
        exception;
        v1 = null;
_L4:
        if (v1 != null)
        {
            v1.a();
        }
        throw exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
        throwable;
          goto _L5
    }
}
