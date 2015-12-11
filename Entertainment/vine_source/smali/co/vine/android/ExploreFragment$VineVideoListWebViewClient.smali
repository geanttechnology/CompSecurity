.class Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "ExploreFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ExploreFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "VineVideoListWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ExploreFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ExploreFragment;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 287
    iget-object v0, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmpty:Landroid/view/View;
    invoke-static {v0}, Lco/vine/android/ExploreFragment;->access$100(Lco/vine/android/ExploreFragment;)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 288
    invoke-virtual {p1, v2, v2}, Landroid/webkit/WebView;->scrollTo(II)V

    .line 289
    return-void
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    const/16 v5, 0x8

    const/4 v4, 0x0

    .line 257
    const-string v1, "ExploreFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "WebViewClient errorCode="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 260
    invoke-virtual {p1, v5}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 264
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mProgressContainer:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$000(Lco/vine/android/ExploreFragment;)Landroid/widget/RelativeLayout;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 265
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mProgressContainer:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$000(Lco/vine/android/ExploreFragment;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 267
    :cond_0
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmpty:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$100(Lco/vine/android/ExploreFragment;)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 268
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmpty:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$100(Lco/vine/android/ExploreFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 270
    :cond_1
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mSadface:Landroid/widget/ImageView;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$200(Lco/vine/android/ExploreFragment;)Landroid/widget/ImageView;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 271
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mSadfaceContainer:Landroid/view/View;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$300(Lco/vine/android/ExploreFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 273
    :cond_2
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmptyText:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$400(Lco/vine/android/ExploreFragment;)Landroid/widget/TextView;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 274
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmptyText:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$400(Lco/vine/android/ExploreFragment;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 278
    :cond_3
    const/4 v1, -0x2

    if-ne p2, v1, :cond_4

    .line 279
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    const v2, 0x7f0e00d2

    invoke-virtual {v1, v2}, Lco/vine/android/ExploreFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 283
    .local v0, "message":Ljava/lang/String;
    :goto_0
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    # getter for: Lco/vine/android/ExploreFragment;->mEmptyText:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/ExploreFragment;->access$400(Lco/vine/android/ExploreFragment;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 284
    return-void

    .line 281
    .end local v0    # "message":Ljava/lang/String;
    :cond_4
    iget-object v1, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    const v2, 0x7f0e00d1

    invoke-virtual {v1, v2}, Lco/vine/android/ExploreFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "message":Ljava/lang/String;
    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 236
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 237
    .local v2, "parsedUri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v3

    const-string v4, "vine"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 238
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 239
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 241
    invoke-virtual {v2}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 242
    .local v0, "host":Ljava/lang/String;
    const-string v3, "channels"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 243
    iget-object v3, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    invoke-virtual {v3}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-class v4, Lco/vine/android/ExploreChannelsActivity;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 247
    :goto_0
    iget-object v3, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    invoke-virtual {v3, v1}, Lco/vine/android/ExploreFragment;->startActivity(Landroid/content/Intent;)V

    .line 248
    const/4 v3, 0x1

    .line 250
    .end local v0    # "host":Ljava/lang/String;
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_1
    return v3

    .line 245
    .restart local v0    # "host":Ljava/lang/String;
    .restart local v1    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v3, p0, Lco/vine/android/ExploreFragment$VineVideoListWebViewClient;->this$0:Lco/vine/android/ExploreFragment;

    invoke-virtual {v3}, Lco/vine/android/ExploreFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    const-class v4, Lco/vine/android/ExploreVideoListActivity;

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    goto :goto_0

    .line 250
    .end local v0    # "host":Ljava/lang/String;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method
