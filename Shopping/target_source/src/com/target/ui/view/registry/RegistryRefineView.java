// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.google.a.a.e;
import com.target.ui.model.registry.RegistryRefineModel;

// Referenced classes of package com.target.ui.view.registry:
//            RegistrySortListView, RegistryEventTypeListView, BaseRegistryExpandView, RegistrySortExpandView, 
//            RegistryEventTypeExpandView

public class RegistryRefineView extends LinearLayout
{
    public static interface a
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);
    }


    private static final String TAG = com/target/ui/view/registry/RegistryRefineView.getSimpleName();
    private a mListener;

    public RegistryRefineView(Context context)
    {
        super(context);
        b();
    }

    public RegistryRefineView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public RegistryRefineView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    static a a(RegistryRefineView registryrefineview)
    {
        return registryrefineview.mListener;
    }

    private RegistrySortListView a(LayoutInflater layoutinflater, RegistryRefineModel registryrefinemodel)
    {
        layoutinflater = (RegistrySortListView)layoutinflater.inflate(0x7f0301da, this, false);
        layoutinflater.a(registryrefinemodel.a(), (com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel)registryrefinemodel.c().d());
        return layoutinflater;
    }

    private RegistryEventTypeListView b(LayoutInflater layoutinflater, RegistryRefineModel registryrefinemodel)
    {
        layoutinflater = (RegistryEventTypeListView)layoutinflater.inflate(0x7f0301d8, this, false);
        layoutinflater.a(registryrefinemodel.b(), (com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel)registryrefinemodel.d().d());
        return layoutinflater;
    }

    private void b()
    {
        setOrientation(1);
    }

    public void a()
    {
        for (int i = 0; i < getChildCount(); i++)
        {
            android.view.View view = getChildAt(i);
            if (view instanceof BaseRegistryExpandView)
            {
                ((BaseRegistryExpandView)view).b();
            }
        }

    }

    public void a(RegistryRefineModel registryrefinemodel)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        final RegistrySortExpandView sortExpandView = (RegistrySortExpandView)layoutinflater.inflate(0x7f0301d9, this, false);
        String s = getContext().getString(0x7f0904b8);
        RegistrySortListView registrysortlistview = a(layoutinflater, registryrefinemodel);
        sortExpandView.a(s, registrysortlistview);
        sortExpandView.a(registrysortlistview.b());
        sortExpandView.b(true);
        sortExpandView.setClickListener(new RegistrySortExpandView.a() {

            final RegistryRefineView this$0;
            final RegistrySortExpandView val$sortExpandView;

            public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
            {
                if (RegistryRefineView.a(RegistryRefineView.this) == null)
                {
                    return;
                } else
                {
                    sortExpandView.a(true);
                    RegistryRefineView.a(RegistryRefineView.this).a(registrysortlabel);
                    return;
                }
            }

            public void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
            {
                if (RegistryRefineView.a(RegistryRefineView.this) == null)
                {
                    return;
                } else
                {
                    sortExpandView.a(false);
                    RegistryRefineView.a(RegistryRefineView.this).b(registrysortlabel);
                    return;
                }
            }

            
            {
                this$0 = RegistryRefineView.this;
                sortExpandView = registrysortexpandview;
                super();
            }
        });
        addView(sortExpandView);
        final RegistryEventTypeExpandView eventTypeExpandView = (RegistryEventTypeExpandView)layoutinflater.inflate(0x7f0301d7, this, false);
        s = getContext().getString(0x7f0904b7);
        registryrefinemodel = b(layoutinflater, registryrefinemodel);
        eventTypeExpandView.a(s, registryrefinemodel);
        eventTypeExpandView.a(registryrefinemodel.b());
        eventTypeExpandView.b(true);
        eventTypeExpandView.setClickListener(new RegistryEventTypeExpandView.a() {

            final RegistryRefineView this$0;
            final RegistryEventTypeExpandView val$eventTypeExpandView;

            public void a(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
            {
                if (RegistryRefineView.a(RegistryRefineView.this) == null)
                {
                    return;
                } else
                {
                    eventTypeExpandView.a(true);
                    RegistryRefineView.a(RegistryRefineView.this).a(registryeventlabel);
                    return;
                }
            }

            public void b(com.target.ui.model.registry.RegistryRefineModel.RegistryEventLabel registryeventlabel)
            {
                if (RegistryRefineView.a(RegistryRefineView.this) == null)
                {
                    return;
                } else
                {
                    eventTypeExpandView.a(false);
                    RegistryRefineView.a(RegistryRefineView.this).b(registryeventlabel);
                    return;
                }
            }

            
            {
                this$0 = RegistryRefineView.this;
                eventTypeExpandView = registryeventtypeexpandview;
                super();
            }
        });
        addView(eventTypeExpandView);
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }

}
