// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.Dialog;
import com.flurry.android.FlurryAgent;
import com.loopj.android.http.AsyncHttpClient;
import com.mixerbox.mixerbox3b.classes.PlaylistItem;
import com.mixerbox.mixerbox3b.classes.SongItem;
import com.mixerbox.mixerbox3b.dialogs.AlertDialogFactory;
import com.mixerbox.mixerbox3b.utils.MixerBoxSharedPreferences;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (playingPlaylist != null && playingSong != null && playingPlaylist.getPlaylistId().equals("PLAYLISTHISTORYID"))
        {
            MixerBoxUtils.sendCohortListening(_fld0, "", "0", playingSong.getSongYtId());
        } else
        if (playingPlaylist != null && playingSong != null && playingSong.getSongId() != null && playingPlaylist.getPlaylistId() != null)
        {
            MixerBoxUtils.sendCohortListening(_fld0, playingSong.getSongId(), playingPlaylist.getPlaylistId(), "");
        } else
        if (playingSong != null && playingSong.getSongYtId() != null)
        {
            MixerBoxUtils.sendCohortListening(_fld0, "", "0", playingSong.getSongYtId());
        }
        if (isLogIn) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = MixerBoxSharedPreferences.getPlaySongCount(_fld0) + 1;
        if (MixerBoxSharedPreferences.getPostFB(_fld0))
        {
            break; /* Loop/switch isn't completed */
        }
        MixerBoxSharedPreferences.putPlaySongCount(_fld0, i);
        if (i == 5 || i % 50 == 0)
        {
            AlertDialogFactory.AskPostAlertDialog(_fld0).show();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        class _cls1 extends MixerBoxAsyncHttpResponseHandler
        {

            final MainPage.MyJavaScriptInterface._cls3 this$2;

            public void onFailure(Throwable throwable, String s1)
            {
                super.onFailure(throwable, s1);
                if (s1 != null)
                {
                    MixerBoxUtils.logMsg(s1);
                    try
                    {
                        throwable = new JSONObject(s1);
                        if (!throwable.isNull("error") && throwable.getJSONObject("error").getString("code").equals("200"))
                        {
                            MixerBoxSharedPreferences.putPostFB(this$0, false);
                            if (fragmentSettings.isAdded())
                            {
                                fragmentSettings.checkbox.setChecked(false);
                                return;
                            }
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Throwable throwable)
                    {
                        throwable.printStackTrace();
                        return;
                    }
                }
            }

            public void onSuccess(String s1)
            {
                super.onSuccess(s1);
                MixerBoxUtils.logMsg(s1);
            }

            _cls1(Context context)
            {
                this$2 = MainPage.MyJavaScriptInterface._cls3.this;
                super(context);
            }
        }

        String s;
        if (i == 5)
        {
            FlurryAgent.logEvent("action:played_05_videos");
        } else
        if (i == 10)
        {
            FlurryAgent.logEvent("action:played_10_videos");
        } else
        if (i == 20)
        {
            FlurryAgent.logEvent("action:played_20_videos");
        } else
        if (i == 50)
        {
            FlurryAgent.logEvent("action:played_50_videos");
        }
        if (playingPlaylist == null)
        {
            s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
        } else
        if (playingPlaylist.getPlaylistId().equals("PLAYLISTHISTORYID"))
        {
            s = (new StringBuilder()).append("http://www.mixerbox.com/music/0/").append(playingSong.getSongYtId()).toString();
        } else
        {
            s = (new StringBuilder()).append("http://www.mixerbox.com/music/").append(playingPlaylist.getPlaylistId()).append("/").append(playingSong.getSongId()).toString();
        }
        (new AsyncHttpClient()).post((new StringBuilder()).append("https://graph.facebook.com/").append(MixerBoxSharedPreferences.getFacebookId(_fld0)).append("/mixerbox:play?music_video=").append(s).append("&access_token=").append(MixerBoxSharedPreferences.getFacebookToken(_fld0)).toString(), null, new _cls1(_fld0));
        return;
    }

    _cls1()
    {
        this$1 = this._cls1.this;
        super();
    }
}
