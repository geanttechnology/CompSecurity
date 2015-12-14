// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effect;

import java.util.ArrayList;
import java.util.HashMap;

public final class EffectParameter
{

    public String a;
    public ParameterType b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public String g;
    public ArrayList h;
    private HashMap i;

    private EffectParameter(String s, ParameterType parametertype, Object obj)
    {
        a = s;
        b = parametertype;
        c = obj;
    }

    public EffectParameter(String s, ParameterType parametertype, Object obj, Object obj1)
    {
        this(s, parametertype, obj1);
        f = obj;
    }

    public EffectParameter(String s, ParameterType parametertype, Object obj, Object obj1, Object obj2, Object obj3)
    {
        this(s, parametertype, obj, obj1);
        d = obj2;
        e = obj3;
    }

    public EffectParameter(String s, ParameterType parametertype, Object obj, Object obj1, HashMap hashmap)
    {
        this(s, parametertype, obj, obj1);
        i = hashmap;
    }

    public static EffectParameter a(ArrayList arraylist, int j)
    {
        if (arraylist != null && j >= 0 && j < arraylist.size())
        {
            return (EffectParameter)arraylist.get(j);
        } else
        {
            return null;
        }
    }

    public static EffectParameter a(ArrayList arraylist, String s)
    {
        for (int j = 0; j < arraylist.size(); j++)
        {
            EffectParameter effectparameter = (EffectParameter)arraylist.get(j);
            if (effectparameter.a.equals(s))
            {
                return effectparameter;
            }
        }

        return null;
    }

    public static ArrayList a(ArrayList arraylist)
    {
        ArrayList arraylist1 = null;
        if (arraylist != null)
        {
            arraylist1 = new ArrayList(arraylist.size());
            for (int j = 0; j < arraylist.size(); j++)
            {
                arraylist1.add(((EffectParameter)arraylist.get(j)).f());
            }

        }
        return arraylist1;
    }

    public static void a(ArrayList arraylist, int j, int k)
    {
        a(arraylist, "x", j);
        a(arraylist, "y", k);
    }

    public static void a(ArrayList arraylist, String s, int j)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null && ((EffectParameter) (arraylist)).b == ParameterType.ParameterTypeInt)
        {
            arraylist.c = Integer.valueOf(j);
        }
    }

    public static void a(ArrayList arraylist, String s, boolean flag)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null && ((EffectParameter) (arraylist)).b == ParameterType.ParameterTypeBool)
        {
            arraylist.c = Boolean.valueOf(flag);
        }
    }

    public static int b(ArrayList arraylist, String s)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null)
        {
            return ((Integer)((EffectParameter) (arraylist)).c).intValue();
        } else
        {
            return 0x7fffffff;
        }
    }

    public static float c(ArrayList arraylist, String s)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null)
        {
            return ((Float)((EffectParameter) (arraylist)).c).floatValue();
        } else
        {
            return 3.402823E+38F;
        }
    }

    public static boolean d(ArrayList arraylist, String s)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null)
        {
            return ((Boolean)((EffectParameter) (arraylist)).c).booleanValue();
        } else
        {
            return false;
        }
    }

    public static int e(ArrayList arraylist, String s)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null)
        {
            return ((Integer)((EffectParameter) (arraylist)).c).intValue();
        } else
        {
            return 0x7fffffff;
        }
    }

    private EffectParameter f()
    {
        EffectParameter effectparameter = new EffectParameter(a, b, f, c, d, e);
        effectparameter.i = i;
        effectparameter.g = g;
        effectparameter.h = h;
        return effectparameter;
    }

    public static String f(ArrayList arraylist, String s)
    {
        arraylist = a(arraylist, s);
        if (arraylist != null)
        {
            return (String)((EffectParameter) (arraylist)).c;
        } else
        {
            return null;
        }
    }

    public final ParameterType a()
    {
        return b;
    }

    public final boolean a(float f1)
    {
        if (b == ParameterType.ParameterTypeInt)
        {
            int j = ((Integer)d).intValue();
            c = new Integer((int)((float)(((Integer)e).intValue() - j) * f1 + (float)j));
            return true;
        }
        if (b == ParameterType.ParameterTypeFloat)
        {
            float f2 = ((Float)d).floatValue();
            c = new Float((((Float)e).floatValue() - f2) * f1 + f2);
            return true;
        } else
        {
            return false;
        }
    }

    public final boolean a(String s)
    {
        if (i != null && i.containsKey(s))
        {
            c = i.get(s);
            g = s;
            return true;
        } else
        {
            return false;
        }
    }

    public final Object b()
    {
        return c;
    }

    public final Object c()
    {
        return d;
    }

    public final Object clone()
    {
        return f();
    }

    public final Object d()
    {
        return e;
    }

    public final void e()
    {
        c = f;
    }

    private class ParameterType extends Enum
    {

        private static final ParameterType $VALUES[];
        public static final ParameterType ParameterTypeBool;
        public static final ParameterType ParameterTypeColor;
        public static final ParameterType ParameterTypeDiscrete;
        public static final ParameterType ParameterTypeFloat;
        public static final ParameterType ParameterTypeInt;
        public static final ParameterType ParameterTypeTexture;

        public static ParameterType valueOf(String s)
        {
            return (ParameterType)Enum.valueOf(com/photo/effect/EffectParameter$ParameterType, s);
        }

        public static ParameterType[] values()
        {
            return (ParameterType[])$VALUES.clone();
        }

        static 
        {
            ParameterTypeInt = new ParameterType("ParameterTypeInt", 0);
            ParameterTypeFloat = new ParameterType("ParameterTypeFloat", 1);
            ParameterTypeBool = new ParameterType("ParameterTypeBool", 2);
            ParameterTypeDiscrete = new ParameterType("ParameterTypeDiscrete", 3);
            ParameterTypeColor = new ParameterType("ParameterTypeColor", 4);
            ParameterTypeTexture = new ParameterType("ParameterTypeTexture", 5);
            $VALUES = (new ParameterType[] {
                ParameterTypeInt, ParameterTypeFloat, ParameterTypeBool, ParameterTypeDiscrete, ParameterTypeColor, ParameterTypeTexture
            });
        }

        private ParameterType(String s, int j)
        {
            super(s, j);
        }
    }

}
