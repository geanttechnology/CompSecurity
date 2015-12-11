// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Comparer, LabelMap, SignatureCreator, Scanner, 
//            ClassInstantiator, CacheParameter, Signature, Parameter, 
//            Label, ParameterMap, ConstructorException, Creator, 
//            Contact, Instantiator, Support

class InstantiatorBuilder
{

    private LabelMap attributes;
    private Comparer comparer;
    private LabelMap elements;
    private Instantiator factory;
    private List options;
    private Scanner scanner;
    private LabelMap texts;
    private Class type;

    public InstantiatorBuilder(Scanner scanner1, Class class1)
    {
        options = new ArrayList();
        comparer = new Comparer();
        attributes = new LabelMap();
        elements = new LabelMap();
        texts = new LabelMap();
        scanner = scanner1;
        type = class1;
    }

    private Instantiator build(Class class1)
        throws Exception
    {
        if (factory == null)
        {
            factory = create(class1);
        }
        return factory;
    }

    private boolean contains(String as[], String s)
        throws Exception
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            for (String s1 = as[i]; s1 == s || s1.equals(s);)
            {
                return true;
            }

        }

        return false;
    }

    private Creator create(Signature signature)
    {
        SignatureCreator signaturecreator = new SignatureCreator(signature);
        if (signature != null)
        {
            options.add(signaturecreator);
        }
        return signaturecreator;
    }

    private Instantiator create(Class class1)
        throws Exception
    {
        Signature signature = scanner.getSignature();
        ParameterMap parametermap = scanner.getParameters();
        SignatureCreator signaturecreator = null;
        if (signature != null)
        {
            signaturecreator = new SignatureCreator(signature);
        }
        return new ClassInstantiator(options, signaturecreator, parametermap, class1);
    }

    private Parameter create(Parameter parameter)
        throws Exception
    {
        Label label = resolve(parameter);
        if (label != null)
        {
            return new CacheParameter(parameter, label);
        } else
        {
            return null;
        }
    }

    private void populate(Class class1)
        throws Exception
    {
        for (class1 = scanner.getSignatures().iterator(); class1.hasNext(); populate((Signature)class1.next())) { }
    }

    private void populate(Signature signature)
        throws Exception
    {
        Signature signature1 = new Signature(signature);
        signature = signature.iterator();
        do
        {
            if (!signature.hasNext())
            {
                break;
            }
            Parameter parameter = create((Parameter)signature.next());
            if (parameter != null)
            {
                signature1.add(parameter);
            }
        } while (true);
        create(signature1);
    }

    private void register(Label label, LabelMap labelmap)
        throws Exception
    {
        String s = label.getName();
        String s1 = label.getPath();
        if (labelmap.containsKey(s))
        {
            if (!((Label)labelmap.get(s)).getPath().equals(s))
            {
                labelmap.remove(s);
            }
        } else
        {
            labelmap.put(s, label);
        }
        labelmap.put(s1, label);
    }

    private Label resolve(Parameter parameter)
        throws Exception
    {
        if (parameter.isAttribute())
        {
            return resolve(parameter, attributes);
        }
        if (parameter.isText())
        {
            return resolve(parameter, texts);
        } else
        {
            return resolve(parameter, elements);
        }
    }

    private Label resolve(Parameter parameter, LabelMap labelmap)
        throws Exception
    {
        String s = parameter.getName();
        parameter = (Label)labelmap.get(parameter.getPath());
        if (parameter == null)
        {
            return (Label)labelmap.get(s);
        } else
        {
            return parameter;
        }
    }

    private void validate(Class class1)
        throws Exception
    {
        Parameter parameter;
        Label label;
        for (Iterator iterator = scanner.getParameters().getAll().iterator(); iterator.hasNext(); validateParameter(label, parameter))
        {
            parameter = (Parameter)iterator.next();
            label = resolve(parameter);
            String s = parameter.getPath();
            if (label == null)
            {
                throw new ConstructorException("Parameter '%s' does not have a match in %s", new Object[] {
                    s, class1
                });
            }
        }

        validateConstructors();
    }

    private void validateAnnotations(Label label, Parameter parameter)
        throws Exception
    {
        Object obj1 = label.getAnnotation();
        Object obj = parameter.getAnnotation();
        label = parameter.getName();
        if (!comparer.equals(((Annotation) (obj1)), ((Annotation) (obj))))
        {
            obj1 = ((Annotation) (obj1)).annotationType();
            obj = ((Annotation) (obj)).annotationType();
            if (!obj1.equals(obj))
            {
                throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", new Object[] {
                    obj, obj1, label, parameter
                });
            }
        }
    }

    private void validateConstructor(Label label, List list)
        throws Exception
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Signature signature = ((Creator)list.next()).getSignature();
            Contact contact = label.getContact();
            Object obj = label.getKey();
            if (contact.isReadOnly() && signature.get(obj) == null)
            {
                list.remove();
            }
        } while (true);
    }

    private void validateConstructors()
        throws Exception
    {
        List list = factory.getCreators();
        if (factory.isDefault())
        {
            validateConstructors(elements);
            validateConstructors(attributes);
        }
        if (!list.isEmpty())
        {
            validateConstructors(elements, list);
            validateConstructors(attributes, list);
        }
    }

    private void validateConstructors(LabelMap labelmap)
        throws Exception
    {
        for (labelmap = labelmap.iterator(); labelmap.hasNext();)
        {
            Label label = (Label)labelmap.next();
            if (label != null && label.getContact().isReadOnly())
            {
                throw new ConstructorException("Default constructor can not accept read only %s in %s", new Object[] {
                    label, type
                });
            }
        }

    }

    private void validateConstructors(LabelMap labelmap, List list)
        throws Exception
    {
        labelmap = labelmap.iterator();
        do
        {
            if (!labelmap.hasNext())
            {
                break;
            }
            Label label = (Label)labelmap.next();
            if (label != null)
            {
                validateConstructor(label, list);
            }
        } while (true);
        if (list.isEmpty())
        {
            throw new ConstructorException("No constructor accepts all read only values in %s", new Object[] {
                type
            });
        } else
        {
            return;
        }
    }

    private void validateNames(Label label, Parameter parameter)
        throws Exception
    {
        String as[] = label.getNames();
        String s = parameter.getName();
        if (!contains(as, s))
        {
            String s1 = label.getName();
            if (s != s1)
            {
                if (s == null || s1 == null)
                {
                    throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] {
                        label, s, parameter
                    });
                }
                if (!s.equals(s1))
                {
                    throw new ConstructorException("Annotation does not match %s for '%s' in %s", new Object[] {
                        label, s, parameter
                    });
                }
            }
        }
    }

    private void validateParameter(Label label, Parameter parameter)
        throws Exception
    {
        Contact contact = label.getContact();
        String s = parameter.getName();
        if (!Support.isAssignable(parameter.getType(), contact.getType()))
        {
            throw new ConstructorException("Type is not compatible with %s for '%s' in %s", new Object[] {
                label, s, parameter
            });
        } else
        {
            validateNames(label, parameter);
            validateAnnotations(label, parameter);
            return;
        }
    }

    public Instantiator build()
        throws Exception
    {
        if (factory == null)
        {
            populate(type);
            build(type);
            validate(type);
        }
        return factory;
    }

    public void register(Label label)
        throws Exception
    {
        if (label.isAttribute())
        {
            register(label, attributes);
            return;
        }
        if (label.isText())
        {
            register(label, texts);
            return;
        } else
        {
            register(label, elements);
            return;
        }
    }
}
