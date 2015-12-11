// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpResponseHandler

public class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    static final boolean $assertionsDisabled;
    private static final String LOG_TAG = "FileAsyncHttpResponseHandler";
    private File mFile;

    public FileAsyncHttpResponseHandler(Context context)
    {
        if (!$assertionsDisabled && context == null)
        {
            throw new AssertionError();
        } else
        {
            mFile = getTemporaryFile(context);
            return;
        }
    }

    public FileAsyncHttpResponseHandler(File file)
    {
        if (!$assertionsDisabled && file == null)
        {
            throw new AssertionError();
        } else
        {
            mFile = file;
            return;
        }
    }

    byte[] getResponseData(HttpEntity httpentity)
    {
        InputStream inputstream;
        int i;
        long l;
        i = 0;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength();
        httpentity = new FileOutputStream(getTargetFile());
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        byte abyte0[] = new byte[4096];
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        i += j;
        httpentity.write(abyte0, 0, j);
        sendProgressMessage(i, (int)l);
          goto _L1
        Exception exception;
        exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        throw exception;
        inputstream.close();
        httpentity.flush();
        httpentity.close();
        return null;
    }

    protected File getTargetFile()
    {
        if (!$assertionsDisabled && mFile == null)
        {
            throw new AssertionError();
        } else
        {
            return mFile;
        }
    }

    protected File getTemporaryFile(Context context)
    {
        try
        {
            context = File.createTempFile("temp_", "_handled", context.getCacheDir());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("FileAsyncHttpResponseHandler", "Cannot create temporary file", context);
            return null;
        }
        return context;
    }

    public void onFailure(int i, Throwable throwable, File file)
    {
        onFailure(throwable, file);
    }

    public void onFailure(int i, Header aheader[], Throwable throwable, File file)
    {
        onFailure(i, throwable, file);
    }

    public void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, throwable, getTargetFile());
    }

    public void onFailure(Throwable throwable, File file)
    {
        onFailure(throwable);
    }

    public void onSuccess(int i, File file)
    {
        onSuccess(file);
    }

    public void onSuccess(int i, Header aheader[], File file)
    {
        onSuccess(i, file);
    }

    public void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, getTargetFile());
    }

    public void onSuccess(File file)
    {
    }

    static 
    {
        boolean flag;
        if (!shared_presage/com/loopj/android/http/FileAsyncHttpResponseHandler.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
