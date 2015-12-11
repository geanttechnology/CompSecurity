// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal.codegen;

import dagger.internal.Keys;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.AnnotationValueVisitor;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.SimpleAnnotationValueVisitor6;
import javax.lang.model.util.SimpleTypeVisitor6;

final class Util
{
    static final class CodeGenerationIncompleteException extends IllegalStateException
    {

        public CodeGenerationIncompleteException(String s)
        {
            super(s);
        }
    }


    private static final AnnotationValueVisitor VALUE_EXTRACTOR = new SimpleAnnotationValueVisitor6() {

        protected volatile Object defaultAction(Object obj, Object obj1)
        {
            return defaultAction(obj, (Void)obj1);
        }

        protected Object defaultAction(Object obj, Void void1)
        {
            return obj;
        }

        public volatile Object visitArray(List list, Object obj)
        {
            return visitArray(list, (Void)obj);
        }

        public Object visitArray(List list, Void void1)
        {
            void1 = ((Void) (new Object[list.size()]));
            for (int i = 0; i < list.size(); i++)
            {
                void1[i] = ((AnnotationValue)list.get(i)).accept(this, null);
            }

            return void1;
        }

        public volatile Object visitString(String s, Object obj)
        {
            return visitString(s, (Void)obj);
        }

        public Object visitString(String s, Void void1)
        {
            if ("<error>".equals(s))
            {
                throw new CodeGenerationIncompleteException("Unknown type returned as <error>.");
            }
            if ("<any>".equals(s))
            {
                throw new CodeGenerationIncompleteException("Unknown type returned as <any>.");
            } else
            {
                return s;
            }
        }

        public volatile Object visitType(TypeMirror typemirror, Object obj)
        {
            return visitType(typemirror, (Void)obj);
        }

        public Object visitType(TypeMirror typemirror, Void void1)
        {
            return typemirror;
        }

    };

    private Util()
    {
    }

    public static String adapterName(TypeElement typeelement, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        rawTypeToString(stringbuilder, typeelement, '$');
        stringbuilder.append(s);
        return stringbuilder.toString();
    }

