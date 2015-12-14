// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.adapters.comment;

import my.googlemusic.play.model.Comment;
import my.googlemusic.play.model.User;

public interface CommentsClickListener
{

    public abstract void onProfileClick(User user);

    public abstract void onReplyClick(Comment comment);
}
