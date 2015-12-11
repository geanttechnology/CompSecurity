// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.view.KeyEvent;
import android.widget.TextView;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            SearchActivity

class a
    implements android.widget.ActionListener
{

    final SearchActivity a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        SearchActivity.a(a);
        return true;
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
