// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import android.view.View;
import android.widget.EditText;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.Store;
import com.target.ui.helper.k.a;
import com.target.ui.util.ai;
import com.target.ui.util.i;

// Referenced classes of package com.target.ui.fragment.debug:
//            DebugFragment

class this._cls0
    implements android.view.ener
{

    final DebugFragment this$0;

    public void onClick(View view)
    {
        if (getActivity() == null)
        {
            return;
        }
        view = DebugFragment.b(DebugFragment.this).storeIdEditText.getText().toString();
        if (view.isEmpty())
        {
            i.a(view, getActivity());
            view = DebugFragment.c(DebugFragment.this);
            if (view != null)
            {
                view = view.getStoreId().a();
                DebugFragment.d(DebugFragment.this).a(new <init>(DebugFragment.this, view), view);
            }
            ai.a(getActivity(), "debug store id cleared. starting normal vlc");
            return;
        } else
        {
            DebugFragment.c(DebugFragment.this, true);
            DebugFragment.d(DebugFragment.this).a(new <init>(DebugFragment.this, view), view);
            return;
        }
    }

    ifier()
    {
        this$0 = DebugFragment.this;
        super();
    }
}
