// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.database.Cursor;
import android.widget.FilterQueryProvider;
import com.poshmark.data_model.adapters.UserInteractionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.UserInteractions;

// Referenced classes of package com.poshmark.ui.fragments:
//            CommentFragment

class this._cls0
    implements FilterQueryProvider
{

    final CommentFragment this$0;

    public Cursor runQuery(CharSequence charsequence)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (charsequence != null)
        {
            obj = charsequence.toString();
            charsequence = ((CharSequence) (obj));
            if (((String) (obj)).indexOf(" ") != -1)
            {
                int i = ((String) (obj)).lastIndexOf(" ");
                charsequence = ((CharSequence) (obj));
                if (i != ((String) (obj)).length() - 1)
                {
                    obj = ((String) (obj)).substring(i + 1).trim();
                    charsequence = ((CharSequence) (obj));
                    if (((String) (obj)).length() < 2);
                }
            }
            obj = obj1;
            if (charsequence.length() > 1)
            {
                obj = obj1;
                if (charsequence.toString().startsWith("@"))
                {
                    obj = adapter.getCursor();
                    if (obj != null)
                    {
                        ((Cursor) (obj)).close();
                    }
                    obj = new CustomMatrixCursor(new String[] {
                        PMData.ID_COL, PMData.DATA_COL
                    });
                    interactionsData.fillFilteredCursor(((CustomMatrixCursor) (obj)), charsequence.substring(1));
                }
            }
        }
        return ((Cursor) (obj));
    }

    ons()
    {
        this$0 = CommentFragment.this;
        super();
    }
}
