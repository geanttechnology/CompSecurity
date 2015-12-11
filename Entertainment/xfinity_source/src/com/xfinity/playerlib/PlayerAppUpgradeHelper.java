// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib;

import android.content.SharedPreferences;
import com.comcast.cim.android.application.AppUpgradeHelper;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.exception.CimUpgradeException;
import com.comcast.cim.model.user.UserManager;
import com.xfinity.playerlib.captions.PersistentCaptionsCache;
import com.xfinity.playerlib.model.database.VideoBookmarkDAO;
import com.xfinity.playerlib.model.downloads.PersistentEntityCache;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.browseprograms.DibicProgramFilter;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib:
//            PlayerApplication

public abstract class PlayerAppUpgradeHelper
    implements AppUpgradeHelper
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/PlayerAppUpgradeHelper);
    private final VideoBookmarkDAO bookmarkDAO;
    private final PlayerDownloadServiceManager downloadsManager;
    private final PersistentCaptionsCache persistentCaptionsCache;
    private final PersistentEntityCache persistentEntityCache;
    private final PlayerApplication playNowApplication;
    private final SharedPreferences sharedPrefs;
    private final UserManager userManager;

    public PlayerAppUpgradeHelper(PlayerApplication playerapplication, UserManager usermanager, SharedPreferences sharedpreferences, PlayerDownloadServiceManager playerdownloadservicemanager, PersistentEntityCache persistententitycache, PersistentCaptionsCache persistentcaptionscache, VideoBookmarkDAO videobookmarkdao)
    {
        playNowApplication = playerapplication;
        userManager = usermanager;
        sharedPrefs = sharedpreferences;
        downloadsManager = playerdownloadservicemanager;
        persistentEntityCache = persistententitycache;
        persistentCaptionsCache = persistentcaptionscache;
        bookmarkDAO = videobookmarkdao;
    }

    private boolean clearPreAdobifyData()
        throws DownloadServiceException
    {
        downloadsManager.waitForInitialization(5000L);
        if (downloadsManager.hasOldFiles())
        {
            downloadsManager.deleteAllContentForUpgrade();
            persistentEntityCache.clear();
            persistentCaptionsCache.clear();
            return true;
        } else
        {
            return false;
        }
    }

    public void onLaunch()
    {
        this;
        JVM INSTR monitorenter ;
        int i = sharedPrefs.getInt("versionCodeLastSuccessfulLaunch", 0);
        if (i < playNowApplication.getVersionCode() && !sharedPrefs.contains("UpgradeSignoutKey") && upgradeRequiresSignout(i))
        {
            userManager.signOutUser();
            android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putInt("versionCodeLastSuccessfulLaunch", playNowApplication.getVersionCode());
            editor.commit();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onUserLoadedOrSignedIn()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int i;
        int j;
        i = playNowApplication.getVersionCode();
        obj = (PlayerUserSettings)userManager.getUserSettings();
        j = ((PlayerUserSettings) (obj)).getAppVersionCodeWhenLastActive();
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_378;
        }
        if (upgradeRequiresFilterReset(j))
        {
            LOG.info("Resetting filters because the user hasn't been active since (we realized) the format changed");
            ((PlayerUserSettings) (obj)).resetFilters();
        }
        if (j >= 3045)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        java.util.HashMap hashmap = ((PlayerUserSettings) (obj)).getKidsFilter().getCurrentProgramTypeFilters();
        Iterator iterator1 = hashmap.keySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s = (String)iterator1.next();
            if (!s.equals("movies") && !s.equals("tvseries"))
            {
                LOG.info("Removing invalid program type filter with id {} and label {}", s, hashmap.get(s));
                iterator1.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_160;
        obj;
        throw obj;
        if (j >= 5504)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        (new Thread(new Runnable() {

            final PlayerAppUpgradeHelper this$0;

            public void run()
            {
                playNowApplication.getFilesDir();
                (new File((new StringBuilder()).append(playNowApplication.getFilesDir()).append("analyticsqueue").toString())).delete();
            }

            
            {
                this$0 = PlayerAppUpgradeHelper.this;
                super();
            }
        })).start();
        if (j >= 5805)
        {
            break MISSING_BLOCK_LABEL_319;
        }
        for (Iterator iterator = ((PlayerUserSettings) (obj)).getNetworkFilterMap().entrySet().iterator(); iterator.hasNext();)
        {
            Iterator iterator2 = ((Map)((java.util.Map.Entry)iterator.next()).getValue()).entrySet().iterator();
            while (iterator2.hasNext()) 
            {
                DibicProgramFilter dibicprogramfilter = (DibicProgramFilter)((java.util.Map.Entry)iterator2.next()).getValue();
                dibicprogramfilter.setHideLockOn(false);
                dibicprogramfilter.clearFiltersForCategory(com.xfinity.playerlib.view.browseprograms.DibicProgramFilter.FilterCategory.NETWORK);
            }
        }

        ((PlayerUserSettings) (obj)).setMovieSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR);
        ((PlayerUserSettings) (obj)).setSeriesSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR);
        ((PlayerUserSettings) (obj)).setSeriesCollectionSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR);
        ((PlayerUserSettings) (obj)).setMovieCollectionSort(com.xfinity.playerlib.view.browseprograms.SortPolicy.SortType.POPULAR);
        if (j >= 5911)
        {
            break MISSING_BLOCK_LABEL_331;
        }
        ((PlayerUserSettings) (obj)).resetNetworkFilters();
        if (j >= 5905)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        bookmarkDAO.updateLastTrackedMilestones();
        if (j >= 3000)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        if (clearPreAdobifyData())
        {
            ((PlayerUserSettings) (obj)).setHasSeenUpgradeMessage(false);
        }
        ((PlayerUserSettings) (obj)).resetFilters();
        ((PlayerUserSettings) (obj)).setAppVersionCodeWhenLastActive(i);
        this;
        JVM INSTR monitorexit ;
        return;
        DownloadServiceException downloadserviceexception;
        downloadserviceexception;
        LOG.error("DownloadServiceManager failed to initialize in time", downloadserviceexception);
        throw new CimUpgradeException("Failed to Upgrade User: ", downloadserviceexception);
    }

    protected abstract boolean upgradeRequiresFilterReset(int i);

    protected abstract boolean upgradeRequiresSignout(int i);


}
