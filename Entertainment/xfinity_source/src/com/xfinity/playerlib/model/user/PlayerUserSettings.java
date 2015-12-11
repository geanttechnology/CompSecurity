// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.user;

import com.comcast.cim.model.user.service.UserSettings;
import com.xfinity.playerlib.downloads.DeviceRegistration;
import com.xfinity.playerlib.view.browseprograms.DibicProgramFilter;
import com.xfinity.playerlib.view.browseprograms.DibicProgramFilterFactory;
import java.util.HashMap;
import java.util.Map;

public class PlayerUserSettings
    implements com.comcast.cim.cmasl.android708compatlib.view.preference.CCPreviewPreference.CCPreferenceStore, UserSettings
{

    private int appVersionCodeWhenLastActive;
    private int audioTrackIndex;
    private int brightnessValue;
    private int ccBackgroundColor;
    private int ccBackgroundOpacity;
    private int ccEdgeColor;
    private int ccEdgeType;
    private int ccFontFamily;
    private int ccTextColor;
    private int ccTextSize;
    private int ccTrackIndex;
    private String deviceAuthToken;
    private DeviceRegistration deviceRegistration;
    private com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType downloadsSort;
    private DibicProgramFilterFactory filterFactory;
    boolean hasSeenCellularEnabledMessage;
    boolean hasSeenHelpScreen;
    boolean hasSeenMenuOptions;
    boolean hasSeenParentalControlsMessage;
    boolean hasSeenUpgradeMessage;
    private boolean hasSeenWearFirstTimeExperience;
    private boolean hasSeenWelcomeDialog;
    private DibicProgramFilter kidsFilter;
    private int micSensitivity;
    private com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType movieCollectionSort;
    private DibicProgramFilter movieFilter;
    private com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType movieSort;
    private Map networkFilterMap;
    private String previousSessionId;
    private com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType seriesCollectionSort;
    private DibicProgramFilter seriesFilter;
    private com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType seriesSort;
    private String setTopBoxDeviceId;
    private String setTopBoxDeviceKey;
    private String setTopBoxName;
    boolean showDownloadsFTU;
    boolean showLastWatched;
    private boolean showVideoOverMobileWarning;
    private boolean useCellularWhenAvailable;
    boolean wantsAdultContent;
    boolean wantsBrightnessControl;
    private boolean wantsClosedCaptions;
    private boolean wantsStaticBitrate;
    boolean wantsVolumeControl;

    public PlayerUserSettings()
    {
        showVideoOverMobileWarning = true;
        showDownloadsFTU = true;
        hasSeenUpgradeMessage = true;
        brightnessValue = -1;
        movieSort = com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR;
        seriesSort = com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR;
        movieCollectionSort = com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR;
        seriesCollectionSort = com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR;
        networkFilterMap = new HashMap();
        downloadsSort = com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.RECENT;
        ccTrackIndex = -1;
        audioTrackIndex = -1;
        ccBackgroundOpacity = 100;
        micSensitivity = 600;
    }

    public int getAppVersionCodeWhenLastActive()
    {
        this;
        JVM INSTR monitorenter ;
        int i = appVersionCodeWhenLastActive;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getAudioTrackIndex()
    {
        this;
        JVM INSTR monitorenter ;
        int i = audioTrackIndex;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public int getBrightnessValue()
    {
        return brightnessValue;
    }

    public int getCCBackgroundColor()
    {
        return ccBackgroundColor;
    }

    public int getCCBackgroundOpacity()
    {
        return ccBackgroundOpacity;
    }

    public int getCCEdgeColor()
    {
        return ccEdgeColor;
    }

    public int getCCEdgeType()
    {
        return ccEdgeType;
    }

    public int getCCFontFamily()
    {
        return ccFontFamily;
    }

    public int getCCTextColor()
    {
        return ccTextColor;
    }

    public int getCCTextSize()
    {
        return ccTextSize;
    }

    public int getCCTrackIndex()
    {
        this;
        JVM INSTR monitorenter ;
        int i = ccTrackIndex;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public String getDeviceAuthToken()
    {
        this;
        JVM INSTR monitorenter ;
        String s = deviceAuthToken;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public DeviceRegistration getDeviceRegistration()
    {
        this;
        JVM INSTR monitorenter ;
        DeviceRegistration deviceregistration = deviceRegistration;
        this;
        JVM INSTR monitorexit ;
        return deviceregistration;
        Exception exception;
        exception;
        throw exception;
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getDownloadsSort()
    {
        this;
        JVM INSTR monitorenter ;
        com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype = downloadsSort;
        this;
        JVM INSTR monitorexit ;
        return sorttype;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getHasSeenCellularEnabledMessage()
    {
        return hasSeenCellularEnabledMessage;
    }

    public boolean getHasSeenHelpScreen()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasSeenHelpScreen;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getHasSeenMenuOptions()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasSeenMenuOptions;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getHasSeenParentalControlsMessage()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasSeenParentalControlsMessage;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getHasSeenUpgradeMessage()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = hasSeenUpgradeMessage;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getHasSeenWearFirstTimeExperience()
    {
        return hasSeenWearFirstTimeExperience;
    }

    public boolean getHasSeenWelcomeDialog()
    {
        return hasSeenWelcomeDialog;
    }

    public DibicProgramFilter getKidsFilter()
    {
        this;
        JVM INSTR monitorenter ;
        DibicProgramFilter dibicprogramfilter;
        if (kidsFilter == null)
        {
            kidsFilter = filterFactory.createDefaultFilter();
        }
        dibicprogramfilter = kidsFilter;
        this;
        JVM INSTR monitorexit ;
        return dibicprogramfilter;
        Exception exception;
        exception;
        throw exception;
    }

    public int getMicSensitivity()
    {
        return micSensitivity;
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getMovieCollectionSort()
    {
        this;
        JVM INSTR monitorenter ;
        com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype = movieCollectionSort;
        this;
        JVM INSTR monitorexit ;
        return sorttype;
        Exception exception;
        exception;
        throw exception;
    }

    public DibicProgramFilter getMovieFilter()
    {
        this;
        JVM INSTR monitorenter ;
        DibicProgramFilter dibicprogramfilter;
        if (movieFilter == null)
        {
            movieFilter = filterFactory.createDefaultFilter();
        }
        dibicprogramfilter = movieFilter;
        this;
        JVM INSTR monitorexit ;
        return dibicprogramfilter;
        Exception exception;
        exception;
        throw exception;
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getMovieSort()
    {
        this;
        JVM INSTR monitorenter ;
        com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype = movieSort;
        this;
        JVM INSTR monitorexit ;
        return sorttype;
        Exception exception;
        exception;
        throw exception;
    }

    public Map getNetworkFilterMap()
    {
        return networkFilterMap;
    }

    public DibicProgramFilter getNetworkProgramsFilter(long l, String s)
    {
        this;
        JVM INSTR monitorenter ;
        String s3;
        s3 = String.valueOf(l);
        if (!networkFilterMap.containsKey(String.valueOf(l)))
        {
            networkFilterMap.put(String.valueOf(l), new HashMap());
        }
        String s1;
        String s2 = "no_category";
        s1 = s2;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        s1 = s2;
        if (!s.equals(""))
        {
            s1 = s;
        }
        if (!((Map)networkFilterMap.get(s3)).containsKey(s1))
        {
            ((Map)networkFilterMap.get(s3)).put(s1, filterFactory.createNetworkFilter());
        }
        s = (DibicProgramFilter)((Map)networkFilterMap.get(s3)).get(s1);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public String getPreviousSessionId()
    {
        this;
        JVM INSTR monitorenter ;
        String s = previousSessionId;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getSeriesCollectionSort()
    {
        this;
        JVM INSTR monitorenter ;
        com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype = seriesCollectionSort;
        this;
        JVM INSTR monitorexit ;
        return sorttype;
        Exception exception;
        exception;
        throw exception;
    }

    public DibicProgramFilter getSeriesFilter()
    {
        this;
        JVM INSTR monitorenter ;
        DibicProgramFilter dibicprogramfilter;
        if (seriesFilter == null)
        {
            seriesFilter = filterFactory.createDefaultFilter();
        }
        dibicprogramfilter = seriesFilter;
        this;
        JVM INSTR monitorexit ;
        return dibicprogramfilter;
        Exception exception;
        exception;
        throw exception;
    }

    public com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType getSeriesSort()
    {
        this;
        JVM INSTR monitorenter ;
        com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype = seriesSort;
        this;
        JVM INSTR monitorexit ;
        return sorttype;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSetTopBoxDeviceId()
    {
        return setTopBoxDeviceId;
    }

    public String getSetTopBoxDeviceKey()
    {
        return setTopBoxDeviceKey;
    }

    public String getSetTopBoxName()
    {
        return setTopBoxName;
    }

    public boolean getShowDownloadsFTU()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = showDownloadsFTU;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getShowLastWatched()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = showLastWatched;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public Boolean getShowVideoOverMobileWarning()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = showVideoOverMobileWarning;
        this;
        JVM INSTR monitorexit ;
        return Boolean.valueOf(flag);
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getUseCellularWhenAvailable()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = useCellularWhenAvailable;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getWantsAdultContent()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = wantsAdultContent;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getWantsBrightnessControl()
    {
        return wantsBrightnessControl;
    }

    public boolean getWantsClosedCaptions()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = wantsClosedCaptions;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean getWantsStaticBitrate()
    {
        return wantsStaticBitrate;
    }

    public boolean getWantsVolumeControl()
    {
        return wantsVolumeControl;
    }

    public void resetFilters()
    {
        movieFilter = null;
        seriesFilter = null;
        kidsFilter = null;
        networkFilterMap = new HashMap();
    }

    public void resetNetworkFilters()
    {
        networkFilterMap = new HashMap();
        if (movieFilter != null && movieFilter.getCurrentNetworkFilters() != null)
        {
            movieFilter.getCurrentNetworkFilters().clear();
        }
        if (seriesFilter != null && seriesFilter.getCurrentNetworkFilters() != null)
        {
            seriesFilter.getCurrentNetworkFilters().clear();
        }
        if (kidsFilter != null && kidsFilter.getCurrentNetworkFilters() != null)
        {
            kidsFilter.getCurrentNetworkFilters().clear();
        }
    }

    public void setAppVersionCodeWhenLastActive(int i)
    {
        this;
        JVM INSTR monitorenter ;
        appVersionCodeWhenLastActive = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAudioTrackIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        audioTrackIndex = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setBrightnessValue(int i)
    {
        brightnessValue = i;
    }

    public void setCCBackgroundColor(int i)
    {
        ccBackgroundColor = i;
    }

    public void setCCBackgroundOpacity(int i)
    {
        ccBackgroundOpacity = i;
    }

    public void setCCEdgeColor(int i)
    {
        ccEdgeColor = i;
    }

    public void setCCEdgeType(int i)
    {
        ccEdgeType = i;
    }

    public void setCCFontFamily(int i)
    {
        ccFontFamily = i;
    }

    public void setCCTextColor(int i)
    {
        ccTextColor = i;
    }

    public void setCCTextSize(int i)
    {
        ccTextSize = i;
    }

    public void setCCTrackIndex(int i)
    {
        this;
        JVM INSTR monitorenter ;
        ccTrackIndex = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setDeviceAuthToken(String s)
    {
        this;
        JVM INSTR monitorenter ;
        deviceAuthToken = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setDeviceRegistration(DeviceRegistration deviceregistration)
    {
        this;
        JVM INSTR monitorenter ;
        deviceRegistration = deviceregistration;
        this;
        JVM INSTR monitorexit ;
        return;
        deviceregistration;
        throw deviceregistration;
    }

    public void setDownloadsSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        this;
        JVM INSTR monitorenter ;
        downloadsSort = sorttype;
        this;
        JVM INSTR monitorexit ;
        return;
        sorttype;
        throw sorttype;
    }

    public void setFilterFactory(DibicProgramFilterFactory dibicprogramfilterfactory)
    {
        filterFactory = dibicprogramfilterfactory;
    }

    public void setHasSeenCellularEnabledMessage(boolean flag)
    {
        hasSeenCellularEnabledMessage = flag;
    }

    public void setHasSeenHelpScreen(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        hasSeenHelpScreen = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHasSeenMenuOptions(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        hasSeenMenuOptions = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHasSeenParentalControlsMessage(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        hasSeenParentalControlsMessage = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHasSeenUpgradeMessage(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        hasSeenUpgradeMessage = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setHasSeenWearFirstTimeExperience(boolean flag)
    {
        hasSeenWearFirstTimeExperience = flag;
    }

    public void setHasSeenWelcomeDialog(boolean flag)
    {
        hasSeenWelcomeDialog = flag;
    }

    public void setMicSensitivity(int i)
    {
        micSensitivity = i;
    }

    public void setMovieCollectionSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        this;
        JVM INSTR monitorenter ;
        movieCollectionSort = sorttype;
        this;
        JVM INSTR monitorexit ;
        return;
        sorttype;
        throw sorttype;
    }

    public void setMovieFilter(DibicProgramFilter dibicprogramfilter)
    {
        this;
        JVM INSTR monitorenter ;
        movieFilter = dibicprogramfilter;
        this;
        JVM INSTR monitorexit ;
        return;
        dibicprogramfilter;
        throw dibicprogramfilter;
    }

    public void setMovieSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        this;
        JVM INSTR monitorenter ;
        movieSort = sorttype;
        this;
        JVM INSTR monitorexit ;
        return;
        sorttype;
        throw sorttype;
    }

    public void setPreviousSessionId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        previousSessionId = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setSeriesCollectionSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        this;
        JVM INSTR monitorenter ;
        seriesCollectionSort = sorttype;
        this;
        JVM INSTR monitorexit ;
        return;
        sorttype;
        throw sorttype;
    }

    public void setSeriesFilter(DibicProgramFilter dibicprogramfilter)
    {
        this;
        JVM INSTR monitorenter ;
        seriesFilter = dibicprogramfilter;
        this;
        JVM INSTR monitorexit ;
        return;
        dibicprogramfilter;
        throw dibicprogramfilter;
    }

    public void setSeriesSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType sorttype)
    {
        this;
        JVM INSTR monitorenter ;
        seriesSort = sorttype;
        this;
        JVM INSTR monitorexit ;
        return;
        sorttype;
        throw sorttype;
    }

    public void setSetTopBoxDeviceId(String s)
    {
        setTopBoxDeviceId = s;
    }

    public void setSetTopBoxDeviceKey(String s)
    {
        setTopBoxDeviceKey = s;
    }

    public void setSetTopBoxName(String s)
    {
        setTopBoxName = s;
    }

    public void setShowDownloadsFTU(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        showDownloadsFTU = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setShowLastWatched(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        showLastWatched = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setShowVideoOverMobileWarning(Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        showVideoOverMobileWarning = boolean1.booleanValue();
        this;
        JVM INSTR monitorexit ;
        return;
        boolean1;
        throw boolean1;
    }

    public void setUseCellularWhenAvailable(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        useCellularWhenAvailable = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setWantsAdultContent(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        wantsAdultContent = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setWantsBrightnessControl(boolean flag)
    {
        wantsBrightnessControl = flag;
    }

    public void setWantsClosedCaptions(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        wantsClosedCaptions = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setWantsStaticBitrate(boolean flag)
    {
        wantsStaticBitrate = flag;
    }

    public void setWantsVolumeControl(boolean flag)
    {
        wantsVolumeControl = flag;
    }
}
