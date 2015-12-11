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
//            MMBaseActivity, BridgeMMMedia

static class hasRequestedPic extends MMBaseActivity
{

    private Uri fileUri;
    boolean hasRequestedPic;

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (intent == null) goto _L2; else goto _L1
_L1:
        Object obj1;
        Exception exception1;
        Object obj2;
        Object obj4;
        Object obj5;
        obj = null;
        obj5 = null;
        obj2 = null;
        exception1 = null;
        obj1 = null;
        obj4 = null;
        Uri uri = intent.getData();
        if (uri != null) goto _L4; else goto _L3
_L3:
        if (intent.getExtras() == null) goto _L2; else goto _L5
_L5:
        obj1 = (Bitmap)intent.getExtras().get("data");
        intent = new File(getIntent().getData().getPath());
        obj = new ByteArrayOutputStream();
        ((Bitmap) (obj1)).compress(android.graphics.erActivity.getIntent, 0, ((OutputStream) (obj)));
        obj = new ByteArrayInputStream(((ByteArrayOutputStream) (obj)).toByteArray());
        intent = new FileOutputStream(intent);
        obj1 = new byte[1024];
_L8:
        i = ((ByteArrayInputStream) (obj)).read(((byte []) (obj1)));
        if (i <= 0) goto _L7; else goto _L6
_L6:
        intent.write(((byte []) (obj1)), 0, i);
          goto _L8
        obj;
_L27:
        if (true) goto _L10; else goto _L9
_L9:
        Exception exception;
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
          goto _L2
_L10:
        if (intent == null) goto _L2; else goto _L11
_L11:
        intent.close();
_L2:
        synchronized (BridgeMMMedia.access$000())
        {
            BridgeMMMedia.access$000().notify();
        }
        finish();
        return;
_L7:
        if (true) goto _L13; else goto _L12
_L12:
        try
        {
            throw new NullPointerException();
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
          goto _L2
_L13:
        if (intent == null) goto _L2; else goto _L14
_L14:
        intent.close();
          goto _L2
        intent;
        obj = obj2;
_L25:
        if (false)
        {
            Object obj3;
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            break MISSING_BLOCK_LABEL_251;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        ((OutputStream) (obj)).close();
        try
        {
            throw intent;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            finish((new StringBuilder()).append("Error with picture: ").append(intent.getMessage()).toString());
        }
          goto _L2
_L4:
        if (uri == null) goto _L2; else goto _L15
_L15:
        intent = getContentResolver();
        if (intent == null) goto _L2; else goto _L16
_L16:
        obj3 = intent.query(uri, new String[] {
            "_data"
        }, null, null, null);
        if (obj3 == null) goto _L2; else goto _L17
_L17:
        i = ((Cursor) (obj3)).getColumnIndex("_data");
        if (i == -1) goto _L2; else goto _L18
_L18:
        ((Cursor) (obj3)).moveToFirst();
        intent = new File(((Cursor) (obj3)).getString(i));
        ((Cursor) (obj3)).close();
        obj3 = new File(getIntent().getData().getPath());
        intent = new FileInputStream(intent);
        obj = new FileOutputStream(((File) (obj3)));
        obj1 = new byte[1024];
_L21:
        i = intent.read(((byte []) (obj1)));
        if (i <= 0) goto _L20; else goto _L19
_L19:
        ((OutputStream) (obj)).write(((byte []) (obj1)), 0, i);
          goto _L21
        obj1;
_L24:
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_446;
        }
        intent.close();
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
        }
          goto _L2
_L20:
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        intent.close();
        if (obj != null)
        {
            try
            {
                ((OutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent) { }
        }
          goto _L2
        intent;
_L23:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        ((InputStream) (obj)).close();
        if (obj1 != null)
        {
            try
            {
                ((OutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw intent;
        intent;
        obj;
        JVM INSTR monitorexit ;
        throw intent;
        exception1;
        obj = intent;
        intent = exception1;
        continue; /* Loop/switch isn't completed */
        exception1;
        obj1 = obj;
        obj = intent;
        intent = exception1;
        if (true) goto _L23; else goto _L22
_L22:
        intent;
        intent = obj5;
        obj = exception1;
          goto _L24
        obj;
        obj = exception1;
          goto _L24
        exception;
        obj = intent;
        intent = exception;
          goto _L25
        intent;
        intent = obj4;
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
                hasRequestedPic = ((Bundle)getLastNonConfigurationInstance()).getBoolean("hasRequestedPic");
            }
            if (!hasRequestedPic)
            {
                if (!getIntent().getStringExtra("type").equalsIgnoreCase("Camera"))
                {
                    break label0;
                }
                bundle = new Intent("android.media.action.IMAGE_CAPTURE");
                fileUri = getIntent().getData();
                bundle.putExtra("return-data", true);
                hasRequestedPic = true;
                startActivityForResult(bundle, 0);
            }
            return;
        }
        bundle = new Intent();
        bundle.setType("image/*");
        bundle.setAction("android.intent.action.GET_CONTENT");
        hasRequestedPic = true;
        startActivityForResult(bundle, 0);
    }

    public Object onRetainNonConfigurationInstance()
    {
        super.onRetainNonConfigurationInstance();
        Bundle bundle = new Bundle();
        bundle.putBoolean("hasRequestedPic", hasRequestedPic);
        return bundle;
    }

    ()
    {
        hasRequestedPic = false;
    }
}
