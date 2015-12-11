// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.db.models.Business;
import com.groupon.db.models.Special;
import com.groupon.loader.BusinessDetailLoaderCallbacks;
import java.util.ArrayList;
import java.util.Iterator;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            BusinessSpecialPage

class backs extends BusinessDetailLoaderCallbacks
{

    final BusinessSpecialPage this$0;

    public void onMerchantDetailLoaded(Business business)
    {
label0:
        {
            if (business == null)
            {
                break label0;
            }
            business = business.getSpecials();
            if (business == null)
            {
                break label0;
            }
            business = business.iterator();
            Special special;
            do
            {
                if (!business.hasNext())
                {
                    break label0;
                }
                special = (Special)business.next();
            } while (!Strings.equals(special.remoteId, specialId));
            BusinessSpecialPage.access$002(BusinessSpecialPage.this, special);
            BusinessSpecialPage.access$200(BusinessSpecialPage.this);
            BusinessSpecialPage.access$100(BusinessSpecialPage.this);
        }
    }

    backs(Context context, String s)
    {
        this$0 = BusinessSpecialPage.this;
        super(context, s);
    }
}
