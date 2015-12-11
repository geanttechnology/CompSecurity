.class Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;
.super Lco/vine/android/client/AppSessionListener;
.source "GCMNotificationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMNotificationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "GCMNotificationServiceListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/GCMNotificationService;


# direct methods
.method private constructor <init>(Lco/vine/android/service/GCMNotificationService;)V
    .locals 0

    .prologue
    .line 489
    iput-object p1, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/service/GCMNotificationService;
    .param p2, "x1"    # Lco/vine/android/service/GCMNotificationService$1;

    .prologue
    .line 489
    invoke-direct {p0, p1}, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;-><init>(Lco/vine/android/service/GCMNotificationService;)V

    return-void
.end method


# virtual methods
.method public onMergeNotificationComplete(Lco/vine/android/api/VineSingleNotification;Ljava/util/ArrayList;)V
    .locals 9
    .param p1, "lastNotification"    # Lco/vine/android/api/VineSingleNotification;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/api/VineSingleNotification;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 573
    .local p2, "notifications":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineSingleNotification;>;"
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_2

    .line 574
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->getNotificationId(Lco/vine/android/api/VineSingleNotification;)I
    invoke-static {v4, p1}, Lco/vine/android/service/GCMNotificationService;->access$800(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;)I

    move-result v3

    .line 575
    .local v3, "notificationId":I
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-virtual {v4, v3}, Lco/vine/android/service/GCMNotificationService;->getNotificationEvent(I)Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    move-result-object v1

    .line 576
    .local v1, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-wide v4, v1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationObjectId:J

    const-wide/16 v6, 0x0

    cmp-long v4, v4, v6

    if-lez v4, :cond_0

    iget-wide v4, p1, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    iget-wide v6, v1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationObjectId:J

    cmp-long v4, v4, v6

    if-eqz v4, :cond_0

    .line 578
    invoke-virtual {v1}, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->reset()V

    .line 579
    iget-wide v4, p1, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    iput-wide v4, v1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationObjectId:J

    .line 581
    :cond_0
    iput-object p2, v1, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notifications:Ljava/util/ArrayList;

    .line 582
    invoke-virtual {p1}, Lco/vine/android/api/VineSingleNotification;->isMessaging()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 584
    :try_start_0
    new-instance v2, Landroid/os/Message;

    invoke-direct {v2}, Landroid/os/Message;-><init>()V

    .line 585
    .local v2, "msg":Landroid/os/Message;
    const/16 v4, 0x65

    iput v4, v2, Landroid/os/Message;->what:I

    .line 586
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mCameraMessenger:Landroid/os/Messenger;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$000(Lco/vine/android/service/GCMNotificationService;)Landroid/os/Messenger;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 587
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mCameraMessenger:Landroid/os/Messenger;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$000(Lco/vine/android/service/GCMNotificationService;)Landroid/os/Messenger;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 592
    .end local v2    # "msg":Landroid/os/Message;
    :cond_1
    :goto_0
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v5

    monitor-enter v5

    .line 593
    :try_start_1
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mNotificationsToFire:Ljava/util/HashMap;
    invoke-static {v4}, Lco/vine/android/service/GCMNotificationService;->access$200(Lco/vine/android/service/GCMNotificationService;)Ljava/util/HashMap;

    move-result-object v4

    iget-wide v6, p1, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    new-instance v7, Lco/vine/android/service/GCMNotificationService$BuildableNotification;

    iget-object v8, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-direct {v7, v8, p1, v1}, Lco/vine/android/service/GCMNotificationService$BuildableNotification;-><init>(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V

    invoke-virtual {v4, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 594
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 599
    .end local v1    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .end local v3    # "notificationId":I
    :cond_2
    :goto_1
    return-void

    .line 589
    .restart local v1    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .restart local v3    # "notificationId":I
    :catch_0
    move-exception v0

    .line 590
    .local v0, "e":Landroid/os/RemoteException;
    const-string v4, "Failed to send request to camera service."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_0

    .line 594
    .end local v0    # "e":Landroid/os/RemoteException;
    :catchall_0
    move-exception v4

    :try_start_2
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .line 596
    :cond_3
    iget-object v4, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->buildNotification(Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V
    invoke-static {v4, p1, v1}, Lco/vine/android/service/GCMNotificationService;->access$900(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V

    goto :goto_1
.end method

.method public onPhotoImageError(Lco/vine/android/util/image/ImageKey;Lco/vine/android/network/HttpResult;)V
    .locals 8
    .param p1, "erroredImageKey"    # Lco/vine/android/util/image/ImageKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 509
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 510
    .local v5, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/util/SparseArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 511
    .local v3, "key":I
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v3}, Lco/vine/android/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 512
    .local v0, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v6, :cond_1

    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v6}, Lco/vine/android/util/image/ImageKey;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 513
    const/4 v6, 0x0

    iput-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 515
    :cond_1
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/util/image/ImageKey;

    .line 516
    .local v4, "thumbnailKey":Lco/vine/android/util/image/ImageKey;
    invoke-virtual {p1, v4}, Lco/vine/android/util/image/ImageKey;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 517
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v6, v4, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 520
    .end local v4    # "thumbnailKey":Lco/vine/android/util/image/ImageKey;
    :cond_3
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    invoke-static {v6, v0}, Lco/vine/android/service/GCMNotificationService;->access$700(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 521
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 524
    .end local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "key":I
    :cond_4
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v5}, Lco/vine/android/util/SparseArray;->removeAll(Ljava/util/Collection;)V

    .line 525
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 9
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
    .line 547
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    .line 548
    .local v6, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_5

    .line 549
    iget-object v7, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v7}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v7

    invoke-virtual {v7}, Lco/vine/android/util/SparseArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Integer;

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v4

    .line 550
    .local v4, "key":I
    iget-object v7, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v7}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v7

    invoke-virtual {v7, v4}, Lco/vine/android/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 551
    .local v0, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v7, :cond_2

    iget-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v7}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 552
    iget-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    invoke-virtual {p1, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/util/image/UrlImage;

    .line 553
    .local v3, "image":Lco/vine/android/util/image/UrlImage;
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 554
    iget-object v7, v3, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    iput-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    .line 556
    :cond_1
    const/4 v7, 0x0

    iput-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 558
    .end local v3    # "image":Lco/vine/android/util/image/UrlImage;
    :cond_2
    iget-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v7}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/util/image/ImageKey;

    .line 559
    .local v5, "thumbnailKey":Lco/vine/android/util/image/ImageKey;
    invoke-virtual {p1, v5}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 560
    iget-object v7, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    const/4 v8, 0x1

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v7, v5, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 563
    .end local v5    # "thumbnailKey":Lco/vine/android/util/image/ImageKey;
    :cond_4
    iget-object v7, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    invoke-static {v7, v0}, Lco/vine/android/service/GCMNotificationService;->access$700(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 564
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 568
    .end local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "key":I
    :cond_5
    iget-object v7, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v7}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v7

    invoke-virtual {v7, v6}, Lco/vine/android/util/SparseArray;->removeAll(Ljava/util/Collection;)V

    .line 569
    return-void
