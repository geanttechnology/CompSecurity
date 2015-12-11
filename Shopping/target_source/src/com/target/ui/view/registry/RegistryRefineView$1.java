// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;


// Referenced classes of package com.target.ui.view.registry:
//            RegistryRefineView, RegistrySortExpandView

class w
    implements w.a
{

    final RegistryRefineView this$0;
    final RegistrySortExpandView val$sortExpandView;

    public void a(com.target.ui.model.registry.egistrySortLabel egistrysortlabel)
    {
        if (RegistryRefineView.a(RegistryRefineView.this) == null)
        {
            return;
        } else
        {
            val$sortExpandView.a(true);
            RegistryRefineView.a(RegistryRefineView.this).a(egistrysortlabel);
            return;
        }
    }

    public void b(com.target.ui.model.registry.egistrySortLabel egistrysortlabel)
    {
        if (RegistryRefineView.a(RegistryRefineView.this) == null)
        {
            return;
        } else
        {
            val$sortExpandView.a(false);
            RegistryRefineView.a(RegistryRefineView.this).b(egistrysortlabel);
            return;
        }
    }

    w()
    {
        this$0 = final_registryrefineview;
        val$sortExpandView = RegistrySortExpandView.this;
        super();
    }
}
