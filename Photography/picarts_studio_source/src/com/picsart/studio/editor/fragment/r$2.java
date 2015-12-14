// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.socialin.android.photo.g;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements android.view..OnClickListener
{

    private r a;

    public final void onClick(View view)
    {
        EditorActivity editoractivity = (EditorActivity)a.getActivity();
        if (editoractivity == null) goto _L2; else goto _L1
_L1:
        r.a(a);
        view.getId();
        JVM INSTR lookupswitch 14: default 148
    //                   2131755023: 213
    //                   2131755024: 234
    //                   2131755025: 188
    //                   2131755026: 207
    //                   2131755027: 173
    //                   2131755028: 149
    //                   2131755029: 220
    //                   2131755030: 195
    //                   2131755031: 165
    //                   2131755033: 226
    //                   2131755034: 242
    //                   2131755035: 201
    //                   2131755036: 181
    //                   2131756482: 157;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L2:
        return;
_L8:
        editoractivity.a(Tool.EFFECT);
        return;
_L16:
        editoractivity.a(Tool.SQUARE_FIT);
        return;
_L11:
        editoractivity.a(Tool.MASK);
        return;
_L7:
        editoractivity.a(Tool.DRAW);
        return;
_L15:
        editoractivity.a(null, null);
        return;
_L5:
        editoractivity.a(null, null);
        return;
_L10:
        editoractivity.c(null);
        return;
_L14:
        editoractivity.a(null);
        return;
_L6:
        editoractivity.b(null);
        return;
_L3:
        editoractivity.a(null, 0);
        return;
_L9:
        editoractivity.d(null);
        return;
_L12:
        editoractivity.a(Tool.SHAPE_MASK);
        return;
_L4:
        editoractivity.a(Tool.BORDER);
        return;
_L13:
        view = new HashMap();
        view.put("from", "editor");
        g.a(editoractivity, view);
        return;
    }

    orActivity(r r1)
    {
        a = r1;
        super();
    }
}
