// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Parameter, Signature, ConstructorException

class SignatureBuilder
{
    private static class ParameterList extends ArrayList
    {

        public ParameterList()
        {
        }

        public ParameterList(ParameterList parameterlist)
        {
            super(parameterlist);
        }
    }

    private static class ParameterTable extends ArrayList
    {

        private int height()
        {
            int i = 0;
            if (width() > 0)
            {
                i = get(0).size();
            }
            return i;
        }

        private int width()
        {
            return size();
        }

        public volatile Object get(int i)
        {
            return get(i);
        }

        public Parameter get(int i, int j)
        {
            return (Parameter)get(i).get(j);
        }

        public ParameterList get(int i)
        {
            for (int j = size(); j <= i; j++)
            {
                add(new ParameterList());
            }

            return (ParameterList)super.get(i);
        }

        public void insert(Parameter parameter, int i)
        {
            ParameterList parameterlist = get(i);
            if (parameterlist != null)
            {
                parameterlist.add(parameter);
            }
        }



        public ParameterTable()
        {
        }
    }


    private final Constructor factory;
    private final ParameterTable table = new ParameterTable();

    public SignatureBuilder(Constructor constructor)
    {
        factory = constructor;
    }

    private List build(ParameterTable parametertable)
        throws Exception
    {
        if (table.isEmpty())
        {
            return create();
        } else
        {
            build(parametertable, 0);
            return create(parametertable);
        }
    }

    private void build(ParameterTable parametertable, int i)
    {
        build(parametertable, new ParameterList(), i);
    }

    private void build(ParameterTable parametertable, ParameterList parameterlist, int i)
    {
        ParameterList parameterlist1 = table.get(i);
        int k = parameterlist1.size();
        if (table.width() - 1 > i)
        {
            for (int j = 0; j < k; j++)
            {
                ParameterList parameterlist2 = new ParameterList(parameterlist);
                if (parameterlist != null)
                {
                    parameterlist2.add((Parameter)parameterlist1.get(j));
                    build(parametertable, parameterlist2, i + 1);
                }
            }

        } else
        {
            populate(parametertable, parameterlist, i);
        }
    }

    private List create()
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        Signature signature = new Signature(factory);
        if (isValid())
        {
            arraylist.add(signature);
        }
        return arraylist;
    }

    private List create(ParameterTable parametertable)
        throws Exception
    {
        ArrayList arraylist = new ArrayList();
        int k = parametertable.height();
        int l = parametertable.width();
        for (int i = 0; i < k; i++)
        {
            Signature signature = new Signature(factory);
            for (int j = 0; j < l; j++)
            {
                Parameter parameter = parametertable.get(j, i);
                String s = parameter.getPath();
                if (signature.contains(parameter.getKey()))
                {
                    throw new ConstructorException("Parameter '%s' is a duplicate in %s", new Object[] {
                        s, factory
                    });
                }
                signature.add(parameter);
            }

            arraylist.add(signature);
        }

        return arraylist;
    }

    private void populate(ParameterTable parametertable, ParameterList parameterlist, int i)
    {
        ParameterList parameterlist1 = table.get(i);
        int l = parameterlist.size();
        int i1 = parameterlist1.size();
        for (int j = 0; j < i1; j++)
        {
            for (int k = 0; k < l; k++)
            {
                parametertable.get(k).add((Parameter)parameterlist.get(k));
            }

            parametertable.get(i).add((Parameter)parameterlist1.get(j));
        }

    }

    public List build()
        throws Exception
    {
        return build(new ParameterTable());
    }

    public void insert(Parameter parameter, int i)
    {
        table.insert(parameter, i);
    }

    public boolean isValid()
    {
        Class aclass[] = factory.getParameterTypes();
        int i = table.width();
        return aclass.length == i;
    }
}
