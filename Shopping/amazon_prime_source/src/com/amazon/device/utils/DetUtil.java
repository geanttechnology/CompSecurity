// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import amazon.communication.MissingCredentialsException;
import amazon.communication.RequestFailedException;
import amazon.communication.TimeoutException;
import amazon.communication.authentication.RequestContext;
import amazon.communication.connection.CompressionOption;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.srr.SrrManager;
import android.os.Build;
import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;

public class DetUtil
{
    public static interface BodyWriter
    {

        public abstract void write(BufferedReader bufferedreader, Writer writer)
            throws Exception;
    }

    public static class DefaultHeaderProcessor
        implements HeaderProcessor
    {

        private final HeaderProcessor mDefaultHeaderProcessor;
        private final Map mHeaderProcessors;

        public void process(String s, String s1, Writer writer)
            throws Exception
        {
            HeaderProcessor headerprocessor = (HeaderProcessor)mHeaderProcessors.get(s);
            if (headerprocessor != null)
            {
                headerprocessor.process(s, s1, writer);
                return;
            } else
            {
                mDefaultHeaderProcessor.process(s, s1, writer);
                return;
            }
        }

        public DefaultHeaderProcessor(Map map, HeaderProcessor headerprocessor)
        {
            mHeaderProcessors = map;
            mDefaultHeaderProcessor = headerprocessor;
        }
    }

    public static final class DetResponse extends Enum
    {

        private static final DetResponse $VALUES[];
        public static final DetResponse CLIENT_ERROR;
        public static final DetResponse SERVER_ERROR;
        public static final DetResponse SUCCESS;

        public static DetResponse valueOf(String s)
        {
            return (DetResponse)Enum.valueOf(com/amazon/device/utils/DetUtil$DetResponse, s);
        }

        public static DetResponse[] values()
        {
            return (DetResponse[])$VALUES.clone();
        }

        static 
        {
            SUCCESS = new DetResponse("SUCCESS", 0);
            CLIENT_ERROR = new DetResponse("CLIENT_ERROR", 1);
            SERVER_ERROR = new DetResponse("SERVER_ERROR", 2);
            $VALUES = (new DetResponse[] {
                SUCCESS, CLIENT_ERROR, SERVER_ERROR
            });
        }

