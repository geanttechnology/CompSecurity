// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.stream;


public final class MimeConfig
    implements Cloneable
{

    private boolean countLineNumbers;
    private String headlessParsing;
    private boolean malformedHeaderStartsBody;
    private long maxContentLen;
    private int maxHeaderCount;
    private int maxHeaderLen;
    private int maxLineLen;
    private boolean strictParsing;

    public MimeConfig()
    {
        strictParsing = false;
        countLineNumbers = false;
        malformedHeaderStartsBody = false;
        maxLineLen = 1000;
        maxHeaderCount = 1000;
        maxHeaderLen = 10000;
        maxContentLen = -1L;
        headlessParsing = null;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public MimeConfig clone()
    {
        MimeConfig mimeconfig;
        try
        {
            mimeconfig = (MimeConfig)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new InternalError();
        }
        return mimeconfig;
    }

    public String getHeadlessParsing()
    {
        return headlessParsing;
    }

    public long getMaxContentLen()
    {
        return maxContentLen;
    }

    public int getMaxHeaderCount()
    {
        return maxHeaderCount;
    }

    public int getMaxHeaderLen()
    {
        return maxHeaderLen;
    }

    public int getMaxLineLen()
    {
        return maxLineLen;
    }

    public boolean isCountLineNumbers()
    {
        return countLineNumbers;
    }

    public boolean isMalformedHeaderStartsBody()
    {
        return malformedHeaderStartsBody;
    }

    public boolean isStrictParsing()
    {
        return strictParsing;
    }

    public void setCountLineNumbers(boolean flag)
    {
        countLineNumbers = flag;
    }

    public void setHeadlessParsing(String s)
    {
        headlessParsing = s;
    }

    public void setMalformedHeaderStartsBody(boolean flag)
    {
        malformedHeaderStartsBody = flag;
    }

    public void setMaxContentLen(long l)
    {
        maxContentLen = l;
    }

    public void setMaxHeaderCount(int i)
    {
        maxHeaderCount = i;
    }

    public void setMaxHeaderLen(int i)
    {
        maxHeaderLen = i;
    }

    public void setMaxLineLen(int i)
    {
        maxLineLen = i;
    }

    public void setStrictParsing(boolean flag)
    {
        strictParsing = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[strict parsing: ").append(strictParsing).append(", max line length: ").append(maxLineLen).append(", max header count: ").append(maxHeaderCount).append(", max content length: ").append(maxContentLen).append(", count line numbers: ").append(countLineNumbers).append("]").toString();
    }
}
