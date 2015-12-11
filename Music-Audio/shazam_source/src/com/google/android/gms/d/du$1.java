// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.google.android.gms.d:
//            du

final class a
    implements android.content.gInterface.OnClickListener
{

    final du a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface = a;
        Intent intent = (new Intent("android.intent.action.EDIT")).setData(android.provider.darContract.Events.CONTENT_URI);
        intent.putExtra("title", ((du) (dialoginterface)).b);
        intent.putExtra("eventLocation", ((du) (dialoginterface)).f);
        intent.putExtra("description", ((du) (dialoginterface)).e);
        if (((du) (dialoginterface)).c > -1L)
        {
            intent.putExtra("beginTime", ((du) (dialoginterface)).c);
        }
        if (((du) (dialoginterface)).d > -1L)
        {
            intent.putExtra("endTime", ((du) (dialoginterface)).d);
        }
        intent.setFlags(0x10000000);
        a.a.startActivity(intent);
    }

    e(du du1)
    {
        a = du1;
        super();
    }
}
