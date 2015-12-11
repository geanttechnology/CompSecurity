// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.loaders.AsynchronousCharacterPictureLoader;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            OneCharacterProposalActivity

class  extends AsynchronousCharacterPictureLoader
{

    final OneCharacterProposalActivity this$0;

    public volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    public void onPostExecute(Void void1)
    {
        super.onPostExecute(void1);
        OneCharacterProposalActivity.access$000(OneCharacterProposalActivity.this).setVisibility(0);
        AkGameFactory.sharedInstance().setCharacterScreenShot(screenShot(findViewById(0x7f0d0085)));
    }

    (Context context, ImageView imageview, String s)
    {
        this$0 = OneCharacterProposalActivity.this;
        super(context, imageview, s);
    }
}
