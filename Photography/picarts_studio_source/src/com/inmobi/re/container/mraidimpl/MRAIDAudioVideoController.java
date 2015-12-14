// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.container.mraidimpl;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.controller.util.AVPlayer;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.inmobi.re.container.mraidimpl:
//            MRAIDExpandController

public class MRAIDAudioVideoController
{

    private IMWebView a;
    public Hashtable audioPlayerList;
    public AVPlayer audioplayer;
    public AVPlayer videoPlayer;
    public Hashtable videoPlayerList;
    public int videoValidateWidth;

    public MRAIDAudioVideoController(IMWebView imwebview)
    {
        videoPlayerList = new Hashtable();
        audioPlayerList = new Hashtable();
        a = imwebview;
    }

    static IMWebView a(MRAIDAudioVideoController mraidaudiovideocontroller)
    {
        return mraidaudiovideocontroller.a;
    }

    private AVPlayer a(String s)
    {
        if (!videoPlayerList.isEmpty())
        {
            return (AVPlayer)videoPlayerList.get(s);
        } else
        {
            return null;
        }
    }

    private void a(AVPlayer avplayer, com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        int i = (int)(-99999F * a.getDensity());
        if (avplayer.isInlineVideo())
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(dimensions.width, dimensions.height);
            android.widget.FrameLayout.LayoutParams layoutparams1 = (android.widget.FrameLayout.LayoutParams)avplayer.getLayoutParams();
            if (dimensions.x == i && dimensions.y == i)
            {
                layoutparams.leftMargin = layoutparams1.leftMargin;
                layoutparams.topMargin = layoutparams1.topMargin;
            } else
            {
                layoutparams.leftMargin = dimensions.x;
                layoutparams.topMargin = dimensions.y;
            }
            layoutparams.gravity = 3;
            avplayer.setLayoutParams(layoutparams);
        }
    }

    private boolean a(String s, String s1, Activity activity)
    {
        if (!audioPlayerList.isEmpty())
        {
            audioplayer = (AVPlayer)audioPlayerList.get(s);
            if (audioplayer == null)
            {
                if (audioPlayerList.size() > 4)
                {
                    a.raiseError("Too many audio players", "playAudio");
                    return false;
                }
                audioplayer = new AVPlayer(activity, a);
            } else
            if (audioplayer.getMediaURL().equals(s1) || s1.length() == 0)
            {
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PLAYING)
                {
                    return false;
                }
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.INIT)
                {
                    if (audioplayer.isPrepared())
                    {
                        audioplayer.start();
                    } else
                    {
                        audioplayer.setAutoPlay(true);
                    }
                    return false;
                }
                if (audioplayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.PAUSED)
                {
                    audioplayer.start();
                    return false;
                }
                s1 = audioplayer.getProperties();
                String s2 = audioplayer.getMediaURL();
                audioplayer.releasePlayer(false);
                audioPlayerList.remove(s);
                audioplayer = new AVPlayer(activity, a);
                audioplayer.setPlayData(s1, s2);
            } else
            {
                audioplayer.releasePlayer(false);
                audioPlayerList.remove(s);
                audioplayer = new AVPlayer(activity, a);
            }
        } else
        {
            audioplayer = new AVPlayer(activity, a);
        }
        return true;
    }

    private boolean a(String s, String s1, Activity activity, com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        com.inmobi.re.controller.util.AVPlayer.playerState playerstate;
        if (videoPlayer == null || !s.equalsIgnoreCase(videoPlayer.getPropertyID()))
        {
            return b(s, s1, activity);
        }
        playerstate = videoPlayer.getState();
        if (!s.equalsIgnoreCase(videoPlayer.getPropertyID()))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        s = videoPlayer.getMediaURL();
        if (s1.length() != 0 && !s1.equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        _cls7.a[playerstate.ordinal()];
        JVM INSTR tableswitch 1 4: default 116
    //                   1 118
    //                   2 137
    //                   3 149
    //                   4 181;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        return false;
_L4:
        videoPlayer.start();
_L8:
        a(videoPlayer, dimensions);
        return false;
_L5:
        a(videoPlayer, dimensions);
        return false;
_L6:
        if (!videoPlayer.getProperties().doLoop())
        {
            videoPlayer.start();
        }
        a(videoPlayer, dimensions);
        return false;
_L7:
        if (videoPlayer.isPrepared())
        {
            videoPlayer.start();
        } else
        {
            videoPlayer.setAutoPlay(true);
        }
        if (true) goto _L8; else goto _L2
_L2:
        if (!URLUtil.isValidUrl(s1))
        {
            a.raiseError("Request must specify a valid URL", "playVideo");
            return false;
        }
        videoPlayer.releasePlayer(false);
        videoPlayer = new AVPlayer(activity, a);
        return true;
    }

    private boolean a(Hashtable hashtable, AVPlayer avplayer)
    {
        hashtable = hashtable.entrySet().iterator();
_L4:
        if (!hashtable.hasNext()) goto _L2; else goto _L1
_L1:
        java.util.Map.Entry entry = (java.util.Map.Entry)hashtable.next();
        if (entry.getValue() != avplayer) goto _L4; else goto _L3
_L3:
        hashtable = (String)entry.getKey();
_L6:
        if (hashtable != null)
        {
            audioPlayerList.remove(hashtable);
            return true;
        } else
        {
            return false;
        }
_L2:
        hashtable = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean b(String s, String s1, Activity activity)
    {
        if (s1.length() != 0 && !URLUtil.isValidUrl(s1) || s1.length() == 0 && !videoPlayerList.containsKey(s))
        {
            a.raiseError("Request must specify a valid URL", "playVideo");
            return false;
        }
        if (videoPlayer != null)
        {
            videoPlayer.hide();
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
        }
        AVPlayer avplayer = a(s);
        if (avplayer == null)
        {
            videoPlayer = new AVPlayer(activity, a);
        } else
        {
            videoPlayer = avplayer;
        }
        if (s1.length() == 0)
        {
            videoPlayer.setPlayData(avplayer.getProperties(), avplayer.getMediaURL());
            videoPlayer.setPlayDimensions(avplayer.getPlayDimensions());
        }
        videoPlayerList.remove(s);
        return true;
    }

    public AVPlayer getCurrentAudioPlayer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (audioplayer == null || !audioplayer.getPropertyID().equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        AVPlayer avplayer = audioplayer;
_L4:
        this;
        JVM INSTR monitorexit ;
        return avplayer;
_L2:
        avplayer = obj;
        if (audioPlayerList.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        avplayer = obj;
        if (audioPlayerList.containsKey(s))
        {
            avplayer = (AVPlayer)audioPlayerList.get(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public AVPlayer getVideoPlayer(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = null;
        if (videoPlayer == null || !videoPlayer.getPropertyID().equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        AVPlayer avplayer = videoPlayer;
_L4:
        this;
        JVM INSTR monitorexit ;
        return avplayer;
_L2:
        avplayer = obj;
        if (videoPlayerList.isEmpty())
        {
            continue; /* Loop/switch isn't completed */
        }
        avplayer = obj;
        if (videoPlayerList.containsKey(s))
        {
            avplayer = (AVPlayer)videoPlayerList.get(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public void hidePlayers()
    {
        Log.debug("[InMobi]-[RE]-4.5.2", "MRAIDAudioVideoController: hiding all players");
        if (videoPlayer != null && videoPlayer.getState() != com.inmobi.re.controller.util.AVPlayer.playerState.RELEASED)
        {
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
            videoPlayer.hide();
        }
        Iterator iterator = audioPlayerList.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            AVPlayer avplayer = (AVPlayer)entry.getValue();
            switch (_cls7.a[avplayer.getState().ordinal()])
            {
            case 2: // '\002'
                avplayer.pause();
                break;

            case 4: // '\004'
                avplayer.releasePlayer(false);
                audioPlayerList.remove(entry.getKey());
                break;
            }
        } while (true);
    }

    public void mediaPlayerReleased(AVPlayer avplayer)
    {
        if (avplayer == audioplayer)
        {
            audioplayer = null;
        }
        if (avplayer == videoPlayer)
        {
            videoPlayer = null;
        }
        if (a(audioPlayerList, avplayer))
        {
            return;
        } else
        {
            a(videoPlayerList, avplayer);
            return;
        }
    }

    public void playAudioImpl(Bundle bundle, Activity activity)
    {
        com.inmobi.re.controller.JSController.PlayerProperties playerproperties = (com.inmobi.re.controller.JSController.PlayerProperties)bundle.getParcelable("player_properties");
        String s = bundle.getString("expand_url");
        bundle = s;
        if (s == null)
        {
            bundle = "";
        }
        if (a(playerproperties.id, bundle, activity))
        {
            if (bundle.length() != 0 && !URLUtil.isValidUrl(bundle) || bundle.length() == 0 && !audioPlayerList.containsKey(playerproperties.id))
            {
                a.raiseError("Request must specify a valid URL", "playAudio");
                return;
            }
            if (audioplayer != null)
            {
                if (bundle.length() != 0)
                {
                    audioplayer.setPlayData(playerproperties, bundle);
                }
                audioPlayerList.put(playerproperties.id, audioplayer);
                bundle = (FrameLayout)activity.findViewById(0x1020002);
                if (playerproperties.isFullScreen())
                {
                    android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
                    layoutparams.addRule(13);
                    audioplayer.setLayoutParams(layoutparams);
                    activity = new RelativeLayout(activity);
                    activity.setOnTouchListener(new _cls1());
                    activity.setBackgroundColor(0xff000000);
                    bundle.addView(activity, new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
                    activity.addView(audioplayer);
                    audioplayer.setBackGroundLayout(activity);
                    audioplayer.requestFocus();
                    audioplayer.setOnKeyListener(new _cls2());
                } else
                {
                    audioplayer.setLayoutParams(new android.view.ViewGroup.LayoutParams(1, 1));
                    bundle.addView(audioplayer);
                }
                audioplayer.setListener(new _cls3(playerproperties));
                audioplayer.play();
                return;
            }
        }
    }

    public void playVideoImpl(Bundle bundle, Activity activity)
    {
        com.inmobi.re.controller.JSController.PlayerProperties playerproperties = (com.inmobi.re.controller.JSController.PlayerProperties)bundle.getParcelable("player_properties");
        Object obj = (com.inmobi.re.controller.JSController.Dimensions)bundle.getParcelable("expand_dimensions");
        Log.debug("[InMobi]-[RE]-4.5.2", (new StringBuilder("Final dimensions: ")).append(obj).toString());
        bundle = bundle.getString("expand_url");
        if (!a(playerproperties.id, bundle, activity, ((com.inmobi.re.controller.JSController.Dimensions) (obj))))
        {
            return;
        }
        a.setBusy(true);
        if (bundle.length() == 0)
        {
            playerproperties = videoPlayer.getProperties();
            bundle = videoPlayer.getPlayDimensions();
            videoPlayer.getMediaURL();
        } else
        {
            videoPlayer.setPlayData(playerproperties, bundle);
            videoPlayer.setPlayDimensions(((com.inmobi.re.controller.JSController.Dimensions) (obj)));
            bundle = ((Bundle) (obj));
        }
        if (videoPlayer.getState() == com.inmobi.re.controller.util.AVPlayer.playerState.HIDDEN)
        {
            videoPlayer.pseudoPause = true;
            videoPlayer.show();
            return;
        }
        obj = (FrameLayout)activity.findViewById(0x1020002);
        if (playerproperties.isFullScreen())
        {
            bundle = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
            bundle.addRule(13);
            videoPlayer.setLayoutParams(bundle);
            bundle = new RelativeLayout(activity);
            bundle.setOnTouchListener(new _cls4());
            bundle.setBackgroundColor(0xff000000);
            ((FrameLayout) (obj)).addView(bundle, new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            bundle.addView(videoPlayer);
            videoPlayer.setBackGroundLayout(bundle);
            videoPlayer.requestFocus();
            videoPlayer.setOnKeyListener(new _cls5());
        } else
        {
            android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(((com.inmobi.re.controller.JSController.Dimensions) (bundle)).width, ((com.inmobi.re.controller.JSController.Dimensions) (bundle)).height);
            activity = new FrameLayout(activity);
            if (a.mExpandController.expandProperties == null)
            {
                layoutparams.leftMargin = ((com.inmobi.re.controller.JSController.Dimensions) (bundle)).x;
                layoutparams.topMargin = ((com.inmobi.re.controller.JSController.Dimensions) (bundle)).y;
            } else
            {
                layoutparams.leftMargin = ((com.inmobi.re.controller.JSController.Dimensions) (bundle)).x + a.mExpandController.expandProperties.currentX;
                layoutparams.topMargin = ((com.inmobi.re.controller.JSController.Dimensions) (bundle)).y + a.mExpandController.expandProperties.currentY;
            }
            layoutparams.gravity = 3;
            videoPlayer.setLayoutParams(layoutparams);
            ((FrameLayout) (obj)).addView(activity, new android.widget.FrameLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent()));
            videoPlayer.setBackGroundLayout(activity);
            activity.addView(videoPlayer);
        }
        videoPlayer.setListener(new _cls6());
        videoPlayer.play();
    }

    public void releaseAllPlayers()
    {
        if (videoPlayer != null)
        {
            videoPlayerList.put(videoPlayer.getPropertyID(), videoPlayer);
        }
        Object aobj[];
        int j;
        aobj = videoPlayerList.values().toArray();
        j = aobj.length;
        int i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = aobj[i];
        ((AVPlayer)obj).releasePlayer(IMWebView.userInitiatedClose);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception1;
        exception1;
        Log.internal("[InMobi]-[RE]-4.5.2", "Unable to release player");
          goto _L3
        Exception exception;
        exception;
        Log.internal("[InMobi]-[RE]-4.5.2", "IMwebview release all players ", exception);
_L1:
        videoPlayerList.clear();
        videoPlayer = null;
        exception = ((Exception) (audioPlayerList.values().toArray()));
        j = exception.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        exception1 = ((Exception) (exception[i]));
        ((AVPlayer)exception1).releasePlayer(IMWebView.userInitiatedClose);
_L6:
        i++;
        if (true) goto _L5; else goto _L4
        exception1;
        Log.internal("[InMobi]-[RE]-4.5.2", "Unable to release player");
          goto _L6
        exception;
        Log.internal("[InMobi]-[RE]-4.5.2", "IMwebview release all players ", exception);
_L4:
        IMWebView.userInitiatedClose = false;
        audioPlayerList.clear();
        audioplayer = null;
        return;
    }

    public void validateVideoDimensions(com.inmobi.re.controller.JSController.Dimensions dimensions)
    {
        dimensions.width = (int)((float)dimensions.width * a.getDensity());
        dimensions.height = (int)((float)dimensions.height * a.getDensity());
        dimensions.x = (int)((float)dimensions.x * a.getDensity());
        dimensions.y = (int)((float)dimensions.y * a.getDensity());
    }

    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls6 {}

}
