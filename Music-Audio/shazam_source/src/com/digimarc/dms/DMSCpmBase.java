// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;


public class DMSCpmBase
{

    private final int BARCODE_TYPE = 253;
    private final String mBarcodeGrid = "Barcode";
    public String mCpmPath;
    protected String mGrid;
    protected String mId;
    protected String mProtocol;
    public String mReaderInfo;
    protected int mType;
    protected String mTypeString;
    protected String mVersion;

    public DMSCpmBase(String s)
    {
        mType = 0;
        mCpmPath = s;
        parseCpmPath();
    }

    public String getCpmPath()
    {
        return mCpmPath;
    }

    public String getGrid()
    {
        return mGrid;
    }

    public String getId()
    {
        return mId;
    }

    public String getProtocol()
    {
        return mProtocol;
    }

    public String getReaderInfo()
    {
        return mReaderInfo;
    }

    public int getType()
    {
        if (mProtocol.contains("AFRE"))
        {
            mType = 254;
        } else
        if (mProtocol.contains("TDS4"))
        {
            mType = 255;
        } else
        if (mGrid.contains("Barcode"))
        {
            mType = 253;
        } else
        {
            mType = Integer.parseInt(mVersion.split("[v]")[1], 10);
        }
        return mType;
    }

    public String getTypeString()
    {
        return mTypeString;
    }

    public String getVersion()
    {
        return mVersion;
    }

    public boolean isAudio()
    {
        return mGrid.contains("Audio");
    }

    public boolean isBarCode()
    {
        return mGrid.contains("Barcode") && !mProtocol.contains("QRCODE");
    }

    public boolean isCode128()
    {
        return mGrid.contains("Barcode") && mProtocol.contains("CODE128");
    }

    public boolean isCode39()
    {
        return mGrid.contains("Barcode") && mProtocol.contains("CODE39");
    }

    public boolean isImage()
    {
        while (isAudio() || isBarCode() || isQRCode()) 
        {
            return false;
        }
        return true;
    }

    public boolean isQRCode()
    {
        return mGrid.contains("Barcode") && mProtocol.contains("QRCODE");
    }

    public void parseCpmPath()
    {
        if (mCpmPath != null)
        {
            String as[] = mCpmPath.split("[.]");
            mGrid = as[0];
            mProtocol = as[1];
            mTypeString = as[2];
            mVersion = as[3];
            StringBuilder stringbuilder = new StringBuilder();
            for (int i = 4; i < as.length; i++)
            {
                stringbuilder.append(as[i]);
                if (i < as.length - 1)
                {
                    stringbuilder.append(".");
                }
            }

            mId = stringbuilder.toString();
        }
    }
}
