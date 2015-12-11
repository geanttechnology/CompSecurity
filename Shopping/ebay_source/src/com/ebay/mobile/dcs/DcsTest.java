// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import android.util.Log;
import com.ebay.common.util.EbaySettings;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.experimentation.Experiments;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.dcs.DcsDomain;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsPropLong;
import com.ebay.nautilus.domain.dcs.DcsPropString;
import com.ebay.nautilus.domain.dcs.DcsPropUrl;
import com.ebay.nautilus.domain.dcs.DcsProperty;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DcsUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ApiSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.dcs:
//            Dcs

public class DcsTest
{
    private static final class DumpInfo
    {

        private static final String NOT_SET = "[Not set]";
        public String configurationValue;
        public Object defaultValue;
        public Object evaluatedValue;
        public final String key;

        public static DumpInfo get(Map map, String s)
        {
            DumpInfo dumpinfo1 = (DumpInfo)map.get(s);
            DumpInfo dumpinfo = dumpinfo1;
            if (dumpinfo1 == null)
            {
                dumpinfo = new DumpInfo(s);
                map.put(s, dumpinfo);
            }
            return dumpinfo;
        }

        public static DumpInfo remove(Map map, String s)
        {
            DumpInfo dumpinfo = (DumpInfo)map.remove(s);
            map = dumpinfo;
            if (dumpinfo == null)
            {
                map = new DumpInfo(s);
            }
            return map;
        }

        public String toString()
        {
            return (new StringBuilder()).append(key).append("\n{\n  default:").append(defaultValue).append("\n  evaluated:").append(evaluatedValue).append("\n  configValue:").append(configurationValue).append("\n}").toString();
        }

        public DumpInfo(String s)
        {
            defaultValue = "[Not set]";
            evaluatedValue = "[Not set]";
            configurationValue = "[Not set]";
            key = s;
        }
    }

    public static final class Endpoint
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        public List getProperties()
        {
            int i = ApiSettings.values().length + EbaySettings.values().length;
            if (i == 0)
            {
                return Collections.emptyList();
            } else
            {
                ArrayList arraylist = new ArrayList(i);
                Collections.addAll(arraylist, ApiSettings.values());
                Collections.addAll(arraylist, EbaySettings.values());
                return Collections.unmodifiableList(arraylist);
            }
        }

