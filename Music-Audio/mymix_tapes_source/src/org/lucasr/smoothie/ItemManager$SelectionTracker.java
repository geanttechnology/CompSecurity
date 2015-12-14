// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package org.lucasr.smoothie:
//            ItemManager, ItemManaged

private class <init>
    implements android.widget.tener
{

    final ItemManager this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        if (ItemManager.access$400(ItemManager.this) != 0)
        {
            ItemManager.access$402(ItemManager.this, 0);
            postUpdateItems();
        }
        android.widget.tener tener = ItemManager.access$800(ItemManager.this).getOnItemSelectedListener();
        if (tener != null)
        {
            tener.onItemSelected(adapterview, view, i, l);
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        android.widget.tener tener = ItemManager.access$800(ItemManager.this).getOnItemSelectedListener();
        if (tener != null)
        {
            tener.onNothingSelected(adapterview);
        }
    }

    private ()
    {
        this$0 = ItemManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
