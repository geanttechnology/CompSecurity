// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            m

final class a
    implements android.view..OnClickListener
{

    private Spinner a;

    public final void onClick(View view)
    {
        a.performClick();
    }

    (Spinner spinner)
    {
        a = spinner;
        super();
    }
}
