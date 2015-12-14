// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.history.RasterAction;
import com.picsart.studio.editor.item.CalloutItem;
import com.picsart.studio.editor.item.ImageItem;
import com.picsart.studio.editor.item.Item;
import com.picsart.studio.editor.item.LensFlareItem;
import com.picsart.studio.editor.item.SvgClipArtItem;
import com.picsart.studio.editor.item.TextItem;
import com.picsart.studio.editor.view.ItemEditorView;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            q

final class a
    implements android.view.OnClickListener
{

    private q a;

    public final void onClick(View view)
    {
        Object obj;
        Iterator iterator;
        try
        {
            view = com.picsart.studio.editor.fragment.q.a(a).f();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            view = new b();
            view.b = a.getString(0x7f08094c);
            view.h = false;
            view.a().show(a.getFragmentManager(), null);
            System.gc();
            return;
        }
        com.picsart.studio.editor.fragment.q.a(a, "done");
        obj = new HashSet();
        iterator = com.picsart.studio.editor.fragment.q.a(a).g().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Item item = (Item)iterator.next();
            if (item instanceof LensFlareItem)
            {
                ((Set) (obj)).add("lensflare");
            } else
            if (item instanceof CalloutItem)
            {
                ((Set) (obj)).add("callout");
            } else
            if (item instanceof ImageItem)
            {
                ((Set) (obj)).add("image");
            } else
            if (item instanceof SvgClipArtItem)
            {
                ((Set) (obj)).add("clipart");
            } else
            if (item instanceof TextItem)
            {
                ((Set) (obj)).add("text");
            }
        } while (true);
        String s;
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext(); e.a().e.d(s))
        {
            s = (String)((Iterator) (obj)).next();
        }

        a.g.a(a, view, RasterAction.create(view, e.a().d.getHistoryDataDirectory()));
    }

    Action(q q1)
    {
        a = q1;
        super();
    }
}
