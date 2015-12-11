// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.outfitbuilder;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bitstrips.outfitbuilder.managers.OBUrlsManager;
import com.bitstrips.outfitbuilder.models.OBAvatarData;
import com.bitstrips.outfitbuilder.models.OBOutfit;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import java.util.ArrayList;

// Referenced classes of package com.bitstrips.outfitbuilder:
//            OBFittingRoomActivity

public class avatarData extends PagerAdapter
{

    OBAvatarData avatarData;
    Context context;
    ArrayList items;
    final OBFittingRoomActivity this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return items.size();
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        Object obj = (OBOutfit)items.get(i);
        LayoutInflater.from(context);
        ImageView imageview = new ImageView(context);
        android.widget.gRoomAdapter groomadapter = new android.widget.gRoomAdapter.context(-1, -1);
        imageview.setTag(Integer.valueOf(((OBOutfit) (obj)).getId()));
        obj = OBUrlsManager.getInstance().getFloatingOutfitUrl(((OBOutfit) (obj)).getId(), avatarData);
        Picasso.with(context).load(((String) (obj))).fit().centerCrop().into(imageview);
        viewgroup.addView(imageview, 0, groomadapter);
        return imageview;
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public (Context context1, ArrayList arraylist, OBAvatarData obavatardata)
    {
        this$0 = OBFittingRoomActivity.this;
        super();
        context = context1;
        items = arraylist;
        avatarData = obavatardata;
    }
}
