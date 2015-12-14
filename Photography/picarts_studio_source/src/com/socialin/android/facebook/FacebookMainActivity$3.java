// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookMainActivity, FacebookPagingFragment, a, g

final class a
    implements android.support.v7.widget.istener
{

    private FacebookPagingFragment a;
    private FacebookMainActivity b;

    public final boolean onQueryTextChange(String s)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        Object obj;
        ArrayList arraylist;
        obj = a;
        obj.d = s;
        obj = ((FacebookPagingFragment) (obj)).c;
        arraylist = new ArrayList();
        if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        ((a) (obj)).setItems(((a) (obj)).a);
_L2:
        return true;
_L4:
        if (((a) (obj)).getItemCount() != 0)
        {
            for (int i = 0; i < ((a) (obj)).a.size(); i++)
            {
                String s1 = ((g)((a) (obj)).a.get(i)).getTitle();
                if (TextUtils.isEmpty(s1) || s1.length() < s.length())
                {
                    continue;
                }
                s1 = s1.substring(0, s.length()).toLowerCase();
                if (!TextUtils.isEmpty(s1) && s.equalsIgnoreCase(s1))
                {
                    arraylist.add(((a) (obj)).a.get(i));
                }
            }

            ((a) (obj)).setItems(arraylist);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final boolean onQueryTextSubmit(String s)
    {
        FacebookMainActivity.a(b).clearFocus();
        return false;
    }

    ner(FacebookMainActivity facebookmainactivity, FacebookPagingFragment facebookpagingfragment)
    {
        b = facebookmainactivity;
        a = facebookpagingfragment;
        super();
    }
}
