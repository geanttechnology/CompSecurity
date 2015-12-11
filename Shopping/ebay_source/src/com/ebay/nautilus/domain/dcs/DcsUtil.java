// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.dcs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.dcs:
//            DcsPropBoolean, DcsPropString, DcsPropInteger, DcsPropLong, 
//            DcsPropUrl, DcsException, DcsTokener, DcsProperty, 
//            DcsState

public final class DcsUtil
{
    static final class BooleanExtractor
        implements DcsValueExtractor
    {

        private Boolean eval(DcsState dcsstate, Object obj, boolean flag)
            throws DcsException
        {
            Object obj1 = obj;
            if (obj instanceof Expression.SwitchBoolean)
            {
                obj1 = ((Expression.SwitchBoolean)obj).get(dcsstate);
            }
            if (obj1 instanceof Expression.BooleanExpression)
            {
                return Boolean.valueOf(((Expression.BooleanExpression)obj1).eval(dcsstate));
            }
            if (flag)
            {
                return get(obj1);
            } else
            {
                return tryGet(obj1);
            }
        }

        public Boolean eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj, false);
        }

        public volatile Object eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj);
        }

        public Boolean get(Object obj)
        {
            return (Boolean)obj;
        }

        public volatile Object get(Object obj)
            throws Exception
        {
            return get(obj);
        }

        public Boolean testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return eval(dcsstate, obj, true);
        }

        public volatile Object testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return testEval(dcsstate, obj);
        }

        public Boolean tryGet(Object obj)
        {
            if (obj instanceof Boolean)
            {
                return (Boolean)obj;
            } else
            {
                return null;
            }
        }

        public volatile Object tryGet(Object obj)
        {
            return tryGet(obj);
        }

        BooleanExtractor()
        {
        }
    }

    static interface DcsValueExtractor
    {

        public abstract Object eval(DcsState dcsstate, Object obj)
            throws DcsException;

        public abstract Object get(Object obj)
            throws Exception;

        public abstract Object testEval(DcsState dcsstate, Object obj)
            throws Exception;

        public abstract Object tryGet(Object obj);
    }

    static final class IntExtractor
        implements DcsValueExtractor
    {

        private Integer eval(DcsState dcsstate, Object obj, boolean flag)
            throws DcsException
        {
            Object obj1 = obj;
            if (obj instanceof Expression.SwitchInt)
            {
                obj1 = ((Expression.SwitchInt)obj).get(dcsstate);
            }
            if (obj1 instanceof Expression.IntExpression)
            {
                return Integer.valueOf(((Expression.IntExpression)obj1).eval(dcsstate));
            }
            if (flag)
            {
                return get(obj1);
            } else
            {
                return tryGet(obj1);
            }
        }

        public Integer eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj, false);
        }

        public volatile Object eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj);
        }

        public Integer get(Object obj)
        {
            return (Integer)obj;
        }

        public volatile Object get(Object obj)
            throws Exception
        {
            return get(obj);
        }

        public Integer testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return eval(dcsstate, obj, true);
        }

        public volatile Object testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return testEval(dcsstate, obj);
        }

        public Integer tryGet(Object obj)
        {
            if (obj instanceof Integer)
            {
                return (Integer)obj;
            } else
            {
                return null;
            }
        }

        public volatile Object tryGet(Object obj)
        {
            return tryGet(obj);
        }

        IntExtractor()
        {
        }
    }

    static final class LongExtractor
        implements DcsValueExtractor
    {

        private Long eval(DcsState dcsstate, Object obj, boolean flag)
            throws DcsException
        {
            if (!(obj instanceof Expression.SwitchLong)) goto _L2; else goto _L1
_L1:
            Object obj1 = ((Expression.SwitchLong)obj).get(dcsstate);
_L4:
            if (obj1 instanceof Expression.LongExpression)
            {
                return Long.valueOf(((Expression.LongExpression)obj1).eval(dcsstate));
            }
            break; /* Loop/switch isn't completed */
_L2:
            obj1 = obj;
            if (obj instanceof Expression.SwitchInt)
            {
                obj1 = ((Expression.SwitchInt)obj).get(dcsstate);
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (obj1 instanceof Expression.IntExpression)
            {
                return Long.valueOf(((Expression.IntExpression)obj1).eval(dcsstate));
            }
            if (flag)
            {
                return get(obj1);
            } else
            {
                return tryGet(obj1);
            }
        }

        public Long eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj, false);
        }

        public volatile Object eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj);
        }

        public Long get(Object obj)
        {
            if (obj instanceof Integer)
            {
                return Long.valueOf(((Integer)obj).longValue());
            } else
            {
                return (Long)obj;
            }
        }

        public volatile Object get(Object obj)
            throws Exception
        {
            return get(obj);
        }

        public Long testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return eval(dcsstate, obj, true);
        }

        public volatile Object testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return testEval(dcsstate, obj);
        }

        public Long tryGet(Object obj)
        {
            if ((obj instanceof Long) || (obj instanceof Integer))
            {
                return get(obj);
            } else
            {
                return null;
            }
        }

        public volatile Object tryGet(Object obj)
        {
            return tryGet(obj);
        }

        LongExtractor()
        {
        }
    }

    static final class StringExtractor
        implements DcsValueExtractor
    {

        private String eval(DcsState dcsstate, Object obj, boolean flag)
            throws DcsException
        {
            Object obj1 = obj;
            if (obj instanceof Expression.SwitchString)
            {
                obj1 = ((Expression.SwitchString)obj).get(dcsstate);
            }
            if (obj1 instanceof Expression.StringExpression)
            {
                return ((Expression.StringExpression)obj1).eval(dcsstate);
            }
            if (flag)
            {
                return get(obj1);
            } else
            {
                return tryGet(obj1);
            }
        }

        public volatile Object eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj);
        }

        public String eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj, false);
        }

        public volatile Object get(Object obj)
            throws Exception
        {
            return get(obj);
        }

        public String get(Object obj)
        {
            return (String)obj;
        }

        public volatile Object testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return testEval(dcsstate, obj);
        }

        public String testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return eval(dcsstate, obj, true);
        }

        public volatile Object tryGet(Object obj)
        {
            return tryGet(obj);
        }

        public String tryGet(Object obj)
        {
            if (obj instanceof String)
            {
                return get(obj);
            } else
            {
                return null;
            }
        }

        StringExtractor()
        {
        }
    }

    static final class UrlExtractor
        implements DcsValueExtractor
    {

        public volatile Object eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            return eval(dcsstate, obj);
        }

        public URL eval(DcsState dcsstate, Object obj)
            throws DcsException
        {
            Object obj1 = obj;
            if (obj instanceof Expression.StringExpression)
            {
                obj1 = DcsUtil.STRING_EXTRACTOR.eval(dcsstate, obj);
            }
            return tryGet(obj1);
        }

        public volatile Object get(Object obj)
            throws Exception
        {
            return get(obj);
        }

        public URL get(Object obj)
            throws Exception
        {
            if (obj instanceof String)
            {
                return new URL((String)obj);
            } else
            {
                return (URL)obj;
            }
        }

        public volatile Object testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            return testEval(dcsstate, obj);
        }

        public URL testEval(DcsState dcsstate, Object obj)
            throws Exception
        {
            Object obj1 = obj;
            if (obj instanceof Expression.StringExpression)
            {
                obj1 = DcsUtil.STRING_EXTRACTOR.testEval(dcsstate, obj);
            }
            return get(obj1);
        }

        public volatile Object tryGet(Object obj)
        {
            return tryGet(obj);
        }

        public URL tryGet(Object obj)
        {
            if (obj instanceof URL)
            {
                return (URL)obj;
            }
            if (!(obj instanceof String))
            {
                break MISSING_BLOCK_LABEL_38;
            }
            obj = new URL((String)obj);
            return ((URL) (obj));
            obj;
            ((MalformedURLException) (obj)).printStackTrace();
            return null;
        }

        UrlExtractor()
        {
        }
    }


    static final BooleanExtractor BOOLEAN_EXTRACTOR = new BooleanExtractor();
    static final IntExtractor INT_EXTRACTOR = new IntExtractor();
    static final LongExtractor LONG_EXTRACTOR = new LongExtractor();
    static final StringExtractor STRING_EXTRACTOR = new StringExtractor();
    static final UrlExtractor URL_EXTRACTOR = new UrlExtractor();
    public final Set prefCountryCodes;

    public DcsUtil(Set set)
    {
        prefCountryCodes = set;
    }

    static DcsValueExtractor getExtractorFromType(DcsProperty dcsproperty)
    {
        if (dcsproperty instanceof DcsPropBoolean)
        {
            return BOOLEAN_EXTRACTOR;
        }
        if (dcsproperty instanceof DcsPropString)
        {
            return STRING_EXTRACTOR;
        }
        if (dcsproperty instanceof DcsPropInteger)
        {
            return INT_EXTRACTOR;
        }
        if (dcsproperty instanceof DcsPropLong)
        {
            return LONG_EXTRACTOR;
        }
        if (dcsproperty instanceof DcsPropUrl)
        {
            return URL_EXTRACTOR;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append(dcsproperty.getClass().getName()).append(" unknown").toString());
        }
    }

    static Object getFromRules(DcsProperty dcsproperty, Object obj, DcsState dcsstate)
    {
        DcsValueExtractor dcsvalueextractor = getExtractorFromType(dcsproperty);
        if (shouldEvaluate(dcsproperty, obj))
        {
            try
            {
                dcsproperty = ((DcsProperty) (dcsvalueextractor.eval(dcsstate, DcsTokener.getExpression((String)obj))));
            }
            // Misplaced declaration of an exception variable
            catch (DcsProperty dcsproperty)
            {
                dcsproperty.printStackTrace();
                return null;
            }
            return dcsproperty;
        } else
        {
            return dcsvalueextractor.tryGet(obj);
        }
    }

    private static boolean shouldEvaluate(DcsProperty dcsproperty, Object obj)
    {
label0:
        {
            boolean flag1 = obj instanceof String;
            boolean flag = flag1;
            if (flag1)
            {
                obj = (String)obj;
                boolean flag2;
                if (!(dcsproperty instanceof DcsPropString) && !(dcsproperty instanceof DcsPropUrl))
                {
                    flag2 = true;
                } else
                {
                    flag2 = false;
                }
                flag = flag2;
                if (!flag2)
                {
                    dcsproperty = ((String) (obj)).trim();
                    int i = dcsproperty.length();
                    if (i <= 1 || dcsproperty.charAt(0) != '{' || dcsproperty.charAt(i - 1) != '}')
                    {
                        break label0;
                    }
                    flag = true;
                }
            }
            return flag;
        }
        return false;
    }

    public Object validateValue(DcsProperty dcsproperty, Object obj, DcsState dcsstate)
        throws Exception
    {
        DcsValueExtractor dcsvalueextractor = getExtractorFromType(dcsproperty);
        if (shouldEvaluate(dcsproperty, obj))
        {
            dcsproperty = ((DcsProperty) (DcsTokener.getExpression((String)obj)));
            try
            {
                if (dcsproperty instanceof Expression.Validator)
                {
                    ((Expression.Validator)dcsproperty).validate(this);
                }
            }
            // Misplaced declaration of an exception variable
            catch (DcsProperty dcsproperty)
            {
                obj = new DcsException((new StringBuilder()).append(dcsproperty.getMessage()).append(" \"").append(obj).append('"').toString());
                ((DcsException) (obj)).initCause(dcsproperty);
                throw obj;
            }
            return dcsvalueextractor.testEval(dcsstate, dcsproperty);
        } else
        {
            return dcsvalueextractor.get(obj);
        }
    }

}
