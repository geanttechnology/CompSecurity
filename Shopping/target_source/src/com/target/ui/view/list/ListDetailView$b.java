// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.model.list.ListDetailCompletedItem;
import com.target.ui.model.list.ListDetailItem;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

public static interface tedItem
{

    public abstract void a(ListDetailCompletedItem listdetailcompleteditem);

    public abstract void a(ListDetailItem listdetailitem);

    public abstract void a(ListDetailItem listdetailitem, int i);

    public abstract void a(ListDetailItem listdetailitem, View view);

    public abstract void a(String s);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(ListDetailItem listdetailitem);

    public abstract void b(ListDetailItem listdetailitem, int i);

    public abstract void b(String s);

    public abstract void c();

    public abstract void c(ListDetailItem listdetailitem);

    public abstract void c(ListDetailItem listdetailitem, int i);

    public abstract void d(ListDetailItem listdetailitem);
}
