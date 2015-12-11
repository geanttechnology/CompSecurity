.class Lco/vine/android/ActivityFragment$ActivityListener;
.super Lco/vine/android/client/AppSessionListener;
.source "ActivityFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ActivityFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ActivityListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ActivityFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ActivityFragment;)V
    .locals 0

    .prologue
    .line 239
    iput-object p1, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 243
    iget-object v1, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ActivityFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 244
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 245
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 246
    iget-object v1, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v1, v1, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v1, Lco/vine/android/ActivityAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/ActivityAdapter;->unfollow(J)V

    .line 249
    :cond_0
    return-void
.end method

.method public onGetActivityComplete(Ljava/lang/String;ILjava/lang/String;Lco/vine/android/api/VinePagedData;Lco/vine/android/api/VinePagedData;)V
    .locals 10
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;",
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p4, "notifications":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineEverydayNotification;>;"
    .local p5, "followRequests":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<Lco/vine/android/api/VineSingleNotification;>;"
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v5, p1}, Lco/vine/android/ActivityFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v4

    .line 266
    .local v4, "req":Lco/vine/android/PendingRequest;
    if-eqz v4, :cond_5

    .line 267
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget v6, v4, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {v5, v6}, Lco/vine/android/ActivityFragment;->hideProgress(I)V

    .line 269
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v5}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    .line 270
    .local v3, "pr":Landroid/content/SharedPreferences;
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    const-string v6, "settings_private"

    const/4 v7, 0x0

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    # setter for: Lco/vine/android/ActivityFragment;->mPrivate:Z
    invoke-static {v5, v6}, Lco/vine/android/ActivityFragment;->access$002(Lco/vine/android/ActivityFragment;Z)Z

    .line 272
    const/4 v1, 0x0

    .line 273
    .local v1, "count":I
    if-eqz p4, :cond_0

    .line 274
    iget-object v5, p4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-nez v5, :cond_6

    const/4 v1, 0x0

    .line 277
    :cond_0
    :goto_0
    const/4 v2, 0x0

    .line 278
    .local v2, "followRequestCount":I
    if-eqz p5, :cond_1

    .line 279
    iget-object v5, p5, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-nez v5, :cond_7

    const/4 v2, 0x0

    .line 282
    :cond_1
    :goto_1
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v5, v5, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    invoke-virtual {v5}, Landroid/widget/BaseAdapter;->getCount()I

    move-result v5

    if-nez v5, :cond_8

    if-nez v1, :cond_8

    if-nez v2, :cond_8

    .line 283
    const/16 v5, 0xc8

    if-eq p2, v5, :cond_2

    .line 284
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    const v6, 0x7f0e00d8

    iput v6, v5, Lco/vine/android/ActivityFragment;->mEmptyTextStringRes:I

    .line 285
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v5, v5, Lco/vine/android/ActivityFragment;->mEmptyText:Landroid/widget/TextView;

    iget-object v6, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget v6, v6, Lco/vine/android/ActivityFragment;->mEmptyTextStringRes:I

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(I)V

    .line 287
    :cond_2
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    const/4 v6, 0x1

    invoke-virtual {v5, v6}, Lco/vine/android/ActivityFragment;->showSadface(Z)V

    .line 292
    :goto_2
    const/16 v5, 0xc8

    if-ne p2, v5, :cond_4

    .line 293
    if-eqz p4, :cond_3

    .line 294
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget v6, p4, Lco/vine/android/api/VinePagedData;->nextPage:I

    iput v6, v5, Lco/vine/android/ActivityFragment;->mNextPage:I

    .line 295
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-wide v6, p4, Lco/vine/android/api/VinePagedData;->anchor:J

    iput-wide v6, v5, Lco/vine/android/ActivityFragment;->mAnchor:J

    .line 297
    :cond_3
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v5, v5, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v5, :cond_4

    .line 298
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v5, v5, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v5, Lco/vine/android/ActivityAdapter;

    if-nez p4, :cond_9

    const/4 v6, 0x0

    move-object v8, v6

    :goto_3
    if-nez p5, :cond_a

    const/4 v6, 0x0

    :goto_4
    iget v7, v4, Lco/vine/android/PendingRequest;->fetchType:I

    const/4 v9, 0x1

    if-ne v7, v9, :cond_b

    const/4 v7, 0x1

    :goto_5
    invoke-virtual {v5, v8, v6, v7}, Lco/vine/android/ActivityAdapter;->mergeData(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V

    .line 304
    :cond_4
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v5}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 306
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    if-eqz v0, :cond_5

    .line 308
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v5}, Lco/vine/android/ActivityFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const/4 v6, 0x1

    invoke-static {v5, v6}, Lco/vine/android/service/GCMNotificationService;->getClearNotificationIntent(Landroid/content/Context;I)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v0, v5}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 311
    check-cast v0, Lco/vine/android/HomeTabActivity;

    .end local v0    # "activity":Landroid/support/v4/app/FragmentActivity;
    invoke-virtual {v0}, Lco/vine/android/HomeTabActivity;->markActivitiesRead()V

    .line 314
    .end local v1    # "count":I
    .end local v2    # "followRequestCount":I
    .end local v3    # "pr":Landroid/content/SharedPreferences;
    :cond_5
    return-void

    .line 274
    .restart local v1    # "count":I
    .restart local v3    # "pr":Landroid/content/SharedPreferences;
    :cond_6
    iget-object v5, p4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v1

    goto/16 :goto_0

    .line 279
    .restart local v2    # "followRequestCount":I
    :cond_7
    iget-object v5, p5, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v2

    goto/16 :goto_1

    .line 289
    :cond_8
    iget-object v5, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Lco/vine/android/ActivityFragment;->showSadface(Z)V

    goto :goto_2

    .line 298
    :cond_9
    iget-object v6, p4, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    move-object v8, v6

    goto :goto_3

    :cond_a
    iget-object v6, p5, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    goto :goto_4

    :cond_b
    const/4 v7, 0x0

    goto :goto_5
