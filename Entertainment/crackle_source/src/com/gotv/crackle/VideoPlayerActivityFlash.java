// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.gotv.crackle.adapters.SubtitleListAdapter;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaUrlItem;
import com.gotv.crackle.util.Log;
import com.gotv.crackle.util.OmnitureWrapper;
import com.sessionm.api.SessionM;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package com.gotv.crackle:
//            Application, VideoPlayerActivity, TwitterWebActivity

public class VideoPlayerActivityFlash extends BaseActivity
{
    private class ClickHandlerInterface
    {

        final VideoPlayerActivityFlash this$0;

        public void captionClick(String s)
        {
            Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("CaptionClicked: ").append(s).toString());
            showDialog(6);
        }

        public void flexToJavascript(String s)
        {
            Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("VideoPlayer ").append(s).toString());
            if (!s.equalsIgnoreCase("ShareThis")) goto _L2; else goto _L1
_L1:
            SessionM.getInstance().presentActivity(com.sessionm.api.SessionM.ActivityType.ACHIEVEMENT);
            runOnUiThread(new Runnable() {

                final ClickHandlerInterface this$1;

                public void run()
                {
                    showDialog(4);
                }

            
            {
                this$1 = ClickHandlerInterface.this;
                super();
            }
            });
_L4:
            return;
_L2:
            if (!s.equalsIgnoreCase("AddToQueue"))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((ConnectivityManager)getSystemService("connectivity")).getActiveNetworkInfo() == null) goto _L4; else goto _L3
_L3:
            s = CrackleAccountManager.getUserID();
            if (s != null)
            {
                MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
                Application.getInstance().getOmnitureTracker().onVideoQueue(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration());
                s = new QueueManager(VideoPlayerActivityFlash.this, s);
                SessionM.getInstance().logAction("addToMyQueue");
                s.addMediaToWatchlist(mMediaID);
                return;
            } else
            {
                showDialogFragment(0xa7b54);
                return;
            }
            if (!s.equalsIgnoreCase("BuyOnAmazon") || mAmazonLink == null || mAmazonLink.isEmpty() || mAmazonLink.equalsIgnoreCase("null")) goto _L4; else goto _L5
