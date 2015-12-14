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
    implements android.view.lectCalloutActivity._cls6
{

    final SelectCalloutActivity a;

    public final void onClick(View view)
    {
        view = (new b()).a(1, 0x7f0c0181);
        view.f = 0x7f0301be;
        view.i = true;
        view.j = true;
        view.p = new c() {

            final SelectCalloutActivity._cls6 a;

            public final void onViewCreated(View view1, DialogFragment dialogfragment)
            {
                dialogfragment.setStyle(1, 0x7f0c0181);
                view1.findViewById(0x7f100831).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                    private DialogFragment a;
                    private _cls2 b;

                    public final void onClick(View view)
                    {
                        view = new Intent(b.a.a, com/socialin/android/photo/main/CommonPhraseListActivity);
                        b.a.a.startActivityForResult(view, 3);
                        AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_common_phrase");
                        a.dismiss();
                    }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                });
                view1.findViewById(0x7f100832).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                    private DialogFragment a;
                    private _cls2 b;

                    public final void onClick(View view)
                    {
                        view = new Intent(b.a.a, com/socialin/android/activity/LocationListActivity);
                        b.a.a.startActivityForResult(view, 1);
                        AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_loc_based");
                        a.dismiss();
                    }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                });
                view1.findViewById(0x7f100833).setOnClickListener(new android.view.View.OnClickListener(this, dialogfragment) {

                    private DialogFragment a;
                    private _cls2 b;

                    public final void onClick(View view)
                    {
                        view = new Intent(b.a.a, com/socialin/android/photo/main/DateAndTimeListActivity);
                        b.a.a.startActivityForResult(view, 2);
                        AnalyticUtils.getInstance(b.a.a).trackLocalAction("callout:text_date");
                        a.dismiss();
                    }

            
            {
                b = _pcls2;
                a = dialogfragment;
                super();
            }
                });
            }

            
            {
                a = SelectCalloutActivity._cls6.this;
                super();
            }
        };
        view.m = new android.content.DialogInterface.OnCancelListener() {

            public final void onCancel(DialogInterface dialoginterface)
            {
                dialoginterface.dismiss();
            }

        };
        view.h = false;
        view.g = false;
        view.a().show(a.getFragmentManager(), null);
    }

    _cls2.a(SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
