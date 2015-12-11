// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.os.AsyncTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package co.vine.android.recorder:
//            RecordCompleteConsumer, RecordingFile

public abstract class HashAsyncTask extends AsyncTask
    implements RecordCompleteConsumer
{

    private final RecordCompleteConsumer mParent;

    public HashAsyncTask(RecordCompleteConsumer recordcompleteconsumer)
    {
        mParent = recordcompleteconsumer;
    }

    private static byte[] createChecksum(String s)
        throws NoSuchAlgorithmException, IOException
    {
        if (!(new File(s)).exists())
        {
            return new byte[0];
        }
        s = new FileInputStream(s);
        byte abyte0[] = new byte[1024];
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        int i;
        do
        {
            i = s.read(abyte0);
            if (i > 0)
            {
                messagedigest.update(abyte0, 0, i);
            }
        } while (i != -1);
        return messagedigest.digest();
    }

    public static String getMD5Checksum(String s)
        throws Exception
    {
        byte abyte0[] = createChecksum(s);
        s = "";
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            s = (new StringBuilder()).append(s).append(Integer.toString((byte0 & 0xff) + 256, 16).substring(1)).toString();
        }

        return s;
    }

    public static void setMD5Checksum(RecordingFile recordingfile)
        throws Exception
    {
        recordingfile.setHash(getMD5Checksum(recordingfile.getVideoPath()));
    }

    protected transient RecordingFile doInBackground(RecordingFile arecordingfile[])
    {
        if (arecordingfile == null || arecordingfile.length == 0)
        {
            return null;
        }
        if (arecordingfile.length > 1)
        {
            throw new IllegalArgumentException("You can only throw on file per execute.");
        }
        arecordingfile = arecordingfile[0];
        try
        {
            arecordingfile.setHash(getMD5Checksum(arecordingfile.getVideoPath()));
        }
        catch (Exception exception)
        {
            onError(arecordingfile, exception);
            return null;
        }
        return arecordingfile;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((RecordingFile[])aobj);
    }

    public final void onComplete(RecordingFile recordingfile)
    {
        onComplete(recordingfile, mParent);
    }

    public abstract void onComplete(RecordingFile recordingfile, RecordCompleteConsumer recordcompleteconsumer);

    public final void onError(RecordingFile recordingfile, Exception exception)
    {
        onError(recordingfile, exception, mParent);
    }

    public abstract void onError(RecordingFile recordingfile, Exception exception, RecordCompleteConsumer recordcompleteconsumer);

    protected final void onPostExecute(RecordingFile recordingfile)
    {
        onComplete(recordingfile, mParent);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((RecordingFile)obj);
    }
}
