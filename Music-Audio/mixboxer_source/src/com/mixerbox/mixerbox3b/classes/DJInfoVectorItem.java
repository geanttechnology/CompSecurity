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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem, CircleBitmapDisplayer, BlurBitmapDisplayer, VectorOnClickListener

public class DJInfoVectorItem
    implements MyItem
{

    private Context ctx;
    String fans;
    String follow;
    JSONObject jFan;
    JSONObject jFollow;
    private JSONObject jOb;
    String name;
    boolean shouldChangeColor;
    private String u;

    public DJInfoVectorItem(Context context, JSONObject jsonobject)
    {
        boolean flag;
        flag = false;
        super();
        ctx = context;
        jOb = jsonobject;
        jFollow = new JSONObject();
        jFan = new JSONObject();
        shouldChangeColor = false;
        if (jsonobject.isNull("0")) goto _L2; else goto _L1
_L1:
        u = jsonobject.getJSONObject("0").getJSONObject("views").getJSONObject("main").getJSONObject("thumbnail").getString("url");
        if (!u.contains("default") || u.contains("mqdefault")) goto _L4; else goto _L3
_L3:
        u = u.replace("default", "mqdefault");
_L2:
        JSONObject jsonobject1;
        int i;
        try
        {
            if (!jsonobject.isNull("0"))
            {
                name = jsonobject.getJSONObject("0").getJSONObject("views").getJSONObject("main").getString("mainText");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            name = "";
        }
        if (jsonobject.isNull("0")) goto _L6; else goto _L5
_L5:
        context = jsonobject.getJSONObject("0").getJSONObject("views").getJSONObject("main").getJSONArray("subLinks");
        i = 0;
_L16:
        if (i >= context.length()) goto _L6; else goto _L7
_L7:
        jsonobject1 = context.getJSONObject(i);
        if (jsonobject1.isNull("action") || !jsonobject1.getString("action").equals("follow") && !jsonobject1.getString("action").equals("unfollow")) goto _L9; else goto _L8
_L8:
        follow = jsonobject1.getString("title");
        jFollow = jsonobject1;
        if (jsonobject1.getString("action").equals("unfollow"))
        {
            shouldChangeColor = true;
        }
_L6:
        if (jsonobject.isNull("1")) goto _L11; else goto _L10
_L10:
        context = jsonobject.getJSONObject("1").getJSONObject("views").getJSONObject("main").getJSONArray("subLinks");
        i = ((flag) ? 1 : 0);
_L17:
        if (i >= context.length()) goto _L11; else goto _L12
_L12:
        jsonobject = context.getJSONObject(i);
        if (jsonobject.isNull("type") || !jsonobject.getString("type").equals("followInfo")) goto _L14; else goto _L13
_L13:
        fans = jsonobject.getString("title");
        jFan = jsonobject;
_L11:
        return;
_L4:
        if (!u.contains("width=100&height=100")) goto _L2; else goto _L15
_L15:
        u = u.replace("width=100&height=100", "width=200&height=200");
          goto _L2
        context;
        u = "";
          goto _L2
_L9:
        i++;
          goto _L16
        context;
        follow = "";
        jFollow = new JSONObject();
          goto _L6
_L14:
        i++;
          goto _L17
        context;
        fans = "";
        jFan = new JSONObject();
        return;
          goto _L16
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = layoutinflater.inflate(0x7f030047, null);
        }
        ImageView imageview = (ImageView)view1.findViewById(0x7f0700fc);
        layoutinflater = (ImageView)view1.findViewById(0x7f0700fb);
        view = (TextView)view1.findViewById(0x7f0700fd);
        TextView textview = (TextView)view1.findViewById(0x7f0700fe);
        TextView textview1 = (TextView)view1.findViewById(0x7f0700ff);
        com.nostra13.universalimageloader.core.DisplayImageOptions displayimageoptions1 = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).displayer(new CircleBitmapDisplayer(ctx.getResources().getColor(0x7f060015), 4)).build();
        ImageLoader.getInstance().displayImage(u, imageview, displayimageoptions1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            com.nostra13.universalimageloader.core.DisplayImageOptions displayimageoptions = (new com.nostra13.universalimageloader.core.DisplayImageOptions.Builder()).cacheInMemory(true).cacheOnDisc(true).displayer(new BlurBitmapDisplayer(ctx, 4)).build();
            ImageLoader.getInstance().displayImage(u, layoutinflater, displayimageoptions);
        } else
        {
            ImageLoader.getInstance().displayImage(u, layoutinflater);
        }
        view.setText(name);
        textview.setText(follow);
        if (shouldChangeColor)
        {
            if (android.os.Build.VERSION.SDK_INT >= 16)
            {
                textview.setBackground(ctx.getResources().getDrawable(0x7f02011f));
            } else
            {
                textview.setBackgroundDrawable(ctx.getResources().getDrawable(0x7f02011f));
            }
            textview.setTextColor(ctx.getResources().getColor(0x7f06001d));
        }
        textview.setOnClickListener(new _cls1(jFollow, new JSONObject(), null, textview));
        textview1.setText(fans);
        textview1.setOnClickListener(new VectorOnClickListener(ctx, jFan, new JSONObject(), null));
        return view1;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.DJ_INFO_ITEM.ordinal();
    }

    private class _cls1 extends VectorOnClickListener
    {

        final DJInfoVectorItem this$0;
        final TextView val$tvFollow;

        public void onClick(View view)
        {
            if (!tvFollow.getText().toString().equals(ctx.getResources().getString(0x7f08014c))) goto _L2; else goto _L1
_L1:
            if (android.os.Build.VERSION.SDK_INT < 16) goto _L4; else goto _L3
_L3:
            tvFollow.setBackground(ctx.getResources().getDrawable(0x7f02011f));
_L5:
            tvFollow.setTextColor(ctx.getResources().getColor(0x7f06001d));
_L7:
            super.onClick(view);
            return;
_L4:
            tvFollow.setBackgroundDrawable(ctx.getResources().getDrawable(0x7f02011f));
              goto _L5
_L2:
            if (!tvFollow.getText().toString().equals(ctx.getResources().getString(0x7f08014d))) goto _L7; else goto _L6
_L6:
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                break MISSING_BLOCK_LABEL_179;
            }
            tvFollow.setBackground(ctx.getResources().getDrawable(0x7f020120));
_L8:
            tvFollow.setTextColor(ctx.getResources().getColor(0x7f060018));
              goto _L7
            tvFollow.setBackgroundDrawable(ctx.getResources().getDrawable(0x7f020120));
              goto _L8
            Exception exception;
            exception;
              goto _L7
        }

        _cls1(JSONObject jsonobject, JSONObject jsonobject1, JSONObject jsonobject2, TextView textview)
        {
            this$0 = DJInfoVectorItem.this;
            tvFollow = textview;
            super(final_context, jsonobject, jsonobject1, jsonobject2);
        }
    }

}
