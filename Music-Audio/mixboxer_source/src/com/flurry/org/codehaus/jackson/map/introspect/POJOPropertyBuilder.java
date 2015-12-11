// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.introspect;

import com.flurry.org.codehaus.jackson.map.BeanPropertyDefinition;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.introspect:
//            AnnotatedMember, AnnotationMap, AnnotatedParameter, AnnotatedConstructor, 
//            AnnotatedField, AnnotatedMethod

public class POJOPropertyBuilder extends BeanPropertyDefinition
    implements Comparable
{
    private static final class Node
    {

        public final String explicitName;
        public final boolean isMarkedIgnored;
        public final boolean isVisible;
        public final Node next;
        public final Object value;

        private Node append(Node node)
        {
            if (next == null)
            {
                return withNext(node);
            } else
            {
                return withNext(next.append(node));
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

        public Node trimByVisibility()
        {
            Node node;
            if (next == null)
            {
                node = this;
            } else
            {
                Node node1 = next.trimByVisibility();
                if (explicitName != null)
                {
                    if (node1.explicitName == null)
                    {
                        return withNext(null);
                    } else
                    {
                        return withNext(node1);
                    }
                }
                node = node1;
                if (node1.explicitName == null)
                {
                    if (isVisible == node1.isVisible)
                    {
                        return withNext(node1);
                    }
                    node = node1;
                    if (isVisible)
                    {
                        return withNext(null);
                    }
                }
            }
            return node;
        }

        public Node withNext(Node node)
        {
            if (node == next)
            {
                return this;
            } else
            {
                return new Node(value, node, explicitName, isVisible, isMarkedIgnored);
            }
        }

        public Node withValue(Object obj)
        {
            if (obj == value)
            {
                return this;
            } else
            {
                return new Node(obj, next, explicitName, isVisible, isMarkedIgnored);
            }
        }

        public Node withoutIgnored()
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
                Node node = next.withoutIgnored();
                if (node != next)
                {
                    return withNext(node);
                }
            }
            return this;
        }

        public Node withoutNonVisible()
        {
            Node node;
            Node node1;
            if (next == null)
            {
                node = null;
            } else
            {
                node = next.withoutNonVisible();
            }
            node1 = node;
            if (isVisible)
            {
                node1 = withNext(node);
            }
            return node1;
        }


        public Node(Object obj, Node node, String s, boolean flag, boolean flag1)
        {
            value = obj;
            next = node;
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


    protected Node _ctorParameters;
    protected Node _fields;
    protected Node _getters;
    protected final String _internalName;
    protected final String _name;
    protected Node _setters;

    public POJOPropertyBuilder(POJOPropertyBuilder pojopropertybuilder, String s)
    {
        _internalName = pojopropertybuilder._internalName;
        _name = s;
        _fields = pojopropertybuilder._fields;
        _ctorParameters = pojopropertybuilder._ctorParameters;
        _getters = pojopropertybuilder._getters;
        _setters = pojopropertybuilder._setters;
    }

    public POJOPropertyBuilder(String s)
    {
        _internalName = s;
        _name = s;
    }

    private boolean _anyExplicitNames(Node node)
    {
        for (; node != null; node = node.next)
        {
            if (node.explicitName != null && node.explicitName.length() > 0)
            {
                return true;
            }
        }

        return false;
    }

    private boolean _anyIgnorals(Node node)
    {
        for (; node != null; node = node.next)
        {
            if (node.isMarkedIgnored)
            {
                return true;
            }
        }

        return false;
    }

    private boolean _anyVisible(Node node)
    {
        for (; node != null; node = node.next)
        {
            if (node.isVisible)
            {
                return true;
            }
        }

        return false;
    }

    private transient AnnotationMap _mergeAnnotations(int i, Node anode[])
    {
        AnnotationMap annotationmap1 = ((AnnotatedMember)anode[i].value).getAllAnnotations();
        i++;
        do
        {
label0:
            {
                AnnotationMap annotationmap = annotationmap1;
                if (i < anode.length)
                {
                    if (anode[i] == null)
                    {
                        break label0;
                    }
                    annotationmap = AnnotationMap.merge(annotationmap1, _mergeAnnotations(i, anode));
                }
                return annotationmap;
            }
            i++;
        } while (true);
    }

    private Node _removeIgnored(Node node)
    {
        if (node == null)
        {
            return node;
        } else
        {
            return node.withoutIgnored();
        }
    }

    private Node _removeNonVisible(Node node)
    {
        if (node == null)
        {
            return node;
        } else
        {
            return node.withoutNonVisible();
        }
    }

    private Node _trimByVisibility(Node node)
    {
        if (node == null)
        {
            return node;
        } else
        {
            return node.trimByVisibility();
        }
    }

    private Node findRenamed(Node node, Node node1)
    {
_L2:
        Node node2;
        String s;
        if (node == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        s = node.explicitName;
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
        node2 = node1;
_L3:
        node = node.next;
        node1 = node2;
        if (true) goto _L2; else goto _L1
_L1:
        node2 = node1;
        if (!s.equals(_name))
        {
label0:
            {
                if (node1 != null)
                {
                    break label0;
                }
                node2 = node;
            }
        }
          goto _L3
        continue; /* Loop/switch isn't completed */
        node2 = node1;
        if (s.equals(node1.explicitName)) goto _L3; else goto _L4
_L4:
        throw new IllegalStateException((new StringBuilder()).append("Conflicting property name definitions: '").append(node1.explicitName).append("' (for ").append(node1.value).append(") vs '").append(node.explicitName).append("' (for ").append(node.value).append(")").toString());
        return node1;
        if (true) goto _L2; else goto _L5
_L5:
    }

    private static Node merge(Node node, Node node1)
    {
        if (node == null)
        {
            return node1;
        }
        if (node1 == null)
        {
            return node;
        } else
        {
            return node.append(node1);
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
        _ctorParameters = new Node(annotatedparameter, _ctorParameters, s, flag, flag1);
    }

    public void addField(AnnotatedField annotatedfield, String s, boolean flag, boolean flag1)
    {
        _fields = new Node(annotatedfield, _fields, s, flag, flag1);
    }

    public void addGetter(AnnotatedMethod annotatedmethod, String s, boolean flag, boolean flag1)
    {
        _getters = new Node(annotatedmethod, _getters, s, flag, flag1);
    }

    public void addSetter(AnnotatedMethod annotatedmethod, String s, boolean flag, boolean flag1)
    {
        _setters = new Node(annotatedmethod, _setters, s, flag, flag1);
    }

    public boolean anyDeserializeIgnorals()
    {
        return _anyIgnorals(_fields) || _anyIgnorals(_setters) || _anyIgnorals(_ctorParameters);
    }

    public boolean anyExplicitNames()
    {
        return _anyExplicitNames(_fields) || _anyExplicitNames(_getters) || _anyExplicitNames(_setters) || _anyExplicitNames(_ctorParameters);
    }

    public boolean anyIgnorals()
    {
        return _anyIgnorals(_fields) || _anyIgnorals(_getters) || _anyIgnorals(_setters) || _anyIgnorals(_ctorParameters);
    }

    public boolean anySerializeIgnorals()
    {
        return _anyIgnorals(_fields) || _anyIgnorals(_getters);
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
        Node node = findRenamed(_fields, null);
        node = findRenamed(_getters, node);
        node = findRenamed(_setters, node);
        node = findRenamed(_ctorParameters, node);
        if (node == null)
        {
            return null;
        } else
        {
            return node.explicitName;
        }
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
        Node node = _ctorParameters;
        Node node1;
        do
        {
            if (((AnnotatedParameter)node.value).getOwner() instanceof AnnotatedConstructor)
            {
                return (AnnotatedParameter)node.value;
            }
            node1 = node.next;
            node = node1;
        } while (node1 != null);
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
        Node node;
        annotatedfield = (AnnotatedField)_fields.value;
        node = _fields.next;
_L9:
        annotatedfield1 = annotatedfield;
        if (node == null) goto _L4; else goto _L3
_L3:
        AnnotatedField annotatedfield2;
        Class class1;
        Class class2;
        annotatedfield2 = (AnnotatedField)node.value;
        class1 = annotatedfield.getDeclaringClass();
        class2 = annotatedfield2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedfield1 = annotatedfield2;
_L10:
        node = node.next;
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
        Node node;
        annotatedmethod = (AnnotatedMethod)_getters.value;
        node = _getters.next;
_L9:
        annotatedmethod1 = annotatedmethod;
        if (node == null) goto _L4; else goto _L3
_L3:
        AnnotatedMethod annotatedmethod2;
        Class class1;
        Class class2;
        annotatedmethod2 = (AnnotatedMethod)node.value;
        class1 = annotatedmethod.getDeclaringClass();
        class2 = annotatedmethod2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedmethod1 = annotatedmethod2;
_L10:
        node = node.next;
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

    public AnnotatedMethod getSetter()
    {
        if (_setters != null) goto _L2; else goto _L1
_L1:
        AnnotatedMethod annotatedmethod1 = null;
_L4:
        return annotatedmethod1;
_L2:
        AnnotatedMethod annotatedmethod;
        Node node;
        annotatedmethod = (AnnotatedMethod)_setters.value;
        node = _setters.next;
_L9:
        annotatedmethod1 = annotatedmethod;
        if (node == null) goto _L4; else goto _L3
_L3:
        AnnotatedMethod annotatedmethod2;
        Class class1;
        Class class2;
        annotatedmethod2 = (AnnotatedMethod)node.value;
        class1 = annotatedmethod.getDeclaringClass();
        class2 = annotatedmethod2.getDeclaringClass();
        if (class1 == class2) goto _L6; else goto _L5
_L5:
        if (!class1.isAssignableFrom(class2)) goto _L8; else goto _L7
_L7:
        annotatedmethod1 = annotatedmethod2;
_L10:
        node = node.next;
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

    public void mergeAnnotations(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (_getters == null) goto _L4; else goto _L3
_L3:
        AnnotationMap annotationmap = _mergeAnnotations(0, new Node[] {
            _getters, _fields, _ctorParameters, _setters
        });
        _getters = _getters.withValue(((AnnotatedMethod)_getters.value).withAnnotations(annotationmap));
_L6:
        return;
_L4:
        if (_fields != null)
        {
            AnnotationMap annotationmap1 = _mergeAnnotations(0, new Node[] {
                _fields, _ctorParameters, _setters
            });
            _fields = _fields.withValue(((AnnotatedField)_fields.value).withAnnotations(annotationmap1));
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (_ctorParameters != null)
        {
            AnnotationMap annotationmap2 = _mergeAnnotations(0, new Node[] {
                _ctorParameters, _setters, _fields, _getters
            });
            _ctorParameters = _ctorParameters.withValue(((AnnotatedParameter)_ctorParameters.value).withAnnotations(annotationmap2));
            return;
        }
        if (_setters != null)
        {
            AnnotationMap annotationmap3 = _mergeAnnotations(0, new Node[] {
                _setters, _fields, _getters
            });
            _setters = _setters.withValue(((AnnotatedMethod)_setters.value).withAnnotations(annotationmap3));
            return;
        }
        if (_fields != null)
        {
            AnnotationMap annotationmap4 = _mergeAnnotations(0, new Node[] {
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

    public POJOPropertyBuilder withName(String s)
    {
        return new POJOPropertyBuilder(this, s);
    }
}
