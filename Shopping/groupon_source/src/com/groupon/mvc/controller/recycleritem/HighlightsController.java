// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.country.Country;
import com.groupon.mvc.model.Highlights;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class HighlightsController extends RecyclerItemViewController
{

    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    private Option option;

    public HighlightsController(Context context)
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
        String s;
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isJapan() && option != null && Strings.notEmpty(option.highlightsHtml))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            s = option.highlightsHtml;
        } else
        {
            s = deal.highlightsHtml;
        }
        if (Strings.isEmpty(s))
        {
            setState(0);
            return;
        } else
        {
            model = new Highlights();
            ((Highlights)model).highlightsHtml = s;
            ((Highlights)model).webViewCSSStyling = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
            setState(2);
            return;
        }
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }
}
