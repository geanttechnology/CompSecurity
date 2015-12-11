// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            SanityCheckRootTools, RootToolsException, RootTools, InternalVariables

private class mHandler extends Thread
{

    private Handler mHandler;
    final SanityCheckRootTools this$0;

    private void visualUpdate(int i, String s)
    {
        Message message = mHandler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", i);
        bundle.putString("text", s);
        message.setData(bundle);
        mHandler.sendMessage(message);
    }

    public void run()
    {
        visualUpdate(1, null);
        visualUpdate(4, "Testing df");
        long l = RootTools.getSpace("/data");
        visualUpdate(3, "[ Checking /data partition size]\n");
        visualUpdate(3, (new StringBuilder(String.valueOf(l))).append("k\n\n").toString());
        visualUpdate(4, "Testing sendShell() w/ return array");
        Object obj;
        obj = RootTools.sendShell("ls /", InternalVariables.timeout);
        visualUpdate(3, "[ Listing of / (passing a List)]\n");
        obj = ((List) (obj)).iterator();
_L5:
        boolean flag = ((Iterator) (obj)).hasNext();
        if (flag) goto _L2; else goto _L1
_L1:
        visualUpdate(4, "Testing sendShell() w/ callbacks");
        Object obj1;
        int i;
        try
        {
            visualUpdate(3, "\n[ Listing of / (callback)]\n");
            obj = new RootTools.Result() {

                final SanityCheckRootTools.SanityCheckThread this$1;

                public void onComplete(int k)
                {
                    visualUpdate(3, "------\nDone.\n");
                }

                public void onFailure(Exception exception)
                {
                    visualUpdate(2, (new StringBuilder("ERROR: ")).append(exception).toString());
                    setError(1);
                }

                public void process(String s)
                    throws Exception
                {
                    visualUpdate(3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
                }

                public void processError(String s)
                    throws Exception
                {
                    visualUpdate(3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
                }

            
            {
                this$1 = SanityCheckRootTools.SanityCheckThread.this;
                super();
            }
            };
            RootTools.sendShell("ls /", ((visualUpdate) (obj)), InternalVariables.timeout);
            i = ((visualUpdate) (obj)).visualUpdate();
        }
        catch (IOException ioexception)
        {
            visualUpdate(2, (new StringBuilder("ERROR: ")).append(ioexception).toString());
            return;
        }
        catch (RootToolsException roottoolsexception)
        {
            visualUpdate(2, (new StringBuilder("DEV-DEFINED ERROR: ")).append(roottoolsexception).toString());
            return;
        }
        catch (TimeoutException timeoutexception)
        {
            visualUpdate(2, (new StringBuilder("Timeout.. ")).append(timeoutexception).toString());
            return;
        }
        if (i == 0) goto _L4; else goto _L3
_L3:
        return;
_L2:
        try
        {
            visualUpdate(3, (new StringBuilder(String.valueOf((String)((Iterator) (obj)).next()))).append("\n").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            visualUpdate(2, (new StringBuilder("ERROR: ")).append(obj1).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            visualUpdate(2, (new StringBuilder("DEV-DEFINED ERROR: ")).append(obj1).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            visualUpdate(2, (new StringBuilder("Timeout.. ")).append(obj1).toString());
            return;
        }
          goto _L5
_L4:
        visualUpdate(4, "Testing sendShell() for multiple commands");
        visualUpdate(3, "\n[ ps + ls + date / (callback)]\n");
        timeoutexception = new RootTools.Result() {

            final SanityCheckRootTools.SanityCheckThread this$1;

            public void onComplete(int k)
            {
                visualUpdate(3, "------\nDone.\n");
            }

            public void onFailure(Exception exception)
            {
                visualUpdate(2, (new StringBuilder("ERROR: ")).append(exception).toString());
                setError(1);
            }

            public void process(String s)
                throws Exception
            {
                visualUpdate(3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
            }

            public void processError(String s)
                throws Exception
            {
                visualUpdate(3, (new StringBuilder(String.valueOf(s))).append("\n").toString());
            }

            
            {
                this$1 = SanityCheckRootTools.SanityCheckThread.this;
                super();
            }
        };
        int j;
        j = InternalVariables.timeout;
        RootTools.sendShell(new String[] {
            "echo \"* PS:\"", "ps", "echo \"* LS:\"", "ls", "echo \"* DATE:\"", "date"
        }, 2000, timeoutexception, j);
        j = timeoutexception.visualUpdate();
        if (j != 0) goto _L3; else goto _L6
_L6:
        visualUpdate(4, "All tests complete.");
        visualUpdate(2, null);
        return;
        Object obj2;
        obj2;
_L10:
        visualUpdate(2, (new StringBuilder("ERROR: ")).append(obj2).toString());
          goto _L6
        obj2;
_L9:
        visualUpdate(2, (new StringBuilder("DEV-DEFINED ERROR: ")).append(obj2).toString());
          goto _L6
        obj2;
_L8:
        visualUpdate(2, (new StringBuilder("Timeout.. ")).append(obj2).toString());
        return;
        obj2;
        if (true) goto _L8; else goto _L7
_L7:
        obj2;
          goto _L9
        obj2;
          goto _L10
    }


    public _cls2.this._cls1(Context context, Handler handler)
    {
        this$0 = SanityCheckRootTools.this;
        super();
        mHandler = handler;
    }
}
