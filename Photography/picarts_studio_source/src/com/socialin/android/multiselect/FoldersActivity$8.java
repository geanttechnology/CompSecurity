// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.multiselect;

import android.widget.HorizontalScrollView;

// Referenced classes of package com.socialin.android.multiselect:
//            FoldersActivity

final class a
    implements Runnable
{

    private FoldersActivity a;

    public final void run()
    {
        FoldersActivity.f(a).fullScroll(66);
        FoldersActivity.f(a).invalidate();
    }

    (FoldersActivity foldersactivity)
    {
        a = foldersactivity;
        super();
    }
}
