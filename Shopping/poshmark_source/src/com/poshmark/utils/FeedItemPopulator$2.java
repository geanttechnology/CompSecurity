// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import android.view.View;
import com.poshmark.data_model.models.FeedItem;
import com.poshmark.data_model.models.PoshmarkPost;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            FeedItemPopulator

static final class Post.PostTarget
    implements android.view.
{

    public void onClick(View view)
    {
        Object obj = (PoshmarkPost)((FeedItem)view.getTag()).contentArray.get(0);
        if (((PoshmarkPost) (obj)).target != null && ((PoshmarkPost) (obj)).target.url != null)
        {
            view = (PMActivity)view.getContext();
            if (view instanceof MainActivity)
            {
                obj = Uri.parse(((PoshmarkPost) (obj)).target.url);
                ((MainActivity)view).handleDeepLinkLaunch(((Uri) (obj)), false);
            }
        }
    }

    Post.PostTarget()
    {
    }
}
