// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.download;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package net.tsz.afinal.bitmap.download:
//            Downloader

public class SimpleHttpDownloader
    implements Downloader
{
    public class FlushedInputStream extends FilterInputStream
    {

        final SimpleHttpDownloader this$0;

        public long skip(long l)
            throws IOException
        {
            long l1 = 0L;
_L5:
            if (l1 < l) goto _L2; else goto _L1
_L1:
            return l1;
_L2:
            long l2;
            long l3 = in.skip(l - l1);
            l2 = l3;
            if (l3 != 0L)
            {
                break; /* Loop/switch isn't completed */
            }
            if (read() < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            l2 = 1L;
            break; /* Loop/switch isn't completed */
            if (true) goto _L1; else goto _L3
_L3:
            l1 += l2;
            if (true) goto _L5; else goto _L4
_L4:
        }

        public FlushedInputStream(InputStream inputstream)
        {
            this$0 = SimpleHttpDownloader.this;
            super(inputstream);
        }
    }


    private static final int IO_BUFFER_SIZE = 8192;
    private static final String TAG = "BitmapDownloader";

    public SimpleHttpDownloader()
    {
    }

    public boolean downloadToLocalStreamByUrl(String s, OutputStream outputstream)
    {
        Object obj2;
        Object obj5 = null;
        Object obj1 = null;
        obj2 = null;
        Object obj6 = null;
        OutputStream outputstream1 = null;
        Object obj8 = null;
        Object obj7 = null;
        Object obj3 = obj8;
        Object obj4 = obj2;
        Object obj;
        int i;
        try
        {
            obj = (HttpURLConnection)(new URL(s)).openConnection();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            outputstream = obj7;
            obj = obj5;
            continue; /* Loop/switch isn't completed */
        }
        finally
        {
            obj = obj1;
        }
        obj3 = obj8;
        obj4 = obj2;
        obj1 = obj;
        obj5 = obj;
        obj2 = new FlushedInputStream(new BufferedInputStream(((HttpURLConnection) (obj)).getInputStream(), 8192));
        outputstream = new BufferedOutputStream(outputstream, 8192);
_L1:
        i = ((FlushedInputStream) (obj2)).read();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        outputstream.close();
        IOException ioexception;
        if (obj2 != null)
        {
            try
            {
                ((FlushedInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return true;
        outputstream.write(i);
          goto _L1
        obj1;
        outputstream1 = outputstream;
        outputstream = ((OutputStream) (obj2));
        obj2 = obj1;
_L5:
        obj3 = outputstream;
        obj4 = outputstream1;
        obj1 = obj;
        Log.e("BitmapDownloader", (new StringBuilder("Error in downloadBitmap - ")).append(s).append(" : ").append(obj2).toString());
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        if (outputstream1 == null)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        outputstream1.close();
        if (outputstream != null)
        {
            try
            {
                outputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return false;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        ((BufferedOutputStream) (obj4)).close();
        if (obj3 != null)
        {
            try
            {
                ((FlushedInputStream) (obj3)).close();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream) { }
        }
        throw s;
        s;
        obj3 = obj2;
        obj4 = obj6;
        continue; /* Loop/switch isn't completed */
        s;
        obj3 = obj2;
        obj4 = outputstream;
        if (true) goto _L3; else goto _L2
_L3:
        break MISSING_BLOCK_LABEL_230;
        ioexception;
        outputstream = ((OutputStream) (obj2));
        obj2 = ioexception;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
