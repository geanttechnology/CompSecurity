// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.widget.CompoundButton;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.QueueManager;
import com.sessionm.api.SessionM;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity

class this._cls0
    implements android.widget.ngeListener
{

    final BaseMediaDetailsActivity this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        String s = CrackleAccountManager.getUserID();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        compoundbutton = new QueueManager(BaseMediaDetailsActivity.this, s);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (mChannelID == null) goto _L4; else goto _L3
_L3:
        SessionM.getInstance().logAction("addToMyQueue");
        compoundbutton.addChannelToWatchlsit(mChannelID);
_L6:
        return;
_L4:
        if (mMediaID == null) goto _L6; else goto _L5
_L5:
        SessionM.getInstance().logAction("addToMyQueue");
        compoundbutton.addMediaToWatchlist(mMediaID);
        return;
_L2:
        if (mChannelID != null)
        {
            compoundbutton.removeChannelFromWatchlist(mChannelID);
            return;
        }
        if (mMediaID == null) goto _L6; else goto _L7
_L7:
        compoundbutton.removeMediaFromWatchlist(mMediaID);
        return;
        compoundbutton.setChecked(false);
        BaseActivity.showDialogFragment(getSupportFragmentManager(), 0xa7b54);
        return;
    }

    eListener()
    {
        this$0 = BaseMediaDetailsActivity.this;
        super();
    }
}
