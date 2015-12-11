// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.app.Activity;
import android.content.Context;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

public class ctx
{

    Context ctx;
    final MainPage this$0;

    public void log(String s)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("FROM JS: ").append(s).toString());
    }

    public void onPageLoaded()
    {
        MainPage.isPageLoaded = true;
        class _cls6
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                wv.loadUrl((new StringBuilder()).append("javascript:setQuality(").append(JS_Player_W_F).append(",").append(MixerBoxSharedPreferences.getHighQuality(this$0)).append(")").toString());
                if (shouldPlayAfterReady)
                {
                    shouldPlayAfterReady = false;
                    playMusic(false);
                }
            }

            _cls6()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls6());
    }

    public void onReady()
    {
        class _cls4
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                isReady = true;
                if (shouldPlayAfterReady)
                {
                    shouldPlayAfterReady = false;
                    playMusic(false);
                }
                if (SCREEN_STATE == 1)
                {
                    wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
                    return;
                } else
                {
                    wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
                    return;
                }
            }

            _cls4()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls4());
    }

    public void onReadyV2()
    {
        class _cls5
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                isReady = true;
                if (SCREEN_STATE == 1)
                {
                    wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W).append(",").append(JS_Player_H).append(")").toString());
                } else
                {
                    wv.loadUrl((new StringBuilder()).append("javascript:setScreenSize(").append(JS_Player_W_F).append(",").append(JS_Player_H_F).append(")").toString());
                }
                if (MainPage.playerType == 0)
                {
                    rlHint.setVisibility(0);
                    MainPage.playerType = 2;
                    MixerBoxSharedPreferences.putPlayerType(this$0, 2);
                    playMusic(false);
                } else
                if (shouldPlayAfterReady)
                {
                    shouldPlayAfterReady = false;
                    playMusic(false);
                    return;
                }
            }

            _cls5()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls5());
    }

    public void onShouldPlayChange(final int flag)
    {
        class _cls9
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;
            final int val$flag;

            public void run()
            {
                shouldPlay = flag;
                if (shouldPlay == 1)
                {
                    btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ed));
                } else
                {
                    btnPlay.setImageDrawable(getResources().getDrawable(0x7f0200ef));
                }
                sendNotification();
            }

            _cls9()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                flag = i;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls9());
    }

    public void onStateChanged(final int s)
    {
        class _cls8
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;
            final int val$s;

            public void run()
            {
                if (!shouldCloseApp)
                {
                    videoState = s;
                    if (videoState == 1)
                    {
                        errorCount = 0;
                    }
                    if (!MixerBoxClient.isConnectingToInternet(this$0))
                    {
                        tvNoNet.setVisibility(0);
                        stopPlayer();
                        return;
                    }
                    if (videoState == 1 && tvNoNet.getVisibility() == 0)
                    {
                        tvNoNet.setVisibility(8);
                        playMusic(false);
                    }
                    if (MainPage.playerType == 2 && !hasSetCanAuto && videoState == 1)
                    {
                        hasSetCanAuto = true;
                        rlHint.setVisibility(8);
                        MainPage.access$600(this$0);
                    }
                    if (tvSwitch.getVisibility() == 0 && videoState == 1)
                    {
                        tvSwitch.setVisibility(8);
                        MixerBoxSharedPreferences.putPlayerType(this$0, 1);
                        MainPage.playerType = 1;
                        MainPage.access$600(this$0);
                    }
                    if (videoState == 1 && shouldResetTime)
                    {
                        shouldResetTime = false;
                        wv.loadUrl((new StringBuilder()).append("javascript:seekTo(").append(resetTime).append(")").toString());
                        resetTime = 0;
                        return;
                    }
                }
            }

            _cls8()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                s = i;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls8());
    }

    public void playMediaPlayer()
    {
        class _cls10
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
            }

            _cls10()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls10());
    }

    public void playNext()
    {
        class _cls2
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                if (!MixerBoxClient.isConnectingToInternet(this$0))
                {
                    stopPlayer();
                    return;
                } else
                {
                    playNextSong();
                    return;
                }
            }

            _cls2()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls2());
    }

    public void postFBAction()
    {
        class _cls3
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                if (playingPlaylist != null && playingSong != null && playingPlaylist.getPlaylistId().equals("PLAYLISTHISTORYID"))
                {
                    MixerBoxUtils.sendCohortListening(this$0, "", "0", playingSong.getSongYtId());
                } else
                if (playingPlaylist != null && playingSong != null && playingSong.getSongId() != null && playingPlaylist.getPlaylistId() != null)
                {
                    MixerBoxUtils.sendCohortListening(this$0, playingSong.getSongId(), playingPlaylist.getPlaylistId(), "");
                } else
                if (playingSong != null && playingSong.getSongYtId() != null)
                {
                    MixerBoxUtils.sendCohortListening(this$0, "", "0", playingSong.getSongYtId());
                }
                if (isLogIn) goto _L2; else goto _L1
_L1:
                return;
_L2:
                int i;
                i = MixerBoxSharedPreferences.getPlaySongCount(this$0) + 1;
                if (MixerBoxSharedPreferences.getPostFB(this$0))
                {
                    break; /* Loop/switch isn't completed */
                }
                MixerBoxSharedPreferences.putPlaySongCount(this$0, i);
                if (i == 5 || i % 50 == 0)
                {
                    AlertDialogFactory.AskPostAlertDialog(this$0).show();
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
                class _cls1 extends MixerBoxAsyncHttpResponseHandler
                {

                    final _cls3 this$2;

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
                            this$2 = _cls3.this;
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
                (new AsyncHttpClient()).post((new StringBuilder()).append("https://graph.facebook.com/").append(MixerBoxSharedPreferences.getFacebookId(this$0)).append("/mixerbox:play?music_video=").append(s).append("&access_token=").append(MixerBoxSharedPreferences.getFacebookToken(this$0)).toString(), null, new _cls1(this$0));
                return;
            }

            _cls3()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls3());
    }

    public void sendError()
    {
        class _cls7
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;

            public void run()
            {
                MainPage mainpage = this$0;
                mainpage.errorCount = mainpage.errorCount + 1;
                MixerBoxUtils.logMsg((new StringBuilder()).append("errorCount = ").append(errorCount).toString());
                FlurryAgent.logEvent("status:youtube_player_error");
                if (arrayPlayingSong == null || errorCount > arrayPlayingSong.size() + 2)
                {
                    closePlayer();
                    MixerBoxUtils.toastMsg(this$0, getResources().getString(0x7f08005a), 1);
                }
            }

            _cls7()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls7());
    }

    public void showTime(final String time)
    {
        class _cls1
            implements Runnable
        {

            final MainPage.MyJavaScriptInterface this$1;
            final String val$time;

            public void run()
            {
                if ((playingSong == null || playingSong.getSongSource() != 3 && playingSong.getSongSource() != 2) && time != null && !time.equals("undefined"))
                {
                    currentTime = (int)Math.round(Double.valueOf(time).doubleValue());
                    if (canUpdateSeekbar)
                    {
                        seekbar.setProgress((int)Math.round(Double.valueOf(time).doubleValue()));
                        tvTimeStart.setText(MixerBoxUtils.getSongTime(String.valueOf((int)Math.round(Double.valueOf(time).doubleValue()))));
                    }
                    if (rlPanelTop.getVisibility() == 8)
                    {
                        rlPanelPopup.setVisibility(8);
                        return;
                    }
                }
            }

            _cls1()
            {
                this$1 = MainPage.MyJavaScriptInterface.this;
                time = s;
                super();
            }
        }

        ((Activity)ctx).runOnUiThread(new _cls1());
    }

    _cls1(Context context)
    {
        this$0 = MainPage.this;
        super();
        ctx = context;
    }
}
