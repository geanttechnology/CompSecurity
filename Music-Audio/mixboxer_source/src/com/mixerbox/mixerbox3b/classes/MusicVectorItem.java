// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.classes;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;
import com.nostra13.universalimageloader.core.ImageLoader;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.mixerbox.mixerbox3b.classes:
//            MyItem

public class MusicVectorItem
    implements MyItem
{

    private String action;
    private Context ctx;
    private String f;
    private String id;
    private JSONObject jOb;
    private int k;
    private int position;
    private int source;
    private String thumb;
    private String tm;
    private String tt;

    public MusicVectorItem(Context context, JSONObject jsonobject, int i, int j)
    {
        tt = "";
        tm = "";
        f = "";
        action = "";
        id = "";
        thumb = "";
        jOb = jsonobject;
        ctx = context;
        if (jsonobject.isNull("source") || !jsonobject.getString("source").equals("soundcloud")) goto _L2; else goto _L1
_L1:
        tt = jsonobject.getString("title");
        tm = jsonobject.getString("duration");
        f = jsonobject.getString("trackId");
        action = jsonobject.getString("action");
        if (!jsonobject.isNull("_id"))
        {
            id = jsonobject.getString("_id");
        }
        if (!jsonobject.isNull("thumbnail"))
        {
            thumb = jsonobject.getString("thumbnail");
        }
        source = 3;
_L9:
        position = i;
        k = j;
        return;
_L2:
        tt = jsonobject.getString("tt");
_L3:
        tm = jsonobject.getString("tm");
_L4:
        f = jsonobject.getString("f");
_L5:
        action = jsonobject.getString("action");
_L6:
        id = jsonobject.getString("_id");
_L7:
        if (jsonobject.isNull("source"))
        {
            source = 1;
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_289;
        context;
        tt = "";
          goto _L3
        context;
        tm = "";
          goto _L4
        context;
        f = "";
          goto _L5
        context;
        action = "";
          goto _L6
        context;
        id = "";
          goto _L7
        if (jsonobject.getString("source").equals("youtube"))
        {
            source = 1;
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            if (jsonobject.getString("source").equals("soundcloud"))
            {
                source = 3;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public JSONObject getMyJSONObject()
    {
        return jOb;
    }

    public View getView(LayoutInflater layoutinflater, View view)
    {
        ViewHolder viewholder;
        if (view == null)
        {
            view = layoutinflater.inflate(0x7f03004f, null);
            viewholder = new ViewHolder(null);
            viewholder.tvName = (TextView)view.findViewById(0x7f070121);
            viewholder.tvTime = (TextView)view.findViewById(0x7f070120);
            viewholder.iv = (ImageView)view.findViewById(0x7f07011e);
            viewholder.btnEdit = (ImageButton)view.findViewById(0x7f070122);
            view.setTag(viewholder);
        } else
        {
            viewholder = (ViewHolder)view.getTag();
        }
        viewholder.tvName.setText(tt);
        viewholder.tvTime.setText(MixerBoxUtils.getSongTime(tm));
        if (source == 3)
        {
            String s = thumb;
            layoutinflater = s;
            if (android.os.Build.VERSION.SDK_INT >= 15)
            {
                layoutinflater = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
                int i = (int)(ctx.getResources().getDisplayMetrics().density * 10F);
                int l = (int)(ctx.getResources().getDisplayMetrics().density * 5F);
                layoutinflater.setMargins(i, l, 0, l);
                viewholder.iv.setLayoutParams(layoutinflater);
                layoutinflater = s;
            }
        } else
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            layoutinflater = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(f).append("/mqdefault.jpg").toString();
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(ctx.getResources().getDimensionPixelSize(0x7f0b0041), ctx.getResources().getDimensionPixelSize(0x7f0b0042));
            int j = (int)(ctx.getResources().getDisplayMetrics().density * 10F);
            int i1 = (int)(ctx.getResources().getDisplayMetrics().density * 5F);
            layoutparams.setMargins(j, i1, 0, i1);
            viewholder.iv.setLayoutParams(layoutparams);
        } else
        {
            layoutinflater = (new StringBuilder()).append("http://i.ytimg.com/vi/").append(f).append("/default.jpg").toString();
        }
        ImageLoader.getInstance().displayImage(layoutinflater, viewholder.iv);
        if (action.equals("addMusic"))
        {
            viewholder.btnEdit.setVisibility(0);
            viewholder.btnEdit.setImageResource(0x7f0200c7);
            viewholder.btnEdit.setOnClickListener(new _cls1());
            return view;
        }
        if (action.equals("editMusic"))
        {
            viewholder.btnEdit.setVisibility(0);
            viewholder.btnEdit.setOnClickListener(new _cls2());
            return view;
        } else
        {
            viewholder.btnEdit.setVisibility(8);
            return view;
        }
    }

    public int getViewType()
    {
        return com.mixerbox.mixerbox3b.adapters.VectorAdapter.RowType.MUSIC_ITEM.ordinal();
    }










    private class ViewHolder
    {

        public ImageButton btnEdit;
        public ImageView iv;
        public TextView tvName;
        public TextView tvTime;

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

        final MusicVectorItem this$0;

        public void onClick(View view)
        {
            view = new SongItem(id, tt, tm, f, position, source, thumb);
            MixerBoxUtils.performSongAction(ctx, 1, view, "", k);
        }

        _cls1()
        {
            this$0 = MusicVectorItem.this;
            super();
        }
    }


    private class _cls2
        implements android.view.View.OnClickListener
    {

        final MusicVectorItem this$0;

        public void onClick(View view)
        {
            SongItem songitem = new SongItem(id, tt, tm, f, position, source, thumb);
            MixerBoxUtils.createPopupMenu(ctx, view, songitem, "", k);
            view = new HashMap();
            view.put("id", id);
            view.put("playlist", "");
            FlurryAgent.logEvent("action:music_edit", view);
        }

        _cls2()
        {
            this$0 = MusicVectorItem.this;
            super();
        }
    }

}
