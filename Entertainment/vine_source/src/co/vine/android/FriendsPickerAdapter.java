// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v4.widget.CursorAdapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.client.AppController;
import co.vine.android.drawable.RecyclableBitmapDrawable;
import co.vine.android.provider.FriendsPickerExclusiveCursor;
import co.vine.android.util.SparseArray;
import co.vine.android.util.Util;
import co.vine.android.util.image.ImageKey;
import co.vine.android.util.image.UrlImage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

// Referenced classes of package co.vine.android:
//            FriendsPickerViewHolder, Settings, FriendsRecipientPickerFragment

public class FriendsPickerAdapter extends CursorAdapter
{

    private AppController mAppController;
    private final FriendsRecipientPickerFragment mFragment;
    private long mLatestRefreshTime;
    private final SparseArray mSelectedBackgroundMap = new SparseArray();
    private ArrayList mViewHolders;

    public FriendsPickerAdapter(Context context, AppController appcontroller, int i, FriendsRecipientPickerFragment friendsrecipientpickerfragment)
    {
        super(context, null, i);
        mAppController = appcontroller;
        mFragment = friendsrecipientpickerfragment;
        mViewHolders = new ArrayList();
    }

    private void setUserImage(FriendsPickerViewHolder friendspickerviewholder, Bitmap bitmap)
    {
        friendspickerviewholder.image.setColorFilter(null);
        if (bitmap != null)
        {
            friendspickerviewholder.image.setImageDrawable(new RecyclableBitmapDrawable(mContext.getResources(), bitmap));
            return;
        } else
        {
            friendspickerviewholder.image.setImageBitmap(null);
            return;
        }
    }

    public void bindView(int i, View view, Context context, Cursor cursor)
    {
label0:
        {
            view = (FriendsPickerViewHolder)view.getTag();
            cursor = (FriendsPickerExclusiveCursor)cursor;
            view.recipient = (VineRecipient)cursor.getItem(i);
            if (i == 0)
            {
                mLatestRefreshTime = ((FriendsPickerViewHolder) (view)).recipient.lastFriendRefresh;
                ((FriendsPickerViewHolder) (view)).sectionIndicator.setVisibility(0);
                ((FriendsPickerViewHolder) (view)).sectionTitle.setVisibility(0);
                ((FriendsPickerViewHolder) (view)).sectionTitle.setText(((FriendsPickerViewHolder) (view)).recipient.sectionTitle);
                int j;
                if (((FriendsPickerViewHolder) (view)).recipient.sectionIndex != 0)
                {
                    ((FriendsPickerViewHolder) (view)).sectionSort.setVisibility(0);
                    ((FriendsPickerViewHolder) (view)).sectionSort.setText(((FriendsPickerViewHolder) (view)).recipient.getTextSortKey());
                } else
                {
                    ((FriendsPickerViewHolder) (view)).sectionSort.setVisibility(8);
                }
            } else
            {
                VineRecipient vinerecipient = (VineRecipient)cursor.getItem(i - 1);
                boolean flag = haveSectionIndicator(vinerecipient, ((FriendsPickerViewHolder) (view)).recipient);
                View view1 = ((FriendsPickerViewHolder) (view)).sectionIndicator;
                int k;
                if (flag)
                {
                    k = 0;
                } else
                {
                    k = 8;
                }
                view1.setVisibility(k);
                if (flag)
                {
                    k = vinerecipient.sectionIndex;
                    if (((FriendsPickerViewHolder) (view)).recipient.sectionIndex != k)
                    {
                        ((FriendsPickerViewHolder) (view)).sectionTitle.setText(((FriendsPickerViewHolder) (view)).recipient.sectionTitle);
                        ((FriendsPickerViewHolder) (view)).sectionTitle.setVisibility(0);
                    } else
                    {
                        ((FriendsPickerViewHolder) (view)).sectionTitle.setVisibility(8);
                    }
                    if (((FriendsPickerViewHolder) (view)).recipient.sectionIndex != 0 && !((FriendsPickerViewHolder) (view)).recipient.getTextSortKey().equals(vinerecipient.getTextSortKey()))
                    {
                        ((FriendsPickerViewHolder) (view)).sectionSort.setVisibility(0);
                        ((FriendsPickerViewHolder) (view)).sectionSort.setText(((FriendsPickerViewHolder) (view)).recipient.getTextSortKey());
                    }
                }
            }
            if (i + 1 < cursor.getCount())
            {
                if (haveSectionIndicator(((FriendsPickerViewHolder) (view)).recipient, (VineRecipient)cursor.getItem(i + 1)))
                {
                    ((FriendsPickerViewHolder) (view)).divider.setVisibility(8);
                } else
                {
                    ((FriendsPickerViewHolder) (view)).divider.setVisibility(0);
                }
            }
            j = ((FriendsPickerViewHolder) (view)).recipient.color;
            if (j != Settings.DEFAULT_PROFILE_COLOR)
            {
                i = j;
                if (j > 0)
                {
                    break label0;
                }
            }
            i = 0xffffff & mContext.getResources().getColor(0x7f090096);
        }
        ((FriendsPickerViewHolder) (view)).username.setText(((FriendsPickerViewHolder) (view)).recipient.display);
        ((FriendsPickerViewHolder) (view)).username.setTextColor(0xff000000 | i);
        view.setSelected(context.getResources(), mFragment.isRecipientSelected(((FriendsPickerViewHolder) (view)).recipient));
        context = ((FriendsPickerViewHolder) (view)).recipient.avatarUrl;
        if (!TextUtils.isEmpty(context))
        {
            cursor = new ImageKey(context, true);
            if (Util.isDefaultAvatarUrl(context))
            {
                Util.safeSetDefaultAvatar(((FriendsPickerViewHolder) (view)).image, co.vine.android.util.Util.ProfileImageSize.MEDIUM, 0xff000000 | i);
                return;
            } else
            {
                view.avatarUrl = cursor;
                setUserImage(view, mAppController.getPhotoBitmap(cursor));
                return;
            }
        } else
        {
            setUserImage(view, null);
            return;
        }
    }

