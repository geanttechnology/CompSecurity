// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.all;
import android.view.LayoutInflater;
import android.view.View;
import com.abtnprojects.ambatana.models.product.Product;
import com.abtnprojects.ambatana.ui.activities.ProductActivity;
import com.abtnprojects.ambatana.ui.activities.chat.MessagesActivity;

public class g
{

    private all a;

    public g()
    {
    }

    public void a()
    {
        all.a();
    }

    public void a(Product product, ProductActivity productactivity)
    {
        boolean flag;
        if (product != null && product.isFavorite())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (productactivity != null && flag)
        {
            View view = productactivity.getLayoutInflater().inflate(0x7f040066, null);
            view.findViewById(0x7f100152).setOnClickListener(new android.view.View.OnClickListener(productactivity, product) {

                final ProductActivity a;
                final Product b;
                final g c;

                public void onClick(View view1)
                {
                    a.H();
                    c.a(b, a.getString(0x7f09004f), a);
                }

            
            {
                c = g.this;
                a = productactivity;
                b = product;
                super();
            }
            });
            if (a != null)
            {
                all.a(a);
            }
            a = all.a(productactivity, view, 0x7f100091, (new android.support.v7.alk.a()).a(4000).b(0x10a0000).c(0x10a0001).a());
            a.b();
        }
    }

    void a(Product product, String s, Activity activity)
    {
        Intent intent = new Intent(activity, com/abtnprojects/ambatana/ui/activities/chat/MessagesActivity);
        intent.putExtra("product", product);
        intent.putExtra("message_type", 0);
        intent.putExtra("message_content", s);
        intent.putExtra("action_defined", "user_liked");
        intent.putExtra("origin_activity", 1);
        activity.startActivity(intent);
    }
}
