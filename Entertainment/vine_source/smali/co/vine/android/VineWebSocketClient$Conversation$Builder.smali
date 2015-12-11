.class public Lco/vine/android/VineWebSocketClient$Conversation$Builder;
.super Ljava/lang/Object;
.source "VineWebSocketClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/VineWebSocketClient$Conversation;
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

    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 100
    iput-boolean v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->connected:Z

    .line 101
    iput-boolean v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->typing:Z

    .line 102
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->lastMessageId:J

    .line 103
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/VineWebSocketClient$Conversation$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    .prologue
    .line 94
    iget-boolean v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->connected:Z

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/VineWebSocketClient$Conversation$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    .prologue
    .line 94
    iget-boolean v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->typing:Z

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/VineWebSocketClient$Conversation$Builder;)J
    .locals 2
    .param p0, "x0"    # Lco/vine/android/VineWebSocketClient$Conversation$Builder;

    .prologue
    .line 94
    iget-wide v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->lastMessageId:J

    return-wide v0
.end method


# virtual methods
.method public build()Lco/vine/android/VineWebSocketClient$Conversation;
    .locals 2

    .prologue
    .line 121
    new-instance v0, Lco/vine/android/VineWebSocketClient$Conversation;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lco/vine/android/VineWebSocketClient$Conversation;-><init>(Lco/vine/android/VineWebSocketClient$Conversation$Builder;Lco/vine/android/VineWebSocketClient$1;)V

    return-object v0
.end method

.method public setConnected()Lco/vine/android/VineWebSocketClient$Conversation$Builder;
    .locals 1

    .prologue
    .line 106
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->connected:Z

    .line 107
    return-object p0
.end method

.method public setLastMessageId(J)Lco/vine/android/VineWebSocketClient$Conversation$Builder;
    .locals 0
    .param p1, "lastMessageId"    # J

    .prologue
    .line 116
    iput-wide p1, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->lastMessageId:J

    .line 117
    return-object p0
.end method

.method public setTyping(Z)Lco/vine/android/VineWebSocketClient$Conversation$Builder;
    .locals 0
    .param p1, "isTyping"    # Z

    .prologue
    .line 111
    iput-boolean p1, p0, Lco/vine/android/VineWebSocketClient$Conversation$Builder;->typing:Z

    .line 112
    return-object p0
.end method
