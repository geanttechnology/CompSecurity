// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.g:
//            j

public final class i extends Fragment
{

    private int a;
    private int b[] = {
        0x7f04007f, 0x7f040080
    };

    public i()
    {
        a = 0;
    }

    public final void a(int k)
    {
        a = k;
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(b[a], viewgroup, false);
        if (a == 1)
        {
            viewgroup = (TextView)layoutinflater.findViewById(0x7f1001db);
            viewgroup.setText(Html.fromHtml(String.format(getResources().getString(0x7f090113), new Object[] {
                "https://offerupnow.com/"
            })));
            viewgroup.setOnClickListener(new j(this));
        }
        return layoutinflater;
    }
}
