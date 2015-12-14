// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.kcpsdk.common.WebRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RequestSigner, ITokenAuthProvider

private class mBody
{

    private byte mBody[];
    private ByteArrayOutputStream mCorpus;
    private boolean mIsValid;
    private String mPath;
    private String mTimestamp;
    private String mToken;
    private String mVerb;
    final RequestSigner this$0;

    public byte[] getCorpus()
    {
        return mCorpus.toByteArray();
    }

    public String getTimestamp()
    {
        return mTimestamp;
    }

    public boolean isValid()
    {
        return mIsValid;
    }

    public boolean validateComponents()
    {
        boolean flag = true;
        if (mVerb == null || mTimestamp == null || mToken == null)
        {
            flag = false;
        }
        return flag;
    }

    public A(ITokenAuthProvider itokenauthprovider, WebRequest webrequest, String s)
    {
        this$0 = RequestSigner.this;
        super();
        mPath = "";
        mBody = new byte[0];
        mCorpus = new ByteArrayOutputStream();
        mTimestamp = s;
        if (mTimestamp == null)
        {
            mTimestamp = (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)).format(new Date());
        }
        if (itokenauthprovider != null)
        {
            itokenauthprovider = itokenauthprovider.getToken();
            if (itokenauthprovider != null)
            {
                mToken = itokenauthprovider;
            }
        }
        if (webrequest == null) goto _L2; else goto _L1
_L1:
        itokenauthprovider = webrequest.getVerbAsString();
        if (itokenauthprovider != null)
        {
            mVerb = itokenauthprovider;
        }
        if (!RequestSigner.access$000(RequestSigner.this)) goto _L4; else goto _L3
_L3:
        mPath = webrequest.getUrl();
_L9:
        if (!RequestSigner.access$000(RequestSigner.this)) goto _L6; else goto _L5
_L5:
        mBody = new byte[0];
_L2:
        if (!validateComponents())
        {
            break MISSING_BLOCK_LABEL_292;
        }
        mCorpus.write((new StringBuilder()).append(mVerb).append("\n").toString().getBytes("UTF-8"));
        mCorpus.write((new StringBuilder()).append(mPath).append("\n").toString().getBytes("UTF-8"));
        mCorpus.write((new StringBuilder()).append(mTimestamp).append("\n").toString().getBytes("UTF-8"));
        mCorpus.write(mBody);
        mCorpus.write("\n".getBytes("UTF-8"));
        mCorpus.write(mToken.getBytes("UTF-8"));
        mIsValid = true;
        return;
_L4:
        itokenauthprovider = webrequest.getPathAndQueryString();
        if (itokenauthprovider != null)
        {
            mPath = itokenauthprovider;
            if (!mPath.startsWith("/"))
            {
                mPath = (new StringBuilder()).append(mPath).append("/").append(mPath).toString();
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        requestsigner = webrequest.getBodyBytes();
        if (RequestSigner.this != null)
        {
            mBody = RequestSigner.this;
        }
        if (true) goto _L2; else goto _L7
_L7:
        requestsigner;
        MAPLog.e(RequestSigner.access$100(), (new StringBuilder("corpusbuilder: UnsupportedEncodingException error: ")).append(getMessage()).toString());
        return;
        requestsigner;
        MAPLog.e(RequestSigner.access$100(), (new StringBuilder("corpusbuilder: IOException error: ")).append(getMessage()).toString());
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
