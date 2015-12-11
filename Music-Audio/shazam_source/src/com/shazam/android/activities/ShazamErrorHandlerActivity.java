// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.shazam.android.base.activities.BaseAppCompatActivity;
import com.shazam.b.e.a;
import com.shazam.f.g.b;
import com.shazam.f.g.c;
import com.shazam.f.g.d;
import com.shazam.f.g.e;
import com.shazam.f.g.f;
import com.shazam.f.h;

// Referenced classes of package com.shazam.android.activities:
//            SplashActivity

public class ShazamErrorHandlerActivity extends BaseAppCompatActivity
    implements android.content.DialogInterface.OnClickListener
{

    private String a;
    private h b;

    public ShazamErrorHandlerActivity()
    {
    }

    public static Intent a(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        return intent;
    }

    public static void a(Context context, h h1)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(context, com/shazam/android/activities/ShazamErrorHandlerActivity);
        intent.putExtra("com.shazam.android.ShazamErrorHandler.ExceptionParam", h1);
        if (!(context instanceof Activity))
        {
            intent.setFlags(0x10000000);
        }
        context.startActivity(intent);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i == -1 && com.shazam.b.e.a.c(a))
        {
            startActivity(a(a));
        }
        dialoginterface.dismiss();
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (com.shazam.android.util.f.a.a(getIntent()))
        {
            startActivity(new Intent(getApplicationContext(), com/shazam/android/activities/SplashActivity));
            finish();
            return;
        }
        b = (h)getIntent().getSerializableExtra("com.shazam.android.ShazamErrorHandler.ExceptionParam");
        bundle = b;
        byte byte0;
        if (bundle instanceof b)
        {
            byte0 = 3;
        } else
        if (bundle instanceof c)
        {
            byte0 = 2;
        } else
        if (bundle instanceof com.shazam.f.g.a)
        {
            byte0 = 1;
        } else
        if (bundle instanceof e)
        {
            byte0 = 6;
        } else
        if (bundle instanceof f)
        {
            byte0 = 5;
        } else
        if (bundle instanceof d)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        showDialog(byte0);
    }

    protected Dialog onCreateDialog(int i)
    {
        Object obj;
        android.app.AlertDialog.Builder builder;
        builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Shazam");
        builder.setCancelable(false);
        obj = null;
        i;
        JVM INSTR tableswitch 1 7: default 72
    //                   1 305
    //                   2 227
    //                   3 110
    //                   4 305
    //                   5 227
    //                   6 110
    //                   7 356;
           goto _L1 _L2 _L3 _L4 _L2 _L3 _L4 _L5
_L1:
        String s;
        builder.setPositiveButton(getString(0x7f090059), this);
        s = getString(0x7f090077);
_L7:
        builder.setMessage(s);
        a = ((String) (obj));
        return builder.create();
_L4:
        builder.setPositiveButton(getString(0x7f0900c4), this);
        Object obj1;
        String s1;
        if (b instanceof b)
        {
            obj1 = (b)b;
            s = ((b) (obj1)).getMessage();
            obj = ((c) (obj1)).d;
            s1 = ((b) (obj1)).b;
            obj1 = ((b) (obj1)).c;
        } else
        {
            obj1 = (e)b;
            s = ((e) (obj1)).getMessage();
            obj = ((f) (obj1)).d;
            s1 = ((e) (obj1)).b;
            obj1 = ((e) (obj1)).c;
        }
        builder.setPositiveButton(s1, this);
        builder.setNegativeButton(((CharSequence) (obj1)), this);
        continue; /* Loop/switch isn't completed */
_L3:
        builder.setPositiveButton(getString(0x7f09016a), this);
        builder.setNegativeButton(getString(0x7f0900b7), this);
        if (b instanceof c)
        {
            obj = (c)b;
            s = ((c) (obj)).getMessage();
            obj = ((c) (obj)).d;
        } else
        {
            obj = (f)b;
            s = ((f) (obj)).getMessage();
            obj = ((f) (obj)).d;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        builder.setPositiveButton(getString(0x7f0900c4), this);
        if (b instanceof com.shazam.f.g.a)
        {
            s = ((com.shazam.f.g.a)b).getMessage();
        } else
        {
            s = ((d)b).getMessage();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        builder.setPositiveButton(getString(0x7f0900c4), this);
        s = b.getMessage();
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected void onStop()
    {
        super.onStop();
        finish();
    }
}
