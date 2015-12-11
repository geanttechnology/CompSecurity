.class Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;
.super Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;
.source "AmazonChooserActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonChooserActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FoldableActivityListAdapter"
.end annotation


# instance fields
.field private mCurrentList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/share/SharableAppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mFoldPosition:I

.field private mFullList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/share/SharableAppInfo;",
            ">;"
        }
    .end annotation
.end field

.field private mIsFolded:Z

.field final synthetic this$0:Lcom/amazon/mShop/AmazonChooserActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/util/List;Landroid/content/Intent;Ljava/util/List;ILcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 1
    .param p3, "targetIntent"    # Landroid/content/Intent;
    .param p5, "foldPosition"    # I
    .param p6, "dialog"    # Lcom/amazon/mShop/AmazonAlertDialog;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Landroid/content/pm/ResolveInfo;",
            ">;",
            "Landroid/content/Intent;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/share/SharableAppInfo;",
            ">;I",
            "Lcom/amazon/mShop/AmazonAlertDialog;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "resolveList":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    .local p4, "fullList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/share/SharableAppInfo;>;"
    const/4 v0, 0x0

    .line 379
    iput-object p1, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    .line 380
    invoke-direct {p0, p1, p2, p3, p6}, Lcom/amazon/mShop/AmazonChooserActivity$ActivityListAdapter;-><init>(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/util/List;Landroid/content/Intent;Lcom/amazon/mShop/AmazonAlertDialog;)V

    .line 373
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    .line 374
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFullList:Ljava/util/List;

    .line 381
    iput-object p4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFullList:Ljava/util/List;

    .line 382
    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    .line 383
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mIsFolded:Z

    .line 384
    iput p5, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFoldPosition:I

    .line 386
    if-lez p5, :cond_0

    invoke-interface {p4}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, p5, :cond_0

    .line 387
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->foldAppList()V

    .line 392
    :goto_0
    return-void

    .line 390
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    goto :goto_0
.end method

.method private expandAppList()V
    .locals 2

    .prologue
    .line 463
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mIsFolded:Z

    if-eqz v0, :cond_0

    .line 464
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 465
    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFullList:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    .line 467
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mIsFolded:Z

    .line 468
    return-void
.end method

