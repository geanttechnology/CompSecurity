// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.configuration;

import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.StringUtil;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.device.analytics.configuration:
//            Configuration, ConfigurationChangedListener, ConfigurationRefreshListener

public class InMemoryConfiguration
    implements Configuration, ConfigurationChangedListener
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/configuration/InMemoryConfiguration);
    private Map changedListeners;
    protected Configuration parentConfiguration;
    protected Map properties;
    private Map refreshListeners;

    public InMemoryConfiguration()
    {
        this(null);
    }

    public InMemoryConfiguration(Configuration configuration)
    {
        this(configuration, ((Map) (new ConcurrentHashMap())), ((Map) (new ConcurrentHashMap())), ((Map) (new ConcurrentHashMap())));
    }

    public InMemoryConfiguration(Configuration configuration, Map map, Map map1, Map map2)
    {
        properties = map;
        if (map1 != null)
        {
            changedListeners = map1;
        } else
        {
            changedListeners = new ConcurrentHashMap();
        }
        if (map2 != null)
        {
            refreshListeners = map2;
        } else
        {
            refreshListeners = new ConcurrentHashMap();
        }
        setParentConfiguration(configuration);
    }

    public Map getAllProperties()
    {
        return properties;
    }

    public Boolean getBoolean(String s)
    {
        Boolean boolean1;
        Boolean boolean2;
        boolean2 = null;
        boolean1 = boolean2;
        boolean flag;
        if (!properties.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_41;
        }
        flag = Boolean.parseBoolean((String)properties.get(s));
        boolean1 = Boolean.valueOf(flag);
_L2:
        boolean2 = boolean1;
        if (boolean1 == null)
        {
            boolean2 = boolean1;
            if (parentConfiguration != null)
            {
                boolean2 = parentConfiguration.getBoolean(s);
            }
        }
        return boolean2;
        Exception exception;
        exception;
        logger.e(String.format("Could not get Boolean for propertyName: %s", new Object[] {
            s
        }), exception);
        exception = boolean2;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public Integer getInt(String s)
    {
        Integer integer1 = null;
        Integer integer = integer1;
        try
        {
            if (properties.containsKey(s))
            {
                integer = Integer.decode((String)properties.get(s));
            }
        }
        catch (Exception exception)
        {
            logger.e(String.format("Could not get Integer for propertyName: %s", new Object[] {
                s
            }), exception);
            exception = integer1;
        }
        integer1 = integer;
        if (integer == null)
        {
            integer1 = integer;
            if (parentConfiguration != null)
            {
                integer1 = parentConfiguration.getInt(s);
            }
        }
        return integer1;
    }

    public String getString(String s)
    {
        String s1 = null;
        if (properties.containsKey(s))
        {
            s1 = (String)properties.get(s);
        }
        String s2 = s1;
        if (s1 == null)
        {
            s2 = s1;
            if (parentConfiguration != null)
            {
                s2 = parentConfiguration.getString(s);
            }
        }
        return s2;
    }

    public void notifyChangedListeners(String s, Object obj)
    {
        if (changedListeners.containsKey("_ALL_"))
        {
            logger.v((new StringBuilder()).append("Notifying PropertyChangedListeners of all events that propertyName:").append(s).append(" changed with propertyValue:").append(obj).toString());
            for (Iterator iterator = ((Map)changedListeners.get("_ALL_")).keySet().iterator(); iterator.hasNext(); ((ConfigurationChangedListener)iterator.next()).onPropertyChanged(s, obj)) { }
        }
        if (changedListeners.containsKey(s))
        {
            logger.v((new StringBuilder()).append("Notifying PropertyChangedListeners of propertyName:").append(s).append(" changed with propertyValue:").append(obj).toString());
            for (Iterator iterator1 = ((Map)changedListeners.get(s)).keySet().iterator(); iterator1.hasNext(); ((ConfigurationChangedListener)iterator1.next()).onPropertyChanged(s, obj)) { }
        }
    }

    public void notifyRefreshListeners()
    {
        logger.v("Notifying refresh listeners that the configuration has changed");
        for (Iterator iterator = refreshListeners.keySet().iterator(); iterator.hasNext(); ((ConfigurationRefreshListener)iterator.next()).onRefresh(this)) { }
    }

    public void onPropertyChanged(String s, Object obj)
    {
        if (!properties.containsKey(s))
        {
            notifyChangedListeners(s, obj);
        }
    }

    public Boolean optBoolean(String s, Boolean boolean1)
    {
        s = getBoolean(s);
        if (s != null)
        {
            return s;
        } else
        {
            return boolean1;
        }
    }

    public Integer optInt(String s, Integer integer)
    {
        s = getInt(s);
        if (s != null)
        {
            return s;
        } else
        {
            return integer;
        }
    }

    public String optString(String s, String s1)
    {
        s = getString(s);
        if (s != null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public void refresh()
    {
        if (parentConfiguration != null)
        {
            parentConfiguration.refresh();
        }
        notifyRefreshListeners();
    }

    public void registerChangedListener(ConfigurationChangedListener configurationchangedlistener)
    {
        registerChangedListener("_ALL_", configurationchangedlistener);
    }

    public void registerChangedListener(String s, ConfigurationChangedListener configurationchangedlistener)
    {
        if (StringUtil.isNullOrEmpty(s) || configurationchangedlistener == null)
        {
            if (configurationchangedlistener == null)
            {
                logger.v((new StringBuilder()).append("Null listener provided to registerChangedListener. propertyName:").append(s).toString());
                return;
            } else
            {
                logger.v((new StringBuilder()).append("Null propertyName provided to registerChangedListener. listener:").append(configurationchangedlistener.toString()).toString());
                return;
            }
        }
        if (!changedListeners.containsKey(s))
        {
            changedListeners.put(s, new ConcurrentHashMap());
        }
        ((Map)changedListeners.get(s)).put(configurationchangedlistener, Boolean.valueOf(true));
    }

    public void registerRefreshListener(ConfigurationRefreshListener configurationrefreshlistener)
    {
        if (configurationrefreshlistener == null)
        {
            logger.v("Null listener provided to registerRefreshListener");
        } else
        if (!refreshListeners.containsKey(configurationrefreshlistener))
        {
            refreshListeners.put(configurationrefreshlistener, Boolean.valueOf(true));
            return;
        }
    }

    public void setParentConfiguration(Configuration configuration)
    {
        if (configuration != null)
        {
            configuration.registerChangedListener(this);
        }
        if (parentConfiguration != null)
        {
            parentConfiguration.unregisterChangedListener(this);
        }
        parentConfiguration = configuration;
    }

    public void setProperty(String s, Object obj)
    {
        while (StringUtil.isNullOrEmpty(s) || properties.containsKey(s) && obj != null && obj.equals(properties.get(s)) || obj == null) 
        {
            return;
        }
        properties.put(s, obj.toString());
        notifyChangedListeners(s, obj);
    }

    public void unregisterChangedListener(ConfigurationChangedListener configurationchangedlistener)
    {
        unregisterChangedListener("_ALL_", configurationchangedlistener);
    }

    public void unregisterChangedListener(String s, ConfigurationChangedListener configurationchangedlistener)
    {
        if (!StringUtil.isNullOrEmpty(s) && configurationchangedlistener != null) goto _L2; else goto _L1
_L1:
        if (configurationchangedlistener != null) goto _L4; else goto _L3
_L3:
        logger.v((new StringBuilder()).append("Null listener provided to registerChangedListener. propertyName:").append(s).toString());
_L6:
        return;
_L4:
        logger.v((new StringBuilder()).append("Null propertyName provided to registerChangedListener. listener:").append(configurationchangedlistener.toString()).toString());
        return;
_L2:
        if (changedListeners.containsKey(s))
        {
            s = (Map)changedListeners.get(s);
            if (s.containsKey(configurationchangedlistener))
            {
                s.remove(configurationchangedlistener);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

}
