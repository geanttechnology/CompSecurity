// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.inject.internal;

import com.google.inject.TypeLiteral;
import com.google.inject.internal.util.SourceProvider;
import com.google.inject.matcher.AbstractMatcher;
import com.google.inject.matcher.Matcher;
import com.google.inject.matcher.Matchers;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeConverterBinding;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.google.inject.internal:
//            AbstractProcessor, InjectorImpl, State, Errors

final class TypeConverterBindingProcessor extends AbstractProcessor
{

    TypeConverterBindingProcessor(Errors errors)
    {
        super(errors);
    }

    private static String capitalize(String s)
    {
        if (s.length() != 0)
        {
            char c = s.charAt(0);
            char c1 = Character.toUpperCase(c);
            if (c != c1)
            {
                return (new StringBuilder()).append(c1).append(s.substring(1)).toString();
            }
        }
        return s;
    }

    private static void convertToClass(InjectorImpl injectorimpl, Class class1, TypeConverter typeconverter)
    {
        convertToClasses(injectorimpl, Matchers.identicalTo(class1), typeconverter);
    }

    private static void convertToClasses(InjectorImpl injectorimpl, Matcher matcher, TypeConverter typeconverter)
    {
        internalConvertToTypes(injectorimpl, new AbstractMatcher(matcher) {

            final Matcher val$typeMatcher;

            public boolean matches(TypeLiteral typeliteral)
            {
                typeliteral = typeliteral.getType();
                if (!(typeliteral instanceof Class))
                {
                    return false;
                } else
                {
                    typeliteral = (Class)typeliteral;
                    return typeMatcher.matches(typeliteral);
                }
            }

            public volatile boolean matches(Object obj)
            {
                return matches((TypeLiteral)obj);
            }

            public String toString()
            {
                return typeMatcher.toString();
            }

            
            {
                typeMatcher = matcher;
                super();
            }
        }, typeconverter);
    }

    private static void convertToPrimitiveType(InjectorImpl injectorimpl, Class class1, Class class2)
    {
        try
        {
            convertToClass(injectorimpl, class2, new TypeConverter(class2.getMethod((new StringBuilder()).append("parse").append(capitalize(class1.getName())).toString(), new Class[] {
                java/lang/String
            }), class2) {

                final Method val$parser;
                final Class val$wrapperType;

                public Object convert(String s, TypeLiteral typeliteral)
                {
                    try
                    {
                        s = ((String) (parser.invoke(null, new Object[] {
                            s
                        })));
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        throw new AssertionError(s);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        throw new RuntimeException(s.getTargetException().getMessage());
                    }
                    return s;
                }

                public String toString()
                {
                    return (new StringBuilder()).append("TypeConverter<").append(wrapperType.getSimpleName()).append(">").toString();
                }

            
            {
                parser = method;
                wrapperType = class1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InjectorImpl injectorimpl)
        {
            throw new AssertionError(injectorimpl);
        }
    }

    private static void internalConvertToTypes(InjectorImpl injectorimpl, Matcher matcher, TypeConverter typeconverter)
    {
        injectorimpl.state.addConverter(new TypeConverterBinding(SourceProvider.UNKNOWN_SOURCE, matcher, typeconverter));
    }

    static void prepareBuiltInConverters(InjectorImpl injectorimpl)
    {
        convertToPrimitiveType(injectorimpl, Integer.TYPE, java/lang/Integer);
        convertToPrimitiveType(injectorimpl, Long.TYPE, java/lang/Long);
        convertToPrimitiveType(injectorimpl, Boolean.TYPE, java/lang/Boolean);
        convertToPrimitiveType(injectorimpl, Byte.TYPE, java/lang/Byte);
        convertToPrimitiveType(injectorimpl, Short.TYPE, java/lang/Short);
        convertToPrimitiveType(injectorimpl, Float.TYPE, java/lang/Float);
        convertToPrimitiveType(injectorimpl, Double.TYPE, java/lang/Double);
        convertToClass(injectorimpl, java/lang/Character, new TypeConverter() {

            public Object convert(String s, TypeLiteral typeliteral)
            {
                s = s.trim();
                if (s.length() != 1)
                {
                    throw new RuntimeException("Length != 1.");
                } else
                {
                    return Character.valueOf(s.charAt(0));
                }
            }

            public String toString()
            {
                return "TypeConverter<Character>";
            }

        });
        convertToClasses(injectorimpl, Matchers.subclassesOf(java/lang/Enum), new TypeConverter() {

            public Object convert(String s, TypeLiteral typeliteral)
            {
                return Enum.valueOf(typeliteral.getRawType(), s);
            }

            public String toString()
            {
                return "TypeConverter<E extends Enum<E>>";
            }

        });
        internalConvertToTypes(injectorimpl, new AbstractMatcher() {

            public boolean matches(TypeLiteral typeliteral)
            {
                return typeliteral.getRawType() == java/lang/Class;
            }

            public volatile boolean matches(Object obj)
            {
                return matches((TypeLiteral)obj);
            }

            public String toString()
            {
                return "Class<?>";
            }

        }, new TypeConverter() {

            public Object convert(String s, TypeLiteral typeliteral)
            {
                try
                {
                    s = Class.forName(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException(s.getMessage());
                }
                return s;
            }

            public String toString()
            {
                return "TypeConverter<Class<?>>";
            }

        });
    }

    public Boolean visit(TypeConverterBinding typeconverterbinding)
    {
        injector.state.addConverter(new TypeConverterBinding(typeconverterbinding.getSource(), typeconverterbinding.getTypeMatcher(), typeconverterbinding.getTypeConverter()));
        return Boolean.valueOf(true);
    }

    public volatile Object visit(TypeConverterBinding typeconverterbinding)
    {
        return visit(typeconverterbinding);
    }
}
