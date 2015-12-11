// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import android.content.DialogInterface;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            az

class w
    implements android.content.DialogInterface.OnClickListener
{

    final JSONObject a;
    final az b;

    w(az az1, JSONObject jsonobject)
    {
        b = az1;
        a = jsonobject;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        az.c(b, a);
        dialoginterface.cancel();
        az.d(b);
    }
}
