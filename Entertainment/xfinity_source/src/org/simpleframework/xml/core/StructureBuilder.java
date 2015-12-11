// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;

// Referenced classes of package org.simpleframework.xml.core:
//            ExpressionBuilder, ModelAssembler, InstantiatorBuilder, TreeModel, 
//            LabelMap, Expression, Model, UnionException, 
//            LabelFactory, Label, PersistenceException, TextException, 
//            AttributeException, ElementException, Scanner, Contact, 
//            Structure, Instantiator

class StructureBuilder
{

    private ModelAssembler assembler;
    private LabelMap attributes;
    private ExpressionBuilder builder;
    private LabelMap elements;
    private Instantiator factory;
    private Format format;
    private boolean primitive;
    private InstantiatorBuilder resolver;
    private Model root;
    private Scanner scanner;
    private Label text;
    private LabelMap texts;
    private Class type;
    private Label version;

    public StructureBuilder(Scanner scanner1, Class class1, Format format1)
        throws Exception
    {
        builder = new ExpressionBuilder(class1, format1);
        assembler = new ModelAssembler(builder, class1, format1);
        resolver = new InstantiatorBuilder(scanner1, class1);
        root = new TreeModel(scanner1, class1);
        attributes = new LabelMap(scanner1);
        elements = new LabelMap(scanner1);
        texts = new LabelMap(scanner1);
        scanner = scanner1;
        format = format1;
        type = class1;
    }

    private Model create(Expression expression)
        throws Exception
    {
        Model model = root;
        Expression expression1 = expression;
        expression = model;
        do
        {
            Object obj;
label0:
            {
                obj = expression;
                if (expression != null)
                {
                    String s = expression1.getPrefix();
                    String s1 = expression1.getFirst();
                    int i = expression1.getIndex();
                    obj = expression;
                    if (s1 != null)
                    {
                        obj = expression.register(s1, s, i);
                    }
                    if (expression1.isPath())
                    {
                        break label0;
                    }
                }
                return ((Model) (obj));
            }
            expression1 = expression1.getPath(1);
            expression = ((Expression) (obj));
        } while (true);
    }

    private Annotation[] extract(Annotation annotation)
        throws Exception
    {
        Method amethod[] = annotation.annotationType().getDeclaredMethods();
        if (amethod.length != 1)
        {
            throw new UnionException("Annotation '%s' is not a valid union for %s", new Object[] {
                annotation, type
            });
        } else
        {
            return (Annotation[])(Annotation[])amethod[0].invoke(annotation, new Object[0]);
        }
    }

    private boolean isAttribute(String s)
        throws Exception
    {
        Expression expression = builder.build(s);
        Model model = lookup(expression);
        if (model != null)
        {
            String s1 = expression.getLast();
            if (!expression.isPath())
            {
                return model.isAttribute(s);
            } else
            {
                return model.isAttribute(s1);
            }
        } else
        {
            return false;
        }
    }

    private boolean isElement(String s)
        throws Exception
    {
        Model model;
        String s1;
        int i;
        s = builder.build(s);
        model = lookup(s);
        if (model == null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        s1 = s.getLast();
        i = s.getIndex();
        if (!model.isElement(s1)) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!model.isModel(s1))
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (!model.lookup(s1, i).isEmpty()) goto _L1; else goto _L3
_L3:
        return false;
        return false;
    }

    private boolean isEmpty()
    {
        if (text != null)
        {
            return false;
        } else
        {
            return root.isEmpty();
        }
    }

    private Model lookup(Expression expression)
        throws Exception
    {
        Expression expression1 = expression.getPath(0, 1);
        if (expression.isPath())
        {
            return root.lookup(expression1);
        } else
        {
            return root;
        }
    }

