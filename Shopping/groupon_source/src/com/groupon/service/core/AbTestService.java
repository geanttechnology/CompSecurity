// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import com.groupon.ABTest;
import com.groupon.models.country.Country;
import com.groupon.models.status.Experiment;
import com.groupon.service.ConfigurationChangedProvider;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ObjectMapperWrapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.codehaus.jackson.type.TypeReference;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class AbTestService
    implements ConfigurationChangedProvider
{

    private static final String ABTEST_CONFIGURED = "abTestConfigured";
    private static final Comparator EXPERIMENT_NAME_COMPARATOR = new Comparator() {

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((String)obj, (String)obj1);
        }

        public int compare(String s, String s1)
        {
            String s2 = s.replaceAll("[^0-9]", "");
            String s3 = s1.replaceAll("[^0-9]", "");
            if (s2.isEmpty() && s3.isEmpty())
            {
                return s.compareToIgnoreCase(s1);
            }
            if (s2.isEmpty())
            {
                return -1;
            }
            if (s3.isEmpty())
            {
                return 1;
            }
            int i = Integer.parseInt(s2);
            int j = Integer.parseInt(s3);
            if (i == j)
            {
                return s.compareToIgnoreCase(s1);
            } else
            {
                return i - j;
            }
        }

    };
    private static final String KEY_EXPERIMENT = "KEY_EXPERIMENT";
    private static final String KEY_EXPERIMENT_OVERRIDES = "KEY_EXPERIMENT_OVERRIDES";
    private static final String PREFS_NAME_AB_TEST = "abtests";
    private static final String SCOPE_SESSION = "session";
    private static final String TEST_AUTOMATION = "TEST_AUTOMATION";
    private SharedPreferences abPrefs;
    private Application application;
    private CurrentCountryManager currentCountryManager;
    private boolean isOverridesReadFromPrefs;
    private Map loggedExperimentVariants;
    private Logger logger;
    private Map mapExperimentToVariant;
    private Map mapExperimentToVariantFromServer;
    private Map mapExperimentToVariantOverrides;
    protected ObjectMapperWrapper objectMapper;

    public AbTestService()
    {
        loggedExperimentVariants = new HashMap();
        mapExperimentToVariantFromServer = new HashMap();
        mapExperimentToVariantOverrides = new HashMap();
        mapExperimentToVariant = new HashMap();
    }

    private void doReadOverridesIfNeeded()
    {
        if (!isOverridesReadFromPrefs)
        {
            isOverridesReadFromPrefs = true;
            mapExperimentToVariantOverrides = readExperimentMapFromPreferences("KEY_EXPERIMENT_OVERRIDES");
        }
    }

    private void logExperimentVariant(String s, String s1)
    {
        if (s1 != null && !"".equals(s1))
        {
            String s2 = (String)loggedExperimentVariants.get(s);
            String s3 = (new StringBuilder()).append(s1).append(Calendar.getInstance(TimeZone.getTimeZone("UTC")).get(6)).toString();
            if (s2 == null || !s2.equals(s3))
            {
                Log.e("ABTest", (new StringBuilder()).append("logging: ").append(s).append(" -> ").append(s3).toString());
                logger.logABTest("", s, "", s1, "session", Logger.NULL_NST_FIELD);
                loggedExperimentVariants.put(s, s3);
                return;
            }
        }
    }

    private Map readExperimentMapFromPreferences(String s)
    {
        try
        {
            s = abPrefs.getString(s, null);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.d(s, "Unable to read abtests", new Object[0]);
            return new HashMap();
        }
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_24;
        }
        return new HashMap();
        s = (Map)objectMapper.readValue(s, new TypeReference() {

            final AbTestService this$0;

            
            {
                this$0 = AbTestService.this;
                super();
            }
        });
        return s;
    }

    private void saveExperiments()
    {
        saveMapExperiments("KEY_EXPERIMENT", mapExperimentToVariant);
    }

    private void saveMapExperiments(String s, Map map)
    {
        android.content.SharedPreferences.Editor editor = abPrefs.edit();
        try
        {
            editor.putString(s, objectMapper.writeValueAsString(map));
            editor.apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    private void saveOverrides()
    {
        saveMapExperiments("KEY_EXPERIMENT_OVERRIDES", mapExperimentToVariantOverrides);
        isOverridesReadFromPrefs = true;
    }

    private void setConfigurationState()
    {
        android.content.SharedPreferences.Editor editor = abPrefs.edit();
        editor.putLong("abTestConfigured", System.currentTimeMillis());
        editor.apply();
    }

    public void applyOverrides()
    {
        mapExperimentToVariant.clear();
        mapExperimentToVariant.putAll(mapExperimentToVariantFromServer);
        mapExperimentToVariant.putAll(mapExperimentToVariantOverrides);
        saveExperiments();
    }

    public void clearAllOverrides()
    {
        mapExperimentToVariantOverrides.clear();
        saveOverrides();
        applyOverrides();
    }

    public volatile Serializable getConfigurationState()
    {
        return getConfigurationState();
    }

    public String getConfigurationState()
    {
        return Long.toString(abPrefs.getLong("abTestConfigured", 0L));
    }

    public List getExperimentsMissingFromStatusCall()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = mapExperimentToVariantFromServer.keySet();
        Set set = ((Set) (obj));
        if (((Set) (obj)).size() == 0)
        {
            set = mapExperimentToVariant.keySet();
        }
        obj = ABTest.KNOWN_EXPERIMENTS.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            boolean flag1 = false;
            String s1 = (new StringBuilder()).append("^").append(s.replace("%s", "\\w+")).append("$").toString();
            Iterator iterator = set.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                if (!((String)iterator.next()).matches(s1))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (!flag)
            {
                Log.e("ABTest", (new StringBuilder()).append("experiment: ").append(s).append(" in the code is not returned by the server\n").append("https://birdcage.groupondev.com/experiments?utf8=\u2713&search=").append(s).toString());
                arraylist.add(s);
            }
        } while (true);
        return arraylist;
    }

    public String getOverride(String s)
    {
        return (String)mapExperimentToVariantOverrides.get(s);
    }

    public List getUnusedExperimentsFromStatusCall()
    {
        ArrayList arraylist = new ArrayList();
        Set set = mapExperimentToVariantFromServer.keySet();
        Object obj = set;
        if (set.size() == 0)
        {
            obj = mapExperimentToVariant.keySet();
        }
        obj = ((Set) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            String s = (String)((Iterator) (obj)).next();
            boolean flag1 = false;
            Iterator iterator = ABTest.KNOWN_EXPERIMENTS.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                if (!s.matches((new StringBuilder()).append("^").append(s1.replace("%s", "\\w+")).append("$").toString()))
                {
                    continue;
                }
                flag = true;
                break;
            } while (true);
            if (!flag)
            {
                Log.e("ABTest", (new StringBuilder()).append("experiment: ").append(s).append(" returned by the server, but not used in code\n").append("https://birdcage.groupondev.com/experiments?utf8=\u2713&search=").append(s).toString());
                arraylist.add(s);
            }
        } while (true);
        Collections.sort(arraylist, EXPERIMENT_NAME_COMPARATOR);
        return arraylist;
    }

    public String getVariant(String s)
    {
        String s1 = getVariantWithoutLogging(s);
        logExperimentVariant(s, s1);
        return s1;
    }

    public int getVariantAsInt(String s)
    {
        boolean flag = false;
        s = getVariant(s);
        int i = ((flag) ? 1 : 0);
        if (Strings.notEmpty(s))
        {
            i = ((flag) ? 1 : 0);
            if (!Strings.equalsIgnoreCase(s, "Original"))
            {
                try
                {
                    i = Integer.parseInt(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    Ln.v(s);
                    return 0;
                }
            }
        }
        return i;
    }

    public String getVariantWithoutLogging(String s)
    {
        s = (String)mapExperimentToVariant.get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return "";
        }
    }

    public void init()
    {
        abPrefs = application.getSharedPreferences("abtests", 0);
        mapExperimentToVariant = readExperimentMapFromPreferences("KEY_EXPERIMENT");
        if (mapExperimentToVariant.get("TEST_AUTOMATION") != null)
        {
            mapExperimentToVariantOverrides.putAll(mapExperimentToVariant);
            saveOverrides();
        }
    }

    public boolean isINTLVariantEnabled(String s, String s1)
    {
        boolean flag = false;
        String s2;
        if (currentCountryManager.getCurrentCountry() != null)
        {
            s2 = currentCountryManager.getCurrentCountry().shortName.toUpperCase();
        } else
        {
            s2 = "";
        }
        s2 = getVariant(String.format(s, new Object[] {
            s2
        }));
        if (Strings.notEmpty(s2))
        {
            flag = Strings.equalsIgnoreCase(s2, s1);
        } else
        {
            String s3 = getVariant(String.format(s, new Object[] {
                "INT"
            }));
            if (Strings.notEmpty(s3))
            {
                return Strings.equalsIgnoreCase(s3, s1);
            }
            s = getVariant(String.format(s, new Object[] {
                "INTL"
            }));
            if (Strings.notEmpty(s))
            {
                return Strings.equalsIgnoreCase(s, s1);
            }
        }
        return flag;
    }

    public boolean isVariantEnabled(String s, String s1)
    {
        return Strings.equalsIgnoreCase(getVariant(s), s1);
    }

    public boolean isVariantEnabledAndUS(String s, String s1)
    {
        return currentCountryManager.getCurrentCountry() != null && currentCountryManager.getCurrentCountry().isUSOnly() && isVariantEnabled(s, s1);
    }

    public boolean isVariantEnabledAndUSCA(String s, String s1)
    {
        return currentCountryManager.getCurrentCountry() != null && currentCountryManager.getCurrentCountry().isUSACompatible() && isVariantEnabled(s, s1);
    }

    public boolean isVariantListEnabled(String s, String s1)
    {
        s = getVariant(s);
        if (s != null)
        {
            s = s.split(",");
            int j = s.length;
            int i = 0;
            while (i < j) 
            {
                if (s[i].trim().equalsIgnoreCase(s1))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public boolean isVariantListEnabledAndUSCA(String s, String s1)
    {
        return isVariantListEnabled(s, s1) && currentCountryManager.getCurrentCountry() != null && currentCountryManager.getCurrentCountry().isUSACompatible();
    }

    public List listExperiments()
    {
        ArrayList arraylist = new ArrayList(mapExperimentToVariant.keySet());
        Collections.sort(arraylist, EXPERIMENT_NAME_COMPARATOR);
        return arraylist;
    }

    public List listExperimentsOverrides()
    {
        doReadOverridesIfNeeded();
        ArrayList arraylist = new ArrayList(mapExperimentToVariantOverrides.keySet());
        Collections.sort(arraylist, EXPERIMENT_NAME_COMPARATOR);
        return arraylist;
    }

    public Map mapExperimentsOverrides()
    {
        return mapExperimentToVariantOverrides;
    }

    public void refresh(List list)
    {
        mapExperimentToVariantFromServer.clear();
        if (list != null)
        {
            String s;
            Object obj;
            for (list = list.iterator(); list.hasNext(); mapExperimentToVariantFromServer.put(s, obj))
            {
                obj = (Experiment)list.next();
                s = ((Experiment) (obj)).id;
                obj = ((Experiment) (obj)).variant;
            }

        }
        doReadOverridesIfNeeded();
        applyOverrides();
        setConfigurationState();
    }

    public void removeOverride(String s)
    {
        mapExperimentToVariantOverrides.remove(s);
        saveOverrides();
        applyOverrides();
    }

    public void setOverride(String s, String s1)
    {
        mapExperimentToVariantOverrides.put(s, s1);
        saveOverrides();
        applyOverrides();
    }

    public void setOverrideByMap(Map map)
    {
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            String s1 = (String)map.get(s);
            if (s1 == null)
            {
                mapExperimentToVariantOverrides.remove(s);
            } else
            {
                mapExperimentToVariantOverrides.put(s, s1);
            }
        }

        saveOverrides();
        applyOverrides();
    }

}
