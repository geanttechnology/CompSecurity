// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;

import android.content.Context;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view.registry:
//            BaseRegistryExpandView, RegistrySortListView

public class RegistrySortExpandView extends BaseRegistryExpandView
{
    public static interface a
    {

        public abstract void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);

        public abstract void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel);
    }

    private class b
        implements RegistrySortListView.b
    {

        final RegistrySortExpandView this$0;

        public void a(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            if (RegistrySortExpandView.a(RegistrySortExpandView.this) == null)
            {
                return;
            } else
            {
                RegistrySortExpandView.a(RegistrySortExpandView.this).a(registrysortlabel);
                return;
            }
        }

        public void b(com.target.ui.model.registry.RegistryRefineModel.RegistrySortLabel registrysortlabel)
        {
            if (RegistrySortExpandView.a(RegistrySortExpandView.this) == null)
            {
                return;
            } else
            {
                RegistrySortExpandView.a(RegistrySortExpandView.this).b(registrysortlabel);
                return;
            }
        }

        private b()
        {
            this$0 = RegistrySortExpandView.this;
            super();
        }

    }


    private a mListener;

    public RegistrySortExpandView(Context context)
    {
        super(context);
    }

    public RegistrySortExpandView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public RegistrySortExpandView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    static a a(RegistrySortExpandView registrysortexpandview)
    {
        return registrysortexpandview.mListener;
    }

    public void a(String s, RegistrySortListView registrysortlistview)
    {
        setTitle(s);
        setChildView(registrysortlistview);
        registrysortlistview.setClickListener(new b());
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
