// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import java.util.List;

// Referenced classes of package com.pipcamera.activity:
//            SettingActivity

public class dataCount extends SimpleAdapter
{

    private int dataCount;
    final SettingActivity this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return super.getView(i, view, viewgroup);
    }

    public (Context context, List list, int i, String as[], int ai[])
    {
        this$0 = SettingActivity.this;
        super(context, list, i, as, ai);
        dataCount = list.size();
    }
}
