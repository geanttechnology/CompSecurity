// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;

import com.amazon.zeroes.intentservice.Metrics;
import com.amazon.zeroes.intentservice.utils.ZeroesMeasurementUtils;

// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            ZeroesCommand

public class RetryCommand
    implements ZeroesCommand
{
    public static interface Validator
    {

        public abstract boolean validate(Object obj);
    }


    private final ZeroesCommand command;
    private final int retryCount;
    private final Validator validator;

    public RetryCommand(int i, ZeroesCommand zeroescommand, Validator validator1)
    {
        if (zeroescommand == null)
        {
            throw new NullPointerException("command must not be null");
        }
        if (validator1 == null)
        {
            throw new NullPointerException("validator must not be null");
        }
        command = zeroescommand;
        validator = validator1;
        if (i < 0)
        {
            retryCount = 5;
            return;
        } else
        {
            retryCount = i;
            return;
        }
    }

    public Object perform()
    {
        Object obj = null;
        int i = 0;
        do
        {
            if (i > 0)
            {
                double d = i;
                try
                {
                    Thread.sleep((long)(500D * Math.pow(d, 1.5D)));
                }
                catch (InterruptedException interruptedexception)
                {
                    Metrics.putMeasurement(ZeroesMeasurementUtils.fromThrowable(interruptedexception));
                    return obj;
                }
            }
            obj = command.perform();
            if (obj == null || !validator.validate(obj))
            {
                if (i >= retryCount)
                {
                    return obj;
                }
            } else
            {
                return obj;
            }
            i++;
        } while (true);
    }
}
