// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.fragment;

import android.view.View;
import android.widget.PopupWindow;
import com.picsart.studio.EditingData;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.photo.select.SelectionDrawController;
import com.socialin.android.photo.select.SelectionShapeDrawController;

// Referenced classes of package com.picsart.studio.editor.fragment:
//            SelectionFragment

final class a
    implements android.view..SelectionFragment._cls24
{

    private SelectionFragment a;

    public final void onClick(View view)
    {
        int i;
        a.g.dismiss();
        i = view.getId();
        i;
        JVM INSTR lookupswitch 11: default 116
    //                   2131756384: 224
    //                   2131757119: 272
    //                   2131757120: 320
    //                   2131757121: 368
    //                   2131757122: 416
    //                   2131757123: 464
    //                   2131757124: 464
    //                   2131757125: 464
    //                   2131757126: 640
    //                   2131757127: 640
    //                   2131757128: 640;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L7 _L7 _L8 _L8 _L8
_L1:
        break; /* Loop/switch isn't completed */
_L16:
        i;
        JVM INSTR lookupswitch 11: default 216
    //                   2131756384: 832
    //                   2131757119: 816
    //                   2131757120: 848
    //                   2131757121: 832
    //                   2131757122: 816
    //                   2131757123: 848
    //                   2131757124: 832
    //                   2131757125: 816
    //                   2131757126: 848
    //                   2131757127: 832
    //                   2131757128: 816;
           goto _L9 _L10 _L11 _L12 _L10 _L11 _L12 _L10 _L11 _L12 _L10 _L11
_L9:
        SelectionFragment.z(a);
        return;
_L2:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "brush"));
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.FREE_CROP);
        break; /* Loop/switch isn't completed */
_L3:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "eraser"));
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.FREE_CROP);
        break; /* Loop/switch isn't completed */
_L4:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "lasso"));
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.LASSO);
        break; /* Loop/switch isn't completed */
_L5:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "lasso_multi"));
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.LASSO);
        break; /* Loop/switch isn't completed */
_L6:
        AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "lasso_erase"));
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.LASSO);
        break; /* Loop/switch isn't completed */
_L7:
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.SHAPE);
        view = SelectionFragment.p(a).r;
        if (((SelectionShapeDrawController) (view)).s != com.socialin.android.photo.select.troller.SelectionShapeType.RECTANGLE)
        {
            view.a(com.socialin.android.photo.select.troller.SelectionShapeType.RECTANGLE);
        }
        switch (i)
        {
        case 2131757123: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "rectangle"));
            break;

        case 2131757124: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "rectangle_multi"));
            break;

        case 2131757125: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "rectangle_erase"));
            break;
        }
        if (false)
        {
        }
          goto _L13
_L8:
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.DRAW_MODE.SHAPE);
        view = SelectionFragment.p(a).r;
        if (((SelectionShapeDrawController) (view)).s != com.socialin.android.photo.select.troller.SelectionShapeType.CIRCLE)
        {
            view.a(com.socialin.android.photo.select.troller.SelectionShapeType.CIRCLE);
        }
        switch (i)
        {
        case 2131757126: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "circle"));
            break;

        case 2131757127: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "circle_multi"));
            break;

        case 2131757128: 
            AnalyticUtils.getInstance(a.getActivity()).track(new com.socialin.android.apiv3.events.ectionTryEvent(SelectionFragment.b(a).a, "circle_erase"));
            break;
        }
          goto _L13
_L11:
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.FILL_TYPE.CLEAR);
          goto _L14
_L10:
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.FILL_TYPE.ADD);
          goto _L14
_L12:
        SelectionFragment.p(a).a(com.socialin.android.photo.select.er.FILL_TYPE.DEFAULT);
_L14:
        if (true) goto _L9; else goto _L13
_L13:
        if (true) goto _L16; else goto _L15
_L15:
    }

    r.FILL_TYPE(SelectionFragment selectionfragment)
    {
        a = selectionfragment;
        super();
    }
}
