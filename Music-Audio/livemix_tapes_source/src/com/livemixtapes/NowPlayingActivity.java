// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.ActionBar;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.ui.FadeImageButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.livemixtapes:
//            console, App, ImageLoader, Utils, 
//            MediaObserver, LMTService, MainActivity, CommentsPopup

public class NowPlayingActivity extends Activity
{

    public static final int MIXTAPE_FLAG = 1;
    public static final int PLAYLIST_FLAG = 3;
    public static final int SEARCH_FLAG = 2;
    public static String artist;
    static TextView artistTitle;
    static TextView currentTime;
    static String currentURL;
    static FadeImageButton download;
    static long downloadId;
    public static int flag;
    static ImageLoader imageLoader;
    static Context mContext;
    public static Map mixtape;
    private static MediaObserver observer = null;
    public static Map playList;
    static ImageView playListImage;
    static FadeImageButton playOrPause;
    private static Boolean playing = Boolean.valueOf(false);
    public static int position;
    static FadeImageButton previous;
    static FadeImageButton repeat;
    public static boolean repeatStatus;
    static ArrayList savedTracksList;
    static SeekBar seekbar;
    static FadeImageButton share;
    static FadeImageButton shuffle;
    public static boolean shuffleStatus;
    public static String tape;
    static String tempDuration;
    public static String thumbURL;
    public static String title;
    static TextView totalTime;
    public static int trackCount;
    public static String trackDuration;
    static TextView trackTitle;
    static ArrayList tracksList;
    public static String whichTrack;
    FrameLayout mFrameLayout;
    FadeImageButton next;
    boolean touchtracking;

    public NowPlayingActivity()
    {
        touchtracking = false;
    }

    public static String formatDuration(double d)
    {
        double d1 = Math.floor(d / 3600D);
        d %= 3600D;
        double d2 = Math.floor(d / 60D);
        String s;
        if (d1 > 0.0D)
        {
            s = (new StringBuilder(String.valueOf((new StringBuilder(String.valueOf(""))).append((int)d1).append(":").toString()))).append(String.format("%02d", new Object[] {
                Integer.valueOf((int)d2)
            })).append(":").toString();
        } else
        {
            s = (new StringBuilder(String.valueOf(""))).append((int)d2).append(":").toString();
        }
        return (new StringBuilder(String.valueOf(s))).append(String.format("%02d", new Object[] {
            Integer.valueOf((int)(d % 60D))
        })).toString();
    }

