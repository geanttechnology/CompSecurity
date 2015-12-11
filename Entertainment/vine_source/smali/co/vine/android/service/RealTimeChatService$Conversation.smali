.class Lco/vine/android/service/RealTimeChatService$Conversation;
.super Ljava/util/HashMap;
.source "RealTimeChatService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/RealTimeChatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Conversation"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)V
    .locals 4
    .param p1, "b"    # Lco/vine/android/service/RealTimeChatService$Conversation$Builder;

    .prologue
    .line 220
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 221
    const-string v0, "connected"

    # getter for: Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->connected:Z
    invoke-static {p1}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->access$700(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/service/RealTimeChatService$Conversation;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    const-string v0, "typing"

    # getter for: Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->typing:Z
    invoke-static {p1}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->access$800(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/service/RealTimeChatService$Conversation;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 223
    # getter for: Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->lastMessageId:J
    invoke-static {p1}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->access$900(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 224
    const-string v0, "last_message_id"

    # getter for: Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->lastMessageId:J
    invoke-static {p1}, Lco/vine/android/service/RealTimeChatService$Conversation$Builder;->access$900(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/service/RealTimeChatService$Conversation;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 226
    :cond_0
    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;Lco/vine/android/service/RealTimeChatService$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/service/RealTimeChatService$Conversation$Builder;
    .param p2, "x1"    # Lco/vine/android/service/RealTimeChatService$1;

    .prologue
    .line 218
    invoke-direct {p0, p1}, Lco/vine/android/service/RealTimeChatService$Conversation;-><init>(Lco/vine/android/service/RealTimeChatService$Conversation$Builder;)V

    return-void
.end method
