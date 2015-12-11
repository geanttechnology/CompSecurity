// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.content.DialogInterface;

// Referenced classes of package co.vine.android.recorder:
//            VineRecorder

class this._cls0
    implements android.content.OnClickListener
{

    final VineRecorder this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
    }

    stener()
    {
        this$0 = VineRecorder.this;
        super();
    }
}
