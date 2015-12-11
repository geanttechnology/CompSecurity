// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemBase, GNODrawer, GNODrawerHelper

public class GNODrawerItemAuthentication extends GNODrawerItemBase
    implements UserListener
{
    private class ViewHolder
    {

        TextView text;
        final GNODrawerItemAuthentication this$0;

        private ViewHolder()
        {
            this$0 = GNODrawerItemAuthentication.this;
            super();
        }

    }


    private static final SparseArray REF_MARKERS;
    private static final String TAG = com/amazon/mShop/gno/GNODrawerItemAuthentication.getSimpleName();
    private Context mContext;
    private int mId;
    private ViewHolder mViewHolder;

    public GNODrawerItemAuthentication(Context context)
    {
        mContext = context;
        User.addUserListener(this);
    }

    private int calcTextViewWidth()
    {
        return mContext.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.gno_menu_width) - mContext.getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.gno_menu_item_padding_left_right) * 2;
    }

    private String chopText()
    {
        String s = null;
        if (mViewHolder == null) goto _L2; else goto _L1
_L1:
        String s1;
        String s3;
        String s4;
        TextPaint textpaint;
        int i;
        s = mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.gno_sign_out);
        s3 = mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.gno_sign_out_new_line);
        s4 = User.getUser().getFullName();
        int j = mViewHolder.text.getWidth();
        i = j;
        if (j == 0)
        {
            i = calcTextViewWidth();
        }
        textpaint = mViewHolder.text.getPaint();
        s1 = String.format(s, new Object[] {
            s4
        });
        s = s1;
        if (textpaint.measureText(s1) <= (float)i) goto _L2; else goto _L3
_L3:
        int k;
        k = s4.length();
        s = s1;
_L7:
        if (k <= 0) goto _L2; else goto _L4
_L4:
        String s2 = String.format(s3, new Object[] {
            s4.substring(0, k)
        });
        s = s2;
        if (k == s4.length())
        {
            StringBuilder stringbuilder = new StringBuilder(s2);
            int l = stringbuilder.lastIndexOf("\u2026");
            s = s2;
            if (l != -1)
            {
                s = stringbuilder.deleteCharAt(l).toString();
            }
        }
        if (textpaint.measureText(s.substring(0, s.indexOf("\n"))) >= (float)i) goto _L5; else goto _L2
_L2:
        return s;
_L5:
        k--;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String getText()
    {
        String s = null;
        if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_signin || mId == com.amazon.mShop.android.lib.R.id.feature_menu_sso_signin)
        {
            s = mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.gno_sign_in);
        } else
        if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_signout || mId == com.amazon.mShop.android.lib.R.id.feature_menu_sso_signout)
        {
            if (User.getUser() != null)
            {
                return chopText();
            } else
            {
                return mContext.getResources().getString(com.amazon.mShop.android.lib.R.string.home_sign_out);
            }
        }
        return s;
    }

    private boolean refreshGNODrawer()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (mContext != null)
        {
            flag = flag1;
            if (mContext instanceof AmazonActivity)
            {
                GNODrawer gnodrawer = ((AmazonActivity)mContext).getGNODrawer();
                flag = flag1;
                if (gnodrawer != null)
                {
                    gnodrawer.refresh();
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void setItemId()
    {
        if (!SSOUtil.isSSOSupported(mContext))
        {
            if (User.isLoggedIn())
            {
                mId = com.amazon.mShop.android.lib.R.id.feature_menu_signout;
            } else
            {
                mId = com.amazon.mShop.android.lib.R.id.feature_menu_signin;
            }
        } else
        if (User.isLoggedIn() || SSOUtil.hasAmazonAccount())
        {
            mId = com.amazon.mShop.android.lib.R.id.feature_menu_sso_signout;
        } else
        {
            mId = com.amazon.mShop.android.lib.R.id.feature_menu_sso_signin;
        }
        setRefMarker((String)REF_MARKERS.get(mId));
    }

    private void updateText()
    {
        if (mViewHolder != null)
        {
            setItemId();
            CharSequence charsequence = mViewHolder.text.getText();
            String s = getText();
            if (!s.equals(charsequence))
            {
                mViewHolder.text.setText(s);
            }
        }
    }

    public String getId()
    {
        return "/authentication";
    }

    public GNODrawerItem.Type getType()
    {
        return GNODrawerItem.Type.AUTHENTICATION;
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

    public void onClick(final AmazonActivity callingActivity, GNODrawer gnodrawer)
    {
        super.onClick(callingActivity, gnodrawer);
        boolean flag;
        if (IdentityType.NON_SSO_TYPE == SSOUtil.getCurrentIdentityType())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        GNODrawerHelper.closeDrawerAndExecute(callingActivity, flag, new Runnable() {

            final GNODrawerItemAuthentication this$0;
            final AmazonActivity val$callingActivity;

            public void run()
            {
                if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_signin)
                {
                    ActivityUtils.startLoginActivity(callingActivity, "gno", true, null, new int[0]);
                } else
                {
                    if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_signout)
                    {
                        ActivityUtils.startLogoutActivity(callingActivity);
                        return;
                    }
                    if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_sso_signin)
                    {
                        SSOUtil.getCurrentIdentityType().handleSSOLogin(callingActivity, true, false, false, "gno");
                        return;
                    }
                    if (mId == com.amazon.mShop.android.lib.R.id.feature_menu_sso_signout)
                    {
                        SSOUtil.getCurrentIdentityType().handleSSOLogout(callingActivity);
                        return;
                    }
                }
            }

            
            {
                this$0 = GNODrawerItemAuthentication.this;
                callingActivity = amazonactivity;
                super();
            }
        });
    }

    public void userSignedIn(User user)
    {
        updateText();
        refreshGNODrawer();
    }

    public void userSignedOut()
    {
        updateText();
        refreshGNODrawer();
    }

    public void userUpdated(User user)
    {
        updateText();
        refreshGNODrawer();
    }

    static 
    {
        REF_MARKERS = new SparseArray(2);
        REF_MARKERS.append(com.amazon.mShop.android.lib.R.id.feature_menu_signin, "gno_si");
        REF_MARKERS.append(com.amazon.mShop.android.lib.R.id.feature_menu_signout, "gno_so");
    }

}
