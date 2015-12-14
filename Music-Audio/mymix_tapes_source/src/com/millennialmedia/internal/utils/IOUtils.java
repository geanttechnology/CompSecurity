// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.millennialmedia.MMLog;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils, HttpUtils

public class IOUtils
{
    public static class BitmapStreamer
        implements HttpUtils.ResponseStreamer
    {

        public void streamContent(InputStream inputstream, HttpUtils.Response response)
        {
            response.bitmap = IOUtils.convertStreamToBitmap(inputstream);
        }

        public BitmapStreamer()
        {
        }
    }

    public static interface DownloadListener
    {

        public abstract void onDownloadFailed(Throwable throwable);

        public abstract void onDownloadSucceeded(File file);
    }

    public static class FileStreamer
        implements HttpUtils.ResponseStreamer
    {

        private File outputFile;

        public void streamContent(InputStream inputstream, HttpUtils.Response response)
        {
            Object obj;
            Object obj1;
            obj = null;
            obj1 = null;
            FileOutputStream fileoutputstream = new FileOutputStream(outputFile);
            IOUtils.read(inputstream, fileoutputstream);
            response.file = outputFile;
            if (fileoutputstream == null)
            {
                break MISSING_BLOCK_LABEL_127;
            }
            fileoutputstream.close();
_L2:
            return;
            inputstream;
            MMLog.e(IOUtils.TAG, "Error closing OutputStream when writing file", inputstream);
            return;
            response;
            inputstream = obj1;
_L5:
            obj = inputstream;
            MMLog.e(IOUtils.TAG, "Unable to create file from input stream", response);
            if (inputstream == null) goto _L2; else goto _L1
_L1:
            try
            {
                inputstream.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                MMLog.e(IOUtils.TAG, "Error closing OutputStream when writing file", inputstream);
            }
            return;
            inputstream;
_L4:
            if (obj != null)
            {
                try
                {
                    ((OutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (HttpUtils.Response response)
                {
                    MMLog.e(IOUtils.TAG, "Error closing OutputStream when writing file", response);
                }
            }
            throw inputstream;
            inputstream;
            obj = fileoutputstream;
            if (true) goto _L4; else goto _L3
_L3:
            response;
            inputstream = fileoutputstream;
              goto _L5
        }

        public FileStreamer(File file)
        {
            outputFile = file;
        }
    }

    public static class StringStreamer
        implements HttpUtils.ResponseStreamer
    {

        public void streamContent(InputStream inputstream, HttpUtils.Response response)
        {
            response.content = IOUtils.convertStreamToString(inputstream);
        }

        public StringStreamer()
        {
        }
    }


    private static final int BUFFER_SIZE = 0x80000;
    private static final String TAG = com/millennialmedia/internal/utils/IOUtils.getSimpleName();

    public IOUtils()
    {
    }

    public static Bitmap convertStreamToBitmap(InputStream inputstream)
    {
        inputstream = BitmapFactory.decodeStream(inputstream);
        if (inputstream == null)
        {
            MMLog.e(TAG, "Unable to create bitmap from input stream");
        }
        return inputstream;
    }

    public static String convertStreamToString(InputStream inputstream)
    {
        Object obj;
        Object obj2;
        Object obj3;
        obj = null;
        obj3 = null;
        obj2 = null;
        if (inputstream == null)
        {
            MMLog.e(TAG, "Unable to convert to string, input stream is null");
            return null;
        }
        inputstream = new BufferedReader(new InputStreamReader(inputstream), 4096);
        obj = new StringBuilder();
_L3:
        String s = inputstream.readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        ((StringBuilder) (obj)).append((new StringBuilder()).append(s).append("\n").toString());
          goto _L3
        Object obj1;
        obj1;
_L9:
        obj = inputstream;
        MMLog.e(TAG, "Error occurred when converting stream to string", ((Throwable) (obj1)));
        obj = obj2;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        inputstream.close();
        obj = obj2;
_L5:
        return ((String) (obj));
_L2:
        obj = ((StringBuilder) (obj)).toString();
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                MMLog.e(TAG, "Error closing input stream reader", inputstream);
            }
        }
        continue; /* Loop/switch isn't completed */
        inputstream;
        MMLog.e(TAG, "Error closing input stream reader", inputstream);
        obj = obj2;
        if (true) goto _L5; else goto _L4
_L4:
        inputstream;
_L7:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(TAG, "Error closing input stream reader", ((Throwable) (obj)));
            }
        }
        throw inputstream;
        obj1;
        obj = inputstream;
        inputstream = ((InputStream) (obj1));
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        inputstream = obj3;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void downloadFile(String s, Integer integer, File file, DownloadListener downloadlistener)
    {
        if (s == null || file == null || downloadlistener == null)
        {
            throw new IllegalArgumentException("url, file, and download listener are required");
        } else
        {
            ThreadUtils.runOnWorkerThread(new Runnable(file, s, integer, downloadlistener) {

                final Integer val$connectionTimeout;
                final DownloadListener val$downloadListener;
                final File val$file;
                final String val$url;

                public void run()
                {
                    Object obj = file;
                    try
                    {
                        if (file.isDirectory())
                        {
                            obj = File.createTempFile("_mm_", null, file);
                        }
                        obj = HttpUtils.httpRequestHandler.sendHttpRequest(url, null, null, connectionTimeout, new FileStreamer(((File) (obj))));
                        if (((HttpUtils.Response) (obj)).file != null)
                        {
                            downloadListener.onDownloadSucceeded(((HttpUtils.Response) (obj)).file);
                            return;
                        }
                    }
                    catch (IOException ioexception)
                    {
                        MMLog.e(IOUtils.TAG, (new StringBuilder()).append("An error occurred downloading file from url = ").append(url).toString(), ioexception);
                        downloadListener.onDownloadFailed(ioexception);
                        return;
                    }
                    downloadListener.onDownloadFailed(new Throwable("Error creating file"));
                    return;
                }

            
            {
                file = file1;
                url = s;
                connectionTimeout = integer;
                downloadListener = downloadlistener;
                super();
            }
            });
            return;
        }
    }

