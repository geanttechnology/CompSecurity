// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import aco;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;
import com.wantu.service.gif.adapter.ThumbBrowserAdapter;
import java.util.List;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity

public class ThumbBrowserActivity extends FullscreenActivity
{

    private GridView a;

    public ThumbBrowserActivity()
    {
    }

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void nextBtnClicked(View view)
    {
        view = ((ThumbBrowserAdapter)a.getAdapter()).getSelectedImageIdList();
        if (view.size() < 2)
        {
            Toast.makeText(this, getResources().getString(0x7f060132), 0).show();
            return;
        } else
        {
            aco aco1 = new aco(this, null);
            aco1.a = view;
            aco1.execute(new Void[0]);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    protected Dialog onCreateDialog(int i)
    {
        ProgressDialog progressdialog;
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            progressdialog = new ProgressDialog(this);
            break;
        }
        progressdialog.setMessage(getResources().getString(0x7f0600ce));
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        return progressdialog;
    }
}
