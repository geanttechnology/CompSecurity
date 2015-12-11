// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.AgentImpl;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.tracing.ActivityTrace;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceLifecycleAware;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.newrelic.agent.android.analytics:
//            AnalyticsController, EventManagerImpl, EventManager, AnalyticAttribute, 
//            AnalyticsEvent, AnalyticsEventFactory, AnalyticsEventCategory, AnalyticAttributeStore

public class AnalyticsControllerImpl
    implements AnalyticsController
{
    class InteractionCompleteListener
        implements TraceLifecycleAware
    {

        final AnalyticsControllerImpl this$0;

        private AnalyticsEvent createTraceEvent(ActivityTrace activitytrace)
        {
            float f = activitytrace.rootTrace.getDurationAsSeconds();
            HashSet hashset = new HashSet();
            hashset.add(new AnalyticAttribute("interactionDuration", f));
            return AnalyticsEventFactory.createEvent(activitytrace.rootTrace.displayName, AnalyticsEventCategory.Interaction, "Mobile", hashset);
        }

        public void onEnterMethod()
        {
        }

        public void onExitMethod()
        {
        }

        public void onTraceComplete(ActivityTrace activitytrace)
        {
            AnalyticsControllerImpl.log.debug("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete invoke.");
            activitytrace = createTraceEvent(activitytrace);
            AnalyticsControllerImpl.getInstance().addEvent(activitytrace);
        }

        public void onTraceStart(ActivityTrace activitytrace)
        {
        }

        InteractionCompleteListener()
        {
            this$0 = AnalyticsControllerImpl.this;
            super();
        }
    }


    private static final int MAX_ATTRIBUTES = 64;
    private static final String NEW_RELIC_PREFIX = "newRelic";
    private static final String NR_PREFIX = "nr.";
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static final AnalyticsControllerImpl instance = new AnalyticsControllerImpl();
    static final AgentLog log = AgentLogManager.getAgentLog();
    private static final List reservedNames = new ArrayList();
    private AgentConfiguration agentConfiguration;
    private AgentImpl agentImpl;
    private EventManager eventManager;
    private boolean isEnabled;
    private InteractionCompleteListener listener;
    private Set systemAttributes;
    private Set userAttributes;

    private AnalyticsControllerImpl()
    {
        eventManager = new EventManagerImpl();
        systemAttributes = Collections.synchronizedSet(new HashSet());
        userAttributes = Collections.synchronizedSet(new HashSet());
        listener = new InteractionCompleteListener();
    }

    private void clear()
    {
        log.debug("AnalyticsControllerImpl.clear - clearing out attributes and events");
        systemAttributes.clear();
        userAttributes.clear();
        eventManager.empty();
    }

    public static AnalyticsControllerImpl getInstance()
    {
        return instance;
    }

    private AnalyticAttribute getSystemAttribute(String s)
    {
        for (Iterator iterator = systemAttributes.iterator(); iterator.hasNext();)
        {
            AnalyticAttribute analyticattribute = (AnalyticAttribute)iterator.next();
            if (analyticattribute.getName().equals(s))
            {
                return analyticattribute;
            }
        }

        return null;
    }

    private AnalyticAttribute getUserAttribute(String s)
    {
        for (Iterator iterator = userAttributes.iterator(); iterator.hasNext();)
        {
            AnalyticAttribute analyticattribute = (AnalyticAttribute)iterator.next();
            if (analyticattribute.getName().equals(s))
            {
                return analyticattribute;
            }
        }

        return null;
    }

    public static void initialize(AgentConfiguration agentconfiguration, AgentImpl agentimpl)
    {
        log.debug("AnalyticsControllerImpl.initialize invoked.");
        if (!initialized.compareAndSet(false, true))
        {
            log.debug("AnalyticsControllerImpl has already been initialized.  Bypassing..");
            return;
        } else
        {
            instance.clear();
            reservedNames.add("eventType");
            reservedNames.add("type");
            reservedNames.add("timestamp");
            reservedNames.add("category");
            reservedNames.add("accountId");
            reservedNames.add("appId");
            reservedNames.add("appName");
            reservedNames.add("uuid");
            reservedNames.add("sessionId");
            reservedNames.add("osName");
            reservedNames.add("osVersion");
            reservedNames.add("osMajorVersion");
            reservedNames.add("deviceManufacturer");
            reservedNames.add("deviceModel");
            reservedNames.add("memUsageMb");
            reservedNames.add("carrier");
            reservedNames.add("newRelicVersion");
            reservedNames.add("interactionDuration");
            instance.reinitialize(agentconfiguration, agentimpl);
            TraceMachine.addTraceListener(instance.listener);
            log.info("Analytics Controller started.");
            return;
        }
    }

    private boolean isNameReserved(String s)
    {
        boolean flag1 = reservedNames.contains(s);
        if (flag1)
        {
            log.debug((new StringBuilder()).append("Name ").append(s).append(" is in the reserved names list.").toString());
        } else
        {
            boolean flag;
            if (flag1 || s.startsWith("newRelic"))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                log.debug((new StringBuilder()).append("Name ").append(s).append(" starts with reserved prefix ").append("newRelic").toString());
                return flag;
            }
            if (flag || s.startsWith("nr."))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            flag1 = flag;
            if (flag)
            {
                log.debug((new StringBuilder()).append("Name ").append(s).append(" starts with reserved prefix ").append("nr.").toString());
                return flag;
            }
        }
        return flag1;
    }

    private boolean isNameValid(String s)
    {
        boolean flag;
        boolean flag2;
        if (s != null && !s.equals("") && s.length() < 256)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            log.error((new StringBuilder()).append("Attribute name ").append(s).append(" is null, empty, or exceeds the maximum length of ").append(256).append(" characters.").toString());
            flag2 = flag;
        } else
        {
            boolean flag1;
            if (!isNameReserved(s))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag1;
            if (!flag1)
            {
                log.error((new StringBuilder()).append("Attribute name ").append(s).append(" is reserved for internal use and will be ignored.").toString());
                return flag1;
            }
        }
        return flag2;
    }

    private boolean isStringValueValid(String s, String s1)
    {
        boolean flag;
        if (s1 != null && !s1.equals("") && s1.getBytes().length < 4096)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            log.error((new StringBuilder()).append("Attribute value for name ").append(s).append(" is null, empty, or exceeds the maximum length of ").append(4096).append(" bytes.").toString());
        }
        return flag;
    }

    public static void shutdown()
    {
        TraceMachine.removeTraceListener(instance.listener);
        initialized.compareAndSet(true, false);
        instance.getEventManager().shutdown();
    }

    public boolean addEvent(AnalyticsEvent analyticsevent)
    {
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        } else
        {
            HashSet hashset = new HashSet();
            hashset.add(new AnalyticAttribute("timeSinceLoad", (float)agentImpl.getSessionDurationMillis() / 1000F));
            analyticsevent.addAttributes(hashset);
            return eventManager.addEvent(analyticsevent);
        }
    }

    public boolean addEvent(String s, AnalyticsEventCategory analyticseventcategory, String s1, Set set)
    {
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        }
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.addEvent - ").append(s).append(": category=").append(analyticseventcategory).append(", eventType: ").append(s1).append(", eventAttributes:").append(set).toString());
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            AnalyticAttribute analyticattribute = (AnalyticAttribute)set.next();
            if (isNameValid(analyticattribute.getName()))
            {
                hashset.add(analyticattribute);
            }
        } while (true);
        return addEvent(AnalyticsEventFactory.createEvent(s, analyticseventcategory, s1, hashset));
    }

    public boolean addEvent(String s, Set set)
    {
        return addEvent(s, AnalyticsEventCategory.Custom, "Mobile", set);
    }

    public AnalyticAttribute getAttribute(String s)
    {
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.getAttribute - retrieving ").append(s).toString());
        AnalyticAttribute analyticattribute1 = getUserAttribute(s);
        AnalyticAttribute analyticattribute = analyticattribute1;
        if (analyticattribute1 == null)
        {
            analyticattribute = getSystemAttribute(s);
        }
        return analyticattribute;
    }

    public EventManager getEventManager()
    {
        return eventManager;
    }

    public int getMaxEventBufferTime()
    {
        return eventManager.getMaxEventBufferTime();
    }

    public int getMaxEventPoolSize()
    {
        return eventManager.getMaxEventPoolSize();
    }

    public int getSessionAttributeCount()
    {
        return systemAttributes.size() + userAttributes.size();
    }

    public Set getSessionAttributes()
    {
        HashSet hashset = new HashSet(getSessionAttributeCount());
        hashset.addAll(getSystemAttributes());
        hashset.addAll(getUserAttributes());
        return Collections.unmodifiableSet(hashset);
    }

    public int getSystemAttributeCount()
    {
        return systemAttributes.size();
    }

    public Set getSystemAttributes()
    {
        HashSet hashset = new HashSet(systemAttributes.size());
        for (Iterator iterator = systemAttributes.iterator(); iterator.hasNext(); hashset.add(new AnalyticAttribute((AnalyticAttribute)iterator.next()))) { }
        return Collections.unmodifiableSet(hashset);
    }

    public int getUserAttributeCount()
    {
        return userAttributes.size();
    }

    public Set getUserAttributes()
    {
        HashSet hashset = new HashSet(userAttributes.size());
        for (Iterator iterator = userAttributes.iterator(); iterator.hasNext(); hashset.add(new AnalyticAttribute((AnalyticAttribute)iterator.next()))) { }
        return Collections.unmodifiableSet(hashset);
    }

    public boolean incrementAttribute(String s, float f)
    {
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.incrementAttribute - ").append(s).append(": ").append(f).toString());
        return incrementAttribute(s, f, true);
    }

    public boolean incrementAttribute(String s, float f, boolean flag)
    {
label0:
        {
            AgentLog agentlog = log;
            StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticsControllerImpl.incrementAttribute - ").append(s).append(": ").append(f);
            Object obj;
            if (flag)
            {
                obj = " (persistent)";
            } else
            {
                obj = " (transient)";
            }
            agentlog.debug(stringbuilder.append(((String) (obj))).toString());
            if (!initialized.get())
            {
                log.warning("Analytics controller is not initialized!");
                return false;
            }
            if (!isEnabled)
            {
                log.warning("Analytics controller is not enabled!");
                return false;
            }
            if (!isNameValid(s))
            {
                return false;
            }
            obj = getAttribute(s);
            if (obj != null && !((AnalyticAttribute) (obj)).isStringAttribute())
            {
                ((AnalyticAttribute) (obj)).setFloatValue(((AnalyticAttribute) (obj)).getFloatValue() + f);
                ((AnalyticAttribute) (obj)).setPersistent(flag);
                if (((AnalyticAttribute) (obj)).isPersistent())
                {
                    flag = agentConfiguration.getAnalyticAttributeStore().store(((AnalyticAttribute) (obj)));
                    if (!flag)
                    {
                        log.error((new StringBuilder()).append("Failed to store attribute ").append(obj).append(" to attribute store.").toString());
                        return flag;
                    }
                }
            } else
            {
                if (obj != null)
                {
                    break label0;
                }
                if (userAttributes.size() < 64)
                {
                    s = new AnalyticAttribute(s, f, flag);
                    userAttributes.add(s);
                    if (s.isPersistent())
                    {
                        agentConfiguration.getAnalyticAttributeStore().store(s);
                        flag = agentConfiguration.getAnalyticAttributeStore().store(s);
                        if (!flag)
                        {
                            log.error((new StringBuilder()).append("Failed to store attribute ").append(s).append(" to attribute store.").toString());
                            return flag;
                        }
                    } else
                    {
                        agentConfiguration.getAnalyticAttributeStore().delete(s);
                    }
                }
            }
            return true;
        }
        log.warning((new StringBuilder()).append("Cannot increment attribute ").append(s).append(": the attribute is already defined as a String value.").toString());
        return false;
    }

    void loadPersistentAttributes()
    {
        log.debug("AnalyticsControllerImpl.loadPersistentAttributes - loading userAttributes from the attribute store...");
        Object obj = agentConfiguration.getAnalyticAttributeStore().fetchAll();
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.loadPersistentAttributes - found ").append(((List) (obj)).size()).append(" userAttributes in the attribute store...").toString());
        AnalyticAttribute analyticattribute;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); userAttributes.add(analyticattribute))
        {
            analyticattribute = (AnalyticAttribute)((Iterator) (obj)).next();
        }

    }

    public boolean recordEvent(String s, Map map)
    {
        HashSet hashset;
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.recordEvent - ").append(s).append(": ").append(map.size()).append(" attributes").toString());
        hashset = new HashSet();
        Iterator iterator = map.keySet().iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s1;
        Object obj;
        s1 = (String)iterator.next();
        obj = map.get(s1);
        if (!(obj instanceof String)) goto _L4; else goto _L3
_L3:
        hashset.add(new AnalyticAttribute(s1, (String)obj));
          goto _L5
        obj;
        log.error(String.format("Error casting attribute [%s] to String or Float: ", new Object[] {
            s1
        }), ((Throwable) (obj)));
          goto _L5
        map;
        log.error(String.format("Error occurred while recording event [%s]: ", new Object[] {
            s
        }), map);
_L2:
        return addEvent(s, AnalyticsEventCategory.Custom, "Mobile", hashset);
_L4:
label0:
        {
            if (!(obj instanceof Float))
            {
                break label0;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((Float)obj).floatValue()).floatValue()));
        }
          goto _L5
