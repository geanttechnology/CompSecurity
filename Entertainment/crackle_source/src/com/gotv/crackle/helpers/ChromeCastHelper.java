// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Menu;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.common.images.WebImage;
import com.google.sample.castcompanionlibrary.cast.VideoCastManager;
import com.google.sample.castcompanionlibrary.cast.callbacks.VideoCastConsumerImpl;
import com.gotv.crackle.Application;
import com.gotv.crackle.ChromeCastingDetailsActivity;
import com.gotv.crackle.DetailsActivityResolver;
import com.gotv.crackle.VideoPlayerActivity;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.model.MediaUrlItem;
import com.gotv.crackle.util.OmnitureWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.gotv.crackle.helpers:
//            SharedPrefsManager

public class ChromeCastHelper
{

    private static final String MESSAGE_NAMESPACE = "urn:x-cast:com.gotv.crackle.messages";
    private static final String TAG = com/gotv/crackle/helpers/ChromeCastHelper.getSimpleName();
    public static final double VOLUME_INCREMENT = 0.050000000000000003D;
    private static ChromeCastHelper sInstance = null;
    private CrackleAccountManager mAccountManager;
    private VideoCastManager mCastMgr;
    private Context mContext;
    private MediaDetailsItem mMediaDetails;
    private MediaDetailsItem mPendingMediaDetails;
    private boolean mPendingResume;
    private String mSelectedSubtitles;

    private ChromeCastHelper(Context context)
    {
        mCastMgr = null;
        mContext = context;
        mAccountManager = new CrackleAccountManager();
        mCastMgr = VideoCastManager.initialize(context, getReceiverApplicationId(), com/gotv/crackle/DetailsActivityResolver, "urn:x-cast:com.gotv.crackle.messages");
        mCastMgr.enableFeatures(7);
        mCastMgr.setStopOnDisconnect(false);
        mCastMgr.addVideoCastConsumer(new VideoCastConsumerImpl() {

            final ChromeCastHelper this$0;

            public void onApplicationConnected(ApplicationMetadata applicationmetadata, String s, boolean flag)
            {
                if (mPendingMediaDetails != null)
                {
                    loadMedia(mPendingMediaDetails, mPendingResume);
                    mPendingMediaDetails = null;
                }
                Application.getInstance().getOmnitureTracker().chromecastStart(null);
                applicationmetadata = Application.getInstance().getCurrentActivity();
                if (applicationmetadata != null && (applicationmetadata.get() instanceof VideoPlayerActivity))
                {
                    applicationmetadata = (VideoPlayerActivity)applicationmetadata.get();
                    s = applicationmetadata.getPlayingMedia();
                    int i = applicationmetadata.getCurrentPosition();
                    mAccountManager.setItemProgress(s.getID(), i, s.getThumbnail_854x480());
                    applicationmetadata.finish();
                    Intent intent = new Intent(mContext, com/gotv/crackle/DetailsActivityResolver);
                    intent.putExtra("MEDIA_ITEM_ID", s.getID());
                    intent.putExtra("START_PLAYING", true);
                    intent.putExtra("SUPPRESS_RESUME_PROMPT", true);
                    applicationmetadata.startActivity(intent);
                }
            }

            public void onDisconnected()
            {
                Log.d(ChromeCastHelper.TAG, "onDisconnected");
                mMediaDetails = null;
                endChromecastingActivity();
                Application.getInstance().getOmnitureTracker().chromecastStop(null);
                try
                {
                    JSONObject jsonobject = new JSONObject();
                    jsonobject.put("command", "disconnect");
                    Log.d(ChromeCastHelper.TAG, (new StringBuilder()).append("sending disconnect message: ").append(jsonobject.toString()).toString());
                    mCastMgr.sendDataMessage(jsonobject.toString());
                    return;
                }
                catch (Exception exception)
                {
                    Log.w(ChromeCastHelper.TAG, "error sending disconnect message: ", exception);
                }
            }

            public void onRemoteMediaPlayerMetadataUpdated()
            {
                Object obj;
                try
                {
                    obj = mCastMgr.getRemoteMediaInformation();
                }
                catch (Exception exception)
                {
                    Log.e(ChromeCastHelper.TAG, "Error in onRemoteMediaPlayerMetadataUpdated", exception);
                    return;
                }
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_48;
                }
                obj = ((MediaInfo) (obj)).getCustomData();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_48;
                }
                obj = ((JSONObject) (obj)).getJSONObject("media");
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_48;
                }
                loadMediaDetails(((JSONObject) (obj)).getString("ID"));
            }

