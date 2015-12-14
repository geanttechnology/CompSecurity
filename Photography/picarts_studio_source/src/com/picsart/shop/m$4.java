// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import android.view.View;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.d;
import java.io.File;
import myobfuscated.cp.a;
import org.json.JSONException;

// Referenced classes of package com.picsart.shop:
//            m, a

final class t>
    implements android.view..OnClickListener
{

    private m a;

    public final void onClick(View view)
    {
        boolean flag = true;
        if (SocialinV3.getInstance().isRegistered())
        {
            SocialinV3.getInstance().getUser();
            Inventory.removeShopItem(m.c(a).id);
            String s;
            Object obj;
            try
            {
                Inventory.addShopItem(m.c(a).toJson());
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                d.b(com.picsart.shop.m.a(), new Object[] {
                    (new StringBuilder("Got unexpected exception: ")).append(view.getMessage()).toString()
                });
            }
        }
        view = a.getActivity();
        com.picsart.shop.m.d(a);
        m.e(a);
        if (view != null && !view.isFinishing())
        {
            view = com.picsart.shop.a.a(view);
            obj = a.getActivity().getApplicationContext();
            s = m.c(a).data.shopItemUid;
            if (((com.picsart.shop.a) (view)).c == null)
            {
                view.c(((android.content.Context) (obj)));
            }
            obj = new File((new StringBuilder()).append(((com.picsart.shop.a) (view)).c).append(s).toString());
            if (((File) (obj)).exists())
            {
                if (!((File) (obj)).delete())
                {
                    flag = false;
                }
            } else
            {
                flag = false;
            }
            obj = new File((new StringBuilder()).append(((com.picsart.shop.a) (view)).c).append(s).append(".part").toString());
            if (((File) (obj)).exists() && !flag)
            {
                ((File) (obj)).delete();
            }
            s = (new StringBuilder()).append(view.d(s)).append(s).toString();
            ((com.picsart.shop.a) (view)).b.a(s);
        }
    }

    n(m m1)
    {
        a = m1;
        super();
    }
}
