// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.draw.dialog;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.picsart.studio.view.WrappingListPopupWindow;
import com.picsart.studio.view.p;

// Referenced classes of package com.socialin.android.photo.draw.dialog:
//            SelectCanvasSizeDialog

final class a
    implements Runnable
{

    private a a;

    public final void run()
    {
        p p1 = WrappingListPopupWindow.a(a.a.getActivity());
        p1.a = a.a;
        p1.b = a.a;
        p1.c = a.a;
        p1.b();
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/socialin/android/photo/draw/dialog/SelectCanvasSizeDialog$5

/* anonymous class */
    final class SelectCanvasSizeDialog._cls5
        implements android.view.View.OnClickListener
    {

        final Button a;
        final ArrayAdapter b;
        final android.widget.AdapterView.OnItemClickListener c;
        final SelectCanvasSizeDialog d;

        public final void onClick(View view)
        {
            view = (InputMethodManager)d.getActivity().getSystemService("input_method");
            view.hideSoftInputFromWindow(SelectCanvasSizeDialog.a(d).getWindowToken(), 0);
            view.hideSoftInputFromWindow(SelectCanvasSizeDialog.b(d).getWindowToken(), 0);
            (new Handler()).postDelayed(new SelectCanvasSizeDialog._cls5._cls1(this), 180L);
        }

            
            {
                d = selectcanvassizedialog;
                a = button;
                b = arrayadapter;
                c = onitemclicklistener;
                super();
            }
    }

}
