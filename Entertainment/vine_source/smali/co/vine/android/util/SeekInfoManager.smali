.class public Lco/vine/android/util/SeekInfoManager;
.super Ljava/lang/Object;
.source "SeekInfoManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/SeekInfoManager$SeekInfo;
    }
.end annotation


# static fields
.field public static final NO_LOOP_LIMIT:Lco/vine/android/util/SeekInfoManager$SeekInfo;


# instance fields
.field private final mAppController:Lco/vine/android/client/AppController;

.field private final mDurations:Ljava/util/HashMap;
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

.field private final mSeekInfoMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lco/vine/android/util/SeekInfoManager$SeekInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 20
    new-instance v0, Lco/vine/android/util/SeekInfoManager$SeekInfo;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    const-wide/16 v3, 0x2

    mul-long/2addr v1, v3

    const/16 v3, 0x1b58

    const v4, 0x7fffffff

    invoke-direct {v0, v1, v2, v3, v4}, Lco/vine/android/util/SeekInfoManager$SeekInfo;-><init>(JII)V

    sput-object v0, Lco/vine/android/util/SeekInfoManager;->NO_LOOP_LIMIT:Lco/vine/android/util/SeekInfoManager$SeekInfo;

    return-void
.end method

.method public constructor <init>(Lco/vine/android/client/AppController;)V
    .locals 1
    .param p1, "appController"    # Lco/vine/android/client/AppController;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/SeekInfoManager;->mSeekInfoMap:Ljava/util/HashMap;

    .line 24
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lco/vine/android/util/SeekInfoManager;->mDurations:Ljava/util/HashMap;

    .line 28
    iput-object p1, p0, Lco/vine/android/util/SeekInfoManager;->mAppController:Lco/vine/android/client/AppController;

    .line 29
    return-void
.end method


# virtual methods
.method public get(J)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 2
    .param p1, "message"    # J

    .prologue
    .line 32
    iget-object v0, p0, Lco/vine/android/util/SeekInfoManager;->mSeekInfoMap:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/SeekInfoManager$SeekInfo;

    return-object v0
.end method

.method public getSeekInfo(Lco/vine/android/player/VideoViewInterface;Lco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 7
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "message"    # Lco/vine/android/api/VinePrivateMessage;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 44
    iget-object v3, p0, Lco/vine/android/util/SeekInfoManager;->mSeekInfoMap:Ljava/util/HashMap;

    iget-wide v4, p2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/util/SeekInfoManager$SeekInfo;

    .line 45
    .local v2, "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    if-nez v2, :cond_4

    .line 46
    iget-wide v3, p2, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    const-wide/16 v5, 0x0

    cmp-long v3, v3, v5

    if-eqz v3, :cond_3

    .line 47
    iget-object v3, p0, Lco/vine/android/util/SeekInfoManager;->mDurations:Ljava/util/HashMap;

    iget-wide v4, p2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 48
    .local v0, "duration":Ljava/lang/Integer;
    if-nez v0, :cond_0

    .line 49
    if-eqz p1, :cond_1

    .line 50
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->getDuration()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    .line 51
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_0

    .line 52
    iget-object v3, p0, Lco/vine/android/util/SeekInfoManager;->mDurations:Ljava/util/HashMap;

    iget-wide v4, p2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-gtz v3, :cond_2

    const/16 v1, 0x1b58

    .line 59
    .local v1, "durationPadded":I
    :goto_0
    new-instance v2, Lco/vine/android/util/SeekInfoManager$SeekInfo;

    .end local v2    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    iget-wide v3, p2, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    iget v5, p2, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    invoke-direct {v2, v3, v4, v1, v5}, Lco/vine/android/util/SeekInfoManager$SeekInfo;-><init>(JII)V

    .line 60
    .restart local v2    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    const-string v3, "Adding SeekInfo: {}."

    invoke-static {v3, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 61
    iget-object v3, p0, Lco/vine/android/util/SeekInfoManager;->mSeekInfoMap:Ljava/util/HashMap;

    iget-wide v4, p2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v3, v2

    .line 68
    .end local v0    # "duration":Ljava/lang/Integer;
    .end local v1    # "durationPadded":I
    :goto_1
    return-object v3

    .line 55
    .restart local v0    # "duration":Ljava/lang/Integer;
    :cond_1
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "Duration cannot be determined."

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 58
    :cond_2
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v3

    add-int/lit8 v1, v3, 0x64

    goto :goto_0

    .line 65
    .end local v0    # "duration":Ljava/lang/Integer;
    :cond_3
    const/4 v3, 0x0

    goto :goto_1

    :cond_4
    move-object v3, v2

    .line 68
    goto :goto_1
.end method

.method public markAsRead(ILco/vine/android/api/VinePrivateMessage;)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .locals 7
    .param p1, "duration"    # I
    .param p2, "message"    # Lco/vine/android/api/VinePrivateMessage;

    .prologue
    .line 74
    if-gtz p1, :cond_0

    const/16 v0, 0x1b58

    .line 75
    .local v0, "durationPadded":I
    :goto_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 76
    .local v2, "startTime":J
    iput-wide v2, p2, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    .line 77
    new-instance v1, Lco/vine/android/util/SeekInfoManager$SeekInfo;

    iget v4, p2, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    invoke-direct {v1, v2, v3, v0, v4}, Lco/vine/android/util/SeekInfoManager$SeekInfo;-><init>(JII)V

    .line 78
    .local v1, "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    const-string v4, "Adding SeekInfo: {}."

    invoke-static {v4, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 79
    iget-object v4, p0, Lco/vine/android/util/SeekInfoManager;->mSeekInfoMap:Ljava/util/HashMap;

    iget-wide v5, p2, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 80
    const-string v4, "Mark as read."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 81
    iget-object v4, p0, Lco/vine/android/util/SeekInfoManager;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v4, p2}, Lco/vine/android/client/AppController;->markMessageLoopViewed(Lco/vine/android/api/VinePrivateMessage;)V

    .line 82
    return-object v1

    .line 74
    .end local v0    # "durationPadded":I
    .end local v1    # "seekInfo":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    .end local v2    # "startTime":J
    :cond_0
    add-int/lit8 v0, p1, 0x64

    goto :goto_0
.end method
