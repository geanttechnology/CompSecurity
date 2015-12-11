// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.launch;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.comcast.cim.android.view.launch.LaunchIntentInterceptor;
import com.comcast.cim.android.view.launch.LaunchStrategy;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.view.browsehistory.HistoryActivity;
import com.xfinity.playerlib.view.browsenetworks.NetworksActivity;
import com.xfinity.playerlib.view.browseprograms.LiveStreamsActivity;
import com.xfinity.playerlib.view.browseprograms.MoviesActivity;
import com.xfinity.playerlib.view.browseprograms.SeriesActivity;
import com.xfinity.playerlib.view.downloads.DownloadsActivity;
import com.xfinity.playerlib.view.favorite.BookmarksActivity;
import com.xfinity.playerlib.view.featured.FeaturedActivity;
import com.xfinity.playerlib.view.programdetails.EpisodeDetailActivity;
import com.xfinity.playerlib.view.programdetails.MovieDetailActivity;
import com.xfinity.playerlib.view.programdetails.SeriesEntityActivity;
import com.xfinity.playerlib.view.settings.PlayNowSettingsFragmentActivity;
import com.xfinity.playerlib.view.videoplay.VideoPlayerActivity;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlayNowLaunchIntentInterceptor
    implements LaunchIntentInterceptor
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/launch/PlayNowLaunchIntentInterceptor);
    private final AndroidDevice androidDevice;
    private final Context context;
    private final LaunchStrategy launchStrategy;
    private final String scheme;

    public PlayNowLaunchIntentInterceptor(Context context1, LaunchStrategy launchstrategy, AndroidDevice androiddevice, String s)
    {
        context = context1;
        launchStrategy = launchstrategy;
        androidDevice = androiddevice;
        scheme = s;
    }

    private void cancelNotificationIfRequested(Intent intent)
    {
        int i = intent.getIntExtra("EXTRA_NOTIFICATION_ID_TO_CANCEL", 0x80000000);
        intent = intent.getStringExtra("EXTRA_NOTIFICATION_TAG_TO_CANCEL");
        if (i != 0x80000000 && intent != null)
        {
            ((NotificationManager)context.getSystemService("notification")).cancel(intent, i);
        }
    }

    private Intent createDefaultScreenState()
    {
        return new Intent(context, launchStrategy.getDefaultActivityClass());
    }

    private List createEntityTargetStates(MerlinId merlinid, MerlinId merlinid1, long l, boolean flag, long l1)
    {
        com.xfinity.playerlib.model.MerlinId.Namespace namespace = merlinid.getNamespace();
        if (namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            return createMovieStack(merlinid1, flag, l1);
        }
        if (namespace.equals(com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries) && !merlinid.equals(merlinid1))
        {
            return createEpisodeStack(merlinid, merlinid1, l, flag, l1);
        } else
        {
            return createSeriesStack(merlinid1, flag, l1);
        }
    }

    private List createEpisodeStack(MerlinId merlinid, MerlinId merlinid1, long l, boolean flag, long l1)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        if (flag)
        {
            Intent intent = new Intent(context, com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
            intent.putExtras(VideoPlayerActivity.createBundle(merlinid1, merlinid, l, l1));
            arraylist.add(intent);
            return arraylist;
        }
        if (!androidDevice.isTabletDevice())
        {
            Intent intent1 = new Intent(context, com/xfinity/playerlib/view/programdetails/EpisodeDetailActivity);
            com.xfinity.playerlib.view.programdetails.DetailFragment.InstanceState instancestate = new com.xfinity.playerlib.view.programdetails.DetailFragment.InstanceState();
            instancestate.setSeriesId(merlinid);
            instancestate.setEpisodeId(merlinid1);
            intent1.putExtras(instancestate.addToBundle(new Bundle()));
            arraylist.add(intent1);
            return arraylist;
        } else
        {
            arraylist.add(createDefaultScreenState());
            Intent intent2 = new Intent(context, com/xfinity/playerlib/view/programdetails/SeriesEntityActivity);
            com.xfinity.playerlib.view.programdetails.SeriesEntityActivity.InstanceState instancestate1 = new com.xfinity.playerlib.view.programdetails.SeriesEntityActivity.InstanceState();
            instancestate1.setSeriesId(merlinid);
            instancestate1.setEpisodeId(merlinid1);
            intent2.putExtras(instancestate1.addToBundle(new Bundle()));
            arraylist.add(intent2);
            return arraylist;
        }
    }

    private List createLiveStreamPlaybackStack(String s, String s1)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        Intent intent = new Intent(context, com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
        if (s1 != null)
        {
            intent.putExtras(VideoPlayerActivity.createBundle(s, s1));
        } else
        {
            intent.putExtras(VideoPlayerActivity.createBundle(s));
        }
        arraylist.add(intent);
        return arraylist;
    }

    private List createLiveStreamTargetStates(String s)
    {
        return createLiveStreamPlaybackStack(s, null);
    }

    private List createLiveStreamTargetStates(String s, String s1)
    {
        return createLiveStreamPlaybackStack(s, s1);
    }

    private List createMovieStack(MerlinId merlinid, boolean flag, long l)
        throws NumberFormatException
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        if (flag)
        {
            Intent intent = new Intent(context, com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
            intent.putExtras(VideoPlayerActivity.createBundle(merlinid, merlinid, 0L, l));
            arraylist.add(intent);
            return arraylist;
        }
        if (androidDevice.isTabletDevice())
        {
            arraylist.add(createDefaultScreenState());
        }
        Intent intent1 = new Intent(context, com/xfinity/playerlib/view/programdetails/MovieDetailActivity);
        com.xfinity.playerlib.view.programdetails.DetailFragment.InstanceState instancestate = new com.xfinity.playerlib.view.programdetails.DetailFragment.InstanceState();
        instancestate.setMerlinId(merlinid);
        intent1.putExtras(instancestate.addToBundle(new Bundle()));
        arraylist.add(intent1);
        return arraylist;
    }

    private List createSeriesStack(MerlinId merlinid, boolean flag, long l)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        if (flag)
        {
            Intent intent = new Intent(context, com/xfinity/playerlib/view/videoplay/VideoPlayerActivity);
            intent.putExtras(VideoPlayerActivity.createBundle(merlinid, merlinid, 0L, l));
            arraylist.add(intent);
            return arraylist;
        }
        if (androidDevice.isTabletDevice())
        {
            arraylist.add(createDefaultScreenState());
        }
        Intent intent1 = new Intent(context, com/xfinity/playerlib/view/programdetails/SeriesEntityActivity);
        com.xfinity.playerlib.view.programdetails.SeriesEntityActivity.InstanceState instancestate = new com.xfinity.playerlib.view.programdetails.SeriesEntityActivity.InstanceState();
        instancestate.setSeriesId(merlinid);
        intent1.putExtras(instancestate.addToBundle(new Bundle()));
        arraylist.add(intent1);
        return arraylist;
    }

    private List createTargetStates(Uri uri)
    {
        Object obj;
        Object obj1;
        List list;
        obj = uri.getScheme();
        obj1 = uri.getHost();
        list = uri.getPathSegments();
        if (!"entity".equals(obj1) && !"playback".equals(obj1) && !"xfinitytv.comcast.net".equals(obj1)) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        flag = false;
        i = ((flag) ? 1 : 0);
        if (!"playback".equals(obj1))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        flag2 = true;
        obj1 = uri.getFragment();
        flag1 = flag2;
        i = ((flag) ? 1 : 0);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        obj1 = ((String) (obj1)).split("=");
        flag1 = flag2;
        i = ((flag) ? 1 : 0);
        if (obj1.length != 2)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        flag1 = flag2;
        i = ((flag) ? 1 : 0);
        if (!obj1[0].equals("t"))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        i = parseTimeStringToMillis(obj1[1]);
        flag1 = flag2;
_L8:
        long l = 0L;
        if (!"xfinitytvplaynow".equals(obj)) goto _L4; else goto _L3
_L3:
        obj = new MerlinId((String)list.get(0));
        static class _cls1
        {

            static final int $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[];

            static 
            {
                $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace = new int[com.xfinity.playerlib.model.MerlinId.Namespace.values().length];
                try
                {
                    $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.Movie.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace[com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.xfinity.playerlib.model.MerlinId.Namespace[((MerlinId) (obj)).getNamespace().ordinal()];
        JVM INSTR tableswitch 1 2: default 200
    //                   1 252
    //                   2 267;
           goto _L5 _L6 _L7
_L5:
        throw new IllegalArgumentException((new StringBuilder()).append("Was not expecting ").append(obj).toString());
        obj1;
        LOG.error("Failed to parse the time from the playback deeplink", ((Throwable) (obj1)));
        flag1 = flag2;
        i = ((flag) ? 1 : 0);
          goto _L8
_L6:
        uri = ((Uri) (obj));
_L9:
        return createEntityTargetStates(((MerlinId) (obj)), uri, 0L, flag1, i);
_L7:
        if (list.size() > 1)
        {
            uri = new MerlinId((String)list.get(1));
        } else
        {
            uri = ((Uri) (obj));
        }
        if (true) goto _L9; else goto _L4
_L4:
        if (!"http".equals(obj)) goto _L11; else goto _L10
_L10:
        obj = Long.valueOf(Long.parseLong(uri.getQueryParameter("programId")));
        obj1 = uri.getQueryParameter("episodeId");
        if (obj1 == null) goto _L13; else goto _L12
_L12:
        l = Long.parseLong(((String) (obj1)));
        obj = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries, ((Long) (obj)));
        obj1 = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode, Long.valueOf(l));
        uri = ((Uri) (obj));
        obj = uri;
_L15:
        return createEntityTargetStates(((MerlinId) (obj)), ((MerlinId) (obj1)), 0L, flag1, i);
_L13:
        obj = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.Movie, ((Long) (obj)));
        uri = ((Uri) (obj));
        obj1 = uri;
        if (true) goto _L15; else goto _L14
_L14:
        NumberFormatException numberformatexception;
        numberformatexception;
_L18:
        throw new IllegalArgumentException((new StringBuilder()).append("Invalid web link path: ").append(uri.getPath()).toString());
_L11:
        if (((String)list.get(0)).equals("0"))
        {
            MerlinId merlinid = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries, Long.valueOf(Long.parseLong((String)list.get(1))));
            if (list.size() >= 3)
            {
                obj1 = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode, Long.valueOf(Long.parseLong((String)list.get(2))));
                uri = ((Uri) (obj1));
                if (list.size() > 3)
                {
                    l = Long.parseLong((String)list.get(3));
                    uri = ((Uri) (obj1));
                }
            } else
            {
                uri = merlinid;
            }
            return createEntityTargetStates(merlinid, uri, l, flag1, i);
        }
        if (((String)list.get(0)).equals("1"))
        {
            uri = new MerlinId(com.xfinity.playerlib.model.MerlinId.Namespace.Movie, Long.valueOf(Long.parseLong((String)list.get(1))));
            return createEntityTargetStates(uri, uri, 0L, flag1, i);
        }
        if (((String)list.get(0)).equals("2"))
        {
            uri = (String)list.get(1);
            if (list.size() == 2)
            {
                return createLiveStreamTargetStates(uri);
            }
            if (list.size() == 3)
            {
                return createLiveStreamTargetStates(uri, (String)list.get(2));
            }
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid path: ").append(uri.getPath()).toString());
        }
          goto _L16
