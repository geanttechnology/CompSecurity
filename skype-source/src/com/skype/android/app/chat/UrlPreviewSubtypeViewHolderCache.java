// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.skype.android.app.chat;


// Referenced classes of package com.skype.android.app.chat:
//            SubtypeViewHolder

public interface UrlPreviewSubtypeViewHolderCache
{

    public abstract SubtypeViewHolder getRecycled(UrlPreviewTextMessageViewHolder.MessageSubType messagesubtype);

    public abstract void putRecycled(UrlPreviewTextMessageViewHolder.MessageSubType messagesubtype, SubtypeViewHolder subtypeviewholder);
}
