// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.test.utils;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.dm.UserContext;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.test.utils.AnnotationHelper;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.test.utils:
//            PreconditionCountry, PreconditionUser

public class TestUserContext extends UserContext
{

    private final AnnotationHelper annotationHelper;

    public TestUserContext(EbayContext ebaycontext, AnnotationHelper annotationhelper)
    {
        super(ebaycontext);
        annotationHelper = annotationhelper;
    }

    protected EbayCountry onInitializeCountry()
    {
        PreconditionCountry preconditioncountry = (PreconditionCountry)annotationHelper.getAnnotation(com/ebay/nautilus/domain/test/utils/PreconditionCountry);
        if (preconditioncountry != null)
        {
            String s = preconditioncountry.value();
            if (s != null && s.length() > 0)
            {
                return EbayCountry.getInstance(preconditioncountry.value());
            }
            int i = preconditioncountry.siteId();
            if (i > -1)
            {
                return EbayCountry.getInstance(EbaySite.getInstanceFromId(i));
            }
        }
        return null;
    }

    protected int onInitializeUser(List list)
    {
        Object obj = (PreconditionUser)annotationHelper.getAnnotation(com/ebay/nautilus/domain/test/utils/PreconditionUser);
        if (obj != null)
        {
            String s = ((PreconditionUser) (obj)).userId();
            obj = ((PreconditionUser) (obj)).iafToken();
            if (s != null && obj != null && s.length() > 0 && ((String) (obj)).length() > 0)
            {
                list.add(createAuth(s, ((String) (obj))));
                return 0;
            }
        }
        return -1;
    }
}
