// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AddQuestionActivity

class this._cls0
    implements android.widget.kListener
{

    final AddQuestionActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        showAnswerSelector(i);
    }

    ()
    {
        this$0 = AddQuestionActivity.this;
        super();
    }
}
