// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.activities;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.abtnprojects.ambatana.ui.activities:
//            c

class a
    implements android.content.ogInterface.OnClickListener
{

    final c a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
        a.startActivity(dialoginterface);
    }

    ner(c c1)
    {
        a = c1;
        super();
    }
}
