// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;
import android.view.View;
import com.poshmark.data_model.models.Actor;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.inner_models.FeedItemStoryType;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.ClosetFragment;

// Referenced classes of package com.poshmark.utils:
//            FeedItemLinearLayout

class this._cls0
    implements android.view.out._cls4
{

    final FeedItemLinearLayout this$0;

    public void onClick(View view)
    {
        FeedItem feeditem = (FeedItem)view.getTag();
        Object obj = feeditem.getStoryType();
        switch (.SwitchMap.com.poshmark.data_model.models.inner_models.FeedItemStoryType.StoryType[((FeedItemStoryType) (obj)).getStoryType().ordinal()])
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        default:
            view = (PMActivity)view.getContext();
            break;
        }
        obj = new Bundle();
        ((Bundle) (obj)).putString("NAME", feeditem.actor.getId());
        view.launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/ClosetFragment, feeditem);
    }

    s.FeedItemStoryType.StoryType()
    {
        this$0 = FeedItemLinearLayout.this;
        super();
    }
}
