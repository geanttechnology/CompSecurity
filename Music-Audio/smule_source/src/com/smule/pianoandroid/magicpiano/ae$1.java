// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import com.smule.android.c.a;
import com.smule.android.c.i;
import com.smule.android.c.n;
import com.smule.android.c.o;
import com.smule.magicpiano.PianoCoreBridge;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ae

class a
    implements android.view.OnClickListener
{

    final ae a;

    public void onClick(View view)
    {
        com.smule.android.c.a.b(com.smule.pianoandroid.magicpiano.ae.a(), o.b, n.a, i.a, PianoCoreBridge.getEnsembleAnalyticsType());
        ae.b(a).execute(new String[] {
            com.smule.pianoandroid.magicpiano.ae.a(a).getText().toString()
        });
        a.dismiss();
    }

    (ae ae1)
    {
        a = ae1;
        super();
    }
}
