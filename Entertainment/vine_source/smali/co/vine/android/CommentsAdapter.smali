.class public Lco/vine/android/CommentsAdapter;
.super Landroid/widget/BaseAdapter;
.source "CommentsAdapter.java"


# static fields
.field private static final SPAN_FLAGS:I = 0x21


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

.field private mCommentSbs:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/text/Editable;",
            ">;"
        }
    .end annotation
.end field

.field private mComments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;

.field private mIdToPositionMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field final mListener:Lco/vine/android/widget/SpanClickListener;

.field final mViewHolders:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/CommentViewHolder;",
            ">;>;"
        }
    .end annotation
.end field

.field private mVineGreen:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Lco/vine/android/client/AppController;Lco/vine/android/widget/SpanClickListener;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appController"    # Lco/vine/android/client/AppController;
    .param p3, "listener"    # Lco/vine/android/widget/SpanClickListener;

    .prologue
    .line 65
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    .line 60
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/CommentsAdapter;->mViewHolders:Ljava/util/ArrayList;

    .line 61
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/CommentsAdapter;->mCommentSbs:Ljava/util/HashMap;

    .line 66
    iput-object p1, p0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    .line 67
    new-instance v0, Lco/vine/android/widget/TypefacesSpan;

    const/4 v1, 0x0

    invoke-static {p1}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x3

    invoke-virtual {v2, v3, v4}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lco/vine/android/widget/TypefacesSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    iput-object v0, p0, Lco/vine/android/CommentsAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    .line 69
    iput-object p2, p0, Lco/vine/android/CommentsAdapter;->mAppController:Lco/vine/android/client/AppController;

    .line 70
    iput-object p3, p0, Lco/vine/android/CommentsAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    .line 71
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090096

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/CommentsAdapter;->mVineGreen:I

    .line 72
    return-void
.end method

.method private rebuildIdToPositionMap()V
    .locals 5

    .prologue
    .line 228
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 230
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 231
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineComment;

    .line 232
    .local v0, "comment":Lco/vine/android/api/VineComment;
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    iget-wide v3, v0, Lco/vine/android/api/VineComment;->commentId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 230
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 235
    .end local v0    # "comment":Lco/vine/android/api/VineComment;
    :cond_0
    return-void
.end method


# virtual methods
.method public addMyComment(Lco/vine/android/api/VineComment;)V
    .locals 1
    .param p1, "commentToMerge"    # Lco/vine/android/api/VineComment;

    .prologue
    .line 238
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 239
    invoke-direct {p0}, Lco/vine/android/CommentsAdapter;->rebuildIdToPositionMap()V

    .line 240
    invoke-virtual {p0}, Lco/vine/android/CommentsAdapter;->notifyDataSetChanged()V

    .line 241
    return-void
.end method

