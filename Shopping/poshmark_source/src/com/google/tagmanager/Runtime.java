// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            ObjectAndStatic, Types, NoopEventInfoDistributor, CacheFactory, 
//            ArbitraryPixelTag, CustomFunctionCall, UniversalAnalyticsTag, ContainsPredicate, 
//            EndsWithPredicate, EqualsPredicate, GreaterEqualsPredicate, GreaterThanPredicate, 
//            LessEqualsPredicate, LessThanPredicate, RegexPredicate, StartsWithPredicate, 
//            AdvertiserIdMacro, AdvertisingTrackingEnabledMacro, AdwordsClickReferrerMacro, AppIdMacro, 
//            AppNameMacro, AppVersionMacro, ConstantMacro, DataLayerMacro, 
//            DeviceIdMacro, DeviceNameMacro, EncodeMacro, EventMacro, 
//            GtmVersionMacro, HashMacro, InstallReferrerMacro, JoinerMacro, 
//            LanguageMacro, MobileAdwordsUniqueIdMacro, OsVersionMacro, PlatformMacro, 
//            RandomMacro, RegexGroupMacro, ResolutionMacro, RuntimeVersionMacro, 
//            SdkVersionMacro, TimeMacro, EventInfoDistributor, FunctionCallImplementation, 
//            RuleEvaluationStepInfoBuilder, Cache, Log, MacroEvaluationInfoBuilder, 
//            ResolvedFunctionCallBuilder, ResolvedPropertyBuilder, ResourceUtil, ValueBuilder, 
//            ValueEscapeUtil, EventInfoBuilder, ResolvedRuleBuilder, DataLayerEventEvaluationInfoBuilder, 
//            DataLayer, ResolvedFunctionCallTranslatorList

class Runtime
{
    static interface AddRemoveSetPopulator
    {

        public abstract void rulePassed(ResourceUtil.ExpandedRule expandedrule, Set set, Set set1, ResolvedRuleBuilder resolvedrulebuilder);
    }

    private static class MacroInfo
    {

        private final Map mAddMacroNames = new HashMap();
        private final Map mAddMacros = new HashMap();
        private ResourceUtil.ExpandedFunctionCall mDefault;
        private final Map mRemoveMacroNames = new HashMap();
        private final Map mRemoveMacros = new HashMap();
        private final Set mRules = new HashSet();

        public void addAddMacroForRule(ResourceUtil.ExpandedRule expandedrule, ResourceUtil.ExpandedFunctionCall expandedfunctioncall)
        {
            List list = (List)mAddMacros.get(expandedrule);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                mAddMacros.put(expandedrule, obj);
            }
            ((List) (obj)).add(expandedfunctioncall);
        }

