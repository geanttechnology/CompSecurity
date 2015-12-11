// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            NTLMEngineImpl, NTLMEngineException

static class domainBytes extends domainBytes
{

    protected byte domainBytes[];
    protected byte hostBytes[];

    String getResponse()
    {
        prepareResponse(40, 1);
        addULong(0xa2088201);
        addUShort(0);
        addUShort(0);
        addULong(40);
        addUShort(0);
        addUShort(0);
        addULong(40);
        addUShort(261);
        addULong(2600);
        addUShort(3840);
        return super.etResponse();
    }

    I(String s, String s1)
        throws NTLMEngineException
    {
        Object obj = null;
        super();
        String s2;
        try
        {
            s2 = NTLMEngineImpl.access$1400(s1);
            s1 = NTLMEngineImpl.access$1500(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NTLMEngineException((new StringBuilder()).append("Unicode unsupported: ").append(s.getMessage()).toString(), s);
        }
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        s = s2.getBytes("ASCII");
_L1:
        hostBytes = s;
        s = obj;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = s1.toUpperCase(Locale.ENGLISH).getBytes("ASCII");
        domainBytes = s;
        return;
        s = null;
          goto _L1
    }
}
