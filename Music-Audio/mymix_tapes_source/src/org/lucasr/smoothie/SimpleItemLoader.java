// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.view.View;
import android.widget.Adapter;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

public abstract class SimpleItemLoader extends ItemLoader
{

    public SimpleItemLoader()
    {
    }

    public abstract void displayItem(View view, Object obj, boolean flag);

    public final void displayItemPart(View view, Object obj, int i, boolean flag)
    {
        displayItem(view, obj, flag);
    }

    public final int getItemPartCount(Adapter adapter, int i)
    {
        return 1;
    }

    public abstract Object loadItem(Object obj);

    public abstract Object loadItemFromMemory(Object obj);

    public final Object loadItemPart(Object obj, int i)
    {
        return loadItem(obj);
    }

    public final Object loadItemPartFromMemory(Object obj, int i)
    {
        return loadItemFromMemory(obj);
    }

    public final boolean shouldPreloadItemPart(Adapter adapter, int i, int j)
    {
        return true;
    }
}