    private void process(Contact contact, Annotation annotation, LabelMap labelmap)
        throws Exception
    {
        annotation = LabelFactory.getInstance(contact, annotation, format);
        String s = annotation.getPath();
        String s1 = annotation.getName();
        if (labelmap.get(s) != null)
        {
            throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] {
                s1, contact
            });
        } else
        {
            process(contact, ((Label) (annotation)), labelmap);
            return;
        }
    }

    private void process(Contact contact, Label label, LabelMap labelmap)
        throws Exception
    {
        Expression expression = label.getExpression();
        String s = label.getPath();
        contact = root;
        if (!expression.isEmpty())
        {
            contact = register(expression);
        }
        resolver.register(label);
        contact.register(label);
        labelmap.put(s, label);
    }

    private Model register(Expression expression)
        throws Exception
    {
        Model model = root.lookup(expression);
        if (model != null)
        {
            return model;
        } else
        {
            return create(expression);
        }
    }

    private void text(Contact contact, Annotation annotation)
        throws Exception
    {
        Label label = LabelFactory.getInstance(contact, annotation, format);
        Expression expression = label.getExpression();
        String s = label.getPath();
        contact = root;
        if (!expression.isEmpty())
        {
            contact = register(expression);
        }
        if (texts.get(s) != null)
        {
            throw new TextException("Multiple text annotations in %s", new Object[] {
                annotation
            });
        } else
        {
            resolver.register(label);
            contact.register(label);
            texts.put(s, label);
            return;
        }
    }

    private void union(Contact contact, Annotation annotation, LabelMap labelmap)
        throws Exception
    {
        Annotation aannotation[] = extract(annotation);
        int j = aannotation.length;
        for (int i = 0; i < j; i++)
        {
            Label label = LabelFactory.getInstance(contact, annotation, aannotation[i], format);
            String s = label.getPath();
            String s1 = label.getName();
            if (labelmap.get(s) != null)
            {
                throw new PersistenceException("Duplicate annotation of name '%s' on %s", new Object[] {
                    s1, label
                });
            }
            process(contact, label, labelmap);
        }

    }

    private void validateAttributes(Class class1, Order order)
        throws Exception
    {
        if (order != null)
        {
            order = order.attributes();
            int j = order.length;
            for (int i = 0; i < j; i++)
            {
                String s = order[i];
                if (!isAttribute(s))
                {
                    throw new AttributeException("Ordered attribute '%s' missing in %s", new Object[] {
                        s, class1
                    });
                }
            }

        }
    }

    private void validateElements(Class class1, Order order)
        throws Exception
    {
        if (order != null)
        {
            order = order.elements();
            int j = order.length;
            for (int i = 0; i < j; i++)
            {
                String s = order[i];
                if (!isElement(s))
                {
                    throw new ElementException("Ordered element '%s' missing for %s", new Object[] {
                        s, class1
                    });
                }
            }

        }
    }

    private void validateModel(Class class1)
        throws Exception
    {
        if (!root.isEmpty())
        {
            root.validate(class1);
        }
    }

    private void validateText(Class class1)
        throws Exception
    {
        if (root.getText() != null)
        {
            if (!elements.isEmpty())
            {
                throw new TextException("Elements used with %s in %s", new Object[] {
                    text, class1
                });
            }
            if (root.isComposite())
            {
                throw new TextException("Paths used with %s in %s", new Object[] {
                    text, class1
                });
            }
        } else
        if (scanner.isEmpty())
        {
            primitive = isEmpty();
        }
    }

    private void validateUnions(Class class1)
        throws Exception
    {
        for (class1 = elements.iterator(); class1.hasNext();)
        {
            Label label = (Label)class1.next();
            String as[] = label.getPaths();
            Contact contact = label.getContact();
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                Object obj = as[i];
                Annotation annotation = contact.getAnnotation();
                obj = (Label)elements.get(obj);
                if (label.isInline() != ((Label) (obj)).isInline())
                {
                    throw new UnionException("Inline must be consistent in %s for %s", new Object[] {
                        annotation, contact
                    });
                }
                if (label.isRequired() != ((Label) (obj)).isRequired())
                {
                    throw new UnionException("Required must be consistent in %s for %s", new Object[] {
                        annotation, contact
                    });
                }
                i++;
            }
        }

    }

    private void version(Contact contact, Annotation annotation)
        throws Exception
    {
        contact = LabelFactory.getInstance(contact, annotation, format);
        if (version != null)
        {
            throw new AttributeException("Multiple version annotations in %s", new Object[] {
                annotation
            });
        } else
        {
            version = contact;
            return;
        }
    }

    public void assemble(Class class1)
        throws Exception
    {
        class1 = scanner.getOrder();
        if (class1 != null)
        {
            assembler.assemble(root, class1);
        }
    }

    public Structure build(Class class1)
        throws Exception
    {
        return new Structure(factory, root, version, text, primitive);
    }

    public void commit(Class class1)
        throws Exception
    {
        if (factory == null)
        {
            factory = resolver.build();
        }
    }

    public void process(Contact contact, Annotation annotation)
        throws Exception
    {
        if (annotation instanceof Attribute)
        {
            process(contact, annotation, attributes);
        }
        if (annotation instanceof ElementUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementListUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementMapUnion)
        {
            union(contact, annotation, elements);
        }
        if (annotation instanceof ElementList)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof ElementArray)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof ElementMap)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof Element)
        {
            process(contact, annotation, elements);
        }
        if (annotation instanceof Version)
        {
            version(contact, annotation);
        }
        if (annotation instanceof Text)
        {
            text(contact, annotation);
        }
    }

    public void validate(Class class1)
        throws Exception
    {
        Order order = scanner.getOrder();
        validateUnions(class1);
        validateElements(class1, order);
        validateAttributes(class1, order);
        validateModel(class1);
        validateText(class1);
    }
}
