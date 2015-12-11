// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.smile.SmileHelper;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemBase, GNODrawerHelper, GNODrawer

public class GNODrawerItemCharity extends GNODrawerItemBase
    implements GNOItemAdapter.HideableItem, UserListener
{
    private class ViewHolder
    {

        public TextView text;
        final GNODrawerItemCharity this$0;

        private ViewHolder()
        {
            this$0 = GNODrawerItemCharity.this;
            super();
        }

    }


    private static final String TAG = com/amazon/mShop/gno/GNODrawerItemCharity.getSimpleName();
    private Context mContext;
    private String mId;
    private Callable mIsHiddenCallable;
    private GNODrawerItemSimple.GNOItemOnClickListener mListener;
    private ViewHolder mViewHolder;

    public GNODrawerItemCharity(Context context, String s, Callable callable)
    {
        mIsHiddenCallable = callable;
        mContext = context;
        mId = s;
        setRefMarker("smi_ac_menu_yc_cycsc");
        mListener = new GNODrawerItemSimple.GNOItemOnClickListener() {

            final GNODrawerItemCharity this$0;

            public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
            {
                AppNavigator.navigate(amazonactivity, com.amazon.mShop.navigation.AppNavigator.Target.charity, null);
            }

            
            {
                this$0 = GNODrawerItemCharity.this;
                super();
            }
        };
        User.addUserListener(this);
    }

    private void updateText()
    {
        if (SmileHelper.isSmile())
        {
            if (mViewHolder != null)
            {
                mViewHolder.text.setText(User.getUser().getCharity());
            }
        } else
        if (mViewHolder != null)
        {
            mViewHolder.text.setText("");
            return;
        }
    }

    public String getId()
    {
        return mId;
    }

    public Callable getIsHiddenCallable()
    {
        return mIsHiddenCallable;
    }

    public GNODrawerItem.Type getType()
    {
        return GNODrawerItem.Type.CHARITY;
    }

    public View getView(View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            viewgroup = LayoutInflater.from(mContext).inflate(com.amazon.mShop.android.lib.R.layout.gno_drawer_item_simple, viewgroup, false);
            mViewHolder = new ViewHolder();
            mViewHolder.text = (TextView)viewgroup.findViewById(com.amazon.mShop.android.lib.R.id.drawer_item_title);
            mViewHolder.text.setSingleLine(false);
            mViewHolder.text.setMaxLines(2);
            viewgroup.setTag(mViewHolder);
        } else
        {
            viewgroup = view;
            mViewHolder = (ViewHolder)view.getTag();
        }
        updateText();
        return viewgroup;
    }

    public boolean isHidden()
    {
        boolean flag;
        if (mIsHiddenCallable == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        flag = ((Boolean)mIsHiddenCallable.call()).booleanValue();
        return flag;
        Exception exception;
        exception;
        Log.e(TAG, "AmazonSmile the menu of charity hidden call error and catch exception");
        return false;
    }

    public void onClick(final AmazonActivity callingActivity, final GNODrawer drawer)
    {
        super.onClick(callingActivity, drawer);
        if (mListener != null)
        {
            GNODrawerHelper.closeDrawerAndExecute(callingActivity, true, new Runnable() {

                final GNODrawerItemCharity this$0;
                final AmazonActivity val$callingActivity;
                final GNODrawer val$drawer;

                public void run()
                {
                    mListener.onClick(callingActivity, drawer);
                }

            
            {
                this$0 = GNODrawerItemCharity.this;
                callingActivity = amazonactivity;
                drawer = gnodrawer;
                super();
            }
            });
        }
    }

    public void userSignedIn(User user)
    {
        updateText();
    }

    public void userSignedOut()
    {
        updateText();
    }

    public void userUpdated(User user)
    {
        updateText();
    }


}
