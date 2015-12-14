// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.eyereplacer;

import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import com.picsart.studio.EditingData;
import com.socialin.android.dialog.g;
import com.socialin.android.util.ModernAsyncTask;
import com.socialin.android.util.Utils;
import com.socialin.android.util.w;
import java.io.File;
import java.util.HashMap;
import myobfuscated.ay.e;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.eyereplacer:
//            EyeReplacerActivity, a, EyeReplaceImageView

final class b extends ModernAsyncTask
{

    private Bitmap a;
    private long b;
    private sh c;

    protected final Object doInBackground(Object aobj[])
    {
        return EyeReplacerActivity.a(c.c).a(EyeReplacerActivity.j(c.c), EyeReplacerActivity.k(c.c), EyeReplacerActivity.l(c.c), EyeReplacerActivity.h(c.c), EyeReplacerActivity.i(c.c), EyeReplacerActivity.m(c.c));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        if (EyeReplacerActivity.n(c.c).isShowing())
        {
            EyeReplacerActivity.n(c.c).dismiss();
        }
        if (!c.c.isFinishing())
        {
            Intent intent = new Intent();
            Object obj1;
            Object obj2;
            int i;
            int j;
            boolean flag;
            if (obj != null)
            {
                intent.putExtra("result_buffer_Data", ((java.io.Serializable) (obj)));
            } else
            if (EyeReplacerActivity.h(c.c) != null)
            {
                intent.putExtra("path", EyeReplacerActivity.h(c.c));
            }
            obj1 = "";
            obj2 = c.c.getIntent();
            obj = obj1;
            if (((Intent) (obj2)).hasExtra("editing_data"))
            {
                obj2 = (EditingData)((Intent) (obj2)).getParcelableExtra("editing_data");
                obj = obj1;
                if (obj2 != null)
                {
                    obj = ((EditingData) (obj2)).a;
                }
            }
            Log.e("ex1", (new StringBuilder("EYE replacer remover uid = ")).append(((String) (obj))).toString());
            obj1 = c.c;
            i = a.getWidth();
            j = a.getHeight();
            if (!c.c.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            e.a(((android.content.Context) (obj1)), "effect_color_eye", i, j, flag, true, (System.nanoTime() - b) / 0xf4240L, false, new JSONArray(), ((String) (obj)));
            c.c.setResult(-1, intent);
            c.c.finish();
        }
    }

    ( , Bitmap bitmap, long l)
    {
        c = ;
        a = bitmap;
        b = l;
        super();
    }

    // Unreferenced inner class com/picsart/effects/eyereplacer/EyeReplacerActivity$3

/* anonymous class */
    final class EyeReplacerActivity._cls3
        implements android.view.View.OnClickListener
    {

        final EyeReplacerActivity a;

        public final void onClick(View view)
        {
            if (EyeReplacerActivity.a(a).j)
            {
                Utils.b(a, 0x7f080405);
            } else
            {
                Bitmap bitmap = EyeReplacerActivity.c(a).b;
                if (bitmap != null && !bitmap.isRecycled())
                {
                    long l = System.nanoTime();
                    if (EyeReplacerActivity.f(a) == bitmap.getWidth() && bitmap.getHeight() == com.picsart.effects.eyereplacer.EyeReplacerActivity.g(a))
                    {
                        Intent intent = new Intent();
                        Object obj;
                        Object obj1;
                        int i;
                        int j;
                        boolean flag;
                        if (EyeReplacerActivity.h(a) != null)
                        {
                            view = new File(EyeReplacerActivity.h(a));
                            w.a(view, bitmap, android.graphics.Bitmap.CompressFormat.PNG, a);
                            intent.putExtra("path", view.getAbsolutePath());
                        } else
                        if (EyeReplacerActivity.i(a) != null)
                        {
                            intent.putExtra("result_buffer_Data", w.a(EyeReplacerActivity.i(a), bitmap));
                        }
                        obj = "";
                        obj1 = a.getIntent();
                        view = ((View) (obj));
                        if (((Intent) (obj1)).hasExtra("editing_data"))
                        {
                            obj1 = (EditingData)((Intent) (obj1)).getParcelableExtra("editing_data");
                            view = ((View) (obj));
                            if (obj1 != null)
                            {
                                view = ((EditingData) (obj1)).a;
                            }
                        }
                        Log.e("ex1", (new StringBuilder("EYE replacer remover uid = ")).append(view).toString());
                        obj = a;
                        i = bitmap.getWidth();
                        j = bitmap.getHeight();
                        if (!a.a)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        e.a(((android.content.Context) (obj)), "effect_color_eye", i, j, flag, true, (System.nanoTime() - l) / 0xf4240L, false, new JSONArray(), view);
                        a.setResult(-1, intent);
                        a.finish();
                        return;
                    } else
                    {
                        (new EyeReplacerActivity._cls3._cls1(this, bitmap, l)).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                            null
                        });
                        EyeReplacerActivity.n(a).show();
                        return;
                    }
                }
            }
        }

            
            {
                a = eyereplaceractivity;
                super();
            }
    }

}
