// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import com.ebay.nautilus.domain.data.MessageFolder;
import java.text.Collator;
import java.util.Comparator;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesMasterFragment

private class collator
    implements Comparator
{

    private final Collator collator;
    final MessagesMasterFragment this$0;

    public int compare(MessageFolder messagefolder, MessageFolder messagefolder1)
    {
        if (!messagefolder.isInbox() || !messagefolder1.isInbox())
        {
            if (messagefolder.isInbox())
            {
                return -1;
            }
            if (messagefolder1.isInbox())
            {
                return 1;
            }
            if (!messagefolder.isSentFolder() || !messagefolder1.isSentFolder())
            {
                if (messagefolder.isSentFolder())
                {
                    return -1;
                }
                if (messagefolder1.isSentFolder())
                {
                    return 1;
                }
                if (!messagefolder.isArchiveFolder() || !messagefolder1.isArchiveFolder())
                {
                    if (messagefolder.isArchiveFolder())
                    {
                        return 1;
                    }
                    if (messagefolder1.isArchiveFolder())
                    {
                        return -1;
                    } else
                    {
                        return collator.compare(messagefolder.folderName, messagefolder1.folderName);
                    }
                }
            }
        }
        return 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((MessageFolder)obj, (MessageFolder)obj1);
    }

    public (Collator collator1)
    {
        this$0 = MessagesMasterFragment.this;
        super();
        collator = collator1;
        collator1.setStrength(0);
    }
}
