// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import com.picsart.studio.editor.custommasks.Mask;
import com.picsart.studio.editor.custommasks.h;
import com.socialin.android.brushlib.stroke.Stroke;
import com.socialin.android.util.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import myobfuscated.cb.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a
{

    private Object mTag;
    private boolean mTitleOptionalHint;

    public a()
    {
    }

    public static void drawWithIntrinsicSize(Canvas canvas, Drawable drawable, float f, float f1)
    {
        drawWithIntrinsicSize(canvas, drawable, f, f1, 17, 0.0F);
    }

    public static void drawWithIntrinsicSize(Canvas canvas, Drawable drawable, float f, float f1, int i)
    {
        drawWithIntrinsicSize(canvas, drawable, f, f1, 17, 0.0F);
    }

    public static void drawWithIntrinsicSize(Canvas canvas, Drawable drawable, float f, float f1, int i, float f2)
    {
        boolean flag;
        int l;
        int i1;
        flag = false;
        if (drawable == null)
        {
            return;
        }
        l = drawable.getIntrinsicWidth();
        i1 = drawable.getIntrinsicHeight();
        i & 7;
        JVM INSTR tableswitch 1 5: default 60
    //                   1 171
    //                   2 60
    //                   3 149
    //                   4 60
    //                   5 158;
           goto _L1 _L2 _L1 _L3 _L1 _L4
_L1:
        int j = 0;
_L9:
        i & 0x70;
        JVM INSTR lookupswitch 3: default 104
    //                   16: 208
    //                   48: 186
    //                   80: 195;
           goto _L5 _L6 _L7 _L8
_L5:
        i = ((flag) ? 1 : 0);
_L10:
        drawable.setBounds(j, i, l + j, i1 + i);
        canvas.save();
        canvas.rotate(f2, f, f1);
        drawable.draw(canvas);
        canvas.restore();
        return;
_L3:
        j = Math.round(f);
          goto _L9
_L4:
        j = Math.round(f - (float)l);
          goto _L9
_L2:
        j = Math.round(f - (float)l / 2.0F);
          goto _L9
_L7:
        i = Math.round(f1);
          goto _L10
_L8:
        i = Math.round(f1 - (float)i1);
          goto _L10
_L6:
        i = Math.round(f1 - (float)i1 / 2.0F);
          goto _L10
    }

    public static void drawWithIntrinsicSize(Canvas canvas, Drawable drawable, PointF pointf)
    {
        drawWithIntrinsicSize(canvas, drawable, pointf.x, pointf.y, 17, 0.0F);
    }

    public static void drawWithIntrinsicSize(Canvas canvas, Drawable drawable, PointF pointf, int i)
    {
        drawWithIntrinsicSize(canvas, drawable, pointf.x, pointf.y, 17, 0.0F);
    }

    public static float generate(float f, Stroke stroke)
    {
        float f2 = stroke.getVelocity(f);
        float f1 = Math.max(0.1F, stroke.getPressure(f));
        if (f2 >= 40F)
        {
            f = 0.4F;
        } else
        {
            f = 1.0F - f2 * 0.01404762F;
        }
        return f * (float)Math.pow(f1, 0.29999999999999999D);
    }

    public static int generate(float f, Stroke stroke)
    {
        f = stroke.getVelocity(f);
        if (f >= 15F)
        {
            f = 55F;
        } else
        {
            f = 255F - f * 13.33333F;
        }
        return (int)f;
    }

    public static List getMaskCategories(Context context, String s)
    {
        if (s.isEmpty())
        {
            throw new IllegalArgumentException("cannot create masks categories from empty string");
        }
          goto _L1
_L3:
        Log.e("ex1", (new StringBuilder("invalid json: ")).append(s.getMessage()).toString());
        s.printStackTrace();
        return getMaskCategoriesFromShop(context);
_L1:
        s = (new JSONObject(s)).getJSONArray("categories");
        if (s != null)
        {
            break; /* Loop/switch isn't completed */
        }
        try
        {
            throw new IllegalArgumentException("there is no \"categories\" element in passed json");
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        finally
        {
            getMaskCategoriesFromShop(context);
        }
        if (true) goto _L3; else goto _L2
        throw s;
_L2:
        ArrayList arraylist = new ArrayList(s.length());
        int i = 0;
_L7:
        JSONArray jsonarray;
        h h1;
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = (JSONObject)s.getJSONObject(i).get("category");
        jsonarray = jsonobject.getJSONArray("items");
        h1 = new h();
        h1.a = jsonobject.getString("name");
        h1.b = jsonobject.getString("folder");
        h1.c = new ArrayList(jsonarray.length());
        int j = 0;
_L5:
        if (j >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject1 = (JSONObject)jsonarray.getJSONObject(j).get("mask");
        Mask mask = new Mask();
        mask.b = jsonobject1.getString("name");
        mask.c = jsonobject1.getString("icon");
        mask.d = jsonobject1.getString("url");
        mask.e = jsonobject1.getString("extention");
        mask.a(jsonobject1.getString("orientation"));
        String s1 = jsonobject1.getString("resType");
        mask.f = (com.picsart.studio.editor.custommasks.Mask.ResourceType)Mask.a.get(s1);
        if (mask.f == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s1).append(": invalid resource type").toString());
        }
        mask.a(jsonobject1.getString("blendMode"), true);
        mask.a(jsonobject1.getString("blendMode"), false);
        mask.h = h1;
        h1.c.add(mask);
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        arraylist.add(h1);
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        arraylist.addAll(getMaskCategoriesFromShop(context));
        return arraylist;
    }

    public static List getMaskCategoriesFromJson(String s)
    {
        if (s.isEmpty())
        {
            throw new IllegalArgumentException("cannot create masks categories from empty string");
        }
        s = (new JSONObject(s)).getJSONArray("categories");
        if (s == null)
        {
            throw new IllegalArgumentException("there is no \"categories\" element in passed json");
        }
        ArrayList arraylist = new ArrayList(s.length());
        for (int i = 0; i < s.length(); i++)
        {
            JSONObject jsonobject = (JSONObject)s.getJSONObject(i).get("category");
            JSONArray jsonarray = jsonobject.getJSONArray("items");
            h h1 = new h();
            h1.a = jsonobject.getString("name");
            h1.b = jsonobject.getString("folder");
            h1.c = new ArrayList(jsonarray.length());
            for (int j = 0; j < jsonarray.length(); j++)
            {
                JSONObject jsonobject1 = (JSONObject)jsonarray.getJSONObject(j).get("mask");
                Mask mask = new Mask();
                mask.b = jsonobject1.getString("name");
                mask.c = jsonobject1.getString("icon");
                mask.d = jsonobject1.getString("url");
                mask.e = jsonobject1.getString("extention");
                mask.a(jsonobject1.getString("orientation"));
                String s1 = jsonobject1.getString("resType");
                mask.f = (com.picsart.studio.editor.custommasks.Mask.ResourceType)Mask.a.get(s1);
                if (mask.f == null)
                {
                    throw new IllegalArgumentException((new StringBuilder()).append(s1).append(": invalid resource type").toString());
                }
                mask.a(jsonobject1.getString("blendMode"), true);
                mask.a(jsonobject1.getString("blendMode"), false);
                mask.h = h1;
                h1.c.add(mask);
            }

            arraylist.add(h1);
        }

        return arraylist;
    }

    public static List getMaskCategoriesFromShop(Context context)
    {
        Object obj = com.picsart.shop.a.a(context).c();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem)((Iterator) (obj)).next();
            if (((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).installed)
            {
                h h1 = new h();
                h1.a = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.name;
                h1.b = ((com.socialin.android.apiv3.model.ShopItemsListResponse.ShopItem) (obj1)).data.shopItemUid;
                h1.e = true;
                obj1 = com.picsart.shop.a.a(context).a(context, h1.b, 5);
                arraylist.add(h1);
                h1.c = new ArrayList(((List) (obj1)).size());
                obj1 = ((List) (obj1)).iterator();
                while (((Iterator) (obj1)).hasNext()) 
                {
                    c c1 = (c)((Iterator) (obj1)).next();
                    String s = c1.m;
                    int i = s.indexOf(".");
                    Mask mask = new Mask();
                    mask.b = c1.s;
                    mask.c = c1.l;
                    mask.d = s.substring(0, i);
                    mask.e = s.substring(i, s.length());
                    mask.f = com.picsart.studio.editor.custommasks.Mask.ResourceType.DOWNLOADABLE;
                    mask.a(c1.x, true);
                    mask.a(c1.x, false);
                    mask.a(c1.t);
                    mask.h = h1;
                    h1.c.add(mask);
                }
            }
        } while (true);
        return arraylist;
    }

    public static void setDrawable(ImageView imageview, Drawable drawable)
    {
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
            if (imageview != null)
            {
                imageview.setImageDrawable(drawable);
            }
        } else
        if (imageview != null && imageview.getContext() != null && (imageview.getContext() instanceof Activity))
        {
            ((Activity)imageview.getContext()).runOnUiThread(new k(imageview, drawable));
            return;
        }
    }

    public abstract void finish();

    public abstract View getCustomView();

    public abstract Menu getMenu();

    public abstract MenuInflater getMenuInflater();

    public abstract CharSequence getSubtitle();

    public Object getTag()
    {
        return mTag;
    }

    public abstract CharSequence getTitle();

    public boolean getTitleOptionalHint()
    {
        return mTitleOptionalHint;
    }

    public abstract void invalidate();

    public boolean isTitleOptional()
    {
        return false;
    }

    public boolean isUiFocusable()
    {
        return true;
    }

    public abstract void setCustomView(View view);

    public abstract void setSubtitle(int i);

    public abstract void setSubtitle(CharSequence charsequence);

    public void setTag(Object obj)
    {
        mTag = obj;
    }

    public abstract void setTitle(int i);

    public abstract void setTitle(CharSequence charsequence);

    public void setTitleOptionalHint(boolean flag)
    {
        mTitleOptionalHint = flag;
    }
}
