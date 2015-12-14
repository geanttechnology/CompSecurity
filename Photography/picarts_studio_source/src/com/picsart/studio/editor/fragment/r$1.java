// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.ResetAction;
import com.picsart.studio.editor.history.a;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            r

final class a
    implements android.view..OnClickListener
{

    private r a;

    public final void onClick(View view)
    {
        Object obj = (EditorActivity)a.getActivity();
        if (obj == null) goto _L2; else goto _L1
_L1:
        com.picsart.studio.editor.fragment.r.a(a);
        view.getId();
        JVM INSTR lookupswitch 6: default 84
    //                   2131755939: 99
    //                   2131756401: 143
    //                   2131756477: 85
    //                   2131756478: 165
    //                   2131756479: 157
    //                   2131756480: 179;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L8:
        break MISSING_BLOCK_LABEL_157;
_L7:
        break MISSING_BLOCK_LABEL_165;
_L3:
        break; /* Loop/switch isn't completed */
_L9:
        break MISSING_BLOCK_LABEL_179;
_L2:
        return;
_L6:
        ((EditorActivity)a.getActivity()).c();
        return;
_L4:
        view.setEnabled(false);
        ((EditorActivity) (obj)).d();
        view = e.a();
        if (((e) (view)).c != null)
        {
            obj = ((e) (view)).c;
            ((a) (obj)).c.execute(new com.picsart.studio.editor.history.<init>(((a) (obj)), view));
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        e.a().b(new ResetAction());
        return;
        ((EditorActivity) (obj)).a(Tool.GIFEXPORT);
        return;
        ((EditorActivity)a.getActivity()).f();
        return;
        (new com.picsart.studio.editor.activity.orActivity._cls12((EditorActivity)a.getActivity())).execute(new Void[0]);
        return;
    }

    orActivity._cls12(r r1)
    {
        a = r1;
        super();
    }
}