label1:
        {
            if (!(obj instanceof Double))
            {
                break label1;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((Double)obj).floatValue()).floatValue()));
        }
          goto _L5
label2:
        {
            if (!(obj instanceof Integer))
            {
                break label2;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((Integer)obj).intValue()).floatValue()));
        }
          goto _L5
label3:
        {
            if (!(obj instanceof Short))
            {
                break label3;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((Short)obj).shortValue()).floatValue()));
        }
          goto _L5
label4:
        {
            if (!(obj instanceof Long))
            {
                break label4;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((Long)obj).longValue()).floatValue()));
        }
          goto _L5
label5:
        {
            if (!(obj instanceof BigDecimal))
            {
                break label5;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((BigDecimal)obj).floatValue()).floatValue()));
        }
          goto _L5
label6:
        {
            if (!(obj instanceof BigInteger))
            {
                break label6;
            }
            hashset.add(new AnalyticAttribute(s1, Float.valueOf(((BigInteger)obj).floatValue()).floatValue()));
        }
          goto _L5
        log.error((new StringBuilder()).append("Unsupported event attribute type for key [").append(s1).append("]: ").append(obj.getClass().getName()).toString());
        return false;
    }

    void reinitialize(AgentConfiguration agentconfiguration, AgentImpl agentimpl)
    {
        agentImpl = agentimpl;
        agentConfiguration = agentconfiguration;
        eventManager.initialize();
        isEnabled = agentconfiguration.getEnableAnalyticsEvents();
        loadPersistentAttributes();
        removeAttribute("sessionDuration");
        DeviceInformation deviceinformation = agentimpl.getDeviceInformation();
        String s1 = deviceinformation.getOsVersion().replace(" ", "");
        String as[] = s1.split("[.:-]");
        String s;
        EnvironmentInformation environmentinformation;
        if (as.length > 0)
        {
            s = as[0];
        } else
        {
            s = s1;
        }
        environmentinformation = agentimpl.getEnvironmentInformation();
        systemAttributes.add(new AnalyticAttribute("osName", deviceinformation.getOsName()));
        systemAttributes.add(new AnalyticAttribute("osVersion", s1));
        systemAttributes.add(new AnalyticAttribute("osMajorVersion", s));
        systemAttributes.add(new AnalyticAttribute("deviceManufacturer", deviceinformation.getManufacturer()));
        systemAttributes.add(new AnalyticAttribute("deviceModel", deviceinformation.getModel()));
        systemAttributes.add(new AnalyticAttribute("uuid", deviceinformation.getDeviceId()));
        systemAttributes.add(new AnalyticAttribute("carrier", agentimpl.getNetworkCarrier()));
        systemAttributes.add(new AnalyticAttribute("newRelicVersion", deviceinformation.getAgentVersion()));
        systemAttributes.add(new AnalyticAttribute("memUsageMb", environmentinformation.getMemoryUsage()));
        systemAttributes.add(new AnalyticAttribute("sessionId", agentconfiguration.getSessionID()));
    }

    public boolean removeAllAttributes()
    {
        log.debug("AnalyticsControllerImpl.removeAttributes - ");
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        } else
        {
            agentConfiguration.getAnalyticAttributeStore().clear();
            userAttributes.clear();
            return false;
        }
    }

    public boolean removeAttribute(String s)
    {
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.removeAttribute - ").append(s).toString());
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        }
        s = getAttribute(s);
        if (s != null)
        {
            userAttributes.remove(s);
            if (s.isPersistent())
            {
                agentConfiguration.getAnalyticAttributeStore().delete(s);
            }
        }
        return true;
    }

    public boolean setAttribute(String s, float f)
    {
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(f).toString());
        return setAttribute(s, f, true);
    }

    public boolean setAttribute(String s, float f, boolean flag)
    {
        AgentLog agentlog = log;
        StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(f);
        Object obj;
        if (flag)
        {
            obj = " (persistent)";
        } else
        {
            obj = " (transient)";
        }
        agentlog.debug(stringbuilder.append(((String) (obj))).toString());
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        }
        if (!isNameValid(s))
        {
            return false;
        }
        obj = getAttribute(s);
        if (obj == null)
        {
            if (userAttributes.size() < 64)
            {
                s = new AnalyticAttribute(s, f, true);
                userAttributes.add(s);
                if (flag)
                {
                    agentConfiguration.getAnalyticAttributeStore().store(s);
                    flag = agentConfiguration.getAnalyticAttributeStore().store(s);
                    if (!flag)
                    {
                        log.error((new StringBuilder()).append("Failed to store attribute ").append(s).append(" to attribute store.").toString());
                        return flag;
                    }
                }
            } else
            {
                log.warning("Attribute limit exceeded: at most 64 are allowed.");
                log.warning("Currently defined attributes:");
                obj = userAttributes.iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    s = (AnalyticAttribute)((Iterator) (obj)).next();
                    AgentLog agentlog1 = log;
                    StringBuilder stringbuilder1 = (new StringBuilder()).append("\t").append(s.getName()).append(": ");
                    if (s.isStringAttribute())
                    {
                        s = s.getStringValue();
                    } else
                    {
                        s = Float.valueOf(s.getFloatValue());
                    }
                    agentlog1.warning(stringbuilder1.append(s).toString());
                }
            }
        } else
        {
            ((AnalyticAttribute) (obj)).setFloatValue(f);
            ((AnalyticAttribute) (obj)).setPersistent(flag);
            if (((AnalyticAttribute) (obj)).isPersistent())
            {
                flag = agentConfiguration.getAnalyticAttributeStore().store(((AnalyticAttribute) (obj)));
                if (!flag)
                {
                    log.error((new StringBuilder()).append("Failed to store attribute ").append(obj).append(" to attribute store.").toString());
                    return flag;
                }
            } else
            {
                agentConfiguration.getAnalyticAttributeStore().delete(((AnalyticAttribute) (obj)));
            }
        }
        return true;
    }

    public boolean setAttribute(String s, String s1)
    {
        log.debug((new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(s1).toString());
        return setAttribute(s, s1, true);
    }

    public boolean setAttribute(String s, String s1, boolean flag)
    {
        AgentLog agentlog = log;
        StringBuilder stringbuilder1 = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(s1);
        Object obj;
        if (flag)
        {
            obj = " (persistent)";
        } else
        {
            obj = " (transient)";
        }
        agentlog.debug(stringbuilder1.append(((String) (obj))).toString());
        if (!initialized.get())
        {
            log.warning("Analytics controller is not initialized!");
            return false;
        }
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        }
        if (!isNameValid(s) || !isStringValueValid(s, s1))
        {
            return false;
        }
        obj = getAttribute(s);
        if (obj == null)
        {
            if (userAttributes.size() < 64)
            {
                s = new AnalyticAttribute(s, s1, true);
                userAttributes.add(s);
                if (flag)
                {
                    flag = agentConfiguration.getAnalyticAttributeStore().store(s);
                    if (!flag)
                    {
                        log.error((new StringBuilder()).append("Failed to store attribute ").append(s).append(" to attribute store.").toString());
                        return flag;
                    }
                }
            } else
            {
                log.warning("Attribute limit exceeded: at most 64 are allowed.");
                log.warning("Currently defined attributes:");
                s1 = userAttributes.iterator();
                while (s1.hasNext()) 
                {
                    s = (AnalyticAttribute)s1.next();
                    obj = log;
                    StringBuilder stringbuilder = (new StringBuilder()).append("\t").append(s.getName()).append(": ");
                    if (s.isStringAttribute())
                    {
                        s = s.getStringValue();
                    } else
                    {
                        s = Float.valueOf(s.getFloatValue());
                    }
                    ((AgentLog) (obj)).warning(stringbuilder.append(s).toString());
                }
            }
        } else
        {
            ((AnalyticAttribute) (obj)).setStringValue(s1);
            ((AnalyticAttribute) (obj)).setPersistent(flag);
            if (((AnalyticAttribute) (obj)).isPersistent())
            {
                flag = agentConfiguration.getAnalyticAttributeStore().store(((AnalyticAttribute) (obj)));
                if (!flag)
                {
                    log.error((new StringBuilder()).append("Failed to store attribute ").append(obj).append(" to attribute store.").toString());
                    return flag;
                }
            } else
            {
                agentConfiguration.getAnalyticAttributeStore().delete(((AnalyticAttribute) (obj)));
            }
        }
        return true;
    }

    public void setMaxEventBufferTime(int i)
    {
        eventManager.setMaxEventBufferTime(i);
    }

    public void setMaxEventPoolSize(int i)
    {
        eventManager.setMaxEventPoolSize(i);
    }

}