.end method

.method public onVideoPathError(Lco/vine/android/util/video/VideoKey;Lco/vine/android/network/HttpResult;)V
    .locals 8
    .param p1, "erroredVideoKey"    # Lco/vine/android/util/video/VideoKey;
    .param p2, "result"    # Lco/vine/android/network/HttpResult;

    .prologue
    .line 492
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 493
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/util/SparseArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 494
    .local v3, "key":I
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v3}, Lco/vine/android/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 495
    .local v0, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/util/video/VideoKey;

    .line 496
    .local v5, "videoKey":Lco/vine/android/util/video/VideoKey;
    invoke-virtual {p1, v5}, Lco/vine/android/util/video/VideoKey;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 497
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v6, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 500
    .end local v5    # "videoKey":Lco/vine/android/util/video/VideoKey;
    :cond_2
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    invoke-static {v6, v0}, Lco/vine/android/service/GCMNotificationService;->access$700(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 501
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 504
    .end local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "key":I
    :cond_3
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v4}, Lco/vine/android/util/SparseArray;->removeAll(Ljava/util/Collection;)V

    .line 505
    return-void
.end method

.method public onVideoPathObtained(Ljava/util/HashMap;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Lco/vine/android/util/video/UrlVideo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 529
    .local p1, "videos":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/video/VideoKey;Lco/vine/android/util/video/UrlVideo;>;"
    const-string v6, "Video path obtained."

    invoke-static {v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 530
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 531
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/util/SparseArray;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 532
    .local v3, "key":I
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v3}, Lco/vine/android/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 533
    .local v0, "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/util/video/VideoKey;

    .line 534
    .local v5, "videoKey":Lco/vine/android/util/video/VideoKey;
    invoke-virtual {p1, v5}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 535
    iget-object v6, v0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    const/4 v7, 0x1

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {v6, v5, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 538
    .end local v5    # "videoKey":Lco/vine/android/util/video/VideoKey;
    :cond_2
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->showNotification(Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z
    invoke-static {v6, v0}, Lco/vine/android/service/GCMNotificationService;->access$700(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 539
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 542
    .end local v0    # "event":Lco/vine/android/service/GCMNotificationService$NotificationEvent;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "key":I
    :cond_3
    iget-object v6, p0, Lco/vine/android/service/GCMNotificationService$GCMNotificationServiceListener;->this$0:Lco/vine/android/service/GCMNotificationService;

    # getter for: Lco/vine/android/service/GCMNotificationService;->mQueue:Lco/vine/android/util/SparseArray;
    invoke-static {v6}, Lco/vine/android/service/GCMNotificationService;->access$600(Lco/vine/android/service/GCMNotificationService;)Lco/vine/android/util/SparseArray;

    move-result-object v6

    invoke-virtual {v6, v4}, Lco/vine/android/util/SparseArray;->removeAll(Ljava/util/Collection;)V

    .line 543
    return-void
.end method
