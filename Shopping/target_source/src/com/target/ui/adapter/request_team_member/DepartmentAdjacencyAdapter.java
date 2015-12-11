// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.request_team_member;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.model.a.c.a;
import java.util.List;

public class DepartmentAdjacencyAdapter extends android.support.v7.widget.RecyclerView.a
{
    static class ViewHolder extends android.support.v7.widget.RecyclerView.t
    {

        TextView departmentText;
        private a mListener;
        RadioButton radioButton;

        public void onItemClicked()
        {
            if (mListener != null)
            {
                mListener.a(f());
            }
        }

        public void onRadioClicked()
        {
            onItemClicked();
        }

        public ViewHolder(View view, a a1)
        {
            super(view);
            ButterKnife.bind(this, view);
            mListener = a1;
        }
    }

    static interface ViewHolder.a
    {

        public abstract void a(int i);
    }

    public static interface a
    {

        public abstract void a(com.target.mothership.model.a.c.a a1);
    }


    private List mDepartmentAdjacencyList;
    private a mDepartmentSelectedListener;
    private ViewHolder.a mItemClickListener;
    private int mSelectedPosition;

    public DepartmentAdjacencyAdapter(a a1)
    {
        mSelectedPosition = 0;
        mItemClickListener = new ViewHolder.a() {

            final DepartmentAdjacencyAdapter this$0;

            public void a(int i)
            {
                com.target.ui.adapter.request_team_member.DepartmentAdjacencyAdapter.a(DepartmentAdjacencyAdapter.this, i);
                d();
                DepartmentAdjacencyAdapter.b(DepartmentAdjacencyAdapter.this).a((com.target.mothership.model.a.c.a)com.target.ui.adapter.request_team_member.DepartmentAdjacencyAdapter.a(DepartmentAdjacencyAdapter.this).get(i));
            }

            
            {
                this$0 = DepartmentAdjacencyAdapter.this;
                super();
            }
        };
        mDepartmentSelectedListener = a1;
    }

    static int a(DepartmentAdjacencyAdapter departmentadjacencyadapter, int i)
    {
        departmentadjacencyadapter.mSelectedPosition = i;
        return i;
    }

    static List a(DepartmentAdjacencyAdapter departmentadjacencyadapter)
    {
        return departmentadjacencyadapter.mDepartmentAdjacencyList;
    }

    static a b(DepartmentAdjacencyAdapter departmentadjacencyadapter)
    {
        return departmentadjacencyadapter.mDepartmentSelectedListener;
    }

    public int a()
    {
        if (mDepartmentAdjacencyList == null)
        {
            return 0;
        } else
        {
            return mDepartmentAdjacencyList.size();
        }
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i)
    {
        return c(viewgroup, i);
    }

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i)
    {
        a((ViewHolder)t, i);
    }

    public void a(ViewHolder viewholder, int i)
    {
        com.target.mothership.model.a.c.a a1 = (com.target.mothership.model.a.c.a)mDepartmentAdjacencyList.get(i);
        RadioButton radiobutton = viewholder.radioButton;
        boolean flag;
        if (mSelectedPosition == i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        radiobutton.setChecked(flag);
        viewholder.departmentText.setText(a1.b());
    }

    public void a(List list)
    {
        mDepartmentAdjacencyList = list;
        d();
    }

    public ViewHolder c(ViewGroup viewgroup, int i)
    {
        return new ViewHolder(LayoutInflater.from(viewgroup.getContext()).inflate(0x7f030156, viewgroup, false), mItemClickListener);
    }
}
