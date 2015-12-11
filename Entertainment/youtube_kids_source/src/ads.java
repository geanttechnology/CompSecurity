// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.libraries.youtube.common.ui.YouTubeTextView;
import java.util.List;

public final class ads extends BaseAdapter
{

    private final Context context;
    private int highlightedTile;
    private List recordings;
    private adu tileCallback;

    public ads(Context context1, adu adu)
    {
        context = context1;
        tileCallback = adu;
        highlightedTile = -1;
    }

    public final int getCount()
    {
        return recordings.size();
    }

    public final Object getItem(int i)
    {
        return recordings.get(i);
    }

    public final long getItemId(int i)
    {
        return (long)i;
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        aei aei1 = (aei)recordings.get(i);
        Object obj;
        android.graphics.Bitmap bitmap;
        int j;
        if (view != null && (view instanceof adv))
        {
            viewgroup = (adv)view;
            view = (FrameLayout)((adv)view).getChildAt(0);
        } else
        {
            viewgroup = new adv(this, context);
            view = (FrameLayout)View.inflate(context, 0x7f040041, null);
            viewgroup.addView(view);
        }
        obj = (ImageView)view.findViewById(0x7f10008a);
        bitmap = BitmapFactory.decodeFile(aei1.getThumbnailPath());
        if (bitmap != null)
        {
            ((ImageView) (obj)).setImageBitmap(bitmap);
        }
        obj = (YouTubeTextView)view.findViewById(0x7f10013b);
        j = recordings.size();
        ((YouTubeTextView) (obj)).setText((new StringBuilder(28)).append("Sing Along Title ").append(j - i).toString());
        if (i == 0 && highlightedTile == -1)
        {
            view.setBackgroundResource(0x7f020048);
            highlightedTile = 0;
        } else
        if (i == highlightedTile)
        {
            view.setBackgroundResource(0x7f020048);
        } else
        {
            view.setBackgroundResource(0);
        }
        view.setTag(0x7f100017, Integer.valueOf(i));
        view.setTag(0x7f100016, new adt(this, aei1));
        return viewgroup;
    }

    public final void updateRecordings(List list)
    {
        recordings = list;
        notifyDataSetChanged();
    }


/*
    static int access$002(ads ads1, int i)
    {
        ads1.highlightedTile = i;
        return i;
    }

*/

}
