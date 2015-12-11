// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            CvExpandActivity

class this._cls0
    implements Runnable
{

    final CvExpandActivity this$0;

    public void run()
    {
        if (CvExpandActivity.access$000(CvExpandActivity.this) != null)
        {
            CvExpandActivity.access$000(CvExpandActivity.this).run();
        } else
        {
            finish();
        }
        CvExpandActivity.access$002(CvExpandActivity.this, null);
    }

    ()
    {
        this$0 = CvExpandActivity.this;
        super();
    }
}
