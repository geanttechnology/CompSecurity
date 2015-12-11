// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.deser.CreatorProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.std.StdValueInstantiator;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Member;
import java.util.HashMap;

public class CreatorCollector
{

    protected final BeanDescription _beanDesc;
    protected AnnotatedWithParams _booleanCreator;
    protected final boolean _canFixAccess;
    protected AnnotatedWithParams _defaultConstructor;
    protected CreatorProperty _delegateArgs[];
    protected AnnotatedWithParams _delegateCreator;
    protected AnnotatedWithParams _doubleCreator;
    protected AnnotatedParameter _incompleteParameter;
    protected AnnotatedWithParams _intCreator;
    protected AnnotatedWithParams _longCreator;
    protected CreatorProperty _propertyBasedArgs[];
    protected AnnotatedWithParams _propertyBasedCreator;
    protected AnnotatedWithParams _stringCreator;

    public CreatorCollector(BeanDescription beandescription, boolean flag)
    {
        _propertyBasedArgs = null;
        _beanDesc = beandescription;
        _canFixAccess = flag;
    }

    private AnnotatedMember _fixAccess(AnnotatedMember annotatedmember)
    {
        if (annotatedmember != null && _canFixAccess)
        {
            ClassUtil.checkAndFixAccess((Member)annotatedmember.getAnnotated());
        }
        return annotatedmember;
    }

    public void addBooleanCreator(AnnotatedWithParams annotatedwithparams)
    {
        _booleanCreator = verifyNonDup(annotatedwithparams, _booleanCreator, "boolean");
    }

    public void addDelegatingCreator(AnnotatedWithParams annotatedwithparams, CreatorProperty acreatorproperty[])
    {
        _delegateCreator = verifyNonDup(annotatedwithparams, _delegateCreator, "delegate");
        _delegateArgs = acreatorproperty;
    }

    public void addDoubleCreator(AnnotatedWithParams annotatedwithparams)
    {
        _doubleCreator = verifyNonDup(annotatedwithparams, _doubleCreator, "double");
    }

    public void addIncompeteParameter(AnnotatedParameter annotatedparameter)
    {
        if (_incompleteParameter == null)
        {
            _incompleteParameter = annotatedparameter;
        }
    }

    public void addIntCreator(AnnotatedWithParams annotatedwithparams)
    {
        _intCreator = verifyNonDup(annotatedwithparams, _intCreator, "int");
    }

    public void addLongCreator(AnnotatedWithParams annotatedwithparams)
    {
        _longCreator = verifyNonDup(annotatedwithparams, _longCreator, "long");
    }

    public void addPropertyCreator(AnnotatedWithParams annotatedwithparams, CreatorProperty acreatorproperty[])
    {
        int i;
        int j;
        _propertyBasedCreator = verifyNonDup(annotatedwithparams, _propertyBasedCreator, "property-based");
        if (acreatorproperty.length <= 1)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        annotatedwithparams = new HashMap();
        j = acreatorproperty.length;
        i = 0;
_L2:
        String s;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        s = acreatorproperty[i].getName();
        if (s.length() != 0 || acreatorproperty[i].getInjectableValueId() == null)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        i++;
        Integer integer;
        if (true) goto _L2; else goto _L1
_L1:
        if ((integer = (Integer)annotatedwithparams.put(s, Integer.valueOf(i))) == null) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException((new StringBuilder()).append("Duplicate creator property \"").append(s).append("\" (index ").append(integer).append(" vs ").append(i).append(")").toString());
        _propertyBasedArgs = acreatorproperty;
        return;
    }

    public void addStringCreator(AnnotatedWithParams annotatedwithparams)
    {
        _stringCreator = verifyNonDup(annotatedwithparams, _stringCreator, "String");
    }

    public ValueInstantiator constructValueInstantiator(DeserializationConfig deserializationconfig)
    {
        StdValueInstantiator stdvalueinstantiator = new StdValueInstantiator(deserializationconfig, _beanDesc.getType());
        if (_delegateCreator != null) goto _L2; else goto _L1
_L1:
        deserializationconfig = null;
_L5:
        stdvalueinstantiator.configureFromObjectSettings(_defaultConstructor, _delegateCreator, deserializationconfig, _delegateArgs, _propertyBasedCreator, _propertyBasedArgs);
        stdvalueinstantiator.configureFromStringCreator(_stringCreator);
        stdvalueinstantiator.configureFromIntCreator(_intCreator);
        stdvalueinstantiator.configureFromLongCreator(_longCreator);
        stdvalueinstantiator.configureFromDoubleCreator(_doubleCreator);
        stdvalueinstantiator.configureFromBooleanCreator(_booleanCreator);
        stdvalueinstantiator.configureIncompleteParameter(_incompleteParameter);
        return stdvalueinstantiator;
_L2:
        int i;
        int j;
        if (_delegateArgs == null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        j = _delegateArgs.length;
        i = 0;
_L6:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        if (_delegateArgs[i] != null) goto _L4; else goto _L3
_L3:
        deserializationconfig = _beanDesc.bindingsForBeanType().resolveType(_delegateCreator.getGenericParameterType(i));
          goto _L5
_L4:
        i++;
          goto _L6
        i = 0;
          goto _L3
    }

    public boolean hasDefaultCreator()
    {
        return _defaultConstructor != null;
    }

    public void setDefaultCreator(AnnotatedWithParams annotatedwithparams)
    {
        _defaultConstructor = (AnnotatedWithParams)_fixAccess(annotatedwithparams);
    }

    protected AnnotatedWithParams verifyNonDup(AnnotatedWithParams annotatedwithparams, AnnotatedWithParams annotatedwithparams1, String s)
    {
        if (annotatedwithparams1 != null && annotatedwithparams1.getClass() == annotatedwithparams.getClass())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Conflicting ").append(s).append(" creators: already had ").append(annotatedwithparams1).append(", encountered ").append(annotatedwithparams).toString());
        } else
        {
            return (AnnotatedWithParams)_fixAccess(annotatedwithparams);
        }
    }
}
