// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.View;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AdapterView

public static class id
    implements android.view.AdapterContextMenuInfo
{

    public long id;
    public int position;
    public View targetView;

    public (View view, int i, long l)
    {
        targetView = view;
        position = i;
        id = l;
    }
}
