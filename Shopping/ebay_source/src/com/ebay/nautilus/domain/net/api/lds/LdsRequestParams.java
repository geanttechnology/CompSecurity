// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.listingdraft.ListingDraftOperation;
import java.util.ArrayList;
import java.util.HashMap;

public class LdsRequestParams
{

    public final ArrayList deletedValues = new ArrayList();
    public boolean fullValidation;
    public String iafToken;
    public String id;
    public ArrayList intlShipLocations1;
    public ArrayList intlShipLocations2;
    public ArrayList intlShipLocations3;
    public ArrayList intlShipLocations4;
    public ArrayList intlShipLocations5;
    public final ArrayList itemSpecifics = new ArrayList();
    public String listingMode;
    public final ListingDraftOperation operation;
    public final ArrayList pictureUrls = new ArrayList();
    public EbaySite site;
    public String sourceItemId;
    public final HashMap values = new HashMap();

    public LdsRequestParams(ListingDraftOperation listingdraftoperation)
    {
        intlShipLocations1 = new ArrayList();
        intlShipLocations2 = new ArrayList();
        intlShipLocations3 = new ArrayList();
        intlShipLocations4 = new ArrayList();
        intlShipLocations5 = new ArrayList();
        fullValidation = false;
        if (listingdraftoperation == null)
        {
            throw new IllegalArgumentException("Construct LdsRequestParams with an operation");
        } else
        {
            operation = listingdraftoperation;
            return;
        }
    }
}
