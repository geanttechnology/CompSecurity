// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.BindingAnnotation;
import com.google.inject.Key;
import com.google.inject.ScopeAnnotation;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.util.Classes;
import com.google.inject.name.Names;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Scope;
import org.roboguice.shaded.goole.common.base.Function;
import org.roboguice.shaded.goole.common.base.Joiner;
import org.roboguice.shaded.goole.common.base.Preconditions;
import org.roboguice.shaded.goole.common.cache.CacheBuilder;
import org.roboguice.shaded.goole.common.cache.CacheLoader;
import org.roboguice.shaded.goole.common.cache.LoadingCache;
import org.roboguice.shaded.goole.common.collect.ImmutableMap;
import org.roboguice.shaded.goole.common.collect.Maps;

// Referenced classes of package com.google.inject.internal:
//            Errors, ErrorsException

public class Annotations
{
    static class AnnotationChecker
    {

        private final Collection annotationTypes;
        final LoadingCache cache;
        private CacheLoader hasAnnotations;

        boolean hasAnnotations(Class class1)
        {
            return ((Boolean)cache.getUnchecked(class1)).booleanValue();
        }


        AnnotationChecker(Collection collection)
        {
            hasAnnotations = new _cls1();
            cache = CacheBuilder.newBuilder().weakKeys().build(hasAnnotations);
            annotationTypes = collection;
        }
    }


