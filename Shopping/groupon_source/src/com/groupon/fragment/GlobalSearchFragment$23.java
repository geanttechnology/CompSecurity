// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;
import com.groupon.activity.GlobalSearch;
import com.groupon.util.Function1;
import com.groupon.util.GeoUtils;
import java.io.IOException;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.locationKeyword
    implements Function1
{

    final GlobalSearchFragment this$0;
    final String val$locationKeyword;

    public void execute(Exception exception)
        throws RuntimeException
    {
        if (exception instanceof IOException)
        {
            Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080162), 1).show();
        } else
        if (exception instanceof NullPointerException)
        {
            Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080155), 1).show();
        } else
        {
            Toast.makeText(getActivity().getApplicationContext(), 0x7f080165, 1).show();
        }
        GlobalSearchFragment.access$3200(GlobalSearchFragment.this).logGeocodeException(exception, com/groupon/activity/GlobalSearch.getSimpleName());
        GlobalSearchFragment.access$500(GlobalSearchFragment.this).setText(val$locationKeyword);
        GlobalSearchFragment.access$500(GlobalSearchFragment.this).requestFocus();
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Exception)obj);
    }

    ()
    {
        this$0 = final_globalsearchfragment;
        val$locationKeyword = String.this;
        super();
    }
}
