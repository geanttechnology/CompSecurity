// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.View;

// Referenced classes of package com.socialin.android.activity:
//            WhatsNewActivity

final class a
    implements android.view.r
{

    private com.socialin.android.apiv3.model.atsNewItem a;
    private WhatsNewActivity b;

    public final void onClick(View view)
    {
        if (WhatsNewActivity.access$400(b) > 0)
        {
            WhatsNewActivity.access$500(b);
            return;
        } else
        {
            WhatsNewActivity.access$600(b, a);
            return;
        }
    }

    .WhatsNewItem(WhatsNewActivity whatsnewactivity, com.socialin.android.apiv3.model.atsNewItem atsnewitem)
    {
        b = whatsnewactivity;
        a = atsnewitem;
        super();
    }
}
