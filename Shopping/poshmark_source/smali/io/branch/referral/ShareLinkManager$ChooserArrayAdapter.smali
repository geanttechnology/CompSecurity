.class Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;
.super Landroid/widget/BaseAdapter;
.source "ShareLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/ShareLinkManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChooserArrayAdapter"
.end annotation


# instance fields
.field public selectedPos:I

.field final synthetic this$0:Lio/branch/referral/ShareLinkManager;


# direct methods
.method private constructor <init>(Lio/branch/referral/ShareLinkManager;)V
    .locals 1

    .prologue
    .line 271
    iput-object p1, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 272
    const/4 v0, -0x1

    iput v0, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->selectedPos:I

    return-void
.end method

.method synthetic constructor <init>(Lio/branch/referral/ShareLinkManager;Lio/branch/referral/ShareLinkManager$1;)V
    .locals 0
    .param p1, "x0"    # Lio/branch/referral/ShareLinkManager;
    .param p2, "x1"    # Lio/branch/referral/ShareLinkManager$1;

    .prologue
    .line 271
    invoke-direct {p0, p1}, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;-><init>(Lio/branch/referral/ShareLinkManager;)V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;
    invoke-static {v0}, Lio/branch/referral/ShareLinkManager;->access$300(Lio/branch/referral/ShareLinkManager;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 281
    iget-object v0, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;
    invoke-static {v0}, Lio/branch/referral/ShareLinkManager;->access$300(Lio/branch/referral/ShareLinkManager;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 286
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    .line 292
    if-nez p2, :cond_0

    .line 293
    new-instance v0, Lio/branch/referral/ShareLinkManager$ShareItemView;

    iget-object v4, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v5, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v5, v5, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-direct {v0, v4, v5}, Lio/branch/referral/ShareLinkManager$ShareItemView;-><init>(Lio/branch/referral/ShareLinkManager;Landroid/content/Context;)V

    .line 297
    .local v0, "itemView":Lio/branch/referral/ShareLinkManager$ShareItemView;
    :goto_0
    iget-object v4, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    # getter for: Lio/branch/referral/ShareLinkManager;->appList_:Ljava/util/List;
    invoke-static {v4}, Lio/branch/referral/ShareLinkManager;->access$300(Lio/branch/referral/ShareLinkManager;)Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 298
    .local v1, "resolveInfo":Landroid/content/pm/ResolveInfo;
    iget v4, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->selectedPos:I

    if-ne p1, v4, :cond_1

    const/4 v2, 0x1

    .line 299
    .local v2, "setSelected":Z
    :goto_1
    iget-object v4, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v4, v4, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/content/pm/ResolveInfo;->loadLabel(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->this$0:Lio/branch/referral/ShareLinkManager;

    iget-object v5, v5, Lio/branch/referral/ShareLinkManager;->context_:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/content/pm/ResolveInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v0, v4, v5, v2}, Lio/branch/referral/ShareLinkManager$ShareItemView;->setLabel(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Z)V

    .line 300
    invoke-virtual {v0, v1}, Lio/branch/referral/ShareLinkManager$ShareItemView;->setTag(Ljava/lang/Object;)V

    .line 301
    invoke-virtual {v0, v3}, Lio/branch/referral/ShareLinkManager$ShareItemView;->setClickable(Z)V

    .line 302
    return-object v0

    .end local v0    # "itemView":Lio/branch/referral/ShareLinkManager$ShareItemView;
    .end local v1    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    .end local v2    # "setSelected":Z
    :cond_0
    move-object v0, p2

    .line 295
    check-cast v0, Lio/branch/referral/ShareLinkManager$ShareItemView;

    .restart local v0    # "itemView":Lio/branch/referral/ShareLinkManager$ShareItemView;
    goto :goto_0

    .restart local v1    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    :cond_1
    move v2, v3

    .line 298
    goto :goto_1
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 307
    iget v0, p0, Lio/branch/referral/ShareLinkManager$ChooserArrayAdapter;->selectedPos:I

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
