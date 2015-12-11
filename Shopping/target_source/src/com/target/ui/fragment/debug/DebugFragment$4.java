// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import android.widget.CompoundButton;
import com.target.ui.util.i;

// Referenced classes of package com.target.ui.fragment.debug:
//            DebugFragment

class this._cls0
    implements android.widget.nCheckedChangeListener
{

    final DebugFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (i.b(getActivity()) != flag)
        {
            i.a(flag, getActivity());
            DebugFragment.d(DebugFragment.this, true);
            a();
        }
    }

    Listener()
    {
        this$0 = DebugFragment.this;
        super();
    }
}
