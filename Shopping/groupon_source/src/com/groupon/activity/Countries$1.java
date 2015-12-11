// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.widget.TextView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Countries

class val.s
    implements android.widget.rListener
{

    final Countries this$0;
    final CharSequence val$s;

    public void onFilterComplete(int i)
    {
        TextView textview = noItems;
        if (Strings.notEmpty(val$s) && i == 0)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        textview.setVisibility(i);
    }

    ner()
    {
        this$0 = final_countries;
        val$s = CharSequence.this;
        super();
    }
}
