// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            SongFragment

class this._cls0
    implements com.handmark.pulltorefresh.library.se.OnRefreshListener
{

    final SongFragment this$0;

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        if (currentPlaylist.getPlaylistType() == 6 || currentPlaylist.getPlaylistType() == 8)
        {
            lv.onRefreshComplete();
        } else
        if (getActivity() != null)
        {
            pulltorefreshbase = MixerBoxClient.getSongUrl(currentPlaylist.getPlaylistId());
            if (!currentPlaylist.getPlaylistId().equals(""))
            {
                class _cls1 extends MixerBoxAsyncHttpResponseHandler
                {

                    final SongFragment._cls2 this$1;

                    public void onSuccess(String s)
                    {
                        super.onSuccess(s);
                        ArrayList arraylist = new ArrayList();
                        if (s != null)
                        {
                            s = MixerBoxUtils.getSongArray(s, this$0);
                        } else
                        {
                            s = arraylist;
                        }
                        if (getActivity() == null)
                        {
                            return;
                        } else
                        {
                            ((MainPage)getActivity()).arraySong = new ArrayList(s);
                            lv.onRefreshComplete();
                            loadContent();
                            return;
                        }
                    }

            _cls1(Context context)
            {
                this$1 = SongFragment._cls2.this;
                super(context);
            }
                }

                MixerBoxClient.get(pulltorefreshbase, null, new _cls1(getActivity()));
                return;
            }
        }
    }

    ase()
    {
        this$0 = SongFragment.this;
        super();
    }
}
