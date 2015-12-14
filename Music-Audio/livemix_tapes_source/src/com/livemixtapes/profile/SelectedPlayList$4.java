// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.profile;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.livemixtapes.profile:
//            SelectedPlayList

class this._cls0
    implements android.view.r
{

    final SelectedPlayList this$0;

    public void onClick(View view)
    {
        Iterator iterator;
        view = SelectedPlayList.this;
        boolean flag;
        if (isEditMode)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        view.isEditMode = flag;
        if (isEditMode || !isSomethingChanged) goto _L2; else goto _L1
_L1:
        isSomethingChanged = false;
        view = new ArrayList();
        iterator = trackList.iterator();
_L6:
        if (iterator.hasNext()) goto _L4; else goto _L3
_L3:
        view = TextUtils.join(",", view);
        (new orderOrDeleteTracks(SelectedPlayList.this, 1)).execute(new String[] {
            view
        });
_L2:
        if (isEditMode)
        {
            playlistName.setFocusable(true);
            playlistName.setFocusableInTouchMode(true);
            playlistName.setCursorVisible(true);
            downloadButton.setVisibility(4);
            playButton.setVisibility(4);
            playlistName.requestFocus();
            playlistName.setSelection(playlistName.getText().toString().length());
        } else
        {
            playlistName.setFocusable(false);
            downloadButton.setVisibility(0);
            playButton.setVisibility(0);
            if (!SelectedPlayList.map.get("title").toString().equals(playlistName.getText().toString()))
            {
                (new orderOrDeleteTracks(SelectedPlayList.this, 3)).execute(new String[] {
                    playlistName.getText().toString()
                });
            }
        }
        adapter.notifyDataSetChanged();
        return;
_L4:
        view.add(((Map)iterator.next()).get("track_dbid").toString());
        if (true) goto _L6; else goto _L5
_L5:
    }

    ackListAdapter()
    {
        this$0 = SelectedPlayList.this;
        super();
    }
}
