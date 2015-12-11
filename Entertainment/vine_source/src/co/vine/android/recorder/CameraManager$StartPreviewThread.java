// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.hardware.Camera;
import co.vine.android.util.CrashUtil;
import com.edisonwang.android.slog.SLog;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package co.vine.android.recorder:
//            CameraManager, RecordController, BasicVineRecorder

public class config extends Thread
{

    private final n config;
    private final long currentDuration;
    private final int frameRate;
    private boolean releasedAlready;
    final CameraManager this$0;

    public void notifyReleasedAlready()
    {
        releasedAlready = true;
    }

    public void run()
    {
        Object obj1 = new it>(CameraManager.this);
        if (CameraManager.access$400(CameraManager.this) == null) goto _L2; else goto _L1
_L1:
        int i;
        i = config.xDuration;
        i = Math.max((int)((float)(config.fferCount * (frameRate / config.rgetFrameRate)) * ((float)((long)i - currentDuration) / (float)i)), 30) / 10;
        CrashUtil.log("Buffer count: {}.", new Object[] {
            Integer.valueOf(i)
        });
        releasedAlready = false;
        Object obj = CameraManager.access$500(CameraManager.this);
        obj;
        JVM INSTR monitorenter ;
        if (CameraManager.access$100(CameraManager.this) == null || releasedAlready) goto _L4; else goto _L3
_L3:
        Iterator iterator = CameraManager.access$600(CameraManager.this).iterator();
        int k = i;
_L6:
        i = k;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        byte abyte1[] = (byte[])iterator.next();
        CameraManager.access$100(CameraManager.this).addCallbackBuffer(abyte1);
        k--;
        if (true) goto _L6; else goto _L5
_L4:
        releasedAlready = true;
        CrashUtil.log("Camera was released already.");
_L5:
        obj;
        JVM INSTR monitorexit ;
        k = i;
        if (!releasedAlready)
        {
            obj = CameraManager.access$300(CameraManager.this).iterator();
            do
            {
                k = i;
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                byte abyte0[] = (byte[])((Iterator) (obj)).next();
                addCallbackBuffer(abyte0);
                i--;
            } while (true);
        }
        break MISSING_BLOCK_LABEL_267;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        long l1;
        CrashUtil.log("After reused buffer count: {}.", new Object[] {
            Integer.valueOf(k)
        });
        l1 = System.currentTimeMillis();
        obj = CameraManager.access$500(CameraManager.this);
        obj;
        JVM INSTR monitorenter ;
        if (CameraManager.access$100(CameraManager.this) == null || releasedAlready) goto _L8; else goto _L7
_L7:
        CameraManager.access$100(CameraManager.this).setPreviewCallbackWithBuffer(CameraManager.access$400(CameraManager.this));
        CameraManager.access$702(CameraManager.this, String.valueOf(CameraManager.access$400(CameraManager.this)));
        CrashUtil.log((new StringBuilder()).append("Current camera callback: ").append(CameraManager.access$700(CameraManager.this)).toString());
_L16:
        System.gc();
        if (releasedAlready) goto _L10; else goto _L9
_L9:
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        i = ((flag1) ? 1 : 0);
        if (!config.eAllocateBuffer) goto _L12; else goto _L11
_L11:
        i = ((flag1) ? 1 : 0);
        if (CameraManager.access$800()) goto _L12; else goto _L13
_L13:
        i = (int)((double)(CameraManager.access$900(CameraManager.this) * (k - CameraManager.access$300(CameraManager.this).size())) * config.eAllocRatio);
        CrashUtil.log("Pre-allocate buffer {}: {}.", new Object[] {
            Double.valueOf(config.eAllocRatio), Integer.valueOf(i)
        });
        CameraManager.access$802(true);
        obj = new byte[i];
        i = ((flag) ? 1 : 0);
_L14:
        CameraManager.access$1002(CameraManager.this, ByteBuffer.wrap(new byte[CameraManager.access$900(CameraManager.this)]));
        if (obj != null)
        {
            obj[0] = 1;
        }
        System.gc();
_L12:
        int l = k;
        if (i != 0)
        {
            l = k;
            if (config.eAllocRatio <= 1.0D)
            {
                l = (int)((double)k * 0.5D);
            }
        }
        k = Math.max(l, 0);
        CameraManager cameramanager;
        boolean flag2;
        if (CameraManager.access$1000(CameraManager.this) == null)
        {
            i = CameraManager.access$900(CameraManager.this);
            obj = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                k + 1, i
            });
            CameraManager.access$1002(CameraManager.this, ByteBuffer.wrap(obj[k]));
        } else
        {
            int j = CameraManager.access$900(CameraManager.this);
            obj = (byte[][])Array.newInstance(Byte.TYPE, new int[] {
                k, j
            });
        }
        cameramanager = CameraManager.this;
        if (!releasedAlready)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        CameraManager.access$002(cameramanager, flag2);
        ((releasedAlready) (obj1)).rt();
        for (i = 0; i < k; i++)
        {
            if (i % 15 == 1)
            {
                CrashUtil.log("Add buffer {}.", new Object[] {
                    Integer.valueOf(i)
                });
            }
            addBuffer(obj[i], false);
        }

        break; /* Loop/switch isn't completed */
_L8:
        releasedAlready = true;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        obj = null;
        i = 1;
        CrashUtil.log("Pre-allocation failed with ratio {}, ignore pre-allocation step.", new Object[] {
            Double.valueOf(config.eAllocRatio)
        });
        if (true) goto _L14; else goto _L10
_L10:
        SLog.d("Waiting for adding to be done.");
        CameraManager.access$002(CameraManager.this, false);
        CrashUtil.log("Making buffer took {} ms.", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l1)
        });
_L2:
        synchronized (CameraManager.access$500(CameraManager.this))
        {
            if (CameraManager.access$100(CameraManager.this) != null && !releasedAlready)
            {
                CameraManager.access$1102(CameraManager.this, -1L);
                CameraManager.access$1202(CameraManager.this, 0L);
                CameraManager.access$1302(CameraManager.this, System.currentTimeMillis());
                CameraManager.access$100(CameraManager.this).startPreview();
            }
        }
        try
        {
            ((this._cls0) (obj1)).n();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            SLog.e("Couldn't wait for add thread to join.");
        }
        break MISSING_BLOCK_LABEL_924;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
        return;
        if (true) goto _L16; else goto _L15
_L15:
    }

    public (int i, long l)
    {
        this$0 = CameraManager.this;
        super("StartPreviewThread");
        frameRate = i;
        currentDuration = l;
        config = CameraManager.access$400(CameraManager.this).mParent.getConfig();
    }
}
