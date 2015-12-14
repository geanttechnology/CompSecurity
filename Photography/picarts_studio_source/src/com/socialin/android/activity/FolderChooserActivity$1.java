// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.view.View;
import android.widget.AdapterView;
import com.socialin.android.util.Utils;

// Referenced classes of package com.socialin.android.activity:
//            FolderChooserActivity, b

final class a
    implements android.widget.istener
{

    private FolderChooserActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        int j;
        adapterview = FolderChooserActivity.access$200(a, (new StringBuilder()).append(FolderChooserActivity.access$000(a)).append("/").append((String)FolderChooserActivity.access$100(a).getItem(i)).toString());
        FolderChooserActivity.access$100(a).clear();
        j = adapterview.length;
        i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        view = adapterview[i];
        FolderChooserActivity.access$100(a).add(view);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            FolderChooserActivity.access$100(a).notifyDataSetChanged();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (AdapterView adapterview)
        {
            Utils.a(a, 0x7f080296);
        }
        return;
    }

    (FolderChooserActivity folderchooseractivity)
    {
        a = folderchooseractivity;
        super();
    }
}
