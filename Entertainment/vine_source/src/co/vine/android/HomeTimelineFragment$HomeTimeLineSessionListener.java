// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.FrameLayout;
import co.vine.android.api.VineClientFlags;
import co.vine.android.util.ClientFlagsHelper;

// Referenced classes of package co.vine.android:
//            HomeTimelineFragment

private class <init> extends <init>
{

    final HomeTimelineFragment this$0;

    public void onFetchClientFlagsComplete(String s, int i, String s1, VineClientFlags vineclientflags, boolean flag)
    {
        super.tchClientFlagsComplete(s, i, s1, vineclientflags, flag);
        if (i == 200 && isFocused() && HomeTimelineFragment.access$100(HomeTimelineFragment.this) != null && flag)
        {
            HomeTimelineFragment.access$100(HomeTimelineFragment.this).setVisibility(8);
        }
    }

    public void onMobileDataNetworkActivated()
    {
        super.bileDataNetworkActivated();
        if (ClientFlagsHelper.shouldShowClientFlagsBanner(getActivity()) && isFocused() && HomeTimelineFragment.access$100(HomeTimelineFragment.this) != null)
        {
            HomeTimelineFragment.access$100(HomeTimelineFragment.this).setVisibility(8);
        }
    }

    private ()
    {
        this$0 = HomeTimelineFragment.this;
        super(HomeTimelineFragment.this);
    }

    t>(t> t>)
    {
        this();
    }
}
