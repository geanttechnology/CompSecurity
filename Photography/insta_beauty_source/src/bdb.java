// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.instamag.activity.library.view.MaglibItemView;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import java.util.ArrayList;

public class bdb extends beb
{

    private ArrayList a;
    private final Context b;
    private bda c;
    private bdz d;

    public bdb(Context context, ArrayList arraylist, bda bda1, bdz bdz)
    {
        a = null;
        b = context;
        c = bda1;
        a = arraylist;
        d = bdz;
    }

    public int a()
    {
        if (a != null)
        {
            return a.size();
        } else
        {
            return 0;
        }
    }

    public View a(View view, ViewGroup viewgroup, int i)
    {
        bdd bdd1;
        if (a != null)
        {
            viewgroup = (TPhotoComposeInfo)a.get(i);
        } else
        {
            viewgroup = null;
        }
        if (view == null)
        {
            view = new MaglibItemView(b);
            ((MaglibItemView)view).setItemClickLisener(d);
            bdd1 = new bdd(null);
            bdd.a(bdd1, ((MaglibItemView)view).getImageView());
            view.setTag(bdd1);
            view.setBackgroundColor(Color.rgb(28, 28, 28));
        } else
        {
            bdd1 = (bdd)view.getTag();
        }
        ((MaglibItemView)view).SetDataInfo(viewgroup);
        if (c != null)
        {
            c.a(viewgroup, bdd.a(bdd1));
        }
        return view;
    }
}
