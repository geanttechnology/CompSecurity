// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsException, DcsState, Operator, DcsUtil

final class Expression
{
    public static interface BooleanExpression
        extends Validator
    {

        public abstract boolean eval(DcsState dcsstate)
            throws DcsException;
    }

    static final class CompareBoolean extends CompareExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            boolean flag;
            boolean flag1;
            flag = true;
            flag1 = false;
            static class _cls11
            {

                static final int $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[];

                static 
                {
                    $SwitchMap$com$ebay$nautilus$domain$dcs$Operator = new int[Operator.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.Equal.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror9) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.NotEqual.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror8) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.RegexMatch.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror7) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.In.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror6) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.LessThan.ordinal()] = 5;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.LessThanOrEqual.ordinal()] = 6;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.GreaterThan.ordinal()] = 7;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.GreaterThanOrEqual.ordinal()] = 8;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.And.ordinal()] = 9;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$nautilus$domain$dcs$Operator[Operator.Or.ordinal()] = 10;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
            JVM INSTR lookupswitch 4: default 56
        //                       1: 94
        //                       2: 132
        //                       9: 163
        //                       10: 197;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for Boolean comparison!").toString());
_L2:
            if (((BooleanExpression)left).eval(dcsstate) == ((BooleanExpression)right).eval(dcsstate))
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L7:
            return flag;
_L3:
            if (((BooleanExpression)left).eval(dcsstate) != ((BooleanExpression)right).eval(dcsstate)) goto _L7; else goto _L6
_L6:
            return false;
_L4:
            if (((BooleanExpression)left).eval(dcsstate) && ((BooleanExpression)right).eval(dcsstate)) goto _L7; else goto _L8
_L8:
            return false;
_L5:
            if (((BooleanExpression)left).eval(dcsstate)) goto _L10; else goto _L9
_L9:
            flag = flag1;
            if (!((BooleanExpression)right).eval(dcsstate)) goto _L11; else goto _L10
_L10:
            flag = true;
_L11:
            return flag;
        }

        public CompareBoolean(BooleanExpression booleanexpression, BooleanExpression booleanexpression1, Operator operator)
        {
            super(booleanexpression, booleanexpression1, operator);
        }
    }

    static final class CompareDouble extends CompareExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            boolean flag = true;
            _cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
            JVM INSTR tableswitch 1 8: default 60
        //                       1 98
        //                       2 137
        //                       3 60
        //                       4 60
        //                       5 169
        //                       6 201
        //                       7 233
        //                       8 265;
               goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
            throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for numeric comparison!").toString());
_L2:
            if (((DoubleExpression)left).eval(dcsstate) == ((DoubleExpression)right).eval(dcsstate))
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L9:
            return flag;
