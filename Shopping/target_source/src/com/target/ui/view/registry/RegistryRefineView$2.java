// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.registry;


// Referenced classes of package com.target.ui.view.registry:
//            RegistryRefineView, RegistryEventTypeExpandView

class ndView
    implements ndView.a
{

    final RegistryRefineView this$0;
    final RegistryEventTypeExpandView val$eventTypeExpandView;

    public void a(com.target.ui.model.registry.egistryEventLabel egistryeventlabel)
    {
        if (RegistryRefineView.a(RegistryRefineView.this) == null)
        {
            return;
        } else
        {
            val$eventTypeExpandView.a(true);
            RegistryRefineView.a(RegistryRefineView.this).a(egistryeventlabel);
            return;
        }
    }

    public void b(com.target.ui.model.registry.egistryEventLabel egistryeventlabel)
    {
        if (RegistryRefineView.a(RegistryRefineView.this) == null)
        {
            return;
        } else
        {
            val$eventTypeExpandView.a(false);
            RegistryRefineView.a(RegistryRefineView.this).b(egistryeventlabel);
            return;
        }
    }

    ndView()
    {
        this$0 = final_registryrefineview;
        val$eventTypeExpandView = RegistryEventTypeExpandView.this;
        super();
    }
}
