// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.analytics.Tracker;
import com.livemixtapes.database.DBHelper;
import com.livemixtapes.library.JSONParser;
import com.livemixtapes.profile.SeeAllList;
import com.livemixtapes.ui.BaseActivity;
import com.livemixtapes.ui.widgets.DjBadgesView;
import com.livemixtapes.utils.Utility;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import net.lingala.zip4j.core.ZipFile;
import org.json.JSONObject;

// Referenced classes of package com.livemixtapes:
//            User, AsyncHttp, LazyAdapterTracks, console, 
//            Utils, MixtapeList, App, MainActivity, 
//            NowPlayingActivity, ImageLoader, CommentsPopup, SignUp

public class Mixtape extends Fragment
    implements android.view.View.OnClickListener
{

    public static final int ACTION_DOWNLOAD = 2;
    public static final int ACTION_NONE = 0;
    public static final int ACTION_PLAY = 1;
    public static final String ARG_INITIAL_ACTION = "init_action";
    private static CountDownTimer Count;
    private static final int DAY = 0x5265c00;
    private static final int HOUR = 0x36ee80;
    private static final int MINUTE = 60000;
    private static final int SECOND = 1000;
    private static long dayValue = 0L;
    private static long hourValue = 0L;
    private static long minuteValue = 0L;
    private static long secondValue = 0L;
    public static boolean shouldClearPlayListMode;
    private static long tempDay = 0L;
    private static long tempHour = 0L;
    private static long tempMinute = 0L;
    private static long tempSecond = 0L;
    LazyAdapterTracks adapter;
    Button addTracksButton;
    LinearLayout buttonShare;
    private ImageButton comments;
    private TextView countText;
    private ImageView cover;
    private TextView date;
    DBHelper dbHelper;
    private ImageButton dislike;
    DjBadgesView djBadges;
    private com.livemixtapes.ui.widgets.DjBadgesView.DjClickListener djClickListener;
    private ImageButton downloadAll;
    private ProgressBar downloadAllProgressBar;
    DownloadManager downloadManager;
    public HashMap downloadProgressList;
    TextView downloadStatus;
    TextView downloadZip;
    private ImageButton favorite;
    private Boolean favorited;
    private View filler;
    Timer globalTimer;
    Handler handler;
    private View header;
    private int id;
    private View info;
    private int lastValue;
    private ViewGroup layout;
    LinearLayout layoutBack;
    private ImageButton like;
    public HashMap listPosMap;
    Context mContext;
    private int mScrollState;
    private FrameLayout mainFrameLayout;
    private int maxCoverSize;
    private int maxHeaderSize;
    private Boolean measured;
    private int minCoverSize;
    private int minHeaderSize;
    Map mixtape;
    private View mixtapeBtns;
    MainActivity parentActivity;
    private ImageButton playAll;
    private ImageButton playlist;
    public Boolean playlistMode;
    private long release_seconds;
    View rootView;
    private TextView score;
    private TextView scorelabel;
    public ArrayList selectedPlayListTracks;
    private int skipNoise;
    TextView textViewBack;
    TextView textViewTitle;
    private TextView title;
    private View trackBtns;
    private ListView tracks;
    private TextView views;
    private Boolean voted;
    private Boolean voting;

    public Mixtape()
    {
        measured = Boolean.valueOf(false);
        countText = null;
        lastValue = 0;
        skipNoise = 0;
        downloadProgressList = new HashMap();
        listPosMap = new HashMap();
        mScrollState = 0;
        favorited = Boolean.valueOf(false);
        voted = Boolean.valueOf(false);
        voting = Boolean.valueOf(false);
        playlistMode = Boolean.valueOf(false);
        selectedPlayListTracks = new ArrayList();
        djClickListener = new com.livemixtapes.ui.widgets.DjBadgesView.DjClickListener() {

            final Mixtape this$0;

            public void onClickDj(String s)
            {
                loadDjList(s);
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        };
    }

    private void disableVoteButtons()
    {
        like.setAlpha(0.3F);
        like.setEnabled(false);
        like.setClickable(false);
        dislike.setAlpha(0.3F);
        dislike.setEnabled(false);
        dislike.setClickable(false);
    }

    private void dislikeMixtape()
    {
        if (voted.booleanValue() || voting.booleanValue())
        {
            return;
        } else
        {
            markMixtape();
            final ProgressDialog dialog = ProgressDialog.show(mContext, "Disliking ...", "Disliking ...", true);
            HashMap hashmap = new HashMap();
            hashmap.put("id", mixtape.get("id").toString());
            hashmap.put("auth", User.getAuth());
            (new AsyncHttp()).get("https://api.livemixtapes.com/api/vote/down", hashmap, new AsyncHttp.AsyncHttpCallback() {

                final Mixtape this$0;
                private final ProgressDialog val$dialog;

                protected void always()
                {
                    voting = Boolean.valueOf(false);
                    dialog.dismiss();
                }

                protected void exception(Exception exception1)
                {
                    console.log(new Object[] {
                        exception1
                    });
                }

                protected void success(String s, String s1, int i)
                {
                    console.log(new Object[] {
                        s, s1, Integer.valueOf(i)
                    });
                    disableVoteButtons();
                    voted = Boolean.valueOf(true);
                    i = Integer.valueOf((String)mixtape.get("score")).intValue();
                    score.setText(Utils.formatWithCommas(i - 1));
                }

            
            {
                this$0 = Mixtape.this;
                dialog = progressdialog;
                super();
            }
            });
            return;
        }
    }

    private void downloadMixtapeZip(String s, final View downloadZipView, AlertDialog alertdialog)
    {
        alertdialog = new HashMap();
        (new AsyncHttp()).get((new StringBuilder("https://api.livemixtapes.com/api/download/mixtape?id=")).append(s).append("&auth=").append(User.getAuth()).toString(), alertdialog, new AsyncHttp.AsyncHttpCallback() {

            final Mixtape this$0;
            private final View val$downloadZipView;

            protected void always()
            {
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    exception1
                });
            }

            protected void success(String s1, String s2, int i)
            {
                String s3;
                console.log(new Object[] {
                    (new StringBuilder("download response: ")).append(id).toString(), s1, s2, Integer.valueOf(i)
                });
                s2 = "download unavailable";
                s3 = "file.zip";
                s1 = (new JSONObject(s1)).getString("download_url");
                s2 = s1;
                console.log(new Object[] {
                    (new StringBuilder("zip url: ")).append(s1).toString()
                });
                s2 = s1;
                String as[] = s1.split("/");
                s2 = s1;
                String s4 = as[as.length - 1];
                s2 = s1;
                s1 = s4;
_L2:
                if (s2.equals("download unavailable"))
                {
                    ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                        final _cls22 this$1;

                        public void run()
                        {
                            (new android.app.AlertDialog.Builder(mContext)).setTitle("Download Unavailable").setMessage("This mixtape cannot be downloaded yet.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }).setIcon(0x1080027).show();
                        }

            
            {
                this$1 = _cls22.this;
                super();
            }
                    });
                    return;
                }
                downloadStatus = (TextView)downloadZipView.findViewById(0x7f080077);
                s2 = new android.app.DownloadManager.Request(Uri.parse(s2));
                s2.setAllowedNetworkTypes(3).setAllowedOverRoaming(false).setTitle((String)mixtape.get("title")).setDescription("Downloading mixtape zip file...").setDestinationInExternalPublicDir(Environment.DIRECTORY_MUSIC, s1);
                console.log(new Object[] {
                    (new StringBuilder("DOWNLOADING: ")).append(s1).toString()
                });
                final long zipdownloadid = downloadManager.enqueue(s2);
                if (s1.contains("?"))
                {
                    s1 = s1.split("\\?")[0];
                }
                (new Thread(s1. new Runnable() {

                    final _cls22 this$1;
                    private final String val$unzip_filename;
                    private final long val$zipdownloadid;

                    public void run()
                    {
                        boolean flag = true;
_L2:
                        Object obj;
                        String s;
                        int i;
                        int j;
                        if (!flag)
                        {
                            return;
                        }
                        obj = new android.app.DownloadManager.Query();
                        ((android.app.DownloadManager.Query) (obj)).setFilterById(new long[] {
                            zipdownloadid
                        });
                        obj = downloadManager.query(((android.app.DownloadManager.Query) (obj)));
                        ((Cursor) (obj)).moveToFirst();
                        i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("bytes_so_far"));
                        j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("total_size"));
                        if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("status")) != 8)
                        {
                            break MISSING_BLOCK_LABEL_327;
                        }
                        flag = false;
                        ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                            final _cls2 this$2;

                            public void run()
                            {
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        console.log(new Object[] {
                            (new StringBuilder("UNZIPPING: ")).append(unzip_filename).toString()
                        });
                        ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                            final _cls2 this$2;

                            public void run()
                            {
                                (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Unzipping").setMessage("Your mixtape is downloaded and it is now unzipping...please wait.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                                    final _cls2 this$3;

                                    public void onClick(DialogInterface dialoginterface, int i)
                                    {
                                        dialoginterface.dismiss();
                                    }

            
            {
                this$3 = _cls2.this;
                super();
            }
                                }).setIcon(0x1080027).show();
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        s = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString();
                        ZipFile zipfile = new ZipFile((new StringBuilder(String.valueOf(s))).append("/").append(unzip_filename).toString());
                        zipfile.isEncrypted();
                        zipfile.extractAll(s);
                        try
                        {
                            (new File((new StringBuilder(String.valueOf(s))).append("/").append(unzip_filename).toString())).delete();
                            s = unzip_filename.replace(".zip", "");
                            scanMedia(s);
                            App.isUnzipping = false;
                            ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                                final _cls2 this$2;

                                public void run()
                                {
                                    (new android.app.AlertDialog.Builder(mContext)).setTitle("Download Complete").setMessage("Your mixtape has finished downloading!  We extracted the zip for you too!").setPositiveButton("Thanks!", new android.content.DialogInterface.OnClickListener() {

                                        final _cls3 this$3;

                                        public void onClick(DialogInterface dialoginterface, int i)
                                        {
                                            dialoginterface.dismiss();
                                        }

            
            {
                this$3 = _cls3.this;
                super();
            }
                                    }).setIcon(0x1080027).show();
                                }

            
            {
                this$2 = _cls2.this;
                super();
            }
                            });
                        }
                        catch (Exception exception)
                        {
                            try
                            {
                                exception.printStackTrace();
                            }
                            catch (Exception exception1)
                            {
                                exception1.printStackTrace();
                            }
                        }
                        i = (int)(((long)i * 100L) / (long)j);
                        ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                            final _cls2 this$2;

                            public void run()
                            {
                            }

            
            {
                this$2 = _cls2.this;
                super();
            }
                        });
                        ((Cursor) (obj)).close();
                        if (true) goto _L2; else goto _L1
