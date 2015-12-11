// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.parse:
//            FindCallback, ParseQueryAdapter, ParseException, Parse, 
//            ParseQuery

class val.page
    implements FindCallback
{

    final ParseQueryAdapter this$0;
    final cs val$firstCallBack;
    final int val$page;
    final ParseQuery val$query;
    final boolean val$shouldClear;

    public volatile void done(Object obj, Throwable throwable)
    {
        done((List)obj, (ParseException)throwable);
    }

    public void done(List list, ParseException parseexception)
    {
        if (!Parse.isLocalDatastoreEnabled() && val$query.getCachePolicy() == cy.CACHE_ONLY && parseexception != null && parseexception.getCode() == 120)
        {
            return;
        }
        if (parseexception == null || parseexception.getCode() != 100 && parseexception.getCode() == 120) goto _L2; else goto _L1
_L1:
        ParseQueryAdapter.access$002(ParseQueryAdapter.this, true);
_L4:
        ParseQueryAdapter.access$600(ParseQueryAdapter.this, list, parseexception);
        return;
_L2:
        if (list != null)
        {
            if (val$shouldClear && ((Boolean)val$firstCallBack.a()).booleanValue())
            {
                ParseQueryAdapter.access$100(ParseQueryAdapter.this).clear();
                ParseQueryAdapter.access$100(ParseQueryAdapter.this).add(new ArrayList());
                ParseQueryAdapter.access$202(ParseQueryAdapter.this, val$page);
                val$firstCallBack.a(Boolean.valueOf(false));
            }
            if (val$page >= ParseQueryAdapter.access$200(ParseQueryAdapter.this))
            {
                ParseQueryAdapter.access$202(ParseQueryAdapter.this, val$page);
                Object obj = ParseQueryAdapter.this;
                boolean flag;
                if (list.size() > ParseQueryAdapter.access$300(ParseQueryAdapter.this))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                ParseQueryAdapter.access$002(((ParseQueryAdapter) (obj)), flag);
            }
            if (ParseQueryAdapter.access$400(ParseQueryAdapter.this) && list.size() > ParseQueryAdapter.access$300(ParseQueryAdapter.this))
            {
                list.remove(ParseQueryAdapter.access$300(ParseQueryAdapter.this));
            }
            obj = (List)ParseQueryAdapter.access$100(ParseQueryAdapter.this).get(val$page);
            ((List) (obj)).clear();
            ((List) (obj)).addAll(list);
            ParseQueryAdapter.access$500(ParseQueryAdapter.this);
            notifyDataSetChanged();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    cy()
    {
        this$0 = final_parsequeryadapter;
        val$query = parsequery;
        val$shouldClear = flag;
        val$firstCallBack = cs1;
        val$page = I.this;
        super();
    }
}
