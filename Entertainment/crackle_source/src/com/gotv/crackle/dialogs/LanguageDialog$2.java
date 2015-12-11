// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.content.Intent;
import android.view.View;
import com.gotv.crackle.captions.CaptionsActivity;

// Referenced classes of package com.gotv.crackle.dialogs:
//            LanguageDialog

class this._cls0
    implements android.view.ner
{

    final LanguageDialog this$0;

    public void onClick(View view)
    {
        view = new Intent(getActivity(), com/gotv/crackle/captions/CaptionsActivity);
        startActivity(view);
    }

    ()
    {
        this$0 = LanguageDialog.this;
        super();
    }
}
