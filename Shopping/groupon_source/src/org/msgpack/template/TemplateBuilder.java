// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.msgpack.Template;
import org.msgpack.annotation.Ignore;
import org.msgpack.annotation.Index;
import org.msgpack.annotation.MessagePackMessage;
import org.msgpack.annotation.Nullable;
import org.msgpack.annotation.Optional;
import org.msgpack.annotation.Required;

// Referenced classes of package org.msgpack.template:
//            TemplateBuildException, FieldOption, ReflectionTemplateBuilder, JavassistTemplateBuilder

public abstract class TemplateBuilder
{
    public static class FieldEntry
    {

        private Field field;
        private FieldOption option;

        static String arrayTypeToString(Class class1)
        {
            int i = 1;
            for (class1 = class1.getComponentType(); class1.isArray();)
            {
                class1 = class1.getComponentType();
                i++;
            }

            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(class1.getName());
            for (int j = 0; j < i; j++)
            {
                stringbuilder.append("[]");
            }

            return stringbuilder.toString();
        }

        public Field getField()
        {
            return field;
        }

        public Type getGenericType()
        {
            return field.getGenericType();
        }

        public String getJavaTypeName()
        {
            Class class1 = field.getType();
            if (class1.isArray())
            {
                return arrayTypeToString(class1);
            } else
            {
                return class1.getName();
            }
        }

        public String getName()
        {
            return field.getName();
        }

        public FieldOption getOption()
        {
            return option;
        }

        public Class getType()
        {
            return field.getType();
        }

        public boolean isAvailable()
        {
            return option != FieldOption.IGNORE;
        }

        public boolean isNullable()
        {
            return option == FieldOption.NULLABLE;
        }

        public boolean isOptional()
        {
            return option == FieldOption.OPTIONAL;
        }

        public boolean isRequired()
        {
            return option == FieldOption.REQUIRED;
        }

        public FieldEntry()
        {
            field = null;
            option = FieldOption.IGNORE;
        }

        public FieldEntry(Field field1, FieldOption fieldoption)
        {
            field = field1;
            option = fieldoption;
        }
    }


    private static TemplateBuilder instance = selectDefaultTemplateBuilder();

    public TemplateBuilder()
    {
    }

    public static Template build(Class class1)
    {
        return instance.buildTemplate(class1);
    }

    public static Template buildArray(Type type)
    {
        return instance.buildArrayTemplate(type);
    }

    public static Template buildOrdinalEnum(Class class1)
    {
        return instance.buildOrdinalEnumTemplate(class1);
    }

    private static void checkOrdinalEnumValidation(Class class1)
    {
        if (!class1.isEnum())
        {
            throw new TemplateBuildException("tried to build ordinal enum template of non-enum class");
        } else
        {
            return;
        }
    }

    private static void checkValidation(Class class1)
    {
        if (class1.isInterface())
        {
            throw new TemplateBuildException("cannot build template of interface");
        }
        if (class1.isArray())
        {
            throw new TemplateBuildException("cannot build template of array class");
        }
        if (class1.isPrimitive())
        {
            throw new TemplateBuildException("cannot build template of primitive type");
        } else
        {
            return;
        }
    }

    private static boolean isAnnotated(AccessibleObject accessibleobject, Class class1)
    {
        return accessibleobject.getAnnotation(class1) != null;
    }

    private static Field[] readAllFields(Class class1)
    {
        ArrayList arraylist = new ArrayList();
        int i = 0;
        for (; class1 != java/lang/Object; class1 = class1.getSuperclass())
        {
            Field afield[] = class1.getDeclaredFields();
            i += afield.length;
            arraylist.add(afield);
        }

        class1 = new Field[i];
        int k = 0;
        for (int j = arraylist.size() - 1; j >= 0; j--)
        {
            Field afield1[] = (Field[])arraylist.get(j);
            System.arraycopy(afield1, 0, class1, k, afield1.length);
            k += afield1.length;
        }

        return class1;
    }

    static FieldEntry[] readFieldEntries(Class class1, FieldOption fieldoption)
    {
        Field afield[] = readAllFields(class1);
        class1 = new ArrayList();
        byte byte0 = -1;
        int l = afield.length;
        int i = 0;
        while (i < l) 
        {
            Field field = afield[i];
            FieldOption fieldoption1 = readFieldOption(field, fieldoption);
            int j;
            if (fieldoption1 == FieldOption.IGNORE)
            {
                j = byte0;
            } else
            {
                int k = readFieldIndex(field, byte0);
                if (class1.size() > k && class1.get(k) != null)
                {
                    throw new TemplateBuildException((new StringBuilder()).append("duplicated index: ").append(k).toString());
                }
                if (k < 0)
                {
                    throw new TemplateBuildException((new StringBuilder()).append("invalid index: ").append(k).toString());
                }
                for (; class1.size() <= k; class1.add(null)) { }
                class1.set(k, new FieldEntry(field, fieldoption1));
                j = byte0;
                if (byte0 < k)
                {
                    j = k;
                }
            }
            i++;
            byte0 = j;
        }
        fieldoption = new FieldEntry[byte0 + 1];
        i = 0;
        while (i < class1.size()) 
        {
            FieldEntry fieldentry = (FieldEntry)class1.get(i);
            if (fieldentry == null)
            {
                fieldoption[i] = new FieldEntry();
            } else
            {
                fieldoption[i] = fieldentry;
            }
            i++;
        }
        return fieldoption;
    }

