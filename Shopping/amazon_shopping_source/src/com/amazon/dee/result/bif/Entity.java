// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.dee.result.bif:
//            Span, Intent, Token, ResolvedEntities

public class Entity
{

    private String mName;
    private ResolvedEntities mResolvedEntities;
    private Span mTokenSpan;
    private List mTokens;
    private String mValue;

    public Entity()
    {
        this(null, null, null, null, null);
    }

    public Entity(String s, String s1)
    {
        this(s, s1, null, null, null);
    }

    public Entity(String s, String s1, Span span)
    {
        this(s, s1, span, null, null);
    }

    public Entity(String s, String s1, Span span, List list, ResolvedEntities resolvedentities)
    {
        mName = s;
        mValue = s1;
        mTokenSpan = span;
        mTokens = new ArrayList();
        if (list != null)
        {
            addTokens(list);
        }
        mResolvedEntities = resolvedentities;
    }

    public Entity(String s, String s1, List list)
    {
        this(s, s1, null, list, null);
    }

    public final void addToken(Token token)
    {
        mTokens.add(token);
    }

    public final void addTokens(List list)
    {
        mTokens.addAll(list);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Entity)
        {
            obj = (Entity)obj;
            flag = flag1;
            if (Objects.equal(mName, ((Entity) (obj)).mName))
            {
                flag = flag1;
                if (Objects.equal(mValue, ((Entity) (obj)).mValue))
                {
                    flag = flag1;
                    if (Objects.equal(mTokenSpan, ((Entity) (obj)).mTokenSpan))
                    {
                        flag = flag1;
                        if (Objects.equal(mTokens, ((Entity) (obj)).mTokens))
                        {
                            flag = flag1;
                            if (Objects.equal(mResolvedEntities, ((Entity) (obj)).mResolvedEntities))
                            {
                                flag = true;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public String getName()
    {
        return mName;
    }

    public final ResolvedEntities getResolvedEntities()
    {
        return mResolvedEntities;
    }

    public Span getSpan()
    {
        return mTokenSpan;
    }

    public final List getTokens()
    {
        return mTokens;
    }

    public List getTokens(Intent intent)
    {
        if (intent == null || mTokenSpan == null)
        {
            return null;
        } else
        {
            int i = mTokenSpan.getStart();
            int j = mTokenSpan.getLength();
            return intent.getTokens().subList(i, i + j);
        }
    }

    public String getTokensAsText()
    {
        if (mTokens == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        for (Iterator iterator = mTokens.iterator(); iterator.hasNext(); stringbuilder.append(((Token)iterator.next()).getValue()).append(" ")) { }
        return stringbuilder.toString().trim();
    }

    public String getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mName, mValue, mTokenSpan, mTokens, mResolvedEntities
        });
    }

    public void setName(String s)
    {
        mName = s;
    }

    public final void setResolvedEntities(ResolvedEntities resolvedentities)
    {
        mResolvedEntities = resolvedentities;
    }

    public void setSpan(Span span)
    {
        mTokenSpan = span;
    }

    public final void setTokens(List list)
    {
        mTokens = list;
    }

    public void setValue(String s)
    {
        mValue = s;
    }
}
