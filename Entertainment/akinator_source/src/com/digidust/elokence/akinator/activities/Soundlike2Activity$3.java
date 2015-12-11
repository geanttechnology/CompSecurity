// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.view.View;
import android.widget.AdapterView;
import com.digidust.elokence.akinator.adapters.AkSoundlikeAdapter;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import java.util.HashSet;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            Soundlike2Activity

class this._cls0
    implements android.widget.ckListener
{

    final Soundlike2Activity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        BackgroundSoundsBinder.sharedInstance().playBip();
        if (Soundlike2Activity.access$000(Soundlike2Activity.this).getSelectedItemsIndex().contains(Integer.valueOf(i)))
        {
            Soundlike2Activity.access$000(Soundlike2Activity.this).removeSelectedItems(Integer.valueOf(i));
            return;
        } else
        {
            Soundlike2Activity.access$000(Soundlike2Activity.this).addSelectedItems(Integer.valueOf(i));
            return;
        }
    }

    sBinder()
    {
        this$0 = Soundlike2Activity.this;
        super();
    }
}
