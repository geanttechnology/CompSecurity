// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls0
    implements android.view.
{

    final GameOverActivity this$0;

    public void onClick(View view)
    {
        if (GameOverActivity.access$1200(GameOverActivity.this).getVisibility() == 0)
        {
            goToStoreItems();
            return;
        } else
        {
            goToStore();
            return;
        }
    }

    ()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}
