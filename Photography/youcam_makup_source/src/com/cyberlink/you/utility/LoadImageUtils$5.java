// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.cyberlink.you.friends.s;
import com.cyberlink.you.sticker.EmojiHelper;
import com.rockerhieu.emojicon.emoji.Emojicon;

// Referenced classes of package com.cyberlink.you.utility:
//            LoadImageUtils

final class d extends AsyncTask
{

    final Context a;
    final Emojicon b;
    final ImageView c;
    final String d;

    protected transient Bitmap a(Void avoid[])
    {
        return EmojiHelper.a(a, b);
    }

    protected void a(Bitmap bitmap)
    {
        if (bitmap != null)
        {
            c.setImageBitmap(bitmap);
            LoadImageUtils.b().a(d, bitmap);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Bitmap)obj);
    }

    (Context context, Emojicon emojicon, ImageView imageview, String s1)
    {
        a = context;
        b = emojicon;
        c = imageview;
        d = s1;
        super();
    }
}