.method public bindView(Landroid/view/View;Lco/vine/android/api/VineComment;)V
    .locals 22
    .param p1, "view"    # Landroid/view/View;
    .param p2, "comment"    # Lco/vine/android/api/VineComment;

    .prologue
    .line 88
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/CommentViewHolder;

    .line 89
    .local v9, "h":Lco/vine/android/CommentViewHolder;
    move-object/from16 v0, p2

    iget-object v15, v0, Lco/vine/android/api/VineComment;->username:Ljava/lang/String;

    .line 90
    .local v15, "username":Ljava/lang/String;
    move-object/from16 v0, p2

    iget-object v5, v0, Lco/vine/android/api/VineComment;->comment:Ljava/lang/String;

    .line 92
    .local v5, "commentString":Ljava/lang/String;
    move-object/from16 v0, p2

    iget-object v7, v0, Lco/vine/android/api/VineComment;->entities:Ljava/util/ArrayList;

    .line 94
    .local v7, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    if-nez v15, :cond_0

    .line 95
    const-string v15, ""

    .line 96
    new-instance v17, Lco/vine/android/VineLoggingException;

    invoke-direct/range {v17 .. v17}, Lco/vine/android/VineLoggingException;-><init>()V

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Username is null for "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, p2

    iget-wide v0, v0, Lco/vine/android/api/VineComment;->commentId:J

    move-wide/from16 v19, v0

    invoke-virtual/range {v18 .. v20}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    const/16 v19, 0x0

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    invoke-static/range {v17 .. v19}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 100
    :cond_0
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->content:Landroid/widget/TextView;

    move-object/from16 v17, v0

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 102
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->timestamp:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v18, v0

    move-object/from16 v0, p2

    iget-wide v0, v0, Lco/vine/android/api/VineComment;->timestamp:J

    move-wide/from16 v19, v0

    const/16 v21, 0x0

    invoke-static/range {v18 .. v21}, Lco/vine/android/util/Util;->getRelativeTimeString(Landroid/content/Context;JZ)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 104
    move-object/from16 v0, p2

    iget-wide v0, v0, Lco/vine/android/api/VineComment;->commentId:J

    move-wide/from16 v17, v0

    invoke-static/range {v17 .. v18}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    iput-object v0, v9, Lco/vine/android/CommentViewHolder;->commentId:Ljava/lang/String;

    .line 105
    move-object/from16 v0, p2

    iget-wide v0, v0, Lco/vine/android/api/VineComment;->userId:J

    move-wide/from16 v17, v0

    move-wide/from16 v0, v17

    iput-wide v0, v9, Lco/vine/android/CommentViewHolder;->userId:J

    .line 107
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mCommentSbs:Ljava/util/HashMap;

    move-object/from16 v17, v0

    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->commentId:Ljava/lang/String;

    move-object/from16 v18, v0

    invoke-virtual/range {v17 .. v18}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/text/Editable;

    .line 109
    .local v4, "commentSb":Landroid/text/Editable;
    if-nez v4, :cond_2

    .line 110
    new-instance v17, Landroid/text/SpannableStringBuilder;

    move-object/from16 v0, v17

    invoke-direct {v0, v15}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    const-string v18, " "

    invoke-virtual/range {v17 .. v18}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    .line 111
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mCommentSbs:Ljava/util/HashMap;

    move-object/from16 v17, v0

    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->commentId:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v0, v1, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mBoldSpan:Lco/vine/android/widget/TypefacesSpan;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v19

    const/16 v20, 0x21

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-static {v4, v0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 115
    new-instance v13, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v17, 0x1

    iget-wide v0, v9, Lco/vine/android/CommentViewHolder;->userId:J

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v19, v0

    move/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v19

    invoke-direct {v13, v0, v1, v2}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 118
    .local v13, "styledClickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/CommentsAdapter;->mVineGreen:I

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-virtual {v13, v0}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 119
    const/16 v17, 0x0

    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v18

    const/16 v19, 0x21

    move/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v4, v13, v0, v1, v2}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V

    .line 122
    if-eqz v7, :cond_2

    .line 124
    :try_start_0
    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v17

    add-int/lit8 v17, v17, 0x1

    const/16 v18, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-static {v7, v4, v0, v1}, Lco/vine/android/util/Util;->adjustEntities(Ljava/util/ArrayList;Landroid/text/Editable;IZ)V

    .line 125
    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v17

    if-eqz v17, :cond_2

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lco/vine/android/api/VineEntity;

    .line 126
    .local v8, "entity":Lco/vine/android/api/VineEntity;
    invoke-virtual {v8}, Lco/vine/android/api/VineEntity;->isUserType()Z

    move-result v17

    if-eqz v17, :cond_3

    .line 127
    new-instance v16, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v17, 0x1

    iget-wide v0, v8, Lco/vine/android/api/VineEntity;->id:J

    move-wide/from16 v18, v0

    invoke-static/range {v18 .. v19}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v19, v0

    invoke-direct/range {v16 .. v19}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 130
    .local v16, "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/CommentsAdapter;->mVineGreen:I

    move/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 131
    iget v0, v8, Lco/vine/android/api/VineEntity;->start:I

    move/from16 v17, v0

    iget v0, v8, Lco/vine/android/api/VineEntity;->end:I

    move/from16 v18, v0

    const/16 v19, 0x21

    move-object/from16 v0, v16

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-static {v4, v0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 140
    .end local v8    # "entity":Lco/vine/android/api/VineEntity;
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v16    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    :catch_0
    move-exception v6

    .line 141
    .local v6, "e":Ljava/lang/IndexOutOfBoundsException;
    invoke-static {v6}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 146
    .end local v6    # "e":Ljava/lang/IndexOutOfBoundsException;
    .end local v13    # "styledClickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    :cond_2
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->content:Landroid/widget/TextView;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 148
    move-object/from16 v0, p2

    iget-object v14, v0, Lco/vine/android/api/VineComment;->avatarUrl:Ljava/lang/String;

    .line 149
    .local v14, "url":Ljava/lang/String;
    invoke-static {v14}, Lco/vine/android/util/Util;->isDefaultAvatarUrl(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_4

    .line 150
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    sget-object v18, Lco/vine/android/util/Util$ProfileImageSize;->MEDIUM:Lco/vine/android/util/Util$ProfileImageSize;

    const/high16 v19, -0x1000000

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/CommentsAdapter;->mVineGreen:I

    move/from16 v20, v0

    or-int v19, v19, v20

    invoke-static/range {v17 .. v19}, Lco/vine/android/util/Util;->safeSetDefaultAvatar(Landroid/widget/ImageView;Lco/vine/android/util/Util$ProfileImageSize;I)V

    .line 151
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 164
    :goto_1
    return-void

    .line 132
    .end local v14    # "url":Ljava/lang/String;
    .restart local v8    # "entity":Lco/vine/android/api/VineEntity;
    .restart local v10    # "i$":Ljava/util/Iterator;
    .restart local v13    # "styledClickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    :cond_3
    :try_start_1
    invoke-virtual {v8}, Lco/vine/android/api/VineEntity;->isTagType()Z

    move-result v17

    if-eqz v17, :cond_1

    .line 133
    new-instance v16, Lco/vine/android/widget/StyledClickableSpan;

    const/16 v17, 0x3

    iget-object v0, v8, Lco/vine/android/api/VineEntity;->title:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mListener:Lco/vine/android/widget/SpanClickListener;

    move-object/from16 v19, v0

    invoke-direct/range {v16 .. v19}, Lco/vine/android/widget/StyledClickableSpan;-><init>(ILjava/lang/Object;Lco/vine/android/widget/SpanClickListener;)V

    .line 136
    .restart local v16    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/CommentsAdapter;->mVineGreen:I

    move/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Lco/vine/android/widget/StyledClickableSpan;->setColor(I)V

    .line 137
    iget v0, v8, Lco/vine/android/api/VineEntity;->start:I

    move/from16 v17, v0

    iget v0, v8, Lco/vine/android/api/VineEntity;->end:I

    move/from16 v18, v0

    const/16 v19, 0x21

    move-object/from16 v0, v16

    move/from16 v1, v17

    move/from16 v2, v18

    move/from16 v3, v19

    invoke-static {v4, v0, v1, v2, v3}, Lco/vine/android/util/Util;->safeSetSpan(Landroid/text/Spannable;Ljava/lang/Object;III)V
    :try_end_1
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 153
    .end local v8    # "entity":Lco/vine/android/api/VineEntity;
    .end local v10    # "i$":Ljava/util/Iterator;
    .end local v13    # "styledClickableSpan":Lco/vine/android/widget/StyledClickableSpan;
    .end local v16    # "usernameSpan":Lco/vine/android/widget/StyledClickableSpan;
    .restart local v14    # "url":Ljava/lang/String;
    :cond_4
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 154
    new-instance v11, Lco/vine/android/util/image/ImageKey;

    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-direct {v11, v14, v0}, Lco/vine/android/util/image/ImageKey;-><init>(Ljava/lang/String;Z)V

    .line 155
    .local v11, "key":Lco/vine/android/util/image/ImageKey;
    iput-object v11, v9, Lco/vine/android/CommentViewHolder;->imageKey:Lco/vine/android/util/image/ImageKey;

    .line 156
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mAppController:Lco/vine/android/client/AppController;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v11}, Lco/vine/android/client/AppController;->getPhotoBitmap(Lco/vine/android/util/image/ImageKey;)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 157
    .local v12, "profileImage":Landroid/graphics/Bitmap;
    if-eqz v12, :cond_5

    .line 158
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    new-instance v18, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v19

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v12}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 160
    :cond_5
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f0200f7

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v18

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 161
    iget-object v0, v9, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    invoke-virtual/range {v17 .. v18}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_1
