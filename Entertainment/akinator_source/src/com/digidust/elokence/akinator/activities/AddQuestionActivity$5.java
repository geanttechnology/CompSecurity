// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import com.digidust.elokence.akinator.adapters.AkCharacterAnswerAdapter;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AddQuestionActivity

class this._cls0
    implements android.content.kListener
{

    final AddQuestionActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        akCharacterAnswerAdapter.notifyDataSetChanged();
    }

    ()
    {
        this$0 = AddQuestionActivity.this;
        super();
    }
}
