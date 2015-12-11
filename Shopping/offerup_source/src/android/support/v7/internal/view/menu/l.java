// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

// Referenced classes of package android.support.v7.internal.view.menu:
//            y, i, g, m

public final class l
    implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnKeyListener, y
{

    private i a;
    private AlertDialog b;
    private g c;

    public l(i j)
    {
        a = j;
    }

    public final void a(IBinder ibinder)
    {
        ibinder = a;
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(ibinder.d());
        c = new g(builder.getContext(), android.support.v7.appcompat.R.layout.abc_list_menu_item_layout);
        c.a(this);
        a.a(c);
        builder.setAdapter(c.a(), this);
        View view = ((i) (ibinder)).c;
        if (view != null)
        {
            builder.setCustomTitle(view);
        } else
        {
            builder.setIcon(((i) (ibinder)).b).setTitle(((i) (ibinder)).a);
        }
        builder.setOnKeyListener(this);
        b = builder.create();
        b.setOnDismissListener(this);
        ibinder = b.getWindow().getAttributes();
        ibinder.type = 1003;
        ibinder.flags = ((android.view.WindowManager.LayoutParams) (ibinder)).flags | 0x20000;
        b.show();
    }

    public final void onClick(DialogInterface dialoginterface, int j)
    {
        a.a((m)c.a().getItem(j), 0);
    }

    public final void onCloseMenu(i j, boolean flag)
    {
        if ((flag || j == a) && b != null)
        {
            b.dismiss();
        }
    }

    public final void onDismiss(DialogInterface dialoginterface)
    {
        c.onCloseMenu(a, true);
    }

    public final boolean onKey(DialogInterface dialoginterface, int j, KeyEvent keyevent)
    {
        if (j == 82 || j == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                dialoginterface = b.getWindow();
                if (dialoginterface != null)
                {
                    dialoginterface = dialoginterface.getDecorView();
                    if (dialoginterface != null)
                    {
                        dialoginterface = dialoginterface.getKeyDispatcherState();
                        if (dialoginterface != null)
                        {
                            dialoginterface.startTracking(keyevent, this);
                            return true;
                        }
                    }
                }
            } else
            if (keyevent.getAction() == 1 && !keyevent.isCanceled())
            {
                Object obj = b.getWindow();
                if (obj != null)
                {
                    obj = ((Window) (obj)).getDecorView();
                    if (obj != null)
                    {
                        obj = ((View) (obj)).getKeyDispatcherState();
                        if (obj != null && ((android.view.KeyEvent.DispatcherState) (obj)).isTracking(keyevent))
                        {
                            a.a(true);
                            dialoginterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return a.performShortcut(j, keyevent, 0);
    }

    public final boolean onOpenSubMenu(i j)
    {
        return false;
    }
}
