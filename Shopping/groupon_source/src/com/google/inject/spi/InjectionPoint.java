// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.spi;

import com.google.inject.ConfigurationException;
import com.google.inject.Guice;
import com.google.inject.HierarchyTraversalFilter;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Annotations;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.MoreTypes;
import com.google.inject.internal.Nullability;
import com.google.inject.internal.util.Classes;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;

// Referenced classes of package com.google.inject.spi:
//            Dependency, Toolable

public final class InjectionPoint
{
    static class InjectableField extends InjectableMember
    {

        final Field field;

        InjectionPoint toInjectionPoint()
        {
            return new InjectionPoint(declaringType, field, optional);
        }

        InjectableField(TypeLiteral typeliteral, Field field1, Annotation annotation)
        {
            super(typeliteral, annotation);
            field = field1;
        }
    }

    static abstract class InjectableMember
    {

        final TypeLiteral declaringType;
        final boolean jsr330;
        InjectableMember next;
        final boolean optional;
        InjectableMember previous;

        abstract InjectionPoint toInjectionPoint();

        InjectableMember(TypeLiteral typeliteral, Annotation annotation)
        {
            declaringType = typeliteral;
            if (annotation.annotationType() == javax/inject/Inject)
            {
                optional = false;
                jsr330 = true;
                return;
            } else
            {
                jsr330 = false;
                optional = ((Inject)annotation).optional();
                return;
            }
        }
    }

    static class InjectableMembers
    {

        InjectableMember head;
        InjectableMember tail;

        void add(InjectableMember injectablemember)
        {
            if (head == null)
            {
                tail = injectablemember;
                head = injectablemember;
                return;
            } else
            {
                injectablemember.previous = tail;
                tail.next = injectablemember;
                tail = injectablemember;
                return;
            }
        }

        void addAll(InjectableMembers injectablemembers)
        {
            for (injectablemembers = injectablemembers.head; injectablemembers != null; injectablemembers = ((InjectableMember) (injectablemembers)).next)
            {
                add(injectablemembers);
            }

        }

        boolean isEmpty()
        {
            return head == null;
        }

        void remove(InjectableMember injectablemember)
        {
            if (injectablemember.previous != null)
            {
                injectablemember.previous.next = injectablemember.next;
            }
            if (injectablemember.next != null)
            {
                injectablemember.next.previous = injectablemember.previous;
            }
            if (head == injectablemember)
            {
                head = injectablemember.next;
            }
            if (tail == injectablemember)
            {
                tail = injectablemember.previous;
            }
        }

        InjectableMembers()
        {
        }
    }

    static class InjectableMethod extends InjectableMember
    {

        final Method method;
        boolean overrodeGuiceInject;

        public boolean isFinal()
        {
            return Modifier.isFinal(method.getModifiers());
        }

        InjectionPoint toInjectionPoint()
        {
            return new InjectionPoint(declaringType, method, optional);
        }

        InjectableMethod(TypeLiteral typeliteral, Method method1, Annotation annotation)
        {
            super(typeliteral, annotation);
            method = method1;
        }
    }

    static class OverrideIndex
    {

        Map bySignature;
        final InjectableMembers injectableMembers;
        Method lastMethod;
        Signature lastSignature;
        Position position;

        void add(InjectableMethod injectablemethod)
        {
            injectableMembers.add(injectablemethod);
            while (position == Position.BOTTOM || injectablemethod.isFinal() || bySignature == null) 
            {
                return;
            }
            Signature signature;
            Object obj;
            List list;
            if (injectablemethod.method == lastMethod)
            {
                signature = lastSignature;
            } else
            {
                signature = new Signature(injectablemethod.method);
            }
            list = (List)bySignature.get(signature);
            obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                bySignature.put(signature, obj);
            }
            ((List) (obj)).add(injectablemethod);
        }

