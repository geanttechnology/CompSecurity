// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.os.Bundle;
import android.view.View;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.view.ItemEditorView;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.OnClickListener
{

    private q a;

    public final void onClick(View view)
    {
        if (!(q.a(a).h() instanceof ImageItem)) goto _L2; else goto _L1
_L1:
        android.graphics.Bitmap bitmap;
        Bundle bundle;
        bitmap = ((ImageItem)q.a(a).h()).h;
        bundle = new Bundle(1);
        bundle.putString("source", "editor_photo");
        view.getId();
        JVM INSTR lookupswitch 6: default 112
    //                   2131755024: 248
    //                   2131755028: 113
    //                   2131755029: 221
    //                   2131756452: 140
    //                   2131756453: 167
    //                   2131756454: 194;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        return;
_L4:
        ((EditorActivity)a.getActivity()).a(Tool.EFFECT, q.d(a), bitmap, bundle, false);
        return;
_L6:
        ((EditorActivity)a.getActivity()).a(Tool.CROP, q.d(a), bitmap, bundle, false);
        return;
_L7:
        ((EditorActivity)a.getActivity()).a(Tool.SHAPE_CROP, q.d(a), bitmap, bundle, false);
        return;
_L8:
        ((EditorActivity)a.getActivity()).a(Tool.FREE_CROP, q.d(a), bitmap, bundle, false);
        return;
_L5:
        ((EditorActivity)a.getActivity()).a(Tool.FRAME_PHOTO, q.d(a), bitmap, bundle, false);
        return;
_L3:
        ((EditorActivity)a.getActivity()).a(Tool.BORDER, q.d(a), bitmap, bundle, false);
        return;
    }

    rActivity(q q1)
    {
        a = q1;
        super();
    }
}
