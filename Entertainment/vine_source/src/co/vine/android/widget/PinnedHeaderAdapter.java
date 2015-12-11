// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.view.View;

public interface PinnedHeaderAdapter
{
    public static class PinnedHeaderStatus
    {

        public boolean pinnedHeaderIsVisible;
        public int pinnedHeaderOffset;
        public boolean shouldRequestNewView;

        public PinnedHeaderStatus(int i, boolean flag, boolean flag1)
        {
            pinnedHeaderOffset = i;
            shouldRequestNewView = flag;
            pinnedHeaderIsVisible = flag1;
        }
    }


    public abstract int getPinnedHeaderHeight();

    public abstract PinnedHeaderStatus getPinnedHeaderStatus(int i);

    public abstract View getPinnedHeaderView(View view);

    public abstract void layoutPinnedHeader(View view, int i, int j, int k, int l);
}