        boolean removeIfOverriddenBy(Method method, boolean flag, InjectableMethod injectablemethod)
        {
            if (position != Position.TOP) goto _L2; else goto _L1
_L1:
            boolean flag2 = false;
_L4:
            return flag2;
_L2:
            if (bySignature == null)
            {
                bySignature = new HashMap();
                InjectableMember injectablemember = injectableMembers.head;
                while (injectablemember != null) 
                {
                    if (injectablemember instanceof InjectableMethod)
                    {
                        InjectableMethod injectablemethod1 = (InjectableMethod)injectablemember;
                        if (!injectablemethod1.isFinal())
                        {
                            ArrayList arraylist = new ArrayList();
                            arraylist.add(injectablemethod1);
                            bySignature.put(new Signature(injectablemethod1.method), arraylist);
                        }
                    }
                    injectablemember = injectablemember.next;
                }
            }
            lastMethod = method;
            Object obj = new Signature(method);
            lastSignature = ((Signature) (obj));
            obj = (List)bySignature.get(obj);
            boolean flag1 = false;
            flag2 = false;
            if (obj == null)
            {
                continue;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                flag2 = flag1;
                if (!((Iterator) (obj)).hasNext())
                {
                    continue;
                }
                InjectableMethod injectablemethod2 = (InjectableMethod)((Iterator) (obj)).next();
                if (InjectionPoint.overrides(method, injectablemethod2.method))
                {
                    boolean flag3;
                    if (!injectablemethod2.jsr330 || injectablemethod2.overrodeGuiceInject)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    if (injectablemethod != null)
                    {
                        injectablemethod.overrodeGuiceInject = flag3;
                    }
                    if (flag || !flag3)
                    {
                        flag1 = true;
                        ((Iterator) (obj)).remove();
                        injectableMembers.remove(injectablemethod2);
                    }
                }
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
        }

        OverrideIndex(InjectableMembers injectablemembers)
        {
            position = Position.TOP;
            injectableMembers = injectablemembers;
        }
    }

    static class Pair
    {

        final Object a;
        final Object b;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (Pair)obj;
                if (!a.equals(((Pair) (obj)).a) || !b.equals(((Pair) (obj)).b))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return a.hashCode() * 31 + b.hashCode();
        }

