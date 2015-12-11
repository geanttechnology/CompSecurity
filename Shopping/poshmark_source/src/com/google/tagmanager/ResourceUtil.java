// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.tagmanager:
//            Types, Log

class ResourceUtil
{
    public static class ExpandedFunctionCall
    {

        private final Map mPropertiesMap;

        public static ExpandedFunctionCallBuilder newBuilder()
        {
            return new ExpandedFunctionCallBuilder();
        }

        public Map getProperties()
        {
            return Collections.unmodifiableMap(mPropertiesMap);
        }

        public String toString()
        {
            return (new StringBuilder()).append("Properties: ").append(getProperties()).toString();
        }

        public void updateCacheableProperty(String s, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            mPropertiesMap.put(s, value);
        }

        private ExpandedFunctionCall(Map map)
        {
            mPropertiesMap = map;
        }

    }

    public static class ExpandedFunctionCallBuilder
    {

        private final Map mPropertiesMap;

        public ExpandedFunctionCallBuilder addProperty(String s, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        {
            mPropertiesMap.put(s, value);
            return this;
        }

        public ExpandedFunctionCall build()
        {
            return new ExpandedFunctionCall(mPropertiesMap);
        }

        private ExpandedFunctionCallBuilder()
        {
            mPropertiesMap = new HashMap();
        }

    }

    public static class ExpandedResource
    {

        private final Map mMacros;
        private final int mResourceFormatVersion;
        private final List mRules;
        private final String mVersion;

        public static ExpandedResourceBuilder newBuilder()
        {
            return new ExpandedResourceBuilder();
        }

        public Map getAllMacros()
        {
            return mMacros;
        }

        public List getMacros(String s)
        {
            return (List)mMacros.get(s);
        }

        public int getResourceFormatVersion()
        {
            return mResourceFormatVersion;
        }

        public List getRules()
        {
            return mRules;
        }

        public String getVersion()
        {
            return mVersion;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(getRules()).append("  Macros: ").append(mMacros).toString();
        }

        private ExpandedResource(List list, Map map, String s, int i)
        {
            mRules = Collections.unmodifiableList(list);
            mMacros = Collections.unmodifiableMap(map);
            mVersion = s;
            mResourceFormatVersion = i;
        }

    }

    public static class ExpandedResourceBuilder
    {

        private final Map mMacros;
        private final List mPredicates;
        private int mResourceFormatVersion;
        private final List mRules;
        private final List mTags;
        private String mVersion;