_L1:
                    }


            
            {
                this$1 = final__pcls22;
                zipdownloadid = l;
                unzip_filename = String.this;
                super();
            }
                })).start();
                return;
                s1;
                s1 = s3;
                if (true) goto _L2; else goto _L1
_L1:
            }


            
            {
                this$0 = Mixtape.this;
                downloadZipView = view;
                super();
            }
        });
    }

    private void enableVoteButtons()
    {
        like.setAlpha(1.0F);
        like.setEnabled(true);
        like.setClickable(true);
        dislike.setAlpha(1.0F);
        dislike.setEnabled(true);
        dislike.setClickable(true);
    }

    private void enterPlaylistMode()
    {
        playlistMode = Boolean.valueOf(true);
        adapter.notifyDataSetChanged();
        addTracksButton.setVisibility(0);
    }

    private void exitPlaylistMode()
    {
        playlistMode = Boolean.valueOf(false);
        selectedPlayListTracks.clear();
        adapter.notifyDataSetChanged();
        addTracksButton.setVisibility(8);
    }

    private void favoriteMixtape()
    {
        final ProgressDialog dialog = ProgressDialog.show(mContext, "Saving ...", "Saving ...", true);
        HashMap hashmap = new HashMap();
        hashmap.put("album_id", mixtape.get("id").toString());
        (new AsyncHttp()).post((new StringBuilder("https://api.livemixtapes.com/api/favorites/add?auth=")).append(User.getAuth()).toString(), hashmap, new AsyncHttp.AsyncHttpCallback() {

            final Mixtape this$0;
            private final ProgressDialog val$dialog;

            protected void always()
            {
                dialog.dismiss();
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    exception1
                });
            }

            protected void success(String s, String s1, int i)
            {
                console.log(new Object[] {
                    (new StringBuilder("added: ")).append(id).toString(), s, s1, Integer.valueOf(i)
                });
                favorite.setImageResource(0x7f0200ff);
                favorited = Boolean.valueOf(true);
                User.addFavoriteMixtape(mixtape);
            }

            
            {
                this$0 = Mixtape.this;
                dialog = progressdialog;
                super();
            }
        });
    }

    private void getMixtapeInfo()
    {
        (new AsyncTask() {

            final Mixtape this$0;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected transient JSONObject doInBackground(String as[])
            {
                as = (new JSONParser()).getUrlResponse((new StringBuilder("https://api.livemixtapes.com/api/stats?id=")).append(mixtape.get("id").toString()).toString());
                try
                {
                    as = new JSONObject(as);
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    return null;
                }
                return as;
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((JSONObject)obj);
            }

            protected void onPostExecute(JSONObject jsonobject)
            {
                if (jsonobject == null)
                {
                    break MISSING_BLOCK_LABEL_71;
                }
                views.setText(Html.fromHtml((new StringBuilder("Mixtape Views: <b>")).append(Utils.formatWithCommas(jsonobject.get("views").toString())).append("</b>").toString()));
                score.setText(Utils.formatWithCommas(jsonobject.getString("score").toString()));
                return;
                jsonobject;
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        }).execute(new String[] {
            ""
        });
    }

    private void likeMixtape()
    {
        if (voted.booleanValue() || voting.booleanValue())
        {
            return;
        } else
        {
            markMixtape();
            final ProgressDialog dialog = ProgressDialog.show(mContext, "Liking ...", "Liking ...", true);
            HashMap hashmap = new HashMap();
            hashmap.put("id", mixtape.get("id").toString());
            hashmap.put("auth", User.getAuth());
            (new AsyncHttp()).get("https://api.livemixtapes.com/api/vote/up", hashmap, new AsyncHttp.AsyncHttpCallback() {

                final Mixtape this$0;
                private final ProgressDialog val$dialog;

                protected void always()
                {
                    voting = Boolean.valueOf(false);
                    dialog.dismiss();
                }

                protected void exception(Exception exception1)
                {
                    console.log(new Object[] {
                        exception1
                    });
                }

                protected void success(String s, String s1, int i)
                {
                    console.log(new Object[] {
                        s, s1, Integer.valueOf(i)
                    });
                    disableVoteButtons();
                    voted = Boolean.valueOf(true);
                    i = Integer.valueOf((String)mixtape.get("score")).intValue();
                    score.setText(Utils.formatWithCommas(i + 1));
                }

            
            {
                this$0 = Mixtape.this;
                dialog = progressdialog;
                super();
            }
            });
            return;
        }
    }

    private void scanMedia(String s)
    {
        new ArrayList();
        s = (new File((new StringBuilder(String.valueOf(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).toString()))).append("/").append(s).toString())).listFiles();
        if (s == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = s.length;
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        File file = s[i];
        if (file.isFile())
        {
            String s1 = file.getAbsolutePath();
            if (s1.substring(s1.lastIndexOf(".") + 1).equalsIgnoreCase("mp3"))
            {
                try
                {
                    Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                    intent.setData(Uri.fromFile(file));
                    mContext.sendBroadcast(intent);
                }
                catch (Exception exception) { }
                console.log(new Object[] {
                    (new StringBuilder(String.valueOf(s1))).append(" is a media file ").toString()
                });
            }
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void shake(View view, final Runnable callback)
    {
        Animation animation = AnimationUtils.loadAnimation(mContext, 0x7f04000c);
        animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final Mixtape this$0;
            private final Runnable val$callback;

            public void onAnimationEnd(Animation animation1)
            {
                if (callback != null)
                {
                    callback.run();
                }
            }

            public void onAnimationRepeat(Animation animation1)
            {
            }

            public void onAnimationStart(Animation animation1)
            {
            }

            
            {
                this$0 = Mixtape.this;
                callback = runnable;
                super();
            }
        });
        view.startAnimation(animation);
    }

    private void showGuestWarning()
    {
        (new android.app.AlertDialog.Builder(mContext)).setTitle("Account Required").setMessage("Sign up to create playlists, vote, comment and more!\nIt's free!").setPositiveButton("Not Now", new android.content.DialogInterface.OnClickListener() {

            final Mixtape this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        }).setNegativeButton("Sign Up", new android.content.DialogInterface.OnClickListener() {

            final Mixtape this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                startActivity(new Intent(App.context, com/livemixtapes/SignUp));
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        }).setIcon(0x108009b).show();
    }

    private void toggleFavorite()
    {
        if (User.isGuest().booleanValue())
        {
            showGuestWarning();
            return;
        }
        if (favorited.booleanValue())
        {
            unfavoriteMixtape();
            return;
        } else
        {
            favoriteMixtape();
            return;
        }
    }

    private void togglePlaylistMode()
    {
        if (User.isGuest().booleanValue())
        {
            showGuestWarning();
            return;
        }
        if (playlistMode.booleanValue())
        {
            exitPlaylistMode();
            return;
        } else
        {
            enterPlaylistMode();
            return;
        }
    }

    private void unfavoriteMixtape()
    {
        final ProgressDialog dialog = ProgressDialog.show(mContext, "Saving ...", "Saving ...", true);
        HashMap hashmap = new HashMap();
        hashmap.put("album_id", mixtape.get("id").toString());
        (new AsyncHttp()).post((new StringBuilder("https://api.livemixtapes.com/api/favorites/remove?auth=")).append(User.getAuth()).toString(), hashmap, new AsyncHttp.AsyncHttpCallback() {

            final Mixtape this$0;
            private final ProgressDialog val$dialog;

            protected void always()
            {
                dialog.dismiss();
            }

            protected void exception(Exception exception1)
            {
                console.log(new Object[] {
                    exception1
                });
            }

            protected void success(String s, String s1, int i)
            {
                console.log(new Object[] {
                    (new StringBuilder("removed: ")).append(id).toString(), s, s1, Integer.valueOf(i)
                });
                favorite.setImageResource(0x7f0200eb);
                favorited = Boolean.valueOf(false);
                User.removeFavoriteMixtape(id);
            }

            
            {
                this$0 = Mixtape.this;
                dialog = progressdialog;
                super();
            }
        });
    }

    public void calcMeasurements()
    {
        if (measured.booleanValue())
        {
            return;
        } else
        {
            maxCoverSize = cover.getWidth();
            minCoverSize = (int)((double)maxCoverSize * 0.5D);
            int i = (int)((double)maxCoverSize * 0.27000000000000002D);
            Object obj = (android.view.ViewGroup.MarginLayoutParams)mixtapeBtns.getLayoutParams();
            android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)info.getLayoutParams();
            obj.height = i;
            mixtapeBtns.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            trackBtns.getLayoutParams().height = i;
            maxHeaderSize = maxCoverSize + i * 2;
            maxHeaderSize = maxHeaderSize + ((android.view.ViewGroup.MarginLayoutParams) (obj)).bottomMargin * 2;
            maxHeaderSize = maxHeaderSize + marginlayoutparams.topMargin;
            minHeaderSize = maxHeaderSize - (maxCoverSize - minCoverSize) - i;
            obj = new android.widget.LinearLayout.LayoutParams(maxCoverSize, maxCoverSize);
            obj.weight = 0.0F;
            cover.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new android.widget.RelativeLayout.LayoutParams(-1, maxHeaderSize);
            header.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            filler = getActivity().getLayoutInflater().inflate(0x7f030020, tracks, false);
            filler.getLayoutParams().height = maxHeaderSize - 1;
            tracks.addHeaderView(filler, null, false);
            filler.getLayoutParams().height = maxHeaderSize - 1;
            measured = Boolean.valueOf(true);
            return;
        }
    }

    void changeImageButtonImage(final int pos, final boolean isDownload)
    {
        handler.post(new Runnable() {

            final Mixtape this$0;
            private final boolean val$isDownload;
            private final int val$pos;

            public void run()
            {
                View view;
                if (pos >= tracks.getFirstVisiblePosition())
                {
                    if ((view = tracks.getChildAt(pos - tracks.getFirstVisiblePosition())) != null)
                    {
                        if (isDownload)
                        {
                            ((ImageButton)view.findViewById(0x7f0800df)).setImageResource(0x7f020095);
                            return;
                        } else
                        {
                            ((ImageButton)view.findViewById(0x7f0800df)).setImageResource(0x7f0200bd);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = Mixtape.this;
                pos = i;
                isDownload = flag;
                super();
            }
        });
    }

    boolean checkIfMixtapeNotVoted()
    {
        boolean flag = false;
        if (!getActivity().getSharedPreferences("LiveMixTapes", 0).getString("votedMixtapes", "").contains(mixtape.get("id").toString()))
        {
            flag = true;
        }
        return flag;
    }

    void checkIfTimerOn()
    {
        console.log(new Object[] {
            "CHECKING TIMER"
        });
        if (globalTimer == null)
        {
            globalTimer = new Timer();
            globalTimer.schedule(new TimerTask() {

                final Mixtape this$0;

                public void run()
                {
                    if (!downloadProgressList.isEmpty()) goto _L2; else goto _L1
_L1:
                    cancel();
                    globalTimer = null;
_L4:
                    return;
_L2:
                    if (mScrollState != 0) goto _L4; else goto _L3
_L3:
                    Iterator iterator = downloadProgressList.keySet().iterator();
_L8:
                    if (!iterator.hasNext()) goto _L4; else goto _L5
_L5:
                    final String key;
                    int i;
                    key = (String)iterator.next();
                    i = ((Integer)listPosMap.get(key)).intValue();
                    if (i < tracks.getFirstVisiblePosition() || i > tracks.getLastVisiblePosition()) goto _L4; else goto _L6
_L6:
                    View view = tracks.getChildAt(i - tracks.getFirstVisiblePosition());
                    if (view == null) goto _L4; else goto _L7
_L7:
                    handler.post(view. new Runnable() {

                        final _cls26 this$1;
                        private final String val$key;
                        private final View val$v;

                        public void run()
                        {
                            int i = getIndividualFileProgress(key);
                            ((ProgressBar)v.findViewById(0x7f080138)).setProgress(i);
                            if (i == 100)
                            {
                                downloadProgressList.remove(key);
                                dbHelper.markDownloadComplete(key);
                                adapter.notifyDataSetChanged();
                            }
                        }

            
            {
                this$1 = final__pcls26;
                key = s;
                v = View.this;
                super();
            }
                    });
                      goto _L8
                }


            
            {
                this$0 = Mixtape.this;
                super();
            }
            }, 0L, 500L);
        }
    }

    void download(int i)
    {
        int j = i + tracks.getHeaderViewsCount();
        HashMap hashmap = (HashMap)((ArrayList)mixtape.get("tracks")).get(i);
        String s = ((String)hashmap.get("track_id")).toString();
        if (!Utils.isFileExists(mContext, s))
        {
            if (hashmap.get("download_url") == null || ((String)hashmap.get("download_url")).length() == 0)
            {
                (new android.app.AlertDialog.Builder(getActivity())).setTitle("Download Disabled").setMessage("This track cannot be downloaded.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                    final Mixtape this$0;

                    public void onClick(DialogInterface dialoginterface, int k)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$0 = Mixtape.this;
                super();
            }
                }).setIcon(0x1080027).show();
                return;
            }
            console.log(new Object[] {
                (new StringBuilder("INSERTING DOWNLOAD: ")).append(s).append(",").append((String)hashmap.get("track_title")).toString()
            });
            dbHelper.insertDownload(s, (String)hashmap.get("track_title"), mixtape.get("id").toString(), (String)mixtape.get("title"), mixtape.get("cover").toString(), (String)hashmap.get("track_duration"), 1);
            if (downloadProgressList.containsKey(s))
            {
                downloadManager.remove(new long[] {
                    ((Long)downloadProgressList.get(s)).longValue()
                });
                downloadProgressList.remove(s);
                listPosMap.remove(s);
                setProgressOnUiThreadWithPos(j, 0);
                changeImageButtonImage(j, true);
                dbHelper.deleteDownload(s);
                return;
            }
            if (hashmap.get("download_url") != null && ((String)hashmap.get("download_url")).length() != 0)
            {
                changeImageButtonImage(j, false);
                android.app.DownloadManager.Request request = new android.app.DownloadManager.Request(Uri.parse((String)hashmap.get("download_url")));
                request.setDescription((CharSequence)hashmap.get("track_title"));
                request.setTitle((CharSequence)hashmap.get("track_title"));
                if (android.os.Build.VERSION.SDK_INT >= 11)
                {
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(0);
                }
                request.setAllowedNetworkTypes(3);
                request.setDestinationUri(Uri.fromFile(Utils.getLivemixtapesFolder(getActivity(), (String)hashmap.get("track_id"))));
                long l = downloadManager.enqueue(request);
                downloadProgressList.put(s, Long.valueOf(l));
                listPosMap.put(s, Integer.valueOf(j));
                checkIfTimerOn();
                return;
            }
        }
    }

    void downloadAll()
    {
        ArrayList arraylist = (ArrayList)mixtape.get("tracks");
        if (arraylist != null)
        {
            int i = 0;
            while (i < arraylist.size()) 
            {
                download(i);
                i++;
            }
        }
    }

    public int getAbsoluteHeight(View view)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int i = view.getHeight();
        Log.v("height", Integer.toString(i));
        i += view.getPaddingTop() + view.getPaddingBottom();
        Log.v("height", Integer.toString(i));
        i += marginlayoutparams.topMargin + marginlayoutparams.bottomMargin;
        Log.v("height", Integer.toString(i));
        return i;
    }

    int getAllFilesDownloadPercentage()
    {
        Object obj = (ArrayList)mixtape.get("tracks");
        int j = ((ArrayList) (obj)).size();
        int i = 0;
        obj = ((ArrayList) (obj)).iterator();
        do
        {
            do
            {
                HashMap hashmap;
                if (!((Iterator) (obj)).hasNext())
                {
                    if (j > 0)
                    {
                        return (int)(((long)i * 100L) / (long)j);
                    } else
                    {
                        return 0;
                    }
                }
                hashmap = (HashMap)((Iterator) (obj)).next();
            } while (!Utils.isFileExists(mContext, ((String)hashmap.get("track_id")).toString()));
            i++;
        } while (true);
    }

    public MotionEvent getFakeTap(float f, float f1, int i)
    {
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100L, i, f, f1, 0);
    }

    int getIndividualFileProgress(String s)
    {
        int i = 0;
        Object obj;
        obj = new android.app.DownloadManager.Query();
        ((android.app.DownloadManager.Query) (obj)).setFilterById(new long[] {
            ((Long)downloadProgressList.get(s)).longValue()
        });
        obj = downloadManager.query(((android.app.DownloadManager.Query) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        if (!((Cursor) (obj)).moveToFirst())
        {
            return 0;
        }
        int j;
        i = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("bytes_so_far"));
        j = ((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("total_size"));
        if (((Cursor) (obj)).getInt(((Cursor) (obj)).getColumnIndex("status")) != 8)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        downloadProgressList.remove(s);
        listPosMap.remove(s);
        ((Cursor) (obj)).close();
        return 100;
        i = (int)(((long)i * 100L) / (long)j);
        ((Cursor) (obj)).close();
        return i;
        s;
        i = 100;
        return i;
    }

    public Uri getLocalUriFromBitmap(Bitmap bitmap)
    {
        try
        {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), (new StringBuilder("share_image_")).append(System.currentTimeMillis()).append(".png").toString());
            file.getParentFile().mkdirs();
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 90, fileoutputstream);
            fileoutputstream.close();
            bitmap = Uri.fromFile(file);
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
            return null;
        }
        return bitmap;
    }

    public Map getMixtape()
    {
        return mixtape;
    }

    public int getScrollY()
    {
        View view = tracks.getChildAt(0);
        if (view == null)
        {
            return 0;
        }
        int i = tracks.getFirstVisiblePosition() - tracks.getHeaderViewsCount();
        int j = view.getTop() * 2;
        int k = view.getHeight();
        Log.d("Nithin", (new StringBuilder(String.valueOf(i))).append("--").append(k).append("--").append(0).append("--").append(j).toString());
        console.log(new Object[] {
            (new StringBuilder("LAST VALUE: ")).append(lastValue).toString()
        });
        if (lastValue == 0)
        {
            lastValue = (-j + i * k) - 0;
        } else
        {
            int l = (-j + i * k) - 0;
            if (lastValue - l > 300 || lastValue - l < -300)
            {
                skipNoise = skipNoise + 1;
                if (skipNoise > 50)
                {
                    skipNoise = 0;
                    lastValue = l;
                } else
                {
                    return lastValue;
                }
            } else
            {
                lastValue = l;
            }
        }
        return (-j + i * k) - 0;
    }

    void hideProgressAndDownloadButtons(final int pos)
    {
        handler.post(new Runnable() {

            final Mixtape this$0;
            private final int val$pos;

            public void run()
            {
                View view;
                if (pos >= tracks.getFirstVisiblePosition())
                {
                    if ((view = tracks.getChildAt(pos - tracks.getFirstVisiblePosition())) != null)
                    {
                        ((ProgressBar)view.findViewById(0x7f080138)).setVisibility(4);
                        ((ImageButton)view.findViewById(0x7f0800df)).setVisibility(4);
                        return;
                    }
                }
            }

            
            {
                this$0 = Mixtape.this;
                pos = i;
                super();
            }
        });
    }

    void loadDjList(String s)
    {
        FragmentTransaction fragmenttransaction = ((BaseActivity)mContext).getAnimatedFragmentTransaction();
        MixtapeList mixtapelist = new MixtapeList();
        Bundle bundle = new Bundle();
        bundle.putString("title", s);
        bundle.putString("dj", s);
        mixtapelist.setArguments(bundle);
        fragmenttransaction.replace(0x7f0800cc, mixtapelist, "MIXTAPELIST").addToBackStack(null);
        fragmenttransaction.commit();
    }

    void markMixtape()
    {
        Object obj = getActivity().getSharedPreferences("LiveMixTapes", 0);
        String s = ((SharedPreferences) (obj)).getString("votedMixtapes", "");
        obj = ((SharedPreferences) (obj)).edit();
        if (s.length() == 0)
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("votedMixtapes", (new StringBuilder(String.valueOf(mixtape.get("id").toString()))).append(",").toString());
        } else
        {
            ((android.content.SharedPreferences.Editor) (obj)).putString("votedMixtapes", (new StringBuilder(String.valueOf(s))).append(mixtape.get("id").toString()).append(",").toString());
        }
        ((android.content.SharedPreferences.Editor) (obj)).commit();
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 7: default 72
    //                   2131230876: 103
    //                   2131230892: 83
    //                   2131230896: 88
    //                   2131230897: 98
    //                   2131230899: 93
    //                   2131230902: 73
    //                   2131230903: 78;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return;
