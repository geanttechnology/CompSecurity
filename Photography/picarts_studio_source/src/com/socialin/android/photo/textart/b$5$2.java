// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.socialin.android.activity.LocationListActivity;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.photo.main.CommonPhraseListActivity;
import com.socialin.android.photo.main.DateAndTimeListActivity;

// Referenced classes of package com.socialin.android.photo.textart:
//            b

final class a
    implements c
{

    final _cls3.a a;

    public final void onViewCreated(View view, DialogFragment dialogfragment)
    {
        dialogfragment.setStyle(1, 0x7f0c0181);
        view.findViewById(0x7f100831).setOnClickListener(new android.view.View.OnClickListener(dialogfragment) {

            private DialogFragment a;
            private b._cls5._cls2 b;

            public final void onClick(View view1)
            {
                view1 = new Intent(b.a.a.getActivity(), com/socialin/android/photo/main/CommonPhraseListActivity);
                com.socialin.android.photo.textart.b.e(b.a.a).startActivityForResult(view1, 3);
                a.dismiss();
            }

            
            {
                b = b._cls5._cls2.this;
                a = dialogfragment;
                super();
            }
        });
        view.findViewById(0x7f100832).setOnClickListener(new android.view.View.OnClickListener(dialogfragment) {

            private DialogFragment a;
            private b._cls5._cls2 b;

            public final void onClick(View view1)
            {
                view1 = new Intent(b.a.a.getActivity(), com/socialin/android/activity/LocationListActivity);
                com.socialin.android.photo.textart.b.e(b.a.a).startActivityForResult(view1, 1);
                a.dismiss();
            }

            
            {
                b = b._cls5._cls2.this;
                a = dialogfragment;
                super();
            }
        });
        view.findViewById(0x7f100833).setOnClickListener(new android.view.View.OnClickListener(dialogfragment) {

            private DialogFragment a;
            private b._cls5._cls2 b;

            public final void onClick(View view1)
            {
                view1 = new Intent(b.a.a.getActivity(), com/socialin/android/photo/main/DateAndTimeListActivity);
                com.socialin.android.photo.textart.b.e(b.a.a).startActivityForResult(view1, 2);
                a.dismiss();
            }

            
            {
                b = b._cls5._cls2.this;
                a = dialogfragment;
                super();
            }
        });
    }

    istener(istener istener)
    {
        a = istener;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/textart/b$5

/* anonymous class */
    final class b._cls5
        implements android.view.View.OnClickListener
    {

        final com.socialin.android.photo.textart.b a;

        public final void onClick(View view)
        {
            view = (new b()).a(1, 0x7f0c0181);
            view.f = 0x7f0301be;
            view.i = true;
            view.j = true;
            view.p = new b._cls5._cls2(this);
            view.m = new b._cls5._cls1();
            view.h = false;
            view.g = false;
            view.a().show(b.e(a).getFragmentManager(), null);
        }

            
            {
                a = b1;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/textart/b$5$1

/* anonymous class */
        final class b._cls5._cls1
            implements android.content.DialogInterface.OnCancelListener
        {

            public final void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
            }

        }

    }

}
