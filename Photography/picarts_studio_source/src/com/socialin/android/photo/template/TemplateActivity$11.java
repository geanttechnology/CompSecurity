// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.template;

import android.graphics.Matrix;
import com.picsart.studio.PicsartContext;
import com.socialin.android.brushlib.util.b;
import com.socialin.android.d;
import com.socialin.android.util.w;
import java.util.ArrayList;
import java.util.Collections;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.template:
//            TemplateActivity, TemplateView, Template, TemplateImage, 
//            h

final class a extends Thread
{

    final TemplateActivity a;

    public final void run()
    {
        TemplateView templateview = com.socialin.android.photo.template.TemplateActivity.b(a);
        Collections.shuffle(templateview.x);
        int j = 0;
        int i = 0;
        do
        {
label0:
            {
                if (j >= templateview.p.f.size())
                {
                    break label0;
                }
                TemplateImage templateimage = (TemplateImage)templateview.p.f.get(j);
                if (i < templateview.x.size() && templateimage.k != null)
                {
                    if (((h)templateview.x.get(i)).d != null)
                    {
                        templateimage.k = w.b(((h)templateview.x.get(i)).d, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)templateview.x.get(i)).e);
                    } else
                    {
                        try
                        {
                            templateimage.k = w.a(((h)templateview.x.get(i)).c, PicsartContext.a.getCollageImageMaxSize(), PicsartContext.a.getCollageImageMaxSize(), ((h)templateview.x.get(i)).e);
                        }
                        catch (Exception exception)
                        {
                            d.b(TemplateView.a, new Object[] {
                                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
                            });
                        }
                    }
                    if (templateimage.k == null)
                    {
                        break label0;
                    }
                    templateimage.k = b.a(new Matrix(), templateimage.k, (int)templateimage.d, (int)templateimage.e);
                    if (templateimage.o != 1)
                    {
                        templateimage.k = w.a(templateimage.k, templateimage.o);
                    }
                    ((h)templateview.x.get(i)).b = templateimage.k;
                    templateimage.l = ((h)templateview.x.get(i)).c;
                    templateimage.n = ((h)templateview.x.get(i)).e;
                    templateimage.o = ((h)templateview.x.get(i)).f;
                    templateimage.p = ((h)templateview.x.get(i)).a;
                    templateimage.j = null;
                    templateimage.m = ((h)templateview.x.get(i)).d;
                    i++;
                }
                j++;
                continue;
            }
            a.runOnUiThread(new Runnable() {

                private TemplateActivity._cls11 a;

                public final void run()
                {
                    com.socialin.android.photo.template.TemplateActivity.b(a.a).invalidate();
                    com.socialin.android.photo.template.TemplateActivity.b(a.a).a();
                    m.b(a.a, a.a.a);
                }

            
            {
                a = TemplateActivity._cls11.this;
                super();
            }
            });
            return;
        } while (true);
    }

    _cls1.a(TemplateActivity templateactivity)
    {
        a = templateactivity;
        super();
    }
}
