.class Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    .line 363
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 369
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$6(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/views/LImageButton;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/views/LImageButton;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 370
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$6(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/views/LImageButton;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/aio/downloader/views/LImageButton;->setVisibility(I)V

    .line 371
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$7(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 372
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$8(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 373
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->rl_fun_gongneng:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$9(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 374
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->appbanner:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$5(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 383
    :goto_0
    return-void

    .line 377
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_detail_back:Lcom/aio/downloader/views/LImageButton;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$6(Lcom/aio/downloader/activity/FunImagePagerActivity;)Lcom/aio/downloader/views/LImageButton;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setVisibility(I)V

    .line 378
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$7(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 379
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->tv_detail_jingdu:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$8(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 380
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->rl_fun_gongneng:Landroid/widget/RelativeLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$9(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 381
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter$1;->this$1:Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;->access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$MyPageAdapter;)Lcom/aio/downloader/activity/FunImagePagerActivity;

    move-result-object v0

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->appbanner:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$5(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method
