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

public class lf extends Dialog
    implements android.view.View.OnClickListener
{

    private Context a;
    private Uri b;
    private String c;
    private lg d;

    public lf(Context context, Uri uri, String s, lg lg1)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = uri;
        c = s;
        d = lg1;
    }

    static lg a(lf lf1)
    {
        return lf1.d;
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0c03bc)
        {
            view = new Intent("android.intent.action.VIEW");
            view.setData(b);
            if (view.resolveActivity(a.getPackageManager()) != null)
            {
                a.startActivity(view);
            }
            dismiss();
            d.a(true);
        } else
        {
            if (view.getId() == 0x7f0c03bd)
            {
                ((ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("StoreAddress", c));
                dismiss();
                d.a(true);
                return;
            }
            if (view.getId() == 0x7f0c00a4)
            {
                dismiss();
                d.a(false);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300f6);
        findViewById(0x7f0c03bc).setOnClickListener(this);
        findViewById(0x7f0c03bd).setOnClickListener(this);
        findViewById(0x7f0c00a4).setOnClickListener(this);
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final lf a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.dismiss();
                lf.a(a).a(false);
            }

            
            {
                a = lf.this;
                super();
            }
        });
    }
}
