// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.fragments;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b.fragments:
//            NewsfeedFragment

class dlessScrollListener
    implements com.handmark.pulltorefresh.library.nRefreshListener
{

    final NewsfeedFragment this$0;
    final dlessScrollListener val$scroller;

    public void onRefresh(PullToRefreshBase pulltorefreshbase)
    {
        endList = false;
        dlessScrollListener.access._mth002(val$scroller, 0);
        dlessScrollListener.access._mth102(val$scroller, 0);
        dlessScrollListener.access._mth202(val$scroller, false);
        class _cls1 extends MixerBoxAsyncHttpResponseHandler
        {

            final NewsfeedFragment._cls2 this$1;

            public void onFailure(Throwable throwable, String s)
            {
                super.onFailure(throwable, s);
                lvNewsfeed.onRefreshComplete();
            }

            public void onSuccess(String s)
            {
                int i = 0;
                super.onSuccess(s);
                if (getActivity() == null || s == null)
                {
                    return;
                }
                Object obj;
                if (((MainPage)getActivity()).arrayNewsfeed != null)
                {
                    ((MainPage)getActivity()).arrayNewsfeed.clear();
                } else
                {
                    ((MainPage)getActivity()).arrayNewsfeed = new ArrayList();
                }
                obj = ((MainPage)getActivity()).DB.getLastPushed();
                if (obj != null)
                {
                    try
                    {
                        obj = new JSONObject((new StringBuilder()).append("{margin: true,type: \"general\",views: {header: {mainText: \"").append(getResources().getString(0x7f080112)).append("\"},main: {mainLink: {type: \"playlist\",ref: \"").append(((PlaylistItem) (obj)).getPlaylistId()).append("\",title: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",owner: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",size: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",thumbnailHQ: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\",ownerId: \"\"},mainText: \"").append(((PlaylistItem) (obj)).getPlaylistName()).append("\",subText: \"").append(((PlaylistItem) (obj)).getPlaylistOwnerName()).append("\",sideText: \"").append(((PlaylistItem) (obj)).getPlaylistItemCount()).append("\",thumbnail: {style: \"square\",url: \"").append(((PlaylistItem) (obj)).getPlaylistCover()).append("\"}},footer: {bgColor: true,links: [{type: \"button\",title: \"").append(getResources().getString(0x7f0800e7)).append("\",action: \"subscribe\",switch: {type: \"button\",title: \"").append(getResources().getString(0x7f0800e8)).append("\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}").toString());
                        MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), 0, 0);
                    }
                    catch (Exception exception)
                    {
                        exception.toString();
                    }
                }
                s = (new JSONObject(s)).getJSONObject("newsPage").getJSONArray("items");
_L1:
                if (i >= s.length())
                {
                    break MISSING_BLOCK_LABEL_452;
                }
                obj = s.getJSONObject(i);
                MixerBoxUtils.addMyItemToArray(((MainPage)getActivity()).arrayNewsfeed, ((JSONObject) (obj)), getActivity(), i, s.length() - i - 1);
                i++;
                  goto _L1
                s;
                s.printStackTrace();
                adapter.notifyDataSetChanged();
                lvNewsfeed.onRefreshComplete();
                canScroll = true;
                return;
            }

            _cls1(Context context)
            {
                this$1 = NewsfeedFragment._cls2.this;
                super(context);
            }
        }

        MixerBoxClient.get(MixerBoxClient.getNewsfeedUrl(getActivity(), 0), null, new _cls1(getActivity()));
    }

    dlessScrollListener()
    {
        this$0 = final_newsfeedfragment;
        val$scroller = dlessScrollListener.this;
        super();
    }
}
