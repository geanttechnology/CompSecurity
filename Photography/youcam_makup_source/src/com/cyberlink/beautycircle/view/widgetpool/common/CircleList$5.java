// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONArray;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList

final class  extends j
{

    protected volatile Object a(Object obj)
    {
        return a((TreeSet)obj);
    }

    protected Void a(TreeSet treeset)
    {
        ArrayList arraylist = new ArrayList();
        if (treeset != null)
        {
            for (treeset = treeset.iterator(); treeset.hasNext(); arraylist.add(((CircleBasic)treeset.next()).id)) { }
        }
        Globals.D().edit().putString("LastShareInCircleIds", Model.b(arraylist).toString()).apply();
        return null;
    }

    ()
    {
    }
}
