// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.ConfigurationException;
import com.google.inject.CreationException;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.ProvisionException;
import com.google.inject.Scope;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.util.Classes;
import com.google.inject.internal.util.SourceProvider;
import com.google.inject.internal.util.StackTraceElements;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.ElementSource;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.Message;
import com.google.inject.spi.ScopeBinding;
import com.google.inject.spi.TypeConverterBinding;
import com.google.inject.spi.TypeListenerBinding;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.roboguice.shaded.goole.common.collect.ImmutableList;
import org.roboguice.shaded.goole.common.collect.ImmutableSet;
import org.roboguice.shaded.goole.common.collect.Lists;
import org.roboguice.shaded.goole.common.collect.Ordering;

// Referenced classes of package com.google.inject.internal:
//            ErrorsException

public final class Errors
    implements Serializable
{
    private static abstract class Converter
    {

        final Class type;

        boolean appliesTo(Object obj)
        {
            return obj != null && type.isAssignableFrom(obj.getClass());
        }

        String convert(Object obj)
        {
            return toString(type.cast(obj));
        }

        abstract String toString(Object obj);

        Converter(Class class1)
        {
            type = class1;
        }
    }


    private static final String CONSTRUCTOR_RULES = "Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.";
    private static final Collection converters = ImmutableList.of(new Converter(java/lang/Class) {

        public String toString(Class class1)
        {
            return class1.getName();
        }

        public volatile String toString(Object obj)
        {
            return toString((Class)obj);
        }

    }, new Converter(java/lang/reflect/Member) {

        public volatile String toString(Object obj)
        {
            return toString((Member)obj);
        }

        public String toString(Member member)
        {
            return Classes.toString(member);
        }

    }, new Converter(com/google/inject/Key) {

        public String toString(Key key)
        {
            if (key.getAnnotationType() != null)
            {
                StringBuilder stringbuilder = (new StringBuilder()).append(key.getTypeLiteral()).append(" annotated with ");
                if (key.getAnnotation() != null)
                {
                    key = key.getAnnotation();
                } else
                {
                    key = key.getAnnotationType();
                }
                return stringbuilder.append(key).toString();
            } else
            {
                return key.getTypeLiteral().toString();
            }
        }

        public volatile String toString(Object obj)
        {
            return toString((Key)obj);
        }

    });
    private List errors;
    private final Errors parent;
    private final Errors root;
    private final Object source;

    public Errors()
    {
        root = this;
        parent = null;
        source = SourceProvider.UNKNOWN_SOURCE;
    }

    private Errors(Errors errors1, Object obj)
    {
        root = errors1.root;
        parent = errors1;
        source = obj;
    }

    public Errors(Object obj)
    {
        root = this;
        parent = null;
        source = obj;
    }

    private transient Errors addMessage(Throwable throwable, String s, Object aobj[])
    {
        s = format(s, aobj);
        addMessage(new Message(getSources(), s, throwable));
        return this;
    }

    private static Object appendModules(Object obj, ElementSource elementsource)
    {
        elementsource = moduleSourceString(elementsource);
        if (elementsource.length() == 0)
        {
            return obj;
        } else
        {
            return (new StringBuilder()).append(obj).append(elementsource).toString();
        }
    }

    public static Object convert(Object obj)
    {
        ElementSource elementsource = null;
        Object obj1 = obj;
        if (obj instanceof ElementSource)
        {
            elementsource = (ElementSource)obj;
            obj1 = elementsource.getDeclaringSource();
        }
        return convert(obj1, elementsource);
    }

    public static Object convert(Object obj, ElementSource elementsource)
    {
        for (Iterator iterator = converters.iterator(); iterator.hasNext();)
        {
            Converter converter = (Converter)iterator.next();
            if (converter.appliesTo(obj))
            {
                return appendModules(converter.convert(obj), elementsource);
            }
        }

        return appendModules(obj, elementsource);
    }

    public static String format(String s, Collection collection)
    {
        s = (new Formatter()).format(s, new Object[0]).format(":%n%n", new Object[0]);
        int i = 1;
        Iterator iterator;
        boolean flag;
        if (getOnlyCause(collection) == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (iterator = collection.iterator(); iterator.hasNext();)
        {
            Object obj = (Message)iterator.next();
            s.format("%s) %s%n", new Object[] {
                Integer.valueOf(i), ((Message) (obj)).getMessage()
            });
            List list = ((Message) (obj)).getSources();
            for (int j = list.size() - 1; j >= 0; j--)
            {
                formatSource(s, list.get(j));
            }

            obj = ((Message) (obj)).getCause();
            if (flag && obj != null)
            {
                StringWriter stringwriter = new StringWriter();
                ((Throwable) (obj)).printStackTrace(new PrintWriter(stringwriter));
                s.format("Caused by: %s", new Object[] {
                    stringwriter.getBuffer()
                });
            }
            s.format("%n", new Object[0]);
            i++;
        }

        if (collection.size() == 1)
        {
            s.format("1 error", new Object[0]);
        } else
        {
            s.format("%s errors", new Object[] {
                Integer.valueOf(collection.size())
            });
        }
        return s.toString();
    }

    public static transient String format(String s, Object aobj[])
    {
        for (int i = 0; i < aobj.length; i++)
        {
            aobj[i] = convert(aobj[i]);
        }

        return String.format(s, aobj);
    }

    public static void formatInjectionPoint(Formatter formatter, Dependency dependency, InjectionPoint injectionpoint, ElementSource elementsource)
    {
        Member member = injectionpoint.getMember();
        if (Classes.memberType(member) == java/lang/reflect/Field)
        {
            formatter.format("  while locating %s%n", new Object[] {
                convert(((Dependency)injectionpoint.getDependencies().get(0)).getKey(), elementsource)
            });
            formatter.format("    for field at %s%n", new Object[] {
                StackTraceElements.forMember(member)
            });
            return;
        }
        if (dependency != null)
        {
            formatter.format("  while locating %s%n", new Object[] {
                convert(dependency.getKey(), elementsource)
            });
            formatter.format("    for parameter %s at %s%n", new Object[] {
                Integer.valueOf(dependency.getParameterIndex()), StackTraceElements.forMember(member)
            });
            return;
        } else
        {
            formatSource(formatter, injectionpoint.getMember());
            return;
        }
    }

    public static void formatSource(Formatter formatter, Object obj)
    {
        ElementSource elementsource = null;
        Object obj1 = obj;
        if (obj instanceof ElementSource)
        {
            elementsource = (ElementSource)obj;
            obj1 = elementsource.getDeclaringSource();
        }
        formatSource(formatter, obj1, elementsource);
    }

    public static void formatSource(Formatter formatter, Object obj, ElementSource elementsource)
    {
        Object obj1 = moduleSourceString(elementsource);
        if (obj instanceof Dependency)
        {
            obj = (Dependency)obj;
            obj1 = ((Dependency) (obj)).getInjectionPoint();
            if (obj1 != null)
            {
                formatInjectionPoint(formatter, ((Dependency) (obj)), ((InjectionPoint) (obj1)), elementsource);
                return;
            } else
            {
                formatSource(formatter, ((Dependency) (obj)).getKey(), elementsource);
                return;
            }
        }
        if (obj instanceof InjectionPoint)
        {
            formatInjectionPoint(formatter, null, (InjectionPoint)obj, elementsource);
            return;
        }
        if (obj instanceof Class)
        {
            formatter.format("  at %s%s%n", new Object[] {
                StackTraceElements.forType((Class)obj), obj1
            });
            return;
        }
        if (obj instanceof Member)
        {
            formatter.format("  at %s%s%n", new Object[] {
                StackTraceElements.forMember((Member)obj), obj1
            });
            return;
        }
        if (obj instanceof TypeLiteral)
        {
            formatter.format("  while locating %s%s%n", new Object[] {
                obj, obj1
            });
            return;
        }
        if (obj instanceof Key)
        {
            formatter.format("  while locating %s%n", new Object[] {
                convert((Key)obj, elementsource)
            });
            return;
        } else
        {
            formatter.format("  at %s%s%n", new Object[] {
                obj, obj1
            });
            return;
        }
    }

    public static Collection getMessagesFromThrowable(Throwable throwable)
    {
        if (throwable instanceof ProvisionException)
        {
            return ((ProvisionException)throwable).getErrorMessages();
        }
        if (throwable instanceof ConfigurationException)
        {
            return ((ConfigurationException)throwable).getErrorMessages();
        }
        if (throwable instanceof CreationException)
        {
            return ((CreationException)throwable).getErrorMessages();
        } else
        {
            return ImmutableSet.of();
        }
    }

    public static Throwable getOnlyCause(Collection collection)
    {
        Object obj = null;
        Iterator iterator = collection.iterator();
        collection = obj;
        do
        {
            Object obj1;
label0:
            {
                obj1 = collection;
                if (iterator.hasNext())
                {
                    obj1 = ((Message)iterator.next()).getCause();
                    if (obj1 == null)
                    {
                        continue;
                    }
                    if (collection == null)
                    {
                        break label0;
                    }
                    obj1 = null;
                }
                return ((Throwable) (obj1));
            }
            collection = ((Collection) (obj1));
        } while (true);
    }

    private Message merge(Message message)
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        arraylist.addAll(getSources());
        arraylist.addAll(message.getSources());
        return new Message(arraylist, message.getMessage(), message.getCause());
    }

    private static String moduleSourceString(ElementSource elementsource)
    {
        if (elementsource == null)
        {
            return "";
        }
        java.util.ArrayList arraylist = Lists.newArrayList(elementsource.getModuleClassNames());
        for (; elementsource.getOriginalElementSource() != null; arraylist.addAll(0, elementsource.getModuleClassNames()))
        {
            elementsource = elementsource.getOriginalElementSource();
        }

        if (arraylist.size() <= 1)
        {
            return "";
        }
        elementsource = new StringBuilder(" (via modules: ");
        for (int i = arraylist.size() - 1; i >= 0; i--)
        {
            elementsource.append((String)arraylist.get(i));
            if (i != 0)
            {
                elementsource.append(" -> ");
            }
        }

        elementsource.append(")");
        return elementsource.toString();
    }

    private Throwable unwrap(RuntimeException runtimeexception)
    {
        Object obj = runtimeexception;
        if (runtimeexception instanceof Exceptions.UnhandledCheckedUserException)
        {
            obj = runtimeexception.getCause();
        }
        return ((Throwable) (obj));
    }

    public Errors addMessage(Message message)
    {
        if (root.errors == null)
        {
            root.errors = Lists.newArrayList();
        }
        root.errors.add(message);
        return this;
    }

    public transient Errors addMessage(String s, Object aobj[])
    {
        return addMessage(null, s, aobj);
    }

    public Errors ambiguousTypeConversion(String s, Object obj, TypeLiteral typeliteral, TypeConverterBinding typeconverterbinding, TypeConverterBinding typeconverterbinding1)
    {
        return addMessage("Multiple converters can convert '%s' (bound at %s) to %s:%n %s and%n %s.%n Please adjust your type converter configuration to avoid overlapping matches.", new Object[] {
            s, convert(obj), typeliteral, typeconverterbinding, typeconverterbinding1
        });
    }

    public Errors atInjectRequired(Class class1)
    {
        return addMessage("Explicit @Inject annotations are required on constructors, but %s has no constructors annotated with @Inject.", new Object[] {
            class1
        });
    }

    public Errors bindingAlreadySet(Key key, Object obj)
    {
        return addMessage("A binding to %s was already configured at %s.", new Object[] {
            key, convert(obj)
        });
    }

    public Errors bindingToProvider()
    {
        return addMessage("Binding to Provider is not allowed.", new Object[0]);
    }

    public Errors cannotBindToGuiceType(String s)
    {
        return addMessage("Binding to core guice framework type is not allowed: %s.", new Object[] {
            s
        });
    }

    public Errors cannotInjectAbstractMethod(Method method)
    {
        return addMessage("Injected method %s cannot be abstract.", new Object[] {
            method
        });
    }

    public Errors cannotInjectFinalField(Field field)
    {
        return addMessage("Injected field %s cannot be final.", new Object[] {
            field
        });
    }

    public Errors cannotInjectInnerClass(Class class1)
    {
        return addMessage("Injecting into inner classes is not supported.  Please use a 'static' class (top-level or nested) instead of %s.", new Object[] {
            class1
        });
    }

    public Errors cannotInjectMethodWithTypeParameters(Method method)
    {
        return addMessage("Injected method %s cannot declare type parameters of its own.", new Object[] {
            method
        });
    }

    public Errors cannotInjectNonVoidMethod(Method method)
    {
        return addMessage("Injected method %s must return void.", new Object[] {
            method
        });
    }

    public Errors cannotInjectRawMembersInjector()
    {
        return addMessage("Cannot inject a MembersInjector that has no type parameter", new Object[0]);
    }

    public Errors cannotInjectRawProvider()
    {
        return addMessage("Cannot inject a Provider that has no type parameter", new Object[0]);
    }

    public Errors cannotInjectRawTypeLiteral()
    {
        return addMessage("Cannot inject a TypeLiteral that has no type parameter", new Object[0]);
    }

    public Errors cannotInjectTypeLiteralOf(Type type)
    {
        return addMessage("Cannot inject a TypeLiteral of %s", new Object[] {
            type
        });
    }

    public Errors cannotSatisfyCircularDependency(Class class1)
    {
        return addMessage("Tried proxying %s to support a circular dependency, but it is not an interface.", new Object[] {
            class1
        });
    }

    public Object checkForNull(Object obj, Object obj1, Dependency dependency)
        throws ErrorsException
    {
        if (obj != null || dependency.isNullable())
        {
            return obj;
        }
        int i = dependency.getParameterIndex();
        if (i != -1)
        {
            obj = (new StringBuilder()).append("parameter ").append(i).append(" of ").toString();
        } else
        {
            obj = "";
        }
        addMessage("null returned by binding at %s%n but %s%s is not @Nullable", new Object[] {
            obj1, obj, dependency.getInjectionPoint().getMember()
        });
        throw toException();
    }

    public Errors childBindingAlreadySet(Key key, Set set)
    {
        Formatter formatter = new Formatter();
        for (set = set.iterator(); set.hasNext();)
        {
            Object obj = set.next();
            if (obj == null)
            {
                formatter.format("%n    (bound by a just-in-time binding)", new Object[0]);
            } else
            {
                formatter.format("%n    bound at %s", new Object[] {
                    obj
                });
            }
        }

        return addMessage("Unable to create binding for %s. It was already configured on one or more child injectors or private modules%s%n  If it was in a PrivateModule, did you forget to expose the binding?", new Object[] {
            key, formatter.out()
        });
    }

    public Errors circularProxiesDisabled(Class class1)
    {
        return addMessage("Tried proxying %s to support a circular dependency, but circular proxies are disabled.", new Object[] {
            class1
        });
    }

    public Errors constructorNotDefinedByType(Constructor constructor, TypeLiteral typeliteral)
    {
        return addMessage("%s does not define %s", new Object[] {
            typeliteral, constructor
        });
    }

    public Errors conversionError(String s, Object obj, TypeLiteral typeliteral, TypeConverterBinding typeconverterbinding, RuntimeException runtimeexception)
    {
        return errorInUserCode(runtimeexception, "Error converting '%s' (bound at %s) to %s%n using %s.%n Reason: %s", new Object[] {
            s, convert(obj), typeliteral, typeconverterbinding, runtimeexception
        });
    }

    public Errors conversionTypeError(String s, Object obj, TypeLiteral typeliteral, TypeConverterBinding typeconverterbinding, Object obj1)
    {
        return addMessage("Type mismatch converting '%s' (bound at %s) to %s%n using %s.%n Converter returned %s.", new Object[] {
            s, convert(obj), typeliteral, typeconverterbinding, obj1
        });
    }

    public Errors converterReturnedNull(String s, Object obj, TypeLiteral typeliteral, TypeConverterBinding typeconverterbinding)
    {
        return addMessage("Received null converting '%s' (bound at %s) to %s%n using %s.", new Object[] {
            s, convert(obj), typeliteral, typeconverterbinding
        });
    }

    public Errors duplicateBindingAnnotations(Member member, Class class1, Class class2)
    {
        return addMessage("%s has more than one annotation annotated with @BindingAnnotation: %s and %s", new Object[] {
            member, class1, class2
        });
    }

    public Errors duplicateScopeAnnotations(Class class1, Class class2)
    {
        return addMessage("More than one scope annotation was found: %s and %s.", new Object[] {
            class1, class2
        });
    }

    public Errors duplicateScopes(ScopeBinding scopebinding, Class class1, Scope scope)
    {
        return addMessage("Scope %s is already bound to %s at %s.%n Cannot bind %s.", new Object[] {
            scopebinding.getScope(), class1, scopebinding.getSource(), scope
        });
    }

    public Errors errorCheckingDuplicateBinding(Key key, Object obj, Throwable throwable)
    {
        return addMessage("A binding to %s was already configured at %s and an error was thrown while checking duplicate bindings.  Error: %s", new Object[] {
            key, convert(obj), throwable
        });
    }

    public Errors errorEnhancingClass(Class class1, Throwable throwable)
    {
        return errorInUserCode(throwable, "Unable to method intercept: %s", new Object[] {
            class1
        });
    }

    public Errors errorInProvider(RuntimeException runtimeexception)
    {
        runtimeexception = unwrap(runtimeexception);
        return errorInUserCode(runtimeexception, "Error in custom provider, %s", new Object[] {
            runtimeexception
        });
    }

    public transient Errors errorInUserCode(Throwable throwable, String s, Object aobj[])
    {
        Collection collection = getMessagesFromThrowable(throwable);
        if (!collection.isEmpty())
        {
            return merge(collection);
        } else
        {
            return addMessage(throwable, s, aobj);
        }
    }

    public Errors errorInUserInjector(MembersInjector membersinjector, TypeLiteral typeliteral, RuntimeException runtimeexception)
    {
        return errorInUserCode(runtimeexception, "Error injecting %s using %s.%n Reason: %s", new Object[] {
            typeliteral, membersinjector, runtimeexception
        });
    }

    public Errors errorInjectingConstructor(Throwable throwable)
    {
        return errorInUserCode(throwable, "Error injecting constructor, %s", new Object[] {
            throwable
        });
    }

    public Errors errorInjectingMethod(Throwable throwable)
    {
        return errorInUserCode(throwable, "Error injecting method, %s", new Object[] {
            throwable
        });
    }

    public Errors errorNotifyingInjectionListener(InjectionListener injectionlistener, TypeLiteral typeliteral, RuntimeException runtimeexception)
    {
        return errorInUserCode(runtimeexception, "Error notifying InjectionListener %s of %s.%n Reason: %s", new Object[] {
            injectionlistener, typeliteral, runtimeexception
        });
    }

    public Errors errorNotifyingTypeListener(TypeListenerBinding typelistenerbinding, TypeLiteral typeliteral, Throwable throwable)
    {
        return errorInUserCode(throwable, "Error notifying TypeListener %s (bound at %s) of %s.%n Reason: %s", new Object[] {
            typelistenerbinding.getListener(), convert(typelistenerbinding.getSource()), typeliteral, throwable
        });
    }

    public Errors exposedButNotBound(Key key)
    {
        return addMessage("Could not expose() %s, it must be explicitly bound.", new Object[] {
            key
        });
    }

    public List getMessages()
    {
        if (root.errors == null)
        {
            return ImmutableList.of();
        } else
        {
            return (new Ordering() {

                final Errors this$0;

                public int compare(Message message, Message message1)
                {
                    return message.getSource().compareTo(message1.getSource());
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Message)obj, (Message)obj1);
                }

            
            {
                this$0 = Errors.this;
                super();
            }
            }).sortedCopy(root.errors);
        }
    }

    public List getSources()
    {
        java.util.ArrayList arraylist = Lists.newArrayList();
        for (Errors errors1 = this; errors1 != null; errors1 = errors1.parent)
        {
            if (errors1.source != SourceProvider.UNKNOWN_SOURCE)
            {
                arraylist.add(0, errors1.source);
            }
        }

        return arraylist;
    }

    public boolean hasErrors()
    {
        return root.errors != null;
    }

    public Errors jitBindingAlreadySet(Key key)
    {
        return addMessage("A just-in-time binding to %s was already configured on a parent injector.", new Object[] {
            key
        });
    }

    public Errors jitDisabled(Key key)
    {
        return addMessage("Explicit bindings are required and %s is not explicitly bound.", new Object[] {
            key
        });
    }

    public Errors keyNotFullySpecified(TypeLiteral typeliteral)
    {
        return addMessage("%s cannot be used as a key; It is not fully specified.", new Object[] {
            typeliteral
        });
    }

    public Errors merge(Errors errors1)
    {
        if (errors1.root == root || errors1.root.errors == null)
        {
            return this;
        } else
        {
            merge(((Collection) (errors1.root.errors)));
            return this;
        }
    }

    public Errors merge(Collection collection)
    {
        for (collection = collection.iterator(); collection.hasNext(); addMessage(merge((Message)collection.next()))) { }
        return this;
    }

    public Errors misplacedBindingAnnotation(Member member, Annotation annotation)
    {
        return addMessage("%s is annotated with %s, but binding annotations should be applied to its parameters instead.", new Object[] {
            member, annotation
        });
    }

    public Errors missingConstantValues()
    {
        return addMessage("Missing constant value. Please call to(...).", new Object[0]);
    }

    public Errors missingConstructor(Class class1)
    {
        return addMessage("Could not find a suitable constructor in %s. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", new Object[] {
            class1
        });
    }

    public Errors missingImplementation(Key key)
    {
        return addMessage("No implementation for %s was bound.", new Object[] {
            key
        });
    }

    public Errors missingRuntimeRetention(Class class1)
    {
        return addMessage(format("Please annotate %s with @Retention(RUNTIME).", new Object[] {
            class1
        }), new Object[0]);
    }

    public Errors missingScopeAnnotation(Class class1)
    {
        return addMessage(format("Please annotate %s with @ScopeAnnotation.", new Object[] {
            class1
        }), new Object[0]);
    }

    public Errors notASubtype(Class class1, Class class2)
    {
        return addMessage("%s doesn't extend %s.", new Object[] {
            class1, class2
        });
    }

    public Errors optionalConstructor(Constructor constructor)
    {
        return addMessage("%s is annotated @Inject(optional=true), but constructors cannot be optional.", new Object[] {
            constructor
        });
    }

    public Errors recursiveBinding()
    {
        return addMessage("Binding points to itself.", new Object[0]);
    }

    public Errors recursiveImplementationType()
    {
        return addMessage("@ImplementedBy points to the same class it annotates.", new Object[0]);
    }

    public Errors recursiveProviderType()
    {
        return addMessage("@ProvidedBy points to the same class it annotates.", new Object[0]);
    }

    public Errors scopeAnnotationOnAbstractType(Class class1, Class class2, Object obj)
    {
        return addMessage("%s is annotated with %s, but scope annotations are not supported for abstract types.%n Bound at %s.", new Object[] {
            class2, class1, convert(obj)
        });
    }

    public Errors scopeNotFound(Class class1)
    {
        return addMessage("No scope is bound to %s.", new Object[] {
            class1
        });
    }

    public int size()
    {
        if (root.errors == null)
        {
            return 0;
        } else
        {
            return root.errors.size();
        }
    }

    public Errors staticInjectionOnInterface(Class class1)
    {
        return addMessage("%s is an interface, but interfaces have no static injection points.", new Object[] {
            class1
        });
    }

    public Errors subtypeNotProvided(Class class1, Class class2)
    {
        return addMessage("%s doesn't provide instances of %s.", new Object[] {
            class1, class2
        });
    }

    public void throwConfigurationExceptionIfErrorsExist()
    {
        if (!hasErrors())
        {
            return;
        } else
        {
            throw new ConfigurationException(getMessages());
        }
    }

    public void throwCreationExceptionIfErrorsExist()
    {
        if (!hasErrors())
        {
            return;
        } else
        {
            throw new CreationException(getMessages());
        }
    }

    public void throwIfNewErrors(int i)
        throws ErrorsException
    {
        if (size() == i)
        {
            return;
        } else
        {
            throw toException();
        }
    }

    public void throwProvisionExceptionIfErrorsExist()
    {
        if (!hasErrors())
        {
            return;
        } else
        {
            throw new ProvisionException(getMessages());
        }
    }

    public ErrorsException toException()
    {
        return new ErrorsException(this);
    }

    public Errors tooManyConstructors(Class class1)
    {
        return addMessage("%s has more than one constructor annotated with @Inject. Classes must have either one (and only one) constructor annotated with @Inject or a zero-argument constructor that is not private.", new Object[] {
            class1
        });
    }

    public Errors voidProviderMethod()
    {
        return addMessage("Provider methods must return a value. Do not return void.", new Object[0]);
    }

    public Errors withSource(Object obj)
    {
        if (obj == source || obj == SourceProvider.UNKNOWN_SOURCE)
        {
            return this;
        } else
        {
            return new Errors(this, obj);
        }
    }

}
