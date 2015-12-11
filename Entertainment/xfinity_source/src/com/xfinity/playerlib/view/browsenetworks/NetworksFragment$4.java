// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.view.View;
import android.widget.AdapterView;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

class this._cls0
    implements android.widget.lickListener
{

    final NetworksFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        NetworksFragment.access$1400().debug("onItemClick()");
        NetworksFragment.access$1500(NetworksFragment.this, adapterview, i);
    }

    ()
    {
        this$0 = NetworksFragment.this;
        super();
    }
}
