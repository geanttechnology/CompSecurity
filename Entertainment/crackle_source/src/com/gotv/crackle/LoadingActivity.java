// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.freewheel.ad.AdFetcher;
import com.freewheel.ad.IAdHolder;
import com.freewheel.ad.SplashAdActivity;
import com.gotv.crackle.base.BaseActivity;
import com.gotv.crackle.data.CrackleAccountManager;
import com.gotv.crackle.data.GenreList;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.Localization;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.data.QueueManager;
import com.gotv.crackle.data.Version;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.model.MediaDetailsItem;
import com.gotv.crackle.util.LocalNotificationManager;
import com.gotv.crackle.util.Log;
import com.tremorvideo.sdk.android.videoad.TremorVideo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.ISlot;

// Referenced classes of package com.gotv.crackle:
//            Application, ApplicationConstants

public class LoadingActivity extends BaseActivity
    implements IAdHolder
{

    public String TAG;
    private IAdContext adContext;
    private AdFetcher adFetcher;
    private ItemsListRequest mCrackleRequester;
    private GenreList mGenreListMovies;
    private GenreList mGenreListShows;
    private boolean mGotLocation;
    private MediaDetailsRequest mMediaDetailsRequest;
    private LocalNotificationManager mNotificationManager;
    private QueueManager mQueueManager;
    private String mResumeItemId;

    public LoadingActivity()
    {
        TAG = "LoadingActivity";
    }

    private void getData()
    {
        mCrackleRequester = new ItemsListRequest(this, com.gotv.crackle.data.ItemsListRequest.ItemsListType.Featured, "moviesandtv");
        mGenreListMovies = new GenreList(this, "movies");
        mGenreListShows = new GenreList(this, "shows");
        String s = CrackleAccountManager.getUserID();
        if (s != null)
        {
            mQueueManager = new QueueManager(this, s);
            mQueueManager.getWatchList();
        }
    }

    private void resetResumeExpiringMediaNotification()
    {
        Object obj;
        String s;
        Object obj1;
        int i;
label0:
        {
            mResumeItemId = SharedPrefsManager.getLastViewedMediaItem();
            if (mResumeItemId != null)
            {
                mMediaDetailsRequest = new MediaDetailsRequest(this, mResumeItemId);
            }
            try
            {
                Thread.sleep(1000L);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((InterruptedException) (obj)).printStackTrace();
            }
            if (mMediaDetailsRequest != null)
            {
                obj1 = mMediaDetailsRequest.getItem();
                if (obj1 != null && ((MediaDetailsItem) (obj1)).getExpiresInLessThan5days())
                {
                    obj = ((MediaDetailsItem) (obj1)).getID();
                    s = ((MediaDetailsItem) (obj1)).getParentChannelID();
                    i = ((MediaDetailsItem) (obj1)).getExpiresInDays().intValue();
                    if (!((MediaDetailsItem) (obj1)).getMediaType().equalsIgnoreCase("series"))
                    {
                        break label0;
                    }
                    obj1 = (new StringBuilder()).append(((MediaDetailsItem) (obj1)).getShowName()).append(" - ").append(((MediaDetailsItem) (obj1)).getEpisodeFancy()).toString();
                    mNotificationManager.resetResumeExpiringMediaNotification(this, ((String) (obj1)), ((String) (obj)), s, i);
                }
            }
            return;
        }
        mNotificationManager.resetResumeExpiringMediaNotification(this, ((MediaDetailsItem) (obj1)).getTitle(), ((String) (obj)), s, i);
    }

    private void resetResumeMediaNotification()
    {
        Object obj;
        String s;
        Object obj1;
label0:
        {
            mResumeItemId = SharedPrefsManager.getLastViewedMediaItem();
            if (mResumeItemId != null)
            {
                mMediaDetailsRequest = new MediaDetailsRequest(this, mResumeItemId);
            }
            try
            {
                Thread.sleep(1000L);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((InterruptedException) (obj)).printStackTrace();
            }
            if (mMediaDetailsRequest != null)
            {
                obj1 = mMediaDetailsRequest.getItem();
                if (obj1 != null)
                {
                    obj = ((MediaDetailsItem) (obj1)).getID();
                    s = ((MediaDetailsItem) (obj1)).getParentChannelID();
                    if (!((MediaDetailsItem) (obj1)).getMediaType().equalsIgnoreCase("series"))
                    {
                        break label0;
                    }
                    obj1 = (new StringBuilder()).append(((MediaDetailsItem) (obj1)).getShowName()).append(" - ").append(((MediaDetailsItem) (obj1)).getEpisodeFancy()).toString();
                    mNotificationManager.resetResumeMediaNotification(this, ((String) (obj1)), ((String) (obj)), s);
                }
            }
            return;
        }
        mNotificationManager.resetResumeMediaNotification(this, ((MediaDetailsItem) (obj1)).getTitle(), ((String) (obj)), s);
    }

    private void versionCheck()
    {
        Version version = new Version(Application.getInstalledVersion());
        Version version1 = new Version(Application.getInstance().getLocalization().getSoftwareVersion());
        IllegalArgumentException illegalargumentexception;
        if (version.compareTo(version1) == -1)
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(getResources().getString(0x7f0b00da));
            builder.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                final LoadingActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    try
                    {
                        finish();
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(Application.getInstance().getPackageName()).toString())));
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (DialogInterface dialoginterface)
                    {
                        Log.e(TAG, dialoginterface.getMessage());
                    }
                    dialoginterface = new Intent("android.intent.action.MAIN");
                    dialoginterface.addCategory("android.intent.category.HOME");
                    startActivity(dialoginterface);
                }

            
            {
                this$0 = LoadingActivity.this;
                super();
            }
            });
            builder.create().show();
        } else
        {
            Log.d("LOADING", "LOADING 7");
            getData();
        }
        return;
        illegalargumentexception;