        public Endpoint()
        {
        }
    }

    public static final class Experiment
        implements com.ebay.nautilus.domain.dcs.DcsDomain.Domain
    {

        public List getProperties()
        {
            List list = Experiments.getExperiments();
            ArrayList arraylist = new ArrayList(list.size());
            arraylist.addAll(list);
            return Collections.unmodifiableList(arraylist);
        }

        public Experiment()
        {
        }
    }


    private final DcsUtil dcsUtil = new DcsUtil(getUsedCountryCodes());
    private final DcsState dummyState;
    private final StringBuilder errors = new StringBuilder();
    private final HashMap keys = new HashMap();

    private DcsTest()
    {
        dummyState = new DcsState(EbayCountry.getInstance(EbaySite.US), null, 0);
    }

    public static void dumpAll()
    {
        DeviceConfiguration deviceconfiguration = DeviceConfiguration.getNoSync();
        Object obj = deviceconfiguration.debugGetProperties();
        HashMap hashmap = new HashMap();
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            DumpInfo.get(hashmap, (String)entry.getKey()).configurationValue = (String)entry.getValue();
        }

        TreeMap treemap = new TreeMap();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain[] = getDomains();
        int j = adomain.length;
        for (int i = 0; i < j; i++)
        {
            Iterator iterator2 = adomain[i].getProperties().iterator();
            while (iterator2.hasNext()) 
            {
                Object obj1 = (DcsProperty)iterator2.next();
                DumpInfo dumpinfo = DumpInfo.remove(hashmap, ((DcsProperty) (obj1)).key());
                if (obj1 instanceof DcsPropBoolean)
                {
                    DcsPropBoolean dcspropboolean = (DcsPropBoolean)obj1;
                    if (deviceconfiguration.getDefault(dcspropboolean))
                    {
                        obj1 = "enabled";
                    } else
                    {
                        obj1 = "disabled";
                    }
                    dumpinfo.defaultValue = obj1;
                    if (deviceconfiguration.get(dcspropboolean))
                    {
                        obj1 = "enabled";
                    } else
                    {
                        obj1 = "disabled";
                    }
                    dumpinfo.evaluatedValue = obj1;
                } else
                if (obj1 instanceof DcsPropInteger)
                {
                    obj1 = (DcsPropInteger)obj1;
                    dumpinfo.defaultValue = Integer.valueOf(deviceconfiguration.getDefault(((DcsPropInteger) (obj1))));
                    dumpinfo.evaluatedValue = Integer.valueOf(deviceconfiguration.get(((DcsPropInteger) (obj1))));
                } else
                if (obj1 instanceof DcsPropLong)
                {
                    obj1 = (DcsPropLong)obj1;
                    dumpinfo.defaultValue = Long.valueOf(deviceconfiguration.getDefault(((DcsPropLong) (obj1))));
                    dumpinfo.evaluatedValue = Long.valueOf(deviceconfiguration.get(((DcsPropLong) (obj1))));
                } else
                if (obj1 instanceof DcsPropString)
                {
                    obj1 = (DcsPropString)obj1;
                    dumpinfo.defaultValue = deviceconfiguration.getDefault(((DcsPropString) (obj1)));
                    dumpinfo.evaluatedValue = deviceconfiguration.get(((DcsPropString) (obj1)));
                } else
                if (obj1 instanceof DcsPropUrl)
                {
                    obj1 = (DcsPropUrl)obj1;
                    dumpinfo.defaultValue = deviceconfiguration.getDefault(((DcsPropUrl) (obj1)));
                    dumpinfo.evaluatedValue = deviceconfiguration.get(((DcsPropUrl) (obj1)));
                } else
                {
                    throw new RuntimeException((new StringBuilder()).append("Unknown property type for ").append(obj1.getClass().getName()).toString());
                }
                treemap.put(dumpinfo.key, dumpinfo);
            }
        }

        Log.d("DeviceConfig", "--------------------------------------------------------------------------------");
        Log.d("DeviceConfig", "Device configuration properties dump");
        Log.d("DeviceConfig", "--------------------------------------------------------------------------------");
        for (Iterator iterator = treemap.values().iterator(); iterator.hasNext(); Log.d("DeviceConfig", ((DumpInfo)iterator.next()).toString())) { }
        if (!hashmap.isEmpty())
        {
            treemap.clear();
            treemap.putAll(hashmap);
            Log.d("DeviceConfig", "--------------------------------------------------------------------------------");
            Log.d("DeviceConfig", "Unmapped properties");
            Log.d("DeviceConfig", "--------------------------------------------------------------------------------");
            for (Iterator iterator1 = treemap.values().iterator(); iterator1.hasNext(); Log.d("DeviceConfig", ((DumpInfo)iterator1.next()).toString())) { }
        }
    }

    public static com.ebay.nautilus.domain.dcs.DcsDomain.Domain[] getDomains()
    {
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain[] = DcsDomain.getDomains();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain1[] = Dcs.getDomains();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain2[] = new com.ebay.nautilus.domain.dcs.DcsDomain.Domain[adomain.length + adomain1.length + 2];
        System.arraycopy(adomain, 0, adomain2, 0, adomain.length);
        System.arraycopy(adomain1, 0, adomain2, adomain.length, adomain1.length);
        adomain2[adomain2.length - 2] = new Endpoint();
        adomain2[adomain2.length - 1] = new Experiment();
        return adomain2;
    }

    public static Set getUsedCountryCodes()
    {
        HashSet hashset = new HashSet();
        hashset.addAll(EbayCountryManager.getGbhCountryCodes());
        for (Iterator iterator = EbaySite.getAvailableInstances().iterator(); iterator.hasNext(); hashset.add(((EbaySite)iterator.next()).localeCountry)) { }
        return Collections.unmodifiableSet(hashset);
    }

    public static void validateDefaults()
        throws IllegalArgumentException
    {
        DcsTest dcstest = new DcsTest();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain[] = getDomains();
        int j = adomain.length;
        for (int i = 0; i < j; i++)
        {
            for (Iterator iterator = adomain[i].getProperties().iterator(); iterator.hasNext(); dcstest.validateLocal((DcsProperty)iterator.next())) { }
        }

        if (dcstest.errors.length() != 0)
        {
            throw new IllegalArgumentException(dcstest.errors.toString());
        } else
        {
            return;
        }
    }

    public static void validateLoadedRules(DeviceConfiguration deviceconfiguration)
        throws IllegalArgumentException
    {
        DcsTest dcstest = new DcsTest();
        com.ebay.nautilus.domain.dcs.DcsDomain.Domain adomain[] = getDomains();
        int j = adomain.length;
        for (int i = 0; i < j; i++)
        {
            for (Iterator iterator = adomain[i].getProperties().iterator(); iterator.hasNext(); dcstest.validateRemote((DcsProperty)iterator.next(), deviceconfiguration)) { }
        }

        if (dcstest.errors.length() != 0)
        {
            throw new IllegalArgumentException(dcstest.errors.toString());
        } else
        {
            return;
        }
    }

    private void validateLocal(DcsProperty dcsproperty)
        throws IllegalArgumentException
    {
        Object obj = (DcsProperty)keys.put(dcsproperty.key(), dcsproperty);
        if (obj != null)
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("Key \"").append(dcsproperty.key()).append("\" for ").append(dcsproperty.getClass().getName());
            if (dcsproperty instanceof Enum)
            {
                stringbuilder.append('.').append(dcsproperty);
            }
            stringbuilder.append(" already defined for ").append(obj.getClass().getName());
            if (obj instanceof Enum)
            {
                stringbuilder.append('.').append(obj);
            }
            throw new IllegalArgumentException(stringbuilder.toString());
        }
        obj = dcsproperty.getClass();
        if (((Class) (obj)).isEnum() && ((Class) (obj)).getSimpleName().length() == 1 && com/ebay/nautilus/domain/dcs/DcsDomain$Domain.isAssignableFrom(((Class) (obj)).getDeclaringClass()))
        {
            String s = dcsproperty.key();
            int i = s.indexOf('.');
            if (i == -1)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid property name: ").append(s).toString());
            }
            String s1 = s.substring(0, i);
            if (!s1.equals(s1.toLowerCase(Locale.US)))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Domain name must all be lower case: ").append(s).toString());
            }
            s1 = s.substring(i + 1);
            if (!dcsproperty.toString().equals(s1))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Suffix '").append(s).append("' must match the enum value name '").append(dcsproperty).append('\'').toString());
            }
            boolean flag = true;
            int k = s1.length();
            for (int j = 0; j < k; j++)
            {
                boolean flag1 = Character.isUpperCase(s1.charAt(j));
                if (flag1 && flag)
                {
                    throw new IllegalArgumentException("Name must be camel case starting with a lower case character");
                }
                flag = flag1;
            }

        }
        validateValue(dcsproperty, dcsproperty.defaultValue(dummyState));
    }

    private void validateRemote(DcsProperty dcsproperty, DeviceConfiguration deviceconfiguration)
    {
        try
        {
            validateValue(dcsproperty, deviceconfiguration.getLoadedRules(dcsproperty));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DcsProperty dcsproperty) { }
        if (errors.length() != 0)
        {
            errors.append("\n\n");
        }
        errors.append(dcsproperty.getMessage());
    }

    private void validateValue(DcsProperty dcsproperty, Object obj)
        throws IllegalArgumentException
    {
        try
        {
            dcsUtil.validateValue(dcsproperty, obj, dummyState);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(dcsproperty.key()).append(" {").append(((Exception) (obj)).getMessage()).append('}').toString(), ((Throwable) (obj)));
        }
    }
}
