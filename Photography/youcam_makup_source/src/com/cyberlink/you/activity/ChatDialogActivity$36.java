// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.cyberlink.you.k;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class a
    implements android.view.ogActivity._cls36
{

    final ChatDialogActivity a;

    public void onClick(View view)
    {
        ChatDialogActivity.f(a).startAnimation(AnimationUtils.loadAnimation(ChatDialogActivity.g(a), k.exit_to_bottom));
        ChatDialogActivity.f(a).setVisibility(4);
        ChatDialogActivity.b(a, false);
    }

    (ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
