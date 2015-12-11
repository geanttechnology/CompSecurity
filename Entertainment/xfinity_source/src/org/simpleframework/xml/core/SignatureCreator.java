// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.simpleframework.xml.core:
//            Creator, Signature, Parameter, Criteria, 
//            Variable, Support, Contact

class SignatureCreator
    implements Creator
{

    private final List list;
    private final Signature signature;
    private final Class type;

    public SignatureCreator(Signature signature1)
    {
        type = signature1.getType();
        list = signature1.getAll();
        signature = signature1;
    }

    private double getAdjustment(double d)
    {
        double d1 = (double)list.size() / 1000D;
        if (d > 0.0D)
        {
            return d / (double)list.size() + d1;
        } else
        {
            return d / (double)list.size();
        }
    }

    private double getPercentage(Criteria criteria)
        throws Exception
    {
        double d = 0.0D;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Parameter parameter = (Parameter)iterator.next();
            if (criteria.get(parameter.getKey()) == null)
            {
                if (parameter.isRequired())
                {
                    return -1D;
                }
                if (parameter.isPrimitive())
                {
                    return -1D;
                }
            } else
            {
                d++;
            }
        } while (true);
        return getAdjustment(d);
    }

    private Object getVariable(Criteria criteria, int i)
        throws Exception
    {
        criteria = criteria.remove(((Parameter)list.get(i)).getKey());
        if (criteria != null)
        {
            return criteria.getValue();
        } else
        {
            return null;
        }
    }

    public Object getInstance()
        throws Exception
    {
        return signature.create();
    }

    public Object getInstance(Criteria criteria)
        throws Exception
    {
        Object aobj[] = list.toArray();
        for (int i = 0; i < list.size(); i++)
        {
            aobj[i] = getVariable(criteria, i);
        }

        return signature.create(aobj);
    }

    public double getScore(Criteria criteria)
        throws Exception
    {
        Signature signature1 = signature.copy();
        for (Iterator iterator = criteria.iterator(); iterator.hasNext();)
        {
            Object obj = iterator.next();
            Parameter parameter = signature1.get(obj);
            obj = criteria.get(obj);
            Contact contact = ((Variable) (obj)).getContact();
            if (parameter != null && !Support.isAssignable(((Variable) (obj)).getValue().getClass(), parameter.getType()))
            {
                return -1D;
            }
            if (contact.isReadOnly() && parameter == null)
            {
                return -1D;
            }
        }

        return getPercentage(criteria);
    }

    public Signature getSignature()
    {
        return signature;
    }

    public Class getType()
    {
        return type;
    }

    public String toString()
    {
        return signature.toString();
    }
}
