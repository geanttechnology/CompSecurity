// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dee.result.bif;

import com.google.common.base.Objects;
import java.util.List;

// Referenced classes of package com.amazon.dee.result.bif:
//            ResolvedEntity, ERStatus

public class EntityResolutionResult
{

    private int mPriorityOrder;
    private ERStatus mResolutionStatus;
    private List mResolvedList;

    public EntityResolutionResult()
    {
        this(0, null, null);
    }

    public EntityResolutionResult(int i, ERStatus erstatus, List list)
    {
        mPriorityOrder = i;
        mResolutionStatus = erstatus;
        mResolvedList = list;
    }

    public EntityResolutionResult(List list)
    {
        this(0, null, list);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof EntityResolutionResult)
        {
            obj = (EntityResolutionResult)obj;
            flag = flag1;
            if (Objects.equal(Integer.valueOf(mPriorityOrder), Integer.valueOf(((EntityResolutionResult) (obj)).mPriorityOrder)))
            {
                flag = flag1;
                if (Objects.equal(mResolutionStatus, ((EntityResolutionResult) (obj)).mResolutionStatus))
                {
                    flag = flag1;
                    if (Objects.equal(mResolvedList, ((EntityResolutionResult) (obj)).mResolvedList))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public ResolvedEntity getBestResolvedEntity()
    {
        if (mResolvedList != null)
        {
            return (ResolvedEntity)mResolvedList.get(0);
        } else
        {
            return null;
        }
    }

    public int getPriorityOrder()
    {
        return mPriorityOrder;
    }

    public ERStatus getResolutionStatus()
    {
        return mResolutionStatus;
    }

    public List getResolvedList()
    {
        return mResolvedList;
    }

    public int hashCode()
    {
        return Objects.hashCode(new Object[] {
            Integer.valueOf(mPriorityOrder), mResolutionStatus, mResolvedList
        });
    }

    public void setPriorityOrder(int i)
    {
        mPriorityOrder = i;
    }

    public void setResolutionStatus(ERStatus erstatus)
    {
        mResolutionStatus = erstatus;
    }

    public void setResolvedList(List list)
    {
        mResolvedList = list;
    }

    public String toString()
    {
        return Objects.toStringHelper(getClass()).add("priorityOrder", mPriorityOrder).add("resolutionStatus", mResolutionStatus).add("resolvedList", mResolvedList).toString();
    }
}
