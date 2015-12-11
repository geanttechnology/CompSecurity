.class Lcom/poshmark/ui/fragments/FeedMotherFragment$2;
.super Ljava/lang/Object;
.source "FeedMotherFragment.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FeedMotherFragment;->initialiseTabHost()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 6
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 196
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$000(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/widget/TabHost;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v1

    .line 197
    .local v1, "pos":I
    packed-switch v1, :pswitch_data_0

    .line 215
    :goto_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$300(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    .line 218
    .local v0, "currentPos":I
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I
    invoke-static {v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$100(Lcom/poshmark/ui/fragments/FeedMotherFragment;)I

    move-result v2

    if-eq v1, v2, :cond_0

    .line 219
    if-nez v1, :cond_2

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z
    invoke-static {v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$400(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 220
    const-string v2, "mlk"

    invoke-static {v2}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/lang/String;)V

    .line 221
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # setter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z
    invoke-static {v2, v5}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$402(Lcom/poshmark/ui/fragments/FeedMotherFragment;Z)Z

    .line 227
    :cond_0
    :goto_1
    if-eq v0, v1, :cond_1

    .line 228
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # getter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;
    invoke-static {v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$300(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/support/v4/view/ViewPager;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    .line 229
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # setter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I
    invoke-static {v2, v1}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$102(Lcom/poshmark/ui/fragments/FeedMotherFragment;I)I

    .line 231
    :cond_1
    return-void

    .line 199
    .end local v0    # "currentPos":I
    :pswitch_0
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v5}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 200
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 201
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    goto :goto_0

    .line 204
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 205
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v5}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 206
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    goto :goto_0

    .line 209
    :pswitch_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 210
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 211
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    iget-object v3, v3, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    # invokes: Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    invoke-static {v2, v3, v5}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V

    goto/16 :goto_0

    .line 223
    .restart local v0    # "currentPos":I
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedMotherFragment;

    # setter for: Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z
    invoke-static {v2, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->access$402(Lcom/poshmark/ui/fragments/FeedMotherFragment;Z)Z

    goto :goto_1

    .line 197
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
