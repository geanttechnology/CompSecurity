// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;

import java.io.IOException;
import java.lang.reflect.Field;
import org.msgpack.AbstractTemplate;
import org.msgpack.MessageTypeException;
import org.msgpack.Packer;

// Referenced classes of package org.msgpack.template:
//            ReflectionTemplateBuilder

static class minimumArrayLength extends AbstractTemplate
{

    protected y entries[];
    protected int minimumArrayLength;
    protected Class targetClass;

    public void pack(Packer packer, Object obj)
        throws IOException
    {
        int i;
        y ay[];
        y y;
        Object obj1;
        int j;
        try
        {
            packer.packArray(entries.length);
            ay = entries;
            j = ay.length;
        }
        // Misplaced declaration of an exception variable
        catch (Packer packer)
        {
            throw packer;
        }
        // Misplaced declaration of an exception variable
        catch (Packer packer)
        {
            throw packer;
        }
        // Misplaced declaration of an exception variable
        catch (Packer packer)
        {
            throw new MessageTypeException(packer);
        }
        i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        y = ay[i];
        if (!y.isAvailable())
        {
            packer.packNil();
            break MISSING_BLOCK_LABEL_127;
        }
        obj1 = y.getField().get(obj);
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        if (!y.isNullable() && !y.isOptional())
        {
            throw new MessageTypeException();
        }
        packer.packNil();
        break MISSING_BLOCK_LABEL_127;
        y.pack(obj1, packer);
        break MISSING_BLOCK_LABEL_127;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    y(Class class1, y ay[])
    {
        targetClass = class1;
        entries = ay;
        minimumArrayLength = 0;
        for (int i = 0; i < ay.length; i++)
        {
            class1 = ay[i];
            if (class1.isRequired() || class1.isNullable())
            {
                minimumArrayLength = i + 1;
            }
        }

    }
}
