// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Activity;
import com.comcast.cim.android.view.launch.AuthenticatingFragment;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.cim.android.view.common:
//            Searchable

public abstract class SearchableFragment extends AuthenticatingFragment
{

    protected Searchable searchable;

    public SearchableFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof Searchable)
        {
            searchable = (Searchable)activity;
            return;
        } else
        {
            LOG.error("Activity must implement Searchable");
            return;
        }
    }
}
