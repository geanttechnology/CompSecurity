// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.view.View;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment

private class <init>
    implements android.view.lickListener
{

    final BrowseFollowingFragment this$0;

    public void onClick(View view)
    {
        boolean flag;
        boolean flag3;
        boolean flag4;
        flag3 = true;
        flag4 = true;
        flag = true;
        view.getId();
        JVM INSTR lookupswitch 3: default 44
    //                   2131755219: 147
    //                   2131755227: 95
    //                   2131755237: 45;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L4:
        view = BrowseFollowingFragment.this;
        if (isSearchesExpanded)
        {
            flag = false;
        }
        view.expandCollapseSearches(flag);
        if (!isSearchesExpanded)
        {
            scrollToHeader(searchesLayout);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        view = BrowseFollowingFragment.this;
        boolean flag1;
        if (!isMembersExpanded)
        {
            flag1 = flag3;
        } else
        {
            flag1 = false;
        }
        view.expandCollapseMembers(flag1);
        if (!isMembersExpanded)
        {
            scrollToHeader(membersLayout);
            return;
        }
        if (true) goto _L1; else goto _L2
_L2:
        view = BrowseFollowingFragment.this;
        boolean flag2;
        if (!isCollectionsExpanded)
        {
            flag2 = flag4;
        } else
        {
            flag2 = false;
        }
        view.expandCollapseCollections(flag2);
        if (!isCollectionsExpanded)
        {
            scrollToHeader(collectionsLayout);
            return;
        }
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
