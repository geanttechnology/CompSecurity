// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import com.ebay.common.util.ImageCache;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesFilterType

public interface MessagesSync
{

    public abstract void clearDraft();

    public abstract List getAllFolders();

    public abstract List getAllMessages();

    public abstract MessageFolder getCurrentFolder();

    public abstract EbayMessage getCurrentMessage();

    public abstract MessagesFilterType getFilterType();

    public abstract List getFilteredMessages();

    public abstract ImageCache getImageCache();

    public abstract int getTabHeadersHeight();

    public abstract boolean isDetailPaneVisible();

    public abstract boolean isDraftInProgress();

    public abstract boolean isDualPane();

    public abstract boolean isMasterPaneVisible();

    public abstract void startDraft();
}
