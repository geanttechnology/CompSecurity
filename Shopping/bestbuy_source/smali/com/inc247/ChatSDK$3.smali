.class Lcom/inc247/ChatSDK$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->maximizeChat()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$3;->this$0:Lcom/inc247/ChatSDK;

    .line 691
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 695
    iget-object v0, p0, Lcom/inc247/ChatSDK$3;->this$0:Lcom/inc247/ChatSDK;

    # getter for: Lcom/inc247/ChatSDK;->badgeLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/inc247/ChatSDK;->access$4(Lcom/inc247/ChatSDK;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 697
    return-void
.end method
