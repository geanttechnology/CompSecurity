// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.widgets;

import android.widget.CompoundButton;

// Referenced classes of package com.abtnprojects.ambatana.ui.widgets:
//            RevealablePasswordContainer

class a
    implements android.widget.ntainer..ViewBinder._cls1
{

    final RevealablePasswordContainer a;
    final rdChecked b;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        a.onRevealPasswordChecked(flag);
    }

    ( , RevealablePasswordContainer revealablepasswordcontainer)
    {
        b = ;
        a = revealablepasswordcontainer;
        super();
    }
}
