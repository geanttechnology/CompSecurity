// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import java.util.Comparator;
import java.util.Date;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            f

class a
    implements Comparator
{

    final f a;

    public int a(com.cyberlink.beautycircle.model.est.ContestInfo contestinfo, com.cyberlink.beautycircle.model.est.ContestInfo contestinfo1)
    {
        int i;
        boolean flag;
        boolean flag1;
        int i1;
        int j1;
        flag1 = true;
        flag = false;
        i1 = contestinfo.a(f.a(a));
        j1 = contestinfo1.a(f.a(a));
        int j;
        if (contestinfo.priority != null)
        {
            i = contestinfo.priority.intValue();
        } else
        {
            i = 0;
        }
        if (contestinfo1.priority != null)
        {
            j = contestinfo1.priority.intValue();
        } else
        {
            j = 0;
        }
        if (i == j) goto _L2; else goto _L1
_L1:
        if (i < j)
        {
            i = 1;
        } else
        {
            i = -1;
        }
_L4:
        return i;
_L2:
        if (i1 != j1)
        {
            if (i1 < j1)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = -1;
            }
            return i;
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo.submitStartDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo.submitEndDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo.voteStartDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo.voteEndDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo1.submitStartDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo1.submitEndDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo1.voteStartDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((flag) ? 1 : 0);
        if (contestinfo1.voteEndDate == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (i1 != com.cyberlink.beautycircle.model.est.ContestInfo.EVENT_ONGOING)
        {
            break; /* Loop/switch isn't completed */
        }
        int k = contestinfo1.submitStartDate.compareTo(contestinfo.submitStartDate);
        i = k;
        if (k == 0)
        {
            return contestinfo.submitEndDate.compareTo(contestinfo.submitEndDate);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (i1 != com.cyberlink.beautycircle.model.est.ContestInfo.EVENT_VOTING)
        {
            break; /* Loop/switch isn't completed */
        }
        int l = contestinfo1.voteStartDate.compareTo(contestinfo.voteStartDate);
        i = l;
        if (l == 0)
        {
            return contestinfo.voteEndDate.compareTo(contestinfo.voteEndDate);
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (i1 == com.cyberlink.beautycircle.model.est.ContestInfo.EVENT_UPCOMING)
        {
            return contestinfo.submitStartDate.compareTo(contestinfo1.submitStartDate);
        }
        i = ((flag) ? 1 : 0);
        if (i1 == com.cyberlink.beautycircle.model.est.ContestInfo.EVENT_EXPIRED)
        {
            return contestinfo1.voteEndDate.compareTo(contestinfo.voteEndDate);
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public int compare(Object obj, Object obj1)
    {
        return a((com.cyberlink.beautycircle.model.est.ContestInfo)obj, (com.cyberlink.beautycircle.model.est.ContestInfo)obj1);
    }

    fo(f f1)
    {
        a = f1;
        super();
    }
}
