// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget.notifier;

import android.view.View;

// Referenced classes of package co.vine.android.widget.notifier:
//            NotifyableRelativeLayout

class this._cls0
    implements android.view.leRelativeLayout._cls1
{

    final NotifyableRelativeLayout this$0;

    public void onClick(View view)
    {
        if (NotifyableRelativeLayout.access$000(NotifyableRelativeLayout.this) != null)
        {
            NotifyableRelativeLayout.access$000(NotifyableRelativeLayout.this).onNotifyClick();
        }
        NotifyableRelativeLayout.access$100(NotifyableRelativeLayout.this);
    }

    tifierClickListener()
    {
        this$0 = NotifyableRelativeLayout.this;
        super();
    }
}
