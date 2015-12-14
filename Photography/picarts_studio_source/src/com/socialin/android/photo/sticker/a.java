// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.sticker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.bumptech.glide.load.engine.l;
import com.bumptech.glide.request.e;
import com.picsart.studio.d;
import com.socialin.android.util.ak;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.photo.sticker:
//            b

public final class a extends BaseAdapter
{

    private ak a;
    private Context b;
    private d c;

    public a(Context context, String s)
    {
        b = context;
        a = ak.a(context, s);
        c = new d(context.getApplicationContext());
    }

    public final int getCount()
    {
        return a.b.length();
    }

    public final Object getItem(int i)
    {
        return null;
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(b).inflate(0x7f0301bc, viewgroup, false);
        }
        view = (ImageView)view;
        viewgroup = new StringBuilder("i_");
        ak ak1 = a;
        viewgroup = viewgroup.append((new StringBuilder()).append(ak1.b.optJSONObject(i).optString("name")).append(".jpg").toString()).toString();
        viewgroup = (new StringBuilder()).append(b.a).append(viewgroup).toString();
        c.a(viewgroup, view, (e)e.b(l.e).a(0x7f020567));
        return view;
    }
}
