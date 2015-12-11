// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.DomainContext;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayAppInfo;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfiguration, DcsState, DcsNautilusBoolean, DcsProperty

final class DeviceConfigurationManager extends DeviceConfiguration
{
    private static final class Observable extends DataSetObservable
        implements Runnable
    {

        static final Handler handler = new Handler(Looper.getMainLooper());

        public void notifyChanged()
        {
            handler.post(this);
        }

        public void run()
        {
            super.notifyChanged();
        }


        private Observable()
        {
        }

    }

    private static final class Properties
    {

        private static final int MAX_RETRIES = 3;
        volatile boolean isStale;
        volatile long lastSynced;
        volatile Map properties;
        private volatile int retryCount;
        final Object syncLock;
        boolean waitingForSync;

        private static boolean isEqual(Map map, Map map1)
        {
            boolean flag1 = false;
            if (map != null) goto _L2; else goto _L1
_L1:
            boolean flag;
            if (map1 == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L4:
            return flag;
_L2:
            flag = flag1;
            if (map1 != null)
            {
                flag = flag1;
                if (map.size() == map1.size())
                {
                    map = map.entrySet().iterator();
label0:
                    do
                    {
label1:
                        {
                            if (!map.hasNext())
                            {
                                break label1;
                            }
                            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                            String s = (String)entry.getKey();
                            flag = flag1;
                            if (!map1.containsKey(s))
                            {
                                continue;
                            }
                            if (!TextUtils.equals((CharSequence)entry.getValue(), (CharSequence)map1.get(s)))
                            {
                                return false;
                            }
                        }
                    } while (true);
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
            return true;
        }

        private void resetRefreshes(boolean flag)
        {
            lastSynced = System.currentTimeMillis();
            retryCount = 0;
            isStale = flag;
        }

        final void load(Context context1)
        {
            File file;
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                DeviceConfigurationManager.verboseLogger.log("loadConfig() called.");
            }
            file = DeviceConfigurationManager.getConfigFile(context1);
            if (DeviceConfigurationManager.debugLogger.isLoggable)
            {
                DeviceConfigurationManager.debugLogger.log((new StringBuilder()).append("Trying to load configuration from ").append(file.getAbsolutePath()).toString());
            }
            if (!file.exists()) goto _L2; else goto _L1
_L1:
            if (file.isFile()) goto _L4; else goto _L3
_L3:
            if (DeviceConfigurationManager.debugLogger.isLoggable)
            {
                DeviceConfigurationManager.debugLogger.log((new StringBuilder()).append("Not a file: ").append(file.getAbsolutePath()).toString());
            }
            file.delete();
_L8:
            return;
_L4:
            String s;
            long l;
            l = file.lastModified();
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                DeviceConfigurationManager.verboseLogger.log(DeviceConfigurationManager.appendTimespan((new StringBuilder()).append("File is "), System.currentTimeMillis() - l).append(" old.").toString());
            }
            s = NautilusKernel.getAppVersionWithoutBuildNumber(context1);
            ObjectInputStream objectinputstream = new ObjectInputStream(new FileInputStream(file));
            Object obj;
            boolean flag;
            flag = false;
            obj = null;
            String s1 = (String)objectinputstream.readObject();
            if (!TextUtils.equals(s, s1)) goto _L6; else goto _L5
_L5:
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                DeviceConfigurationManager.verboseLogger.log("Configuration file version matches.");
            }
            context1 = (HashMap)objectinputstream.readObject();
            lastSynced = l;
_L10:
            objectinputstream.close();
            if (!flag)
            {
                continue; /* Loop/switch isn't completed */
            }
            file.delete();
            if (context1 == null) goto _L8; else goto _L7
_L7:
            boolean flag1;
            try
            {
                properties = Collections.unmodifiableMap(context1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                DeviceConfigurationManager.debugLogger.logAsError("Faild to load!", context1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context1) { }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                if (DeviceConfigurationManager.debugLogger.isLoggable)
                {
                    DeviceConfigurationManager.debugLogger.logAsError("Failed to load configuration", context1);
                }
                file.delete();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            flag1 = true;
            flag = flag1;
            context1 = obj;
            if (!DeviceConfigurationManager.debugLogger.isLoggable) goto _L10; else goto _L9
_L9:
            DeviceConfigurationManager.debugLogger.log((new StringBuilder()).append("Configuration file version doesn't match. Expecting version: ").append(s).append(" found version: ").append(s1).append(". Deleting file:").append(file.getName()).toString());
            flag = flag1;
            context1 = obj;
              goto _L10
            context1;
            objectinputstream.close();
            throw context1;
            if (!DeviceConfigurationManager.debugLogger.isLoggable) goto _L8; else goto _L11
_L11:
            DeviceConfigurationManager.debugLogger.logAsWarning("Caught IOException. Probably cross-process file access sync problem.");
            return;
_L2:
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                DeviceConfigurationManager.verboseLogger.log((new StringBuilder()).append("Load configuration failed: Configuration file: ").append(file.getName()).append(" not found").toString());
                return;
            }
            if (true) goto _L8; else goto _L12
_L12:
        }

        final boolean needsUpdate()
        {
            boolean flag;
            if (lastSynced + 0x493e0L < System.currentTimeMillis())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                StringBuilder stringbuilder = new StringBuilder();
                stringbuilder.append("Threshold: ");
                if (0x493e0L <= 0L)
                {
                    stringbuilder.append(0x493e0L);
                } else
                {
                    DeviceConfigurationManager.appendTimespan(stringbuilder, 0x493e0L);
                }
                stringbuilder.append(", thread: ");
                if (Looper.getMainLooper() == Looper.myLooper())
                {
                    stringbuilder.append("main");
                } else
                {
                    stringbuilder.append(Thread.currentThread());
                }
                stringbuilder.append(", is stale: ").append(flag);
                DeviceConfigurationManager.verboseLogger.log(stringbuilder.toString());
            }
            return flag;
        }

