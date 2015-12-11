// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

// Referenced classes of package com.abtnprojects.ambatana.ui.fragments:
//            AbstractProductDeleteConfirmationFragment

public class f extends AbstractProductDeleteConfirmationFragment
{

    public f()
    {
    }

    public Dialog c(Bundle bundle)
    {
        return (new android.support.v7.app.d.a(j())).a(0x7f09008d).a(0x1040013, new android.content.DialogInterface.OnClickListener() {

            final f a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.aj.l();
            }

            
            {
                a = f.this;
                super();
            }
        }).b(0x1040009, new android.content.DialogInterface.OnClickListener() {

            final f a;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                a = f.this;
                super();
            }
        }).b();
    }
}
