// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.app.Fragment;
import android.os.Bundle;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchFragment, GetawaysSearchViewPresenter

public static class  extends Fragment
{

    private GetawaysSearchViewPresenter presenter;

    public GetawaysSearchViewPresenter getPresenter()
    {
        return presenter;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void setPresenter(GetawaysSearchViewPresenter getawayssearchviewpresenter)
    {
        presenter = getawayssearchviewpresenter;
    }

    public ()
    {
    }
}
