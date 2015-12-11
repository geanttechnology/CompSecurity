// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;

// Referenced classes of package org.simpleframework.xml.core:
//            Converter, ObjectFactory, Primitive, Collector, 
//            Revision, Context, Schema, Caller, 
//            Instance, Instantiator, Section, LabelMap, 
//            AttributeException, Criteria, ElementException, Label, 
//            ValueRequiredException, Variable, Contact, PersistenceException, 
//            Decorator, TextException

class Composite
    implements Converter
{
    private static class Builder
    {

        protected final Composite composite;
        protected final Criteria criteria;
        protected final Schema schema;
        protected final Instance value;

        public Object read(InputNode inputnode)
            throws Exception
        {
            Object obj = value.getInstance();
            Section section = schema.getSection();
            value.setInstance(obj);
            composite.readVersion(inputnode, obj, schema);
            composite.readText(inputnode, obj, section);
            composite.readAttributes(inputnode, obj, section);
            composite.readElements(inputnode, obj, section);
            criteria.commit(obj);
            return obj;
        }

        public Builder(Composite composite1, Criteria criteria1, Schema schema1, Instance instance)
        {
            composite = composite1;
            criteria = criteria1;
            schema = schema1;
            value = instance;
        }
    }

    private class Injector extends Builder
    {

        final Composite this$0;

        private Object readInject(InputNode inputnode)
            throws Exception
        {
            inputnode = ((InputNode) (schema.getInstantiator().getInstance(criteria)));
            value.setInstance(inputnode);
            criteria.commit(inputnode);
            return inputnode;
        }

        public Object read(InputNode inputnode)
            throws Exception
        {
            Section section = schema.getSection();
            composite.readVersion(inputnode, null, schema);
            composite.readText(inputnode, null, section);
            composite.readAttributes(inputnode, null, section);
            composite.readElements(inputnode, null, section);
            return readInject(inputnode);
        }

        private Injector(Composite composite1, Criteria criteria1, Schema schema, Instance instance)
        {
            this$0 = Composite.this;
            super(composite1, criteria1, schema, instance);
        }

    }


    private final Context context;
    private final Criteria criteria;
    private final ObjectFactory factory;
    private final Primitive primitive;
    private final Revision revision;
    private final Type type;

    public Composite(Context context1, Type type1)
    {
        this(context1, type1, null);
    }

    public Composite(Context context1, Type type1, Class class1)
    {
        factory = new ObjectFactory(context1, type1, class1);
        primitive = new Primitive(context1, type1);
        criteria = new Collector();
        revision = new Revision();
        context = context1;
        type = type1;
    }

    private boolean isOverridden(OutputNode outputnode, Object obj, Type type1)
        throws Exception
    {
        return factory.setOverride(type1, obj, outputnode);
    }

    private Object read(InputNode inputnode, Instance instance, Class class1)
        throws Exception
    {
        Object obj = context.getSchema(class1);
        class1 = ((Schema) (obj)).getCaller();
        obj = read(((Schema) (obj)), instance).read(inputnode);
        class1.validate(obj);
        class1.commit(obj);
        instance.setInstance(obj);
        return readResolve(inputnode, obj, class1);
    }

    private Builder read(Schema schema, Instance instance)
        throws Exception
    {
        if (schema.getInstantiator().isDefault())
        {
            return new Builder(this, criteria, schema, instance);
        } else
        {
            return new Injector(this, criteria, schema, instance);
        }
    }

    private void read(InputNode inputnode, Object obj, Schema schema)
        throws Exception
    {
        Section section = schema.getSection();
        readVersion(inputnode, obj, schema);
        readSection(inputnode, obj, section);
    }

    private void readAttribute(InputNode inputnode, Object obj, Section section, LabelMap labelmap)
        throws Exception
    {
        section = section.getAttribute(inputnode.getName());
        Label label = labelmap.getLabel(section);
        if (label == null)
        {
            inputnode = inputnode.getPosition();
            obj = context.getType(type, obj);
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new AttributeException("Attribute '%s' does not have a match in %s at %s", new Object[] {
                    section, obj, inputnode
                });
            }
        } else
        {
            readInstance(inputnode, obj, label);
        }
    }

    private void readAttributes(InputNode inputnode, Object obj, Section section)
        throws Exception
    {
        Object obj1 = inputnode.getAttributes();
        LabelMap labelmap = section.getAttributes();
        obj1 = ((NodeMap) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            InputNode inputnode1 = inputnode.getAttribute((String)((Iterator) (obj1)).next());
            if (inputnode1 != null)
            {
                readAttribute(inputnode1, obj, section, labelmap);
            }
        } while (true);
        validate(inputnode, labelmap, obj);
    }

    private void readElement(InputNode inputnode, Object obj, Section section, LabelMap labelmap)
        throws Exception
    {
        String s = section.getPath(inputnode.getName());
        Label label = labelmap.getLabel(s);
        section = label;
        if (label == null)
        {
            section = criteria.resolve(s);
        }
        if (section == null)
        {
            section = inputnode.getPosition();
            obj = context.getType(type, obj);
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new ElementException("Element '%s' does not have a match in %s at %s", new Object[] {
                    s, obj, section
                });
            } else
            {
                inputnode.skip();
                return;
            }
        } else
        {
            readUnion(inputnode, obj, labelmap, section);
            return;
        }
    }

    private void readElements(InputNode inputnode, Object obj, Section section)
        throws Exception
    {
        LabelMap labelmap = section.getElements();
        InputNode inputnode1 = inputnode.getNext();
        while (inputnode1 != null) 
        {
            Section section1 = section.getSection(inputnode1.getName());
            if (section1 != null)
            {
                readSection(inputnode1, obj, section1);
            } else
            {
                readElement(inputnode1, obj, section, labelmap);
            }
            inputnode1 = inputnode.getNext();
        }
        validate(inputnode, labelmap, obj);
    }

    private Object readInstance(InputNode inputnode, Object obj, Label label)
        throws Exception
    {
        Object obj1 = readVariable(inputnode, obj, label);
        if (obj1 == null)
        {
            inputnode = inputnode.getPosition();
            obj = context.getType(type, obj);
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Empty value for %s in %s at %s", new Object[] {
                    label, obj, inputnode
                });
            }
        } else
        if (obj1 != label.getEmpty(context))
        {
            criteria.set(label, obj1);
        }
        return obj1;
    }

    private Object readPrimitive(InputNode inputnode, Instance instance)
        throws Exception
    {
        Class class1 = instance.getType();
        inputnode = ((InputNode) (primitive.read(inputnode, class1)));
        if (class1 != null)
        {
            instance.setInstance(inputnode);
        }
        return inputnode;
    }

    private Object readResolve(InputNode inputnode, Object obj, Caller caller)
        throws Exception
    {
        if (obj != null)
        {
            org.simpleframework.xml.stream.Position position = inputnode.getPosition();
            inputnode = ((InputNode) (caller.resolve(obj)));
            obj = type.getType();
            caller = inputnode.getClass();
            if (!((Class) (obj)).isAssignableFrom(caller))
            {
                throw new ElementException("Type %s does not match %s at %s", new Object[] {
                    caller, obj, position
                });
            }
        } else
        {
            inputnode = ((InputNode) (obj));
        }
        return inputnode;
    }

    private void readSection(InputNode inputnode, Object obj, Section section)
        throws Exception
    {
        readText(inputnode, obj, section);
        readAttributes(inputnode, obj, section);
        readElements(inputnode, obj, section);
    }

    private void readText(InputNode inputnode, Object obj, Section section)
        throws Exception
    {
        section = section.getText();
        if (section != null)
        {
            readInstance(inputnode, obj, section);
        }
    }

    private void readUnion(InputNode inputnode, Object obj, LabelMap labelmap, Label label)
        throws Exception
    {
        inputnode = ((InputNode) (readInstance(inputnode, obj, label)));
        obj = label.getPaths();
        int j = obj.length;
        for (int i = 0; i < j; i++)
        {
            labelmap.getLabel(obj[i]);
        }

        if (label.isInline())
        {
            criteria.set(label, inputnode);
        }
    }

    private Object readVariable(InputNode inputnode, Object obj, Label label)
        throws Exception
    {
        Converter converter = label.getConverter(context);
        if (label.isCollection())
        {
            Variable variable = criteria.get(label);
            label = label.getContact();
            if (variable != null)
            {
                return converter.read(inputnode, variable.getValue());
            }
            if (obj != null)
            {
                obj = label.get(obj);
                if (obj != null)
                {
                    return converter.read(inputnode, obj);
                }
            }
        }
        return converter.read(inputnode);
    }

    private void readVersion(InputNode inputnode, Object obj, Label label)
        throws Exception
    {
        inputnode = ((InputNode) (readInstance(inputnode, obj, label)));
        obj = type.getType();
        if (inputnode != null)
        {
            double d = context.getVersion(((Class) (obj))).revision();
            if (!inputnode.equals(revision))
            {
                revision.compare(Double.valueOf(d), inputnode);
            }
        }
    }

    private void readVersion(InputNode inputnode, Object obj, Schema schema)
        throws Exception
    {
        Class class1;
label0:
        {
            schema = schema.getVersion();
            class1 = type.getType();
            if (schema != null)
            {
                String s = schema.getName();
                inputnode = (InputNode)inputnode.getAttributes().remove(s);
                if (inputnode == null)
                {
                    break label0;
                }
                readVersion(inputnode, obj, ((Label) (schema)));
            }
            return;
        }
        inputnode = context.getVersion(class1);
        obj = Double.valueOf(revision.getDefault());
        double d = inputnode.revision();
        criteria.set(schema, obj);
        revision.compare(Double.valueOf(d), obj);
    }

    private void validate(InputNode inputnode, Label label)
        throws Exception
    {
        Converter converter = label.getConverter(context);
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        Class class1 = type.getType();
        if (!converter.validate(inputnode))
        {
            throw new PersistenceException("Invalid value for %s in %s at %s", new Object[] {
                label, class1, position
            });
        } else
        {
            criteria.set(label, null);
            return;
        }
    }

    private void validate(InputNode inputnode, LabelMap labelmap)
        throws Exception
    {
        inputnode = inputnode.getPosition();
        for (labelmap = labelmap.iterator(); labelmap.hasNext();)
        {
            Label label = (Label)labelmap.next();
            Class class1 = type.getType();
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] {
                    label, class1, inputnode
                });
            }
        }

    }

    private void validate(InputNode inputnode, LabelMap labelmap, Object obj)
        throws Exception
    {
        obj = context.getType(type, obj);
        inputnode = inputnode.getPosition();
        labelmap = labelmap.iterator();
        do
        {
            if (!labelmap.hasNext())
            {
                break;
            }
            Label label = (Label)labelmap.next();
            if (label.isRequired() && revision.isEqual())
            {
                throw new ValueRequiredException("Unable to satisfy %s for %s at %s", new Object[] {
                    label, obj, inputnode
                });
            }
            Object obj1 = label.getEmpty(context);
            if (obj1 != null)
            {
                criteria.set(label, obj1);
            }
        } while (true);
    }

    private boolean validate(InputNode inputnode, Class class1)
        throws Exception
    {
        class1 = context.getSchema(class1);
        Section section = class1.getSection();
        validateText(inputnode, class1);
        validateSection(inputnode, section);
        return inputnode.isElement();
    }

    private void validateAttribute(InputNode inputnode, Section section, LabelMap labelmap)
        throws Exception
    {
        org.simpleframework.xml.stream.Position position = inputnode.getPosition();
        section = section.getAttribute(inputnode.getName());
        Label label = labelmap.getLabel(section);
        if (label == null)
        {
            inputnode = type.getType();
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new AttributeException("Attribute '%s' does not exist for %s at %s", new Object[] {
                    section, inputnode, position
                });
            }
        } else
        {
            validate(inputnode, label);
        }
    }

    private void validateAttributes(InputNode inputnode, Section section)
        throws Exception
    {
        Object obj = inputnode.getAttributes();
        LabelMap labelmap = section.getAttributes();
        obj = ((NodeMap) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            InputNode inputnode1 = inputnode.getAttribute((String)((Iterator) (obj)).next());
            if (inputnode1 != null)
            {
                validateAttribute(inputnode1, section, labelmap);
            }
        } while (true);
        validate(inputnode, labelmap);
    }

    private void validateElement(InputNode inputnode, Section section, LabelMap labelmap)
        throws Exception
    {
        String s = section.getPath(inputnode.getName());
        Label label = labelmap.getLabel(s);
        section = label;
        if (label == null)
        {
            section = criteria.resolve(s);
        }
        if (section == null)
        {
            section = inputnode.getPosition();
            Class class1 = type.getType();
            if (labelmap.isStrict(context) && revision.isEqual())
            {
                throw new ElementException("Element '%s' does not exist for %s at %s", new Object[] {
                    s, class1, section
                });
            } else
            {
                inputnode.skip();
                return;
            }
        } else
        {
            validateUnion(inputnode, labelmap, section);
            return;
        }
    }

    private void validateElements(InputNode inputnode, Section section)
        throws Exception
    {
        LabelMap labelmap = section.getElements();
        InputNode inputnode1 = inputnode.getNext();
        while (inputnode1 != null) 
        {
            Section section1 = section.getSection(inputnode1.getName());
            if (section1 != null)
            {
                validateSection(inputnode1, section1);
            } else
            {
                validateElement(inputnode1, section, labelmap);
            }
            inputnode1 = inputnode.getNext();
        }
        validate(inputnode, labelmap);
    }

    private void validateSection(InputNode inputnode, Section section)
        throws Exception
    {
        validateAttributes(inputnode, section);
        validateElements(inputnode, section);
    }

    private void validateText(InputNode inputnode, Schema schema)
        throws Exception
    {
        schema = schema.getText();
        if (schema != null)
        {
            validate(inputnode, schema);
        }
    }

    private void validateUnion(InputNode inputnode, LabelMap labelmap, Label label)
        throws Exception
    {
        String as[] = label.getPaths();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            labelmap.getLabel(as[i]);
        }

        if (label.isInline())
        {
            criteria.set(label, null);
        }
        validate(inputnode, label);
    }

    private void write(OutputNode outputnode, Object obj, Schema schema)
        throws Exception
    {
        Section section = schema.getSection();
        writeVersion(outputnode, obj, schema);
        writeSection(outputnode, obj, section);
    }

    private void writeAttribute(OutputNode outputnode, Object obj, Label label)
        throws Exception
    {
        if (obj != null)
        {
            label.getDecorator().decorate(outputnode.setAttribute(label.getName(), factory.getText(obj)));
        }
    }

    private void writeAttributes(OutputNode outputnode, Object obj, Section section)
        throws Exception
    {
        Label label;
        for (Iterator iterator = section.getAttributes().iterator(); iterator.hasNext(); writeAttribute(outputnode, section, label))
        {
            label = (Label)iterator.next();
            Object obj1 = label.getContact().get(obj);
            Class class1 = context.getType(type, obj);
            section = ((Section) (obj1));
            if (obj1 == null)
            {
                section = ((Section) (label.getEmpty(context)));
            }
            if (section == null && label.isRequired())
            {
                throw new AttributeException("Value for %s is null in %s", new Object[] {
                    label, class1
                });
            }
        }

    }

    private void writeElement(OutputNode outputnode, Object obj, Converter converter)
        throws Exception
    {
        converter.write(outputnode, obj);
    }

    private void writeElement(OutputNode outputnode, Object obj, Label label)
        throws Exception
    {
        if (obj != null)
        {
            Class class1 = obj.getClass();
            Label label1 = label.getLabel(class1);
            String s = label1.getName();
            label = label.getType(class1);
            outputnode = outputnode.getChild(s);
            if (!label1.isInline())
            {
                writeNamespaces(outputnode, label, label1);
            }
            if (label1.isInline() || !isOverridden(outputnode, obj, label))
            {
                label = label1.getConverter(context);
                outputnode.setData(label1.isData());
                writeElement(outputnode, obj, ((Converter) (label)));
            }
        }
    }

    private void writeElements(OutputNode outputnode, Object obj, Section section)
        throws Exception
    {
        Iterator iterator = section.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            Section section1 = section.getSection(s);
            if (section1 != null)
            {
                writeSection(outputnode.getChild(s), obj, section1);
            } else
            {
                Label label = section.getElement(section.getPath(s));
                Class class1 = context.getType(type, obj);
                if (criteria.get(label) == null)
                {
                    if (label == null)
                    {
                        throw new ElementException("Element '%s' not defined in %s", new Object[] {
                            s, class1
                        });
                    }
                    writeUnion(outputnode, obj, section, label);
                }
            }
        } while (true);
    }

    private void writeNamespaces(OutputNode outputnode, Type type1, Label label)
        throws Exception
    {
        type1 = type1.getType();
        type1 = context.getDecorator(type1);
        label.getDecorator().decorate(outputnode, type1);
    }

    private Object writeReplace(Object obj)
        throws Exception
    {
        Object obj1 = obj;
        if (obj != null)
        {
            obj1 = obj.getClass();
            obj1 = context.getCaller(((Class) (obj1))).replace(obj);
        }
        return obj1;
    }

    private void writeSection(OutputNode outputnode, Object obj, Section section)
        throws Exception
    {
        Object obj1 = outputnode.getNamespaces();
        String s = section.getPrefix();
        if (s != null)
        {
            obj1 = ((NamespaceMap) (obj1)).getReference(s);
            if (obj1 == null)
            {
                throw new ElementException("Namespace prefix '%s' in %s is not in scope", new Object[] {
                    s, type
                });
            }
            outputnode.setReference(((String) (obj1)));
        }
        writeAttributes(outputnode, obj, section);
        writeElements(outputnode, obj, section);
        writeText(outputnode, obj, section);
    }

    private void writeText(OutputNode outputnode, Object obj, Label label)
        throws Exception
    {
        if (obj != null)
        {
            obj = factory.getText(obj);
            outputnode.setData(label.isData());
            outputnode.setValue(((String) (obj)));
        }
    }

    private void writeText(OutputNode outputnode, Object obj, Section section)
        throws Exception
    {
        Label label = section.getText();
        if (label != null)
        {
            section = ((Section) (label.getContact().get(obj)));
            Class class1 = context.getType(type, obj);
            obj = section;
            if (section == null)
            {
                obj = label.getEmpty(context);
            }
            if (obj == null && label.isRequired())
            {
                throw new TextException("Value for %s is null in %s", new Object[] {
                    label, class1
                });
            }
            writeText(outputnode, obj, label);
        }
    }

    private void writeUnion(OutputNode outputnode, Object obj, Section section, Label label)
        throws Exception
    {
        section = ((Section) (label.getContact().get(obj)));
        obj = context.getType(type, obj);
        if (section == null && label.isRequired())
        {
            throw new ElementException("Value for %s is null in %s", new Object[] {
                label, obj
            });
        }
        obj = writeReplace(section);
        if (obj != null)
        {
            writeElement(outputnode, obj, label);
        }
        criteria.set(label, obj);
    }

    private void writeVersion(OutputNode outputnode, Object obj, Schema schema)
        throws Exception
    {
label0:
        {
            obj = schema.getRevision();
            schema = schema.getVersion();
            if (obj != null)
            {
                double d = revision.getDefault();
                obj = Double.valueOf(((Version) (obj)).revision());
                if (!revision.compare(obj, Double.valueOf(d)))
                {
                    break label0;
                }
                if (schema.isRequired())
                {
                    writeAttribute(outputnode, obj, schema);
                }
            }
            return;
        }
        writeAttribute(outputnode, obj, schema);
    }

    public Object read(InputNode inputnode)
        throws Exception
    {
        Instance instance = factory.getInstance(inputnode);
        Class class1 = instance.getType();
        if (instance.isReference())
        {
            return instance.getInstance();
        }
        if (context.isPrimitive(class1))
        {
            return readPrimitive(inputnode, instance);
        } else
        {
            return read(inputnode, instance, class1);
        }
    }

    public Object read(InputNode inputnode, Object obj)
        throws Exception
    {
        Object obj1 = obj.getClass();
        obj1 = context.getSchema(((Class) (obj1)));
        Caller caller = ((Schema) (obj1)).getCaller();
        read(inputnode, obj, ((Schema) (obj1)));
        criteria.commit(obj);
        caller.validate(obj);
        caller.commit(obj);
        return readResolve(inputnode, obj, caller);
    }

    public boolean validate(InputNode inputnode)
        throws Exception
    {
        Instance instance = factory.getInstance(inputnode);
        if (!instance.isReference())
        {
            instance.setInstance(null);
            return validate(inputnode, instance.getType());
        } else
        {
            return true;
        }
    }

    public void write(OutputNode outputnode, Object obj)
        throws Exception
    {
        Object obj1;
        Schema schema;
        obj1 = obj.getClass();
        schema = context.getSchema(((Class) (obj1)));
        obj1 = schema.getCaller();
        if (!schema.isPrimitive()) goto _L2; else goto _L1
_L1:
        primitive.write(outputnode, obj);
_L4:
        ((Caller) (obj1)).complete(obj);
        return;
_L2:
        ((Caller) (obj1)).persist(obj);
        write(outputnode, obj, schema);
        if (true) goto _L4; else goto _L3
_L3:
        outputnode;
        ((Caller) (obj1)).complete(obj);
        throw outputnode;
    }




}
