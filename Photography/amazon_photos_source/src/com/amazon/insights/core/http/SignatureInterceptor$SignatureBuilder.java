// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.http;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;

// Referenced classes of package com.amazon.insights.core.http:
//            SignatureInterceptor, SignatureBuilderException

static final class isBinaryRequest
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

    public createHash isBinaryRequest(boolean flag)
    {
        isBinaryRequest = flag;
        return this;
    }

    public isBinaryRequest withBody(byte abyte0[])
    {
        body = abyte0;
        return this;
    }

    public body withFullPath(String s)
    {
        fullPath = s;
        return this;
    }

    public fullPath withHttpMethod(fullPath fullpath)
    {
        return withHttpVerb(fullpath.withHttpVerb());
    }

    public withHttpVerb withHttpVerb(String s)
    {
        httpVerb = s;
        return this;
    }

    public httpVerb withPrivateKey(String s)
    {
        privateKey = s;
        return this;
    }

    public privateKey withTimestamp(String s)
    {
        timestamp = s;
        return this;
    }

    I()
    {
        isBinaryRequest = false;
    }
}
