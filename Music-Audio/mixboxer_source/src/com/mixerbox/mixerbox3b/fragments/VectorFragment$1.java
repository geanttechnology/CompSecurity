// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.MainPage;
import com.mixerbox.mixerbox3b.classes.MyItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.classes.VectorOnClickHandle;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            VectorFragment

class this._cls0
    implements android.widget.mClickListener
{

    final VectorFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (vectorPageType == 3) goto _L2; else goto _L1
_L1:
        adapterview = (MyItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
        VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
_L32:
        return;
_L2:
        Object obj2;
        adapterview = (MyItem)((ListView)lv.getRefreshableView()).getItemAtPosition(i);
        obj2 = adapterview.getMyJSONObject();
        if (((JSONObject) (obj2)).isNull("type") || !((JSONObject) (obj2)).getString("type").equals("music"))
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj;
        Object obj1;
        String s;
        int j;
        obj = "";
        adapterview = "";
        view = "";
        obj1 = "";
        s = "";
        j = 1;
        if (!((JSONObject) (obj2)).isNull("f"))
        {
            obj = ((JSONObject) (obj2)).getString("f");
        }
        if (((JSONObject) (obj2)).isNull("tm")) goto _L4; else goto _L3
_L3:
        adapterview = ((JSONObject) (obj2)).getString("tm");
_L17:
        if (((JSONObject) (obj2)).isNull("tt")) goto _L6; else goto _L5
_L5:
        view = ((JSONObject) (obj2)).getString("tt");
_L19:
        if (!((JSONObject) (obj2)).isNull("_id"))
        {
            obj1 = ((JSONObject) (obj2)).getString("_id");
        }
        if (!((JSONObject) (obj2)).isNull("thumbnail"))
        {
            s = ((JSONObject) (obj2)).getString("thumbnail");
        }
        if (!((JSONObject) (obj2)).isNull("source")) goto _L8; else goto _L7
_L7:
        j = 1;
_L22:
        SongItem songitem;
        ArrayList arraylist;
        songitem = new SongItem(((String) (obj1)), view, adapterview, ((String) (obj)), 0, j, s);
        arraylist = new ArrayList();
        int k;
        k = 0;
        obj2 = adapterview;
        View view1 = view;
        String s2 = ((String) (obj1));
        obj1 = s;
        adapterview = ((AdapterView) (obj));
        view = ((View) (obj2));
        obj = view1;
        s = s2;
_L15:
        JSONObject jsonobject;
        if (k >= array.size())
        {
            break MISSING_BLOCK_LABEL_695;
        }
        jsonobject = ((MyItem)array.get(k)).getMyJSONObject();
        if (!jsonobject.isNull("f"))
        {
            adapterview = jsonobject.getString("f");
        }
        if (jsonobject.isNull("tm")) goto _L10; else goto _L9
_L9:
        view = jsonobject.getString("tm");
_L25:
        if (jsonobject.isNull("tt")) goto _L12; else goto _L11
_L11:
        obj = jsonobject.getString("tt");
_L27:
        if (!jsonobject.isNull("_id"))
        {
            s = jsonobject.getString("_id");
        }
        if (!jsonobject.isNull("source")) goto _L14; else goto _L13
_L13:
        j = 1;
        obj2 = obj1;
_L28:
        arraylist.add(new SongItem(s, ((String) (obj)), view, adapterview, k, j, ((String) (obj2))));
        k++;
        obj1 = obj2;
          goto _L15
_L4:
        if (((JSONObject) (obj2)).isNull("duration")) goto _L17; else goto _L16
_L16:
        adapterview = ((JSONObject) (obj2)).getString("duration");
          goto _L17
_L6:
        if (((JSONObject) (obj2)).isNull("title")) goto _L19; else goto _L18
_L18:
        view = ((JSONObject) (obj2)).getString("title");
          goto _L19
_L8:
        if (!((JSONObject) (obj2)).getString("source").equals("youtube")) goto _L21; else goto _L20
_L20:
        j = 1;
          goto _L22
_L21:
        if (!((JSONObject) (obj2)).getString("source").equals("soundcloud")) goto _L22; else goto _L23
_L23:
        j = 3;
        obj = ((JSONObject) (obj2)).getString("trackId");
          goto _L22
_L10:
        if (jsonobject.isNull("duration")) goto _L25; else goto _L24
_L24:
        view = jsonobject.getString("duration");
          goto _L25
_L12:
        if (jsonobject.isNull("title")) goto _L27; else goto _L26
_L26:
        obj = jsonobject.getString("title");
          goto _L27
_L14:
        if (!jsonobject.getString("source").equals("youtube"))
        {
            break MISSING_BLOCK_LABEL_624;
        }
        j = 1;
        obj2 = obj1;
          goto _L28
        obj2 = obj1;
        if (!jsonobject.getString("source").equals("soundcloud")) goto _L28; else goto _L29
_L29:
        byte byte0 = 3;
        String s1 = jsonobject.getString("trackId");
        adapterview = s1;
        j = byte0;
        obj2 = obj1;
        if (jsonobject.isNull("thumbnail")) goto _L28; else goto _L30
_L30:
        obj2 = jsonobject.getString("thumbnail");
        adapterview = s1;
        j = byte0;
          goto _L28
        try
        {
            ((MainPage)getActivity()).arrayPlayingSong = arraylist;
            ((MainPage)getActivity()).playingSong = songitem;
            ((MainPage)getActivity()).playingPlaylist = null;
            ((MainPage)getActivity()).playingSongIndex = i - 1;
            ((MainPage)getActivity()).playMusic(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            adapterview.toString();
        }
        return;
        if (((JSONObject) (obj2)).isNull("type") || !((JSONObject) (obj2)).getString("type").equals("playlist")) goto _L32; else goto _L31
_L31:
        VectorOnClickHandle.onClick(getActivity(), adapterview.getMyJSONObject(), null, null, null);
        return;
    }

    ()
    {
        this$0 = VectorFragment.this;
        super();
    }
}
