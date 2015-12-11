// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.widget.ImageView;
import android.widget.TextView;
import co.vine.android.util.image.ImageKey;

public class CommentViewHolder
{

    String commentId;
    TextView content;
    ImageKey imageKey;
    ImageView profileImage;
    TextView timestamp;
    long userId;

    public CommentViewHolder()
    {
    }
}
