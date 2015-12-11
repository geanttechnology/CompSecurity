// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsException, Expression, Operator

class DcsTokener
{
    private static final class Case
    {

        public final Object condition;
        public final int type;
        public final Object value;

        public Case(Object obj, Object obj1)
        {
            condition = obj;
            value = obj1;
            type = Expression.getType(obj1);
        }
    }

    private final class ExpressionStack
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
                static class _cls1
                {

                    static final int $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[];

                    static 
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator = new int[Operator.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.And.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror10) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.Or.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror9) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.Equal.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.NotEqual.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.Not.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.LessThan.ordinal()] = 6;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.LessThanOrEqual.ordinal()] = 7;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.GreaterThan.ordinal()] = 8;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.GreaterThanOrEqual.ordinal()] = 9;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.RegexMatch.ordinal()] = 10;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.In.ordinal()] = 11;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                if (i <= j)
                {
                    i = j;
                }
                switch (_cls1..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[operator.ordinal()])
                {
                case 5: // '\005'
                default:
                    throw new RuntimeException("Operator ! should have already been handled");

                case 1: // '\001'
                case 2: // '\002'
                    return new Expression.CompareBoolean(toBooleanExp(obj), toBooleanExp(obj1), operator);

                case 3: // '\003'
                case 4: // '\004'
                    switch (i)
                    {
                    default:
                        throw syntaxError((new StringBuilder()).append("Type unknown for comparison ").append(i).toString());

                    case 1: // '\001'
                        return new Expression.CompareString(toStringExp(obj), toStringExp(obj1), operator);

                    case 2: // '\002'
                        return new Expression.CompareBoolean(toBooleanExp(obj), toBooleanExp(obj1), operator);

                    case 3: // '\003'
                        return new Expression.CompareInt(toIntExp(obj), toIntExp(obj1), operator);

                    case 4: // '\004'
                        return new Expression.CompareLong(toLongExp(obj), toLongExp(obj1), operator);

                    case 5: // '\005'
                        return new Expression.CompareDouble(toDoubleExp(obj), toDoubleExp(obj1), operator);
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
                        return new Expression.CompareInt(toIntExp(obj), toIntExp(obj1), operator);

                    case 4: // '\004'
                        return new Expression.CompareLong(toLongExp(obj), toLongExp(obj1), operator);

                    case 5: // '\005'
                        return new Expression.CompareDouble(toDoubleExp(obj), toDoubleExp(obj1), operator);
                    }

                case 10: // '\n'
                case 11: // '\013'
                    return new Expression.CompareString(toStringExp(obj), toStringExp(obj1), operator);
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
                    if (obj instanceof Expression.BooleanExpression)
                    {
                        obj1 = new Expression.Not((Expression.BooleanExpression)obj);
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

        private ExpressionStack()
        {
            this$0 = DcsTokener.this;
            super();
            lastReadOperator = true;
            expressions = new Stack();
            operators = new Stack();
        }

    }


    private final String in;
    private int pos;

    private DcsTokener(String s)
    {
        in = s;
    }

    private Expression.SwitchBoolean createBooleanSwitch(List list)
        throws DcsException
    {
        ArrayList arraylist = new ArrayList(list.size());
        Case case1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(newSwitchEntry(case1.condition, toBooleanExp(case1.value))))
        {
            case1 = (Case)list.next();
        }

        return new Expression.SwitchBoolean(arraylist);
    }

    private Expression.SwitchDouble createDoubleSwitch(List list)
        throws DcsException
    {
        ArrayList arraylist = new ArrayList(list.size());
        Case case1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(newSwitchEntry(case1.condition, toDoubleExp(case1.value))))
        {
            case1 = (Case)list.next();
        }

        return new Expression.SwitchDouble(arraylist);
    }

    private Expression.SwitchInt createIntSwitch(List list)
        throws DcsException
    {
        ArrayList arraylist = new ArrayList(list.size());
        Case case1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(newSwitchEntry(case1.condition, toIntExp(case1.value))))
        {
            case1 = (Case)list.next();
        }

        return new Expression.SwitchInt(arraylist);
    }

    private Expression.SwitchLong createLongSwitch(List list)
        throws DcsException
    {
        ArrayList arraylist = new ArrayList(list.size());
        Case case1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(newSwitchEntry(case1.condition, toLongExp(case1.value))))
        {
            case1 = (Case)list.next();
        }

        return new Expression.SwitchLong(arraylist);
    }

    private Expression.SwitchString createStringSwitch(List list)
        throws DcsException
    {
        ArrayList arraylist = new ArrayList(list.size());
        Case case1;
        for (list = list.iterator(); list.hasNext(); arraylist.add(newSwitchEntry(case1.condition, toStringExp(case1.value))))
        {
            case1 = (Case)list.next();
        }

        return new Expression.SwitchString(arraylist);
    }

    public static Object getExpression(String s)
        throws DcsException
    {
        s = new DcsTokener(s);
        Object obj = s.readExpression();
        if (s.nextCleanInternal() != -1)
        {
            throw new DcsException((new StringBuilder()).append("Found invalid character at the end").append(s).toString());
        } else
        {
            return obj;
        }
    }

    private Expression.Switch.Entry newSwitchEntry(Object obj, Object obj1)
        throws DcsException
    {
        if (obj == null)
        {
            obj = Expression.True;
        } else
        {
            obj = toBooleanExp(obj);
        }
        return new Expression.Switch.Entry(((Expression.BooleanExpression) (obj)), obj1);
    }

    private int nextCleanInternal()
        throws DcsException
    {
_L9:
        if (pos >= in.length()) goto _L2; else goto _L1
_L1:
        int i;
        String s = in;
        i = pos;
        pos = i + 1;
        i = s.charAt(i);
        i;
        JVM INSTR lookupswitch 6: default 96
    //                   9: 0
    //                   10: 0
    //                   13: 0
    //                   32: 0
    //                   35: 214
    //                   47: 98;
           goto _L3 _L4 _L4 _L4 _L4 _L5 _L6
_L4:
        continue; /* Loop/switch isn't completed */
_L3:
        return i;
_L6:
        if (pos == in.length()) goto _L3; else goto _L7
_L7:
        switch (in.charAt(pos))
        {
        default:
            return i;

        case 42: // '*'
            String s1 = in;
            int j = pos + 1;
            pos = j;
            j = s1.indexOf("*/", j);
            if (j == -1)
            {
                throw syntaxError("Unterminated comment");
            }
            pos = j + 2;
            break;

        case 47: // '/'
            pos = pos + 1;
            skipToEndOfLine();
            break;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        skipToEndOfLine();
        continue; /* Loop/switch isn't completed */
_L2:
        return -1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private String nextString(char c)
        throws DcsException
    {
        StringBuilder stringbuilder = null;
        int i = pos;
        int j = in.length();
        do
        {
            if (pos >= j)
            {
                break;
            }
            String s = in;
            int k = pos;
            pos = k + 1;
            k = s.charAt(k);
            if (k == c)
            {
                if (stringbuilder == null)
                {
                    return in.substring(i, pos - 1);
                } else
                {
                    return stringbuilder.append(in, i, pos - 1).toString();
                }
            }
            if (k == '\\')
            {
                if (pos == j)
                {
                    throw syntaxError("Unterminated escape sequence");
                }
                StringBuilder stringbuilder1 = stringbuilder;
                if (stringbuilder == null)
                {
                    stringbuilder1 = new StringBuilder();
                }
                stringbuilder1.append(in, i, pos - 1);
                stringbuilder1.append(readEscapeCharacter());
                i = pos;
                stringbuilder = stringbuilder1;
            }
        } while (true);
        throw syntaxError("Unterminated string");
    }

    private String nextToInternal()
    {
        int i = pos;
        do
        {
            if (pos >= in.length())
            {
                break;
            }
            switch (in.charAt(pos))
            {
            default:
                pos = pos + 1;
                break;

            case 9: // '\t'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 32: // ' '
            case 33: // '!'
            case 35: // '#'
            case 36: // '$'
            case 38: // '&'
            case 40: // '('
            case 41: // ')'
            case 44: // ','
            case 47: // '/'
            case 58: // ':'
            case 59: // ';'
            case 60: // '<'
            case 61: // '='
            case 62: // '>'
            case 91: // '['
            case 92: // '\\'
            case 93: // ']'
            case 123: // '{'
            case 124: // '|'
            case 125: // '}'
                return in.substring(i, pos);
            }
        } while (true);
        return in.substring(i);
    }

    private Case readCase()
        throws DcsException
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj1 = null;
        obj = readExpression();
        switch (nextCleanInternal())
        {
        default:
            throw syntaxError("Invalid switch");

        case 44: // ','
        case 125: // '}'
            break MISSING_BLOCK_LABEL_98;

        case 58: // ':'
            if (Expression.getType(obj) != 2)
            {
                throw syntaxError("The left side of ':' statement must evaluate to a boolean condition");
            }
            obj2 = readExpression();
            obj1 = obj;
            break;
        }
_L1:
        obj = new Case(obj1, obj2);
        if (((Case) (obj)).type == -1)
        {
            throw syntaxError("Invalid expression");
        } else
        {
            return ((Case) (obj));
        }
        pos = pos - 1;
        obj2 = obj;
          goto _L1
    }

    private char readEscapeCharacter()
        throws DcsException
    {
        String s = in;
        int i = pos;
        pos = i + 1;
        char c = s.charAt(i);
        switch (c)
        {
        default:
            return c;

        case 117: // 'u'
            if (pos + 4 > in.length())
            {
                throw syntaxError("Unterminated escape sequence");
            }
            char c1;
            try
            {
                c1 = (char)Integer.parseInt(in.substring(pos, pos + 4), 16);
                pos = pos + 4;
            }
            catch (NumberFormatException numberformatexception)
            {
                throw syntaxError(numberformatexception.getMessage());
            }
            return c1;

        case 116: // 't'
            return '\t';

        case 98: // 'b'
            return '\b';

        case 110: // 'n'
            return '\n';

        case 114: // 'r'
            return '\r';

        case 102: // 'f'
            return '\f';
        }
    }

    private Object readExpression()
        throws DcsException
    {
        int i = nextCleanInternal();
        if (i == -1)
        {
            return null;
        }
        boolean flag = true;
        ExpressionStack expressionstack = new ExpressionStack(null);
        do
        {
            if (flag)
            {
                switch (i)
                {
                default:
                    pos = pos - 1;
                    expressionstack.pushExpression(readLiteral());
                    i = nextCleanInternal();
                    break;

                case -1: 
                    flag = false;
                    break;

                case 41: // ')'
                case 44: // ','
                case 58: // ':'
                case 125: // '}'
                    pos = pos - 1;
                    flag = false;
                    break;

                case 123: // '{'
                    expressionstack.pushExpression(readSwitch());
                    i = nextCleanInternal();
                    break;

                case 40: // '('
                    expressionstack.pushExpression(readExpression());
                    if (nextCleanInternal() != 41)
                    {
                        throw syntaxError("Missing closing ')'");
                    }
                    i = nextCleanInternal();
                    break;

                case 36: // '$'
                    expressionstack.pushExpression(readVar());
                    i = nextCleanInternal();
                    break;

                case 34: // '"'
                case 39: // '\''
                    expressionstack.pushExpression(nextString((char)i));
                    i = nextCleanInternal();
                    break;

                case 33: // '!'
                case 38: // '&'
                case 60: // '<'
                case 61: // '='
                case 62: // '>'
                case 73: // 'I'
                case 105: // 'i'
                case 124: // '|'
                    expressionstack.pushOperator(readOperator((char)i));
                    i = nextCleanInternal();
                    break;
                }
            } else
            {
                return expressionstack.getExpression();
            }
        } while (true);
    }

    private Object readLiteral()
        throws DcsException
    {
        String s1;
        String s2;
        byte byte0;
        s2 = nextToInternal();
        if (s2.length() == 0)
        {
            throw syntaxError("Expected literal value");
        }
        if ("null".equalsIgnoreCase(s2))
        {
            return null;
        }
        if ("true".equalsIgnoreCase(s2) || "enabled".equalsIgnoreCase(s2))
        {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(s2) || "disabled".equalsIgnoreCase(s2))
        {
            return Boolean.FALSE;
        }
        if (s2.indexOf('.') != -1)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        byte0 = 10;
        s1 = s2;
        if (!s1.startsWith("0x") && !s1.startsWith("0X")) goto _L2; else goto _L1
_L1:
        String s;
        int i;
        s = s1.substring(2);
        i = 16;
_L4:
        long l = Long.parseLong(s, i);
        if (l <= 0x7fffffffL && l >= 0xffffffff80000000L)
        {
            i = (int)l;
            return Integer.valueOf(i);
        } else
        {
            return Long.valueOf(l);
        }
_L2:
        i = byte0;
        s = s1;
        if (s1.startsWith("0"))
        {
            i = byte0;
            s = s1;
            if (s1.length() > 1)
            {
                s = s1.substring(1);
                i = 8;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        NumberFormatException numberformatexception;
        numberformatexception;
        Double double1;
        try
        {
            double1 = Double.valueOf(s2);
        }
        catch (NumberFormatException numberformatexception1)
        {
            throw syntaxError("Unquoted string");
        }
        return double1;
    }

    private Operator readOperator(char c)
        throws DcsException
    {
        c;
        JVM INSTR lookupswitch 8: default 76
    //                   33: 149
    //                   38: 293
    //                   60: 197
    //                   61: 101
    //                   62: 245
    //                   73: 301
    //                   105: 301
    //                   124: 297;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L8
_L1:
        throw syntaxError((new StringBuilder()).append("Unknown operator ").append(c).toString());
_L5:
        if (pos < in.length() && in.charAt(pos) == '~')
        {
            pos = pos + 1;
            return Operator.RegexMatch;
        } else
        {
            return Operator.Equal;
        }
_L2:
        if (pos < in.length() && in.charAt(pos) == '=')
        {
            pos = pos + 1;
            return Operator.NotEqual;
        } else
        {
            return Operator.Not;
        }
_L4:
        if (pos < in.length() && in.charAt(pos) == '=')
        {
            pos = pos + 1;
            return Operator.LessThanOrEqual;
        } else
        {
            return Operator.LessThan;
        }
_L6:
        if (pos < in.length() && in.charAt(pos) == '=')
        {
            pos = pos + 1;
            return Operator.GreaterThanOrEqual;
        } else
        {
            return Operator.GreaterThan;
        }
_L3:
        return Operator.And;
_L8:
        return Operator.Or;
_L7:
        if (pos < in.length() || in.charAt(pos) == 'n' || in.charAt(pos) == 'N')
        {
            pos = pos + 1;
            return Operator.In;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    private List readStatement()
        throws DcsException
    {
        ArrayList arraylist;
        int i;
        int k;
        i = 0;
        arraylist = new ArrayList();
        k = 44;
_L2:
        Case case1;
        int j;
        if (k != 44)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        case1 = readCase();
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = case1.type;
_L4:
        arraylist.add(case1);
        k = nextCleanInternal();
        i = j;
        if (true) goto _L2; else goto _L1
_L1:
        j = i;
        if (i == case1.type) goto _L4; else goto _L3
_L3:
        if (i < 3)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        if (case1.type >= 3) goto _L4; else goto _L5
_L5:
        throw syntaxError("Values in a switch must be of the same type");
        if (k != -1)
        {
            pos = pos - 1;
        }
        return arraylist;
    }

    private Object readSwitch()
        throws DcsException
    {
        List list = readStatement();
        if (nextCleanInternal() != 125)
        {
            throw syntaxError("Switch not terminated");
        }
        int i = 0;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Case case1 = (Case)iterator.next();
            if (i < case1.type)
            {
                i = case1.type;
            }
        } while (true);
        switch (i)
        {
        default:
            throw syntaxError("Unexpected type");

        case 2: // '\002'
            return createBooleanSwitch(list);

        case 1: // '\001'
            return createStringSwitch(list);

        case 3: // '\003'
            return createIntSwitch(list);

        case 4: // '\004'
            return createLongSwitch(list);

        case 5: // '\005'
            return createDoubleSwitch(list);
        }
    }

    private Object readVar()
        throws DcsException
    {
label0:
        {
            if (pos < in.length())
            {
                String s = in;
                int i = pos;
                pos = i + 1;
                if (s.charAt(i) == '{')
                {
                    break label0;
                }
            }
            throw syntaxError("Invalid variable");
        }
        String s1 = nextToInternal();
        Object obj = Expression.variables.get(s1);
        if (obj == null)
        {
            throw syntaxError((new StringBuilder()).append("Unknown variable ").append(s1).toString());
        }
        if (nextCleanInternal() != 125)
        {
            throw syntaxError("Unterminated variable");
        } else
        {
            return obj;
        }
    }

    private void skipToEndOfLine()
    {
        int i;
        do
        {
            if (pos >= in.length())
            {
                break;
            }
            String s = in;
            i = pos;
            pos = i + 1;
            i = s.charAt(i);
        } while (i != '\r' && i != '\n');
    }

    private Expression.BooleanExpression toBooleanExp(Object obj)
        throws DcsException
    {
        if (obj instanceof Expression.BooleanExpression)
        {
            return (Expression.BooleanExpression)obj;
        }
        if (obj instanceof Boolean)
        {
            if (((Boolean)obj).booleanValue())
            {
                obj = Expression.True;
            } else
            {
                obj = Expression.False;
            }
            return ((Expression.BooleanExpression) (obj));
        } else
        {
            throw new DcsException("Not a boolean expression");
        }
    }

    private Expression.DoubleExpression toDoubleExp(Object obj)
        throws DcsException
    {
        if (obj instanceof Expression.DoubleExpression)
        {
            return (Expression.DoubleExpression)obj;
        }
        if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof Integer))
        {
            return new Expression.ConstDouble(((Number)obj).doubleValue());
        }
        if (obj instanceof Expression.IntExpression)
        {
            return new Expression.DoubleIntExpression((Expression.IntExpression)obj);
        }
        if (obj instanceof Expression.LongExpression)
        {
            return new Expression.DoubleLongExpression((Expression.LongExpression)obj);
        } else
        {
            throw new DcsException("Not a double expression");
        }
    }

    private Expression.IntExpression toIntExp(Object obj)
        throws DcsException
    {
        if (obj instanceof Expression.IntExpression)
        {
            return (Expression.IntExpression)obj;
        }
        if (obj instanceof Integer)
        {
            return new Expression.ConstInt(((Integer)obj).intValue());
        } else
        {
            throw new DcsException("Not an int expression");
        }
    }

    private Expression.LongExpression toLongExp(Object obj)
        throws DcsException
    {
        if (obj instanceof Expression.LongExpression)
        {
            return (Expression.LongExpression)obj;
        }
        if ((obj instanceof Long) || (obj instanceof Integer))
        {
            return new Expression.ConstLong(((Number)obj).longValue());
        }
        if (obj instanceof Expression.IntExpression)
        {
            return new Expression.LongIntExpression((Expression.IntExpression)obj);
        } else
        {
            throw new DcsException("Not a long expression");
        }
    }

    private Expression.StringExpression toStringExp(Object obj)
        throws DcsException
    {
        if (obj == null)
        {
            return Expression.Null;
        }
        if (obj instanceof Expression.StringExpression)
        {
            return (Expression.StringExpression)obj;
        }
        if (obj instanceof String)
        {
            return new Expression.ConstString((String)obj);
        } else
        {
            throw new DcsException("Not a string expression");
        }
    }

    final DcsException syntaxError(String s)
    {
        return new DcsException((new StringBuilder()).append(s).append(this).toString());
    }

    public String toString()
    {
        return (new StringBuilder()).append(" at character ").append(pos).append(" of ").append(in).toString();
    }





}