    public void bindView(View view, Context context, Cursor cursor)
    {
        bindView(cursor.getPosition(), view, context, cursor);
    }

    public long getItemId(int i)
    {
        if (i < getCount())
        {
            Cursor cursor = (Cursor)super.getItem(i);
            if (cursor != null)
            {
                return ((VineRecipient)((FriendsPickerExclusiveCursor)cursor).getItem(i)).userId;
            }
        }
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        FriendsPickerExclusiveCursor friendspickerexclusivecursor = (FriendsPickerExclusiveCursor)mCursor;
        static class _cls1
        {

            static final int $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[];

            static 
            {
                $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode = new int[co.vine.android.provider.ExclusiveHybridCursor.Mode.values().length];
                try
                {
                    $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[co.vine.android.provider.ExclusiveHybridCursor.Mode.LIST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$co$vine$android$provider$ExclusiveHybridCursor$Mode[co.vine.android.provider.ExclusiveHybridCursor.Mode.CURSOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        View view1;
        switch (_cls1..SwitchMap.co.vine.android.provider.ExclusiveHybridCursor.Mode[friendspickerexclusivecursor.getMode().ordinal()])
        {
        default:
            return super.getView(i, view, viewgroup);

        case 1: // '\001'
            view1 = view;
            break;
        }
        if (view == null)
        {
            view1 = newView(mContext, friendspickerexclusivecursor, viewgroup);
        }
        bindView(i, view1, mContext, friendspickerexclusivecursor);
        return view1;
    }

    public boolean haveSectionIndicator(VineRecipient vinerecipient, VineRecipient vinerecipient1)
    {
        return vinerecipient1.sectionIndex != vinerecipient.sectionIndex || vinerecipient1.sectionIndex != 0 && !vinerecipient1.getTextSortKey().equals(vinerecipient.getTextSortKey());
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
        cursor = LayoutInflater.from(context).inflate(0x7f030080, viewgroup, false);
        context = new FriendsPickerViewHolder(context, mSelectedBackgroundMap, cursor);
        mViewHolders.add(new WeakReference(context));
        cursor.setTag(context);
        return cursor;
    }

    public void onRecipientItemRemoved(VineRecipient vinerecipient)
    {
        Iterator iterator = mViewHolders.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FriendsPickerViewHolder friendspickerviewholder = (FriendsPickerViewHolder)((WeakReference)iterator.next()).get();
            if (friendspickerviewholder != null && vinerecipient.equals(friendspickerviewholder.recipient))
            {
                friendspickerviewholder.setSelected(mContext.getResources(), false);
            }
        } while (true);
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
        FriendsPickerViewHolder friendspickerviewholder;
        Object obj1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_109;
        }
        obj1 = (WeakReference)iterator.next();
        friendspickerviewholder = (FriendsPickerViewHolder)((WeakReference) (obj1)).get();
        if (friendspickerviewholder != null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        ((ArrayList) (obj)).add(obj1);
          goto _L1
        hashmap;
        throw hashmap;
        obj1 = (UrlImage)hashmap.get(friendspickerviewholder.avatarUrl);
        if (obj1 == null) goto _L1; else goto _L2
_L2:
        if (!((UrlImage) (obj1)).isValid()) goto _L1; else goto _L3
_L3:
        setUserImage(friendspickerviewholder, ((UrlImage) (obj1)).bitmap);
          goto _L1
        for (hashmap = ((ArrayList) (obj)).iterator(); hashmap.hasNext(); mViewHolders.remove(obj))
        {
            obj = (WeakReference)hashmap.next();
        }

        this;
        JVM INSTR monitorexit ;
    }
}
