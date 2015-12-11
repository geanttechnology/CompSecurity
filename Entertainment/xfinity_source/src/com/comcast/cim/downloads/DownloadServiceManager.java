// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.downloads;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.httpcomponentsandroid.message.BasicHeader;
import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.UserManager;
import com.comcast.cim.model.user.service.UserSettings;
import com.comcast.cim.utils.JsonSerializer;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import com.penthera.virtuososdk.client.IDownloadedObserver;
import com.penthera.virtuososdk.client.IEngineObserver;
import com.penthera.virtuososdk.client.IFileFragment;
import com.penthera.virtuososdk.client.IQueueObserver;
import com.penthera.virtuososdk.client.IServiceConnectedCallback;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import com.penthera.virtuososdk.client.IVirtuosoIdentifier;
import com.penthera.virtuososdk.client.ServiceException;
import com.penthera.virtuososdk.client.Virtuoso;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.downloads:
//            DownloadServiceException, DownloadFile, DownloadFileFactory, DownloadServiceListener, 
//            DownloadMetaData

public class DownloadServiceManager
    implements com.comcast.cim.model.user.UserManager.UserManagerListener
{
    private abstract class UpdateDownloadableFileMapTask
        implements Runnable
    {

        private final List identifiers;
        final DownloadServiceManager this$0;
        private final Map uuidToFileMap;

        protected abstract void onFileMapRetrieved();

        public void run()
        {
            Object obj;
            HashSet hashset;
            obj = Sets.newHashSet();
            for (Iterator iterator = identifiers.iterator(); iterator.hasNext();)
            {
                Object obj1 = (IVirtuosoIdentifier)iterator.next();
                if (((IVirtuosoIdentifier) (obj1)).type() == 4)
                {
                    obj1 = (IVirtuosoAsset)obj1;
                    ((Set) (obj)).add(getDownloadFile(((IVirtuosoAsset) (obj1))));
                } else
                {
                    hasOldFiles = true;
                }
            }

            hashset = Sets.newHashSet();
            Map map = uuidToFileMap;
            map;
            JVM INSTR monitorenter ;
            ImmutableSet immutableset = ImmutableSet.copyOf(Sets.difference(Sets.newHashSet(uuidToFileMap.values()), ((Set) (obj))));
            Map map1 = pendingDeletes;
            map1;
            JVM INSTR monitorenter ;
            Iterator iterator2 = pendingDeletes.entrySet().iterator();
            do
            {
                if (!iterator2.hasNext())
                {
                    break;
                }
                Object obj2 = (java.util.Map.Entry)iterator2.next();
                DownloadFile downloadfile2 = (DownloadFile)((java.util.Map.Entry) (obj2)).getKey();
                obj2 = (CountDownLatch)((java.util.Map.Entry) (obj2)).getValue();
                if (immutableset.contains(downloadfile2))
                {
                    hashset.add(downloadfile2);
                    iterator2.remove();
                    ((CountDownLatch) (obj2)).countDown();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_234;
            obj;
            map1;
            JVM INSTR monitorexit ;
            throw obj;
            obj;
            map;
            JVM INSTR monitorexit ;
            throw obj;
            map1;
            JVM INSTR monitorexit ;
            uuidToFileMap.clear();
            DownloadFile downloadfile1;
            for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); uuidToFileMap.put(downloadfile1.getAsset().uuid(), downloadfile1))
            {
                downloadfile1 = (DownloadFile)((Iterator) (obj)).next();
            }

            map;
            JVM INSTR monitorexit ;
            DownloadFile downloadfile;
            for (Iterator iterator1 = hashset.iterator(); iterator1.hasNext(); onFileDeleted(downloadfile))
            {
                downloadfile = (DownloadFile)iterator1.next();
                DownloadServiceManager.LOG.debug("Calling onFileDeleted for {}", downloadfile);
            }

            onFileMapRetrieved();
            if (isFileListReady())
            {
                initializationLatch.countDown();
                onFileListUpdated();
            }
            return;
        }

        protected UpdateDownloadableFileMapTask(List list, Map map)
        {
            this$0 = DownloadServiceManager.this;
            super();
            identifiers = list;
            uuidToFileMap = map;
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/downloads/DownloadServiceManager);
    protected final Executor backgroundExecutor;
    protected final Context context;
    private final DownloadFileFactory downloadFileFactory;
    private final JsonSerializer downloadMetaDataSerializer;
    private final Map downloadsMap = Collections.synchronizedMap(new HashMap());
    private volatile boolean externalStorageAvailable;
    private BroadcastReceiver externalStorageReceiver;
    protected final Executor foregroundExecutor;
    private boolean hasOldFiles;
    private volatile boolean initialDownloadFilesMapRetrieved;
    private volatile boolean initialQueuedFilesMapRetrieved;
    private final CountDownLatch initializationLatch = new CountDownLatch(1);
    private final Set listeners = Collections.synchronizedSet(new HashSet());
    private boolean pauseCalled;
    private final Map pendingDeletes = new HashMap();
    private final Map queuedFilesMap = Collections.synchronizedMap(new HashMap());
    private boolean resumeCalled;
    protected final SharedPreferences sharedPreferences;
    private final UserManager userManager;
    private final IQueueObserver virtuosoDownloadQueueCallback = new IQueueObserver() {

        final DownloadServiceManager this$0;

        public void downloadEngineDidFinishDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.LOG.debug("Callback downloadEngineDidFinishDownloadingFile");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new Runnable() {

                    final _cls4 this$1;
                    final IVirtuosoAsset val$file;

                    public void run()
                    {
                        DownloadServiceManager.LOG.debug((new StringBuilder()).append("File Progress is : ").append(file.currentSize()).append(":").append(file.expectedSize()).append(", percent complete: ").append(file.fractionComplete()).toString());
                        DownloadFile downloadfile = getDownloadFile(file);
                        queuedFilesMap.put(file.uuid(), downloadfile);
                        onFileDownloadFinished(downloadfile);
                    }

            
            {
                this$1 = final__pcls4;
                file = IVirtuosoAsset.this;
                super();
            }
                });
            }
        }

        public void downloadEngineDidStartDownloadingFile(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.LOG.debug("Callback downloadEngineDidStartDownloadingFile");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new Runnable() {

                    final _cls4 this$1;
                    final IVirtuosoAsset val$file;

                    public void run()
                    {
                        DownloadFile downloadfile = getDownloadFile(file);
                        queuedFilesMap.put(file.uuid(), downloadfile);
                        onFileDownloadStarted(downloadfile);
                    }

            
            {
                this$1 = final__pcls4;
                file = IVirtuosoAsset.this;
                super();
            }
                });
            }
        }

        public void downloadEngineFileWithError(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.LOG.debug("Callback downloadEngineFileWithError");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new Runnable() {

                    final _cls4 this$1;
                    final IVirtuosoAsset val$file;

                    public void run()
                    {
                        DownloadFile downloadfile = getDownloadFile(file);
                        queuedFilesMap.put(file.uuid(), downloadfile);
                        onFileDownloadError(downloadfile);
                    }

            
            {
                this$1 = final__pcls4;
                file = IVirtuosoAsset.this;
                super();
            }
                });
            }
        }

        public void downloadEngineProgressUpdatedForFile(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.LOG.debug("Callback downloadEngineProgressUpdatedForFile");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new Runnable() {

                    final _cls4 this$1;
                    final IVirtuosoAsset val$file;

                    public void run()
                    {
                        DownloadFile downloadfile = getDownloadFile(file);
                        queuedFilesMap.put(file.uuid(), downloadfile);
                        onFileProgressUpdated(downloadfile);
                    }

            
            {
                this$1 = final__pcls4;
                file = IVirtuosoAsset.this;
                super();
            }
                });
            }
        }

        public void engineDownloadQueueChanged()
        {
            backgroundExecutor.execute(new UpdateDownloadableFileMapTask(virtuosoService.queuedRootList(), queuedFilesMap) {

                final _cls4 this$1;

                protected void onFileMapRetrieved()
                {
                    initialQueuedFilesMapRetrieved = true;
                }

            
            {
                this$1 = _cls4.this;
                super(list, map);
            }
            });
        }

        public void fragmentComplete(IVirtuosoIdentifier ivirtuosoidentifier)
        {
            DownloadServiceManager.LOG.debug("Callback downloadEngineProgressUpdatedForFile");
            if (ivirtuosoidentifier.type() == 4)
            {
                ivirtuosoidentifier = (IVirtuosoAsset)ivirtuosoidentifier;
                backgroundExecutor.execute(ivirtuosoidentifier. new Runnable() {

                    final _cls4 this$1;
                    final IVirtuosoAsset val$file;

                    public void run()
                    {
                        DownloadFile downloadfile = getDownloadFile(file);
                        queuedFilesMap.put(file.uuid(), downloadfile);
                        onFileProgressUpdated(downloadfile);
                    }

            
            {
                this$1 = final__pcls4;
                file = IVirtuosoAsset.this;
                super();
            }
                });
            }
        }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
    };
    private final IDownloadedObserver virtuosoDownloadedCallback = new IDownloadedObserver() {

        final DownloadServiceManager this$0;

        public void engineDownloadedListChanged()
        {
            backgroundExecutor.execute(new UpdateDownloadableFileMapTask(virtuosoService.downloadedRootList(), downloadsMap) {

                final _cls3 this$1;

                protected void onFileMapRetrieved()
                {
                    initialDownloadFilesMapRetrieved = true;
                }

            
            {
                this$1 = _cls3.this;
                super(list, map);
            }
            });
        }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
    };
    private IEngineObserver virtuosoEngineCallback;
    private final Virtuoso virtuosoService;
    private final LinkedHashMap volatileDownloadFileCache = new LinkedHashMap(10);
    private boolean waitingForPause;
    private boolean waitingForResume;

    public DownloadServiceManager(Application application, JsonSerializer jsonserializer, DownloadFileFactory downloadfilefactory, UserManager usermanager, Executor executor, Executor executor1, SharedPreferences sharedpreferences)
    {
        externalStorageAvailable = false;
        externalStorageReceiver = null;
        initialQueuedFilesMapRetrieved = false;
        initialDownloadFilesMapRetrieved = false;
        virtuosoEngineCallback = new IEngineObserver() {

            final DownloadServiceManager this$0;

            public void downloadEngineStatusDidChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
            {
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Callback downloadEngineStatusDidChange: ").append(ivirtuosodownloadenginestatus.status().name()).toString());
                onDownloadEngineStatusChanged(ivirtuosodownloadenginestatus);
            }

            public void settingChanged(int i)
            {
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        };
        context = application;
        downloadMetaDataSerializer = jsonserializer;
        downloadFileFactory = downloadfilefactory;
        userManager = usermanager;
        backgroundExecutor = executor;
        foregroundExecutor = executor1;
        sharedPreferences = sharedpreferences;
        virtuosoService = new Virtuoso(application, new IServiceConnectedCallback() {

            final DownloadServiceManager this$0;

            public void connected()
            {
                DownloadServiceManager.LOG.debug("Initial connection to virtuoso service established");
                Object obj;
                try
                {
                    setupServiceSettings();
                    fetchFileList();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    DownloadServiceManager.LOG.error("ServiceException while setting up in connected() callback", ((Throwable) (obj)));
                    return;
                }
                DownloadServiceManager.LOG.debug("Service settings setup & fetchFileList called");
                onDownloadServiceConnected();
                userManager.addUserManagerListener(DownloadServiceManager.this);
                obj = userManager.getUser();
                if (obj == null)
                {
                    onUserLoggedOut();
                } else
                {
                    onUserLoggedIn(((User) (obj)), userManager.getUserSettings());
                }
                startWatchingExternalStorage();
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        });
        virtuosoService.addDownloadedObserver(virtuosoDownloadedCallback);
        virtuosoService.addQueueObserver(virtuosoDownloadQueueCallback);
        virtuosoService.addEngineObserver(virtuosoEngineCallback);
        virtuosoService.onResume();
    }

    private void configureHttpSettings()
    {
        this;
        JVM INSTR monitorenter ;
        BasicHeader basicheader = CALContainer.getInstance().getDownloadUserAgent();
        Bundle bundle = new Bundle();
        bundle.putString(basicheader.getName(), basicheader.getValue());
        configureService(bundle, 10000, 30000);
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        throw new RuntimeException(((Throwable) (obj)));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    private void fetchFileList()
        throws ServiceException
    {
        backgroundExecutor.execute(new UpdateDownloadableFileMapTask(virtuosoService.downloadedRootList(), downloadsMap) {

            final DownloadServiceManager this$0;

            protected void onFileMapRetrieved()
            {
                initialDownloadFilesMapRetrieved = true;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super(list, map);
            }
        });
        backgroundExecutor.execute(new UpdateDownloadableFileMapTask(virtuosoService.queuedRootList(), queuedFilesMap) {

            final DownloadServiceManager this$0;

            protected void onFileMapRetrieved()
            {
                initialQueuedFilesMapRetrieved = true;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super(list, map);
            }
        });
    }

    private void forceRetryDownloads()
    {
        try
        {
            virtuosoService.overrideBatteryThreshold(0.13999999999999999D);
            virtuosoService.overrideBatteryThreshold(0.14999999999999999D);
            return;
        }
        catch (ServiceException serviceexception)
        {
            LOG.error("Failed to trigger downloads", serviceexception);
        }
    }

    private DownloadFile getDownloadFile(IVirtuosoAsset ivirtuosoasset)
    {
        String s = ivirtuosoasset.uuid();
        LinkedHashMap linkedhashmap = volatileDownloadFileCache;
        linkedhashmap;
        JVM INSTR monitorenter ;
        DownloadFile downloadfile = (DownloadFile)volatileDownloadFileCache.get(s);
        if (downloadfile != null) goto _L2; else goto _L1
_L1:
        ivirtuosoasset = downloadFileFactory.create(ivirtuosoasset);
        volatileDownloadFileCache.put(s, ivirtuosoasset);
_L3:
        linkedhashmap;
        JVM INSTR monitorexit ;
        return ivirtuosoasset;
_L2:
        downloadfile.setAsset(ivirtuosoasset);
        ivirtuosoasset = downloadfile;
          goto _L3
        ivirtuosoasset;
        linkedhashmap;
        JVM INSTR monitorexit ;
        throw ivirtuosoasset;
    }

    private void handleDownloadEngineStatusChange(IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus)
    {
        this;
        JVM INSTR monitorenter ;
        if (ivirtuosodownloadenginestatus.status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused) goto _L2; else goto _L1
_L1:
        waitingForPause = false;
        if (resumeCalled)
        {
            resumeDownloading();
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        try
        {
            waitingForResume = false;
            if (pauseCalled)
            {
                pauseDownloading();
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus) { }
        finally
        {
            this;
        }
        LOG.error("Pause/Resume Error", ivirtuosodownloadenginestatus);
        if (true) goto _L4; else goto _L3
_L3:
        throw ivirtuosodownloadenginestatus;
    }

    private void resetFilesWithSDCardError()
    {
        Iterator iterator = getFilesList().iterator();
_L2:
        Object obj;
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (DownloadFile)iterator.next();
        obj = ((DownloadFile) (obj1)).getAsset();
        com.penthera.virtuososdk.Common.EFileDownloadStatus efiledownloadstatus = ((IVirtuosoAsset) (obj)).downloadStatus();
        if (efiledownloadstatus != com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Corrupt && (efiledownloadstatus != com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error || ((IVirtuosoAsset) (obj)).currentSize() != 0.0D))
        {
            continue; /* Loop/switch isn't completed */
        }
        ArrayList arraylist;
        obj1 = virtuosoService.virtuosoHLSFile(((IVirtuosoAsset) (obj)).assetURL(), downloadMetaDataSerializer.serialize(((DownloadFile) (obj1)).getDownloadMetaData()));
        Object obj2 = ((IVirtuosoHLSFile)obj).fragments();
        arraylist = new ArrayList(((List) (obj2)).size());
        for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); arraylist.add(((IFileFragment)((Iterator) (obj2)).next()).remotePath())) { }
        try
        {
            ((IVirtuosoHLSFile)obj1).addFragments(arraylist);
            virtuosoService.delete(((IVirtuosoIdentifier) (obj)));
            virtuosoService.addToQueue(((IVirtuosoIdentifier) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            LOG.error("Failed to fix corrupted file!  User removal will be required at this point...");
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void setupServiceSettings()
        throws ServiceException
    {
        configureHttpSettings();
        virtuosoService.overrideHeadroom(50D);
        virtuosoService.overrideBatteryThreshold(0.14999999999999999D);
        virtuosoService.overrideMaxStorageAllowed(-1D);
    }

    private void startWatchingExternalStorage()
    {
        externalStorageReceiver = new BroadcastReceiver() {

            final DownloadServiceManager this$0;

            public void onReceive(Context context1, Intent intent)
            {
                if (isExternalStorageConnected())
                {
                    if (!externalStorageAvailable)
                    {
                        externalStorageAvailable = true;
                        backgroundExecutor.execute(new Runnable() {

                            final _cls15 this$1;

                            public void run()
                            {
                                try
                                {
                                    Thread.sleep(5000L);
                                    if (externalStorageAvailable)
                                    {
                                        resetFilesWithSDCardError();
                                        forceRetryDownloads();
                                    }
                                    return;
                                }
                                catch (InterruptedException interruptedexception)
                                {
                                    return;
                                }
                            }

            
            {
                this$1 = _cls15.this;
                super();
            }
                        });
                    }
                    return;
                } else
                {
                    externalStorageAvailable = false;
                    return;
                }
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentfilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentfilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentfilter.addDataScheme("file");
        context.registerReceiver(externalStorageReceiver, intentfilter);
        externalStorageAvailable = isExternalStorageConnected();
    }

    public void addDownloadServiceListener(DownloadServiceListener downloadservicelistener)
    {
        listeners.add(downloadservicelistener);
    }

    public void configureService(Bundle bundle, int i, int j)
        throws DownloadServiceException
    {
        try
        {
            virtuosoService.configure(bundle, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            throw new DownloadServiceException("Download Service failed to configure Http Connection", bundle);
        }
    }

    protected IVirtuosoHLSFile createHlsFile(List list, String s, DownloadMetaData downloadmetadata)
        throws ServiceException
    {
        Validate.notNull(list);
        Validate.notNull(s);
        Validate.notNull(downloadmetadata);
        s = virtuosoService.virtuosoHLSFile(s, downloadMetaDataSerializer.serialize(downloadmetadata));
        s.addFragments(list);
        return s;
    }

    public Map deleteAllContent()
        throws DownloadServiceException
    {
        return deleteFiles(getFilesList());
    }

    public void deleteAllContentForUpgrade()
        throws DownloadServiceException
    {
        try
        {
            virtuosoService.deleteAllFiles();
            return;
        }
        catch (ServiceException serviceexception)
        {
            LOG.error("Failed to clear out the downloads file list", serviceexception);
            throw new DownloadServiceException(serviceexception);
        }
    }

    public Map deleteFile(DownloadFile downloadfile)
        throws DownloadServiceException
    {
        return deleteFiles(CollectionUtils.createList(downloadfile));
    }

    public Map deleteFiles(final List files)
        throws DownloadServiceException
    {
        HashMap hashmap = Maps.newHashMap();
        Map map = pendingDeletes;
        map;
        JVM INSTR monitorenter ;
        DownloadFile downloadfile;
        CountDownLatch countdownlatch;
        for (Iterator iterator = files.iterator(); iterator.hasNext(); hashmap.put(downloadfile, countdownlatch))
        {
            downloadfile = (DownloadFile)iterator.next();
            countdownlatch = new CountDownLatch(1);
            pendingDeletes.put(downloadfile, countdownlatch);
        }

        break MISSING_BLOCK_LABEL_84;
        files;
        map;
        JVM INSTR monitorexit ;
        throw files;
        map;
        JVM INSTR monitorexit ;
        backgroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final List val$files;

            public void run()
            {
                Iterator iterator1 = files.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    Object obj = (DownloadFile)iterator1.next();
                    try
                    {
                        virtuosoService.delete(((DownloadFile) (obj)).getAsset());
                    }
                    catch (ServiceException serviceexception)
                    {
                        synchronized (pendingDeletes)
                        {
                            obj = (CountDownLatch)pendingDeletes.remove(obj);
                        }
                        if (obj != null)
                        {
                            ((CountDownLatch) (obj)).countDown();
                        }
                    }
                } while (true);
                break MISSING_BLOCK_LABEL_92;
                exception;
                map1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                files = list;
                super();
            }
        });
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator1 = listeners.iterator(); iterator1.hasNext(); ((DownloadServiceListener)iterator1.next()).onFileListUpdated()) { }
                break MISSING_BLOCK_LABEL_54;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        });
        return hashmap;
    }

    protected void deleteUnusedHlsFile(IVirtuosoHLSFile ivirtuosohlsfile)
    {
        Validate.notNull(ivirtuosohlsfile);
        try
        {
            virtuosoService.delete(ivirtuosohlsfile);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (IVirtuosoHLSFile ivirtuosohlsfile)
        {
            LOG.error("Failed to delete Unused Virtuoso HLS file", ivirtuosohlsfile);
        }
    }

    protected void downloadHlsFileWithMetadata(final String assetId, final HlsSimplePlaylist simplePlaylist, final HlsVariantPlaylist variantPlaylist, final HlsSimplePlaylist alternateAudioPlaylist, final DownloadMetaData metaData, final Runnable extraTask, final FutureCallback resultCallback)
        throws DownloadServiceException
    {
        backgroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final HlsSimplePlaylist val$alternateAudioPlaylist;
            final String val$assetId;
            final Runnable val$extraTask;
            final DownloadMetaData val$metaData;
            final FutureCallback val$resultCallback;
            final HlsSimplePlaylist val$simplePlaylist;
            final HlsVariantPlaylist val$variantPlaylist;

            public void run()
            {
                Object obj;
                StopWatch stopwatch;
                Object obj1;
                Object obj2;
                try
                {
                    stopwatch = new StopWatch();
                    stopwatch.start();
                    obj1 = simplePlaylist.getRelativeSequencePaths();
                    obj = Lists.newArrayList();
                    if (alternateAudioPlaylist != null)
                    {
                        obj = alternateAudioPlaylist.getRelativeSequencePaths();
                    }
                    obj2 = new ArrayList(((List) (obj1)).size() + ((List) (obj)).size());
                    com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment2;
                    for (Iterator iterator = ((List) (obj1)).iterator(); iterator.hasNext(); ((List) (obj2)).add((new StringBuilder()).append(simplePlaylist.getUrlPathPrefix()).append(sequencesegment2.getPath()).toString()))
                    {
                        sequencesegment2 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)iterator.next();
                    }

                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    resultCallback.onFailure(new DownloadServiceException(((Throwable) (obj))));
                    return;
                }
                com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment3;
                for (Iterator iterator1 = ((List) (obj)).iterator(); iterator1.hasNext(); ((List) (obj2)).add((new StringBuilder()).append(alternateAudioPlaylist.getUrlPathPrefix()).append(sequencesegment3.getPath()).toString()))
                {
                    sequencesegment3 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)iterator1.next();
                }

                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Added ").append(((List) (obj1)).size()).append(" segments").toString());
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Added ").append(((List) (obj)).size()).append(" audio segments").toString());
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Created full path list in ").append(stopwatch).append(" seconds").toString());
                stopwatch.reset();
                stopwatch.start();
                obj = createHlsFile(((List) (obj2)), assetId, metaData);
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Created Virtuoso File in ").append(stopwatch).append(" seconds").toString());
                stopwatch.reset();
                stopwatch.start();
                obj2 = variantPlaylist.getMediaProfiles();
                obj1 = Lists.newArrayList();
                com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile mediaprofile;
                for (obj2 = ((List) (obj2)).iterator(); ((Iterator) (obj2)).hasNext(); ((List) (obj1)).add(mediaprofile))
                {
                    mediaprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaProfile)((Iterator) (obj2)).next();
                    mediaprofile.setRelativePath("simple.m3u8");
                }

                variantPlaylist.setMediaProfiles(((List) (obj1)));
                Object obj3 = variantPlaylist.getAudioProfiles();
                obj1 = Lists.newArrayList();
                com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile mediaaudioprofile;
                for (obj3 = ((List) (obj3)).iterator(); ((Iterator) (obj3)).hasNext(); ((List) (obj1)).add(mediaaudioprofile))
                {
                    mediaaudioprofile = (com.comcast.cim.cmasl.hls.HlsVariantPlaylist.MediaAudioProfile)((Iterator) (obj3)).next();
                    if (mediaaudioprofile.getUriString() != null)
                    {
                        mediaaudioprofile.setUriString("\"audio.m3u8\"");
                    }
                }

                variantPlaylist.setAudioProfiles(((List) (obj1)));
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Manipulated Variant Playlist in ").append(stopwatch).append(" seconds").toString());
                stopwatch.reset();
                stopwatch.start();
                Object obj4 = simplePlaylist.getRelativeSequencePaths();
                obj1 = new ArrayList(((List) (obj4)).size());
                com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment;
                for (obj4 = ((List) (obj4)).iterator(); ((Iterator) (obj4)).hasNext(); ((List) (obj1)).add(sequencesegment))
                {
                    sequencesegment = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)((Iterator) (obj4)).next();
                    String s = sequencesegment.getPath();
                    if (s.lastIndexOf('/') != -1)
                    {
                        sequencesegment.setPath(s.substring(s.lastIndexOf('/') + 1));
                    }
                }

                simplePlaylist.setSequencePaths(((List) (obj1)));
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Manipulated Simple Playlist in ").append(stopwatch).append(" seconds").toString());
                if (alternateAudioPlaylist == null)
                {
                    break MISSING_BLOCK_LABEL_903;
                }
                stopwatch.reset();
                stopwatch.start();
                Object obj5 = alternateAudioPlaylist.getRelativeSequencePaths();
                obj1 = new ArrayList(((List) (obj5)).size());
                com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment sequencesegment1;
                for (obj5 = ((List) (obj5)).iterator(); ((Iterator) (obj5)).hasNext(); ((List) (obj1)).add(sequencesegment1))
                {
                    sequencesegment1 = (com.comcast.cim.cmasl.hls.HlsSimplePlaylist.SequenceSegment)((Iterator) (obj5)).next();
                    String s1 = sequencesegment1.getPath();
                    if (s1.lastIndexOf('/') != -1)
                    {
                        sequencesegment1.setPath(s1.substring(s1.lastIndexOf('/') + 1));
                    }
                }

                alternateAudioPlaylist.setSequencePaths(((List) (obj1)));
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Manipulated Alternate Audio Playlist in ").append(stopwatch).append(" seconds").toString());
                stopwatch.reset();
                stopwatch.start();
                obj1 = ((IVirtuosoHLSFile) (obj)).localBaseDir();
                variantPlaylist.writeToFile(new File(((String) (obj1)), "variant.m3u8"));
                simplePlaylist.writeToFile(new File(((String) (obj1)), "simple.m3u8"));
                if (alternateAudioPlaylist != null)
                {
                    alternateAudioPlaylist.writeToFile(new File(((String) (obj1)), "audio.m3u8"));
                }
                stopwatch.stop();
                DownloadServiceManager.LOG.debug((new StringBuilder()).append("Saved Variant & Simple Playlists to disk in ").append(stopwatch).append("seconds").toString());
                foregroundExecutor.execute(((_cls1) (obj)). new Runnable() {

                    final _cls18 this$1;
                    final IVirtuosoHLSFile val$hlsFile;

                    public void run()
                    {
                        StopWatch stopwatch;
                        stopwatch = new StopWatch();
                        stopwatch.reset();
                        stopwatch.start();
                        virtuosoService.addToQueue(hlsFile);
                        try
                        {
                            if (extraTask != null)
                            {
                                extraTask.run();
                            }
                        }
                        catch (Exception exception)
                        {
                            try
                            {
                                throw new ServiceException(exception);
                            }
                            catch (ServiceException serviceexception)
                            {
                                resultCallback.onFailure(new DownloadServiceException(serviceexception));
                            }
                            return;
                        }
                        stopwatch.stop();
                        DownloadServiceManager.LOG.debug((new StringBuilder()).append("Added Virtuoso File to download Queue in ").append(stopwatch).append(" seconds").toString());
                        resultCallback.onSuccess(null);
                        return;
                    }

            
            {
                this$1 = final__pcls18;
                hlsFile = IVirtuosoHLSFile.this;
                super();
            }
                });
                return;
                IOException ioexception;
                ioexception;
                deleteUnusedHlsFile(((IVirtuosoHLSFile) (obj)));
                throw new ServiceException("Failed to write playlist files", ioexception);
            }

            
            {
                this$0 = DownloadServiceManager.this;
                simplePlaylist = hlssimpleplaylist;
                alternateAudioPlaylist = hlssimpleplaylist1;
                assetId = s;
                metaData = downloadmetadata;
                variantPlaylist = hlsvariantplaylist;
                extraTask = runnable;
                resultCallback = futurecallback;
                super();
            }
        });
    }

    public void expireFile(DownloadFile downloadfile)
        throws DownloadServiceException
    {
        try
        {
            virtuosoService.expire(downloadfile.getAsset());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DownloadFile downloadfile)
        {
            throw new DownloadServiceException("Download Service failed to expire file.", downloadfile);
        }
    }

    public IVirtuosoDownloadEngineStatus getDownloadEngineStatus()
        throws DownloadServiceException
    {
        IVirtuosoDownloadEngineStatus ivirtuosodownloadenginestatus;
        try
        {
            ivirtuosodownloadenginestatus = virtuosoService.status();
        }
        catch (ServiceException serviceexception)
        {
            throw new DownloadServiceException("Download Service failed to return Engine Status", serviceexception);
        }
        return ivirtuosodownloadenginestatus;
    }

    public List getDownloadedFileList()
    {
        Map map = downloadsMap;
        map;
        JVM INSTR monitorenter ;
        Object obj1;
        obj1 = new ArrayList(downloadsMap.size());
        ((List) (obj1)).addAll(downloadsMap.values());
        Object obj = pendingDeletes;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = pendingDeletes.keySet().iterator(); iterator.hasNext(); ((List) (obj1)).remove((DownloadFile)iterator.next())) { }
        break MISSING_BLOCK_LABEL_103;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj1));
    }

    public List getFilesList()
    {
        Map map = queuedFilesMap;
        map;
        JVM INSTR monitorenter ;
        Object obj = downloadsMap;
        obj;
        JVM INSTR monitorenter ;
        Object obj2;
        obj2 = new ArrayList(downloadsMap.size() + queuedFilesMap.size());
        ((List) (obj2)).addAll(queuedFilesMap.values());
        ((List) (obj2)).addAll(downloadsMap.values());
        Object obj1 = pendingDeletes;
        obj1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = pendingDeletes.keySet().iterator(); iterator.hasNext(); ((List) (obj2)).remove((DownloadFile)iterator.next())) { }
        break MISSING_BLOCK_LABEL_147;
        obj2;
        obj1;
        JVM INSTR monitorexit ;
        throw obj2;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        obj1;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj2));
    }

    public boolean hasOldFiles()
    {
        return hasOldFiles;
    }

    public boolean isExternalStorageConnected()
    {
        File file = Environment.getExternalStorageDirectory();
        return file != null && file.canWrite();
    }

    public boolean isFileListReady()
    {
        return initialQueuedFilesMapRetrieved && initialDownloadFilesMapRetrieved;
    }

    protected void onDownloadEngineStatusChanged(final IVirtuosoDownloadEngineStatus status)
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final IVirtuosoDownloadEngineStatus val$status;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onDownloadEngineStatusChanged(status)) { }
                break MISSING_BLOCK_LABEL_58;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                status = ivirtuosodownloadenginestatus;
                super();
            }
        });
        handleDownloadEngineStatusChange(status);
    }

    protected void onDownloadServiceConnected()
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onDownloadServiceConnected()) { }
                break MISSING_BLOCK_LABEL_54;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        });
    }

    protected void onFileDeleted(DownloadFile downloadfile)
    {
        synchronized (volatileDownloadFileCache)
        {
            volatileDownloadFileCache.remove(downloadfile.getAsset().uuid());
        }
        return;
        downloadfile;
        linkedhashmap;
        JVM INSTR monitorexit ;
        throw downloadfile;
    }

    protected void onFileDownloadError(final DownloadFile file)
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final DownloadFile val$file;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileDownloadError(file)) { }
                break MISSING_BLOCK_LABEL_58;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                file = downloadfile;
                super();
            }
        });
    }

    protected void onFileDownloadFinished(final DownloadFile file)
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final DownloadFile val$file;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileDownloadFinished(file)) { }
                break MISSING_BLOCK_LABEL_58;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                file = downloadfile;
                super();
            }
        });
    }

    protected void onFileDownloadStarted(final DownloadFile file)
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final DownloadFile val$file;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileDownloadStarted(file)) { }
                break MISSING_BLOCK_LABEL_58;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                file = downloadfile;
                super();
            }
        });
    }

    protected void onFileListUpdated()
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileListUpdated()) { }
                break MISSING_BLOCK_LABEL_54;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                super();
            }
        });
    }

    protected void onFileProgressUpdated(final DownloadFile file)
    {
        foregroundExecutor.execute(new Runnable() {

            final DownloadServiceManager this$0;
            final DownloadFile val$file;

            public void run()
            {
                Set set = listeners;
                set;
                JVM INSTR monitorenter ;
                for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((DownloadServiceListener)iterator.next()).onFileProgressUpdated(file)) { }
                break MISSING_BLOCK_LABEL_58;
                Exception exception;
                exception;
                set;
                JVM INSTR monitorexit ;
                throw exception;
                set;
                JVM INSTR monitorexit ;
            }

            
            {
                this$0 = DownloadServiceManager.this;
                file = downloadfile;
                super();
            }
        });
    }

    public void onUserChanged(User user, UserSettings usersettings)
    {
    }

    public void onUserLoaded(User user, UserSettings usersettings)
    {
    }

    public void onUserLoggedIn(User user, UserSettings usersettings)
    {
        try
        {
            if (sharedPreferences.contains("PausedBySignout"))
            {
                LOG.debug("Signed into the app, resuming downloads!");
                resumeDownloading();
                user = sharedPreferences.edit();
                user.remove("PausedBySignout");
                user.commit();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (User user)
        {
            LOG.error("Failed to Resume Downloading for Sign-In!");
        }
    }

    public void onUserLoggedOut()
    {
        LOG.debug("onUserLoggedOut");
        try
        {
            if (getDownloadEngineStatus().status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused)
            {
                LOG.debug("Signed Out of the app, pausing downloads!");
                pauseDownloading();
                android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("PausedBySignout", true);
                editor.commit();
            }
            return;
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            LOG.error("Failed to Pause Downloading for Sign-Out!");
        }
    }

    public void pauseDownloading()
        throws DownloadServiceException
    {
        this;
        JVM INSTR monitorenter ;
        if (!waitingForResume) goto _L2; else goto _L1
_L1:
        pauseCalled = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        pauseCalled = false;
        if (!waitingForPause)
        {
            virtuosoService.pauseDownloads();
            waitingForPause = true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        throw new DownloadServiceException("Download Service failed to pause downloading.", ((Throwable) (obj)));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void removeDownloadServiceListener(DownloadServiceListener downloadservicelistener)
    {
        listeners.remove(downloadservicelistener);
    }

    public void resumeDownloading()
        throws DownloadServiceException
    {
        this;
        JVM INSTR monitorenter ;
        if (!waitingForPause) goto _L2; else goto _L1
_L1:
        resumeCalled = true;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        resumeCalled = false;
        if (!waitingForResume)
        {
            waitingForResume = true;
            virtuosoService.resumeDownloads();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        throw new DownloadServiceException("Download Service failed to resume downloading.", ((Throwable) (obj)));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void setCellularDataThreshold(double d)
        throws DownloadServiceException
    {
        try
        {
            virtuosoService.overrideCellularDataQuota(d);
            return;
        }
        catch (ServiceException serviceexception)
        {
            throw new DownloadServiceException("Download Service failed to change Cellular Data Setting", serviceexception);
        }
    }

    public void showCrashDialog(Context context1, final Exception e)
    {
        Resources resources = context1.getResources();
        (new android.app.AlertDialog.Builder(context1)).setTitle(resources.getString(com.comcast.cim.android.R.string.download_service_restart_title)).setMessage(resources.getString(com.comcast.cim.android.R.string.download_service_restart_message)).setPositiveButton(context1.getString(com.comcast.cim.android.R.string.dlg_btn_ok), new android.content.DialogInterface.OnClickListener() {

            final DownloadServiceManager this$0;
            final Exception val$e;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                throw new RuntimeException(e);
            }

            
            {
                this$0 = DownloadServiceManager.this;
                e = exception;
                super();
            }
        }).setCancelable(false).show();
    }

    public void startDownloadImmediately(DownloadFile downloadfile)
        throws DownloadServiceException
    {
        try
        {
            virtuosoService.move(downloadfile.getAsset(), 0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DownloadFile downloadfile)
        {
            throw new DownloadServiceException("Download Service failed to move the file to the top of the queue.", downloadfile);
        }
    }

    public void updateFileMetadata(DownloadFile downloadfile)
    {
        IVirtuosoAsset ivirtuosoasset = downloadfile.getAsset();
        ivirtuosoasset.setMetadata(downloadMetaDataSerializer.serialize(downloadfile.getDownloadMetaData()));
        virtuosoService.update(ivirtuosoasset);
    }

    public void waitForInitialization(long l)
        throws DownloadServiceException
    {
        boolean flag = false;
        boolean flag1 = initializationLatch.await(l, TimeUnit.MILLISECONDS);
        flag = flag1;
_L2:
        if (!flag)
        {
            throw new DownloadServiceException("Service connection failed");
        } else
        {
            return;
        }
        InterruptedException interruptedexception;
        interruptedexception;
        if (true) goto _L2; else goto _L1
_L1:
    }





/*
    static boolean access$1002(DownloadServiceManager downloadservicemanager, boolean flag)
    {
        downloadservicemanager.initialQueuedFilesMapRetrieved = flag;
        return flag;
    }

*/





/*
    static boolean access$1302(DownloadServiceManager downloadservicemanager, boolean flag)
    {
        downloadservicemanager.externalStorageAvailable = flag;
        return flag;
    }

*/




/*
    static boolean access$1602(DownloadServiceManager downloadservicemanager, boolean flag)
    {
        downloadservicemanager.hasOldFiles = flag;
        return flag;
    }

*/








/*
    static boolean access$702(DownloadServiceManager downloadservicemanager, boolean flag)
    {
        downloadservicemanager.initialDownloadFilesMapRetrieved = flag;
        return flag;
    }

*/


}
