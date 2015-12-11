// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.content.Context;
import android.support.v7.widget.an;
import android.support.v7.widget.ao;
import android.support.v7.widget.bi;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wishabi.flipp.util.l;
import com.wishabi.flipp.util.m;
import com.wishabi.flipp.widget.CustomEditText;
import com.wishabi.flipp.widget.db;
import com.wishabi.flipp.widget.dk;
import java.util.ArrayList;

// Referenced classes of package com.wishabi.flipp.content:
//            ShoppingList, aw, at, au, 
//            av, ax, az, ay, 
//            SimpleSearchResult

public final class as extends an
{

    public ay c;
    public final ShoppingList d;
    public boolean e;
    private final Context f;

    public as(Context context, ShoppingList shoppinglist)
    {
        f = context;
        d = shoppinglist;
        if (super.a.a())
        {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        } else
        {
            super.b = true;
            return;
        }
    }

    public final int a()
    {
        return d.a();
    }

    public final int a(int i)
    {
        return d.a(i);
    }

    public final bi a(ViewGroup viewgroup, int i)
    {
        Object obj = LayoutInflater.from(f);
        i;
        JVM INSTR tableswitch 0 1: default 32
    //                   0 42
    //                   1 124;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalStateException("Invalid view type for shopping list");
_L2:
        viewgroup = new db(f);
        viewgroup.setListener(new aw(this));
        obj = (CustomEditText)viewgroup.findViewById(0x7f0b0121);
        ((CustomEditText) (obj)).setOnEditorActionListener(new at(this, viewgroup));
        ((CustomEditText) (obj)).setOnFocusChangeListener(new au(this, viewgroup));
        ((CustomEditText) (obj)).setKeyboardDimissedListener(new av(this, viewgroup));
_L5:
        return new ax(viewgroup);
_L3:
        viewgroup = ((LayoutInflater) (obj)).inflate(0x7f03004f, viewgroup, false);
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(bi bi, int i)
    {
        SimpleSearchResult simplesearchresult;
        db db1;
        ax ax1;
        simplesearchresult = null;
        db1 = null;
        ax1 = (ax)bi;
        d.a(i);
        JVM INSTR tableswitch 0 1: default 40
    //                   0 50
    //                   1 462;
           goto _L1 _L2 _L3
_L1:
        throw new IllegalStateException("Invalid view type for shopping list");
_L2:
        ShoppingList shoppinglist = d;
        bi = db1;
        if (shoppinglist.a != null)
        {
            if (shoppinglist.a.d(i) == null)
            {
                bi = db1;
            } else
            {
                bi = shoppinglist.a;
                if (bi.d(i) == null)
                {
                    bi = simplesearchresult;
                } else
                {
                    bi = ((bi) (bi.d(i).e));
                }
                bi = (az)bi;
            }
        }
        simplesearchresult = d.c(bi.a());
        if (bi == null)
        {
            throw new IllegalStateException("Shopping list item has no data");
        }
        bi.b();
        if (ax1.k.getLongTag() != bi.a())
        {
            ax1.k.a();
        }
        if (c != null)
        {
            c.b(bi);
        }
        ax1.k.setLongTag(bi.a());
        ax1.k.setName(bi.b());
        ax1.k.setChecked(bi.c());
        db1 = ax1.k;
        boolean flag;
        if (simplesearchresult != null && simplesearchresult.a != null)
        {
            i = simplesearchresult.a.size();
        } else
        {
            i = 0;
        }
        db1.setResultCount(i);
        ax1.k.setClipCount(((az) (bi)).b);
        db1 = ax1.k;
        if (bi.a() == d.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        db1.setSelected(flag);
        if (!e) goto _L5; else goto _L4
_L4:
        ax1.k.a();
        bi.c = false;
        ax1.k.setState$282bce2c(dk.d);
_L7:
        return;
_L5:
        if (ax1.k.getLongTag() == bi.a() && ax1.k.getState$1599ee8e() == dk.c) goto _L7; else goto _L6
_L6:
        if (((az) (bi)).c && simplesearchresult != null && simplesearchresult.b != null)
        {
            ax1.k.setThumbnailUrls(simplesearchresult.b);
            ax1.k.b();
            bi.c = false;
            return;
        }
        if (((az) (bi)).b != -1 && simplesearchresult != null && simplesearchresult.a != null)
        {
            ax1.k.setState$282bce2c(dk.a);
            return;
        } else
        {
            ax1.k.setState$282bce2c(dk.b);
            return;
        }
_L3:
        ax1.l.setText(d.b(i));
        return;
    }

    public final void a(boolean flag)
    {
        e = flag;
        super.a.b();
    }

    public final long b(int i)
    {
        ShoppingList shoppinglist = d;
        if (shoppinglist.a == null || shoppinglist.a.d(i) == null)
        {
            return -1L;
        } else
        {
            return shoppinglist.a.d(i).a;
        }
    }
}