    public static File getUniqueFileName(File file, String s)
    {
        file.mkdirs();
        Object obj = new File(file, s);
        if (!((File) (obj)).exists())
        {
            return ((File) (obj));
        }
        s = s.split("\\.(?=[^\\.]+$)");
        obj = s[0];
        int i;
        if (s.length > 1)
        {
            s = s[1];
        } else
        {
            s = "";
        }
        for (i = 1; i < 1000; i++)
        {
            File file1 = new File(file, (new StringBuilder()).append(((String) (obj))).append("(").append(i).append(").").append(s).toString());
            if (!file1.exists())
            {
                return file1;
            }
        }

        return null;
    }

    public static String read(InputStream inputstream, String s)
        throws IOException
    {
        if (s == null)
        {
            s = "UTF-8";
        }
        return new String(read(inputstream), s);
    }

    public static void read(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[0x80000];
        do
        {
            int i = inputstream.read(abyte0, 0, 0x80000);
            if (i != -1)
            {
                outputstream.write(abyte0, 0, i);
            } else
            {
                return;
            }
        } while (true);
    }

    public static byte[] read(InputStream inputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        read(inputstream, ((OutputStream) (bytearrayoutputstream)));
        return bytearrayoutputstream.toByteArray();
    }

    public static void write(OutputStream outputstream, String s)
        throws IOException
    {
        outputstream = new OutputStreamWriter(outputstream);
        outputstream.write(s);
        if (outputstream != null)
        {
            outputstream.close();
        }
        return;
        s;
        if (outputstream != null)
        {
            outputstream.close();
        }
        throw s;
    }


}
