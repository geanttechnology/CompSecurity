// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adadapters;

import android.content.Context;
import android.widget.RelativeLayout;

// Referenced classes of package com.millennialmedia.internal.adadapters:
//            AdAdapter

public abstract class InlineAdapter extends AdAdapter
{
    public static interface InlineAdapterListener
    {

        public abstract void displayFailed();

        public abstract void displaySucceeded();

        public abstract void initFailed();

        public abstract void initSucceeded();

        public abstract void onAdLeftApplication();

        public abstract void onClicked();

        public abstract void onCollapsed();

        public abstract void onExpanded();

        public abstract void onResize(int i, int j);

        public abstract void onResized(int i, int j, boolean flag);
    }


    public InlineAdapter()
    {
    }

    public abstract void display(RelativeLayout relativelayout, int i, int j);

    public abstract void init(Context context, InlineAdapterListener inlineadapterlistener);
}
