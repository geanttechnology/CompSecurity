// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.adapters;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkSessionFactory;
import com.facebook.AccessToken;
import com.facebook.login.widget.ProfilePictureView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class AkFacebookInviteAdapter extends BaseAdapter
{
    private class ViewHolder
    {

        final AkFacebookInviteAdapter this$0;
        ImageView uiCheckBoxSelected;
        ProfilePictureView uiImage;
        RelativeLayout uiLayoutFacebookItem;
        TextView uiName;
        TextView uiRang;
        TextView uiScore;

        private ViewHolder()
        {
            this$0 = AkFacebookInviteAdapter.this;
            super();
        }

    }


    private AkActivity mActivity;
    private List mIdsToInvite;
    private LayoutInflater mInflater;
    private List mList;
    private int mMyPosition;
    private Typeface tf;

    public AkFacebookInviteAdapter(AkActivity akactivity, List list)
    {
        tf = AkApplication.getTypeFace();
        mInflater = null;
        mIdsToInvite = new ArrayList();
        mMyPosition = -1;
        mActivity = akactivity;
        mInflater = LayoutInflater.from(akactivity);
        mList = list;
    }

    public void addId(String s)
    {
        mIdsToInvite.add(s);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        return mList.size();
    }

    public List getIdToInvite()
    {
        return mIdsToInvite;
    }

    public Object getItem(int i)
    {
        return mList.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        ViewHolder viewholder;
        JSONObject jsonobject = (JSONObject)mList.get(i);
        viewgroup = view;
        Object obj;
        try
        {
            obj = jsonobject.getJSONObject("user");
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return viewgroup;
        }
        if (view != null) goto _L2; else goto _L1
_L1:
        viewgroup = view;
        viewholder = new ViewHolder();
        viewgroup = view;
        view = mInflater.inflate(0x7f03005a, null);
        viewgroup = view;
        viewholder.uiLayoutFacebookItem = (RelativeLayout)view.findViewById(0x7f0d0263);
        viewgroup = view;
        viewholder.uiRang = (TextView)view.findViewById(0x7f0d0264);
        viewgroup = view;
        viewholder.uiCheckBoxSelected = (ImageView)view.findViewById(0x7f0d0266);
        viewgroup = view;
        viewholder.uiImage = (ProfilePictureView)view.findViewById(0x7f0d0265);
        viewgroup = view;
        viewholder.uiName = (TextView)view.findViewById(0x7f0d0267);
        viewgroup = view;
        viewholder.uiScore = (TextView)view.findViewById(0x7f0d0268);
        viewgroup = view;
        mActivity.addTextView(viewholder.uiRang);
        viewgroup = view;
        mActivity.addTextView(viewholder.uiName);
        viewgroup = view;
        mActivity.addTextView(viewholder.uiScore);
        viewgroup = view;
        viewholder.uiRang.setTypeface(tf);
        viewgroup = view;
        viewholder.uiName.setTypeface(tf);
        viewgroup = view;
        viewholder.uiScore.setTypeface(tf);
        viewgroup = view;
        viewholder.uiRang.setText((new StringBuilder()).append("").append(i + 1).toString());
        viewgroup = view;
        viewholder.uiImage.setProfileId(((JSONObject) (obj)).getString("id"));
        viewgroup = view;
        viewholder.uiName.setText(((JSONObject) (obj)).getString("name"));
        viewgroup = view;
        viewholder.uiScore.setText(jsonobject.getString("score"));
        viewgroup = view;
        view.setTag(viewholder);
        viewgroup = view;
        mActivity.updateTextViewsSize();
_L4:
        viewgroup = view;
        if (AccessToken.getCurrentAccessToken().getUserId().equals(((JSONObject) (obj)).getString("id")))
        {
            break MISSING_BLOCK_LABEL_493;
        }
        viewgroup = view;
        if (mMyPosition == -1)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        viewgroup = view;
        if (i <= mMyPosition)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        viewgroup = view;
        obj = ((JSONObject) (obj)).getString("id");
        viewgroup = view;
        if (!AkSessionFactory.sharedInstance().isFacebookRequestAlreadySend(((String) (obj))))
        {
            break; /* Loop/switch isn't completed */
        }
        viewgroup = view;
        viewholder.uiCheckBoxSelected.setImageResource(0x7f02023b);
        return view;
_L2:
        viewgroup = view;
        viewholder = (ViewHolder)view.getTag();
        if (true) goto _L4; else goto _L3
_L3:
        viewgroup = view;
        if (!mIdsToInvite.contains(obj))
        {
            break MISSING_BLOCK_LABEL_465;
        }
        viewgroup = view;
        viewholder.uiCheckBoxSelected.setImageResource(0x7f020237);
        return view;
        viewgroup = view;
        viewholder.uiCheckBoxSelected.setImageResource(0x7f02023f);
        return view;
        viewgroup = view;
        viewholder.uiCheckBoxSelected.setVisibility(8);
        return view;
        viewgroup = view;
        viewholder.uiLayoutFacebookItem.setBackgroundResource(0x7f02031b);
        viewgroup = view;
        viewholder.uiCheckBoxSelected.setVisibility(8);
        viewgroup = view;
        mMyPosition = i;
        return view;
    }

    public boolean isSelectabled(int i)
    {
        return i > mMyPosition;
    }

    public void removeId(String s)
    {
        mIdsToInvite.remove(s);
        notifyDataSetChanged();
    }
}
