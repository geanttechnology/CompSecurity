// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineUser;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import co.vine.android.widget.UserViewHolder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FriendSearchAdapter extends ArrayAdapter
{

    private final AppController mAppController;
    private final int mProfileImageSize;
    protected final ArrayList mViewHolders = new ArrayList();
    private final int mVineGreen;

    public FriendSearchAdapter(Context context, AppController appcontroller, List list)
    {
        super(context, 0, list);
        mAppController = appcontroller;
        mProfileImageSize = context.getResources().getDimensionPixelOffset(0x7f0b0087);
        mVineGreen = context.getResources().getColor(0x7f090096);
    }

    private void setUserImage(UserViewHolder userviewholder, Bitmap bitmap)
    {
        userviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            userviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(getContext().getResources(), bitmap));
            return;
        } else
        {
            userviewholder.image.setImageResource(0x7f0200f7);
            return;
        }
    }

    public long getItemId(int i)
    {
        return ((VineUser)getItem(i)).userId;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Object obj;
        if (view != null)
        {
            UserViewHolder userviewholder = (UserViewHolder)view.getTag();
            mViewHolders.add(new WeakReference(userviewholder));
            viewgroup = view;
            view = userviewholder;
        } else
        {
            viewgroup = LayoutInflater.from(getContext()).inflate(0x7f0300a3, viewgroup, false);
            view = new UserViewHolder(viewgroup);
        }
        obj = (VineUser)getItem(i);
        ((UserViewHolder) (view)).username.setText(((VineUser) (obj)).username);
        obj = ((VineUser) (obj)).avatarUrl;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ImageKey imagekey = new ImageKey(((String) (obj)), mProfileImageSize, mProfileImageSize, true);
            if (Util.isDefaultAvatarUrl(((String) (obj))))
            {
                Util.safeSetDefaultAvatar(((UserViewHolder) (view)).image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | mVineGreen);
            } else
            {
                view.avatarUrl = imagekey;
                setUserImage(view, mAppController.getPhotoBitmap(imagekey));
            }
        } else
        {
            setUserImage(view, null);
        }
        viewgroup.setTag(view);
        return viewgroup;
    }

    public void setData(List list)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            addAll(list);
        } else
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                add((VineUser)list.next());
            }
        }
    }

    public void setUserImages(HashMap hashmap)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        Iterator iterator;
        obj = new ArrayList();
        iterator = mViewHolders.iterator();
_L1:
        UserViewHolder userviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = (WeakReference)iterator.next();
        userviewholder = (UserViewHolder)((WeakReference) (obj1)).get();
        if (userviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(userviewholder.avatarUrl);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        setUserImage(userviewholder, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
