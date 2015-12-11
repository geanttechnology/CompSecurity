// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.b.a.a.j;
import com.offerup.android.dto.Discussion;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.dto.response.DiscussionsResponse;
import com.offerup.android.network.c;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity, a, ChatActivity

public final class ea extends AsyncTask
{

    private Item a;
    private MyOffersActivity b;

    public ea(MyOffersActivity myoffersactivity, Item item)
    {
        b = myoffersactivity;
        super();
        a = item;
    }

    protected final Object doInBackground(Object aobj[])
    {
        return c.a(a.getId());
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (DiscussionsResponse)obj;
        b.i();
        if (obj == null || !((DiscussionsResponse) (obj)).isSuccess())
        {
            MyOffersActivity.a(b, true, a);
            return;
        }
        if (((DiscussionsResponse) (obj)).getDiscussions().size() <= 0) goto _L2; else goto _L1
_L1:
        obj = ((DiscussionsResponse) (obj)).getDiscussions().iterator();
_L6:
        if (!((Iterator) (obj)).hasNext()) goto _L4; else goto _L3
_L3:
        Discussion discussion = (Discussion)((Iterator) (obj)).next();
        if (discussion.getBuyer().getId() != b.e.n()) goto _L6; else goto _L5
_L5:
        long l = discussion.getId();
_L8:
        if (l < 0L)
        {
            Toast.makeText(b, (new StringBuilder("Could not retrieve messages for ")).append(a.getTitle()).toString(), 1).show();
            return;
        } else
        {
            obj = b.f;
            Intent intent = new Intent(((a) (obj)).a, com/offerup/android/activities/ChatActivity);
            intent.putExtra("discussionId", l);
            ((a) (obj)).a.startActivity(intent);
            return;
        }
_L2:
        Toast.makeText(b, (new StringBuilder("Could not retrieve messages for ")).append(a.getTitle()).toString(), 1).show();
        return;
_L4:
        l = -1L;
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected final void onPreExecute()
    {
        b.g = ProgressDialog.show(b, "", (new StringBuilder("Fetching messages for ")).append(a.getTitle()).toString());
    }
}
