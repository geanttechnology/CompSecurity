// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.typeahead;

import com.target.mothership.model.c;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.typeahead:
//            a, b

class d extends c
    implements a
{

    private b mProductSuggestionLiveDataSource;

    public d()
    {
        mProductSuggestionLiveDataSource = new b();
    }

    public void a(String s, h h)
    {
        a("typeahead.json");
        mProductSuggestionLiveDataSource.a(s, h);
    }
}
