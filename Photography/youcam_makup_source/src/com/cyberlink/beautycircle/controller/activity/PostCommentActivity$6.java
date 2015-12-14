// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.utility.AccountManager;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity

class a
    implements android.view.ener
{

    final PostCommentActivity a;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag && AccountManager.b() == null)
        {
            a.i();
            view.clearFocus();
            AccountManager.a(a, null);
        }
    }

    (PostCommentActivity postcommentactivity)
    {
        a = postcommentactivity;
        super();
    }
}
