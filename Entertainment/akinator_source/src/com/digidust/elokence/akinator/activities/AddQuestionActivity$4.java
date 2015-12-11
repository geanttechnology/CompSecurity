// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AddQuestionActivity

class val.pos
    implements android.content.kListener
{

    final AddQuestionActivity this$0;
    final int val$pos;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((muleObjectAnswer)AddQuestionActivity.access$100(AddQuestionActivity.this).get(val$pos)).setAnswer(i - 1);
    }

    muleObjectAnswer()
    {
        this$0 = final_addquestionactivity;
        val$pos = I.this;
        super();
    }
}
