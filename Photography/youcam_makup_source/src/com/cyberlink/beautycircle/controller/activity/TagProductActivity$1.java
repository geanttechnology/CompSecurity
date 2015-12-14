// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.k;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            TagProductActivity

class a
    implements Runnable
{

    final TagProductActivity a;

    public void run()
    {
        Iterator iterator = TagProductActivity.a(a).iterator();
        int i = 0;
        Object obj;
        for (; iterator.hasNext(); TagProductActivity.f(a).add(obj))
        {
            obj = (com.cyberlink.beautycircle.model.uctActivity._cls1.a)iterator.next();
            obj = TagProductActivity.a(a, ((com.cyberlink.beautycircle.model.uctActivity._cls1.a) (obj)), i);
            TagProductActivity.b(a).addView(((View) (obj)));
            TagProductActivity.c(a).add(obj);
            obj = TagProductActivity.e(a).inflate(k.bc_view_item_tag_product_number, TagProductActivity.d(a), false);
            ((View) (obj)).setVisibility(0);
            TextView textview = (TextView)((View) (obj)).findViewById(j.tag_number);
            i++;
            textview.setText(String.valueOf(i));
            TagProductActivity.d(a).addView(((View) (obj)));
        }

        TagProductActivity.d(a).post(new Runnable() {

            final TagProductActivity._cls1 a;

            public void run()
            {
                for (int l = 0; l < TagProductActivity.f(a.a).size(); l++)
                {
                    View view = (View)TagProductActivity.f(a.a).get(l);
                    com.cyberlink.beautycircle.model.Tags.ProductTag.TagPoint tagpoint = ((com.cyberlink.beautycircle.model.Tags.ProductTag)TagProductActivity.a(a.a).get(l)).b();
                    view.setTranslationX((float)(tagpoint.xRatio * (double)TagProductActivity.d(a.a).getWidth()) - (float)view.getWidth() / 2.0F);
                    view.setTranslationY((float)(tagpoint.yRatio * (double)TagProductActivity.d(a.a).getHeight()) - (float)view.getHeight() / 2.0F);
                }

            }

            
            {
                a = TagProductActivity._cls1.this;
                super();
            }
        });
    }

    _cls1.a(TagProductActivity tagproductactivity)
    {
        a = tagproductactivity;
        super();
    }
}
