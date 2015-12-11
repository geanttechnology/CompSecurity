// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsInfoStore, DefaultFileHandlerFactory, MobileAdsLoggerFactory, MobileAdsLogger, 
//            FileHandlerFactory, ThreadUtils, AppEvent, FileOutputHandler, 
//            FileInputHandler, JSONUtils, RegistrationInfo, SISRegistration

class AppEventRegistrationHandler
{

    protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
    protected static final long APP_EVENTS_FILE_MAX_SIZE = 0x100000L;
    protected static final String APP_EVENT_NAME_KEY = "evtName";
    protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
    protected static final String INSTALL_REFERRER_EVENT_NAME = "INSTALL_REFERRER";
    private static final String LOGTAG = com/amazon/device/ads/AppEventRegistrationHandler.getSimpleName();
    protected static AppEventRegistrationHandler instance = new AppEventRegistrationHandler(MobileAdsInfoStore.getInstance(), new DefaultFileHandlerFactory());
    protected final Object appEventsFileLock = new Object();
    protected final Set eventsSent = Collections.synchronizedSet(new HashSet());
    private final FileHandlerFactory fileHandlerFactory;
    private FileInputHandler fileInputHandler;
    private FileOutputHandler fileOutputHandler;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    protected final Set newEventsToSave = Collections.synchronizedSet(new HashSet());