.end method

.method public deleteComment(J)V
    .locals 2
    .param p1, "commentId"    # J

    .prologue
    .line 244
    invoke-virtual {p0, p1, p2}, Lco/vine/android/CommentsAdapter;->getPositionForId(J)I

    move-result v0

    .line 245
    .local v0, "position":I
    iget-object v1, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 246
    invoke-direct {p0}, Lco/vine/android/CommentsAdapter;->rebuildIdToPositionMap()V

    .line 247
    invoke-virtual {p0}, Lco/vine/android/CommentsAdapter;->notifyDataSetChanged()V

    .line 248
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 193
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "pos"    # I

    .prologue
    .line 198
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineComment;

    iget-wide v0, v0, Lco/vine/android/api/VineComment;->commentId:J

    return-wide v0
.end method

.method public getPositionForId(J)I
    .locals 2
    .param p1, "id"    # J

    .prologue
    .line 212
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 213
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mIdToPositionMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 215
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 204
    if-nez p2, :cond_0

    .line 205
    invoke-virtual {p0}, Lco/vine/android/CommentsAdapter;->newView()Landroid/view/View;

    move-result-object p2

    .line 207
    :cond_0
    invoke-virtual {p0, p1}, Lco/vine/android/CommentsAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VineComment;

    invoke-virtual {p0, p2, v0}, Lco/vine/android/CommentsAdapter;->bindView(Landroid/view/View;Lco/vine/android/api/VineComment;)V

    .line 208
    return-object p2
