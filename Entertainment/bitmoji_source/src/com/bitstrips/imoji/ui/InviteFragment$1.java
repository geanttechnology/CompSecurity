// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.ui.views.ImojiView;
import com.crashlytics.android.Crashlytics;
import com.squareup.picasso.Callback;

// Referenced classes of package com.bitstrips.imoji.ui:
//            InviteFragment

class this._cls0
    implements Callback
{

    final InviteFragment this$0;

    public void onError()
    {
        Crashlytics.log(String.format("%s - Failure to load template: %s", new Object[] {
            "InviteFragment", InviteFragment.access$100(InviteFragment.this)
        }));
    }

    public void onSuccess()
    {
        InviteFragment.access$000(InviteFragment.this).setScaleType(android.widget.pe.FIT_XY);
    }

    ()
    {
        this$0 = InviteFragment.this;
        super();
    }
}
