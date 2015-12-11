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
//            MyItem

public class PlaylistVectorItem
    implements MyItem
{

    private Context ctx;
    private JSONObject item;
    private JSONObject jOb;
    private String owner;
    private String size;
    private String title;
    private String u;

    public PlaylistVectorItem(Context context, JSONObject jsonobject)
    {
        if (jsonobject.isNull("thumbnail") && jsonobject.isNull("title"))
        {
            break MISSING_BLOCK_LABEL_135;
        }
        jOb = jsonobject;
        ctx = context;
        item = jsonobject;
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
            owner = jsonobject.getString("owner");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            owner = "";
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
        jOb = jsonobject;
        ctx = context;
        item = jsonobject;
        try
        {
            title = jsonobject.getString("name");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            title = "";
        }
        try
        {
            owner = jsonobject.getString("ownerName");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            owner = "";
        }
        try
        {
            size = jsonobject.getString("itemCount");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            size = "";
        }
        try
        {
            if (!jsonobject.isNull("_id"))
            {
                jsonobject.put("ref", jsonobject.getString("_id"));
            }
            if (!jsonobject.isNull("name"))
            {
                jsonobject.put("title", jsonobject.getString("name"));
            }
            if (!jsonobject.isNull("coverhq"))
            {
                jsonobject.put("thumbnailHQ", jsonobject.getString("coverhq"));
            }
            if (!jsonobject.isNull("cover"))
            {
                jsonobject.put("thumbnail", jsonobject.getString("cover"));
            }
            if (!jsonobject.isNull("owner"))
            {
                jsonobject.put("ownerId", jsonobject.getString("owner"));
            }
            if (!jsonobject.isNull("ownerName"))
            {
                jsonobject.put("owner", jsonobject.getString("ownerNqme"));
            }
            if (!jsonobject.isNull("itemCount"))
            {
                jsonobject.put("size", jsonobject.get("itemCount"));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        try
        {
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                u = jsonobject.getString("coverhq");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            u = "";
            return;
        }
        u = jsonobject.getString("cover");
        return;
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        if (view == null)
        {
            view = layoutinflater.inflate(0x7f03004c, null);
            layoutinflater = new ViewHolder(null);
            layoutinflater.tvName = (TextView)view.findViewById(0x7f07011c);
            layoutinflater.tvOwner = (TextView)view.findViewById(0x7f07011d);
            layoutinflater.tvItemCount = (TextView)view.findViewById(0x7f07011b);
            layoutinflater.iv = (ImageView)view.findViewById(0x7f070119);
            layoutinflater.ivQuickPlay = (ImageView)view.findViewById(0x7f07011a);
            view.setTag(layoutinflater);
        } else
        {
            layoutinflater = (ViewHolder)view.getTag();
        }
        ((ViewHolder) (layoutinflater)).tvName.setText(title);
        if (owner.length() != 0)
        {
            ((ViewHolder) (layoutinflater)).tvOwner.setText((new StringBuilder()).append(ctx.getResources().getString(0x7f0800d1)).append(" ").append(owner).toString());
        } else
        {
            ((ViewHolder) (layoutinflater)).tvOwner.setVisibility(8);
        }
        ((ViewHolder) (layoutinflater)).tvItemCount.setText(size);
        ImageLoader.getInstance().displayImage(u, ((ViewHolder) (layoutinflater)).iv);
        ((ViewHolder) (layoutinflater)).ivQuickPlay.setOnClickListener(new _cls1());
        return view;
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.PLAYLIST_ITEM.ordinal();
    }







    private class ViewHolder
    {

        public ImageView iv;
        public ImageView ivQuickPlay;
        public TextView tvItemCount;
        public TextView tvName;
        public TextView tvOwner;

        private ViewHolder()
        {
        }

        ViewHolder(_cls1 _pcls1)
        {
            this();
        }
    }


    private class _cls1
        implements android.view.View.OnClickListener
    {

        final PlaylistVectorItem this$0;

        public void onClick(View view)
        {
            if (item.isNull("isAlbum"))
            {
                break MISSING_BLOCK_LABEL_209;
            }
            view = Boolean.valueOf(item.getBoolean("isAlbum"));
_L1:
            view = new PlaylistItem(item.getString("ref"), title, "", owner, size, "0", u, 3, view.booleanValue());
            if (!MixerBoxClient.isConnectingToInternet(ctx))
            {
                AlertDialogFactory.NoNetworkAlertDialog((Activity)ctx).show();
                return;
            }
            try
            {
                ((MainPage)ctx).arraySong.clear();
                Object obj = ((MainPage)ctx).setSong(view.getPlaylistId());
                obj.currentPlaylist = view;
                MixerBoxUtils.loadSong(ctx, view.getPlaylistId(), false, 1, 0, ((SongFragment) (obj)));
                obj = new HashMap();
                ((Map) (obj)).put("id", view.getPlaylistId());
                FlurryAgent.logEvent("action:playlist_play", ((Map) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            return;
            view = Boolean.valueOf(false);
              goto _L1
        }

        _cls1()
        {
            this$0 = PlaylistVectorItem.this;
            super();
        }
    }

}
