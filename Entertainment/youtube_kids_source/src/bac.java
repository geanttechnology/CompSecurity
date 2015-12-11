// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.io.IOException;

public final class bac extends azd
{

    private bac(Context context, bbb bbb1, bbc bbc1)
    {
        super(context, bbb1, bbc1);
    }

    public static bac a(String s, Context context)
    {
        bbb bbb1 = new bbb();
        a(s, context, bbb1);
        return new bac(context, bbb1, new bbc(239));
    }

    private bad d(Context context)
    {
        atu atu1;
label0:
        {
            int i = 0;
            byte abyte0[];
            int j;
            try
            {
                atu1 = att.a(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new IOException(context);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new IOException(context);
            }
            context = atu1.a();
            if (context == null || !context.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$"))
            {
                break label0;
            }
            abyte0 = new byte[16];
            j = 0;
            int k;
            for (; i < context.length(); i = k + 2)
            {
label1:
                {
                    if (i != 8 && i != 13 && i != 18)
                    {
                        k = i;
                        if (i != 23)
                        {
                            break label1;
                        }
                    }
                    k = i + 1;
                }
                abyte0[j] = (byte)((Character.digit(context.charAt(k), 16) << 4) + Character.digit(context.charAt(k + 1), 16));
                j++;
            }

            context = b.a(abyte0, true);
        }
        return new bad(this, context, atu1.b());
    }

    protected final void b(Context context)
    {
        super.b(context);
        Object obj = d(context);
        long l;
        if (((bad) (obj)).b)
        {
            l = 1L;
        } else
        {
            l = 0L;
        }
        a(28, l);
        obj = ((bad) (obj)).a;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        a(26, 5L);
        a(24, ((String) (obj)));
        return;
        avu avu1;
        avu1;
        try
        {
            a(24, c(context));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
