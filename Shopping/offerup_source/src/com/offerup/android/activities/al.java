// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            ChangeLocationActivity, ar

final class al
    implements android.widget.TextView.OnEditorActionListener
{

    private EditText a;
    private ChangeLocationActivity b;

    al(ChangeLocationActivity changelocationactivity, EditText edittext)
    {
        b = changelocationactivity;
        a = edittext;
        super();
    }

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
label0:
        {
            if (i == 6)
            {
                textview = a.getText().toString();
                if (!StringUtils.isNotEmpty(textview) || !ChangeLocationActivity.a(textview))
                {
                    break label0;
                }
                b.a(new ar(b, b, textview, true, true, b.getString(0x7f090147)), new Object[0]);
            }
            return false;
        }
        b.m();
        return false;
    }
}
