// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.editor.view.FrameEditorView;
import java.util.List;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            l

final class a
    implements android.widget.erView.OnItemSelectedListener
{

    private l a;

    public final void onItemSelected(AdapterView adapterview, View view, int i, long l1)
    {
        l.a(a).setOverlayBlendingMode(((Integer)l.d(a).get(i)).intValue());
    }

    public final void onNothingSelected(AdapterView adapterview)
    {
    }

    orView(l l1)
    {
        a = l1;
        super();
    }
}