        public void addAddMacroRuleNameForRule(ResourceUtil.ExpandedRule expandedrule, String s)
        {
            List list = (List)mAddMacroNames.get(expandedrule);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                mAddMacroNames.put(expandedrule, obj);
            }
            ((List) (obj)).add(s);
        }

        public void addRemoveMacroForRule(ResourceUtil.ExpandedRule expandedrule, ResourceUtil.ExpandedFunctionCall expandedfunctioncall)
        {
            List list = (List)mRemoveMacros.get(expandedrule);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                mRemoveMacros.put(expandedrule, obj);
            }
            ((List) (obj)).add(expandedfunctioncall);
        }

        public void addRemoveMacroRuleNameForRule(ResourceUtil.ExpandedRule expandedrule, String s)
        {
            List list = (List)mRemoveMacroNames.get(expandedrule);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                mRemoveMacroNames.put(expandedrule, obj);
            }
            ((List) (obj)).add(s);
        }

        public void addRule(ResourceUtil.ExpandedRule expandedrule)
        {
            mRules.add(expandedrule);
        }

        public Map getAddMacroRuleNames()
        {
            return mAddMacroNames;
        }

        public Map getAddMacros()
        {
            return mAddMacros;
        }

        public ResourceUtil.ExpandedFunctionCall getDefault()
        {
            return mDefault;
        }

        public Map getRemoveMacroRuleNames()
        {
            return mRemoveMacroNames;
        }

        public Map getRemoveMacros()
        {
            return mRemoveMacros;
        }

        public Set getRules()
        {
            return mRules;
        }

        public void setDefault(ResourceUtil.ExpandedFunctionCall expandedfunctioncall)
        {
            mDefault = expandedfunctioncall;
        }

        public MacroInfo()
        {
        }
    }


    static final String DEFAULT_RULE_NAME = "Unknown";
    private static final ObjectAndStatic DEFAULT_VALUE_AND_STATIC = new ObjectAndStatic(Types.getDefaultValue(), true);
    private static final int MAX_CACHE_SIZE = 0x100000;
    private final EventInfoDistributor eventInfoDistributor;
    private volatile String mCurrentEventName;
    private final Cache mFunctionCallCache;
    private final Cache mMacroEvaluationCache;
    private final Map mMacroLookup;
    private final Map mMacroMap;
    private final Map mPredicateMap;
    private final ResourceUtil.ExpandedResource mResource;
    private final Set mRules;
    private final Map mTrackingTagMap;

    public Runtime(Context context, ResourceUtil.ExpandedResource expandedresource, DataLayer datalayer, CustomFunctionCall.CustomEvaluator customevaluator, CustomFunctionCall.CustomEvaluator customevaluator1)
    {
        this(context, expandedresource, datalayer, customevaluator, customevaluator1, ((EventInfoDistributor) (new NoopEventInfoDistributor())));
    }

    public Runtime(Context context, ResourceUtil.ExpandedResource expandedresource, DataLayer datalayer, CustomFunctionCall.CustomEvaluator customevaluator, CustomFunctionCall.CustomEvaluator customevaluator1, EventInfoDistributor eventinfodistributor)
    {
        if (expandedresource == null)
        {
            throw new NullPointerException("resource cannot be null");
        }
        mResource = expandedresource;
        mRules = new HashSet(expandedresource.getRules());
        eventInfoDistributor = eventinfodistributor;
        expandedresource = new CacheFactory.CacheSizeManager() {

            final Runtime this$0;

            public int sizeOf(ResourceUtil.ExpandedFunctionCall expandedfunctioncall, ObjectAndStatic objectandstatic)
            {
                return ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic.getObject()).toByteArray().length;
            }

            public volatile int sizeOf(Object obj, Object obj1)
            {
                return sizeOf((ResourceUtil.ExpandedFunctionCall)obj, (ObjectAndStatic)obj1);
            }

            
            {
                this$0 = Runtime.this;
                super();
            }
        };
        mFunctionCallCache = (new CacheFactory()).createCache(0x100000, expandedresource);
        expandedresource = new CacheFactory.CacheSizeManager() {

            final Runtime this$0;

            public volatile int sizeOf(Object obj, Object obj1)
            {
                return sizeOf((String)obj, (ObjectAndStatic)obj1);
            }

            public int sizeOf(String s, ObjectAndStatic objectandstatic)
            {
                int k = s.length();
                return ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic.getObject()).toByteArray().length + k;
            }

            
            {
                this$0 = Runtime.this;
                super();
            }
        };
        mMacroEvaluationCache = (new CacheFactory()).createCache(0x100000, expandedresource);
        mTrackingTagMap = new HashMap();
        addTrackingTag(new ArbitraryPixelTag(context));
        addTrackingTag(new CustomFunctionCall(customevaluator1));
        addTrackingTag(new UniversalAnalyticsTag(context, datalayer));
        mPredicateMap = new HashMap();
        addPredicate(new ContainsPredicate());
        addPredicate(new EndsWithPredicate());
        addPredicate(new EqualsPredicate());
        addPredicate(new GreaterEqualsPredicate());
        addPredicate(new GreaterThanPredicate());
        addPredicate(new LessEqualsPredicate());
        addPredicate(new LessThanPredicate());
        addPredicate(new RegexPredicate());
        addPredicate(new StartsWithPredicate());
        mMacroMap = new HashMap();
        addMacro(new AdvertiserIdMacro(context));
        addMacro(new AdvertisingTrackingEnabledMacro());
        addMacro(new AdwordsClickReferrerMacro(context));
        addMacro(new AppIdMacro(context));
        addMacro(new AppNameMacro(context));
        addMacro(new AppVersionMacro(context));
        addMacro(new ConstantMacro());
        addMacro(new CustomFunctionCall(customevaluator));
        addMacro(new DataLayerMacro(datalayer));
        addMacro(new DeviceIdMacro(context));
        addMacro(new DeviceNameMacro());
        addMacro(new EncodeMacro());
        addMacro(new EventMacro(this));
        addMacro(new GtmVersionMacro());
        addMacro(new HashMacro());
        addMacro(new InstallReferrerMacro(context));
        addMacro(new JoinerMacro());
        addMacro(new LanguageMacro());
        addMacro(new MobileAdwordsUniqueIdMacro(context));
        addMacro(new OsVersionMacro());
        addMacro(new PlatformMacro());
        addMacro(new RandomMacro());
        addMacro(new RegexGroupMacro());
        addMacro(new ResolutionMacro(context));
        addMacro(new RuntimeVersionMacro());
        addMacro(new SdkVersionMacro());
        addMacro(new TimeMacro());
        mMacroLookup = new HashMap();
        for (datalayer = mRules.iterator(); datalayer.hasNext();)
        {
            customevaluator = (ResourceUtil.ExpandedRule)datalayer.next();
            if (eventinfodistributor.debugMode())
            {
                verifyFunctionAndNameListSizes(customevaluator.getAddMacros(), customevaluator.getAddMacroRuleNames(), "add macro");
                verifyFunctionAndNameListSizes(customevaluator.getRemoveMacros(), customevaluator.getRemoveMacroRuleNames(), "remove macro");
                verifyFunctionAndNameListSizes(customevaluator.getAddTags(), customevaluator.getAddTagRuleNames(), "add tag");
                verifyFunctionAndNameListSizes(customevaluator.getRemoveTags(), customevaluator.getRemoveTagRuleNames(), "remove tag");
            }
            for (int i = 0; i < customevaluator.getAddMacros().size(); i++)
            {
                customevaluator1 = (ResourceUtil.ExpandedFunctionCall)customevaluator.getAddMacros().get(i);
                expandedresource = "Unknown";
                context = expandedresource;
                if (eventinfodistributor.debugMode())
                {
                    context = expandedresource;
                    if (i < customevaluator.getAddMacroRuleNames().size())
                    {
                        context = (String)customevaluator.getAddMacroRuleNames().get(i);
                    }
                }
                expandedresource = getOrAddMacroInfo(mMacroLookup, getFunctionName(customevaluator1));
                expandedresource.addRule(customevaluator);
                expandedresource.addAddMacroForRule(customevaluator, customevaluator1);
                expandedresource.addAddMacroRuleNameForRule(customevaluator, context);
            }

            int j = 0;
            while (j < customevaluator.getRemoveMacros().size()) 
            {
                customevaluator1 = (ResourceUtil.ExpandedFunctionCall)customevaluator.getRemoveMacros().get(j);
                expandedresource = "Unknown";
                context = expandedresource;
                if (eventinfodistributor.debugMode())
                {
                    context = expandedresource;
                    if (j < customevaluator.getRemoveMacroRuleNames().size())
                    {
                        context = (String)customevaluator.getRemoveMacroRuleNames().get(j);
                    }
                }
                expandedresource = getOrAddMacroInfo(mMacroLookup, getFunctionName(customevaluator1));
                expandedresource.addRule(customevaluator);
                expandedresource.addRemoveMacroForRule(customevaluator, customevaluator1);
                expandedresource.addRemoveMacroRuleNameForRule(customevaluator, context);
                j++;
            }
        }

        for (context = mResource.getAllMacros().entrySet().iterator(); context.hasNext();)
        {
            expandedresource = (java.util.Map.Entry)context.next();
            datalayer = ((List)expandedresource.getValue()).iterator();
            while (datalayer.hasNext()) 
            {
                customevaluator = (ResourceUtil.ExpandedFunctionCall)datalayer.next();
                if (!Types.valueToBoolean((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)customevaluator.getProperties().get(Key.NOT_DEFAULT_MACRO.toString())).booleanValue())
                {
                    getOrAddMacroInfo(mMacroLookup, (String)expandedresource.getKey()).setDefault(customevaluator);
                }
            }
        }

    }

    private static void addFunctionImplToMap(Map map, FunctionCallImplementation functioncallimplementation)
    {
        if (map.containsKey(functioncallimplementation.getInstanceFunctionId()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate function type name: ").append(functioncallimplementation.getInstanceFunctionId()).toString());
        } else
        {
            map.put(functioncallimplementation.getInstanceFunctionId(), functioncallimplementation);
            return;
        }
    }

    private ObjectAndStatic calculateGenericToRun(Set set, Set set1, AddRemoveSetPopulator addremovesetpopulator, RuleEvaluationStepInfoBuilder ruleevaluationstepinfobuilder)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        boolean flag = true;
        for (set = set.iterator(); set.hasNext();)
        {
            ResourceUtil.ExpandedRule expandedrule = (ResourceUtil.ExpandedRule)set.next();
            ResolvedRuleBuilder resolvedrulebuilder = ruleevaluationstepinfobuilder.createResolvedRuleBuilder();
            ObjectAndStatic objectandstatic = evaluatePredicatesInRule(expandedrule, set1, resolvedrulebuilder);
            if (((Boolean)objectandstatic.getObject()).booleanValue())
            {
                addremovesetpopulator.rulePassed(expandedrule, hashset, hashset1, resolvedrulebuilder);
            }
            if (flag && objectandstatic.isStatic())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        hashset.removeAll(hashset1);
        ruleevaluationstepinfobuilder.setEnabledFunctions(hashset);
        return new ObjectAndStatic(hashset, flag);
    }

    private ObjectAndStatic evaluateMacroReferenceCycleDetection(String s, Set set, MacroEvaluationInfoBuilder macroevaluationinfobuilder)
    {
        Object obj = (ObjectAndStatic)mMacroEvaluationCache.get(s);
        if (obj != null && !eventInfoDistributor.debugMode())
        {
            return ((ObjectAndStatic) (obj));
        }
        obj = (MacroInfo)mMacroLookup.get(s);
        if (obj == null)
        {
            Log.e((new StringBuilder()).append("Invalid macro: ").append(s).toString());
            return DEFAULT_VALUE_AND_STATIC;
        }
        ObjectAndStatic objectandstatic = calculateMacrosToRun(s, ((MacroInfo) (obj)).getRules(), ((MacroInfo) (obj)).getAddMacros(), ((MacroInfo) (obj)).getAddMacroRuleNames(), ((MacroInfo) (obj)).getRemoveMacros(), ((MacroInfo) (obj)).getRemoveMacroRuleNames(), set, macroevaluationinfobuilder.createRulesEvaluation());
        if (((Set)objectandstatic.getObject()).isEmpty())
        {
            obj = ((MacroInfo) (obj)).getDefault();
        } else
        {
            if (((Set)objectandstatic.getObject()).size() > 1)
            {
                Log.w((new StringBuilder()).append("Multiple macros active for macroName ").append(s).toString());
            }
            obj = (ResourceUtil.ExpandedFunctionCall)((Set)objectandstatic.getObject()).iterator().next();
        }
        if (obj == null)
        {
            return DEFAULT_VALUE_AND_STATIC;
        }
        set = executeFunction(mMacroMap, ((ResourceUtil.ExpandedFunctionCall) (obj)), set, macroevaluationinfobuilder.createResult());
        boolean flag;
        if (objectandstatic.isStatic() && set.isStatic())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (set == DEFAULT_VALUE_AND_STATIC)
        {
            set = DEFAULT_VALUE_AND_STATIC;
        } else
        {
            set = new ObjectAndStatic(set.getObject(), flag);
        }
        if (set.isStatic())
        {
            mMacroEvaluationCache.put(s, set);
        }
        return set;
    }

    private ObjectAndStatic executeFunction(Map map, ResourceUtil.ExpandedFunctionCall expandedfunctioncall, Set set, ResolvedFunctionCallBuilder resolvedfunctioncallbuilder)
    {
        Object obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)expandedfunctioncall.getProperties().get(Key.FUNCTION.toString());
        if (obj == null)
        {
            Log.e("No function id in properties");
            map = DEFAULT_VALUE_AND_STATIC;
        } else
        {
            obj = ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)).getFunctionId();
            FunctionCallImplementation functioncallimplementation = (FunctionCallImplementation)map.get(obj);
            if (functioncallimplementation == null)
            {
                Log.e((new StringBuilder()).append(((String) (obj))).append(" has no backing implementation.").toString());
                return DEFAULT_VALUE_AND_STATIC;
            }
            map = (ObjectAndStatic)mFunctionCallCache.get(expandedfunctioncall);
            if (map == null || eventInfoDistributor.debugMode())
            {
                map = new HashMap();
                boolean flag = true;
                Iterator iterator = expandedfunctioncall.getProperties().entrySet().iterator();
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj1 = resolvedfunctioncallbuilder.createResolvedPropertyBuilder((String)entry.getKey());
                    obj1 = macroExpandValue((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)entry.getValue(), set, ((ResolvedPropertyBuilder) (obj1)).createPropertyValueBuilder((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)entry.getValue()));
                    if (obj1 == DEFAULT_VALUE_AND_STATIC)
                    {
                        return DEFAULT_VALUE_AND_STATIC;
                    }
                    if (((ObjectAndStatic) (obj1)).isStatic())
                    {
                        expandedfunctioncall.updateCacheableProperty((String)entry.getKey(), (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)((ObjectAndStatic) (obj1)).getObject());
                    } else
                    {
                        flag = false;
                    }
                    map.put(entry.getKey(), ((ObjectAndStatic) (obj1)).getObject());
                }
                if (!functioncallimplementation.hasRequiredKeys(map.keySet()))
                {
                    Log.e((new StringBuilder()).append("Incorrect keys for function ").append(((String) (obj))).append(" required ").append(functioncallimplementation.getRequiredKeys()).append(" had ").append(map.keySet()).toString());
                    return DEFAULT_VALUE_AND_STATIC;
                }
                boolean flag1;
                if (flag && functioncallimplementation.isCacheable())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                map = new ObjectAndStatic(functioncallimplementation.evaluate(map), flag1);
                if (flag1)
                {
                    mFunctionCallCache.put(expandedfunctioncall, map);
                }
                resolvedfunctioncallbuilder.setFunctionResult((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.getObject());
                return map;
            }
        }
        return map;
    }

    private static String getFunctionName(ResourceUtil.ExpandedFunctionCall expandedfunctioncall)
    {
        return Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)expandedfunctioncall.getProperties().get(Key.INSTANCE_NAME.toString()));
    }

    private static MacroInfo getOrAddMacroInfo(Map map, String s)
    {
        MacroInfo macroinfo1 = (MacroInfo)map.get(s);
        MacroInfo macroinfo = macroinfo1;
        if (macroinfo1 == null)
        {
            macroinfo = new MacroInfo();
            map.put(s, macroinfo);
        }
        return macroinfo;
    }

    private ObjectAndStatic macroExpandValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value, Set set, ValueBuilder valuebuilder)
    {
        if (!value.getContainsReferences())
        {
            return new ObjectAndStatic(value, true);
        }
        static class _cls5
        {

            static final int $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[];

            static 
            {
                $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.values().length];
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MACRO_REFERENCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.TEMPLATE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder2;
        int k;
        switch (_cls5..SwitchMap.com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type[value.getType().ordinal()])
        {
        default:
            Log.e((new StringBuilder()).append("Unknown type: ").append(value.getType()).toString());
            return DEFAULT_VALUE_AND_STATIC;

        case 1: // '\001'
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder = ResourceUtil.newValueBuilderBasedOnValue(value);
            for (int i = 0; i < value.getListItemCount(); i++)
            {
                ObjectAndStatic objectandstatic = macroExpandValue(value.getListItem(i), set, valuebuilder.getListItem(i));
                if (objectandstatic == DEFAULT_VALUE_AND_STATIC)
                {
                    return DEFAULT_VALUE_AND_STATIC;
                }
                builder.addListItem((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic.getObject());
            }

            return new ObjectAndStatic(builder.build(), false);

        case 2: // '\002'
            com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder1 = ResourceUtil.newValueBuilderBasedOnValue(value);
            if (value.getMapKeyCount() != value.getMapValueCount())
            {
                Log.e((new StringBuilder()).append("Invalid serving value: ").append(value.toString()).toString());
                return DEFAULT_VALUE_AND_STATIC;
            }
            for (int j = 0; j < value.getMapKeyCount(); j++)
            {
                ObjectAndStatic objectandstatic1 = macroExpandValue(value.getMapKey(j), set, valuebuilder.getMapKey(j));
                ObjectAndStatic objectandstatic3 = macroExpandValue(value.getMapValue(j), set, valuebuilder.getMapValue(j));
                if (objectandstatic1 == DEFAULT_VALUE_AND_STATIC || objectandstatic3 == DEFAULT_VALUE_AND_STATIC)
                {
                    return DEFAULT_VALUE_AND_STATIC;
                }
                builder1.addMapKey((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic1.getObject());
                builder1.addMapValue((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic3.getObject());
            }

            return new ObjectAndStatic(builder1.build(), false);

        case 3: // '\003'
            if (set.contains(value.getMacroReference()))
            {
                Log.e((new StringBuilder()).append("Macro cycle detected.  Current macro reference: ").append(value.getMacroReference()).append(".").append("  Previous macro references: ").append(set.toString()).append(".").toString());
                return DEFAULT_VALUE_AND_STATIC;
            } else
            {
                set.add(value.getMacroReference());
                valuebuilder = ValueEscapeUtil.applyEscapings(evaluateMacroReferenceCycleDetection(value.getMacroReference(), set, valuebuilder.createValueMacroEvaluationInfoExtension()), value.getEscapingList());
                set.remove(value.getMacroReference());
                return valuebuilder;
            }

        case 4: // '\004'
            builder2 = ResourceUtil.newValueBuilderBasedOnValue(value);
            k = 0;
            break;
        }
        for (; k < value.getTemplateTokenCount(); k++)
        {
            ObjectAndStatic objectandstatic2 = macroExpandValue(value.getTemplateToken(k), set, valuebuilder.getTemplateToken(k));
            if (objectandstatic2 == DEFAULT_VALUE_AND_STATIC)
            {
                return DEFAULT_VALUE_AND_STATIC;
            }
            builder2.addTemplateToken((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)objectandstatic2.getObject());
        }

        return new ObjectAndStatic(builder2.build(), false);
    }

    private static void verifyFunctionAndNameListSizes(List list, List list1, String s)
    {
        if (list.size() != list1.size())
        {
            Log.i((new StringBuilder()).append("Invalid resource: imbalance of rule names of functions for ").append(s).append(" operation. Using default rule name instead").toString());
        }
    }

    void addMacro(FunctionCallImplementation functioncallimplementation)
    {
        addFunctionImplToMap(mMacroMap, functioncallimplementation);
    }

    void addPredicate(FunctionCallImplementation functioncallimplementation)
    {
        addFunctionImplToMap(mPredicateMap, functioncallimplementation);
    }

    void addTrackingTag(FunctionCallImplementation functioncallimplementation)
    {
        addFunctionImplToMap(mTrackingTagMap, functioncallimplementation);
    }

    ObjectAndStatic calculateMacrosToRun(String s, Set set, final Map addMacros, final Map addMacroRuleNames, final Map removeMacros, final Map removeMacroRuleNames, Set set1, 
            RuleEvaluationStepInfoBuilder ruleevaluationstepinfobuilder)
    {
        return calculateGenericToRun(set, set1, new AddRemoveSetPopulator() {

            final Runtime this$0;
            final Map val$addMacroRuleNames;
            final Map val$addMacros;
            final Map val$removeMacroRuleNames;
            final Map val$removeMacros;

            public void rulePassed(ResourceUtil.ExpandedRule expandedrule, Set set2, Set set3, ResolvedRuleBuilder resolvedrulebuilder)
            {
                List list = (List)addMacros.get(expandedrule);
                List list1 = (List)addMacroRuleNames.get(expandedrule);
                if (list != null)
                {
                    set2.addAll(list);
                    resolvedrulebuilder.getAddedMacroFunctions().translateAndAddAll(list, list1);
                }
                set2 = (List)removeMacros.get(expandedrule);
                expandedrule = (List)removeMacroRuleNames.get(expandedrule);
                if (set2 != null)
                {
                    set3.addAll(set2);
                    resolvedrulebuilder.getRemovedMacroFunctions().translateAndAddAll(set2, expandedrule);
                }
            }

            
            {
                this$0 = Runtime.this;
                addMacros = map;
                addMacroRuleNames = map1;
                removeMacros = map2;
                removeMacroRuleNames = map3;
                super();
            }
        }, ruleevaluationstepinfobuilder);
    }

    ObjectAndStatic calculateTagsToRun(Set set, RuleEvaluationStepInfoBuilder ruleevaluationstepinfobuilder)
    {
        return calculateGenericToRun(set, new HashSet(), new AddRemoveSetPopulator() {

            final Runtime this$0;

            public void rulePassed(ResourceUtil.ExpandedRule expandedrule, Set set1, Set set2, ResolvedRuleBuilder resolvedrulebuilder)
            {
                set1.addAll(expandedrule.getAddTags());
                set2.addAll(expandedrule.getRemoveTags());
                resolvedrulebuilder.getAddedTagFunctions().translateAndAddAll(expandedrule.getAddTags(), expandedrule.getAddTagRuleNames());
                resolvedrulebuilder.getRemovedTagFunctions().translateAndAddAll(expandedrule.getRemoveTags(), expandedrule.getRemoveTagRuleNames());
            }

            
            {
                this$0 = Runtime.this;
                super();
            }
        }, ruleevaluationstepinfobuilder);
    }

    public ObjectAndStatic evaluateMacroReference(String s)
    {
        EventInfoBuilder eventinfobuilder = eventInfoDistributor.createMacroEvalutionEventInfo(s);
        s = evaluateMacroReferenceCycleDetection(s, new HashSet(), eventinfobuilder.createMacroEvaluationInfoBuilder());
        eventinfobuilder.processEventInfo();
        return s;
    }

    ObjectAndStatic evaluatePredicate(ResourceUtil.ExpandedFunctionCall expandedfunctioncall, Set set, ResolvedFunctionCallBuilder resolvedfunctioncallbuilder)
    {
        expandedfunctioncall = executeFunction(mPredicateMap, expandedfunctioncall, set, resolvedfunctioncallbuilder);
        set = Types.valueToBoolean((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)expandedfunctioncall.getObject());
        resolvedfunctioncallbuilder.setFunctionResult(Types.objectToValue(set));
        return new ObjectAndStatic(set, expandedfunctioncall.isStatic());
    }

    ObjectAndStatic evaluatePredicatesInRule(ResourceUtil.ExpandedRule expandedrule, Set set, ResolvedRuleBuilder resolvedrulebuilder)
    {
        boolean flag = true;
        for (Iterator iterator = expandedrule.getNegativePredicates().iterator(); iterator.hasNext();)
        {
            ObjectAndStatic objectandstatic1 = evaluatePredicate((ResourceUtil.ExpandedFunctionCall)iterator.next(), set, resolvedrulebuilder.createNegativePredicate());
            if (((Boolean)objectandstatic1.getObject()).booleanValue())
            {
                resolvedrulebuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
                return new ObjectAndStatic(Boolean.valueOf(false), objectandstatic1.isStatic());
            }
            if (flag && objectandstatic1.isStatic())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        for (expandedrule = expandedrule.getPositivePredicates().iterator(); expandedrule.hasNext();)
        {
            ObjectAndStatic objectandstatic = evaluatePredicate((ResourceUtil.ExpandedFunctionCall)expandedrule.next(), set, resolvedrulebuilder.createPositivePredicate());
            if (!((Boolean)objectandstatic.getObject()).booleanValue())
            {
                resolvedrulebuilder.setValue(Types.objectToValue(Boolean.valueOf(false)));
                return new ObjectAndStatic(Boolean.valueOf(false), objectandstatic.isStatic());
            }
            if (flag && objectandstatic.isStatic())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        resolvedrulebuilder.setValue(Types.objectToValue(Boolean.valueOf(true)));
        return new ObjectAndStatic(Boolean.valueOf(true), flag);
    }

    public void evaluateTags(String s)
    {
        this;
        JVM INSTR monitorenter ;
        setCurrentEventName(s);
        s = eventInfoDistributor.createDataLayerEventEvaluationEventInfo(s);
        DataLayerEventEvaluationInfoBuilder datalayereventevaluationinfobuilder = s.createDataLayerEventEvaluationInfoBuilder();
        ResourceUtil.ExpandedFunctionCall expandedfunctioncall;
        for (Iterator iterator = ((Set)calculateTagsToRun(mRules, datalayereventevaluationinfobuilder.createRulesEvaluation()).getObject()).iterator(); iterator.hasNext(); executeFunction(mTrackingTagMap, expandedfunctioncall, new HashSet(), datalayereventevaluationinfobuilder.createAndAddResult()))
        {
            expandedfunctioncall = (ResourceUtil.ExpandedFunctionCall)iterator.next();
        }

        break MISSING_BLOCK_LABEL_103;
        s;
        throw s;
        s.processEventInfo();
        setCurrentEventName(null);
        this;
        JVM INSTR monitorexit ;
    }

    String getCurrentEventName()
    {
        this;
        JVM INSTR monitorenter ;
        String s = mCurrentEventName;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public ResourceUtil.ExpandedResource getResource()
    {
        return mResource;
    }

    void setCurrentEventName(String s)
    {
        this;
        JVM INSTR monitorenter ;
        mCurrentEventName = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
