// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.ct;
import android.support.v7.cu;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Callable;

// Referenced classes of package com.parse:
//            ParseObject, Parse, ParseFileUtils, ParsePlugins, 
//            InstallationId, ParseException, ParseQuery, ParseTaskUtils, 
//            PLog, ParseExecutors, PushType, ManifestInfo, 
//            ParseOperationSet, PushService, PushRouter

public class ParseInstallation extends ParseObject
{

    static final String FILENAME_CURRENT_INSTALLATION = "currentInstallation";
    private static final String KEY_APP_IDENTIFIER = "appIdentifier";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_APP_VERSION = "appVersion";
    private static final String KEY_DEVICE_TOKEN = "deviceToken";
    private static final String KEY_DEVICE_TOKEN_LAST_MODIFIED = "deviceTokenLastModified";
    private static final String KEY_DEVICE_TYPE = "deviceType";
    private static final String KEY_INSTALLATION_ID = "installationId";
    private static final String KEY_PARSE_VERSION = "parseVersion";
    private static final String KEY_PUSH_TYPE = "pushType";
    private static final String KEY_TIME_ZONE = "timeZone";
    private static final Object MUTEX_CURRENT_INSTALLATION = new Object();
    private static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
    private static final List READ_ONLY_FIELDS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "deviceType", "installationId", "deviceToken", "pushType", "timeZone", "appVersion", "appName", "parseVersion", "deviceTokenLastModified", "appIdentifier"
    }));
    private static final String TAG = "com.parse.ParseInstallation";
    static ParseInstallation currentInstallation = null;
    static String installationId = null;

    public ParseInstallation()
    {
    }

    static void clearCurrentInstallationFromDisk(Context context)
    {
        synchronized (MUTEX_CURRENT_INSTALLATION)
        {
            currentInstallation = null;
            installationId = null;
            if (Parse.isLocalDatastoreEnabled())
            {
                ParseObject.unpinAllInBackground("_currentInstallation");
            }
            ParseFileUtils.deleteQuietly(new File(Parse.getParseDir(), "currentInstallation"));
            ParsePlugins.get().installationId().clear();
        }
        return;
        exception;
        context;
        JVM INSTR monitorexit ;
        throw exception;
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
        synchronized (MUTEX_CURRENT_INSTALLATION)
        {
            obj = currentInstallation;
        }
        if (obj != null)
        {
            return ((ParseInstallation) (obj));
        }
        break MISSING_BLOCK_LABEL_23;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        if (!Parse.isLocalDatastoreEnabled())
        {
            break MISSING_BLOCK_LABEL_133;
        }
        ParseInstallation parseinstallation = (ParseInstallation)ParseTaskUtils.wait(ParseQuery.getQuery(com/parse/ParseInstallation).fromPin("_currentInstallation").ignoreACLs().findInBackground().d(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                cu1 = (List)cu1.e();
                if (cu1 != null)
                {
                    if (cu1.size() == 1)
                    {
                        return cu.a(cu1.get(0));
                    } else
                    {
                        return ParseObject.unpinAllInBackground("_currentInstallation").i();
                    }
                } else
                {
                    return cu.a(null);
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        }).d(new ct() {

            public cu then(cu cu1)
                throws Exception
            {
                if ((ParseInstallation)cu1.e() != null)
                {
                    return cu1;
                } else
                {
                    return ParseObject.migrateFromDiskToLDS("currentInstallation", "_currentInstallation").i();
                }
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

        }));
        obj = parseinstallation;
_L1:
        ParseException parseexception;
        boolean flag;
        if (obj == null)
        {
            obj = (ParseInstallation)ParseObject.create(com/parse/ParseInstallation);
            ((ParseInstallation) (obj)).updateDeviceInfo();
            flag = false;
        } else
        {
            flag = true;
            PLog.v("com.parse.ParseInstallation", "Successfully deserialized Installation object");
        }
        if (flag)
        {
            ParsePlugins.get().installationId().set(((ParseInstallation) (obj)).getInstallationId());
        }
        synchronized (MUTEX_CURRENT_INSTALLATION)
        {
            currentInstallation = ((ParseInstallation) (obj));
        }
        return ((ParseInstallation) (obj));
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
        parseexception;
          goto _L1
        obj = (ParseInstallation)getFromDisk("currentInstallation");
          goto _L1
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseInstallation);
    }

    static cu hasCurrentInstallationAsync()
    {
label0:
        {
            cu cu1;
            synchronized (MUTEX_CURRENT_INSTALLATION)
            {
                if (currentInstallation == null)
                {
                    break label0;
                }
                cu1 = cu.a(Boolean.valueOf(true));
            }
            return cu1;
        }
        obj;
        JVM INSTR monitorexit ;
        if (Parse.isLocalDatastoreEnabled())
        {
            return ParseQuery.getQuery(com/parse/ParseInstallation).fromPin("_currentInstallation").ignoreACLs().countInBackground().c(new ct() {

                public Boolean then(cu cu2)
                    throws Exception
                {
                    boolean flag;
                    if (((Integer)cu2.e()).intValue() == 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    return Boolean.valueOf(flag);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            });
        } else
        {
            return cu.a(new Callable() {

                public Boolean call()
                    throws Exception
                {
                    return Boolean.valueOf((new File(Parse.getParseDir(), "currentInstallation")).exists());
                }

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

            }, cu.a);
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean isCurrentInstallation()
    {
        Object obj = MUTEX_CURRENT_INSTALLATION;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (this == currentInstallation)
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

    private static cu maybeFlushToDiskAsync(ParseInstallation parseinstallation)
    {
        if (!parseinstallation.isCurrentInstallation())
        {
            return cu.a(null);
        }
        cu cu1;
        if (Parse.isLocalDatastoreEnabled())
        {
            cu1 = ParseObject.unpinAllInBackground("_currentInstallation").b(new ct(parseinstallation) {

                final ParseInstallation val$installation;

                public cu then(cu cu2)
                    throws Exception
                {
                    return installation.pinInBackground("_currentInstallation", false);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                installation = parseinstallation;
                super();
            }
            });
        } else
        {
            cu1 = cu.a(null).b(new ct(parseinstallation) {

                final ParseInstallation val$installation;

                public cu then(cu cu2)
                    throws Exception
                {
                    installation.saveToDisk("currentInstallation");
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                installation = parseinstallation;
                super();
            }
            });
        }
        return cu1.b(new ct(parseinstallation) {

            final ParseInstallation val$installation;

            public cu then(cu cu2)
                throws Exception
            {
                ParsePlugins.get().installationId().set(installation.getInstallationId());
                return cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                installation = parseinstallation;
                super();
            }
        }, ParseExecutors.io());
    }

    private void updateDeviceInfo()
    {
        if (!has("installationId"))
        {
            performPut("installationId", ParsePlugins.get().installationId().get());
        }
        if (!"android".equals(get("deviceType")))
        {
            performPut("deviceType", "android");
        }
    }

    private void updateTimezone()
    {
        String s = TimeZone.getDefault().getID();
        if ((s.indexOf('/') > 0 || s.equals("GMT")) && !s.equals(get("timeZone")))
        {
            performPut("timeZone", s);
        }
    }

    private void updateVersionInfo()
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        String s;
        Object obj2;
        Object obj3;
        obj2 = Parse.getApplicationContext();
        s = ((Context) (obj2)).getPackageName();
        obj3 = ((Context) (obj2)).getPackageManager();
        obj2 = ((PackageManager) (obj3)).getPackageInfo(s, 0).versionName;
        obj3 = ((PackageManager) (obj3)).getApplicationLabel(((PackageManager) (obj3)).getApplicationInfo(s, 0)).toString();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        if (!s.equals(get("appIdentifier")))
        {
            performPut("appIdentifier", s);
        }
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        if (!((String) (obj3)).equals(get("appName")))
        {
            performPut("appName", obj3);
        }
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        if (!((String) (obj2)).equals(get("appVersion")))
        {
            performPut("appVersion", obj2);
        }
_L1:
        if (!"1.9.4".equals(get("parseVersion")))
        {
            performPut("parseVersion", "1.9.4");
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        Object obj1;
        obj1;
        PLog.w("com.parse.ParseInstallation", "Cannot load package info; will not be saved to installation");
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    cu fetchAsync(final String sessionToken, final cu toAwait)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        cu cu1;
        if (getObjectId() != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        cu1 = saveAsync(sessionToken, toAwait);
_L1:
        sessionToken = cu1.d(new ct() {

            final ParseInstallation this$0;
            final String val$sessionToken;
            final cu val$toAwait;

            public cu then(cu cu2)
                throws Exception
            {
                return fetchAsync(sessionToken, toAwait);
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$0 = ParseInstallation.this;
                sessionToken = s;
                toAwait = cu1;
                super();
            }
        });
        return sessionToken;
        cu1 = cu.a(null);
          goto _L1
        sessionToken;
        obj;
        JVM INSTR monitorexit ;
        throw sessionToken;
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

    cu handleFetchResultAsync(ParseObject.State state)
    {
        return super.handleFetchResultAsync(state).d(new ct() {

            final ParseInstallation this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseInstallation.maybeFlushToDiskAsync(ParseInstallation.this);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
        });
    }

    cu handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseoperationset)
    {
        parseoperationset = super.handleSaveResultAsync(state, parseoperationset);
        if (state == null)
        {
            return parseoperationset;
        }
        state = parseoperationset;
        if (ManifestInfo.getPushUsesBroadcastReceivers())
        {
            state = parseoperationset;
            if (ManifestInfo.getPushType() == PushType.PPNS)
            {
                state = parseoperationset.d(new ct() {

                    final ParseInstallation this$0;

                    public cu then(cu cu1)
                        throws Exception
                    {
                        return PushRouter.getForceEnabledStateAsync();
                    }

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
                }).c(new ct() {

                    final ParseInstallation this$0;

                    public volatile Object then(cu cu1)
                        throws Exception
                    {
                        return then(cu1);
                    }

                    public Void then(cu cu1)
                        throws Exception
                    {
                        cu1 = (Boolean)cu1.e();
                        if (cu1 == null || cu1.booleanValue())
                        {
                            PushService.startServiceIfRequired(ParsePlugins.Android.get().applicationContext());
                        }
                        return null;
                    }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
                });
            }
        }
        return state.d(new ct() {

            final ParseInstallation this$0;

            public cu then(cu cu1)
                throws Exception
            {
                return ParseInstallation.maybeFlushToDiskAsync(ParseInstallation.this);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
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

    boolean isKeyMutable(String s)
    {
        return !READ_ONLY_FIELDS.contains(s);
    }

    boolean needsDefaultACL()
    {
        return false;
    }

    void removeDeviceToken()
    {
        performRemove("deviceToken");
        performRemove("deviceTokenLastModified");
    }

    void removePushType()
    {
        performRemove("pushType");
    }

    void setDeviceToken(String s)
    {
        if (s != null && s.length() > 0)
        {
            performPut("deviceToken", s);
            performPut("deviceTokenLastModified", Long.valueOf(ManifestInfo.getLastModified()));
        }
    }

    void setDeviceTokenLastModified(long l)
    {
        performPut("deviceTokenLastModified", Long.valueOf(l));
    }

    void setPushType(PushType pushtype)
    {
        if (pushtype != null)
        {
            performPut("pushType", pushtype.toString());
        }
    }

    void updateBeforeSave()
    {
        super.updateBeforeSave();
        if (isCurrentInstallation())
        {
            updateTimezone();
            updateVersionInfo();
            updateDeviceInfo();
        }
    }



}
