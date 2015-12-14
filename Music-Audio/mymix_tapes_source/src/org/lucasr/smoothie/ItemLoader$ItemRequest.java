// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.lucasr.smoothie;

import android.view.View;
import java.lang.ref.SoftReference;
import java.util.concurrent.Future;

// Referenced classes of package org.lucasr.smoothie:
//            ItemLoader

private static final class <init>
{

    public final String id;
    public SoftReference itemContainer;
    public final Object itemParams;
    public final Integer itemPart;
    public SoftReference itemView;
    public Future loadItemTask;
    public final int position;
    public SoftReference result;
    public Long timestamp;

    public (String s, View view, View view1, Object obj, int i, int j, long l)
    {
        id = s;
        itemContainer = new SoftReference(view);
        if (view1 != null)
        {
            s = new SoftReference(view1);
        } else
        {
            s = null;
        }
        itemView = s;
        itemParams = obj;
        position = i;
        itemPart = Integer.valueOf(j);
        result = null;
        timestamp = Long.valueOf(l);
        loadItemTask = null;
    }

    public loadItemTask(String s, View view, Object obj, int i, int j, long l)
    {
        this(s, view, null, obj, i, j, l);
    }
}
