// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import com.digimarc.discover.qrcode.DigimarcQRCodeReader;

// Referenced classes of package com.digimarc.dms:
//            DMSIImageReader, DMSOptionsBarCode, DMSPayloadBarcode, DMSPayload, 
//            DMSMessage

public class DMSReaderBarcode extends DMSIImageReader
{

    private DigimarcQRCodeReader readerInstance;

    public DMSReaderBarcode(String s)
    {
        readerInstance = null;
        name = s;
    }

    public DigimarcQRCodeReader getReaderInstance()
    {
        if (readerInstance == null && name != null)
        {
            if (name.compareTo("ImageBarcode") == 0)
            {
                readerInstance = new DigimarcQRCodeReader(optionsBarCode.isRead1DBarcodes(), optionsBarCode.isReadQRCodes(), optionsBarCode.getInvertedReadInterval());
            } else
            {
                DMS_Notify_Marks(600, null);
            }
        }
        return readerInstance;
    }

    public DMSPayload queueImageData(byte abyte0[], int i, int j, boolean flag)
    {
        DMSMessage dmsmessage;
label0:
        {
            Object obj = getReaderInstance().read(abyte0, i, j);
            abyte0 = null;
            if (obj != null)
            {
                obj = new DMSPayloadBarcode(((com.digimarc.discover.qrcode.QRBarResult) (obj)));
                abyte0 = new DMSPayload(((DMSPayloadBarcode) (obj)).getCpmPath());
                dmsmessage = new DMSMessage(abyte0, name, 0);
                if (!((DMSPayloadBarcode) (obj)).isQRCode())
                {
                    break label0;
                }
                DMS_Notify_Marks(103, dmsmessage);
            }
            return abyte0;
        }
        DMS_Notify_Marks(102, dmsmessage);
        return abyte0;
    }

    public void start()
    {
    }

    public void stop()
    {
    }
}
