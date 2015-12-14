// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.AlertDialog;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.wantu.setting.CommonBottomView;

public class boh
    implements android.view.View.OnClickListener
{

    final CommonBottomView a;

    public boh(CommonBottomView commonbottomview)
    {
        a = commonbottomview;
        super();
    }

    public void onClick(View view)
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            Toast.makeText(a.mContext, 0x7f0600f6, 1).show();
            return;
        } else
        {
            view = new android.app.AlertDialog.Builder(a.mContext);
            EditText edittext = new EditText(a.mContext);
            edittext.setText(0x7f060189);
            view.setTitle(0x7f06014c);
            view.setView(edittext);
            view.setPositiveButton(0x7f0601e0, new boi(this, edittext));
            view.setNegativeButton(0x7f0601df, new boj(this));
            view.create().show();
            return;
        }
    }
}
