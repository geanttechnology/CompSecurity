// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.content.Intent;
import android.view.View;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment, EditFollowingActivity

private class <init>
    implements android.view.lickListener
{

    final BrowseFollowingFragment this$0;

    public void onClick(View view)
    {
        Intent intent = new Intent(getActivity(), com/ebay/mobile/following/EditFollowingActivity);
        view.getId();
        JVM INSTR lookupswitch 3: default 56
    //                   2131755217: 87
    //                   2131755225: 76
    //                   2131755235: 65;
           goto _L1 _L2 _L3 _L4
_L1:
        startActivity(intent);
        return;
_L4:
        intent.putExtra("followType", 1);
        continue; /* Loop/switch isn't completed */
_L3:
        intent.putExtra("followType", 2);
        continue; /* Loop/switch isn't completed */
_L2:
        intent.putExtra("followType", 3);
        if (true) goto _L1; else goto _L5
_L5:
    }

    private ()
    {
        this$0 = BrowseFollowingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
