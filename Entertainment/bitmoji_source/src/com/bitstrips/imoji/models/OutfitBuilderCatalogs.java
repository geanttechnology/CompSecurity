// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.models;

import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBCatalog;

public class OutfitBuilderCatalogs
{

    OBCatalog femaleCatalog;
    OBCatalog maleCatalog;

    public OutfitBuilderCatalogs(OBCatalog obcatalog, OBCatalog obcatalog1)
    {
        maleCatalog = obcatalog;
        femaleCatalog = obcatalog1;
    }

    public OBCatalog getCatalogForData(OBAvatarData obavatardata)
    {
        if (obavatardata.getGender() == OBAvatarData.FEMALE)
        {
            return femaleCatalog;
        } else
        {
            return maleCatalog;
        }
    }

    public OBCatalog getFemaleCatalog()
    {
        return femaleCatalog;
    }

    public OBCatalog getMaleCatalog()
    {
        return maleCatalog;
    }
}
