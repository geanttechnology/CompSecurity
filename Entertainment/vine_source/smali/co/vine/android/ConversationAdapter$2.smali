.class Lco/vine/android/ConversationAdapter$2;
.super Ljava/lang/Object;
.source "ConversationAdapter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ConversationAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationAdapter;


# direct methods
.method constructor <init>(Lco/vine/android/ConversationAdapter;)V
    .locals 0

    .prologue
    .line 857
    iput-object p1, p0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized run()V
    .locals 17

    .prologue
    .line 860
    monitor-enter p0

    :try_start_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mListView:Landroid/widget/ListView;
    invoke-static {v13}, Lco/vine/android/ConversationAdapter;->access$100(Lco/vine/android/ConversationAdapter;)Landroid/widget/ListView;

    move-result-object v8

    .line 861
    .local v8, "listView":Landroid/widget/ListView;
    invoke-virtual {v8}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v2

    .line 862
    .local v2, "currentFirst":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;
    invoke-static {v13}, Lco/vine/android/ConversationAdapter;->access$200(Lco/vine/android/ConversationAdapter;)Landroid/util/SparseArray;

    move-result-object v13

    invoke-virtual {v13, v2}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lco/vine/android/api/VinePrivateMessage;

    .line 863
    .local v9, "msg":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v9, :cond_5

    iget-boolean v13, v9, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    if-eqz v13, :cond_5

    const/4 v3, 0x1

    .line 864
    .local v3, "currentHasVideo":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # invokes: Lco/vine/android/ConversationAdapter;->getViewAt(I)Landroid/view/View;
    invoke-static {v13, v2}, Lco/vine/android/ConversationAdapter;->access$300(Lco/vine/android/ConversationAdapter;I)Landroid/view/View;

    move-result-object v5

    .line 865
    .local v5, "currentView":Landroid/view/View;
    const/high16 v12, -0x40800000    # -1.0f

    .line 866
    .local v12, "ratio":F
    if-eqz v5, :cond_1

    .line 867
    const/4 v6, 0x0

    .line 868
    .local v6, "currentlyPlayingOffset":I
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v13}, Lco/vine/android/ConversationAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v13

    if-eqz v13, :cond_0

    .line 869
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v13}, Lco/vine/android/ConversationAdapter;->getLastPlayer()Lco/vine/android/player/SdkVideoView;

    move-result-object v13

    invoke-virtual {v13}, Lco/vine/android/player/SdkVideoView;->getHeight()I

    move-result v13

    div-int/lit8 v6, v13, 0x2

    .line 871
    :cond_0
    invoke-virtual {v5}, Landroid/view/View;->getBottom()I

    move-result v13

    int-to-float v13, v13

    int-to-float v14, v6

    add-float v1, v13, v14

    .line 872
    .local v1, "bottom":F
    invoke-virtual {v5}, Landroid/view/View;->getHeight()I

    move-result v13

    int-to-float v13, v13

    int-to-float v14, v6

    add-float v7, v13, v14

    .line 873
    .local v7, "height":F
    div-float v12, v1, v7

    .line 875
    .end local v1    # "bottom":F
    .end local v6    # "currentlyPlayingOffset":I
    .end local v7    # "height":F
    :cond_1
    const-string v13, "Current First: {}, ratio: {}"

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    invoke-static {v12}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v15

    invoke-static {v13, v14, v15}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 876
    const/4 v4, -0x1

    .line 877
    .local v4, "currentNext":I
    float-to-double v13, v12

    const-wide/high16 v15, 0x3fe0000000000000L    # 0.5

    cmpg-double v13, v13, v15

    if-ltz v13, :cond_2

    const/4 v13, -0x1

    if-eq v2, v13, :cond_2

    if-nez v3, :cond_7

    .line 878
    :cond_2
    add-int/lit8 v11, v2, 0x1

    .local v11, "nextPlayer":I
    :goto_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v13}, Lco/vine/android/ConversationAdapter;->getCount()I

    move-result v13

    if-ge v11, v13, :cond_3

    .line 879
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mMessages:Landroid/util/SparseArray;
    invoke-static {v13}, Lco/vine/android/ConversationAdapter;->access$200(Lco/vine/android/ConversationAdapter;)Landroid/util/SparseArray;

    move-result-object v13

    invoke-virtual {v13, v11}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lco/vine/android/api/VinePrivateMessage;

    .line 880
    .local v10, "next":Lco/vine/android/api/VinePrivateMessage;
    if-eqz v10, :cond_3

    .line 881
    iget-boolean v13, v10, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    if-eqz v13, :cond_6

    .line 882
    move v4, v11

    .line 890
    .end local v10    # "next":Lco/vine/android/api/VinePrivateMessage;
    :cond_3
    const-string v13, "Current Next: {}"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v14

    invoke-static {v13, v14}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 891
    const/4 v13, -0x1

    if-eq v4, v13, :cond_4

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I
    invoke-static {v13}, Lco/vine/android/ConversationAdapter;->access$400(Lco/vine/android/ConversationAdapter;)I

    move-result v13

    if-eq v4, v13, :cond_4

    .line 892
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v13, v4}, Lco/vine/android/ConversationAdapter;->play(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 899
    .end local v11    # "nextPlayer":I
    :cond_4
    :goto_2
    monitor-exit p0

    return-void

    .line 863
    .end local v3    # "currentHasVideo":Z
    .end local v4    # "currentNext":I
    .end local v5    # "currentView":Landroid/view/View;
    .end local v12    # "ratio":F
    :cond_5
    const/4 v3, 0x0

    goto/16 :goto_0

    .line 878
    .restart local v3    # "currentHasVideo":Z
    .restart local v4    # "currentNext":I
    .restart local v5    # "currentView":Landroid/view/View;
    .restart local v10    # "next":Lco/vine/android/api/VinePrivateMessage;
    .restart local v11    # "nextPlayer":I
    .restart local v12    # "ratio":F
    :cond_6
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 894
    .end local v10    # "next":Lco/vine/android/api/VinePrivateMessage;
    .end local v11    # "nextPlayer":I
    :cond_7
    :try_start_1
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    # getter for: Lco/vine/android/ConversationAdapter;->mCurrentPlaying:I
    invoke-static {v13}, Lco/vine/android/ConversationAdapter;->access$400(Lco/vine/android/ConversationAdapter;)I

    move-result v13

    if-eq v2, v13, :cond_8

    .line 895
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    invoke-virtual {v13, v2}, Lco/vine/android/ConversationAdapter;->play(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 860
    .end local v2    # "currentFirst":I
    .end local v3    # "currentHasVideo":Z
    .end local v4    # "currentNext":I
    .end local v5    # "currentView":Landroid/view/View;
    .end local v8    # "listView":Landroid/widget/ListView;
    .end local v9    # "msg":Lco/vine/android/api/VinePrivateMessage;
    .end local v12    # "ratio":F
    :catchall_0
    move-exception v13

    monitor-exit p0

    throw v13

    .line 897
    .restart local v2    # "currentFirst":I
    .restart local v3    # "currentHasVideo":Z
    .restart local v4    # "currentNext":I
    .restart local v5    # "currentView":Landroid/view/View;
    .restart local v8    # "listView":Landroid/widget/ListView;
    .restart local v9    # "msg":Lco/vine/android/api/VinePrivateMessage;
    .restart local v12    # "ratio":F
    :cond_8
    :try_start_2
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/ConversationAdapter$2;->this$0:Lco/vine/android/ConversationAdapter;

    const/4 v14, 0x0

    invoke-virtual {v13, v2, v14}, Lco/vine/android/ConversationAdapter;->playFile(IZ)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2
.end method
