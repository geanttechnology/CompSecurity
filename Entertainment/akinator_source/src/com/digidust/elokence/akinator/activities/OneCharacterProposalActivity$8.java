// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.digidust.elokence.akinator.factories.AkSessionFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            OneCharacterProposalActivity, DefiDuJourActivity

class val.idBase
    implements android.view.animation.ProposalActivity._cls8
{

    final OneCharacterProposalActivity this$0;
    final int val$idBase;

    public void onAnimationEnd(Animation animation)
    {
        animation = new Intent(OneCharacterProposalActivity.this, com/digidust/elokence/akinator/activities/DefiDuJourActivity);
        animation.putExtra("keyPersoTrouve", val$idBase);
        Bitmap bitmap = Bitmap.createBitmap(((BitmapDrawable)OneCharacterProposalActivity.access$300(OneCharacterProposalActivity.this).getDrawable()).getBitmap());
        AkSessionFactory.sharedInstance().setImageDefi(bitmap);
        startActivity(animation);
        finish();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    ()
    {
        this$0 = final_onecharacterproposalactivity;
        val$idBase = I.this;
        super();
    }
}