    private static final Function DEEP_TO_STRING_FN = new Function() {

        public volatile Object apply(Object obj)
        {
            return apply(obj);
        }

        public String apply(Object obj)
        {
            obj = Arrays.deepToString(new Object[] {
                obj
            });
            return ((String) (obj)).substring(1, ((String) (obj)).length() - 1);
        }

    };
    private static final org.roboguice.shaded.goole.common.base.Joiner.MapJoiner JOINER = Joiner.on(", ").withKeyValueSeparator("=");
    private static final AnnotationChecker bindingAnnotationChecker = new AnnotationChecker(Arrays.asList(new Class[] {
        com/google/inject/BindingAnnotation, javax/inject/Qualifier
    }));
    private static final LoadingCache cache = CacheBuilder.newBuilder().weakKeys().build(new CacheLoader() {

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((Class)obj);
        }

        public Annotation load(Class class1)
        {
            return Annotations.generateAnnotationImpl(class1);
        }

    });
    private static final AnnotationChecker scopeChecker = new AnnotationChecker(Arrays.asList(new Class[] {
        com/google/inject/ScopeAnnotation, javax/inject/Scope
    }));

    public Annotations()
    {
    }

    private static boolean annotationEquals(Class class1, Map map, Object obj)
        throws Exception
    {
        if (class1.isInstance(obj)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        class1 = class1.getDeclaredMethods();
        int j = class1.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                Object obj2 = class1[i];
                Object obj1 = ((Method) (obj2)).getName();
                obj2 = ((Method) (obj2)).invoke(obj, new Object[0]);
                obj1 = map.get(obj1);
                if (!Arrays.deepEquals(new Object[] {
    obj2
}, new Object[] {
    obj1
}))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    private static int annotationHashCode(Class class1, Map map)
        throws Exception
    {
        int j = 0;
        class1 = class1.getDeclaredMethods();
        int k = class1.length;
        for (int i = 0; i < k; i++)
        {
            String s = class1[i].getName();
            Object obj = map.get(s);
            j += s.hashCode() * 127 ^ Arrays.deepHashCode(new Object[] {
                obj
            }) - 31;
        }

        return j;
    }

    private static String annotationToString(Class class1, Map map)
        throws Exception
    {
        class1 = (new StringBuilder()).append("@").append(class1.getName()).append("(");
        JOINER.appendTo(class1, Maps.transformValues(map, DEEP_TO_STRING_FN));
        return class1.append(")").toString();
    }

    public static Class canonicalizeIfNamed(Class class1)
    {
        Object obj = class1;
        if (class1 == javax/inject/Named)
        {
            obj = com/google/inject/name/Named;
        }
        return ((Class) (obj));
    }

    public static Annotation canonicalizeIfNamed(Annotation annotation)
    {
        Object obj = annotation;
        if (annotation instanceof Named)
        {
            obj = Names.named(((Named)annotation).value());
        }
        return ((Annotation) (obj));
    }

    public static void checkForMisplacedScopeAnnotations(Class class1, Object obj, Errors errors)
    {
        Class class2;
        if (!Classes.isConcrete(class1))
        {
            if ((class2 = findScopeAnnotation(errors, class1)) != null)
            {
                errors.withSource(class1).scopeAnnotationOnAbstractType(class2, class1, obj);
                return;
            }
        }
    }

    public static Annotation findBindingAnnotation(Errors errors, Member member, Annotation aannotation[])
    {
        Annotation annotation = null;
        int j = aannotation.length;
        int i = 0;
        while (i < j) 
        {
            Annotation annotation2 = aannotation[i];
            Class class1 = annotation2.annotationType();
            Annotation annotation1 = annotation;
            if (isBindingAnnotation(class1))
            {
                if (annotation != null)
                {
                    errors.duplicateBindingAnnotations(member, annotation.annotationType(), class1);
                    annotation1 = annotation;
                } else
                {
                    annotation1 = annotation2;
                }
            }
            i++;
            annotation = annotation1;
        }
        return annotation;
    }

    public static Class findScopeAnnotation(Errors errors, Class class1)
    {
        return findScopeAnnotation(errors, class1.getAnnotations());
    }

    public static Class findScopeAnnotation(Errors errors, Annotation aannotation[])
    {
        Class class1 = null;
        int j = aannotation.length;
        int i = 0;
        while (i < j) 
        {
            Class class3 = aannotation[i].annotationType();
            Class class2 = class1;
            if (isScopeAnnotation(class3))
            {
                if (class1 != null)
                {
                    errors.duplicateScopeAnnotations(class1, class3);
                    class2 = class1;
                } else
                {
                    class2 = class3;
                }
            }
            i++;
            class1 = class2;
        }
        return class1;
    }

    public static Annotation generateAnnotation(Class class1)
    {
        Preconditions.checkState(isAllDefaultMethods(class1), "%s is not all default methods", new Object[] {
            class1
        });
        return (Annotation)cache.getUnchecked(class1);
    }

    private static Annotation generateAnnotationImpl(Class class1)
    {
        Object obj = resolveMembers(class1);
        ClassLoader classloader = class1.getClassLoader();
        obj = new InvocationHandler(class1, ((Map) (obj))) {

            final Class val$annotationType;
            final Map val$members;

            public Object invoke(Object obj1, Method method, Object aobj[])
                throws Exception
            {
                obj1 = method.getName();
                if (((String) (obj1)).equals("annotationType"))
                {
                    return annotationType;
                }
                if (((String) (obj1)).equals("toString"))
                {
                    return Annotations.annotationToString(annotationType, members);
                }
                if (((String) (obj1)).equals("hashCode"))
                {
                    return Integer.valueOf(Annotations.annotationHashCode(annotationType, members));
                }
                if (((String) (obj1)).equals("equals"))
                {
                    return Boolean.valueOf(Annotations.annotationEquals(annotationType, members, aobj[0]));
                } else
                {
                    return members.get(obj1);
                }
            }

            
            {
                annotationType = class1;
                members = map;
                super();
            }
        };
        return (Annotation)class1.cast(Proxy.newProxyInstance(classloader, new Class[] {
            class1
        }, ((InvocationHandler) (obj))));
    }

    public static Key getKey(TypeLiteral typeliteral, Member member, Annotation aannotation[], Errors errors)
        throws ErrorsException
    {
        int i = errors.size();
        member = findBindingAnnotation(errors, member, aannotation);
        errors.throwIfNewErrors(i);
        if (member == null)
        {
            return Key.get(typeliteral);
        } else
        {
            return Key.get(typeliteral, member);
        }
    }

    public static boolean isAllDefaultMethods(Class class1)
    {
        boolean flag = false;
        class1 = class1.getDeclaredMethods();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Method method = class1[i];
            flag = true;
            if (method.getDefaultValue() == null)
            {
                return false;
            }
        }

        return flag;
    }

    public static boolean isBindingAnnotation(Class class1)
    {
        return bindingAnnotationChecker.hasAnnotations(class1);
    }

    public static boolean isMarker(Class class1)
    {
        return class1.getDeclaredMethods().length == 0;
    }

    public static boolean isRetainedAtRuntime(Class class1)
    {
        class1 = (Retention)class1.getAnnotation(java/lang/annotation/Retention);
        return class1 != null && class1.value() == RetentionPolicy.RUNTIME;
    }

    public static boolean isScopeAnnotation(Class class1)
    {
        return scopeChecker.hasAnnotations(class1);
    }

    private static ImmutableMap resolveMembers(Class class1)
    {
        org.roboguice.shaded.goole.common.collect.ImmutableMap.Builder builder = ImmutableMap.builder();
        class1 = class1.getDeclaredMethods();
        int j = class1.length;
        for (int i = 0; i < j; i++)
        {
            Method method = class1[i];
            builder.put(method.getName(), method.getDefaultValue());
        }

        return builder.build();
    }






    // Unreferenced inner class com/google/inject/internal/Annotations$AnnotationChecker$1

/* anonymous class */
    class AnnotationChecker._cls1 extends CacheLoader
    {

        final AnnotationChecker this$0;

        public Boolean load(Class class1)
        {
            class1 = class1.getAnnotations();
            int j = class1.length;
            for (int i = 0; i < j; i++)
            {
                Annotation annotation = class1[i];
                if (annotationTypes.contains(annotation.annotationType()))
                {
                    return Boolean.valueOf(true);
                }
            }

            return Boolean.valueOf(false);
        }

        public volatile Object load(Object obj)
            throws Exception
        {
            return load((Class)obj);
        }

            
            {
                this$0 = AnnotationChecker.this;
                super();
            }
    }

}