            public void onRemoteMediaPlayerStatusUpdated()
            {
                Object obj;
                obj = mCastMgr.getRemoteMediaPlayer().getMediaStatus();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                obj = ((MediaStatus) (obj)).getCustomData();
                if (obj == null)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                if (((JSONObject) (obj)).getBoolean("mediaEnded"))
                {
                    savePosition(0);
                    mMediaDetails = null;
                    endChromecastingActivity();
                }
                if (mMediaDetails != null)
                {
                    obj = ((JSONObject) (obj)).getString("subtitles");
                    mMediaDetails.getCaptionLanguageFromLocale(((String) (obj)));
                }
                return;
                JSONException jsonexception;
                jsonexception;
            }

            
            {
                this$0 = ChromeCastHelper.this;
                super();
            }
        });
    }

    private final void displayErrorAndQuit(String s)
    {
        mMediaDetails = null;
        WeakReference weakreference = Application.getInstance().getCurrentActivity();
        if (weakreference != null)
        {
            (new android.app.AlertDialog.Builder((Context)weakreference.get())).setTitle(0x7f0b0030).setMessage(s).setPositiveButton(0x7f0b00b2, new android.content.DialogInterface.OnClickListener() {

                final ChromeCastHelper this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    dialoginterface.cancel();
                    endChromecastingActivity();
                }

            
            {
                this$0 = ChromeCastHelper.this;
                super();
            }
            }).create().show();
        }
    }

    private void endChromecastingActivity()
    {
        WeakReference weakreference = Application.getInstance().getCurrentActivity();
        if (weakreference != null && (weakreference.get() instanceof ChromeCastingDetailsActivity))
        {
            ((BaseActivity)weakreference.get()).finish();
        }
    }

    public static ChromeCastHelper getInstance(Context context)
    {
        if (sInstance == null)
        {
            sInstance = new ChromeCastHelper(context);
        }
        sInstance.setContext(context);
        return sInstance;
    }

    private String getReceiverApplicationId()
    {
        return mContext.getString(0x7f0b0092);
    }

    private void loadMedia(MediaDetailsItem mediadetailsitem, Map map, String s, boolean flag, float f)
    {
        if (!isConnected())
        {
            mPendingMediaDetails = mediadetailsitem;
            mPendingResume = flag;
            return;
        }
        mMediaDetails = mediadetailsitem;
        map = (MediaUrlItem)map.get("AppleTV.m3u8");
        if (map == null || ((MediaUrlItem) (map)).path == null || ((MediaUrlItem) (map)).path.length() == 0)
        {
            displayErrorAndQuit(mContext.getString(0x7f0b0149));
            return;
        }
        map = ((MediaUrlItem) (map)).path;
        String s1 = (new StringBuilder()).append(map).append("&xtest=cdnvz").toString();
        Log.v(TAG, (new StringBuilder()).append("casting media: ").append(mediadetailsitem.getTitle()).append(" url: ").append(s1).toString());
        map = mediadetailsitem.getThumbnailOneSheet185x277();
        MediaMetadata mediametadata;
        JSONObject jsonobject;
        if (map != null)
        {
            map = Uri.parse(map);
        } else
        {
            map = null;
        }
        mediametadata = new MediaMetadata();
        mediametadata.putString("com.google.android.gms.cast.metadata.TITLE", mediadetailsitem.getTitle());
        if (map != null)
        {
            mediametadata.addImage(new WebImage(map));
        }
        if (flag)
        {
            f = SharedPrefsManager.getPlayProgressForItem(mediadetailsitem.getID());
        }
        jsonobject = new JSONObject();
        if (Application.getInstance().isTablet())
        {
            map = "Android Tablet App";
        } else
        {
            map = "Android Phone App";
        }
        try
        {
            jsonobject.put("deviceType", map);
            jsonobject.put("userRating", mediadetailsitem.getUserRating());
            jsonobject.put("rating", mediadetailsitem.getRating());
            jsonobject.put("releaseYear", mediadetailsitem.getReleaseYear());
        }
        // Misplaced declaration of an exception variable
        catch (MediaDetailsItem mediadetailsitem)
        {
            Log.e(TAG, (new StringBuilder()).append("error setting JSON value: ").append(mediadetailsitem).toString());
            displayErrorAndQuit(mContext.getString(0x7f0b0146));
            return;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_288;
        }
        jsonobject.put("subtitles", s);
        jsonobject.put("country", Application.getInstance().getLocalization().getCurrentCountryCode());
        map = new JSONObject();
        map.put("ID", mediadetailsitem.getID());
        map.put("genre", mediadetailsitem.getGenre());
        map.put("mediaType", mediadetailsitem.getMediaType());
        map.put("parentChannelID", mediadetailsitem.getParentChannelID());
        map.put("season", mediadetailsitem.getSeason());
        map.put("episode", mediadetailsitem.getEpisode());
        jsonobject.put("media", map);
        mediadetailsitem = (new com.google.android.gms.cast.MediaInfo.Builder(s1)).setStreamType(1).setContentType("video/mp4").setStreamDuration(Integer.parseInt(mediadetailsitem.getDurationInSeconds()) * 1000).setMetadata(mediametadata).setCustomData(jsonobject).build();
        try
        {
            mCastMgr.loadMedia(mediadetailsitem, true, (int)f, jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaDetailsItem mediadetailsitem)
        {
            displayErrorAndQuit(mContext.getString(0x7f0b0146));
        }
        return;
    }

    private void loadMediaDetails(final String mediaID)
    {
        while (mediaID == null || mMediaDetails != null && mMediaDetails.getID().equals(mediaID)) 
        {
            return;
        }
        final DetailsProvider detailsProvider = new DetailsProvider();
        detailsProvider.getDataWithMediaId(new com.gotv.crackle.data.DataRequest.DataRequestListener() {

            final ChromeCastHelper this$0;
            final DetailsProvider val$detailsProvider;
            final String val$mediaID;

            public void onDataFailed(String s, String s1)
            {
                Log.w(ChromeCastHelper.TAG, (new StringBuilder()).append("couldn't load data for media ID: ").append(mediaID).toString());
            }

            public void onDataSuccess(String s)
            {
                mMediaDetails = detailsProvider.getMediaDetailsItem();
                savePosition();
                refreshActivity();
            }

            
            {
                this$0 = ChromeCastHelper.this;
                detailsProvider = detailsprovider;
                mediaID = s;
                super();
            }
        }, mediaID);
    }

    private void refreshActivity()
    {
        WeakReference weakreference = Application.getInstance().getCurrentActivity();
        if (weakreference != null)
        {
            ((BaseActivity)weakreference.get()).postRefreshData();
        }
    }

    private void setContext(Context context)
    {
        mContext = context;
        mCastMgr.setContext(context);
    }

    public int getCurrentPosition()
    {
        double d;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        d = mCastMgr.getCurrentMediaPosition();
        return (int)d;
        Exception exception;
        exception;
        Log.e(TAG, (new StringBuilder()).append("Error in getCurrentPosition: ").append(exception).toString());
        return 0;
    }

    public int getDuration()
    {
        double d;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        d = mCastMgr.getMediaDuration();
        return (int)d;
        Exception exception;
        exception;
        Log.e(TAG, (new StringBuilder()).append("Error in getDuration: ").append(exception).toString());
        return 0;
    }

    public MediaDetailsItem getMediaDetails()
    {
        return mMediaDetails;
    }

    public String getSelectedSubtitles()
    {
        return mSelectedSubtitles;
    }

    public double getVolume()
    {
        double d;
        try
        {
            d = mCastMgr.getVolume();
        }
        catch (Exception exception)
        {
            return 1.0D;
        }
        return d;
    }

    public void incrementVolume(double d)
    {
        try
        {
            mCastMgr.incrementVolume(d);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, "incrementVolume() Failed to change volume", exception);
        }
    }

    public boolean isConnected()
    {
        return mCastMgr.isConnected();
    }

    public boolean isPlaying()
    {
        boolean flag;
        try
        {
            flag = mCastMgr.isRemoteMoviePlaying();
        }
        catch (Exception exception)
        {
            return false;
        }
        return flag;
    }

    public boolean isPlayingAd()
    {
        Object obj;
        if (!isConnected())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = mCastMgr.getRemoteMediaPlayer().getMediaStatus();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = ((MediaStatus) (obj)).getCustomData();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        boolean flag = ((JSONObject) (obj)).getBoolean("isPlayingAd");
        return flag;
        Object obj1;
        obj1;
        Log.e(TAG, (new StringBuilder()).append("error in isPlayingAd: ").append(obj1).toString());
_L2:
        return false;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void loadMedia(MediaDetailsItem mediadetailsitem, boolean flag)
    {
        loadMedia(mediadetailsitem, mediadetailsitem.getMediaUrls(), null, flag, 0.0F);
    }

    public void onPause()
    {
        mCastMgr.decrementUiCounter();
    }

    public void onResume()
    {
        mCastMgr.incrementUiCounter();
    }

    public void pause()
    {
        try
        {
            mCastMgr.pause();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append("Error in play: ").append(exception).toString());
        }
    }

    public void play()
    {
        try
        {
            mCastMgr.play();
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append("Error in play: ").append(exception).toString());
        }
    }

    public void savePosition()
    {
        savePosition(-1);
    }

    public void savePosition(int i)
    {
        if (mMediaDetails != null)
        {
            if (i < 0)
            {
                i = getCurrentPosition();
            }
            mAccountManager.setItemProgress(mMediaDetails.getID(), i, mMediaDetails.getThumbnail_854x480());
        }
    }

    public void seekTo(long l)
    {
        try
        {
            mCastMgr.seek((int)l);
            savePosition((int)l);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append("Error in seek: ").append(exception).toString());
        }
    }

    public void selectSubtitles(String s)
    {
        if (!isConnected())
        {
            return;
        }
        try
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("command", "selectSubtitles");
            jsonobject.put("lang", s);
            mCastMgr.sendDataMessage(jsonobject.toString());
            Log.i(TAG, " selectSubtitles");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Error in selectSubtitles", s);
        }
    }

    public void setVolume(double d)
    {
        try
        {
            mCastMgr.setVolume(d);
            return;
        }
        catch (Exception exception)
        {
            Log.e(TAG, (new StringBuilder()).append("Error setting volume: ").append(exception).toString());
        }
    }

    public void setupMenuItem(Menu menu)
    {
        if (menu.findItem(0x7f0a01b1) != null)
        {
            mCastMgr.addMediaRouterButton(menu, 0x7f0a01b1);
        }
    }

    public void updateMedia(MediaDetailsItem mediadetailsitem, Map map, String s, float f)
    {
        loadMedia(mediadetailsitem, map, s, false, f);
    }





/*
    static MediaDetailsItem access$102(ChromeCastHelper chromecasthelper, MediaDetailsItem mediadetailsitem)
    {
        chromecasthelper.mMediaDetails = mediadetailsitem;
        return mediadetailsitem;
    }

*/





/*
    static MediaDetailsItem access$402(ChromeCastHelper chromecasthelper, MediaDetailsItem mediadetailsitem)
    {
        chromecasthelper.mPendingMediaDetails = mediadetailsitem;
        return mediadetailsitem;
    }

*/





}
