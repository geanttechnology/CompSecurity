// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.utils;

import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.hockeyapp.android.utils:
//            VersionHelper

class this._cls0
    implements Comparator
{

    final VersionHelper this$0;

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((JSONObject)obj, (JSONObject)obj1);
    }

    public int compare(JSONObject jsonobject, JSONObject jsonobject1)
    {
        int i;
        int j;
        try
        {
            i = jsonobject.getInt("version");
            j = jsonobject1.getInt("version");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return 0;
        }
        if (i <= j);
        return 0;
    }

    ()
    {
        this$0 = VersionHelper.this;
        super();
    }
}
