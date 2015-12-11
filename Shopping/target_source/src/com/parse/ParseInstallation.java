// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.parse:
//            ParseObject, ParseException, ParseCurrentInstallationController, ParseTaskUtils, 
//            ParseCorePlugins, ParseQuery, Parse, PLog, 
//            PushType, ParsePlugins, InstallationId, ParseOperationSet

public class ParseInstallation extends ParseObject
{

    private static final String KEY_APP_IDENTIFIER = "appIdentifier";
    private static final String KEY_APP_NAME = "appName";
    private static final String KEY_APP_VERSION = "appVersion";
    static final String KEY_CHANNELS = "channels";
    private static final String KEY_DEVICE_TOKEN = "deviceToken";
    private static final String KEY_DEVICE_TYPE = "deviceType";
    private static final String KEY_INSTALLATION_ID = "installationId";
    private static final String KEY_LOCALE = "localeIdentifier";
    private static final String KEY_PARSE_VERSION = "parseVersion";
    private static final String KEY_PUSH_TYPE = "pushType";
    private static final String KEY_TIME_ZONE = "timeZone";
    private static final List READ_ONLY_FIELDS = Collections.unmodifiableList(Arrays.asList(new String[] {
        "deviceType", "installationId", "deviceToken", "pushType", "timeZone", "localeIdentifier", "appVersion", "appName", "parseVersion", "appIdentifier"
    }));
    private static final String TAG = "com.parse.ParseInstallation";

    public ParseInstallation()
    {
    }

    public static ParseInstallation getCurrentInstallation()
    {
        ParseInstallation parseinstallation;
        try
        {
            parseinstallation = (ParseInstallation)ParseTaskUtils.wait(getCurrentInstallationController().getAsync());
        }
        catch (ParseException parseexception)
        {
            return null;
        }
        return parseinstallation;
    }

    static ParseCurrentInstallationController getCurrentInstallationController()
    {
        return ParseCorePlugins.getInstance().getCurrentInstallationController();
    }

    public static ParseQuery getQuery()
    {
        return ParseQuery.getQuery(com/parse/ParseInstallation);
    }

    private void updateLocaleIdentifier()
    {
        Locale locale = Locale.getDefault();
        String s1 = locale.getLanguage();
        String s2 = locale.getCountry();
        if (!TextUtils.isEmpty(s1))
        {
            String s = s1;
            if (s1.equals("iw"))
            {
                s = "he";
            }
            s1 = s;
            if (s.equals("in"))
            {
                s1 = "id";
            }
            s = s1;
            if (s1.equals("ji"))
            {
                s = "yi";
            }
            s1 = s;
            if (!TextUtils.isEmpty(s2))
            {
                s1 = String.format(Locale.US, "%s-%s", new Object[] {
                    s, s2
                });
            }
            if (!s1.equals(get("localeIdentifier")))
            {
                performPut("localeIdentifier", s1);
                return;
            }
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
        if (!"1.10.3".equals(get("parseVersion")))
        {
            performPut("parseVersion", "1.10.3");
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

    j fetchAsync(final String sessionToken, final j toAwait)
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        j j1;
        if (getObjectId() != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        j1 = saveAsync(sessionToken, toAwait);
_L1:
        sessionToken = j1.d(new i() {

            final ParseInstallation this$0;
            final String val$sessionToken;
            final j val$toAwait;

            public j then(j j2)
                throws Exception
            {
                return fetchAsync(sessionToken, toAwait);
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$0 = ParseInstallation.this;
                sessionToken = s;
                toAwait = j1;
                super();
            }
        });
        return sessionToken;
        j1 = j.a(null);
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

    j handleFetchResultAsync(ParseObject.State state)
    {
        return super.handleFetchResultAsync(state).d(new i() {

            final ParseInstallation this$0;

            public j then(j j1)
                throws Exception
            {
                return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
        });
    }

    j handleSaveResultAsync(ParseObject.State state, ParseOperationSet parseoperationset)
    {
        parseoperationset = super.handleSaveResultAsync(state, parseoperationset);
        if (state == null)
        {
            return parseoperationset;
        } else
        {
            return parseoperationset.d(new i() {

                final ParseInstallation this$0;

                public j then(j j1)
                    throws Exception
                {
                    return ParseInstallation.getCurrentInstallationController().setAsync(ParseInstallation.this);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseInstallation.this;
                super();
            }
            });
        }
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
        }
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
        if (getCurrentInstallationController().isCurrent(this))
        {
            updateTimezone();
            updateVersionInfo();
            updateDeviceInfo();
            updateLocaleIdentifier();
        }
    }

    void updateDeviceInfo()
    {
        updateDeviceInfo(ParsePlugins.get().installationId());
    }

    void updateDeviceInfo(InstallationId installationid)
    {
        if (!has("installationId"))
        {
            performPut("installationId", installationid.get());
        }
        if (!"android".equals(get("deviceType")))
        {
            performPut("deviceType", "android");
        }
    }


}