        private DetResponse(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface HeaderProcessor
    {

        public abstract void process(String s, String s1, Writer writer)
            throws Exception;
    }

    public static class HeaderWriter
        implements HeaderProcessor
    {

        public void process(String s, String s1, Writer writer)
            throws Exception
        {
            writer.write(s);
            writer.write(": ");
            writer.write(s1);
            writer.write("\n");
        }

        public HeaderWriter()
        {
        }
    }

    public static class PlainBodyWriter
        implements BodyWriter
    {

        public void write(BufferedReader bufferedreader, Writer writer)
            throws Exception
        {
            char ac[] = new char[8192];
            do
            {
                int i = bufferedreader.read(ac, 0, 8192);
                if (i == -1)
                {
                    return;
                }
                writer.write(ac, 0, i);
            } while (true);
        }

        public PlainBodyWriter()
        {
        }
    }

    public static class ReplaceHeader
        implements HeaderProcessor
    {

        private String mNewHeader;
        private HeaderProcessor mNextProcessor;

        public void process(String s, String s1, Writer writer)
            throws Exception
        {
            mNextProcessor.process(mNewHeader, s1, writer);
        }

        public ReplaceHeader(String s, HeaderProcessor headerprocessor)
        {
            mNewHeader = s;
            mNextProcessor = headerprocessor;
        }
    }

    public static class ReplaceValue
        implements HeaderProcessor
    {

        private HeaderProcessor mNextProcessor;
        private Map mReplaceValueMap;

        public void process(String s, String s1, Writer writer)
            throws Exception
        {
            String s2 = (String)mReplaceValueMap.get(s1);
            if (s2 == null)
            {
                mNextProcessor.process(s, s1, writer);
                return;
            } else
            {
                mNextProcessor.process(s, s2, writer);
                return;
            }
        }

        public ReplaceValue(Map map, HeaderProcessor headerprocessor)
        {
            mReplaceValueMap = map;
            mNextProcessor = headerprocessor;
        }
    }


    private static final Pattern HEADER_VALUE_REGEX = Pattern.compile("^(.+?): (.+)$");
    private static final SimpleDateFormat sDetDateFormat;
    private int mDetUploadTimeOut;

    public DetUtil()
    {
        mDetUploadTimeOut = (int)TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
    }

    public DetUtil(int i)
    {
        mDetUploadTimeOut = (int)TimeUnit.MILLISECONDS.convert(2L, TimeUnit.MINUTES);
        mDetUploadTimeOut = i;
    }

    public void addEventsSectionHeader(Writer writer)
        throws Exception
    {
        writer.write("\n[Events]\n");
    }

    public void addMetadataSectionHeader(HeaderProcessor headerprocessor, String s, String s1, Map map, Writer writer)
        throws Exception
    {
        writer.write("[Metadata]\n");
        headerprocessor.process("DeviceType", s, writer);
        headerprocessor.process("DeviceSerialNumber", s1, writer);
        headerprocessor.process("SystemVersion", Build.DISPLAY, writer);
        headerprocessor.process("BuildType", Build.TYPE, writer);
        headerprocessor.process("BuildTags", Build.TAGS, writer);
        if (map != null)
        {
            for (s = map.entrySet().iterator(); s.hasNext();)
            {
                s1 = (java.util.Map.Entry)s.next();
                if (s1.getKey() == null || s1.getValue() == null)
                {
                    Log.d("addMetadataSectionHeader", (new StringBuilder()).append("Extra info key or value set to null. Skipping. Key :").append((String)s1.getKey()).append(" Value :").append((String)s1.getValue()).toString());
                } else
                {
                    headerprocessor.process((String)s1.getKey(), (String)s1.getValue(), writer);
                }
            }

        }
    }

    public byte[] compressMessage(byte abyte0[])
        throws IOException
    {
        GZIPOutputStream gzipoutputstream;
        ByteArrayOutputStream bytearrayoutputstream;
        bytearrayoutputstream = new ByteArrayOutputStream((int)((float)abyte0.length * 0.2F));
        gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        gzipoutputstream.write(abyte0);
        gzipoutputstream.close();
        return bytearrayoutputstream.toByteArray();
        abyte0;
        gzipoutputstream.close();
        throw abyte0;
    }

    public HttpPost createDefaultHttpPost(String s, String s1, String s2)
        throws Exception
    {
        s = new HttpPost(String.format("/DeviceEventProxy/DETLogServlet?key=%s", new Object[] {
            s
        }));
        s.addHeader("expect", "");
        s.addHeader("X-Anonymous-Tag", s2);
        s.addHeader("X-DeviceType", s1);
        s.addHeader("X-DeviceFirmwareVersion", Build.DISPLAY);
        return s;
    }

    protected String createDetMfbsHeader(Long long1)
        throws Exception
    {
        StringBuilder stringbuilder = new StringBuilder(150);
        stringbuilder.append("\nFiles: messages.0");
        stringbuilder.append("\n------------------");
        stringbuilder.append("\nMFBS/1.0 1");
        stringbuilder.append("\n");
        stringbuilder.append("\nContent-Type: ").append("text/plain");
        stringbuilder.append("\nContent-Encoding: ").append("GZIP");
        stringbuilder.append("\nContent-Length: ").append(long1.toString());
        stringbuilder.append("\nContent-Name: Content");
        stringbuilder.append("\n\n");
        return stringbuilder.toString();
    }

    public String formatDate(long l)
    {
        return sDetDateFormat.format(new Date(l));
    }

    public DetResponse postFileToDet(HttpPost httppost, SrrManager srrmanager, EndpointIdentity endpointidentity, RequestContext requestcontext)
        throws IllegalAccessException, TimeoutException, RequestFailedException, MissingCredentialsException
    {
        if (httppost == null)
        {
            throw new IllegalArgumentException("Http Post must not be null.");
        }
        if (srrmanager == null)
        {
            throw new IllegalArgumentException("SRR Manager must not be null.");
        }
        if (endpointidentity == null)
        {
            throw new IllegalArgumentException("Endpoint identity must not be null.");
        }
        Log.d("postFileToDet", String.format("Posting file to DET of size %d with time out %d", new Object[] {
            Long.valueOf(httppost.getEntity().getContentLength()), Integer.valueOf(mDetUploadTimeOut)
        }));
        srrmanager = srrmanager.makeRequestSync((new amazon.communication.srr.SrrRequest.Builder()).setRequest(httppost).setEndpointIdentity(endpointidentity).setTimeout(mDetUploadTimeOut).setCompressionOption(CompressionOption.REQUIRED).setRequestContext(requestcontext).build());
        if (srrmanager == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        httppost = srrmanager.getEntity();
        if (httppost != null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        httppost = null;
_L1:
        if (httppost != null)
        {
            try
            {
                httppost.close();
            }
            // Misplaced declaration of an exception variable
            catch (HttpPost httppost)
            {
                Log.i("postFileToDet", "IO exception while trying to close the DET response.", httppost);
            }
        }
        httppost = srrmanager.getStatusLine();
        if (httppost == null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        if (httppost.getStatusCode() >= 200 && httppost.getStatusCode() < 300)
        {
            Log.d("postFileToDet", "Succesfully posted file to DET.");
            return DetResponse.SUCCESS;
        }
        break MISSING_BLOCK_LABEL_229;
        httppost = httppost.getContent();
          goto _L1
        Log.d("postFileToDet", (new StringBuilder()).append("Failed with error code: ").append(httppost.getStatusCode()).toString());
        if (httppost.getStatusCode() >= 400 && httppost.getStatusCode() < 500)
        {
            return DetResponse.CLIENT_ERROR;
        }
        if (httppost.getStatusCode() >= 500 && httppost.getStatusCode() < 600)
        {
            return DetResponse.SERVER_ERROR;
        }
        return DetResponse.CLIENT_ERROR;
    }

    public void processHeaders(BufferedReader bufferedreader, Writer writer, HeaderProcessor headerprocessor)
        throws Exception
    {
_L5:
        Object obj = bufferedreader.readLine();
        if (obj != null && !((String) (obj)).equals("")) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!((Matcher) (obj = HEADER_VALUE_REGEX.matcher(((CharSequence) (obj))))).matches()) goto _L1; else goto _L3
_L3:
        headerprocessor.process(((Matcher) (obj)).group(1), ((Matcher) (obj)).group(2), writer);
        if (true) goto _L5; else goto _L4
_L4:
    }

    static 
    {
        sDetDateFormat = new SimpleDateFormat("yyMMdd:HHmmss", Locale.US);
        sDetDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
