// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view.registry:
//            BaseRegistryExpandView, RegistryEventTypeListView

public class RegistryEventTypeExpandView extends BaseRegistryExpandView
{
    public static interface a
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);
    }

    private class b
        implements RegistryEventTypeListView.a
    {

        final RegistryEventTypeExpandView this$0;

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            if (RegistryEventTypeExpandView.a(RegistryEventTypeExpandView.this) == null)
            {
                return;
            } else
            {
                RegistryEventTypeExpandView.a(RegistryEventTypeExpandView.this).a(registryeventlabel);
                return;
            }
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
        {
            if (RegistryEventTypeExpandView.a(RegistryEventTypeExpandView.this) == null)
            {
                return;
            } else
            {
                RegistryEventTypeExpandView.a(RegistryEventTypeExpandView.this).b(registryeventlabel);
                return;
            }
        }

        private b()
        {
            this$0 = RegistryEventTypeExpandView.this;
            super();
        }

    }


    private a mListener;

    public RegistryEventTypeExpandView(Context context)
    {
        super(context);
    }

    public RegistryEventTypeExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RegistryEventTypeExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(RegistryEventTypeExpandView registryeventtypeexpandview)
    {
        return registryeventtypeexpandview.mListener;
    }

    public void a(String s, RegistryEventTypeListView registryeventtypelistview)
    {
        setTitle(s);
        setChildView(registryeventtypelistview);
        registryeventtypelistview.setClickListener(new b());
    }

    public void b(boolean flag)
    {
        setExpanded(flag);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