        public ExpandedResourceBuilder addMacro(ExpandedFunctionCall expandedfunctioncall)
        {
            String s = Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)expandedfunctioncall.getProperties().get(Key.INSTANCE_NAME.toString()));
            List list = (List)mMacros.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                mMacros.put(s, obj);
            }
            ((List) (obj)).add(expandedfunctioncall);
            return this;
        }

        public ExpandedResourceBuilder addRule(ExpandedRule expandedrule)
        {
            mRules.add(expandedrule);
            return this;
        }

        public ExpandedResource build()
        {
            return new ExpandedResource(mRules, mMacros, mVersion, mResourceFormatVersion);
        }

        public ExpandedResourceBuilder setResourceFormatVersion(int i)
        {
            mResourceFormatVersion = i;
            return this;
        }

        public ExpandedResourceBuilder setVersion(String s)
        {
            mVersion = s;
            return this;
        }

        private ExpandedResourceBuilder()
        {
            mRules = new ArrayList();
            mTags = new ArrayList();
            mPredicates = new ArrayList();
            mMacros = new HashMap();
            mVersion = "";
            mResourceFormatVersion = 0;
        }

    }

    public static class ExpandedRule
    {

        private final List mAddMacroRuleNames;
        private final List mAddMacros;
        private final List mAddTagRuleNames;
        private final List mAddTags;
        private final List mNegativePredicates;
        private final List mPositivePredicates;
        private final List mRemoveMacroRuleNames;
        private final List mRemoveMacros;
        private final List mRemoveTagRuleNames;
        private final List mRemoveTags;

        public static ExpandedRuleBuilder newBuilder()
        {
            return new ExpandedRuleBuilder();
        }

        public List getAddMacroRuleNames()
        {
            return mAddMacroRuleNames;
        }

        public List getAddMacros()
        {
            return mAddMacros;
        }

        public List getAddTagRuleNames()
        {
            return mAddTagRuleNames;
        }

        public List getAddTags()
        {
            return mAddTags;
        }

        public List getNegativePredicates()
        {
            return mNegativePredicates;
        }

        public List getPositivePredicates()
        {
            return mPositivePredicates;
        }

        public List getRemoveMacroRuleNames()
        {
            return mRemoveMacroRuleNames;
        }

        public List getRemoveMacros()
        {
            return mRemoveMacros;
        }

        public List getRemoveTagRuleNames()
        {
            return mRemoveTagRuleNames;
        }

        public List getRemoveTags()
        {
            return mRemoveTags;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Positive predicates: ").append(getPositivePredicates()).append("  Negative predicates: ").append(getNegativePredicates()).append("  Add tags: ").append(getAddTags()).append("  Remove tags: ").append(getRemoveTags()).append("  Add macros: ").append(getAddMacros()).append("  Remove macros: ").append(getRemoveMacros()).toString();
        }

        private ExpandedRule(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9)
        {
            mPositivePredicates = Collections.unmodifiableList(list);
            mNegativePredicates = Collections.unmodifiableList(list1);
            mAddTags = Collections.unmodifiableList(list2);
            mRemoveTags = Collections.unmodifiableList(list3);
            mAddMacros = Collections.unmodifiableList(list4);
            mRemoveMacros = Collections.unmodifiableList(list5);
            mAddMacroRuleNames = Collections.unmodifiableList(list6);
            mRemoveMacroRuleNames = Collections.unmodifiableList(list7);
            mAddTagRuleNames = Collections.unmodifiableList(list8);
            mRemoveTagRuleNames = Collections.unmodifiableList(list9);
        }

    }

    public static class ExpandedRuleBuilder
    {

        private final List mAddMacroRuleNames;
        private final List mAddMacros;
        private final List mAddTagRuleNames;
        private final List mAddTags;
        private final List mNegativePredicates;
        private final List mPositivePredicates;
        private final List mRemoveMacroRuleNames;
        private final List mRemoveMacros;
        private final List mRemoveTagRuleNames;
        private final List mRemoveTags;

        public ExpandedRuleBuilder addAddMacro(ExpandedFunctionCall expandedfunctioncall)
        {
            mAddMacros.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addAddMacroRuleName(String s)
        {
            mAddMacroRuleNames.add(s);
            return this;
        }

        public ExpandedRuleBuilder addAddTag(ExpandedFunctionCall expandedfunctioncall)
        {
            mAddTags.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addAddTagRuleName(String s)
        {
            mAddTagRuleNames.add(s);
            return this;
        }

        public ExpandedRuleBuilder addNegativePredicate(ExpandedFunctionCall expandedfunctioncall)
        {
            mNegativePredicates.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addPositivePredicate(ExpandedFunctionCall expandedfunctioncall)
        {
            mPositivePredicates.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveMacro(ExpandedFunctionCall expandedfunctioncall)
        {
            mRemoveMacros.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveMacroRuleName(String s)
        {
            mRemoveMacroRuleNames.add(s);
            return this;
        }

        public ExpandedRuleBuilder addRemoveTag(ExpandedFunctionCall expandedfunctioncall)
        {
            mRemoveTags.add(expandedfunctioncall);
            return this;
        }

        public ExpandedRuleBuilder addRemoveTagRuleName(String s)
        {
            mRemoveTagRuleNames.add(s);
            return this;
        }

        public ExpandedRule build()
        {
            return new ExpandedRule(mPositivePredicates, mNegativePredicates, mAddTags, mRemoveTags, mAddMacros, mRemoveMacros, mAddMacroRuleNames, mRemoveMacroRuleNames, mAddTagRuleNames, mRemoveTagRuleNames);
        }

        private ExpandedRuleBuilder()
        {
            mPositivePredicates = new ArrayList();
            mNegativePredicates = new ArrayList();
            mAddTags = new ArrayList();
            mRemoveTags = new ArrayList();
            mAddMacros = new ArrayList();
            mRemoveMacros = new ArrayList();
            mAddMacroRuleNames = new ArrayList();
            mRemoveMacroRuleNames = new ArrayList();
            mAddTagRuleNames = new ArrayList();
            mRemoveTagRuleNames = new ArrayList();
        }

    }

    public static class InvalidResourceException extends Exception
    {

        public InvalidResourceException(String s)
        {
            super(s);
        }
    }


    private ResourceUtil()
    {
    }

    private static ExpandedFunctionCall expandFunctionCall(com.google.analytics.containertag.proto.Serving.FunctionCall functioncall, com.google.analytics.containertag.proto.Serving.Resource resource, com.google.analytics.midtier.proto.containertag.TypeSystem.Value avalue[], int i)
        throws InvalidResourceException
    {
        ExpandedFunctionCallBuilder expandedfunctioncallbuilder = ExpandedFunctionCall.newBuilder();
        Object obj;
        for (functioncall = functioncall.getPropertyList().iterator(); functioncall.hasNext(); expandedfunctioncallbuilder.addProperty((String)getWithBoundsCheck(resource.getKeyList(), ((com.google.analytics.containertag.proto.Serving.Property) (obj)).getKey(), "keys"), (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)getWithBoundsCheck(avalue, ((com.google.analytics.containertag.proto.Serving.Property) (obj)).getValue(), "values")))
        {
            obj = (Integer)functioncall.next();
            obj = (com.google.analytics.containertag.proto.Serving.Property)getWithBoundsCheck(resource.getPropertyList(), ((Integer) (obj)).intValue(), "properties");
        }

        return expandedfunctioncallbuilder.build();
    }

    private static ExpandedRule expandRule(com.google.analytics.containertag.proto.Serving.Rule rule, List list, List list1, List list2, com.google.analytics.containertag.proto.Serving.Resource resource)
    {
        ExpandedRuleBuilder expandedrulebuilder = ExpandedRule.newBuilder();
        for (Iterator iterator = rule.getPositivePredicateList().iterator(); iterator.hasNext(); expandedrulebuilder.addPositivePredicate((ExpandedFunctionCall)list2.get(((Integer)iterator.next()).intValue()))) { }
        for (Iterator iterator1 = rule.getNegativePredicateList().iterator(); iterator1.hasNext(); expandedrulebuilder.addNegativePredicate((ExpandedFunctionCall)list2.get(((Integer)iterator1.next()).intValue()))) { }
        for (list2 = rule.getAddTagList().iterator(); list2.hasNext(); expandedrulebuilder.addAddTag((ExpandedFunctionCall)list.get(((Integer)list2.next()).intValue()))) { }
        for (list2 = rule.getAddTagRuleNameList().iterator(); list2.hasNext(); expandedrulebuilder.addAddTagRuleName(resource.getValue(((Integer)list2.next()).intValue()).getString())) { }
        for (list2 = rule.getRemoveTagList().iterator(); list2.hasNext(); expandedrulebuilder.addRemoveTag((ExpandedFunctionCall)list.get(((Integer)list2.next()).intValue()))) { }
        for (list = rule.getRemoveTagRuleNameList().iterator(); list.hasNext(); expandedrulebuilder.addRemoveTagRuleName(resource.getValue(((Integer)list.next()).intValue()).getString())) { }
        for (list = rule.getAddMacroList().iterator(); list.hasNext(); expandedrulebuilder.addAddMacro((ExpandedFunctionCall)list1.get(((Integer)list.next()).intValue()))) { }
        for (list = rule.getAddMacroRuleNameList().iterator(); list.hasNext(); expandedrulebuilder.addAddMacroRuleName(resource.getValue(((Integer)list.next()).intValue()).getString())) { }
        for (list = rule.getRemoveMacroList().iterator(); list.hasNext(); expandedrulebuilder.addRemoveMacro((ExpandedFunctionCall)list1.get(((Integer)list.next()).intValue()))) { }
        for (rule = rule.getRemoveMacroRuleNameList().iterator(); rule.hasNext(); expandedrulebuilder.addRemoveMacroRuleName(resource.getValue(((Integer)rule.next()).intValue()).getString())) { }
        return expandedrulebuilder.build();
    }

    private static com.google.analytics.midtier.proto.containertag.TypeSystem.Value expandValue(int i, com.google.analytics.containertag.proto.Serving.Resource resource, com.google.analytics.midtier.proto.containertag.TypeSystem.Value avalue[], Set set)
        throws InvalidResourceException
    {
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value;
        Object obj;
        if (set.contains(Integer.valueOf(i)))
        {
            logAndThrow((new StringBuilder()).append("Value cycle detected.  Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        value = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)getWithBoundsCheck(resource.getValueList(), i, "values");
        if (avalue[i] != null)
        {
            return avalue[i];
        }
        obj = null;
        set.add(Integer.valueOf(i));
        static class _cls1
        {

            static final int $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[];

            static 
            {
                $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type = new int[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.values().length];
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MAP.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.MACRO_REFERENCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.TEMPLATE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.STRING.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.FUNCTION_ID.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.INTEGER.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$google$analytics$midtier$proto$containertag$TypeSystem$Value$Type[com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type.BOOLEAN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Type[value.getType().ordinal()];
        JVM INSTR tableswitch 1 8: default 152
    //                   1 199
    //                   2 268
    //                   3 451
    //                   4 517
    //                   5 586
    //                   6 586
    //                   7 586
    //                   8 586;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L6 _L6 _L6
_L1:
        resource = obj;
_L8:
        if (resource == null)
        {
            logAndThrow((new StringBuilder()).append("Invalid value: ").append(value).toString());
        }
        avalue[i] = resource;
        set.remove(Integer.valueOf(i));
        return resource;
_L2:
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder = newValueBuilderBasedOnValue(value);
        for (Iterator iterator = getServingValue(value).getListItemList().iterator(); iterator.hasNext(); builder.addListItem(expandValue(((Integer)iterator.next()).intValue(), resource, avalue, set))) { }
        resource = builder.build();
        continue; /* Loop/switch isn't completed */
_L3:
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder1 = newValueBuilderBasedOnValue(value);
        Object obj1 = getServingValue(value);
        if (((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapKeyCount() != ((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapValueCount())
        {
            logAndThrow((new StringBuilder()).append("Uneven map keys (").append(((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapKeyCount()).append(") and map values (").append(((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapValueCount()).append(")").toString());
        }
        for (Iterator iterator2 = ((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapKeyList().iterator(); iterator2.hasNext(); builder1.addMapKey(expandValue(((Integer)iterator2.next()).intValue(), resource, avalue, set))) { }
        for (obj1 = ((com.google.analytics.containertag.proto.Serving.ServingValue) (obj1)).getMapValueList().iterator(); ((Iterator) (obj1)).hasNext(); builder1.addMapValue(expandValue(((Integer)((Iterator) (obj1)).next()).intValue(), resource, avalue, set))) { }
        resource = builder1.build();
        continue; /* Loop/switch isn't completed */
_L4:
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder2 = newValueBuilderBasedOnValue(value);
        com.google.analytics.containertag.proto.Serving.ServingValue servingvalue = getServingValue(value);
        if (!servingvalue.hasMacroNameReference())
        {
            logAndThrow("Missing macro name reference");
            resource = "";
        } else
        {
            resource = Types.valueToString(expandValue(servingvalue.getMacroNameReference(), resource, avalue, set));
        }
        builder2.setMacroReference(resource);
        resource = builder2.build();
        continue; /* Loop/switch isn't completed */
_L5:
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder3 = newValueBuilderBasedOnValue(value);
        for (Iterator iterator1 = getServingValue(value).getTemplateTokenList().iterator(); iterator1.hasNext(); builder3.addTemplateToken(expandValue(((Integer)iterator1.next()).intValue(), resource, avalue, set))) { }
        resource = builder3.build();
        continue; /* Loop/switch isn't completed */
_L6:
        resource = value;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static ExpandedResource getExpandedResource(com.google.analytics.containertag.proto.Serving.Resource resource)
        throws InvalidResourceException
    {
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value avalue[] = new com.google.analytics.midtier.proto.containertag.TypeSystem.Value[resource.getValueCount()];
        for (int i = 0; i < resource.getValueCount(); i++)
        {
            expandValue(i, resource, avalue, new HashSet(0));
        }

        ExpandedResourceBuilder expandedresourcebuilder = ExpandedResource.newBuilder();
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < resource.getTagCount(); j++)
        {
            arraylist.add(expandFunctionCall(resource.getTag(j), resource, avalue, j));
        }

        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < resource.getPredicateCount(); k++)
        {
            arraylist1.add(expandFunctionCall(resource.getPredicate(k), resource, avalue, k));
        }

        ArrayList arraylist2 = new ArrayList();
        for (int l = 0; l < resource.getMacroCount(); l++)
        {
            ExpandedFunctionCall expandedfunctioncall = expandFunctionCall(resource.getMacro(l), resource, avalue, l);
            expandedresourcebuilder.addMacro(expandedfunctioncall);
            arraylist2.add(expandedfunctioncall);
        }

        for (Iterator iterator = resource.getRuleList().iterator(); iterator.hasNext(); expandedresourcebuilder.addRule(expandRule((com.google.analytics.containertag.proto.Serving.Rule)iterator.next(), arraylist, arraylist2, arraylist1, resource))) { }
        expandedresourcebuilder.setVersion(resource.getVersion());
        expandedresourcebuilder.setResourceFormatVersion(resource.getResourceFormatVersion());
        return expandedresourcebuilder.build();
    }

    private static com.google.analytics.containertag.proto.Serving.ServingValue getServingValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
        throws InvalidResourceException
    {
        if (!value.hasExtension(com.google.analytics.containertag.proto.Serving.ServingValue.ext))
        {
            logAndThrow((new StringBuilder()).append("Expected a ServingValue and didn't get one. Value is: ").append(value).toString());
        }
        return (com.google.analytics.containertag.proto.Serving.ServingValue)value.getExtension(com.google.analytics.containertag.proto.Serving.ServingValue.ext);
    }

    private static Object getWithBoundsCheck(List list, int i, String s)
        throws InvalidResourceException
    {
        if (i < 0 || i >= list.size())
        {
            logAndThrow((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return list.get(i);
    }

    private static Object getWithBoundsCheck(Object aobj[], int i, String s)
        throws InvalidResourceException
    {
        if (i < 0 || i >= aobj.length)
        {
            logAndThrow((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    private static void logAndThrow(String s)
        throws InvalidResourceException
    {
        Log.e(s);
        throw new InvalidResourceException(s);
    }

    public static com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder newValueBuilderBasedOnValue(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value)
    {
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Builder builder = com.google.analytics.midtier.proto.containertag.TypeSystem.Value.newBuilder().setType(value.getType()).addAllEscaping(value.getEscapingList());
        if (value.getContainsReferences())
        {
            builder.setContainsReferences(true);
        }
        return builder;
    }
}
