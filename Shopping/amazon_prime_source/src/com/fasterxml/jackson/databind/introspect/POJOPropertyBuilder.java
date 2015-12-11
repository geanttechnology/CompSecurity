// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;

// Referenced classes of package com.fasterxml.jackson.databind.introspect:
//            BeanPropertyDefinition, AnnotatedMember, AnnotationMap, ObjectIdInfo, 
//            AnnotatedParameter, AnnotatedConstructor, AnnotatedField, AnnotatedMethod

public class POJOPropertyBuilder extends BeanPropertyDefinition
    implements Comparable
{
    private static final class Linked
    {

        public final String explicitName;
        public final boolean isMarkedIgnored;
        public final boolean isVisible;
        public final Linked next;
        public final Object value;

        private Linked append(Linked linked)
        {
            if (next == null)
            {
                return withNext(linked);
            } else
            {
                return withNext(next.append(linked));
            }
        }

        public String toString()
        {
            String s1 = (new StringBuilder()).append(value.toString()).append("[visible=").append(isVisible).append("]").toString();
            String s = s1;
            if (next != null)
            {
                s = (new StringBuilder()).append(s1).append(", ").append(next.toString()).toString();
            }
            return s;
        }

        public Linked trimByVisibility()
        {
            Linked linked;
            if (next == null)
            {
                linked = this;
            } else
            {
                Linked linked1 = next.trimByVisibility();
                if (explicitName != null)
                {
                    if (linked1.explicitName == null)
                    {
                        return withNext(null);
                    } else
                    {
                        return withNext(linked1);
                    }
                }
                linked = linked1;
                if (linked1.explicitName == null)
                {
                    if (isVisible == linked1.isVisible)
                    {
                        return withNext(linked1);
                    }
                    linked = linked1;
                    if (isVisible)
                    {
                        return withNext(null);
                    }
                }
            }
            return linked;
        }

        public Linked withNext(Linked linked)
        {
            if (linked == next)
            {
                return this;
            } else
            {
                return new Linked(value, linked, explicitName, isVisible, isMarkedIgnored);
            }
        }

        public Linked withValue(Object obj)
        {
            if (obj == value)
            {
                return this;
            } else
            {
                return new Linked(obj, next, explicitName, isVisible, isMarkedIgnored);
            }
        }

        public Linked withoutIgnored()
        {
            if (isMarkedIgnored)
            {
                if (next == null)
                {
                    return null;
                } else
                {
                    return next.withoutIgnored();
                }
            }
            if (next != null)
            {
                Linked linked = next.withoutIgnored();
                if (linked != next)
                {
                    return withNext(linked);
                }
            }
            return this;
        }

        public Linked withoutNonVisible()
        {
            Linked linked;
            Linked linked1;
            if (next == null)
            {
                linked = null;
            } else
            {
                linked = next.withoutNonVisible();
            }
            linked1 = linked;
            if (isVisible)
            {
                linked1 = withNext(linked);
            }
            return linked1;
        }


        public Linked(Object obj, Linked linked, String s, boolean flag, boolean flag1)
        {
            value = obj;
            next = linked;
            if (s == null)
            {
                explicitName = null;
            } else
            {
                obj = s;
                if (s.length() == 0)
                {
                    obj = null;
                }
                explicitName = ((String) (obj));
            }
            isVisible = flag;
            isMarkedIgnored = flag1;
        }
    }

    private static interface WithMember
    {

        public abstract Object withMember(AnnotatedMember annotatedmember);
    }


    protected final AnnotationIntrospector _annotationIntrospector;
    protected Linked _ctorParameters;
    protected Linked _fields;
    protected final boolean _forSerialization;
    protected Linked _getters;
    protected final String _internalName;
    protected final String _name;
    protected Linked _setters;

    public POJOPropertyBuilder(POJOPropertyBuilder pojopropertybuilder, String s)
    {
        _internalName = pojopropertybuilder._internalName;
        _name = s;
        _annotationIntrospector = pojopropertybuilder._annotationIntrospector;
        _fields = pojopropertybuilder._fields;
        _ctorParameters = pojopropertybuilder._ctorParameters;
        _getters = pojopropertybuilder._getters;
        _setters = pojopropertybuilder._setters;
        _forSerialization = pojopropertybuilder._forSerialization;
    }

    public POJOPropertyBuilder(String s, AnnotationIntrospector annotationintrospector, boolean flag)
    {
        _internalName = s;
        _name = s;
        _annotationIntrospector = annotationintrospector;
        _forSerialization = flag;
    }

    private boolean _anyExplicitNames(Linked linked)
    {
        for (; linked != null; linked = linked.next)
        {
            if (linked.explicitName != null && linked.explicitName.length() > 0)
            {
                return true;
            }
        }

        return false;
    }

    private boolean _anyIgnorals(Linked linked)
    {
        for (; linked != null; linked = linked.next)
        {
            if (linked.isMarkedIgnored)
            {
                return true;
            }
        }

        return false;
    }

    private boolean _anyVisible(Linked linked)
    {
        for (; linked != null; linked = linked.next)
        {
            if (linked.isVisible)
            {
                return true;
            }
        }

        return false;
    }

    private transient AnnotationMap _mergeAnnotations(int i, Linked alinked[])
    {
        AnnotationMap annotationmap1 = ((AnnotatedMember)alinked[i].value).getAllAnnotations();
        i++;
        do
        {
label0:
            {
                AnnotationMap annotationmap = annotationmap1;
                if (i < alinked.length)
                {
                    if (alinked[i] == null)
                    {
                        break label0;
                    }
                    annotationmap = AnnotationMap.merge(annotationmap1, _mergeAnnotations(i, alinked));
                }
                return annotationmap;
            }
            i++;
        } while (true);
    }

    private Linked _removeIgnored(Linked linked)
    {
        if (linked == null)
        {
            return linked;
        } else
        {
            return linked.withoutIgnored();
        }
    }

    private Linked _removeNonVisible(Linked linked)
    {
        if (linked == null)
        {
            return linked;
        } else
        {
            return linked.withoutNonVisible();
        }
    }

    private Linked _trimByVisibility(Linked linked)
    {
        if (linked == null)
        {
            return linked;
        } else
        {
            return linked.trimByVisibility();
        }
    }

    private Linked findRenamed(Linked linked, Linked linked1)
    {
_L2:
        Linked linked2;
        String s;
        if (linked == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        s = linked.explicitName;
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
        linked2 = linked1;
_L3:
        linked = linked.next;
        linked1 = linked2;
        if (true) goto _L2; else goto _L1
_L1:
        linked2 = linked1;
        if (!s.equals(_name))
        {
label0:
            {
                if (linked1 != null)
                {
                    break label0;
                }
                linked2 = linked;
            }
        }
          goto _L3
        continue; /* Loop/switch isn't completed */
        linked2 = linked1;
        if (s.equals(linked1.explicitName)) goto _L3; else goto _L4
_L4:
        throw new IllegalStateException((new StringBuilder()).append("Conflicting property name definitions: '").append(linked1.explicitName).append("' (for ").append(linked1.value).append(") vs '").append(linked.explicitName).append("' (for ").append(linked.value).append(")").toString());
        return linked1;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static Linked merge(Linked linked, Linked linked1)
    {
        if (linked == null)
        {
            return linked1;
        }
        if (linked1 == null)
        {
            return linked;
        } else
        {
            return linked.append(linked1);
        }
    }

    public void addAll(POJOPropertyBuilder pojopropertybuilder)
    {
        _fields = merge(_fields, pojopropertybuilder._fields);
        _ctorParameters = merge(_ctorParameters, pojopropertybuilder._ctorParameters);
        _getters = merge(_getters, pojopropertybuilder._getters);
        _setters = merge(_setters, pojopropertybuilder._setters);
    }

    public void addCtor(AnnotatedParameter annotatedparameter, String s, boolean flag, boolean flag1)
    {
        _ctorParameters = new Linked(annotatedparameter, _ctorParameters, s, flag, flag1);
    }

    public void addField(AnnotatedField annotatedfield, String s, boolean flag, boolean flag1)
    {
        _fields = new Linked(annotatedfield, _fields, s, flag, flag1);
    }

    public void addGetter(AnnotatedMethod annotatedmethod, String s, boolean flag, boolean flag1)
    {
        _getters = new Linked(annotatedmethod, _getters, s, flag, flag1);
    }

    public void addSetter(AnnotatedMethod annotatedmethod, String s, boolean flag, boolean flag1)
    {
        _setters = new Linked(annotatedmethod, _setters, s, flag, flag1);
    }

    public boolean anyIgnorals()
    {
        return _anyIgnorals(_fields) || _anyIgnorals(_getters) || _anyIgnorals(_setters) || _anyIgnorals(_ctorParameters);
    }

    public boolean anyVisible()
    {
        return _anyVisible(_fields) || _anyVisible(_getters) || _anyVisible(_setters) || _anyVisible(_ctorParameters);
    }

    public int compareTo(POJOPropertyBuilder pojopropertybuilder)
    {
        if (_ctorParameters != null)
        {
            if (pojopropertybuilder._ctorParameters == null)
            {
                return -1;
            }
        } else
        if (pojopropertybuilder._ctorParameters != null)
        {
            return 1;
        }
        return getName().compareTo(pojopropertybuilder.getName());
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((POJOPropertyBuilder)obj);
    }

    public boolean couldSerialize()
    {
        return _getters != null || _fields != null;
    }

    public String findNewName()
    {
        Linked linked = findRenamed(_fields, null);
        linked = findRenamed(_getters, linked);
        linked = findRenamed(_setters, linked);
        linked = findRenamed(_ctorParameters, linked);
        if (linked == null)
        {
            return null;
        } else
        {
            return linked.explicitName;
        }
    }

    public ObjectIdInfo findObjectIdInfo()
    {
        return (ObjectIdInfo)fromMemberAnnotations(new WithMember() {

            final POJOPropertyBuilder this$0;

            public ObjectIdInfo withMember(AnnotatedMember annotatedmember)
            {
                ObjectIdInfo objectidinfo1 = _annotationIntrospector.findObjectIdInfo(annotatedmember);
                ObjectIdInfo objectidinfo = objectidinfo1;
                if (objectidinfo1 != null)
                {
                    objectidinfo = _annotationIntrospector.findObjectReferenceInfo(annotatedmember, objectidinfo1);
                }
                return objectidinfo;
            }

            public volatile Object withMember(AnnotatedMember annotatedmember)
            {
                return withMember(annotatedmember);
            }

            
            {
                this$0 = POJOPropertyBuilder.this;
                super();
            }
        });
    }

    public com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty findReferenceType()
    {
        return (com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty)fromMemberAnnotations(new WithMember() {

            final POJOPropertyBuilder this$0;

            public com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember annotatedmember)
            {
                return _annotationIntrospector.findReferenceType(annotatedmember);
            }

            public volatile Object withMember(AnnotatedMember annotatedmember)
            {
                return withMember(annotatedmember);
            }

            
            {
                this$0 = POJOPropertyBuilder.this;
                super();
            }
        });
    }

    public Class[] findViews()
    {
        return (Class[])fromMemberAnnotations(new WithMember() {

            final POJOPropertyBuilder this$0;

            public volatile Object withMember(AnnotatedMember annotatedmember)
            {
                return withMember(annotatedmember);
            }

            public Class[] withMember(AnnotatedMember annotatedmember)
            {
                return _annotationIntrospector.findViews(annotatedmember);
            }

            
            {
                this$0 = POJOPropertyBuilder.this;
                super();
            }
        });
    }

    protected Object fromMemberAnnotations(WithMember withmember)
    {
        Object obj;
        Object obj1;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj = null;
        if (_annotationIntrospector == null) goto _L2; else goto _L1
_L1:
        if (!_forSerialization) goto _L4; else goto _L3
_L3:
        if (_getters != null)
        {
            obj = withmember.withMember((AnnotatedMember)_getters.value);
        }
_L6:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (_fields != null)
            {
                obj1 = withmember.withMember((AnnotatedMember)_fields.value);
            }
        }
_L2:
        return obj1;
_L4:
        Object obj2 = obj3;
        if (_ctorParameters != null)
        {
            obj2 = withmember.withMember((AnnotatedMember)_ctorParameters.value);
        }
        obj = obj2;
        if (obj2 == null)
        {
            obj = obj2;
            if (_setters != null)
            {
                obj = withmember.withMember((AnnotatedMember)_setters.value);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public AnnotatedMember getAccessor()
    {
        AnnotatedMethod annotatedmethod = getGetter();
        Object obj = annotatedmethod;
        if (annotatedmethod == null)
        {
            obj = getField();
        }
        return ((AnnotatedMember) (obj));
    }

    public AnnotatedParameter getConstructorParameter()
    {
        if (_ctorParameters == null)
        {
            return null;
        }
        Linked linked = _ctorParameters;
        Linked linked1;
        do
        {
            if (((AnnotatedParameter)linked.value).getOwner() instanceof AnnotatedConstructor)
            {
                return (AnnotatedParameter)linked.value;
            }
            linked1 = linked.next;
            linked = linked1;
        } while (linked1 != null);
        return (AnnotatedParameter)_ctorParameters.value;
    }

    public AnnotatedField getField()
    {
        if (_fields != null) goto _L2; else goto _L1
_L1:
        AnnotatedField annotatedfield1 = null;
_L4:
        return annotatedfield1;
_L2:
        AnnotatedField annotatedfield;
        Linked linked;
        annotatedfield = (AnnotatedField)_fields.value;
        linked = _fields.next;
_L9:
        annotatedfield1 = annotatedfield;
        if (linked == null) goto _L4; else goto _L3
_L3:
        AnnotatedField annotatedfield2;
        Class class1;
        Class class2;
        annotatedfield2 = (AnnotatedField)linked.value;
        class1 = annotatedfield.getDeclaringClass();
        class2 = annotatedfield2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedfield1 = annotatedfield2;
_L10:
        linked = linked.next;
        annotatedfield = annotatedfield1;
          goto _L9
_L8:
        annotatedfield1 = annotatedfield;
        if (class2.isAssignableFrom(class1)) goto _L10; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Multiple fields representing property \"").append(getName()).append("\": ").append(annotatedfield.getFullName()).append(" vs ").append(annotatedfield2.getFullName()).toString());
    }

    public AnnotatedMethod getGetter()
    {
        if (_getters != null) goto _L2; else goto _L1
_L1:
        AnnotatedMethod annotatedmethod1 = null;
_L4:
        return annotatedmethod1;
_L2:
        AnnotatedMethod annotatedmethod;
        Linked linked;
        annotatedmethod = (AnnotatedMethod)_getters.value;
        linked = _getters.next;
_L9:
        annotatedmethod1 = annotatedmethod;
        if (linked == null) goto _L4; else goto _L3
_L3:
        AnnotatedMethod annotatedmethod2;
        Class class1;
        Class class2;
        annotatedmethod2 = (AnnotatedMethod)linked.value;
        class1 = annotatedmethod.getDeclaringClass();
        class2 = annotatedmethod2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedmethod1 = annotatedmethod2;
_L10:
        linked = linked.next;
        annotatedmethod = annotatedmethod1;
          goto _L9
_L8:
        annotatedmethod1 = annotatedmethod;
        if (class2.isAssignableFrom(class1)) goto _L10; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Conflicting getter definitions for property \"").append(getName()).append("\": ").append(annotatedmethod.getFullName()).append(" vs ").append(annotatedmethod2.getFullName()).toString());
    }

    public String getInternalName()
    {
        return _internalName;
    }

    public AnnotatedMember getMutator()
    {
        AnnotatedParameter annotatedparameter = getConstructorParameter();
        Object obj = annotatedparameter;
        if (annotatedparameter == null)
        {
            AnnotatedMethod annotatedmethod = getSetter();
            obj = annotatedmethod;
            if (annotatedmethod == null)
            {
                obj = getField();
            }
        }
        return ((AnnotatedMember) (obj));
    }

    public String getName()
    {
        return _name;
    }

    public AnnotatedMember getPrimaryMember()
    {
        if (_forSerialization)
        {
            return getAccessor();
        } else
        {
            return getMutator();
        }
    }

    public AnnotatedMethod getSetter()
    {
        if (_setters != null) goto _L2; else goto _L1
_L1:
        AnnotatedMethod annotatedmethod1 = null;
_L4:
        return annotatedmethod1;
_L2:
        AnnotatedMethod annotatedmethod;
        Linked linked;
        annotatedmethod = (AnnotatedMethod)_setters.value;
        linked = _setters.next;
_L9:
        annotatedmethod1 = annotatedmethod;
        if (linked == null) goto _L4; else goto _L3
_L3:
        AnnotatedMethod annotatedmethod2;
        Class class1;
        Class class2;
        annotatedmethod2 = (AnnotatedMethod)linked.value;
        class1 = annotatedmethod.getDeclaringClass();
        class2 = annotatedmethod2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedmethod1 = annotatedmethod2;
_L10:
        linked = linked.next;
        annotatedmethod = annotatedmethod1;
          goto _L9
_L8:
        annotatedmethod1 = annotatedmethod;
        if (class2.isAssignableFrom(class1)) goto _L10; else goto _L6
_L6:
        throw new IllegalArgumentException((new StringBuilder()).append("Conflicting setter definitions for property \"").append(getName()).append("\": ").append(annotatedmethod.getFullName()).append(" vs ").append(annotatedmethod2.getFullName()).toString());
    }

    public boolean hasConstructorParameter()
    {
        return _ctorParameters != null;
    }

    public boolean hasField()
    {
        return _fields != null;
    }

    public boolean hasGetter()
    {
        return _getters != null;
    }

    public boolean hasSetter()
    {
        return _setters != null;
    }

    public boolean isExplicitlyIncluded()
    {
        return _anyExplicitNames(_fields) || _anyExplicitNames(_getters) || _anyExplicitNames(_setters) || _anyExplicitNames(_ctorParameters);
    }

    public boolean isRequired()
    {
        Boolean boolean1 = (Boolean)fromMemberAnnotations(new WithMember() {

            final POJOPropertyBuilder this$0;

            public Boolean withMember(AnnotatedMember annotatedmember)
            {
                return _annotationIntrospector.hasRequiredMarker(annotatedmember);
            }

            public volatile Object withMember(AnnotatedMember annotatedmember)
            {
                return withMember(annotatedmember);
            }

            
            {
                this$0 = POJOPropertyBuilder.this;
                super();
            }
        });
        return boolean1 != null && boolean1.booleanValue();
    }

    public boolean isTypeId()
    {
        Boolean boolean1 = (Boolean)fromMemberAnnotations(new WithMember() {

            final POJOPropertyBuilder this$0;

            public Boolean withMember(AnnotatedMember annotatedmember)
            {
                return _annotationIntrospector.isTypeId(annotatedmember);
            }

            public volatile Object withMember(AnnotatedMember annotatedmember)
            {
                return withMember(annotatedmember);
            }

            
            {
                this$0 = POJOPropertyBuilder.this;
                super();
            }
        });
        return boolean1 != null && boolean1.booleanValue();
    }

    public void mergeAnnotations(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (_getters == null) goto _L4; else goto _L3
_L3:
        AnnotationMap annotationmap = _mergeAnnotations(0, new Linked[] {
            _getters, _fields, _ctorParameters, _setters
        });
        _getters = _getters.withValue(((AnnotatedMethod)_getters.value).withAnnotations(annotationmap));
_L6:
        return;
_L4:
        if (_fields != null)
        {
            AnnotationMap annotationmap1 = _mergeAnnotations(0, new Linked[] {
                _fields, _ctorParameters, _setters
            });
            _fields = _fields.withValue(((AnnotatedField)_fields.value).withAnnotations(annotationmap1));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (_ctorParameters != null)
        {
            AnnotationMap annotationmap2 = _mergeAnnotations(0, new Linked[] {
                _ctorParameters, _setters, _fields, _getters
            });
            _ctorParameters = _ctorParameters.withValue(((AnnotatedParameter)_ctorParameters.value).withAnnotations(annotationmap2));
            return;
        }
        if (_setters != null)
        {
            AnnotationMap annotationmap3 = _mergeAnnotations(0, new Linked[] {
                _setters, _fields, _getters
            });
            _setters = _setters.withValue(((AnnotatedMethod)_setters.value).withAnnotations(annotationmap3));
            return;
        }
        if (_fields != null)
        {
            AnnotationMap annotationmap4 = _mergeAnnotations(0, new Linked[] {
                _fields, _getters
            });
            _fields = _fields.withValue(((AnnotatedField)_fields.value).withAnnotations(annotationmap4));
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void removeIgnored()
    {
        _fields = _removeIgnored(_fields);
        _getters = _removeIgnored(_getters);
        _setters = _removeIgnored(_setters);
        _ctorParameters = _removeIgnored(_ctorParameters);
    }

    public void removeNonVisible()
    {
        _getters = _removeNonVisible(_getters);
        _ctorParameters = _removeNonVisible(_ctorParameters);
        if (_getters == null)
        {
            _fields = _removeNonVisible(_fields);
            _setters = _removeNonVisible(_setters);
        }
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[Property '").append(_name).append("'; ctors: ").append(_ctorParameters).append(", field(s): ").append(_fields).append(", getter(s): ").append(_getters).append(", setter(s): ").append(_setters);
        stringbuilder.append("]");
        return stringbuilder.toString();
    }

    public void trimByVisibility()
    {
        _fields = _trimByVisibility(_fields);
        _getters = _trimByVisibility(_getters);
        _setters = _trimByVisibility(_setters);
        _ctorParameters = _trimByVisibility(_ctorParameters);
    }

    public volatile BeanPropertyDefinition withName(String s)
    {
        return withName(s);
    }

    public POJOPropertyBuilder withName(String s)
    {
        return new POJOPropertyBuilder(this, s);
    }
}
