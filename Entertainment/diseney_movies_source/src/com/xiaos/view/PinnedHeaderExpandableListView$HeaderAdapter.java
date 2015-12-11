// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xiaos.view;

import android.view.View;

// Referenced classes of package com.xiaos.view:
//            PinnedHeaderExpandableListView

public static interface A
{

    public static final int PINNED_HEADER_GONE = 0;
    public static final int PINNED_HEADER_PUSHED_UP = 2;
    public static final int PINNED_HEADER_VISIBLE = 1;

    public abstract void configureHeader(View view, int i, int j, int k);

    public abstract int getGroupClickStatus(int i);

    public abstract int getHeaderState(int i, int j);

    public abstract void setGroupClickStatus(int i, int j);
}
