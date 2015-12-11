// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk.module.engagement.interaction.model.common;

import org.json.JSONObject;

public abstract class Action extends JSONObject
{

    private static final String KEY_ACTION = "action";
    public static final String KEY_ID = "id";
    public static final String KEY_LABEL = "label";

    public Action(String s)
    {
        super(s);
    }

    public String getId()
    {
        return optString("id", null);
    }

    public String getLabel()
    {
        return optString("label", null);
    }

    public Type getType()
    {
        return Type.parse(optString("action", Type.unknown.name()));
    }

    private class Type extends Enum
    {

        private static final Type $VALUES[];
        public static final Type dismiss;
        public static final Type interaction;
        public static final Type unknown;

        public static Type parse(String s)
        {
            Type type;
            try
            {
                type = valueOf(s);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Log.v((new StringBuilder("Error parsing unknown Action.Type: ")).append(s).toString(), new Object[0]);
                return unknown;
            }
            return type;
        }

        public static Type valueOf(String s)
        {
            return (Type)Enum.valueOf(com/apptentive/android/sdk/module/engagement/interaction/model/common/Action$Type, s);
        }

        public static Type[] values()
        {
            return (Type[])$VALUES.clone();
        }

        static 
        {
            dismiss = new Type("dismiss", 0);
            interaction = new Type("interaction", 1);
            unknown = new Type("unknown", 2);
            $VALUES = (new Type[] {
                dismiss, interaction, unknown
            });
        }

        private Type(String s, int i)
        {
            super(s, i);
        }
    }

}
