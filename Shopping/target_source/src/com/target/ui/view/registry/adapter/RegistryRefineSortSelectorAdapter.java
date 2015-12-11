// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.registries.f;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.List;

public class RegistryRefineSortSelectorAdapter extends e
{
    static class ViewHolder extends com.target.ui.view.a
    {

        TextView count;
        int position;
        RadioButton radioButton;

        ViewHolder(View view)
        {
            super(view);
            position = -1;
        }
    }

    public static interface a
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final RegistryRefineSortSelectorAdapter this$0;

        public void onClick(View view)
        {
            com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel;
            view = (ViewHolder)u.a(view.getTag(), com/target/ui/view/registry/adapter/RegistryRefineSortSelectorAdapter$ViewHolder);
            if (view == null)
            {
                return;
            }
            RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this));
            RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this, ((ViewHolder) (view)).position);
            registrysortlabel = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this).get(RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this));
            if (RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this) != -1)
            {
                view = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this).get(RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this));
            } else
            {
                view = null;
            }
            if (RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this) == RegistryRefineSortSelectorAdapter.c(RegistryRefineSortSelectorAdapter.this)) goto _L2; else goto _L1
_L1:
            if (RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this) != null)
            {
                if (view != null)
                {
                    RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).b(view);
                }
                RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, registrysortlabel);
                RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).a(registrysortlabel);
            }
_L4:
            notifyDataSetInvalidated();
            return;
_L2:
            RegistryRefineSortSelectorAdapter.b(RegistryRefineSortSelectorAdapter.this, -1);
            if (RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this) != null)
            {
                RegistryRefineSortSelectorAdapter.a(RegistryRefineSortSelectorAdapter.this, null);
                RegistryRefineSortSelectorAdapter.d(RegistryRefineSortSelectorAdapter.this).b(registrysortlabel);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private b()
        {
            this$0 = RegistryRefineSortSelectorAdapter.this;
            super();
        }

    }


    private static final int NULL_INT = -1;
    public static final String TAG = com/target/ui/view/registry/adapter/RegistryRefineSortSelectorAdapter.getSimpleName();
    private int mCurrentlySelectedPosition;
    private a mListener;
    private int mPreviouslySelPosition;
    private com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel mSelectedSorting;
    private List mSortingOptionsList;

    public RegistryRefineSortSelectorAdapter(Context context, List list)
    {
        super(context, list);
        mSortingOptionsList = list;
        mCurrentlySelectedPosition = -1;
    }

    static int a(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter)
    {
        return registryrefinesortselectoradapter.mCurrentlySelectedPosition;
    }

    static int a(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter, int i)
    {
        registryrefinesortselectoradapter.mPreviouslySelPosition = i;
        return i;
    }

    static com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel a(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter, com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        registryrefinesortselectoradapter.mSelectedSorting = registrysortlabel;
        return registrysortlabel;
    }

    private void a(int i, ViewHolder viewholder, com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        if (mSelectedSorting != null && registrysortlabel.c().equals(mSelectedSorting.c()) && registrysortlabel.b().equals(mSelectedSorting.b()))
        {
            mCurrentlySelectedPosition = i;
        }
        viewholder = viewholder.radioButton;
        boolean flag;
        if (i == mCurrentlySelectedPosition)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewholder.setChecked(flag);
    }

    private void a(ViewHolder viewholder, com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        if (viewholder == null || registrysortlabel == null)
        {
            return;
        } else
        {
            viewholder.radioButton.setTag(viewholder);
            viewholder.radioButton.setEnabled(true);
            viewholder.radioButton.setText(registrysortlabel.a());
            viewholder.radioButton.setOnClickListener(new b());
            return;
        }
    }

    static int b(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter, int i)
    {
        registryrefinesortselectoradapter.mCurrentlySelectedPosition = i;
        return i;
    }

    static List b(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter)
    {
        return registryrefinesortselectoradapter.mSortingOptionsList;
    }

    static int c(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter)
    {
        return registryrefinesortselectoradapter.mPreviouslySelPosition;
    }

    static a d(RegistryRefineSortSelectorAdapter registryrefinesortselectoradapter)
    {
        return registryrefinesortselectoradapter.mListener;
    }

    public void a()
    {
        mCurrentlySelectedPosition = -1;
        mSelectedSorting = null;
        notifyDataSetChanged();
    }

    public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
    {
        mSelectedSorting = registrysortlabel;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel = (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)getItem(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f0301cf, viewgroup, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        al.c(((ViewHolder) (viewgroup)).count);
        a(viewgroup, registrysortlabel);
        a(i, viewgroup, registrysortlabel);
        return view;
    }

}
