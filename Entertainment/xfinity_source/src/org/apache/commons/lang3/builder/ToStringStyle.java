// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3.builder;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.SystemUtils;

public abstract class ToStringStyle
    implements Serializable
{
    private static final class DefaultToStringStyle extends ToStringStyle
    {

        private Object readResolve()
        {
            return ToStringStyle.DEFAULT_STYLE;
        }

        DefaultToStringStyle()
        {
        }
    }

    private static final class MultiLineToStringStyle extends ToStringStyle
    {

        private Object readResolve()
        {
            return ToStringStyle.MULTI_LINE_STYLE;
        }

        MultiLineToStringStyle()
        {
            setContentStart("[");
            setFieldSeparator((new StringBuilder()).append(SystemUtils.LINE_SEPARATOR).append("  ").toString());
            setFieldSeparatorAtStart(true);
            setContentEnd((new StringBuilder()).append(SystemUtils.LINE_SEPARATOR).append("]").toString());
        }
    }

    private static final class NoFieldNameToStringStyle extends ToStringStyle
    {

        private Object readResolve()
        {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }

        NoFieldNameToStringStyle()
        {
            setUseFieldNames(false);
        }
    }

    private static final class ShortPrefixToStringStyle extends ToStringStyle
    {

        private Object readResolve()
        {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }

        ShortPrefixToStringStyle()
        {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }
    }

    private static final class SimpleToStringStyle extends ToStringStyle
    {

        private Object readResolve()
        {
            return ToStringStyle.SIMPLE_STYLE;
        }

        SimpleToStringStyle()
        {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }
    }


    public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
    public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
    private static final ThreadLocal REGISTRY = new ThreadLocal();
    public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
    public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
    private boolean arrayContentDetail;
    private String arrayEnd;
    private String arraySeparator;
    private String arrayStart;
    private String contentEnd;
    private String contentStart;
    private boolean defaultFullDetail;
    private String fieldNameValueSeparator;
    private String fieldSeparator;
    private boolean fieldSeparatorAtEnd;
    private boolean fieldSeparatorAtStart;
    private String nullText;
    private String sizeEndText;
    private String sizeStartText;
    private String summaryObjectEndText;
    private String summaryObjectStartText;
    private boolean useClassName;
    private boolean useFieldNames;
    private boolean useIdentityHashCode;
    private boolean useShortClassName;

    protected ToStringStyle()
    {
        useFieldNames = true;
        useClassName = true;
        useShortClassName = false;
        useIdentityHashCode = true;
        contentStart = "[";
        contentEnd = "]";
        fieldNameValueSeparator = "=";
        fieldSeparatorAtStart = false;
        fieldSeparatorAtEnd = false;
        fieldSeparator = ",";
        arrayStart = "{";
        arraySeparator = ",";
        arrayContentDetail = true;
        arrayEnd = "}";
        defaultFullDetail = true;
        nullText = "<null>";
        sizeStartText = "<size=";
        sizeEndText = ">";
        summaryObjectStartText = "<";
        summaryObjectEndText = ">";
    }

    static Map getRegistry()
    {
        return (Map)REGISTRY.get();
    }

    static boolean isRegistered(Object obj)
    {
        Map map = getRegistry();
        return map != null && map.containsKey(obj);
    }

    static void register(Object obj)
    {
        if (obj != null)
        {
            if (getRegistry() == null)
            {
                REGISTRY.set(new WeakHashMap());
            }
            getRegistry().put(obj, null);
        }
    }

    static void unregister(Object obj)
    {
        if (obj != null)
        {
            Map map = getRegistry();
            if (map != null)
            {
                map.remove(obj);
                if (map.isEmpty())
                {
                    REGISTRY.remove();
                }
            }
        }
    }

    public void append(StringBuffer stringbuffer, String s, int i)
    {
        appendFieldStart(stringbuffer, s);
        appendDetail(stringbuffer, s, i);
        appendFieldEnd(stringbuffer, s);
    }

    public void append(StringBuffer stringbuffer, String s, long l)
    {
        appendFieldStart(stringbuffer, s);
        appendDetail(stringbuffer, s, l);
        appendFieldEnd(stringbuffer, s);
    }

    public void append(StringBuffer stringbuffer, String s, Object obj, Boolean boolean1)
    {
        appendFieldStart(stringbuffer, s);
        if (obj == null)
        {
            appendNullText(stringbuffer, s);
        } else
        {
            appendInternal(stringbuffer, s, obj, isFullDetail(boolean1));
        }
        appendFieldEnd(stringbuffer, s);
    }

    public void append(StringBuffer stringbuffer, String s, boolean flag)
    {
        appendFieldStart(stringbuffer, s);
        appendDetail(stringbuffer, s, flag);
        appendFieldEnd(stringbuffer, s);
    }

    protected void appendClassName(StringBuffer stringbuffer, Object obj)
    {
label0:
        {
            if (useClassName && obj != null)
            {
                register(obj);
                if (!useShortClassName)
                {
                    break label0;
                }
                stringbuffer.append(getShortClassName(obj.getClass()));
            }
            return;
        }
        stringbuffer.append(obj.getClass().getName());
    }

    protected void appendContentEnd(StringBuffer stringbuffer)
    {
        stringbuffer.append(contentEnd);
    }

    protected void appendContentStart(StringBuffer stringbuffer)
    {
        stringbuffer.append(contentStart);
    }

    protected void appendCyclicObject(StringBuffer stringbuffer, String s, Object obj)
    {
        ObjectUtils.identityToString(stringbuffer, obj);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, byte byte0)
    {
        stringbuffer.append(byte0);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, char c)
    {
        stringbuffer.append(c);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, double d)
    {
        stringbuffer.append(d);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, float f)
    {
        stringbuffer.append(f);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, int i)
    {
        stringbuffer.append(i);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, long l)
    {
        stringbuffer.append(l);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, Object obj)
    {
        stringbuffer.append(obj);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, Collection collection)
    {
        stringbuffer.append(collection);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, Map map)
    {
        stringbuffer.append(map);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, short word0)
    {
        stringbuffer.append(word0);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, boolean flag)
    {
        stringbuffer.append(flag);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, byte abyte0[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < abyte0.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, abyte0[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, char ac[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < ac.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, ac[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, double ad[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < ad.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, ad[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, float af[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < af.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, af[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, int ai[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < ai.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, ai[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, long al[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < al.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, al[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, Object aobj[])
    {
        stringbuffer.append(arrayStart);
        int i = 0;
        while (i < aobj.length) 
        {
            Object obj = aobj[i];
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            if (obj == null)
            {
                appendNullText(stringbuffer, s);
            } else
            {
                appendInternal(stringbuffer, s, obj, arrayContentDetail);
            }
            i++;
        }
        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, short aword0[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < aword0.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, aword0[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    protected void appendDetail(StringBuffer stringbuffer, String s, boolean aflag[])
    {
        stringbuffer.append(arrayStart);
        for (int i = 0; i < aflag.length; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(arraySeparator);
            }
            appendDetail(stringbuffer, s, aflag[i]);
        }

        stringbuffer.append(arrayEnd);
    }

    public void appendEnd(StringBuffer stringbuffer, Object obj)
    {
        if (!fieldSeparatorAtEnd)
        {
            removeLastFieldSeparator(stringbuffer);
        }
        appendContentEnd(stringbuffer);
        unregister(obj);
    }

    protected void appendFieldEnd(StringBuffer stringbuffer, String s)
    {
        appendFieldSeparator(stringbuffer);
    }

    protected void appendFieldSeparator(StringBuffer stringbuffer)
    {
        stringbuffer.append(fieldSeparator);
    }

    protected void appendFieldStart(StringBuffer stringbuffer, String s)
    {
        if (useFieldNames && s != null)
        {
            stringbuffer.append(s);
            stringbuffer.append(fieldNameValueSeparator);
        }
    }

    protected void appendIdentityHashCode(StringBuffer stringbuffer, Object obj)
    {
        if (isUseIdentityHashCode() && obj != null)
        {
            register(obj);
            stringbuffer.append('@');
            stringbuffer.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    protected void appendInternal(StringBuffer stringbuffer, String s, Object obj, boolean flag)
    {
        if (isRegistered(obj) && !(obj instanceof Number) && !(obj instanceof Boolean) && !(obj instanceof Character))
        {
            appendCyclicObject(stringbuffer, s, obj);
            return;
        }
        register(obj);
        if (!(obj instanceof Collection)) goto _L2; else goto _L1
_L1:
        if (!flag) goto _L4; else goto _L3
_L3:
        appendDetail(stringbuffer, s, (Collection)obj);
_L5:
        unregister(obj);
        return;
_L4:
        appendSummarySize(stringbuffer, s, ((Collection)obj).size());
          goto _L5
        stringbuffer;
        unregister(obj);
        throw stringbuffer;
_L2:
        if (!(obj instanceof Map))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        appendDetail(stringbuffer, s, (Map)obj);
          goto _L5
        appendSummarySize(stringbuffer, s, ((Map)obj).size());
          goto _L5
        if (!(obj instanceof long[]))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        appendDetail(stringbuffer, s, (long[])(long[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (long[])(long[])obj);
          goto _L5
        if (!(obj instanceof int[]))
        {
            break MISSING_BLOCK_LABEL_223;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        appendDetail(stringbuffer, s, (int[])(int[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (int[])(int[])obj);
          goto _L5
        if (!(obj instanceof short[]))
        {
            break MISSING_BLOCK_LABEL_267;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        appendDetail(stringbuffer, s, (short[])(short[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (short[])(short[])obj);
          goto _L5
        if (!(obj instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_311;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        appendDetail(stringbuffer, s, (byte[])(byte[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (byte[])(byte[])obj);
          goto _L5
        if (!(obj instanceof char[]))
        {
            break MISSING_BLOCK_LABEL_355;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_339;
        }
        appendDetail(stringbuffer, s, (char[])(char[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (char[])(char[])obj);
          goto _L5
        if (!(obj instanceof double[]))
        {
            break MISSING_BLOCK_LABEL_399;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        appendDetail(stringbuffer, s, (double[])(double[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (double[])(double[])obj);
          goto _L5
        if (!(obj instanceof float[]))
        {
            break MISSING_BLOCK_LABEL_443;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        appendDetail(stringbuffer, s, (float[])(float[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (float[])(float[])obj);
          goto _L5
        if (!(obj instanceof boolean[]))
        {
            break MISSING_BLOCK_LABEL_487;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        appendDetail(stringbuffer, s, (boolean[])(boolean[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (boolean[])(boolean[])obj);
          goto _L5
        if (!obj.getClass().isArray())
        {
            break MISSING_BLOCK_LABEL_534;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_518;
        }
        appendDetail(stringbuffer, s, (Object[])(Object[])obj);
          goto _L5
        appendSummary(stringbuffer, s, (Object[])(Object[])obj);
          goto _L5
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_549;
        }
        appendDetail(stringbuffer, s, obj);
          goto _L5
        appendSummary(stringbuffer, s, obj);
          goto _L5
    }

    protected void appendNullText(StringBuffer stringbuffer, String s)
    {
        stringbuffer.append(nullText);
    }

    public void appendStart(StringBuffer stringbuffer, Object obj)
    {
        if (obj != null)
        {
            appendClassName(stringbuffer, obj);
            appendIdentityHashCode(stringbuffer, obj);
            appendContentStart(stringbuffer);
            if (fieldSeparatorAtStart)
            {
                appendFieldSeparator(stringbuffer);
            }
        }
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, Object obj)
    {
        stringbuffer.append(summaryObjectStartText);
        stringbuffer.append(getShortClassName(obj.getClass()));
        stringbuffer.append(summaryObjectEndText);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, byte abyte0[])
    {
        appendSummarySize(stringbuffer, s, abyte0.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, char ac[])
    {
        appendSummarySize(stringbuffer, s, ac.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, double ad[])
    {
        appendSummarySize(stringbuffer, s, ad.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, float af[])
    {
        appendSummarySize(stringbuffer, s, af.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, int ai[])
    {
        appendSummarySize(stringbuffer, s, ai.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, long al[])
    {
        appendSummarySize(stringbuffer, s, al.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, Object aobj[])
    {
        appendSummarySize(stringbuffer, s, aobj.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, short aword0[])
    {
        appendSummarySize(stringbuffer, s, aword0.length);
    }

    protected void appendSummary(StringBuffer stringbuffer, String s, boolean aflag[])
    {
        appendSummarySize(stringbuffer, s, aflag.length);
    }

    protected void appendSummarySize(StringBuffer stringbuffer, String s, int i)
    {
        stringbuffer.append(sizeStartText);
        stringbuffer.append(i);
        stringbuffer.append(sizeEndText);
    }

    protected String getNullText()
    {
        return nullText;
    }

    protected String getShortClassName(Class class1)
    {
        return ClassUtils.getShortClassName(class1);
    }

    protected boolean isFullDetail(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return defaultFullDetail;
        } else
        {
            return boolean1.booleanValue();
        }
    }

    protected boolean isUseIdentityHashCode()
    {
        return useIdentityHashCode;
    }

    protected void removeLastFieldSeparator(StringBuffer stringbuffer)
    {
        int j;
        int k;
        j = stringbuffer.length();
        k = fieldSeparator.length();
        if (j <= 0 || k <= 0 || j < k) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag1;
        flag1 = true;
        i = 0;
_L8:
        boolean flag = flag1;
        if (i >= k) goto _L4; else goto _L3
_L3:
        if (stringbuffer.charAt(j - 1 - i) == fieldSeparator.charAt(k - 1 - i)) goto _L6; else goto _L5
_L5:
        flag = false;
_L4:
        if (flag)
        {
            stringbuffer.setLength(j - k);
        }
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void setContentEnd(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        contentEnd = s1;
    }

    protected void setContentStart(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        contentStart = s1;
    }

    protected void setFieldSeparator(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        fieldSeparator = s1;
    }

    protected void setFieldSeparatorAtStart(boolean flag)
    {
        fieldSeparatorAtStart = flag;
    }

    protected void setUseClassName(boolean flag)
    {
        useClassName = flag;
    }

    protected void setUseFieldNames(boolean flag)
    {
        useFieldNames = flag;
    }

    protected void setUseIdentityHashCode(boolean flag)
    {
        useIdentityHashCode = flag;
    }

    protected void setUseShortClassName(boolean flag)
    {
        useShortClassName = flag;
    }

}
