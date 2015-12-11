// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpResponseHandler, Utils, AsyncHttpClient, LogInterface

public abstract class FileAsyncHttpResponseHandler extends AsyncHttpResponseHandler
{

    private static final String LOG_TAG = "FileAsyncHttpRH";
    protected final boolean append;
    protected final File file;
    protected File frontendFile;
    protected final boolean renameIfExists;

    public FileAsyncHttpResponseHandler(Context context)
    {
        file = getTemporaryFile(context);
        append = false;
        renameIfExists = false;
    }

    public FileAsyncHttpResponseHandler(File file1)
    {
        this(file1, false);
    }

    public FileAsyncHttpResponseHandler(File file1, boolean flag)
    {
        this(file1, flag, false);
    }

    public FileAsyncHttpResponseHandler(File file1, boolean flag, boolean flag1)
    {
        this(file1, flag, flag1, false);
    }

    public FileAsyncHttpResponseHandler(File file1, boolean flag, boolean flag1, boolean flag2)
    {
        super(flag2);
        if (file1 != null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        Utils.asserts(flag2, "File passed into FileAsyncHttpResponseHandler constructor must not be null");
        if (!file1.isDirectory() && !file1.getParentFile().isDirectory())
        {
            Utils.asserts(file1.getParentFile().mkdirs(), "Cannot create parent directories for requested File location");
        }
        if (file1.isDirectory() && !file1.mkdirs())
        {
            AsyncHttpClient.log.d("FileAsyncHttpRH", "Cannot create directories for requested Directory location, might not be a problem");
        }
        file = file1;
        append = flag;
        renameIfExists = flag1;
    }

    public boolean deleteTargetFile()
    {
        return getTargetFile() != null && getTargetFile().delete();
    }

    protected File getOriginalFile()
    {
        boolean flag;
        if (file != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Utils.asserts(flag, "Target file is null, fatal!");
        return file;
    }

    protected byte[] getResponseData(HttpEntity httpentity)
        throws IOException
    {
        InputStream inputstream;
        long l;
        if (httpentity == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        inputstream = httpentity.getContent();
        l = httpentity.getContentLength();
        httpentity = new FileOutputStream(getTargetFile(), append);
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        byte abyte0[] = new byte[4096];
        int i = 0;
_L1:
        int j = inputstream.read(abyte0);
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        if (Thread.currentThread().isInterrupted())
        {
            break MISSING_BLOCK_LABEL_112;
        }
        i += j;
        httpentity.write(abyte0, 0, j);
        sendProgressMessage(i, l);
          goto _L1
        Exception exception;
        exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        httpentity.flush();
        AsyncHttpClient.silentCloseOutputStream(httpentity);
        throw exception;
        AsyncHttpClient.silentCloseInputStream(inputstream);
        httpentity.flush();
        AsyncHttpClient.silentCloseOutputStream(httpentity);
        return null;
    }

    public File getTargetFile()
    {
        if (frontendFile == null)
        {
            File file1;
            if (getOriginalFile().isDirectory())
            {
                file1 = getTargetFileByParsingURL();
            } else
            {
                file1 = getOriginalFile();
            }
            frontendFile = file1;
        }
        return frontendFile;
    }

    protected File getTargetFileByParsingURL()
    {
        Utils.asserts(getOriginalFile().isDirectory(), "Target file is not a directory, cannot proceed");
        String s;
        File file1;
        boolean flag;
        if (getRequestURI() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Utils.asserts(flag, "RequestURI is null, cannot proceed");
        s = getRequestURI().toString();
        s = s.substring(s.lastIndexOf('/') + 1, s.length());
        file1 = new File(getOriginalFile(), s);
        if (file1.exists() && renameIfExists)
        {
            int i;
            if (!s.contains("."))
            {
                s = (new StringBuilder()).append(s).append(" (%d)").toString();
            } else
            {
                s = (new StringBuilder()).append(s.substring(0, s.lastIndexOf('.'))).append(" (%d)").append(s.substring(s.lastIndexOf('.'), s.length())).toString();
            }
            i = 0;
            do
            {
                file1 = new File(getOriginalFile(), String.format(s, new Object[] {
                    Integer.valueOf(i)
                }));
                if (!file1.exists())
                {
                    return file1;
                }
                i++;
            } while (true);
        } else
        {
            return file1;
        }
    }

    protected File getTemporaryFile(Context context)
    {
        boolean flag;
        if (context != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Utils.asserts(flag, "Tried creating temporary file without having Context");
        try
        {
            context = File.createTempFile("temp_", "_handled", context.getCacheDir());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            AsyncHttpClient.log.e("FileAsyncHttpRH", "Cannot create temporary file", context);
            return null;
        }
        return context;
    }

    public abstract void onFailure(int i, Header aheader[], Throwable throwable, File file1);

    public final void onFailure(int i, Header aheader[], byte abyte0[], Throwable throwable)
    {
        onFailure(i, aheader, throwable, getTargetFile());
    }

    public abstract void onSuccess(int i, Header aheader[], File file1);

    public final void onSuccess(int i, Header aheader[], byte abyte0[])
    {
        onSuccess(i, aheader, getTargetFile());
    }
}
