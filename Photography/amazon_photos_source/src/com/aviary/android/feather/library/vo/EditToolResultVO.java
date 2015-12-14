// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.vo;

import com.aviary.android.feather.headless.moa.MoaActionList;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.library.vo:
//            EditToolVO, ToolActionVO

public class EditToolResultVO
{

    MoaActionList actionList;
    final EditToolVO editTool;

    public EditToolResultVO(String s, int i)
    {
        editTool = new EditToolVO(s, i);
    }

    public void addToolAction(ToolActionVO toolactionvo)
    {
        editTool.addToolAction(toolactionvo);
    }

    public MoaActionList getActionList()
    {
        return actionList;
    }

    public EditToolVO getEditTool()
    {
        return editTool;
    }

    public List getToolActions()
    {
        return editTool.getToolActions();
    }

    public String getToolId()
    {
        return editTool.getToolId();
    }

    public int getToolVersion()
    {
        return editTool.getToolVersion();
    }

    public void reset()
    {
        if (actionList != null)
        {
            actionList.clear();
        }
        editTool.reset();
    }

    public void setActionList(MoaActionList moaactionlist)
    {
        actionList = moaactionlist;
    }

    public void setToolAction(ToolActionVO toolactionvo)
    {
        editTool.setToolAction(toolactionvo);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("EditToolResultVO{ ");
        if (valid())
        {
            stringbuilder.append((new StringBuilder()).append("toolId:").append(getToolId()).toString());
            stringbuilder.append((new StringBuilder()).append(", toolVersion:").append(getToolVersion()).toString());
            stringbuilder.append((new StringBuilder()).append(", actions:").append(actionList.size()).toString());
            stringbuilder.append((new StringBuilder()).append(", edit:").append(getToolActions().toString()).toString());
        } else
        {
            stringbuilder.append("INVALID");
        }
        stringbuilder.append(" }");
        return stringbuilder.toString();
    }

    public boolean valid()
    {
        return actionList != null && actionList.size() > 0;
    }
}
