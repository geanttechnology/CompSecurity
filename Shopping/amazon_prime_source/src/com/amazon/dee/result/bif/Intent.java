// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.dee.result.bif:
//            ScoreSource, Score, Slot, ConfirmationState, 
//            Token, ConfidenceBin

public class Intent
{

    private Map mConfidenceScores;
    private ConfirmationState mConfirmationState;
    private boolean mMergedFromContext;
    private String mName;
    private List mSlots;
    private List mTokens;

    public Intent()
    {
        this(null, null, null, false);
    }

    public Intent(String s)
    {
        this(s, null, null, false);
    }

    public Intent(String s, Map map)
    {
        this(s, map, null, false);
    }

    public Intent(String s, Map map, ConfirmationState confirmationstate)
    {
        this(s, map, confirmationstate, false);
    }

    public Intent(String s, Map map, ConfirmationState confirmationstate, boolean flag)
    {
        mName = s;
        if (map == null)
        {
            mConfidenceScores = new HashMap();
            mConfidenceScores.put(ScoreSource.SLU, new Score(0.0D));
        } else
        {
            mConfidenceScores = map;
        }
        mConfirmationState = confirmationstate;
        mSlots = new ArrayList();
        mTokens = new ArrayList();
        mMergedFromContext = flag;
    }

    public final void addSlot(Slot slot)
    {
        mSlots.add(slot);
    }

    public final void addSlots(List list)
    {
        mSlots.addAll(list);
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
        if (obj instanceof Intent)
        {
            obj = (Intent)obj;
            flag = flag1;
            if (Objects.equal(mName, ((Intent) (obj)).mName))
            {
                flag = flag1;
                if (Objects.equal(mConfidenceScores, ((Intent) (obj)).mConfidenceScores))
                {
                    flag = flag1;
                    if (Objects.equal(mTokens, ((Intent) (obj)).mTokens))
                    {
                        flag = flag1;
                        if (Objects.equal(mSlots, ((Intent) (obj)).mSlots))
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

    public final ConfirmationState getConfirmationState()
    {
        return mConfirmationState;
    }

    public final List getEmptySlots()
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = mSlots.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Slot slot = (Slot)iterator.next();
            if (slot.getValue() == null)
            {
                arraylist.add(slot);
            }
        } while (true);
        return arraylist;
    }

    public final boolean getMergedFromContext()
    {
        return mMergedFromContext;
    }

    public final String getName()
    {
        return mName;
    }

    public final Slot getSlotByName(String s)
    {
        for (Iterator iterator = mSlots.iterator(); iterator.hasNext();)
        {
            Slot slot = (Slot)iterator.next();
            if (s.equals(slot.getName()))
            {
                return slot;
            }
        }

        return null;
    }

    public final List getSlots()
    {
        return mSlots;
    }

    public final List getTokens()
    {
        return mTokens;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            mConfidenceScores, mName, mSlots, mTokens
        });
    }

    public final void setConfidenceScores(Map map)
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

    public void setMergedFromContext(boolean flag)
    {
        mMergedFromContext = flag;
    }

    public final void setName(String s)
    {
        mName = s;
    }

    public final void setSlots(List list)
    {
        mSlots = list;
    }

    public final void setTokens(List list)
    {
        mTokens = list;
    }
}
