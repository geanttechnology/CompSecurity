// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.internal.view.menu.MenuBuilder;
import android.support.v7.internal.view.menu.MenuItemImpl;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;

public class ah
    implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnKeyListener, as
{

    ad a;
    private MenuBuilder b;
    private AlertDialog c;
    private as d;

    public ah(MenuBuilder menubuilder)
    {
        b = menubuilder;
    }

    public void a()
    {
        if (c != null)
        {
            c.dismiss();
        }
    }

    public void a(IBinder ibinder)
    {
        Object obj = b;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(((MenuBuilder) (obj)).e());
        a = new ad(android.support.v7.appcompat.R.layout.abc_list_menu_item_layout, android.support.v7.appcompat.R.style.Theme_AppCompat_CompactMenu);
        a.a(this);
        b.a(a);
        builder.setAdapter(a.a(), this);
        View view = ((MenuBuilder) (obj)).o();
        if (view != null)
        {
            builder.setCustomTitle(view);
        } else
        {
            builder.setIcon(((MenuBuilder) (obj)).n()).setTitle(((MenuBuilder) (obj)).m());
        }
        builder.setOnKeyListener(this);
        c = builder.create();
        c.setOnDismissListener(this);
        obj = c.getWindow().getAttributes();
        obj.type = 1003;
        if (ibinder != null)
        {
            obj.token = ibinder;
        }
        obj.flags = ((android.view.WindowManager.LayoutParams) (obj)).flags | 0x20000;
        c.show();
    }

    public void a(MenuBuilder menubuilder, boolean flag)
    {
        if (flag || menubuilder == b)
        {
            a();
        }
        if (d != null)
        {
            d.a(menubuilder, flag);
        }
    }

    public boolean a(MenuBuilder menubuilder)
    {
        if (d != null)
        {
            return d.a(menubuilder);
        } else
        {
            return false;
        }
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        b.a((MenuItemImpl)a.a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        a.a(b, true);
    }

    public boolean onKey(DialogInterface dialoginterface, int i, KeyEvent keyevent)
    {
        if (i == 82 || i == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                dialoginterface = c.getWindow();
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
                Object obj = c.getWindow();
                if (obj != null)
                {
                    obj = ((Window) (obj)).getDecorView();
                    if (obj != null)
                    {
                        obj = ((View) (obj)).getKeyDispatcherState();
                        if (obj != null && ((android.view.KeyEvent.DispatcherState) (obj)).isTracking(keyevent))
                        {
                            b.a(true);
                            dialoginterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return b.performShortcut(i, keyevent, 0);
    }
}
