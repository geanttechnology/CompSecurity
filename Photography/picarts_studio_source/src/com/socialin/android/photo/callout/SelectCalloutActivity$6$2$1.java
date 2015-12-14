// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import com.socialin.android.activity.LocationListActivity;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.dialog.a;
import com.socialin.android.dialog.b;
import com.socialin.android.dialog.c;
import com.socialin.android.photo.main.CommonPhraseListActivity;
import com.socialin.android.photo.main.DateAndTimeListActivity;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a
    implements android.view.CalloutActivity._cls6._cls2._cls1
{

    private DialogFragment a;
    private a b;

    public final void onClick(View view)
    {
        view = new Intent(b.b.b, com/socialin/android/photo/main/CommonPhraseListActivity);
        b.b.b.startActivityForResult(view, 3);
        AnalyticUtils.getInstance(b.b.b).trackLocalAction("callout:text_common_phrase");
        a.dismiss();
    }

    a(a a1, DialogFragment dialogfragment)
    {
        b = a1;
        a = dialogfragment;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/callout/SelectCalloutActivity$6

/* anonymous class */
    final class SelectCalloutActivity._cls6
        implements android.view.View.OnClickListener
    {

        final SelectCalloutActivity a;

        public final void onClick(View view)
        {
            view = (new b()).a(1, 0x7f0c0181);
            view.f = 0x7f0301be;
            view.i = true;
            view.j = true;
            view.p = new SelectCalloutActivity._cls6._cls2(this);
            view.m = new SelectCalloutActivity._cls6._cls1();
            view.h = false;
            view.g = false;
            view.a().show(a.getFragmentManager(), null);
        }

            
            {
                a = selectcalloutactivity;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/callout/SelectCalloutActivity$6$1

/* anonymous class */
        final class SelectCalloutActivity._cls6._cls1
            implements android.content.DialogInterface.OnCancelListener
        {

            public final void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
            }

        }

    }


    // Unreferenced inner class com/socialin/android/photo/callout/SelectCalloutActivity$6$2

/* anonymous class */
    final class SelectCalloutActivity._cls6._cls2
        implements c
    {

        final SelectCalloutActivity._cls6 a;

        public final void onViewCreated(View view, DialogFragment dialogfragment)
        {
            dialogfragment.setStyle(1, 0x7f0c0181);
            view.findViewById(0x7f100831).setOnClickListener(new SelectCalloutActivity._cls6._cls2._cls1(this, dialogfragment));
            view.findViewById(0x7f100832).setOnClickListener(new SelectCalloutActivity._cls6._cls2._cls2(dialogfragment));
            view.findViewById(0x7f100833).setOnClickListener(new SelectCalloutActivity._cls6._cls2._cls3(dialogfragment));
        }

            
            {
                a = _pcls6;
                super();
            }

        // Unreferenced inner class com/socialin/android/photo/callout/SelectCalloutActivity$6$2$2

/* anonymous class */
        final class SelectCalloutActivity._cls6._cls2._cls2
            implements android.view.View.OnClickListener
        {

            private DialogFragment a;
            private SelectCalloutActivity._cls6._cls2 b;

            public final void onClick(View view)
            {
                view = new Intent(b.a.a, com/socialin/android/activity/LocationListActivity);
                b.a.a.startActivityForResult(view, 1);
                AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_loc_based");
                a.dismiss();
            }

                    
                    {
                        b = SelectCalloutActivity._cls6._cls2.this;
                        a = dialogfragment;
                        super();
                    }
        }


        // Unreferenced inner class com/socialin/android/photo/callout/SelectCalloutActivity$6$2$3

/* anonymous class */
        final class SelectCalloutActivity._cls6._cls2._cls3
            implements android.view.View.OnClickListener
        {

            private DialogFragment a;
            private SelectCalloutActivity._cls6._cls2 b;

            public final void onClick(View view)
            {
                view = new Intent(b.a.a, com/socialin/android/photo/main/DateAndTimeListActivity);
                b.a.a.startActivityForResult(view, 2);
                AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_date");
                a.dismiss();
            }

                    
                    {
                        b = SelectCalloutActivity._cls6._cls2.this;
                        a = dialogfragment;
                        super();
                    }
        }

    }

}
