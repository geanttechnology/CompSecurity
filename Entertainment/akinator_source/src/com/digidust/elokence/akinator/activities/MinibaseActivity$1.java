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

class this._cls0
    implements android.view.r
{

    final MinibaseActivity this$0;

    public void onClick(View view)
    {
        if (MinibaseActivity.access$000(MinibaseActivity.this) == null || MinibaseActivity.access$000(MinibaseActivity.this).getCharacters() == null || MinibaseActivity.access$000(MinibaseActivity.this).getCharacters().size() == 0)
        {
            return;
        } else
        {
            view = new android.app.(MinibaseActivity.this);
            view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_TITRE"));
            view.setMessage(TraductionFactory.sharedInstance().getTraductionFromToken("ALERTE_1_MY_WORLD_DESCRIPTION"));
            android.content.lickListener licklistener = new android.content.DialogInterface.OnClickListener() {

                final MinibaseActivity._cls1 this$1;

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

            
            {
                this$1 = MinibaseActivity._cls1.this;
                super();
            }
            };
            view.setPositiveButton(TraductionFactory.sharedInstance().getTraductionFromToken("OUI"), licklistener);
            view.setNegativeButton(TraductionFactory.sharedInstance().getTraductionFromToken("NON"), licklistener);
            view.create().show();
            return;
        }
    }

    _cls1.this._cls1()
    {
        this$0 = MinibaseActivity.this;
        super();
    }
}
