.class public Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
.super Ljava/lang/Object;
.source "RealTimeChatService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/RealTimeChatService$Conversation;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private connected:Z

.field private lastMessageId:J

.field private typing:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 233
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 234
    iput-boolean v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->connected:Z

    .line 235
    iput-boolean v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->typing:Z

    .line 236
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->lastMessageId:J

    .line 237
    return-void
.end method

.method static synthetic access$700(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    .prologue
    .line 228
    iget-boolean v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->connected:Z

    return v0
.end method

.method static synthetic access$800(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    .prologue
    .line 228
    iget-boolean v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->typing:Z

    return v0
.end method

.method static synthetic access$900(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    .prologue
    .line 228
    iget-wide v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->lastMessageId:J

    return-wide v0
.end method


# virtual methods
.method public build()Lco/vine/android/service/RealTimeChatService$Conversation;
    .locals 2

    .prologue
    .line 255
    new-instance v0, Lco/vine/android/service/RealTimeChatService$Conversation;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/service/RealTimeChatService$Conversation;-><init>(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;Lco/vine/android/service/RealTimeChatService$1;)V

    return-object v0
.end method

.method public setConnected()Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
    .locals 1

    .prologue
    .line 240
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->connected:Z

    .line 241
    return-object p0
.end method

.method public setLastMessageId(J)Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
    .locals 0
    .param p1, "lastMessageId"    # J

    .prologue
    .line 250
    iput-wide p1, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->lastMessageId:J

    .line 251
    return-object p0
.end method

.method public setTyping(Z)Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
    .locals 0
    .param p1, "isTyping"    # Z

    .prologue
    .line 245
    iput-boolean p1, p0, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->typing:Z

    .line 246
    return-object p0
.end method
