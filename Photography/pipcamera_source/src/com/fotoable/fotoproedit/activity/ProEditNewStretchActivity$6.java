// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity;

import android.app.ProgressDialog;
import go;

// Referenced classes of package com.fotoable.fotoproedit.activity:
//            ProEditNewStretchActivity

class a
    implements go
{

    final ProEditNewStretchActivity a;

    public void a()
    {
        a.setResult(-1);
        a.j.dismiss();
        a.finish();
        a.overridePendingTransition(0, 0x7f040027);
    }

    (ProEditNewStretchActivity proeditnewstretchactivity)
    {
        a = proeditnewstretchactivity;
        super();
    }
}
