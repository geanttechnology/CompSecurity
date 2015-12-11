// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v8.renderscript;

import android.content.Context;
import android.renderscript.RenderScript;

// Referenced classes of package android.support.v8.renderscript:
//            RenderScript, RSInvalidStateException

class RenderScriptThunker extends android.support.v8.renderscript.RenderScript
{

    RenderScript mN;

    RenderScriptThunker(Context context)
    {
        super(context);
        isNative = true;
    }

    public static android.support.v8.renderscript.RenderScript create(Context context, int i)
    {
        RenderScriptThunker renderscriptthunker = new RenderScriptThunker(context);
        renderscriptthunker.mN = RenderScript.create(context, i);
        return renderscriptthunker;
    }

    public void contextDump()
    {
        mN.contextDump();
    }

    public void destroy()
    {
        mN.destroy();
        mN = null;
    }

    public void finish()
    {
        mN.finish();
    }

    public void setPriority(RenderScript.Priority priority)
    {
        if (priority == RenderScript.Priority.LOW)
        {
            mN.setPriority(android.renderscript.RenderScript.Priority.LOW);
        }
        if (priority == RenderScript.Priority.NORMAL)
        {
            mN.setPriority(android.renderscript.RenderScript.Priority.NORMAL);
        }
    }

    void validate()
    {
        if (mN == null)
        {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        } else
        {
            return;
        }
    }
}
