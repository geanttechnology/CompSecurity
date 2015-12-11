// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.discover.qrcode;


// Referenced classes of package com.digimarc.discover.qrcode:
//            QRBarResult

public class DigimarcQRCodeReader
{

    private int mFrameCount;
    private int mInvertedReadInterval;
    private boolean mReadBar;
    private boolean mReadQR;

    public DigimarcQRCodeReader(boolean flag, boolean flag1, int i)
    {
        mReadQR = flag;
        mReadBar = flag1;
        mInvertedReadInterval = i;
        System.loadLibrary("DMSImageBarcode");
    }

    public native QRBarResult nativeQRRead(byte abyte0[], int i, int j, boolean flag, boolean flag1, boolean flag2);

    public QRBarResult read(byte abyte0[], int i, int j)
    {
        boolean flag = false;
        mFrameCount = mFrameCount + 1;
        if (mInvertedReadInterval != 0)
        {
            if (mFrameCount % mInvertedReadInterval == 0)
            {
                flag = true;
            }
        } else
        {
            flag = false;
        }
        return nativeQRRead(abyte0, i, j, mReadQR, mReadBar, flag);
    }
}
