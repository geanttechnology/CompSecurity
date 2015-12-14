// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.media.AudioRecord;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import java.nio.ByteBuffer;

public class nc
    implements Runnable
{

    final nk a;
    final ActivityCameraNew b;

    public nc(ActivityCameraNew activitycameranew, nk nk1)
    {
        b = activitycameranew;
        a = nk1;
        super();
    }

    public void run()
    {
        Object obj;
        int ai[];
        int i;
        int j;
        boolean flag;
        flag = false;
        ai = ActivityCameraNew.e();
        j = ai.length;
        i = 0;
        obj = null;
_L5:
        int k;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_301;
        }
        k = ai[i];
        obj = new AudioRecord(k, 44100, 16, 2, 25600);
        k = ((AudioRecord) (obj)).getState();
        if (k != 1)
        {
            obj = null;
        }
_L4:
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1 = obj;
_L10:
        if (obj1 == null)
        {
            a.sendMessage(a.obtainMessage(3, Boolean.valueOf(false)));
            return;
        }
          goto _L3
        obj;
        obj = null;
          goto _L4
_L2:
        i++;
          goto _L5
_L3:
        obj = ByteBuffer.allocateDirect(1024);
        try
        {
            ((AudioRecord) (obj1)).startRecording();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((AudioRecord) (obj1)).release();
            a.sendMessage(a.obtainMessage(3, Boolean.valueOf(false)));
            return;
        }
        ((ByteBuffer) (obj)).clear();
        i = ((AudioRecord) (obj1)).read(((ByteBuffer) (obj)), 1024);
        Object obj2;
        if (i < 0)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        ((ByteBuffer) (obj)).clear();
        ((AudioRecord) (obj1)).stop();
_L7:
        ((AudioRecord) (obj1)).release();
        a.sendMessage(a.obtainMessage(3, Boolean.valueOf(flag)));
        return;
        obj2;
        ((ByteBuffer) (obj)).clear();
        ((AudioRecord) (obj1)).stop();
        flag = false;
        if (true) goto _L7; else goto _L6
_L6:
        obj2;
        try
        {
            ((ByteBuffer) (obj)).clear();
            ((AudioRecord) (obj1)).stop();
            throw obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((AudioRecord) (obj1)).release();
        }
        finally
        {
            flag = true;
        }
        a.sendMessage(a.obtainMessage(3, Boolean.valueOf(false)));
        return;
_L9:
        ((AudioRecord) (obj1)).release();
        a.sendMessage(a.obtainMessage(3, Boolean.valueOf(flag)));
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L9; else goto _L8
_L8:
        obj1 = obj;
          goto _L10
    }
}
