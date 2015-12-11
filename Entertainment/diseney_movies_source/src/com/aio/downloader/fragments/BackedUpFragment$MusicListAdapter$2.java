// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.view.View;
import android.widget.Toast;
import java.io.File;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpFragment

class val.position
    implements android.view.icListAdapter._cls2
{

    final this._cls1 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        view = new File((String)BackedUpFragment.access$3(cess._mth0(this._cls1.this)).get(val$position));
        if (view.exists())
        {
            view.delete();
        }
        BackedUpFragment.access$3(cess._mth0(this._cls1.this)).remove(val$position);
        BackedUpFragment.access$2(cess._mth0(this._cls1.this)).tifyDataSetChanged();
        Toast.makeText(cess._mth0(this._cls1.this).getActivity(), "Delete successfully", 0).show();
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
