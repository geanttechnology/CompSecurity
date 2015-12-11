// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.common.content.dm:
//            RlProductInfoDataManager

public static class barcodeType
{

    public String barcode;
    public String barcodeType;
    public EbaySite site;

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (barcodeType)obj;
            if (!barcode.equals(((barcode) (obj)).barcode) || !barcodeType.equals(((barcodeType) (obj)).barcodeType) || !site.equals(((site) (obj)).site))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ((barcode.hashCode() + 31) * 31 + barcodeType.hashCode()) * 31 + site.hashCode();
    }

    public (EbaySite ebaysite, String s, String s1)
    {
        site = ebaysite;
        barcode = s;
        barcodeType = s1;
    }
}
