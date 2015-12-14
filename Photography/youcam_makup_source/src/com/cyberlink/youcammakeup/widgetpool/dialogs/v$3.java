// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.widget.CompoundButton;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            v

class a
    implements android.widget.oundButton.OnCheckedChangeListener
{

    final v a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        v.a(a, Boolean.valueOf(flag));
    }

    ner(v v1)
    {
        a = v1;
        super();
    }
}
