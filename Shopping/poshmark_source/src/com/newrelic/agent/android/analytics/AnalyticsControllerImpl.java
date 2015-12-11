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
//            AnalyticAttributeStore, AnalyticsEvent, AnalyticsEventFactory, AnalyticsEventCategory

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
            AnalyticsControllerImpl.log.verbose("AnalyticsControllerImpl.InteractionCompleteListener.onTraceComplete invoke.");
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


    protected static final int MAX_ATTRIBUTES = 64;
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
        if (log.getLevel() == 4)
        {
            log.verbose("AnalyticsControllerImpl.clear - clearing out attributes and events");
        }
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
        Object obj = null;
        Iterator iterator = systemAttributes.iterator();
        AnalyticAttribute analyticattribute;
        do
        {
            analyticattribute = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            analyticattribute = (AnalyticAttribute)iterator.next();
        } while (!analyticattribute.getName().equals(s));
        return analyticattribute;
    }

    private AnalyticAttribute getUserAttribute(String s)
    {
        Object obj = null;
        Iterator iterator = userAttributes.iterator();
        AnalyticAttribute analyticattribute;
        do
        {
            analyticattribute = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            analyticattribute = (AnalyticAttribute)iterator.next();
        } while (!analyticattribute.getName().equals(s));
        return analyticattribute;
    }

    public static void initialize(AgentConfiguration agentconfiguration, AgentImpl agentimpl)
    {
        log.verbose("AnalyticsControllerImpl.initialize invoked.");
        if (!initialized.compareAndSet(false, true))
        {
            log.verbose("AnalyticsControllerImpl has already been initialized.  Bypassing..");
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
            reservedNames.add("install");
            reservedNames.add("upgradeFrom");
            instance.reinitialize(agentconfiguration, agentimpl);
            TraceMachine.addTraceListener(instance.listener);
            log.info("Analytics Controller started.");
            return;
        }
    }

    private boolean isAttributeNameValid(String s)
    {
        boolean flag = isNameValid(s);
        boolean flag2 = flag;
        if (flag)
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
                flag2 = flag1;
            }
        }
        return flag2;
    }

    private boolean isInitializedAndEnabled()
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
            return true;
        }
    }

    private boolean isNameReserved(String s)
    {
        boolean flag = reservedNames.contains(s);
        if (flag)
        {
            if (log.getLevel() == 4)
            {
                log.verbose((new StringBuilder()).append("Name ").append(s).append(" is in the reserved names list.").toString());
            }
            return flag;
        }
        if (flag || s.startsWith("newRelic"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (log.getLevel() == 4)
            {
                log.verbose((new StringBuilder()).append("Name ").append(s).append(" starts with reserved prefix ").append("newRelic").toString());
            }
            return flag;
        }
        if (flag || s.startsWith("nr."))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && log.getLevel() == 4)
        {
            log.verbose((new StringBuilder()).append("Name ").append(s).append(" starts with reserved prefix ").append("nr.").toString());
        }
        return flag;
    }

    private boolean isNameValid(String s)
    {
        boolean flag;
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
        }
        return flag;
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

    public boolean addAttributeUnchecked(AnalyticAttribute analyticattribute, boolean flag)
    {
        String s1;
        s1 = analyticattribute.getName();
        String s = analyticattribute.valueAsString();
        AgentLog agentlog = log;
        StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticsControllerImpl.setAttributeUnchecked - ").append(s1).append(": ").append(s);
        if (flag)
        {
            s = " (persistent)";
        } else
        {
            s = " (transient)";
        }
        agentlog.verbose(stringbuilder.append(s).toString());
        if (initialized.get()) goto _L2; else goto _L1
_L1:
        log.warning("Analytics controller is not initialized!");
_L4:
        return false;
_L2:
        if (!isEnabled)
        {
            log.warning("Analytics controller is not enabled!");
            return false;
        }
        if (!isNameValid(s1)) goto _L4; else goto _L3
_L3:
        AnalyticAttribute analyticattribute1;
        analyticattribute1 = getAttribute(analyticattribute.getName());
        if (analyticattribute1 == null)
        {
            userAttributes.add(analyticattribute);
            if (analyticattribute.isPersistent())
            {
                agentConfiguration.getAnalyticAttributeStore().store(analyticattribute);
                flag = agentConfiguration.getAnalyticAttributeStore().store(analyticattribute);
                if (!flag)
                {
                    log.error((new StringBuilder()).append("Failed to store attribute ").append(analyticattribute).append(" to attribute store.").toString());
                    return flag;
                }
            }
            break MISSING_BLOCK_LABEL_376;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[];

            static 
            {
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType = new int[AnalyticAttribute.AttributeDataType.values().length];
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AnalyticAttribute.AttributeDataType.STRING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AnalyticAttribute.AttributeDataType.FLOAT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType[AnalyticAttribute.AttributeDataType.BOOLEAN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.newrelic.agent.android.analytics.AnalyticAttribute.AttributeDataType[analyticattribute.getAttributeDataType().ordinal()];
        JVM INSTR tableswitch 1 3: default 264
    //                   1 330
    //                   2 341
    //                   3 352;
           goto _L5 _L6 _L7 _L8
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        break MISSING_BLOCK_LABEL_352;
_L9:
        analyticattribute1.setPersistent(flag);
        if (analyticattribute1.isPersistent())
        {
            flag = agentConfiguration.getAnalyticAttributeStore().store(analyticattribute1);
            if (!flag)
            {
                log.error((new StringBuilder()).append("Failed to store attribute ").append(analyticattribute1).append(" to attribute store.").toString());
                return flag;
            }
        } else
        {
            agentConfiguration.getAnalyticAttributeStore().delete(analyticattribute1);
        }
        break MISSING_BLOCK_LABEL_376;
_L6:
        analyticattribute1.setStringValue(analyticattribute.getStringValue());
          goto _L9
_L7:
        analyticattribute1.setFloatValue(analyticattribute.getFloatValue());
          goto _L9
        analyticattribute1.setBooleanValue(analyticattribute.getBooleanValue());
          goto _L9
        return true;
    }

    public boolean addEvent(AnalyticsEvent analyticsevent)
    {
        if (!isInitializedAndEnabled())
        {
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.addEvent - ").append(s).append(": category=").append(analyticseventcategory).append(", eventType: ").append(s1).append(", eventAttributes:").append(set).toString());
        if (!isInitializedAndEnabled())
        {
            return false;
        }
        HashSet hashset = new HashSet();
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            AnalyticAttribute analyticattribute = (AnalyticAttribute)set.next();
            if (isAttributeNameValid(analyticattribute.getName()))
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.getAttribute - retrieving ").append(s).toString());
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.incrementAttribute - ").append(s).append(": ").append(f).toString());
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
            agentlog.verbose(stringbuilder.append(((String) (obj))).toString());
            while (!isInitializedAndEnabled() || !isAttributeNameValid(s)) 
            {
                return false;
            }
            obj = getAttribute(s);
            if (obj != null && ((AnalyticAttribute) (obj)).isFloatAttribute())
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
        log.warning((new StringBuilder()).append("Cannot increment attribute ").append(s).append(": the attribute is already defined as a non-float value.").toString());
        return false;
    }

    void loadPersistentAttributes()
    {
        if (log.getLevel() == 4)
        {
            log.verbose("AnalyticsControllerImpl.loadPersistentAttributes - loading userAttributes from the attribute store...");
        }
        Object obj = agentConfiguration.getAnalyticAttributeStore().fetchAll();
        if (log.getLevel() == 4)
        {
            log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.loadPersistentAttributes - found ").append(((List) (obj)).size()).append(" userAttributes in the attribute store...").toString());
        }
        AnalyticAttribute analyticattribute;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); userAttributes.add(analyticattribute))
        {
            analyticattribute = (AnalyticAttribute)((Iterator) (obj)).next();
        }

    }

    public boolean recordEvent(String s, Map map)
    {
        HashSet hashset;
        if (log.getLevel() == 4)
        {
            log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.recordEvent - ").append(s).append(": ").append(map.size()).append(" attributes").toString());
        }
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
        hashset.add(new AnalyticAttribute(s1, String.valueOf(obj)));
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
label7:
        {
            if (!(obj instanceof Boolean))
            {
                break label7;
            }
            hashset.add(new AnalyticAttribute(s1, Boolean.valueOf(((Boolean)obj).booleanValue()).booleanValue()));
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
        log.verbose("AnalyticsControllerImpl.removeAttributes - ");
        if (!isInitializedAndEnabled())
        {
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.removeAttribute - ").append(s).toString());
        if (!isInitializedAndEnabled())
        {
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(f).toString());
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
        agentlog.verbose(stringbuilder.append(((String) (obj))).toString());
        while (!isInitializedAndEnabled() || !isAttributeNameValid(s)) 
        {
            return false;
        }
        obj = getAttribute(s);
        if (obj == null)
        {
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
                }
            } else
            {
                log.warning("Attribute limit exceeded: at most 64 are allowed.");
                log.warning("Currently defined attributes:");
                for (s = userAttributes.iterator(); s.hasNext(); log.warning((new StringBuilder()).append("\t").append(((AnalyticAttribute) (obj)).getName()).append(": ").append(((AnalyticAttribute) (obj)).valueAsString()).toString()))
                {
                    obj = (AnalyticAttribute)s.next();
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
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(s1).toString());
        return setAttribute(s, s1, true);
    }

    public boolean setAttribute(String s, String s1, boolean flag)
    {
        AgentLog agentlog = log;
        StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(s1);
        Object obj;
        if (flag)
        {
            obj = " (persistent)";
        } else
        {
            obj = " (transient)";
        }
        agentlog.verbose(stringbuilder.append(((String) (obj))).toString());
        while (!isInitializedAndEnabled() || !isAttributeNameValid(s) || !isStringValueValid(s, s1)) 
        {
            return false;
        }
        obj = getAttribute(s);
        if (obj == null)
        {
            if (userAttributes.size() < 64)
            {
                s = new AnalyticAttribute(s, s1, flag);
                userAttributes.add(s);
                if (s.isPersistent())
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
                for (s = userAttributes.iterator(); s.hasNext(); log.warning((new StringBuilder()).append("\t").append(s1.getName()).append(": ").append(s1.valueAsString()).toString()))
                {
                    s1 = (AnalyticAttribute)s.next();
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

    public boolean setAttribute(String s, boolean flag)
    {
        log.verbose((new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(flag).toString());
        return setAttribute(s, flag, true);
    }

    public boolean setAttribute(String s, boolean flag, boolean flag1)
    {
        AgentLog agentlog = log;
        StringBuilder stringbuilder = (new StringBuilder()).append("AnalyticsControllerImpl.setAttribute - ").append(s).append(": ").append(flag);
        Object obj;
        if (flag1)
        {
            obj = " (persistent)";
        } else
        {
            obj = " (transient)";
        }
        agentlog.verbose(stringbuilder.append(((String) (obj))).toString());
        while (!isInitializedAndEnabled() || !isAttributeNameValid(s)) 
        {
            return false;
        }
        obj = getAttribute(s);
        if (obj == null)
        {
            if (userAttributes.size() < 64)
            {
                s = new AnalyticAttribute(s, flag, flag1);
                userAttributes.add(s);
                if (s.isPersistent())
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
                for (s = userAttributes.iterator(); s.hasNext(); log.warning((new StringBuilder()).append("\t").append(((AnalyticAttribute) (obj)).getName()).append(": ").append(((AnalyticAttribute) (obj)).valueAsString()).toString()))
                {
                    obj = (AnalyticAttribute)s.next();
                }

            }
        } else
        {
            ((AnalyticAttribute) (obj)).setBooleanValue(flag);
            ((AnalyticAttribute) (obj)).setPersistent(flag1);
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
