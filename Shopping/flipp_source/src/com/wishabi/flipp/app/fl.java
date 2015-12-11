// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.widget.CompoundButton;

// Referenced classes of package com.wishabi.flipp.app:
//            fg

final class fl
    implements android.widget.CompoundButton.OnCheckedChangeListener
{

    final fg a;

    fl(fg fg1)
    {
        a = fg1;
        super();
    }

    public final void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        fg.e(a);
    }
}
