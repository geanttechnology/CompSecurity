// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.configuration.InMemoryConfiguration;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.mas.client.featureconfig.FeatureConfig;
import com.amazon.mas.client.featureconfig.FeatureConfigLocator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.analytics:
//            AnalyticsConfiguration

class AnalyticsConfigurationImpl
    implements AnalyticsConfiguration
{

    private static Logger logger = Logging.getLogger(com/amazon/analytics/AnalyticsConfigurationImpl);
    private volatile FeatureConfig featureConfig;
    private final FeatureConfigLocator featureConfigLocator;
    private final InMemoryConfiguration memConfig = new InMemoryConfiguration();

    public AnalyticsConfigurationImpl(FeatureConfigLocator featureconfiglocator)
    {
        featureConfig = null;
        featureConfigLocator = featureconfiglocator;
        refresh();
    }

    public boolean getBoolean(AnalyticsConfiguration.Setting setting)
    {
        return memConfig.optBoolean(setting.getKey(), (Boolean)setting.getDefaultValue(java/lang/Boolean)).booleanValue();
    }

    public List getCommaDelimitedStringList(AnalyticsConfiguration.Setting setting)
    {
        ArrayList arraylist = new ArrayList();
        for (setting = new StringTokenizer(memConfig.optString(setting.getKey(), (String)setting.getDefaultValue(java/lang/String)), ","); setting.hasMoreTokens(); arraylist.add(setting.nextToken())) { }
        return arraylist;
    }

    public int getInt(AnalyticsConfiguration.Setting setting)
    {
        return memConfig.optInt(setting.getKey(), (Integer)setting.getDefaultValue(java/lang/Integer)).intValue();
    }

    InMemoryConfiguration getUnderlyingConfig()
    {
        return memConfig;
    }

    public void refresh()
    {
        memConfig.refresh();
        if (featureConfigLocator == null) goto _L2; else goto _L1
_L1:
        Object obj = featureConfigLocator.getFeatureConfig("analytics");
        if (obj == null || featureConfig == obj) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorenter ;
        JSONObject jsonobject;
        if (featureConfig == obj)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        jsonobject = ((FeatureConfig) (obj)).getConfigurationData();
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        Iterator iterator;
        memConfig.getAllProperties().clear();
        iterator = jsonobject.keys();
_L4:
        String s;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s = (String)iterator.next();
        memConfig.setProperty(s, jsonobject.getString(s));
          goto _L4
        JSONException jsonexception;
        jsonexception;
        logger.d("JSON parse error in refresh", jsonexception);
          goto _L4
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        featureConfig = ((FeatureConfig) (obj));
        memConfig.notifyRefreshListeners();
        this;
        JVM INSTR monitorexit ;
_L2:
    }

    public void registerChangedListener(String s, ConfigurationChangedListener configurationchangedlistener)
    {
        memConfig.registerChangedListener(s, configurationchangedlistener);
    }

}
