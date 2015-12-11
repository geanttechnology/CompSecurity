// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.content;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.kernel.content:
//            EbayContext

public class ResultStatus
{
    public static interface Message
    {

        public abstract boolean displayToUser();

        public abstract String getCategory();

        public abstract String getDomain();

        public abstract int getId();

        public abstract String getLongMessage(EbayContext ebaycontext);

        public abstract String getRemediationUrl();

        public abstract Severity getSeverity();

        public abstract String getShortMessage(EbayContext ebaycontext);

        public abstract boolean isLongMessageHtml(EbayContext ebaycontext);
    }

    public static final class Severity extends Enum
    {

        private static final Severity $VALUES[];
        public static final Severity Error;
        public static final Severity PartialFailure;
        public static final Severity Warning;

        public static Severity valueOf(String s)
        {
            return (Severity)Enum.valueOf(com/ebay/nautilus/kernel/content/ResultStatus$Severity, s);
        }

        public static Severity[] values()
        {
            return (Severity[])$VALUES.clone();
        }

        static 
        {
            Warning = new Severity("Warning", 0);
            Error = new Severity("Error", 1);
            PartialFailure = new Severity("PartialFailure", 2);
            $VALUES = (new Severity[] {
                Warning, Error, PartialFailure
            });
        }

        private Severity(String s, int i)
        {
            super(s, i);
        }
    }


    public static final ResultStatus CANCELED = new ResultStatus() {

            
            {
                _messages = Collections.unmodifiableList(Collections.singletonList(new _cls1()));
            }
    };
    public static final ResultStatus SUCCESS = new ResultStatus() {

        public List initializeMessages()
        {
            this;
            JVM INSTR monitorenter ;
            throw new RuntimeException("SUCCESS never has errors!");
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

    };
    public static final ResultStatus UNKNOWN = new ResultStatus() {

            
            {
                _messages = Collections.unmodifiableList(Collections.singletonList(new _cls1()));
            }
    };
    private volatile boolean _canRetry;
    volatile List _messages;

    public ResultStatus()
    {
        _canRetry = false;
        _messages = null;
    }

    public static ResultStatus create(Collection collection)
    {
        if (collection == null || collection.isEmpty())
        {
            return SUCCESS;
        } else
        {
            ResultStatus resultstatus = new ResultStatus();
            resultstatus._messages = new ArrayList(collection);
            return resultstatus;
        }
    }

    public static transient ResultStatus create(Message amessage[])
    {
        if (amessage == null || amessage.length == 0)
        {
            return SUCCESS;
        } else
        {
            ArrayList arraylist = new ArrayList(amessage.length);
            Collections.addAll(arraylist, amessage);
            amessage = new ResultStatus();
            amessage._messages = arraylist;
            return amessage;
        }
    }

    public static String getSafeLongMessage(EbayContext ebaycontext, Message message)
    {
        String s1 = message.getLongMessage(ebaycontext);
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = message.getShortMessage(ebaycontext);
        }
        return s;
    }

    public static boolean isError(Severity severity)
    {
        return severity == Severity.Error || severity == Severity.PartialFailure;
    }

    public final boolean canRetry()
    {
        return _canRetry;
    }

    public final Message getFirstError()
    {
        Object obj = getMessages();
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Message message = (Message)((Iterator) (obj)).next();
                static class _cls4
                {

                    static final int $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[];

                    static 
                    {
                        $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity = new int[Severity.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[Severity.Error.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$kernel$content$ResultStatus$Severity[Severity.PartialFailure.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls4..SwitchMap.com.ebay.nautilus.kernel.content.ResultStatus.Severity[message.getSeverity().ordinal()])
                {
                case 1: // '\001'
                case 2: // '\002'
                    return message;
                }
            } while (true);
        }
        return null;
    }

    public final Message getFirstMessage()
    {
        List list = getMessages();
        if (list != null && !list.isEmpty())
        {
            return (Message)list.get(0);
        } else
        {
            return null;
        }
    }

    public final Message getFirstWarning()
    {
label0:
        {
            Object obj = getMessages();
            if (obj == null || ((List) (obj)).isEmpty())
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            Message message;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                message = (Message)((Iterator) (obj)).next();
            } while (message.getSeverity() != Severity.Warning);
            return message;
        }
        return null;
    }

    public final List getMessages()
    {
        return _messages;
    }

    public final boolean hasError()
    {
        return getFirstError() != null;
    }

    public final boolean hasMessage()
    {
        return getFirstMessage() != null;
    }

    public final boolean hasWarning()
    {
        return !hasError() && getFirstWarning() != null;
    }

    public List initializeMessages()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        if (_messages == null)
        {
            _messages = new ArrayList();
        }
        list = _messages;
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public final void setCanRetry(boolean flag)
    {
        _canRetry = flag;
    }

    public String toString()
    {
        Object obj = getMessages();
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return "Success";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("{ ");
        Message message;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append("{ ").append(message).append(" } "))
        {
            message = (Message)((Iterator) (obj)).next();
        }

        stringbuilder.append('}');
        return stringbuilder.toString();
    }


    // Unreferenced inner class com/ebay/nautilus/kernel/content/ResultStatus$2$1

/* anonymous class */
    class _cls1
        implements Message
    {

        final _cls2 this$0;

        public boolean displayToUser()
        {
            return false;
        }

        public String getCategory()
        {
            return null;
        }

        public String getDomain()
        {
            return null;
        }

        public int getId()
        {
            return -1;
        }

        public String getLongMessage(EbayContext ebaycontext)
        {
            return null;
        }

        public String getRemediationUrl()
        {
            return null;
        }

        public Severity getSeverity()
        {
            return Severity.Error;
        }

        public String getShortMessage(EbayContext ebaycontext)
        {
            return "Unknown error!";
        }

        public boolean isLongMessageHtml(EbayContext ebaycontext)
        {
            return false;
        }

        public String toString()
        {
            return "Unknown error!";
        }

            
            {
                this$0 = _cls2.this;
                super();
            }
    }


    // Unreferenced inner class com/ebay/nautilus/kernel/content/ResultStatus$3$1

/* anonymous class */
    class _cls1
        implements Message
    {

        final _cls3 this$0;

        public boolean displayToUser()
        {
            return false;
        }

        public String getCategory()
        {
            return null;
        }

        public String getDomain()
        {
            return null;
        }

        public int getId()
        {
            return -2;
        }

        public String getLongMessage(EbayContext ebaycontext)
        {
            return null;
        }

        public String getRemediationUrl()
        {
            return null;
        }

        public Severity getSeverity()
        {
            return Severity.Error;
        }

        public String getShortMessage(EbayContext ebaycontext)
        {
            return "A pending call was canceled.";
        }

        public boolean isLongMessageHtml(EbayContext ebaycontext)
        {
            return false;
        }

        public String toString()
        {
            return "A pending call was canceled.";
        }

            
            {
                this$0 = _cls3.this;
                super();
            }
    }

}