.end method

.method public onGetUsersMeComplete(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineUser;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "sessionOwnerId"    # J
    .param p6, "meUser"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 324
    if-eqz p6, :cond_0

    invoke-virtual {p6}, Lco/vine/android/api/VineUser;->isPrivate()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 325
    iget-object v0, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/ActivityFragment;->mPrivate:Z
    invoke-static {v0, v1}, Lco/vine/android/ActivityFragment;->access$002(Lco/vine/android/ActivityFragment;Z)Z

    .line 327
    :cond_0
    return-void
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 1
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
    .line 318
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v0, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v0, v0, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v0, Lco/vine/android/ActivityAdapter;

    invoke-virtual {v0, p1}, Lco/vine/android/ActivityAdapter;->setImages(Ljava/util/HashMap;)V

    .line 319
    return-void
.end method

.method public onUnFollowComplete(Ljava/lang/String;ILjava/lang/String;J)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "userId"    # J

    .prologue
    .line 253
    iget-object v1, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    invoke-virtual {v1, p1}, Lco/vine/android/ActivityFragment;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    .line 254
    .local v0, "req":Lco/vine/android/PendingRequest;
    if-eqz v0, :cond_0

    .line 255
    const/16 v1, 0xc8

    if-eq p2, v1, :cond_0

    .line 256
    iget-object v1, p0, Lco/vine/android/ActivityFragment$ActivityListener;->this$0:Lco/vine/android/ActivityFragment;

    iget-object v1, v1, Lco/vine/android/ActivityFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v1, Lco/vine/android/ActivityAdapter;

    invoke-virtual {v1, p4, p5}, Lco/vine/android/ActivityAdapter;->follow(J)V

    .line 259
    :cond_0
    return-void
.end method
