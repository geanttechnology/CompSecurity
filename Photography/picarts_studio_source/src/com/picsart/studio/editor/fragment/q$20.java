// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.item.BrushEditableItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.photo.clipart.a;
import com.socialin.android.photo.clipart.b;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.OnClickListener
{

    private q a;

    public final void onClick(View view)
    {
        Object obj = new b();
        obj.a = a.getString(0x7f0805fb);
        obj.f = 0x7f030047;
        obj.h = false;
        view = (BrushEditableItem)com.picsart.studio.editor.fragment.q.a(a).h();
        obj = new a(((b) (obj)).a, ((b) (obj)).e, ((b) (obj)).b, ((b) (obj)).f, ((b) (obj)).g, ((b) (obj)).h, ((b) (obj)).k, ((b) (obj)).l, ((b) (obj)).m, ((b) (obj)).o, ((b) (obj)).n, ((b) (obj)).p, ((b) (obj)).d, ((b) (obj)).c, (byte)0);
        com.socialin.android.photo.clipart.a.a(((a) (obj)), view);
        ((a) (obj)).setRetainInstance(true);
        ((a) (obj)).show(a.getFragmentManager(), "BRUSH_SETTINGS_DIALOG");
    }

    ableItem(q q1)
    {
        a = q1;
        super();
    }
}
