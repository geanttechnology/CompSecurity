// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils, InternalAdRegistration, IInternalAdRegistration, AppEvent, 
//            Log, JSONUtils

class AppEventRegistrationHandler
{

    protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
    protected static final long APP_EVENTS_FILE_MAX_SIZE = 0x100000L;
    protected static final String APP_EVENT_NAME_KEY = "evtName";
    protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
    private static final String LOG_TAG = com/amazon/device/ads/AppEventRegistrationHandler.getSimpleName();
    protected static AppEventRegistrationHandler instance = new AppEventRegistrationHandler();
    protected final Object appEventsFileLock = new Object();
    protected final Set eventsSent = Collections.synchronizedSet(new HashSet());
    protected final Set newEventsToSave = Collections.synchronizedSet(new HashSet());

    protected AppEventRegistrationHandler()
    {
    }

    public static AppEventRegistrationHandler getInstance()
    {
        return instance;
    }

    public void addEventToAppEventsCacheFile(final AppEvent appEvent)
    {
        ThreadUtils.executeRunnable(new Runnable() {

            final AppEventRegistrationHandler this$0;
            final AppEvent val$appEvent;

            public void run()
            {
                appendAppEventToFile(appEvent);
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
        String s;
        Object obj5;
        Object obj = InternalAdRegistration.getInstance().getApplicationContext();
        if (obj == null)
        {
            return;
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("evtName", appevent.getEventName());
            jsonobject.put("ts", appevent.getTimestamp());
            java.util.Map.Entry entry;
            for (Iterator iterator = appevent.getPropertyEntries().iterator(); iterator.hasNext(); jsonobject.put((String)entry.getKey(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w(LOG_TAG, "Internal error while persisting the application event %s.", new Object[] {
                appevent.toString()
            });
            return;
        }
        newEventsToSave.add(jsonobject.toString());
        synchronized (appEventsFileLock)
        {
            s = (new StringBuilder()).append(jsonobject.toString()).append("\n").toString();
            obj5 = new File(((Context) (obj)).getFilesDir(), "AppEventsJsonFile");
            if (((File) (obj5)).length() + (long)s.length() <= 0x100000L)
            {
                break MISSING_BLOCK_LABEL_233;
            }
            Log.w(LOG_TAG, "Couldn't write the application event %s to the cache file. Maximum size limit reached.", new Object[] {
                appevent.toString()
            });
        }
        return;
        appevent;
        obj4;
        JVM INSTR monitorexit ;
        throw appevent;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj2 = null;
        obj5 = new FileOutputStream(((File) (obj5)), true);
        obj1 = new OutputStreamWriter(((java.io.OutputStream) (obj5)));
        ((OutputStreamWriter) (obj1)).write(s);
        Log.d(LOG_TAG, "Added the application event %s to the cache file.", new Object[] {
            appevent.toString()
        });
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        ((OutputStreamWriter) (obj1)).close();
_L1:
        obj4;
        JVM INSTR monitorexit ;
        return;
        appevent;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L1
        obj1;
_L6:
        obj1 = obj2;
        Log.w(LOG_TAG, "Couldn't write the application event %s to the file.", new Object[] {
            appevent.toString()
        });
        if (obj2 == null) goto _L1; else goto _L2
_L2:
        ((OutputStreamWriter) (obj2)).close();
          goto _L1
        appevent;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L1
        appevent;
_L5:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_365;
        }
        ((OutputStreamWriter) (obj1)).close();
_L3:
        throw appevent;
        obj1;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L3
        appevent;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        appevent;
        if (true) goto _L5; else goto _L4
_L4:
        obj1;
          goto _L6
        IOException ioexception;
        ioexception;
        ioexception = ((IOException) (obj1));
          goto _L6
    }

    public JSONArray getAppEventsJSONArray()
    {
        Context context = InternalAdRegistration.getInstance().getApplicationContext();
        if (context == null)
        {
            return null;
        }
        synchronized (appEventsFileLock)
        {
            obj = new File(context.getFilesDir(), "AppEventsJsonFile");
            if (((File) (obj)).exists())
            {
                break MISSING_BLOCK_LABEL_56;
            }
        }
        return null;
        obj;
        obj8;
        JVM INSTR monitorexit ;
        throw obj;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        obj4 = null;
        obj7 = null;
        obj5 = null;
        obj6 = null;
        obj3 = null;
        Object obj1 = new FileInputStream(((File) (obj)));
        Object obj2 = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj1))));
        obj3 = null;
_L5:
        obj4 = ((BufferedReader) (obj2)).readLine();
        if (obj4 == null) goto _L2; else goto _L1
_L1:
        obj4 = JSONUtils.getJSONObjectFromString(((String) (obj4)));
        if (obj4 != null) goto _L4; else goto _L3
_L3:
        onAppEventsRegistered();
        obj3 = null;
_L2:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        ((FileInputStream) (obj1)).close();
_L6:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        ((BufferedReader) (obj2)).close();
_L7:
        obj8;
        JVM INSTR monitorexit ;
        return ((JSONArray) (obj3));
_L4:
        if (obj3 != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj3 = new JSONArray();
        ((JSONArray) (obj3)).put(obj4);
        eventsSent.add(((JSONObject) (obj4)).toString());
          goto _L5
        obj1;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
          goto _L6
        obj1;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
          goto _L7
        obj1;
        obj2 = obj3;
        obj1 = obj7;
_L14:
        obj4 = obj1;
        obj5 = obj2;
        Log.w(LOG_TAG, "Problem while reading the application events file.");
        obj4 = null;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        ((FileInputStream) (obj1)).close();
_L9:
        obj3 = obj4;
        if (obj2 == null) goto _L7; else goto _L8
_L8:
        ((BufferedReader) (obj2)).close();
        obj3 = obj4;
          goto _L7
        obj1;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
        obj3 = obj4;
          goto _L7
        obj1;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
          goto _L9
        obj3;
        obj2 = obj5;
        obj1 = obj4;
_L13:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_299;
        }
        ((FileInputStream) (obj1)).close();
_L10:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        ((BufferedReader) (obj2)).close();
_L11:
        throw obj3;
        IOException ioexception;
        ioexception;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
          goto _L10
        ioexception;
        Log.w(LOG_TAG, "Problem while closing the application events file.");
          goto _L11
        obj3;
        obj2 = obj6;
        continue; /* Loop/switch isn't completed */
        obj3;
        continue; /* Loop/switch isn't completed */
        obj3;
        if (true) goto _L13; else goto _L12
_L12:
        IOException ioexception1;
        ioexception1;
        ioexception1 = ((IOException) (obj3));
          goto _L14
        IOException ioexception2;
        ioexception2;
          goto _L14
        ioexception2;
          goto _L14
    }

    public void onAppEventsRegistered()
    {
        Object obj1;
        obj1 = InternalAdRegistration.getInstance().getApplicationContext();
        if (obj1 == null)
        {
            return;
        }
        Object obj3 = appEventsFileLock;
        obj3;
        JVM INSTR monitorenter ;
        newEventsToSave.removeAll(eventsSent);
        if (newEventsToSave.isEmpty()) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder = new StringBuilder();
        Object obj = newEventsToSave;
        obj;
        JVM INSTR monitorenter ;
        for (Iterator iterator = newEventsToSave.iterator(); iterator.hasNext(); stringbuilder.append((String)iterator.next()).append("\n")) { }
        break MISSING_BLOCK_LABEL_118;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj;
        obj3;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        JVM INSTR monitorexit ;
        Object obj4 = new File(((Context) (obj1)).getFilesDir(), "AppEventsJsonFile");
        Object obj2;
        obj = null;
        obj2 = null;
        obj1 = null;
        obj4 = new FileOutputStream(((File) (obj4)), false);
        obj = new BufferedWriter(new OutputStreamWriter(((java.io.OutputStream) (obj4))));
        ((BufferedWriter) (obj)).write(stringbuilder.toString());
        newEventsToSave.clear();
        eventsSent.clear();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_205;
        }
        ((BufferedWriter) (obj)).close();
_L3:
        obj3;
        JVM INSTR monitorexit ;
        return;
        obj;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L3
        obj;
_L7:
        obj = obj1;
        Log.w(LOG_TAG, "Couldn't write the application event(s) to the file.");
        if (obj1 == null) goto _L3; else goto _L4
_L4:
        ((BufferedWriter) (obj1)).close();
          goto _L3
        obj;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L3
        obj1;
_L6:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_265;
        }
        ((BufferedWriter) (obj)).close();
_L5:
        throw obj1;
        obj;
        Log.w(LOG_TAG, "Problem while closing application events file.");
          goto _L5
_L2:
        ((Context) (obj1)).deleteFile("AppEventsJsonFile");
        eventsSent.clear();
          goto _L3
        obj1;
        obj = obj2;
          goto _L6
        obj1;
          goto _L6
        obj;
          goto _L7
        IOException ioexception;
        ioexception;
        ioexception = ((IOException) (obj));
          goto _L7
    }

}
