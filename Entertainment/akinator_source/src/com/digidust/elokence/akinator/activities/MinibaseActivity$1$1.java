// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.digidust.elokence.akinator.adapters.AkMinibaseCharacterAdapter;
import com.elokence.limuleapi.TraductionFactory;
import java.util.ArrayList;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            MinibaseActivity

class this._cls1
    implements android.content.ckListener
{

    final _cls1.execute this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
    /* block-local class not found */
    class _cls1 {}

        if (i == -1)
        {
            (new _cls1()).execute(new Void[0]);
        } else
        if (i == -2)
        {
            dialoginterface.dismiss();
            return;
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/MinibaseActivity$1

/* anonymous class */
    class MinibaseActivity._cls1
        implements android.view.View.OnClickListener
    {

        final MinibaseActivity this$0;

        public void onClick(View view)
        {
            if (MinibaseActivity.access$000(MinibaseActivity.this) == null || MinibaseActivity.access$000(MinibaseActivity.this).getCharacters() == null || MinibaseActivity.access$000(MinibaseActivity.this).getCharacters().size() == 0)
            {
                return;
            } else
            {
                view = new android.app.AlertDialog.Builder(MinibaseActivity.this);
                view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_TITRE"));
                view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_DESCRIPTION"));
                MinibaseActivity._cls1._cls1 _lcls1 = new MinibaseActivity._cls1._cls1();
                view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), _lcls1);
                view.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON"), _lcls1);
                view.create().show();
                return;
            }
        }

            
            {
                this$0 = MinibaseActivity.this;
                super();
            }
    }

}
