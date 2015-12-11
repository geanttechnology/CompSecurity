// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.urbanairship.util.UAStringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

// Referenced classes of package com.urbanairship:
//            PropertyName, Logger, ConstantClass

public class AirshipConfigOptions
{

    public static final String ADM_TRANSPORT = "ADM";
    private static final int DEFAULT_DEVELOPMENT_LOG_LEVEL = 3;
    private static final int DEFAULT_PRODUCTION_LOG_LEVEL = 6;
    private static final String DEFAULT_PROPERTIES_FILENAME = "airshipconfig.properties";
    public static final String GCM_TRANSPORT = "GCM";
    private static final int MAX_BG_REPORTING_INTERVAL_MS = 0x5265c00;
    private static final int MIN_BG_REPORTING_INTERVAL_MS = 60000;
    public String additionalGCMSenderIds[];
    public String allowedTransports[] = {
        "ADM", "GCM"
    };
    public boolean analyticsEnabled;
    public String analyticsServer;
    public boolean autoLaunchApplication;
    public long backgroundReportingIntervalMS;
    public boolean channelCaptureEnabled;
    public boolean channelCreationDelayEnabled;
    public boolean clearNamedUser;
    public String developmentAppKey;
    public String developmentAppSecret;
    public int developmentLogLevel;
    public String gcmSender;
    public String hostURL;
    public boolean inProduction;
    public String landingPageContentURL;
    public int minSdkVersion;
    public String productionAppKey;
    public String productionAppSecret;
    public int productionLogLevel;
    public String whitelist[];

    public AirshipConfigOptions()
    {
        hostURL = "https://device-api.urbanairship.com/";
        analyticsServer = "https://combine.urbanairship.com/";
        landingPageContentURL = "https://dl.urbanairship.com/aaa/";
        whitelist = null;
        inProduction = false;
        analyticsEnabled = true;
        backgroundReportingIntervalMS = 0xdbba0L;
        clearNamedUser = false;
        developmentLogLevel = 3;
        productionLogLevel = 6;
        minSdkVersion = 4;
        autoLaunchApplication = true;
        channelCreationDelayEnabled = false;
        channelCaptureEnabled = true;
    }

    private String getPropertyValue(Field field, Properties properties)
    {
        PropertyName propertyname = (PropertyName)field.getAnnotation(com/urbanairship/PropertyName);
        if (propertyname != null)
        {
            properties = properties.getProperty(propertyname.name());
            Logger.verbose((new StringBuilder("AirshipConfigOptions - Found PropertyAnnotation for ")).append(propertyname.name()).append(" matching ").append(field.getName()).toString());
            return properties;
        } else
        {
            return null;
        }
    }

