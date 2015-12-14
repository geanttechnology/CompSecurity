// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.unittest.uiimagecodec;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.UIBytePerPixel;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.UIInterpolation;
import com.cyberlink.youcammakeup.jniproxy.UIJPEGSubSampling;
import com.cyberlink.youcammakeup.jniproxy.UITiffCompression;
import com.cyberlink.youcammakeup.jniproxy.an;
import com.cyberlink.youcammakeup.jniproxy.ap;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.bd;
import com.cyberlink.youcammakeup.jniproxy.be;
import com.cyberlink.youcammakeup.jniproxy.bf;
import com.cyberlink.youcammakeup.jniproxy.d;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.q;
import com.cyberlink.youcammakeup.jniproxy.t;
import com.cyberlink.youcammakeup.jniproxy.v;
import com.cyberlink.youcammakeup.jniproxy.x;
import com.pf.common.utility.m;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UIImageCodecTestbed extends Activity
{

    private Button a;
    private Button b;
    private TextView c;
    private ImageView d;
    private ImageView e;
    private CheckBox f;
    private String g;
    private ba h;
    private final int i = 4;
    private k j;
    private Set k;

    public UIImageCodecTestbed()
    {
        g = "";
        j = new k(Globals.d().l());
        k = new HashSet(Arrays.asList(new UIImageOrientation[] {
            UIImageOrientation.f, UIImageOrientation.g, UIImageOrientation.h, UIImageOrientation.i
        }));
    }

    static ImageView a(UIImageCodecTestbed uiimagecodectestbed)
    {
        return uiimagecodectestbed.d;
    }

    private ap a(double d1, double d2, double d3)
    {
        ap ap1;
        if (Math.max(d1, d2) > d3)
        {
            if (d1 > d2)
            {
                d2 = Math.floor((d3 / d1) * d2);
                d1 = d3;
                d3 = d2;
            } else
            {
                d1 = Math.floor((d3 / d2) * d1);
            }
        } else
        {
            d3 = d2;
        }
        d1 = Math.max(d1, 1.0D);
        d2 = Math.max(d3, 1.0D);
        ap1 = new ap();
        ap1.a((long)d1);
        ap1.b((long)d2);
        return ap1;
    }

    private void a(String s)
    {
        long l = System.nanoTime();
        Object obj = new android.graphics.BitmapFactory.Options();
        obj.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        obj.inSampleSize = 4;
        s = BitmapFactory.decodeFile(s, ((android.graphics.BitmapFactory.Options) (obj)));
        float f1 = System.nanoTime() - l;
        obj = (new StringBuilder()).append(Float.valueOf(f1 * 1E-06F).toString()).append(" ms").toString();
        m.e("[UIImageCodecTestbed]", ((String) (obj)));
        c.setText(((CharSequence) (obj)));
        d.setImageBitmap(s);
    }

    static CheckBox b(UIImageCodecTestbed uiimagecodectestbed)
    {
        return uiimagecodectestbed.f;
    }

    private void b(String s)
    {
        Object obj2 = null;
        boolean flag;
        h = new ba();
        flag = j.a(s, h);
        if (flag) goto _L2; else goto _L1
_L1:
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("GetMetadataFromFile failed, ret = ").append(flag).toString());
        if (false)
        {
            throw new NullPointerException();
        }
        if (false)
        {
            throw new NullPointerException();
        }
_L7:
        return;
_L2:
        Object obj;
        Object obj3;
        j.a(h);
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("masterOrientation, ret = ").append(h.b().e()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("getNColorSpace, ret = ").append(h.c().b()).toString());
        obj3 = new bd();
        flag = j.a(s, ((bd) (obj3)));
        obj = UIImageOrientation.b;
        Object obj1 = obj;
        if (!flag) goto _L4; else goto _L3
_L3:
        obj3 = ((bd) (obj3)).b();
        int l = 0;
_L5:
        obj1 = obj;
        if ((long)l >= ((bf) (obj3)).b())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((bf) (obj3)).a(l);
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("UIThumbnailPropertyItem Width: ").append(((be) (obj)).d()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("UIThumbnailPropertyItem Height: ").append(((be) (obj)).c()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("UIThumbnailPropertyItem Orientation: ").append(((be) (obj)).e()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("UIThumbnailPropertyItem Type: ").append(((be) (obj)).b()).toString());
        obj = ((be) (obj)).e();
        l++;
        if (true) goto _L5; else goto _L4
_L4:
        obj = new d();
        flag = j.a(s, ((d) (obj)), true);
        if (flag)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("GetThumbnailFromFile failed, ret = ").append(flag).toString());
        if (obj != null)
        {
            ((d) (obj)).b();
        }
        if (true) goto _L7; else goto _L6
_L6:
        throw new NullPointerException();
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("GetThumbnailFromFile, thumbBuf.GetWidth() = ").append(((d) (obj)).e()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("GetThumbnailFromFile, thumbBuf.GetHeight() = ").append(((d) (obj)).f()).toString());
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("GetThumbnailFromFile, thumbBuf.GetBytesPerPixel() = ").append(((d) (obj)).g()).toString());
        if (!k.contains(obj1)) goto _L9; else goto _L8
_L8:
        obj2 = Bitmap.createBitmap((int)((d) (obj)).f(), (int)((d) (obj)).e(), android.graphics.Bitmap.Config.ARGB_8888);
        obj3 = new d();
        ((d) (obj3)).a(obj2);
        j.a(((d) (obj)), ((d) (obj3)), ((UIImageOrientation) (obj1)));
        com.cyberlink.youcammakeup.jniproxy.d.b(((d) (obj3)));
        ((d) (obj3)).c();
        e.setImageBitmap(((Bitmap) (obj2)));
_L13:
        obj2 = new ap();
        flag = j.a(s, h.b().b(), 4L, ((ap) (obj2)));
        if (flag) goto _L11; else goto _L10
_L10:
        m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("CalcOutputDimension failed, ret = ").append(flag).toString());
        if (obj != null)
        {
            ((d) (obj)).b();
        }
        if (true) goto _L7; else goto _L12
