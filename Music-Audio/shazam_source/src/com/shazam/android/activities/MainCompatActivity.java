// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.shazam.android.k.f.p;
import com.shazam.android.k.f.t;

public class MainCompatActivity extends Activity
{

    private final t a;

    public MainCompatActivity()
    {
        this(((t) (new p())));
    }

    public MainCompatActivity(t t1)
    {
        a = t1;
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        byte byte0;
        super.onCreate(bundle);
        obj = getIntent().getData().getPath();
        bundle = new Intent("android.intent.action.VIEW");
        byte0 = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 4: default 76
    //                   -1309148525: 176
    //                   94623710: 148
    //                   97969830: 190
    //                   1406295219: 162;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte0;
        JVM INSTR tableswitch 0 3: default 108
    //                   0 204
    //                   1 221
    //                   2 238
    //                   3 255;
           goto _L6 _L7 _L8 _L9 _L10
_L6:
        bundle.setData(getIntent().getData());
_L11:
        obj = getIntent().getExtras();
        if (obj != null)
        {
            bundle.putExtras(((Bundle) (obj)));
        }
        startActivity(bundle);
        finish();
        return;
_L3:
        if (((String) (obj)).equals("chart"))
        {
            byte0 = 0;
        }
          goto _L1
_L5:
        if (((String) (obj)).equals("friendsfeed"))
        {
            byte0 = 1;
        }
          goto _L1
_L2:
        if (((String) (obj)).equals("explore"))
        {
            byte0 = 2;
        }
          goto _L1
_L4:
        if (((String) (obj)).equals("myshazam"))
        {
            byte0 = 3;
        }
          goto _L1
_L7:
        bundle.setData(a.c());
          goto _L11
_L8:
        bundle.setData(a.d());
          goto _L11
_L9:
        bundle.setData(a.e());
          goto _L11
_L10:
        bundle.setData(a.b());
          goto _L11
    }
}
