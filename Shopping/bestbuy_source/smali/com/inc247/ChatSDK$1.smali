.class Lcom/inc247/ChatSDK$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->startChat(Lorg/json/JSONObject;Landroid/app/Activity;Lorg/json/JSONObject;Z)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$1;->this$0:Lcom/inc247/ChatSDK;

    .line 341
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/inc247/ChatSDK$1;)Lcom/inc247/ChatSDK;
    .locals 1

    .prologue
    .line 341
    iget-object v0, p0, Lcom/inc247/ChatSDK$1;->this$0:Lcom/inc247/ChatSDK;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 344
    iget-object v0, p0, Lcom/inc247/ChatSDK$1;->this$0:Lcom/inc247/ChatSDK;

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->maximizeChat()V

    .line 346
    iget-object v0, p0, Lcom/inc247/ChatSDK$1;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->maximizeButton:Lcom/inc247/ChatSDKMaximizeButton;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$2(Lcom/inc247/ChatSDK;)Lcom/inc247/ChatSDKMaximizeButton;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/inc247/ChatSDKMaximizeButton;->setClickable(Z)V

    .line 347
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/inc247/ChatSDK$1$1;

    invoke-direct {v1, p0}, Lcom/inc247/ChatSDK$1$1;-><init>(Lcom/inc247/ChatSDK$1;)V

    .line 354
    const-wide/16 v2, 0x1f4

    .line 347
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 356
    return-void
.end method
