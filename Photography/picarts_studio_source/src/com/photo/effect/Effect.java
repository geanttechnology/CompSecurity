// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.effect;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.util.Log;
import com.socialin.android.photo.imgop.ImageResize;
import com.socialin.android.util.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import myobfuscated.au.b;
import myobfuscated.ay.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.photo.effect:
//            EffectParameter, a, b, c, 
//            d

public final class Effect
{

    public d a;
    public EnumSet b;
    public ArrayList c;
    public String d;
    public boolean e;
    public b f;
    private com.photo.effect.b g;
    private int h;
    private int i;

    public Effect()
    {
        b = EnumSet.of(EffectApplyType.EffectApplyTypeNative);
        h = -1;
        i = -1;
        e = true;
    }

    public Effect(JSONObject jsonobject)
    {
        b = EnumSet.of(EffectApplyType.EffectApplyTypeNative);
        h = -1;
        i = -1;
        e = true;
        d = jsonobject.getString("name");
        if (jsonobject.has("applyMaxSize"))
        {
            h = jsonobject.getInt("applyMaxSize");
        }
        if (jsonobject.has("applyScaleSize"))
        {
            i = jsonobject.getInt("applyScaleSize");
        }
        if (jsonobject.has("supportScale"))
        {
            e = jsonobject.getBoolean("supportScale");
        }
        jsonobject = jsonobject.getJSONArray("params");
        c = new ArrayList(jsonobject.length());
        int j = 0;
_L2:
        if (j >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        EffectParameter effectparameter = a(jsonobject.getJSONObject(j));
        c.add(effectparameter);
        j++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        jsonobject.printStackTrace();
_L1:
    }

    public Effect(JSONObject jsonobject, com.photo.effect.b b1)
    {
        this(jsonobject);
        g = b1;
    }

    private static EffectParameter a(JSONObject jsonobject)
    {
        Object obj;
        if (!jsonobject.has("type"))
        {
            break MISSING_BLOCK_LABEL_463;
        }
        obj = jsonobject.getString("type");
_L1:
        Object obj1;
        Object obj2;
        obj2 = EffectParameter.ParameterType.ParameterTypeInt;
        obj1 = jsonobject.getString("description");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        if (!((String) (obj)).equals("int"))
        {
            break MISSING_BLOCK_LABEL_86;
        }
        return new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj2)), Integer.valueOf(jsonobject.getInt("value")), Integer.valueOf(jsonobject.getInt("value")), Integer.valueOf(jsonobject.getInt("min")), Integer.valueOf(jsonobject.getInt("max")));
        if (!((String) (obj)).equals("float"))
        {
            break MISSING_BLOCK_LABEL_194;
        }
        obj = EffectParameter.ParameterType.ParameterTypeFloat;
        obj2 = jsonobject.getString("value");
        String s = jsonobject.getString("min");
        jsonobject = jsonobject.getString("max");
        jsonobject = new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj)), Float.valueOf(Float.parseFloat(((String) (obj2)))), Float.valueOf(Float.parseFloat(((String) (obj2)))), Float.valueOf(Float.parseFloat(s)), Float.valueOf(Float.parseFloat(jsonobject)));
        return jsonobject;
        HashMap hashmap;
        if (((String) (obj)).equals("Bool"))
        {
            obj = EffectParameter.ParameterType.ParameterTypeBool;
            jsonobject = Boolean.valueOf(jsonobject.getBoolean("value"));
            return new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj)), jsonobject, jsonobject);
        }
        if (((String) (obj)).equals("Color"))
        {
            obj = EffectParameter.ParameterType.ParameterTypeColor;
            jsonobject = Integer.valueOf(Color.argb(255, jsonobject.getInt("red"), jsonobject.getInt("green"), jsonobject.getInt("blue")));
            return new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj)), jsonobject, jsonobject);
        }
        if (!((String) (obj)).equals("discrete"))
        {
            break MISSING_BLOCK_LABEL_426;
        }
        obj2 = EffectParameter.ParameterType.ParameterTypeDiscrete;
        JSONObject jsonobject1 = jsonobject.getJSONObject("values");
        Iterator iterator = jsonobject1.keys();
        hashmap = new HashMap(7);
        obj = new ArrayList();
        String s2;
        String s3;
        for (; iterator.hasNext(); hashmap.put(s2, s3))
        {
            s2 = (String)iterator.next();
            s3 = jsonobject1.getString(s2);
            ((ArrayList) (obj)).add(s2);
        }

        try
        {
            jsonobject = jsonobject.getString("default_key");
            String s1 = (String)hashmap.get(jsonobject);
            obj1 = new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj2)), s1, s1, hashmap);
            obj1.g = jsonobject;
            obj1.h = ((ArrayList) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            Log.e("ex1", (new StringBuilder("JSONException = ")).append(jsonobject.toString()).toString());
            return null;
        }
        return ((EffectParameter) (obj1));
        if (!((String) (obj)).equals("Texture"))
        {
            break MISSING_BLOCK_LABEL_461;
        }
        obj = EffectParameter.ParameterType.ParameterTypeTexture;
        jsonobject = jsonobject.getString("name");
        jsonobject = new EffectParameter(((String) (obj1)), ((EffectParameter.ParameterType) (obj)), jsonobject, jsonobject);
        return jsonobject;
        return null;
        obj = null;
          goto _L1
    }

    public final float a(String s)
    {
        return com.photo.effect.EffectParameter.c(c, s);
    }

    public final Bitmap a(Context context, Bitmap bitmap)
    {
        if (g != null && bitmap != null)
        {
            bitmap.getWidth();
            bitmap.getHeight();
            if (e())
            {
                int j = bitmap.getWidth();
                int k = bitmap.getHeight();
                ByteBuffer bytebuffer = myobfuscated.ay.e.a(j * k * 4);
                bitmap.copyPixelsToBuffer(bytebuffer);
                bytebuffer.position(0);
                bitmap = myobfuscated.ay.e.a(j * k * 4);
                bitmap.position(0);
                a(context, bytebuffer, ((ByteBuffer) (bitmap)), j, k, false, -1);
                myobfuscated.ay.e.a(bytebuffer);
                context = com.socialin.android.util.c.a(j, k, android.graphics.Bitmap.Config.ARGB_8888);
                if (context != null)
                {
                    bitmap.position(0);
                    context.copyPixelsFromBuffer(bitmap);
                }
                myobfuscated.ay.e.a(bitmap);
                return context;
            }
            if (f())
            {
                return a(context, bitmap, null);
            }
        }
        return null;
    }

    public final Bitmap a(Context context, Bitmap bitmap, Bitmap bitmap1)
    {
        Object obj1 = null;
        Object obj = obj1;
        if (f())
        {
            obj = obj1;
            if (g != null)
            {
                obj = new a();
                obj.a = context;
                obj.b = bitmap;
                obj.c = bitmap1;
                obj.m = null;
                obj.h = 1.0F;
                obj.n = EffectApplyType.EffectApplyTypeBitmap;
                obj = g.a(c, a, ((a) (obj))).b;
            }
        }
        return ((Bitmap) (obj));
    }

    public final EffectParameter a(int j)
    {
        return EffectParameter.a(c, j);
    }

    public final String a()
    {
        return d;
    }

    public final void a(String s, int j)
    {
        EffectParameter.a(c, s, j);
    }

    public final boolean a(Context context, Object obj, Bitmap bitmap, Bitmap bitmap1)
    {
        if (!d() || g == null || obj == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        Allocation allocation;
        Allocation allocation1;
        boolean flag;
        allocation = Allocation.createFromBitmap((RenderScript)obj, bitmap, android.renderscript.Allocation.MipmapControl.MIPMAP_NONE, 1);
        allocation1 = Allocation.createTyped((RenderScript)obj, allocation.getType());
        if (!d() || g == null)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        a a1 = new a();
        a1.a = context;
        a1.j = obj;
        a1.k = allocation;
        a1.l = allocation1;
        a1.m = null;
        a1.b = bitmap;
        a1.h = 1.0F;
        a1.n = EffectApplyType.EffectApplyTypeRenderScript;
        flag = g.a(c, a, a1).a;
_L1:
        allocation1.copyTo(bitmap1);
        allocation.destroy();
        allocation1.destroy();
        return flag;
        flag = false;
          goto _L1
        context;
        return false;
        return false;
    }

    public final boolean a(Context context, ByteBuffer bytebuffer, ByteBuffer bytebuffer1, int j, int k, boolean flag, int l)
    {
        if (e() && g != null)
        {
            if (h > 0 && i > 0)
            {
                int i1 = j * k;
                int j1 = h * h;
                Log.e("ex1", (new StringBuilder("applyEffectMaxSize = ")).append(h).toString());
                Log.e("ex1", (new StringBuilder("applyEffectScaleSize = ")).append(i).toString());
                Log.e("ex1", (new StringBuilder("pixelsCount = ")).append(i1).toString());
                Log.e("ex1", (new StringBuilder("pixelsMaxCount = ")).append(j1).toString());
                Log.e("ex1", (new StringBuilder("size = ")).append(j).append(" : ").append(k).toString());
                if (i1 > j1)
                {
                    Log.e("ex1", "pixelsCount > pixelsMaxCount");
                    int k1 = i * i;
                    Log.e("ex1", (new StringBuilder("pixelsScaledCount = ")).append(k1).toString());
                    float f1 = (float)Math.sqrt((float)k1 / (float)i1);
                    i1 = (int)((float)j * f1);
                    k1 = (int)(f1 * (float)k);
                    Log.e("ex1", (new StringBuilder("scaledWidth = ")).append(i1).toString());
                    Log.e("ex1", (new StringBuilder("scaledHeight = ")).append(k1).toString());
                    ByteBuffer bytebuffer2 = myobfuscated.ay.e.a(i1 * k1 * 4);
                    ByteBuffer bytebuffer3 = myobfuscated.ay.e.a(i1 * k1 * 4);
                    ImageResize.resize(bytebuffer, j, k, bytebuffer2, i1, k1, 1);
                    bytebuffer = new Point(i1, k1);
                    a a3 = new a();
                    a3.a = context;
                    a3.d = bytebuffer2;
                    a3.e = bytebuffer3;
                    a3.m = null;
                    a3.i = bytebuffer;
                    a3.h = 1.0F;
                    a3.f = flag;
                    a3.g = l;
                    a3.n = EffectApplyType.EffectApplyTypeNative;
                    context = g.a(c, a, a3);
                    if (((com.photo.effect.c) (context)).a)
                    {
                        ImageResize.resize(bytebuffer3, i1, k1, bytebuffer1, j, k, 1);
                    }
                    myobfuscated.ay.e.a(bytebuffer2);
                    myobfuscated.ay.e.a(bytebuffer3);
                    return ((com.photo.effect.c) (context)).a;
                } else
                {
                    Point point = new Point(j, k);
                    a a1 = new a();
                    a1.a = context;
                    a1.d = bytebuffer;
                    a1.e = bytebuffer1;
                    a1.m = null;
                    a1.i = point;
                    a1.h = 1.0F;
                    a1.f = flag;
                    a1.g = l;
                    a1.n = EffectApplyType.EffectApplyTypeNative;
                    return g.a(c, a, a1).a;
                }
            } else
            {
                Point point1 = new Point(j, k);
                a a2 = new a();
                a2.a = context;
                a2.d = bytebuffer;
                a2.e = bytebuffer1;
                a2.m = null;
                a2.i = point1;
                a2.h = 1.0F;
                a2.f = flag;
                a2.g = l;
                a2.n = EffectApplyType.EffectApplyTypeNative;
                return g.a(c, a, a2).a;
            }
        } else
        {
            return false;
        }
    }

    public final EffectParameter b(int j)
    {
        EffectParameter effectparameter = EffectParameter.a(c, j);
        if (effectparameter != null && effectparameter.b == EffectParameter.ParameterType.ParameterTypeFloat)
        {
            return effectparameter;
        } else
        {
            return null;
        }
    }

    public final ArrayList b()
    {
        return c;
    }

    public final boolean b(String s)
    {
        return EffectParameter.d(c, s);
    }

    public final JSONArray c()
    {
        JSONArray jsonarray = new JSONArray();
        if (c != null)
        {
            Iterator iterator = c.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (EffectParameter)iterator.next();
                if (((EffectParameter) (obj)).b == EffectParameter.ParameterType.ParameterTypeInt)
                {
                    String s = ((EffectParameter) (obj)).a;
                    int j = ((Integer)((EffectParameter) (obj)).c).intValue();
                    obj = new JSONObject();
                    try
                    {
                        ((JSONObject) (obj)).put("name", s);
                        ((JSONObject) (obj)).put("value", j);
                    }
                    catch (JSONException jsonexception)
                    {
                        jsonexception.printStackTrace();
                    }
                    jsonarray.put(obj);
                } else
                if (((EffectParameter) (obj)).b == EffectParameter.ParameterType.ParameterTypeFloat)
                {
                    String s1 = ((EffectParameter) (obj)).a;
                    float f1 = ((Float)((EffectParameter) (obj)).c).floatValue();
                    obj = new JSONObject();
                    try
                    {
                        ((JSONObject) (obj)).put("name", s1);
                        ((JSONObject) (obj)).put("value", f1);
                    }
                    catch (JSONException jsonexception1)
                    {
                        jsonexception1.printStackTrace();
                    }
                    jsonarray.put(obj);
                }
            } while (true);
        }
        return jsonarray;
    }

    public final boolean d()
    {
        return b.contains(EffectApplyType.EffectApplyTypeRenderScript);
    }

    public final boolean e()
    {
        return b.contains(EffectApplyType.EffectApplyTypeNative);
    }

    public final boolean f()
    {
        return b.contains(EffectApplyType.EffectApplyTypeBitmap);
    }

    private class EffectApplyType extends Enum
    {

        private static final EffectApplyType $VALUES[];
        public static final EffectApplyType EffectApplyTypeBitmap;
        public static final EffectApplyType EffectApplyTypeNative;
        public static final EffectApplyType EffectApplyTypeRenderScript;
        private int value;

        public static EffectApplyType valueOf(String s)
        {
            return (EffectApplyType)Enum.valueOf(com/photo/effect/Effect$EffectApplyType, s);
        }

        public static EffectApplyType[] values()
        {
            return (EffectApplyType[])$VALUES.clone();
        }

        public final int getValue()
        {
            return value;
        }

        static 
        {
            EffectApplyTypeNative = new EffectApplyType("EffectApplyTypeNative", 0, 0);
            EffectApplyTypeBitmap = new EffectApplyType("EffectApplyTypeBitmap", 1, 1);
            EffectApplyTypeRenderScript = new EffectApplyType("EffectApplyTypeRenderScript", 2, 2);
            $VALUES = (new EffectApplyType[] {
                EffectApplyTypeNative, EffectApplyTypeBitmap, EffectApplyTypeRenderScript
            });
        }

        private EffectApplyType(String s, int j, int k)
        {
            super(s, j);
            value = k;
        }
    }

}
