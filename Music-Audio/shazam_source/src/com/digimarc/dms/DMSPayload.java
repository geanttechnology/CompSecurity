// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.dms.imagereader.Payload;
import java.math.BigInteger;

// Referenced classes of package com.digimarc.dms:
//            DMSCpmBase

public class DMSPayload
{

    private DMSCpmBase mCpm;
    private String mCpmPath;

    public DMSPayload(String s)
    {
        mCpmPath = null;
        mCpm = null;
        mCpmPath = s;
        mCpm = new DMSCpmBase(s);
    }

    private int getNumberValueBitsForProtocol()
    {
        String s;
        String s1;
        byte byte1;
        byte1 = 64;
        s = mCpm.getProtocol();
        s1 = mCpm.getVersion();
        if (!s.equalsIgnoreCase("KE"))
        {
            break MISSING_BLOCK_LABEL_93;
        }
        if (!s1.equalsIgnoreCase("v5")) goto _L2; else goto _L1
_L1:
        byte byte0 = 32;
_L4:
        return byte0;
_L2:
        byte0 = byte1;
        if (s1.equalsIgnoreCase("v6")) goto _L4; else goto _L3
_L3:
        if (s1.equalsIgnoreCase("v7"))
        {
            return 47;
        }
        byte0 = byte1;
        if (s1.equalsIgnoreCase("v8")) goto _L4; else goto _L5
_L5:
        return !s1.equalsIgnoreCase("v9") ? 0 : 98;
        if (s.equalsIgnoreCase("AFRE"))
        {
            return 24;
        }
        return !s.equalsIgnoreCase("TDS4") ? 0 : 24;
    }

    public String getBarcodeType()
    {
        return mCpm.mProtocol;
    }

    public String getBarcodeValue()
    {
        if (mCpm.isBarCode())
        {
            return mCpm.getId();
        }
        if (mCpm.isImage() && (mCpm.getVersion().equalsIgnoreCase("v7") || mCpm.getVersion().equalsIgnoreCase("v8")))
        {
            BigInteger biginteger = new BigInteger("00007fffffffffff", 16);
            BigInteger biginteger2 = new BigInteger("100000000000000", 10);
            BigInteger biginteger1 = (new BigInteger(mCpm.getId(), 16)).and(biginteger);
            biginteger = biginteger1;
            if (biginteger1.compareTo(biginteger2) > 0)
            {
                biginteger = biginteger1.subtract(biginteger2);
            }
            return String.format("%014d", new Object[] {
                Long.valueOf(biginteger.longValue())
            });
        } else
        {
            return "";
        }
    }

    public String getCpmId()
    {
        return getValue();
    }

    public String getGrid()
    {
        return mCpm.getGrid();
    }

    public int getNumberValueBits()
    {
        return getNumberValueBitsForProtocol();
    }

    public Payload getPayloadForResolver()
    {
        if (mCpmPath != null)
        {
            return new Payload(mCpmPath);
        } else
        {
            return null;
        }
    }

    public String getPayloadId()
    {
        return mCpmPath;
    }

    public String getProtocol()
    {
        return mCpm.getProtocol();
    }

    public String getValue()
    {
        return mCpm.getId();
    }

    public String getVersion()
    {
        return mCpm.getVersion();
    }

    public boolean isAudio()
    {
        return mCpm.isAudio();
    }

    public boolean isBarCode()
    {
        return mCpm.isBarCode();
    }

    public boolean isImage()
    {
        return mCpm.isImage();
    }

    public boolean isQRCode()
    {
        return mCpm.isQRCode();
    }
}
