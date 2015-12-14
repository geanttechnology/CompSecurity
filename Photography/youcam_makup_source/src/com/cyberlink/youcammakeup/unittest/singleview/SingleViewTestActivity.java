// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.unittest.singleview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;

public class SingleViewTestActivity extends Activity
{

    private ImageViewer a;
    private final int b = 1;

    public SingleViewTestActivity()
    {
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR tableswitch 1 1: default 28
    //                   1 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (j == -1)
        {
            Object obj = intent.getData();
            intent = new String[1];
            intent[0] = "_data";
            obj = getContentResolver().query(((android.net.Uri) (obj)), intent, null, null, null);
            ((Cursor) (obj)).moveToFirst();
            intent = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex(intent[0]));
            ((Cursor) (obj)).close();
            a.setImagePath(intent);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001d);
        a = (ImageViewer)findViewById(0x7f0c01a6);
        ((Button)findViewById(0x7f0c01a5)).setOnClickListener(new android.view.View.OnClickListener() {

            final SingleViewTestActivity a;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.GET_CONTENT");
                view.setType("image/*");
                a.startActivityForResult(view, 1);
            }

            
            {
                a = SingleViewTestActivity.this;
                super();
            }
        });
    }
}
