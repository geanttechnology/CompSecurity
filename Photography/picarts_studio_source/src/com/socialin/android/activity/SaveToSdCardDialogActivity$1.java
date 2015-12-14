// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

// Referenced classes of package com.socialin.android.activity:
//            SaveToSdCardDialogActivity

final class  extends ArrayAdapter
{

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        return super.getView(i, null, viewgroup);
    }

    public final int getViewTypeCount()
    {
        return 1;
    }

    (Context context, String as[])
    {
        super(context, 0x1090008, as);
    }
}
