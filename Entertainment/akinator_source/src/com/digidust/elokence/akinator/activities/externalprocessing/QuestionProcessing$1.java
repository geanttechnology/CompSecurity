// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities.externalprocessing;

import android.widget.Button;
import android.widget.RelativeLayout;

// Referenced classes of package com.digidust.elokence.akinator.activities.externalprocessing:
//            QuestionProcessing

class this._cls0
    implements Runnable
{

    final QuestionProcessing this$0;

    public void run()
    {
        QuestionProcessing.access$000(QuestionProcessing.this).setVisibility(8);
        QuestionProcessing.access$100(QuestionProcessing.this).setVisibility(8);
    }

    ()
    {
        this$0 = QuestionProcessing.this;
        super();
    }
}