_L5:
            s = mMediaDetailsRequest.getItem();
            Application.getInstance().getOmnitureTracker().onVideoBuy(s.getID(), s.getTitle(), s.getTitle(), s.getRootChannelID(), s.getMediaType(), s.getSeason(), s.getEpisode(), "Flash", mSubTitleSelected, s.getDuration());
            s = new Intent("android.intent.action.VIEW", Uri.parse(mAmazonLink));
            startActivity(s);
            return;
        }

        public void moviePlayer75PercentJavascript()
        {
            MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideo75Percent(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
        }

        public void onAdStart()
        {
            MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
            mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onAdStart(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds, 0, 0, "");
        }

        public void onbeforeunload(String s)
        {
            int i = (int)Math.round(Double.parseDouble(s));
            if (i > 0 && i <= mDurationInSeconds)
            {
                SharedPrefsManager.setPlayProgressForItem(mMediaID, mThumbnailUrl, Integer.valueOf(i));
            }
        }

        public void subtitlesLoaded(String s)
        {
            Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("VideoPlayerActivityFlash:").append(s).toString());
        }

        public void updatePlayerPosition(String s)
        {
            Log.d("VideoPlayerActivityFlash", (new StringBuilder()).append("updatePlayerPosition: ").append(s).toString());
            if ((int)Math.round(Double.parseDouble(s)) > 0 && !mPlayingStarted)
            {
                mPlayingStarted = true;
                mWebView.loadUrl((new StringBuilder()).append("javascript:loadSubtitles('").append(mCurrentSubtitleUrl).append("')").toString());
            }
            int i = ((ConnectivityManager) (this)).getActiveNetworkInfo;
        }

        public void videoPlayerEndJavascript()
        {
            SharedPrefsManager.clearPlayProgressForItem(mMediaID);
            MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
            Application.getInstance().getOmnitureTracker().onVideoComplete(mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
            finish();
        }

        private ClickHandlerInterface()
        {
            this$0 = VideoPlayerActivityFlash.this;
            super();
        }

    }


    public static final int NETWORK_DIALOG_CANT_PLAY = 5;
    private static final int RESUME_DIALOG = 1;
    public static final int SHARE_DIALOG = 4;
    public static final int SUBTITLE_DIALOG = 6;
    public static final String URL_PLAYER = "http://images2.crackle.com/profiles/android2/hdpfw.html?assetId=%asset%&width=%wid%&height=%height%&startingIndex=%index%&resumeTime=%time%&maximumBitrateAllowed=%bitrate%&connectionSpeed=%adBitRate%&fwSiteId=%ssid%&mediaSrc=%sfile%&showPurchase=%showpurch%&showCaptionButton=%showcap%&lang=%lang%&verCode=3";
    private String mAmazonLink;
    private String mCurrentSubtitleUrl;
    private int mDurationInSeconds;
    private int mLastOmnitureReportTimeInSeconds;
    private MediaDetailsRequest mMediaDetailsRequest;
    private String mMediaDimensions;
    private String mMediaID;
    private String mMediaUri;
    private boolean mPlayingStarted;
    private Boolean mResume;
    private boolean mShouldShowCaptionButton;
    private int mStartPosition;
    private String mSubTitleSelected;
    private android.widget.AdapterView.OnItemClickListener mSubtitleItemClickListener;
    private String mThumbnailUrl;
    private int mTimePlayingCounter;
    private int mVideoHeight;
    private int mVideoWidth;
    private WebView mWebView;
    private android.view.View.OnClickListener shareItemClickListener;
    private android.os.PowerManager.WakeLock wakeLock;

    public VideoPlayerActivityFlash()
    {
        wakeLock = null;
        mSubTitleSelected = null;
        mStartPosition = 0;
        mPlayingStarted = false;
        shareItemClickListener = new android.view.View.OnClickListener() {

            final VideoPlayerActivityFlash this$0;

            public void onClick(View view)
            {
                MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
                if (view.getId() == 0x7f0a0169)
                {
                    removeDialog(4);
                    postToFacebook(false, mMediaDetailsRequest.getItem());
                    Application.getInstance().getOmnitureTracker().onVideoShare("Facebook", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration());
                } else
                {
                    if (view.getId() == 0x7f0a016a)
                    {
                        removeDialog(4);
                        view = new Intent(VideoPlayerActivityFlash.this, com/gotv/crackle/TwitterWebActivity);
                        view.putExtra("share_link", mMediaDetailsRequest.getItem().getPermaLink());
                        view.putExtra("share_title", mMediaDetailsRequest.getItem().getTitle());
                        startActivity(view);
                        Application.getInstance().getOmnitureTracker().onVideoShare("Twitter", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration());
                        return;
                    }
                    if (view.getId() == 0x7f0a0165)
                    {
                        try
                        {
                            shareMailClicked(mMediaDetailsRequest.getItem());
                        }
                        // Misplaced declaration of an exception variable
                        catch (View view)
                        {
                            view.printStackTrace();
                        }
                        removeDialog(4);
                        Application.getInstance().getOmnitureTracker().onVideoShare("Email", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration());
                        return;
                    }
                    if (view.getId() == 0x7f0a0167)
                    {
                        removeDialog(4);
                        Application.getInstance().getOmnitureTracker().onVideoShare("SMS", mediadetailsitem.getID(), mediadetailsitem.getTitle(), mediadetailsitem.getTitle(), mediadetailsitem.getRootChannelID(), mediadetailsitem.getMediaType(), mediadetailsitem.getSeason(), mediadetailsitem.getEpisode(), "Flash", mSubTitleSelected, mediadetailsitem.getDuration());
                        shareSMSClicked(mediadetailsitem);
                        return;
                    }
                }
            }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
        };
        mSubtitleItemClickListener = new android.widget.AdapterView.OnItemClickListener() {

            final VideoPlayerActivityFlash this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                removeDialog(6);
                if (getString(0x7f0b00d5).compareTo((String)view.getTag()) == 0)
                {
                    mCurrentSubtitleUrl = null;
                    mSubTitleSelected = null;
                    mWebView.loadUrl("javascript:hideSubtitles()");
                    return;
                } else
                {
                    mCurrentSubtitleUrl = (String)mMediaDetailsRequest.getItem().getClosedCaptionFileUrls().get(view.getTag());
                    mSubTitleSelected = (String)view.getTag();
                    mWebView.loadUrl((new StringBuilder()).append("javascript:loadSubtitles('").append(mCurrentSubtitleUrl).append("')").toString());
                    return;
                }
            }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
        };
    }

    private void callHiddenWebViewMethod(String s)
    {
        if (mWebView == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        android/webkit/WebView.getMethod(s, new Class[0]).invoke(mWebView, new Object[0]);
        return;
        Object obj;
        obj;
        Log.e("WebView", (new StringBuilder()).append("No such method: ").append(s).append(obj).toString());
        ((NoSuchMethodException) (obj)).printStackTrace();
        return;
        obj;
        Log.e("WebView", (new StringBuilder()).append("Illegal Access: ").append(s).append(obj).toString());
        return;
        obj;
        Log.e("WebView", (new StringBuilder()).append("Invocation Target Exception: ").append(s).append(obj).toString());
        return;
    }

    private void startPlayBack()
    {
        if (mMediaUri != null)
        {
            Object obj = mMediaDetailsRequest.getItem();
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setAllowFileAccess(true);
            mWebView.getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON);
            mWebView.clearCache(true);
            mWebView.clearHistory();
            mWebView.addJavascriptInterface(new ClickHandlerInterface(), "ClickHandlerInterface");
            String s = "http://images2.crackle.com/profiles/android2/hdpfw.html?assetId=%asset%&width=%wid%&height=%height%&startingIndex=%index%&resumeTime=%time%&maximumBitrateAllowed=%bitrate%&connectionSpeed=%adBitRate%&fwSiteId=%ssid%&mediaSrc=%sfile%&showPurchase=%showpurch%&showCaptionButton=%showcap%&lang=%lang%&verCode=3".replaceFirst("%asset%", mMediaID).replaceFirst("%index%", "2").replaceFirst("%bitrate%", "600").replaceFirst("%adBitRate%", "800").replaceFirst("%sfile%", mMediaUri).replaceFirst("%ssid%", "crackle_android_handset_app_movies").replaceFirst("%wid%", String.valueOf(mVideoWidth - 1)).replaceFirst("%height%", String.valueOf(mVideoHeight - 1));
            if (mStartPosition == 0)
            {
                mLastOmnitureReportTimeInSeconds = Application.getInstance().getOmnitureTracker().onVideoStart(((MediaDetailsItem) (obj)).getID(), ((MediaDetailsItem) (obj)).getTitle(), ((MediaDetailsItem) (obj)).getTitle(), ((MediaDetailsItem) (obj)).getRootChannelID(), ((MediaDetailsItem) (obj)).getMediaType(), ((MediaDetailsItem) (obj)).getSeason(), ((MediaDetailsItem) (obj)).getEpisode(), "Flash", mSubTitleSelected, ((MediaDetailsItem) (obj)).getDuration(), mTimePlayingCounter, mLastOmnitureReportTimeInSeconds);
            }
            s = s.replaceFirst("%time%", (new StringBuilder()).append(mStartPosition).append(".0").toString());
            obj = s;
            if (Application.getInstance().getLocalization().allRequestsComplete())
            {
                if (Application.getInstance().getLocalization().isLatinAmericaUI())
                {
                    obj = s.replaceFirst("%showpurch%", "false");
                } else
                {
                    obj = s.replaceFirst("%showpurch%", "true");
                }
            }
            if (mShouldShowCaptionButton)
            {
                obj = ((String) (obj)).replaceFirst("%showcap%", "true");
            } else
            {
                obj = ((String) (obj)).replaceFirst("%showcap%", "false");
            }
            obj = ((String) (obj)).replaceFirst("%lang%", getString(0x7f0b00dc));
            mWebView.setWebViewClient(new WebViewClient() {

                final VideoPlayerActivityFlash this$0;

                public void onPageFinished(WebView webview, String s1)
                {
                    (new Handler()).postDelayed(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            if (mWebView != null)
                            {
                                mWebView.loadUrl("javascript:reportPlayheadTime()");
                            }
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    }, 10000L);
                    super.onPageFinished(webview, s1);
                }

                public boolean shouldOverrideUrlLoading(WebView webview, String s1)
                {
                    webview = new Intent("android.intent.action.VIEW");
                    webview.setData(Uri.parse(s1));
                    startActivity(webview);
                    return true;
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            });
            mWebView.loadUrl(((String) (obj)));
        }
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        bundle = getWindow().getAttributes();
        bundle.flags = 1024;
        getWindow().setAttributes(bundle);
        setContentView(0x7f03007d);
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            setRequestedOrientation(6);
        }
        bundle = getIntent();
        mMediaID = bundle.getStringExtra("MEDIA_ID");
        bundle = bundle.getStringExtra("RESUME_EXTRA");
        if (bundle != null)
        {
            mResume = Boolean.valueOf(Boolean.parseBoolean(bundle));
        }
        mWebView = (WebView)findViewById(0x7f0a01a5);
        mMediaDetailsRequest = new MediaDetailsRequest(this, mMediaID);
        if (SharedPrefsManager.getWifiOnlyEnabled())
        {
            bundle = new IntentFilter();
            bundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            registerReceiver(new BroadcastReceiver() {

                final VideoPlayerActivityFlash this$0;

                public void onReceive(Context context, Intent intent)
                {
                    if (!((ConnectivityManager)getSystemService("connectivity")).getNetworkInfo(1).isConnected() && SharedPrefsManager.getWifiOnlyEnabled())
                    {
                        showDialogFragment(0xcb51c);
                    }
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            }, bundle);
        }
    }

    protected Dialog onCreateDialog(int i)
    {
        Dialog dialog1;
        View view;
        View view1;
        View view2;
        View view3;
        View view4;
        switch (i)
        {
        case 2: // '\002'
        case 3: // '\003'
        default:
            return super.onCreateDialog(i);

        case 5: // '\005'
            return (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00a4)).setNegativeButton(getResources().getString(0x7f0b00b2), new android.content.DialogInterface.OnClickListener() {

                final VideoPlayerActivityFlash this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    showDialogFragment(0x5a39fc);
                    finish();
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            }).create();

        case 6: // '\006'
            Dialog dialog = new Dialog(this);
            ((TextView)dialog.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
            dialog.setTitle(0x7f0b00af);
            dialog.setCanceledOnTouchOutside(true);
            ListView listview = (ListView)((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03001d, null, false);
            listview.setOnItemClickListener(mSubtitleItemClickListener);
            listview.setAdapter(new SubtitleListAdapter(this, new ArrayList(mMediaDetailsRequest.getItem().getClosedCaptionFiles().keySet()), mSubTitleSelected));
            dialog.setContentView(listview);
            return dialog;

        case 1: // '\001'
            return (new android.app.AlertDialog.Builder(this)).setIcon(0x1080027).setMessage(getResources().getString(0x7f0b00ba)).setNegativeButton(getResources().getString(0x7f0b00bb), new android.content.DialogInterface.OnClickListener() {

                final VideoPlayerActivityFlash this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    removeDialog(1);
                    mStartPosition = SharedPrefsManager.getPlayProgressForItem(mMediaID);
                    startPlayBack();
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            }).setPositiveButton(getResources().getString(0x7f0b00bc), new android.content.DialogInterface.OnClickListener() {

                final VideoPlayerActivityFlash this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    removeDialog(1);
                    mMediaDetailsRequest.getItem();
                    startPlayBack();
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            }).create();

        case 4: // '\004'
            dialog1 = new Dialog(this);
            ((TextView)dialog1.findViewById(0x1020016)).setTypeface(Application.getInstance().getTypeFace());
            dialog1.setTitle(0x7f0b00af);
            dialog1.setCanceledOnTouchOutside(true);
            view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f03006b, null, false);
            view1 = view.findViewById(0x7f0a0169);
            view2 = view.findViewById(0x7f0a016a);
            view3 = view.findViewById(0x7f0a0165);
            view4 = view.findViewById(0x7f0a0167);
            break;
        }
        if (Application.isNookTablet() || Application.getInstance().isTabletSizedScreen())
        {
            view4.setVisibility(8);
            view.findViewById(0x7f0a0168);
        }
        view1.setOnClickListener(shareItemClickListener);
        view2.setOnClickListener(shareItemClickListener);
        view3.setOnClickListener(shareItemClickListener);
        view4.setOnClickListener(shareItemClickListener);
        dialog1.setContentView(view);
        return dialog1;
    }

    public void onDataFailed(String s, String s1)
    {
        if (s.compareTo("MediaDetails") == 0)
        {
            runOnUiThread(new Runnable() {

                final VideoPlayerActivityFlash this$0;

                public void run()
                {
                    showDialog(5);
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            });
            return;
        } else
        {
            super.onDataFailed(s, s1);
            return;
        }
    }

    public void onDataSuccess(String s)
    {
        if (s.compareTo("MediaDetails") == 0)
        {
            runOnUiThread(new Runnable() {

                final VideoPlayerActivityFlash this$0;

                public void run()
                {
                    MediaDetailsItem mediadetailsitem = mMediaDetailsRequest.getItem();
                    float f;
                    String s1;
                    String s2;
                    int i;
                    int j;
                    if (mediadetailsitem.getRootChannelID().compareTo("82") == 0)
                    {
                        BaseActivity.mJustPlayedMovie = true;
                    } else
                    {
                        BaseActivity.mJustPlayedShow = true;
                    }
                    if (mediadetailsitem.getClosedCaptionFiles().size() > 0)
                    {
                        mShouldShowCaptionButton = true;
                        if (mediadetailsitem.getDefaultLang() != null)
                        {
                            mSubTitleSelected = mediadetailsitem.getDefaultLang();
                            mCurrentSubtitleUrl = (String)mMediaDetailsRequest.getItem().getClosedCaptionFileUrls().get(mediadetailsitem.getDefaultLang());
                        }
                    }
                    mMediaDimensions = mediadetailsitem.getDimensions();
                    s1 = mMediaDimensions.substring(0, mMediaDimensions.indexOf("x"));
                    s2 = mMediaDimensions.substring(mMediaDimensions.indexOf("x") + 1, mMediaDimensions.length());
                    j = getWindow().getWindowManager().getDefaultDisplay().getWidth();
                    i = getWindow().getWindowManager().getDefaultDisplay().getHeight();
                    f = getResources().getDisplayMetrics().density;
                    j = (new Float((float)j / f)).intValue();
                    i = (new Float((float)i / f)).intValue();
                    f = Float.parseFloat(s2) / Float.parseFloat(s1);
                    mVideoHeight = (new Float((float)j * f)).intValue();
                    mVideoWidth = j;
                    if (mVideoHeight > i)
                    {
                        mVideoHeight = i;
                        float f1 = Float.parseFloat(s1) / Float.parseFloat(s2);
                        mVideoWidth = (new Float((float)i * f1)).intValue();
                    }
                    mThumbnailUrl = mediadetailsitem.getThumbnailOneSheet185x277();
                    try
                    {
                        mDurationInSeconds = Integer.parseInt(mediadetailsitem.getDurationInSeconds());
                    }
                    catch (Exception exception) { }
                    mAmazonLink = mediadetailsitem.getAmazonLink();
                    mMediaDimensions = mediadetailsitem.getDimensions();
                    mMediaUri = ((MediaUrlItem)mMediaDetailsRequest.getItem().getMediaUrls().get("H264_Android.smil")).path;
                    if (SharedPrefsManager.getPlayProgressForItem(mMediaID) > 0)
                    {
                        if (mResume == null)
                        {
                            showDialog(1);
                            return;
                        }
                        if (mResume.booleanValue())
                        {
                            mStartPosition = SharedPrefsManager.getPlayProgressForItem(mMediaID);
                            startPlayBack();
                            return;
                        } else
                        {
                            startPlayBack();
                            return;
                        }
                    } else
                    {
                        startPlayBack();
                        return;
                    }
                }

            
            {
                this$0 = VideoPlayerActivityFlash.this;
                super();
            }
            });
            return;
        } else
        {
            super.onDataSuccess(s);
            return;
        }
    }

    protected void onDestroy()
    {
        if (mWebView != null)
        {
            mWebView.stopLoading();
            mWebView.addJavascriptInterface(null, "ClickHandlerInterface");
            mWebView.clearCache(true);
            mWebView.clearView();
            mWebView.freeMemory();
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
        System.gc();
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i != 4) goto _L2; else goto _L1
_L1:
        if (mWebView != null)
        {
            mWebView.loadUrl("javascript:onbeforeunload()");
        }
        finish();
_L4:
        return super.onKeyDown(i, keyevent);
_L2:
        if (mWebView != null)
        {
            mWebView.loadUrl("javascript:onbeforeunload()");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        releaseWakeMode(this);
        callHiddenWebViewMethod("onPause");
    }

    protected void onResume()
    {
        requestWakeMode();
        super.onResume();
    }

    protected void onStop()
    {
        releaseWakeMode(this);
        super.onStop();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        if (flag)
        {
            callHiddenWebViewMethod("onResume");
            if (mWebView != null)
            {
                mWebView.resumeTimers();
            }
        }
    }

    protected void performMenuAction(int i)
    {
    }

    public void releaseWakeMode(Context context)
    {
        if (wakeLock != null)
        {
            if (wakeLock.isHeld())
            {
                wakeLock.release();
            }
            wakeLock = null;
        }
    }

    public void requestWakeMode()
    {
        if (wakeLock == null)
        {
            wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(0x2000000a, com/gotv/crackle/VideoPlayerActivity.getName());
            wakeLock.setReferenceCounted(false);
            wakeLock.acquire();
        }
    }




/*
    static int access$1008(VideoPlayerActivityFlash videoplayeractivityflash)
    {
        int i = videoplayeractivityflash.mTimePlayingCounter;
        videoplayeractivityflash.mTimePlayingCounter = i + 1;
        return i;
    }

*/



/*
    static int access$1102(VideoPlayerActivityFlash videoplayeractivityflash, int i)
    {
        videoplayeractivityflash.mLastOmnitureReportTimeInSeconds = i;
        return i;
    }

*/



/*
    static int access$1202(VideoPlayerActivityFlash videoplayeractivityflash, int i)
    {
        videoplayeractivityflash.mDurationInSeconds = i;
        return i;
    }

*/



/*
    static String access$1302(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mThumbnailUrl = s;
        return s;
    }

*/


/*
    static boolean access$1402(VideoPlayerActivityFlash videoplayeractivityflash, boolean flag)
    {
        videoplayeractivityflash.mShouldShowCaptionButton = flag;
        return flag;
    }

*/



/*
    static String access$1502(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mMediaDimensions = s;
        return s;
    }

*/



/*
    static int access$1602(VideoPlayerActivityFlash videoplayeractivityflash, int i)
    {
        videoplayeractivityflash.mVideoHeight = i;
        return i;
    }

*/


/*
    static int access$1702(VideoPlayerActivityFlash videoplayeractivityflash, int i)
    {
        videoplayeractivityflash.mVideoWidth = i;
        return i;
    }

*/


/*
    static String access$1802(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mMediaUri = s;
        return s;
    }

*/





/*
    static String access$302(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mSubTitleSelected = s;
        return s;
    }

*/



/*
    static String access$402(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mCurrentSubtitleUrl = s;
        return s;
    }

*/



/*
    static int access$602(VideoPlayerActivityFlash videoplayeractivityflash, int i)
    {
        videoplayeractivityflash.mStartPosition = i;
        return i;
    }

*/




/*
    static String access$802(VideoPlayerActivityFlash videoplayeractivityflash, String s)
    {
        videoplayeractivityflash.mAmazonLink = s;
        return s;
    }

*/



/*
    static boolean access$902(VideoPlayerActivityFlash videoplayeractivityflash, boolean flag)
    {
        videoplayeractivityflash.mPlayingStarted = flag;
        return flag;
    }

*/
}
