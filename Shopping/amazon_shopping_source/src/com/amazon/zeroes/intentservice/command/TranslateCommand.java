// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.zeroes.intentservice.command;


// Referenced classes of package com.amazon.zeroes.intentservice.command:
//            ZeroesCommand

public class TranslateCommand
    implements ZeroesCommand
{
    public static interface Translator
    {

        public abstract Object translate(Object obj);
    }


    private final ZeroesCommand command;
    private final Translator translator;

    public TranslateCommand(ZeroesCommand zeroescommand, Translator translator1)
    {
        if (zeroescommand == null)
        {
            throw new NullPointerException("command must not be null");
        }
        if (translator1 == null)
        {
            throw new NullPointerException("translator must not be null");
        } else
        {
            command = zeroescommand;
            translator = translator1;
            return;
        }
    }

    public Object perform()
    {
        Object obj = command.perform();
        if (obj == null)
        {
            return null;
        } else
        {
            return translator.translate(obj);
        }
    }
}
