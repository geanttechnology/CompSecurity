// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import com.cyberlink.beautycircle.m;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.ProductComment;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ProductSocialActivity

class a
    implements android.view.activity.ProductSocialActivity._cls13
{

    final ProductComment a;
    final ProductSocialActivity b;

    public boolean onLongClick(View view)
    {
        Menu menu;
        boolean flag;
        PopupMenu popupmenu = new PopupMenu(b, view);
        menu = popupmenu.getMenu();
        UserInfo userinfo = AccountManager.d();
        if (a != null && a.creator != null && a.creator.b().c())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (userinfo == null || userinfo.id != a.creator.userId) goto _L2; else goto _L1
_L1:
        menu.add(m.bc_post_comment_menu_delete).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener(view) {

            final View a;
            final ProductSocialActivity._cls13 b;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                DialogUtils.a(b.b, "", b.b.getResources().getString(m.bc_product_review_delete_confirm_text), b.b.getResources().getString(m.bc_review_cancel), new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                    }

            
            {
                a = _pcls1;
                super();
            }
                }, b.b.getResources().getString(m.bc_review_delete), new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        ProductSocialActivity.a(a.b.b, a.b.a, a.a);
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
                return true;
            }

            
            {
                b = ProductSocialActivity._cls13.this;
                a = view;
                super();
            }
        });
_L4:
        if (e.a)
        {
            menu.add(m.bc_post_comment_menu_copy).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final ProductSocialActivity._cls13 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    ((ClipboardManager)a.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, a.a.comment));
                    return true;
                }

            
            {
                a = ProductSocialActivity._cls13.this;
                super();
            }
            });
        }
        menu.add(m.bc_post_comment_menu_cancel);
        popupmenu.show();
        return true;
_L2:
        if (!flag)
        {
            menu.add(m.bc_post_comment_menu_report).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

                final ProductSocialActivity._cls13 a;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    ProductSocialActivity.a(a.b, a.a.id);
                    return true;
                }

            
            {
                a = ProductSocialActivity._cls13.this;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls3.a(ProductSocialActivity productsocialactivity, ProductComment productcomment)
    {
        b = productsocialactivity;
        a = productcomment;
        super();
    }
}
