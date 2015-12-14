// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.os.Bundle;
import android.view.View;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList

class this._cls0
    implements android.view.istener
{

    final SeeAllList this$0;

    public void onClick(View view)
    {
        if (isAddTracksToPlayList)
        {
            (new dtoPlayList(SeeAllList.this, 1)).execute(new String[] {
                "playlist/create", "", getArguments().getString("tracks")
            });
        }
    }

    dtoPlayList()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
