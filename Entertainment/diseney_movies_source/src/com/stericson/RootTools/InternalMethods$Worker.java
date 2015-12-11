// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.stericson.RootTools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.stericson.RootTools:
//            InternalMethods, RootTools, InternalVariables

private static class <init> extends Thread
{

    private String commands[];
    public int exit;

    public void run()
    {
        Object obj;
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
        obj18 = null;
        obj19 = null;
        obj1 = null;
        obj14 = null;
        obj = null;
        obj15 = null;
        obj10 = null;
        obj16 = null;
        obj13 = null;
        obj12 = null;
        obj8 = null;
        obj17 = null;
        obj11 = null;
        obj9 = null;
        obj4 = obj1;
        obj5 = obj;
        obj6 = obj17;
        obj7 = obj16;
        obj2 = obj18;
        obj3 = obj19;
        Runtime.getRuntime().gc();
        obj4 = obj1;
        obj5 = obj;
        obj6 = obj17;
        obj7 = obj16;
        obj2 = obj18;
        obj3 = obj19;
        obj1 = Runtime.getRuntime().exec("su");
        obj4 = obj1;
        obj5 = obj;
        obj6 = obj17;
        obj7 = obj16;
        obj2 = obj1;
        obj3 = obj1;
        obj = new DataOutputStream(((Process) (obj1)).getOutputStream());
        obj2 = new InputStreamReader(((Process) (obj1)).getInputStream());
        obj3 = new InputStreamReader(((Process) (obj1)).getErrorStream());
        int j;
        obj7 = new BufferedReader(((java.io.Reader) (obj2)));
        obj6 = new BufferedReader(((java.io.Reader) (obj3)));
        obj4 = commands;
        j = obj4.length;
        int i = 0;
_L8:
        if (i < j) goto _L2; else goto _L1
_L1:
        ((DataOutputStream) (obj)).writeBytes("exit \n");
        ((DataOutputStream) (obj)).flush();
        obj4 = ((BufferedReader) (obj7)).readLine();
        obj5 = ((BufferedReader) (obj6)).readLine();
          goto _L3
_L18:
        if (obj4 != null) goto _L5; else goto _L4
_L4:
        exit = ((Process) (obj1)).waitFor();
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
            break MISSING_BLOCK_LABEL_255;
        }
        ((DataOutputStream) (obj)).flush();
        ((DataOutputStream) (obj)).close();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        ((InputStreamReader) (obj2)).close();
        if (obj3 == null) goto _L7; else goto _L6
_L6:
        ((InputStreamReader) (obj3)).close();
_L16:
        return;
_L2:
        obj5 = obj4[i];
        RootTools.log((new StringBuilder("Shell command: ")).append(((String) (obj5))).toString());
        ((DataOutputStream) (obj)).writeBytes((new StringBuilder(String.valueOf(obj5))).append("\n").toString());
        ((DataOutputStream) (obj)).flush();
        i++;
          goto _L8
_L28:
        if (!commands[0].equals("id")) goto _L10; else goto _L9
_L9:
        obj8 = (new HashSet(Arrays.asList(((String) (obj4)).split(" ")))).iterator();
_L12:
        if (((Iterator) (obj8)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
_L13:
        if (!InternalVariables.accessGiven)
        {
            RootTools.log(InternalVariables.TAG, "Access Denied?");
        }
_L10:
        if (commands[0].startsWith("df") && ((String) (obj4)).contains(commands[0].substring(2, commands[0].length()).trim()))
        {
            InternalVariables.space = ((String) (obj4)).split(" ");
        }
        if (commands[0].equals("busybox") && ((String) (obj4)).startsWith("BusyBox"))
        {
            InternalVariables.busyboxVersion = ((String) (obj4)).split(" ")[1];
        }
        if (commands[0].startsWith("busybox pidof") && !((String) (obj4)).equals(""))
        {
            RootTools.log((new StringBuilder("PID: ")).append(((String) (obj4))).toString());
            InternalVariables.pid = ((String) (obj4));
        }
        RootTools.log(((String) (obj4)));
        obj4 = ((BufferedReader) (obj7)).readLine();
        continue; /* Loop/switch isn't completed */
        if (!((String)((Iterator) (obj8)).next()).toLowerCase().contains("uid=0")) goto _L12; else goto _L11
_L11:
        InternalVariables.accessGiven = true;
        RootTools.log(InternalVariables.TAG, "Access Given");
          goto _L13
        if (true) goto _L12; else goto _L14
_L14:
        obj4;
        obj4 = obj3;
_L26:
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
            break MISSING_BLOCK_LABEL_616;
        }
        ((DataOutputStream) (obj)).flush();
        ((DataOutputStream) (obj)).close();
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStreamReader) (obj2)).close();
        if (obj4 == null) goto _L16; else goto _L15