.end method

.method public mergeComments(Ljava/util/ArrayList;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 221
    .local p1, "comments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineComment;>;"
    iget-object v0, p0, Lco/vine/android/CommentsAdapter;->mComments:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1, p1}, Ljava/util/ArrayList;->addAll(ILjava/util/Collection;)Z

    .line 223
    invoke-direct {p0}, Lco/vine/android/CommentsAdapter;->rebuildIdToPositionMap()V

    .line 224
    invoke-virtual {p0}, Lco/vine/android/CommentsAdapter;->notifyDataSetChanged()V

    .line 225
    return-void
.end method

.method public newView()Landroid/view/View;
    .locals 6

    .prologue
    .line 75
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f030025

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 77
    .local v1, "layout":Landroid/widget/RelativeLayout;
    new-instance v0, Lco/vine/android/CommentViewHolder;

    invoke-direct {v0}, Lco/vine/android/CommentViewHolder;-><init>()V

    .line 78
    .local v0, "h":Lco/vine/android/CommentViewHolder;
    const v2, 0x7f0a007a

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    iput-object v2, v0, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    .line 79
    const v2, 0x7f0a0061

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v0, Lco/vine/android/CommentViewHolder;->content:Landroid/widget/TextView;

    .line 80
    iget-object v2, v0, Lco/vine/android/CommentViewHolder;->content:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 81
    const v2, 0x7f0a007b

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v0, Lco/vine/android/CommentViewHolder;->timestamp:Landroid/widget/TextView;

    .line 82
    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 83
    iget-object v2, p0, Lco/vine/android/CommentsAdapter;->mViewHolders:Ljava/util/ArrayList;

    new-instance v3, Ljava/lang/ref/WeakReference;

    invoke-direct {v3, v0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 84
    return-object v1
.end method

.method public updateProfileImages(Ljava/util/HashMap;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 167
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 169
    .local v3, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/ref/WeakReference<Lco/vine/android/CommentViewHolder;>;>;"
    iget-object v6, p0, Lco/vine/android/CommentsAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    add-int/lit8 v0, v6, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_2

    .line 170
    iget-object v6, p0, Lco/vine/android/CommentsAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/ref/WeakReference;

    .line 171
    .local v5, "wf":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/CommentViewHolder;>;"
    invoke-virtual {v5}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/CommentViewHolder;

    .line 172
    .local v4, "vh":Lco/vine/android/CommentViewHolder;
    if-nez v4, :cond_1

    .line 173
    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 169
    :cond_0
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 174
    :cond_1
    iget-object v6, v4, Lco/vine/android/CommentViewHolder;->imageKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v6, :cond_0

    .line 175
    iget-object v6, v4, Lco/vine/android/CommentViewHolder;->imageKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/image/UrlImage;

    .line 176
    .local v2, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v2, :cond_0

    .line 177
    iget-object v6, v4, Lco/vine/android/CommentViewHolder;->profileImage:Landroid/widget/ImageView;

    new-instance v7, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v8, p0, Lco/vine/android/CommentsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    iget-object v9, v2, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v7, v8, v9}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 181
    .end local v2    # "image":Lco/vine/android/util/image/UrlImage;
    .end local v4    # "vh":Lco/vine/android/CommentViewHolder;
    .end local v5    # "wf":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/CommentViewHolder;>;"
    :cond_2
    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/ref/WeakReference;

    .line 182
    .restart local v5    # "wf":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/CommentViewHolder;>;"
    iget-object v6, p0, Lco/vine/android/CommentsAdapter;->mViewHolders:Ljava/util/ArrayList;

    invoke-virtual {v6, v5}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 184
    .end local v5    # "wf":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/CommentViewHolder;>;"
    :cond_3
    return-void
.end method
