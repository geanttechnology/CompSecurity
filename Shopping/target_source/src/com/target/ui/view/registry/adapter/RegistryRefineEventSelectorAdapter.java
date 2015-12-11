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
import com.target.mothership.common.registries.c;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.List;

// Referenced classes of package com.target.ui.view.registry.adapter:
//            RegistryRefineSortSelectorAdapter

public class RegistryRefineEventSelectorAdapter extends e
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

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);
    }

    private class b
        implements android.view.View.OnClickListener
    {

        final RegistryRefineEventSelectorAdapter this$0;

        public void onClick(View view)
        {
            com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel;
            view = (ViewHolder)u.a(view.getTag(), com/target/ui/view/registry/adapter/RegistryRefineEventSelectorAdapter$ViewHolder);
            if (view == null)
            {
                return;
            }
            RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this));
            RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this, ((ViewHolder) (view)).position);
            registryeventlabel = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this).get(RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this));
            if (com.target.ui.view.registry.adapter.RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this) != -1)
            {
                view = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this).get(com.target.ui.view.registry.adapter.RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this));
            } else
            {
                view = null;
            }
            if (RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this) == com.target.ui.view.registry.adapter.RegistryRefineEventSelectorAdapter.c(RegistryRefineEventSelectorAdapter.this)) goto _L2; else goto _L1
_L1:
            if (RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this) != null)
            {
                if (view != null)
                {
                    RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).b(view);
                }
                RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, registryeventlabel);
                RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).a(registryeventlabel);
            }
_L4:
            notifyDataSetInvalidated();
            return;
_L2:
            RegistryRefineEventSelectorAdapter.b(RegistryRefineEventSelectorAdapter.this, -1);
            if (RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this) != null)
            {
                RegistryRefineEventSelectorAdapter.a(RegistryRefineEventSelectorAdapter.this, null);
                RegistryRefineEventSelectorAdapter.d(RegistryRefineEventSelectorAdapter.this).b(registryeventlabel);
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private b()
        {
            this$0 = RegistryRefineEventSelectorAdapter.this;
            super();
        }

    }


    private static final int NULL_INT = -1;
    public static final String TAG = com/target/ui/view/registry/adapter/RegistryRefineSortSelectorAdapter.getSimpleName();
    private int mCurrentlySelectedPosition;
    private List mEventTypeOptionsList;
    private a mListener;
    private int mPreviouslySelPosition;
    private com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel mSelectedEvenType;

    public RegistryRefineEventSelectorAdapter(Context context, List list)
    {
        super(context, list);
        mEventTypeOptionsList = list;
        mCurrentlySelectedPosition = -1;
    }

    static int a(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter)
    {
        return registryrefineeventselectoradapter.mCurrentlySelectedPosition;
    }

    static int a(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter, int i)
    {
        registryrefineeventselectoradapter.mPreviouslySelPosition = i;
        return i;
    }

    static com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel a(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter, com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        registryrefineeventselectoradapter.mSelectedEvenType = registryeventlabel;
        return registryeventlabel;
    }

    private void a(int i, ViewHolder viewholder, com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        if (mSelectedEvenType != null && registryeventlabel.b().equals(mSelectedEvenType.b()))
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

    private void a(ViewHolder viewholder, com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        if (viewholder == null || registryeventlabel == null)
        {
            return;
        } else
        {
            viewholder.radioButton.setTag(viewholder);
            viewholder.radioButton.setEnabled(true);
            viewholder.radioButton.setText(registryeventlabel.a());
            viewholder.radioButton.setOnClickListener(new b());
            return;
        }
    }

    static int b(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter, int i)
    {
        registryrefineeventselectoradapter.mCurrentlySelectedPosition = i;
        return i;
    }

    static List b(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter)
    {
        return registryrefineeventselectoradapter.mEventTypeOptionsList;
    }

    static int c(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter)
    {
        return registryrefineeventselectoradapter.mPreviouslySelPosition;
    }

    static a d(RegistryRefineEventSelectorAdapter registryrefineeventselectoradapter)
    {
        return registryrefineeventselectoradapter.mListener;
    }

    public void a()
    {
        mCurrentlySelectedPosition = -1;
        mSelectedEvenType = null;
        notifyDataSetChanged();
    }

    public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
    {
        mSelectedEvenType = registryeventlabel;
    }

    public void a(a a1)
    {
        mListener = a1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel = (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)getItem(i);
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
        a(viewgroup, registryeventlabel);
        a(i, viewgroup, registryeventlabel);
        return view;
    }

}
