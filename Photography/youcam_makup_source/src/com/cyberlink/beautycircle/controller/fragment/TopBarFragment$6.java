// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.cyberlink.beautycircle.BaseActivity;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            TopBarFragment, z

class a
    implements android.widget.ActionListener
{

    final TopBarFragment a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        e.b(new Object[] {
            "actionId: ", Integer.valueOf(i), "; KeyEvent: ", keyevent
        });
        if (i != 0)
        {
            return false;
        }
        ((BaseActivity)a.getActivity()).i();
        for (textview = com.cyberlink.beautycircle.controller.fragment.TopBarFragment.e(a).iterator(); textview.hasNext(); ((z)textview.next()).c(TopBarFragment.g(a).getText().toString())) { }
        return true;
    }

    (TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}
