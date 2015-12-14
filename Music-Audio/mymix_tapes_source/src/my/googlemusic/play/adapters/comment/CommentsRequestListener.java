// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.comment;

import my.googlemusic.play.model.Comment;

public interface CommentsRequestListener
{

    public abstract void onFailedRequest(Comment comment);

    public abstract void onPrepareRequest(Comment comment);

    public abstract void onSuccessRequest(Comment comment);
}
