// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ag

class a
    implements android.content.gInterface.OnClickListener
{

    final String a;
    final ag b;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        String s = a;
        dialoginterface = s;
        if (!s.startsWith("http://"))
        {
            dialoginterface = s;
            if (!s.startsWith("https://"))
            {
                dialoginterface = (new StringBuilder()).append("http://").append(s).toString();
            }
        }
        dialoginterface = new Intent("android.intent.action.VIEW", Uri.parse(dialoginterface));
        b.startActivity(dialoginterface);
    }

    Listener(ag ag1, String s)
    {
        b = ag1;
        a = s;
        super();
    }
}
