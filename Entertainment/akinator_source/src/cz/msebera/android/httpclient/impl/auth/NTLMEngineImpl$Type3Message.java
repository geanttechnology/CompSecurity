// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl.auth:
//            NTLMEngineImpl, NTLMEngineException

static class NTLMUserSessionKey extends NTLMUserSessionKey
{

    protected byte domainBytes[];
    protected byte hostBytes[];
    protected byte lmResp[];
    protected byte ntResp[];
    protected byte sessionKey[];
    protected int type2Flags;
    protected byte userBytes[];

    String getResponse()
    {
        int l = ntResp.length;
        int i1 = lmResp.length;
        int i;
        int j;
        int k;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        if (domainBytes != null)
        {
            i = domainBytes.length;
        } else
        {
            i = 0;
        }
        if (hostBytes != null)
        {
            j = hostBytes.length;
        } else
        {
            j = 0;
        }
        j1 = userBytes.length;
        if (sessionKey != null)
        {
            k = sessionKey.length;
        } else
        {
            k = 0;
        }
        k1 = i1 + 72;
        l1 = k1 + l;
        i2 = l1 + i;
        j2 = i2 + j1;
        k2 = j2 + j;
        prepareResponse(k2 + k, 3);
        addUShort(i1);
        addUShort(i1);
        addULong(72);
        addUShort(l);
        addUShort(l);
        addULong(k1);
        addUShort(i);
        addUShort(i);
        addULong(l1);
        addUShort(j1);
        addUShort(j1);
        addULong(i2);
        addUShort(j);
        addUShort(j);
        addULong(j2);
        addUShort(k);
        addUShort(k);
        addULong(k2);
        addULong(type2Flags & 0x80 | type2Flags & 0x200 | type2Flags & 0x80000 | 0x2000000 | type2Flags & 0x8000 | type2Flags & 0x20 | type2Flags & 0x10 | type2Flags & 0x20000000 | type2Flags & 0x80000000 | type2Flags & 0x40000000 | type2Flags & 0x800000 | type2Flags & 1 | type2Flags & 4);
        addUShort(261);
        addULong(2600);
        addUShort(3840);
        addBytes(lmResp);
        addBytes(ntResp);
        addBytes(domainBytes);
        addBytes(userBytes);
        addBytes(hostBytes);
        if (sessionKey != null)
        {
            addBytes(sessionKey);
        }
        return super.etResponse();
    }

    I(String s, String s1, String s2, String s3, byte abyte0[], int i, String s4, 
            byte abyte1[])
        throws NTLMEngineException
    {
        String s5;
        type2Flags = i;
        s5 = NTLMEngineImpl.access$1400(s1);
        s1 = NTLMEngineImpl.access$1500(s);
        s3 = new it>(s1, s2, s3, abyte0, s4, abyte1);
        if ((0x800000 & i) == 0 || abyte1 == null || s4 == null) goto _L2; else goto _L1
_L1:
        ntResp = s3.NTLMv2Response();
        lmResp = s3.LMv2Response();
        if ((i & 0x80) == 0) goto _L4; else goto _L3
_L3:
        try
        {
            s = s3.LanManagerSessionKey();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ntResp = new byte[0];
            lmResp = s3.LMResponse();
            if ((i & 0x80) != 0)
            {
                s = s3.LanManagerSessionKey();
            } else
            {
                s = s3.LMUserSessionKey();
            }
        }
        if ((i & 0x10) != 0)
        {
            if ((0x40000000 & i) != 0)
            {
                sessionKey = NTLMEngineImpl.RC4(s3.SecondaryKey(), s);
            } else
            {
                sessionKey = s;
            }
        } else
        {
            sessionKey = null;
        }
        if (s5 == null) goto _L6; else goto _L5
_L5:
        s = s5.getBytes("UnicodeLittleUnmarked");
_L9:
        hostBytes = s;
        if (s1 == null) goto _L8; else goto _L7
_L7:
        s = s1.toUpperCase(Locale.ENGLISH).getBytes("UnicodeLittleUnmarked");
_L10:
        domainBytes = s;
        userBytes = s2.getBytes("UnicodeLittleUnmarked");
        return;
_L4:
        s = s3.NTLMv2UserSessionKey();
        break MISSING_BLOCK_LABEL_91;
_L2:
        if ((0x80000 & i) == 0)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        ntResp = s3.NTLM2SessionResponse();
        lmResp = s3.LM2SessionResponse();
        if ((i & 0x80) == 0)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        s = s3.LanManagerSessionKey();
        break MISSING_BLOCK_LABEL_91;
        s = s3.NTLM2SessionResponseUserSessionKey();
        break MISSING_BLOCK_LABEL_91;
        ntResp = s3.NTLMResponse();
        lmResp = s3.LMResponse();
        if ((i & 0x80) == 0)
        {
            break MISSING_BLOCK_LABEL_269;
        }
        s = s3.LanManagerSessionKey();
        break MISSING_BLOCK_LABEL_91;
        s = s3.NTLMUserSessionKey();
        break MISSING_BLOCK_LABEL_91;
_L6:
        s = null;
          goto _L9
_L8:
        s = null;
          goto _L10
        s;
        throw new NTLMEngineException((new StringBuilder()).append("Unicode not supported: ").append(s.getMessage()).toString(), s);
          goto _L9
    }
}
