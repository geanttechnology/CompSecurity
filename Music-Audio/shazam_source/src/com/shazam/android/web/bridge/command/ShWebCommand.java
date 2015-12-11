// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.shazam.android.ae.m;
import com.shazam.d.b;
import com.shazam.i.j.a;
import com.shazam.j.c;

// Referenced classes of package com.shazam.android.web.bridge.command:
//            ShWebCommandType

public class ShWebCommand
    implements b
{

    private static final com.shazam.j.a jsonMapper = a.b();
    private String data;
    private ShWebCommandType type;

    public ShWebCommand()
    {
    }

    public ShWebCommand(ShWebCommandType shwebcommandtype, String s)
    {
        type = shwebcommandtype;
        data = s;
    }

    public static ShWebCommand fromTypeAndData(ShWebCommandType shwebcommandtype, Object obj)
    {
        Object obj1 = null;
        String s = obj1;
        if (obj != null)
        {
            try
            {
                s = jsonMapper.a(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                m.a(com/shazam/android/web/bridge/command/ShWebCommand, "Could not interpret shweb data as json object", ((Throwable) (obj)));
                s = obj1;
            }
        }
        return fromTypeAndData(shwebcommandtype, s);
    }

    public static ShWebCommand fromTypeAndData(ShWebCommandType shwebcommandtype, String s)
    {
        return new ShWebCommand(shwebcommandtype, s);
    }

    public static int getNumberOfPriorities()
    {
        return ShWebCommandType.getNumberOfPriorities();
    }

    private Object parseData(Class class1)
    {
        if (data != null)
        {
            return jsonMapper.a(data, class1);
        } else
        {
            return null;
        }
    }

    public Object getData(Class class1)
    {
        Object obj;
        try
        {
            obj = parseData(class1);
        }
        catch (c c1)
        {
            class1.getName();
            return null;
        }
        return obj;
    }

    public int getPriority()
    {
        return type.getPriority();
    }

    public ShWebCommandType getType()
    {
        return type;
    }

    public boolean hasData()
    {
        return data != null;
    }

    public String toString()
    {
        return (new StringBuilder("ShWebCommand{type=")).append(type).append(", data=").append(data).append('}').toString();
    }

}