_L15:
        try
        {
            ((InputStreamReader) (obj4)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (!RootTools.debugMode) goto _L16; else goto _L17
_L17:
        RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
        ((Exception) (obj)).printStackTrace();
        return;
_L5:
        RootTools.log(((String) (obj4)));
        obj4 = ((BufferedReader) (obj6)).readLine();
          goto _L18
        obj3;
        obj1 = obj4;
        obj4 = obj10;
        obj = obj14;
_L25:
        obj5 = obj;
        obj6 = obj8;
        obj7 = obj4;
        obj2 = obj1;
        if (!RootTools.debugMode)
        {
            break MISSING_BLOCK_LABEL_769;
        }
        obj5 = obj;
        obj6 = obj8;
        obj7 = obj4;
        obj2 = obj1;
        RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj3)).getMessage()).toString());
        obj5 = obj;
        obj6 = obj8;
        obj7 = obj4;
        obj2 = obj1;
        ((Exception) (obj3)).printStackTrace();
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
            break MISSING_BLOCK_LABEL_789;
        }
        ((DataOutputStream) (obj)).flush();
        ((DataOutputStream) (obj)).close();
        if (obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((InputStreamReader) (obj4)).close();
        if (obj8 == null) goto _L16; else goto _L19
_L19:
        try
        {
            ((InputStreamReader) (obj8)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (!RootTools.debugMode) goto _L16; else goto _L20
_L20:
        RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
        ((Exception) (obj)).printStackTrace();
        return;
        obj1;
        obj3 = obj2;
        obj2 = obj7;
        obj = obj5;
_L24:
        if (obj3 != null)
        {
            try
            {
                ((Process) (obj3)).destroy();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj3) { }
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_876;
        }
        ((DataOutputStream) (obj)).flush();
        ((DataOutputStream) (obj)).close();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_884;
        }
        ((InputStreamReader) (obj2)).close();
        if (obj6 == null)
        {
            break MISSING_BLOCK_LABEL_894;
        }
        ((InputStreamReader) (obj6)).close();
_L22:
        throw obj1;
        obj;
        if (RootTools.debugMode)
        {
            RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
            ((Exception) (obj)).printStackTrace();
        }
        if (true) goto _L22; else goto _L21
_L21:
        obj;
        if (RootTools.debugMode)
        {
            RootTools.log((new StringBuilder("Error: ")).append(((Exception) (obj)).getMessage()).toString());
            ((Exception) (obj)).printStackTrace();
        }
_L7:
        return;
        obj4;
        obj6 = obj11;
        obj2 = obj13;
        obj3 = obj1;
        obj1 = obj4;
        continue; /* Loop/switch isn't completed */
        obj4;
        obj6 = obj11;
        obj3 = obj1;
        obj1 = obj4;
        continue; /* Loop/switch isn't completed */
        obj4;
        obj6 = obj3;
        obj3 = obj1;
        obj1 = obj4;
        if (true) goto _L24; else goto _L23
_L23:
        obj3;
        obj4 = obj10;
          goto _L25
        obj3;
        obj4 = obj2;
          goto _L25
        obj4;
        obj8 = obj3;
        obj3 = obj4;
        obj4 = obj2;
          goto _L25
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception = obj15;
        obj4 = obj9;
        obj2 = obj12;
        obj1 = obj3;
          goto _L26
        InterruptedException interruptedexception1;
        interruptedexception1;
        obj4 = obj9;
        interruptedexception1 = obj12;
          goto _L26
        InterruptedException interruptedexception2;
        interruptedexception2;
        obj4 = obj9;
          goto _L26
_L3:
        if (obj4 != null) goto _L28; else goto _L27
_L27:
        obj4 = obj5;
          goto _L18
    }

    private (String as[])
    {
        exit = -911;
        commands = as;
    }

    commands(String as[], commands commands1)
    {
        this(as);
    }
}
