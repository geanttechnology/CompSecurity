// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.offerup.android.activities:
//            SendMessageActivity

final class hk
    implements android.view.View.OnClickListener
{

    private EditText a;
    private SendMessageActivity b;

    hk(SendMessageActivity sendmessageactivity, EditText edittext)
    {
        b = sendmessageactivity;
        a = edittext;
        super();
    }

    public final void onClick(View view)
    {
        b.b = a.getText().toString();
        SendMessageActivity.a(b);
    }
}
