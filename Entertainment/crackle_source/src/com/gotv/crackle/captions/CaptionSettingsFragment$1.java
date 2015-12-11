// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

// Referenced classes of package com.gotv.crackle.captions:
//            CaptionSettingsFragment

class this._cls0 extends ArrayAdapter
{

    final CaptionSettingsFragment this$0;

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return (View)getItem(i);
    }

    _cls9(Context context, int i)
    {
        this$0 = CaptionSettingsFragment.this;
        super(context, i);
    }
}
