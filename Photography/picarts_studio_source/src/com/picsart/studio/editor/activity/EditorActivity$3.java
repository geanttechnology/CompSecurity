// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.activity;

import android.content.SharedPreferences;
import com.socialin.android.picsart.profile.invite.i;

// Referenced classes of package com.picsart.studio.editor.activity:
//            EditorActivity

final class a
    implements Runnable
{

    private EditorActivity a;

    public final void run()
    {
        i.a(a.getApplicationContext()).edit().remove("invite_new_user_redeem_dialog_stop").apply();
        i.a(a, 0L);
    }

    _cls9(EditorActivity editoractivity)
    {
        a = editoractivity;
        super();
    }
}
