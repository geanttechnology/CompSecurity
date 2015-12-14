// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.util.Log;
import go;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditFontActivity

class a
    implements go
{

    final ProEditFontActivity a;

    public void a()
    {
        a.setResult(-1);
        a.c();
        a.finish();
        a.overridePendingTransition(0, 0x7f040027);
        Log.e("ProEditFontActivity", "font save finish");
    }

    (ProEditFontActivity proeditfontactivity)
    {
        a = proeditfontactivity;
        super();
    }
}