_L3:
            if (((DoubleExpression)left).eval(dcsstate) == ((DoubleExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (((DoubleExpression)left).eval(dcsstate) >= ((DoubleExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (((DoubleExpression)left).eval(dcsstate) > ((DoubleExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (((DoubleExpression)left).eval(dcsstate) <= ((DoubleExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (((DoubleExpression)left).eval(dcsstate) < ((DoubleExpression)right).eval(dcsstate))
            {
                return false;
            }
            if (true) goto _L9; else goto _L8
_L8:
        }

        public CompareDouble(DoubleExpression doubleexpression, DoubleExpression doubleexpression1, Operator operator)
        {
            super(doubleexpression, doubleexpression1, operator);
        }
    }

    static abstract class CompareExpression
        implements Validator
    {

        protected final Validator left;
        protected final Operator op;
        protected final Validator right;

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
            left.validate(dcsutil);
            right.validate(dcsutil);
        }

        public CompareExpression(Validator validator, Validator validator1, Operator operator)
        {
            left = validator;
            right = validator1;
            op = operator;
        }
    }

    static final class CompareInt extends CompareExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            boolean flag = true;
            _cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
            JVM INSTR tableswitch 1 8: default 60
        //                       1 98
        //                       2 136
        //                       3 60
        //                       4 60
        //                       5 167
        //                       6 198
        //                       7 229
        //                       8 260;
               goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
            throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for numeric comparison!").toString());
_L2:
            if (((IntExpression)left).eval(dcsstate) == ((IntExpression)right).eval(dcsstate))
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L9:
            return flag;
_L3:
            if (((IntExpression)left).eval(dcsstate) == ((IntExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (((IntExpression)left).eval(dcsstate) >= ((IntExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (((IntExpression)left).eval(dcsstate) > ((IntExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (((IntExpression)left).eval(dcsstate) <= ((IntExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (((IntExpression)left).eval(dcsstate) < ((IntExpression)right).eval(dcsstate))
            {
                return false;
            }
            if (true) goto _L9; else goto _L8
_L8:
        }

        public CompareInt(IntExpression intexpression, IntExpression intexpression1, Operator operator)
        {
            super(intexpression, intexpression1, operator);
        }
    }

    static final class CompareLong extends CompareExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            boolean flag = true;
            _cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
            JVM INSTR tableswitch 1 8: default 60
        //                       1 98
        //                       2 137
        //                       3 60
        //                       4 60
        //                       5 169
        //                       6 201
        //                       7 233
        //                       8 265;
               goto _L1 _L2 _L3 _L1 _L1 _L4 _L5 _L6 _L7
_L1:
            throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for numeric comparison!").toString());
_L2:
            if (((LongExpression)left).eval(dcsstate) == ((LongExpression)right).eval(dcsstate))
            {
                flag = true;
            } else
            {
                flag = false;
            }
_L9:
            return flag;
_L3:
            if (((LongExpression)left).eval(dcsstate) == ((LongExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (((LongExpression)left).eval(dcsstate) >= ((LongExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (((LongExpression)left).eval(dcsstate) > ((LongExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (((LongExpression)left).eval(dcsstate) <= ((LongExpression)right).eval(dcsstate))
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
_L7:
            if (((LongExpression)left).eval(dcsstate) < ((LongExpression)right).eval(dcsstate))
            {
                return false;
            }
            if (true) goto _L9; else goto _L8
_L8:
        }

        public CompareLong(LongExpression longexpression, LongExpression longexpression1, Operator operator)
        {
            super(longexpression, longexpression1, operator);
        }
    }

    static final class CompareString extends CompareExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            boolean flag = true;
            String s = ((StringExpression)left).eval(dcsstate);
            dcsstate = ((StringExpression)right).eval(dcsstate);
            switch (_cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()])
            {
            default:
                throw new DcsException((new StringBuilder()).append("Operation '").append(op.symbol).append("' not valid for string comparison!").toString());

            case 1: // '\001'
                return TextUtils.equals(s, dcsstate);

            case 2: // '\002'
                return !TextUtils.equals(s, dcsstate);

            case 3: // '\003'
                if (s == null || !s.matches(dcsstate))
                {
                    flag = false;
                }
                return flag;

            case 4: // '\004'
                break;
            }
            if (s == null || dcsstate == null)
            {
                return false;
            }
            if (dcsstate.indexOf(',') == -1)
            {
                return dcsstate.equals(s);
            } else
            {
                return Arrays.asList(dcsstate.split("\\s*,\\s*")).contains(s);
            }
        }

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
            String s;
            StringExpression stringexpression;
            super.validate(dcsutil);
            if ((left instanceof VarExpression) && (right instanceof ConstExpression))
            {
                stringexpression = (StringExpression)left;
                s = ((StringExpression)right).eval(null);
            } else
            if ((left instanceof ConstExpression) && (right instanceof VarExpression))
            {
                stringexpression = (StringExpression)right;
                s = ((StringExpression)left).eval(null);
            } else
            {
                stringexpression = null;
                s = null;
            }
            if (stringexpression == null || s == null) goto _L2; else goto _L1
_L1:
            dcsutil = new ValidateHelper(dcsutil);
            if (!dcsutil.needsValidation(stringexpression)) goto _L2; else goto _L3
_L3:
            _cls11..SwitchMap.com.ebay.nautilus.domain.dcs.Operator[op.ordinal()];
            JVM INSTR tableswitch 1 4: default 116
        //                       1 169
        //                       2 169
        //                       3 116
        //                       4 224;
               goto _L2 _L4 _L4 _L2 _L5
_L2:
            return;
_L4:
            if (s.indexOf(',') != -1)
            {
                throw new DcsException((new StringBuilder()).append("Did you intend to use 'in' instead of '").append(op.symbol).append("'?").toString());
            } else
            {
                dcsutil.validate(stringexpression, s);
                return;
            }
_L5:
            if (s.indexOf(',') == -1)
            {
                dcsutil.validate(stringexpression, s);
                return;
            }
            String as[] = s.split("\\s*,\\s*");
            int j = as.length;
            int i = 0;
            while (i < j) 
            {
                dcsutil.validate(stringexpression, as[i]);
                i++;
            }
            if (true) goto _L2; else goto _L6
_L6:
        }

        public CompareString(StringExpression stringexpression, StringExpression stringexpression1, Operator operator)
        {
            super(stringexpression, stringexpression1, operator);
        }
    }

    final class CompareString.ValidateHelper
    {

        final Object localeCountry;
        final Object localeLanguage;
        final Object prefCountry;
        final Object prefLanguage;
        final CompareString this$0;
        final Object user;
        final DcsUtil validation;

        boolean needsValidation(StringExpression stringexpression)
        {
            return stringexpression == prefCountry || stringexpression == prefLanguage || stringexpression == localeCountry || stringexpression == localeLanguage || stringexpression == user;
        }

        void validate(StringExpression stringexpression, String s)
            throws DcsException
        {
            if (stringexpression == prefCountry || stringexpression == localeCountry)
            {
                if (s.length() != 2 || s.charAt(0) < 'A' || s.charAt(0) > 'Z' || s.charAt(1) < 'A' || s.charAt(1) > 'Z')
                {
                    throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
                }
                if (stringexpression == prefCountry && !validation.prefCountryCodes.contains(s))
                {
                    throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
                }
            } else
            if ((stringexpression == prefLanguage || stringexpression == localeLanguage) && (s.length() != 2 || s.charAt(0) < 'a' || s.charAt(0) > 'z' || s.charAt(1) < 'a' || s.charAt(1) > 'z'))
            {
                throw new DcsException((new StringBuilder()).append("Invalid country code '").append(s).append('\'').toString());
            }
        }

        public CompareString.ValidateHelper(DcsUtil dcsutil)
        {
            this$0 = CompareString.this;
            super();
            prefCountry = Expression.variables.get("prefCountry");
            prefLanguage = Expression.variables.get("prefLanguage");
            localeCountry = Expression.variables.get("localeCountry");
            localeLanguage = Expression.variables.get("localeLanguage");
            user = Expression.variables.get("user");
            validation = dcsutil;
        }
    }

    static abstract class ConstBoolean extends ConstExpression
        implements BooleanExpression
    {

        ConstBoolean()
        {
        }
    }

    static final class ConstDouble extends ConstExpression
        implements DoubleExpression
    {

        private final double value;

        public double eval(DcsState dcsstate)
        {
            return value;
        }

        public ConstDouble(double d)
        {
            value = d;
        }
    }

    static abstract class ConstExpression
        implements Validator
    {

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
        }

        ConstExpression()
        {
        }
    }

    static final class ConstInt extends ConstExpression
        implements IntExpression
    {

        private final int value;

        public int eval(DcsState dcsstate)
        {
            return value;
        }

        public ConstInt(int i)
        {
            value = i;
        }
    }

    static final class ConstLong extends ConstExpression
        implements LongExpression
    {

        private final long value;

        public long eval(DcsState dcsstate)
        {
            return value;
        }

        public ConstLong(long l)
        {
            value = l;
        }
    }

    static final class ConstString extends ConstExpression
        implements StringExpression
    {

        private final String value;

        public String eval(DcsState dcsstate)
        {
            return value;
        }

        public ConstString(String s)
        {
            value = s;
        }
    }

    public static interface DoubleExpression
        extends Validator
    {

        public abstract double eval(DcsState dcsstate)
            throws DcsException;
    }

    static final class DoubleIntExpression extends WrapperExpression
        implements DoubleExpression
    {

        public double eval(DcsState dcsstate)
            throws DcsException
        {
            return (double)((IntExpression)value).eval(dcsstate);
        }

        public DoubleIntExpression(IntExpression intexpression)
        {
            super(intexpression);
        }
    }

    static final class DoubleLongExpression extends WrapperExpression
        implements DoubleExpression
    {

        public double eval(DcsState dcsstate)
            throws DcsException
        {
            return (double)((LongExpression)value).eval(dcsstate);
        }

        public DoubleLongExpression(LongExpression longexpression)
        {
            super(longexpression);
        }
    }

    public static interface IntExpression
        extends Validator
    {

        public abstract int eval(DcsState dcsstate)
            throws DcsException;
    }

    public static interface LongExpression
        extends Validator
    {

        public abstract long eval(DcsState dcsstate)
            throws DcsException;
    }

    static final class LongIntExpression extends WrapperExpression
        implements LongExpression
    {

        public long eval(DcsState dcsstate)
            throws DcsException
        {
            return (long)((IntExpression)value).eval(dcsstate);
        }

        public LongIntExpression(IntExpression intexpression)
        {
            super(intexpression);
        }
    }

    static final class Not extends WrapperExpression
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            return !((BooleanExpression)value).eval(dcsstate);
        }

        public Not(BooleanExpression booleanexpression)
        {
            super(booleanexpression);
        }
    }

    public static interface StringExpression
        extends Validator
    {

        public abstract String eval(DcsState dcsstate)
            throws DcsException;
    }

    public static abstract class Switch
        implements Validator
    {

        private final List entries;

        public final Validator get(DcsState dcsstate)
            throws DcsException
        {
            for (Iterator iterator = entries.iterator(); iterator.hasNext();)
            {
                Entry entry = (Entry)iterator.next();
                if (entry.condition.eval(dcsstate))
                {
                    return (Validator)entry.value;
                }
            }

            return null;
        }

        public final Validator getExpression(DcsState dcsstate)
            throws DcsException
        {
            dcsstate = get(dcsstate);
            if (dcsstate == null)
            {
                throw new DcsException("Missing value for condition");
            } else
            {
                return dcsstate;
            }
        }

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
            Entry entry;
            for (Iterator iterator = entries.iterator(); iterator.hasNext(); ((Validator)entry.value).validate(dcsutil))
            {
                entry = (Entry)iterator.next();
                entry.condition.validate(dcsutil);
            }

        }

        public Switch(List list)
        {
            entries = list;
        }
    }

    public static final class Switch.Entry
    {

        public final BooleanExpression condition;
        public final Object value;

        public Switch.Entry(BooleanExpression booleanexpression, Object obj)
        {
            condition = booleanexpression;
            value = obj;
        }
    }

    public static final class SwitchBoolean extends Switch
        implements BooleanExpression
    {

        public boolean eval(DcsState dcsstate)
            throws DcsException
        {
            return ((BooleanExpression)getExpression(dcsstate)).eval(dcsstate);
        }

        public SwitchBoolean(List list)
        {
            super(list);
        }
    }

    public static final class SwitchDouble extends Switch
        implements DoubleExpression
    {

        public double eval(DcsState dcsstate)
            throws DcsException
        {
            return ((DoubleExpression)getExpression(dcsstate)).eval(dcsstate);
        }

        public SwitchDouble(List list)
        {
            super(list);
        }
    }

    public static final class SwitchInt extends Switch
        implements IntExpression
    {

        public int eval(DcsState dcsstate)
            throws DcsException
        {
            return ((IntExpression)getExpression(dcsstate)).eval(dcsstate);
        }

        public SwitchInt(List list)
        {
            super(list);
        }
    }

    public static final class SwitchLong extends Switch
        implements LongExpression
    {

        public long eval(DcsState dcsstate)
            throws DcsException
        {
            return ((LongExpression)getExpression(dcsstate)).eval(dcsstate);
        }

        public SwitchLong(List list)
        {
            super(list);
        }
    }

    public static final class SwitchString extends Switch
        implements StringExpression
    {

        public String eval(DcsState dcsstate)
            throws DcsException
        {
            return ((StringExpression)getExpression(dcsstate)).eval(dcsstate);
        }

        public SwitchString(List list)
        {
            super(list);
        }
    }

    public static interface Validator
    {

        public abstract void validate(DcsUtil dcsutil)
            throws DcsException;
    }

    static abstract class VarBoolean extends VarExpression
        implements BooleanExpression
    {

        VarBoolean()
        {
        }
    }

    static abstract class VarExpression
        implements Validator
    {

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
        }

        VarExpression()
        {
        }
    }

    static abstract class VarInt extends VarExpression
        implements IntExpression
    {

        VarInt()
        {
        }
    }

    static abstract class VarString extends VarExpression
        implements StringExpression
    {

        VarString()
        {
        }
    }

    static abstract class WrapperExpression
        implements Validator
    {

        protected final Validator value;

        public void validate(DcsUtil dcsutil)
            throws DcsException
        {
            value.validate(dcsutil);
        }

        public WrapperExpression(Validator validator)
        {
            value = validator;
        }
    }


    static final BooleanExpression False = new ConstBoolean() {

        public boolean eval(DcsState dcsstate)
        {
            return false;
        }

    };
    static final StringExpression Null = new ConstString(null);
    public static final int TYPE_BOOL = 2;
    public static final int TYPE_DOUBLE = 5;
    public static final int TYPE_INT = 3;
    public static final int TYPE_LONG = 4;
    public static final int TYPE_NOT_SET = 0;
    public static final int TYPE_STRING = 1;
    public static final int TYPE_UNKNOWN = -1;
    static final BooleanExpression True = new ConstBoolean() {

        public boolean eval(DcsState dcsstate)
        {
            return true;
        }

    };
    static final Map variables;

    Expression()
    {
    }

    public static int getType(Object obj)
    {
        if (obj == null || (obj instanceof String) || (obj instanceof StringExpression))
        {
            return 1;
        }
        if ((obj instanceof Boolean) || (obj instanceof BooleanExpression))
        {
            return 2;
        }
        if ((obj instanceof Integer) || (obj instanceof IntExpression))
        {
            return 3;
        }
        if ((obj instanceof Long) || (obj instanceof LongExpression))
        {
            return 4;
        }
        return !(obj instanceof Double) && !(obj instanceof DoubleExpression) ? -1 : 5;
    }

    static 
    {
        variables = new HashMap();
        variables.put("prefCountry", new VarString() {

            public String eval(DcsState dcsstate)
            {
                return dcsstate.country;
            }

        });
        variables.put("prefLanguage", new VarString() {

            public String eval(DcsState dcsstate)
            {
                return dcsstate.language;
            }

        });
        variables.put("localeCountry", new VarString() {

            public String eval(DcsState dcsstate)
            {
                return dcsstate.locale.getCountry();
            }

        });
        variables.put("localeLanguage", new VarString() {

            public String eval(DcsState dcsstate)
            {
                String s = dcsstate.locale.getLanguage();
                dcsstate = s;
                if (s.length() > 2)
                {
                    dcsstate = s.substring(0, 2);
                }
                return dcsstate;
            }

        });
        variables.put("isGbh", new VarBoolean() {

            public boolean eval(DcsState dcsstate)
            {
                return dcsstate.isGbh;
            }

        });
        variables.put("user", new VarString() {

            public String eval(DcsState dcsstate)
            {
                return dcsstate.user;
            }

        });
        variables.put("rolloutThreshold", new VarInt() {

            public int eval(DcsState dcsstate)
            {
                return dcsstate.rolloutThreshold;
            }

        });
        variables.put("osLevel", new VarInt() {

            public int eval(DcsState dcsstate)
            {
                return android.os.Build.VERSION.SDK_INT;
            }

        });
    }
}
