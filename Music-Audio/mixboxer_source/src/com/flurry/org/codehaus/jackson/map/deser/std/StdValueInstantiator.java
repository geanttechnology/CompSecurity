// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.DeserializationConfig;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.deser.SettableBeanProperty;
import com.flurry.org.codehaus.jackson.map.deser.ValueInstantiator;
import com.flurry.org.codehaus.jackson.map.deser.impl.CreatorProperty;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedWithParams;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

public class StdValueInstantiator extends ValueInstantiator
{

    protected final boolean _cfgEmptyStringsAsObjects;
    protected CreatorProperty _constructorArguments[];
    protected AnnotatedWithParams _defaultCreator;
    protected AnnotatedWithParams _delegateCreator;
    protected JavaType _delegateType;
    protected AnnotatedWithParams _fromBooleanCreator;
    protected AnnotatedWithParams _fromDoubleCreator;
    protected AnnotatedWithParams _fromIntCreator;
    protected AnnotatedWithParams _fromLongCreator;
    protected AnnotatedWithParams _fromStringCreator;
    protected final String _valueTypeDesc;
    protected AnnotatedWithParams _withArgsCreator;

    public StdValueInstantiator(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        boolean flag;
        if (deserializationconfig == null)
        {
            flag = false;
        } else
        {
            flag = deserializationconfig.isEnabled(com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        }
        _cfgEmptyStringsAsObjects = flag;
        if (javatype == null)
        {
            deserializationconfig = "UNKNOWN TYPE";
        } else
        {
            deserializationconfig = javatype.toString();
        }
        _valueTypeDesc = deserializationconfig;
    }

    public StdValueInstantiator(DeserializationConfig deserializationconfig, Class class1)
    {
        boolean flag;
        if (deserializationconfig == null)
        {
            flag = false;
        } else
        {
            flag = deserializationconfig.isEnabled(com.flurry.org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        }
        _cfgEmptyStringsAsObjects = flag;
        if (class1 == null)
        {
            deserializationconfig = "UNKNOWN TYPE";
        } else
        {
            deserializationconfig = class1.getName();
        }
        _valueTypeDesc = deserializationconfig;
    }

    protected StdValueInstantiator(StdValueInstantiator stdvalueinstantiator)
    {
        _cfgEmptyStringsAsObjects = stdvalueinstantiator._cfgEmptyStringsAsObjects;
        _valueTypeDesc = stdvalueinstantiator._valueTypeDesc;
        _defaultCreator = stdvalueinstantiator._defaultCreator;
        _constructorArguments = stdvalueinstantiator._constructorArguments;
        _withArgsCreator = stdvalueinstantiator._withArgsCreator;
        _delegateType = stdvalueinstantiator._delegateType;
        _delegateCreator = stdvalueinstantiator._delegateCreator;
        _fromStringCreator = stdvalueinstantiator._fromStringCreator;
        _fromIntCreator = stdvalueinstantiator._fromIntCreator;
        _fromLongCreator = stdvalueinstantiator._fromLongCreator;
        _fromDoubleCreator = stdvalueinstantiator._fromDoubleCreator;
        _fromBooleanCreator = stdvalueinstantiator._fromBooleanCreator;
    }

    protected Object _createFromStringFallbacks(String s)
        throws IOException, JsonProcessingException
    {
        if (_fromBooleanCreator != null)
        {
            String s1 = s.trim();
            if ("true".equals(s1))
            {
                return createFromBoolean(true);
            }
            if ("false".equals(s1))
            {
                return createFromBoolean(false);
            }
        }
        if (_cfgEmptyStringsAsObjects && s.length() == 0)
        {
            return null;
        } else
        {
            throw new JsonMappingException((new StringBuilder()).append("Can not instantiate value of type ").append(getValueTypeDesc()).append(" from JSON String; no single-String constructor/factory method").toString());
        }
    }

    public boolean canCreateFromBoolean()
    {
        return _fromBooleanCreator != null;
    }

    public boolean canCreateFromDouble()
    {
        return _fromDoubleCreator != null;
    }

    public boolean canCreateFromInt()
    {
        return _fromIntCreator != null;
    }

    public boolean canCreateFromLong()
    {
        return _fromLongCreator != null;
    }

    public boolean canCreateFromObjectWith()
    {
        return _withArgsCreator != null;
    }

    public boolean canCreateFromString()
    {
        return _fromStringCreator != null;
    }

    public boolean canCreateUsingDefault()
    {
        return _defaultCreator != null;
    }

    public void configureFromBooleanCreator(AnnotatedWithParams annotatedwithparams)
    {
        _fromBooleanCreator = annotatedwithparams;
    }

    public void configureFromDoubleCreator(AnnotatedWithParams annotatedwithparams)
    {
        _fromDoubleCreator = annotatedwithparams;
    }

    public void configureFromIntCreator(AnnotatedWithParams annotatedwithparams)
    {
        _fromIntCreator = annotatedwithparams;
    }

    public void configureFromLongCreator(AnnotatedWithParams annotatedwithparams)
    {
        _fromLongCreator = annotatedwithparams;
    }

    public void configureFromObjectSettings(AnnotatedWithParams annotatedwithparams, AnnotatedWithParams annotatedwithparams1, JavaType javatype, AnnotatedWithParams annotatedwithparams2, CreatorProperty acreatorproperty[])
    {
        _defaultCreator = annotatedwithparams;
        _delegateCreator = annotatedwithparams1;
        _delegateType = javatype;
        _withArgsCreator = annotatedwithparams2;
        _constructorArguments = acreatorproperty;
    }

    public void configureFromStringCreator(AnnotatedWithParams annotatedwithparams)
    {
        _fromStringCreator = annotatedwithparams;
    }

    public Object createFromBoolean(boolean flag)
        throws IOException, JsonProcessingException
    {
label0:
        {
            Object obj;
            try
            {
                if (_fromBooleanCreator == null)
                {
                    break label0;
                }
                obj = _fromBooleanCreator.call1(Boolean.valueOf(flag));
            }
            catch (Exception exception)
            {
                throw wrapException(exception);
            }
            return obj;
        }
        throw new JsonMappingException((new StringBuilder()).append("Can not instantiate value of type ").append(getValueTypeDesc()).append(" from JSON boolean value; no single-boolean/Boolean-arg constructor/factory method").toString());
    }

    public Object createFromDouble(double d)
        throws IOException, JsonProcessingException
    {
label0:
        {
            Object obj;
            try
            {
                if (_fromDoubleCreator == null)
                {
                    break label0;
                }
                obj = _fromDoubleCreator.call1(Double.valueOf(d));
            }
            catch (Exception exception)
            {
                throw wrapException(exception);
            }
            return obj;
        }
        throw new JsonMappingException((new StringBuilder()).append("Can not instantiate value of type ").append(getValueTypeDesc()).append(" from JSON floating-point number; no one-double/Double-arg constructor/factory method").toString());
    }

    public Object createFromInt(int i)
        throws IOException, JsonProcessingException
    {
label0:
        {
            Object obj;
            try
            {
                if (_fromIntCreator != null)
                {
                    return _fromIntCreator.call1(Integer.valueOf(i));
                }
                if (_fromLongCreator == null)
                {
                    break label0;
                }
                obj = _fromLongCreator.call1(Long.valueOf(i));
            }
            catch (Exception exception)
            {
                throw wrapException(exception);
            }
            return obj;
        }
        throw new JsonMappingException((new StringBuilder()).append("Can not instantiate value of type ").append(getValueTypeDesc()).append(" from JSON integral number; no single-int-arg constructor/factory method").toString());
    }

    public Object createFromLong(long l)
        throws IOException, JsonProcessingException
    {
label0:
        {
            Object obj;
            try
            {
                if (_fromLongCreator == null)
                {
                    break label0;
                }
                obj = _fromLongCreator.call1(Long.valueOf(l));
            }
            catch (Exception exception)
            {
                throw wrapException(exception);
            }
            return obj;
        }
        throw new JsonMappingException((new StringBuilder()).append("Can not instantiate value of type ").append(getValueTypeDesc()).append(" from JSON long integral number; no single-long-arg constructor/factory method").toString());
    }

    public Object createFromObjectWith(Object aobj[])
        throws IOException, JsonProcessingException
    {
        if (_withArgsCreator == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No with-args constructor for ").append(getValueTypeDesc()).toString());
        }
        try
        {
            aobj = ((Object []) (_withArgsCreator.call(aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw wrapException(((Throwable) (aobj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw wrapException(((Throwable) (aobj)));
        }
        return ((Object) (aobj));
    }

    public Object createFromString(String s)
        throws IOException, JsonProcessingException
    {
        if (_fromStringCreator != null)
        {
            try
            {
                s = ((String) (_fromStringCreator.call1(s)));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw wrapException(s);
            }
            return s;
        } else
        {
            return _createFromStringFallbacks(s);
        }
    }

    public Object createUsingDefault()
        throws IOException, JsonProcessingException
    {
        if (_defaultCreator == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No default constructor for ").append(getValueTypeDesc()).toString());
        }
        Object obj;
        try
        {
            obj = _defaultCreator.call();
        }
        catch (ExceptionInInitializerError exceptionininitializererror)
        {
            throw wrapException(exceptionininitializererror);
        }
        catch (Exception exception)
        {
            throw wrapException(exception);
        }
        return obj;
    }

    public Object createUsingDelegate(Object obj)
        throws IOException, JsonProcessingException
    {
        if (_delegateCreator == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("No delegate constructor for ").append(getValueTypeDesc()).toString());
        }
        try
        {
            obj = _delegateCreator.call1(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw wrapException(((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw wrapException(((Throwable) (obj)));
        }
        return obj;
    }

    public AnnotatedWithParams getDefaultCreator()
    {
        return _defaultCreator;
    }

    public AnnotatedWithParams getDelegateCreator()
    {
        return _delegateCreator;
    }

    public JavaType getDelegateType()
    {
        return _delegateType;
    }

    public SettableBeanProperty[] getFromObjectArguments()
    {
        return _constructorArguments;
    }

    public String getValueTypeDesc()
    {
        return _valueTypeDesc;
    }

    public AnnotatedWithParams getWithArgsCreator()
    {
        return _withArgsCreator;
    }

    protected JsonMappingException wrapException(Throwable throwable)
    {
        for (; throwable.getCause() != null; throwable = throwable.getCause()) { }
        return new JsonMappingException((new StringBuilder()).append("Instantiation of ").append(getValueTypeDesc()).append(" value failed: ").append(throwable.getMessage()).toString(), throwable);
    }
}
