// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.content.DialogInterface;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.content.celListener
{

    private SelectionFragment a;

    public final void onCancel(DialogInterface dialoginterface)
    {
        SelectionFragment.Q(a);
    }

    (SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
