// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.DateUtil;
import com.amazon.insights.core.util.Preconditions;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.codec.binary.Base64;

// Referenced classes of package com.amazon.insights.core.http:
//            SignatureBuilderException

public class SignatureInterceptor
    implements HttpClient.Interceptor
{
    static final class SignatureBuilder
    {

        private byte body[];
        private String fullPath;
        private String httpVerb;
        private boolean isBinaryRequest;
        private String privateKey;
        private String timestamp;

        private byte[] createHash()
            throws NoSuchAlgorithmException
        {
            String s = "";
            if (!isBinaryRequest) goto _L2; else goto _L1
_L1:
            String s1 = new String(Base64.encodeBase64(body), "UTF-8");
            s = s1;
_L4:
            s = (new StringBuilder()).append(httpVerb).append("\n").append(fullPath).append("\n").append(timestamp).append("\n").append(s).append("\n").append(privateKey).toString();
            return MessageDigest.getInstance("SHA-256").digest(s.getBytes());
_L2:
            s1 = new String(body, "UTF-8");
            s = s1;
            continue; /* Loop/switch isn't completed */
            UnsupportedEncodingException unsupportedencodingexception;
            unsupportedencodingexception;
            if (true) goto _L4; else goto _L3
_L3:
        }

        public String createSignature()
            throws SignatureBuilderException
        {
            String s = null;
            byte abyte0[];
            try
            {
                abyte0 = createHash();
            }
            catch (NoSuchAlgorithmException nosuchalgorithmexception)
            {
                throw new SignatureBuilderException("SHA-256 unsupported", nosuchalgorithmexception);
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                throw new SignatureBuilderException("UTF-8 encoding unsupported", unsupportedencodingexception);
            }
            if (abyte0 == null)
            {
                break MISSING_BLOCK_LABEL_25;
            }
            s = new String(Base64.encodeBase64(abyte0), "UTF-8");
            return s;
        }

        public SignatureBuilder isBinaryRequest(boolean flag)
        {
            isBinaryRequest = flag;
            return this;
        }

        public SignatureBuilder withBody(byte abyte0[])
        {
            body = abyte0;
            return this;
        }

        public SignatureBuilder withFullPath(String s)
        {
            fullPath = s;
            return this;
        }

        public SignatureBuilder withHttpMethod(HttpClient.HttpMethod httpmethod)
        {
            return withHttpVerb(httpmethod.toString());
        }

        public SignatureBuilder withHttpVerb(String s)
        {
            httpVerb = s;
            return this;
        }

        public SignatureBuilder withPrivateKey(String s)
        {
            privateKey = s;
            return this;
        }

        public SignatureBuilder withTimestamp(String s)
        {
            timestamp = s;
            return this;
        }

        SignatureBuilder()
        {
            isBinaryRequest = false;
        }
    }


    private static Logger logger = Logger.getLogger(com/amazon/insights/core/http/SignatureInterceptor);
    protected DateFormat df;
    private String privateKey;
    protected TimeZone timeZone;

    public SignatureInterceptor(String s)
    {
        Preconditions.checkNotNull(s, "A valid privateKey must be provided");
        privateKey = s;
        timeZone = TimeZone.getTimeZone("GMT");
        df = DateUtil.createLocaleIndependentDateFormatter("yyyy-MM-dd'T'HH:mm:ss");
        df.setTimeZone(timeZone);
    }

    private String getPrivateKey()
    {
        return privateKey;
    }

    public void after(HttpClient.Response response)
    {
    }

    public void before(HttpClient.Request request)
    {
        byte abyte0[];
        String s;
        SignatureBuilder signaturebuilder;
        boolean flag;
        s = getTimeStamp();
        flag = "gzip".equalsIgnoreCase((String)request.getHeaders().get("Content-Encoding"));
        signaturebuilder = (new SignatureBuilder()).withPrivateKey(getPrivateKey()).withHttpMethod(request.getMethod()).withFullPath(request.getUrl().substring(request.getUrl().lastIndexOf("/")));
        if (request.getPostBodyBytes() == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        abyte0 = request.getPostBodyBytes();
_L1:
        request.addHeader("x-amzn-Request-Signature", signaturebuilder.withBody(abyte0).withTimestamp(s).isBinaryRequest(flag).createSignature());
        request.addHeader("x-amzn-Request-Signature-Timestamp", s);
        return;
        try
        {
            abyte0 = new byte[0];
        }
        catch (SignatureBuilderException signaturebuilderexception)
        {
            logger.e((new StringBuilder()).append("error signing request: ").append(request).toString(), signaturebuilderexception);
            return;
        }
          goto _L1
    }

    protected String getTimeStamp()
    {
        this;
        JVM INSTR monitorenter ;
        String s = df.format(new Date());
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

}
