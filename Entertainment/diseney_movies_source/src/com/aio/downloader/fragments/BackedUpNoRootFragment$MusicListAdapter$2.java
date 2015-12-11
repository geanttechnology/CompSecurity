// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.aio.downloader.db.TypeDbUtilsBackup;
import com.aio.downloader.model.BackupModel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.aio.downloader.fragments:
//            BackedUpNoRootFragment

class val.position
    implements android.view.icListAdapter._cls2
{

    final this._cls1 this$1;
    private final int val$position;

    public void onClick(View view)
    {
        BackedUpNoRootFragment.access$0(cess._mth0(this._cls1.this)).deletefile(((BackupModel)BackedUpNoRootFragment.access$2(cess._mth0(this._cls1.this)).get(val$position)).getPackage_name());
        BackedUpNoRootFragment.access$1(cess._mth0(this._cls1.this), BackedUpNoRootFragment.access$0(cess._mth0(this._cls1.this)).queryApk("game_app", "timesort"));
        if (BackedUpNoRootFragment.access$2(cess._mth0(this._cls1.this)) == null)
        {
            BackedUpNoRootFragment.access$1(cess._mth0(this._cls1.this), new ArrayList());
        }
        BackedUpNoRootFragment.access$3(cess._mth0(this._cls1.this), new nit>(cess._mth0(this._cls1.this)));
        BackedUpNoRootFragment.access$4(cess._mth0(this._cls1.this)).setAdapter(BackedUpNoRootFragment.access$5(cess._mth0(this._cls1.this)));
        BackedUpNoRootFragment.access$5(cess._mth0(this._cls1.this)).tifyDataSetChanged();
        Toast.makeText(cess._mth0(this._cls1.this).getActivity(), "Delete successfully", 0).show();
    }

    ()
    {
        this$1 = final_;
        val$position = I.this;
        super();
    }
}
