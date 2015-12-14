// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.editview.savemylook;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cyberlink.youcammakeup.a;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.pages.editview.savemylook:
//            a

public class LookItemPopupMenu extends a
{

    public static final UUID a = UUID.randomUUID();
    private View b;
    private View c;
    private View d;
    private View e;
    private View f;
    private com.cyberlink.youcammakeup.pages.editview.savemylook.a g;
    private boolean h;
    private boolean i;
    private android.view.View.OnClickListener j;
    private android.view.View.OnClickListener k;
    private android.content.DialogInterface.OnKeyListener l;

    public LookItemPopupMenu()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        g = null;
        j = new android.view.View.OnClickListener() {

            final LookItemPopupMenu a;

            public void onClick(View view)
            {
                if (LookItemPopupMenu.c(a) == null)
                {
                    LookItemPopupMenu.d(a);
                    return;
                }
                if (view != LookItemPopupMenu.e(a)) goto _L2; else goto _L1
_L1:
                LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), com.cyberlink.youcammakeup.pages.editview.savemylook.Action.a);
_L4:
                LookItemPopupMenu.d(a);
                return;
_L2:
                if (view == LookItemPopupMenu.f(a))
                {
                    LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), Action.b);
                } else
                if (view == LookItemPopupMenu.g(a))
                {
                    LookItemPopupMenu.c(a).a(LookItemPopupMenu.b(a), Action.c);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = LookItemPopupMenu.this;
                super();
            }

            private class Action extends Enum
            {

                public static final Action a;
                public static final Action b;
                public static final Action c;
                private static final Action d[];

                public static Action valueOf(String s)
                {
                    return (Action)Enum.valueOf(com/cyberlink/youcammakeup/pages/editview/savemylook/LookItemPopupMenu$Action, s);
                }

                public static Action[] values()
                {
                    return (Action[])d.clone();
                }

                static 
                {
                    a = new Action("DELETE", 0);
                    b = new Action("RENAME", 1);
                    c = new Action("DETAILS", 2);
                    d = (new Action[] {
                        a, b, c
                    });
                }

                private Action(String s, int i1)
                {
                    super(s, i1);
                }
            }

        };
        k = new android.view.View.OnClickListener() {

            final LookItemPopupMenu a;

            public void onClick(View view)
            {
                LookItemPopupMenu.d(a);
            }

            
            {
                a = LookItemPopupMenu.this;
                super();
            }
        };
        l = new android.content.DialogInterface.OnKeyListener() {

            final LookItemPopupMenu a;

            public boolean onKey(DialogInterface dialoginterface, int i1, KeyEvent keyevent)
            {
                if (i1 == 4 && keyevent.getAction() == 1)
                {
                    LookItemPopupMenu.d(a);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = LookItemPopupMenu.this;
                super();
            }
        };
    }

    static View a(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.c;
    }

    static View b(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.b;
    }

    private void b()
    {
        if (b == null)
        {
            return;
        }
        if (c.getWidth() > 0)
        {
            c.setX(b.getX() - (float)((c.getWidth() - b.getWidth()) / 2));
            return;
        } else
        {
            c.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final LookItemPopupMenu a;

                public void onLayoutChange(View view, int i1, int j1, int k1, int l1, int i2, int j2, 
                        int k2, int l2)
                {
                    com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.a(a).removeOnLayoutChangeListener(this);
                    com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.a(a).setX(LookItemPopupMenu.b(a).getX() - (float)((com.cyberlink.youcammakeup.pages.editview.savemylook.LookItemPopupMenu.a(a).getWidth() - LookItemPopupMenu.b(a).getWidth()) / 2));
                }

            
            {
                a = LookItemPopupMenu.this;
                super();
            }
            });
            return;
        }
    }

    static com.cyberlink.youcammakeup.pages.editview.savemylook.a c(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.g;
    }

    private void c()
    {
        dismiss();
    }

    static void d(LookItemPopupMenu lookitempopupmenu)
    {
        lookitempopupmenu.c();
    }

    static View e(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.d;
    }

    static View f(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.e;
    }

    static View g(LookItemPopupMenu lookitempopupmenu)
    {
        return lookitempopupmenu.f;
    }

    public void a(View view)
    {
        b = view;
    }

    public void a(com.cyberlink.youcammakeup.pages.editview.savemylook.a a1)
    {
        g = a1;
    }

    public void a(boolean flag)
    {
        h = flag;
        if (e != null)
        {
            e.setEnabled(flag);
        }
    }

    public void b(boolean flag)
    {
        i = flag;
        if (d != null)
        {
            d.setEnabled(flag);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = getView();
        c = bundle.findViewById(0x7f0c060b);
        d = bundle.findViewById(0x7f0c060c);
        e = bundle.findViewById(0x7f0c060d);
        f = bundle.findViewById(0x7f0c060e);
        getDialog().setOnKeyListener(l);
        bundle.setOnClickListener(k);
        d.setOnClickListener(j);
        e.setOnClickListener(j);
        f.setOnClickListener(j);
        e.setEnabled(h);
        d.setEnabled(i);
        b();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030151, viewgroup);
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

}