_L2:
        getData();
        return;
        IllegalArgumentException illegalargumentexception1;
        illegalargumentexception1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void beforeSubmitRequest(String s)
    {
        if (Application.getInstance().isTablet())
        {
            adContext.addSiteSectionNonTemporalSlot("SPLASH_SLOT", null, 512, 512, null, false, null, null);
            return;
        } else
        {
            adContext.addSiteSectionNonTemporalSlot("SPLASH_SLOT", null, 300, 250, null, false, null, null);
            return;
        }
    }

    public void getAd()
    {
        adFetcher = new AdFetcher(this);
        adFetcher.loadAd(ApplicationConstants.getFreeWheelLaunchSiteSection());
    }

    public Activity getBaseActivity()
    {
        return this;
    }

    public String getVideoAssetId()
    {
        return null;
    }

    public int getVideoDurationInSec()
    {
        return 0;
    }

    public String getVideoTitle()
    {
        return null;
    }

    public void onAdContextCreated(IAdContext iadcontext)
    {
        adContext = iadcontext;
    }

    public void onAdManagerLoadFailed()
    {
        finish();
        Application.getInstance().startHomeActivity(this);
    }

    public void onAppSdkEvent(long l, int i, String s)
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        setContentView(0x7f030071);
        mRootView = findViewById(0x1020002);
        super.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030071);
        mRootView = findViewById(0x1020002);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().hide();
        }
        SharedPrefsManager.setNumberOfLaunches(SharedPrefsManager.getNumberOfLaunches() + 1);
        mNotificationManager = new LocalNotificationManager();
        mNotificationManager.create2DayNotification(this);
        mNotificationManager.reset45dayNotification(this);
        resetResumeMediaNotification();
        resetResumeExpiringMediaNotification();
        Application.getInstance().setCurrentActivity(new WeakReference(this));
        TremorVideo.initialize(this, "430752");
        TremorVideo.start();
        Log.d("LOADING", "LOADING 1");
    }

    public void onDataFailed(final String tag, final String Message)
    {
        if (!isFinishing())
        {
            runOnUiThread(new Runnable() {

                final LoadingActivity this$0;
                final String val$Message;
                final String val$tag;

                public void run()
                {
                    if (tag.compareTo("GetAllowedLocations") == 0 || tag.compareTo("GetLocation") == 0)
                    {
                        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoadingActivity.this);
                        builder.setMessage(getResources().getString(0x7f0b00b4));
                        builder.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                            final _cls3 this$1;

                            public void onClick(DialogInterface dialoginterface, int i)
                            {
                                finish();
                                dialoginterface = new Intent("android.intent.action.MAIN");
                                dialoginterface.addCategory("android.intent.category.HOME");
                                dialoginterface.setFlags(0x10000000);
                                startActivity(dialoginterface);
                            }

            
            {
                this$1 = _cls3.this;
                super();
            }
                        });
                        builder.create().show();
                        return;
                    } else
                    {
                        mNetworkDialog.setMessage(Message);
                        mNetworkDialog.show();
                        return;
                    }
                }

            
            {
                this$0 = LoadingActivity.this;
                tag = s;
                Message = s1;
                super();
            }
            });
        }
    }

    public void onDataSuccess(final String tag)
    {
        runOnUiThread(new Runnable() {

            final LoadingActivity this$0;
            final String val$tag;

            public void run()
            {
                if (mGotLocation || !tag.equalsIgnoreCase("GetAllowedLocations") && !tag.equalsIgnoreCase("GetLocation")) goto _L2; else goto _L1
_L1:
                Log.d("LOADING", "LOADING 3");
                if (!Application.getInstance().getLocalization().allRequestsComplete()) goto _L4; else goto _L3
_L3:
                Log.d("LOADING", "LOADING 4");
                if (!Application.getInstance().getLocalization().isCurrentCountryCodeValid()) goto _L6; else goto _L5
_L5:
                Log.d("LOADING", "LOADING 5");
                mGotLocation = true;
                Application.getInstance();
                if (Application.isLeanBack() || Application.isNookTablet() || Application.isKindle()) goto _L8; else goto _L7
_L7:
                versionCheck();
_L4:
                return;
_L8:
                getData();
                return;
_L6:
                Log.d("LOADING", "LOADING 6");
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(LoadingActivity.this);
                builder.setMessage(getResources().getString(0x7f0b00b3));
                builder.setPositiveButton(getResources().getString(0x7f0b00b5), new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        finish();
                        dialoginterface = new Intent("android.intent.action.MAIN");
                        dialoginterface.addCategory("android.intent.category.HOME");
                        startActivity(dialoginterface);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                builder.create().show();
                return;
_L2:
                if (mCrackleRequester != null && mGenreListMovies != null && mGenreListShows != null)
                {
                    Log.d("LOADING", "LOADING 8");
                    if (mCrackleRequester.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE && mGenreListMovies.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE && mGenreListShows.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
                    {
                        Log.d("LOADING", "LOADING 9");
                        if (Application.isLeanBack())
                        {
                            finish();
                            Application.getInstance().startHomeActivity(LoadingActivity.this);
                            return;
                        } else
                        {
                            getAd();
                            return;
                        }
                    }
                }
                if (true) goto _L4; else goto _L9
_L9:
            }

            
            {
                this$0 = LoadingActivity.this;
                tag = s;
                super();
            }
        });
    }

    public void onRequestComplete(IEvent ievent)
    {
        if (!mRootView.hasWindowFocus()) goto _L2; else goto _L1
_L1:
        ievent = adContext.getSlotsByTimePositionClass(adContext.getConstants().TIME_POSITION_CLASS_DISPLAY());
        if (ievent.size() >= 1) goto _L4; else goto _L3
_L3:
        finish();
        Application.getInstance().startHomeActivity(this);
_L2:
        return;
_L4:
        ievent = ievent.iterator();
        ISlot islot;
        do
        {
            if (!ievent.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            islot = (ISlot)ievent.next();
        } while (islot.getCustomId().compareTo("SPLASH_SLOT") != 0);
        SplashAdActivity.setSlot(islot);
        startActivity(new Intent(this, com/freewheel/ad/SplashAdActivity));
        finish();
        return;
        if (false) goto _L2; else goto _L5
_L5:
        finish();
        Application.getInstance().startHomeActivity(this);
        return;
    }

    protected void onResume()
    {
        Application.getInstance().setCurrentActivity(new WeakReference(this));
        Log.d("LOADING", "LOADING 2");
        mGotLocation = false;
        Application.getInstance().getLocalization().getAllowedLocationsAsync();
        Application.getInstance().getLocalization().updateCurrentLocationAsync();
        super.onResume();
    }

    protected void performMenuAction(int i)
    {
    }

    protected void refreshData()
    {
        getData();
    }



/*
    static boolean access$002(LoadingActivity loadingactivity, boolean flag)
    {
        loadingactivity.mGotLocation = flag;
        return flag;
    }

*/





}
