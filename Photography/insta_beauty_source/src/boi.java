// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;
import android.widget.EditText;
import com.wantu.setting.CommonBottomView;

class boi
    implements android.content.DialogInterface.OnClickListener
{

    final EditText a;
    final boh b;

    boi(boh boh1, EditText edittext)
    {
        b = boh1;
        a = edittext;
        super();
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (b.a.onClickNewCreateFolderListener != null)
        {
            b.a.onClickNewCreateFolderListener.e(a.getText().toString());
        }
        dialoginterface.cancel();
    }
}
