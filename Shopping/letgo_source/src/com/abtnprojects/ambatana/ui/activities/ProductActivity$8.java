// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.DialogInterface;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            ProductActivity

class a
    implements android.content.ClickListener
{

    final ProductActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
    }

    (ProductActivity productactivity)
    {
        a = productactivity;
        super();
    }
}
