// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.Stack;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsTokener, DcsException, Expression, Operator

private final class <init>
{

    public final Stack expressions;
    public boolean lastReadOperator;
    public final Stack operators;
    final DcsTokener this$0;

    private Object createExpression(Object obj, Operator operator, Object obj1)
        throws DcsException
    {
        int i = Expression.getType(obj);
        int j = Expression.getType(obj1);
        if (i >= 1 && (i == j || i >= 3 && j >= 3))
        {
            if (i <= j)
            {
                i = j;
            }
            switch (.ebay.nautilus.domain.dcs.Operator[operator.ordinal()])
            {
            case 5: // '\005'
            default:
                throw new RuntimeException("Operator ! should have already been handled");

            case 1: // '\001'
            case 2: // '\002'
                return new init>(DcsTokener.access$100(DcsTokener.this, obj), DcsTokener.access$100(DcsTokener.this, obj1), operator);

            case 3: // '\003'
            case 4: // '\004'
                switch (i)
                {
                default:
                    throw syntaxError((new StringBuilder()).append("Type unknown for comparison ").append(i).toString());

                case 1: // '\001'
                    return new nit>(DcsTokener.access$200(DcsTokener.this, obj), DcsTokener.access$200(DcsTokener.this, obj1), operator);

                case 2: // '\002'
                    return new init>(DcsTokener.access$100(DcsTokener.this, obj), DcsTokener.access$100(DcsTokener.this, obj1), operator);

                case 3: // '\003'
                    return new >(DcsTokener.access$300(DcsTokener.this, obj), DcsTokener.access$300(DcsTokener.this, obj1), operator);

                case 4: // '\004'
                    return new t>(DcsTokener.access$400(DcsTokener.this, obj), DcsTokener.access$400(DcsTokener.this, obj1), operator);

                case 5: // '\005'
                    return new nit>(DcsTokener.access$500(DcsTokener.this, obj), DcsTokener.access$500(DcsTokener.this, obj1), operator);
                }

            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
                switch (i)
                {
                default:
                    obj1 = DcsTokener.this;
                    operator = (new StringBuilder()).append("Operation ").append(operator.symbol).append(" not allowed for ");
                    if (i == 1)
                    {
                        obj = "string";
                    } else
                    {
                        obj = "boolean";
                    }
                    throw ((DcsTokener) (obj1)).syntaxError(operator.append(((String) (obj))).toString());

                case 3: // '\003'
                    return new >(DcsTokener.access$300(DcsTokener.this, obj), DcsTokener.access$300(DcsTokener.this, obj1), operator);

                case 4: // '\004'
                    return new t>(DcsTokener.access$400(DcsTokener.this, obj), DcsTokener.access$400(DcsTokener.this, obj1), operator);

                case 5: // '\005'
                    return new nit>(DcsTokener.access$500(DcsTokener.this, obj), DcsTokener.access$500(DcsTokener.this, obj1), operator);
                }

            case 10: // '\n'
            case 11: // '\013'
                return new nit>(DcsTokener.access$200(DcsTokener.this, obj), DcsTokener.access$200(DcsTokener.this, obj1), operator);
            }
        } else
        {
            throw syntaxError("Type mismatch");
        }
    }

    public Object getExpression()
        throws DcsException
    {
        if (lastReadOperator)
        {
            if (expressions.isEmpty())
            {
                throw syntaxError("Empty expression");
            } else
            {
                throw syntaxError("Can't end an expression with an operator");
            }
        }
        Operator operator;
        Object obj;
        Object obj1;
        for (; !operators.isEmpty(); expressions.push(createExpression(obj1, operator, obj)))
        {
            operator = (Operator)operators.pop();
            obj = expressions.pop();
            obj1 = expressions.pop();
        }

        return expressions.peek();
    }

    public void pushExpression(Object obj)
        throws DcsException
    {
        boolean flag = false;
        if (!lastReadOperator)
        {
            throw syntaxError("Operator expected");
        }
        lastReadOperator = false;
        Object obj1 = obj;
        if (!operators.isEmpty())
        {
            obj1 = obj;
            if (operators.peek() == Operator.Not)
            {
                operators.pop();
                if (obj instanceof Boolean)
                {
                    if (!((Boolean)obj).booleanValue())
                    {
                        flag = true;
                    }
                    obj1 = Boolean.valueOf(flag);
                } else
                if (obj instanceof n)
                {
                    obj1 = new n((n)obj);
                } else
                {
                    throw syntaxError("Boolean expression expected");
                }
            }
        }
        expressions.push(obj1);
    }

    public void pushOperator(Operator operator)
        throws DcsException
    {
        if (operator == Operator.Not)
        {
            if (!lastReadOperator)
            {
                throw syntaxError("Operator expected");
            }
            if (!operators.empty() && operators.peek() == Operator.Not)
            {
                operators.pop();
                return;
            }
        } else
        if (lastReadOperator)
        {
            throw syntaxError((new StringBuilder()).append("Unexpected operator ").append(operator.symbol).toString());
        }
        lastReadOperator = true;
        Operator operator1;
        Object obj;
        Object obj1;
        for (; !operators.isEmpty() && ((Operator)operators.peek()).priority > operator.priority; expressions.push(createExpression(obj1, operator1, obj)))
        {
            operator1 = (Operator)operators.pop();
            obj = expressions.pop();
            obj1 = expressions.pop();
        }

        operators.push(operator);
    }

    private n()
    {
        this$0 = DcsTokener.this;
        super();
        lastReadOperator = true;
        expressions = new Stack();
        operators = new Stack();
    }

    operators(operators operators1)
    {
        this();
    }
}
