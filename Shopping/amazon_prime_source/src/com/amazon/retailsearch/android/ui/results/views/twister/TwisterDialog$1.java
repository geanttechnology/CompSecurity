// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.views.twister;

import android.view.View;
import com.amazon.retailsearch.log.MessageLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.views.twister:
//            TwisterDialog

class this._cls0
    implements android.view.ener
{

    final TwisterDialog this$0;

    public void onClick(View view)
    {
        try
        {
            dismiss();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            TwisterDialog.access$000().error("Could not dismiss dialog", view);
        }
    }

    ()
    {
        this$0 = TwisterDialog.this;
        super();
    }
}
