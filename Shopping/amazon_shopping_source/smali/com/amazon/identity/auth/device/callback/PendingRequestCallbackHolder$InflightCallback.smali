.class Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;
.super Ljava/lang/Object;
.source "PendingRequestCallbackHolder.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "InflightCallback"
.end annotation


# instance fields
.field private final mId:Ljava/lang/String;

.field final synthetic this$0:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;


# direct methods
.method public constructor <init>(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;)V
    .locals 0
    .param p2, "id"    # Ljava/lang/String;

    .prologue
    .line 20
    iput-object p1, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->this$0:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    iput-object p2, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->mId:Ljava/lang/String;

    .line 22
    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->this$0:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->mId:Ljava/lang/String;

    invoke-static {v0, v1, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->access$100(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 34
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->this$0:Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder$InflightCallback;->mId:Ljava/lang/String;

    invoke-static {v0, v1, p1}, Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;->access$000(Lcom/amazon/identity/auth/device/callback/PendingRequestCallbackHolder;Ljava/lang/String;Landroid/os/Bundle;)V

    .line 28
    return-void
.end method
