// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import android.widget.AdapterView;
import com.digidust.elokence.akinator.adapters.AkCharacterAdapter;
import java.util.HashSet;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SeveralCharactersProposalActivity

class this._cls0
    implements android.widget.aractersProposalActivity._cls2
{

    final SeveralCharactersProposalActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).getSelectedItemsIndex().contains(Integer.valueOf(i)))
        {
            SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).removeSelectedItems(Integer.valueOf(i));
            return;
        } else
        {
            SeveralCharactersProposalActivity.access$000(SeveralCharactersProposalActivity.this).addSelectedItems(Integer.valueOf(i));
            return;
        }
    }

    ()
    {
        this$0 = SeveralCharactersProposalActivity.this;
        super();
    }
}
