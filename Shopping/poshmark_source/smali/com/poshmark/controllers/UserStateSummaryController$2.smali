.class Lcom/poshmark/controllers/UserStateSummaryController$2;
.super Landroid/os/Handler;
.source "UserStateSummaryController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/controllers/UserStateSummaryController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/UserStateSummaryController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/UserStateSummaryController;)V
    .locals 0

    .prologue
    .line 151
    iput-object p1, p0, Lcom/poshmark/controllers/UserStateSummaryController$2;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 154
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 160
    :goto_0
    return-void

    .line 156
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController$2;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    # invokes: Lcom/poshmark/controllers/UserStateSummaryController;->fireRecurringRefreshMessage()V
    invoke-static {v0}, Lcom/poshmark/controllers/UserStateSummaryController;->access$100(Lcom/poshmark/controllers/UserStateSummaryController;)V

    .line 157
    iget-object v0, p0, Lcom/poshmark/controllers/UserStateSummaryController$2;->this$0:Lcom/poshmark/controllers/UserStateSummaryController;

    invoke-virtual {v0}, Lcom/poshmark/controllers/UserStateSummaryController;->refreshModels()V

    goto :goto_0

    .line 154
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
