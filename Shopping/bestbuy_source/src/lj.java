// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;

public class lj extends Dialog
    implements android.view.View.OnClickListener
{

    private Context a;
    private String b;

    public lj(Context context)
    {
        super(context, 0x7f0e002b);
        a = context;
        b = context.getString(0x7f0801ca);
    }

    public void onClick(View view)
    {
        if (view.getId() == 0x7f0c0444)
        {
            if (android.os.Build.VERSION.SDK_INT < 11)
            {
                ((ClipboardManager)a.getSystemService("clipboard")).setText(b);
            } else
            {
                ((android.content.ClipboardManager)a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label", b));
            }
            cancel();
        } else
        {
            if (view.getId() == 0x7f0c0445)
            {
                view = new Intent();
                view.setAction("android.intent.action.VIEW");
                view.addCategory("android.intent.category.BROWSABLE");
                view.setData(Uri.parse(b));
                a.startActivity(view);
                cancel();
                return;
            }
            if (view.getId() == 0x7f0c0446)
            {
                view = b;
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", view);
                intent.setType("text/plain");
                a.startActivity(Intent.createChooser(intent, "Share Registry To..."));
                cancel();
                return;
            }
            if (view.getId() == 0x7f0c0447)
            {
                cancel();
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030120);
        findViewById(0x7f0c0444).setOnClickListener(this);
        findViewById(0x7f0c0445).setOnClickListener(this);
        findViewById(0x7f0c0446).setOnClickListener(this);
        findViewById(0x7f0c0447).setOnClickListener(this);
        setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final lj a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.dismiss();
            }

            
            {
                a = lj.this;
                super();
            }
        });
    }
}
