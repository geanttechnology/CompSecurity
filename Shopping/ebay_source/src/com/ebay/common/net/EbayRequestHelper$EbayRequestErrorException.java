// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import com.ebay.nautilus.domain.net.EbayResponseError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net:
//            EbayRequestHelper

public static class errors extends IOException
{

    private static final long serialVersionUID = 1L;
    private final ArrayList errors;

    public final ArrayList getErrors()
    {
        return errors;
    }

    public String getMessage()
    {
        StringBuilder stringbuilder = new StringBuilder(10);
        if (errors != null)
        {
            for (Iterator iterator = errors.iterator(); iterator.hasNext(); stringbuilder.append((EbayResponseError)iterator.next()).append('\n')) { }
        }
        return stringbuilder.toString();
    }

    public (ArrayList arraylist)
    {
        if (arraylist == null)
        {
            arraylist = new ArrayList();
        }
        errors = arraylist;
    }

    public errors(List list)
    {
        errors = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            com.ebay.nautilus.kernel.content.  = (com.ebay.nautilus.kernel.content.)list.next();
            if ( instanceof EbayResponseError)
            {
                errors.add((EbayResponseError));
            }
        } while (true);
    }
}
