// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.content.DialogInterface;
import android.content.Intent;

// Referenced classes of package com.livemixtapes:
//            Mixtape, App, SignUp

class this._cls0
    implements android.content.face.OnClickListener
{

    final Mixtape this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        startActivity(new Intent(App.context, com/livemixtapes/SignUp));
    }

    ace()
    {
        this$0 = Mixtape.this;
        super();
    }
}
