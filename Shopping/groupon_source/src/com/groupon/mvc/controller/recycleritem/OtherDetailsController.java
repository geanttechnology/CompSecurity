// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.mvc.model.OtherDetails;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class OtherDetailsController extends RecyclerItemViewController
{

    private Deal deal;

    public OtherDetailsController(Context context)
    {
        super(context);
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public Void getCallback()
    {
        return null;
    }

    public void processData()
    {
        String s = deal.specificAttributesReservationsHtml;
        if (Strings.isEmpty(s))
        {
            setState(0);
            return;
        } else
        {
            model = new OtherDetails();
            ((OtherDetails)model).reservationsHtml = s;
            ((OtherDetails)model).webViewCSSStyling = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
            setState(2);
            return;
        }
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }
}
