// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.netverify.sdk.custom;

import com.jumio.netverify.sdk.enums.NVScanMode;
import com.jumio.netverify.sdk.enums.NVScanSide;
import jumiomobile.hn;
import jumiomobile.hq;

public class NetverifyDocumentPart
{

    private NVScanMode scanMode;
    private NVScanSide scanSide;

    public NetverifyDocumentPart(NVScanSide nvscanside, hq hq1)
    {
        scanSide = nvscanside;
        scanMode = setScanMode(hq1);
    }

    private NVScanMode setScanMode(hq hq1)
    {
        switch (hn.a[hq1.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return NVScanMode.MRZ;

        case 6: // '\006'
        case 7: // '\007'
            return NVScanMode.BARCODE;

        case 8: // '\b'
        case 9: // '\t'
            return NVScanMode.LINE_FINDER;

        case 10: // '\n'
            return NVScanMode.TEMPLATE_MATCHER;

        case 11: // '\013'
            return NVScanMode.FACE_MANUAL;

        case 12: // '\f'
            return NVScanMode.FACE;

        case 13: // '\r'
            return NVScanMode.MANUAL;
        }
    }

    public NVScanMode getScanMode()
    {
        return scanMode;
    }

    public NVScanSide getScanSide()
    {
        return scanSide;
    }
}
