// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.cyberlink.beautycircle.controller.fragment.TopBarFragment;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            SearchActivity

public class o
    implements TextWatcher
{

    final SearchActivity a;
    private boolean b;

    public o(SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
        b = false;
    }

    public void a(boolean flag)
    {
        b = flag;
        if (SearchActivity.l(a) != null)
        {
            SearchActivity.l(a).b(flag);
        }
    }

    public void afterTextChanged(Editable editable)
    {
        if (!SearchActivity.p(a).isEmpty())
        {
            return;
        }
        if (editable.length() != 0) goto _L2; else goto _L1
_L1:
        a(false);
_L4:
        SearchActivity.d(a).removeCallbacks(SearchActivity.v(a));
        SearchActivity.d(a).postDelayed(SearchActivity.v(a), 1500L);
        return;
_L2:
        if (!b)
        {
            a(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }
}