_L2:
        if ("discovery".equals(obj1))
        {
            return createTopLevelScreenStack(list);
        }
_L16:
        return null;
        merlinid;
        if (true) goto _L18; else goto _L17
_L17:
    }

    private List createTopLevelScreenStack(List list)
    {
        Object obj = (String)list.get(0);
        if (!((String) (obj)).equalsIgnoreCase("featured")) goto _L2; else goto _L1
_L1:
        obj = new Intent(context, com/xfinity/playerlib/view/featured/FeaturedActivity);
_L4:
        return Lists.newArrayList(new Intent[] {
            obj
        });
_L2:
        if (((String) (obj)).equalsIgnoreCase("networks"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/browsenetworks/NetworksActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("movies"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/browseprograms/MoviesActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("tv"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/browseprograms/SeriesActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("live"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/browseprograms/LiveStreamsActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("downloads"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/downloads/DownloadsActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("flagged"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/favorite/BookmarksActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("history"))
        {
            obj = new Intent(context, com/xfinity/playerlib/view/browsehistory/HistoryActivity);
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).equalsIgnoreCase("search"))
        {
            obj = createDefaultScreenState();
            continue; /* Loop/switch isn't completed */
        }
        if (!((String) (obj)).equalsIgnoreCase("settings"))
        {
            break; /* Loop/switch isn't completed */
        }
        Intent intent = new Intent(context, com/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity);
        if (list.size() > 1 && ((String)list.get(1)).equalsIgnoreCase("dm"))
        {
            intent.putExtra("resource", "manage_devices_prefs");
            obj = intent;
        } else
        {
            obj = intent;
            if (list.size() > 1)
            {
                obj = intent;
                if (((String)list.get(1)).equalsIgnoreCase("cd"))
                {
                    intent.putExtra("resource", "use_cellular_prefs");
                    obj = intent;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException();
    }

    private boolean isInputValid(Intent intent)
    {
        if (intent != null) goto _L2; else goto _L1
_L1:
        LOG.debug("intent is null; returning false");
_L4:
        return false;
_L2:
        String s;
        int i;
        intent = intent.getData();
        LOG.info((new StringBuilder()).append("uri=").append(intent).toString());
        if (intent == null)
        {
            LOG.debug("uri is null; returning false");
            return false;
        }
        if (!"xfinitytvplaynow".equals(intent.getScheme()) && !scheme.equals(intent.getScheme()) && !"http".equals(intent.getScheme()))
        {
            LOG.debug("invalid scheme; returning false");
            return false;
        }
        s = intent.getHost();
        if (!"entity".equals(s) && !"playback".equals(s) && !"discovery".equals(s) && !"xfinitytv.comcast.net".equals(s))
        {
            LOG.debug((new StringBuilder()).append("invalid host: ").append(s).toString());
            return false;
        }
        List list = intent.getPathSegments();
        if (list == null)
        {
            LOG.debug("pathSegments is null; returning false");
            return false;
        }
        i = list.size();
        if ("xfinitytvplaynow".equals(intent.getScheme()))
        {
            if (i != 1 && i != 2)
            {
                LOG.debug((new StringBuilder()).append("path size invalid xfinityplaynow scheme").append(i).append("; returning false").toString());
                return false;
            }
            break; /* Loop/switch isn't completed */
        }
        if (!"http".equals(intent.getScheme()))
        {
            continue; /* Loop/switch isn't completed */
        }
        if ("xfinitytv.comcast.net".equals(s) && i < 2) goto _L4; else goto _L3
_L3:
        return true;
        if ("entity".equals(s) && (i < 2 || i > 4) || "playback".equals(s) && i < 2 && i > 4 || "discovery".equals(s) && i != 1 && i != 2) goto _L4; else goto _L5
_L5:
        LOG.debug((new StringBuilder()).append("path size invalid xplay scheme").append(i).append("; returning false").toString());
          goto _L3
        if (true) goto _L4; else goto _L6
_L6:
    }

    private int parseTimeStringToMillis(String s)
    {
        String as[] = StringUtils.split(s, ':');
        if (as.length != 3)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported time format: ").append(s).toString());
        }
        int i;
        int j;
        int k;
        try
        {
            i = Integer.parseInt(as[0]);
            j = Integer.parseInt(as[1]);
            k = Integer.parseInt(as[2]);
        }
        catch (NumberFormatException numberformatexception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported time format: ").append(s).toString(), numberformatexception);
        }
        return (i * 3600 + j * 60 + k) * 1000;
    }

    String getScheme()
    {
        return scheme;
    }

    public List intercept(Intent intent)
        throws Exception
    {
        if (!isInputValid(intent))
        {
            return null;
        }
        cancelNotificationIfRequested(intent);
        List list;
        try
        {
            list = createTargetStates(intent.getData());
        }
        catch (Exception exception)
        {
            LOG.error((new StringBuilder()).append("Caught exception creating target intent uri ").append(intent.getData()).toString(), exception);
            throw new IllegalStateException(exception);
        }
        return list;
    }

}
