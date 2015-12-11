.class public Lco/vine/android/service/GCMNotificationService$NotificationEvent;
.super Ljava/lang/Object;
.source "GCMNotificationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMNotificationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationEvent"
.end annotation


# instance fields
.field public avatarKey:Lco/vine/android/util/image/ImageKey;

.field public bm:Landroid/graphics/Bitmap;

.field public builder:Landroid/support/v4/app/NotificationCompat$Builder;

.field public final notificationId:I

.field public notificationObjectId:J

.field public notifications:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation
.end field

.field public final thumbnailKeys:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field

.field public final videoKeys:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "notificationId"    # I

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 132
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    .line 133
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    .line 138
    iput p1, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notificationId:I

    .line 139
    return-void
.end method


# virtual methods
.method public isReady()Z
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 142
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    if-nez v2, :cond_0

    .line 143
    const-string v2, "Builder is not ready, this event has been reset by notification merge."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v2, v3

    .line 162
    :goto_0
    return v2

    .line 146
    :cond_0
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    if-eqz v2, :cond_1

    .line 147
    const-string v2, "Notification not ready because avatar is pending."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v2, v3

    .line 148
    goto :goto_0

    .line 150
    :cond_1
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/image/ImageKey;

    .line 151
    .local v1, "key":Lco/vine/android/util/image/ImageKey;
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_2

    .line 152
    const-string v2, "Notification not ready because thumbnails are pending."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v2, v3

    .line 153
    goto :goto_0

    .line 156
    .end local v1    # "key":Lco/vine/android/util/image/ImageKey;
    :cond_3
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_4
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/util/video/VideoKey;

    .line 157
    .local v1, "key":Lco/vine/android/util/video/VideoKey;
    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v2, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_4

    .line 158
    const-string v2, "Notification not ready because videos are pending."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    move v2, v3

    .line 159
    goto :goto_0

    .line 162
    .end local v1    # "key":Lco/vine/android/util/video/VideoKey;
    :cond_5
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public reset()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 166
    iput-object v1, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->builder:Landroid/support/v4/app/NotificationCompat$Builder;

    .line 167
    iput-object v1, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->notifications:Ljava/util/ArrayList;

    .line 168
    iput-object v1, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->avatarKey:Lco/vine/android/util/image/ImageKey;

    .line 169
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->thumbnailKeys:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 170
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->videoKeys:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 171
    iput-object v1, p0, Lco/vine/android/service/GCMNotificationService$NotificationEvent;->bm:Landroid/graphics/Bitmap;

    .line 172
    return-void
.end method
