// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;

import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.utils.DateUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.models:
//            PMData, PartyEvent

public class EventList extends PMData
{

    List currentParties;
    List data;
    List futureParties;
    PMData.NextMaxID more;
    List pastParties;

    public EventList()
    {
        data = Collections.synchronizedList(new ArrayList());
        more = null;
        currentParties = new ArrayList();
        pastParties = new ArrayList();
        futureParties = new ArrayList();
    }

    public void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (data == null) goto _L2; else goto _L1
_L1:
        List list = data;
        list;
        JVM INSTR monitorenter ;
        for (Iterator iterator = data.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (PartyEvent)iterator.next()
})) { }
        break MISSING_BLOCK_LABEL_68;
        custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
        throw custommatrixcursor;
        list;
        JVM INSTR monitorexit ;
_L2:
    }

    public List filterParties()
    {
        Date date = new Date();
        Iterator iterator = data.iterator();
        futureParties.clear();
        pastParties.clear();
        currentParties.clear();
        while (iterator.hasNext()) 
        {
            PartyEvent partyevent = (PartyEvent)iterator.next();
            if (true)
            {
                Date date1 = DateUtils.getDateFromString(partyevent.start_time);
                if (date1.after(date))
                {
                    futureParties.add(partyevent);
                } else
                if (DateUtils.isDateWithinPastWindow(date1, partyevent.duration.longValue(), com.poshmark.utils.DateUtils.TIME_UNIT.SECONDS))
                {
                    currentParties.add(partyevent);
                } else
                {
                    pastParties.add(partyevent);
                }
            } else
            {
                pastParties.add(partyevent);
            }
        }
        return currentParties;
    }

    public List getCurrentParties()
    {
        return currentParties;
    }

    public int getCurrentPartiesCount()
    {
        return currentParties.size();
    }

    public int getEventsCount()
    {
        return futureParties.size() + currentParties.size() + pastParties.size();
    }

    public List getFutureParties()
    {
        return futureParties;
    }

    public PartyEvent getParty(String s)
    {
        for (Iterator iterator = data.iterator(); iterator.hasNext();)
        {
            PartyEvent partyevent = (PartyEvent)iterator.next();
            if (s.equals(partyevent.getId()))
            {
                return partyevent;
            }
        }

        return null;
    }

    public List getPastParties()
    {
        return pastParties;
    }

    public int getPastPartiesCount()
    {
        return pastParties.size();
    }

    public int getUpcomingPartiesCount()
    {
        return futureParties.size();
    }
}
