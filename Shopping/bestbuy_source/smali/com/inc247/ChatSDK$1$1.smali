.class Lcom/inc247/ChatSDK$1$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK$1;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic this$1:Lcom/inc247/ChatSDK$1;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK$1;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$1$1;->this$1:Lcom/inc247/ChatSDK$1;

    .line 347
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 352
    iget-object v0, p0, Lcom/inc247/ChatSDK$1$1;->this$1:Lcom/inc247/ChatSDK$1;

    # getter for: Lcom/inc247/ChatSDK$1;->this$0:Lcom/inc247/ChatSDK;
    invoke-static {v0}, Lcom/inc247/ChatSDK$1;->access$0(Lcom/inc247/ChatSDK$1;)Lcom/inc247/ChatSDK;

    move-result-object v0

    # getter for: Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$2(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKMaximizeButton;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setClickable(Z)V

    .line 353
    return-void
.end method
