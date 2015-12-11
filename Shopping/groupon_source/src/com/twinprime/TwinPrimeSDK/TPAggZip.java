// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.zip.Deflater;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPLog, JNILibrary, TPControlChannelStateMachine

public class TPAggZip
{
    class TPAggZipSendTask extends AsyncTask
    {

        final TPAggZip this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((byte[][])aobj);
        }

        protected transient Void doInBackground(byte abyte0[][])
        {
            if (TPLog.LOG13.isLoggable("TPAggZip"))
            {
                Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Requesting sending xcp msg - ").append(abyte0[0].length).append(" bytes").toString());
            }
            TPControlChannelStateMachine.writeMessage(ByteBuffer.wrap(abyte0[0]));
            return null;
        }

        TPAggZipSendTask()
        {
            this$0 = TPAggZip.this;
            super();
        }
    }

    class TPAggZipTimer extends Handler
    {

        boolean started;
        final TPAggZip this$0;

        public void handleMessage(Message message)
        {
            if (message.what == 201)
            {
                if (TPLog.LOG13.isLoggable("TPAggZip"))
                {
                    Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Timer is off, time to send xcp msg!").toString());
                }
                started = false;
                send();
            }
        }

        TPAggZipTimer()
        {
            this$0 = TPAggZip.this;
            super();
            started = false;
        }
    }


    byte aggBuf[];
    int bytesNumber;
    int bytesThreshold;
    String desc;
    int secThreshold;
    TPAggZipTimer timer;

    TPAggZip(String s, int i, int j)
    {
        timer = new TPAggZipTimer();
        bytesNumber = 0;
        desc = s;
        bytesThreshold = i;
        secThreshold = j;
        aggBuf = new byte[i];
    }

    private byte[] gzip()
        throws IOException
    {
        Deflater deflater = new Deflater();
        deflater.setInput(Arrays.copyOfRange(aggBuf, 0, bytesNumber));
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(bytesNumber);
        deflater.finish();
        byte abyte1[] = new byte[1024];
        for (; !deflater.finished(); bytearrayoutputstream.write(abyte1, 0, deflater.deflate(abyte1))) { }
        bytearrayoutputstream.close();
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        deflater.end();
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - original: ").append(bytesNumber).append(" bytes").toString());
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - compressed: ").append(abyte0.length).append(" bytes").toString());
        }
        return abyte0;
    }

    boolean aggregate(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - aggregate ").append(abyte0.length).append(" bytes").toString());
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - bytes before aggregating: ").append(bytesNumber).toString());
        }
        if (!timer.started)
        {
            startTimer();
        }
        if (bytesNumber + abyte0.length > aggBuf.length)
        {
            send();
        }
        System.arraycopy(abyte0, 0, aggBuf, bytesNumber, abyte0.length);
        bytesNumber = bytesNumber + abyte0.length;
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - bytes after aggregating: ").append(bytesNumber).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return false;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
    }

    void clean()
    {
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Cleaning ").append(bytesNumber).append(" bytes!").toString());
        }
        aggBuf = new byte[bytesThreshold];
        bytesNumber = 0;
        stopTimer();
    }

    void send()
    {
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Time to send messages! ").append(bytesNumber).append("bytes.").toString());
        }
        this;
        JVM INSTR monitorenter ;
        byte abyte0[] = JNILibrary.encodeMessage(gzip(), 14, true);
        (new TPAggZipSendTask()).execute(new byte[][] {
            Arrays.copyOfRange(abyte0, 0, abyte0.length)
        });
_L1:
        clean();
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        (new TPAggZipSendTask()).execute(new byte[][] {
            Arrays.copyOfRange(aggBuf, 0, bytesNumber)
        });
          goto _L1
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    void startTimer()
    {
        if (timer.started)
        {
            stopTimer();
        }
        if (TPLog.LOG13.isLoggable("TPAggZip"))
        {
            Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Starting timer [").append(secThreshold).append(" secs]").toString());
        }
        timer.sendEmptyMessageDelayed(201, secThreshold * 1000);
        timer.started = true;
    }

    void stopTimer()
    {
        timer.removeMessages(201);
        timer.started = false;
    }
}
