// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.dialogs;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import com.gotv.crackle.VideoPlayerActivity;
import com.gotv.crackle.VideoPlayerActivityFlash;

// Referenced classes of package com.gotv.crackle.dialogs:
//            MainDialogFragment

class this._cls0
    implements android.content.ckListener
{

    final MainDialogFragment this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        if ((getActivity() instanceof VideoPlayerActivity) || (getActivity() instanceof VideoPlayerActivityFlash))
        {
            getActivity().finish();
        }
    }

    r()
    {
        this$0 = MainDialogFragment.this;
        super();
    }
}
