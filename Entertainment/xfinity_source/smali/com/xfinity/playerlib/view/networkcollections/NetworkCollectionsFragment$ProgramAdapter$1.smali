.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;
.super Ljava/lang/Object;
.source "NetworkCollectionsFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;->bindItem(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;

.field final synthetic val$holder:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

.field final synthetic val$placeHolderTitleIsPresent:Z


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;ZLcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;

    .prologue
    .line 480
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;->this$1:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter;

    iput-boolean p2, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;->val$placeHolderTitleIsPresent:Z

    iput-object p3, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

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
    .line 483
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;->val$placeHolderTitleIsPresent:Z

    if-eqz v0, :cond_0

    .line 484
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramAdapter$1;->val$holder:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$ProgramViewHolder;->placeholderTitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 486
    :cond_0
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 490
    return-void
.end method
