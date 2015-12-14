// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.livemixtapes.ui.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes.profile:
//            SeeAllList, SelectedPlayList

class this._cls0
    implements android.widget.nItemClickListener
{

    final SeeAllList this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (isAddTracksToPlayList)
        {
            (new dtoPlayList(SeeAllList.this, 2)).execute(new String[] {
                "playlist/add", ((Map)playList.get(i)).get("playlist_id").toString(), getArguments().getString("tracks")
            });
        } else
        {
            if (flag == 1)
            {
                SelectedPlayList.map = (Map)playList.get(i);
                adapterview = ((BaseActivity)getActivity()).getAnimatedFragmentTransaction();
                adapterview.replace(0x7f0800cc, new SelectedPlayList(), "SELECTED").addToBackStack(null);
                adapterview.commit();
                return;
            }
            if (flag == 2)
            {
                adapterview = (Map)playList.get(i);
                (new adMixtapeData(SeeAllList.this)).execute(new String[] {
                    adapterview.get("albumId").toString()
                });
                return;
            }
            if (flag == 3)
            {
                adapterview = (HashMap)((ArrayList)((Map)playList.get(i)).get("tracks")).get(0);
                (new adMixtapeData(SeeAllList.this)).execute(new String[] {
                    ((String)adapterview.get("track_album")).toString()
                });
                return;
            }
        }
    }

    adMixtapeData()
    {
        this$0 = SeeAllList.this;
        super();
    }
}
