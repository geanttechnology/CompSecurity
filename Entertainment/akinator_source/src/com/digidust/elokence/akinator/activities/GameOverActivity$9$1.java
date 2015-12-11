// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import com.elokence.limuleapi.Session;
import com.elokence.limuleapi.SessionFactory;
import com.elokence.limuleapi.TraductionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            GameOverActivity

class this._cls1
    implements android.content.ckListener
{

    final this._cls1 this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/digidust/elokence/akinator/activities/GameOverActivity$9

/* anonymous class */
    class GameOverActivity._cls9
        implements android.view.View.OnClickListener
    {

        final GameOverActivity this$0;

        public void onClick(View view)
        {
            BackgroundSoundsBinder.sharedInstance().playBip();
            view = new android.app.AlertDialog.Builder(GameOverActivity.this);
            view.setTitle(TraductionFactory.sharedInstance().getTraductionFromToken("PLUS"));
            RelativeLayout relativelayout = (RelativeLayout)LayoutInflater.from(GameOverActivity.this).inflate(0x7f030069, null);
            GameOverActivity.access$302(GameOverActivity.this, (Button)relativelayout.findViewById(0x7f0d028d));
            GameOverActivity.access$402(GameOverActivity.this, (Button)relativelayout.findViewById(0x7f0d028e));
            GameOverActivity.access$502(GameOverActivity.this, (Button)relativelayout.findViewById(0x7f0d028f));
            GameOverActivity.access$602(GameOverActivity.this, (Button)relativelayout.findViewById(0x7f0d0290));
            GameOverActivity.access$300(GameOverActivity.this).setText(TraductionFactory.sharedInstance().getTraductionFromToken("RAPPORT_DE_PARTIE"));
            GameOverActivity.access$300(GameOverActivity.this).setOnClickListener(mMoreDialogButtonClickListener);
            if (SessionFactory.sharedInstance().getSession().isActive() || GameOverActivity.access$700(GameOverActivity.this))
            {
                GameOverActivity.access$300(GameOverActivity.this).setVisibility(8);
            }
            GameOverActivity.access$400(GameOverActivity.this).setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_UNE_PHOTO"));
            GameOverActivity.access$400(GameOverActivity.this).setOnClickListener(mMoreDialogButtonClickListener);
            boolean flag;
            if (SessionFactory.sharedInstance().getSession().getCurrentStats().getFlagPhoto() == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag || AkSessionFactory.sharedInstance().hasAlreadyProposedPhoto() || GameOverActivity.access$700(GameOverActivity.this))
            {
                GameOverActivity.access$400(GameOverActivity.this).setVisibility(8);
            } else
            {
                GameOverActivity.access$400(GameOverActivity.this).setOnClickListener(mMoreDialogButtonClickListener);
            }
            if (GameOverActivity.access$700(GameOverActivity.this))
            {
                GameOverActivity.access$500(GameOverActivity.this).setVisibility(8);
            } else
            {
                GameOverActivity.access$500(GameOverActivity.this).setText(TraductionFactory.sharedInstance().getTraductionFromToken("AJOUTER_UNE_QUESTION"));
                GameOverActivity.access$500(GameOverActivity.this).setOnClickListener(mMoreDialogButtonClickListener);
            }
            if (!GameOverActivity.access$700(GameOverActivity.this)) goto _L2; else goto _L1
_L1:
            GameOverActivity.access$600(GameOverActivity.this).setText(TraductionFactory.sharedInstance().getTraductionFromToken("MODIFIER_DANS_MY_WORLD"));
_L4:
            GameOverActivity.access$600(GameOverActivity.this).setOnClickListener(GameOverActivity.access$800(GameOverActivity.this));
            view.setView(relativelayout);
            view.setNeutralButton(TraductionFactory.sharedInstance().getTraductionFromToken("ANNULER"), new GameOverActivity._cls9._cls1());
            moreAlertDialog = view.show();
            return;
_L2:
            GameOverActivity.access$600(GameOverActivity.this).setText(TraductionFactory.sharedInstance().getTraductionFromToken("PERSONNALISER_2"));
            if (AkConfigFactory.sharedInstance().isFreemium())
            {
                if (!AkGameFactory.sharedInstance().isUnlocked() || AkGameFactory.sharedInstance().isUnlocked() && AkConfigFactory.sharedInstance().isCustomizeEnabled())
                {
                    GameOverActivity.access$600(GameOverActivity.this).setVisibility(0);
                } else
                if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
                {
                    GameOverActivity.access$600(GameOverActivity.this).setVisibility(8);
                }
            } else
            if (AkConfigFactory.sharedInstance().isCustomizeEnabled())
            {
                GameOverActivity.access$600(GameOverActivity.this).setVisibility(0);
            } else
            {
                GameOverActivity.access$600(GameOverActivity.this).setVisibility(8);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                this$0 = GameOverActivity.this;
                super();
            }
    }

}
