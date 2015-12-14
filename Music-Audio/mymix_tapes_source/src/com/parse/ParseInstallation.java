// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import bolts.Continuation;
import bolts.Task;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore, Parse, ParseException, 
//            ParseQuery, ParseUser, ParseFileUtils, PushType, 
//            ManifestInfo, ParseOperationSet, PushService, PushRouter

public class ParseInstallation extends ParseObject
{

    private static final String APP_IDENTIFIER = "appIdentifier";
    private static final String APP_NAME = "appName";
    private static final String APP_VERSION = "appVersion";
    private static final String DEVICE_TOKEN = "deviceToken";
    private static final String DEVICE_TOKEN_LAST_MODIFIED = "deviceTokenLastModified";
    private static final String DEVICE_TYPE = "deviceType";
    private static final String INSTALLATION_ID = "installationId";
    private static final String INSTALLATION_ID_LOCATION = "installationId";
    private static final Object MUTEX_CURRENT_INSTALLATION = new Object();
    static final String OS_VERSION = "osVersion";
    private static final String PARSE_VERSION = "parseVersion";
    private static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
    private static final String PUSH_TYPE = "pushType";
    private static final List READ_ONLY_FIELDS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "deviceType", "installationId", "deviceToken", "pushType", "timeZone", "appVersion", "appName", "parseVersion", "deviceTokenLastModified", "appIdentifier"
    }));
    private static final String STORAGE_LOCATION = "currentInstallation";
    private static final String TAG = "com.parse.ParseInstallation";
    private static final String TIMEZONE = "timeZone";
    static ParseInstallation currentInstallation = null;
    private static String installationId = null;

    public ParseInstallation()
    {
    }

    static void clearCurrentInstallationFromDisk(Context context)
    {
        synchronized (MUTEX_CURRENT_INSTALLATION)
        {
            currentInstallation = null;
            installationId = null;
            if (OfflineStore.isEnabled())
            {
                ParseObject.unpinAllInBackground("_currentInstallation");
            }
            Parse.deleteDiskObject(context, "currentInstallation");
            Parse.deleteDiskObject(context, "installationId");
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    static void clearCurrentInstallationFromMemory()
    {
        synchronized (MUTEX_CURRENT_INSTALLATION)
        {
            currentInstallation = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static ParseInstallation getCurrentInstallation()
    {
        boolean flag1 = false;
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        boolean flag = flag1;
        if (currentInstallation != null) goto _L2; else goto _L1
_L1:
        ParseObject parseobject = null;
        boolean flag2 = OfflineStore.isEnabled();
        if (!flag2) goto _L4; else goto _L3
_L3:
        ParseObject parseobject1 = (ParseObject)Parse.waitForTask(ParseQuery.getQuery(com/parse/ParseInstallation).fromPin("_currentInstallation").findInBackground((ParseUser)null).onSuccessTask(new Continuation() {

            public Task then(Task task)
                throws Exception
            {
                task = (List)task.getResult();
                if (task != null)
                {
                    if (task.size() == 1)
                    {
                        return Task.forResult(task.get(0));
                    } else
                    {
                        return ParseObject.unpinAllInBackground("_currentInstallation").cast();
                    }
                } else
                {
                    return Task.forResult(null);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

        }));
        parseobject = parseobject1;
_L8:
        if (parseobject != null) goto _L6; else goto _L5
_L5:
        currentInstallation = (ParseInstallation)ParseObject.create(com/parse/ParseInstallation);
        currentInstallation.updateDeviceInfo();
        flag = flag1;
_L2:
        obj;
        JVM INSTR monitorexit ;
        if (flag)
        {
            currentInstallation.maybeUpdateInstallationIdOnDisk();
        }
        return currentInstallation;
_L4:
        parseobject = getFromDisk(Parse.applicationContext, "currentInstallation");
        continue; /* Loop/switch isn't completed */
_L6:
        flag = true;
        currentInstallation = (ParseInstallation)parseobject;
        Parse.logV("com.parse.ParseInstallation", "Successfully deserialized Installation object");
          goto _L2
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ParseException parseexception;
        parseexception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static String getOrCreateCurrentInstallationId()
    {
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        String s = installationId;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        installationId = new String(ParseFileUtils.readFileToByteArray(new File(Parse.getParseDir(), "installationId")));
_L1:
        if (installationId == null)
        {
            installationId = UUID.randomUUID().toString();
            setCurrentInstallationId(installationId);
        }
        obj;
        JVM INSTR monitorexit ;
        return installationId;
        Object obj1;
        obj1;
        Parse.logI("com.parse.ParseInstallation", "Couldn't find existing installationId file. Creating one instead.");
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        obj1;
        Parse.logE("com.parse.ParseInstallation", "Unexpected exception reading installation id from disk", ((Throwable) (obj1)));
          goto _L1
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseInstallation);
    }

    static boolean hasCurrentInstallation()
    {
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (currentInstallation != null || (new File(Parse.getParseDir(), "currentInstallation")).exists())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static Task maybeFlushToDiskAsync(ParseInstallation parseinstallation)
    {
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        boolean flag;
        if (parseinstallation == currentInstallation)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            return Task.forResult(null);
        }
        break MISSING_BLOCK_LABEL_36;
        parseinstallation;
        obj;
        JVM INSTR monitorexit ;
        throw parseinstallation;
        Task task;
        if (OfflineStore.isEnabled())
        {
            task = ParseObject.unpinAllInBackground("_currentInstallation").continueWithTask(new Continuation(parseinstallation) {

                final ParseInstallation val$installation;

                public Task then(Task task1)
                    throws Exception
                {
                    return installation.pinInBackground("_currentInstallation");
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                installation = parseinstallation;
                super();
            }
            });
        } else
        {
            task = Task.forResult(null).continueWithTask(new Continuation(parseinstallation) {

                final ParseInstallation val$installation;

                public Task then(Task task1)
                    throws Exception
                {
                    installation.saveToDisk(Parse.applicationContext, "currentInstallation");
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                installation = parseinstallation;
                super();
            }
            });
        }
        return task.continueWithTask(new Continuation(parseinstallation) {

            final ParseInstallation val$installation;

            public Task then(Task task1)
                throws Exception
            {
                installation.maybeUpdateInstallationIdOnDisk();
                return task1;
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                installation = parseinstallation;
                super();
            }
        });
    }

    private void maybeUpdateInstallationIdOnDisk()
    {
        String s = getInstallationId();
        String s1 = getOrCreateCurrentInstallationId();
        boolean flag;
        if (s == null || s.length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !s.equals(s1))
        {
            Parse.logW("com.parse.ParseInstallation", (new StringBuilder()).append("Will update installation id on disk: ").append(s1).append(" because it does not match installation id in ParseInstallation: ").append(s).toString());
            setCurrentInstallationId(s);
        }
    }

    static void setCurrentInstallationId(String s)
    {
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        File file = new File(Parse.getParseDir(), "installationId");
        ParseFileUtils.writeByteArrayToFile(file, s.getBytes());
_L1:
        installationId = s;
        return;
        IOException ioexception;
        ioexception;
        Parse.logE("com.parse.ParseInstallation", "Unexpected exception writing installation id to disk", ioexception);
          goto _L1
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void updateDeviceInfo()
    {
        if (!has("installationId"))
        {
            super.put("installationId", getOrCreateCurrentInstallationId());
        }
        if (!"android".equals(get("deviceType")))
        {
            super.put("deviceType", "android");
        }
    }

    private void updateTimezone()
    {
        String s = TimeZone.getDefault().getID();
        if ((s.indexOf('/') > 0 || s.equals("GMT")) && !s.equals(get("timeZone")))
        {
            super.put("timeZone", s);
        }
    }

    private void updateVersionInfo()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        String s1;
        Object obj2;
        s = Parse.applicationContext.getPackageName();
        obj2 = Parse.applicationContext.getPackageManager();
        s1 = ((PackageManager) (obj2)).getPackageInfo(s, 0).versionName;
        obj2 = ((PackageManager) (obj2)).getApplicationLabel(((PackageManager) (obj2)).getApplicationInfo(s, 0)).toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (!s.equals(get("appIdentifier")))
        {
            super.put("appIdentifier", s);
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (!((String) (obj2)).equals(get("appName")))
        {
            super.put("appName", obj2);
        }
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (!s1.equals(get("appVersion")))
        {
            super.put("appVersion", s1);
        }
_L1:
        if (!"1.8.0".equals(get("parseVersion")))
        {
            super.put("parseVersion", "1.8.0");
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        Parse.logW("com.parse.ParseInstallation", "Cannot load package info; will not be saved to installation");
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    void checkKeyIsMutable(String s)
        throws IllegalArgumentException
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        if (READ_ONLY_FIELDS.contains(s))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot change ").append(s).append(" property of an installation object.").toString());
        }
        break MISSING_BLOCK_LABEL_58;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
        obj;
        JVM INSTR monitorexit ;
    }

    Task fetchAsync(final Task toAwait)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        Task task;
        if (getObjectId() != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        task = saveAsync(toAwait);
_L1:
        toAwait = task.onSuccessTask(new Continuation() {

            final ParseInstallation this$0;
            final Task val$toAwait;

            public Task then(Task task1)
                throws Exception
            {
                return fetchAsync(toAwait);
            }

            public volatile Object then(Task task1)
                throws Exception
            {
                return then(task1);
            }

            
            {
                this$0 = ParseInstallation.this;
                toAwait = task;
                super();
            }
        });
        return toAwait;
        task = Task.forResult(null);
          goto _L1
        toAwait;
        obj;
        JVM INSTR monitorexit ;
        throw toAwait;
    }

    String getDeviceToken()
    {
        return super.getString("deviceToken");
    }

    public String getInstallationId()
    {
        return getString("installationId");
    }

    PushType getPushType()
    {
        return PushType.fromString(super.getString("pushType"));
    }

    Task handleFetchResultAsync(JSONObject jsonobject)
    {
        return super.handleFetchResultAsync(jsonobject).onSuccessTask(new Continuation() {

            final ParseInstallation this$0;

            public Task then(Task task)
                throws Exception
            {
                return ParseInstallation.maybeFlushToDiskAsync(ParseInstallation.this);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
        });
    }

    Task handleSaveResultAsync(JSONObject jsonobject, ParseOperationSet parseoperationset)
    {
        parseoperationset = super.handleSaveResultAsync(jsonobject, parseoperationset);
        jsonobject = parseoperationset;
        if (ManifestInfo.getPushUsesBroadcastReceivers())
        {
            jsonobject = parseoperationset.onSuccessTask(new Continuation() {

                final ParseInstallation this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return PushRouter.getForceEnabledStateAsync();
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
            }).onSuccess(new Continuation() {

                final ParseInstallation this$0;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                    throws Exception
                {
                    task = (Boolean)task.getResult();
                    if (task == null || task.booleanValue())
                    {
                        PushService.startServiceIfRequired(Parse.applicationContext);
                    }
                    return null;
                }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
            });
        }
        return jsonobject.onSuccessTask(new Continuation() {

            final ParseInstallation this$0;

            public Task then(Task task)
                throws Exception
            {
                return ParseInstallation.maybeFlushToDiskAsync(ParseInstallation.this);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
        });
    }

    boolean isDeviceTokenStale()
    {
        return super.getLong("deviceTokenLastModified") != ManifestInfo.getLastModified();
    }

    boolean needsDefaultACL()
    {
        return false;
    }

    public void put(String s, Object obj)
        throws IllegalArgumentException
    {
        synchronized (mutex)
        {
            checkKeyIsMutable(s);
            super.put(s, obj);
        }
        return;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void remove(String s)
    {
        synchronized (mutex)
        {
            checkKeyIsMutable(s);
            super.remove(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    void removeDeviceToken()
    {
        super.remove("deviceToken");
        super.remove("deviceTokenLastModified");
    }

    void removePushType()
    {
        super.remove("pushType");
    }

    void setDefaultValues()
    {
        super.setDefaultValues();
        super.put("deviceType", "android");
        super.put("installationId", getOrCreateCurrentInstallationId());
    }

    void setDeviceToken(String s)
    {
        if (s != null && s.length() > 0)
        {
            super.put("deviceToken", s);
            super.put("deviceTokenLastModified", Long.valueOf(ManifestInfo.getLastModified()));
        }
    }

    void setDeviceTokenLastModified(long l)
    {
        super.put("deviceTokenLastModified", Long.valueOf(l));
    }

    void setPushType(PushType pushtype)
    {
        if (pushtype != null)
        {
            super.put("pushType", pushtype.toString());
        }
    }

    void updateBeforeSave()
    {
        super.updateBeforeSave();
        updateTimezone();
        updateVersionInfo();
        updateDeviceInfo();
    }




}
