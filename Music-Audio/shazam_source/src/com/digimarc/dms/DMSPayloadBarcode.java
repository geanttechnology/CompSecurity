// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms;

import android.net.Uri;
import com.digimarc.discover.qrcode.QRBarResult;
import com.google.c.a;

// Referenced classes of package com.digimarc.dms:
//            DMSQRCodeResult

public class DMSPayloadBarcode
{

    private QRBarResult mBarcode;
    private DMSQRCodeResult mQRResolver;

    public DMSPayloadBarcode(QRBarResult qrbarresult)
    {
        mQRResolver = null;
        mBarcode = qrbarresult;
        mQRResolver = new DMSQRCodeResult(mBarcode.getCode());
    }

    public QRBarResult getBarcode()
    {
        return mBarcode;
    }

    public String getCpmPath()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$google$zxing$BarcodeFormat[];

            static 
            {
                $SwitchMap$com$google$zxing$BarcodeFormat = new int[a.values().length];
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.o.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.p.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.h.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.g.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.c.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.e.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$zxing$BarcodeFormat[a.l.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        String s;
        a a1;
        if (isQRCode())
        {
            if (mQRResolver.uri != null)
            {
                s = mQRResolver.uri.toString();
            } else
            {
                s = mQRResolver.getCode();
            }
        } else
        {
            s = mBarcode.getCode();
        }
        a1 = mBarcode.getBarcodeFormat();
        switch (_cls1..SwitchMap.com.google.zxing.BarcodeFormat[a1.ordinal()])
        {
        default:
            return (new StringBuilder("Barcode.OTHER.DEFAULT.v0.")).append(s).toString();

        case 1: // '\001'
            return (new StringBuilder("Barcode.UPCA.DEFAULT.v0.")).append(s).toString();

        case 2: // '\002'
            return (new StringBuilder("Barcode.UPCE.DEFAULT.v0.")).append(s).toString();

        case 3: // '\003'
            return (new StringBuilder("Barcode.EAN13.DEFAULT.v0.")).append(s).toString();

        case 4: // '\004'
            return (new StringBuilder("Barcode.EAN8.DEFAULT.v0.")).append(s).toString();

        case 5: // '\005'
            return (new StringBuilder("Barcode.CODE39.DEFAULT.v0.")).append(s).toString();

        case 6: // '\006'
            return (new StringBuilder("Barcode.CODE128.DEFAULT.v0.")).append(s).toString();

        case 7: // '\007'
            return (new StringBuilder("Barcode.QRCODE.DEFAULT.v0.")).append(s).toString();
        }
    }

    public DMSQRCodeResult getForResolver()
    {
        return mQRResolver;
    }

    public boolean isQRCode()
    {
        return mBarcode.getBarcodeFormat() == a.l;
    }
}
