// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageFoldersDataManager

public static interface 
{

    public abstract void onMessageFoldersDataChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content);

    public abstract void onMessageFoldersListChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content);
}
