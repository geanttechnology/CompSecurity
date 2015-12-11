// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.List;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.NopAnnotationIntrospector;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

// Referenced classes of package org.codehaus.jackson.map:
//            MapperConfig

public abstract class AnnotationIntrospector
{
    public static class ReferenceProperty
    {

        private final String _name;
        private final Type _type;

        public static ReferenceProperty back(String s)
        {
            return new ReferenceProperty(Type.BACK_REFERENCE, s);
        }

        public static ReferenceProperty managed(String s)
        {
            return new ReferenceProperty(Type.MANAGED_REFERENCE, s);
        }

        public String getName()
        {
            return _name;
        }

        public boolean isBackReference()
        {
            return _type == Type.BACK_REFERENCE;
        }

        public boolean isManagedReference()
        {
            return _type == Type.MANAGED_REFERENCE;
        }

        public ReferenceProperty(Type type, String s)
        {
            _type = type;
            _name = s;
        }
    }

    public static final class ReferenceProperty.Type extends Enum
    {

        private static final ReferenceProperty.Type $VALUES[];
        public static final ReferenceProperty.Type BACK_REFERENCE;
        public static final ReferenceProperty.Type MANAGED_REFERENCE;

        public static ReferenceProperty.Type valueOf(String s)
        {
            return (ReferenceProperty.Type)Enum.valueOf(org/codehaus/jackson/map/AnnotationIntrospector$ReferenceProperty$Type, s);
        }

        public static ReferenceProperty.Type[] values()
        {
            return (ReferenceProperty.Type[])$VALUES.clone();
        }

        static 
        {
            MANAGED_REFERENCE = new ReferenceProperty.Type("MANAGED_REFERENCE", 0);
            BACK_REFERENCE = new ReferenceProperty.Type("BACK_REFERENCE", 1);
            $VALUES = (new ReferenceProperty.Type[] {
                MANAGED_REFERENCE, BACK_REFERENCE
            });
        }

        private ReferenceProperty.Type(String s, int i)
        {
            super(s, i);
        }
    }


    public AnnotationIntrospector()
    {
    }

    public static AnnotationIntrospector nopInstance()
    {
        return NopAnnotationIntrospector.instance;
    }

    public VisibilityChecker findAutoDetectVisibility(AnnotatedClass annotatedclass, VisibilityChecker visibilitychecker)
    {
        return visibilitychecker;
    }

    public Boolean findCachability(AnnotatedClass annotatedclass)
    {
        return null;
    }

    public abstract Class findContentDeserializer(Annotated annotated);

    public Class findContentSerializer(Annotated annotated)
    {
        return null;
    }

    public abstract String findDeserializablePropertyName(AnnotatedField annotatedfield);

    public abstract Class findDeserializationContentType(Annotated annotated, JavaType javatype, String s);

    public abstract Class findDeserializationKeyType(Annotated annotated, JavaType javatype, String s);

    public abstract Class findDeserializationType(Annotated annotated, JavaType javatype, String s);

    public abstract Object findDeserializer(Annotated annotated);

    public abstract String findEnumValue(Enum enum);

    public Object findFilterId(AnnotatedClass annotatedclass)
    {
        return null;
    }

    public abstract String findGettablePropertyName(AnnotatedMethod annotatedmethod);

    public abstract Boolean findIgnoreUnknownProperties(AnnotatedClass annotatedclass);

    public Object findInjectableValueId(AnnotatedMember annotatedmember)
    {
        return null;
    }

    public abstract Class findKeyDeserializer(Annotated annotated);

    public Class findKeySerializer(Annotated annotated)
    {
        return null;
    }

    public abstract String[] findPropertiesToIgnore(AnnotatedClass annotatedclass);

    public TypeResolverBuilder findPropertyContentTypeResolver(MapperConfig mapperconfig, AnnotatedMember annotatedmember, JavaType javatype)
    {
        return null;
    }

    public abstract String findPropertyNameForParam(AnnotatedParameter annotatedparameter);

    public TypeResolverBuilder findPropertyTypeResolver(MapperConfig mapperconfig, AnnotatedMember annotatedmember, JavaType javatype)
    {
        return null;
    }

    public ReferenceProperty findReferenceType(AnnotatedMember annotatedmember)
    {
        return null;
    }

    public abstract String findRootName(AnnotatedClass annotatedclass);

    public abstract String findSerializablePropertyName(AnnotatedField annotatedfield);

    public Class findSerializationContentType(Annotated annotated, JavaType javatype)
    {
        return null;
    }

    public org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion findSerializationInclusion(Annotated annotated, org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion inclusion)
    {
        return inclusion;
    }

    public Class findSerializationKeyType(Annotated annotated, JavaType javatype)
    {
        return null;
    }

    public abstract String[] findSerializationPropertyOrder(AnnotatedClass annotatedclass);

    public abstract Boolean findSerializationSortAlphabetically(AnnotatedClass annotatedclass);

    public abstract Class findSerializationType(Annotated annotated);

    public abstract org.codehaus.jackson.map.annotate.JsonSerialize.Typing findSerializationTyping(Annotated annotated);

    public abstract Class[] findSerializationViews(Annotated annotated);

    public abstract Object findSerializer(Annotated annotated);

    public abstract String findSettablePropertyName(AnnotatedMethod annotatedmethod);

    public List findSubtypes(Annotated annotated)
    {
        return null;
    }

    public String findTypeName(AnnotatedClass annotatedclass)
    {
        return null;
    }

    public TypeResolverBuilder findTypeResolver(MapperConfig mapperconfig, AnnotatedClass annotatedclass, JavaType javatype)
    {
        return null;
    }

    public Object findValueInstantiator(AnnotatedClass annotatedclass)
    {
        return null;
    }

    public boolean hasAnyGetterAnnotation(AnnotatedMethod annotatedmethod)
    {
        return false;
    }

    public boolean hasAnySetterAnnotation(AnnotatedMethod annotatedmethod)
    {
        return false;
    }

    public abstract boolean hasAsValueAnnotation(AnnotatedMethod annotatedmethod);

    public boolean hasCreatorAnnotation(Annotated annotated)
    {
        return false;
    }

    public boolean hasIgnoreMarker(AnnotatedMember annotatedmember)
    {
        if (annotatedmember instanceof AnnotatedMethod)
        {
            return isIgnorableMethod((AnnotatedMethod)annotatedmember);
        }
        if (annotatedmember instanceof AnnotatedField)
        {
            return isIgnorableField((AnnotatedField)annotatedmember);
        }
        if (annotatedmember instanceof AnnotatedConstructor)
        {
            return isIgnorableConstructor((AnnotatedConstructor)annotatedmember);
        } else
        {
            return false;
        }
    }

    public abstract boolean isHandled(Annotation annotation);

    public abstract boolean isIgnorableConstructor(AnnotatedConstructor annotatedconstructor);

    public abstract boolean isIgnorableField(AnnotatedField annotatedfield);

    public abstract boolean isIgnorableMethod(AnnotatedMethod annotatedmethod);

    public Boolean isIgnorableType(AnnotatedClass annotatedclass)
    {
        return null;
    }

    public Boolean shouldUnwrapProperty(AnnotatedMember annotatedmember)
    {
        return null;
    }
}
