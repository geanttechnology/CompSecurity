// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.content.Context;
import android.database.DataSetObserver;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.DomainContext;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DeviceConfigurationTestImpl, DeviceConfigurationManager, DcsProperty, DcsUtil, 
//            DcsPropBoolean, DcsPropString, DcsPropInteger, DcsPropLong, 
//            DcsPropUrl, DcsState, DcsNautilusBoolean

public abstract class DeviceConfiguration
{
    public static interface ApplicationHelper
    {

        public abstract void disableDeveloperOptions();

        public abstract EbayCountry getCurrentCountry();
    }


    public static final Object DEV_OVERRIDE_NULL = new Object();
    static final String META_APP_VERSION = "meta.app.version";
    static final String META_CONFIG_VERSION = "meta.config.version";
    private static volatile DeviceConfiguration appInst;
    private static volatile DeviceConfiguration inst;
    private DcsState dcsState;
    protected Map devOverrides;
    private final Map resolvedDefaults = new HashMap();
    private final Map resolvedValues = new HashMap();

    DeviceConfiguration(DcsState dcsstate)
    {
        dcsState = dcsstate;
    }

    public static void TEST_setDcsTestHook(boolean flag)
    {
        com/ebay/nautilus/domain/dcs/DeviceConfiguration;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        if (inst == appInst)
        {
            inst = new DeviceConfigurationTestImpl();
        }
_L4:
        com/ebay/nautilus/domain/dcs/DeviceConfiguration;
        JVM INSTR monitorexit ;
        return;
_L2:
        inst = appInst;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public static DeviceConfiguration getAsync()
    {
        inst.refresh(false, Boolean.FALSE);
        return inst;
    }

    public static DeviceConfiguration getNoSync()
    {
        return inst;
    }

    public static DeviceConfiguration getSync()
    {
        inst.refresh(false, Boolean.TRUE);
        return inst;
    }

    public static DeviceConfiguration getSyncIfBackground()
    {
        inst.refresh(false, null);
        return inst;
    }

    public static void init(Context context, DomainContext domaincontext, ApplicationHelper applicationhelper, String s)
    {
        com/ebay/nautilus/domain/dcs/DeviceConfiguration;
        JVM INSTR monitorenter ;
        if (appInst != null) goto _L2; else goto _L1
_L1:
        appInst = new DeviceConfigurationManager(context, domaincontext, applicationhelper, s);
        if (inst == null)
        {
            inst = appInst;
        }
_L4:
        com/ebay/nautilus/domain/dcs/DeviceConfiguration;
        JVM INSTR monitorexit ;
        return;
_L2:
        appInst.setUser(s);
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public static void registerObserver(DataSetObserver datasetobserver)
    {
        DeviceConfigurationManager.registerObserver(datasetobserver);
    }

    private void reset()
    {
        resolvedDefaults.clear();
        resolvedValues.clear();
    }

    public static void unregisterObserver(DataSetObserver datasetobserver)
    {
        DeviceConfigurationManager.unregisterObserver(datasetobserver);
    }

    public Map debugGetProperties()
    {
        this;
        JVM INSTR monitorenter ;
        Map map = Collections.emptyMap();
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
    }

    public final int get(DcsPropInteger dcspropinteger)
    {
        dcspropinteger = ((DcsPropInteger) (getValue(dcspropinteger)));
        if (dcspropinteger == null)
        {
            return 0;
        } else
        {
            return ((Integer)dcspropinteger).intValue();
        }
    }

    public final long get(DcsPropLong dcsproplong)
    {
        dcsproplong = ((DcsPropLong) (getValue(dcsproplong)));
        if (dcsproplong == null)
        {
            return 0L;
        } else
        {
            return ((Long)dcsproplong).longValue();
        }
    }

    public final String get(DcsPropString dcspropstring)
    {
        return (String)getValue(dcspropstring);
    }

    public final URL get(DcsPropUrl dcspropurl)
    {
        return (URL)getValue(dcspropurl);
    }

    public final boolean get(DcsPropBoolean dcspropboolean)
    {
        dcspropboolean = ((DcsPropBoolean) (getValue(dcspropboolean)));
        if (dcspropboolean == null)
        {
            return false;
        } else
        {
            return ((Boolean)dcspropboolean).booleanValue();
        }
    }

    public String getConfigVersion()
    {
        this;
        JVM INSTR monitorenter ;
        return null;
    }

    public final int getDefault(DcsPropInteger dcspropinteger)
    {
        dcspropinteger = ((DcsPropInteger) (getDefaultValue(dcspropinteger)));
        if (dcspropinteger == null)
        {
            return 0;
        } else
        {
            return ((Integer)dcspropinteger).intValue();
        }
    }

    public final long getDefault(DcsPropLong dcsproplong)
    {
        dcsproplong = ((DcsPropLong) (getDefaultValue(dcsproplong)));
        if (dcsproplong == null)
        {
            return 0L;
        } else
        {
            return ((Long)dcsproplong).longValue();
        }
    }

    public final String getDefault(DcsPropString dcspropstring)
    {
        return (String)getDefaultValue(dcspropstring);
    }

    public final URL getDefault(DcsPropUrl dcspropurl)
    {
        return (URL)getDefaultValue(dcspropurl);
    }

    public final boolean getDefault(DcsPropBoolean dcspropboolean)
    {
        dcspropboolean = ((DcsPropBoolean) (getDefaultValue(dcspropboolean)));
        if (dcspropboolean == null)
        {
            return false;
        } else
        {
            return ((Boolean)dcspropboolean).booleanValue();
        }
    }

    protected final Object getDefaultValue(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        s = dcsproperty.key();
        obj = resolvedDefaults.get(s);
        Object obj1;
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        obj1 = obj;
        if (resolvedDefaults.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        obj1 = dcsproperty.defaultValue(dcsState);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        obj = DcsUtil.getFromRules(dcsproperty, obj1, dcsState);
        resolvedDefaults.put(s, obj);
        obj1 = obj;
        this;
        JVM INSTR monitorexit ;
        return obj1;
        dcsproperty;
        throw dcsproperty;
    }

    public final Boolean getDevOverride(DcsPropBoolean dcspropboolean)
    {
        return (Boolean)getDevOverrideValue(dcspropboolean);
    }

    public final Integer getDevOverride(DcsPropInteger dcspropinteger)
    {
        return (Integer)getDevOverrideValue(dcspropinteger);
    }

    public final Long getDevOverride(DcsPropLong dcsproplong)
    {
        return (Long)getDevOverrideValue(dcsproplong);
    }

    public final Object getDevOverride(DcsPropString dcspropstring)
    {
        return getDevOverrideValue(dcspropstring);
    }

    public final Object getDevOverride(DcsPropUrl dcspropurl)
    {
        return getDevOverrideValue(dcspropurl);
    }

    public int getDevOverrideCount()
    {
        this;
        JVM INSTR monitorenter ;
        if (devOverrides == null) goto _L2; else goto _L1
_L1:
        int i = devOverrides.size();
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        i = 0;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    protected final Object getDevOverrideValue(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        if (devOverrides == null) goto _L2; else goto _L1
_L1:
        Object obj = devOverrides.get(dcsproperty.key());
_L4:
        Object obj1;
        obj1 = obj;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj1 = obj;
        if (obj == DEV_OVERRIDE_NULL)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        if ((dcsproperty instanceof DcsPropBoolean) && !(obj instanceof Boolean) || (dcsproperty instanceof DcsPropString) && !(obj instanceof String) || (dcsproperty instanceof DcsPropInteger) && !(obj instanceof Integer) || (dcsproperty instanceof DcsPropLong) && !(obj instanceof Long))
        {
            break MISSING_BLOCK_LABEL_114;
        }
        obj1 = obj;
        if (!(dcsproperty instanceof DcsPropUrl))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj1 = obj;
        if (obj instanceof URL)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj1 = null;
        setDevOverrideValue(dcsproperty, null);
        this;
        JVM INSTR monitorexit ;
        return obj1;
_L2:
        obj = null;
        if (true) goto _L4; else goto _L3
_L3:
        dcsproperty;
        throw dcsproperty;
    }

    public long getLastSynced()
    {
        this;
        JVM INSTR monitorenter ;
        return 0L;
    }

    public final int getLoaded(DcsPropInteger dcspropinteger)
    {
        dcspropinteger = ((DcsPropInteger) (getLoadedValue(dcspropinteger)));
        if (dcspropinteger == null)
        {
            return 0;
        } else
        {
            return ((Integer)dcspropinteger).intValue();
        }
    }

    public final long getLoaded(DcsPropLong dcsproplong)
    {
        dcsproplong = ((DcsPropLong) (getLoadedValue(dcsproplong)));
        if (dcsproplong == null)
        {
            return 0L;
        } else
        {
            return ((Long)dcsproplong).longValue();
        }
    }

    public final String getLoaded(DcsPropString dcspropstring)
    {
        return (String)getLoadedValue(dcspropstring);
    }

    public final URL getLoaded(DcsPropUrl dcspropurl)
    {
        return (URL)getLoadedValue(dcspropurl);
    }

    public final boolean getLoaded(DcsPropBoolean dcspropboolean)
    {
        dcspropboolean = ((DcsPropBoolean) (getLoadedValue(dcspropboolean)));
        if (dcspropboolean == null)
        {
            return false;
        } else
        {
            return ((Boolean)dcspropboolean).booleanValue();
        }
    }

    public String getLoadedRules(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        return null;
    }

    protected final Object getLoadedValue(DcsProperty dcsproperty)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        String s;
        s = dcsproperty.key();
        obj = resolvedValues.get(s);
        Object obj1;
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj1 = obj;
        if (resolvedValues.containsKey(s))
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj1 = getLoadedRules(dcsproperty);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = DcsUtil.getFromRules(dcsproperty, obj1, dcsState);
        obj1 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj1 = getDefaultValue(dcsproperty);
        resolvedValues.put(s, obj1);
        this;
        JVM INSTR monitorexit ;
        return obj1;
        dcsproperty;
        throw dcsproperty;
    }

    public final DcsState getState()
    {
        this;
        JVM INSTR monitorenter ;
        DcsState dcsstate = dcsState;
        this;
        JVM INSTR monitorexit ;
        return dcsstate;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract Object getValue(DcsProperty dcsproperty);

    public boolean isStale()
    {
        return false;
    }

    public void refresh(boolean flag, Boolean boolean1)
    {
    }

    public void resetAllDevOverrides()
    {
        this;
        JVM INSTR monitorenter ;
        devOverrides.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected final void resetResolvedValues()
    {
        resolvedValues.clear();
    }

    public void setCountry(EbayCountry ebaycountry)
    {
        this;
        JVM INSTR monitorenter ;
        setState(dcsState.setCountry(ebaycountry));
        this;
        JVM INSTR monitorexit ;
        return;
        ebaycountry;
        throw ebaycountry;
    }

    public final void setDevOverride(DcsPropBoolean dcspropboolean, Boolean boolean1)
    {
        setDevOverrideValue(dcspropboolean, boolean1);
    }

    public final void setDevOverride(DcsPropInteger dcspropinteger, Integer integer)
    {
        setDevOverrideValue(dcspropinteger, integer);
    }

    public final void setDevOverride(DcsPropLong dcsproplong, Long long1)
    {
        setDevOverrideValue(dcsproplong, long1);
    }

    public final void setDevOverride(DcsPropString dcspropstring, Object obj)
    {
        if (obj != null && obj != DEV_OVERRIDE_NULL && !(obj instanceof String))
        {
            throw new IllegalArgumentException("Override must be a String type");
        } else
        {
            setDevOverrideValue(dcspropstring, obj);
            return;
        }
    }

    public final void setDevOverride(DcsPropUrl dcspropurl, Object obj)
    {
        if (obj != null && obj != DEV_OVERRIDE_NULL && !(obj instanceof URL))
        {
            throw new IllegalArgumentException("Override must be a URL type");
        } else
        {
            setDevOverrideValue(dcspropurl, obj);
            return;
        }
    }

    protected void setDevOverrideValue(DcsProperty dcsproperty, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (dcsproperty == DcsNautilusBoolean.QA_ENABLED)
        {
            throw new IllegalArgumentException("Cannot override QA_ENABLED!");
        }
        break MISSING_BLOCK_LABEL_24;
        dcsproperty;
        this;
        JVM INSTR monitorexit ;
        throw dcsproperty;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        devOverrides.remove(dcsproperty.key());
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        devOverrides.put(dcsproperty.key(), obj);
          goto _L1
    }

    public boolean setRolloutThreshold(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (i > 0 && i <= 100)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        throw new IllegalArgumentException("Threshold must be in range [1,100]");
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = setState(dcsState.setRolloutThreshold(i));
        this;
        JVM INSTR monitorexit ;
        return flag;
    }

    protected boolean setState(DcsState dcsstate)
    {
        if (dcsState == dcsstate)
        {
            return false;
        } else
        {
            dcsState = dcsstate;
            reset();
            return true;
        }
    }

    public void setUser(String s)
    {
        this;
        JVM INSTR monitorenter ;
        setState(inst.dcsState.setUser(s));
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
