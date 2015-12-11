// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.os.Handler;

// Referenced classes of package com.groupon.view:
//            TypewriterTextView

class this._cls0
    implements Runnable
{

    final TypewriterTextView this$0;

    public void run()
    {
        setText(TypewriterTextView.access$100(TypewriterTextView.this).subSequence(0, TypewriterTextView.access$510(TypewriterTextView.this)));
        if (TypewriterTextView.access$500(TypewriterTextView.this) >= 0)
        {
            TypewriterTextView.access$400(TypewriterTextView.this).postDelayed(TypewriterTextView.access$600(TypewriterTextView.this), TypewriterTextView.access$300(TypewriterTextView.this));
        }
    }

    ()
    {
        this$0 = TypewriterTextView.this;
        super();
    }
}
