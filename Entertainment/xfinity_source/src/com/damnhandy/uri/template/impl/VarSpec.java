// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.damnhandy.uri.template.impl;


// Referenced classes of package com.damnhandy.uri.template.impl:
//            Modifier

public final class VarSpec
{
    public static final class VarFormat extends Enum
    {

        private static final VarFormat $VALUES[];
        public static final VarFormat ARRAY;
        public static final VarFormat PAIRS;
        public static final VarFormat SINGLE;

        public static VarFormat valueOf(String s)
        {
            return (VarFormat)Enum.valueOf(com/damnhandy/uri/template/impl/VarSpec$VarFormat, s);
        }

        public static VarFormat[] values()
        {
            return (VarFormat[])$VALUES.clone();
        }

        static 
        {
            SINGLE = new VarFormat("SINGLE", 0);
            ARRAY = new VarFormat("ARRAY", 1);
            PAIRS = new VarFormat("PAIRS", 2);
            $VALUES = (new VarFormat[] {
                SINGLE, ARRAY, PAIRS
            });
        }

        private VarFormat(String s, int i)
        {
            super(s, i);
        }
    }


    private Modifier modifier;
    private Integer position;
    private String value;
    private String variableName;

    public VarSpec(String s, Modifier modifier1)
    {
        this(s, modifier1, null);
    }

    public VarSpec(String s, Modifier modifier1, Integer integer)
    {
        modifier = Modifier.NONE;
        position = null;
        modifier = modifier1;
        value = s;
        position = integer;
        initVariableName();
    }

    private void initVariableName()
    {
        if (modifier == Modifier.NONE)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        if (modifier != Modifier.PREFIX) goto _L2; else goto _L1
_L1:
        variableName = getValue().split(Modifier.PREFIX.getValue())[0];
_L4:
        return;
_L2:
        if (modifier != Modifier.EXPLODE) goto _L4; else goto _L3
_L3:
        variableName = getValue().substring(0, getValue().length() - 1);
        return;
        variableName = getValue();
        return;
    }

    public Modifier getModifier()
    {
        return modifier;
    }

    public Integer getPosition()
    {
        return position;
    }

    public String getValue()
    {
        return value;
    }

    public String getVariableName()
    {
        if (variableName == null)
        {
            return getValue();
        } else
        {
            return variableName;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("VarSpec [modifier=").append(modifier).append(", value=").append(value).append(", position=").append(position).append(", variableName=").append(variableName).append("]").toString();
    }
}
