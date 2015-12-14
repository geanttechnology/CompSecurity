// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.PopupWindow;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements android.view..OnClickListener
{

    private r a;

    public final void onClick(View view)
    {
        EditorActivity editoractivity;
        r.b(a).dismiss();
        r.a(a);
        editoractivity = (EditorActivity)a.getActivity();
        if (editoractivity == null) goto _L2; else goto _L1
_L1:
        view.getId();
        JVM INSTR lookupswitch 14: default 160
    //                   2131755167: 209
    //                   2131755168: 161
    //                   2131755169: 177
    //                   2131755170: 217
    //                   2131755171: 169
    //                   2131755172: 193
    //                   2131755173: 225
    //                   2131755174: 185
    //                   2131755175: 201
    //                   2131755176: 257
    //                   2131757758: 233
    //                   2131757759: 265
    //                   2131757760: 241
    //                   2131757761: 249;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L2:
        return;
_L4:
        editoractivity.a(Tool.ADJUST);
        return;
_L7:
        editoractivity.a(Tool.TRANSFORM);
        return;
_L5:
        editoractivity.a(Tool.CROP);
        return;
_L10:
        editoractivity.a(Tool.RESIZE);
        return;
_L8:
        editoractivity.a(Tool.FREE_CROP);
        return;
_L11:
        editoractivity.a(Tool.SHAPE_CROP);
        return;
_L3:
        editoractivity.a(Tool.CLONE);
        return;
_L6:
        editoractivity.a(Tool.CURVES);
        return;
_L9:
        editoractivity.a(Tool.MOTION);
        return;
_L13:
        editoractivity.a(Tool.SELECTION);
        return;
_L15:
        editoractivity.a(Tool.ENHANCE);
        return;
_L16:
        editoractivity.a(Tool.TILT_SHIFT);
        return;
_L12:
        editoractivity.a(Tool.STRETCH);
        return;
_L14:
        editoractivity.a(Tool.PERSPECTIVE);
        return;
    }

    orActivity(r r1)
    {
        a = r1;
        super();
    }
}
