// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.internet;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package my.googlemusic.play.internet:
//            Connection, Response

public class RequestCreator
{
    public static interface OnProgressListener
    {

        public abstract void onProgress(int i);
    }


    private Connection connection;
    private long endTime;
    private File file;
    private OnProgressListener listener;
    private String phoneModel;
    private OnConnectionRequestListener requestListener;
    private long startTime;
    private String url;

    RequestCreator(Connection connection1, String s)
    {
        url = s;
        connection = connection1;
        phoneModel = connection1.getDeviceName();
    }

    private void close(Closeable closeable)
    {
        if (closeable == null)
        {
            return;
        }
        try
        {
            closeable.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Closeable closeable)
        {
            closeable.printStackTrace();
        }
    }

    private URL getURL()
        throws MalformedURLException
    {
        addParam("phoneType", "1");
        addParam("phoneModel", phoneModel);
        return new URL(url.replace(" ", "%20"));
    }

    public RequestCreator addParam(String s, Object obj)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(url);
        String s1;
        if (url.contains("?"))
        {
            s1 = "&";
        } else
        {
            s1 = "?";
        }
        url = stringbuilder.append(s1).toString();
        url = (new StringBuilder()).append(url).append(s).append("=").append(obj).toString();
        return this;
    }

    public Response get()
    {
        Object obj;
        Object obj1;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        byte abyte0[];
        Object obj7;
        if (!connection.isConnected())
        {
            return new Response(6, "No Internet Connection");
        }
        obj6 = null;
        abyte0 = null;
        obj7 = null;
        obj1 = null;
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        if (requestListener == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        startTime = System.currentTimeMillis();
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
    /* block-local class not found */
    class OnConnectionRequestListener {}

        requestListener.onRequest(startTime);
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        Object obj8 = getURL();
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        System.out.println(obj8);
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        obj8 = (new OkUrlFactory(new OkHttpClient())).open(((URL) (obj8)));
        obj3 = obj1;
        obj4 = obj6;
        obj5 = abyte0;
        obj = obj7;
        obj1 = ((HttpURLConnection) (obj8)).getInputStream();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (file == null) goto _L2; else goto _L1
_L1:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = new FileOutputStream(file);
_L7:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        int l = ((HttpURLConnection) (obj8)).getContentLength();
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        abyte0 = new byte[1024];
        int i;
        long l1;
        l1 = 0L;
        i = 0;
_L4:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        int i1 = ((InputStream) (obj1)).read(abyte0);
        int j;
        if (i1 == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 += i1;
        j = i;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (listener == null)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        j = i;
        if (l <= 0)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        int k = (int)(((float)l1 * 100F) / (float)l);
        j = i;
        if (i == k)
        {
            break MISSING_BLOCK_LABEL_393;
        }
        j = k;
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        listener.onProgress(j);
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        ((OutputStream) (obj6)).write(abyte0, 0, i1);
        i = j;
        if (true) goto _L4; else goto _L3
        obj1;
        obj = obj3;
        obj4 = new Response(3, "URL mal formed.");
        obj = obj3;
        ((MalformedURLException) (obj1)).printStackTrace();
        if (requestListener != null)
        {
            endTime = System.currentTimeMillis();
            requestListener.onRequest(endTime - startTime);
        }
        close(((Closeable) (obj3)));
        return ((Response) (obj4));
_L2:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = new ByteArrayOutputStream();
        continue; /* Loop/switch isn't completed */
        obj;
        obj = obj4;
        obj1 = new Response(2, "URL not found.");
        if (requestListener != null)
        {
            endTime = System.currentTimeMillis();
            requestListener.onRequest(endTime - startTime);
        }
        close(((Closeable) (obj4)));
        return ((Response) (obj1));
_L3:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        if (!(obj6 instanceof ByteArrayOutputStream))
        {
            break MISSING_BLOCK_LABEL_655;
        }
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = obj6.toString();
_L5:
        obj3 = obj1;
        obj4 = obj1;
        obj5 = obj1;
        obj = obj1;
        obj6 = new Response(1, ((String) (obj6)));
        if (requestListener != null)
        {
            endTime = System.currentTimeMillis();
            requestListener.onRequest(endTime - startTime);
        }
        close(((Closeable) (obj1)));
        return ((Response) (obj6));
        obj6 = null;
          goto _L5
        Object obj2;
        obj2;
        obj = obj5;
        obj3 = new Response(4, "Error request.");
        obj = obj5;
        ((IOException) (obj2)).printStackTrace();
        if (requestListener != null)
        {
            endTime = System.currentTimeMillis();
            requestListener.onRequest(endTime - startTime);
        }
        close(((Closeable) (obj5)));
        return ((Response) (obj3));
        obj2;
        if (requestListener != null)
        {
            endTime = System.currentTimeMillis();
            requestListener.onRequest(endTime - startTime);
        }
        close(((Closeable) (obj)));
        throw obj2;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public RequestCreator into(File file1)
    {
        file = file1;
        return this;
    }

    public RequestCreator onRequest(OnConnectionRequestListener onconnectionrequestlistener)
    {
        requestListener = onconnectionrequestlistener;
        return this;
    }

    public RequestCreator progress(OnProgressListener onprogresslistener)
    {
        listener = onprogresslistener;
        return this;
    }
}
