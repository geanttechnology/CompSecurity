// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amobee.pulse3d;

import android.opengl.GLES20;

// Referenced classes of package com.amobee.pulse3d:
//            CommandBase, Pulse3DView

class CommandIsEnabled extends CommandBase
{

    static int argTypes[] = {
        2
    };
    int cap_;
    boolean ret_;

    CommandIsEnabled()
    {
    }

    void execute()
    {
        ret_ = GLES20.glIsEnabled(cap_);
    }

    void initArgs(CmdParserBase.GlArg aglarg[], Pulse3DView pulse3dview)
    {
        cap_ = aglarg[0].intVal[0];
    }

    String stringifyResult()
    {
        String s = (new StringBuilder()).append("{ result: ").append(Boolean.toString(ret_)).toString();
        return (new StringBuilder()).append(s).append("}").toString();
    }

}
