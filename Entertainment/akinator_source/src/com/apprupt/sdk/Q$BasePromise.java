// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            Q

private class <init>
    implements <init>
{

    private Throwable error;
    private Object result;
    private final l task;
    final Q this$0;

    public Throwable getError()
    {
        return error;
    }

    public Object getResult()
    {
        return result;
    }

    public boolean isError()
    {
        return error != null;
    }

    public void resolve(Throwable throwable, Object obj, error error1)
    {
        error error2 = Q.access$000(Q.this);
        String s;
        if (throwable == null)
        {
            s = "[OK]";
        } else
        {
            s = "[E]";
        }
        error2._mth0(throwable, new Object[] {
            "Promise resolve", s, obj
        });
        if (throwable != null)
        {
            error = throwable;
        } else
        {
            Object obj1 = obj;
            if (obj != null)
            {
                throwable = ((Throwable) (obj));
                if (obj instanceof error)
                {
                    throwable = new <init>((<init>)obj);
                }
                obj1 = throwable;
                if (throwable instanceof <init>)
                {
                    ((<init>)throwable).<init>(result, error1);
                    return;
                }
            }
            result = obj1;
        }
        error1.omplete(this);
    }

    public void run(Object obj, omplete omplete)
    {
        omplete = new (Q.this, this, omplete, null);
        try
        {
            task.task(obj, omplete);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            omplete.l(((Throwable) (obj)));
        }
    }

    private ( )
    {
        this$0 = Q.this;
        super();
        error = null;
        result = null;
        task = ;
    }

    task(task task1, task task2)
    {
        this(task1);
    }
}
