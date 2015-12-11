// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead;

import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.h;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.typeahead:
//            d, b, a

public class c extends a
{

    private com.target.mothership.model.typeahead.a mProductSuggestion;

    public c()
    {
        if (b.a().m())
        {
            mProductSuggestion = new d();
            return;
        } else
        {
            mProductSuggestion = new com.target.mothership.model.typeahead.b();
            return;
        }
    }

    public void a(String s, h h1)
    {
        if (s == null)
        {
            h1.a(x.a("Suggestion query cannot be null").a());
            return;
        } else
        {
            mProductSuggestion.a(s, h1);
            return;
        }
    }
}
