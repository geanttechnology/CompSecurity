// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.ConfigFeature;

public final class MapperFeature extends Enum
    implements ConfigFeature
{

    private static final MapperFeature $VALUES[];
    public static final MapperFeature ALLOW_FINAL_FIELDS_AS_MUTATORS;
    public static final MapperFeature AUTO_DETECT_CREATORS;
    public static final MapperFeature AUTO_DETECT_FIELDS;
    public static final MapperFeature AUTO_DETECT_GETTERS;
    public static final MapperFeature AUTO_DETECT_IS_GETTERS;
    public static final MapperFeature AUTO_DETECT_SETTERS;
    public static final MapperFeature CAN_OVERRIDE_ACCESS_MODIFIERS;
    public static final MapperFeature DEFAULT_VIEW_INCLUSION;
    public static final MapperFeature INFER_PROPERTY_MUTATORS;
    public static final MapperFeature REQUIRE_SETTERS_FOR_GETTERS;
    public static final MapperFeature SORT_PROPERTIES_ALPHABETICALLY;
    public static final MapperFeature USE_ANNOTATIONS;
    public static final MapperFeature USE_GETTERS_AS_SETTERS;
    public static final MapperFeature USE_STATIC_TYPING;
    public static final MapperFeature USE_WRAPPER_NAME_AS_PROPERTY_NAME;
    private final boolean _defaultState;

    private MapperFeature(String s, int i, boolean flag)
    {
        super(s, i);
        _defaultState = flag;
    }

    public static MapperFeature valueOf(String s)
    {
        return (MapperFeature)Enum.valueOf(com/fasterxml/jackson/databind/MapperFeature, s);
    }

    public static MapperFeature[] values()
    {
        return (MapperFeature[])$VALUES.clone();
    }

    public boolean enabledByDefault()
    {
        return _defaultState;
    }

    public int getMask()
    {
        return 1 << ordinal();
    }

    static 
    {
        USE_ANNOTATIONS = new MapperFeature("USE_ANNOTATIONS", 0, true);
        AUTO_DETECT_CREATORS = new MapperFeature("AUTO_DETECT_CREATORS", 1, true);
        AUTO_DETECT_FIELDS = new MapperFeature("AUTO_DETECT_FIELDS", 2, true);
        AUTO_DETECT_GETTERS = new MapperFeature("AUTO_DETECT_GETTERS", 3, true);
        AUTO_DETECT_IS_GETTERS = new MapperFeature("AUTO_DETECT_IS_GETTERS", 4, true);
        AUTO_DETECT_SETTERS = new MapperFeature("AUTO_DETECT_SETTERS", 5, true);
        REQUIRE_SETTERS_FOR_GETTERS = new MapperFeature("REQUIRE_SETTERS_FOR_GETTERS", 6, false);
        USE_GETTERS_AS_SETTERS = new MapperFeature("USE_GETTERS_AS_SETTERS", 7, true);
        CAN_OVERRIDE_ACCESS_MODIFIERS = new MapperFeature("CAN_OVERRIDE_ACCESS_MODIFIERS", 8, true);
        INFER_PROPERTY_MUTATORS = new MapperFeature("INFER_PROPERTY_MUTATORS", 9, true);
        ALLOW_FINAL_FIELDS_AS_MUTATORS = new MapperFeature("ALLOW_FINAL_FIELDS_AS_MUTATORS", 10, true);
        USE_STATIC_TYPING = new MapperFeature("USE_STATIC_TYPING", 11, false);
        DEFAULT_VIEW_INCLUSION = new MapperFeature("DEFAULT_VIEW_INCLUSION", 12, true);
        SORT_PROPERTIES_ALPHABETICALLY = new MapperFeature("SORT_PROPERTIES_ALPHABETICALLY", 13, false);
        USE_WRAPPER_NAME_AS_PROPERTY_NAME = new MapperFeature("USE_WRAPPER_NAME_AS_PROPERTY_NAME", 14, false);
        $VALUES = (new MapperFeature[] {
            USE_ANNOTATIONS, AUTO_DETECT_CREATORS, AUTO_DETECT_FIELDS, AUTO_DETECT_GETTERS, AUTO_DETECT_IS_GETTERS, AUTO_DETECT_SETTERS, REQUIRE_SETTERS_FOR_GETTERS, USE_GETTERS_AS_SETTERS, CAN_OVERRIDE_ACCESS_MODIFIERS, INFER_PROPERTY_MUTATORS, 
            ALLOW_FINAL_FIELDS_AS_MUTATORS, USE_STATIC_TYPING, DEFAULT_VIEW_INCLUSION, SORT_PROPERTIES_ALPHABETICALLY, USE_WRAPPER_NAME_AS_PROPERTY_NAME
        });
    }
}