        final boolean sync(Context context1, EbayContext ebaycontext)
        {
            boolean flag3;
            boolean flag4;
            boolean flag5;
            flag4 = false;
            flag5 = false;
            flag3 = false;
            if (DeviceConfigurationManager.verboseLogger.isLoggable)
            {
                DeviceConfigurationManager.verboseLogger.log("sync() called");
            }
            if (!NetworkUtil.hasConnectedNetwork(context1)) goto _L2; else goto _L1
_L1:
            boolean flag;
            retryCount = retryCount + 1;
            String s = ebaycontext.getAppInfo().getAppVersionWithoutBuildNumber();
            if (DeviceConfigurationManager.debugLogger.isLoggable)
            {
                DeviceConfigurationManager.debugLogger.log((new StringBuilder()).append("requesting configuration, version=").append(s).toString());
            }
            Object obj = new com.ebay.nautilus.domain.net.api.dcs.EbayDcsGetConfiguration.GetConfigurationRequest(DeviceConfiguration.getNoSync().getDefault(ApiSettings.dcs), "", EbaySite.US);
            boolean flag1 = flag4;
            boolean flag2 = flag5;
            try
            {
                ebaycontext = (com.ebay.nautilus.domain.net.api.dcs.EbayDcsGetConfiguration.GetConfigurationResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, ((com.ebay.nautilus.kernel.net.Request) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                DeviceConfigurationManager.debugLogger.logAsError("get device configuration request failed", context1);
                flag = flag1;
                continue; /* Loop/switch isn't completed */
            }
            // Misplaced declaration of an exception variable
            catch (Context context1)
            {
                flag = flag2;
                if (DeviceConfigurationManager.verboseLogger.isLoggable)
                {
                    DeviceConfigurationManager.verboseLogger.logAsWarning("get device configuration request was interrupted.", context1);
                    flag = flag2;
                }
                continue; /* Loop/switch isn't completed */
            }
            flag = flag3;
            flag1 = flag4;
            flag2 = flag5;
            if (!ebaycontext.isSuccessful())
            {
                break MISSING_BLOCK_LABEL_275;
            }
            flag1 = flag4;
            flag2 = flag5;
            obj = ((com.ebay.nautilus.domain.net.api.dcs.EbayDcsGetConfiguration.GetConfigurationResponse) (ebaycontext)).properties;
            flag1 = flag4;
            flag2 = flag5;
            ((HashMap) (obj)).put("meta.app.version", s);
            flag1 = flag4;
            flag2 = flag5;
            ((HashMap) (obj)).put("meta.config.version", ((com.ebay.nautilus.domain.net.api.dcs.EbayDcsGetConfiguration.GetConfigurationResponse) (ebaycontext)).configVersion);
            flag1 = flag4;
            flag2 = flag5;
            if (!isEqual(properties, ((Map) (obj))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_248;
            }
            flag1 = flag;
            flag2 = flag;
            properties = Collections.unmodifiableMap(((Map) (obj)));
            flag1 = flag;
            flag2 = flag;
            DeviceConfigurationManager.saveConfig(context1, ((HashMap) (obj)));
            flag1 = flag;
            flag2 = flag;
            resetRefreshes(false);
_L4:
            if (retryCount >= 3)
            {
                resetRefreshes(true);
            }
            return flag;
_L2:
            flag = flag3;
            if (DeviceConfigurationManager.debugLogger.isLoggable)
            {
                DeviceConfigurationManager.debugLogger.logAsWarning("handle message, no network");
                flag = flag3;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private Properties()
        {
            syncLock = new Object();
            waitingForSync = false;
            properties = Collections.emptyMap();
            lastSynced = 0L;
            retryCount = 0;
        }

    }


    private static final String CONFIG_FILENAME = "dcs-0";
    private static final String CONFIG_QA_FILENAME = "dcs-1";
    private static final String DEV_OVERRIDE_FILENAME = "dcsDevOverride";
    private static final String ROLLOUT_THRESHOLD_FILE = "RolloutThresholdFile";
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger;
    private static final DataSetObservable observable = new Observable();
    static final long stalenessThreshold = 0x493e0L;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo verboseLogger;
    Map configRules;
    private volatile Properties configuration;
    private final Context context;
    private final EbayContext ebayContext;
    private final DeviceConfiguration.ApplicationHelper helper;
    volatile long lastSynced;

    DeviceConfigurationManager(Context context1, DomainContext domaincontext, DeviceConfiguration.ApplicationHelper applicationhelper, String s)
    {
        super(new DcsState(null, s, getRolloutThreshold(context1)));
        configRules = Collections.emptyMap();
        context = context1;
        ebayContext = domaincontext;
        helper = applicationhelper;
    }

    static StringBuilder appendTimespan(StringBuilder stringbuilder, long l)
    {
        int k = (int)(l % 1000L);
        l /= 1000L;
        int i1 = (int)(l % 60L);
        l /= 60L;
        int j1 = (int)(l % 60L);
        l /= 60L;
        int k1 = (int)(l % 24L);
        int j = (int)(l / 24L);
        String as[] = new String[5];
        as[0] = "";
        as[1] = " ";
        as[2] = " ";
        as[3] = " ";
        as[4] = " ";
        int i = -1;
        if (j > 0)
        {
            i = -1 + 1;
            stringbuilder.append(as[i]).append(j).append(" days");
        }
        j = i;
        if (k1 > 0)
        {
            j = i + 1;
            stringbuilder.append(as[j]).append(k1).append(" hours");
        }
        i = j;
        if (j1 > 0)
        {
            i = j + 1;
            stringbuilder.append(as[i]).append(j1).append(" min");
        }
        j = i;
        if (i1 > 0)
        {
            j = i + 1;
            stringbuilder.append(as[j]).append(i1).append(" sec");
        }
        if (k > 0)
        {
            stringbuilder.append(as[j + 1]).append(k).append(" ms");
        }
        return stringbuilder;
    }

    static File getConfigFile(Context context1)
    {
        File file = context1.getCacheDir();
        if (NautilusKernel.isQaMode())
        {
            context1 = "dcs-1";
        } else
        {
            context1 = "dcs-0";
        }
        return new File(file, context1);
    }

    private static int getRolloutThreshold(Context context1)
    {
        context1 = new File(context1.getFilesDir(), "RolloutThresholdFile");
        int j;
        if (!context1.exists())
        {
            return writeThresholdFile(context1);
        }
        j = readThresholdFile(context1);
        int i;
        i = j;
        if (j != 0)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        i = writeThresholdFile(context1);
        return i;
        context1;
        if (debugLogger.isLoggable)
        {
            debugLogger.logAsWarning("error saving or reading threshold", context1);
        }
        i = 100;
        return i;
    }

    private HashMap loadDeveloperOptions()
    {
        Object obj;
        obj = context.getFileStreamPath("dcsDevOverride");
        if (!((File) (obj)).exists())
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (!((File) (obj)).isFile())
        {
            context.deleteFile("dcsDevOverride");
        }
        Object obj2 = new ObjectInputStream(new FileInputStream(((File) (obj))));
        HashMap hashmap = (HashMap)((ObjectInputStream) (obj2)).readObject();
        obj = null;
        Iterator iterator = hashmap.entrySet().iterator();
_L1:
        java.util.Map.Entry entry;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_192;
            }
            entry = (java.util.Map.Entry)iterator.next();
        } while (entry.getValue() != null);
        Object obj1;
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj1 = new ArrayList();
        ((ArrayList) (obj1)).add(entry.getKey());
        obj = obj1;
          goto _L1
        obj;
        String s;
        try
        {
            ((ObjectInputStream) (obj2)).close();
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj2)
        {
            s = ((Exception) (obj2)).getMessage();
        }
        obj = s;
        if (TextUtils.isEmpty(s))
        {
            obj = obj2.getClass().getSimpleName();
        }
        debugLogger.logAsError(((String) (obj)), ((Throwable) (obj2)));
        context.deleteFile("dcsDevOverride");
        return new HashMap();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_231;
        }
        for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashmap.put((String)((Iterator) (obj)).next(), DEV_OVERRIDE_NULL)) { }
        ((ObjectInputStream) (obj2)).close();
        return hashmap;
    }

