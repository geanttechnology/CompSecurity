// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class kw extends Dialog
    implements android.view.View.OnClickListener
{

    private Context a;
    private Uri b;
    private String c;

    public kw(Context context, Uri uri, String s)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = uri;
        c = s;
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0c016e)
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(b);
            if (view.resolveActivity(a.getPackageManager()) != null)
            {
                a.startActivity(view);
            }
            dismiss();
        } else
        if (view.getId() == 0x7f0c016f)
        {
            ((ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("StoreAddress", c));
            dismiss();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030067);
        findViewById(0x7f0c016e).setOnClickListener(this);
        findViewById(0x7f0c016f).setOnClickListener(this);
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final kw a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.dismiss();
            }

            
            {
                a = kw.this;
                super();
            }
        });
    }
}
