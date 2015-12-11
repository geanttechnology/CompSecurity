// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.am;

import com.google.api.services.now.Now;
import com.google.api.services.now.model.Card;
import com.google.api.services.now.model.Context;
import com.google.api.services.now.model.ContextTimeContextWrapper;
import com.google.api.services.now.model.ListCardsResponse;
import com.google.api.services.now.model.ListContextsResponse;
import com.google.api.services.now.model.TimeRange;
import com.google.api.services.now.model.Timestamp;
import com.shazam.b.e.a;
import com.shazam.n.m;
import com.shazam.o.b;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.shazam.android.am:
//            f

public final class p
    implements f
{

    private static final List a = Collections.singletonList((new ContextTimeContextWrapper()).setTimeContext("leisure"));
    private final com.google.api.services.now.Now.Contexts b;
    private final com.google.api.services.now.Now.Users.Cards c;
    private final m d;

    public p(Now now, m m1)
    {
        d = m1;
        b = now.contexts();
        c = now.users().cards();
    }

    private static Timestamp a(long l)
    {
        return (new Timestamp()).setSeconds(Long.valueOf(l));
    }

    public final Context a(TimeUnit timeunit)
    {
        long l = TimeUnit.SECONDS.convert(d.a(), TimeUnit.MILLISECONDS);
        long l1 = TimeUnit.SECONDS.convert(2L, timeunit);
        timeunit = (new TimeRange()).setStartTime(a(l)).setEndTime(a(l1 + l));
        return (new Context()).setTimeRange(timeunit);
    }

    public final String a()
    {
        Object obj;
        obj = ((ListContextsResponse)b.list().execute()).getContexts();
        if (com.shazam.o.b.a(((java.util.Collection) (obj))))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj = ((List) (obj)).iterator();
_L2:
        Context context1;
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_109;
            }
            context1 = (Context)((Iterator) (obj)).next();
            obj1 = context1.getAnyOfTimeContexts();
        } while (obj1 == null);
        obj1 = ((List) (obj1)).iterator();
_L4:
        if (!((Iterator) (obj1)).hasNext()) goto _L2; else goto _L1
_L1:
        if (!((ContextTimeContextWrapper)((Iterator) (obj1)).next()).getTimeContext().equals("leisure")) goto _L4; else goto _L3
_L3:
        obj = context1.getContextId();
_L5:
        if (com.shazam.b.e.a.c(((String) (obj))))
        {
            return ((String) (obj));
        } else
        {
            Context context = (new Context()).setAnyOfTimeContexts(a);
            return ((Context)b.create(context).execute()).getContextId();
        }
        obj = null;
          goto _L5
    }

    public final void a(Card card)
    {
        Object obj = ((ListCardsResponse)c.list("shazam_google_now").execute()).getCards();
        if (com.shazam.o.b.b(((java.util.Collection) (obj))))
        {
            obj = ((Card)((List) (obj)).get(0)).getCardId();
        } else
        {
            obj = null;
        }
        if (com.shazam.b.e.a.c(((String) (obj))))
        {
            card.setCardId(((String) (obj)));
            c.update("shazam_google_now", ((String) (obj)), card).execute();
            return;
        } else
        {
            c.create("shazam_google_now", card).execute();
            return;
        }
    }

}
