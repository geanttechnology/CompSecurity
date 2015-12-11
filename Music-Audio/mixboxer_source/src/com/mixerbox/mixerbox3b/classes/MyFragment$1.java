// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.view.View;
import com.mixerbox.mixerbox3b.Onboarding;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyFragment

class this._cls0
    implements android.view.istener
{

    final MyFragment this$0;

    public void onClick(View view)
    {
        ((Onboarding)getActivity()).goToMainPage();
    }

    ()
    {
        this$0 = MyFragment.this;
        super();
    }
}
