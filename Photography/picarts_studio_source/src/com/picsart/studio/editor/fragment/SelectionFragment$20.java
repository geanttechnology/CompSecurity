// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import com.socialin.android.photo.freecrop.b;
import com.socialin.android.photo.select.SelectionHistoryStack;
import com.socialin.android.util.w;
import java.io.File;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class c
    implements Runnable
{

    final SelectionFragment a;
    private Activity b;
    private Bitmap c;

    public final void run()
    {
        String s = com.socialin.android.photo.freecrop.b.a(SelectionFragment.r(a));
        if (s != null)
        {
            File file = new File(s);
            boolean flag1 = false;
            boolean flag = flag1;
            if (c != null)
            {
                flag = flag1;
                if (!c.isRecycled())
                {
                    w.a(s, c);
                    flag = true;
                }
            }
            if (flag)
            {
                Object obj = SelectionFragment.y(a).a(new com.socialin.android.photo.select..SelectionHistoryItem(file));
                if (obj != null && ((com.socialin.android.photo.select..SelectionHistoryItem) (obj)).c == com.socialin.android.photo.select..SelectionHistoryItem.SelectionHistoryType.File)
                {
                    obj = ((com.socialin.android.photo.select..SelectionHistoryItem) (obj)).a;
                    if (obj != null)
                    {
                        ((File) (obj)).delete();
                    }
                }
                b.runOnUiThread(new Runnable() {

                    private SelectionFragment._cls20 a;

                    public final void run()
                    {
                        SelectionFragment.A(a.a);
                    }

            
            {
                a = SelectionFragment._cls20.this;
                super();
            }
                });
            }
        }
    }

    _cls1.a(SelectionFragment selectionfragment, Activity activity, Bitmap bitmap)
    {
        a = selectionfragment;
        b = activity;
        c = bitmap;
        super();
    }
}
