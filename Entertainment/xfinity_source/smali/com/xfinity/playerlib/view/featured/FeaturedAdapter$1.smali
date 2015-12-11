.class Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;
.super Ljava/lang/Object;
.source "FeaturedAdapter.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

.field final synthetic val$holder:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

.field final synthetic val$leavePlaceHolderOn:Z

.field final synthetic val$placeholderTitleIsPresent:Z


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;ZZLcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    iput-boolean p2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$leavePlaceHolderOn:Z

    iput-boolean p3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$placeholderTitleIsPresent:Z

    iput-object p4, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 126
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$leavePlaceHolderOn:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$placeholderTitleIsPresent:Z

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 129
    :cond_0
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 4
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 133
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    # getter for: Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->access$000(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 134
    .local v1, "it":Ljava/util/Iterator;, "Ljava/util/Iterator<+Lcom/xfinity/playerlib/model/EditorialProgram;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 135
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/EditorialProgram;

    .line 136
    .local v2, "program":Lcom/xfinity/playerlib/model/EditorialProgram;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getImageKey()Ljava/lang/String;

    move-result-object v0

    .line 137
    .local v0, "imageKey":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 138
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 139
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->notifyDataSetChanged()V

    .line 143
    .end local v0    # "imageKey":Ljava/lang/String;
    .end local v2    # "program":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_1
    return-void
.end method
