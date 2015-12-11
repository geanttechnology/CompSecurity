.class public Lco/vine/android/provider/HybridPostCursor;
.super Lco/vine/android/provider/GroupCursor;
.source "HybridPostCursor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lco/vine/android/provider/GroupCursor",
        "<",
        "Lco/vine/android/api/VinePost;",
        ">;"
    }
.end annotation


# static fields
.field public static final EXTRA_INCLUDE_LIST:Ljava/lang/String; = "include_list"

.field public static final EXTRA_IS_LAST:Ljava/lang/String; = "is_last"

.field public static final EXTRA_POST:Ljava/lang/String; = "post"

.field public static final EXTRA_POSTS:Ljava/lang/String; = "extra_posts"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mIncludeList:Z


# direct methods
.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 48
    const/16 v0, 0x14

    invoke-direct {p0, p1, v0}, Lco/vine/android/provider/HybridPostCursor;-><init>(Landroid/database/Cursor;I)V

    .line 49
    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;I)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "limit"    # I

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lco/vine/android/provider/GroupCursor;-><init>(Landroid/database/Cursor;I)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/provider/HybridPostCursor;->mIncludeList:Z

    .line 53
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lco/vine/android/provider/HybridPostCursor;

    if-ne v0, v1, :cond_0

    .line 54
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Constructed HybridPostCursor with explore app. Use HybridPostCursorExplore."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 57
    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;I)V
    .locals 2
    .param p2, "limit"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 60
    .local p1, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lco/vine/android/provider/GroupCursor;-><init>(Landroid/database/Cursor;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/provider/HybridPostCursor;->mIncludeList:Z

    .line 61
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lco/vine/android/util/BuildUtil;->isExplore()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lco/vine/android/provider/HybridPostCursor;

    if-ne v0, v1, :cond_0

    .line 62
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Constructed HybridPostCursor with explore app. Use HybridPostCursorExplore."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_0
    iput-object p1, p0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    .line 67
    iput p2, p0, Lco/vine/android/provider/HybridPostCursor;->mLimit:I

    .line 68
    return-void
.end method

.method public static declared-synchronized mergePosts(Ljava/util/ArrayList;Ljava/util/ArrayList;Lco/vine/android/api/VineComparatorFactory$VineComparator;Z)Ljava/util/ArrayList;
    .locals 10
    .param p3, "enableTracking"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Lco/vine/android/api/VineComparatorFactory$VineComparator",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;Z)",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 211
    .local p0, "oldPosts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .local p1, "newPosts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .local p2, "comparator":Lco/vine/android/api/VineComparatorFactory$VineComparator;, "Lco/vine/android/api/VineComparatorFactory$VineComparator<Lco/vine/android/api/VinePost;>;"
    const-class v7, Lco/vine/android/provider/HybridPostCursor;

    monitor-enter v7

    if-eqz p0, :cond_0

    :try_start_0
    invoke-virtual {p0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 212
    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_1

    .line 213
    invoke-static {p1, p2}, Lco/vine/android/provider/HybridPostCursor;->sort(Ljava/util/ArrayList;Lco/vine/android/api/VineComparatorFactory$VineComparator;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object p0, p1

    .line 245
    .end local p0    # "oldPosts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    :goto_0
    monitor-exit v7

    return-object p0

    .line 216
    .restart local p0    # "oldPosts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    :cond_1
    const/4 p0, 0x0

    goto :goto_0

    .line 221
    :cond_2
    :try_start_1
    new-instance v1, Lco/vine/android/util/LongSparseArray;

    invoke-virtual {p0}, Ljava/util/ArrayList;->size()I

    move-result v6

    invoke-direct {v1, v6}, Lco/vine/android/util/LongSparseArray;-><init>(I)V

    .line 222
    .local v1, "existingPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .line 223
    .local v0, "count":I
    invoke-virtual {p0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/api/VinePost;

    .line 224
    .local v4, "post":Lco/vine/android/api/VinePost;
    iget-wide v8, v4, Lco/vine/android/api/VinePost;->postId:J

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1, v8, v9, v6}, Lco/vine/android/util/LongSparseArray;->put(JLjava/lang/Object;)V

    .line 225
    add-int/lit8 v0, v0, 0x1

    .line 226
    goto :goto_1

    .line 228
    .end local v4    # "post":Lco/vine/android/api/VinePost;
    :cond_3
    const/4 v0, 0x0

    .line 230
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VinePost;

    .line 231
    .local v3, "newPost":Lco/vine/android/api/VinePost;
    iget-wide v8, v3, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {v1, v8, v9}, Lco/vine/android/util/LongSparseArray;->get(J)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    .line 232
    .local v5, "updateThisPostIndex":Ljava/lang/Integer;
    if-eqz v5, :cond_4

    .line 233
    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-virtual {p0, v6, v3}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 211
    .end local v0    # "count":I
    .end local v1    # "existingPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Integer;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "newPost":Lco/vine/android/api/VinePost;
    .end local v5    # "updateThisPostIndex":Ljava/lang/Integer;
    :catchall_0
    move-exception v6

    monitor-exit v7

    throw v6

    .line 235
    .restart local v0    # "count":I
    .restart local v1    # "existingPosts":Lco/vine/android/util/LongSparseArray;, "Lco/vine/android/util/LongSparseArray<Ljava/lang/Integer;>;"
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "newPost":Lco/vine/android/api/VinePost;
    .restart local v5    # "updateThisPostIndex":Ljava/lang/Integer;
    :cond_4
    :try_start_2
    invoke-virtual {p0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 236
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 240
    .end local v3    # "newPost":Lco/vine/android/api/VinePost;
    .end local v5    # "updateThisPostIndex":Ljava/lang/Integer;
    :cond_5
    if-eqz p3, :cond_6

    .line 241
    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackGraphTimelineRefreshNewCount(I)V

    .line 244
    :cond_6
    invoke-static {p0, p2}, Lco/vine/android/provider/HybridPostCursor;->sort(Ljava/util/ArrayList;Lco/vine/android/api/VineComparatorFactory$VineComparator;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private static sort(Ljava/util/ArrayList;Lco/vine/android/api/VineComparatorFactory$VineComparator;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;",
            "Lco/vine/android/api/VineComparatorFactory$VineComparator",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 259
    .local p0, "posts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VinePost;>;"
    .local p1, "comparator":Lco/vine/android/api/VineComparatorFactory$VineComparator;, "Lco/vine/android/api/VineComparatorFactory$VineComparator<Lco/vine/android/api/VinePost;>;"
    if-nez p1, :cond_0

    .line 260
    const/4 v0, -0x1

    invoke-static {v0}, Lco/vine/android/api/VineComparatorFactory;->get(I)Lco/vine/android/api/VineComparatorFactory$VineComparator;

    move-result-object v0

    invoke-static {p0, v0}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 264
    :goto_0
    return-void

    .line 262
    :cond_0
    invoke-static {p0, p1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    goto :goto_0
.end method


# virtual methods
.method public getColumnIndexOrThrow(Ljava/lang/String;)I
    .locals 2
    .param p1, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 250
    sget-object v1, Lco/vine/android/provider/VineDatabaseSQL$PostCommentsLikesQuery;->LOOKUP:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 251
    .local v0, "columnIndex":I
    if-ltz v0, :cond_0

    .line 254
    .end local v0    # "columnIndex":I
    :goto_0
    return v0

    .restart local v0    # "columnIndex":I
    :cond_0
    invoke-super {p0, p1}, Lco/vine/android/provider/GroupCursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method

.method public getExtras()Landroid/os/Bundle;
    .locals 6

    .prologue
    .line 179
    :try_start_0
    invoke-super {p0}, Lco/vine/android/provider/GroupCursor;->getExtras()Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 184
    .local v3, "superExtras":Landroid/os/Bundle;
    :goto_0
    if-eqz v3, :cond_1

    .line 185
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1, v3}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 189
    .local v1, "extras":Landroid/os/Bundle;
    :goto_1
    iget-boolean v4, p0, Lco/vine/android/provider/HybridPostCursor;->mIncludeList:Z

    if-eqz v4, :cond_2

    .line 190
    const-string v5, "extra_posts"

    iget-object v4, p0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    check-cast v4, Ljava/util/ArrayList;

    invoke-virtual {v1, v5, v4}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 198
    :cond_0
    :goto_2
    return-object v1

    .line 180
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v3    # "superExtras":Landroid/os/Bundle;
    :catch_0
    move-exception v0

    .line 181
    .local v0, "e":Ljava/lang/NullPointerException;
    const/4 v3, 0x0

    .restart local v3    # "superExtras":Landroid/os/Bundle;
    goto :goto_0

    .line 187
    .end local v0    # "e":Ljava/lang/NullPointerException;
    :cond_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .restart local v1    # "extras":Landroid/os/Bundle;
    goto :goto_1

    .line 192
    :cond_2
    iget v4, p0, Lco/vine/android/provider/HybridPostCursor;->mCursorPosition:I

    invoke-virtual {p0, v4}, Lco/vine/android/provider/HybridPostCursor;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/api/VinePost;

    .line 193
    .local v2, "post":Lco/vine/android/api/VinePost;
    if-eqz v2, :cond_0

    .line 194
    const-string v4, "post"

    invoke-virtual {v1, v4, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 195
    const-string v4, "is_last"

    iget-boolean v5, v2, Lco/vine/android/api/VinePost;->isLast:Z

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    goto :goto_2
.end method

.method public markLast()V
    .locals 2

    .prologue
    .line 267
    iget-object v0, p0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    if-eqz v0, :cond_0

    .line 268
    iget-object v0, p0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    iget-object v1, p0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/api/VinePost;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lco/vine/android/api/VinePost;->isLast:Z

    .line 270
    :cond_0
    return-void
.end method

.method public onPrepare()V
    .locals 21

    .prologue
    .line 86
    move-object/from16 v0, p0

    iget-object v7, v0, Lco/vine/android/provider/HybridPostCursor;->mCursor:Landroid/database/Cursor;

    .line 92
    .local v7, "cursor":Landroid/database/Cursor;
    const/4 v4, 0x0

    .line 94
    .local v4, "count":I
    if-eqz v7, :cond_a

    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v17

    if-eqz v17, :cond_a

    .line 95
    const-wide/16 v13, 0x0

    .line 96
    .local v13, "postId":J
    const/16 v16, 0x0

    .line 97
    .local v16, "vinePost":Lco/vine/android/api/VinePost;
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    .line 99
    :cond_0
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    .line 102
    .local v5, "currentPostId":J
    cmp-long v17, v5, v13

    if-eqz v17, :cond_2

    .line 104
    if-eqz v16, :cond_1

    .line 105
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 106
    add-int/lit8 v4, v4, 0x1

    .line 108
    :cond_1
    move-wide v13, v5

    .line 109
    invoke-static {v7}, Lco/vine/android/api/VinePost;->from(Landroid/database/Cursor;)Lco/vine/android/api/VinePost;

    move-result-object v16

    .line 112
    :cond_2
    if-eqz v16, :cond_4

    .line 114
    const/16 v17, 0x22

    move/from16 v0, v17

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 115
    .local v2, "commentId":J
    const/16 v17, 0x1b

    move/from16 v0, v17

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    .line 116
    .local v10, "likeId":J
    const-wide/16 v17, 0x0

    cmp-long v17, v2, v17

    if-lez v17, :cond_7

    .line 117
    invoke-static {v7}, Lco/vine/android/api/VineComment;->from(Landroid/database/Cursor;)Lco/vine/android/api/VineComment;

    move-result-object v15

    .line 118
    .local v15, "vc":Lco/vine/android/api/VineComment;
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    if-nez v17, :cond_3

    .line 119
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    iput-object v0, v1, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 121
    :cond_3
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 131
    .end local v2    # "commentId":J
    .end local v10    # "likeId":J
    .end local v15    # "vc":Lco/vine/android/api/VineComment;
    :cond_4
    :goto_0
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v12

    .line 158
    .local v12, "moveToNext":Z
    :goto_1
    if-eqz v12, :cond_5

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/provider/HybridPostCursor;->mLimit:I

    move/from16 v17, v0

    move/from16 v0, v17

    if-lt v4, v0, :cond_0

    .line 159
    :cond_5
    if-eqz v16, :cond_6

    .line 160
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 165
    .end local v5    # "currentPostId":J
    .end local v12    # "moveToNext":Z
    .end local v13    # "postId":J
    .end local v16    # "vinePost":Lco/vine/android/api/VinePost;
    :cond_6
    :goto_2
    return-void

    .line 122
    .restart local v2    # "commentId":J
    .restart local v5    # "currentPostId":J
    .restart local v10    # "likeId":J
    .restart local v13    # "postId":J
    .restart local v16    # "vinePost":Lco/vine/android/api/VinePost;
    :cond_7
    const-wide/16 v17, 0x0

    cmp-long v17, v10, v17

    if-lez v17, :cond_4

    .line 123
    invoke-static {v7}, Lco/vine/android/api/VineLike;->from(Landroid/database/Cursor;)Lco/vine/android/api/VineLike;

    move-result-object v9

    .line 124
    .local v9, "like":Lco/vine/android/api/VineLike;
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    if-nez v17, :cond_8

    .line 125
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    iput-object v0, v1, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 127
    :cond_8
    move-object/from16 v0, v16

    iget-object v0, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v9}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 132
    .end local v2    # "commentId":J
    .end local v9    # "like":Lco/vine/android/api/VineLike;
    .end local v10    # "likeId":J
    :catch_0
    move-exception v8

    .line 148
    .local v8, "e":Ljava/lang/IllegalStateException;
    const-string v17, "Failed to get cursor\'s row id. total: {}, current: {}, limit: {}, postId: {}."

    const/16 v18, 0x4

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-interface {v7}, Landroid/database/Cursor;->getCount()I

    move-result v20

    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    aput-object v20, v18, v19

    const/16 v19, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    aput-object v20, v18, v19

    const/16 v19, 0x2

    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/provider/HybridPostCursor;->mLimit:I

    move/from16 v20, v0

    invoke-static/range {v20 .. v20}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v20

    aput-object v20, v18, v19

    const/16 v19, 0x3

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v20

    aput-object v20, v18, v19

    invoke-static/range {v17 .. v18}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 151
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/provider/HybridPostCursor;->mContext:Landroid/content/Context;

    move-object/from16 v17, v0

    if-eqz v17, :cond_9

    .line 152
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/provider/HybridPostCursor;->mContext:Landroid/content/Context;

    move-object/from16 v17, v0

    invoke-static/range {v17 .. v17}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lco/vine/android/client/AppController;->clearImageCacheFromMemory()V

    .line 155
    :cond_9
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 156
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z

    move-result v12

    .restart local v12    # "moveToNext":Z
    goto/16 :goto_1

    .line 163
    .end local v5    # "currentPostId":J
    .end local v8    # "e":Ljava/lang/IllegalStateException;
    .end local v12    # "moveToNext":Z
    .end local v13    # "postId":J
    .end local v16    # "vinePost":Lco/vine/android/api/VinePost;
    :cond_a
    const/16 v17, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/provider/HybridPostCursor;->mList:Ljava/util/List;

    goto/16 :goto_2
.end method

.method public prepare(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 79
    invoke-virtual {p0, p1}, Lco/vine/android/provider/HybridPostCursor;->setContext(Landroid/content/Context;)V

    .line 80
    invoke-super {p0}, Lco/vine/android/provider/GroupCursor;->prepare()V

    .line 81
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/provider/HybridPostCursor;->setContext(Landroid/content/Context;)V

    .line 82
    return-void
.end method

.method public respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 2
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 203
    const-string v0, "include_list"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lco/vine/android/provider/HybridPostCursor;->mIncludeList:Z

    .line 204
    return-object p1
.end method

.method public setContext(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    if-eqz p1, :cond_0

    .line 72
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/provider/HybridPostCursor;->mContext:Landroid/content/Context;

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/provider/HybridPostCursor;->mContext:Landroid/content/Context;

    goto :goto_0
.end method
