// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.stericson.RootTools:
//            RootToolsException, InternalVariables, RootTools, IResult

public class Executer
{
    private static class Worker extends Thread
    {

        private String commands[];
        public int exit;
        public List finalResponse;
        private IResult result;
        private int sleepTime;
        private boolean useRoot;

        public void run()
        {
            Object obj1;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            Object obj12;
            Object obj13;
            Object obj14;
            Object obj15;
            Object obj16;
            Object obj17;
            Object obj18;
            Object obj19;
            Object obj20;
            obj19 = null;
            obj20 = null;
            obj1 = null;
            obj14 = null;
            obj16 = null;
            obj15 = null;
            obj11 = null;
            obj13 = null;
            obj17 = null;
            obj12 = null;
            obj9 = null;
            obj10 = null;
            obj18 = null;
            obj4 = null;
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj19;
            obj3 = obj20;
            Runtime.getRuntime().gc();
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj19;
            obj3 = obj20;
            Runtime runtime = Runtime.getRuntime();
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj19;
            obj3 = obj20;
            Object obj;
            int i;
            int j;
            if (useRoot)
            {
                obj = "su";
            } else
            {
                obj = "sh";
            }
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj19;
            obj3 = obj20;
            obj1 = runtime.exec(((String) (obj)));
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj1;
            obj3 = obj1;
            if (useRoot)
            {
                obj = "Using Root";
            } else
            {
                obj = "Using sh";
            }
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj1;
            obj3 = obj1;
            RootTools.log(((String) (obj)));
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj1;
            obj3 = obj1;
            if (result == null)
            {
                break MISSING_BLOCK_LABEL_269;
            }
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj1;
            obj3 = obj1;
            result.setProcess(((Process) (obj1)));
            obj7 = obj16;
            obj6 = obj18;
            obj5 = obj17;
            obj2 = obj1;
            obj8 = obj1;
            obj3 = obj1;
            obj = new DataOutputStream(((Process) (obj1)).getOutputStream());
            obj2 = new InputStreamReader(((Process) (obj1)).getInputStream());
            obj3 = new InputStreamReader(((Process) (obj1)).getErrorStream());
            obj8 = new BufferedReader(((java.io.Reader) (obj2)));
            obj7 = new BufferedReader(((java.io.Reader) (obj3)));
            obj4 = null;
            if (result == null)
            {
                obj4 = new LinkedList();
            }
            obj5 = commands;
            j = obj5.length;
            i = 0;
_L13:
            if (i < j) goto _L2; else goto _L1
_L1:
            ((DataOutputStream) (obj)).writeBytes("exit \n");
            ((DataOutputStream) (obj)).flush();
            obj6 = ((BufferedReader) (obj8)).readLine();
            obj5 = ((BufferedReader) (obj7)).readLine();
_L14:
            if (obj6 != null) goto _L4; else goto _L3
_L3:
            if (obj5 != null) goto _L6; else goto _L5
_L5:
            if (obj1 == null) goto _L8; else goto _L7
_L7:
            finalResponse = ((List) (obj4));
            exit = ((Process) (obj1)).waitFor();
            RootTools.lastExitCode = exit;
            if (result == null) goto _L10; else goto _L9
_L9:
            result.onComplete(exit);
_L8:
            if (obj1 != null)
            {
                try
                {
                    ((Process) (obj1)).destroy();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_486;
            }
            ((DataOutputStream) (obj)).flush();
            ((DataOutputStream) (obj)).close();
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_494;
            }
            ((InputStreamReader) (obj2)).close();
            if (obj3 == null) goto _L12; else goto _L11
_L11:
            ((InputStreamReader) (obj3)).close();
_L20:
            return;
_L2:
            obj6 = obj5[i];
            RootTools.log((new StringBuilder("Shell command: ")).append(((String) (obj6))).toString());
            ((DataOutputStream) (obj)).writeBytes((new StringBuilder(String.valueOf(obj6))).append("\n").toString());
            ((DataOutputStream) (obj)).flush();
            Thread.sleep(sleepTime);
            i++;
              goto _L13
_L4:
            if (result != null)
            {
                break MISSING_BLOCK_LABEL_636;
            }
            ((List) (obj4)).add(obj6);
_L15:
            RootTools.log((new StringBuilder("input stream")).append(((String) (obj6))).toString());
            obj6 = ((BufferedReader) (obj8)).readLine();
              goto _L14
            result.process(((String) (obj6)));
              goto _L15
            obj5;
            if (result != null)
            {
                result.onFailure(((Exception) (obj5)));
            }
            if (obj1 == null) goto _L8; else goto _L16
_L16:
            finalResponse = ((List) (obj4));
            exit = ((Process) (obj1)).waitFor();
            RootTools.lastExitCode = exit;
            if (result == null) goto _L18; else goto _L17
_L17:
            result.onComplete(exit);
              goto _L8
            obj4;
            obj4 = obj3;
_L31:
            if (obj1 != null)
            {
                try
                {
                    ((Process) (obj1)).destroy();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_744;
            }
            ((DataOutputStream) (obj)).flush();
            ((DataOutputStream) (obj)).close();
            if (obj2 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStreamReader) (obj2)).close();
            if (obj4 == null) goto _L20; else goto _L19
_L19:
            try
            {
                ((InputStreamReader) (obj4)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (!RootTools.debugMode) goto _L20; else goto _L21
_L21:
            RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
            return;
_L6:
            if (result != null)
            {
                break MISSING_BLOCK_LABEL_840;
            }
            ((List) (obj4)).add(obj5);
_L22:
            RootTools.log((new StringBuilder("error stream: ")).append(((String) (obj5))).toString());
            obj5 = ((BufferedReader) (obj7)).readLine();
              goto _L3
            result.processError(((String) (obj5)));
              goto _L22
            obj5;
            if (obj1 == null) goto _L24; else goto _L23
_L23:
            finalResponse = ((List) (obj4));
            exit = ((Process) (obj1)).waitFor();
            RootTools.lastExitCode = exit;
            if (result == null) goto _L26; else goto _L25
_L25:
            result.onComplete(exit);
_L24:
            throw obj5;
            obj5;
            obj4 = obj2;
            obj9 = obj3;
            obj3 = obj5;
_L30:
            obj7 = obj;
            obj6 = obj9;
            obj5 = obj4;
            obj2 = obj1;
            if (!RootTools.debugMode)
            {
                break MISSING_BLOCK_LABEL_972;
            }
            obj7 = obj;
            obj6 = obj9;
            obj5 = obj4;
            obj2 = obj1;
            RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj3)).getMessage()).toString());
            if (obj1 != null)
            {
                try
                {
                    ((Process) (obj1)).destroy();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_992;
            }
            ((DataOutputStream) (obj)).flush();
            ((DataOutputStream) (obj)).close();
            if (obj4 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            ((InputStreamReader) (obj4)).close();
            if (obj9 == null) goto _L20; else goto _L27
_L27:
            try
            {
                ((InputStreamReader) (obj9)).close();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
            if (!RootTools.debugMode) goto _L20; else goto _L28
_L28:
            RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
            return;
_L18:
            ((List) (obj4)).add(Integer.toString(exit));
              goto _L8
            obj4;
            obj6 = obj3;
            obj3 = obj2;
            obj2 = obj4;
_L29:
            if (obj1 != null)
            {
                try
                {
                    ((Process) (obj1)).destroy();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1) { }
            }
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_1093;
            }
            ((DataOutputStream) (obj)).flush();
            ((DataOutputStream) (obj)).close();
            if (obj3 == null)
            {
                break MISSING_BLOCK_LABEL_1103;
            }
            ((InputStreamReader) (obj3)).close();
            if (obj6 != null)
            {
                try
                {
                    ((InputStreamReader) (obj6)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    if (RootTools.debugMode)
                    {
                        RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
                    }
                }
            }
            throw obj2;
_L26:
            ((List) (obj4)).add(Integer.toString(exit));
              goto _L24
_L10:
            ((List) (obj4)).add(Integer.toString(exit));
              goto _L8
            obj;
            if (RootTools.debugMode)
            {
                RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
            }
_L12:
            return;
            obj4;
            obj = obj7;
            obj3 = obj5;
            obj1 = obj2;
            obj2 = obj4;
              goto _L29
            obj2;
            obj6 = obj10;
            obj3 = obj13;
              goto _L29
            obj4;
            obj6 = obj10;
            obj3 = obj2;
            obj2 = obj4;
              goto _L29
            obj3;
            obj = obj14;
            obj4 = obj11;
            obj1 = obj8;
              goto _L30
            obj3;
            obj4 = obj11;
              goto _L30
            obj3;
            obj4 = obj2;
              goto _L30
            InterruptedException interruptedexception;
            interruptedexception;
            interruptedexception = obj15;
            obj2 = obj12;
            obj1 = obj3;
              goto _L31
            InterruptedException interruptedexception1;
            interruptedexception1;
            interruptedexception1 = obj12;
              goto _L31
            InterruptedException interruptedexception2;
            interruptedexception2;
              goto _L31
        }

        private Worker(String as[], int i, IResult iresult, boolean flag)
        {
            exit = -911;
            commands = as;
            sleepTime = i;
            result = iresult;
            useRoot = flag;
        }

        Worker(String as[], int i, IResult iresult, boolean flag, Worker worker)
        {
            this(as, i, iresult, flag);
        }
    }


    public Executer()
    {
    }

    public List sendShell(String as[], int i, IResult iresult, boolean flag, int j)
        throws IOException, RootToolsException, TimeoutException
    {
        String s1 = InternalVariables.TAG;
        StringBuilder stringbuilder = (new StringBuilder("Sending ")).append(as.length).append(" shell command");
        String s;
        long l;
        if (as.length > 1)
        {
            s = "s";
        } else
        {
            s = "";
        }
        RootTools.log(s1, stringbuilder.append(s).toString());
        as = new Worker(as, i, iresult, flag, null);
        as.start();
        i = j;
        if (j == -1)
        {
            i = 0x493e0;
        }
        l = i;
        as.join(l);
        Thread.sleep(RootTools.shellDelay);
        if (((Worker) (as)).exit == -911)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        iresult = ((Worker) (as)).finalResponse;
        return iresult;
        try
        {
            throw new TimeoutException();
        }
        // Misplaced declaration of an exception variable
        catch (IResult iresult)
        {
            as.interrupt();
        }
        Thread.currentThread().interrupt();
        throw new TimeoutException();
    }
}
