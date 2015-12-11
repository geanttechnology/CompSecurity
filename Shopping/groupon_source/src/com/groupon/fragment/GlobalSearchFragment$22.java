// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;
import com.groupon.models.Place;
import com.groupon.util.Function1;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class val.locationKeyword
    implements Function1
{

    final GlobalSearchFragment this$0;
    final String val$locationKeyword;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        GlobalSearchFragment.access$500(GlobalSearchFragment.this).clearFocus();
        String s;
        EditText edittext;
        if (list != null && !list.isEmpty())
        {
            GlobalSearchFragment.access$600(GlobalSearchFragment.this).saveRecentLocation((Place)list.get(0));
        } else
        {
            Toast.makeText(getActivity().getApplicationContext(), getString(0x7f080155), 1).show();
        }
        edittext = GlobalSearchFragment.access$500(GlobalSearchFragment.this);
        if (list != null && !list.isEmpty())
        {
            s = ((Place)list.get(0)).name;
        } else
        {
            s = val$locationKeyword;
        }
        edittext.setText(s);
        if (list != null)
        {
            GlobalSearchFragment.access$3100(GlobalSearchFragment.this);
            return;
        } else
        {
            GlobalSearchFragment.access$500(GlobalSearchFragment.this).requestFocus();
            return;
        }
    }

    Wrapper()
    {
        this$0 = final_globalsearchfragment;
        val$locationKeyword = String.this;
        super();
    }
}
