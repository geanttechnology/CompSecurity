// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.deep_link;

import com.target.mothership.common.product.EndecaId;
import java.util.List;

// Referenced classes of package com.target.ui.util.deep_link:
//            r

private static class facets
{

    EndecaId category;
    List facets;

    uct.EndecaId(EndecaId endecaid, List list)
    {
        category = endecaid;
        facets = list;
    }
}
