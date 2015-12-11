// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.inner_models.UserReference;
import com.poshmark.ui.customviews.PMAvataarImageView;
import com.poshmark.utils.FollowFollowingHelper;

public class FindPeopleAdapter extends CursorAdapter
{

    Context context;
    android.view.View.OnClickListener followFollowingButtonListener;
    private LayoutInflater inflater;
    android.view.View.OnClickListener itemClickListener;

    public FindPeopleAdapter(Context context1, Fragment fragment, Cursor cursor, int i)
    {
        super(context1, cursor, i);
        followFollowingButtonListener = new android.view.View.OnClickListener() {

            final FindPeopleAdapter this$0;

            public void onClick(View view)
            {
                Button button = (Button)view;
                view = (UserReference)view.getTag();
                if (view.isCallerFollowing())
                {
                    FollowFollowingHelper.setFollowButton(context, button);
                    view.setCallerFollowing(false);
                    FollowFollowingHelper.fireUnfollowCall(view.getUserId());
                    return;
                } else
                {
                    FollowFollowingHelper.setFollowingButton(context, button);
                    view.setCallerFollowing(true);
                    FollowFollowingHelper.fireFollowCall(view.getUserId());
                    return;
                }
            }

            
            {
                this$0 = FindPeopleAdapter.this;
                super();
            }
        };
        context = context1;
    }

    public void bindView(View view, Context context1, Cursor cursor)
    {
        cursor = (CustomMatrixCursor)cursor;
        cursor = (UserReference)cursor.get(cursor.getColumnIndex(PMData.DATA_COL));
        PMAvataarImageView pmavataarimageview = (PMAvataarImageView)view.findViewById(0x7f0c0057);
        TextView textview = (TextView)view.findViewById(0x7f0c02f8);
        TextView textview1 = (TextView)view.findViewById(0x7f0c0058);
        Button button = (Button)view.findViewById(0x7f0c0060);
        textview1.setText((new StringBuilder()).append("@").append(cursor.getUserName()).toString());
        pmavataarimageview.setImageBitmap(null);
        pmavataarimageview.setUser(cursor.getUserId());
        pmavataarimageview.loadImage(cursor.getAvataar());
        textview.setText(cursor.getFullName());
        if (cursor.getUserId().equals(PMApplicationSession.GetPMSession().getUserId()))
        {
            button.setVisibility(8);
        } else
        {
            button.setVisibility(0);
            button.setTag(cursor);
            button.setOnClickListener(followFollowingButtonListener);
            if (cursor.isCallerFollowing())
            {
                FollowFollowingHelper.setFollowingButton(context1, button);
            } else
            {
                FollowFollowingHelper.setFollowButton(context1, button);
            }
        }
        view.setOnClickListener(itemClickListener);
        view.setTag(cursor);
    }

    public View newView(Context context1, Cursor cursor, ViewGroup viewgroup)
    {
        inflater = LayoutInflater.from(context1);
        return inflater.inflate(0x7f0300cb, viewgroup, false);
    }

    public void setOnItemClickListener(android.view.View.OnClickListener onclicklistener)
    {
        itemClickListener = onclicklistener;
    }
}
