// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

class this._cls0
    implements android.widget.ongClickListener
{

    final NetworksFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        NetworksFragment.access$1500(NetworksFragment.this, adapterview, i);
        return true;
    }

    ()
    {
        this$0 = NetworksFragment.this;
        super();
    }
}
