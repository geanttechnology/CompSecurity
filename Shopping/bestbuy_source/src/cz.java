// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class cz extends ArrayAdapter
{

    public List a;
    private Activity b;
    private boolean c;

    public cz(Activity activity, int i, ArrayList arraylist, boolean flag)
    {
        super(activity, i);
        b = activity;
        c = flag;
        a = arraylist;
    }

    public int getCount()
    {
        return a.size();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        Object obj1;
        if (view == null)
        {
            view = ((LayoutInflater)b.getSystemService("layout_inflater")).inflate(0x7f0300e4, null, true);
            viewgroup = new da(this);
            viewgroup.a = (BBYTextView)view.findViewById(0x7f0c0384);
            viewgroup.b = (BBYTextView)view.findViewById(0x7f0c0385);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (da)view.getTag();
        }
        obj = (RegistryWishList)a.get(i);
        if (!c)
        {
            ((da) (viewgroup)).a.setText(Html.fromHtml(((RegistryWishList) (obj)).getShortDescription()));
        } else
        {
            ((da) (viewgroup)).a.setText(((RegistryWishList) (obj)).getShortDescription());
        }
        obj = ((RegistryWishList) (obj)).getOccasionDate();
        obj1 = (new SimpleDateFormat("MM/dd/yyyy")).parse(((String) (obj)));
        obj1 = (new SimpleDateFormat("MMMM d, yyyy")).format(((java.util.Date) (obj1)));
        obj = obj1;
_L2:
        ((da) (viewgroup)).b.setText(((String) (obj)));
        return view;
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
    }
}
