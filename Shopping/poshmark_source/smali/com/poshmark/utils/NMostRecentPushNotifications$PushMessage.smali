.class public Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;
.super Ljava/lang/Object;
.source "NMostRecentPushNotifications.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/NMostRecentPushNotifications;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessage"
.end annotation


# instance fields
.field msg:Ljava/lang/String;

.field priority:I


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 143
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 142
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    .line 144
    iput-object p1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->msg:Ljava/lang/String;

    .line 145
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "priority"    # Ljava/lang/String;

    .prologue
    .line 147
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 142
    const/4 v1, 0x0

    iput v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    .line 148
    iput-object p1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->msg:Ljava/lang/String;

    .line 150
    :try_start_0
    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 155
    :goto_0
    return-void

    .line 151
    :catch_0
    move-exception v0

    .line 153
    .local v0, "e":Ljava/lang/NumberFormatException;
    const/4 v1, 0x1

    iput v1, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->priority:I

    goto :goto_0
.end method


# virtual methods
.method public getMessage()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/poshmark/utils/NMostRecentPushNotifications$PushMessage;->msg:Ljava/lang/String;

    return-object v0
.end method
