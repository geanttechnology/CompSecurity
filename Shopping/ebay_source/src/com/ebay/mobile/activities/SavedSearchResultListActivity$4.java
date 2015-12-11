// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.Arrays;
import java.util.HashSet;

// Referenced classes of package com.ebay.mobile.activities:
//            SavedSearchResultListActivity

class this._cls0
    implements android.view.
{

    final SavedSearchResultListActivity this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        if (SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this) != null && SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).result != null && SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).result.searchUrl != null) goto _L2; else goto _L1
_L1:
        Toast.makeText(SavedSearchResultListActivity.this, "There are no search results!", 1).show();
_L4:
        return true;
_L2:
label0:
        {
            menuitem = SavedSearchResultListActivity.access$500(SavedSearchResultListActivity.this).result.searchUrl;
            Object obj = Uri.parse(menuitem);
            Object obj1 = ((Uri) (obj)).getEncodedQuery();
            if (obj1 == null)
            {
                break label0;
            }
            menuitem = new HashSet(Arrays.asList(new String[] {
                "_pos", "_stpos", "_ipg", "_pgn", "_os"
            }));
            obj1 = new StringBuilder(((String) (obj1)));
            int j = 0;
label1:
            do
            {
                int i;
label2:
                {
                    if (j >= ((StringBuilder) (obj1)).length())
                    {
                        break label1;
                    }
                    int l = ((StringBuilder) (obj1)).indexOf("&", j);
                    int k;
                    int i1;
                    if (l == -1)
                    {
                        i = ((StringBuilder) (obj1)).length();
                    } else
                    {
                        i = l;
                    }
                    i1 = ((StringBuilder) (obj1)).indexOf("=", j);
                    if (i1 != -1)
                    {
                        k = i1;
                        if (i1 <= i)
                        {
                            break label2;
                        }
                    }
                    k = i;
                }
                if (menuitem.contains(((StringBuilder) (obj1)).substring(j, k)))
                {
                    if (l != -1)
                    {
                        ((StringBuilder) (obj1)).delete(j, l + 1);
                    } else
                    if (j > 0)
                    {
                        ((StringBuilder) (obj1)).delete(j - 1, i);
                    } else
                    {
                        ((StringBuilder) (obj1)).delete(j, i);
                    }
                } else
                {
                    j = i + 1;
                }
            } while (true);
            if (((StringBuilder) (obj1)).length() == 0)
            {
                menuitem = null;
            } else
            {
                menuitem = ((StringBuilder) (obj1)).toString();
            }
            menuitem = ((Uri) (obj)).buildUpon().searchUrl(menuitem).searchUrl().toString();
        }
        obj = new Intent("android.intent.action.SEND");
        ((Intent) (obj)).setType("text/plain");
        ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", "URL for RTM");
        ((Intent) (obj)).putExtra("android.intent.extra.TEXT", menuitem);
        menuitem = Intent.createChooser(((Intent) (obj)), "URL for RTM");
        startActivity(menuitem);
        if (true) goto _L4; else goto _L3
_L3:
    }

    esult()
    {
        this$0 = SavedSearchResultListActivity.this;
        super();
    }
}
