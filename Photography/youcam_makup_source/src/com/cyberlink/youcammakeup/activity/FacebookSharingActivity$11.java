// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookSharingActivity

class a
    implements android.view.bookSharingActivity._cls11
{

    final FacebookSharingActivity a;

    public void onClick(View view)
    {
        view = " #";
        int i = Math.max(FacebookSharingActivity.k(a).getSelectionStart(), 0);
        int j = Math.max(FacebookSharingActivity.k(a).getSelectionEnd(), 0);
        String s = FacebookSharingActivity.k(a).getText().toString();
        if (i == 0 || !FacebookSharingActivity.a(a, i, s))
        {
            view = "#";
        }
        FacebookSharingActivity.k(a).getText().replace(i, j, view, 0, view.length());
    }

    (FacebookSharingActivity facebooksharingactivity)
    {
        a = facebooksharingactivity;
        super();
    }
}