    private static int readFieldIndex(Field field, int i)
    {
        field = (Index)field.getAnnotation(org/msgpack/annotation/Index);
        if (field == null)
        {
            return i + 1;
        } else
        {
            return field.value();
        }
    }

    private static FieldOption readFieldOption(Field field, FieldOption fieldoption)
    {
        int i = field.getModifiers();
        if (Modifier.isStatic(i) || Modifier.isFinal(i))
        {
            field = FieldOption.IGNORE;
        } else
        {
            if (isAnnotated(field, org/msgpack/annotation/Ignore))
            {
                return FieldOption.IGNORE;
            }
            if (isAnnotated(field, org/msgpack/annotation/Required))
            {
                return FieldOption.REQUIRED;
            }
            if (isAnnotated(field, org/msgpack/annotation/Optional))
            {
                return FieldOption.OPTIONAL;
            }
            if (isAnnotated(field, org/msgpack/annotation/Nullable))
            {
                if (field.getDeclaringClass().isPrimitive())
                {
                    return FieldOption.REQUIRED;
                } else
                {
                    return FieldOption.NULLABLE;
                }
            }
            field = fieldoption;
            if (fieldoption == FieldOption.DEFAULT)
            {
                if (Modifier.isTransient(i))
                {
                    return FieldOption.IGNORE;
                }
                if (Modifier.isPublic(i))
                {
                    return FieldOption.REQUIRED;
                } else
                {
                    return FieldOption.IGNORE;
                }
            }
        }
        return field;
    }

    private static FieldOption readImplicitFieldOption(Class class1)
    {
        class1 = (MessagePackMessage)class1.getAnnotation(org/msgpack/annotation/MessagePackMessage);
        if (class1 == null)
        {
            return FieldOption.DEFAULT;
        } else
        {
            return class1.value();
        }
    }

    private static TemplateBuilder selectDefaultTemplateBuilder()
    {
        ReflectionTemplateBuilder reflectiontemplatebuilder;
        if (!System.getProperty("java.vm.name").equals("Dalvik"))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        reflectiontemplatebuilder = ReflectionTemplateBuilder.getInstance();
        return reflectiontemplatebuilder;
        Exception exception;
        exception;
        return JavassistTemplateBuilder.getInstance();
    }

    public Template buildArrayTemplate(Type type)
    {
        boolean flag = true;
        int i = 1;
        Object obj;
        Class class1;
        if (type instanceof GenericArrayType)
        {
            for (obj = ((GenericArrayType)type).getGenericComponentType(); obj instanceof GenericArrayType;)
            {
                obj = ((GenericArrayType)obj).getGenericComponentType();
                i++;
            }

            if (obj instanceof ParameterizedType)
            {
                class1 = (Class)((ParameterizedType)obj).getRawType();
            } else
            {
                class1 = (Class)obj;
            }
        } else
        {
            obj = ((Class)type).getComponentType();
            for (i = ((flag) ? 1 : 0); ((Class) (obj)).isArray(); i++)
            {
                obj = ((Class) (obj)).getComponentType();
            }

            Class class2 = ((Class) (obj));
            class1 = ((Class) (obj));
            obj = class2;
        }
        return buildArrayTemplate(type, ((Type) (obj)), class1, i);
    }

    public abstract Template buildArrayTemplate(Type type, Type type1, Class class1, int i);

    public Template buildOrdinalEnumTemplate(Class class1)
    {
        checkOrdinalEnumValidation(class1);
        return buildOrdinalEnumTemplate(class1, (Enum[])(Enum[])class1.getEnumConstants());
    }

    public abstract Template buildOrdinalEnumTemplate(Class class1, Enum aenum[]);

    public Template buildTemplate(Class class1)
    {
        return buildTemplate(class1, readImplicitFieldOption(class1));
    }

    public Template buildTemplate(Class class1, FieldOption fieldoption)
    {
        checkValidation(class1);
        return buildTemplate(class1, readFieldEntries(class1, fieldoption));
    }

    public abstract Template buildTemplate(Class class1, FieldEntry afieldentry[]);

}
