// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.activity;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import com.cyberlink.you.database.d;
import com.cyberlink.you.e;
import java.util.List;

// Referenced classes of package com.cyberlink.you.activity:
//            SelectGroupActivity

class a extends AsyncTask
{

    final SelectGroupActivity a;

    protected transient List a(Void avoid[])
    {
        return e.f().b();
    }

    protected void a(List list)
    {
        if (list != null)
        {
            SelectGroupActivity.a(a).clear();
            SelectGroupActivity.a(a).addAll(list);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }

    (SelectGroupActivity selectgroupactivity)
    {
        a = selectgroupactivity;
        super();
    }
}
