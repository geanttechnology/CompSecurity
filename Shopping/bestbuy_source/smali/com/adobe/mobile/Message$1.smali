.class final Lcom/adobe/mobile/Message$1;
.super Ljava/util/HashMap;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mobile/Message;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Class;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 91
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 92
    const-string v0, "local"

    const-class v1, Lcom/adobe/mobile/MessageLocalNotification;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/Message$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 93
    const-string v0, "alert"

    const-class v1, Lcom/adobe/mobile/MessageAlert;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/Message$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 94
    const-string v0, "fullscreen"

    const-class v1, Lcom/adobe/mobile/MessageFullScreen;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/Message$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    const-string v0, "callback"

    const-class v1, Lcom/adobe/mobile/MessageTemplateCallback;

    invoke-virtual {p0, v0, v1}, Lcom/adobe/mobile/Message$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    return-void
.end method