    private boolean isLogLevelValid(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return true;
        }
    }

    public static AirshipConfigOptions loadDefaultOptions(Context context)
    {
        AirshipConfigOptions airshipconfigoptions = new AirshipConfigOptions();
        airshipconfigoptions.loadFromProperties(context);
        return airshipconfigoptions;
    }

    private void setPropertyValue(Field field, String s)
    {
        if (field.getType() == Boolean.TYPE || field.getType() == java/lang/Boolean)
        {
            field.set(this, Boolean.valueOf(s));
            return;
        }
        if (field.getType() == Integer.TYPE || field.getType() == java/lang/Integer)
        {
            field.set(this, Integer.valueOf(parseOptionValues(field, s)));
            return;
        }
        if (field.getType() == Long.TYPE || field.getType() == java/lang/Long)
        {
            field.set(this, Long.valueOf(s));
            return;
        }
          goto _L1
_L3:
        Logger.error((new StringBuilder("AirshipConfigOptions - Unable to set field '")).append(field.getName()).append("' due to invalid configuration value.").toString(), s);
        return;
_L1:
        if (field.getType().isArray())
        {
            field.set(this, s.split("[, ]+"));
            return;
        }
        try
        {
            field.set(this, s.trim());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.error((new StringBuilder("AirshipConfigOptions - Unable to set field '")).append(field.getName()).append("' because the field is not visible.").toString(), s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (true) goto _L3; else goto _L2
_L2:
    }

    public String getAppKey()
    {
        if (inProduction)
        {
            return productionAppKey;
        } else
        {
            return developmentAppKey;
        }
    }

    public String getAppSecret()
    {
        if (inProduction)
        {
            return productionAppSecret;
        } else
        {
            return developmentAppSecret;
        }
    }

    public Set getGCMSenderIds()
    {
        HashSet hashset = new HashSet();
        if (!UAStringUtil.isEmpty(gcmSender))
        {
            hashset.add(gcmSender);
        }
        if (additionalGCMSenderIds != null)
        {
            hashset.addAll(Arrays.asList(additionalGCMSenderIds));
        }
        return hashset;
    }

    public int getLoggerLevel()
    {
        if (inProduction)
        {
            return productionLogLevel;
        } else
        {
            return developmentLogLevel;
        }
    }

    public boolean isTransportAllowed(String s)
    {
        if (allowedTransports != null && s != null)
        {
            String as[] = allowedTransports;
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                if (s.equalsIgnoreCase(as[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public boolean isValid()
    {
        int i = 0;
        boolean flag = true;
        Object obj;
        Field afield[];
        int j;
        boolean flag1;
        if (inProduction)
        {
            obj = "production";
        } else
        {
            obj = "development";
        }
        if (getAppKey() == null || getAppKey().length() == 0 || getAppKey().indexOf(' ') > 0)
        {
            Logger.error((new StringBuilder("AirshipConfigOptions: ")).append(getAppKey()).append(" is not a valid ").append(((String) (obj))).append(" app key").toString());
            flag = false;
        }
        if (getAppSecret() == null || getAppSecret().length() == 0 || getAppSecret().indexOf(' ') > 0)
        {
            Logger.error((new StringBuilder("AirshipConfigOptions: ")).append(getAppSecret()).append(" is not a valid ").append(((String) (obj))).append(" app secret").toString());
            flag = false;
        }
        flag1 = flag;
        if (analyticsEnabled)
        {
            flag1 = flag;
            if (UAStringUtil.isEmpty(analyticsServer))
            {
                Logger.error("Invalid config - analyticsServer is empty or null.");
                flag1 = false;
            }
        }
        if (UAStringUtil.isEmpty(hostURL))
        {
            Logger.error("Invalid config - hostURL is empty or null.");
            flag = false;
        } else
        {
            flag = flag1;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        afield = getClass().getFields();
        j = afield.length;
_L7:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_507;
        }
        obj = afield[i];
        if ((((Field) (obj)).getModifiers() & 0x10) != 0) goto _L4; else goto _L3
_L3:
        if (obj != null)
        {
            try
            {
                if (!((Field) (obj)).isAnnotationPresent(com/urbanairship/PropertyName))
                {
                    Logger.error((new StringBuilder("AirshipConfigOptions - The public field '")).append(((Field) (obj)).getName()).append("' is missing an annotation").toString());
                    Logger.error("AirshipConfigOptions appears to be obfuscated. If using Proguard, add the following to your proguard.cfg: \n\t-keepattributes *Annotation*");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
_L2:
        if (inProduction)
        {
            if (!isLogLevelValid(productionLogLevel))
            {
                Logger.error((new StringBuilder()).append(productionLogLevel).append(" is not a valid log level. Falling back to 6").append(" ERROR.").toString());
                productionLogLevel = 6;
            }
        } else
        if (!isLogLevelValid(developmentLogLevel))
        {
            Logger.error((new StringBuilder()).append(developmentLogLevel).append(" is not a valid log level. Falling back to 3").append(" DEBUG.").toString());
            developmentLogLevel = 3;
        }
        if (backgroundReportingIntervalMS >= 60000L) goto _L6; else goto _L5
_L5:
        Logger.warn((new StringBuilder("AirshipConfigOptions - The backgroundReportingIntervalMS ")).append(backgroundReportingIntervalMS).append(" may decrease battery life.").toString());
_L9:
        return flag;
_L4:
        i++;
          goto _L7
_L6:
        if (backgroundReportingIntervalMS <= 0x5265c00L) goto _L9; else goto _L8
_L8:
        Logger.warn((new StringBuilder("AirshipConfigOptions - The backgroundReportingIntervalMS ")).append(backgroundReportingIntervalMS).append(" may provide less detailed analytic reports.").toString());
        return flag;
        obj = null;
          goto _L3
    }

    public void loadFromProperties(Context context)
    {
        loadFromProperties(context, "airshipconfig.properties");
    }

    public void loadFromProperties(Context context, String s)
    {
        Object obj1 = context.getResources().getAssets();
        if (Arrays.asList(((AssetManager) (obj1)).list("")).contains(s)) goto _L2; else goto _L1
_L1:
        Logger.verbose((new StringBuilder("AirshipConfigOptions - Couldn't find ")).append(s).toString());
_L6:
        return;
        context;
        Logger.error(context);
        return;
_L2:
        Object obj;
        Properties properties;
        properties = new Properties();
        obj = null;
        context = null;
        obj1 = ((AssetManager) (obj1)).open(s);
        context = ((Context) (obj1));
        obj = obj1;
        properties.load(((InputStream) (obj1)));
        context = ((Context) (obj1));
        obj = obj1;
        Field afield[] = getClass().getDeclaredFields();
        context = ((Context) (obj1));
        obj = obj1;
        int j = afield.length;
        int i = 0;
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Field field;
        field = afield[i];
        context = ((Context) (obj1));
        obj = obj1;
        if (com/urbanairship/AirshipConfigOptions.isAssignableFrom(field.getType()))
        {
            continue; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj1));
        obj = obj1;
        String s1 = getPropertyValue(field, properties);
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        context = ((Context) (obj1));
        obj = obj1;
        setPropertyValue(field, s1);
        i++;
          goto _L5
_L4:
        if (obj1 != null)
        {
            try
            {
                ((InputStream) (obj1)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Logger.error("AirshipConfigOptions - Failed to close input stream.", context);
            }
            return;
        }
          goto _L6
        IOException ioexception;
        ioexception;
        obj = context;
        Logger.error((new StringBuilder("AirshipConfigOptions - Unable to load properties file ")).append(s).toString(), ioexception);
        if (context == null) goto _L6; else goto _L7
_L7:
        try
        {
            context.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Logger.error("AirshipConfigOptions - Failed to close input stream.", context);
        }
        return;
        context;
        if (obj != null)
        {
            try
            {
                ((InputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Logger.error("AirshipConfigOptions - Failed to close input stream.", s);
            }
        }
        throw context;
    }

    int parseOptionValues(Field field, String s)
    {
        int i;
        try
        {
            i = Integer.valueOf(s).intValue();
        }
        catch (NumberFormatException numberformatexception)
        {
            ConstantClass constantclass = (ConstantClass)field.getAnnotation(com/urbanairship/ConstantClass);
            if (constantclass == null)
            {
                throw new IllegalArgumentException((new StringBuilder("The field '")).append(field.getName()).append("' has a type mismatch or missing annotation.").toString());
            }
            Field afield[] = Class.forName(constantclass.name()).getDeclaredFields();
            int k = afield.length;
            for (int j = 0; j < k; j++)
            {
                Field field1 = afield[j];
                if (field1.getName().equalsIgnoreCase(s))
                {
                    try
                    {
                        j = field1.getInt(this);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        throw new IllegalArgumentException((new StringBuilder("The field '")).append(field.getName()).append("' is incompatible with specified class").toString(), s);
                    }
                    return j;
                }
            }

            throw new IllegalArgumentException((new StringBuilder("Unable to match class for field '")).append(field.getName()).append("'").toString());
        }
        return i;
    }
}