_L12:
        throw new NullPointerException();
_L9:
        obj1 = Bitmap.createBitmap((int)((d) (obj)).e(), (int)((d) (obj)).f(), android.graphics.Bitmap.Config.ARGB_8888);
        com.cyberlink.youcammakeup.jniproxy.d.b(((d) (obj)));
        ((d) (obj)).b(obj1);
        e.setImageBitmap(((Bitmap) (obj1)));
          goto _L13
        s;
        obj1 = null;
_L16:
        if (obj != null)
        {
            ((d) (obj)).b();
        }
        if (obj1 != null)
        {
            ((d) (obj1)).b();
        }
        throw s;
_L11:
        obj3 = new t();
        ((t) (obj3)).a(UIBytePerPixel.a);
        ((t) (obj3)).a(((ap) (obj2)).b());
        ((t) (obj3)).b(((ap) (obj2)).c());
        ((t) (obj3)).a(h.b().b());
        ((t) (obj3)).c(4L);
        obj1 = new d();
        ((d) (obj1)).a(((ap) (obj2)).b(), ((ap) (obj2)).c(), 4L);
        long l1 = System.nanoTime();
        j.a(s, ((d) (obj1)), ((t) (obj3)));
        float f1 = System.nanoTime() - l1;
        s = (new StringBuilder()).append(Float.valueOf(f1 * 1E-06F).toString()).append(" ms").toString();
        m.e("[UIImageCodecTestbed]", s);
        c.setText(s);
        s = new d();
        obj3 = a(((ap) (obj2)).b(), ((ap) (obj2)).c(), 900D);
        s.a(((ap) (obj3)).b(), ((ap) (obj3)).c(), 4L);
        j.a(((d) (obj1)), s, UIInterpolation.b);
        if (!k.contains(h.b().e()))
        {
            break MISSING_BLOCK_LABEL_1107;
        }
        obj2 = new d();
        ((d) (obj2)).a(((ap) (obj3)).c(), ((ap) (obj3)).b(), 4L);
        obj3 = Bitmap.createBitmap((int)((ap) (obj3)).c(), (int)((ap) (obj3)).b(), android.graphics.Bitmap.Config.ARGB_8888);
        ((d) (obj2)).a(obj3);
        j.a(s, ((d) (obj2)), h.b().e());
        com.cyberlink.youcammakeup.jniproxy.d.b(((d) (obj2)));
        ((d) (obj2)).c();
        d.setImageBitmap(((Bitmap) (obj3)));
_L15:
        if (obj != null)
        {
            ((d) (obj)).b();
        }
        if (obj1 == null) goto _L7; else goto _L14
