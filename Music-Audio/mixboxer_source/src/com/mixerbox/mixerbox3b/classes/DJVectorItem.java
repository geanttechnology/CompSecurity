// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem, CircleBitmapDisplayer

public class DJVectorItem
    implements MyItem
{

    private Context ctx;
    private JSONObject jOb;
    private String size;
    private String title;
    private String u;

    public DJVectorItem(Context context, JSONObject jsonobject)
    {
        ctx = context;
        jOb = jsonobject;
        try
        {
            title = jsonobject.getString("title");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            title = "";
        }
        try
        {
            size = jsonobject.getString("size");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            size = "";
        }
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            u = jsonobject.getString("thumbnailHQ");
            return;
        }
        try
        {
            u = jsonobject.getString("thumbnail");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            u = "";
        }
        return;
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        com.nostra13.universalimageloader.core.DisplayImageOptions displayimageoptions;
        if (view == null)
        {
            view = layoutinflater.inflate(0x7f030048, null);
            layoutinflater = new ViewHolder(null);
            layoutinflater.iv = (ImageView)view.findViewById(0x7f070100);
            layoutinflater.tvTitle = (TextView)view.findViewById(0x7f070102);
            layoutinflater.tvCount = (TextView)view.findViewById(0x7f070101);
            view.setTag(layoutinflater);
        } else
        {
            layoutinflater = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (layoutinflater)).tvTitle.setText(title);
        ((ViewHolder) (layoutinflater)).tvCount.setText((new StringBuilder()).append(size).append(" ").append(ctx.getResources().getString(0x7f0800d6)).toString());
        displayimageoptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).displayer(new CircleBitmapDisplayer()).build();
        ImageLoader.getInstance().displayImage("", ((ViewHolder) (layoutinflater)).iv, displayimageoptions);
        ImageLoader.getInstance().displayImage(u, ((ViewHolder) (layoutinflater)).iv, displayimageoptions);
        return view;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.DJ_ITEM.ordinal();
    }

    private class ViewHolder
    {

        public ImageView iv;
        public TextView tvCount;
        public TextView tvTitle;

        private ViewHolder()
        {
        }

        ViewHolder(_cls1 _pcls1)
        {
            this();
        }
    }

}
