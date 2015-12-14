// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import android.widget.CompoundButton;

// Referenced classes of package com.millennialmedia.internal.video:
//            InlineWebVideoView

class this._cls0
    implements android.widget.kedChangeListener
{

    final InlineWebVideoView this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        InlineWebVideoView.access$000(InlineWebVideoView.this);
        if (flag)
        {
            InlineWebVideoView.access$1100(InlineWebVideoView.this);
        }
    }

    ()
    {
        this$0 = InlineWebVideoView.this;
        super();
    }
}
