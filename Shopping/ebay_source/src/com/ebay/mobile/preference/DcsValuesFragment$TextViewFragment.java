// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsValuesFragment

public static final class  extends Fragment
{

    public static final String EXTRA_TEXT = "text";

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        Bundle bundle1 = getArguments();
        layoutinflater = layoutinflater.getContext();
        viewgroup = new ScrollView(layoutinflater);
        bundle = new TextView(layoutinflater);
        if (bundle1 != null)
        {
            layoutinflater = bundle1.getString("text");
        } else
        {
            layoutinflater = null;
        }
        bundle.setText(layoutinflater);
        viewgroup.addView(bundle);
        return viewgroup;
    }

    public ()
    {
    }
}
