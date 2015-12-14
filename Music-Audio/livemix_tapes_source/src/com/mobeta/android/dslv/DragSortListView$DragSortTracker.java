// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class mFile
{

    StringBuilder mBuilder;
    File mFile;
    private int mNumFlushes;
    private int mNumInBuffer;
    private boolean mTracking;
    final DragSortListView this$0;

    public void appendState()
    {
        if (mTracking) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        int j;
        int k;
        mBuilder.append("<DSLVState>\n");
        j = getChildCount();
        k = getFirstVisiblePosition();
        mBuilder.append("    <Positions>");
        i = 0;
_L9:
        if (i < j) goto _L4; else goto _L3
_L3:
        mBuilder.append("</Positions>\n");
        mBuilder.append("    <Tops>");
        i = 0;
_L10:
        if (i < j) goto _L6; else goto _L5
_L5:
        mBuilder.append("</Tops>\n");
        mBuilder.append("    <Bottoms>");
        i = 0;
_L11:
        if (i < j) goto _L8; else goto _L7
_L7:
        mBuilder.append("</Bottoms>\n");
        mBuilder.append("    <FirstExpPos>").append(DragSortListView.access$15(DragSortListView.this)).append("</FirstExpPos>\n");
        mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.access$31(DragSortListView.this, DragSortListView.access$15(DragSortListView.this)) - DragSortListView.access$32(DragSortListView.this, DragSortListView.access$15(DragSortListView.this))).append("</FirstExpBlankHeight>\n");
        mBuilder.append("    <SecondExpPos>").append(DragSortListView.access$16(DragSortListView.this)).append("</SecondExpPos>\n");
        mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.access$31(DragSortListView.this, DragSortListView.access$16(DragSortListView.this)) - DragSortListView.access$32(DragSortListView.this, DragSortListView.access$16(DragSortListView.this))).append("</SecondExpBlankHeight>\n");
        mBuilder.append("    <SrcPos>").append(DragSortListView.access$10(DragSortListView.this)).append("</SrcPos>\n");
        mBuilder.append("    <SrcHeight>").append(DragSortListView.access$13(DragSortListView.this) + getDividerHeight()).append("</SrcHeight>\n");
        mBuilder.append("    <ViewHeight>").append(getHeight()).append("</ViewHeight>\n");
        mBuilder.append("    <LastY>").append(DragSortListView.access$33(DragSortListView.this)).append("</LastY>\n");
        mBuilder.append("    <FloatY>").append(DragSortListView.access$23(DragSortListView.this)).append("</FloatY>\n");
        mBuilder.append("    <ShuffleEdges>");
        i = 0;
_L12:
        if (i < j)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        mBuilder.append("</ShuffleEdges>\n");
        mBuilder.append("</DSLVState>\n");
        mNumInBuffer = mNumInBuffer + 1;
        if (mNumInBuffer > 1000)
        {
            flush();
            mNumInBuffer = 0;
            return;
        }
          goto _L1
_L4:
        mBuilder.append(k + i).append(",");
        i++;
          goto _L9
_L6:
        mBuilder.append(getChildAt(i).getTop()).append(",");
        i++;
          goto _L10
_L8:
        mBuilder.append(getChildAt(i).getBottom()).append(",");
        i++;
          goto _L11
        mBuilder.append(DragSortListView.access$34(DragSortListView.this, k + i, getChildAt(i).getTop())).append(",");
        i++;
          goto _L12
    }

    public void flush()
    {
        boolean flag;
        if (!mTracking)
        {
            return;
        }
        flag = true;
        if (mNumFlushes == 0)
        {
            flag = false;
        }
        try
        {
            FileWriter filewriter = new FileWriter(mFile, flag);
            filewriter.write(mBuilder.toString());
            mBuilder.delete(0, mBuilder.length());
            filewriter.flush();
            filewriter.close();
            mNumFlushes = mNumFlushes + 1;
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    public void startTracking()
    {
        mBuilder.append("<DSLVStates>\n");
        mNumFlushes = 0;
        mTracking = true;
    }

    public void stopTracking()
    {
        if (mTracking)
        {
            mBuilder.append("</DSLVStates>\n");
            flush();
            mTracking = false;
        }
    }

    public ()
    {
        this$0 = DragSortListView.this;
        super();
        mBuilder = new StringBuilder();
        mNumInBuffer = 0;
        mNumFlushes = 0;
        mTracking = false;
        mFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        if (mFile.exists())
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mFile.createNewFile();
        Log.d("mobeta", "file created");
        return;
        dragsortlistview;
        Log.w("mobeta", "Could not create dslv_state.txt");
        Log.d("mobeta", getMessage());
        return;
    }
}
