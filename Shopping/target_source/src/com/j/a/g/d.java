// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            o, w, c, q

final class d
    implements Runnable
{

    final Object a;
    final String b;
    final View c;
    final String d;

    d(Object obj, String s, View view, String s1)
    {
        a = obj;
        b = s;
        c = view;
        d = s1;
        super();
    }

    public void run()
    {
        int j = 0;
        if (a == null || a == JSONObject.NULL) goto _L2; else goto _L1
_L1:
        Object obj = b;
        int i = -1;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 7: default 1369
    //                   -2127641265: 242
    //                   260368425: 228
    //                   515545814: 270
    //                   1407839876: 214
    //                   1885480407: 298
    //                   1927155694: 256
    //                   1984984239: 284;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L39:
        obj = d;
        ((String) (obj)).hashCode();
        JVM INSTR lookupswitch 6: default 1415
    //                   -1266517045: 924
    //                   3212: 952
    //                   3677: 938
    //                   104431: 895
    //                   97526364: 910
    //                   126056324: 966;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L47:
        obj = Class.forName(d);
        c.getClass().getMethod(b, new Class[] {
            obj
        }).invoke(c, new Object[] {
            a
        });
        return;
_L7:
        if (((String) (obj)).equals("setWidth"))
        {
            i = 0;
        }
          goto _L3
_L5:
        if (((String) (obj)).equals("setHeight"))
        {
            i = 1;
        }
          goto _L3
_L4:
        if (((String) (obj)).equals("setPadding"))
        {
            i = 2;
        }
          goto _L3
_L9:
        if (((String) (obj)).equals("setBackgroundDrawable"))
        {
            i = 3;
        }
          goto _L3
_L6:
        if (((String) (obj)).equals("setHintText"))
        {
            i = 4;
        }
          goto _L3
_L10:
        if (((String) (obj)).equals("setText"))
        {
            i = 5;
        }
          goto _L3
_L8:
        if (((String) (obj)).equals("setImageDrawable"))
        {
            i = 6;
        }
          goto _L3
_L40:
        if (a != JSONObject.NULL)
        {
            float f = ((Number)a).floatValue();
            c.getLayoutParams().width = o.a(f);
            c.requestLayout();
            return;
        }
          goto _L2
_L31:
        try
        {
            c.setBackgroundDrawable(((Drawable) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            w.b((new StringBuilder()).append(((Exception) (obj)).getCause()).append(": ").append(c.getClass()).append(", ").append(b).append(", ").append(((Exception) (obj)).getMessage()).toString(), ((Exception) (obj)));
            return;
        }
        w.b((new StringBuilder()).append("Method errors on ").append(b).toString(), ((Exception) (obj)));
        return;
_L41:
        if (a != JSONObject.NULL)
        {
            f1 = ((Number)a).floatValue();
            c.getLayoutParams().height = o.a(f1);
            c.requestLayout();
            return;
        }
          goto _L2
_L42:
        obj = (JSONObject)a;
        if (!((JSONObject) (obj)).has("left") || ((JSONObject) (obj)).isNull("left")) goto _L19; else goto _L18
_L18:
        i = o.a(((JSONObject) (obj)).getInt("left"));
_L26:
        if (!((JSONObject) (obj)).has("right") || ((JSONObject) (obj)).isNull("right")) goto _L21; else goto _L20
_L20:
        j = o.a(((JSONObject) (obj)).getInt("right"));
_L27:
        if (!((JSONObject) (obj)).has("top") || ((JSONObject) (obj)).isNull("top")) goto _L23; else goto _L22
_L22:
        k = o.a(((JSONObject) (obj)).getInt("top"));
_L28:
        if (!((JSONObject) (obj)).has("bottom") || ((JSONObject) (obj)).isNull("bottom")) goto _L25; else goto _L24
_L24:
        l = o.a(((JSONObject) (obj)).getInt("bottom"));
_L29:
        c.getClass().getMethod(b, new Class[] {
            Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE
        }).invoke(c, new Object[] {
            Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(l)
        });
        return;
_L19:
        i = c.getPaddingLeft();
          goto _L26
_L21:
        j = c.getPaddingRight();
          goto _L27
_L23:
        k = c.getPaddingTop();
          goto _L28
_L25:
        l = c.getPaddingBottom();
          goto _L29
_L43:
        obj = com.j.a.g.c.a(a);
        if (!((File) (obj)).exists()) goto _L2; else goto _L30
_L30:
        obj = Drawable.createFromPath(((File) (obj)).getAbsolutePath());
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            c.setBackground(((Drawable) (obj)));
            return;
        }
          goto _L31
_L44:
        obj = ((String)a).replace("\\n", "\n");
        ((TextView)c).setHint(((CharSequence) (obj)));
        return;
_L45:
        obj = ((String)a).replace("\\n", "\n");
        ((TextView)c).setText(((CharSequence) (obj)));
        return;
_L46:
        obj = com.j.a.g.c.a(a);
        if (((File) (obj)).exists())
        {
            obj = Drawable.createFromPath(((File) (obj)).getAbsolutePath());
            if (android.os.Build.VERSION.SDK_INT >= 9)
            {
                ((ImageView)c).setImageDrawable(((Drawable) (obj)));
                return;
            }
        }
          goto _L2
_L15:
        if (!((String) (obj)).equals("int")) goto _L11; else goto _L32
_L32:
        i = j;
          goto _L33
_L16:
        if (!((String) (obj)).equals("float")) goto _L11; else goto _L34
_L34:
        i = 1;
          goto _L33
_L12:
        if (!((String) (obj)).equals("tlColor")) goto _L11; else goto _L35
_L35:
        i = 2;
          goto _L33
_L14:
        if (!((String) (obj)).equals("sp")) goto _L11; else goto _L36
_L36:
        i = 3;
          goto _L33
_L13:
        if (!((String) (obj)).equals("dp")) goto _L11; else goto _L37
_L37:
        i = 4;
          goto _L33
_L17:
        if (!((String) (obj)).equals("ScaleType")) goto _L11; else goto _L38
_L38:
        i = 5;
          goto _L33
_L48:
        if (a instanceof Number)
        {
            c.getClass().getMethod(b, new Class[] {
                Integer.TYPE
            }).invoke(c, new Object[] {
                Integer.valueOf(((Number)a).intValue())
            });
            return;
        }
_L49:
        if (a instanceof Number)
        {
            c.getClass().getMethod(b, new Class[] {
                Float.TYPE
            }).invoke(c, new Object[] {
                Float.valueOf(((Number)a).floatValue())
            });
            return;
        }
_L50:
        obj = q.a(a);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1159;
        }
        c.getClass().getMethod(b, new Class[] {
            Integer.TYPE
        }).invoke(c, new Object[] {
            obj
        });
        return;
_L51:
        if (a instanceof Number)
        {
            c.getClass().getMethod(b, new Class[] {
                Integer.TYPE, Float.TYPE
            }).invoke(c, new Object[] {
                Integer.valueOf(2), Float.valueOf(((Number)a).floatValue())
            });
            return;
        }
          goto _L2
_L52:
        if (a instanceof Number)
        {
            i = o.a(((Number)a).floatValue());
            c.getClass().getMethod(b, new Class[] {
                Integer.TYPE
            }).invoke(c, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
          goto _L2
_L53:
        if (a instanceof Number)
        {
            obj = android.widget.ImageView.ScaleType.values()[((Number)a).intValue()];
            c.getClass().getMethod(b, new Class[] {
                android/widget/ImageView$ScaleType
            }).invoke(c, new Object[] {
                obj
            });
            return;
        }
          goto _L2
_L3:
        i;
        JVM INSTR tableswitch 0 6: default 1412
    //                   0 313
    //                   1 384
    //                   2 427
    //                   3 687
    //                   4 736
    //                   5 825
    //                   6 852;
           goto _L39 _L40 _L41 _L42 _L43 _L44 _L45 _L46
_L11:
        i = -1;
_L33:
        i;
        JVM INSTR tableswitch 0 5: default 1456
    //                   0 980
    //                   1 1043
    //                   2 1106
    //                   3 1159
    //                   4 1235
    //                   5 1303;
           goto _L47 _L48 _L49 _L50 _L51 _L52 _L53
_L2:
    }
}
