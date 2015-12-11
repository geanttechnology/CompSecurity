// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import java.util.Vector;

// Referenced classes of package org.cybergarage.upnp:
//            Argument

public class ArgumentList extends Vector
{

    public static final String ELEM_NAME = "argumentList";

    public ArgumentList()
    {
    }

    public Argument getArgument(int i)
    {
        return (Argument)get(i);
    }

    public Argument getArgument(String s)
    {
        int i;
        int j;
        j = size();
        i = 0;
_L2:
        Argument argument;
        String s1;
        if (i >= j)
        {
            return null;
        }
        argument = getArgument(i);
        s1 = argument.getName();
          goto _L1
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (s1 == null || !s1.equals(s)) goto _L4; else goto _L3
_L3:
        return argument;
    }

    public void set(ArgumentList argumentlist)
    {
        int j = argumentlist.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Argument argument = argumentlist.getArgument(i);
            Argument argument1 = getArgument(argument.getName());
            if (argument1 != null)
            {
                argument1.setValue(argument.getValue());
            }
            i++;
        } while (true);
    }

    public void setReqArgs(ArgumentList argumentlist)
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Argument argument = getArgument(i);
            if (argument.isInDirection())
            {
                String s = argument.getName();
                Argument argument1 = argumentlist.getArgument(s);
                if (argument1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("Argument \"")).append(s).append("\" missing.").toString());
                }
                argument.setValue(argument1.getValue());
            }
            i++;
        } while (true);
    }

    public void setResArgs(ArgumentList argumentlist)
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Argument argument = getArgument(i);
            if (argument.isOutDirection())
            {
                String s = argument.getName();
                Argument argument1 = argumentlist.getArgument(s);
                if (argument1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("Argument \"")).append(s).append("\" missing.").toString());
                }
                argument.setValue(argument1.getValue());
            }
            i++;
        } while (true);
    }
}
