// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.Tool;
import com.picsart.studio.editor.e;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class b
    implements Runnable
{

    private Bundle a;
    private questCode b;
    private EditorActivity c;

    public final void run()
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        a.putString("source", "editor");
        b[b.ordinal()];
        JVM INSTR tableswitch 1 11: default 88
    //                   1 89
    //                   2 115
    //                   3 141
    //                   4 167
    //                   5 193
    //                   6 256
    //                   7 282
    //                   8 308
    //                   9 364
    //                   10 364
    //                   11 457;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L11 _L12
_L2:
        return;
_L3:
        c.a(Tool.TEXT, c, e.a().b, a, true);
        return;
_L4:
        c.a(Tool.CALLOUT, c, e.a().b, a, true);
        return;
_L5:
        c.a(Tool.LENS_FLARE, c, e.a().b, a, true);
        return;
_L6:
        c.a(Tool.CLIPART, c, e.a().b, a, true);
        return;
_L7:
        c.a(Tool.PHOTO, c, e.a().b, a, true);
        i.a(c.getApplicationContext()).edit().remove("invite_new_user_redeem_dialog_stop").apply();
        i.a(c, 2000L);
        return;
_L8:
        c.a(Tool.FRAME, c, e.a().b, a, true);
        return;
_L9:
        c.a(Tool.STICKER, c, e.a().b, a, true);
        return;
_L10:
        AnalyticUtils.getInstance(c).track(new com.socialin.android.apiv3.events.tToolsApplyEvent("tool_resize"));
        e.a().e.c("resize");
        EditorActivity.a(c, a.getInt("width"), a.getInt("height"));
        return;
_L11:
        String s = a.getString("dstPath");
        android.graphics.rmat rmat1 = (android.graphics.rmat)a.getSerializable("format");
        String s1 = a.getString("fileExtension", "");
        android.graphics.rmat rmat = rmat1;
        if (rmat1 == null)
        {
            if (".jpg".equals(s1))
            {
                rmat = android.graphics.rmat.JPEG;
            } else
            {
                rmat = rmat1;
                if (".png".equals(s1))
                {
                    rmat = android.graphics.rmat.PNG;
                }
            }
        }
        EditorActivity.a(c, e.a().c(), s, rmat, s1);
        return;
_L12:
        EditorActivity.b(c, a.getString("button"));
        return;
    }

    questCode(EditorActivity editoractivity, Bundle bundle, questCode questcode)
    {
        c = editoractivity;
        a = bundle;
        b = questcode;
        super();
    }
}
