// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.d;

import com.google.a.a.c;
import com.target.mothership.common.registries.a;
import com.target.mothership.model.registries.interfaces.RegistryRecipient;
import com.target.mothership.util.o;
import com.target.ui.util.af;
import java.util.Iterator;
import java.util.List;

public class d
{
    private static class a
    {

        String coRegistrantName;
        String primaryRegistrantName;

        private a()
        {
        }

    }


    private static String a(String s, String s1)
    {
        if (!o.g(s) || !o.g(s1))
        {
            return "";
        } else
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append(s);
            stringbuilder.append(" ");
            stringbuilder.append(s1);
            return stringbuilder.toString();
        }
    }

    public static String a(List list)
    {
        list = b(list);
        return af.a(c.a(" & ").a().a(((a) (list)).primaryRegistrantName, ((a) (list)).coRegistrantName, new Object[0]));
    }

    private static a b(List list)
    {
        a a1 = new a();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            RegistryRecipient registryrecipient = (RegistryRecipient)list.next();
            if (registryrecipient.a().equals(com.target.mothership.common.registries.a.PRIMARY_REG))
            {
                a1.primaryRegistrantName = a(registryrecipient.b(), registryrecipient.c());
            } else
            if (registryrecipient.a().equals(com.target.mothership.common.registries.a.CO_REG))
            {
                a1.coRegistrantName = a(registryrecipient.b(), registryrecipient.c());
            }
        } while (true);
        return a1;
    }
}
