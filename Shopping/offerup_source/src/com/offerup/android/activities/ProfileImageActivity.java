// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.g;
import com.offerup.android.utils.as;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.offerup.android.activities:
//            k, gf, gi, gj, 
//            gk, gl

public class ProfileImageActivity extends k
    implements Target
{

    Uri a;
    ExecutorService b;
    String c;
    Uri d;
    private Button j;
    private Button k;
    private View l;
    private View m;
    private View n;
    private ImageView o;
    private Button p;
    private Button q;
    private String r[] = {
        "_id", "orientation", "_data"
    };

    public ProfileImageActivity()
    {
    }

    final void a()
    {
        l.setVisibility(0);
        m.setVisibility(8);
        p.setVisibility(8);
    }

    final String b()
    {
        return "my_profile_image";
    }

    protected void onActivityResult(int i, int i1, Intent intent)
    {
        super.onActivityResult(i, i1, intent);
        System.gc();
        if (i1 != -1) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR lookupswitch 2: default 44
    //                   306: 103
    //                   522: 45;
           goto _L2 _L3 _L4
_L2:
        return;
_L4:
        d = intent.getData();
        if (d.toString().contains("picasa/item"))
        {
            as.a("You have selected an image stored remotely in your Picasa album. This is not currently supported. Please select another image. ", this);
            return;
        } else
        {
            Picasso.with(this).load(d).resize(600, 600).centerCrop().into(this);
            return;
        }
_L3:
        Cursor cursor = getContentResolver().query(a, r, null, null, null);
        intent = cursor;
        cursor.moveToFirst();
        intent = cursor;
        String s = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
        intent = cursor;
        Picasso.with(this).load(new File(s)).resize(600, 600).centerCrop().into(this);
        if (cursor != null)
        {
            try
            {
                cursor.close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                g.a(this, intent);
            }
            return;
        }
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception1;
        exception1;
        cursor = null;
_L9:
        intent = cursor;
        g.a(this, exception1);
        if (cursor == null) goto _L2; else goto _L6
_L6:
        try
        {
            cursor.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            g.a(this, intent);
        }
        return;
        Exception exception;
        exception;
        intent = null;
_L8:
        if (intent != null)
        {
            try
            {
                intent.close();
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                g.a(this, intent);
            }
        }
        throw exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
        exception1;
          goto _L9
    }

    public void onBitmapFailed(Drawable drawable)
    {
        i();
        a("Error", "We were unable to process your image. If this continues, please restart app or contact support.");
    }

    public void onBitmapLoaded(Bitmap bitmap, com.squareup.picasso.Picasso.LoadedFrom loadedfrom)
    {
        double d2;
        loadedfrom = null;
        d2 = 200D;
        o.setImageBitmap(bitmap);
        l.setVisibility(8);
        m.setVisibility(0);
        p.setVisibility(0);
        i();
        FileOutputStream fileoutputstream;
        c = (new StringBuilder()).append(getExternalFilesDir(null).toString()).append(File.separator).append("profile.jpg").toString();
        fileoutputstream = new FileOutputStream(c);
        loadedfrom = fileoutputstream;
        double d3 = bitmap.getWidth();
        loadedfrom = fileoutputstream;
        double d1 = bitmap.getHeight();
        if (d3 <= 200D && d1 <= 200D) goto _L2; else goto _L1
_L1:
        if (d3 <= d1) goto _L4; else goto _L3
_L3:
        loadedfrom = fileoutputstream;
        d1 = (d1 / d3) * 200D;
_L9:
        loadedfrom = fileoutputstream;
        Bitmap.createScaledBitmap(bitmap, (int)d2, (int)d1, false).compress(android.graphics.Bitmap.CompressFormat.JPEG, 80, fileoutputstream);
        Exception exception;
        try
        {
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap) { }
        System.gc();
        return;
_L4:
        d2 = (d3 / d1) * 200D;
        d1 = 200D;
        continue; /* Loop/switch isn't completed */
        exception;
        bitmap = null;
_L7:
        loadedfrom = bitmap;
        g.a(com/offerup/android/activities/ProfileImageActivity.getSimpleName(), exception);
        loadedfrom = bitmap;
        a("Error", "We were unable to process your image. If this continues, please restart app or contact support.");
        loadedfrom = bitmap;
        a();
        if (bitmap != null)
        {
            try
            {
                bitmap.flush();
                bitmap.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap bitmap) { }
        }
        break MISSING_BLOCK_LABEL_182;
        bitmap;
_L6:
        if (loadedfrom != null)
        {
            try
            {
                loadedfrom.flush();
                loadedfrom.close();
            }
            // Misplaced declaration of an exception variable
            catch (com.squareup.picasso.Picasso.LoadedFrom loadedfrom) { }
        }
        throw bitmap;
        bitmap;
        if (true) goto _L6; else goto _L5
_L5:
        exception;
        bitmap = fileoutputstream;
        if (true) goto _L7; else goto _L2
_L2:
        d2 = d3;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040037);
        System.gc();
        j = (Button)findViewById(0x7f100121);
        k = (Button)findViewById(0x7f100122);
        l = findViewById(0x7f100120);
        m = findViewById(0x7f100123);
        n = findViewById(0x7f100126);
        o = (ImageView)findViewById(0x7f100125);
        p = (Button)findViewById(0x7f100124);
        q = (Button)findViewById(0x7f100127);
        bundle = Typeface.createFromAsset(getAssets(), "segoesc.ttf");
        ((TextView)findViewById(0x7f10011f)).setTypeface(bundle);
        j.setOnClickListener(new gf(this));
        k.setOnClickListener(new gi(this));
        q.setOnClickListener(new gj(this));
        n.setOnClickListener(new gk(this));
        p.setOnClickListener(new gl(this));
        a();
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onPrepareLoad(Drawable drawable)
    {
        g = ProgressDialog.show(this, "", "Loading image...");
    }
}
