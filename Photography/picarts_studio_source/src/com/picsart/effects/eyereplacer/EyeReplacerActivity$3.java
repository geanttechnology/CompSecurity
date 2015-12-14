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

final class a
    implements android.view.ReplacerActivity._cls3
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
                        w.a(view, bitmap, android.graphics.PNG, a);
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
                    (new ModernAsyncTask(bitmap, l) {

                        private Bitmap a;
                        private long b;
                        private EyeReplacerActivity._cls3 c;

                        protected final Object doInBackground(Object aobj[])
                        {
                            return EyeReplacerActivity.a(c.a).a(EyeReplacerActivity.j(c.a), EyeReplacerActivity.k(c.a), EyeReplacerActivity.l(c.a), EyeReplacerActivity.h(c.a), EyeReplacerActivity.i(c.a), EyeReplacerActivity.m(c.a));
                        }

                        protected final void onPostExecute(Object obj2)
                        {
                            obj2 = (HashMap)obj2;
                            if (EyeReplacerActivity.n(c.a).isShowing())
                            {
                                EyeReplacerActivity.n(c.a).dismiss();
                            }
                            if (!c.a.isFinishing())
                            {
                                Intent intent1 = new Intent();
                                Object obj3;
                                Object obj4;
                                int k;
                                int i1;
                                boolean flag1;
                                if (obj2 != null)
                                {
                                    intent1.putExtra("result_buffer_Data", ((java.io.Serializable) (obj2)));
                                } else
                                if (EyeReplacerActivity.h(c.a) != null)
                                {
                                    intent1.putExtra("path", EyeReplacerActivity.h(c.a));
                                }
                                obj3 = "";
                                obj4 = c.a.getIntent();
                                obj2 = obj3;
                                if (((Intent) (obj4)).hasExtra("editing_data"))
                                {
                                    obj4 = (EditingData)((Intent) (obj4)).getParcelableExtra("editing_data");
                                    obj2 = obj3;
                                    if (obj4 != null)
                                    {
                                        obj2 = ((EditingData) (obj4)).a;
                                    }
                                }
                                Log.e("ex1", (new StringBuilder("EYE replacer remover uid = ")).append(((String) (obj2))).toString());
                                obj3 = c.a;
                                k = a.getWidth();
                                i1 = a.getHeight();
                                if (!c.a.a)
                                {
                                    flag1 = true;
                                } else
                                {
                                    flag1 = false;
                                }
                                e.a(((android.content.Context) (obj3)), "effect_color_eye", k, i1, flag1, true, (System.nanoTime() - b) / 0xf4240L, false, new JSONArray(), ((String) (obj2)));
                                c.a.setResult(-1, intent1);
                                c.a.finish();
                            }
                        }

            
            {
                c = EyeReplacerActivity._cls3.this;
                a = bitmap;
                b = l;
                super();
            }
                    }).executeOnExecutor(EyeReplacerActivity.o(a), new Void[] {
                        null
                    });
                    EyeReplacerActivity.n(a).show();
                    return;
                }
            }
        }
    }

    _cls1.b(EyeReplacerActivity eyereplaceractivity)
    {
        a = eyereplaceractivity;
        super();
    }
}
