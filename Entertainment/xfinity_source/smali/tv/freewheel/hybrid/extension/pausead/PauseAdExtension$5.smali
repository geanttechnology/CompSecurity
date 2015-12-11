.class Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;
.super Ljava/lang/Object;
.source "PauseAdExtension.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 2
    .param p1, "event"    # Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    .prologue
    .line 153
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "adImpressionListener"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 154
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # invokes: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->isEventFromCurrentPlayingPauseSlot(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)Ljava/lang/Boolean;
    invoke-static {v0, p1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$800(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 155
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    # getter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->logger:Ltv/freewheel/hybrid/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$100(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v0

    const-string v1, "adImpressionListener, ad played successfully"

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->debug(Ljava/lang/String;)V

    .line 156
    iget-object v0, p0, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension$5;->this$0:Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    # setter for: Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->needDispatchContentResumeEvent:Ljava/lang/Boolean;
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;->access$702(Ltv/freewheel/hybrid/extension/pausead/PauseAdExtension;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 158
    :cond_0
    return-void
.end method
