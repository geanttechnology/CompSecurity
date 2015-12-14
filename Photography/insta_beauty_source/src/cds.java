// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioRecord;
import android.os.Process;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

class cds extends Thread
{

    public boolean a;
    final cdq b;
    private final Object c;

    private cds(cdq cdq1)
    {
        b = cdq1;
        super();
        c = new Object();
        a = true;
    }

    cds(cdq cdq1, cdr cdr)
    {
        this(cdq1);
    }

    public void run()
    {
        Process.setThreadPriority(-19);
        int k = AudioRecord.getMinBufferSize(44100, 16, 2);
        int i;
        i = 25600;
        if (25600 >= k)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        i = (k / 1024 + 1) * 1024 * 2;
        int ai[];
        int l;
        ai = cdq.e();
        l = ai.length;
        Object obj;
        k = 0;
        obj = null;
_L6:
        if (k >= l) goto _L2; else goto _L1
_L1:
        int i1 = ai[k];
        obj = new AudioRecord(i1, 44100, 16, 2, i);
        i1 = ((AudioRecord) (obj)).getState();
        if (i1 != 1)
        {
            obj = null;
        }
_L4:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        ByteBuffer bytebuffer;
        Exception exception;
        int j;
        try
        {
            if (cdq.a(b) != null)
            {
                cdq.a(b).g();
            }
            b.c();
            Log.e("MediaAudioEncoder", "failed to initialize AudioRecord");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("MediaAudioEncoder", "AudioThread#run", ((Throwable) (obj)));
        }
        break MISSING_BLOCK_LABEL_297;
        obj;
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        k++;
        if (true) goto _L6; else goto _L5
_L5:
        if (!b.b)
        {
            break MISSING_BLOCK_LABEL_361;
        }
        bytebuffer = ByteBuffer.allocateDirect(1024);
        ((AudioRecord) (obj)).startRecording();
_L7:
        do
        {
            if (!b.b || b.c || b.e)
            {
                break MISSING_BLOCK_LABEL_349;
            }
        } while (a);
        bytebuffer.clear();
        j = ((AudioRecord) (obj)).read(bytebuffer, 1024);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_304;
        }
        bytebuffer.position(j);
        bytebuffer.flip();
        b.a(bytebuffer, j, b.j());
        b.f();
          goto _L7
        exception;
        ((AudioRecord) (obj)).stop();
        throw exception;
        exception;
        ((AudioRecord) (obj)).release();
        throw exception;
        return;
        Exception exception1;
        exception1;
        ((AudioRecord) (obj)).release();
        return;
        cdw cdw1 = (cdw)b.i.get();
        if (cdw1 == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        if (cdw1.a != null)
        {
            cdw1.a.sendEmptyMessage(3);
        }
        ((AudioRecord) (obj)).stop();
        b.c();
        b.f();
        ((AudioRecord) (obj)).stop();
        ((AudioRecord) (obj)).release();
        return;
    }
}
