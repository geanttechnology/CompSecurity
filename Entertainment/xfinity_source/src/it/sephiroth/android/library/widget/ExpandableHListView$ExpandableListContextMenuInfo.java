// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.View;

// Referenced classes of package it.sephiroth.android.library.widget:
//            ExpandableHListView

public static class id
    implements android.view.bleListContextMenuInfo
{

    public long id;
    public long packedPosition;
    public View targetView;

    public (View view, long l, long l1)
    {
        targetView = view;
        packedPosition = l;
        id = l1;
    }
}