_L7:
        togglePlaylistMode();
        return;
_L8:
        toggleFavorite();
        return;
_L3:
        likeMixtape();
        return;
_L4:
        dislikeMixtape();
        return;
_L6:
        downloadAll();
        return;
_L5:
        playAll();
        return;
_L2:
        if (selectedPlayListTracks.size() > 0)
        {
            shouldClearPlayListMode = false;
            view = getActivity().getFragmentManager().beginTransaction();
            SeeAllList seealllist = new SeeAllList();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 1);
            bundle.putBoolean("isAddTrackToPlaylist", true);
            bundle.putString("tracks", TextUtils.join(",", selectedPlayListTracks));
            seealllist.setArguments(bundle);
            view.replace(0x7f0800cc, seealllist, "SEEALL").addToBackStack(null);
            view.commit();
            return;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        console.log(new Object[] {
            "LOGGING MIXTAPE VIEW"
        });
        App app = (App)getActivity().getApplication();
        app.getDefaultTracker().setScreenName("Image~Mixtape");
        app.getDefaultTracker().send((new com.google.android.gms.analytics.HitBuilders.ScreenViewBuilder()).build());
        if (rootView != null) goto _L2; else goto _L1
_L1:
label0:
        {
            mContext = getActivity();
            Utility.hideKeyboard(getActivity());
            shouldClearPlayListMode = false;
            handler = new Handler();
            rootView = layoutinflater.inflate(0x7f030025, viewgroup, false);
            viewgroup = getArguments();
            layoutinflater = "Recent";
            if (viewgroup == null)
            {
                break label0;
            }
            mixtape = (Map)viewgroup.getSerializable("mixtapeData");
            viewgroup = viewgroup.getString("backScreenTitle");
            if (viewgroup != null)
            {
                layoutinflater = viewgroup;
                if (!viewgroup.equals(""))
                {
                    break label0;
                }
            }
            layoutinflater = "Recent";
        }
        setHasOptionsMenu(true);
        mainFrameLayout = (FrameLayout)rootView.findViewById(0x7f080098);
        mainFrameLayout.getForeground().setAlpha(0);
        layout = (ViewGroup)rootView.findViewById(0x7f08009b);
        header = rootView.findViewById(0x7f08009e);
        info = rootView.findViewById(0x7f0800a0);
        cover = (ImageView)rootView.findViewById(0x7f0800a1);
        tracks = (ListView)rootView.findViewById(0x7f08009d);
        mixtapeBtns = rootView.findViewById(0x7f0800aa);
        trackBtns = rootView.findViewById(0x7f0800b4);
        title = (TextView)rootView.findViewById(0x7f08004e);
        views = (TextView)rootView.findViewById(0x7f0800a9);
        date = (TextView)rootView.findViewById(0x7f080075);
        score = (TextView)rootView.findViewById(0x7f0800af);
        scorelabel = (TextView)rootView.findViewById(0x7f0800ae);
        comments = (ImageButton)rootView.findViewById(0x7f0800b8);
        playAll = (ImageButton)rootView.findViewById(0x7f0800b1);
        downloadAll = (ImageButton)rootView.findViewById(0x7f0800b3);
        favorite = (ImageButton)rootView.findViewById(0x7f0800b7);
        playlist = (ImageButton)rootView.findViewById(0x7f0800b6);
        like = (ImageButton)rootView.findViewById(0x7f0800ac);
        dislike = (ImageButton)rootView.findViewById(0x7f0800b0);
        downloadAllProgressBar = (ProgressBar)rootView.findViewById(0x7f0800b2);
        djBadges = (DjBadgesView)rootView.findViewById(0x7f0800a3);
        layoutBack = (LinearLayout)rootView.findViewById(0x7f08006d);
        textViewBack = (TextView)rootView.findViewById(0x7f08006f);
        buttonShare = (LinearLayout)rootView.findViewById(0x7f080099);
        textViewTitle = (TextView)rootView.findViewById(0x7f08006c);
        layoutBack.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtape this$0;

            public void onClick(View view)
            {
                getActivity().onBackPressed();
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        textViewBack.setText(layoutinflater);
        viewgroup = mixtape.get("artist").toString();
        layoutinflater = viewgroup;
        if (viewgroup.length() > 12)
        {
            layoutinflater = (new StringBuilder(String.valueOf(viewgroup.substring(0, 12)))).append("...").toString();
        }
        textViewTitle.setText(layoutinflater);
        buttonShare.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtape this$0;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.SEND");
                view.setType("text/plain");
                view.putExtra("android.intent.extra.SUBJECT", (String)mixtape.get("title"));
                view.putExtra("android.intent.extra.TEXT", (String)mixtape.get("sharetext"));
                startActivity(Intent.createChooser(view, "Share using"));
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        downloadManager = (DownloadManager)mContext.getSystemService("download");
        downloadAll.setOnClickListener(this);
        playAll.setOnClickListener(this);
        playlist.setOnClickListener(this);
        favorite.setOnClickListener(this);
        like.setOnClickListener(this);
        dislike.setOnClickListener(this);
        addTracksButton = (Button)rootView.findViewById(0x7f08009c);
        addTracksButton.setVisibility(8);
        addTracksButton.setOnClickListener(this);
        if (((ArrayList)mixtape.get("tracks")).size() <= 0) goto _L4; else goto _L3
_L3:
        layoutinflater = ((LayoutInflater)App.context.getSystemService("layout_inflater")).inflate(0x7f03001e, null, false);
        tracks.addFooterView(layoutinflater);
        ((TextView)layoutinflater.findViewById(0x7f080076)).setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtape this$0;

            public void onClick(View view)
            {
                if (App.isUnzipping)
                {
                    ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Downloading").setMessage("You already have a mixtape zip downloading...please wait for it to finish.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                                final _cls1 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            }).setIcon(0x1080027).show();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
                if (User.isGuest().booleanValue())
                {
                    showGuestWarning();
                    return;
                } else
                {
                    App.isUnzipping = true;
                    view = ((LayoutInflater)App.context.getSystemService("layout_inflater")).inflate(0x7f03001f, null, false);
                    Object obj = new android.app.AlertDialog.Builder(mContext);
                    ((android.app.AlertDialog.Builder) (obj)).setMessage("").setCancelable(false).setView(view);
                    obj = ((android.app.AlertDialog.Builder) (obj)).create();
                    downloadMixtapeZip(mixtape.get("id").toString(), view, ((AlertDialog) (obj)));
                    ((BaseActivity)mContext).runOnUiThread(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            (new android.app.AlertDialog.Builder(mContext)).setTitle("Mixtape Downloading").setMessage("The mixtape zip has started downloading in the background.  Please wait.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {

                                final _cls2 this$2;

                                public void onClick(DialogInterface dialoginterface, int i)
                                {
                                    dialoginterface.dismiss();
                                }

            
            {
                this$2 = _cls2.this;
                super();
            }
                            }).setIcon(0x1080027).show();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
            }


            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        if (!App.didLoad.booleanValue())
        {
            App.didLoad = Boolean.valueOf(true);
            MainActivity.firstLoad = true;
            console.log(new Object[] {
                (new StringBuilder("MIXTAPE DATA: ")).append(mixtape).toString()
            });
            NowPlayingActivity.mixtape = mixtape;
            NowPlayingActivity.playList = null;
            NowPlayingActivity.position = 0;
            NowPlayingActivity.tracksList = (ArrayList)mixtape.get("tracks");
            NowPlayingActivity.flag = 1;
            startActivity(new Intent(mContext, com/livemixtapes/NowPlayingActivity));
        }
_L6:
        comments.setOnClickListener(new android.view.View.OnClickListener() {

            final Mixtape this$0;

            public void onClick(View view)
            {
                showCommentPopup();
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        filler = getActivity().getLayoutInflater().inflate(0x7f030020, tracks, false);
        tracks.addHeaderView(filler, null, false);
        setData();
        App.scaleViewGroup(layout);
        new App.OnLayoutMeasureListener(layout) {

            final Mixtape this$0;

            public void onLayoutMeasure()
            {
                calcMeasurements();
            }

            
            {
                this$0 = Mixtape.this;
                super(viewgroup);
            }
        };
        tracks.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final Mixtape this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
                if (!measured.booleanValue())
                {
                    return;
                }
                j = getScrollY();
                if (j > 0)
                {
                    views.setVisibility(4);
                    if (release_seconds == 0L)
                    {
                        date.setVisibility(4);
                    }
                    mixtapeBtns.setVisibility(4);
                } else
                {
                    views.setVisibility(0);
                    if (release_seconds == 0L)
                    {
                        date.setVisibility(0);
                    }
                    mixtapeBtns.setVisibility(0);
                }
                i = j;
                if (j < 0)
                {
                    i = 0;
                }
                j = Math.max(maxCoverSize - (int)((double)i * 0.40000000000000002D), minCoverSize);
                i = Math.max(maxHeaderSize - (int)((double)i * 0.40000000000000002D), minHeaderSize);
                cover.getLayoutParams().width = j;
                cover.getLayoutParams().height = j;
                header.getLayoutParams().height = i;
                cover.requestLayout();
                header.requestLayout();
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
                mScrollState = i;
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        tracks.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final Mixtape this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                Log.v("mixtape", "track clicked");
                i -= tracks.getHeaderViewsCount();
                adapterview = (ArrayList)mixtape.get("tracks");
                if (!playlistMode.booleanValue())
                {
                    break MISSING_BLOCK_LABEL_161;
                }
                view = (String)((HashMap)adapterview.get(i)).get("track_id");
                if (!selectedPlayListTracks.contains(view)) goto _L2; else goto _L1
_L1:
                selectedPlayListTracks.remove(view);
                updatePlayListSelectionBackground(i, false);
_L3:
                App.showNotification((String)((HashMap)adapterview.get(i)).get("track_title"), cover);
                return;
_L2:
                try
                {
                    selectedPlayListTracks.add(view);
                    updatePlayListSelectionBackground(i, true);
                }
                // Misplaced declaration of an exception variable
                catch (AdapterView adapterview)
                {
                    adapterview.printStackTrace();
                    return;
                }
                  goto _L3
                NowPlayingActivity.mixtape = mixtape;
                NowPlayingActivity.position = i;
                NowPlayingActivity.flag = 1;
                MainActivity.isPlaying = true;
                NowPlayingActivity.initializeAndReload();
                MainActivity.nowplayingbutton.setImageResource(0x7f0200f8);
                shake(MainActivity.nowplayingbutton, null);
                  goto _L3
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
        header.setOnTouchListener(new android.view.View.OnTouchListener() {

            final Mixtape this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = Mixtape.this;
                super();
            }
        });
_L2:
        if (bundle == null)
        {
            final int action = getArguments().getInt("init_action", 0);
            (new Handler()).postDelayed(new Runnable() {

                final Mixtape this$0;
                private final int val$action;

                public void run()
                {
                    if (action == 1)
                    {
                        playAll();
                    } else
                    if (action == 2)
                    {
                        downloadAll();
                        return;
                    }
                }

            
            {
                this$0 = Mixtape.this;
                action = i;
                super();
            }
            }, 1L);
        }
        return rootView;
_L4:
        playAll.setVisibility(8);
        downloadAll.setVisibility(8);
        downloadAllProgressBar.setVisibility(8);
        like.setVisibility(8);
        dislike.setVisibility(8);
        date.setVisibility(4);
        score.setVisibility(8);
        scorelabel.setVisibility(8);
        try
        {
            release_seconds = Long.parseLong(String.valueOf(mixtape.get("releaseseconds")));
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            release_seconds = 0L;
        }
        console.log(new Object[] {
            (new StringBuilder("RELEASE SECONDS: ")).append(release_seconds).toString()
        });
        layoutinflater = (LinearLayout)rootView.findViewById(0x7f0800a4);
        if (release_seconds > 0L)
        {
            layoutinflater.setVisibility(0);
            (new CountDownTimer(release_seconds * 1000L, 1000L) {

                final Mixtape this$0;

                public void onFinish()
                {
                }

                public void onTick(long l)
                {
                    Mixtape.tempDay = l / 0x5265c00L;
                    Mixtape.tempHour = l / 0x36ee80L - Mixtape.tempDay * 24L;
                    Mixtape.tempMinute = l / 60000L - Mixtape.tempHour * 60L - Mixtape.tempDay * 24L * 60L;
                    Mixtape.tempSecond = l / 1000L - Mixtape.tempMinute * 60L - Mixtape.tempHour * 60L * 60L - Mixtape.tempDay * 24L * 60L * 60L;
                    Log.v("COUNTER", (new StringBuilder("DAYS: ")).append(Long.toString(Mixtape.tempDay)).toString());
                    Log.v("COUNTER", (new StringBuilder("HOURS: ")).append(Long.toString(Mixtape.tempHour)).toString());
                    Log.v("COUNTER", (new StringBuilder("MINUTES: ")).append(Long.toString(Mixtape.tempMinute)).toString());
                    Log.v("COUNTER", (new StringBuilder("SECONDS: ")).append(Long.toString(Mixtape.tempSecond)).toString());
                    if (Mixtape.tempDay != Mixtape.dayValue)
                    {
                        countText = (TextView)rootView.findViewById(0x7f0800a5);
                        countText.setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.tempDay)))).toString());
                        Mixtape.dayValue = Mixtape.tempDay;
                    }
                    if (Mixtape.tempHour != Mixtape.hourValue)
                    {
                        countText = (TextView)rootView.findViewById(0x7f0800a6);
                        countText.setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.tempHour)))).toString());
                        Mixtape.hourValue = Mixtape.tempHour;
                    }
                    if (Mixtape.tempMinute != Mixtape.minuteValue)
                    {
                        countText = (TextView)rootView.findViewById(0x7f0800a7);
                        countText.setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.tempMinute)))).toString());
                        Mixtape.minuteValue = Mixtape.tempMinute;
                    }
                    if (Mixtape.tempSecond != Mixtape.secondValue)
                    {
                        countText = (TextView)rootView.findViewById(0x7f0800a8);
                        countText.setText((new StringBuilder(String.valueOf(Long.toString(Mixtape.tempSecond)))).toString());
                        Mixtape.secondValue = Mixtape.tempSecond;
                    }
                }

            
            {
                this$0 = Mixtape.this;
                super(l, l1);
            }
            }).start();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onResume()
    {
        super.onResume();
        if (shouldClearPlayListMode && playlistMode.booleanValue())
        {
            shouldClearPlayListMode = false;
            exitPlaylistMode();
        }
    }

    public void onStart()
    {
        super.onStart();
        getMixtapeInfo();
    }

    void playAll()
    {
        NowPlayingActivity.tracksList = (ArrayList)mixtape.get("tracks");
        NowPlayingActivity.mixtape = mixtape;
        NowPlayingActivity.position = 0;
        NowPlayingActivity.flag = 1;
        MainActivity.isPlaying = true;
        MainActivity.nowplayingbutton.setImageResource(0x7f0200f8);
        shake(MainActivity.nowplayingbutton, null);
        NowPlayingActivity.initializeAndReload();
    }

    public void setData()
    {
        dbHelper = DBHelper.sharedInstance(mContext);
        id = Integer.valueOf(mixtape.get("id").toString()).intValue();
        djBadges.setOnDjClickListener(djClickListener);
        djBadges.loadDjs(mixtape.get("DJ").toString().split(","), false);
        title.setText((String)mixtape.get("title"));
        views.setText(Html.fromHtml((new StringBuilder("Mixtape Views: <b>")).append(Utils.formatWithCommas((String)mixtape.get("views"))).append("</b>").toString()));
        java.util.Date date1 = Utility.parseApiDate((String)mixtape.get("releasedate"));
        date.setText(Html.fromHtml((new StringBuilder("Uploaded: <b>")).append(Utility.formatDateShort(date1)).append("</b>").toString()));
        score.setText(Utils.formatWithCommas((String)mixtape.get("score")));
        favorited = Boolean.valueOf(false);
        voted = Boolean.valueOf(false);
        voting = Boolean.valueOf(false);
        if (User.isGuest().booleanValue())
        {
            disableVoteButtons();
        } else
        {
            favorited = Boolean.valueOf(User.getData().favoriteMixtapeIds.contains(Integer.valueOf(id)));
            if (checkIfMixtapeNotVoted())
            {
                enableVoteButtons();
            } else
            {
                disableVoteButtons();
            }
        }
        if (favorited.booleanValue())
        {
            favorite.setImageResource(0x7f0200ff);
        } else
        {
            favorite.setImageResource(0x7f0200eb);
        }
        (new ImageLoader(mContext)).DisplayImage((String)mixtape.get("cover"), cover);
        adapter = new LazyAdapterTracks(this, (ArrayList)mixtape.get("tracks"));
        tracks.setAdapter(adapter);
        downloadAllProgressBar.setProgress(0);
        Log.v("mixtape", "setData");
    }

    void setProgressOnUiThreadWithPos(final int pos, final int progress)
    {
        handler.post(new Runnable() {

            final Mixtape this$0;
            private final int val$pos;
            private final int val$progress;

            public void run()
            {
                View view;
                if (pos >= tracks.getFirstVisiblePosition())
                {
                    if ((view = tracks.getChildAt(pos - tracks.getFirstVisiblePosition())) != null)
                    {
                        ((ProgressBar)view.findViewById(0x7f080138)).setProgress(progress);
                        return;
                    }
                }
            }

            
            {
                this$0 = Mixtape.this;
                pos = i;
                progress = j;
                super();
            }
        });
    }

    void shareSocialNetworks(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        if (s.equals("com.instagram.android"))
        {
            intent.setType("image/*");
        }
        intent.putExtra("android.intent.extra.TEXT", (String)mixtape.get("sharetext"));
        intent.putExtra("android.intent.extra.STREAM", getLocalUriFromBitmap((new ImageLoader(mContext)).getBitmap((String)mixtape.get("cover"))));
        Iterator iterator = getActivity().getPackageManager().queryIntentActivities(intent, 0).iterator();
        ResolveInfo resolveinfo;
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            resolveinfo = (ResolveInfo)iterator.next();
        } while (!resolveinfo.activityInfo.packageName.equals(s));
        s = resolveinfo.activityInfo;
        s = new ComponentName(((ActivityInfo) (s)).applicationInfo.packageName, ((ActivityInfo) (s)).name);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setFlags(0x10200000);
        intent.setComponent(s);
        startActivity(intent);
    }

    public void showCommentPopup()
    {
        (new CommentsPopup(getActivity(), mContext, mixtape)).showPopup(mainFrameLayout, comments);
    }

    void updatePlayListSelectionBackground(final int pos, final boolean isSelected)
    {
        handler.post(new Runnable() {

            final Mixtape this$0;
            private final boolean val$isSelected;
            private final int val$pos;

            public void run()
            {
                View view;
                if (pos >= 0)
                {
                    if ((view = tracks.getChildAt((pos + tracks.getHeaderViewsCount()) - tracks.getFirstVisiblePosition())) != null)
                    {
                        view = view.findViewById(0x7f080134);
                        if (isSelected)
                        {
                            view.setBackgroundColor(Color.parseColor("#000080"));
                        } else
                        {
                            view.setBackgroundResource(0x7f020062);
                        }
                        if (selectedPlayListTracks.size() > 0)
                        {
                            addTracksButton.setText((new StringBuilder("Add ")).append(selectedPlayListTracks.size()).append(" Track(s)").toString());
                            return;
                        } else
                        {
                            addTracksButton.setText("Tap the tracks you want to add");
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = Mixtape.this;
                pos = i;
                isSelected = flag;
                super();
            }
        });
    }












































}
