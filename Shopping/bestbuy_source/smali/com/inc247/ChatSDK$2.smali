.class Lcom/inc247/ChatSDK$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->addChat(Landroid/app/Activity;)V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$2;->this$0:Lcom/inc247/ChatSDK;

    .line 585
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 588
    iget-object v0, p0, Lcom/inc247/ChatSDK$2;->this$0:Lcom/inc247/ChatSDK;

    # invokes: Lcom/inc247/ChatSDK;->showMaximizeButton()V
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$3(Lcom/inc247/ChatSDK;)V

    .line 589
    return-void
.end method
