// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.Environment;
import android.view.View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

final class f
{

    private StringBuilder a;
    private File b;
    private int c;
    private int d;
    private boolean e;
    private DragSortListView f;

    public f(DragSortListView dragsortlistview)
    {
        f = dragsortlistview;
        super();
        a = new StringBuilder();
        c = 0;
        d = 0;
        e = false;
        b = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        if (b.exists())
        {
            break MISSING_BLOCK_LABEL_69;
        }
        b.createNewFile();
        return;
        dragsortlistview;
        dragsortlistview.getMessage();
        return;
    }

    private void d()
    {
        boolean flag;
        flag = false;
        if (!e)
        {
            return;
        }
        FileWriter filewriter;
        IOException ioexception;
        if (d != 0)
        {
            flag = true;
        }
        filewriter = new FileWriter(b, flag);
        filewriter.write(a.toString());
        a.delete(0, a.length());
        filewriter.flush();
        filewriter.close();
        d = d + 1;
        return;
        ioexception;
    }

    public final void a()
    {
        a.append("<DSLVStates>\n");
        d = 0;
        e = true;
    }

    public final void b()
    {
        if (e)
        {
            a.append("<DSLVState>\n");
            int i1 = f.getChildCount();
            int j1 = f.getFirstVisiblePosition();
            a.append("    <Positions>");
            for (int i = 0; i < i1; i++)
            {
                a.append(j1 + i).append(",");
            }

            a.append("</Positions>\n");
            a.append("    <Tops>");
            for (int j = 0; j < i1; j++)
            {
                a.append(f.getChildAt(j).getTop()).append(",");
            }

            a.append("</Tops>\n");
            a.append("    <Bottoms>");
            for (int k = 0; k < i1; k++)
            {
                a.append(f.getChildAt(k).getBottom()).append(",");
            }

            a.append("</Bottoms>\n");
            a.append("    <FirstExpPos>").append(DragSortListView.k(f)).append("</FirstExpPos>\n");
            a.append("    <FirstExpBlankHeight>").append(DragSortListView.b(f, DragSortListView.k(f)) - DragSortListView.c(f, DragSortListView.k(f))).append("</FirstExpBlankHeight>\n");
            a.append("    <SecondExpPos>").append(DragSortListView.l(f)).append("</SecondExpPos>\n");
            a.append("    <SecondExpBlankHeight>").append(DragSortListView.b(f, DragSortListView.l(f)) - DragSortListView.c(f, DragSortListView.l(f))).append("</SecondExpBlankHeight>\n");
            a.append("    <SrcPos>").append(DragSortListView.g(f)).append("</SrcPos>\n");
            a.append("    <SrcHeight>").append(DragSortListView.i(f) + f.getDividerHeight()).append("</SrcHeight>\n");
            a.append("    <ViewHeight>").append(f.getHeight()).append("</ViewHeight>\n");
            a.append("    <LastY>").append(DragSortListView.w(f)).append("</LastY>\n");
            a.append("    <FloatY>").append(DragSortListView.q(f)).append("</FloatY>\n");
            a.append("    <ShuffleEdges>");
            for (int l = 0; l < i1; l++)
            {
                a.append(DragSortListView.a(f, j1 + l, f.getChildAt(l).getTop())).append(",");
            }

            a.append("</ShuffleEdges>\n");
            a.append("</DSLVState>\n");
            c = c + 1;
            if (c > 1000)
            {
                d();
                c = 0;
                return;
            }
        }
    }

    public final void c()
    {
        if (e)
        {
            a.append("</DSLVStates>\n");
            d();
            e = false;
        }
    }
}