        public Pair(Object obj, Object obj1)
        {
            a = obj;
            b = obj1;
        }
    }

    static final class Position extends Enum
    {

        private static final Position $VALUES[];
        public static final Position BOTTOM;
        public static final Position MIDDLE;
        public static final Position TOP;

        public static Position valueOf(String s)
        {
            return (Position)Enum.valueOf(com/google/inject/spi/InjectionPoint$Position, s);
        }

        public static Position[] values()
        {
            return (Position[])$VALUES.clone();
        }

        static 
        {
            TOP = new Position("TOP", 0);
            MIDDLE = new Position("MIDDLE", 1);
            BOTTOM = new Position("BOTTOM", 2);
            $VALUES = (new Position[] {
                TOP, MIDDLE, BOTTOM
            });
        }

        private Position(String s, int i)
        {
            super(s, i);
        }
    }

    static class Signature
    {

        final int hash;
        final String name;
        final Class parameterTypes[];

        public boolean equals(Object obj)
        {
            if (obj instanceof Signature) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            if (name.equals(((Signature) (obj = (Signature)obj)).name) && parameterTypes.length == ((Signature) (obj)).parameterTypes.length)
            {
                int i = 0;
label0:
                do
                {
label1:
                    {
                        if (i >= parameterTypes.length)
                        {
                            break label1;
                        }
                        if (parameterTypes[i] != ((Signature) (obj)).parameterTypes[i])
                        {
                            break label0;
                        }
                        i++;
                    }
                } while (true);
            }
            if (true) goto _L1; else goto _L3
_L3:
            return true;
        }

        public int hashCode()
        {
            return hash;
        }

        Signature(Method method)
        {
            name = method.getName();
            parameterTypes = method.getParameterTypes();
            int j = name.hashCode() * 31 + parameterTypes.length;
            method = parameterTypes;
            int k = method.length;
            for (int i = 0; i < k; i++)
            {
                j = j * 31 + method[i].hashCode();
            }

            hash = j;
        }
    }


    private static HierarchyTraversalFilter filter = Guice.createHierarchyTraversalFilter();
    private static final Logger logger = Logger.getLogger(com/google/inject/spi/InjectionPoint.getName());
    private final TypeLiteral declaringType;
    private final ImmutableList dependencies;
    private final Member member;
    private final boolean optional;

    InjectionPoint(TypeLiteral typeliteral, Constructor constructor)
    {
        member = constructor;
        declaringType = typeliteral;
        optional = false;
        dependencies = forMember(constructor, typeliteral, constructor.getParameterAnnotations());
    }

    InjectionPoint(TypeLiteral typeliteral, Field field, boolean flag)
    {
        member = field;
        declaringType = typeliteral;
        optional = flag;
        Annotation aannotation[] = field.getAnnotations();
        Errors errors = new Errors(field);
        Object obj = null;
        try
        {
            typeliteral = Annotations.getKey(typeliteral.getFieldType(field), field, aannotation, errors);
        }
        // Misplaced declaration of an exception variable
        catch (TypeLiteral typeliteral)
        {
            errors.merge(typeliteral.getErrorMessages());
            typeliteral = obj;
        }
        // Misplaced declaration of an exception variable
        catch (TypeLiteral typeliteral)
        {
            errors.merge(typeliteral.getErrors());
            typeliteral = obj;
        }
        errors.throwConfigurationExceptionIfErrorsExist();
        dependencies = ImmutableList.of(newDependency(typeliteral, Nullability.allowsNull(aannotation), -1));
    }

    InjectionPoint(TypeLiteral typeliteral, Method method, boolean flag)
    {
        member = method;
        declaringType = typeliteral;
        optional = flag;
        dependencies = forMember(method, typeliteral, method.getParameterAnnotations());
    }

    private static boolean checkForMisplacedBindingAnnotations(Member member1, Errors errors)
    {
        Annotation annotation;
        annotation = Annotations.findBindingAnnotation(errors, member1, ((AnnotatedElement)member1).getAnnotations());
        if (annotation == null)
        {
            return false;
        }
        if (!(member1 instanceof Method))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        Field field = member1.getDeclaringClass().getDeclaredField(member1.getName());
        if (field != null)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_51;
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        errors.misplacedBindingAnnotation(member1, annotation);
        return true;
    }

    private static void computeInjectableMembers(TypeLiteral typeliteral, boolean flag, Errors errors, InjectableMembers injectablemembers, OverrideIndex overrideindex, HierarchyTraversalFilter hierarchytraversalfilter)
    {
        Class class1 = typeliteral.getRawType();
        if (isWorthScanning(hierarchytraversalfilter, class1))
        {
            Object obj = class1.getSuperclass();
            if (isWorthScanning(hierarchytraversalfilter, ((Class) (obj))))
            {
                computeInjectableMembers(typeliteral.getSupertype(((Class) (obj))), flag, errors, injectablemembers, overrideindex, hierarchytraversalfilter);
                overrideindex.position = Position.MIDDLE;
            } else
            {
                overrideindex.position = Position.TOP;
            }
            obj = hierarchytraversalfilter.getAllFields(com/google/inject/Inject.getName(), class1);
            if (obj != null)
            {
                obj = ((Set) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    Field field = (Field)((Iterator) (obj)).next();
                    if (Modifier.isStatic(field.getModifiers()) == flag)
                    {
                        Object obj2 = getAtInject(field);
                        if (obj2 != null)
                        {
                            obj2 = new InjectableField(typeliteral, field, ((Annotation) (obj2)));
                            if (((InjectableField) (obj2)).jsr330 && Modifier.isFinal(field.getModifiers()))
                            {
                                errors.cannotInjectFinalField(field);
                            }
                            injectablemembers.add(((InjectableMember) (obj2)));
                        }
                    }
                } while (true);
            }
            hierarchytraversalfilter = hierarchytraversalfilter.getAllMethods(com/google/inject/Inject.getName(), class1);
            if (hierarchytraversalfilter != null)
            {
                hierarchytraversalfilter = hierarchytraversalfilter.iterator();
                while (hierarchytraversalfilter.hasNext()) 
                {
                    Method method = (Method)hierarchytraversalfilter.next();
                    if (isEligibleForInjection(method, flag))
                    {
                        Object obj1 = getAtInject(method);
                        if (obj1 != null)
                        {
                            obj1 = new InjectableMethod(typeliteral, method, ((Annotation) (obj1)));
                            if (checkForMisplacedBindingAnnotations(method, errors) || !isValidMethod(((InjectableMethod) (obj1)), errors))
                            {
                                if (overrideindex.removeIfOverriddenBy(method, false, ((InjectableMethod) (obj1))))
                                {
                                    logger.log(Level.WARNING, "Method: {0} is not a valid injectable method (because it either has misplaced binding annotations or specifies type parameters) but is overriding a method that is valid. Because it is not valid, the method will not be injected. To fix this, make the method a valid injectable method.", method);
                                }
                            } else
                            if (flag)
                            {
                                injectablemembers.add(((InjectableMember) (obj1)));
                            } else
                            {
                                overrideindex.removeIfOverriddenBy(method, true, ((InjectableMethod) (obj1)));
                                overrideindex.add(((InjectableMethod) (obj1)));
                            }
                        } else
                        if (overrideindex.removeIfOverriddenBy(method, false, null))
                        {
                            logger.log(Level.WARNING, "Method: {0} is not annotated with @Inject but is overriding a method that is annotated with @javax.inject.Inject.  Because it is not annotated with @Inject, the method will not be injected. To fix this, annotate the method with @Inject.", method);
                        }
                    }
                }
            }
        }
    }

    public static InjectionPoint forConstructor(Constructor constructor)
    {
        return new InjectionPoint(TypeLiteral.get(constructor.getDeclaringClass()), constructor);
    }

    public static InjectionPoint forConstructor(Constructor constructor, TypeLiteral typeliteral)
    {
        if (typeliteral.getRawType() != constructor.getDeclaringClass())
        {
            (new Errors(typeliteral)).constructorNotDefinedByType(constructor, typeliteral).throwConfigurationExceptionIfErrorsExist();
        }
        return new InjectionPoint(typeliteral, constructor);
    }

    public static InjectionPoint forConstructorOf(TypeLiteral typeliteral)
    {
        Constructor constructor;
        Constructor constructor1;
        Class class1;
        Errors errors;
        Iterator iterator;
        class1 = MoreTypes.getRawType(typeliteral.getType());
        errors = new Errors(class1);
        filter.reset();
        constructor1 = null;
        constructor = null;
        if (!filter.isWorthScanningForConstructors(com/google/inject/Inject.getName(), class1))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        iterator = filter.getAllConstructors(com/google/inject/Inject.getName(), class1).iterator();
_L2:
        Inject inject;
        boolean flag;
        constructor1 = constructor;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_164;
        }
        constructor1 = (Constructor)iterator.next();
        inject = (Inject)constructor1.getAnnotation(com/google/inject/Inject);
        if (inject != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if ((javax.inject.Inject)constructor1.getAnnotation(javax/inject/Inject) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
_L3:
        if (flag)
        {
            errors.optionalConstructor(constructor1);
        }
        if (constructor != null)
        {
            errors.tooManyConstructors(class1);
        }
        constructor = constructor1;
        checkForMisplacedBindingAnnotations(constructor, errors);
        if (true) goto _L2; else goto _L1
_L1:
        flag = inject.optional();
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        errors.throwConfigurationExceptionIfErrorsExist();
        if (constructor1 != null)
        {
            return new InjectionPoint(typeliteral, constructor1);
        }
        try
        {
            constructor = class1.getDeclaredConstructor(new Class[0]);
            if (Modifier.isPrivate(constructor.getModifiers()) && !Modifier.isPrivate(class1.getModifiers()))
            {
                errors.missingConstructor(class1);
                throw new ConfigurationException(errors.getMessages());
            }
        }
        // Misplaced declaration of an exception variable
        catch (TypeLiteral typeliteral)
        {
            errors.missingConstructor(class1);
            throw new ConfigurationException(errors.getMessages());
        }
        checkForMisplacedBindingAnnotations(constructor, errors);
        typeliteral = new InjectionPoint(typeliteral, constructor);
        return typeliteral;
    }

    public static InjectionPoint forConstructorOf(Class class1)
    {
        return forConstructorOf(TypeLiteral.get(class1));
    }

    public static Set forInstanceMethodsAndFields(TypeLiteral typeliteral)
    {
        Errors errors = new Errors();
        typeliteral = getInjectionPoints(typeliteral, false, errors);
        if (errors.hasErrors())
        {
            throw (new ConfigurationException(errors.getMessages())).withPartialValue(typeliteral);
        } else
        {
            return typeliteral;
        }
    }

    public static Set forInstanceMethodsAndFields(Class class1)
    {
        return forInstanceMethodsAndFields(TypeLiteral.get(class1));
    }

    private ImmutableList forMember(Member member1, TypeLiteral typeliteral, Annotation aannotation[][])
    {
        Errors errors;
        ArrayList arraylist;
        int i;
        errors = new Errors(member1);
        aannotation = Arrays.asList(aannotation).iterator();
        arraylist = Lists.newArrayList();
        i = 0;
        typeliteral = typeliteral.getParameterTypes(member1).iterator();
_L2:
        TypeLiteral typeliteral1;
        if (!typeliteral.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        typeliteral1 = (TypeLiteral)typeliteral.next();
        Annotation aannotation1[] = (Annotation[])aannotation.next();
        arraylist.add(newDependency(Annotations.getKey(typeliteral1, member1, aannotation1, errors), Nullability.allowsNull(aannotation1), i));
        i++;
        continue; /* Loop/switch isn't completed */
        Object obj;
        obj;
        errors.merge(((ConfigurationException) (obj)).getErrorMessages());
        continue; /* Loop/switch isn't completed */
        obj;
        errors.merge(((ErrorsException) (obj)).getErrors());
        if (true) goto _L2; else goto _L1
_L1:
        errors.throwConfigurationExceptionIfErrorsExist();
        return ImmutableList.copyOf(arraylist);
    }

    public static Set forStaticMethodsAndFields(TypeLiteral typeliteral)
    {
        Errors errors = new Errors();
        if (typeliteral.getRawType().isInterface())
        {
            errors.staticInjectionOnInterface(typeliteral.getRawType());
            typeliteral = null;
        } else
        {
            typeliteral = getInjectionPoints(typeliteral, true, errors);
        }
        if (errors.hasErrors())
        {
            throw (new ConfigurationException(errors.getMessages())).withPartialValue(typeliteral);
        } else
        {
            return typeliteral;
        }
    }

    public static Set forStaticMethodsAndFields(Class class1)
    {
        return forStaticMethodsAndFields(TypeLiteral.get(class1));
    }

    static Annotation getAtInject(AnnotatedElement annotatedelement)
    {
        Annotation annotation1 = annotatedelement.getAnnotation(javax/inject/Inject);
        Annotation annotation = annotation1;
        if (annotation1 == null)
        {
            annotation = annotatedelement.getAnnotation(com/google/inject/Inject);
        }
        return annotation;
    }

    private static Set getInjectionPoints(TypeLiteral typeliteral, boolean flag, Errors errors)
    {
        InjectableMembers injectablemembers = new InjectableMembers();
        Object obj = new OverrideIndex(injectablemembers);
        obj.position = Position.BOTTOM;
        filter.reset();
        computeInjectableMembers(typeliteral, flag, errors, injectablemembers, ((OverrideIndex) (obj)), filter);
        if (injectablemembers.isEmpty())
        {
            return Collections.emptySet();
        }
        obj = ImmutableSet.builder();
        typeliteral = injectablemembers.head;
        do
        {
            if (typeliteral == null)
            {
                break;
            }
            try
            {
                ((org.roboguice.shaded.goole.common.collect.ImmutableSet.Builder) (obj)).add(typeliteral.toInjectionPoint());
            }
            catch (ConfigurationException configurationexception)
            {
                if (!((InjectableMember) (typeliteral)).optional)
                {
                    errors.merge(configurationexception.getErrorMessages());
                }
            }
            typeliteral = ((InjectableMember) (typeliteral)).next;
        } while (true);
        return ((org.roboguice.shaded.goole.common.collect.ImmutableSet.Builder) (obj)).build();
    }

    private static List hierarchyFor(TypeLiteral typeliteral)
    {
        ArrayList arraylist = new ArrayList();
        for (; typeliteral.getRawType() != java/lang/Object; typeliteral = typeliteral.getSupertype(typeliteral.getRawType().getSuperclass()))
        {
            arraylist.add(typeliteral);
        }

        return arraylist;
    }

    private static boolean isEligibleForInjection(Method method, boolean flag)
    {
        return Modifier.isStatic(method.getModifiers()) == flag && !method.isBridge() && !method.isSynthetic();
    }

    private static boolean isValidMethod(InjectableMethod injectablemethod, Errors errors)
    {
        boolean flag = true;
        boolean flag1 = true;
        if (injectablemethod.jsr330)
        {
            injectablemethod = injectablemethod.method;
            flag = flag1;
            if (Modifier.isAbstract(injectablemethod.getModifiers()))
            {
                errors.cannotInjectAbstractMethod(injectablemethod);
                flag = false;
            }
            if (injectablemethod.getTypeParameters().length > 0)
            {
                errors.cannotInjectMethodWithTypeParameters(injectablemethod);
                flag = false;
            }
        }
        return flag;
    }

    private static boolean isWorthScanning(HierarchyTraversalFilter hierarchytraversalfilter, Class class1)
    {
        return hierarchytraversalfilter.isWorthScanningForFields(com/google/inject/Inject.getName(), class1) || hierarchytraversalfilter.isWorthScanningForMethods(com/google/inject/Inject.getName(), class1);
    }

    private Dependency newDependency(Key key, boolean flag, int i)
    {
        return new Dependency(this, key, flag, i);
    }

    private static boolean overrides(Method method, Method method1)
    {
        int i = method1.getModifiers();
        if (Modifier.isPublic(i) || Modifier.isProtected(i))
        {
            return true;
        }
        if (Modifier.isPrivate(i))
        {
            return false;
        } else
        {
            return method.getDeclaringClass().getPackage().equals(method1.getDeclaringClass().getPackage());
        }
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof InjectionPoint) && member.equals(((InjectionPoint)obj).member) && declaringType.equals(((InjectionPoint)obj).declaringType);
    }

    public TypeLiteral getDeclaringType()
    {
        return declaringType;
    }

    public List getDependencies()
    {
        return dependencies;
    }

    public Member getMember()
    {
        return member;
    }

    public int hashCode()
    {
        return member.hashCode() ^ declaringType.hashCode();
    }

    public boolean isOptional()
    {
        return optional;
    }

    public boolean isToolable()
    {
        return ((AnnotatedElement)member).isAnnotationPresent(com/google/inject/spi/Toolable);
    }

    public String toString()
    {
        return Classes.toString(member);
    }


}
