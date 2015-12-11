// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import com.smule.android.f.p;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            aw

class a
    implements android.widget.undButton.OnCheckedChangeListener
{

    final aw a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        compoundbutton = aw.f(a).getSharedPreferences("sharedialog", 0).edit();
        compoundbutton.putBoolean("doNotShow", flag);
        p.a(compoundbutton);
    }

    r(aw aw1)
    {
        a = aw1;
        super();
    }
}
