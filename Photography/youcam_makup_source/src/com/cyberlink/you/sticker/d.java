// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.sticker;

import android.app.Activity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.cyberlink.you.p;
import com.rockerhieu.emojicon.emoji.Emojicon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.you.sticker:
//            StickerFragment, EmojiHelper, f

class d extends AsyncTask
{

    final StickerFragment a;
    private List b;

    public d(StickerFragment stickerfragment, List list)
    {
        a = stickerfragment;
        super();
        b = list;
    }

    private List a(Emojicon aemojicon[])
    {
        android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
        if (fragmentactivity == null)
        {
            return null;
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        View view = null;
        for (; i < aemojicon.length; i++)
        {
            if (i % 21 == 0)
            {
                if (view != null)
                {
                    view.setTag(StickerFragment.PageType.c);
                    arraylist.add(view);
                }
                view = fragmentactivity.getLayoutInflater().inflate(p.u_view_item_emojicon_preview, null);
            }
            if (a.isAdded())
            {
                ImageView imageview = (ImageView)view.findViewById(fragmentactivity.getResources().getIdentifier((new StringBuilder()).append("emojiconView").append(String.valueOf(i % 21)).toString(), "id", fragmentactivity.getPackageName()));
                imageview.setTag(aemojicon[i]);
                imageview.setOnClickListener(StickerFragment.u(a));
            }
        }

        if (view != null)
        {
            view.setTag(StickerFragment.PageType.c);
            arraylist.add(view);
        }
        return arraylist;
    }

    public transient List a(String as[])
    {
        Thread.currentThread().setName("LoadEmojiconTask AsyncTask");
        Log.d("StickerFragment", "LoadEmojiconTask in");
        as = new ArrayList();
        Iterator iterator = b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EmojiHelper.EmojiCategory emojicategory = (EmojiHelper.EmojiCategory)iterator.next();
            if (StickerFragment.i(a))
            {
                Log.d("StickerFragment", "LoadEmojiconTask cancelled !!!");
                return null;
            }
            List list = a(EmojiHelper.a(emojicategory));
            if (list != null)
            {
                as.add(Pair.create(emojicategory, list));
            }
        } while (true);
        Log.d("StickerFragment", "LoadEmojiconTask out");
        return as;
    }

    protected void a(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Pair pair = (Pair)list.next();
                f f1 = new f(a, (List)pair.second, true);
                if (StickerFragment.f(a) != null)
                {
                    StickerFragment.f(a).put(((EmojiHelper.EmojiCategory)pair.first).toString(), f1);
                }
                if (StickerFragment.s(a) != null)
                {
                    StickerFragment.s(a).put(((EmojiHelper.EmojiCategory)pair.first).toString(), f1);
                }
            } while (true);
        }
        StickerFragment.c(a, true);
        b = null;
        StickerFragment.t(a);
    }

    public Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((List)obj);
    }
}
