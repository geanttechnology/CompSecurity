// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.share.widget.GameRequestDialog;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls0
    implements android.content.ickListener
{

    final GameOverActivity this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        try
        {
            dialoginterface = (new com.facebook.share.model.uilder()).setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("DEFI_TES_AMIS")).setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ESSAIE_DE_ME_BATTRE")).setTo(TextUtils.join(",", GameOverActivity.access$000(GameOverActivity.this))).setActionType(com.facebook.share.model.ctionType.TURN).build();
            GameOverActivity.access$1600(GameOverActivity.this).show(dialoginterface);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DialogInterface dialoginterface)
        {
            dialoginterface.printStackTrace();
        }
    }

    ()
    {
        this$0 = GameOverActivity.this;
        super();
    }
}
