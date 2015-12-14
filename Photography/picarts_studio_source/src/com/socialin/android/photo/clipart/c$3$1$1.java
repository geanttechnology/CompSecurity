// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clipart;

import android.app.Activity;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.picsart.studio.ItemType;
import com.socialin.android.apiv3.controllers.RemoveItemController;
import com.socialin.android.apiv3.model.ImageItem;
import com.socialin.android.apiv3.request.ParamWithItemId;
import com.socialin.android.constants.CommonConstants;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import java.io.File;
import java.util.List;
import myobfuscated.cb.c;

// Referenced classes of package com.socialin.android.photo.clipart:
//            c, e

final class a
    implements d
{

    private a a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        Utils.b(a.a.a, a.a.a.getString(0x7f0805cb));
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        if (a.a.a.isVisible() && a.a.a.a == com.socialin.android.photo.clipart.c.a(a.a.a))
        {
            c.n(a.a.a);
            c.o(a.a.a);
            if (c.p(a.a.a) == 0)
            {
                c.q(a.a.a);
            }
        }
    }

    nts(nts nts)
    {
        a = nts;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/clipart/c$3

/* anonymous class */
    final class c._cls3
        implements android.widget.AbsListView.MultiChoiceModeListener
    {

        final List a;
        final Activity b;
        final List c;
        final List d;
        final com.socialin.android.photo.clipart.c e;

        public final boolean onActionItemClicked(ActionMode actionmode, MenuItem menuitem)
        {
            if (menuitem.getItemId() == 1)
            {
                actionmode = new b();
                actionmode.b = b.getString(0x7f0805ea);
                actionmode.a(e.getString(0x7f080311)).a(new c._cls3._cls1(this)).b(e.getString(0x7f080295)).a().show(b.getFragmentManager(), null);
            }
            return true;
        }

        public final boolean onCreateActionMode(ActionMode actionmode, Menu menu)
        {
            actionmode.setTitle(e.getString(0x7f080583));
            menu.add(0, 1, 0, "Delete").setTitle(e.getString(0x7f080583)).setIcon(0x7f02033d);
            return true;
        }

        public final void onDestroyActionMode(ActionMode actionmode)
        {
            a.clear();
        }

        public final void onItemCheckedStateChanged(ActionMode actionmode, int i, long l, boolean flag)
        {
            int j;
            boolean flag1;
            flag1 = false;
            j = 0;
            if (!flag) goto _L2; else goto _L1
_L1:
            if (i >= com.socialin.android.photo.clipart.c.c(e).size()) goto _L4; else goto _L3
_L3:
            a.add(com.socialin.android.photo.clipart.c.c(e).get(i));
_L6:
            return;
_L4:
            actionmode = ((c)com.socialin.android.photo.clipart.c.l(e).get(i)).d;
            String s = actionmode.substring(actionmode.lastIndexOf("/"));
            String s1 = actionmode.substring(actionmode.lastIndexOf("/") + 1, actionmode.length());
            c.add(actionmode);
            d.add(com.socialin.android.photo.clipart.e.b(s, s1));
            return;
_L2:
            if (i >= com.socialin.android.photo.clipart.c.c(e).size())
            {
                break; /* Loop/switch isn't completed */
            }
            while (j < a.size()) 
            {
                if (((ImageItem)a.get(j)).id == ((ImageItem)com.socialin.android.photo.clipart.c.c(e).get(i)).id)
                {
                    a.remove(j);
                    return;
                }
                j++;
            }
            if (true) goto _L6; else goto _L5
_L5:
            actionmode = ((c)com.socialin.android.photo.clipart.c.l(e).get(i)).d;
            i = ((flag1) ? 1 : 0);
            while (i < c.size()) 
            {
                if (((String)c.get(i)).equals(actionmode))
                {
                    c.remove(i);
                    d.remove(i);
                    return;
                }
                i++;
            }
            if (true) goto _L6; else goto _L7
_L7:
        }

        public final boolean onPrepareActionMode(ActionMode actionmode, Menu menu)
        {
            return true;
        }

            
            {
                e = c1;
                a = list;
                b = activity;
                c = list1;
                d = list2;
                super();
            }
    }


    // Unreferenced inner class com/socialin/android/photo/clipart/c$3$1

/* anonymous class */
    final class c._cls3._cls1
        implements android.view.View.OnClickListener
    {

        final c._cls3 a;

        public final void onClick(View view)
        {
            boolean flag = false;
            com.socialin.android.photo.clipart.c.a(a.e, a.a.size());
            a.e.e(0x7f1007e7).setVisibility(0);
            int i = 0;
            int j;
            do
            {
                j = ((flag) ? 1 : 0);
                if (i >= a.a.size())
                {
                    break;
                }
                view = (ImageItem)a.a.get(i);
                com.socialin.android.photo.clipart.c.a(a.e, new ParamWithItemId());
                c.m(a.e).itemId = ((ImageItem) (view)).id;
                com.socialin.android.photo.clipart.c.a(a.e, new RemoveItemController());
                c.r(a.e).setRequestCompleteListener(new c._cls3._cls1._cls1(this));
                c.r(a.e).doRequest(com.socialin.android.photo.clipart.c.a(), c.m(a.e));
                Object obj = (new StringBuilder()).append(CommonConstants.b[ItemType.CLIPART.getValue()]).append(String.valueOf(((ImageItem) (view)).id)).toString();
                view = new File(com.socialin.android.photo.clipart.e.a(c.i(a.e), ((String) (obj))));
                obj = new File(com.socialin.android.photo.clipart.e.b(c.g(a.e), ((String) (obj))));
                if (view.exists() && !view.delete())
                {
                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete synced clipart");
                }
                if (((File) (obj)).exists() && !((File) (obj)).delete())
                {
                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete synced clipart icon");
                }
                i++;
            } while (true);
            for (; j < a.c.size(); j++)
            {
                if (a.c.get(j) != null)
                {
                    view = new File((String)a.c.get(j));
                    if (view.exists() && !view.delete())
                    {
                        Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete local clipart");
                    }
                }
                if (a.d.get(j) == null)
                {
                    continue;
                }
                view = new File((String)a.d.get(j));
                if (view.exists() && !view.delete())
                {
                    Log.e(com.socialin.android.photo.clipart.c.a(), "Failed to delete local clipart icon");
                }
            }

            a.c.clear();
            a.d.clear();
            if (a.a.size() == 0)
            {
                c.q(a.e);
            }
            a.a.clear();
        }

            
            {
                a = _pcls3;
                super();
            }
    }

}
