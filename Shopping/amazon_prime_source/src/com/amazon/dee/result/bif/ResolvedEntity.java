// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.dee.result.bif:
//            Score, Value

public class ResolvedEntity
{

    private Score mConfidenceScore;
    private Map mExtraDataFromAuthority;
    private Map mIdentifiers;
    private String mName;
    private Value mResolvedValue;

    public ResolvedEntity()
    {
    }

    public ResolvedEntity(String s, Value value)
    {
        this(s, value, (Score)null, null, null);
    }

    public ResolvedEntity(String s, Value value, Score score, Map map, Map map1)
    {
        mName = s;
        mResolvedValue = value;
        mConfidenceScore = score;
        mIdentifiers = map;
        mExtraDataFromAuthority = map1;
    }

    public ResolvedEntity(String s, Value value, String s1, Map map, Map map1)
    {
        if (s1 == null || s1.equals(""))
        {
            s1 = null;
        } else
        {
            s1 = new Score(Double.valueOf(s1).doubleValue());
        }
        this(s, value, ((Score) (s1)), map, map1);
    }

    public void addExtraDataFromAuthorityObject(String s, String s1)
    {
        if (mExtraDataFromAuthority != null)
        {
            mExtraDataFromAuthority.put(s, s1);
            return;
        } else
        {
            mExtraDataFromAuthority = new HashMap();
            mExtraDataFromAuthority.put(s, s1);
            return;
        }
    }

    public void addIdentifier(String s, String s1)
    {
        if (mIdentifiers != null)
        {
            mIdentifiers.put(s, s1);
            return;
        } else
        {
            mIdentifiers = new HashMap();
            mIdentifiers.put(s, s1);
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof ResolvedEntity)
        {
            obj = (ResolvedEntity)obj;
            flag = flag1;
            if (Objects.equal(mName, ((ResolvedEntity) (obj)).mName))
            {
                flag = flag1;
                if (Objects.equal(mResolvedValue, ((ResolvedEntity) (obj)).mResolvedValue))
                {
                    flag = flag1;
                    if (Objects.equal(mConfidenceScore, ((ResolvedEntity) (obj)).mConfidenceScore))
                    {
                        flag = flag1;
                        if (Objects.equal(mIdentifiers, ((ResolvedEntity) (obj)).mIdentifiers))
                        {
                            flag = flag1;
                            if (Objects.equal(mExtraDataFromAuthority, ((ResolvedEntity) (obj)).mExtraDataFromAuthority))
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

    public Score getConfidenceScore()
    {
        return mConfidenceScore;
    }

    public Map getExtraDataFromAuthority()
    {
        return mExtraDataFromAuthority;
    }

    public String getExtraDataFromAuthorityGivenKey(String s)
    {
        return (String)mExtraDataFromAuthority.get(s);
    }

    public String getIdentifier(String s)
    {
        return (String)mIdentifiers.get(s);
    }

    public Map getIdentifiers()
    {
        return mIdentifiers;
    }

    public String getName()
    {
        return mName;
    }

    public String getRelevance()
    {
        if (mConfidenceScore == null)
        {
            return null;
        } else
        {
            return String.valueOf(mConfidenceScore.getValue());
        }
    }

    public Value getResolvedValue()
    {
        return mResolvedValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mName, mResolvedValue, mConfidenceScore, mIdentifiers, mExtraDataFromAuthority
        });
    }

    public void setConfidenceScore(Score score)
    {
        mConfidenceScore = score;
    }

    public void setExtraDataFromAuthority(Map map)
    {
        mExtraDataFromAuthority = map;
    }

    public void setIdentifiers(Map map)
    {
        mIdentifiers = map;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public void setRelevance(String s)
    {
        if (s == null || s.equals(""))
        {
            mConfidenceScore = null;
            return;
        }
        double d = Double.valueOf(s).doubleValue();
        if (mConfidenceScore == null)
        {
            mConfidenceScore = new Score(d);
            return;
        } else
        {
            mConfidenceScore.setValue(d);
            return;
        }
    }

    public void setResolvedValue(Value value)
    {
        mResolvedValue = value;
    }

    public String toString()
    {
        return Objects.toStringHelper(getClass()).add("name", mName).add("resolvedValue", mResolvedValue).add("confidenceScore", mConfidenceScore).add("identifiers", mIdentifiers).add("extraDataFromAuthority", mExtraDataFromAuthority).toString();
    }
}
