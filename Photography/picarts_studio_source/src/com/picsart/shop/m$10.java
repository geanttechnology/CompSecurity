// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;

import android.app.Activity;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.apiv3.util.PublicSyncInventory;
import com.socialin.android.dialog.g;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.d;
import org.json.JSONException;

// Referenced classes of package com.picsart.shop:
//            m

final class >
    implements d
{

    private m a;

    public final volatile void onCancelRequest(Object obj, Request request)
    {
    }

    public final void onFailure(Exception exception, Request request)
    {
        exception.printStackTrace();
        try
        {
            if (m.p(a).isShowing())
            {
                m.p(a).dismiss();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            com.socialin.android.d.b(m.a(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(exception.getMessage()).toString()
            });
        }
    }

    public final transient void onProgressUpdate(Integer ainteger[])
    {
    }

    public final void onSuccess(Object obj, Request request)
    {
        m.c(a).hidden = false;
        Inventory.addShopItem(m.c(a).toJson());
        if (m.c(a).data.shopItemUid.equals("ad_remover")) goto _L2; else goto _L1
_L1:
        m.b(a, "");
_L6:
        obj = a.getActivity();
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((Activity) (obj)).isFinishing())
        {
            return;
        }
          goto _L5
_L2:
        if (a.getString(0x7f0808c8).equals(a.getString(0x7f0808ce)))
        {
            PublicSyncInventory.setAdsState(true);
        }
        m.n(a);
          goto _L6
_L7:
        if (m.p(a) != null && m.p(a).isShowing())
        {
            try
            {
                m.p(a).dismiss();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return;
            }
        }
        break; /* Loop/switch isn't completed */
_L5:
        try
        {
            m.o(a);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            com.socialin.android.d.b(m.a(), new Object[] {
                (new StringBuilder("Got unexpected exception: ")).append(((JSONException) (obj)).getMessage()).toString()
            });
        }
        if (true) goto _L7; else goto _L4
_L4:
    }

    (m m1)
    {
        a = m1;
        super();
    }
}
