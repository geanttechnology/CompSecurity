// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import co.vine.android.api.VineRecipient;
import co.vine.android.util.SparseArray;
import co.vine.android.util.Util;
import co.vine.android.util.ViewUtil;
import co.vine.android.widget.UserViewHolder;

// Referenced classes of package co.vine.android:
//            Settings

public class FriendsPickerViewHolder extends UserViewHolder
{

    public View divider;
    private final SparseArray mColoredIndicatorMap;
    public VineRecipient recipient;
    public View sectionIndicator;
    public TextView sectionSort;
    public TextView sectionTitle;
    public View selectionIndicator;

    public FriendsPickerViewHolder(Context context, SparseArray sparsearray, View view)
    {
        super(view);
        mColoredIndicatorMap = sparsearray;
        selectionIndicator = view.findViewById(0x7f0a0148);
        sectionIndicator = view.findViewById(0x7f0a0120);
        sectionTitle = (TextView)view.findViewById(0x7f0a01ab);
        sectionSort = (TextView)view.findViewById(0x7f0a01aa);
        divider = view.findViewById(0x7f0a0060);
        Util.styleSectionHeader(context, sectionTitle, sectionSort);
    }

    public void setSelected(Resources resources, boolean flag)
    {
        if (flag)
        {
            Drawable drawable = null;
            Drawable drawable2;
            if (recipient.color <= 0 || recipient.color == Settings.DEFAULT_PROFILE_COLOR)
            {
                recipient.color = resources.getColor(0x7f090096);
            } else
            {
                drawable = (Drawable)mColoredIndicatorMap.get(recipient.color);
            }
            drawable2 = drawable;
            if (drawable == null)
            {
                drawable2 = resources.getDrawable(0x7f02015a).mutate();
                drawable2.setColorFilter(new PorterDuffColorFilter(0xff000000 | recipient.color, android.graphics.PorterDuff.Mode.SRC_IN));
                mColoredIndicatorMap.put(recipient.color, drawable2);
            }
            ViewUtil.setBackground(selectionIndicator, drawable2);
            return;
        } else
        {
            Drawable drawable1 = resources.getDrawable(0x7f020159);
            drawable1.setColorFilter(new PorterDuffColorFilter(resources.getColor(0x7f09001a), android.graphics.PorterDuff.Mode.SRC_IN));
            ViewUtil.setBackground(selectionIndicator, drawable1);
            return;
        }
    }
}