    private static Class box(PrimitiveType primitivetype)
    {
        static class _cls3
        {

            static final int $SwitchMap$javax$lang$model$element$ElementKind[];
            static final int $SwitchMap$javax$lang$model$type$TypeKind[];

            static 
            {
                $SwitchMap$javax$lang$model$type$TypeKind = new int[TypeKind.values().length];
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BYTE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.SHORT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.INT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.LONG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.FLOAT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.DOUBLE.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.BOOLEAN.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.CHAR.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$javax$lang$model$type$TypeKind[TypeKind.VOID.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$javax$lang$model$element$ElementKind = new int[ElementKind.values().length];
                try
                {
                    $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.FIELD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.CONSTRUCTOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$javax$lang$model$element$ElementKind[ElementKind.METHOD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls3..SwitchMap.javax.lang.model.type.TypeKind[primitivetype.getKind().ordinal()])
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            return java/lang/Byte;

        case 2: // '\002'
            return java/lang/Short;

        case 3: // '\003'
            return java/lang/Integer;

        case 4: // '\004'
            return java/lang/Long;

        case 5: // '\005'
            return java/lang/Float;

        case 6: // '\006'
            return java/lang/Double;

        case 7: // '\007'
            return java/lang/Boolean;

        case 8: // '\b'
            return java/lang/Character;

        case 9: // '\t'
            return java/lang/Void;
        }
    }

    public static String className(ExecutableElement executableelement)
    {
        return ((TypeElement)executableelement.getEnclosingElement()).getQualifiedName().toString();
    }

    static String elementToString(Element element)
    {
        switch (_cls3..SwitchMap.javax.lang.model.element.ElementKind[element.getKind().ordinal()])
        {
        default:
            return element.toString();

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return (new StringBuilder()).append(element.getEnclosingElement()).append(".").append(element).toString();
        }
    }

    public static Map getAnnotation(Class class1, Element element)
    {
label0:
        {
            for (Iterator iterator = element.getAnnotationMirrors().iterator(); iterator.hasNext();)
            {
                element = (AnnotationMirror)iterator.next();
                if (rawTypeToString(element.getAnnotationType(), '$').equals(class1.getName()))
                {
                    Object obj = new LinkedHashMap();
                    Method amethod[] = class1.getMethods();
                    int j = amethod.length;
                    for (int i = 0; i < j; i++)
                    {
                        Method method = amethod[i];
                        ((Map) (obj)).put(method.getName(), method.getDefaultValue());
                    }

                    Iterator iterator1 = element.getElementValues().entrySet().iterator();
                    do
                    {
                        element = ((Element) (obj));
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        element = (java.util.Map.Entry)iterator1.next();
                        String s = ((ExecutableElement)element.getKey()).getSimpleName().toString();
                        Object obj1 = ((AnnotationValue)element.getValue()).accept(VALUE_EXTRACTOR, null);
                        element = ((Element) (((Map) (obj)).get(s)));
                        if (!lenientIsInstance(element.getClass(), obj1))
                        {
                            obj = obj1.getClass().getName();
                            String s1 = element.getClass().getName();
                            element = ((Element) (obj1));
                            if (obj1 instanceof Object[])
                            {
                                element = Arrays.toString((Object[])(Object[])obj1);
                            }
                            throw new IllegalStateException(String.format("Value of %s.%s is a %s but expected a %s\n    value: %s", new Object[] {
                                class1, s, obj, s1, element
                            }));
                        }
                        ((Map) (obj)).put(s, obj1);
                    } while (true);
                    break label0;
                }
            }

            element = null;
        }
        return element;
    }

    public static TypeMirror getApplicationSupertype(TypeElement typeelement)
    {
        TypeMirror typemirror = typeelement.getSuperclass();
        typeelement = typemirror;
        if (Keys.isPlatformType(typemirror.toString()))
        {
            typeelement = null;
        }
        return typeelement;
    }

    public static ExecutableElement getNoArgsConstructor(TypeElement typeelement)
    {
        for (typeelement = typeelement.getEnclosedElements().iterator(); typeelement.hasNext();)
        {
            Object obj = (Element)typeelement.next();
            if (((Element) (obj)).getKind() == ElementKind.CONSTRUCTOR)
            {
                obj = (ExecutableElement)obj;
                if (((ExecutableElement) (obj)).getParameters().isEmpty())
                {
                    return ((ExecutableElement) (obj));
                }
            }
        }

        return null;
    }

    public static PackageElement getPackage(Element element)
    {
        for (; element.getKind() != ElementKind.PACKAGE; element = element.getEnclosingElement()) { }
        return (PackageElement)element;
    }

    public static boolean isCallableConstructor(ExecutableElement executableelement)
    {
        if (!executableelement.getModifiers().contains(Modifier.PRIVATE))
        {
            if ((executableelement = (TypeElement)executableelement.getEnclosingElement()).getEnclosingElement().getKind() == ElementKind.PACKAGE || executableelement.getModifiers().contains(Modifier.STATIC))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isInterface(TypeMirror typemirror)
    {
        return (typemirror instanceof DeclaredType) && ((DeclaredType)typemirror).asElement().getKind() == ElementKind.INTERFACE;
    }

    static boolean isStatic(Element element)
    {
        for (element = element.getModifiers().iterator(); element.hasNext();)
        {
            if (((Modifier)element.next()).equals(Modifier.STATIC))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean lenientIsInstance(Class class1, Object obj)
    {
        boolean flag;
        flag = true;
        if (!class1.isArray())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        class1 = class1.getComponentType();
        if (obj instanceof Object[]) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        obj = ((Object) ((Object[])(Object[])obj));
        int j = obj.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break; /* Loop/switch isn't completed */
            }
            if (!lenientIsInstance(class1, obj[i]))
            {
                continue; /* Loop/switch isn't completed */
            }
            i++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
        if (class1 == java/lang/Class)
        {
            return obj instanceof TypeMirror;
        }
        if (class1 != obj.getClass())
        {
            flag = false;
        }
        return flag;
    }

    public static String rawTypeToString(TypeMirror typemirror, char c)
    {
        if (!(typemirror instanceof DeclaredType))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unexpected type: ").append(typemirror).toString());
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            rawTypeToString(stringbuilder, (TypeElement)((DeclaredType)typemirror).asElement(), c);
            return stringbuilder.toString();
        }
    }

    static void rawTypeToString(StringBuilder stringbuilder, TypeElement typeelement, char c)
    {
        String s = getPackage(typeelement).getQualifiedName().toString();
        typeelement = typeelement.getQualifiedName().toString();
        if (s.isEmpty())
        {
            stringbuilder.append(typeelement.replace('.', c));
            return;
        } else
        {
            stringbuilder.append(s);
            stringbuilder.append('.');
            stringbuilder.append(typeelement.substring(s.length() + 1).replace('.', c));
            return;
        }
    }

    public static String typeToString(TypeMirror typemirror)
    {
        StringBuilder stringbuilder = new StringBuilder();
        typeToString(typemirror, stringbuilder, '.');
        return stringbuilder.toString();
    }

    public static void typeToString(TypeMirror typemirror, StringBuilder stringbuilder, char c)
    {
        typemirror.accept(new SimpleTypeVisitor6(stringbuilder, c, typemirror) {

            final char val$innerClassSeparator;
            final StringBuilder val$result;
            final TypeMirror val$type;

            protected volatile Object defaultAction(TypeMirror typemirror1, Object obj)
            {
                return defaultAction(typemirror1, (Void)obj);
            }

            protected Void defaultAction(TypeMirror typemirror1, Void void1)
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("Unexpected TypeKind ").append(typemirror1.getKind()).append(" for ").append(typemirror1).toString());
            }

            public volatile Object visitArray(ArrayType arraytype, Object obj)
            {
                return visitArray(arraytype, (Void)obj);
            }

            public Void visitArray(ArrayType arraytype, Void void1)
            {
                void1 = arraytype.getComponentType();
                if (void1 instanceof PrimitiveType)
                {
                    result.append(void1.toString());
                } else
                {
                    Util.typeToString(arraytype.getComponentType(), result, innerClassSeparator);
                }
                result.append("[]");
                return null;
            }

            public volatile Object visitDeclared(DeclaredType declaredtype, Object obj)
            {
                return visitDeclared(declaredtype, (Void)obj);
            }

            public Void visitDeclared(DeclaredType declaredtype, Void void1)
            {
                void1 = (TypeElement)declaredtype.asElement();
                Util.rawTypeToString(result, void1, innerClassSeparator);
                declaredtype = declaredtype.getTypeArguments();
                if (!declaredtype.isEmpty())
                {
                    result.append("<");
                    for (int i = 0; i < declaredtype.size(); i++)
                    {
                        if (i != 0)
                        {
                            result.append(", ");
                        }
                        Util.typeToString((TypeMirror)declaredtype.get(i), result, innerClassSeparator);
                    }

                    result.append(">");
                }
                return null;
            }

            public volatile Object visitError(ErrorType errortype, Object obj)
            {
                return visitError(errortype, (Void)obj);
            }

            public Void visitError(ErrorType errortype, Void void1)
            {
                if ("<any>".equals(errortype.toString()))
                {
                    throw new CodeGenerationIncompleteException("Type reported as <any> is likely a not-yet generated parameterized type.");
                } else
                {
                    result.append(errortype.toString());
                    return null;
                }
            }

            public volatile Object visitPrimitive(PrimitiveType primitivetype, Object obj)
            {
                return visitPrimitive(primitivetype, (Void)obj);
            }

            public Void visitPrimitive(PrimitiveType primitivetype, Void void1)
            {
                result.append(Util.box((PrimitiveType)type).getName());
                return null;
            }

            public volatile Object visitTypeVariable(TypeVariable typevariable, Object obj)
            {
                return visitTypeVariable(typevariable, (Void)obj);
            }

            public Void visitTypeVariable(TypeVariable typevariable, Void void1)
            {
                result.append(typevariable.asElement().getSimpleName());
                return null;
            }

            
            {
                result = stringbuilder;
                innerClassSeparator = c;
                type = typemirror;
                super();
            }
        }, null);
    }


}