.method private foldAppList()V
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 471
    iget v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFoldPosition:I

    if-nez v0, :cond_0

    .line 486
    :goto_0
    return-void

    .line 476
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    if-eqz v0, :cond_1

    .line 477
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 479
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFullList:Ljava/util/List;

    const/4 v4, 0x0

    iget v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mFoldPosition:I

    invoke-interface {v3, v4, v5}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    .line 480
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonChooserActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sharing_see_all:I

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 481
    .local v1, "seeAll":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    new-instance v0, Lcom/amazon/mShop/share/SharableAppInfo;

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultRefTag()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getDefaultPriority()I

    move-result v5

    move-object v3, v2

    move-object v6, v2

    invoke-direct/range {v0 .. v6}, Lcom/amazon/mShop/share/SharableAppInfo;-><init>(Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;ILandroid/content/pm/ResolveInfo;)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 485
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mIsFolded:Z

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    if-nez v0, :cond_0

    .line 397
    const/4 v0, 0x0

    .line 399
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 404
    move-object v7, p2

    .line 406
    .local v7, "itemView":Landroid/view/View;
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/share/SharableAppInfo;

    .line 408
    .local v6, "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    invoke-virtual {v6}, Lcom/amazon/mShop/share/SharableAppInfo;->getLabel()Ljava/lang/CharSequence;

    move-result-object v2

    .line 410
    .local v2, "label":Ljava/lang/CharSequence;
    invoke-virtual {v6}, Lcom/amazon/mShop/share/SharableAppInfo;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 411
    .local v3, "icon":Landroid/graphics/drawable/Drawable;
    invoke-virtual {v6}, Lcom/amazon/mShop/share/SharableAppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v4

    .line 412
    .local v4, "packageName":Ljava/lang/String;
    invoke-virtual {v6}, Lcom/amazon/mShop/share/SharableAppInfo;->getResolveInfo()Landroid/content/pm/ResolveInfo;

    move-result-object v5

    .local v5, "resolveInfo":Landroid/content/pm/ResolveInfo;
    move-object v0, p0

    move-object v1, p2

    .line 414
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->populateItemView(Landroid/view/View;Ljava/lang/CharSequence;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Landroid/content/pm/ResolveInfo;)Landroid/view/View;

    move-result-object v7

    .line 416
    .end local v2    # "label":Ljava/lang/CharSequence;
    .end local v3    # "icon":Landroid/graphics/drawable/Drawable;
    .end local v4    # "packageName":Ljava/lang/String;
    .end local v5    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    .end local v6    # "appInfo":Lcom/amazon/mShop/share/SharableAppInfo;
    :cond_0
    return-object v7
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 7
    .param p2, "itemView"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "viewId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 423
    .local p1, "parentView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-boolean v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mIsFolded:Z

    if-eqz v4, :cond_1

    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ne p3, v4, :cond_1

    .line 424
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->expandAppList()V

    .line 425
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->notifyDataSetChanged()V

    .line 460
    :cond_0
    :goto_0
    return-void

    .line 429
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    if-eqz v4, :cond_0

    .line 430
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 431
    const/4 v3, 0x0

    .line 432
    .local v3, "shared":Z
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/share/SharableAppInfo;

    .line 433
    .local v2, "selectedApp":Lcom/amazon/mShop/share/SharableAppInfo;
    invoke-virtual {v2}, Lcom/amazon/mShop/share/SharableAppInfo;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 434
    .local v0, "packageName":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    invoke-static {v4}, Lcom/amazon/mShop/share/SharableAppInfoManager;->isCnMshopPackage(Landroid/content/Context;)Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatTimelinePackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {}, Lcom/amazon/mShop/share/SocialAppConfig;->getWechatPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 439
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    invoke-static {v4, v2}, Lcom/amazon/mShop/share/SharableAppInfoManager;->replaceRefMarker(Landroid/content/Intent;Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 440
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    invoke-static {v4, v5, v0}, Lcom/amazon/mShop/share/WechatSDKManager;->sendRequest(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)Z

    move-result v3

    .line 449
    :cond_3
    :goto_1
    if-eqz v3, :cond_4

    .line 451
    invoke-static {v2}, Lcom/amazon/mShop/share/SharableAppInfoManager;->logClickRefMarker(Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 452
    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->this$0:Lcom/amazon/mShop/AmazonChooserActivity;

    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mCurrentList:Ljava/util/List;

    invoke-interface {v4, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/share/SharableAppInfo;

    invoke-virtual {v4}, Lcom/amazon/mShop/share/SharableAppInfo;->getResolveInfo()Landroid/content/pm/ResolveInfo;

    move-result-object v4

    iget-object v4, v4, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v4, v4, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    const/4 v6, -0x1

    # invokes: Lcom/amazon/mShop/AmazonChooserActivity;->setSeletedResult(Ljava/lang/String;I)V
    invoke-static {v5, v4, v6}, Lcom/amazon/mShop/AmazonChooserActivity;->access$100(Lcom/amazon/mShop/AmazonChooserActivity;Ljava/lang/String;I)V

    .line 457
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v4}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    goto :goto_0

    .line 442
    :cond_5
    invoke-virtual {v2}, Lcom/amazon/mShop/share/SharableAppInfo;->getResolveInfo()Landroid/content/pm/ResolveInfo;

    move-result-object v1

    .line 443
    .local v1, "resolveInfo":Landroid/content/pm/ResolveInfo;
    if-eqz v1, :cond_3

    .line 444
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    invoke-static {v4, v2}, Lcom/amazon/mShop/share/SharableAppInfoManager;->replaceRefMarker(Landroid/content/Intent;Lcom/amazon/mShop/share/SharableAppInfo;)V

    .line 445
    iget-object v4, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mActivity:Lcom/amazon/mShop/AmazonChooserActivity;

    iget-object v5, p0, Lcom/amazon/mShop/AmazonChooserActivity$FoldableActivityListAdapter;->mTargetIntent:Landroid/content/Intent;

    # invokes: Lcom/amazon/mShop/AmazonChooserActivity;->startResolvedActivity(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V
    invoke-static {v4, v1, v5}, Lcom/amazon/mShop/AmazonChooserActivity;->access$000(Lcom/amazon/mShop/AmazonChooserActivity;Landroid/content/pm/ResolveInfo;Landroid/content/Intent;)V

    .line 446
    const/4 v3, 0x1

    goto :goto_1
.end method
