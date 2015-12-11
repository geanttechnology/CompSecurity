// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder.adapters;

import com.bitstrips.outfitbuilder.OBCatalogDisplayable;

// Referenced classes of package com.bitstrips.outfitbuilder.adapters:
//            OBCatalogArrayAdapter

public static class data
{

    OBCatalogDisplayable data;
    int dataViewRepresentation;

    public int getSpanRepresentation(int i)
    {
        switch (dataViewRepresentation)
        {
        default:
            i = 0;
            // fall through

        case 1: // '\001'
        case 2: // '\002'
            return i;

        case 0: // '\0'
            return 1;
        }
    }

    public (int i, OBCatalogDisplayable obcatalogdisplayable)
    {
        dataViewRepresentation = i;
        data = obcatalogdisplayable;
    }
}
