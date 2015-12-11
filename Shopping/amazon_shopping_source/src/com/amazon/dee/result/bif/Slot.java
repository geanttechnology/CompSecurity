// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.dee.result.bif:
//            ScoreSource, Score, Entity, ConfirmationState, 
//            ConfidenceBin, Intent

public class Slot
{

    private Map mConfidenceScores;
    private ConfirmationState mConfirmationState;
    private String mName;
    private List mTraits;
    private Entity mValue;

    public Slot()
    {
        this(null, null, null, null, null);
    }

    public Slot(String s, Entity entity)
    {
        this(s, entity, null, null);
    }

    public Slot(String s, Entity entity, Map map)
    {
        this(s, entity, map, null, null);
    }

    public Slot(String s, Entity entity, Map map, List list)
    {
        this(s, entity, map, list, null);
    }

    public Slot(String s, Entity entity, Map map, List list, ConfirmationState confirmationstate)
    {
        mName = s;
        mValue = entity;
        if (map == null)
        {
            mConfidenceScores = new HashMap();
            mConfidenceScores.put(ScoreSource.SLU, new Score(0.0D));
        } else
        {
            mConfidenceScores = map;
        }
        if (list == null)
        {
            list = new ArrayList();
        }
        mTraits = list;
        mConfirmationState = confirmationstate;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof Slot)
        {
            obj = (Slot)obj;
            flag = flag1;
            if (Objects.equal(mConfidenceScores, ((Slot) (obj)).mConfidenceScores))
            {
                flag = flag1;
                if (Objects.equal(mName, ((Slot) (obj)).mName))
                {
                    flag = flag1;
                    if (Objects.equal(mValue, ((Slot) (obj)).mValue))
                    {
                        flag = flag1;
                        if (Objects.equal(mTraits, ((Slot) (obj)).mTraits))
                        {
                            flag = true;
                        }
                    }
                }
            }
        }
        return flag;
    }

    public double getConfidenceScore(ScoreSource scoresource)
    {
        Score score = null;
        if (mConfidenceScores != null)
        {
            score = (Score)mConfidenceScores.get(scoresource);
        }
        if (score == null)
        {
            return 0.0D;
        } else
        {
            return score.getValue();
        }
    }

    public ConfidenceBin getConfidenceScoreBin(ScoreSource scoresource)
    {
        Score score = null;
        if (mConfidenceScores != null)
        {
            score = (Score)mConfidenceScores.get(scoresource);
        }
        if (score == null)
        {
            return null;
        } else
        {
            return score.getBin();
        }
    }

    public final Map getConfidenceScores()
    {
        return mConfidenceScores;
    }

    public ConfirmationState getConfirmationState()
    {
        return mConfirmationState;
    }

    public String getName()
    {
        return mName;
    }

    public List getToken(Intent intent)
    {
        if (mValue != null)
        {
            return mValue.getTokens(intent);
        } else
        {
            return null;
        }
    }

    public List getTraits()
    {
        return mTraits;
    }

    public Entity getValue()
    {
        return mValue;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mConfidenceScores, mName, mValue, mTraits
        });
    }

    public void setConfidenceScores(Map map)
    {
        if (map != null)
        {
            mConfidenceScores = map;
        }
    }

    public void setConfirmationState(ConfirmationState confirmationstate)
    {
        mConfirmationState = confirmationstate;
    }

    public void setName(String s)
    {
        mName = s;
    }

    public void setTraits(List list)
    {
        mTraits = list;
    }

    public void setValue(Entity entity)
    {
        mValue = entity;
    }
}
