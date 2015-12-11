.class Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;
.super Ljava/lang/Object;
.source "FbMessengerShare.java"

# interfaces
.implements Lcom/facebook/FacebookCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/facebook/FacebookCallback",
        "<",
        "Lcom/facebook/share/Sharer$Result;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;)V
    .locals 0

    .prologue
    .line 85
    iput-object p1, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel()V
    .locals 2

    .prologue
    .line 95
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 96
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_CANCELLED:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 97
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 98
    return-void
.end method

.method public onError(Lcom/facebook/FacebookException;)V
    .locals 2
    .param p1, "e"    # Lcom/facebook/FacebookException;

    .prologue
    .line 102
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 103
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 104
    return-void
.end method

.method public onSuccess(Lcom/facebook/share/Sharer$Result;)V
    .locals 2
    .param p1, "result"    # Lcom/facebook/share/Sharer$Result;

    .prologue
    .line 88
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 89
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_SUCCESS:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->this$0:Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;

    iget-object v0, v0, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare;->listener:Lcom/poshmark/utils/sharing/StateCompletionListener;

    invoke-interface {v0}, Lcom/poshmark/utils/sharing/StateCompletionListener;->stateCompleted()V

    .line 91
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 85
    check-cast p1, Lcom/facebook/share/Sharer$Result;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/sharing/share_states/FbMessengerShare$1;->onSuccess(Lcom/facebook/share/Sharer$Result;)V

    return-void
.end method
