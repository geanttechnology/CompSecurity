// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            am

static final class c
    implements android.view.OnClickListener
{

    final EditText a;
    final c b;
    final Dialog c;

    public void onClick(View view)
    {
        if (((Integer)view.getTag()).intValue() != 0) goto _L2; else goto _L1
_L1:
        view = null;
        String s = a.getText().toString();
        view = s;
_L8:
        if (view != null) goto _L4; else goto _L3
_L3:
        b.a(c);
_L6:
        return;
_L4:
        b.a(c, view);
        return;
_L2:
        if (((Integer)view.getTag()).intValue() != 1) goto _L6; else goto _L5
_L5:
        b.a(c);
        return;
        Exception exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    (EditText edittext,  , Dialog dialog)
    {
        a = edittext;
        b = ;
        c = dialog;
        super();
    }
}
