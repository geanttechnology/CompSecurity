// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.o;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class h extends ArrayAdapter
{

    private static final String z[];
    private Context a;

    public h(Context context, int i, List list)
    {
        super(context, 0x80000000, list);
        a = null;
        a = context;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        if (view != null) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (d)getItem(i);
        i = cn.jpush.android.util.a.a(a, 5F);
        viewgroup = new FrameLayout(a);
        view = new LinearLayout(a);
        view.setPadding(i, i, i, i);
        view.setOrientation(1);
        Object obj1;
        Object obj2;
        obj1 = a.getResources().getAssets().open(z[2]);
        obj2 = BitmapFactory.decodeStream(((InputStream) (obj1)));
        if (obj2 == null)
        {
            try
            {
                throw new RuntimeException(z[1]);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1) { }
            break MISSING_BLOCK_LABEL_110;
        }
        viewgroup.setBackgroundDrawable(new NinePatchDrawable(a.getResources(), new NinePatch(((Bitmap) (obj2)), ((Bitmap) (obj2)).getNinePatchChunk(), null)));
        ((InputStream) (obj1)).close();
        continue; /* Loop/switch isn't completed */
_L4:
        obj2 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj1 = new LinearLayout(a);
        ((LinearLayout) (obj1)).setOrientation(0);
        view.addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
        obj2 = new ImageView(a);
        ((ImageView) (obj2)).setBackgroundColor(0xff00ff00);
        ((ImageView) (obj2)).setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        Object obj3 = BitmapFactory.decodeFile(((l)obj).ad.l);
        if (obj3 != null)
        {
            ((ImageView) (obj2)).setImageBitmap(((Bitmap) (obj3)));
        }
        i = cn.jpush.android.util.a.a(a, 45F);
        ((LinearLayout) (obj1)).addView(((View) (obj2)), new android.widget.LinearLayout.LayoutParams(i, i));
        obj2 = new LinearLayout(a);
        ((LinearLayout) (obj2)).setOrientation(1);
        obj3 = new TextView(a);
        ((TextView) (obj3)).setTextSize(22F);
        ((TextView) (obj3)).setSingleLine();
        ((TextView) (obj3)).setEllipsize(android.text.TextUtils.TruncateAt.END);
        ((TextView) (obj3)).setText(((d) (obj)).c);
        ((LinearLayout) (obj2)).addView(((View) (obj3)));
        obj3 = new TextView(a);
        ((TextView) (obj3)).setSingleLine();
        ((TextView) (obj3)).setEllipsize(android.text.TextUtils.TruncateAt.END);
        ((TextView) (obj3)).setText(((d) (obj)).c);
        ((LinearLayout) (obj2)).addView(((View) (obj3)));
        obj = new android.widget.LinearLayout.LayoutParams(-2, -2);
        obj.gravity = 16;
        obj.leftMargin = cn.jpush.android.util.a.a(a, 5F);
        obj.rightMargin = cn.jpush.android.util.a.a(a, 5F);
        ((LinearLayout) (obj1)).addView(((View) (obj2)), ((android.view.ViewGroup.LayoutParams) (obj)));
        obj = new RelativeLayout(a);
        i = cn.jpush.android.util.a.a(a, 18F);
        obj2 = new android.widget.LinearLayout.LayoutParams(i, i);
        obj1 = new LinearLayout(a);
        ((LinearLayout) (obj1)).setOrientation(0);
        i = 0;
        do
        {
            if (i >= 3)
            {
                break;
            }
            ImageView imageview = new ImageView(a);
            try
            {
                imageview.setImageBitmap(BitmapFactory.decodeStream(a.getAssets().open(z[0])));
            }
            catch (IOException ioexception)
            {
                cn/jpush/android/ui/h.getSimpleName();
                ioexception.getMessage();
                x.f();
            }
            ((LinearLayout) (obj1)).addView(imageview, ((android.view.ViewGroup.LayoutParams) (obj2)));
            i++;
        } while (true);
        obj2 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(9, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj2)).addRule(15, -1);
        ((RelativeLayout) (obj)).addView(((View) (obj1)), ((android.view.ViewGroup.LayoutParams) (obj2)));
        obj1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(11, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj1)).addRule(15, -1);
        ((RelativeLayout) (obj)).addView(new TextView(a), ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj1 = new android.widget.LinearLayout.LayoutParams(-1, -2);
        obj1.topMargin = cn.jpush.android.util.a.a(a, 5F);
        view.addView(((View) (obj)), ((android.view.ViewGroup.LayoutParams) (obj1)));
        obj = new android.widget.FrameLayout.LayoutParams(-1, -2);
        obj.gravity = 17;
        obj.topMargin = cn.jpush.android.util.a.a(a, 2.0F);
        obj.leftMargin = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
        obj.bottomMargin = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
        obj.rightMargin = ((android.widget.FrameLayout.LayoutParams) (obj)).topMargin;
        viewgroup.addView(view, ((android.view.ViewGroup.LayoutParams) (obj)));
_L2:
        return viewgroup;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        Object obj1;
        String as2[];
        int i;
        int j;
        as2 = new String[3];
        obj1 = "er \036/ps-\000^si+";
        i = -1;
        j = 0;
_L10:
        Object obj;
        String as[];
        int k;
        int i1;
        int j1;
        int k1;
        obj = as2;
        obj1 = ((String) (obj1)).toCharArray();
        k = obj1.length;
        if (k > 1)
        {
            break MISSING_BLOCK_LABEL_280;
        }
        i1 = 0;
        as = ((String []) (obj));
        j1 = j;
        obj = obj1;
        k1 = i;
_L9:
        j = i1;
_L7:
        int l1;
        obj1 = obj;
        l1 = obj1[i1];
        j % 5;
        JVM INSTR tableswitch 0 3: default 96
    //                   0 253
    //                   1 259
    //                   2 266
    //                   3 273;
           goto _L1 _L2 _L3 _L4 _L5
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        i = 112;
_L11:
label0:
        {
            obj1[i1] = (char)(i ^ l1);
            j++;
            if (k != 0)
            {
                break label0;
            }
            i1 = k;
        }
        if (true) goto _L7; else goto _L6
        String as1[];
        int i2;
        i = k;
        as1 = as;
        i2 = j1;
        obj1 = obj;
        l1 = k1;
_L12:
        k1 = l1;
        obj = obj1;
        j1 = i2;
        as = as1;
        k = i;
        i1 = j;
        if (i > j) goto _L9; else goto _L8
_L8:
        obj = (new String(((char []) (obj1)))).intern();
        switch (l1)
        {
        default:
            as1[i2] = ((String) (obj));
            obj1 = "db8R\022js!\023\000#a-\033\034fcl_Pah>\026\025qX.\025^:)<\034\027";
            j = 1;
            i = 0;
            break;

        case 0: // '\0'
            as1[i2] = ((String) (obj));
            j = 2;
            obj1 = "ah>\026\025qX.\025^:)<\034\027";
            i = 1;
            break;

        case 1: // '\001'
            as1[i2] = ((String) (obj));
            z = as2;
            return;
        }
          goto _L10
_L6:
        i = 3;
          goto _L11
_L3:
        i = 7;
          goto _L11
_L4:
        i = 76;
          goto _L11
_L5:
        i = 114;
          goto _L11
        boolean flag = false;
        l1 = i;
        i2 = j;
        as1 = ((String []) (obj));
        i = k;
        j = ((flag) ? 1 : 0);
          goto _L12
    }
}
