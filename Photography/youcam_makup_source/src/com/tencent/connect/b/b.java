// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.connect.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.open.a.k;
import com.tencent.open.utils.HttpUtils;
import com.tencent.tauth.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.tencent.connect.b:
//            a, c

class b
    implements com.tencent.tauth.b
{

    com.tencent.tauth.b a;
    final a b;
    private final String c = "sendinstall";
    private final String d = "installwording";
    private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

    public b(a a1, com.tencent.tauth.b b1)
    {
        b = a1;
        super();
        a = b1;
    }

    private Drawable a(String s, Context context)
    {
        context = context.getApplicationContext().getAssets();
        context = context.open(s);
        if (context == null)
        {
            return null;
        }
        boolean flag = s.endsWith(".9.png");
        if (!flag) goto _L2; else goto _L1
_L1:
        s = BitmapFactory.decodeStream(context);
_L7:
        if (s == null) goto _L4; else goto _L3
_L3:
        context = s.getNinePatchChunk();
        NinePatch.isNinePatchChunk(context);
        s = new NinePatchDrawable(s, context, new Rect(), null);
        return s;
        context;
        s = null;
_L5:
        context.printStackTrace();
        return s;
        s;
        s.printStackTrace();
        s = null;
        continue; /* Loop/switch isn't completed */
_L2:
        s = Drawable.createFromStream(context, s);
        context.close();
        return s;
        context;
        if (true) goto _L5; else goto _L4
_L4:
        return null;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private View a(Context context, Drawable drawable, String s, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1)
    {
        Object obj = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        float f = ((DisplayMetrics) (obj)).density;
        obj = new RelativeLayout(context);
        Object obj1 = new ImageView(context);
        ((ImageView) (obj1)).setImageDrawable(drawable);
        ((ImageView) (obj1)).setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        ((ImageView) (obj1)).setId(1);
        int i = (int)(60F * f);
        int j = (int)(60F * f);
        int l = (int)(14F * f);
        l = (int)(18F * f);
        int i1 = (int)(6F * f);
        int j1 = (int)(18F * f);
        drawable = new android.widget.RelativeLayout.LayoutParams(i, j);
        drawable.addRule(9);
        drawable.setMargins(0, l, i1, j1);
        ((RelativeLayout) (obj)).addView(((View) (obj1)), drawable);
        drawable = new TextView(context);
        drawable.setText(s);
        drawable.setTextSize(14F);
        drawable.setGravity(3);
        drawable.setIncludeFontPadding(false);
        drawable.setPadding(0, 0, 0, 0);
        drawable.setLines(2);
        drawable.setId(5);
        drawable.setMinWidth((int)(185F * f));
        s = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        s.addRule(1, 1);
        s.addRule(6, 1);
        i = (int)(10F * f);
        s.setMargins(0, 0, (int)(5F * f), 0);
        ((RelativeLayout) (obj)).addView(drawable, s);
        drawable = new View(context);
        drawable.setBackgroundColor(Color.rgb(214, 214, 214));
        drawable.setId(3);
        s = new android.widget.RelativeLayout.LayoutParams(-2, 2);
        s.addRule(3, 1);
        s.addRule(5, 1);
        s.addRule(7, 5);
        s.setMargins(0, 0, 0, (int)(12F * f));
        ((RelativeLayout) (obj)).addView(drawable, s);
        drawable = new LinearLayout(context);
        s = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        s.addRule(5, 1);
        s.addRule(7, 5);
        s.addRule(3, 3);
        obj1 = new Button(context);
        ((Button) (obj1)).setText("\u8DF3\u8FC7");
        ((Button) (obj1)).setBackgroundDrawable(a("buttonNegt.png", context));
        ((Button) (obj1)).setTextColor(Color.rgb(36, 97, 131));
        ((Button) (obj1)).setTextSize(20F);
        ((Button) (obj1)).setOnClickListener(onclicklistener1);
        ((Button) (obj1)).setId(4);
        onclicklistener1 = new android.widget.LinearLayout.LayoutParams(0, (int)(45F * f));
        onclicklistener1.rightMargin = (int)(14F * f);
        onclicklistener1.leftMargin = (int)(4F * f);
        onclicklistener1.weight = 1.0F;
        drawable.addView(((View) (obj1)), onclicklistener1);
        onclicklistener1 = new Button(context);
        onclicklistener1.setText("\u786E\u5B9A");
        onclicklistener1.setTextSize(20F);
        onclicklistener1.setTextColor(Color.rgb(255, 255, 255));
        onclicklistener1.setBackgroundDrawable(a("buttonPost.png", context));
        onclicklistener1.setOnClickListener(onclicklistener);
        context = new android.widget.LinearLayout.LayoutParams(0, (int)(45F * f));
        context.weight = 1.0F;
        context.rightMargin = (int)(4F * f);
        drawable.addView(onclicklistener1, context);
        ((RelativeLayout) (obj)).addView(drawable, s);
        context = new android.widget.FrameLayout.LayoutParams((int)(279F * f), (int)(163F * f));
        ((RelativeLayout) (obj)).setPadding((int)(14F * f), 0, (int)(12F * f), (int)(12F * f));
        ((RelativeLayout) (obj)).setLayoutParams(context);
        ((RelativeLayout) (obj)).setBackgroundColor(Color.rgb(247, 251, 247));
        context = new PaintDrawable(Color.rgb(247, 251, 247));
        context.setCornerRadius(f * 5F);
        ((RelativeLayout) (obj)).setBackgroundDrawable(context);
        return ((View) (obj));
    }

    private void a(String s, com.tencent.tauth.b b1, Object obj)
    {
        Drawable drawable = null;
        Dialog dialog = new Dialog(com.tencent.connect.b.a.e(b));
        dialog.requestWindowFeature(1);
        Object obj2 = com.tencent.connect.b.a.e(b).getPackageManager();
        Object obj1;
        ColorDrawable colordrawable;
        try
        {
            obj1 = ((PackageManager) (obj2)).getPackageInfo(com.tencent.connect.b.a.e(b).getPackageName(), 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            namenotfoundexception = null;
        }
        if (obj1 != null)
        {
            drawable = ((PackageInfo) (obj1)).applicationInfo.loadIcon(((PackageManager) (obj2)));
        }
        obj1 = new c(dialog, b1, obj) {

            final com.tencent.tauth.b a;
            final Object b;
            final b c;

            public void onClick(View view)
            {
                c.b();
                if (d != null && d.isShowing())
                {
                    d.dismiss();
                }
                if (a != null)
                {
                    a.a(b);
                }
            }

            
            {
                c = b.this;
                a = b2;
                b = obj;
                super(b.this, dialog);
            }
        };
        obj2 = new c(dialog, b1, obj) {

            final com.tencent.tauth.b a;
            final Object b;
            final b c;

            public void onClick(View view)
            {
                if (d != null && d.isShowing())
                {
                    d.dismiss();
                }
                if (a != null)
                {
                    a.a(b);
                }
            }

            
            {
                c = b.this;
                a = b2;
                b = obj;
                super(b.this, dialog);
            }
        };
        colordrawable = new ColorDrawable();
        colordrawable.setAlpha(0);
        dialog.getWindow().setBackgroundDrawable(colordrawable);
        dialog.setContentView(a(((Context) (com.tencent.connect.b.a.e(b))), drawable, s, ((android.view.View.OnClickListener) (obj1)), ((android.view.View.OnClickListener) (obj2))));
        dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(b1, obj) {

            final com.tencent.tauth.b a;
            final Object b;
            final b c;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (a != null)
                {
                    a.a(b);
                }
            }

            
            {
                c = b.this;
                a = b2;
                b = obj;
                super();
            }
        });
        if (com.tencent.connect.b.a.e(b) != null && !com.tencent.connect.b.a.e(b).isFinishing())
        {
            dialog.show();
        }
    }

    public void a()
    {
        if (a != null)
        {
            a.a();
        }
    }

    public void a(d d1)
    {
        if (a != null)
        {
            a.a(d1);
        }
    }

    public void a(Object obj)
    {
        Object obj1;
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        obj1 = (JSONObject)obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        if (((JSONObject) (obj1)).getInt("sendinstall") == 1)
        {
            flag = true;
        }
        flag1 = flag;
        try
        {
            obj1 = ((JSONObject) (obj1)).getString("installwording");
        }
        catch (JSONException jsonexception)
        {
            k.d("FeedConfirm", "There is no value for sendinstall.");
            flag = flag1;
            jsonexception = "";
        }
        obj1 = URLDecoder.decode(((String) (obj1)));
        k.b("TAG", (new StringBuilder()).append(" WORDING = ").append(((String) (obj1))).append("xx").toString());
        if (flag && !TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            a(((String) (obj1)), a, obj);
        } else
        if (a != null)
        {
            a.a(obj);
            return;
        }
    }

    protected void b()
    {
        android.os.Bundle bundle = com.tencent.connect.b.a.g(b);
        HttpUtils.a(com.tencent.connect.b.a.h(b), com.tencent.connect.b.a.e(b), "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", bundle, "POST", null);
    }
}
