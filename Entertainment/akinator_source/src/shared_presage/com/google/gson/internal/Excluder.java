// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import shared_presage.com.google.gson.ExclusionStrategy;
import shared_presage.com.google.gson.FieldAttributes;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.TypeAdapter;
import shared_presage.com.google.gson.TypeAdapterFactory;
import shared_presage.com.google.gson.annotations.Expose;
import shared_presage.com.google.gson.annotations.Since;
import shared_presage.com.google.gson.annotations.Until;
import shared_presage.com.google.gson.reflect.TypeToken;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            m

public final class Excluder
    implements Cloneable, TypeAdapterFactory
{

    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1D;
    private List deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    public Excluder()
    {
        version = -1D;
        modifiers = 136;
        serializeInnerClasses = true;
        serializationStrategies = Collections.emptyList();
        deserializationStrategies = Collections.emptyList();
    }

    private boolean isAnonymousOrLocal(Class class1)
    {
        return !java/lang/Enum.isAssignableFrom(class1) && (class1.isAnonymousClass() || class1.isLocalClass());
    }

    private boolean isInnerClass(Class class1)
    {
        return class1.isMemberClass() && !isStatic(class1);
    }

    private boolean isStatic(Class class1)
    {
        return (class1.getModifiers() & 8) != 0;
    }

    private boolean isValidSince(Since since)
    {
        return since == null || since.value() <= version;
    }

    private boolean isValidUntil(Until until)
    {
        return until == null || until.value() > version;
    }

    private boolean isValidVersion(Since since, Until until)
    {
        return isValidSince(since) && isValidUntil(until);
    }

    protected final volatile Object clone()
    {
        return clone();
    }

    protected final Excluder clone()
    {
        Excluder excluder;
        try
        {
            excluder = (Excluder)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError();
        }
        return excluder;
    }

    public final TypeAdapter create(Gson gson, TypeToken typetoken)
    {
        Class class1 = typetoken.getRawType();
        boolean flag = excludeClass(class1, true);
        boolean flag1 = excludeClass(class1, false);
        if (!flag && !flag1)
        {
            return null;
        } else
        {
            return new m(this, flag1, flag, gson, typetoken);
        }
    }

    public final Excluder disableInnerClassSerialization()
    {
        Excluder excluder = clone();
        excluder.serializeInnerClasses = false;
        return excluder;
    }

    public final boolean excludeClass(Class class1, boolean flag)
    {
        if (version != -1D && !isValidVersion((Since)class1.getAnnotation(shared_presage/com/google/gson/annotations/Since), (Until)class1.getAnnotation(shared_presage/com/google/gson/annotations/Until)))
        {
            return true;
        }
        if (!serializeInnerClasses && isInnerClass(class1))
        {
            return true;
        }
        if (isAnonymousOrLocal(class1))
        {
            return true;
        }
        Object obj;
        if (flag)
        {
            obj = serializationStrategies;
        } else
        {
            obj = deserializationStrategies;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            if (((ExclusionStrategy)((Iterator) (obj)).next()).shouldSkipClass(class1))
            {
                return true;
            }
        }

        return false;
    }

    public final boolean excludeField(Field field, boolean flag)
    {
label0:
        {
            if ((modifiers & field.getModifiers()) != 0)
            {
                return true;
            }
            if (version != -1D && !isValidVersion((Since)field.getAnnotation(shared_presage/com/google/gson/annotations/Since), (Until)field.getAnnotation(shared_presage/com/google/gson/annotations/Until)))
            {
                return true;
            }
            if (field.isSynthetic())
            {
                return true;
            }
            if (requireExpose)
            {
                Expose expose = (Expose)field.getAnnotation(shared_presage/com/google/gson/annotations/Expose);
                if (expose == null || (flag ? !expose.serialize() : !expose.deserialize()))
                {
                    return true;
                }
            }
            if (!serializeInnerClasses && isInnerClass(field.getType()))
            {
                return true;
            }
            if (isAnonymousOrLocal(field.getType()))
            {
                return true;
            }
            Object obj;
            if (flag)
            {
                obj = serializationStrategies;
            } else
            {
                obj = deserializationStrategies;
            }
            if (((List) (obj)).isEmpty())
            {
                break label0;
            }
            field = new FieldAttributes(field);
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((ExclusionStrategy)((Iterator) (obj)).next()).shouldSkipField(field));
            return true;
        }
        return false;
    }

    public final Excluder excludeFieldsWithoutExposeAnnotation()
    {
        Excluder excluder = clone();
        excluder.requireExpose = true;
        return excluder;
    }

    public final Excluder withExclusionStrategy(ExclusionStrategy exclusionstrategy, boolean flag, boolean flag1)
    {
        Excluder excluder = clone();
        if (flag)
        {
            excluder.serializationStrategies = new ArrayList(serializationStrategies);
            excluder.serializationStrategies.add(exclusionstrategy);
        }
        if (flag1)
        {
            excluder.deserializationStrategies = new ArrayList(deserializationStrategies);
            excluder.deserializationStrategies.add(exclusionstrategy);
        }
        return excluder;
    }

    public final transient Excluder withModifiers(int ai[])
    {
        int i = 0;
        Excluder excluder = clone();
        excluder.modifiers = 0;
        for (int j = ai.length; i < j; i++)
        {
            excluder.modifiers = ai[i] | excluder.modifiers;
        }

        return excluder;
    }

    public final Excluder withVersion(double d)
    {
        Excluder excluder = clone();
        excluder.version = d;
        return excluder;
    }

}
