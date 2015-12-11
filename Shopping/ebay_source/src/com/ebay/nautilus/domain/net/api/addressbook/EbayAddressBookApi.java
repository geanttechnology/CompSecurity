// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.addressbook;

import com.ebay.nautilus.domain.EbaySite;
import java.util.HashSet;

public final class EbayAddressBookApi
{

    public static final String ServiceDomain = "urn:ebay:apis:eBLBaseComponents";
    private static final HashSet recoverableErrorCodes;
    public static final String soaServiceName = "AddressBookService";
    public final String iafToken;
    public final EbaySite site;

    public EbayAddressBookApi(EbaySite ebaysite, String s)
    {
        site = ebaysite;
        iafToken = s;
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        }
        if (s == null)
        {
            throw new NullPointerException("iafToken");
        } else
        {
            return;
        }
    }

    public static boolean errorCodeRepresentsCongestion(int i)
    {
        return errorCodeRepresentsCongestion(String.valueOf(i));
    }

    public static boolean errorCodeRepresentsCongestion(String s)
    {
        return s != null && recoverableErrorCodes.contains(s);
    }

    static boolean isRecoverableError(String s)
    {
        return errorCodeRepresentsCongestion(s);
    }

    static 
    {
        recoverableErrorCodes = new HashSet();
        recoverableErrorCodes.add("10007");
        recoverableErrorCodes.add("17460");
    }
}
