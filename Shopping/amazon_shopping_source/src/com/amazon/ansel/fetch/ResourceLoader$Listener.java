// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import com.amazon.ansel.fetch.tools.ref.ObjectReference;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.ansel.fetch:
//            ResourceLoader, LoaderContext, ResourceListener, LoaderListener

private class <init> extends ner
{

    final ResourceLoader this$0;

    public void done()
    {
        if (ResourceLoader.access$400(ResourceLoader.this) != 1)
        {
            return;
        }
        ResourceLoader.access$500(ResourceLoader.this, "Done");
        synchronized (ResourceLoader.access$600(ResourceLoader.this))
        {
            if (ResourceLoader.access$400(ResourceLoader.this) == 1)
            {
                break MISSING_BLOCK_LABEL_50;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        ResourceLoader.access$402(ResourceLoader.this, 2);
        obj;
        JVM INSTR monitorexit ;
        ResourceLoader.access$700(ResourceLoader.this);
        return;
    }

    public void error(final Throwable error)
    {
        if (ResourceLoader.access$400(ResourceLoader.this) != 1)
        {
            return;
        } else
        {
            ResourceLoader.access$500(ResourceLoader.this, (new StringBuilder()).append("Error: ").append(error.getMessage()).toString());
            ResourceLoader.access$200(ResourceLoader.this).executeCallback(new Runnable() {

                final ResourceLoader.Listener this$1;
                final Throwable val$error;

                public void run()
                {
                    Object obj = getResourceListener();
                    if (obj != null)
                    {
                        ((ResourceListener) (obj)).error(error);
                    }
                    obj = ResourceLoader.access$300(this$0).iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
                        if (loaderlistener != null)
                        {
                            loaderlistener.error(error);
                        }
                    } while (true);
                }

            
            {
                this$1 = ResourceLoader.Listener.this;
                error = throwable;
                super();
            }
            });
            return;
        }
    }

    public void result(final Object result)
    {
        if (ResourceLoader.access$400(ResourceLoader.this) != 1)
        {
            return;
        } else
        {
            ResourceLoader.access$500(ResourceLoader.this, "Sending result");
            ResourceLoader.access$200(ResourceLoader.this).executeCallback(new Runnable() {

                final ResourceLoader.Listener this$1;
                final Object val$result;

                public void run()
                {
                    ResourceListener resourcelistener = getResourceListener();
                    if (resourcelistener == null)
                    {
                        ResourceLoader.access$500(this$0, "Result listener reference is stale");
                        return;
                    } else
                    {
                        ResourceLoader.access$200(this$0).addReference(getResourceKey(), ResourceLoader.access$100(this$0));
                        ResourceLoader.access$500(this$0, "Invoking result callback");
                        resourcelistener.result(result);
                        return;
                    }
                }

            
            {
                this$1 = ResourceLoader.Listener.this;
                result = obj;
                super();
            }
            });
            return;
        }
    }

    private _cls2.val.error()
    {
        this$0 = ResourceLoader.this;
        super();
    }

    ner(ner ner)
    {
        this();
    }
}
