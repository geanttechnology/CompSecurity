// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.whatsapp;

import android.content.DialogInterface;

// Referenced classes of package com.whatsapp:
//            EULA

class dd
    implements android.content.DialogInterface.OnClickListener
{

    final EULA a;

    dd(EULA eula)
    {
        a = eula;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        a.showDialog(5);
    }
}