    private void notifyConfigChanged()
    {
        if (debugLogger.isLoggable)
        {
            debugLogger.log("State changed. Notifying observers...");
        }
        NetworkUtil.useHttpClient(get(DcsNautilusBoolean.HttpClientFallback));
        observable.notifyChanged();
    }

    private static int readThresholdFile(File file)
        throws IOException
    {
        file = new DataInputStream(new FileInputStream(file));
        int i = file.readInt();
        file.close();
        return i;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    public static void registerObserver(DataSetObserver datasetobserver)
    {
        observable.registerObserver(datasetobserver);
    }

    static void saveConfig(Context context1, HashMap hashmap)
    {
        File file;
        String s;
        file = getConfigFile(context1);
        s = NautilusKernel.getAppVersionWithoutBuildNumber(context1);
        if (debugLogger.isLoggable)
        {
            debugLogger.log((new StringBuilder()).append("save configuration to ").append(file.getAbsolutePath()).toString());
        }
        context1 = new ObjectOutputStream(new FileOutputStream(file));
        context1.writeObject(s);
        context1.writeObject(hashmap);
        try
        {
            context1.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context1) { }
        break MISSING_BLOCK_LABEL_87;
        hashmap;
        context1.close();
        throw hashmap;
        if (debugLogger.isLoggable)
        {
            debugLogger.logAsError("save configuration failed", context1);
        }
        file.delete();
        return;
    }

    private void saveDeveloperOptions(Map map)
    {
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(context.openFileOutput("dcsDevOverride", 0));
        Object obj = map.entrySet().iterator();
        ArrayList arraylist = null;
_L2:
        java.util.Map.Entry entry;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        if (entry.getValue() != DEV_OVERRIDE_NULL)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (arraylist != null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        arraylist = new ArrayList();
        arraylist.add(entry.getKey());
        if (true) goto _L2; else goto _L1
_L1:
        obj = map;
        if (arraylist == null) goto _L4; else goto _L3
_L3:
        obj = new HashMap(map);
        for (map = arraylist.iterator(); map.hasNext(); ((Map) (obj)).put((String)map.next(), null)) { }
          goto _L4
        map;
_L6:
        String s;
        try
        {
            objectoutputstream.close();
            throw map;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            s = ((IOException) (obj)).getMessage();
        }
        map = s;
        if (TextUtils.isEmpty(s))
        {
            map = obj.getClass().getSimpleName();
        }
        debugLogger.logAsError(map, ((Throwable) (obj)));
        context.deleteFile("dcsDevOverride");
        return;
_L4:
        objectoutputstream.writeObject(obj);
        objectoutputstream.close();
        return;
        map;
        continue; /* Loop/switch isn't completed */
        map;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void startSyncService(Properties properties, Boolean boolean1)
    {
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (Looper.getMainLooper() == Looper.myLooper())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        properties;
        JVM INSTR monitorenter ;
        if (!properties.waitingForSync)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        properties.waitingForSync = true;
        flag2 = flag;
_L10:
        properties;
        JVM INSTR monitorexit ;
        if (!flag2) goto _L4; else goto _L3
_L3:
        if (verboseLogger.isLoggable)
        {
            com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = verboseLogger;
            StringBuilder stringbuilder = (new StringBuilder()).append("Requesting sync on thread (");
            Object obj;
            if (flag1)
            {
                obj = "main";
            } else
            {
                obj = Thread.currentThread();
            }
            loginfo.log(stringbuilder.append(obj).append(") blocking(").append(boolean1).append(')').toString());
        }
        if (!flag1 && (boolean1 == null || boolean1.booleanValue())) goto _L6; else goto _L5
_L5:
        updateAsynchronously(properties);
_L8:
        return;
_L2:
        flag2 = flag;
        if (!flag1)
        {
            flag2 = flag;
            if (boolean1 == null)
            {
                flag2 = true;
            }
        }
        continue; /* Loop/switch isn't completed */
        boolean1;
        properties;
        JVM INSTR monitorexit ;
        throw boolean1;
_L6:
        updateSynchronously(properties);
        return;
_L4:
        if (!debugLogger.isLoggable) goto _L8; else goto _L7
_L7:
        debugLogger.log("Already syncing, so don't start the service again.");
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void unregisterObserver(DataSetObserver datasetobserver)
    {
        observable.unregisterObserver(datasetobserver);
    }

    private void updateAsynchronously(final Properties config)
    {
        if (Looper.getMainLooper() != Looper.myLooper())
        {
            if (verboseLogger.isLoggable)
            {
                verboseLogger.log("Async request on a background thread. Hand off to the main thread and move on.");
            }
            Observable.handler.post(new Runnable() {

                final DeviceConfigurationManager this$0;
                final Properties val$config;

                public void run()
                {
                    updateAsynchronously(config);
                }

            
            {
                this$0 = DeviceConfigurationManager.this;
                config = properties;
                super();
            }
            });
            return;
        }
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log("Start an async task to make the request");
        }
        (new AsyncTask() {

            final DeviceConfigurationManager this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Properties[])aobj);
            }

            protected transient Void doInBackground(Properties aproperties[])
            {
                updateSynchronously(aproperties[0]);
                return null;
            }

            
            {
                this$0 = DeviceConfigurationManager.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Properties[] {
            config
        });
    }

    private static int writeThresholdFile(File file)
        throws IOException
    {
        int i = Math.abs((int)(UUID.randomUUID().getLeastSignificantBits() % 100L)) + 1;
        writeThresholdFile(file, i);
        return i;
    }

    private static void writeThresholdFile(File file, int i)
        throws IOException
    {
        file = new DataOutputStream(new FileOutputStream(file));
        file.writeInt(i);
        file.close();
        return;
        Exception exception;
        exception;
        file.close();
        throw exception;
    }

    public Map debugGetProperties()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = Collections.unmodifiableMap(configRules);
        this;
        JVM INSTR monitorexit ;
        return map;
        Exception exception;
        exception;
        throw exception;
    }

    public void developerOptionsEnabled(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (flag) goto _L2; else goto _L1
_L1:
        helper.disableDeveloperOptions();
        devOverrides = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (devOverrides == null)
        {
            devOverrides = loadDeveloperOptions();
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public String getConfigVersion()
    {
        this;
        JVM INSTR monitorenter ;
        String s = (String)configRules.get("meta.config.version");
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    final long getConfiguration(boolean flag, Boolean boolean1)
    {
        Properties properties;
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log("Getting the configuration");
        }
        if (boolean1 != null && boolean1.booleanValue())
        {
            NautilusKernel.verifyNotMain();
        }
        Properties properties1 = configuration;
        properties = properties1;
        if (properties1 == null)
        {
            properties = new Properties();
            configuration = properties;
            properties.load(context);
            updateRules(properties.properties, properties.lastSynced);
        }
        if (flag)
        {
            properties.lastSynced = 0L;
        }
        if (!properties.needsUpdate()) goto _L2; else goto _L1
_L1:
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Configuration is stale. Start sync service.");
        }
        startSyncService(properties, boolean1);
_L4:
        return properties.lastSynced;
_L2:
        if (verboseLogger.isLoggable)
        {
            verboseLogger.log("Configuration is up to date. No need to sync.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public long getLastSynced()
    {
        this;
        JVM INSTR monitorenter ;
        long l = lastSynced;
        this;
        JVM INSTR monitorexit ;
        return l;
        Exception exception;
        exception;
        throw exception;
    }

    public String getLoadedRules(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        dcsproperty = (String)configRules.get(dcsproperty.key());
        this;
        JVM INSTR monitorexit ;
        return dcsproperty;
        dcsproperty;
        throw dcsproperty;
    }

    protected Object getValue(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        if (devOverrides == null) goto _L2; else goto _L1
_L1:
        Object obj = getDevOverrideValue(dcsproperty);
        if (obj != null) goto _L3; else goto _L2
_L2:
        dcsproperty = ((DcsProperty) (getLoadedValue(dcsproperty)));
_L5:
        this;
        JVM INSTR monitorexit ;
        return dcsproperty;
_L3:
        Object obj1 = DEV_OVERRIDE_NULL;
        dcsproperty = ((DcsProperty) (obj));
        if (obj == obj1)
        {
            dcsproperty = null;
        }
        if (true) goto _L5; else goto _L4
_L4:
        dcsproperty;
        throw dcsproperty;
    }

    public boolean isStale()
    {
        return configuration == null || configuration.needsUpdate() || configuration.isStale;
    }

    public void refresh(boolean flag, Boolean boolean1)
    {
        this;
        JVM INSTR monitorenter ;
        setState(getState().setLocale(Locale.getDefault()).setCountry(helper.getCurrentCountry()));
        this;
        JVM INSTR monitorexit ;
        lastSynced = getConfiguration(flag, boolean1);
        return;
        boolean1;
        this;
        JVM INSTR monitorexit ;
        throw boolean1;
    }

    public void resetAllDevOverrides()
    {
        this;
        JVM INSTR monitorenter ;
        super.resetAllDevOverrides();
        context.deleteFile("dcsDevOverride");
        notifyConfigChanged();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected void setDevOverrideValue(DcsProperty dcsproperty, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        super.setDevOverrideValue(dcsproperty, obj);
        if (!devOverrides.isEmpty())
        {
            break MISSING_BLOCK_LABEL_37;
        }
        context.deleteFile("dcsDevOverride");
_L1:
        notifyConfigChanged();
        this;
        JVM INSTR monitorexit ;
        return;
        saveDeveloperOptions(devOverrides);
          goto _L1
        dcsproperty;
        throw dcsproperty;
    }

    public boolean setRolloutThreshold(int i)
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        if (i > 0 && i <= 100)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        throw new IllegalArgumentException("Threshold must be in range [1,100]");
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        int j = getState().rolloutThreshold;
        if (j != i) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        File file = new File(context.getFilesDir(), "RolloutThresholdFile");
        writeThresholdFile(file, i);
        super.setRolloutThreshold(i);
        flag = true;
          goto _L1
        file;
        debugLogger.logAsError("Couldn't set rollout threshold", file);
          goto _L1
    }

    protected boolean setState(DcsState dcsstate)
    {
        boolean flag = super.setState(dcsstate);
        if (flag)
        {
            notifyConfigChanged();
        }
        return flag;
    }

    void updateRules(Map map, long l)
    {
        this;
        JVM INSTR monitorenter ;
        configRules = map;
        resetResolvedValues();
        lastSynced = l;
        if (!map.isEmpty() && devOverrides != null && !get(DcsNautilusBoolean.QA_ENABLED))
        {
            developerOptionsEnabled(false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        map;
        throw map;
    }

    final void updateSynchronously(Properties properties)
    {
        properties;
        JVM INSTR monitorenter ;
        if (properties.waitingForSync)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        properties;
        JVM INSTR monitorexit ;
        return;
        properties;
        JVM INSTR monitorexit ;
        boolean flag = false;
        Object obj = properties.syncLock;
        obj;
        JVM INSTR monitorenter ;
        if (debugLogger.isLoggable)
        {
            debugLogger.log(appendTimespan(new StringBuilder("Sync device configuration with threshold "), 0x493e0L).toString());
        }
        if (properties.needsUpdate())
        {
            flag = properties.sync(context, ebayContext);
        }
        properties;
        JVM INSTR monitorenter ;
        properties.waitingForSync = false;
        properties;
        JVM INSTR monitorexit ;
        obj;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        if (debugLogger.isLoggable)
        {
            debugLogger.log("Configuration changed. Notifying observers...");
            if (verboseLogger.isLoggable)
            {
                java.util.Map.Entry entry;
                for (obj = properties.properties.entrySet().iterator(); ((Iterator) (obj)).hasNext(); verboseLogger.log((new StringBuilder()).append("  ").append((String)entry.getKey()).append('=').append((String)entry.getValue()).toString()))
                {
                    entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                }

            }
        }
        break MISSING_BLOCK_LABEL_242;
        obj;
        properties;
        JVM INSTR monitorexit ;
        throw obj;
        Exception exception;
        exception;
        properties;
        JVM INSTR monitorexit ;
        throw exception;
        properties;
        obj;
        JVM INSTR monitorexit ;
        throw properties;
        exception;
        properties;
        JVM INSTR monitorenter ;
        properties.waitingForSync = false;
        properties;
        JVM INSTR monitorexit ;
        throw exception;
        exception;
        properties;
        JVM INSTR monitorexit ;
        throw exception;
        updateRules(properties.properties, properties.lastSynced);
        notifyConfigChanged();
    }

    static 
    {
        debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("DeviceConfig", 3, "Log DeviceConfiguration events");
        verboseLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(debugLogger.tag, 2, "Log extended DeviceConfiguration events");
    }

}
