// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.msgpack.AbstractTemplate;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;
import org.msgpack.Template;

// Referenced classes of package org.msgpack.template:
//            TemplateBuilder, BooleanArrayTemplate, ShortArrayTemplate, IntArrayTemplate, 
//            LongArrayTemplate, FloatArrayTemplate, DoubleArrayTemplate, TemplateRegistry

public class ReflectionTemplateBuilder extends TemplateBuilder
{
    static class BooleanFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Boolean)obj).booleanValue());
        }

        BooleanFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class ByteFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Byte)obj).byteValue());
        }

        ByteFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class DoubleFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Double)obj).doubleValue());
        }

        DoubleFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class FloatFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Float)obj).floatValue());
        }

        FloatFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class IntFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Integer)obj).intValue());
        }

        IntFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class LongFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Long)obj).longValue());
        }

        LongFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class NullFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
        }

        NullFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }

    static class ObjectFieldEntry extends ReflectionFieldEntry
    {

        private Template template;

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            template.pack(packer, obj);
        }

        ObjectFieldEntry(TemplateBuilder.FieldEntry fieldentry, Template template1)
        {
            super(fieldentry);
            template = template1;
        }
    }

    static abstract class ReflectionFieldEntry extends TemplateBuilder.FieldEntry
    {

        public abstract void pack(Object obj, Packer packer)
            throws IOException;

        ReflectionFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry.getField(), fieldentry.getOption());
        }
    }

    static class ReflectionMultidimentionalArrayTemplate extends AbstractTemplate
    {

        private Class componentClass;
        private Template componentTemplate;

        Class getComponentClass()
        {
            return componentClass;
        }

        public void pack(Packer packer, Object obj)
            throws IOException
        {
            obj = ((Object) ((Object[])(Object[])obj));
            int j = obj.length;
            packer.packArray(j);
            for (int i = 0; i < j; i++)
            {
                componentTemplate.pack(packer, obj[i]);
            }

        }

        public ReflectionMultidimentionalArrayTemplate(Class class1, Template template)
        {
            componentClass = class1;
            componentTemplate = template;
        }
    }

    static class ReflectionObjectArrayTemplate extends AbstractTemplate
    {

        private Class componentClass;
        private Template elementTemplate;

        public void pack(Packer packer, Object obj)
            throws IOException
        {
            if (!(obj instanceof Object[]) || !componentClass.isAssignableFrom(obj.getClass().getComponentType()))
            {
                throw new MessageTypeException();
            }
            obj = ((Object) ((Object[])(Object[])obj));
            int j = obj.length;
            packer.packArray(j);
            for (int i = 0; i < j; i++)
            {
                elementTemplate.pack(packer, obj[i]);
            }

        }

        public ReflectionObjectArrayTemplate(Class class1, Template template)
        {
            componentClass = class1;
            elementTemplate = template;
        }
    }

    static class ReflectionOrdinalEnumTemplate extends AbstractTemplate
    {

        protected Enum entries[];
        protected Map reverse;

        public void pack(Packer packer, Object obj)
            throws IOException
        {
            obj = (Integer)reverse.get(obj);
            if (obj == null)
            {
                throw new MessageTypeException();
            } else
            {
                packer.pack(((Integer) (obj)).intValue());
                return;
            }
        }

        ReflectionOrdinalEnumTemplate(Enum aenum[])
        {
            entries = aenum;
            reverse = new HashMap();
            for (int i = 0; i < aenum.length; i++)
            {
                reverse.put(aenum[i], Integer.valueOf(i));
            }

        }
    }

    static class ReflectionTemplate extends AbstractTemplate
    {

        protected ReflectionFieldEntry entries[];
        protected int minimumArrayLength;
        protected Class targetClass;

        public void pack(Packer packer, Object obj)
            throws IOException
        {
            int i;
            ReflectionFieldEntry areflectionfieldentry[];
            ReflectionFieldEntry reflectionfieldentry;
            Object obj1;
            int j;
            try
            {
                packer.packArray(entries.length);
                areflectionfieldentry = entries;
                j = areflectionfieldentry.length;
            }
            // Misplaced declaration of an exception variable
            catch (Packer packer)
            {
                throw packer;
            }
            // Misplaced declaration of an exception variable
            catch (Packer packer)
            {
                throw packer;
            }
            // Misplaced declaration of an exception variable
            catch (Packer packer)
            {
                throw new MessageTypeException(packer);
            }
            i = 0;
_L2:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_126;
            }
            reflectionfieldentry = areflectionfieldentry[i];
            if (!reflectionfieldentry.isAvailable())
            {
                packer.packNil();
                break MISSING_BLOCK_LABEL_127;
            }
            obj1 = reflectionfieldentry.getField().get(obj);
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_105;
            }
            if (!reflectionfieldentry.isNullable() && !reflectionfieldentry.isOptional())
            {
                throw new MessageTypeException();
            }
            packer.packNil();
            break MISSING_BLOCK_LABEL_127;
            reflectionfieldentry.pack(obj1, packer);
            break MISSING_BLOCK_LABEL_127;
            return;
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        ReflectionTemplate(Class class1, ReflectionFieldEntry areflectionfieldentry[])
        {
            targetClass = class1;
            entries = areflectionfieldentry;
            minimumArrayLength = 0;
            for (int i = 0; i < areflectionfieldentry.length; i++)
            {
                class1 = areflectionfieldentry[i];
                if (class1.isRequired() || class1.isNullable())
                {
                    minimumArrayLength = i + 1;
                }
            }

        }
    }

    static class ShortFieldEntry extends ReflectionFieldEntry
    {

        public void pack(Object obj, Packer packer)
            throws IOException
        {
            packer.pack(((Short)obj).shortValue());
        }

        ShortFieldEntry(TemplateBuilder.FieldEntry fieldentry)
        {
            super(fieldentry);
        }
    }


    private static ReflectionTemplateBuilder instance;

    private ReflectionTemplateBuilder()
    {
    }

    public static ReflectionTemplateBuilder getInstance()
    {
        org/msgpack/template/ReflectionTemplateBuilder;
        JVM INSTR monitorenter ;
        ReflectionTemplateBuilder reflectiontemplatebuilder;
        if (instance == null)
        {
            instance = new ReflectionTemplateBuilder();
        }
        reflectiontemplatebuilder = instance;
        org/msgpack/template/ReflectionTemplateBuilder;
        JVM INSTR monitorexit ;
        return reflectiontemplatebuilder;
        Exception exception;
        exception;
        throw exception;
    }

    public Template buildArrayTemplate(Type type, Type type1, Class class1, int i)
    {
        if (i == 1)
        {
            if (class1 == Boolean.TYPE)
            {
                return BooleanArrayTemplate.getInstance();
            }
            if (class1 == Short.TYPE)
            {
                return ShortArrayTemplate.getInstance();
            }
            if (class1 == Integer.TYPE)
            {
                return IntArrayTemplate.getInstance();
            }
            if (class1 == Long.TYPE)
            {
                return LongArrayTemplate.getInstance();
            }
            if (class1 == Float.TYPE)
            {
                return FloatArrayTemplate.getInstance();
            }
            if (class1 == Double.TYPE)
            {
                return DoubleArrayTemplate.getInstance();
            } else
            {
                return new ReflectionObjectArrayTemplate(class1, TemplateRegistry.lookup(type1));
            }
        }
        if (i == 2)
        {
            return new ReflectionMultidimentionalArrayTemplate(Array.newInstance(class1, 0).getClass(), buildArrayTemplate(type, type1, class1, i - 1));
        } else
        {
            type = (ReflectionMultidimentionalArrayTemplate)buildArrayTemplate(type, type1, class1, i - 1);
            return new ReflectionMultidimentionalArrayTemplate(Array.newInstance(type.getComponentClass(), 0).getClass(), type);
        }
    }

    public Template buildOrdinalEnumTemplate(Class class1, Enum aenum[])
    {
        return new ReflectionOrdinalEnumTemplate(aenum);
    }

    public Template buildTemplate(Class class1, TemplateBuilder.FieldEntry afieldentry[])
    {
        int k = afieldentry.length;
        for (int i = 0; i < k; i++)
        {
            Field field = afieldentry[i].getField();
            if (!Modifier.isPublic(field.getModifiers()))
            {
                field.setAccessible(true);
            }
        }

        ReflectionFieldEntry areflectionfieldentry[] = new ReflectionFieldEntry[afieldentry.length];
        int j = 0;
        while (j < afieldentry.length) 
        {
            TemplateBuilder.FieldEntry fieldentry = afieldentry[j];
            Class class2 = fieldentry.getType();
            if (!fieldentry.isAvailable())
            {
                areflectionfieldentry[j] = new NullFieldEntry(fieldentry);
            } else
            if (class2.equals(Boolean.TYPE))
            {
                areflectionfieldentry[j] = new BooleanFieldEntry(fieldentry);
            } else
            if (class2.equals(Byte.TYPE))
            {
                areflectionfieldentry[j] = new ByteFieldEntry(fieldentry);
            } else
            if (class2.equals(Short.TYPE))
            {
                areflectionfieldentry[j] = new ShortFieldEntry(fieldentry);
            } else
            if (class2.equals(Integer.TYPE))
            {
                areflectionfieldentry[j] = new IntFieldEntry(fieldentry);
            } else
            if (class2.equals(Long.TYPE))
            {
                areflectionfieldentry[j] = new LongFieldEntry(fieldentry);
            } else
            if (class2.equals(Float.TYPE))
            {
                areflectionfieldentry[j] = new FloatFieldEntry(fieldentry);
            } else
            if (class2.equals(Double.TYPE))
            {
                areflectionfieldentry[j] = new DoubleFieldEntry(fieldentry);
            } else
            {
                areflectionfieldentry[j] = new ObjectFieldEntry(fieldentry, TemplateRegistry.lookup(fieldentry.getGenericType(), true));
            }
            j++;
        }
        return new ReflectionTemplate(class1, areflectionfieldentry);
    }
}