_L14:
        ((d) (obj1)).b();
        return;
        obj2 = Bitmap.createBitmap((int)((ap) (obj3)).b(), (int)((ap) (obj3)).c(), android.graphics.Bitmap.Config.ARGB_8888);
        com.cyberlink.youcammakeup.jniproxy.d.b(s);
        s.b(obj2);
        d.setImageBitmap(((Bitmap) (obj2)));
          goto _L15
        s;
          goto _L16
        s;
        obj1 = null;
        obj = obj2;
          goto _L16
    }

    static TextView c(UIImageCodecTestbed uiimagecodectestbed)
    {
        return uiimagecodectestbed.c;
    }

    static ba d(UIImageCodecTestbed uiimagecodectestbed)
    {
        return uiimagecodectestbed.h;
    }

    static k e(UIImageCodecTestbed uiimagecodectestbed)
    {
        return uiimagecodectestbed.j;
    }

    protected void onActivityResult(int l, int i1, Intent intent)
    {
        l;
        JVM INSTR tableswitch 1 1: default 20
    //                   1 21;
           goto _L1 _L2
_L1:
        return;
_L2:
        if (i1 == -1)
        {
            Object obj = intent.getData();
            intent = new String[1];
            intent[0] = "_data";
            obj = getContentResolver().query(((Uri) (obj)), intent, null, null, null);
            ((Cursor) (obj)).moveToFirst();
            g = ((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex(intent[0]));
            ((Cursor) (obj)).close();
            if (f.isChecked())
            {
                a(g);
                return;
            } else
            {
                b(g);
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030021);
        sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse((new StringBuilder()).append("file://").append(Environment.getExternalStorageDirectory()).toString())));
        d = (ImageView)findViewById(0x7f0c01cf);
        e = (ImageView)findViewById(0x7f0c01ce);
        c = (TextView)findViewById(0x7f0c01d1);
        a = (Button)findViewById(0x7f0c01cd);
        b = (Button)findViewById(0x7f0c01d0);
        f = (CheckBox)findViewById(0x7f0c01d2);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final UIImageCodecTestbed a;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                a.startActivityForResult(view, 1);
            }

            
            {
                a = UIImageCodecTestbed.this;
                super();
            }
        });
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final UIImageCodecTestbed a;

            public void onClick(View view)
            {
                Object obj = ((BitmapDrawable)UIImageCodecTestbed.a(a).getDrawable()).getBitmap().copy(android.graphics.Bitmap.Config.ARGB_8888, true);
                if (UIImageCodecTestbed.b(a).isChecked())
                {
                    try
                    {
                        view = new FileOutputStream("/storage/sdcard0/export.jpg");
                        long l = System.nanoTime();
                        ((Bitmap) (obj)).compress(android.graphics.Bitmap.CompressFormat.JPEG, 100, view);
                        view.close();
                        float f1 = System.nanoTime() - l;
                        view = (new StringBuilder()).append(Float.valueOf(f1 * 1E-06F).toString()).append(" ms").toString();
                        m.e("[UIImageCodecTestbed]", view);
                        UIImageCodecTestbed.c(a).setText(view);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        view.printStackTrace();
                    }
                    return;
                } else
                {
                    view = new d();
                    view.a(obj);
                    com.cyberlink.youcammakeup.jniproxy.d.b(view);
                    obj = new v(UIImageFormat.b, 90, UITiffCompression.a, UIJPEGSubSampling.d, UIBytePerPixel.a, UIImageOrientation.b);
                    long l1 = System.nanoTime();
                    Object obj1 = new q();
                    obj = UIImageCodecTestbed.e(a).a("/storage/sdcard0/export.jpg", view, ((v) (obj)), com.cyberlink.youcammakeup.unittest.uiimagecodec.UIImageCodecTestbed.d(a), ((q) (obj1)));
                    float f2 = System.nanoTime() - l1;
                    obj1 = (new StringBuilder()).append(Float.valueOf(f2 * 1E-06F).toString()).append(" ms").toString();
                    m.e("[UIImageCodecTestbed]", ((String) (obj1)));
                    UIImageCodecTestbed.c(a).setText(((CharSequence) (obj1)));
                    m.e("[UIImageCodecTestbed]", (new StringBuilder()).append("UIImageCodecErrorCode ").append(((UIImageCodecErrorCode) (obj)).a()).toString());
                    view.c();
                    return;
                }
            }

            
            {
                a = UIImageCodecTestbed.this;
                super();
            }
        });
    }
}
