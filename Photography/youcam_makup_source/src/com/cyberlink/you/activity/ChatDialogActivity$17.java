// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.view.MotionEvent;

// Referenced classes of package com.cyberlink.you.activity:
//            ChatDialogActivity

class ner extends android.view.OnGestureListener
{

    final ChatDialogActivity a;

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        ChatDialogActivity.c(a, false);
        return false;
    }

    ner(ChatDialogActivity chatdialogactivity)
    {
        a = chatdialogactivity;
        super();
    }
}
