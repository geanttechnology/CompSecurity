// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sitespeed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.appspeed.AppSpeedShim;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.SiteSpeedData;
import com.ebay.nautilus.domain.data.SiteSpeedDataNoOp;
import com.ebay.nautilus.shell.app.ActivityShim;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.TrackingSupport;

public class SiteSpeedActivityUtil extends ActivityShim
{

    public static final SiteSpeedDataNoOp SITE_SPEED_DATA_NO_OP = new SiteSpeedDataNoOp("NoOp", false, null);
    private Runnable allLoadedReporter;
    private boolean keepActiveAfterPause;
    private Runnable primaryLoadedReporter;
    private SiteSpeedData siteSpeedData;
    private boolean skipCreate;
    private View view;
    private Runnable viewAppearedReporter;

    public SiteSpeedActivityUtil()
    {
    }

    public static void allLoaded(FwActivity fwactivity)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.allLoaded();
        }
    }

    public static SiteSpeedData createSiteSpeedData(String s)
    {
        Preferences preferences = MyApp.getPrefs();
        return new SiteSpeedData(s, preferences.isSignedIn(), preferences.getCurrentCountry());
    }

    private void doAllLoaded(SiteSpeedData sitespeeddata)
    {
        sitespeeddata.allLoaded();
        if (sitespeeddata.upload(getFwActivity().getEbayContext()))
        {
            invalidate();
        }
    }

    private void doPrimaryLoaded(SiteSpeedData sitespeeddata)
    {
        sitespeeddata.primaryLoaded();
        if (sitespeeddata.upload(getFwActivity().getEbayContext()))
        {
            invalidate();
        }
    }

    private void doViewAppeared(SiteSpeedData sitespeeddata)
    {
        sitespeeddata.viewAppeared();
        if (sitespeeddata.upload(getFwActivity().getEbayContext()))
        {
            invalidate();
        }
    }

    private static SiteSpeedActivityUtil get(FwActivity fwactivity)
    {
        return (SiteSpeedActivityUtil)fwactivity.getShim(com/ebay/mobile/sitespeed/SiteSpeedActivityUtil);
    }

    public static SiteSpeedData getSiteSpeedData(FwActivity fwactivity)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            return fwactivity.getSiteSpeedData();
        } else
        {
            return SITE_SPEED_DATA_NO_OP;
        }
    }

    public static void initSiteSpeedData(FwActivity fwactivity)
    {
        if (fwactivity instanceof TrackingSupport)
        {
            String s = ((TrackingSupport)fwactivity).getTrackingEventName();
            if (s != null)
            {
                initSiteSpeedData(fwactivity, s);
            }
        }
    }

    public static void initSiteSpeedData(FwActivity fwactivity, String s)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.initSiteSpeedData(s);
        }
    }

    public static void initSiteSpeedData(FwActivity fwactivity, String s, boolean flag, EbayCountry ebaycountry)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.initSiteSpeedData(s, flag, ebaycountry);
        }
    }

    private void initSiteSpeedData(String s)
    {
        Preferences preferences = MyApp.getPrefs();
        initSiteSpeedData(s, preferences.isSignedIn(), preferences.getCurrentCountry());
    }

    private void initSiteSpeedData(String s, boolean flag, EbayCountry ebaycountry)
    {
        releaseView();
        view = getActivity().findViewById(0x1020002);
        siteSpeedData = new SiteSpeedData(s, flag, ebaycountry);
    }

    public static void invalidate(FwActivity fwactivity)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.invalidate();
        }
    }

    public static void primaryAndAllLoaded(FwActivity fwactivity)
    {
        SiteSpeedActivityUtil sitespeedactivityutil = get(fwactivity);
        if (sitespeedactivityutil != null)
        {
            sitespeedactivityutil.primaryLoaded();
            sitespeedactivityutil.allLoaded();
        }
        fwactivity = (AppSpeedShim)fwactivity.getShim(com/ebay/mobile/appspeed/AppSpeedShim);
        if (fwactivity != null)
        {
            fwactivity.atfRendered();
        }
    }

    private void primaryLoaded()
    {
        final SiteSpeedData speedData = getSiteSpeedData();
        if (view != null)
        {
            if (primaryLoadedReporter == null)
            {
                primaryLoadedReporter = new Runnable() {

                    final SiteSpeedActivityUtil this$0;
                    final SiteSpeedData val$speedData;

                    public void run()
                    {
                        doPrimaryLoaded(speedData);
                    }

            
            {
                this$0 = SiteSpeedActivityUtil.this;
                speedData = sitespeeddata;
                super();
            }
                };
                ViewCompat.postOnAnimation(view, primaryLoadedReporter);
            }
            return;
        } else
        {
            doPrimaryLoaded(speedData);
            return;
        }
    }

    public static void primaryLoaded(FwActivity fwactivity)
    {
        SiteSpeedActivityUtil sitespeedactivityutil = get(fwactivity);
        if (sitespeedactivityutil != null)
        {
            sitespeedactivityutil.primaryLoaded();
        }
        fwactivity = (AppSpeedShim)fwactivity.getShim(com/ebay/mobile/appspeed/AppSpeedShim);
        if (fwactivity != null)
        {
            fwactivity.atfRendered();
        }
    }

    private void releaseView()
    {
        viewAppearedReporter = null;
        primaryLoadedReporter = null;
        allLoadedReporter = null;
        view = null;
    }

    public static void setKeepActiveAfterPause(FwActivity fwactivity, boolean flag)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.keepActiveAfterPause = flag;
        }
    }

    public static void skipCreate(FwActivity fwactivity)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.skipCreate = true;
        }
    }

    private void viewAppeared()
    {
        final SiteSpeedData speedData = getSiteSpeedData();
        if (view != null)
        {
            if (viewAppearedReporter == null)
            {
                viewAppearedReporter = new Runnable() {

                    final SiteSpeedActivityUtil this$0;
                    final SiteSpeedData val$speedData;

                    public void run()
                    {
                        doViewAppeared(speedData);
                    }

            
            {
                this$0 = SiteSpeedActivityUtil.this;
                speedData = sitespeeddata;
                super();
            }
                };
                ViewCompat.postOnAnimation(view, viewAppearedReporter);
            }
            return;
        } else
        {
            doViewAppeared(speedData);
            return;
        }
    }

    public static void viewAppeared(FwActivity fwactivity)
    {
        fwactivity = get(fwactivity);
        if (fwactivity != null)
        {
            fwactivity.viewAppeared();
        }
    }

    protected final void allLoaded()
    {
        final SiteSpeedData speedData = getSiteSpeedData();
        if (view != null)
        {
            if (allLoadedReporter == null)
            {
                allLoadedReporter = new Runnable() {

                    final SiteSpeedActivityUtil this$0;
                    final SiteSpeedData val$speedData;

                    public void run()
                    {
                        doAllLoaded(speedData);
                    }

            
            {
                this$0 = SiteSpeedActivityUtil.this;
                speedData = sitespeeddata;
                super();
            }
                };
                ViewCompat.postOnAnimation(view, allLoadedReporter);
            }
            return;
        } else
        {
            doAllLoaded(speedData);
            return;
        }
    }

    protected final SiteSpeedData getSiteSpeedData()
    {
        if (siteSpeedData == null)
        {
            siteSpeedData = SITE_SPEED_DATA_NO_OP;
        }
        return siteSpeedData;
    }

    protected final void invalidate()
    {
        releaseView();
        siteSpeedData = SITE_SPEED_DATA_NO_OP;
    }

    protected void onCreate(Bundle bundle)
    {
        if (!skipCreate)
        {
            Object obj = getActivity();
            if (bundle == null && (obj instanceof TrackingSupport))
            {
                obj = ((TrackingSupport)obj).getTrackingEventName();
                if (obj != null)
                {
                    initSiteSpeedData(((String) (obj)));
                }
            }
        }
        super.onCreate(bundle);
    }

    protected void onPause()
    {
        super.onPause();
        if (!keepActiveAfterPause)
        {
            invalidate();
        }
    }

    protected void onPostResume()
    {
        super.onPostResume();
        viewAppeared();
    }




}
