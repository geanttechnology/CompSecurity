.class Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;
.super Landroid/os/Handler;
.source "ViewItDialogHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 131
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 146
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->isStillNoObjectFoundDialogShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mErrorDialog:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$200(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)Landroid/widget/LinearLayout;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 155
    :goto_0
    return-void

    .line 133
    :pswitch_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$000(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->finish()V

    goto :goto_0

    .line 137
    :pswitch_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showPauseDialog()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$100(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    goto :goto_0

    .line 140
    :pswitch_2
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$000(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)Lcom/amazon/mShop/search/viewit/ViewItActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->stopScanning()V

    goto :goto_0

    .line 151
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->dimissErrorWindow()V
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->access$300(Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;)V

    goto :goto_0

    .line 131
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
