// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.millennialmedia.android:
//            MMBaseActivity, MMLog, BridgeMMMedia

class a extends MMBaseActivity
{

    private boolean a;

    protected final void a(int i, int j, Intent intent)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        obj2 = null;
        obj3 = null;
        obj1 = null;
        super.a(i, j, intent);
        if (intent == null) goto _L2; else goto _L1
_L1:
        obj = intent.getData();
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (intent.getExtras() == null) goto _L2; else goto _L5
_L5:
        obj = (Bitmap)intent.getExtras().get("data");
        intent = new File(getIntent().getData().getPath());
        obj2 = new ByteArrayOutputStream();
        ((Bitmap) (obj)).compress(android.graphics.erActivity.getIntent, 0, ((OutputStream) (obj2)));
        obj2 = new ByteArrayInputStream(((ByteArrayOutputStream) (obj2)).toByteArray());
        obj = new FileOutputStream(intent);
        intent = ((Intent) (obj));
        obj1 = new byte[1024];
_L7:
        intent = ((Intent) (obj));
        i = ((ByteArrayInputStream) (obj2)).read(((byte []) (obj1)));
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        intent = ((Intent) (obj));
        ((OutputStream) (obj)).write(((byte []) (obj1)), 0, i);
        if (true) goto _L7; else goto _L6
        obj1;
_L27:
        intent = ((Intent) (obj));
        MMLog.a("BridgeMMMedia", "Problem getting bitmap from data", ((Throwable) (obj1)));
        if (obj == null) goto _L2; else goto _L8
_L8:
        ((OutputStream) (obj)).close();
_L2:
        synchronized (BridgeMMMedia.a())
        {
            BridgeMMMedia.a().notify();
        }
        finish();
        return;
_L6:
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            try
            {
                MMLog.a("BridgeMMMedia", "Error closing file", intent);
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                MMLog.a("BridgeMMMedia", "Error with picture: ", intent);
            }
        }
          goto _L2
        intent;
        MMLog.a("BridgeMMMedia", "Error closing file", intent);
          goto _L2
        intent;
        obj = obj1;
_L25:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        ((OutputStream) (obj)).close();
_L9:
        throw intent;
        obj;
        MMLog.a("BridgeMMMedia", "Error closing file", ((Throwable) (obj)));
        if (true) goto _L9; else goto _L4
_L4:
        if (obj == null) goto _L2; else goto _L10
_L10:
        intent = getContentResolver();
        if (intent == null) goto _L2; else goto _L11
_L11:
        obj = intent.query(((Uri) (obj)), new String[] {
            "_data"
        }, null, null, null);
        if (obj == null) goto _L2; else goto _L12
_L12:
        i = ((Cursor) (obj)).getColumnIndex("_data");
        if (i == -1) goto _L2; else goto _L13
_L13:
        ((Cursor) (obj)).moveToFirst();
        intent = new File(((Cursor) (obj)).getString(i));
        ((Cursor) (obj)).close();
        obj1 = new File(getIntent().getData().getPath());
        obj = new FileInputStream(intent);
        intent = new FileOutputStream(((File) (obj1)));
        obj1 = new byte[1024];
_L16:
        i = ((InputStream) (obj)).read(((byte []) (obj1)));
        if (i <= 0) goto _L15; else goto _L14
_L14:
        intent.write(((byte []) (obj1)), 0, i);
          goto _L16
        obj2;
        obj1 = obj;
        obj = intent;
        intent = ((Intent) (obj1));
        obj1 = obj2;
_L24:
        MMLog.a("BridgeMMMedia", "Error copying image", ((Throwable) (obj1)));
        if (intent == null) goto _L18; else goto _L17
_L17:
        intent.close();
_L18:
        if (obj == null) goto _L2; else goto _L19
_L19:
        ((OutputStream) (obj)).close();
          goto _L2
        intent;
        MMLog.a("BridgeMMMedia", "Error closing file", intent);
          goto _L2
_L15:
        ((InputStream) (obj)).close();
        intent.close();
          goto _L2
        intent;
        MMLog.a("BridgeMMMedia", "Error closing file", intent);
          goto _L2
        intent;
        obj1 = null;
        obj = obj3;
_L23:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_527;
        }
        ((InputStream) (obj1)).close();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_537;
        }
        ((OutputStream) (obj)).close();
_L21:
        throw intent;
        obj;
        MMLog.a("BridgeMMMedia", "Error closing file", ((Throwable) (obj)));
        if (true) goto _L21; else goto _L20
_L20:
        obj;
        intent;
        JVM INSTR monitorexit ;
        throw obj;
        intent;
        obj1 = obj;
        obj = obj3;
        continue; /* Loop/switch isn't completed */
        obj1;
        obj2 = intent;
        intent = ((Intent) (obj1));
        obj1 = obj;
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj2;
        obj1 = intent;
        intent = ((Intent) (obj2));
        if (true) goto _L23; else goto _L22
_L22:
        obj1;
        intent = null;
        obj = obj2;
          goto _L24
        obj1;
        intent = ((Intent) (obj));
        obj = obj2;
          goto _L24
        obj1;
        obj = intent;
        intent = ((Intent) (obj1));
          goto _L25
        obj1;
        obj = null;
        if (true) goto _L27; else goto _L26
_L26:
    }

    public void onCreate(Bundle bundle)
    {
label0:
        {
            super.onCreate(bundle);
            if (getLastNonConfigurationInstance() != null)
            {
                a = ((Bundle)getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
            }
            if (!a)
            {
                if (!getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
                {
                    break label0;
                }
                bundle = new Intent("android.media.action.IMAGE_CAPTURE");
                getIntent().getData();
                bundle.putExtra("return-data", true);
                a = true;
                startActivityForResult(bundle, 0);
            }
            return;
        }
        bundle = new Intent();
        bundle.setType("image/*");
        bundle.setAction("android.intent.action.GET_CONTENT");
        a = true;
        startActivityForResult(bundle, 0);
    }

    public Object onRetainNonConfigurationInstance()
    {
        super.onRetainNonConfigurationInstance();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasRequestedPic", a);
        return bundle;
    }

    ()
    {
        a = false;
    }
}
