// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.graphics.Bitmap;
import com.picsart.studio.EditingData;
import com.picsart.studio.editor.EditorProject;
import com.picsart.studio.editor.activity.EditorActivity;
import com.picsart.studio.editor.c;
import com.picsart.studio.editor.e;
import com.picsart.studio.editor.fragment.s;
import com.picsart.studio.editor.history.RasterAction;

public class n
{

    public com.picsart.studio.editor.fragment.s._cls4 a;

    public n(com.picsart.studio.editor.fragment.s._cls4 _pcls4)
    {
        a = _pcls4;
        super();
    }

    public void a(Bitmap bitmap)
    {
        e.a().e.d("mask");
        if (a.a.isResumed())
        {
            ((EditorActivity)a.a.getActivity()).e();
            a.a.g.a(a.a, bitmap, RasterAction.create(bitmap, e.a().d.getHistoryDataDirectory()));
        }
    }
}
