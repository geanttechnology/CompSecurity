// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.view.View;
import com.groupon.models.hotel.Destination;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchFragment, GetawaysSearchViewPresenter

private class <init>
    implements android.view.nClickListener
{

    private final Destination destination;
    final GetawaysSearchFragment this$0;

    public void onClick(View view)
    {
        GetawaysSearchFragment.access$500(GetawaysSearchFragment.this).onRecentlySearchedDestinationClicked(destination);
    }

    private (Destination destination1)
    {
        this$0 = GetawaysSearchFragment.this;
        super();
        destination = destination1;
    }

    destination(Destination destination1, destination destination2)
    {
        this(destination1);
    }
}
