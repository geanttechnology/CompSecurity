// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.view.View;
import android.widget.EditText;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.account:
//            GuestNameViewStatic

static class lastName extends a
{

    EditText firstName;
    EditText lastName;
    View root;

    (View view)
    {
        super(view);
        root = view;
        firstName = (EditText)view.findViewById(0x7f1002d7);
        lastName = (EditText)view.findViewById(0x7f1002d9);
    }
}