    public static void initializeAndReload()
    {
        if (flag != 1) goto _L2; else goto _L1
_L1:
        tracksList = (ArrayList)mixtape.get("tracks");
_L4:
        savedTracksList = new ArrayList(tracksList);
        reloadData(true);
        return;
_L2:
        if (flag == 3)
        {
            tracksList = (ArrayList)playList.get("tracks");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void nextTrack()
    {
        console.log(new Object[] {
            "NEXT TRACK CALLED"
        });
        if (!repeatStatus && position == trackCount - 1)
        {
            return;
        }
        if (position == trackCount - 1)
        {
            if (repeatStatus)
            {
                position = 0;
            }
        } else
        {
            position++;
        }
        reloadTrackInfo();
    }

    public static void pause()
    {
        playOrPause.setImageResource(0x7f02008f);
        Intent intent = new Intent("com.livemixtapes.action.PAUSE");
        intent.setPackage("com.livemixtapes");
        App.context.startService(intent);
    }

    public static void play()
    {
        playOrPause.setImageResource(0x7f02008e);
        Intent intent = new Intent("com.livemixtapes.action.PLAY");
        intent.setPackage("com.livemixtapes");
        App.context.startService(intent);
    }

    public static void playpause()
    {
        Intent intent = new Intent("com.livemixtapes.action.TOGGLE_PLAYBACK");
        intent.setPackage("com.livemixtapes");
        App.context.startService(intent);
    }

    public static void previousTrack()
    {
        console.log(new Object[] {
            "PREVIOUS TRACKED CALLED"
        });
        if (!repeatStatus && position == 0)
        {
            return;
        }
        if (position == 0)
        {
            position = trackCount - 1;
        } else
        {
            position--;
        }
        reloadTrackInfo();
    }

    static void reloadData()
    {
        reloadData(true);
    }

    static void reloadData(boolean flag1)
    {
        if (flag != 1 && flag != 2) goto _L2; else goto _L1
_L1:
        artistTitle.setText((String)mixtape.get("title"));
        thumbURL = (String)mixtape.get("cover");
        Intent intent;
        try
        {
            imageLoader.DisplayImageWithoutCache((String)mixtape.get("cover"), playListImage);
            trackTitle.setText((new StringBuilder(String.valueOf(((HashMap)tracksList.get(position)).get("track_artist").toString()))).append(" - ").append(((HashMap)tracksList.get(position)).get("track_title").toString()).toString());
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        tape = (String)mixtape.get("title");
        title = ((HashMap)tracksList.get(position)).get("track_title").toString();
        try
        {
            artist = ((HashMap)tracksList.get(position)).get("track_artist").toString();
        }
        catch (Exception exception1)
        {
            if (mixtape.containsKey("artist"))
            {
                artist = (String)mixtape.get("artist");
            } else
            {
                artist = "";
            }
        }
_L4:
        trackCount = tracksList.size();
        whichTrack = ((HashMap)tracksList.get(position)).get("track_id").toString();
        HashMap hashmap;
        Exception exception2;
        if (Utils.isFileExists(App.context, whichTrack))
        {
            console.log(new Object[] {
                "TRACK IS DOWNLOADED"
            });
            currentURL = (new StringBuilder("file://")).append(Utils.getLivemixtapesFolder(mContext, ((HashMap)tracksList.get(position)).get("track_id").toString())).toString();
            console.log(new Object[] {
                (new StringBuilder("TRACK URL IS: ")).append(currentURL).toString()
            });
            download.setVisibility(4);
        } else
        {
            console.log(new Object[] {
                "TRACK IS NOT DOWNLOADED"
            });
            Exception exception3;
            try
            {
                currentURL = ((HashMap)tracksList.get(position)).get("download_url").toString();
            }
            catch (Exception exception4) { }
            download.setVisibility(0);
        }
        tempDuration = ((HashMap)tracksList.get(position)).get("track_duration").toString();
        trackDuration = tempDuration;
        totalTime.setText(formatDuration(Double.valueOf(tempDuration).doubleValue()));
        currentTime.setText("0:00");
        if (flag1)
        {
            playing = Boolean.valueOf(true);
            intent = new Intent("com.livemixtapes.action.URL");
            intent.setPackage("com.livemixtapes");
            intent.setData(Uri.parse(currentURL));
            App.context.startService(intent);
            playOrPause.setBackgroundResource(0x7f02008e);
        }
        if (observer != null)
        {
            observer.stop();
        }
        try
        {
            observer.unstop();
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception3) { }
        App.showNotification(title, playListImage);
        return;
_L2:
        if (flag == 3)
        {
            hashmap = (HashMap)tracksList.get(position);
            try
            {
                artistTitle.setText((CharSequence)hashmap.get("track_artist"));
            }
            catch (Exception exception5) { }
            thumbURL = ((String)hashmap.get("track_mixtape_thumb")).replace("tn_", "");
            try
            {
                imageLoader.DisplayImageWithoutCache(thumbURL, playListImage);
                trackTitle.setText((new StringBuilder(String.valueOf(((String)hashmap.get("track_artist")).toString()))).append(" - ").append(((String)hashmap.get("track_title")).toString()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2)
            {
                exception2.printStackTrace();
            }
            tape = "Playlist";
            title = ((HashMap)tracksList.get(position)).get("track_title").toString();
            try
            {
                artist = ((HashMap)tracksList.get(position)).get("track_artist").toString();
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception2)
            {
                artist = "";
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void reloadTrackInfo()
    {
        reloadData();
    }

    private void setListeners()
    {
        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                boolean flag1;
                if (NowPlayingActivity.playing.booleanValue())
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
                NowPlayingActivity.playing = Boolean.valueOf(flag1);
                if (NowPlayingActivity.playing.booleanValue())
                {
                    try
                    {
                        view = new Intent("com.livemixtapes.action.PLAY");
                        view.setPackage("com.livemixtapes");
                        App.context.startService(view);
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view) { }
                    NowPlayingActivity.playOrPause.setImageResource(0x7f02008e);
                    return;
                }
                try
                {
                    view = new Intent("com.livemixtapes.action.PAUSE");
                    view.setPackage("com.livemixtapes");
                    App.context.startService(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                NowPlayingActivity.playOrPause.setImageResource(0x7f02008f);
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        };
        playOrPause.setOnClickListener(onclicklistener);
        onclicklistener = new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    (new Intent("com.livemixtapes.action.STOP")).setPackage("com.livemixtapes");
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                NowPlayingActivity.nextTrack();
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        };
        next.setOnClickListener(onclicklistener);
        onclicklistener = new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                try
                {
                    (new Intent("com.livemixtapes.action.STOP")).setPackage("com.livemixtapes");
                }
                // Misplaced declaration of an exception variable
                catch (View view) { }
                NowPlayingActivity.previousTrack();
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        };
        previous.setOnClickListener(onclicklistener);
        shuffle.setOnClickListener(new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                boolean flag1;
                if (NowPlayingActivity.shuffleStatus)
                {
                    NowPlayingActivity.tracksList = new ArrayList(NowPlayingActivity.savedTracksList);
                    NowPlayingActivity.shuffle.setImageResource(0x7f0200dd);
                } else
                {
                    Collections.shuffle(NowPlayingActivity.tracksList);
                    NowPlayingActivity.shuffle.setImageResource(0x7f0200dc);
                }
                if (NowPlayingActivity.shuffleStatus)
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
                NowPlayingActivity.shuffleStatus = flag1;
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        });
        repeat.setOnClickListener(new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                boolean flag1;
                if (NowPlayingActivity.repeatStatus)
                {
                    NowPlayingActivity.repeat.setImageResource(0x7f0200cf);
                } else
                {
                    NowPlayingActivity.repeat.setImageResource(0x7f0200ce);
                }
                if (NowPlayingActivity.repeatStatus)
                {
                    flag1 = false;
                } else
                {
                    flag1 = true;
                }
                NowPlayingActivity.repeatStatus = flag1;
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        });
        seekbar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final NowPlayingActivity this$0;

            public void onProgressChanged(SeekBar seekbar1, int i, boolean flag1)
            {
                if (!touchtracking || !flag1)
                {
                    break MISSING_BLOCK_LABEL_157;
                }
                int j = Integer.parseInt(NowPlayingActivity.trackDuration);
                console.log(new Object[] {
                    (new StringBuilder("SEEKING TO UPDATE: ")).append(i).toString()
                });
                console.log(new Object[] {
                    (new StringBuilder("TRACK DURATION: ")).append(NowPlayingActivity.trackDuration).toString()
                });
                seekbar1 = Double.valueOf(Double.valueOf(Double.valueOf(Double.valueOf(i).doubleValue() * Double.valueOf(j).doubleValue()).doubleValue() / 100D).doubleValue() * 1000D);
                console.log(new Object[] {
                    (new StringBuilder("SEEKING TO ")).append(seekbar1.intValue()).toString()
                });
                LMTService.mPlayer.seekTo(seekbar1.intValue());
                return;
                seekbar1;
            }

            public void onStartTrackingTouch(SeekBar seekbar1)
            {
                touchtracking = true;
                NowPlayingActivity.observer.stop();
            }

            public void onStopTrackingTouch(SeekBar seekbar1)
            {
                touchtracking = false;
                NowPlayingActivity.observer.unstop();
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        });
        download.setOnClickListener(new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                view = (HashMap)NowPlayingActivity.tracksList.get(NowPlayingActivity.position);
                android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Uri.parse(((String)view.get("download_url")).toString()));
                request.setDescription(((String)view.get("track_title")).toString());
                request.setTitle(((String)view.get("track_title")).toString());
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(0);
                }
                request.setAllowedNetworkTypes(3);
                DBHelper.sharedInstance(NowPlayingActivity.mContext).insertDownload((String)view.get("track_id"), (String)view.get("track_title"), NowPlayingActivity.mixtape.get("id").toString(), (String)NowPlayingActivity.mixtape.get("title"), NowPlayingActivity.mixtape.get("cover").toString(), (String)view.get("track_duration"), 1);
                request.setDestinationUri(Uri.fromFile(Utils.getLivemixtapesFolder(NowPlayingActivity.mContext, ((String)view.get("track_id")).toString())));
                ((DownloadManager)NowPlayingActivity.mContext.getSystemService("download")).enqueue(request);
                NowPlayingActivity.download.setVisibility(4);
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        });
    }

    public static void setTrack(int i)
    {
    }

    public static void stop()
    {
        playOrPause.setImageResource(0x7f02008f);
        Intent intent = new Intent("com.livemixtapes.action.PAUSE");
        intent.setPackage("com.livemixtapes");
        App.context.startService(intent);
    }

    public static void updatePosition()
    {
        LMTService.mPlayer.isPlaying();
        int i = LMTService.mPlayer.getCurrentPosition() / 1000;
        int j = Integer.parseInt(trackDuration);
        currentTime.setText(formatDuration(Double.valueOf(i).doubleValue()));
        double d = Double.valueOf(Double.valueOf(i).doubleValue() / Double.valueOf(j).doubleValue()).doubleValue();
        seekbar.setProgress(Double.valueOf(d * 100D).intValue());
    }

    int getIndividualFileProgress(long l)
    {
        Object obj = (DownloadManager)mContext.getSystemService("download");
        android.app.DownloadManager.Query query = new android.app.DownloadManager.Query();
        query.setFilterById(new long[] {
            l
        });
        obj = ((DownloadManager) (obj)).query(query);
        if (obj == null || !((Cursor) (obj)).moveToFirst())
        {
            return 0;
        }
        int i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("bytes_so_far"));
        int j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("total_size"));
        if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("status")) == 8)
        {
            ((Cursor) (obj)).close();
            return 100;
        } else
        {
            i = (int)(((long)i * 100L) / (long)j);
            ((Cursor) (obj)).close();
            return i;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002d);
        mContext = this;
        getActionBar().setDisplayShowTitleEnabled(false);
        getActionBar().setIcon(new ColorDrawable(getResources().getColor(0x106000d)));
        trackTitle = (TextView)findViewById(0x7f0800d1);
        artistTitle = (TextView)findViewById(0x7f0800d6);
        playListImage = (ImageView)findViewById(0x7f0800d7);
        seekbar = (SeekBar)findViewById(0x7f0800da);
        currentTime = (TextView)findViewById(0x7f0800db);
        totalTime = (TextView)findViewById(0x7f0800dc);
        share = (FadeImageButton)findViewById(0x7f0800de);
        download = (FadeImageButton)findViewById(0x7f0800df);
        playOrPause = (FadeImageButton)findViewById(0x7f0800e2);
        previous = (FadeImageButton)findViewById(0x7f0800e3);
        next = (FadeImageButton)findViewById(0x7f0800e4);
        shuffle = (FadeImageButton)findViewById(0x7f0800e0);
        repeat = (FadeImageButton)findViewById(0x7f0800e1);
        shuffleStatus = false;
        repeatStatus = true;
        mFrameLayout = (FrameLayout)findViewById(0x7f0800d5);
        mFrameLayout.getForeground().setAlpha(0);
        imageLoader = new ImageLoader(getApplicationContext());
        if (observer == null)
        {
            observer = new MediaObserver(this);
            (new Thread(observer)).start();
        }
        if (MainActivity.firstLoad)
        {
            MainActivity.fromWidget = true;
            MainActivity.firstLoad = false;
            finish();
        }
        if (MainActivity.fromWidget)
        {
            MainActivity.fromWidget = false;
        }
        reloadData(false);
        share.setOnClickListener(new android.view.View.OnClickListener() {

            final NowPlayingActivity this$0;

            public void onClick(View view)
            {
                (new CommentsPopup(NowPlayingActivity.this, NowPlayingActivity.mContext, NowPlayingActivity.mixtape)).showPopup(mFrameLayout, NowPlayingActivity.share);
            }

            
            {
                this$0 = NowPlayingActivity.this;
                super();
            }
        });
        observer.unstop();
        playOrPause.setImageResource(0x7f02008e);
        playing = Boolean.valueOf(true);
        setListeners();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f100001, menu);
        getActionBar().setTitle("Now Playing");
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131231037: 
            finish();
            break;
        }
        return true;
    }

    public void onResume()
    {
        super.onResume();
        console.log(new Object[] {
            "LOGGING NOW PLAYING ACTIVITY"
        });
        App app = (App)getApplication();
        app.getDefaultTracker().setScreenName("Image~NowPlayingActivity");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
    }




}