    protected AppEventRegistrationHandler(MobileAdsInfoStore mobileadsinfostore, FileHandlerFactory filehandlerfactory)
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        infoStore = mobileadsinfostore;
        fileHandlerFactory = filehandlerfactory;
    }

    private boolean createFileInputHandlerIfNeeded()
    {
        if (fileInputHandler != null) goto _L2; else goto _L1
_L1:
        java.io.File file = infoStore.getFilesDir();
        if (file != null) goto _L4; else goto _L3
_L3:
        logger.e("No files directory has been set.");
_L6:
        return false;
_L4:
        fileInputHandler = fileHandlerFactory.createFileInputHandler(file, "AppEventsJsonFile");
_L2:
        if (fileInputHandler != null)
        {
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean createFileOutputHandlerIfNeeded()
    {
        if (fileOutputHandler != null) goto _L2; else goto _L1
_L1:
        java.io.File file = infoStore.getFilesDir();
        if (file != null) goto _L4; else goto _L3
_L3:
        logger.e("No files directory has been set.");
_L6:
        return false;
_L4:
        fileOutputHandler = fileHandlerFactory.createFileOutputHandler(file, "AppEventsJsonFile");
_L2:
        if (fileOutputHandler != null)
        {
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static AppEventRegistrationHandler getInstance()
    {
        return instance;
    }

    public void addEventToAppEventsCacheFile(final AppEvent appEvent)
    {
        ThreadUtils.scheduleRunnable(new Runnable() {

            final AppEventRegistrationHandler this$0;
            final AppEvent val$appEvent;

            public void run()
            {
                appendAppEventToFile(appEvent);
                if (appEvent.getEventName().equals("INSTALL_REFERRER") && infoStore.getRegistrationInfo().isRegisteredWithSIS())
                {
                    infoStore.getSISRegistration().registerEvents();
                }
            }

            
            {
                this$0 = AppEventRegistrationHandler.this;
                appEvent = appevent;
                super();
            }
        });
    }

    protected void appendAppEventToFile(AppEvent appevent)
    {
        Object obj1;
        if (!createFileOutputHandlerIfNeeded())
        {
            logger.e("Error creating file output handler.");
            return;
        }
        obj1 = new JSONObject();
        try
        {
            ((JSONObject) (obj1)).put("evtName", appevent.getEventName());
            ((JSONObject) (obj1)).put("ts", appevent.getTimestamp());
            java.util.Map.Entry entry;
            for (Iterator iterator = appevent.getPropertyEntries().iterator(); iterator.hasNext(); ((JSONObject) (obj1)).put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        catch (JSONException jsonexception)
        {
            logger.w("Internal error while persisting the application event %s.", new Object[] {
                appevent.toString()
            });
            return;
        }
        newEventsToSave.add(((JSONObject) (obj1)).toString());
        synchronized (appEventsFileLock)
        {
            obj1 = (new StringBuilder()).append(((JSONObject) (obj1)).toString()).append("\n").toString();
            if (fileOutputHandler.getFileLength() + (long)((String) (obj1)).length() <= 0x100000L)
            {
                break MISSING_BLOCK_LABEL_216;
            }
            logger.w("Couldn't write the application event %s to the cache file. Maximum size limit reached.", new Object[] {
                appevent.toString()
            });
        }
        return;
        appevent;
        obj;
        JVM INSTR monitorexit ;
        throw appevent;
        boolean flag = fileOutputHandler.open(FileOutputHandler.WriteMethod.APPEND);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        fileOutputHandler.write(((String) (obj1)));
        logger.d("Added the application event %s to the cache file.", new Object[] {
            appevent.toString()
        });
_L1:
        fileOutputHandler.close();
        obj;
        JVM INSTR monitorexit ;
        return;
        IOException ioexception;
        ioexception;
        logger.w("Couldn't write the application event %s to the file.", new Object[] {
            appevent.toString()
        });
          goto _L1
    }

    public JSONArray getAppEventsJSONArray()
    {
label0:
        {
            if (!createFileInputHandlerIfNeeded())
            {
                logger.e("Error creating file input handler.");
                return null;
            }
            synchronized (appEventsFileLock)
            {
                if (fileInputHandler.doesFileExist())
                {
                    break label0;
                }
            }
            return null;
        }
        if (fileInputHandler.open())
        {
            break MISSING_BLOCK_LABEL_64;
        }
        logger.e("App Events File could not be opened.");
        obj;
        JVM INSTR monitorexit ;
        return null;
        obj1 = new JSONArray();
_L1:
        Object obj2 = fileInputHandler.readLine();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_136;
        }
        obj2 = JSONUtils.getJSONObjectFromString(((String) (obj2)));
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        onAppEventsRegistered();
        fileInputHandler.close();
        obj;
        JVM INSTR monitorexit ;
        return null;
        ((JSONArray) (obj1)).put(obj2);
        eventsSent.add(((JSONObject) (obj2)).toString());
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        fileInputHandler.close();
        if (((JSONArray) (obj1)).length() > 0)
        {
            return ((JSONArray) (obj1));
        }
        obj;
        JVM INSTR monitorexit ;
        return null;
    }

    public void onAppEventsRegistered()
    {
        if (!createFileOutputHandlerIfNeeded())
        {
            logger.e("Error creating file output handler.");
            return;
        }
        Object obj = appEventsFileLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj2;
        newEventsToSave.removeAll(eventsSent);
        if (newEventsToSave.isEmpty())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        obj2 = new StringBuilder();
        Object obj1 = newEventsToSave;
        obj1;
        JVM INSTR monitorenter ;
        for (Iterator iterator = newEventsToSave.iterator(); iterator.hasNext(); ((StringBuilder) (obj2)).append((String)iterator.next()).append("\n")) { }
        break MISSING_BLOCK_LABEL_119;
        obj2;
        obj1;
        JVM INSTR monitorexit ;
        throw obj2;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        JVM INSTR monitorexit ;
        boolean flag = fileOutputHandler.open(FileOutputHandler.WriteMethod.APPEND);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        fileOutputHandler.write(((StringBuilder) (obj2)).toString());
        newEventsToSave.clear();
        eventsSent.clear();
_L1:
        fileOutputHandler.close();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        IOException ioexception;
        ioexception;
        logger.w("Couldn't write the application event(s) to the file.");
          goto _L1
        infoStore.getApplicationContext().deleteFile("AppEventsJsonFile");
        eventsSent.clear();
          goto _L2
    }


}
