// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import java.util.List;

// Referenced classes of package com.picsart.studio.ads:
//            MoPubRecyclerAdapter

final class a
    implements com.mopub.nativeads.ilityTrackerListener
{

    private MoPubRecyclerAdapter a;

    public final void onVisibilityChanged(List list, List list1)
    {
        MoPubRecyclerAdapter.access$100(a, list);
    }

    tyTrackerListener(MoPubRecyclerAdapter mopubrecycleradapter)
    {
        a = mopubrecycleradapter;
        super();
    }
}
