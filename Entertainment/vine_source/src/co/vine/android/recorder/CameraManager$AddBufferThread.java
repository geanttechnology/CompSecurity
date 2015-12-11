// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package co.vine.android.recorder:
//            CameraManager

private class this._cls0 extends Thread
{

    final CameraManager this$0;

    public void run()
    {
        do
        {
            Object obj;
label0:
            {
label1:
                {
                    if (CameraManager.access$000(CameraManager.this))
                    {
                        if (CameraManager.access$100(CameraManager.this) == null)
                        {
                            continue;
                        }
                        obj = (byte[])CameraManager.access$200(CameraManager.this).poll();
                        if (obj != null)
                        {
                            break label1;
                        }
                        try
                        {
                            Thread.sleep(50L);
                            continue;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj) { }
                    }
                    obj = new ArrayList();
                    do
                    {
                        byte abyte0[] = (byte[])CameraManager.access$200(CameraManager.this).poll();
                        if (abyte0 == null)
                        {
                            break;
                        }
                        if (CameraManager.access$100(CameraManager.this) != null)
                        {
                            addCallbackBuffer(abyte0);
                        } else
                        {
                            ((ArrayList) (obj)).add(abyte0);
                        }
                    } while (true);
                    break label0;
                }
                addCallbackBuffer(((byte []) (obj)));
                continue;
            }
            CameraManager.access$300(CameraManager.this).addAll(((java.util.Collection) (obj)));
            return;
        } while (true);
    }

    public ()
    {
        this$0 = CameraManager.this;
        super("AddBufferThread");
    }
}
